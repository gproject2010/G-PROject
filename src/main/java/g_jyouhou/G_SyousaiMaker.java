package g_jyouhou;

//import inputUtility.HttpUtility;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rep_upload.Rep_List_DAO;

/**
 * Servlet implementation class G_SyousaiMaker
 */
public class G_SyousaiMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public G_SyousaiMaker() {
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
		//選択されたゲームの情報のDAOへの検索依頼・検索結果の受け取り処理
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Calendar Now = new GregorianCalendar();
		Now.add(Calendar.MONTH, -3);//同じゲームに対するレポートは3か月間受付不可
		HttpSession session = request.getSession(true);
		
		String GameCode = request.getParameter("GameCode");//検索結果画面(G_SeachResult.jsp)から受け取った検索キー
		int Teisyutsu = 9999;//過去にこのゲームのレポートを提出しているか
		
		session.setAttribute("errcode", "GData-005");
		String NextPage = "/passed/Error_Gamen.jsp";//次に表示するページ
		if(GameCode!=null){//何も渡されなかった場合は何もしない(このサーブレットには連続2回リクエストが来るため)
			try{
				//GameCode = HttpUtility.escapeHTML(GameCode);//特殊文字チェック
				G_Syousai_DAO dao = new G_Syousai_DAO();//詳細情報の検索依頼
				GS_jyouhou_TO GSData = dao.SyousaiSeach(GameCode);//検索結果の受け取り
				if(GSData == null){
					session.setAttribute("errcode", "GData-105");
					NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
				}else{
				session.setAttribute("syousai", GSData);//検索結果をsessionスコープにセット
				
				String Input_Id = request.getRemoteUser();
				Rep_List_DAO rdao = new Rep_List_DAO();//過去3か月間の同じゲームに対するレポートの提出回数をカウント
				Teisyutsu = rdao.UpKaisu(Input_Id, GameCode, Date_Changer.CalToString(Now));
				session.setAttribute("up_flg", Teisyutsu);
				NextPage = "/passed/Game_Data_Show.jsp";//詳細画面へフォワード
				}
			}catch(Exception e){
				e.printStackTrace();
				session.setAttribute("errcode", "GData-005");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}
				
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
		}
	}

}
