package gpro_ron;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GRon_Kaisetsu_Update
 */
public class GRon_Kaisetsu_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Kaisetsu_Update() {
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
		//System.out.println("HIT!");
		session.setAttribute("errcode", "GRon-004");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		GRon_Data_TO TourokuData = (GRon_Data_TO)session.getAttribute("kouhodata");
		try{
			if(TourokuData != null && TourokuData.getKaisetsusya_ID().equals(request.getRemoteUser())){
		GRon_Data_DAO dao = new GRon_Data_DAO();
		boolean TourokuError = dao.Kouho_Update(TourokuData);
		
		if(TourokuError != true){
			session.setAttribute("syori", "掲示板の新規開設");
		NextPage = "/passed/G-PRO_Ron/Update_Kanryou.jsp";
		}else{
			session.setAttribute("errcode", "GRon-304");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "GRon-404");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}
}
