package event;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.MailSendBean;

/**
 * Servlet implementation class Event_Toiawase
 */
public class Event_Toiawase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event_Toiawase() {
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
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "Event-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		EventData_DAO dao = new EventData_DAO();
		Calendar Now = new GregorianCalendar();
		int Result = 0;
		boolean mailerror = false;
		try{
		String Mailaddress = request.getParameter("mailaddress");
		String Naiyou = request.getParameter("naiyou");
		EventData_TO EventData = (EventData_TO)session.getAttribute("eventsyousai");
		
		if(Mailaddress.isEmpty() == false && (!(Mailaddress.equals("入力してください"))) && Naiyou.isEmpty() == false && (!(Naiyou.equals("入力してください")))){
				MailSendBean Send = new MailSendBean();
				
				String Smtphost = "mail.gamereporters.info";
				//String Smtphost = "ybbsmtp.mail.yahoo.co.jp";
				String From = "GameMaster@mail.gamereporters.info";
				//String From = "xysyr908@ybb.ne.jp";
				String Personal = "G-PROjectイベント受付サーバ";
				String Subject = "大会問い合わせの回答依頼";
				String Body = "G-PROjectイベント受付サーバです。この度はG-PROjectをご利用いただきありがとうございます。\n" + 
				"ご登録いただいたイベントに対しユーザーから当社サーバに問い合わせがありました。内容を送信させていただきますので、問い合わせ元のユーザーに対し" +
				"至急ご回答をお願いいたします。\n\n" +
				"問い合わせを行ったユーザーのメールアドレス:" + Mailaddress + "\n" +
				"問い合わせ内容：\n" + Naiyou;
				
				Send.setSmtpHost(Smtphost);
				Send.setFrom(From);
				Send.setPersonal(Personal);
				Send.setTo(EventData.getToiawasesaki());
				Send.setSubject(Subject);
				Send.setBody(Body);
				
				mailerror = Send.send();
				if(mailerror == true){
					Result = 3;
				}else{
					System.out.println("HIT!");
				MailSendBean Send2 = new MailSendBean();
				String Smtphost2 = "mail.gamereporters.info";
				//String Smtphost = "ybbsmtp.mail.yahoo.co.jp";
				String From2 = "GameMaster@mail.gamereporters.info";
				//String From = "xysyr908@ybb.ne.jp";
				String Personal2 = "G-PROjectイベント受付サーバ";
				String Subject2 = "大会問い合わせ控え";
				String Body2 = "G-PROjectイベント受付サーバです。この度はお問い合わせいただきありがとうございます。\n" + 
				"イベントの主催者に対しご入力いただいた内容を送信いたしました。後ほど主催者から直接回答させていただきますのでしばらくお待ちください。\n\n" +
				"問い合わせ内容：\n" + Naiyou;
				
				Send2.setSmtpHost(Smtphost2);
				Send2.setFrom(From2);
				Send2.setPersonal(Personal2);
				Send2.setTo(Mailaddress);
				Send2.setSubject(Subject2);
				Send2.setBody(Body2);
				
				mailerror = Send2.send();
				if(mailerror == true){
					Result = 4;
				}else{
				Result = dao.Toiawase_Touroku(EventData, Mailaddress, Naiyou, Now, Result);
				}
			}
			
		}else{
			Result = 2;
		}
		
		session.setAttribute("result", Result);
		NextPage = "/free_area/Event/Event_Toiawase_Result.jsp";
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Event-202");
		NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
	}
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
