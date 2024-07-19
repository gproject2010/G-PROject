package voteandExpect;

//import inputUtility.HttpUtility;

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

import times.Date_Maker;

/**
 * Servlet implementation class VoteAndExpect_TopMaker
 */
public class VoteAndExpect_TopMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoteAndExpect_TopMaker() {
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
		session.setAttribute("errcode", "VoteExp-003");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		/*String Ancate_Code = request.getParameter("anc_code");
		if(Ancate_Code != null){
		//Ancate_Code = HttpUtility.escapeHTML(Ancate_Code);*/
		try{
		VoAndExp_DAO vdao = new VoAndExp_DAO();
		//ArrayList<VoAndExp_TO> AncList = vdao.Anc_Serch(Ancate_Code);
		ArrayList<VoAndExp_TO> AncList = vdao.Anc_Serch();
		ArrayList<VoAndExp_TO> FreeAncList = vdao.FreeAnc_Serch();
		
		ArrayList<VoAndExp_TO> Now_Info = new ArrayList<VoAndExp_TO>();//回答受付中の通常アンケート
		ArrayList<VoAndExp_TO> End_Info = new ArrayList<VoAndExp_TO>();//回答・結果予想ともに終了した通常アンケート
		ArrayList<VoAndExp_TO> FreeNow_Info = new ArrayList<VoAndExp_TO>();//回答受付中の項目追加型アンケート
		ArrayList<VoAndExp_TO> FreeEnd_Info = new ArrayList<VoAndExp_TO>();//回答・結果予想ともに終了した項目追加型アンケート
		int diff = 0;//締切日時との日数差
		for(VoAndExp_TO Bef : AncList){//通常アンケートの処理
			diff = Date_Maker.nowGetter().compareTo(Date_Changer.toCalendar(Bef.getVote_Shimekiri()));
			if(diff <= 0){//現在日時が回答の締切日時を過ぎていない(受付中)の場合
				Now_Info.add(Bef);
			}else{//現在日時が回答の締切日時を過ぎている(受付終了)の場合
				End_Info.add(Bef);//受付を締め切った掲示板として登録
			}
		}
		
		for(VoAndExp_TO FrBef : FreeAncList){//項目追加型アンケートの処理
			diff = Date_Maker.nowGetter().compareTo(Date_Changer.toCalendar(FrBef.getVote_Shimekiri()));
			if(diff <= 0){//現在日時が回答の締切日時を過ぎていない(受付中)の場合
				FreeNow_Info.add(FrBef);
			}else{//現在日時が回答の締切日時を過ぎている(受付終了)の場合
				FreeEnd_Info.add(FrBef);//受付を締め切った掲示板として登録
			}
		}
		session.setAttribute("nowinfo", Now_Info);
		session.setAttribute("endinfo", End_Info);
		session.setAttribute("freenowinfo", FreeNow_Info);
		session.setAttribute("freeendinfo", FreeEnd_Info);
		
		NextPage = "/passed/VoteANDExpect/VoteAndExpect_Top.jsp";
		//System.out.println("NP="+NextPage);
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "VoteExp-003");
		NextPage = "/passed/Error_Gamen.jsp";
	}
	session.setAttribute("int", 1);
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
		//}
	}
}
