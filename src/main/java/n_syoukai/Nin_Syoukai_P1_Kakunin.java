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

/**
 * Servlet implementation class Nin_Syoukai_P1_Kakunin
 */
public class Nin_Syoukai_P1_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Nin_Syoukai_P1_Kakunin() {
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
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "NSyoukai-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		String Input_Mail = request.getParameter("mailaddress");
		String Input_Name = request.getParameter("player_name");
		
		
		boolean NoMail = false;
		boolean NoName = false;
		boolean Wrong = false;
		boolean empty = false;
		
		try{
		if(Input_Mail == null || Input_Mail.equals("")){
			NoMail = true;
		}else{
			//HttpUtility.escapeHTML(Input_Mail);
		}
		
			if(Input_Name == null || Input_Name.equals("")){
				NoName = true;
			}else{
				//HttpUtility.escapeHTML(Input_Name);
			}
		}catch(Exception e){
			e.printStackTrace();
			Wrong = true;
		}	
			try{
		K_jyouhou_DAO kdao = new K_jyouhou_DAO();
		K_jyouhou_TO Syo = kdao.Nin_Syougou(Input_Name, Input_Mail);
		if(Syo == null){
			empty = true;
		}
		if(empty || NoMail || NoName || Wrong){
			K_jyouhou_TO Syo_Wrong = new K_jyouhou_TO(Input_Name, Input_Mail, NoMail, NoName, Wrong, empty);
			session.setAttribute("wrong", Syo_Wrong);
			NextPage = "/free_area/Nin_Syoukai_P1_Syusei.jsp";
		}else{
			session.setAttribute("syo_data", Syo);
			NextPage = "/free_area/Nin_Syoukai_P2.jsp";
		}
		}catch(Exception e2){
			e2.printStackTrace();
			session.setAttribute("errcode", "NSyoukai-001");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}
}
