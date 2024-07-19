package event;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Event_Result_Maker
 */
public class Event_Result_Maker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Event_Result_Maker() {
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
		session.setAttribute("errcode", "Event-008");
		String NextPage = "/free_area/Error_Gamen.jsp";
		
		ServletContext application = getServletContext();
		
		EventData_TO EventData = new EventData_TO();
		EventData_TO Winners = new EventData_TO();
		ArrayList<EventData_TO> EventResult = new ArrayList<EventData_TO>();
		EventData_DAO dao = new EventData_DAO();
		
		try{
			String EventCode = request.getParameter("event_code");
			
			EventData = dao.EventIndex_SyousaiLoad(EventCode);
			Winners = dao.EventWinner_Load(EventCode);
			EventResult = dao.EventRank_Load(EventCode);
			
			if(EventData != null && Winners != null && EventResult != null){
			
			application.setAttribute("gaiyou", EventData);
			application.setAttribute("winners", Winners);
			application.setAttribute("rank", EventResult);
			
			NextPage = "/free_area/Event/Event_Result_Simple.jsp";
			
			}else{
				session.setAttribute("errcode", "Event-108");
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
