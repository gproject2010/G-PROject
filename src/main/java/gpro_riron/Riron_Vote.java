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
 * Servlet implementation class Riron_Vote
 */
public class Riron_Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Riron_Vote() {
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
		boolean TourokuError = true;
		
		session.setAttribute("errcode", "GRiron-100");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		try{
			R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
			GPRiron_TO RonbunData = (GPRiron_TO)session.getAttribute("ronbundata");
			String Vote = request.getParameter("vote");
			GPRiron_DAO dao = new GPRiron_DAO();
			TourokuError = dao.Vote_Upload(RonbunData.getRonbunCode(), KaiinData.getk_Id(), Vote);
			
			if(TourokuError == false){
				session.setAttribute("errcode", "GRiron-101");
				NextPage = "/passed/Error_Gamen.jsp";
			}else{
				session.setAttribute("syorisyubetsu", "vote");
				NextPage = "/passed/GPRO_Riron/Ronbun_Touroku_Result.jsp";
			}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GRiron-102");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
					}
}
