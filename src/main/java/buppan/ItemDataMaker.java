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
 * Servlet implementation class ItemDataMaker
 */
public class ItemDataMaker extends HttpServlet {
	
	int PageSt;
	int PageFin;
	boolean DSubmit;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ItemDataMaker() {
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
		
		boolean wrong = false;
		String NextPage = null;
		
		if(DSubmit == false){
		String ShopId = request.getParameter("shopid2");
		String ItemId = request.getParameter("itemid");
		String ItemCategorry = request.getParameter("itemcategorry2");
		String ItemName = request.getParameter("itemname");
		String PriceMin_S = request.getParameter("pricemin");
		String PriceMax_S = request.getParameter("pricemax");
		
		String MoveFlg = request.getParameter("moveflg");
		
		int PriceMin = 0;
		int PriceMax = 0;
		
		if(ShopId == null){
			ShopId = "*";
		}
		if(ItemId == null){
			ItemId = "*";
		}
		if(ItemCategorry == "指定なし" || ItemCategorry == null || ItemCategorry == ""){
			ItemCategorry = "*";
		}
		if(ItemName == null){
			ItemName = "*";
		}
		try{
			if(PriceMin_S == null || PriceMin_S == ""){
				PriceMin = 0;
			}
			else{
				Integer.parseInt(PriceMin_S);
			}
			
			if(PriceMax_S == null || PriceMax_S == ""){
				PriceMax = 99999999;
			}
			else{
				Integer.parseInt(PriceMax_S);
			}
			
			}catch(NumberFormatException e){
				wrong = true;
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
			
			ItemDAO dao = new ItemDAO();
			
			ArrayList<ItemData> I_HitList = dao.ItemSarch(ShopId, ItemId, ItemCategorry, ItemName, PriceMin, PriceMax, PageSt, PageFin);
			
			int I_ResultCount = (I_HitList == null ? 0 : I_HitList.size());
			
			session.setAttribute("i_hitlist", I_HitList);
			session.setAttribute("i_resultcount", I_ResultCount);
			session.setAttribute("pagest", PageSt );
			session.setAttribute("pagefin", PageFin );
			
			DSubmit = true;
		}
			if(wrong == true){
				NextPage = "/passed/buppancorner/Buppan_Error.jsp";
			}
			else{
				NextPage = "/passed/buppancorner/ItemSerchResult.jsp";
			}
			
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
	}

}
