package g_jyouhou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rep_upload.Rep_Koumoku;

/**
 * Servlet implementation class WordRep_Load
 */
public class WordRep_Load extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordRep_Load() {
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
		String NextPage = "/free_area/Error_Gamen.jsp";
		
		Rep_Koumoku RepData = new Rep_Koumoku();
		Rep_Load_DAO dao = new Rep_Load_DAO();
		
		try{
		String Rep_Code = request.getParameter("rep_code");
		
		RepData = dao.WordRep_Load(Rep_Code);
		
		session.setAttribute("repdata", RepData);
		
		NextPage = "/free_area/Word_Report/WordRep_Show.jsp";
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "wordrep-003");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
			
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
