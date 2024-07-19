package buppan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CommandBuy implements Command{
	
	public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		HttpSession session = request.getSession(true);
		Cart cart = (Cart)session.getAttribute("cart");
		//ここに決済などの処理を追加
		cart.getList().clear();
		
		return "/view/Cyumon_Kanryou.jsp";//まだ作ってない
	}

}
