package rep_upload;

import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Free_Report_Kakunin
 */
public class Free_Report_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Free_Report_Kakunin() {
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
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "Rep-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
		Rep_Koumoku Judge = new Rep_Koumoku();
		boolean Jisu_Wrong = false;
		boolean over = false;//評価点数の入力値が不正かどうかを表すフラグ
		boolean notscore = false;//評価点数に入力されていない部分があるかを表すフラグ
		boolean wrong = false;//入力値が不正かどうかを表すフラグ
		boolean few = false;//マイナスの値が入力されているかを表すフラグ
		String NGWord = null;//NGワードを検出したかを表すフラグ
		boolean notmatch = false;//自由点の合計が合っていないことを示すフラグ
		boolean notOutline = false;//ゲームの概要の欄が空欄かどうかを表すフラグ
		boolean notAnswer = false;//インタビュー項目に空欄があるかを表すフラグ
		boolean nofile = false;//添付ファイルが指定されていないかどうかを表すフラグ
		
String Dificultty_S = request.getParameter("difficulty"); //難易度の適正度
		
		double dificultty = 5;
		if(Dificultty_S == null || Dificultty_S.equals("")){//難易度の適正度の欄が空欄なら
			notscore = true;
		}else{
			try{
				//Dificultty_S = HttpUtility.escapeHTML(Dificultty_S);//特殊文字チェック
				if(HttpUtility.NG_Word_Check(Dificultty_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Dificultty_S);//NGワードチェック
				}
		dificultty = Double.parseDouble(Dificultty_S);//String→Doubleへ変換
		if(dificultty > 10){//満点(10.0)を超えている場合は
			over = true;
		}
		if(dificultty < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}	
			
		}
		
		String Story_S = request.getParameter("story"); //キャラクター・ストーリー(世界観)
		
		double story = 5;
		if(Story_S == null || Story_S.equals("")){
			notscore = true;
		}else{
			try{
				//Story_S = HttpUtility.escapeHTML(Story_S);
				if(HttpUtility.NG_Word_Check(Story_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Story_S);//NGワードチェック
				}
		story = Double.parseDouble(Story_S);
		if(story > 10){
			over = true;
		}
		if(story < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}
		
		}
		String Graphic_S = request.getParameter("graphic"); //グラフィック
		
		double graphic = 5;
		if(Graphic_S == null || Graphic_S.equals("")){
			notscore = true;
		}else{
			try{
				//Graphic_S = HttpUtility.escapeHTML(Graphic_S);
				if(HttpUtility.NG_Word_Check(Graphic_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Graphic_S);//NGワードチェック
				}
		graphic = Double.parseDouble(Graphic_S);
		if(graphic > 10){
			over = true;
		}
		if(graphic < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}
		
		}
		String Sound_S = request.getParameter("sound"); //サウンド
		
		double sound = 5;
		if(Sound_S == null || Sound_S.equals("")){
			notscore = true;
		}else{
			try{
				//Sound_S = HttpUtility.escapeHTML(Sound_S);
				if(HttpUtility.NG_Word_Check(Sound_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Sound_S);//NGワードチェック
				}
		sound = Double.parseDouble(Sound_S);
		if(sound > 10){
			over = true;
		}
		if(sound < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}
		
		}
		String Volume_S = request.getParameter("volume"); //ボリューム度・ハマり度
		
		double volume = 5;
		if(Volume_S == null || Volume_S.equals("")){
			notscore = true;
		}else{
			try{
				//Volume_S = HttpUtility.escapeHTML(Volume_S);
				if(HttpUtility.NG_Word_Check(Volume_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Volume_S);//NGワードチェック
				}
		volume = Double.parseDouble(Volume_S);
		if(volume > 10){
			over = true;
		}
		if(volume < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}	
		
		}
		String Controll_S = request.getParameter("controll"); //操作性
	
		double controll = 5;
		if(Controll_S == null || Controll_S.equals("")){
			notscore = true;
		}else{
			try{
				//Controll_S = HttpUtility.escapeHTML(Controll_S);
				if(HttpUtility.NG_Word_Check(Controll_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Controll_S);//NGワードチェック
				}
		controll = Double.parseDouble(Controll_S);
		if(controll > 10){
			over = true;
		}
		if(controll < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}	
		
		}
		String Promotion_S = request.getParameter("promotion"); //プロモーション
		
		double promotion = 5;
		if(Promotion_S == null || Promotion_S.equals("")){
			notscore = true;
		}else{
			try{
				//Promotion_S = HttpUtility.escapeHTML(Promotion_S);
				if(HttpUtility.NG_Word_Check(Promotion_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Promotion_S);//NGワードチェック
				}
		promotion = Double.parseDouble(Promotion_S);
		if(promotion > 10){
			over = true;
		}
		if(promotion < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}	
		
		}
		String Free_S_S = request.getParameter("free_s"); //自由点
		
		double free_S = 15;
		if(Free_S_S == null || Free_S_S.equals("")){
			notscore = true;
		}else{
			try{
				//Free_S_S = HttpUtility.escapeHTML(Free_S_S);
				if(HttpUtility.NG_Word_Check(Free_S_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Free_S_S);//NGワードチェック
				}
		free_S = Double.parseDouble(Free_S_S);
		if(free_S > 30){
			over = true;
		}
		if(free_S < 0){
			few = true;
		}
			}catch(NumberFormatException e){
				wrong = true;
			}
		
		}
		double total = dificultty + story + graphic + sound + volume + controll + promotion + free_S; //合計
		if(total > 100){
			over = true;
		}
		
		String Jiyuten_Koumoku1 = request.getParameter("jiyuten_koumoku1");
		try{
		if(Jiyuten_Koumoku1 == null || Jiyuten_Koumoku1.equals("")){
			notscore = true;
		}else if(Jiyuten_Koumoku1.length() > 30){
			Jisu_Wrong = true;
		}
		//Jiyuten_Koumoku1 = HttpUtility.escapeHTML(Jiyuten_Koumoku1);
		if(HttpUtility.NG_Word_Check(Jiyuten_Koumoku1) != null){
			NGWord = HttpUtility.NG_Word_Check(Jiyuten_Koumoku1);//NGワードチェック
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		String Jiyuten_Koumoku2 = request.getParameter("jiyuten_koumoku2");
		try{
			if(Jiyuten_Koumoku2.length() > 30){
				Jisu_Wrong = true;
			}
		//Jiyuten_Koumoku2 = HttpUtility.escapeHTML(Jiyuten_Koumoku2);
			if(HttpUtility.NG_Word_Check(Jiyuten_Koumoku2) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Koumoku2);//NGワードチェック
			}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		String Jiyuten_Koumoku3 = request.getParameter("jiyuten_koumoku3");
		try{
			if(Jiyuten_Koumoku3.length() > 30){
				Jisu_Wrong = true;
			}
		//Jiyuten_Koumoku3 = HttpUtility.escapeHTML(Jiyuten_Koumoku3);
			if(HttpUtility.NG_Word_Check(Jiyuten_Koumoku3) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Koumoku3);//NGワードチェック
			}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		String Jiyuten_Koumoku4 = request.getParameter("jiyuten_koumoku4");
		try{
			if(Jiyuten_Koumoku4.length() > 30){
				Jisu_Wrong = true;
			}
		//Jiyuten_Koumoku4 = HttpUtility.escapeHTML(Jiyuten_Koumoku4);
			if(HttpUtility.NG_Word_Check(Jiyuten_Koumoku4) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Koumoku4);//NGワードチェック
			}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		String Jiyuten_Koumoku5 = request.getParameter("jiyuten_koumoku5");
		try{
			if(Jiyuten_Koumoku5.length() > 30){
				Jisu_Wrong = true;
			}
		//Jiyuten_Koumoku5 = HttpUtility.escapeHTML(Jiyuten_Koumoku5);
			if(HttpUtility.NG_Word_Check(Jiyuten_Koumoku5) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Koumoku5);//NGワードチェック
			}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		double Jiyuten_Score1 = 15.00;
		String Jiyuten_Score1_S = request.getParameter("jiyuten_score1");
		try{
		//Jiyuten_Score1_S = HttpUtility.escapeHTML(Jiyuten_Score1_S);
		if(HttpUtility.NG_Word_Check(Jiyuten_Score1_S) != null){
			NGWord = HttpUtility.NG_Word_Check(Jiyuten_Score1_S);//NGワードチェック
		}
		if(Jiyuten_Score1_S == null || Jiyuten_Score1_S.equals("")){
		Jiyuten_Score1 = 15.00;
		}else{
		Jiyuten_Score1 = Double.parseDouble(Jiyuten_Score1_S);
		if(Jiyuten_Score1 < 0){
		few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		double Jiyuten_Score2 = 0.00;		
		String Jiyuten_Score2_S = request.getParameter("jiyuten_score2");
		try{
		//Jiyuten_Score2_S = HttpUtility.escapeHTML(Jiyuten_Score2_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_Score2_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Score2_S);//NGワードチェック
			}
		if(Jiyuten_Score2_S == null || Jiyuten_Score2_S.equals("")){
			Jiyuten_Score1 = 0.00;
			notscore = true;
			}else{
		Jiyuten_Score2 = Double.parseDouble(Jiyuten_Score2_S);
		if(Jiyuten_Score2 < 0){
			few = true;
		}
			}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_Score3 = 0.00;				
		String Jiyuten_Score3_S = request.getParameter("jiyuten_score3");
		try{
		//Jiyuten_Score3_S = HttpUtility.escapeHTML(Jiyuten_Score3_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_Score3_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Score3_S);//NGワードチェック
			}
		if(Jiyuten_Score3_S == null || Jiyuten_Score3_S.equals("")){
			Jiyuten_Score3 = 0.00;
		}else{	
		Jiyuten_Score3 = Double.parseDouble(Jiyuten_Score3_S);
		if(Jiyuten_Score3 < 0){
			few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_Score4 = 0.00;
		String Jiyuten_Score4_S = request.getParameter("jiyuten_score4");
		try{
		//Jiyuten_Score4_S = HttpUtility.escapeHTML(Jiyuten_Score4_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_Score4_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Score4_S);//NGワードチェック
			}
		if(Jiyuten_Score4_S == null || Jiyuten_Score4_S.equals("")){
			Jiyuten_Score4 = 0.00;
		}else{						
		Jiyuten_Score4 = Double.parseDouble(Jiyuten_Score4_S);
		if(Jiyuten_Score4 < 0){
			few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_Score5 = 0.00;
		String Jiyuten_Score5_S = request.getParameter("jiyuten_score5");
		try{
		//Jiyuten_Score5_S = HttpUtility.escapeHTML(Jiyuten_Score5_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_Score5_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_Score5_S);//NGワードチェック
			}
		if(Jiyuten_Score5_S == null || Jiyuten_Score5_S.equals("")){
			Jiyuten_Score5 = 0.00;
		}else{														
		Jiyuten_Score5 = Double.parseDouble(Jiyuten_Score5_S);
		if(Jiyuten_Score5 < 0){
			few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_ScoreTotal = Jiyuten_Score1 + Jiyuten_Score2 + Jiyuten_Score3 + Jiyuten_Score4 + Jiyuten_Score5;
		try{
		if(Jiyuten_ScoreTotal != free_S){
			notmatch = true;
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		double Jiyuten_MaxScore1 = 30.00;
		String Jiyuten_MaxScore1_S = request.getParameter("jiyuten_maxscore1");
		try{
		//Jiyuten_MaxScore1_S = HttpUtility.escapeHTML(Jiyuten_MaxScore1_S);
		if(HttpUtility.NG_Word_Check(Jiyuten_MaxScore1_S) != null){
			NGWord = HttpUtility.NG_Word_Check(Jiyuten_MaxScore1_S);//NGワードチェック
		}
		if(Jiyuten_MaxScore1_S == null || Jiyuten_MaxScore1_S.equals("")){
		Jiyuten_MaxScore1 = 30.00;
		}else{
		Jiyuten_MaxScore1 = Double.parseDouble(Jiyuten_MaxScore1_S);
		if(Jiyuten_MaxScore1 < 0){
		few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_MaxScore2 = 0.00;		
		String Jiyuten_MaxScore2_S = request.getParameter("jiyuten_maxscore2");
		try{
		//Jiyuten_MaxScore2_S = HttpUtility.escapeHTML(Jiyuten_MaxScore2_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_MaxScore2_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_MaxScore2_S);//NGワードチェック
			}
		if(Jiyuten_MaxScore2_S == null || Jiyuten_MaxScore2_S.equals("")){
			Jiyuten_MaxScore2 = 0.00;
			}else{
		Jiyuten_MaxScore2 = Double.parseDouble(Jiyuten_MaxScore2_S);
		if(Jiyuten_MaxScore2 < 0){
			few = true;
		}
			}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_MaxScore3 = 0.00;				
		String Jiyuten_MaxScore3_S = request.getParameter("jiyuten_maxscore3");
		try{
		//Jiyuten_MaxScore3_S = HttpUtility.escapeHTML(Jiyuten_MaxScore3_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_MaxScore3_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_MaxScore3_S);//NGワードチェック
			}
		if(Jiyuten_MaxScore3_S == null || Jiyuten_MaxScore3_S.equals("")){
			Jiyuten_MaxScore3 = 0.00;
		}else{	
		Jiyuten_MaxScore3 = Double.parseDouble(Jiyuten_MaxScore3_S);
		if(Jiyuten_MaxScore3 < 0){
			few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_MaxScore4 = 0.00;
		String Jiyuten_MaxScore4_S = request.getParameter("jiyuten_maxscore4");
		try{
		//Jiyuten_MaxScore4_S = HttpUtility.escapeHTML(Jiyuten_MaxScore4_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_MaxScore4_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_MaxScore4_S);//NGワードチェック
			}
		if(Jiyuten_MaxScore4_S == null || Jiyuten_MaxScore4_S.equals("")){
			Jiyuten_MaxScore4 = 0.00;
		}else{						
		Jiyuten_MaxScore4 = Double.parseDouble(Jiyuten_MaxScore4_S);
		if(Jiyuten_MaxScore4 < 0){
			few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_MaxScore5 = 0.00;
		String Jiyuten_MaxScore5_S = request.getParameter("jiyuten_maxscore5");
		try{
		//Jiyuten_MaxScore5_S = HttpUtility.escapeHTML(Jiyuten_MaxScore5_S);
			if(HttpUtility.NG_Word_Check(Jiyuten_MaxScore5_S) != null){
				NGWord = HttpUtility.NG_Word_Check(Jiyuten_MaxScore5_S);//NGワードチェック
			}
		if(Jiyuten_MaxScore5_S == null || Jiyuten_MaxScore5_S.equals("")){
			Jiyuten_MaxScore5 = 0.00;
		}else{														
		Jiyuten_MaxScore5 = Double.parseDouble(Jiyuten_MaxScore5_S);
		if(Jiyuten_MaxScore5 < 0){
			few = true;
		}
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		double Jiyuten_MaxScoreTotal = Jiyuten_MaxScore1 + Jiyuten_MaxScore2 + Jiyuten_MaxScore3 + Jiyuten_MaxScore4 + Jiyuten_MaxScore5;
		try{
		if(Jiyuten_MaxScoreTotal != 30.00){
			notmatch = true;
		}
		}catch(NumberFormatException e){
			wrong = true;
		}
		
		String outline = request.getParameter("outline"); //概要
		
		if(outline == null || outline.equals("") || outline.equals("入力してください")){
			notOutline = true;
			outline="入力してください";
		}else if(outline.length() > 500){
			Jisu_Wrong = true;
		}
				//outline = HttpUtility.escapeHTML(outline);
				//outline = outline.replaceAll("\n", "<br/>");
				if(HttpUtility.NG_Word_Check(outline) != null){
					NGWord = HttpUtility.NG_Word_Check(outline);//NGワードチェック
				}
		
        String Konyu_Houhou = request.getParameter("konyu_houhou");//購入方法
		
		if(Konyu_Houhou == null || Konyu_Houhou.equals("")){
			notAnswer = true;
		}
		else{
			//Konyu_Houhou = HttpUtility.escapeHTML(Konyu_Houhou);
			if(HttpUtility.NG_Word_Check(Konyu_Houhou) != null){
				NGWord = HttpUtility.NG_Word_Check(Konyu_Houhou);
			}
		}
		
		String[] Interview1 = request.getParameterValues("Interview1");//プレー希望者
		try{
		if(Interview1 == null || Interview1[0].equals("")){
			Interview1 = new String[1];
			Interview1[0] = "該当項目なし";
		}
		}catch(NullPointerException ex){
			notAnswer = true;
		}
		
		
		String Interview2 = request.getParameter("Interview2");//心待ちにしていた人
		try{
		if(Interview2 == null){
			notAnswer = true;
		}
		}catch(NullPointerException ex){
			notAnswer = true;
		}
		
		
		String[] Interview3 = request.getParameterValues("Interview3");//見聞きしたことのある情報
		try{
		if(Interview3 == null || Interview3[0].equals("")){
			Interview3 = new String[1];
			Interview3[0] = "該当項目なし";
		}
		}catch(NullPointerException ex){
			notAnswer = true;
		}
		
		
		String Interview4 = request.getParameter("Interview4");//購入の最大の決め手
		try{
		if(Interview4 == null){
			notAnswer = true;
		}
		}catch(NullPointerException ex){
			notAnswer = true;
		}
		
		
		String[] Interview5 = request.getParameterValues("Interview5");//購入理由
		int i=0;
		try{
		if(Interview5 == null){
			Interview5 = new String[1];
			Interview5[0] = "該当項目なし";
		}else{
			for(String Inter5 : Interview5){
			if(Inter5.equals("その他")){//その他をチェックした場合はフォームの文字列をそのまま格納
			Inter5 = request.getParameter("Interview5_etc");
			if(Inter5 == null || Inter5.equals("")){
				Inter5 = "記述なし";
			}else if(Inter5.length() > 40){
				Jisu_Wrong = true;
			}
			//Interview5[i] = HttpUtility.escapeHTML(Inter5);
			//Interview5[i] = Interview5[i].replaceAll("\n", "<br/>");
			if(HttpUtility.NG_Word_Check(Interview5[i]) != null){
				NGWord = HttpUtility.NG_Word_Check(Interview5[i]);//NGワードチェック
			}
			i++;
			}
			}
		}
		}catch(NullPointerException ex){
			notAnswer = true;
		}
		
		String Interview6 = request.getParameter("Interview6");//次回作の購入意欲
		try{
		if(Interview6 == null){
			notAnswer = true;
		}
		}catch(NullPointerException ex){
			notAnswer = true;
		}
		/*
		String UploadFileName = request.getParameter("filename");//レポートデータのファイル名
		
		try{
			if(UploadFileName == null || UploadFileName.equals("")){
				nofile = true;
			}
			else{
				//UploadFileName = HttpUtility.escapeHTML(UploadFileName);
				if(HttpUtility.NG_Word_Check(UploadFileName) == true){
					nghit = true;//NGワードチェック
				}
			}
		}catch(NullPointerException ex){
			nofile = true;
		}
		*/
		
		Judge = new Rep_Koumoku(Jisu_Wrong, over, notscore, wrong, few, NGWord, notmatch, nofile, dificultty, story, graphic, sound, volume, controll, promotion, free_S, total,
				Jiyuten_Koumoku1, Jiyuten_Koumoku2, Jiyuten_Koumoku3, Jiyuten_Koumoku4, Jiyuten_Koumoku5, Jiyuten_Score1, Jiyuten_Score2, Jiyuten_Score3, Jiyuten_Score4, Jiyuten_Score5,
				Jiyuten_ScoreTotal, Jiyuten_MaxScore1, Jiyuten_MaxScore2, Jiyuten_MaxScore3, Jiyuten_MaxScore4, Jiyuten_MaxScore5, Jiyuten_MaxScoreTotal, outline, notOutline, Konyu_Houhou,
				Interview1, Interview2, Interview3, Interview4, Interview5, Interview6, notAnswer);//, UploadFileName);
		session.setAttribute("freehyouka", Judge);
		
		if(Jisu_Wrong || over || few || NGWord != null ||notmatch || notOutline || notscore || wrong || notAnswer || nofile){
			
			NextPage = "/passed/Free_Report/Free_Rep_Syusei.jsp";
		}else{	
			NextPage = "/passed/Free_Report/Free_Rep_Kakunin.jsp";
		}
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Rep-001");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
