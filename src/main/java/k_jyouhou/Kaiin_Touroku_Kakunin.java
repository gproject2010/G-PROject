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
 * Servlet implementation class Kaiin_Touroku_Kakunin
 */
public class Kaiin_Touroku_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kaiin_Touroku_Kakunin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "KData-004");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean Name_jyufuku = false;//プレイヤーネームが未入力
		boolean Id_jyufuku = false;//IDが未入力
		boolean Keitai_jyufuku = false;//携帯メールアドレスが未入力
		boolean Wrong_Password = false;
		
		//N_jyouhou_TO Nin_BeforeData = (N_jyouhou_TO)session.getAttribute("nin_jyouhou");
		//K_jyouhou_TO Kaiin_BeforeData = (K_jyouhou_TO)session.getAttribute("mail");
		try{
		String Login_Name = request.getParameter("login_name");//希望プレイヤーネーム
		String Kibou_Id = request.getParameter("kibou_id");//希望ID
		String Kibou_Password = request.getParameter("kibou_password");//希望パスワード
		String Kakunin_Password = request.getParameter("kakunin_password");//パスワード(再入力)
		String Keitai_Address = request.getParameter("keitaiaddress");//携帯メールアドレス
		K_Touroku_TO Mail_Address_res = (K_Touroku_TO) session.getAttribute("mailaddress");//PCメールアドレスへの参照
		String Mail_Address = Mail_Address_res.getMail_Address();//PCメールアドレス
		
		
		if(Login_Name == null || Login_Name.equals("")){//プレイヤーネームが未入力の場合はワイルドカードを付加
			Name_jyufuku = true;
			Login_Name = "*";
		}else{
			//Login_Name = HttpUtility.escapeHTML(Login_Name);//特殊文字チェック
		}
		
		if(Kibou_Id == null || Kibou_Id.equals("")){//IDが未入力の場合はワイルドカードを付加
			Id_jyufuku = true;
			Kibou_Id = "*";
		}else{
			//Kibou_Id = HttpUtility.escapeHTML(Kibou_Id);//特殊文字チェック
		}
		
		if(Keitai_Address == null || Keitai_Address.equals("")){
			Keitai_Address = "*";//携帯メールアドレスが未入力の場合はワイルドカードを付加
		}else{
			//Keitai_Address = HttpUtility.escapeHTML(Keitai_Address);//特殊文字チェック
		}
		
		
		K_jyouhou_DAO dao = new K_jyouhou_DAO();//DAOに入力情報を渡して重複がないか検索を依頼
		K_Touroku_TO Tourokudata1 = dao.JyufukuKakunin(Login_Name, Kibou_Id, Mail_Address, Keitai_Address);
		//System.out.println(Tourokudata1.getKeitai_address_res());
		/*if(!(Tourokudata1 == null)){
			session.setAttribute("errcode", "KData-104");
			NextPage = "/passed/Error_Gamen.jsp";
		}else{
		*/
		if((Tourokudata1.getLogin_name_res() != 0) || (Login_Name == null) || (Login_Name.equals("")) || (Login_Name.length() > 12) /*|| (!(Login_Name.equals(Kaiin_BeforeData.getLogin_name())) || (Tourokudata1.get(0).getLogin_name_res() > 1) || (Tourokudata1.get(0).getLogin_name_res() > 0))*/){
			Name_jyufuku = true;//System.out.println("NAME"+Name_jyufuku);//プレイヤーネームが不正、または重複している場合フラグON
		}
		if((Tourokudata1.getTouroku_id_res() != 0) || Kibou_Id == null || Kibou_Id.equals("") || Kibou_Id.length() < 8 || Kibou_Id.length() > 16 || (HttpUtility.digitAlphabetCheck(Kibou_Id) == false)/*|| (Kibou_Id.equals(Nin_BeforeData.getK_Id())) && Tourokudata1.get(0).getTouroku_id_res() > 1) || Tourokudata1.get(0).getTouroku_id_res() > 0*/){
			Id_jyufuku = true;//System.out.println("ID"+Id_jyufuku);//IDが不正、または重複している場合フラグON
		}	
		if((!(Keitai_Address == null || Keitai_Address.equals("") || Keitai_Address.equals("*"))) && ((Tourokudata1.getKeitai_address_res() != 0) || /*(Keitai_Address.equals("")) || (Keitai_Address.length() < 8) ||*/ (Keitai_Address.length() > 70) || (!(HttpUtility.digitAlphabetCheck(Keitai_Address))))){
			Keitai_jyufuku = true;//System.out.println("KEI"+Keitai_jyufuku+(!(HttpUtility.digitAlphabetCheck(Keitai_Address))));//携帯メールアドレスが、または重複している場合フラグON
		}
		
		 if(Kibou_Password == null || Kibou_Password.equals("") || Kibou_Password.length() > 16 || Kibou_Password.length() < 8 || Kakunin_Password == null || Kakunin_Password.equals("") || Kakunin_Password.length() > 12 || Kakunin_Password.length() < 8 || (!(HttpUtility.digitAlphabetCheck(Kakunin_Password))) || (!(Kibou_Password.equals(Kakunin_Password))) || HttpUtility.digitAlphabetCheck(Kibou_Password) == false ||
				 (!(Kibou_Password.equals(Kakunin_Password)))){
			Wrong_Password = true;//System.out.println("PASS"+Wrong_Password);//パスワードが不正な値の場合フラグON(他のデータとかぶってもOK)
			
		}else if(Kibou_Password.equals(Kakunin_Password)){//パスワードが有効の場合特殊文字チェック
			//Kibou_Password = HttpUtility.escapeHTML(Kibou_Password);
			//Kakunin_Password = HttpUtility.escapeHTML(Kakunin_Password);
			
		}/*else{
			Wrong_Password = true;//エラーが発生した場合フラグON
		}*/
		//}
		 String NGWord = null;
		 if((HttpUtility.NG_Word_Check(Login_Name) != null)){
			 NGWord = HttpUtility.NG_Word_Check(Login_Name);
		 }else if(HttpUtility.NG_Word_Check(Kibou_Id) != null){
			 NGWord = HttpUtility.NG_Word_Check(Kibou_Id);
		 }else if(HttpUtility.NG_Word_Check(Kibou_Password) != null){
			 NGWord = HttpUtility.NG_Word_Check(Kibou_Password);
		 } //禁止ワードチェックを行い、引っかかった場合フラグON
		
		if(Name_jyufuku || Id_jyufuku || Keitai_jyufuku || Wrong_Password || NGWord != null){
			K_Touroku_TO WrongData = null;//データに不備がある場合は修正用ページにフォワード
			WrongData = new K_Touroku_TO(Login_Name, Kibou_Id, Kibou_Password, Kakunin_Password, Mail_Address, Keitai_Address, Name_jyufuku, Id_jyufuku, Keitai_jyufuku, Wrong_Password, NGWord);
			session.setAttribute("wrongdata_p1", WrongData);
			NextPage = "/Shinki_Nyukai_Lv1/Kaiintouroku_p1_syusei.jsp";
			
		}else{
			K_Touroku_TO Tourokudata_page1 = null;//登録可能な場合はプレイヤー情報の入力ページにフォワード
			int Password_length = Kibou_Password.length();
			Tourokudata_page1 = new K_Touroku_TO(Login_Name, Kibou_Id, Kibou_Password, Mail_Address, Keitai_Address, Password_length);
			session.setAttribute("tourokudata_p1", Tourokudata_page1);
			NextPage = "/Shinki_Nyukai_Lv2/Kaiintouroku_p2_nyuryoku.html";
			
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-003");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
