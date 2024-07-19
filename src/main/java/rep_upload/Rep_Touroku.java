package rep_upload;

import g_jyouhou.GS_jyouhou_TO;
import inputUtility.Date_Changer;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class Rep_Touroku
 */
public class Rep_Touroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rep_Touroku() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		String syubetsu = null;
		session.setAttribute("errcode", "Rep-012");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext sc = getServletContext();
		Calendar Now = new GregorianCalendar();
		
		Rep_Koumoku rep_data = null;
		String Rep_Code = null;
		boolean FileUploadError = false;
		boolean RollBackError = true;
		try{
		
			
		GS_jyouhou_TO gamedata = (GS_jyouhou_TO) session.getAttribute("syousai");//ゲームコード、ゲームタイトルをsessionから抽出
		GS_jyouhou_TO inputdata = (GS_jyouhou_TO) session.getAttribute("indata");//新規登録レポートに入力されたゲーム情報をsessionから抽出
		R_jyouhou_TO kaiindata = (R_jyouhou_TO) session.getAttribute("seiseki");//提出者情報をsessionから抽出
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		@SuppressWarnings("unchecked")
		List<FileItem> list = upload.parseRequest(request);
		File file = null;
		
		for(FileItem item : list){
			syubetsu = item.getString();
			
			if(kaiindata.getk_Id().equals(request.getRemoteUser()) && (!(item.isFormField()))){
				//String path = getServletContext().getRealPath("D:/uploadfiles");
				factory.setSizeThreshold(4096);
				upload.setSizeMax(-1);
				upload.setHeaderEncoding("UTF-8");
				
				try{
					
						
							
					String storePath = "/opt/freerep_files/shinsamae/";
					
							String filename = item.getName();
							if((filename != null) && (!filename.equals(""))){								
								filename = new File(filename).getName();//ファイル名のみを取り出し
								file = new File(storePath + Date_Changer.CalToString(Now).replaceAll("/", "-") + "_" + request.getRemoteUser() + "_" + filename);
							item.write(file);
							item.delete();
								}
						FileUploadError = false;
					}catch(FileUploadException e){
						e.printStackTrace();
						FileUploadError = true;
					}catch(Exception e){
						e.printStackTrace();
						FileUploadError = true;
					}
			
			}else if(item.isFormField()){
		
		//syubetsu = request.getParameter("rep");
		
		//System.out.println("Syu="+syubetsu);
		System.out.println(ServletFileUpload.isMultipartContent(request));
		
		//if(!(ServletFileUpload.isMultipartContent(request))){
		if(syubetsu.equals("marubatsu")){//レポート種別が「OX」(ゲーム情報からの登録)の場合に実行
		     rep_data = (Rep_Koumoku)session.getAttribute("hyouka");//レポートの内容をsessionから抽出
		
		String gamecode = gamedata.getGamecode();//ゲームコード
		String gametitle = gamedata.getGametitle();//ゲームタイトル
		
		String k_id = kaiindata.getk_Id();//提出者のID
		String login_name = kaiindata.getlogin_name();//提出者のプレイヤーネーム
		String Seinengappi = kaiindata.getSeinenGappi();
		String Sex = kaiindata.getSex();
		String Job = kaiindata.getJob();
		String Pref = kaiindata.getPref();
		
		double dificultty = rep_data.getdificultty();//難易度の適正度
		double story = rep_data.getstory();//ストーリー・世界観
		double graphic = rep_data.getgraphic();//グラフィック
		double sound = rep_data.getsound();//サウンド
		double volume = rep_data.getvolume();//ボリューム度・ハマり度
		double controll = rep_data.getcontroll();//操作性
		double promotion = rep_data.getpromotion();//プロモーション
		double free_S = rep_data.getfree_S();//自由点
		double total = rep_data.gettotal();//合計(使わない予定)
		
		String jiyuten_koumoku1 = rep_data.getjiyuten_koumoku1();
		String jiyuten_koumoku2 = rep_data.getjiyuten_koumoku2();
		String jiyuten_koumoku3 = rep_data.getjiyuten_koumoku3();
		String jiyuten_koumoku4 = rep_data.getjiyuten_koumoku4();
		String jiyuten_koumoku5 = rep_data.getjiyuten_koumoku5();
		
		double jiyuten_score1 = rep_data.getjiyuten_score1();
		double jiyuten_score2 = rep_data.getjiyuten_score2();
		double jiyuten_score3 = rep_data.getjiyuten_score3();
		double jiyuten_score4 = rep_data.getjiyuten_score4();
		double jiyuten_score5 = rep_data.getjiyuten_score5();
		
		double jiyuten_maxscore1 = rep_data.getjiyuten_maxscore1();
		double jiyuten_maxscore2 = rep_data.getjiyuten_maxscore2();
		double jiyuten_maxscore3 = rep_data.getjiyuten_maxscore3();
		double jiyuten_maxscore4 = rep_data.getjiyuten_maxscore4();
		double jiyuten_maxscore5 = rep_data.getjiyuten_maxscore5();
	
		String outline = rep_data.getoutline();//ゲーム概要
		String goodies = rep_data.getgoodies();//良かった所
		String badies = rep_data.getbadies();//悪かった所
		
		String Konyu_Houhou = rep_data.getKonyu_houhou();//購入方法
		
		String Interview1[] = rep_data.getInterview1();//プレー希望者
		
		String Interview2 = rep_data.getInterview2();//最も心待ちにしていた人
		
		String Interview3[] = rep_data.getInterview3();//見聞きしたことのある情報
		
		String Interview4 = rep_data.getInterview4();//購入を決定づけた情報
		
		String[] Interview5 = rep_data.getInterview5();//購入理由
		
		String Interview6 = rep_data.getInterview6();//シリーズ・続編の購入意欲
		
		
		Rep_List_TO oxdata = new Rep_List_TO(gamecode, gametitle, k_id, login_name, Seinengappi, Sex, Pref,
				dificultty, story, graphic, sound, volume, controll, promotion, free_S, total,
				jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
				jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
				jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
				outline, goodies, badies, Konyu_Houhou, Interview1,
				Interview2, Interview3, Interview4, Interview5, Interview6, Job);//まとめて1つのオブジェクトに格納
		
		if(kaiindata.getk_Id().equals(request.getRemoteUser())){
		Rep_List_DAO oxdao = new Rep_List_DAO();//DAOにレポートデータの登録を依頼
		Rep_Code = oxdao.ox_touroku(oxdata);
		session.removeAttribute("hyouka");
		}else{
			Rep_Code = null;
		}
		
		
		}else if(syubetsu.equals("newox")){//レポート種別が「OX」(メニューからの新規登録)の場合に実行
		     rep_data = (Rep_Koumoku)session.getAttribute("hyouka");
		
		
		String GameTitle = inputdata.getGametitle();//ゲームタイトル
		String MakerName = inputdata.getMakername();//発売元メーカ名
		String HatsubaiNengappi = inputdata.getHatsubainengappi();//発売年月日
		if(HatsubaiNengappi == null || HatsubaiNengappi.equals("") || HatsubaiNengappi.equals("不明")){
			HatsubaiNengappi = "0000-01-01";
		}
		String MainGenre = inputdata.getMaingenre();//メインジャンル
		String PlatForm = inputdata.getPlatform();//プラットフォーム
		
		/*String report_code = コードのつけ方が未定のためコメントアウト
		*/
		String k_id = kaiindata.getk_Id();
		String login_name = kaiindata.getlogin_name();
		String Seinengappi = kaiindata.getSeinenGappi();
		String Sex = kaiindata.getSex();
		String Job = kaiindata.getJob();
		String Pref = kaiindata.getPref();
		
		double dificultty = rep_data.getdificultty();
		double story = rep_data.getstory();
		double graphic = rep_data.getgraphic();
		double sound = rep_data.getsound();
		double volume = rep_data.getvolume();
		double controll = rep_data.getcontroll();
		double promotion = rep_data.getpromotion();
		double free_S = rep_data.getfree_S();
		double total = rep_data.gettotal();
		
		String jiyuten_koumoku1 = rep_data.getjiyuten_koumoku1();
		String jiyuten_koumoku2 = rep_data.getjiyuten_koumoku2();
		String jiyuten_koumoku3 = rep_data.getjiyuten_koumoku3();
		String jiyuten_koumoku4 = rep_data.getjiyuten_koumoku4();
		String jiyuten_koumoku5 = rep_data.getjiyuten_koumoku5();
		
		double jiyuten_score1 = rep_data.getjiyuten_score1();
		double jiyuten_score2 = rep_data.getjiyuten_score2();
		double jiyuten_score3 = rep_data.getjiyuten_score3();
		double jiyuten_score4 = rep_data.getjiyuten_score4();
		double jiyuten_score5 = rep_data.getjiyuten_score5();
		
		double jiyuten_maxscore1 = rep_data.getjiyuten_maxscore1();
		double jiyuten_maxscore2 = rep_data.getjiyuten_maxscore2();
		double jiyuten_maxscore3 = rep_data.getjiyuten_maxscore3();
		double jiyuten_maxscore4 = rep_data.getjiyuten_maxscore4();
		double jiyuten_maxscore5 = rep_data.getjiyuten_maxscore5();
	
		String outline = rep_data.getoutline();
		String goodies = rep_data.getgoodies();
		String badies = rep_data.getbadies();
		
		String Konyu_Houhou = rep_data.getKonyu_houhou();
		
		String[] Interview1 = null;
		Interview1 = rep_data.getInterview1();
		
		String Interview2 = rep_data.getInterview2();
		
		String[] Interview3 = null;
		Interview3 = rep_data.getInterview3();
		
		String Interview4 = rep_data.getInterview4();
		
		String[] Interview5 = rep_data.getInterview5();
		
		String Interview6 = rep_data.getInterview6();
		
		
		Rep_List_TO newoxdata = new Rep_List_TO(GameTitle,k_id, login_name, Seinengappi, Sex, Pref,
				dificultty, story, graphic, sound, volume, controll, promotion, free_S, total,
				jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
				jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
				jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
				outline, goodies, badies, Konyu_Houhou, Interview1,
				Interview2, Interview3, Interview4, Interview5, Interview6,
				 MakerName, HatsubaiNengappi, MainGenre, PlatForm, Job);
		
		if(kaiindata.getk_Id().equals(request.getRemoteUser())){
		Rep_List_DAO newoxdao = new Rep_List_DAO();
		Rep_Code = newoxdao.newox_touroku(newoxdata);
		session.removeAttribute("hyouka");
		}else{
			Rep_Code = null;
		}
		
		}else if(syubetsu.equals("kiji")){//レポート種別が「紹介記事」(ゲーム情報からの登録)の場合に実行
			rep_data = (Rep_Koumoku)session.getAttribute("kijihyouka");
			
			String gamecode = gamedata.getGamecode();
			String gametitle = gamedata.getGametitle();
			
			/*String report_code = コードのつけ方が未定のためコメントアウト
			String upload_date =
			String hyouka_rank = 
			boolean tensaku_flg =
			*/
			String k_id = kaiindata.getk_Id();
			String login_name = kaiindata.getlogin_name();
			String Seinengappi = kaiindata.getSeinenGappi();
			String Sex = kaiindata.getSex();
			String Job = kaiindata.getJob();
			String Pref = kaiindata.getPref();
			
			double dificultty = rep_data.getdificultty();
			double story = rep_data.getstory();
			double graphic = rep_data.getgraphic();
			double sound = rep_data.getsound();
			double volume = rep_data.getvolume();
			double controll = rep_data.getcontroll();
			double promotion = rep_data.getpromotion();
			double free_S = rep_data.getfree_S();
			double total = rep_data.gettotal();
			String outline = rep_data.getoutline();

			String jiyuten_koumoku1 = rep_data.getjiyuten_koumoku1();
			String jiyuten_koumoku2 = rep_data.getjiyuten_koumoku2();
			String jiyuten_koumoku3 = rep_data.getjiyuten_koumoku3();
			String jiyuten_koumoku4 = rep_data.getjiyuten_koumoku4();
			String jiyuten_koumoku5 = rep_data.getjiyuten_koumoku5();
			
			double jiyuten_score1 = rep_data.getjiyuten_score1();
			double jiyuten_score2 = rep_data.getjiyuten_score2();
			double jiyuten_score3 = rep_data.getjiyuten_score3();
			double jiyuten_score4 = rep_data.getjiyuten_score4();
			double jiyuten_score5 = rep_data.getjiyuten_score5();
			
			double jiyuten_maxscore1 = rep_data.getjiyuten_maxscore1();
			double jiyuten_maxscore2 = rep_data.getjiyuten_maxscore2();
			double jiyuten_maxscore3 = rep_data.getjiyuten_maxscore3();
			double jiyuten_maxscore4 = rep_data.getjiyuten_maxscore4();
			double jiyuten_maxscore5 = rep_data.getjiyuten_maxscore5();
		
			String midashi = rep_data.getmidashi();//記事見出し
			String feature = rep_data.getfeature();//特徴・セールスポイント
			String evaluate = rep_data.getevaluate();//評価文
			
			String Konyu_Houhou = rep_data.getKonyu_houhou();//購入方法
			
			String[] Interview1 = null;
			Interview1 = rep_data.getInterview1();
			
			String Interview2 = rep_data.getInterview2();
			
			String[] Interview3 = null;
			Interview3 = rep_data.getInterview3();
			
			String Interview4 = rep_data.getInterview4();
			
			String[] Interview5 = rep_data.getInterview5();
			
			String Interview6 = rep_data.getInterview6();
			
			Rep_List_TO kijidata = new Rep_List_TO(gamecode, gametitle, k_id, login_name, Seinengappi, Sex, Pref,
					dificultty, story, graphic, sound, volume, controll, promotion, free_S, total,
					jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
					jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
					jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
					outline, midashi, feature, evaluate, Konyu_Houhou, Interview1,
					Interview2, Interview3, Interview4, Interview5, Interview6, Job);
			
			if(kaiindata.getk_Id().equals(request.getRemoteUser())){
			Rep_List_DAO kijidao = new Rep_List_DAO();
			Rep_Code = kijidao.kiji_touroku(kijidata);
			session.removeAttribute("kijihyouka");
			}else{
				Rep_Code = null;
			}
		
		
		}else if(syubetsu.equals("newkiji")){//レポート種別が「紹介記事」(メニューからの新規登録)の場合に実行
			rep_data = (Rep_Koumoku)session.getAttribute("kijihyouka");
			
			String gametitle = inputdata.getGametitle();
			
			String MakerName = inputdata.getMakername();
			String HatsubaiNengappi = inputdata.getHatsubainengappi();
			if(HatsubaiNengappi == null || HatsubaiNengappi.equals("") || HatsubaiNengappi.equals("不明")){
				HatsubaiNengappi = "0000-01-01";
			}
			String MainGenre = inputdata.getMaingenre();
			String PlatForm = inputdata.getPlatform();
			/*String report_code = コードのつけ方が未定のためコメントアウト
			String upload_date =
			String hyouka_rank = 
			boolean tensaku_flg =
			*/
			String k_id = kaiindata.getk_Id();
			String login_name = kaiindata.getlogin_name();
			String Seinengappi = kaiindata.getSeinenGappi();
			String Sex = kaiindata.getSex();
			String Job = kaiindata.getJob();
			String Pref = kaiindata.getPref();
			
			double dificultty = rep_data.getdificultty();
			double story = rep_data.getstory();
			double graphic = rep_data.getgraphic();
			double sound = rep_data.getsound();
			double volume = rep_data.getvolume();
			double controll = rep_data.getcontroll();
			double promotion = rep_data.getpromotion();
			double free_S = rep_data.getfree_S();
			double total = rep_data.gettotal();
			String outline = rep_data.getoutline();

			String jiyuten_koumoku1 = rep_data.getjiyuten_koumoku1();
			String jiyuten_koumoku2 = rep_data.getjiyuten_koumoku2();
			String jiyuten_koumoku3 = rep_data.getjiyuten_koumoku3();
			String jiyuten_koumoku4 = rep_data.getjiyuten_koumoku4();
			String jiyuten_koumoku5 = rep_data.getjiyuten_koumoku5();
			
			double jiyuten_score1 = rep_data.getjiyuten_score1();
			double jiyuten_score2 = rep_data.getjiyuten_score2();
			double jiyuten_score3 = rep_data.getjiyuten_score3();
			double jiyuten_score4 = rep_data.getjiyuten_score4();
			double jiyuten_score5 = rep_data.getjiyuten_score5();
			
			double jiyuten_maxscore1 = rep_data.getjiyuten_maxscore1();
			double jiyuten_maxscore2 = rep_data.getjiyuten_maxscore2();
			double jiyuten_maxscore3 = rep_data.getjiyuten_maxscore3();
			double jiyuten_maxscore4 = rep_data.getjiyuten_maxscore4();
			double jiyuten_maxscore5 = rep_data.getjiyuten_maxscore5();
		
			String midashi = rep_data.getmidashi();
			String feature = rep_data.getfeature();
			String evaluate = rep_data.getevaluate();
			
			String Konyu_Houhou = rep_data.getKonyu_houhou();
			
			String[] Interview1 = null;
			Interview1 = rep_data.getInterview1();
			
			String Interview2 = rep_data.getInterview2();
			
			String[] Interview3 = null;
			Interview3 = rep_data.getInterview3();
			
			String Interview4 = rep_data.getInterview4();
			
			String[] Interview5 = rep_data.getInterview5();
			
			String Interview6 = rep_data.getInterview6();
			
			Rep_List_TO newkijidata = new Rep_List_TO(gametitle, k_id, login_name, Seinengappi, Sex, Pref,
					dificultty, story, graphic, sound, volume, controll, promotion, free_S, total,
					jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
					jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
					jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
					outline, midashi, feature, evaluate, Konyu_Houhou, Interview1,
					Interview2, Interview3, Interview4, Interview5, Interview6,
					 MakerName, HatsubaiNengappi, MainGenre, PlatForm, Job);
			
			if(kaiindata.getk_Id().equals(request.getRemoteUser())){
			Rep_List_DAO kijidao = new Rep_List_DAO();
			Rep_Code = kijidao.newkiji_touroku(newkijidata);
			session.removeAttribute("kijihyouka");
			}else{
				Rep_Code = null;
			}
		
		//}else{
		/*
		@SuppressWarnings("unchecked")
		List<FileItem> list = upload.parseRequest(request);
		
		for(FileItem item : list){
			if(item.isFormField()){
				syubetsu = item.getString();
				syubetsu = new String(syubetsu.getBytes("iso-8859-1"), "utf-8");
		*/
		}else if(syubetsu.equals("free")){//レポート種別が「自由形式」(ゲーム情報からの登録)の場合に実行
			rep_data = (Rep_Koumoku)session.getAttribute("freehyouka");
			
			String gamecode = gamedata.getGamecode();
			String gametitle = gamedata.getGametitle();
			
			/*String report_code = コードのつけ方が未定のためコメントアウト
			*/
			String k_id = kaiindata.getk_Id();
			String login_name = kaiindata.getlogin_name();
			String Seinengappi = kaiindata.getSeinenGappi();
			String Sex = kaiindata.getSex();
			String Job = kaiindata.getJob();
			String Pref = kaiindata.getPref();
			
			double dificultty = rep_data.getdificultty();
			double story = rep_data.getstory();
			double graphic = rep_data.getgraphic();
			double sound = rep_data.getsound();
			double volume = rep_data.getvolume();
			double controll = rep_data.getcontroll();
			double promotion = rep_data.getpromotion();
			double free_S = rep_data.getfree_S();
			double total = rep_data.gettotal();

			String jiyuten_koumoku1 = rep_data.getjiyuten_koumoku1();
			String jiyuten_koumoku2 = rep_data.getjiyuten_koumoku2();
			String jiyuten_koumoku3 = rep_data.getjiyuten_koumoku3();
			String jiyuten_koumoku4 = rep_data.getjiyuten_koumoku4();
			String jiyuten_koumoku5 = rep_data.getjiyuten_koumoku5();
			
			double jiyuten_score1 = rep_data.getjiyuten_score1();
			double jiyuten_score2 = rep_data.getjiyuten_score2();
			double jiyuten_score3 = rep_data.getjiyuten_score3();
			double jiyuten_score4 = rep_data.getjiyuten_score4();
			double jiyuten_score5 = rep_data.getjiyuten_score5();
			
			double jiyuten_maxscore1 = rep_data.getjiyuten_maxscore1();
			double jiyuten_maxscore2 = rep_data.getjiyuten_maxscore2();
			double jiyuten_maxscore3 = rep_data.getjiyuten_maxscore3();
			double jiyuten_maxscore4 = rep_data.getjiyuten_maxscore4();
			double jiyuten_maxscore5 = rep_data.getjiyuten_maxscore5();
		
			String outline = rep_data.getoutline();
			
			String Konyu_Houhou = rep_data.getKonyu_houhou();
			
			String[] Interview1 = null;
			Interview1 = rep_data.getInterview1();
			
			String Interview2 = rep_data.getInterview2();
			
			String[] Interview3 = null;
			Interview3 = rep_data.getInterview3();
			
			String Interview4 = rep_data.getInterview4();
			
			String[] Interview5 = rep_data.getInterview5();
			
			String Interview6 = rep_data.getInterview6();
			
			String UploadFileName = file.getName();
			
			Rep_List_TO freedata = new Rep_List_TO(gamecode, gametitle, k_id, login_name, Seinengappi, Sex, Pref,
					dificultty, story, graphic, sound, volume, controll, promotion, free_S, total,
					jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
					jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
					jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
					outline, Konyu_Houhou, Interview1,
					Interview2, Interview3, Interview4, Interview5, Interview6, UploadFileName, Job);
			
			if(kaiindata.getk_Id().equals(request.getRemoteUser())){
			Rep_List_DAO freedao = new Rep_List_DAO();
			Rep_Code = freedao.free_touroku(freedata);
			session.removeAttribute("freehyouka");
			//String storePath = sc.getRealPath("D:/");
			//FileUploadError = File_Upload_Utility.execute(request, storePath);
			}else{
				Rep_Code = null;
			}
		
		
		}else if(syubetsu.equals("newfree")){
			rep_data = (Rep_Koumoku)session.getAttribute("freehyouka");
			
			String gametitle = inputdata.getGametitle();
			
			String MakerName = inputdata.getMakername();
			String HatsubaiNengappi = inputdata.getHatsubainengappi();
			if(HatsubaiNengappi == null || HatsubaiNengappi.equals("") || HatsubaiNengappi.equals("不明")){
				HatsubaiNengappi = "0000-01-01";
			}
			String MainGenre = inputdata.getMaingenre();
			String PlatForm = inputdata.getPlatform();
			
			/*String report_code = コードのつけ方が未定のためコメントアウト
			String upload_date =
			String hyouka_rank = 
			boolean tensaku_flg =
			*/
			String k_id = kaiindata.getk_Id();
			String login_name = kaiindata.getlogin_name();
			String Seinengappi = kaiindata.getSeinenGappi();
			String Sex = kaiindata.getSex();
			String Job = kaiindata.getJob();
			String Pref = kaiindata.getPref();
			
			double dificultty = rep_data.getdificultty();
			double story = rep_data.getstory();
			double graphic = rep_data.getgraphic();
			double sound = rep_data.getsound();
			double volume = rep_data.getvolume();
			double controll = rep_data.getcontroll();
			double promotion = rep_data.getpromotion();
			double free_S = rep_data.getfree_S();
			double total = rep_data.gettotal();

			String jiyuten_koumoku1 = rep_data.getjiyuten_koumoku1();
			String jiyuten_koumoku2 = rep_data.getjiyuten_koumoku2();
			String jiyuten_koumoku3 = rep_data.getjiyuten_koumoku3();
			String jiyuten_koumoku4 = rep_data.getjiyuten_koumoku4();
			String jiyuten_koumoku5 = rep_data.getjiyuten_koumoku5();
			
			double jiyuten_score1 = rep_data.getjiyuten_score1();
			double jiyuten_score2 = rep_data.getjiyuten_score2();
			double jiyuten_score3 = rep_data.getjiyuten_score3();
			double jiyuten_score4 = rep_data.getjiyuten_score4();
			double jiyuten_score5 = rep_data.getjiyuten_score5();
			
			double jiyuten_maxscore1 = rep_data.getjiyuten_maxscore1();
			double jiyuten_maxscore2 = rep_data.getjiyuten_maxscore2();
			double jiyuten_maxscore3 = rep_data.getjiyuten_maxscore3();
			double jiyuten_maxscore4 = rep_data.getjiyuten_maxscore4();
			double jiyuten_maxscore5 = rep_data.getjiyuten_maxscore5();
		
			String outline = rep_data.getoutline();
			
			String Konyu_Houhou = rep_data.getKonyu_houhou();
			
			String[] Interview1 = null;
			Interview1 = rep_data.getInterview1();
			
			String Interview2 = rep_data.getInterview2();
			
			String[] Interview3 = null;
			Interview3 = rep_data.getInterview3();
			
			String Interview4 = rep_data.getInterview4();
			
			String[] Interview5 = rep_data.getInterview5();
			
			String Interview6 = rep_data.getInterview6();
			
			String UploadFileName = file.getName();
			
			Rep_List_TO newfreedata = new Rep_List_TO(gametitle, k_id, login_name, Seinengappi, Sex, Pref,
					outline, story, graphic, sound, volume, controll, promotion, free_S, total,
					jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
					jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
					jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
					dificultty, Konyu_Houhou, Interview1,
					Interview2, Interview3, Interview4, Interview5, Interview6,
					MakerName, HatsubaiNengappi, MainGenre, PlatForm, UploadFileName, Job);
			
			if(kaiindata.getk_Id().equals(request.getRemoteUser())){
			Rep_List_DAO freedao = new Rep_List_DAO();
			Rep_Code = freedao.newfree_touroku(newfreedata);
			session.removeAttribute("freehyouka");
		//}
		//}else{
			//String storePath = sc.getRealPath("D:\\");
			//FileUploadError = File_Upload_Utility.execute(request, storePath);
			}else{
				Rep_Code = null;
			}
		}
		} 
		if(Rep_Code == null){
			session.setAttribute("errcode", "Rep-212");//レポートデータのアップロード自体に失敗
			item.delete();
			NextPage = "/passed/Error_Gamen.jsp";
		}else if(FileUploadError){
			Rep_List_DAO deldao = new Rep_List_DAO();
			syubetsu = item.getString();
			RollBackError = deldao.Rep_RollBack(Rep_Code, syubetsu);
			if(RollBackError == false){
			session.setAttribute("errcode", "Rep_312");//ファイルの保存に失敗(添付書類の削除は成功)
			
			}else{
				session.setAttribute("errcode", "Rep-412");//ファイルの保存に失敗(添付書類の削除も失敗)
			}
			NextPage = "/passed/Error_Gamen.jsp";
			
		}else{
			NextPage = "/passed/Rep_Uketsuke_Kanryou.html";
		}
		item.delete();
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "Rep-012");
		NextPage = "/passed/Error_Gamen.jsp";
	}	
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
