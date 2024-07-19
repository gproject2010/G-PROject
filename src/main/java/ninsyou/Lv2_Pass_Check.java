package ninsyou;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.K_jyouhou_DAO;
import k_jyouhou.K_jyouhou_TO;

/**
 * Servlet implementation class Lv2_Pass_Check
 */
public class Lv2_Pass_Check extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Lv2_Pass_Check() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(true);
		session.setAttribute("errcode", "Ninsyou-004");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		String HenkouJyouhou = request.getParameter("henkoujyouhou");//変更する情報の種別
		
		String Kakunin_Id = request.getParameter("id");//IDの確認入力
		
		String Kakunin_Password = request.getParameter("password");//パスワードの確認入力
		
		boolean Henkou_Accept = false;
		
		if(Kakunin_Id == null || Kakunin_Id.equals("") || Kakunin_Password == null || Kakunin_Password.equals("")){
			Kakunin_Id = "empty";
			Kakunin_Password = "empty";
		}
		//if(HenkouJyouhou != null){//入力値を持つリクエストのみ許可する
		try{
		//HenkouJyouhou = HttpUtility.escapeHTML(HenkouJyouhou);//特殊文字チェック
		//Kakunin_Id = HttpUtility.escapeHTML(Kakunin_Id);
		//Kakunin_Password = HttpUtility.escapeHTML(Kakunin_Password);
		
		N_jyouhou_DAO dao = new N_jyouhou_DAO();
		N_jyouhou_TO Result = dao.PassCheck_Lv2(Kakunin_Id);
		
		if(Result != null && Kakunin_Id.equals(Result.getK_Id()) && Kakunin_Password.equals(Result.getK_Password()) &&//認証済み＆追加認証に成功が変更の条件 
				(request.isUserInRole("Master_User") || request.isUserInRole("Reguler_User") || request.isUserInRole("General_User") ||
				request.isUserInRole("Administrator"))){//テスト用にAdministratorを許可
			
			if(HenkouJyouhou.equals("ninsyou_jyouhou")){//認証情報を変更する場合
				Henkou_Accept = dao.Change_Kaisu(Kakunin_Id);
				session.setAttribute("nin_jyouhou", Result);//認証情報をsessionスコープにセット(変更完了時に破棄）
				
				K_jyouhou_DAO kdao = new K_jyouhou_DAO();
				K_jyouhou_TO MailR = kdao.MailCheck_Lv2(Kakunin_Id);//メールアドレス、携帯メールアドレスの取得をDAOに依頼
				session.setAttribute("mail", MailR);
				session.setAttribute("id_accept", Henkou_Accept);
				
			NextPage = "/passed/Ninsyou_Henkou.jsp";
			
				
		/*	
		}else if(HenkouJyouhou.equals("player_jyouhou")){
			NextPage = "/passed/Player_Henkou.jsp";
		}	
		
		}catch(Exception e){
			e.printStackTrace();
			NextPage = "/passed/Kakunin_Error_Lv2.html";
		}*/
			}else if(HenkouJyouhou.equals("player_jyouhou")){
			//try{
				String Id = request.getRemoteUser();
				K_jyouhou_DAO kadao = new K_jyouhou_DAO();
				K_jyouhou_TO P_Data = new K_jyouhou_TO();
				P_Data = kadao.findkaiin_NById(Id);
				if(P_Data != null){
				session.setAttribute("pdata", P_Data);
				//System.out.println(P_Data);					
				NextPage = "/passed/P_jyouhou_Henkou.jsp";
				}
			
		}else if(HenkouJyouhou.equals("taikai_syori")){
			String Id = request.getRemoteUser();
			session.setAttribute("ninsyou_jyouhou", Result);
			if(Id != null && (!(Id.equals("")))){
				NextPage = "/passed/Taikai_Uketsuke.jsp";
			}
		}
				}else{
					//session.setAttribute("errcode", "NinSyou-503");
					NextPage = "/passed/Kaiin_Henkou_Menu.html";
				}

			}catch(Exception e){
				e.printStackTrace();
				session.setAttribute("errcode", "Ninsyou-005");
				NextPage = "/passed/Error_Gamen.jsp";
			}
		ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
		//}
	}

}
