package gpro_ron;

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

import k_jyouhou.R_jyouhou_DAO;
import k_jyouhou.R_jyouhou_TO;
//import inputUtility.HttpUtility;

/**
 * Servlet implementation class GPRO_Ron_ToppageMaker
 */
public class GPRO_Ron_ToppageMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GPRO_Ron_ToppageMaker() {
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
		session.setAttribute("errcode", "GRon-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		Calendar Now = new GregorianCalendar();
		Calendar ShimekiriNichiji_C = new GregorianCalendar();
		
		try{
		String Input_Id = request.getRemoteUser();//認証情報からIDを取得
		//Input_Id = HttpUtility.escapeHTML(Input_Id);//特殊文字チェック
		if(Input_Id != null){
			R_jyouhou_DAO kdao = new R_jyouhou_DAO();//DAOに会員ステータスの検索を依頼
			R_jyouhou_TO Status = kdao.findkaiin_NById(Input_Id);
			session.setAttribute("seiseki", Status);//会員ステータスを更新
		}
		GRon_Data_DAO ronDAO = new GRon_Data_DAO();
		ArrayList<GRon_Data_TO> GronData = ronDAO.GRon_Gaiyou_Load();//検索結果表示用の概要データを検索
		if(GronData == null){
			session.setAttribute("errcode", "GRon-101");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		
		ArrayList<GRon_Data_TO> Now_Info = new ArrayList<GRon_Data_TO>();//書き込み・投票受付中の掲示板
		ArrayList<GRon_Data_TO> End_Info = new ArrayList<GRon_Data_TO>();//書き込み・投票受付が終了した掲示板
		int diff = 0;//締切日時との日数差
		for(GRon_Data_TO Bef : GronData){
			ShimekiriNichiji_C = Date_Changer.toCalendar(Bef.getShimekiriNichiji());
			diff = Now.compareTo(ShimekiriNichiji_C);
			if(diff < 0){//現在日時が締切日時を過ぎていない(受付中)の場合
				Now_Info.add(Bef);//受付中の掲示板として登録
			}else if(Bef.getTotalRespCount() != 0){//現在日時が締切日時を過ぎている(受付終了)の場合※レスポンス数が0の場合は表示しない
				End_Info.add(Bef);//受付を締め切った掲示板として登録
			}
		}
		session.setAttribute("nowinfo", Now_Info);
		session.setAttribute("endinfo", End_Info);
		//System.out.println(End_Info.isEmpty());
		
		NextPage = "/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp";
		//System.out.println("NP="+NextPage);
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "GRon-001");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
	session.setAttribute("int", 1);
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}
}
