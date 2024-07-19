package ninsyou;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.K_Touroku_DAO;
import k_jyouhou.K_Touroku_TO;
import k_jyouhou.R_jyouhou_DAO;
import k_jyouhou.R_jyouhou_TO;
import times.Date_Maker;
//import inputUtility.HttpUtility;

/**
 * Servlet implementation class AuthenticationController
 */
public class AuthenticationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected boolean isAuthentication=false;

	public void init() throws ServletException{
		
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticationController() {
        super();
        // TODO Auto-generated constructor stub
    }
    public boolean isAuthentication(){
		return isAuthentication;
	}
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @param <FilterChain>
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected synchronized void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		ServletContext sc = getServletContext();

		String nextPage = null;
		int Error_Kaisu = 20;//接続しているIPアドレスで認証エラーになった回数
		if(request.isUserInRole("shinki")){//ロールが"shinki"(新規入会者)の場合は
			try{
				String Id = request.getRemoteUser();//認証情報から仮IDを取得
				K_Touroku_DAO tdao = new K_Touroku_DAO();
				K_Touroku_TO Mail_Address = tdao.Kari_Load(Id);//DAOに仮ID(照合用)とメールアドレスの検索を依頼
				session.setAttribute("mailaddress", Mail_Address);
				nextPage = "/Shinki_Nyukai_Lv1/Kaiintouroku_p1_nyuryoku.jsp";
			}catch(Exception e){
				e.printStackTrace();
				nextPage = "/free_area/Ninsyou_Error_Gamen.html";
			}
			
		}else if(request.isUserInRole("Master_User_taikai") || request.isUserInRole("Reguler_User_taikai") 
				|| request.isUserInRole("General_User_taikai")){//退会者の場合は
			nextPage = "/passed/Fukki_Uketsuke.jsp";//復帰受付ページへフォワード
			
		}else{//"shinki"または退会者以外のロールの場合は
			
			N_jyouhou_TO BrockData = new N_jyouhou_TO();
			N_jyouhou_DAO ndao = new N_jyouhou_DAO();
			BrockData = ndao.SousaLock_Data();
			Error_Kaisu = ndao.N_ErrorLog_Search(request.getRemoteAddr());
			
			session.setAttribute("brock", BrockData);

		String Input_Id = request.getRemoteUser();//認証情報からIDを取得
		//Input_Id = HttpUtility.escapeHTML(Input_Id);//特殊文字チェック
		if(Input_Id != null){
			try{
				/*
				N_jyouhou_DAO dao = new N_jyouhou_DAO();//DAOに基本情報の検索を依頼
				N_jyouhou_TO Kaiin_n = dao.findkaiin_NById(Input_Id);

					session.setAttribute("input_id", Kaiin_n.getid());
					session.setAttribute("playerdata", Kaiin_n);
					*/
				R_jyouhou_DAO kdao = new R_jyouhou_DAO();//DAOに会員ステータスの検索を依頼
				R_jyouhou_TO Status = kdao.findkaiin_NById(Input_Id);
				
				session.setAttribute("seiseki", Status);
				
				Calendar now = Date_Maker.nowGetter();
				String now_S = Date_Changer.toDateString(now);
				session.setAttribute("nowtime", now_S);
				
				ArrayList<Infomation_TO> InfoData = new ArrayList<Infomation_TO>();
				Infomation_DAO infodao = new Infomation_DAO();
				InfoData = infodao.Info_Serch(0);
				
				session.setAttribute("infomation", InfoData);
				
				if(BrockData.isLogin_Lock() == false){
				nextPage = "/passed/Kaiin_Menu_Top.jsp";
				}else{
					nextPage = "/passed/Login_Block.html";
				}
				
				if(Error_Kaisu > 10){//過去1ヶ月に10回を超えて同じIPアドレスから認証に失敗している場合は(ブルートフォース、辞書攻撃を想定)
					session.invalidate();//確立しているセッションをすべて破棄し
					isAuthentication = false;
					nextPage = "/free_area/Ninsyou_Error_Gamen.html";//認証エラーとする
				}
				
			}catch(Exception e){
				e.printStackTrace();
					nextPage = "/free_area/Ninsyou_Error_Gamen.html";
				}
			}
		}
		
		RequestDispatcher rd = sc.getRequestDispatcher(nextPage);
		rd.forward(request, response);
		//response.sendRedirect(response.encodeRedirectURL(nextPage));
		}
	public void logout(){
		isAuthentication = false;
	}
	}
