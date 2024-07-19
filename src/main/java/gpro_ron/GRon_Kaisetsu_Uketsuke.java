package gpro_ron;

import inputUtility.HttpUtility;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_TO;

/**
 * Servlet implementation class Gron_Kaisetsu_Uketsuke
 */
public class GRon_Kaisetsu_Uketsuke extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GRon_Kaisetsu_Uketsuke() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		
		R_jyouhou_TO KaiinData = (R_jyouhou_TO)session.getAttribute("seiseki");
		GRon_Data_TO KouhoData = new GRon_Data_TO();
		
		session.setAttribute("errcode", "GRon-003");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		boolean NoData = false;
		String NGWord = null;
		boolean SelectError = false;
		boolean WrongMojisu = false;
		
		String Gidai = request.getParameter("gidai");
		String JyoukenSyubetsu = request.getParameter("jyoukensyubetsu");
		String Sc_Syubetsu = request.getParameter("sc_syubetsu");
		String PLv_Min_S = request.getParameter("playerlv_min");
		String PLv_Max_S = request.getParameter("playerlv_max");
		String Sc_Min_S = request.getParameter("sc_min");
		String RankJyouken = request.getParameter("rankjyouken");
		String Rank_Min_S = request.getParameter("rank_min");
		String KaisetsuKikan = request.getParameter("kaisetsukikan");
		String KakikomiJyougen_S = request.getParameter("kakikomijyougen");
		String First_Write = request.getParameter("1st_write");
		String Sex = request.getParameter("sex");
		
		double Sc_Min = 0;
		int PLv_Min = 0;
		int PLv_Max = 9999;
		int Rank_Min = 0;
		int KakikomiJyougen = 1;
		
		Calendar Up_Nichiji = Calendar.getInstance();
		
		String Kaisetsusya = KaiinData.getlogin_name();
		String Kaisetsusya_ID = KaiinData.getk_Id();
		
		try{
		
		if(Gidai == null || Gidai.equals("") || Gidai.equals("入力してください")){
			NoData = true;
		}else{
		//Gidai = HttpUtility.escapeHTML(Gidai);
		if(HttpUtility.NG_Word_Check(Gidai) != null){
			NGWord = HttpUtility.NG_Word_Check(Gidai);
		}
		if(Gidai.length() > 30){
			WrongMojisu = true;
		}
	}
		
		if(First_Write == null || First_Write.equals("") || First_Write.equals("ここに入力してください")){
			NoData = true;
		}else{
			//First_Write = HttpUtility.escapeHTML(First_Write);
			//First_Write = First_Write.replaceAll("\n", "<br>");
			if(HttpUtility.NG_Word_Check(First_Write) != null){
				NGWord = HttpUtility.NG_Word_Check(First_Write);
			}
		}
		if(First_Write.length() > 200){
			WrongMojisu = true;
		}
		
		if(JyoukenSyubetsu == null || JyoukenSyubetsu.equals("")){
			SelectError = true;
		}else{
			//JyoukenSyubetsu = HttpUtility.escapeHTML(JyoukenSyubetsu);
		}
		
		if(Sc_Syubetsu == null || Sc_Syubetsu.equals("")){
			SelectError = true;
		}else{
			//Sc_Syubetsu = HttpUtility.escapeHTML(Sc_Syubetsu);
		}
		
		//Sc_Min_S = HttpUtility.escapeHTML(Sc_Min_S);
		//PLv_Min_S = HttpUtility.escapeHTML(PLv_Min_S);
		//PLv_Max_S = HttpUtility.escapeHTML(PLv_Max_S);
		
		Sc_Min = Double.parseDouble(Sc_Min_S);
		PLv_Min = Integer.parseInt(PLv_Min_S);
		PLv_Max = Integer.parseInt(PLv_Max_S);
		
		//RankJyouken = HttpUtility.escapeHTML(RankJyouken);
		//Rank_Min_S = HttpUtility.escapeHTML(Rank_Min_S);
		Rank_Min = Integer.parseInt(Rank_Min_S);
		
		if(KaisetsuKikan == null || KaisetsuKikan.equals("")){
			SelectError = true;
		}else{
			//KaisetsuKikan = HttpUtility.escapeHTML(KaisetsuKikan);
		}
		
		if(KakikomiJyougen_S == null || KakikomiJyougen_S.equals("")){
			SelectError = true;
		}else{
			//KakikomiJyougen_S = HttpUtility.escapeHTML(KakikomiJyougen_S);
			KakikomiJyougen = Integer.parseInt(KakikomiJyougen_S);
		}
		
		if(Sex != null && (Sex.equals("男性") || Sex.equals("女性"))){
			if(HttpUtility.NG_Word_Check(Sex) != null){
				NGWord = HttpUtility.NG_Word_Check(Sex);
			}
		}else{
			SelectError = true;
		}
		
		KouhoData = new GRon_Data_TO(Gidai, Up_Nichiji, KaisetsuKikan, Kaisetsusya, Kaisetsusya_ID, First_Write, JyoukenSyubetsu, PLv_Min, PLv_Max, Sc_Syubetsu, Sc_Min, RankJyouken, Rank_Min, Sex, KakikomiJyougen, NoData, NGWord, SelectError, WrongMojisu);
		
		session.setAttribute("kouhodata", KouhoData);
		if(NGWord != null || NoData == true || SelectError == true){
			NextPage = "/passed/G-PRO_Ron/GRon_Kaisetsu_Syusei.jsp";
		}else{
		NextPage = "/passed/G-PRO_Ron/GRon_Kaisetsu_Kakunin.jsp";
		}
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "GRon-003");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}

}
