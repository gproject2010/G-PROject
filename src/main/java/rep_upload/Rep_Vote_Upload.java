package rep_upload;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Rep_Vote_Upload
 */
public class Rep_Vote_Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rep_Vote_Upload() {
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
		session.setAttribute("errcode", "Rep-013");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean ErrorFlg = true;
		try{
		R_jyouhou_TO Kaiindata = (R_jyouhou_TO)session.getAttribute("seiseki");
		String Kaiin_ID = Kaiindata.getk_Id();
		
		String Rep_Code = request.getParameter("rep_code");
		//Rep_Code = HttpUtility.escapeHTML(Rep_Code);
		String Command = request.getParameter("command");
		//Command = HttpUtility.escapeHTML(Command);
		if(Kaiin_ID.equals(request.getRemoteUser())){
		Rep_List_DAO dao = new Rep_List_DAO();
		ErrorFlg = dao.VoteCount_Upload(Rep_Code, Command, Kaiin_ID);
		}else{
			ErrorFlg = true;
		}
		
		if(ErrorFlg == false){
			NextPage = "/passed/VoteTouroku_Kanryou.jsp";
		}else{
			session.setAttribute("errcode", "Rep-313");
			NextPage = "/passed/Error_Gamen.jsp";
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "Rep-013");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
			}

}
