package buppan;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShopSyousaiMaker
 */
public class ShopSyousaiMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopSyousaiMaker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		
		String ShopId = request.getParameter("sid");
		System.out.println("SHOP="+ShopId);
		
		ShopDAO sdao = new ShopDAO();
		ItemDAO idao = new ItemDAO();
		
		ShopData Shop_S = sdao.ShopSyousaiSarch(ShopId);
		session.setAttribute("s_syousai", Shop_S);
		ArrayList<ItemData> Item_S = idao.ItemSyousai(ShopId);
		session.setAttribute("i_syousai", Item_S);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/passed/buppancorner/Shoppage.jsp");
		rd.forward(request, response);
	}

}
