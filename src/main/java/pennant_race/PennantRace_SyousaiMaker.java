package pennant_race;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.EventData_DAO;
import event.EventData_TO;

/**
 * Servlet implementation class PennantRace_SyousaiMaker
 */
public class PennantRace_SyousaiMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PennantRace_SyousaiMaker() {
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
		session.setAttribute("errcode", "Pennant-001");
		String NextPage = "/free_area/Error_Gamen.jsp";
		
		ServletContext application = getServletContext();
		
		PennantData_TO LeagueData = new PennantData_TO();
		ArrayList<PennantData_TO> PlayerData = new ArrayList<PennantData_TO>();
		ArrayList<PennantData_TO> EventList = new ArrayList<PennantData_TO>();
		ArrayList<EventData_TO> EventData = new ArrayList<EventData_TO>();
		
		EventData_TO Event_tmp = new EventData_TO();
		
		try{
		PennantData_DAO dao = new PennantData_DAO();
		EventData_DAO edao = new EventData_DAO();
		
		String League_ID = request.getParameter("league_id");
		String Order = request.getParameter("order");
		LeagueData = dao.League_Load(League_ID);
		PlayerData = dao.RuikeiStar_Rank(League_ID, Order);
		
		EventList = dao.LeagueTaikaiRireki(League_ID);
		
		for(int i=0; i < EventList.size(); i++){
		Event_tmp = edao.EventIndex_SyousaiLoad(EventList.get(i).getEventCode());
		EventData.add(Event_tmp);
		}
		
		application.setAttribute("leaguesyousai", LeagueData);
		application.setAttribute("playersyousai", PlayerData);
		application.setAttribute("eventlist", EventData);
		NextPage = "/free_area/Pennant_Race/Pennant_Race_Syousai.jsp";
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Pennant-201");
		NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
	}
	
	RequestDispatcher rd = application.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
