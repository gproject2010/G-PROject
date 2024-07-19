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
 * Servlet implementation class ShopDataMaker
 */
public class ShopDataMaker extends HttpServlet {
	
	int PageSt;
	int PageFin;
	boolean DSubmit;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShopDataMaker() {
        super();
        PageSt = 0;
    	PageFin = 20;
    	DSubmit = false;
        
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
		
		if(DSubmit == false){
		String Shopid = request.getParameter("shopid");
		String Itemcategorry = request.getParameter("itemcategorry");
		String Syougou = request.getParameter("syougou");
		String Representname = request.getParameter("representname");
		String Chargename = request.getParameter("chargename");
		String Pref = request.getParameter("pref");
		String Syouhin = request.getParameter("syouhin");
		String Toiawase = request.getParameter("toiawase");
		String Surpporttel = request.getParameter("surpporttel");
		
		String MoveFlg = request.getParameter("moveflg");
		
		if(Shopid == null){
			Shopid = "*";
		}
		if(Itemcategorry == "指定なし" || Itemcategorry == "" ||Itemcategorry == null){
			Itemcategorry = "*";
		}
		if(Syougou == null){
			Syougou = "*";
		}
		if(Representname == null){
			Representname = "*";
		}
		if(Chargename == null){
			Chargename = "*";
		}
		if(Pref == "指定なし" || Pref == "" || Pref == null){
			Pref = "*";
		}
		if(Syouhin == null){
			Syouhin = "*";
		}
		if(Toiawase == null){
			Toiawase = "*";
		}
		if(Surpporttel == null){
			Surpporttel = "*";
		}
		
		
		if(MoveFlg == null){
			PageSt = 0;
			PageFin = 20;
		}
		else if(MoveFlg.equals("forward")){
			PageSt = PageSt + 20;
			PageFin = PageFin + 20;
		}
		else if(MoveFlg.equals("back")){
			PageSt = PageSt - 20;
			PageFin = PageFin - 20;
			
			if(PageSt < 0){
			PageSt = 0;
			}
		}
		
		
		
		
		ShopDAO sdao = new ShopDAO();
		
		ArrayList<ShopData> S_HitList = sdao.ShopSarch( Shopid, Itemcategorry, Syougou, Representname, Chargename, Pref, Syouhin, Toiawase, Surpporttel, PageSt, PageFin );
		
		int S_ResultCount = ( S_HitList == null ? 0 : S_HitList.size() );
		
		session.setAttribute("s_hitlist", S_HitList );
		session.setAttribute("pagest", PageSt );
		session.setAttribute("pagefin", PageFin );
		session.setAttribute("s_resultcount", S_ResultCount );
		
		
		DSubmit = true;
		}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/passed/buppancorner/ShopSerchResult.jsp");
		rd.forward(request, response);
	}

}
