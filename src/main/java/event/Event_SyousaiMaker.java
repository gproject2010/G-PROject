package event;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Event_SyousaiMaker
 */
public class Event_SyousaiMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event_SyousaiMaker() {
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
		session.setAttribute("errcode", "Event-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		EventData_TO Event_Syousai = new EventData_TO();
		EventData_DAO dao = new EventData_DAO();
		
		try{
			
			String Event_Code = request.getParameter("eventcode");
			if(Event_Code.isEmpty() == false){
				Event_Syousai = dao.EventIndex_SyousaiLoad(Event_Code);
				session.setAttribute("eventsyousai", Event_Syousai);
				NextPage = "/free_area/Event/Event_Gaiyou.jsp";
			}else{
				session.setAttribute("errcode", "Event-101");
				NextPage = "/free_area/Error_Gamen.jsp";
			}
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "Event-201");
			NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}
