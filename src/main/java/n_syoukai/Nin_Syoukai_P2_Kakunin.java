package n_syoukai;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.K_jyouhou_DAO;
import k_jyouhou.K_jyouhou_TO;
import mail.MailSendBean;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * Servlet implementation class Nin_Syoukai_P2_Kakunin
 */
public class Nin_Syoukai_P2_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nin_Syoukai_P2_Kakunin() {
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
		HttpSession session = request.getSession(false);
		request.setCharacterEncoding("UTF-8");
		//K_jyouhou_TO ResetData = null;
		session.setAttribute("errcode", "NSyoukai-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		K_jyouhou_DAO dao = new K_jyouhou_DAO();
		MailSendBean Send = new MailSendBean();
		boolean wrong = false;
		boolean UpError = false;
		boolean mailerror = false;
		
		
		ServletContext sc = getServletContext();
		String Birthday = null;
		String Addressno = null;
		//int NewPass_i = 0;
		String NewPass = null;
		try{
		String BirthYear = request.getParameter("birthyear");
		String BirthTsuki = request.getParameter("birthtsuki");
		String BirthDay = request.getParameter("birthday");
		
		if(BirthYear == null || BirthYear.equals("") || BirthTsuki == null || BirthTsuki.equals("") || BirthDay == null || BirthDay.equals("")){
			wrong = true;
		}else{
			Birthday = BirthYear + "-" + BirthTsuki + "-" + BirthDay;
		//HttpUtility.escapeHTML(Birthday);
		}
		
		Addressno = request.getParameter("addressno");
		if(Addressno == null || Addressno.equals("")){
			wrong = true;
		}else{
		//HttpUtility.escapeHTML(Addressno);
		}
		String Secret_Answer = request.getParameter("secret_answer");
		//HttpUtility.escapeHTML(Secret_Answer);

		K_jyouhou_TO match = (K_jyouhou_TO)session.getAttribute("syo_data");
		if(match != null && Birthday.equals(match.getbirthday()) && Addressno.equals(match.getyubin_bangou()) && Secret_Answer.equals(match.getsecret_answer())){
			//ここにゲームマスターへの申請の通知処理を追加
			//NewPass_i = (int) Math.ceil(Math.random() * 10000000);
			//NewPass = Integer.toString(NewPass_i);
			NewPass = RandomStringUtils.randomAlphabetic(10);
			UpError = dao.Password_Reset(match.getk_Id(), NewPass);
			if(UpError == false){

				String Smtphost = "mail.gamereporters.info";
				//String Smtphost = "ybbsmtp.mail.yahoo.co.jp";
				String From = "GameMaster@mail.gamereporters.info";
				//String From = "xysyr908@ybb.ne.jp";
				String Personal = "G-PROject認証照会サーバ";
				String Subject = "パスワードリセットのお知らせ";
				String Body =  "G-PROject認証照会サーバです。このたびはお問い合わせいただきありがとうございます。\n" +
						"会員情報による認証に成功しましたのでパスワードのリセットを行いました。\n" +
						"下記のG-PRO_IDとパスワードでログインし、会員メニューの「8：会員情報の変更」から\n" +
						"パスワードを新しいものに変更してください。\n\n" +
						"リセットを行ったG-PRO_ID:" + match.getk_Id() + "\n\nパスワード(リセット後):" + NewPass + "\n\n" +
								"G-PROjectトップページ→http://www.gamereporters.info/G-pro_Service/AuthenticationController \n" +
								"※1:このメールに表示されているG-PRO IDがあなたのものではない、もしくは「G-PRO ID・パスワードを\n" +
								"忘れるなどして照会した」覚えがない場合はお手数ですがG-PROjectのお問い合わせフォームにてお知らせください。\n" +
								"※2:このメールは送信専用のアドレスから送信されています。返信いただいても回答しかねますのでご注意ください。";
				
				Send.setSmtpHost(Smtphost);
				Send.setFrom(From);
				Send.setPersonal(Personal);
				Send.setTo(match.getmailaddress());
				Send.setSubject(Subject);
				Send.setBody(Body);
				
				mailerror = Send.send();
				if(mailerror == false){
					session.setAttribute("k_id", match.getk_Id());
			NextPage = "/free_area/Password_Reset_Kanryou.jsp";//まだ作ってない
				}else{
					session.setAttribute("errcode", "Nsyoukai-302");
					NextPage = "/passed/Error_Gamen.jsp";
				}
			}else{
				session.setAttribute("errcode", "NSyoukai-202");
				NextPage = "/passed/Error_Gamen.jsp";
			}
		}else{
			K_jyouhou_TO wrong2 = new K_jyouhou_TO(BirthDay, Addressno, Secret_Answer, wrong);
			session.setAttribute("wrong2", wrong2);
			NextPage = "/free_area/Nin_Syoukai_P2_Syusei.jsp";
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "NSyoukai-002");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
