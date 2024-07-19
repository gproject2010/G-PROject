package ninsyou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Infomation_SyousaiMaker
 */
public class Infomation_SyousaiMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Infomation_SyousaiMaker() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "Ninsyou-003");
		String NextPage = "/passed/Error_Gamen.jsp";
		ServletContext application = getServletContext();

		try{
		String Info_Code = request.getParameter("code");
		String Login_Jyoukyou = request.getParameter("login_jyoukyou");
		Infomation_TO SyousaiData = new Infomation_TO();

		Infomation_DAO infodao = new Infomation_DAO();
		SyousaiData = infodao.Info_SyousaiSerch(Info_Code);


		if(SyousaiData.getTeiseiDate() == null){
			SyousaiData.setTeiseiDate("empty");
		}

		application.setAttribute("infodata", SyousaiData);


		if(Login_Jyoukyou.equals("yes")){
		NextPage = "/passed/Info_Syousai.jsp";
		}else{
			NextPage = "/free_area/Info_Syousai.jsp";
		}

	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Ninsyou-003");
		NextPage = "/passed/Error_Gamen.jsp";
	}
//	ServletContext sc = getServletContext();
	RequestDispatcher rd = application.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
