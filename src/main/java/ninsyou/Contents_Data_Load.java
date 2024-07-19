package ninsyou;

import java.io.IOException;
import java.util.ArrayList;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import event.EventData_DAO;
import event.EventData_TO;
import g_jyouhou.Rep_Load_DAO;
import gpro_riron.GPRiron_DAO;
import gpro_riron.GPRiron_TO;
import gpro_ron.GRon_Data_DAO;
import gpro_ron.GRon_Data_TO;
import location.LocateData_DAO;
import location.RaitenData_DAO;
import location.RaitenData_TO;
import pennant_race.PennantData_DAO;
import pennant_race.PennantData_TO;
import rep_upload.NewGame_DAO;
import rep_upload.NewGames_TO;
import rep_upload.Rep_Koumoku;
import voteandExpect.VoAndExp_DAO;
import voteandExpect.VoAndExp_TO;

/**
 * Servlet implementation class Contents_Data_Load
 */
public class Contents_Data_Load extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contents_Data_Load() {
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
		ServletContext application = getServletContext();
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "TopMake-001");
		String NextPage = "/free_area/Error_Gamen.jsp";

		try{
			String PageTo = request.getParameter("pageto");
//			String UserAgent = request.getHeader("user-agent");
//			int Device_Syubetsu = this.UserAgent_Hantei(UserAgent);

			GRon_Data_DAO ronDAO = new GRon_Data_DAO();
			ArrayList<GRon_Data_TO> GronData = ronDAO.GRon_IndexLoad();

			GPRiron_DAO rironDAO = new GPRiron_DAO();
			ArrayList<GPRiron_TO> GRironData = rironDAO.RironGaiyou_Load();

			VoAndExp_DAO voDAO = new VoAndExp_DAO();
			ArrayList<VoAndExp_TO> VoExpData = voDAO.AncIndex_Serch();
			ArrayList<VoAndExp_TO> FreeVoExpData = voDAO.FreeAnc_IndexSerch();
			ArrayList<VoAndExp_TO> VoAndExp_VoteLog = voDAO.IndexVo_LogLoad(FreeVoExpData);

			Infomation_DAO infoDAO = new Infomation_DAO();
			ArrayList<Infomation_TO> InfoData = infoDAO.Info_Serch(5);

			PennantData_DAO penDAO = new PennantData_DAO();
			ArrayList<PennantData_TO> PennantData = penDAO.League_Load_All(5);

			NewGame_DAO newgameDAO = new NewGame_DAO();
			ArrayList<NewGames_TO> PropData = newgameDAO.Prop_Info(5);

			EventData_DAO eventdao = new EventData_DAO();
			ArrayList<EventData_TO> EventData = eventdao.EventIndex_Load();

			LocateData_DAO locateDAO = new LocateData_DAO();
			ArrayList<String> Locates = locateDAO.NewLocate_Load();

			RaitenData_DAO raitenDAO = new RaitenData_DAO();
			ArrayList<RaitenData_TO> RaitenData = raitenDAO.SyutsubotsuJyouhou_Load();

			Rep_Load_DAO repdao = new Rep_Load_DAO();
			ArrayList<Rep_Koumoku> HitokotoRep = repdao.WordRep_TopLoad();

			ArrayList<Infomation_TO> LinksData = new ArrayList<Infomation_TO>();
			ArrayList<Infomation_TO> EngineLinks = new ArrayList<Infomation_TO>();
			ArrayList<Infomation_TO> BlogLinks = new ArrayList<Infomation_TO>();

			N_jyouhou_DAO lockDAO = new N_jyouhou_DAO();
			N_jyouhou_TO LockData = lockDAO.SousaLock_Data();

			LinksData = infoDAO.Links_Serch();

			for(Infomation_TO list : LinksData){
				if(list.getLink_Syubetsu() == 1){//1=検索エンジン、2=ゲーム関連ブログ
					EngineLinks.add(list);
				}else if(list.getLink_Syubetsu() == 2){
					BlogLinks.add(list);
				}
			}

			application.setAttribute("gronindex", GronData);
			application.setAttribute("rironindex", GRironData);
			application.setAttribute("voexpindex", VoExpData);
			application.setAttribute("freevoexpindex", FreeVoExpData);
			application.setAttribute("freevoexpvote", VoAndExp_VoteLog);
			application.setAttribute("infoindex", InfoData);
			application.setAttribute("propindex", PropData);
			application.setAttribute("eventindex", EventData);
			application.setAttribute("pennantindex", PennantData);
			application.setAttribute("wordrepindex", HitokotoRep);
			application.setAttribute("raitenindex", RaitenData);

			application.setAttribute("enginelinks", EngineLinks);
			application.setAttribute("bloglinks", BlogLinks);
			application.setAttribute("locates", Locates);

			application.setAttribute("lockdata", LockData);

//			if(Device_Syubetsu == 1){
			if(PageTo == null){
			NextPage = "/free_area/G-PROject_Top.jsp";
			}else if(PageTo.equals("consume")){
				NextPage = "/free_area/G-PROject_ConsumeTop.jsp";
			}else if(PageTo.equals("arcade")){
				NextPage = "/free_area/G-PROject_ArcadeTop.jsp";
			}else{
				NextPage = "/free_area/G-PROject_Top.jsp";
			}

//			}else if(Device_Syubetsu == 2){
//				NextPage = "/free_area/G-PROject_MobileTop.jsp"; //まだ作ってない
//			}
		}catch(Exception ex){
			//session.setAttribute("errcode", "TopMake-001");
			//NextPage = "/free_area/Error_Gamen.jsp";//まだ作ってない
			ex.printStackTrace();
		}

//		ServletContext sc = getServletContext();
		RequestDispatcher rd = application.getRequestDispatcher(NextPage);
		rd.forward(request, response);

	}
/*
	protected int UserAgent_Hantei(String UserAgent){
		Pattern pattern = Pattern.compile("iPhone|Android.*Mobile|Windows.*Phone");
		Matcher matcher = pattern.matcher(UserAgent);
		boolean isMatch = matcher.matches();
		if(isMatch == true){
			return 2;
		}else{
			return 1;
		}
	}
	*/
}

