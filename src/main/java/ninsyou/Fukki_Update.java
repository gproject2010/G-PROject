package ninsyou;

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

import k_jyouhou.K_jyouhou_DAO;

/**
 * Servlet implementation class Fukki_Update
 */
public class Fukki_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fukki_Update() {
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
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		boolean Update_Error = false;
		Calendar Now = new GregorianCalendar();
		String NextPage = "/passed/Error_Gamen.jsp";
		
		String Kaiin_ID = request.getRemoteUser();
		String RoleName = null;
		try{
		if(request.isUserInRole("Master_User_taikai")){
			RoleName = "Master_User";
		}else if(request.isUserInRole("Reguler_User_taikai")){
			RoleName = "Reguler_User";
		}else if(request.isUserInRole("General_User_taikai")){
				RoleName = "General_User";
		}
		K_jyouhou_DAO dao = new K_jyouhou_DAO();
		Update_Error = dao.Taikai_Uketsuke(Kaiin_ID, RoleName, Date_Changer.CalToString(Now));
		
		if(Update_Error == false){
			NextPage = "/passed/Fukki_Kanryou.jsp";
		}else{
			session.setAttribute("errcode", "Ninsyou-206");
			NextPage = "/passed/Error_Gamen.jsp";
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-006");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
