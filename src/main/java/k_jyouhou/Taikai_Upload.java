package k_jyouhou;

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
 * Servlet implementation class Taikai_Upload
 */
public class Taikai_Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Taikai_Upload() {
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
		session.setAttribute("errcode", "KData-005");
		String NextPage = "/passed/Error_Gamen.jsp";
		Calendar Now = new GregorianCalendar();
		boolean UploadError = false;
		try{
		K_jyouhou_TO Taikaisya = (K_jyouhou_TO)session.getAttribute("ninsyou_jyouhou");
		K_jyouhou_DAO dao = new K_jyouhou_DAO();
		
		String RoleName = null;
		
		if(request.isUserInRole("Master_User")){
			RoleName = "Master_User_taikai";
		}else if(request.isUserInRole("Reguler_User")){
			RoleName = "Reguler_User_taikai";
		}else if(request.isUserInRole("General_User")){
				RoleName = "General_User_taikai";
		}
		
		if(Taikaisya.getk_Id().equals(request.getRemoteUser())){
			UploadError = dao.Taikai_Uketsuke(Taikaisya.getk_Id(), RoleName, Date_Changer.CalToString(Now));
		}else{
		UploadError = true;
		}
		
		if(UploadError == false){
			NextPage = "/passed/Taikai_Uketsuke_Kanryou.jsp";
		}else{
			session.setAttribute("errcode", "KData-005");
			NextPage = "/passed/Error_Gamen.jsp";
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-205");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
