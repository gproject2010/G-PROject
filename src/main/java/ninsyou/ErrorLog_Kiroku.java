package ninsyou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ErrorLog_Kiroku
 */
public class ErrorLog_Kiroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorLog_Kiroku() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		boolean TourokuError = true;
		
		String NextPage = null;
		String InputId = "";
		String InputPassword = "";
		String IpAddress = "";
		
		N_jyouhou_DAO dao = new N_jyouhou_DAO();
		try{
			InputId = request.getParameter("j_username");
			InputPassword = request.getParameter("j_password");
			IpAddress = request.getRemoteAddr();
			TourokuError = dao.N_ErrorLog_Upload(InputId, InputPassword, IpAddress);
			
			if(TourokuError == false){
				NextPage = "/free_area/Ninsyou_Error_Gamen.html";
			}else{
				NextPage = "/free_area/Ninsyou_Error_Gamen.html";
			}
		}catch(Exception e){
			e.printStackTrace();
				NextPage = "/free_area/Ninsyou_Error_Gamen.html";
			}
    ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
}
}
