package mail;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Toiawase_Touroku
 */
public class Toiawase_Touroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Toiawase_Touroku() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		Calendar Now = new GregorianCalendar();
		
		String NextPage = null;
		boolean failed = false;
		
		Toiawase_Koumoku naiyou = (Toiawase_Koumoku)session.getAttribute("toi");
		
		Toiawase_DAO tdao = new Toiawase_DAO();
		failed = tdao.Toiawase_Kakunou(naiyou, Date_Changer.CalToString(Now));
		
		if(failed == false){
			NextPage = "/free_area/Toiawase_Kanryou.html";
		}else{
			NextPage = "/free_area/Toiawase_Error.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		
	}

}
