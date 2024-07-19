package rep_upload;

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
 * Servlet implementation class WordRep_Kakunin
 */
public class NewGame_Rep_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGame_Rep_Kakunin() {
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
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "Rep-006");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		try{
		Rep_Koumoku RepData = new Rep_Koumoku();
		
		String Rep_Syubetsu = request.getParameter("rep_syubetsu");
		boolean NoComment = false;
		boolean MojisuOver = false;
		String NGWord = null;
		
		String Comment = request.getParameter("comment");
		if(Comment == null || Comment.equals("")){
			NoComment = true;
		}else{
		//Comment = HttpUtility.escapeHTML(Comment);
		if(HttpUtility.NG_Word_Check(Comment) != null){
			NGWord = HttpUtility.NG_Word_Check(Comment);
		}
		
		if(Comment.length() > 500){
			MojisuOver = true;
		}
		RepData = new Rep_Koumoku(Comment, NoComment, NGWord, MojisuOver);
		session.setAttribute("newgamerep", RepData);
		}
		if(NoComment == false && NGWord == null){
			if(Rep_Syubetsu.equals("newgame")){
			NextPage = "/passed/NewGames/NewGame_Rep_Kakunin.jsp";
			}else if(Rep_Syubetsu.equals("propresp")){
				NextPage = "/passed/NewGames/PropRep_Report_Kakunin.jsp";
			}else{
				session.setAttribute("errcode", "Rep-006");
				NextPage = "/passed/Error_Gamen.jsp";//レポートの種類が判定できなければエラーとみなす(まだ作ってない）
			}
		}else{
			if(Rep_Syubetsu.equals("newgame")){
			NextPage = "/passed/NewGames/NewGame_Rep_Syusei.jsp";
			}else if(Rep_Syubetsu.equals("propresp")){
				NextPage = "/passed/NewGames/PropRep_Report_Syusei.jsp";
			}else{
				session.setAttribute("errcode", "Rep-006");
				NextPage = "/passed/Error_Gamen.jsp";//レポートの種類が判定できなければエラーとみなす(まだ作ってない）
			}
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Rep-006");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
