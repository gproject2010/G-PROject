package g_jyouhou;

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
 * Servlet implementation class G_RankingMaker
 */
public class G_RankingMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public G_RankingMaker() {
        super();
       
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "GData-004");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
		String hani = request.getParameter("hani");//ランキングの種類
		String MoveFlg = request.getParameter("moveflg");//表示部分の移動方向
		G_jyouhou_TO Pages = null;
		if(MoveFlg == null){//最初に表示したときはnullが渡される
			Pages = new G_jyouhou_TO(0, 20);
		}
		else if(MoveFlg.equals("forward")){//"forward"が渡されたときは20名分下にずらす
			Pages = (G_jyouhou_TO)session.getAttribute("pages");
			Pages.setPageSt(Pages.getPageSt() + 20);
			//Pages.setPageFin(Pages.getPageFin() + 20);
		}
		else if(MoveFlg.equals("back")){//"back"が渡されたときは20名分上にずらす
			Pages = (G_jyouhou_TO)session.getAttribute("pages");
			Pages.setPageSt(Pages.getPageSt() - 20);
			//Pages.setPageFin(Pages.getPageFin() - 20);
			
			if(Pages.getPageSt() < 0){
			Pages.setPageSt(0);
			}
		}
		ArrayList<GR_jyouhou_TO> Ranklist = new ArrayList<GR_jyouhou_TO>();
		GR_jyouhou_DAO dao = new GR_jyouhou_DAO();
		
		Ranklist = dao.GameRankAll(hani, Pages.getPageSt(), Pages.getPageFin());
		if(Ranklist == null){
			session.setAttribute("errcode", "GData-104");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}else{
		//ServletContext application = getServletContext();
		session.setAttribute("ranklist", Ranklist);
		
		//int GR_ResultCount = ( Ranklist == null ? 0 : Ranklist.size() );//ヒットした件数(ゼロの場合はnullの代わりに0が返される)
		session.setAttribute("pages", Pages );
		//session.setAttribute("hani", hani);
		//session.setAttribute("gr_resultcount", GR_ResultCount );
		
		if(hani.equals("dai1_insyou")){//第一印象ランキング
			NextPage = "/free_area/Dai1_Insyou_R.jsp";
		}
		else if(hani.equals("ninkisaku")){//人気作ランキング
			NextPage = "/free_area/Ninkisaku_Ranking.jsp";
		}
		else if(hani.equals("nenkan")){//ビッグヒットランキング
			NextPage = "/free_area/Big_Hit_Ranking.jsp";
		}
		else if(hani.equals("meisaku")){//名作ランキング
			NextPage = "/free_area/Meisaku_Ranking.jsp";
		}
		
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "GData-004");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}
}

