package gpro_riron;

import inputUtility.CodeMaker;
import inputUtility.Date_Changer;
import inputUtility.HttpUtility;

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

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Comment_Upload
 */
public class Comment_Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Comment_Upload() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "GriRon-020");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean DeleteError = true;
		
		try{
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		GPRiron_TO RonbunData = (GPRiron_TO)session.getAttribute("ronbundata");
		String RespCode = request.getParameter("respcode");
		
		GPRiron_DAO dao = new GPRiron_DAO();
		
		if(KaiinData.getk_Id().equals(request.getRemoteUser())){
			DeleteError = dao.Comment_Delete(RonbunData.getRonbunCode(), RespCode, KaiinData.getk_Id());
		}
		if(DeleteError == true){
			session.setAttribute("errcode", "GriRon-021");
			NextPage = "/passed/Error_Gamen.jsp";
		}else{
			session.setAttribute("syorisyubetsu", "comment_del");
			NextPage = "/passed/GPRO_Riron/Ronbun_Touroku_Result.jsp";
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "GRiron-102");
		NextPage = "/passed/Error_Gamen.jsp";
	}
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "GriRon-020");
		String NextPage = "/passed/Error_Gamen.jsp";
		Calendar Now = new GregorianCalendar();
		boolean TourokuError = true;
		boolean Over = false;
		
		String NGWord = null;
		
		try{
			R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
			GPRiron_TO RonbunData = (GPRiron_TO)session.getAttribute("ronbundata");
			String Comment = request.getParameter("comment");
			GPRiron_DAO dao = new GPRiron_DAO();
			
			NGWord = HttpUtility.NG_Word_Check(Comment);
			if(NGWord != null){
				session.setAttribute("ngword", NGWord);
				NextPage = "/passed/GPRO_Riron/Riron_Etsuran.jsp";
			}else if(Comment.length() > 300 || Comment.length() < 3){
				Over = true;
				session.setAttribute("over", Over);
				NextPage = "/passed/GPRO_Riron/Riron_Etsuran.jsp";
			}else{
				NGWord = "";
			if(KaiinData.getk_Id().equals(request.getRemoteUser())){
				TourokuError = dao.Comment_Upload(RonbunData.getRonbunCode(), CodeMaker.Rep_Code_Maker("rironresp", Now), Date_Changer.toDateString(Now), KaiinData.getk_Id(), KaiinData.getlogin_name(), Comment);
			}
			if(TourokuError == true){
				session.setAttribute("errcode", "GriRon-022");
				NextPage = "/passed/Error_Gamen.jsp";
			}else{
				session.setAttribute("syorisyubetsu", "comment_touroku");
				NextPage = "/passed/GPRO_Riron/Ronbun_Touroku_Result.jsp";
			}
			}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GRiron-102");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}
}
