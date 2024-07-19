package ninsyou;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Logout
 */
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		String url = request.getParameter("url");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head>");
		out.println("<base>/G-pro_Service/Logout</base>");
		out.println("<title>ログアウト中…</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ログアウト処理中…</h1>");
		out.println("ログアウト処理を行っています。しばらくお待ちください。<br>");
		out.println("ページが切り替わらない場合は<a href='/G-pro_Service/Logout'>ここ</a>をクリックしてください。");
		out.println("</body></html>");
		
		session.invalidate();//セッションをすべて無効化
		
		if(url==null){
		response.sendRedirect("/G-pro_Service/AuthenticationController");
		}else{
			response.sendRedirect(url);
		}
	}

}
