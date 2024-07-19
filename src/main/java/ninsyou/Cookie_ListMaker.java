package ninsyou;

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
 * Servlet implementation class Cookie_ListMaker
 */
public class Cookie_ListMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cookie_ListMaker() {
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
		session.setAttribute("errcode", "TopMake-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		ArrayList<Cookie_TO> Cookie = new ArrayList<Cookie_TO>();
		Cookie_DAO dao = new Cookie_DAO();
		
		try{
			R_jyouhou_TO Seiseki = (R_jyouhou_TO) session.getAttribute("seiseki");
			Cookie = dao.Cookie_TourokuCounter(Seiseki.getk_Id());
			session.setAttribute("cookies", Cookie);
			NextPage = "/passed/Cookie/Cookie_Hakkou.jsp";

	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-006");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
