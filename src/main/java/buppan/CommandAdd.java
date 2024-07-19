package buppan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CommandAdd implements Command{
	
	public String execute(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException{
		
		HttpSession session = request.getSession(true);
		Cart cart = (Cart) session.getAttribute("cart");//現在カートに入っている商品の情報
		
			String ItemId = request.getParameter("ItemId");
			ItemDAO idao = new ItemDAO();
			ItemData Item_S = idao.Sin_ItemSyousai(ItemId);//商品の詳細を再検索（詳細画面以外からも参照できるように）して
			cart.addItem(Item_S);//cartオブジェクトに格納
		
		
		cart.addItem(Item_S);
		return "G-Pro_Shop_Top.jsp";
	}

}
