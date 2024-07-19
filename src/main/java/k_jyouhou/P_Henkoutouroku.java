package k_jyouhou;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class P_Henkoutouroku
 */
public class P_Henkoutouroku extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public P_Henkoutouroku() {
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
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		session.setAttribute("errcode", "KData-009");
		String NextPage = "/passed/Error_Gamen.jsp";
		boolean tourokuerror = false;
		
		try{
		K_Touroku_TO ChangeData = (K_Touroku_TO)session.getAttribute("h_tourokudata");
		K_jyouhou_TO BaseData = (K_jyouhou_TO)session.getAttribute("pdata");
		
		if(ChangeData != null && BaseData != null){
		K_jyouhou_DAO dao = new K_jyouhou_DAO();
		tourokuerror = dao.P_Data_Upload(ChangeData, BaseData);
		}
		if(tourokuerror == true){
			session.setAttribute("errcode", "KData-309");
			NextPage = "/passed/Error_Gamen.jsp";
		}else{
			R_jyouhou_DAO rdao = new R_jyouhou_DAO();
			R_jyouhou_TO KoushinData = rdao.findkaiin_NById(BaseData.getk_Id());
			session.setAttribute("seiseki", KoushinData);//セッション上の成績データを更新
			session.removeAttribute("h_tourokudata");
			session.removeAttribute("pdata");
			session.setAttribute("action", "プロフィール情報");
			NextPage = "/passed/Kaiin_Henkou_Kanryou.jsp";
		}
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "KData-009");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
	}

}
