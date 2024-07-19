package rep_upload;

//import g_jyouhou.GS_jyouhou_TO;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpSession;

//import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Report_Upload_Info
 */
public class Report_Upload_Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Report_Upload_Info() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {//不要なメソッド
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		session.setAttribute("errcode", "Rep-014");
		String NextPage = "/passed/Error_Gamen.jsp";
		/*
		GS_jyouhou_TO gamedata = (GS_jyouhou_TO) session.getAttribute("syousai");
		R_jyouhou_TO kaiindata = (R_jyouhou_TO) session.getAttribute("seiseki");
		
		Rep_Koumoku rep_data = null;
		boolean tourokuerror = false;
		rep_data = (Rep_Koumoku)session.getAttribute("freehyouka");
		
		String gamecode = gamedata.getGamecode();
		String gametitle = gamedata.getGametitle();
		
		String report_code = コードのつけ方が未定のためコメントアウト
		String upload_date =
		String hyouka_rank = 
		boolean tensaku_flg =
		
		String k_id = kaiindata.getk_Id();
		String login_name = kaiindata.getlogin_name();
		
		double dificultty = rep_data.getdificultty();
		double story = rep_data.getstory();
		double graphic = rep_data.getgraphic();
		double sound = rep_data.getsound();
		double volume = rep_data.getvolume();
		double controll = rep_data.getcontroll();
		double promotion = rep_data.getpromotion();
		double free_S = rep_data.getfree_S();
		double total = rep_data.gettotal();
		String outline = rep_data.getoutline();
		
		String[] Interview1 = null;
		Interview1 = rep_data.getInterview1();
		
		String Interview2 = rep_data.getInterview2();
		
		String[] Interview3 = null;
		Interview3 = rep_data.getInterview3();
		
		String Interview4 = rep_data.getInterview4();
		
		String Interview5 = rep_data.getInterview5();
		
		String Interview6 = rep_data.getInterview6();
		
		String UploadFileName = rep_data.getUploadfilename();
		
		Rep_List_TO freedata = new Rep_List_TO(gamecode, gametitle, k_id, login_name,
				dificultty, story, graphic, sound, volume, controll, promotion, free_S, total,
				outline, Interview1, Interview2, Interview3, Interview4, Interview5, Interview6, UploadFileName);
		
		Rep_List_DAO freedao = new Rep_List_DAO();
		tourokuerror = freedao.kiji_touroku(freedata);
		*/
		try{
		ServletContext sc = getServletContext();
		String storePath = sc.getRealPath("");
		
		File_Upload_Utility.execute(request, storePath);
		NextPage = "/passed/Rep_Uketsuke_Kanryou";
		
		}catch(Exception e){
			e.printStackTrace();
			session.setAttribute("errcode", "Rep-014");
			NextPage = "/passed/Error_Gamen.jsp";
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		
	}

}
