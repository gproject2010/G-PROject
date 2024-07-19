package k_jyouhou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.MailSendBean;

/**
 * Servlet implementation class New_Kaiin_Maker
 */
public class New_Kaiin_Maker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public New_Kaiin_Maker() {
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
		// 登録データをまとめてDAOに登録を依頼
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "KData-005");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		K_Touroku_TO NyukaiData = null;
		
		try{
		//必要なデータをsessionオブジェクトから抽出
		K_Touroku_TO P1Data = (K_Touroku_TO) session.getAttribute("tourokudata_p1");//Kaiin_Touroku_Kakunin_p1.javaから
		K_Touroku_TO P2Data = (K_Touroku_TO) session.getAttribute("tourokudata_p2");//Kaiin_Touroku_Kakunin_p2.javaから
		K_Touroku_TO Mail = (K_Touroku_TO) session.getAttribute("mailaddress");//Kaiin_Touroku_Kakunin_p0.javaから
		
		String Login_Name = P1Data.getLogin_Name();
		String Kibou_Id = P1Data.getKibou_Id();
		String Kibou_Password = P1Data.getKibou_Password();
		String Mail_Address = Mail.getMail_Address();
		String Keitai_Address = P1Data.getKeitai_Address();
		String Sei_Kanji = P2Data.getSei_Kanji();
		String Mei_Kanji = P2Data.getMei_Kanji();
		String Sei_Kana = P2Data.getSei_Kana();
		String Mei_Kana = P2Data.getMei_Kana();
		String BirthYear = P2Data.getBirthYear();
		String BirthTsuki = P2Data.getBirthTsuki();
		String BirthDay = P2Data.getBirthDay();
		String AddressNo = P2Data.getAddressNo();
		String Pref = P2Data.getPref();
		String Jyusyo = P2Data.getJyusyo();
		String Telephone_No = P2Data.getTelephone_No();
		String Secret_Question = P2Data.getSecret_Question();
		String Secret_Answer = P2Data.getSecret_Answer();
		String Job = P2Data.getJob();
		
		String OldId = Mail.getKari_Id();
		
		NyukaiData = new K_Touroku_TO(Login_Name, Kibou_Id, Kibou_Password, Mail_Address, Keitai_Address, Sei_Kanji, Mei_Kanji, Sei_Kana, Mei_Kana, BirthYear, BirthTsuki, BirthDay, 
				AddressNo, Pref, Jyusyo, Telephone_No, Secret_Question, Secret_Answer, Job, OldId);//まとめて1つのオブジェクトに格納
		
		K_Touroku_DAO todao = new K_Touroku_DAO();//DBへの登録を依頼
		boolean Touroku_E = todao.K_Touroku(NyukaiData);
		
		if(Touroku_E == false){
			MailSendBean Send = new MailSendBean();
			String PassCount = "";
			for(int i=0; i < Kibou_Password.length(); i++){
				PassCount = PassCount + "*";
			}

			String Smtphost = "mail.gamereporters.info";
			//String Smtphost = "ybbsmtp.mail.yahoo.co.jp";
			String From = "Tea-N@mail.gamereporters.info";
			//String From = "xysyr908@ybb.ne.jp";
			String Personal = "G-PROject登録受付サーバ";
			String Subject = "G-PROject本登録のお知らせ";
			String Body =  "G-PROject登録受付サーバです。このたびはG-PROjectをご利用いただきありがとうございます。\n" +
					"サイトへの登録は以上で完了となります。設定いただいたG-PRO IDとパスワードでログインし、G-PROjectをお楽しみください!\n\n" +
					"現在設定されているG-PRO ID:" + Kibou_Id + "\n\n現在設定されているパスワード:" + PassCount + "\n\n" +
							"G-PROjectトップページ→https://www.gamereporters.info/G-pro_Service/Contents_Data_Load \n" +
							"※このメールは送信専用のメールアドレスから送信されています。返信いただいても回答しかねますのでご注意ください。";
			
			Send.setSmtpHost(Smtphost);
			Send.setFrom(From);
			Send.setPersonal(Personal);
			Send.setTo(Mail_Address);
			Send.setSubject(Subject);
			Send.setBody(Body);
			
			boolean mailerror = Send.send();
			
			request.setAttribute("mailerror", mailerror);
			
			session.setAttribute("id", Kibou_Id);
			session.setAttribute("passcount", PassCount);
			session.setAttribute("mailaddress", Mail_Address);
			
			NextPage = "/Shinki_Nyukai_Lv2/Kaiin_Touroku_Kanryou.jsp";
		}else{
			session.setAttribute("errcode", "KData-305");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-005");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
