package g_jyouhou;

//import inputUtility.HttpUtility;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import rep_upload.NewGame_DAO;
import rep_upload.NewGames_TO;
import rep_upload.Rep_List_DAO;
import rep_upload.Rep_List_TO;

/**
 * Servlet implementation class NewGame_SyousaiMaker
 */
public class NewGame_SyousaiMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewGame_SyousaiMaker() {
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
		//選択されたゲームの情報のDAOへの検索依頼・検索結果の受け取り処理
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		Calendar Now = new GregorianCalendar();
		Now.add(Calendar.MONTH, -3);//同じゲームに対するレポートは3か月間受付不可
		
		String Data_Syubetsu = request.getParameter("Data_Syubetsu");
		String GameCode = request.getParameter("GameCode");//検索結果画面(NewGame_Ichiran.jsp)から受け取った検索キー
		String Rep_Code = request.getParameter("rep_code");
		int Teisyutsu = 9999;//過去にこのゲームのレポートを提出しているか
		ArrayList<Rep_List_TO> Comments = new ArrayList<Rep_List_TO>();
		
		session.setAttribute("errcode", "GData-007");
		String NextPage = "/passed/Error_Gamen.jsp";//次に表示するページ
			try{
				//GameCode = HttpUtility.escapeHTML(GameCode);//特殊文字チェック
				//Data_Syubetsu = HttpUtility.escapeHTML(Data_Syubetsu);//特殊文字チェック
				
				if(Data_Syubetsu.equals("newgames")){
				G_Syousai_DAO dao = new G_Syousai_DAO();//詳細情報の検索依頼
				GS_jyouhou_TO GSData = dao.NewGames_SyousaiSeach(GameCode);//検索結果の受け取り
				
				session.setAttribute("syousai", GSData);//検索結果をsessionスコープにセット
				
				String Input_Id = request.getRemoteUser();
				Rep_List_DAO rdao = new Rep_List_DAO();
				Teisyutsu = rdao.UpKaisu(Input_Id, GameCode, Date_Changer.CalToString(Now));//過去3か月間にこのゲームのレポートを何回提出しているか調査
				session.setAttribute("up_flg", Teisyutsu);
				NextPage = "/passed/NewGames/NewGameData_Show.jsp";//詳細画面へフォワード
				
				}else if(Data_Syubetsu.equals("proprep")){
					NewGame_DAO newgamedao = new NewGame_DAO();//詳細情報の検索依頼
					NewGames_TO NewGData = new NewGames_TO();
					NewGData = newgamedao.Prop_Syousai(Rep_Code);//検索結果の受け取り
					
					session.setAttribute("syousai", NewGData);//検索結果をsessionスコープにセット
					
					String Input_Id = request.getRemoteUser();
					Rep_List_DAO rdao = new Rep_List_DAO();
					Comments = rdao.Comment_Loader(Rep_Code);
					Teisyutsu = rdao.HitokotoKaisu(Input_Id, Rep_Code, Date_Changer.CalToString(Now), "proprespdata");//過去にこのゲームのレポートを何回提出しているか調査
					
				session.setAttribute("comments", Comments);
				session.setAttribute("up_flg", Teisyutsu);//検索結果をsessionスコープにセット
				NextPage = "/passed/NewGames/PropData_Show.jsp";//詳細画面へフォワード
				
				}
			}catch(Exception e){
				e.printStackTrace();
				session.setAttribute("errcode", "GData-008");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}
				
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
			return;
		}

}
