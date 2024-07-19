package voteandExpect;

//import inputUtility.ChartMaker;
import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;
import times.Date_Maker;
//import java.io.OutputStream;
//import org.jfree.chart.ChartUtilities;
//import org.jfree.chart.JFreeChart;

/**
 * Servlet implementation class VoAndExp_RespPageMaker
 */
public class VoAndExp_RespPageMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoAndExp_RespPageMaker() {
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
		//OutputStream out = response.getOutputStream();
		session.setAttribute("errcode", "VoteExp-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
		String Taisyou_Code = request.getParameter("taisyoucode");
		String KaitouKahi = request.getParameter("kaitoukahi");
		
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		
		VoAndExp_TO TaisyouData = new VoAndExp_TO();
		VoAndExp_DAO exdao = new VoAndExp_DAO();
		TaisyouData = exdao.Anc_SyousaiSerch(Taisyou_Code);
		if(TaisyouData == null){
			session.setAttribute("errcode", "VoteExp-101");
			NextPage = "/passed/Error_Gamen.jsp";
		}else{
		
		int Sentakusyasu_A = 0;
		int Sentakusyasu_B = 0;
		int Sentakusyasu_C = 0;
		int Sentakusyasu_D = 0;
		int Sentakusyasu_Total = 0;
		
		int Yosousyasu_A = 0;
		int Yosousyasu_B = 0;
		int Yosousyasu_C = 0;
		int Yosousyasu_D = 0;
		int Yosousyasu_Total = 0;
		
		String Your_Vote = "未回答";
		String Your_Exp = "未投票";
		String MaxVote = "A";
		String MaxExp = "A";
		
				/*
		if(TaisyouData.getSentakusyaList_A() == null || TaisyouData.getSentakusyaList_A().equals("")){
			Sentakusyasu_A = 0;
		}else{
			if(TaisyouData.getSentakusyaList_A().substring(TaisyouData.getSentakusyaList_A().length() - 5, TaisyouData.getSentakusyaList_A().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
				TaisyouData.setSentakusyaList_A(TaisyouData.getSentakusyaList_A().substring(0, TaisyouData.getSentakusyaList_A().length() - 5));
			}
			Sentakusyasu_A = TaisyouData.getSentakusyaList_A().split("plus;").length;
		}
		
			if(TaisyouData.getSentakusyaList_B() == null || TaisyouData.getSentakusyaList_B().equals("")){
				Sentakusyasu_B = 0;
			}else{
				if(TaisyouData.getSentakusyaList_B().substring(TaisyouData.getSentakusyaList_B().length() - 5, TaisyouData.getSentakusyaList_B().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					TaisyouData.setSentakusyaList_B(TaisyouData.getSentakusyaList_B().substring(0, TaisyouData.getSentakusyaList_B().length() - 5));
				}
			Sentakusyasu_B = TaisyouData.getSentakusyaList_B().split("plus;").length;
			}
			
			if(TaisyouData.getSentakusyaList_C() == null || TaisyouData.getSentakusyaList_C().equals("")){
				Sentakusyasu_C = 0;
			}else{
				if(TaisyouData.getSentakusyaList_C().substring(TaisyouData.getSentakusyaList_C().length() - 5, TaisyouData.getSentakusyaList_C().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					TaisyouData.setSentakusyaList_C(TaisyouData.getSentakusyaList_C().substring(0, TaisyouData.getSentakusyaList_C().length() - 5));
				}
			Sentakusyasu_C = TaisyouData.getSentakusyaList_C().split("plus;").length;
			}
			
			if(TaisyouData.getSentakusyaList_D() == null || TaisyouData.getSentakusyaList_D().equals("")){
				Sentakusyasu_D = 0;
			}else{
				if(TaisyouData.getSentakusyaList_D().substring(TaisyouData.getSentakusyaList_D().length() - 5, TaisyouData.getSentakusyaList_D().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					TaisyouData.setSentakusyaList_D(TaisyouData.getSentakusyaList_D().substring(0, TaisyouData.getSentakusyaList_D().length() - 5));
				}
			Sentakusyasu_D = TaisyouData.getSentakusyaList_D().split("plus;").length;
			}
			*/
		
		
		ArrayList<VoAndExp_TO> Vote_Log = exdao.Vo_LogLoad(TaisyouData.getAnc_Code());
		for(int i=0; i < Vote_Log.size(); i++){
			if(Vote_Log.get(i).getAnswer() != null){
			if(Vote_Log.get(i).getAnswer().equals("A")){
				Sentakusyasu_A++;
			}else if(Vote_Log.get(i).getAnswer().equals("B")){
				Sentakusyasu_B++;
			}else if(Vote_Log.get(i).getAnswer().equals("C")){
				Sentakusyasu_C++;
			}else if(Vote_Log.get(i).getAnswer().equals("D")){
				Sentakusyasu_D++;
			}
			
			if(Vote_Log.get(i).getAnswer().equals(KaiinData.getk_Id())){
				Your_Vote = Vote_Log.get(i).getAnswer();
			}
			}
		}
		
			Sentakusyasu_Total = Sentakusyasu_A + Sentakusyasu_B + Sentakusyasu_C + Sentakusyasu_D;
			
			if(Sentakusyasu_A < Sentakusyasu_B){
				MaxVote = "B";
			}
			if(Sentakusyasu_B < Sentakusyasu_C){
				MaxVote = "C";
			}
			if(Sentakusyasu_C < Sentakusyasu_D){
				MaxVote = "D";
			}
			
			/*
			if(TaisyouData.getSentakusyaList_A() != null && (!(TaisyouData.getSentakusyaList_A().equals(""))) && TaisyouData.getSentakusyaList_A().indexOf(KaiinData.getk_Id()) != -1 ){
				Your_Vote = "A";
			}else if(TaisyouData.getSentakusyaList_B() != null && (!(TaisyouData.getSentakusyaList_B().equals(""))) && TaisyouData.getSentakusyaList_B().indexOf(KaiinData.getk_Id()) != -1 ){
				Your_Vote = "B";
			}else if(TaisyouData.getSentakusyaList_C() != null && (!(TaisyouData.getSentakusyaList_C().equals(""))) && TaisyouData.getSentakusyaList_C().indexOf(KaiinData.getk_Id()) != -1 ){
				Your_Vote = "C";
			}else if(TaisyouData.getSentakusyaList_D() != null && (!(TaisyouData.getSentakusyaList_D().equals(""))) && TaisyouData.getSentakusyaList_D().indexOf(KaiinData.getk_Id()) != -1 ){
				Your_Vote = "D";
			}else{
				Your_Vote = "未回答";
			}
			
			if(TaisyouData.getYosousyaList_A() == null || TaisyouData.getYosousyaList_A().equals("")){
				Yosousyasu_A = 0;
			}else{
				if(TaisyouData.getYosousyaList_A().substring(TaisyouData.getYosousyaList_A().length() - 5, TaisyouData.getYosousyaList_A().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					TaisyouData.setYosousyaList_A(TaisyouData.getYosousyaList_A().substring(0, TaisyouData.getYosousyaList_A().length() - 5));
				}
			Yosousyasu_A = TaisyouData.getYosousyaList_A().split("plus;").length;
			}
			if(TaisyouData.getYosousyaList_B() == null || TaisyouData.getYosousyaList_B().equals("")){
				Yosousyasu_B = 0;
			}else{
				if(TaisyouData.getYosousyaList_B().substring(TaisyouData.getYosousyaList_B().length() - 5, TaisyouData.getYosousyaList_B().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					TaisyouData.setYosousyaList_B(TaisyouData.getYosousyaList_B().substring(0, TaisyouData.getYosousyaList_B().length() - 5));
				}
			Yosousyasu_B = TaisyouData.getYosousyaList_B().split("plus;").length;
			}
			if(TaisyouData.getYosousyaList_C() == null || TaisyouData.getYosousyaList_C().equals("")){
				Yosousyasu_C = 0;
			}else{
				if(TaisyouData.getYosousyaList_C().substring(TaisyouData.getYosousyaList_C().length() - 5, TaisyouData.getYosousyaList_C().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					TaisyouData.setYosousyaList_C(TaisyouData.getYosousyaList_C().substring(0, TaisyouData.getYosousyaList_C().length() - 5));
				}
			Yosousyasu_C = TaisyouData.getYosousyaList_C().split("plus;").length;
			}
			if(TaisyouData.getYosousyaList_D() == null || TaisyouData.getYosousyaList_D().equals("")){
				Yosousyasu_D = 0;
			}else{
				if(TaisyouData.getYosousyaList_D().substring(TaisyouData.getYosousyaList_D().length() - 5, TaisyouData.getYosousyaList_D().length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					TaisyouData.setYosousyaList_D(TaisyouData.getYosousyaList_D().substring(0, TaisyouData.getYosousyaList_D().length() - 5));
				}
			Yosousyasu_D = TaisyouData.getYosousyaList_D().split("plus;").length;
			}
			*/
			ArrayList<VoAndExp_TO> Expect_Log = exdao.Exp_LogLoad(TaisyouData.getAnc_Code());
			for(int i=0; i < Expect_Log.size(); i++){
				if(Expect_Log.get(i).getAnswer() != null){
				if(Expect_Log.get(i).getAnswer().equals("A")){
					Yosousyasu_A++;
				}else if(Expect_Log.get(i).getAnswer().equals("B")){
					Yosousyasu_B++;
				}else if(Expect_Log.get(i).getAnswer().equals("C")){
					Yosousyasu_C++;
				}else if(Expect_Log.get(i).getAnswer().equals("D")){
					Yosousyasu_D++;
				}
				
				if(Expect_Log.get(i).getAnswer().equals(KaiinData.getk_Id())){
					Your_Exp = Expect_Log.get(i).getAnswer();
				}
				}
			}
			
			Yosousyasu_Total = Yosousyasu_A + Yosousyasu_B + Yosousyasu_C + Yosousyasu_D;
			
			if(Yosousyasu_A < Yosousyasu_B){
				MaxExp = "B";
			}
			if(Yosousyasu_B < Yosousyasu_C){
				MaxExp = "C";
			}
			if(Yosousyasu_C < Yosousyasu_D){
				MaxExp = "D";
			}
			
			if(TaisyouData.getYosousyaList_A() != null && (!(TaisyouData.getYosousyaList_A().equals(""))) && TaisyouData.getYosousyaList_A().indexOf(KaiinData.getk_Id()) != -1){
				Your_Exp = "A";
			}else if(TaisyouData.getYosousyaList_B() != null && (!(TaisyouData.getYosousyaList_B().equals(""))) && TaisyouData.getYosousyaList_B().indexOf(KaiinData.getk_Id()) != -1){
				Your_Exp = "B";
			}else if(TaisyouData.getYosousyaList_C() != null && (!(TaisyouData.getYosousyaList_C().equals(""))) && TaisyouData.getYosousyaList_C().indexOf(KaiinData.getk_Id()) != -1){
				Your_Exp = "C";
			}else if(TaisyouData.getYosousyaList_D() != null && (!(TaisyouData.getYosousyaList_D().equals(""))) && TaisyouData.getYosousyaList_D().indexOf(KaiinData.getk_Id()) != -1){
				Your_Exp = "D";
			}else{
				Your_Exp = "未投票";
			}
			
			int diff = 0;//締切日時との日数差
				diff = Date_Maker.nowGetter().compareTo(Date_Changer.toCalendar(TaisyouData.getExpect_Shimekiri()));//予想締切が現在日時を過ぎていない(受付中)の場合はマイナス、過ぎている場合はプラス
			
			VoAndExp_TO VoteData = new VoAndExp_TO(Sentakusyasu_A, Sentakusyasu_B, Sentakusyasu_C, Sentakusyasu_D, Sentakusyasu_Total, Yosousyasu_A, Yosousyasu_B, Yosousyasu_C, Yosousyasu_D, Yosousyasu_Total, KaitouKahi, Your_Vote, Your_Exp, diff, MaxVote, MaxExp);
			
		session.setAttribute("taisyoudata", TaisyouData);
		session.setAttribute("votedata", VoteData);
		/*
		if(KaitouKahi.equals("now")){
		JFreeChart Exchart = ChartMaker.createChart("結果予想", TaisyouData.getSentakushi_A(), TaisyouData.getSentakushi_B(), TaisyouData.getSentakushi_C(), TaisyouData.getSentakushi_D(), Sentakusyasu_A, Sentakusyasu_B, Sentakusyasu_C, Sentakusyasu_D);
		ChartUtilities.writeChartAsPNG(out, Exchart, 300, 250);
		
		}else if(KaitouKahi.equals("end")){
		JFreeChart Vochart = ChartMaker.createChart("アンケート結果", TaisyouData.getSentakushi_A(), TaisyouData.getSentakushi_B(), TaisyouData.getSentakushi_C(), TaisyouData.getSentakushi_D(), Sentakusyasu_A, Sentakusyasu_B, Sentakusyasu_C, Sentakusyasu_D);
		ChartUtilities.writeChartAsPNG(out, Vochart, 300, 250);
		}*/
			NextPage = "/passed/VoteANDExpect/Vote_Uketsuke.jsp";
		}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "VoteExp-001");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
