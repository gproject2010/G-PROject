package buppan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.ArrayList;

public class CommandInitCart implements Command{
	
	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		HttpSession session = request.getSession(true);
		Cart cart = (Cart)session.getAttribute("cart");//sessionからカート内の商品情報を取得
		
		if(cart == null){//Cartがnull（Cartオブジェクトが存在しない）なら新しく作成
			cart = new Cart();
			cart.setList(new ArrayList<ItemData>());
		}
		
		session.setAttribute("cart", cart);//再度sessionに格納
		
		return "G-Pro_Shop_Top.jsp";
	}

}
