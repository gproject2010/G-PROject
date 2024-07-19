package buppan;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CommandRemoveAll implements Command{

	public String execute(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
		
		HttpSession session = request.getSession(true);
		Cart cart = (Cart)session.getAttribute("cart");
		
		cart.getList().clear();
		
		return "G-Pro_Shop_Top.jsp";
	}
}
