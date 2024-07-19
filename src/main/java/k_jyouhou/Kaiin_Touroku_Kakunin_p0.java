package k_jyouhou;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.MailSendBean;
import ninsyou.N_jyouhou_DAO;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Servlet implementation class Kaiin_Touroku_Kakunin_p0
 */
public class Kaiin_Touroku_Kakunin_p0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kaiin_Touroku_Kakunin_p0() {
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
		// 仮ID、仮パスワードの発行処理
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		
		session.setAttribute("errcode", "KData-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean Mail_jyufuku = false;//メールアドレス重複フラグ
		boolean tourokuerror = false;//登録エラーフラグ
		try{
		String Mailaddress = request.getParameter("mailaddress");//Kaiintouroku_p0で入力されたメールアドレス
		//HttpUtility.escapeHTML(Mailaddress);//特殊文字チェック
		
		N_jyouhou_DAO tdao = new N_jyouhou_DAO();//メールアドレス重複確認
		Mail_jyufuku = tdao.Mail_jyufuku(Mailaddress);
		
		if(Mail_jyufuku == false){//重複がなければ仮ID、仮パスワード発行
		
		//int KariId_i = (int) Math.ceil(Math.random() * 100000000);//仮ID、仮パスワードはランダムに発行された数字8ケタ
		//String KariId = Integer.toString(KariId_i);//文字列に変換
			
			String KariId = RandomStringUtils.randomAlphabetic(10);
		//int KariPassword_i = (int) Math.floor(Math.random() * 100000000);
		//String KariPassword = Integer.toString(KariPassword_i);
			
			String KariPassword = RandomStringUtils.randomAlphabetic(10);
		
		K_Touroku_TO Karininsyou = new K_Touroku_TO(Mailaddress, KariId, KariPassword);
		
		tourokuerror = tdao.Karininsyou(Karininsyou);//DBに会員情報を作成
		if(tourokuerror == true){
			session.setAttribute("tourokuerror", "falied");
		}else{
		
		session.setAttribute("karijyouhou", Karininsyou);
		/*
		String from = "g_produce2012-daihyou@yahoo.co.jp";
		String personal = "G-PROjectシステムサーバ";
		/*String cc = null;
		String bcc = null;
		String smtphost = "ybbsmtp.mail.yahoo.co.jp";
		String mailer = "G-PROjectのサーバ";
		
		Properties props = System.getProperties();
		props.put("mail.smtp.host", smtphost);
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", true);
		
		Session s = Session.getDefaultInstance(props, null);
		
		MimeMessage msg = new MimeMessage(s);
		msg.setFrom(new InternetAddress(from,personal));
		msg.addRecipient(Message.RecipientType.TO, new InternetAddress(Mailaddress));
		/*if(cc != null){
			msg.addRecipient(Message.RecipientType.CC, new InternetAddress(cc));
		}
		if(bcc != null){
			msg.addRecipient(Message.RecipientType.BCC, new InternetAddress(bcc));
		}
		msg.setSubject("仮ID/仮パスワードのお知らせ");
		msg.setHeader("X-Mailer", mailer);
		msg.setSentDate(new Date());
		msg.setText( "メールアドレスを確認しました。G-PROjectにログインし、残りの情報を登録してください\n仮ID:" + KariId_i + "\n仮パスワード:" + KariPassword_i + 
    "\nG-Projectトップページ→http://localhost/G-pro_Service/AuthenticationController \n※仮登録はこのメールが送信された日の23時59分まで有効です。それを過ぎると登録が破棄されますのでご注意ください。");
		
		Transport.send(msg);*/
		
		MailSendBean Send = new MailSendBean();
		
		String Smtphost = "192.168.12.81";
		//String Smtphost = "ybbsmtp.mail.yahoo.co.jp";
		String From = "Tea-N@mail.gamereporters.info";
		//String From = "xysyr908@ybb.ne.jp";
		String Personal = "G-PROject登録受付サーバ";
		String Subject = "仮ID/仮パスワードのお知らせ";
		String Body =  "G-PROject登録受付サーバです。このたびはG-PROjectにご登録いただきありがとうございます。\n" +
				"メールアドレスを確認しましたので下記の仮ID・仮パスワードでG-PROjectにログインし、プロフィールを登録してください。\n\n" +
				"仮ID:" + KariId + "\n\n仮パスワード:" + KariPassword + "\n\n" +
						"G-PROjectトップページ→https://www.gamereporters.info/G-pro_Service/AuthenticationController \n" +
						"※1:仮登録は次のサーバメンテナンス(毎日AM7:00)が行われるまで有効です。それを過ぎると登録が破棄されますのでご注意ください。\n" +
						"※2:このメールは送信専用のメールアドレスから送信されています。返信いただいても回答しかねますのでご注意ください。";
		
		Send.setSmtpHost(Smtphost);
		Send.setFrom(From);
		Send.setPersonal(Personal);
		Send.setTo(Mailaddress);
		Send.setSubject(Subject);
		Send.setBody(Body);
		
		boolean mailerror = Send.send();
		if(mailerror == false){
			session.setAttribute("tourokuerror", "success");
		NextPage = "/Shinki_Nyukai_Lv1/Kaiintouroku_p0_sousin.jsp";//設定されたメールアドレスに仮ID、仮パスワードを送信
		}else{
			session.setAttribute("tourokuerror", "failed");
			NextPage = "/Shinki_Nyukai_Lv1/Kaiintouroku_p0_sousin.jsp";
		}
		}
		}else{
			NextPage = "/Shinki_Nyukai_Lv1/Kaiintouroku_p0_syusei.html";
		}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "KData-002");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
