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
 * Servlet implementation class Kakunin_Mail_Saisou
 */
public class Kakunin_Mail_Saisou extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kakunin_Mail_Saisou() {
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
		HttpSession session = request.getSession(true);
		MailSendBean Send = new MailSendBean();
		String NextPage = "/passed/Error_Gamen.jsp";
		
		try{
		
		String Kaiin_Id = (String)session.getAttribute("id");
		String PassCount = (String)session.getAttribute("passcount");
		String MailAddress = (String)session.getAttribute("mailaddress");
		
		String Smtphost = "mail.gamereporters.info";
		String From = "GameMaster@mail.gamereporters.info";
		String Personal = "G-PROject登録受付サーバ";
		String Subject = "G-PROject本登録のお知らせ(再送)";
		String Body =  "G-PROject登録受付サーバです。このたびはG-PROjectをご利用いただきありがとうございます。\n" +
				"サイトへの登録は以上で完了となります。設定いただいたG-PRO IDとパスワードでログインし、G-PROjectをお楽しみください!\n\n" +
				"現在設定されているG-PRO ID:" + Kaiin_Id + "\n\n現在設定されているパスワード:" + PassCount + "\n\n" +
						"G-PROjectトップページ→https://www.gamereporters.info/G-pro_Service/AuthenticationController \n" +
						"※このメールは送信専用のメールアドレスから送信されています。返信いただいても回答しかねますのでご注意ください。";
		
		Send.setSmtpHost(Smtphost);
		Send.setFrom(From);
		Send.setPersonal(Personal);
		Send.setTo(MailAddress);
		Send.setSubject(Subject);
		Send.setBody(Body);
		
		boolean mailerror = Send.send();
		
		request.setAttribute("mailerror", mailerror);
		
		NextPage = "/Shinki_Nyukai_Lv2/Kaiin_Touroku_Kanryou.jsp";
	
}catch(Exception e){
	e.printStackTrace();
	session.setAttribute("errcode", "KData-006");
	NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
}
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
}

}
