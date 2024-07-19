package k_jyouhou;

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
 * Servlet implementation class Kaiin_Touroku_Kakunin_p2
 */
public class Kaiin_Touroku_Kakunin_p2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kaiin_Touroku_Kakunin_p2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		ServletContext sc = getServletContext();
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "KData-003");
		String NextPage = "/passed/Error_Gamen.jsp";
		String Input_Id = request.getRemoteUser();//認証情報からIDを抽出
		//Input_Id = HttpUtility.escapeHTML(Input_Id);//特殊文字チェック
		try{
		String Sei_Kanji = request.getParameter("sei_kanji");//姓(漢字)
		String Mei_Kanji = request.getParameter("mei_kanji");//名(漢字)
		String Sei_Kana = request.getParameter("sei_kana");//姓(カタカナ)
		String Mei_Kana = request.getParameter("mei_kana");//名(カタカナ)
		String BirthYear = request.getParameter("birthyear");//生年月日
		String BirthTsuki = request.getParameter("birthtsuki");
		String BirthDay = request.getParameter("birthday");
		String Sex = request.getParameter("sex");//性別
		String AddressNo = request.getParameter("addressno");//住所(郵便番号)
		String Pref = request.getParameter("pref");//住所(都道府県)
		String Jyusyo = request.getParameter("jyusyo");//住所(区市区町村以下)
		String Telephone_No = request.getParameter("telephone_no");//連絡先電話番号
		String Secret_Question = request.getParameter("secret_question");//秘密の質問
		String Secret_Answer = request.getParameter("secret_answer");//秘密の質問の答え
		String Job = request.getParameter("job");
		
		boolean NoName = false;
		if(Sei_Kanji == null || Sei_Kanji.equals("") || Sei_Kanji.length() > 15 || Mei_Kanji == null || Mei_Kanji.equals("") || Mei_Kanji.length() > 15 ||
		Sei_Kana == null || Sei_Kana.equals("") || Sei_Kana.length() > 15 || Mei_Kana == null || Mei_Kana.equals("") || Mei_Kana.length() > 15){//本名が一部でも未入力の場合はフラグON
			NoName = true;
		}else{
			//Sei_Kanji = HttpUtility.escapeHTML(Sei_Kanji);//特殊文字チェック
			//Mei_Kanji = HttpUtility.escapeHTML(Mei_Kanji);
			//Sei_Kana = HttpUtility.escapeHTML(Sei_Kana);
			//Mei_Kana = HttpUtility.escapeHTML(Mei_Kana);
		}
		
		boolean NoBirthday = false;
		if(BirthYear == null || BirthYear.equals("") || BirthYear.length() != 4 || BirthTsuki == null || BirthTsuki.equals("") || BirthTsuki.length() != 2 || BirthDay == null || BirthDay.equals("") || BirthDay.length() != 2 || (!(HttpUtility.digitCheck(BirthYear))) || (!(HttpUtility.digitCheck(BirthTsuki))) || (!(HttpUtility.digitCheck(BirthDay)))){
			NoBirthday = true;//System.out.println(BirthYear+"-"+BirthTsuki+"-"+BirthDay);//生年月日が未入力、または不正な値である時はフラグON
		}else{
			//BirthYear = HttpUtility.escapeHTML(BirthYear);//特殊文字チェック
			//BirthDay = HttpUtility.escapeHTML(BirthDay);
		}
		
		boolean NoAddress = false;
		/* //住所・電話番号は任意
		if(AddressNo == null || AddressNo.equals("") || Jyusyo == null || Jyusyo.equals("") || Telephone_No == null || Telephone_No.equals("")){
			NoAddress = true;//住所が一部分でも未入力の場合はフラグON
		}else{
			//AddressNo = HttpUtility.escapeHTML(AddressNo);//特殊文字チェック
			//Jyusyo = HttpUtility.escapeHTML(Jyusyo);
			//Telephone_No = HttpUtility.escapeHTML(Telephone_No);
		}
		*/
		if(Pref.isEmpty() == true || Pref.equals("選択してください")){
			NoAddress = true;
		}
		boolean NoSecret = false;
		if(Secret_Question == null || Secret_Question.equals("") || Secret_Answer == null || Secret_Answer.equals("")){
			NoSecret = true;//秘密の質問・答えが未入力の場合はフラグON
		}else{
			//Secret_Question = HttpUtility.escapeHTML(Secret_Question);
			//Secret_Answer = HttpUtility.escapeHTML(Secret_Answer);
		}
		
		boolean NoJob = false;
		if(Job == null || Job.equals("")){
			NoJob = true;
		}
		
		String NGWord = null;
		if(HttpUtility.NG_Word_Check(Sei_Kanji) != null){
			NGWord = HttpUtility.NG_Word_Check(Sei_Kanji);
		}else if(HttpUtility.NG_Word_Check(Mei_Kanji) != null){
			NGWord = HttpUtility.NG_Word_Check(Mei_Kanji);
		}else if(HttpUtility.NG_Word_Check(Sei_Kana) != null){
			NGWord = HttpUtility.NG_Word_Check(Sei_Kana);
		}else if(HttpUtility.NG_Word_Check(Mei_Kana) != null){
			NGWord = HttpUtility.NG_Word_Check(Mei_Kana);
		}else if(HttpUtility.NG_Word_Check(BirthYear) != null){
			NGWord = HttpUtility.NG_Word_Check(BirthYear);
		}else if(HttpUtility.NG_Word_Check(BirthTsuki) != null){
			NGWord = HttpUtility.NG_Word_Check(BirthTsuki);
		}else if(HttpUtility.NG_Word_Check(BirthDay) != null){
			NGWord = HttpUtility.NG_Word_Check(BirthDay);
		}else if(HttpUtility.NG_Word_Check(Sex) != null){
			NGWord = HttpUtility.NG_Word_Check(Sex);
		}else if(HttpUtility.NG_Word_Check(AddressNo) != null){
			NGWord = HttpUtility.NG_Word_Check(AddressNo);
		}else if(HttpUtility.NG_Word_Check(Pref) != null){
			NGWord = HttpUtility.NG_Word_Check(Pref);
		}else if(HttpUtility.NG_Word_Check(Jyusyo) != null){
			NGWord = HttpUtility.NG_Word_Check(Jyusyo);
		}else if(HttpUtility.NG_Word_Check(Telephone_No) != null){
			NGWord = HttpUtility.NG_Word_Check(Telephone_No);
		}else if(HttpUtility.NG_Word_Check(Secret_Question) != null){
			NGWord = HttpUtility.NG_Word_Check(Secret_Question);
		}else if(HttpUtility.NG_Word_Check(Secret_Answer) != null){
			NGWord = HttpUtility.NG_Word_Check(Secret_Answer);
		}else if(HttpUtility.NG_Word_Check(Job) != null){
			NGWord = HttpUtility.NG_Word_Check(Job);
		}
		
		if(NoName || NoBirthday || NoAddress || NoSecret || NGWord != null){//未入力の欄が一か所でもある、もしくは禁止ワードを検出した場合は修正用ページへフォワード
			K_Touroku_TO WrongData = null;
			WrongData = new K_Touroku_TO(Sei_Kanji, Mei_Kanji, Sei_Kana, Mei_Kana, BirthYear, BirthTsuki, BirthDay, Sex, AddressNo, Pref, Jyusyo, Telephone_No,
					Secret_Question, Secret_Answer, NoName, NoBirthday, NoAddress, NoSecret, Job, NoJob, NGWord);
			
			session.setAttribute("wrongdata_p2", WrongData);
			NextPage = "/Shinki_Nyukai_Lv2/Kaiintouroku_p2_syusei.jsp";
		}else{
			K_Touroku_TO Tourokudata_page2 = null;//すべて入力済みの場合は確認用ページへフォワード
			Tourokudata_page2 = new K_Touroku_TO(Sei_Kanji, Mei_Kanji, Sei_Kana, Mei_Kana, BirthYear, BirthTsuki, BirthDay, Sex, AddressNo, Pref, Jyusyo, Telephone_No,
					Secret_Question, Secret_Answer, Input_Id, Job);
			session.setAttribute("tourokudata_p2", Tourokudata_page2);
			NextPage = "/Shinki_Nyukai_Lv2/Kaiin_SaisyuKakunin.jsp";
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-003");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
