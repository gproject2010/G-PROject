package g_jyouhou;

//import inputUtility.HttpUtility;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;
import rep_upload.Rep_List_TO;

/**
 * Servlet implementation class BestReportMaker
 */
public class BestReportMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BestReportMaker() {
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
		
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		
		String Rep_Code = request.getParameter("rep_code");//ゲームデータ表示画面(Game_Data_Show.jsp)から受け取った検索キー（レポートコード）
		String Rep_Syubetsu = Rep_Code.substring(0, 2);//レポートコードの最初の2文字（レポートの種類）を抽出
		/*
		int Shijisyasu = 0;
		int Fushijisyasu = 0;*/
		String YourVote = "empty";
		
		session.setAttribute("errcode", "GRon-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		if(Rep_Code != null){
			try{
			//Rep_Code = HttpUtility.escapeHTML(Rep_Code);//特殊文字チェック
			
			Rep_Load_DAO dao = new Rep_Load_DAO();//レポートの内容の検索依頼（Rep_Load_DAOへ）※1つのレポートを直接指定しているため検索結果も1つ
			Rep_List_TO RData = dao.BestRep_Load(Rep_Code, KaiinData.getk_Id());//TOはrep_uploadパッケージのRep_List_TOを流用
			if(RData == null){
				session.setAttribute("errcode", "GData-101");
				NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
			}else{
			/*
			if(RData.getShijisyaList() != null || RData.getShijisyaList().equals("NO_DATA")){
			if(RData.getShijisyaList().indexOf(KaiinData.getk_Id()) != -1){
				YourVote = "shiji";
			}
			}else if(RData.getFushijisyaList() != null || RData.getShijisyaList().equals("NO_DATA")){
			if(RData.getFushijisyaList().indexOf(KaiinData.getk_Id()) != -1){
				YourVote = "fushiji";
			}
			}else{
				YourVote = "empty";
			}
			*/
				
				if(RData.getYourVote() == null){
					YourVote = "empty";
				}else{
					YourVote = RData.getYourVote();
				}
				
			Rep_List_TO Votedata = new Rep_List_TO(RData.getShijisyasu(), RData.getFushijisyasu(), YourVote);
			
			session.setAttribute("bestrep", RData);//検索結果をsessionにセット
			session.setAttribute("vote", Votedata);
			
			if(Rep_Syubetsu.equals("ox")){//レポートの種類がOXだった場合
			NextPage = "/passed/OX_Report/OX_BestReport.jsp";
			
		}else if(Rep_Syubetsu.equals("ki")){//同じく記事レポートの場合
			NextPage = "/passed/Kiji_Report/Kiji_BestReport.jsp";
		
		}else if(Rep_Syubetsu.equals("fr")){//同じく自由形式の場合
			NextPage = "/passed/Free_Report/Free_BestReport.jsp";
		}
			}
	}catch(Exception e){//エラーが発生した場合
		e.printStackTrace();
		session.setAttribute("errcode", "GData-001");
		NextPage = "/passed/Error_Gamen.jsp";
	}
		}
	
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
		}
}
