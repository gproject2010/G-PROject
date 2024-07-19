package buppan;

import java.io.*;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.http.*;

public class CommandRemove implements Command{

	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession(true);
		Cart cart = (Cart)session.getAttribute("cart");
		
		String input = request.getParameter("ItemId");//リクエストから削除する商品の商品IDを取得
		
			ArrayList<ItemData> item = cart.getList();
			for(int i=0;i<item.size();i++){
				if(item.get(i).getItemId().equals(input)){
					cart.removeItem(input);
					break;
				}
			}
			return "G-Pro_Shop_Top.jsp";
	}
}
