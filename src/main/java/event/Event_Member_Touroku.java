package event;

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
 * Servlet implementation class Event_Member_Touroku
 */
public class Event_Member_Touroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event_Member_Touroku() {
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
		String NextPage = "/passed/Error_Gamen.jsp";
		
		EventData_TO SankasyaData = new EventData_TO();
		EventData_TO FormData = new EventData_TO();
		
		FormData = (EventData_TO)session.getAttribute("formdata");
		
		boolean Form_Empty = false;
		boolean Mojisu_Over = false;
		String NGWords = "";
		
		String Koumoku1 = "";
		String Koumoku2 = "";
		String Koumoku3 = "";
		String Koumoku4 = "";
		String Koumoku5 = "";
		
		int Maxlength1 = 0;
		int Maxlength2 = 0;
		int Maxlength3 = 0;
		int Maxlength4 = 0;
		int Maxlength5 = 0;
		
		if(FormData.getMaxLengthList_A().length > 0){
		Maxlength1 = Integer.parseInt(FormData.getMaxLengthList_A()[0]);
		if(FormData.getMaxLengthList_A().length > 1){
		Maxlength2 = Integer.parseInt(FormData.getMaxLengthList_A()[1]);
		if(FormData.getMaxLengthList_A().length > 2){
		Maxlength3 = Integer.parseInt(FormData.getMaxLengthList_A()[2]);
		if(FormData.getMaxLengthList_A().length > 3){
		Maxlength4 = Integer.parseInt(FormData.getMaxLengthList_A()[3]);
		if(FormData.getMaxLengthList_A().length > 4){
		Maxlength5 = Integer.parseInt(FormData.getMaxLengthList_A()[4]);
		}
		}
		}
		}
		}
		
		String NameError = "";
		String YomiError = "";
		String PrefError = "";
		String MailError = "";
		
		String KoumokuError1 = "";
		String KoumokuError2 = "";
		String KoumokuError3 = "";
		String KoumokuError4 = "";
		String KoumokuError5 = "";
		
		String Bikou = "";
		String BikouError = "";
		
