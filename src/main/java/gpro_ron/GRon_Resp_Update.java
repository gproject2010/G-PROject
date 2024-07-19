package gpro_ron;
import inputUtility.Date_Changer;
import inputUtility.HttpUtility;

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
 * Servlet implementation class GRon_Resp_Update
 */
public class GRon_Resp_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
      //protected int Daccess = 0; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Resp_Update() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//書き込みの登録・編集データの作成
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		//System.out.println(Daccess);
		//if(Daccess % 2 == 0){
			
		String Login_ID = request.getRemoteUser();
		
		ServletContext sc = getServletContext();
		session.setAttribute("errcode", "GRon-006");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean Abort = false;
		
		GRon_Data_TO Resp_Taisyou = (GRon_Data_TO)session.getAttribute("resp_taisyou");//返信の対象となる書き込みのデータ
		GRon_Data_TO KeijiData = (GRon_Data_TO)session.getAttribute("keijidata");//掲示板の基本情報
		R_jyouhou_TO Kijyutsusya_Data = (R_jyouhou_TO)session.getAttribute("seiseki");//書き込みを行うプレイヤーの成績データ
		
		GRon_Data_TO Origin_No_S = (GRon_Data_TO)session.getAttribute("origin_no");//登録・編集を要求している書き込みの整理番号
		
		boolean Koushin_Flg = false;//登録か編集かの判別用フラグ(true=編集、false=登録)
		String NewKakikomi = request.getParameter("honbun");//登録する(編集後の)書き込み本文
		String Command = "Empty";
		if(request.getParameter("command").equals("touroku")){//登録・編集or削除
			Command = Origin_No_S.getCommand();
		}else if(request.getParameter("command").equals("delete")){
			Command = "delete";
		}else{
			Abort = true;
		}
		//System.out.println("Command="+Command);
		if(!(Command.equals("Empty"))){
		String Henshinwaku_S = request.getParameter("henshinwaku");
		//Henshinwaku_S = HttpUtility.escapeHTML(Henshinwaku_S);
		int Henshinwaku = Integer.parseInt(Henshinwaku_S);
		
		if(NewKakikomi != null && Command != null){
			try{
		String Keijiban_Code = KeijiData.getKeijiban_Code();
		int Henshin_Lv = Resp_Taisyou.getHenshin_Lv() + 1;
		int Kakikomi_No = Resp_Taisyou.getSaikoubi() + 1;
		int Origin_Youso = Resp_Taisyou.getKakikomi_No();
		String Kijyutsusya_Name = Kijyutsusya_Data.getlogin_name();
		String Kijyutsusya_ID = Kijyutsusya_Data.getk_Id();
		int Kijyutsusya_Lv = Kijyutsusya_Data.getplayer_Level();
		Calendar KakikomiNichiji_C = Calendar.getInstance();
		String KakikomiNichiji = Date_Changer.CalToString(KakikomiNichiji_C);
		String Kakikomi_Honbun = NewKakikomi; //HttpUtility.escapeHTML(NewKakikomi);
		Kakikomi_Honbun = Kakikomi_Honbun.replaceAll("\n", "<br>");
		String NGWord = HttpUtility.NG_Word_Check(Kakikomi_Honbun);
		int Shijisyasu = 0;
		int Fushijisyasu = 0;
		int Henshinsu = 0;
		int Kakikomi_Kaisu = 0;
		int Touhyou_Kaisu = 0;
		int KakikomiJyougen = Henshinwaku;
		int TouhyouJyougen = 1;//原則プレイヤー1人につき一票
		//System.out.println("IDKakunin="+Login_ID.equals(Kijyutsusya_ID));
		if(Login_ID.equals(Kijyutsusya_ID)){//ログインしたIDと登録・更新を要求しているIDが同じであることを確認
		if(Resp_Taisyou.getKijyutsusya_ID().equals(Kijyutsusya_Data.getk_Id()) && (!(Command.equals("insert")))){//記述者のIDと更新を要求したプレイヤーのIDが一致した場合は更新モードで処理
			Koushin_Flg = true;
			Henshin_Lv = Resp_Taisyou.getHenshin_Lv();
			Kakikomi_No = Resp_Taisyou.getKakikomi_No();
			Shijisyasu = Resp_Taisyou.getShijisyasu();
			Fushijisyasu = Resp_Taisyou.getFushijisyasu();
			Henshinsu = Resp_Taisyou.getHenshinsu();
		}
		GRon_Data_TO TourokuData = new GRon_Data_TO(Keijiban_Code, Henshin_Lv, Kakikomi_No, Origin_Youso, Kijyutsusya_Name, Kijyutsusya_ID, Kijyutsusya_Lv, KakikomiNichiji, Kakikomi_Honbun, Shijisyasu, Fushijisyasu, Henshinsu, Kakikomi_Kaisu, Touhyou_Kaisu, KakikomiJyougen, TouhyouJyougen);
		
		GRon_Data_DAO dao = new GRon_Data_DAO();
		boolean TourokuError = dao.Resp_Update(TourokuData, Command, Koushin_Flg);
		
		if(TourokuError != true && NGWord == null && Abort == false){
			session.setAttribute("syori", "書き込みの登録・編集");
		NextPage = "/passed/G-PRO_Ron/Update_Kanryou.jsp";
		}else if(NGWord != null){
			session.setAttribute("errcode", "GRon-006");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		
		}else{
			session.setAttribute("errcode", "GRon-206");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		}else{//87行目でIDが一致しなかった場合
			session.setAttribute("errcode", "GRon-506");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "GRon-006");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		//System.out.println("np="+NextPage);
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}else{
			//System.out.println("nosuccess");
		}
	}
	}
}
