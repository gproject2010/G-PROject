package k_jyouhou;

import inputUtility.HttpUtility;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rep_upload.Rep_List_DAO;
import rep_upload.Rep_List_TO;

/**
 * Servlet implementation class StatusMaker
 */
public class StatusMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusMaker() {
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
		//会員ステータス情報の作成処理
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "KData-010");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		try{
		//String key = (String) session.getAttribute("input_id");//AuthenticationController.javaでsessionスコープにセットされたIDを使用
		String key = request.getRemoteUser();
		boolean LvUpFlg = false;
		//System.out.println("HIT!");
		R_jyouhou_DAO dao = new R_jyouhou_DAO();
		R_jyouhou_TO Status = dao.findkaiin_NById(key);//現在のプレイヤー情報を取得
		
		K_jyouhou_DAO kdao = new K_jyouhou_DAO();
		//K_jyouhou_TO Tonext = kdao.ToNextScore(Status.getplayer_Level()+1);//次に昇格するレベル(現在のレベル+1)の情報を取得
		if(Status == null){
			session.setAttribute("errcode", "KData-110");
			NextPage = "/passed/Error_Gamen.jsp";
			
		}else{
			
		double NextScore = 0;
		int NextLv = Status.getplayer_Level() + 1;
		double NextScore_Bef = (NextLv * 0.5) + (NextLv * NextLv * 0.1);
		NextScore = HttpUtility.Round(NextScore_Bef, 2, "cut");
		
		if(NextScore - Status.getreportScore_Ruikei() - Status.getActionScore_Ruikei() <= 0){//経験値(レポートスコア+アクションスコア)がレベルアップに必要な値以上なら
			LvUpFlg = true;//レベルアップ用フラグをON
			Status.setLv_Up_Flg(LvUpFlg);//sessionオブジェクト内のレベルアップ用フラグを更新
			kdao.LevelUpdate(Status.getplayer_Level() + 1, Status.getk_Id());//レベルアップ処理をDAOに依頼
			//Tonext = kdao.ToNextScore(Status.getplayer_Level()+1);//次に昇格するレベル(現在のレベル+1)の情報を取得
			
		}
		
		Rep_List_DAO rdao = new Rep_List_DAO();
		ArrayList<Rep_List_TO> UpLog = rdao.Report_Rireki(key);
		
		
		session.setAttribute("seiseki", Status);
		session.setAttribute("nextsc", NextScore);
		session.setAttribute("r_rireki", UpLog);
		
		NextPage = "/passed/Kaiin_Status.jsp";
		}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "KData-010");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
