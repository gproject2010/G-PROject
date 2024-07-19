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
 * Servlet implementation class WordRep_Touroku
 */
public class WordRep_Touroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordRep_Touroku() {
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
		session.setAttribute("errcode", "WordRep-002");
		String NextPage = "/free_area/Error_Gamen.jsp";
		ServletContext sc = getServletContext();
		
		Rep_List_DAO dao = new Rep_List_DAO();
		String Rep_Code = null;
		try{
		
		Rep_Koumoku RepData = (Rep_Koumoku) session.getAttribute("repdata");
		
		String GameTitle = RepData.getGameTitle();
		
		double Dificultty = RepData.getdificultty();
		double Story = RepData.getstory();
		double Graphic = RepData.getgraphic();
		double Sound = RepData.getsound();
		double Volume = RepData.getvolume();
		double Controll = RepData.getcontroll();
		double Promotion = RepData.getpromotion();
		double Free_S = RepData.getfree_S();
		double Total = RepData.gettotal();
		
		String Jiyuten_Koumoku1 = RepData.getjiyuten_koumoku1();
		String Jiyuten_Koumoku2 = RepData.getjiyuten_koumoku2();
		String Jiyuten_Koumoku3 = RepData.getjiyuten_koumoku3();
		
		double Jiyuten_Score1 = RepData.getjiyuten_score1();
		double Jiyuten_Score2 = RepData.getjiyuten_score2();
		double Jiyuten_Score3 = RepData.getjiyuten_score3();
		double Jiyuten_ScoreTotal = RepData.getjiyuten_scoretotal();
		
		double Jiyuten_MaxScore1 = RepData.getjiyuten_maxscore1();
		double Jiyuten_MaxScore2 = RepData.getjiyuten_maxscore2();
		double Jiyuten_MaxScore3 = RepData.getjiyuten_maxscore3();
		double Jiyuten_MaxScoreTotal = RepData.getjiyuten_maxscoretotal();
		
		String Comment = RepData.getComment();
		
		Rep_Koumoku UploadData = new Rep_Koumoku(GameTitle, Dificultty, Story, Graphic, Sound, Volume, Controll, Promotion, Free_S, Total,
				Jiyuten_Koumoku1, Jiyuten_Koumoku2, Jiyuten_Koumoku3, Jiyuten_Score1, Jiyuten_Score2, Jiyuten_Score3, Jiyuten_ScoreTotal,
				Jiyuten_MaxScore1, Jiyuten_MaxScore2, Jiyuten_MaxScore3, Jiyuten_MaxScoreTotal, Comment);
		
		String IPAddress = request.getRemoteAddr();
		
		Rep_Code = dao.WordRep_Touroku(UploadData, IPAddress);
		
		if(Rep_Code != null){
			session.setAttribute("repcode", Rep_Code);
			NextPage = "/free_area/Word_Report/WordRep_Uketsuke_Kanryou.html";
		}else{
			session.setAttribute("errcode", "Wordrep-003");
			NextPage = "/free_area/Error_Gamen.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "WordRep-104");
			NextPage = "/passed/Error_Gamen.jsp";
		}	
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);

	}
}
