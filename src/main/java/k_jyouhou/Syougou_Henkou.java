package k_jyouhou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Syougou_Henkou
 */
public class Syougou_Henkou extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Syougou_Henkou() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		boolean TourokuError = true;
		session.setAttribute("errcode", "Coupon-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		
		R_jyouhou_DAO dao = new R_jyouhou_DAO();
		try{
			R_jyouhou_TO PlayerData = (R_jyouhou_TO) session.getAttribute("seiseki");
			String NewSyougou = request.getParameter("syougou_name");
			
			for(int i=0; i < PlayerData.getSyougouList().length; i++){
				if(PlayerData.getSyougouList()[i].equals(NewSyougou) == true){
					TourokuError = dao.Syougou_Koushin( PlayerData.getk_Id(), NewSyougou);
					break;
				}
			}
			if(TourokuError == false){
			NextPage = "/StatusMaker";
			}else{
				session.setAttribute("errcode", "Coupon-110");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "Coupon-110");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}
