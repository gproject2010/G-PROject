package voteandExpect;

//import inputUtility.HttpUtility;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Vote_Update
 */
public class Vote_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Vote_Update() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "VoteExp-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		Calendar Now = Calendar.getInstance();
		
		try{
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		VoAndExp_TO TaisyouData = (VoAndExp_TO)session.getAttribute("taisyoudata");
		VoAndExp_TO VoteLogInsData = new VoAndExp_TO();
		VoAndExp_TO ExpLogInsData = new VoAndExp_TO();
		String K_ID = KaiinData.getk_Id();
		String Anc_Code = TaisyouData.getAnc_Code();
		
		
		String VoteSel = request.getParameter("vote");
		String ExpectSel = request.getParameter("expect");
		
		if(ExpectSel.equals("newsel")){
			ExpectSel = VoteSel;
		}
		
		int UpSuccess = 1;
		int VoteLogUpSuccess = 1;
		int ExpLogUpSuccess = 1;
		
		if(VoteSel != null && (!(VoteSel.equals("")))){
		//VoteSel = HttpUtility.escapeHTML(VoteSel);
		}else{
			VoteSel = "empty";
		}
		if(ExpectSel != null && (!(ExpectSel.equals(""))) && (!(ExpectSel.equals("empty")))){
		//ExpectSel = HttpUtility.escapeHTML(ExpectSel);
		}else{
			ExpectSel = "empty";
		}
		
		VoteLogInsData = new VoAndExp_TO(Anc_Code, K_ID, Date_Changer.CalToString(Now), VoteSel);
		ExpLogInsData = new VoAndExp_TO(Anc_Code, K_ID, Date_Changer.CalToString(Now), ExpectSel);
		
		if(K_ID.equals(request.getRemoteUser())){
		VoAndExp_DAO exdao = new VoAndExp_DAO();
		UpSuccess = exdao.Vote_Update(Anc_Code, VoteSel, ExpectSel, K_ID);
		VoteLogUpSuccess = exdao.Vo_LogInsert(VoteLogInsData);
		ExpLogUpSuccess = exdao.Exp_LogInsert(ExpLogInsData);
		}else{
			UpSuccess = 2;
		}
		
		if(UpSuccess == 0 && VoteLogUpSuccess == 0 && ExpLogUpSuccess == 0){
			session.setAttribute("syori", "回答・結果予想");
			session.setAttribute("yourvote", VoteSel);
			session.setAttribute("yourexp", ExpectSel);
			NextPage = "./Vote_Kanryou.jsp";//まだ作ってない
		}else{
			session.setAttribute("errcode", "VoteExp-302");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "VoteExp-002");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
