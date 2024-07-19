package gpro_ron;

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

import k_jyouhou.R_jyouhou_TO;
import times.Date_Maker;

/**
 * Servlet implementation class GRon_SyousaiMaker
 */
public class GRon_SyousaiMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_SyousaiMaker() {
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
		
		boolean KakikomiKahi = false;//書き込みの条件を満たしているか
		boolean TouhyouKahi = false;//書き込み・投票を受け付けているか
			
		boolean NotEmpty_Lv1 = false;
		boolean NotEmpty_Lv2 = false;
		boolean NotEmpty_Lv3 = false;
		
		session.setAttribute("errcode", "GRon-007");
		String NextPage = "/passed/Error_Gamen.jsp";
		String Keijiban_Code = "Empty";
		String Input_Id = request.getRemoteUser();//認証情報からIDを取得
		Keijiban_Code = request.getParameter("taisyoucode");
		//System.out.println("K-C=" +Keijiban_Code);
		Calendar Now = new GregorianCalendar();
		if(Keijiban_Code == null){
			Keijiban_Code = "Empty";
		}
		if((!(Keijiban_Code.equals("Empty"))) && Keijiban_Code != null){
		GRon_Data_TO KakikomiJudge = new GRon_Data_TO();//書き込み・投票の可否データを格納
		GRon_Data_DAO ronDAO = new GRon_Data_DAO();
		GRon_Data_TO KeijiData = ronDAO.GRon_SyousaiLoad(Keijiban_Code);//討論データをロード
		if(KeijiData == null){
			session.setAttribute("errcode", "GRon-107");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}else{
		
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");//書き込みの可否判定用にプレイヤーのステータスをロード
		try{	
		
		ArrayList<GRon_Data_TO> GronData = ronDAO.GRon_Kakikomi_Load(Keijiban_Code, Input_Id);//書き込みの内容を検索(仕分け前)
		ArrayList<GRon_Data_TO> GronData_Lv1 = new ArrayList<GRon_Data_TO>();//ベースの書き込み
		ArrayList<GRon_Data_TO> GronData_Lv2 = new ArrayList<GRon_Data_TO>();//返信の書き込み
		ArrayList<GRon_Data_TO> GronData_Lv3 = new ArrayList<GRon_Data_TO>();//返信の返信
		
		for(GRon_Data_TO GronData_Bf : GronData){
			if(GronData_Bf.getHenshin_Lv() == 1){//ベースの書き込みなら
				GronData_Lv1.add(GronData_Bf);
			}else if(GronData_Bf.getHenshin_Lv() == 2){//返信なら
				GronData_Lv2.add(GronData_Bf);
			}else if(GronData_Bf.getHenshin_Lv() == 3){//返信の返信なら
				GronData_Lv3.add(GronData_Bf);
			}
		}
		
		session.setAttribute("tourondata_lv1", GronData_Lv1);
		session.setAttribute("tourondata_lv2", GronData_Lv2);
		session.setAttribute("tourondata_lv3", GronData_Lv3);
		
		
			
			if(GronData_Lv1 != null){
				NotEmpty_Lv1 = true;
			}
			if(GronData_Lv2 != null){
				NotEmpty_Lv2 = true;
			}
			if(GronData_Lv3 != null){
				NotEmpty_Lv3 = true;
			}
		
		if(KeijiData.getJyoukenSyubetsu().equals("G-PROjectランキング上位者")){//書き込み条件の種類が「G-PROの上位ランカー」で1
			
		if(KeijiData.getRankJyouken().equals("アクションスコア")){//条件とするパラメータが「アクションスコア」で2
		if(KeijiData.getSc_Syubetsu().equals("累計")){	//時期条件が「累計」の場合3
		if(KeijiData.getRank_Min() >= KaiinData.getActionScore_Ruikei_Rank()){//設定値以上なら
			KakikomiKahi = true;//書き込み可能と判断
		}else if(KeijiData.getSc_Syubetsu().equals("年間")){//時期条件が「年間」の場合
			if(KeijiData.getRank_Min() >= KaiinData.getActionScore_Nenkan_Rank()){
				KakikomiKahi = true;
			}
		}else if(KeijiData.getSc_Syubetsu().equals("先月")){//時期条件が「先月」の場合
			if(KeijiData.getRank_Min() >= KaiinData.getActionScore_Sengetsu_Rank()){
				KakikomiKahi = true;
			}	
		}else if(KeijiData.getSc_Syubetsu().equals("今月")){//時期条件が「今月(暫定)」の場合
			if(KeijiData.getRank_Min() >= KaiinData.getActionScore_Kongetsu_Rank()){
				KakikomiKahi = true;
			}
		}
		}//-1
		
		}else if(KeijiData.getRankJyouken().equals("レポートスコア")){//条件とするパラメータが「レポートスコア」で2
			
		    if(KeijiData.getSc_Syubetsu().equals("累計")){//時期条件が「累計」の場合3
				if(KeijiData.getRank_Min() >= KaiinData.getReportScore_Ruikei_Rank()){
					KakikomiKahi = true;
			}else if(KeijiData.getSc_Syubetsu().equals("年間")){//時期条件が「年間」の場合
				if(KeijiData.getRank_Min() >= KaiinData.getReportScore_Nenkan_Rank()){
					KakikomiKahi = true;
				}
			}else if(KeijiData.getSc_Syubetsu().equals("先月")){//時期条件が「先月」の場合
				if(KeijiData.getRank_Min() >= KaiinData.getReportScore_Sengetsu_Rank()){
					KakikomiKahi = true;
				}
			}else if(KeijiData.getSc_Syubetsu().equals("今月")){//時期条件が「今月(暫定)」の場合
				if(KeijiData.getRank_Min() >= KaiinData.getReportScore_Kongetsu_Rank()){
					KakikomiKahi = true;
				}
			}
		    }//-1
				
				}else if(KeijiData.getRankJyouken().equals("レポートスコア・アクションスコア合計")){//条件とするパラメータが「経験値(レポートスコア+アクションスコア)」で2
			
		    if(KeijiData.getSc_Syubetsu().equals("累計")){//時期条件が「累計」の場合3
				if(KeijiData.getRank_Min() >= (KaiinData.getActionScore_Ruikei_Rank() + KaiinData.getReportScore_Ruikei_Rank()) / 2){
					KakikomiKahi = true;
			}else if(KeijiData.getSc_Syubetsu().equals("年間")){//時期条件が「年間」の場合
				if(KeijiData.getRank_Min() >= (KaiinData.getActionScore_Nenkan_Rank() + KaiinData.getReportScore_Nenkan_Rank()) / 2){
					KakikomiKahi = true;
				}
			}else if(KeijiData.getSc_Syubetsu().equals("先月")){//時期条件が「先月」の場合
				if(KeijiData.getRank_Min() >= (KaiinData.getActionScore_Sengetsu_Rank() + KaiinData.getReportScore_Sengetsu_Rank()) / 2){
					KakikomiKahi = true;
				}
			}else if(KeijiData.getSc_Syubetsu().equals("今月")){//時期条件が「今月(暫定)」の場合
				if(KeijiData.getRank_Min() >= (KaiinData.getActionScore_Kongetsu_Rank() + KaiinData.getReportScore_Kongetsu_Rank()) / 2){
					KakikomiKahi = true;
				}
			}
		    }//-1
				}//-1
		    
		}else if(KeijiData.getJyoukenSyubetsu().equals("アクションスコア")){//書き込み条件の種類が「アクションスコア」で1
			if(KeijiData.getSc_Syubetsu().equals("累計")){//時期条件が「累計」の場合2
				if(KeijiData.getSc_Min() <= KaiinData.getActionScore_Ruikei()){
					KakikomiKahi = true;
				}
			}else if(KeijiData.getSc_Syubetsu().equals("年間")){//時期条件が「年間」の場合
				if(KeijiData.getSc_Min() <= KaiinData.getActionScore_Nenkan()){
					KakikomiKahi = true;
				}
			}else if(KeijiData.getSc_Syubetsu().equals("先月")){//時期条件が「先月」の場合
				if(KeijiData.getSc_Min() <= KaiinData.getActionScore_Sengetsu()){
					KakikomiKahi = true;
				}
			}else if(KeijiData.getSc_Syubetsu().equals("今月")){//時期条件が「今月(暫定)」の場合
				//if(KeijiData.getSc_Min() <= KaiinData.getActionScore_Sengetsu()){
					KakikomiKahi = true;
					
				//}
			}//-1
			
        }else if(KeijiData.getJyoukenSyubetsu().equals("レポートスコア")){//書き込み条件の種類が「レポートスコア」で1
	         if(KeijiData.getSc_Syubetsu().equals("累計")){//時期条件が「累計」の場合2
		          if(KeijiData.getSc_Min() <= KaiinData.getreportScore_Ruikei()){
			          KakikomiKahi = true;
		     }
	    }else if(KeijiData.getSc_Syubetsu().equals("年間")){//時期条件が「年間」の場合
		     if(KeijiData.getSc_Min() <= KaiinData.getreportScore_Nenkan()){
			      KakikomiKahi = true;
		     }
	    }else if(KeijiData.getSc_Syubetsu().equals("先月")){//時期条件が「先月」の場合
		     //if(KeijiData.getSc_Min() <= KaiinData.getreportScore_Sengetsu()){
			      KakikomiKahi = true;
		     }
	    }else if(KeijiData.getSc_Syubetsu().equals("今月")){//時期条件が「今月(暫定)」の場合
		     if(KeijiData.getSc_Min() <= KaiinData.getreportScore_Sengetsu()){
			      KakikomiKahi = true;
		     }
	    
		}else if(KeijiData.getJyoukenSyubetsu().equals("プレイヤーレベル")){//書き込み条件の種類が「プレイヤーレベル」の場合1
			if(KeijiData.getPlayerLv_Min() <= KaiinData.getplayer_Level() && KaiinData.getplayer_Level() <= KeijiData.getPlayerLv_Max()){
				KakikomiKahi = true;
			}
		}else if(KeijiData.getJyoukenSyubetsu().equals("年齢")){//書き込み条件の種類が「プレイヤーの年齢」の場合1
			int age = 0;
			age = Now.get(Calendar.YEAR) - Date_Changer.toCalendar(KaiinData.getSeinenGappi()).get(Calendar.YEAR);
			if(KeijiData.getPlayerLv_Min() <= age && age <= KeijiData.getPlayerLv_Max()){
				KakikomiKahi = true;
			}
		}else if(KeijiData.getJyoukenSyubetsu().equals("性別")){//書き込み条件の種類が「性別」の場合1
			if(KeijiData.getSex().equals(KaiinData.getSex())){
				KakikomiKahi = true;
			}
		}else if(KeijiData.getJyoukenSyubetsu().equals("フリー(条件なし)")){//書き込み条件の種類が設定されていない場合1
			KakikomiKahi = true;
		}else{
			//System.out.println("abort!");
		}
		
		int diff = 0;//締切日時との日数差
		Calendar ShimekiriNichiji_C = Date_Changer.toCalendar(KeijiData.getShimekiriNichiji());
			diff = Date_Maker.nowGetter().compareTo(ShimekiriNichiji_C);
			if(diff < 0){//現在日時が締切日時を過ぎていない(受付中)の場合
				TouhyouKahi = true;//投票可能な掲示板として登録
			}else{//現在日時が締切日時を過ぎている(受付終了)の場合
				KakikomiKahi = false;//受付を締め切った掲示板として登録
				TouhyouKahi = false;
			}
			
			KakikomiJudge = new GRon_Data_TO(KakikomiKahi, TouhyouKahi, NotEmpty_Lv1, NotEmpty_Lv2, NotEmpty_Lv3);
			session.setAttribute("kakikomikahi", KakikomiJudge);
		
		
		session.setAttribute("keijidata", KeijiData);
		NextPage = "/passed/G-PRO_Ron/Touron_Page.jsp";
		
		/*}else{
			NextPage = "/error1.jsp";//まだ作ってない
		}*/
		}catch(Exception ex){
			session.setAttribute("errcode", "GRon-007");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			ex.printStackTrace();
		}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}
		
		}
		
	}
}
