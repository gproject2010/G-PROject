package k_jyouhou;

//import inputUtility.HttpUtility;

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
 * Servlet implementation class K_RankingMaker
 */
public class K_RankingMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//boolean DSubmit;//1回だけメソッドへのアクセスを許可する
    /**
     * @see HttpServlet#HttpServlet()
     */
    public K_RankingMaker() {
        super();
    	//DSubmit = false;
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
		// 会員に関するランキングの検索依頼・結果の受け取り処理
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "KData-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		try{
		String hani = request.getParameter("hani");//ランキングの種類
		if(hani == null){
			hani = (String)session.getAttribute("hani");
		}
		//hani = HttpUtility.escapeHTML(hani);//特殊文字チェック
		String MoveFlg = request.getParameter("moveflg");//結果の表示部分の移動方向
		K_Ranking_TO Pages = null;
		
		
		if(MoveFlg == null){//最初の表示(MoveFlg=null)
			Pages = new K_Ranking_TO(0, 20);
		}
		else if(MoveFlg.equals("forward")){//"foward"が渡された場合は20件分下に移動
			Pages = (K_Ranking_TO)session.getAttribute("pages");
			Pages.setPageSt(Pages.getPageSt() + 20);
			//Pages.setPageFin(Pages.getPageFin() + 20);
		}
		else if(MoveFlg.equals("back")){//"back"が渡された場合は20件分上に移動
			Pages = (K_Ranking_TO)session.getAttribute("pages");
			Pages.setPageSt(Pages.getPageSt() - 20);
			//Pages.setPageFin(Pages.getPageFin() - 20);
			
			if(Pages.getPageSt() < 0){
			Pages.setPageSt(0);
			}
		}
		K_Ranking_DAO dao = new K_Ranking_DAO();
		
		ArrayList<K_Ranking_TO> Ranklist = dao.All_Rank(hani, Pages.getPageSt(), Pages.getPageFin());//"hani"に対応したランキングを検索
		
		//int KR_ResultCount = ( Ranklist == null ? 0 : Ranklist.size() );//検索結果がゼロの場合はnullの代わりに0が渡される
		
		//ServletContext application = getServletContext();
		session.setAttribute("ranklist", Ranklist);//ランキングデータをセット
		
		//session.setAttribute("pagest", Pages.getPageSt() );
		//session.setAttribute("pagefin", Pages.getPageFin() );
		session.setAttribute("pages", Pages);
		//session.setAttribute("kr_resultcount", KR_ResultCount );//ヒット件数
		
		if(hani.equals("kongetsu")){//それぞれの結果表示画面へフォワード			
			NextPage = "/free_area/Repsc_Ranking_Kongetsu.jsp";
		}
		else if (hani.equals("sengetsu")){
			NextPage = "/free_area/Repsc_Ranking_Month.jsp";
		}
		else if (hani.equals("nenkan")){
			NextPage = "/free_area/Repsc_Ranking_Nenkan.jsp";
		}
		else if (hani.equals("ruikei")){
			NextPage = "/free_area/Repsc_Ranking_Ruikei.jsp";
		}
		else if (hani.equals("r_count")){
			NextPage = "/free_area/R-Count.jsp";
		}
		
		else if(hani.equals("act_kongetsu")){//それぞれの結果表示画面へフォワード			
			NextPage = "/free_area/Actsc_Ranking_Kongetsu.jsp";
		}
		else if (hani.equals("act_sengetsu")){
			NextPage = "/free_area/Actsc_Ranking_Month.jsp";
		}
		else if (hani.equals("act_nenkan")){
			NextPage = "/free_area/Actsc_Ranking_Nenkan.jsp";
		}
		else if (hani.equals("act_ruikei")){
			NextPage = "/free_area/Actsc_Ranking_Ruikei.jsp";
		}
		
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "KData-001");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
		
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}
}

