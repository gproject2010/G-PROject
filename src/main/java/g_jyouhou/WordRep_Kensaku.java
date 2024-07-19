package g_jyouhou;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rep_upload.Rep_Koumoku;

/**
 * Servlet implementation class WordRep_Load
 */
public class WordRep_Kensaku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordRep_Kensaku() {
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
		HttpSession session = request.getSession(true);
		Calendar Now = new GregorianCalendar();
		String NextPage = "/free_area/Error_Gamen.jsp";
		
		ArrayList<Rep_Koumoku> RepData = new ArrayList<Rep_Koumoku>();
		Rep_Load_DAO dao = new Rep_Load_DAO();
		
		try{
		
		String HyoujiHani = request.getParameter("hyoujihani");
		if(HyoujiHani.equals("1week")){
			Now.add(Calendar.DATE, -7);
		}else if(HyoujiHani.equals("1month")){
			Now.add(Calendar.MONTH, -1);
		}else if(HyoujiHani.equals("3months")){
			Now.add(Calendar.MONTH, -3);
		}else{
			session.setAttribute("errcode", "wordrep-001");
			NextPage = "/free_area/Error_Gamen.jsp";
		}
		
		RepData = dao.WordRep_Kensaku(Date_Changer.toDateString(Now));
		
		session.setAttribute("replist", RepData);
		session.setAttribute("hyoujihani", HyoujiHani);
		
		NextPage = "/free_area/Word_Report/WordRep_Serch_Result.jsp";
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "wordrep-002");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
}

}
