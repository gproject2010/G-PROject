package gpro_ron;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GRon_Wrong_Update
 */
public class GRon_Wrong_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Wrong_Update() {
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
		session.setAttribute("errcode", "GRon-010");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
		GRon_Data_TO Del_Taisyou = (GRon_Data_TO) session.getAttribute("wrong_taisyou");
		
		String Login_ID = request.getRemoteUser();
		
		if(Login_ID.equals(Del_Taisyou.getKijyutsusya_ID())){//ログインしたIDと登録・更新を要求しているIDが同じであることを確認
		GRon_Data_DAO dao = new GRon_Data_DAO();
		boolean TourokuError = dao.Kakikomi_KariSakujyo(Del_Taisyou.getKeijiban_Code(), Del_Taisyou.getKakikomi_No(), Login_ID);
		if(TourokuError == false){
			session.setAttribute("syori", "規約違反の報告");
			NextPage = "/passed/G-PRO_Ron/Update_Kanryou.jsp";
		}
		}else{
			session.setAttribute("errcode", "GRon-210");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "GRon-010");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
