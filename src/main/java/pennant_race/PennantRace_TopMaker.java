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

/**
 * Servlet implementation class PennantRace_TopMaker
 */
public class PennantRace_TopMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PennantRace_TopMaker() {
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
		
		ArrayList<PennantData_TO>LeagueData = new ArrayList<PennantData_TO>();
		ArrayList<PennantData_TO>PlayerData = new ArrayList<PennantData_TO>();
		ArrayList<PennantData_TO>PlayerData_tmp = new ArrayList<PennantData_TO>();
		
		PennantData_DAO dao = new PennantData_DAO();
		try{
		String Order = request.getParameter("order");
		
		LeagueData = dao.League_Load_All(0);
		
		for(int i=0; i < LeagueData.size(); i++){
		PlayerData_tmp = dao.RuikeiStar_Rank(LeagueData.get(i).getLeagueCode(), Order);
		PlayerData.addAll(PlayerData_tmp);
		}
		
		application.setAttribute("league", LeagueData);
		application.setAttribute("player", PlayerData);
		
		NextPage = "/free_area/Pennant_Race/Pennant_Race_Top.jsp";
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Pennant-201");
		NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
	}
	
	RequestDispatcher rd = application.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
