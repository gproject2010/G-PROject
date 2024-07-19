package mail;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Toiawase_Kakunin
 */
public class Toiawase_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Toiawase_Kakunin() {
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
		String NextPage = null;
		Toiawase_Koumoku naiyou = new Toiawase_Koumoku();
		
		  String From = request.getParameter("from");//送信元メールアドレス
		  String Toi_syubetsu = request.getParameter("toi_syubetsu");//問い合わせの種別
		  String Subject = request.getParameter("subject");//題名
		  String Body = request.getParameter("body");//問い合わせ文本体
		  boolean Nokoumoku = false;//入力されていない項目があるかを表すフラグ
		  boolean Wrong = false;//不正な入力があるかを表すフラグ
		  try{
		  //HttpUtility.escapeHTML(From);//特殊文字チェック
		  //HttpUtility.escapeHTML(Toi_syubetsu);
		  //HttpUtility.escapeHTML(Subject);
		  //HttpUtility.escapeHTML(Body);
		  
		  if(From.equals("") || From.equals("null") || Subject.equals("") || Subject.equals("null") || Body.equals("") || Body.equals("null")){
			  Nokoumoku = true;//入力されていない項目がある場合はフラグON
		  }
	}catch(Exception e){
		Wrong = true;//エラーが発生した場合はフラグON
	}
		naiyou = new Toiawase_Koumoku(From, Toi_syubetsu, Subject, Body, Nokoumoku, Wrong);
		session.setAttribute("toi", naiyou);
		
		if(Nokoumoku || Wrong){
			NextPage = "/free_area/Toi_Syusei.jsp";
		}else{
			NextPage = "/free_area/Toi_Kakunin.jsp";
		}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
