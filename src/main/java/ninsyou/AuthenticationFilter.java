package ninsyou;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;

public class AuthenticationFilter implements Filter {

	private String LoginPage;

	public void init(FilterConfig config) throws ServletException {

		LoginPage = config.getInitParameter("loginPage");
		if (LoginPage == null) {
			System.err.println("loginPage is not set.");
		}
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");	
		
		HttpSession session = httpRequest.getSession(false);
		
			if(session!=null && httpRequest.isUserInRole("Root") || httpRequest.isUserInRole("Administrator") || httpRequest.isUserInRole("Manager")
					 || httpRequest.isUserInRole("Master_User") || httpRequest.isUserInRole("Reguler_User") || httpRequest.isUserInRole("General_User")){
				chain.doFilter(httpRequest, httpResponse);
				return;
			}
			
		RequestDispatcher rd = request.getRequestDispatcher(LoginPage);
		rd.forward(request, response);
	}
	public void destroy(){
	}
}
