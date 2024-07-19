package k_jyouhou;

//import inputUtility.HttpUtility;

import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ninsyou.N_jyouhou_TO;

/**
 * Servlet implementation class Ninsyou_Henkou_Kakunin
 */
public class Ninsyou_Henkou_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ninsyou_Henkou_Kakunin() {
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
		N_jyouhou_TO Nin_BeforeData = (N_jyouhou_TO)session.getAttribute("nin_jyouhou");
		K_jyouhou_TO Kaiin_BeforeData = (K_jyouhou_TO)session.getAttribute("mail");
		session.setAttribute("errcode", "KData-007");
		String NextPage = "/passed/Error_Gamen.jsp";
		String NGWord = null;
		try{
		String Login_Name = request.getParameter("login_name");//プレイヤーネーム
		String Kibou_Id = request.getParameter("kibou_id");//希望ID
		String new_Password = request.getParameter("new_password");//新パスワード
		String Kakunin_Password = request.getParameter("kakunin_password");//新パスワード(確認)
		String Mail_Address = request.getParameter("mailaddress");//新PCメールアドレス
		String Keitai_Address = request.getParameter("keitaiaddress");//新携帯メールアドレス
		
		boolean Name_jyufuku = false;//プレイヤーネームの未入力チェック
		if(Login_Name == null || Login_Name.equals("") || Login_Name.length() > 12){
			Login_Name = Kaiin_BeforeData.getLogin_name();
		}else{
			//Login_Name = HttpUtility.escapeHTML(Login_Name);
		}
		
		boolean Id_jyufuku = false;//IDの未入力チェック
		if(Kibou_Id == null || Kibou_Id.equals("") || Kibou_Id.length() < 8){
			Kibou_Id = Nin_BeforeData.getK_Id();
		}else{
			//Kibou_Id = HttpUtility.escapeHTML(Kibou_Id);
		}
		
		boolean Mail_jyufuku = false;//PCメールアドレスの未入力チェック
		if(Mail_Address == null || Mail_Address.equals("")){
			Mail_Address = Kaiin_BeforeData.getmailaddress();
		}else{
			//Mail_Address = HttpUtility.escapeHTML(Mail_Address);
		}
		
		boolean Keitai_jyufuku = false;//携帯メールアドレスの未入力チェック
		if(Keitai_Address == null || Keitai_Address.equals("")){
			Keitai_Address = Kaiin_BeforeData.getkeitaiaddress();
		}else{
			//Keitai_Address = HttpUtility.escapeHTML(Keitai_Address);
		}
		
		K_jyouhou_DAO dao = new K_jyouhou_DAO();
		K_Touroku_TO Tourokudata1 = dao.JyufukuKakunin(Login_Name, Kibou_Id, Mail_Address, Keitai_Address);
		/*if(Tourokudata1.size() > 1){
			session.setAttribute("errcode", "KData-107");
			NextPage = "/passed/Error_Gamen.jsp";
		}else{
		*/
		if(Login_Name == null || Login_Name.equals("") || (!(Login_Name.equals(Kaiin_BeforeData.getLogin_name()) && Tourokudata1.getLogin_name_res() == 1)) && Tourokudata1.getLogin_name_res() != 0){
			Name_jyufuku = true;//プレイヤーネームの重複・不正値チェック
		}else if(HttpUtility.NG_Word_Check(Login_Name) != null){
				NGWord = HttpUtility.NG_Word_Check(Login_Name);
			//System.out.println(Tourokudata1.getLogin_name_res());
		}
		if(Kibou_Id == null || Kibou_Id.equals("") || Kibou_Id.length() < 8 || Kibou_Id.length() > 16 || (!(HttpUtility.digitAlphabetCheck(Kibou_Id))) || (!(Kibou_Id.equals(Nin_BeforeData.getK_Id()) && Tourokudata1.getTouroku_id_res() == 1)) && Tourokudata1.getTouroku_id_res() != 0){
			Id_jyufuku = true;//IDの重複・不正値チェック
		}	
		if(Mail_Address == null || Mail_Address.equals("") || (!(Mail_Address.equals(Kaiin_BeforeData.getmailaddress()) && Tourokudata1.getMailaddress_res() == 1)) && Tourokudata1.getMailaddress_res() != 0){
			Mail_jyufuku = true;//PCメールアドレスの重複・不正値チェック
		}
		if(Keitai_Address == null || Keitai_Address.equals("")){
			Keitai_Address = "empty";
		}else if((!(Keitai_Address.equals(Kaiin_BeforeData.getkeitaiaddress()) && Tourokudata1.getKeitai_address_res() == 1)) && Tourokudata1.getKeitai_address_res() != 0){
			Keitai_jyufuku = true;//携帯メールアドレスの重複・不正値チェック
		}
		
		boolean Wrong_Password = false;
		 if(new_Password == null || new_Password.equals("") || (!(HttpUtility.digitAlphabetCheck(new_Password))) || new_Password.length() > 16 || new_Password.length() <  8 || Kakunin_Password == null || Kakunin_Password.equals("") || Kakunin_Password.length() > 16 || Kakunin_Password.length() < 8){
			Wrong_Password = true;//パスワードの不正値チェック
			
		}else if(new_Password.equals(Kakunin_Password)){
			//new_Password = HttpUtility.escapeHTML(new_Password);
			//Kakunin_Password = HttpUtility.escapeHTML(Kakunin_Password);
			
		}else{
			Wrong_Password = true;
		}
		
		if(Name_jyufuku || Id_jyufuku || Mail_jyufuku || Keitai_jyufuku || Wrong_Password || NGWord != null){
			K_Touroku_TO WrongData = null;//不備がある場合は修正用ページへフォワード
			WrongData = new K_Touroku_TO(Login_Name, Kibou_Id, new_Password, Kakunin_Password, Mail_Address, Keitai_Address, Name_jyufuku, Id_jyufuku, Mail_jyufuku, Keitai_jyufuku, Wrong_Password, NGWord);
			session.setAttribute("wrongdata_henkou", WrongData);
			NextPage = "/passed/Ninsyou_Henkou_Syusei.jsp";
		}else{
			K_Touroku_TO Tourokudata_page1 = null;//問題なければ確認用ページへフォワード
			int Password_length = new_Password.length();
			Tourokudata_page1 = new K_Touroku_TO(Login_Name, Kibou_Id, new_Password, Mail_Address, Keitai_Address, Password_length);
			session.setAttribute("n_henkoudata", Tourokudata_page1);
			NextPage = "/passed/Ninsyou_Henkou_Kakunin.jsp";
		}
		//}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-007");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}

