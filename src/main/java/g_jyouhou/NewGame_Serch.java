package g_jyouhou;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rep_upload.Rep_List_DAO;
import rep_upload.Rep_List_TO;

/**
 * Servlet implementation class NewGame_Serch
 */
public class NewGame_Serch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGame_Serch() {
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
		session.setAttribute("errcode", "GData-006");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		G_jyouhou_DAO bdao = new G_jyouhou_DAO();
		Rep_List_DAO pdao = new Rep_List_DAO();
		ArrayList<G_jyouhou_TO> newgame = new ArrayList<G_jyouhou_TO>();
		ArrayList<Rep_List_TO> proprep = new ArrayList<Rep_List_TO>();
		try{
		newgame = bdao.Hatsubaimae_Serch();
		proprep = pdao.Prop_Serch();
		if(newgame == null || proprep == null){
			session.setAttribute("errcode", "GData-106");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}else{
		session.setAttribute("newgames", newgame);
		session.setAttribute("proprepo", proprep);
		NextPage = "/passed/NewGames/NewGame_Ichiran.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GData-006");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}
}