		try{
		
		String Entry_Name = request.getParameter("entry_name");
		if(Entry_Name.isEmpty() == true || Entry_Name.equals("入力してください")){
			NameError = "form_empty";
		}else if(Entry_Name.length() > 20){
			NameError = "mojisu_over";
		}else if(!(HttpUtility.NG_Word_Check(Entry_Name).equals(""))){
			NameError = HttpUtility.NG_Word_Check(Entry_Name);
		}
		
		String Entry_Name_Yomi = request.getParameter("entry_name_yomi");
		if(Entry_Name_Yomi.isEmpty() == true || Entry_Name_Yomi.equals("入力してください")){
			YomiError = "form_empty";
		}else if(Entry_Name_Yomi.length() > 30){
			YomiError = "mojisu_over";
		}else if(!(HttpUtility.NG_Word_Check(Entry_Name_Yomi).equals(""))){
			YomiError = HttpUtility.NG_Word_Check(Entry_Name_Yomi);
		}
		
		String MailAddress = request.getParameter("mailaddress");
		if(MailAddress.isEmpty() == true || MailAddress.length() < 75 || (!(HttpUtility.NG_Word_Check(MailAddress).equals("")))){
			MailError = "wrong";
		}
		
		String Pref = request.getParameter("pref");
		if(Pref.isEmpty() == true || Pref.length() > 5 || (!(HttpUtility.NG_Word_Check(Pref).equals("")))){
			PrefError = "wrong";
		}
		
		if(FormData.getKoumokuList_A().length > 0){
			Koumoku1 = request.getParameter("koumoku1");
			if(Koumoku1.isEmpty() == true){
				KoumokuError1 = "form_empty";
			}else if(Koumoku1.length() > Maxlength1){
				KoumokuError1 = "mojisu_over";
			}else if(!(HttpUtility.NG_Word_Check(Koumoku1).equals(""))){
				KoumokuError1 = HttpUtility.NG_Word_Check(Koumoku1);
			}
			
		}if(FormData.getKoumokuList_A().length > 1){
			Koumoku2 = request.getParameter("koumoku2");
			if(Koumoku2.isEmpty() == true){
				KoumokuError2 = "form_empty";
			}else if(Koumoku2.length() > Maxlength2){
				KoumokuError2 = "mojisu_over";
			}else if(!(HttpUtility.NG_Word_Check(Koumoku2).equals(""))){
				KoumokuError2 = HttpUtility.NG_Word_Check(Koumoku2);
			}
			
		}if(FormData.getKoumokuList_A().length > 2){
			Koumoku3 = request.getParameter("koumoku3");
			if(Koumoku3.isEmpty() == true){
				KoumokuError3 = "form_empty";
			}else if(Koumoku3.length() > Maxlength3){
				KoumokuError3 = "mojisu_over";
			}else if(!(HttpUtility.NG_Word_Check(Koumoku3).equals(""))){
				KoumokuError3 = HttpUtility.NG_Word_Check(Koumoku3);
			}
			
		}if(FormData.getKoumokuList_A().length > 3){
			Koumoku4 = request.getParameter("koumoku4");
			if(Koumoku4.isEmpty() == true){
				KoumokuError4 = "form_empty";
			}else if(Koumoku4.length() > Maxlength4){
				KoumokuError4 = "mojisu_over";
			}else if(!(HttpUtility.NG_Word_Check(Koumoku4).equals(""))){
				KoumokuError4 = HttpUtility.NG_Word_Check(Koumoku4);
			}
			
		}if(FormData.getKoumokuList_A().length > 4){
			Koumoku5 = request.getParameter("koumoku5");
			if(Koumoku5.isEmpty() == true){
				KoumokuError5 = "form_empty";
			}else if(Koumoku5.length() > Maxlength5){
				KoumokuError5 = "mojisu_over";
			}else if(!(HttpUtility.NG_Word_Check(Koumoku5).equals(""))){
				KoumokuError5 = HttpUtility.NG_Word_Check(Koumoku5);
			}
			
		}
		
		Bikou = request.getParameter("bikou");
		if(Bikou.length() > 150){
			BikouError = "mojisu_over";
		}else if(!(HttpUtility.NG_Word_Check(Bikou).equals(""))){
			BikouError = HttpUtility.NG_Word_Check(Bikou);
		}
		
		SankasyaData = new EventData_TO(Entry_Name, Entry_Name_Yomi, MailAddress, Pref, Koumoku1, Koumoku2, Koumoku3, Koumoku4, Koumoku5, NameError, YomiError, MailError, PrefError, KoumokuError1, KoumokuError2, KoumokuError3, KoumokuError4, KoumokuError5, Bikou, BikouError);
		session.setAttribute("sankasyadata", SankasyaData);
		
		if(NameError.equals("") && YomiError.equals("") && PrefError.equals("") && KoumokuError1.equals("") && KoumokuError2.equals("") && KoumokuError3.equals("") && KoumokuError4.equals("") && KoumokuError5.equals("") && BikouError.equals("")){
		NextPage = "/free_area/Event/Event_Sanka_Kakunin.jsp";
		}else{
			if(NameError.equals("form_empty") || Entry_Name_Yomi.equals("form_empty") || PrefError.equals("wrong") || MailError.equals("wrong") || KoumokuError1.equals("form_empty") || KoumokuError2.equals("form_empty") || KoumokuError3.equals("form_empty") || KoumokuError4.equals("form_empty") || KoumokuError5.equals("form_empty")){
				Form_Empty = true;
			}
			if(NameError.equals("mojisu_over") || Entry_Name_Yomi.equals("mojisu_over") || KoumokuError1.equals("mojisu_over") || KoumokuError2.equals("mojisu_over") || KoumokuError3.equals("mojisu_over") || KoumokuError4.equals("mojisu_over") || KoumokuError5.equals("mojisu_over") || BikouError.equals("mojisu_over")){
				Mojisu_Over = true;
			}
			
			
			if(NameError.equals("form_empty") == false && (NameError.equals("mojisu_over") == false)){
				NGWords = NGWords + NameError + ",";
			}
			if(YomiError.equals("form_empty") == false && (YomiError.equals("mojisu_over") == false)){
				NGWords = NGWords + YomiError + ",";
			}
			
			if(KoumokuError1.equals("form_empty") == false && (KoumokuError1.equals("mojisu_over") == false)){
				NGWords = NGWords + KoumokuError1 + ",";
			}
			if(KoumokuError2.equals("form_empty") == false && (KoumokuError2.equals("mojisu_over") == false)){
				NGWords = NGWords + KoumokuError2 + ",";
			}
			if(KoumokuError3.equals("form_empty") == false && (KoumokuError3.equals("mojisu_over") == false)){
				NGWords = NGWords + KoumokuError3 + ",";
			}
			if(KoumokuError4.equals("form_empty") == false && (KoumokuError4.equals("mojisu_over") == false)){
				NGWords = NGWords + KoumokuError4 + ",";
			}
			if(KoumokuError5.equals("form_empty") == false && (KoumokuError5.equals("mojisu_over") == false)){
				NGWords = NGWords + KoumokuError5 + ",";
			}
			if(BikouError.equals("mojisu_over") == false){
				NGWords = NGWords + BikouError + ",";
			}
			
			
			if(NGWords.length() > 0){
				NGWords.substring(0, NGWords.length() - 1);
			}
			
			session.setAttribute("form_empty", Form_Empty);
			session.setAttribute("mojisu_over", Mojisu_Over);
			session.setAttribute("ngwords", NGWords);
			
			NextPage = "/free_area/Event/Event_Sanka_Syusei.jsp";
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
