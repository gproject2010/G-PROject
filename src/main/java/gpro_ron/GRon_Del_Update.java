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
 * Servlet implementation class GRon_Del_Update
 */
public class GRon_Del_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Del_Update() {
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
		
		String Login_ID = request.getRemoteUser();
		
		ServletContext sc = getServletContext();
		session.setAttribute("errcode", "GRon-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean TourokuError = false;
		
		String Req_Keiji_Code = request.getParameter("keijicode");
		
		GRon_Data_TO Req_Taisyou = (GRon_Data_TO)session.getAttribute("keijidata");
		
		try{
			GRon_Data_DAO dao = new GRon_Data_DAO();
			GRon_Data_TO Check_Taisyou = dao.GRon_SyousaiLoad(Req_Keiji_Code);
			
			if(Req_Taisyou.getKaisetsusya_ID().equals(Login_ID)){//ログインしたIDと登録・更新を要求しているIDが同じであることを確認
			if(Req_Taisyou.getKeijiban_Code().equals(Check_Taisyou.getKeijiban_Code())){
				//System.out.println("REQ="+Req_Taisyou.getKeijiban_Code());
				//System.out.println(Check_Taisyou.getKeijiban_Code());
				TourokuError = dao.Del_Update(Req_Keiji_Code);
			}else{
				TourokuError = true;
			}
			
			if(TourokuError != true){
				session.setAttribute("syori", "掲示板の削除");
			NextPage = "/passed/G-PRO_Ron/Update_Kanryou.jsp";
			}else{
				session.setAttribute("errcode", "GRon-402");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}
			}else{//58行目でIDが一致しなかった場合
				session.setAttribute("errcode", "GRon-502");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}
			}catch(Exception ex){
				ex.printStackTrace();
				session.setAttribute("errcode", "GRon-002");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
			
	}

}
