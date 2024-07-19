package voteandExpect;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;
import times.Date_Maker;

/**
 * Servlet implementation class VoAndExp_FreeRespPageMaker
 */
public class VoAndExp_FreeRespPageMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoAndExp_FreeRespPageMaker() {
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
		ArrayList<VoAndExp_TO> Vote_Log = new ArrayList<VoAndExp_TO>();
		ArrayList<VoAndExp_TO> Expect_Log = new ArrayList<VoAndExp_TO>();
		VoAndExp_DAO exdao = new VoAndExp_DAO();
		TaisyouData = exdao.FreeAnc_SyousaiSerch(Taisyou_Code);
		
		ArrayList<VoAndExp_TO> Votes = new ArrayList<VoAndExp_TO>();
		ArrayList<VoAndExp_TO> Expects = new ArrayList<VoAndExp_TO>();
		VoAndExp_TO Ans_tmp = new VoAndExp_TO();
		
		String MaxExp = "Empty";
		int MaxExpCount = 0;
		
		String Your_Vote = "未回答";
		String Your_Exp = "未投票";
		
		if(TaisyouData == null){
			session.setAttribute("errcode", "VoteExp-101");
			NextPage = "/passed/Error_Gamen.jsp";
		}else{
			Vote_Log = exdao.Vo_LogLoad(Taisyou_Code);
			Expect_Log = exdao.Exp_LogLoad(Taisyou_Code);
			
			for(int i=0; i < Vote_Log.size(); i++){
				for(int j=0; j < Votes.size(); j++){
					if(Vote_Log.get(i).getAnswer().equals(Votes.get(j).getAnswer())){
						Votes.get(j).setAnswer_Count(Votes.get(j).getAnswer_Count() + 1);
						break;
					}
					if(j == Votes.size()){
					Ans_tmp = new VoAndExp_TO(Taisyou_Code, Votes.get(j).getAnswer(), 1);
					Votes.add(Ans_tmp);
					}
				}
			}
			
			for(int i=0; i < Votes.size(); i++){
				if(KaiinData.getk_Id().equals(Votes.get(i).getGPRO_ID())){
					Your_Vote = Votes.get(i).getAnswer();
				}
			}
			
			VoAndExp_FreeRespPageMaker.AnsCount_Sort(Votes);
			
			for(int i=0; i < Expect_Log.size(); i++){
				for(int j=0; j < Expects.size(); j++){
					if(Vote_Log.get(i).getAnswer().equals(Expects.get(j).getAnswer())){
						Expects.get(j).setAnswer_Count(Expects.get(j).getAnswer_Count() + 1);
						break;
					}
					if(j == Expects.size()){
					Ans_tmp = new VoAndExp_TO(Taisyou_Code, Expects.get(j).getAnswer(), 1);
					Expects.add(Ans_tmp);
					}
				}
			}
			
			if(Expects.size() != 0){
				MaxExp = Expects.get(0).getAnswer();
				MaxExpCount = Expects.get(0).getAnswer_Count();
				}
				for(int i=1; i < Expects.size(); i++){
					if(Expects.get(i).getAnswer_Count() > MaxExpCount){
						MaxExp = Expects.get(i).getAnswer();
						MaxExpCount = Expects.get(i).getAnswer_Count();
					}
					if(KaiinData.getk_Id().equals(Expects.get(i).getGPRO_ID())){
						Your_Vote = Expects.get(i).getAnswer();
					}
				}
				if(Your_Vote.equals("empty")){
					Your_Vote = "未投票";
				}
				
				VoAndExp_FreeRespPageMaker.SortCopy(Votes, Expects);
		}
				int diff = 0;//締切日時との日数差
				diff = Date_Maker.nowGetter().compareTo(Date_Changer.toCalendar(TaisyouData.getExpect_Shimekiri()));//予想締切が現在日時を過ぎていない(受付中)の場合はマイナス、過ぎている場合はプラス
			
			session.setAttribute("taisyoudata", TaisyouData);
			session.setAttribute("votedata", Votes);
			session.setAttribute("expectdata", Expects);
			session.setAttribute("maxexp", MaxExp);
			session.setAttribute("maxexpcount", MaxExpCount);
			session.setAttribute("your_vote", Your_Vote);
			session.setAttribute("your_exp", Your_Exp);
			session.setAttribute("kaitoukahi", KaitouKahi);
			session.setAttribute("diff", diff);
			
			NextPage = "/passed/VoteANDExpect/NewVote_Uketsuke.jsp";
		
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "VoteExp-001");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

	private static ArrayList<VoAndExp_TO> AnsCount_Sort(ArrayList<VoAndExp_TO> MyData){
		Collections.sort(MyData, new Comparator<VoAndExp_TO>(){
			public int compare(VoAndExp_TO Data1, VoAndExp_TO Data2){
				if(Data1.getIns_Date() == null || Data2.getIns_Date() == null){
					return 0;
				}
				return Data1.getIns_Date().compareTo(Data2.getIns_Date());
			}
		});
		return MyData;
	}
	
	private static ArrayList<VoAndExp_TO> SortCopy(ArrayList<VoAndExp_TO> BaseData, ArrayList<VoAndExp_TO> SortData){
		for(int i=0; i< BaseData.size(); i++){
			for(int j=i; j < SortData.size(); j++){
				if(BaseData.get(i).getAnswer().equals(SortData.get(j).getAnswer())){
					SortData.subList(j, i);
					break;
				}
			}
		}
		return SortData;
	}
}
