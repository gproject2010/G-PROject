package location;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LocateData_Maker
 */
public class LocateData_Maker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LocateData_Maker() {
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
		session.setAttribute("errcode", "Event-101");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		LocateData_TO LocateData = new LocateData_TO();
		LocateData_TO LocateSyubetsu = new LocateData_TO();
		LocateData_DAO ldao = new LocateData_DAO();
		
		try{
			String LocateName = request.getParameter("shopname");
			LocateSyubetsu = ldao.LocateSyubetsu_Load(LocateName);
			if(LocateSyubetsu == null){
				session.setAttribute("errcode", "Event-503");
				NextPage = "/free_area/Error_Gamen.jsp";
			}else if(LocateSyubetsu.getLocate_Syubetsu().equals("アミューズメント施設")){
				LocateData = ldao.AmuseData_Load(LocateName);
				session.setAttribute("locatedata", LocateData);
				NextPage = "/free_area/Locate/Amusement_Show.jsp";
			}else if(LocateSyubetsu.getLocate_Syubetsu().equals("ゲーム小売店")){
				LocateData = ldao.ConsumeData_Load(LocateName);
				session.setAttribute("locatedata", LocateData);
				NextPage = "/free_area/Locate/Consume_Show.jsp";
			}else if(LocateSyubetsu.getLocate_Syubetsu().equals("特設会場")){
				LocateData = ldao.TokusetsuData_Load(LocateName);
				session.setAttribute("locatedata", LocateData);
				NextPage = "/free_area/Locate/Tokusetsu_Show.jsp";
			}else{
				session.setAttribute("errcode", "Event-502");
				NextPage = "/free_area/Error_Gamen.jsp";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "Event-501");
			NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}
