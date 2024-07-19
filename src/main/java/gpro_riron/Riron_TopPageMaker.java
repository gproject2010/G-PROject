package gpro_riron;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Riron_TopPageMaker
 */
public class Riron_TopPageMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Riron_TopPageMaker() {
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
		session.setAttribute("errcode", "GriRon-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		try{
			String User = request.getRemoteUser();
			R_jyouhou_TO kaiindata = (R_jyouhou_TO) session.getAttribute("seiseki");//提出者情報をsessionから抽出
			
			ArrayList<GPRiron_TO> MyData = new ArrayList<GPRiron_TO>();
			ArrayList<GPRiron_TO> OtherData = new ArrayList<GPRiron_TO>();
			
			if(User.equals(kaiindata.getk_Id())){
			GPRiron_DAO dao = new GPRiron_DAO();
			ArrayList<GPRiron_TO> RonbunList = dao.RironGaiyou_Load();
			
			for(GPRiron_TO List : RonbunList){
				if(List.getPlayer_Id().equals(User)){
					MyData.add(List);
				}else{
					OtherData.add(List);
				}
			}
			
			session.setAttribute("mydata", MyData);
			session.setAttribute("otherdata", OtherData);

			NextPage = "/passed/GPRO_Riron/GPRO_Riron_Top.jsp";
			//System.out.println("NP="+NextPage);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "GriRon-001");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}
