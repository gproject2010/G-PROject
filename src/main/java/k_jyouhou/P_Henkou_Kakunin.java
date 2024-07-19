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

/**
 * Servlet implementation class P_Henkou_Kakunin
 */
public class P_Henkou_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P_Henkou_Kakunin() {
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
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		K_jyouhou_TO noHenkou = (K_jyouhou_TO)session.getAttribute("pdata");
		
		ServletContext sc = getServletContext();
		session.setAttribute("errcode", "KData-008");
		String NextPage = "/passed/Error_Gamen.jsp";
		String NGWord = null;
		String Input_Id = request.getRemoteUser();//認証情報からIDを抽出
		//Input_Id = HttpUtility.escapeHTML(Input_Id);//特殊文字チェック
		try{
		String Sei_Kanji = request.getParameter("sei_kanji");//姓(漢字)
		String Mei_Kanji = request.getParameter("mei_kanji");//名(漢字)
		String Sei_Kana = request.getParameter("sei_kana");//姓(カタカナ)
		String Mei_Kana = request.getParameter("mei_kana");//名(カタカナ)
		String BirthDay = noHenkou.getbirthday();//生年月日
		String Job = request.getParameter("job");//職業
		if(Job.equals("変更しない")){
			Job = noHenkou.getJob();
		}
		String AddressNo = request.getParameter("addressno");//住所(郵便番号)
		String Pref = request.getParameter("pref");//住所(都道府県)
		if(Pref.equals("変更しない")){
			Pref = noHenkou.getpref();
		}
		String Jyusyo = request.getParameter("jyusyo");//住所(区市区町村以下)
		String Telephone_No = request.getParameter("telephone_no");//連絡先電話番号
		String Secret_Question = request.getParameter("secret_question");//秘密の質問
		String Secret_Answer = request.getParameter("secret_answer");//秘密の質問の答え
		
		boolean NoName = false;
		if(Sei_Kanji == null || Sei_Kanji.equals("") ||
		Sei_Kana == null ||Sei_Kana.equals("") || Mei_Kanji == null || Mei_Kanji.equals("") || Mei_Kana == null || Mei_Kana.equals("")){//本名が一部でも未入力の場合はフラグON
			NoName = true;
		}else{
			//Sei_Kanji = HttpUtility.escapeHTML(Sei_Kanji);//特殊文字チェック
			//Sei_Kana = HttpUtility.escapeHTML(Sei_Kana);
		}
		
		
		boolean NoAddress = false;
		if(AddressNo == null || AddressNo.equals("") || Jyusyo == null || Jyusyo.equals("") || Telephone_No == null || Telephone_No.equals("")){
			NoAddress = true;//住所が一部分でも未入力の場合はフラグON
		}else{
			//AddressNo = HttpUtility.escapeHTML(AddressNo);//特殊文字チェック
			//Jyusyo = HttpUtility.escapeHTML(Jyusyo);
			//Telephone_No = HttpUtility.escapeHTML(Telephone_No);
		}
		
		boolean NoSecret = false;
		if(Secret_Question == null || Secret_Question.equals("") || Secret_Answer == null || Secret_Answer.equals("")){
			NoSecret = true;//秘密の質問・答えが未入力の場合はフラグON
		}else{
			if(HttpUtility.NG_Word_Check(Secret_Question) != null){
				NGWord = HttpUtility.NG_Word_Check(Secret_Question);
			}
			if(HttpUtility.NG_Word_Check(Secret_Answer) != null){
				NGWord = HttpUtility.NG_Word_Check(Secret_Answer);
			}
			//Secret_Question = HttpUtility.escapeHTML(Secret_Question);
			//Secret_Answer = HttpUtility.escapeHTML(Secret_Answer);
		}
		
		if(NoName || NoAddress || NoSecret || NGWord != null){//未入力の欄が一か所でもある場合は修正用ページへフォワード
			K_Touroku_TO H_WrongData = null;
			H_WrongData = new K_Touroku_TO(Sei_Kanji, Mei_Kanji, Sei_Kana, Mei_Kana, BirthDay, AddressNo, Pref, Jyusyo, Telephone_No,
					Secret_Question, Secret_Answer, NoName, NoAddress, NoSecret, NGWord, Job);
			session.setAttribute("h_wrongdata", H_WrongData);
			NextPage = "/passed/P_Henkou_Syusei.jsp";
		}else{
			K_Touroku_TO H_Tourokudata = null;//すべて入力済みの場合は確認用ページへフォワード
			H_Tourokudata = new K_Touroku_TO(Sei_Kanji, Mei_Kanji, Sei_Kana, Mei_Kana, BirthDay, AddressNo, Pref, Jyusyo, Telephone_No,
					Secret_Question, Secret_Answer, Input_Id, Job);
			session.setAttribute("h_tourokudata", H_Tourokudata);
			NextPage = "/passed/P_Henkou_SaisyuKakunin.jsp";
		}
		
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-008");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
