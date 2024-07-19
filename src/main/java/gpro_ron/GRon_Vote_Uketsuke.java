package gpro_ron;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GRon_Vote_Uketsuke
 */
public class GRon_Vote_Uketsuke extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Vote_Uketsuke() {
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
		ServletContext sc = getServletContext();
		session.setAttribute("errcode", "GRon-008");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		String Vote = request.getParameter("vote");//どれに投票したか
		//Vote = HttpUtility.escapeHTML(Vote);//特殊文字チェック
		String KakikomiNo_S = request.getParameter("no");//投票された書き込みの整理番号
		//KakikomiNo_S = HttpUtility.escapeHTML(KakikomiNo_S);//特殊文字チェック
		int KakikomiNo = Integer.parseInt(KakikomiNo_S);//int型に変換
		
		GRon_Data_TO KeijibanData = (GRon_Data_TO)session.getAttribute("keijidata");
		String Keijiban_Code = KeijibanData.getKeijiban_Code();
		String Input_Id = request.getRemoteUser();//認証情報からIDを取得
		
		GRon_Data_DAO ronDAO = new GRon_Data_DAO();
		boolean UpSccess = ronDAO.Vote_CountUp(Keijiban_Code, Vote, KakikomiNo, Input_Id);
		
		if(UpSccess == true){
			session.setAttribute("syori", "書き込みへの投票");
			NextPage = "/passed/G-PRO_Ron/Update_Kanryou.jsp";
		}else{
			session.setAttribute("errcode", "GRon-308");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}

}
