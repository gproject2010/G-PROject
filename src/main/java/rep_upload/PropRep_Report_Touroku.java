package rep_upload;

import inputUtility.CodeMaker;
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

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class PropRep_Report_Touroku
 */
public class PropRep_Report_Touroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PropRep_Report_Touroku() {
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
		session.setAttribute("errcode", "Rep-012");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext sc = getServletContext();
		Calendar Now = new GregorianCalendar();
		
		boolean TourokuError = true;
		
		try{
		
		NewGames_TO gamedata = (NewGames_TO)session.getAttribute("syousai");
		Rep_Koumoku repdata = (Rep_Koumoku)session.getAttribute("newgamerep");
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		
		Rep_List_DAO dao = new Rep_List_DAO();
		
		String Upload_Date = Date_Changer.CalToString(Now);
		String Rep_Code = CodeMaker.Rep_Code_Maker("propresp", Now);
		String GameCode = gamedata.getGameCode();
		String GameTitle = gamedata.getGameTitle();
		String Comment = repdata.getComment();
		String GPRO_ID = KaiinData.getk_Id();
		String PlayerName = KaiinData.getlogin_name();
		String Seinengappi = KaiinData.getSeinenGappi();
		String Sex = KaiinData.getSex();
		String Pref = KaiinData.getPref();
		String Job = KaiinData.getJob();
		
		Rep_List_TO TourokuData = new Rep_List_TO(Upload_Date, Rep_Code, GameCode, GameTitle, Comment, GPRO_ID, PlayerName, Seinengappi, Sex, Pref, Job);
		TourokuError = dao.Rep_Response_Touroku(TourokuData);
		
		if(TourokuError){
			session.setAttribute("errcode", "Rep-211");
			NextPage = "/passed/Error_Gamen.jsp";
			
	}else{
		NextPage = "/passed/Rep_Uketsuke_Kanryou.html";
	}
	
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "Rep-011");
		NextPage = "/passed/Error_Gamen.jsp";
	}
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	
	}
}
