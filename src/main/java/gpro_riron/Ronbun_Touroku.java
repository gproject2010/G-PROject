package gpro_riron;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Ronbun_Touroku
 */
public class Ronbun_Touroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ronbun_Touroku() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		boolean FileUploadError = true;
		
		session.setAttribute("errcode", "GRiron-009");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		GPRiron_TO NewData = (GPRiron_TO)session.getAttribute("newdata");
		GPRiron_DAO dao = new GPRiron_DAO();
		
		if(NewData.getPlayer_Id().equals(request.getRemoteUser()) && NewData.getPlayer_Id().equals(KaiinData.getk_Id())){
			FileUploadError = dao.Ronbun_Shinkitouroku(NewData, KaiinData);
			if(FileUploadError == false){
				session.setAttribute("syorisyubetsu", "shinki");
			NextPage = "/passed/GPRO_Riron/Ronbun_Touroku_Result.jsp";
			}else{
				NextPage = "/passed/GPRO_Riron/Ronbun_Shinki_Kakunin.jsp";
			}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "Griron-006");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}