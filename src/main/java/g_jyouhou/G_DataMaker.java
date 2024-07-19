package g_jyouhou;

//import inputUtility.HttpUtility;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class G_DataMaker
 */
public class G_DataMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public G_DataMaker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Get");
		//doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//ゲーム情報の検索条件の組み立て・DAOからの検索結果の受け取り処理
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "GData-003");
		String NextPage = "/passed/Error_Gamen.jsp";
		//System.out.println("Post");
		ArrayList<G_jyouhou_TO> Hitlist = new ArrayList<G_jyouhou_TO>();
		try{
		String GameTitle = request.getParameter("gametitle");//ゲームのタイトル
		String Maker_Name = request.getParameter("hatsubaimaker");//そのゲームの発売元
		String Main_Genre = request.getParameter("Genre");//ゲームのジャンル
		String Platform = request.getParameter("Platform");//プラットフォームのゲーム機
		String Hatsubai_Nen_Start = request.getParameter("hatsubainen_start");//発売年の下限
		String Hatsubai_Tsuki_Start = request.getParameter("hatsubaitsuki_start");//発売月の下限
		String Hatsubaibi_Start = request.getParameter("hatsubaibi_start");//発売日の下限
		String Hatsubai_Nen_Limit = request.getParameter("hatsubainen_limit");//発売年の上限
		String Hatsubai_Tsuki_Limit = request.getParameter("hatsubaitsuki_limit");//発売月の上限
		String Hatsubaibi_Limit = request.getParameter("hatsubaibi_limit");//発売日の上限
		String GS_Syubetsu = request.getParameter("GS_syubetsu");//検索条件とするG-Scoreの種別
		String G_Score_Min_st = request.getParameter("G_Score_Min");//G-Scoreの下限
		String G_Score_Max_st = request.getParameter("G_Score_Max");//G-Scoreの上限
		String Lisence = request.getParameter("Lisence");//著作物の転載許可状況
		
		String MoveFlg = request.getParameter("moveflg");//ランキングの表示部分の移動方向
		G_jyouhou_TO Jyouken = null;
		
		if (GameTitle == null || GameTitle.equals("")){
			GameTitle = "*";//フォームに何も入力されていない場合はワイルドカードを付加
		}else if(GameTitle.length() > 40){
			GameTitle = GameTitle.substring(0, 40);
		}
		//GameTitle = HttpUtility.escapeHTML(GameTitle);//特殊文字チェック
		
		if (Maker_Name == null || Maker_Name.equals("")){
			Maker_Name = "*";
		}else if(Maker_Name.length() > 40){
			Maker_Name = Maker_Name.substring(0, 40);
		}
		//Maker_Name = HttpUtility.escapeHTML(Maker_Name);
		
		if (Main_Genre == null || Main_Genre.equals("")){
			Main_Genre = "*";
		}else if(Main_Genre.length() > 30){
			Main_Genre = Main_Genre.substring(0, 30);
		}
		//Main_Genre = HttpUtility.escapeHTML(Main_Genre);
		
		if (Platform == null || Platform.equals("")){
			Platform = "*";
		}else if(Platform.length() > 40){
			Platform = Platform.substring(0, 40);
		}
		//Platform = HttpUtility.escapeHTML(Platform);
		
		if (Hatsubai_Nen_Start == null || Hatsubai_Nen_Start.equals("")){
			Hatsubai_Nen_Start = "0001";//フォームに何も入力されていない場合は最も小さい値を付加
		}
		//Hatsubai_Nen_Start = HttpUtility.escapeHTML(Hatsubai_Nen_Start);
		
		if (Hatsubai_Tsuki_Start == null || Hatsubai_Tsuki_Start.equals("")){
			Hatsubai_Tsuki_Start = "01";
		}
		//Hatsubai_Tsuki_Start = HttpUtility.escapeHTML(Hatsubai_Tsuki_Start);
		
		if(Hatsubaibi_Start == null || Hatsubaibi_Start.equals("")){
			Hatsubaibi_Start = "01";
		}
		//Hatsubaibi_Start = HttpUtility.escapeHTML(Hatsubaibi_Start);
		
		String Hatsubainengappi_Start = Hatsubai_Nen_Start + "-" + Hatsubai_Tsuki_Start + "-" + Hatsubaibi_Start;//発売年月日を一つにつなげてString型に→日付型としてDBに格納
		
		if (Hatsubai_Nen_Limit == null || Hatsubai_Nen_Limit.equals("")){
			Hatsubai_Nen_Limit = "9999";//フォームに何も入力されていない場合は最も大きい値を付加
		}
		//Hatsubai_Nen_Limit = HttpUtility.escapeHTML(Hatsubai_Nen_Limit);
		
		if (Hatsubai_Tsuki_Limit == null || Hatsubai_Tsuki_Limit.equals("")){
			Hatsubai_Tsuki_Limit = "12";
		}
		//Hatsubai_Tsuki_Limit = HttpUtility.escapeHTML(Hatsubai_Tsuki_Limit);
		
		if(Hatsubaibi_Limit == null || Hatsubaibi_Limit.equals("")){
			Hatsubaibi_Limit = "31";
		}
		//Hatsubaibi_Limit = HttpUtility.escapeHTML(Hatsubaibi_Limit);
		
		String Hatsubainengappi_Limit = Hatsubai_Nen_Limit + "-" + Hatsubai_Tsuki_Limit + "-" + Hatsubaibi_Limit;
		
		if(GS_Syubetsu == null || GS_Syubetsu.equals("")){//最初に結果を表示したときはnullが渡される
			GS_Syubetsu = "*";
		}
		//GS_Syubetsu = HttpUtility.escapeHTML(GS_Syubetsu);
		
		if(G_Score_Min_st == null || G_Score_Min_st.equals("")){
			G_Score_Min_st = "0.00";
		}
		//G_Score_Min_st = HttpUtility.escapeHTML(G_Score_Min_st);
		
		if(G_Score_Max_st == null || G_Score_Max_st.equals("")){
			G_Score_Max_st = "999999.99";
		}
		//G_Score_Max_st = HttpUtility.escapeHTML(G_Score_Max_st);
		
		double G_Score_Max = Double.parseDouble(G_Score_Max_st);//フォームに文字列として入力されたG-Scoreを数値に変換
		double G_Score_Min = Double.parseDouble(G_Score_Min_st);
		
		if(Lisence == null || Lisence.equals("")){//「著作物の転載が許可されているゲームのみ検索」にチェックがついている場合は文字列"true"が渡される
			Lisence = "*";
		}
		//Lisence = HttpUtility.escapeHTML(Lisence);
		
		if(MoveFlg == null){//最初に表示された時に表示される順位の範囲
			Jyouken = new G_jyouhou_TO(GameTitle, Maker_Name, Main_Genre, Platform, Hatsubainengappi_Start, Hatsubainengappi_Limit, GS_Syubetsu, G_Score_Min, G_Score_Max, Lisence, 0, 20);
		}
		else if(MoveFlg.equals("forward")){//"forward"が渡されたときは20名分下にずらす
			Jyouken = (G_jyouhou_TO)session.getAttribute("jyouken");
			Jyouken.setPageSt(Jyouken.getPageSt() + 20);
			//Jyouken.setPageFin(Jyouken.getPageFin() + 20);
		}
		else if(MoveFlg.equals("back")){//"back"が渡されたときは20名分上にずらす
			Jyouken = (G_jyouhou_TO)session.getAttribute("jyouken");
			Jyouken.setPageSt(Jyouken.getPageSt() - 20);
			//Jyouken.setPageFin(Jyouken.getPageFin() - 20);
			
			if(Jyouken.getPageSt() < 0){//0未満にはならない
			Jyouken.setPageSt(0);
			}
		}
		
		G_jyouhou_DAO dao = new G_jyouhou_DAO();//ゲームの概要情報の検索処理
		Hitlist = dao.Search(Jyouken);
		
		if(Hitlist == null){
			session.setAttribute("errcode", "GData-103");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}else{
		//int ResultCount = (Hitlist == null ? 0 :Hitlist.size());//ヒットした件数(ゼロの場合はnullの代わりに０が返される)
		
		session.setAttribute("hitresult", Hitlist);
		//session.setAttribute("result_c", ResultCount);
		session.setAttribute("jyouken", Jyouken);
		NextPage = "/passed/G_SeachResult.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GData-003");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
