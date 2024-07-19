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
 * Servlet implementation class TopPageMaker
 */
public class TopPageMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TopPageMaker() {
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
		
		ShopDAO sdao = new ShopDAO();
		ItemDAO idao = new ItemDAO();
		
		ArrayList<ShopData> Shop_R = sdao.NewShops();
		ArrayList<ItemData> Item_R = idao.Osusume();
		ArrayList<ItemData> Item_Rank = idao.Order_Rank();
		
		ArrayList<ItemData> Doujinshi = new ArrayList<ItemData>();
		ArrayList<ItemData> Tankoubon = new ArrayList<ItemData>();
		ArrayList<ItemData> IndiesGame = new ArrayList<ItemData>();
		ArrayList<ItemData> FunBook = new ArrayList<ItemData>();
		ArrayList<ItemData> OriginalSound = new ArrayList<ItemData>();
		
		for(int i=0; i < Item_Rank.size(); i++){
			if(Item_Rank.get(i).getItemCategorry().equals("同人誌")){
				Doujinshi.add(Item_Rank.get(i));
			}else if(Item_Rank.get(i).getItemCategorry().equals("オリジナル単行本")){
				Tankoubon.add(Item_Rank.get(i));
			}else if(Item_Rank.get(i).getItemCategorry().equals("インディーズゲーム")){
				IndiesGame.add(Item_Rank.get(i));
			}else if(Item_Rank.get(i).getItemCategorry().equals("攻略本・ファンブック")){
				FunBook.add(Item_Rank.get(i));
			}else if(Item_Rank.get(i).getItemCategorry().equals("オリジナルサウンド")){
				OriginalSound.add(Item_Rank.get(i));
			}
		}
		
		session.setAttribute("newcommer", Shop_R);
		session.setAttribute("osusume", Item_R);
		session.setAttribute("doujinshi", Doujinshi);
		session.setAttribute("tankoubon", Tankoubon);
		session.setAttribute("indiesgame", IndiesGame);
		session.setAttribute("funbook", FunBook);
		session.setAttribute("originalsound", OriginalSound);
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/passed/buppancorner/G-Pro_Shop_Top.jsp");
		rd.forward(request, response);
	}

}
