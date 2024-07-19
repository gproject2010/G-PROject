package rep_upload;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Shinki_Report_jyushin
 */
public class Shinki_Report_jyushin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Shinki_Report_jyushin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "Rep-015");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext context = getServletContext();
		String storePath = context.getRealPath("");
		try{
		File_Upload_Utility.execute(request, storePath);
		NextPage = "/passed/Rep_Uketsuke_Kanryou.html";
		
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "Rep-015");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		RequestDispatcher rd = request.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
