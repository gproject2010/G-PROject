package event;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mail.MailSendBean;

/**
 * Servlet implementation class Event_Sanka_Upload
 */
public class Event_Sanka_Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event_Sanka_Upload() {
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
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "Event-005");
		String NextPage = "/free_area/Error_Gamen.jsp";
		int TourokuError = 1;
		
		Calendar Now = new GregorianCalendar();
		
		EventData_TO SankasyaData = new EventData_TO();
		EventData_TO Event_Syousai = new EventData_TO();
		EventData_TO FormData = new EventData_TO();
		
		EventData_DAO dao = new EventData_DAO();
		
		try{
		
		SankasyaData = (EventData_TO)session.getAttribute("sankasyadata");
		Event_Syousai = (EventData_TO)session.getAttribute("eventsyousai");
		FormData = (EventData_TO)session.getAttribute("formdata");
		
		Random rnd = new Random();
		int ran = rnd.nextInt(100000000);
		
		TourokuError = dao.Sankasya_Touroku(Event_Syousai, SankasyaData, ran, Now);
		
		if(TourokuError == 0){
			MailSendBean Send = new MailSendBean();
			
			String Smtphost = "mail.gamereporters.info";
			//String Smtphost = "ybbsmtp.mail.yahoo.co.jp";
			String From = "GameMaster@mail.gamereporters.info";
			//String From = "xysyr908@ybb.ne.jp";
			String Personal = "G-PROjectイベント受付サーバ";
			String Subject = "大会参加登録控え";
			String Body = "G-PROjectイベント受付サーバです。この度は参加登録いただきありがとうございます。\n" + 
			"このメールが参加登録の証明となりますので、プリントアウトするなどしてイベント終了まで必ず保管してください。\n" + 
					"(主催者から提示を求められることがあります)\n" + 
			"\n"
			 + "イベントコード:" + Event_Syousai.getEventCode() + "\n"
			 + "イベント名称:" + Event_Syousai.getEventName() + "\n"
			 + "\n"
			 + "エントリーネーム:" + SankasyaData.getEntry_Name() + "(読み:" + SankasyaData.getEntry_Name_Yomi() + ")\n"
			 + "参加者ID:" + ran + "\n"
			 + "在住都道府県:" + SankasyaData.getPref() + "\n";
			if(FormData.getKoumokuList_A().length > 0){
			Body = Body + "\n" + FormData.getKoumokuList_A()[0] + ":" + SankasyaData.getKoumoku1();
			}
			if(FormData.getKoumokuList_A().length > 1){
				Body = Body + "\n" + FormData.getKoumokuList_A()[1] + ":" + SankasyaData.getKoumoku2();
				}
			if(FormData.getKoumokuList_A().length > 2){
				Body = Body + "\n" + FormData.getKoumokuList_A()[2] + ":" + SankasyaData.getKoumoku3();
				}
			if(FormData.getKoumokuList_A().length > 3){
				Body = Body + "\n" + FormData.getKoumokuList_A()[3] + ":" + SankasyaData.getKoumoku4();
				}
			if(FormData.getKoumokuList_A().length > 4){
				Body = Body + "\n" + FormData.getKoumokuList_A()[4] + ":" + SankasyaData.getKoumoku5();
				}
			
			if(Event_Syousai.getOption_Mode() == 2){//イベントへの特設ページへのリンクを設定する場合
				Body = Body + "\n\n" + "クリックするとイベントの特設ページに移動できます↓\n"
			+ "イベント特設ページURL:\n" + Event_Syousai.getSystem_URL();
			}else if(Event_Syousai.getOption_Mode() == 3){//イベントの主催者のHPへリンクを設定する場合
				Body = Body + "\n\n" + "クリックするとイベント主催者のHPに移動できます↓\n"
			+ "イベント主催者URL:\n" + Event_Syousai.getSystem_URL();
			}else if(Event_Syousai.getOption_Mode() == 4){//イベント専用Webシステムへの自動ログイン機能を設定する場合
				Body = Body + "\n\n" + "クリックするとイベント参加者専用のページに移動できます↓\n"
			+ "イベント参加者専用ページURL:\n" + Event_Syousai.getSystem_URL() + "?sankasyaid=" + ran;
			}
			
			Body = Body + "\n" + "G-PROjectトップページ→https://www.gamereporters.info/G-pro_Service/AuthenticationController \n" +
					"※このメールは送信専用のメールアドレスから送信されています。返信いただいても回答しかねますのでご注意ください。";
			
	Send.setSmtpHost(Smtphost);
	Send.setFrom(From);
	Send.setPersonal(Personal);
	Send.setTo(SankasyaData.getMailAddress());
	Send.setSubject(Subject);
	Send.setBody(Body);
	
	boolean mailerror = Send.send();
	
	session.setAttribute("mailerror", mailerror);
	session.setAttribute("tourokuerror", false);
			NextPage = "/free_area/Event/Sankatouroku_Result.jsp";
		}else{
			session.setAttribute("mailerror", false);
			session.setAttribute("tourokuerror", true);
			NextPage = "/free_area/Event/Sankatouroku_Result.jsp";
		}
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Event-205");
		NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
	}
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
