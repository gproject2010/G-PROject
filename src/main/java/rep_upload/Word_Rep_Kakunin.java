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
 * Servlet implementation class Word_Rep_Kakunin
 */
public class Word_Rep_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Word_Rep_Kakunin() {
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
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "Rep-006");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		Rep_Koumoku RepData = new Rep_Koumoku();
		Rep_List_DAO dao = new Rep_List_DAO();
		
		boolean NoTitle = false;//ゲームタイトルの未入力
		boolean Jisu_Wrong = false;//字数制限を守っていなければtrue
		boolean over = false;//評価点数が満点を超えていればtrue
		boolean notscore = false;//評価点数の入力漏れ
		boolean wrong = false;//不正な値が入力されていればtrue
		boolean few = false;//マイナスの値が入力されているかを表すフラグ
		boolean notmatch = false;//自由点の合計が合っていないことを示すフラグ
		boolean nocomment = false;//コメントの未入力
		String NGWord = null;
		
		try{
			String GameTitle = request.getParameter("gametitle");
			String Dificultty_S = request.getParameter("dificultty");
			String Story_S = request.getParameter("story");
			String Graphic_S = request.getParameter("graphic");
			String Sound_S = request.getParameter("sound");
			String Volume_S = request.getParameter("volume");
			String Controll_S = request.getParameter("controll");
			String Promotion_S = request.getParameter("promotion");
			String Free_S_S = request.getParameter("free_s");
			
			String Jiyuten_Koumoku1 = request.getParameter("jiyuten_koumoku1");
			String Jiyuten_Koumoku2 = request.getParameter("jiyuten_koumoku2");
			String Jiyuten_Koumoku3 = request.getParameter("jiyuten_koumoku3");
			String Jiyuten_Score1_S = request.getParameter("jiyuten_score1");
			String Jiyuten_Score2_S = request.getParameter("jiyuten_score2");
			String Jiyuten_Score3_S = request.getParameter("jiyuten_score3");
			String Jiyuten_MaxScore1_S = request.getParameter("jiyuten_maxscore1");
			String Jiyuten_MaxScore2_S = request.getParameter("jiyuten_maxscore2");
			String Jiyuten_MaxScore3_S = request.getParameter("jiyuten_maxscore3");
			
			String Comment = request.getParameter("comment");
			
			if(GameTitle == null || GameTitle.equals("") || GameTitle.equals("入力してください")){
				GameTitle = "入力してください";
				NoTitle = true;
			}else if(HttpUtility.NG_Word_Check(GameTitle) != null){
				wrong = true;
				NGWord = HttpUtility.NG_Word_Check(GameTitle);
			}else if(GameTitle.length() > 40){
				Jisu_Wrong = true;
			}
			
			double Dificultty = 5;
			double Story = 5;
			double Graphic = 5;
			double Sound = 5;
			double Volume = 5;
			double Controll = 5;
			double Promotion = 5;
			double Free_S = 5;
			double Total = 50;
			
			try{
				if(Dificultty_S == null || Dificultty_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Dificultty_S) != null){
					wrong = true;
					NGWord = HttpUtility.NG_Word_Check(Dificultty_S);
				}else{
				Dificultty = Double.parseDouble(Dificultty_S);
				Dificultty = HttpUtility.Round(Dificultty, 2, "cut");
				if(Dificultty > 10){
					over = true;
				}else if(Dificultty < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			try{
				if(Story_S == null || Story_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Story_S) != null){
					wrong = true;
					NGWord = HttpUtility.NG_Word_Check(Story_S);
				}else{
				Story = Double.parseDouble(Story_S);
				Story = HttpUtility.Round(Story, 2, "cut");
				if(Story > 10){
					over = true;
				}else if(Story < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			try{
				if(Graphic_S == null || Graphic_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Graphic_S) != null){
					wrong = true;
					NGWord = HttpUtility.NG_Word_Check(Graphic_S);
				}else{
				Graphic = Double.parseDouble(Graphic_S);
				Graphic = HttpUtility.Round(Graphic, 2, "cut");
				if(Graphic > 10){
					over = true;
				}else if(Graphic < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			try{
				if(Sound_S == null || Sound_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Sound_S) != null){
					wrong = true;
					NGWord = HttpUtility.NG_Word_Check(Sound_S);
				}else{
				Sound = Double.parseDouble(Sound_S);
				Sound = HttpUtility.Round(Sound, 2, "cut");
				if(Sound > 10){
					over = true;
				}else if(Sound < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			try{
				if(Volume_S == null || Volume_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Volume_S) != null){
					wrong = true;
					NGWord = HttpUtility.NG_Word_Check(Volume_S);
				}else{
				Volume = Double.parseDouble(Volume_S);
				Volume = HttpUtility.Round(Volume, 2, "cut");
				if(Volume > 10){
					over = true;
				}else if(Volume < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			try{
				if(Controll_S == null || Controll_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Controll_S) != null){
					wrong = true;
					NGWord = HttpUtility.NG_Word_Check(Controll_S);
				}else{
				Controll = Double.parseDouble(Controll_S);
				Controll = HttpUtility.Round(Controll, 2, "cut");
				if(Controll > 10){
					over = true;
				}else if(Controll < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			try{
				if(Promotion_S == null || Promotion_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Promotion_S) != null){
					wrong = true;
					NGWord = HttpUtility.NG_Word_Check(Promotion_S);
				}else{
				Promotion = Double.parseDouble(Promotion_S);
				Promotion = HttpUtility.Round(Promotion, 2, "cut");
				if(Promotion > 10){
					over = true;
				}else if(Promotion < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			try{
				if(Free_S_S == null || Free_S_S.equals("")){
					notscore = true;
				}else if(HttpUtility.NG_Word_Check(Free_S_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Free_S_S);
					wrong = true;
				}else{
				Free_S = Double.parseDouble(Free_S_S);
				Free_S = HttpUtility.Round(Free_S, 2, "cut");
				if(Free_S > 30){
					over = true;
				}else if(Free_S < 0){
					few = true;
				}
				}
				}catch(NumberFormatException s){
					s.printStackTrace();
					wrong = true;
				}
			
			Total = Dificultty + Story + Graphic + Sound + Volume + Controll + Promotion + Free_S;
			if(Total > 100){
				over = true;
			}
			

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
			}catch(Exception e){
				wrong = true;
			}
			
			try{
				if(Jiyuten_Koumoku2.length() > 30){
					Jisu_Wrong = true;
				}
			//Jiyuten_Koumoku2 = HttpUtility.escapeHTML(Jiyuten_Koumoku2);
				if(HttpUtility.NG_Word_Check(Jiyuten_Koumoku2) != null){
					NGWord = HttpUtility.NG_Word_Check(Jiyuten_Koumoku2);//NGワードチェック
				}
			}catch(Exception e){
				wrong = true;
			}
			
			try{
				if(Jiyuten_Koumoku3.length() > 30){
					Jisu_Wrong = true;
				}
			//Jiyuten_Koumoku3 = HttpUtility.escapeHTML(Jiyuten_Koumoku3);
				if(HttpUtility.NG_Word_Check(Jiyuten_Koumoku3) != null){
					NGWord = HttpUtility.NG_Word_Check(Jiyuten_Koumoku3);//NGワードチェック
				}
			}catch(Exception e){
				wrong = true;
			}
			

			double Jiyuten_Score1 = 15.00;
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
			try{
			//Jiyuten_Score2_S = HttpUtility.escapeHTML(Jiyuten_Score2_S);
				if(HttpUtility.NG_Word_Check(Jiyuten_Score2_S) != null){
					NGWord = HttpUtility.NG_Word_Check(Jiyuten_Score2_S);//NGワードチェック
				}
			if(Jiyuten_Score2_S == null || Jiyuten_Score2_S.equals("")){
				Jiyuten_Score2 = 0.00;
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


			double Jiyuten_MaxScore1 = 30.00;
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
			
			double Jiyuten_TotalScore = Jiyuten_Score1 + Jiyuten_Score2 + Jiyuten_Score3;
			double Jiyuten_TotalMaxScore = Jiyuten_MaxScore1 + Jiyuten_MaxScore2 + Jiyuten_MaxScore3;
			
			if(Jiyuten_TotalScore != Free_S || Jiyuten_TotalMaxScore != 30){
				notmatch = true;
			}
			
			if(Comment == null || Comment.equals("") || Comment.equals("入力してください")){
				Comment = "入力してください";
			nocomment = true;
		}else if(HttpUtility.NG_Word_Check(Comment) != null){
			wrong = true;
			}else if(Comment.length() > 200){
				Jisu_Wrong = true;
			}
			
			RepData = new Rep_Koumoku(GameTitle, Dificultty, Story, Graphic, Sound, Volume, Controll, Promotion, Free_S, Total,
					Jiyuten_Koumoku1, Jiyuten_Koumoku2, Jiyuten_Koumoku3, Jiyuten_Score1, Jiyuten_Score2, Jiyuten_Score3, Jiyuten_TotalScore,
					 Jiyuten_MaxScore1, Jiyuten_MaxScore2, Jiyuten_MaxScore3, Jiyuten_TotalMaxScore, Comment, NoTitle, Jisu_Wrong, over, notscore, wrong,
					 few, notmatch, nocomment, NGWord);
			session.setAttribute("repdata", RepData);
			
			String IPAddress = request.getRemoteAddr();
			
			if(IPAddress == null || IPAddress.equals("") || dao.WordRep_Jyufukukakunin(IPAddress) > 3){
			NextPage = "/free_area/Word_Report/KaisuOver.html";
			}else{
			if(NoTitle || Jisu_Wrong || over || notscore || wrong || few || notmatch || nocomment || NGWord != null){
				NextPage = "/free_area/Word_Report/Word_Report_Syusei.jsp";
			}else{
				NextPage = "/free_area/Word_Report/Word_Report_Kakunin.jsp";
			}
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "WordRep-007");
			NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
		}
			
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
		}

}
