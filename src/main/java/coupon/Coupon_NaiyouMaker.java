package coupon;

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

import k_jyouhou.R_jyouhou_TO;
import pennant_race.PennantData_DAO;
import pennant_race.PennantData_TO;

/**
 * Servlet implementation class Coupon_NaiyouMaker
 */
public class Coupon_NaiyouMaker extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Coupon_NaiyouMaker() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession(true);
		request.setCharacterEncoding("UTF-8");
		session.setAttribute("errcode", "Coupon-001");
		String NextPage = "/passed/Error_Gamen.jsp";
		Calendar Now = new GregorianCalendar();
		try{
		String Coupon_Code = request.getParameter("coupon_code");
		R_jyouhou_TO Seiseki = new R_jyouhou_TO();
		Seiseki = (R_jyouhou_TO)session.getAttribute("seiseki");
		int League_HitCount = 0;
		
		Coupon_Data_TO CouponData = new Coupon_Data_TO();
		Coupon_Data_DAO cdao = new Coupon_Data_DAO();
		
		ArrayList<PennantData_TO> LeagueData = new ArrayList<PennantData_TO>();
		PennantData_DAO pdao = new PennantData_DAO();
		
		CouponData = cdao.Coupon_Data_Load(Coupon_Code, Now);
		LeagueData = pdao.PlayerSeiseki_Load(Seiseki.getk_Id(), CouponData.getLeague_Code());
		League_HitCount = LeagueData.size();
		
		session.setAttribute("coupondata", CouponData);
		
		if(LeagueData.size() == 0){
			LeagueData.add(pdao.League_Load(CouponData.getLeague_Code()));
		}
			
			session.setAttribute("leaguedata", LeagueData);
			session.setAttribute("leaguecount", League_HitCount);
			NextPage = "/passed/Coupon/Coupon_Hendou_Kakunin.jsp";
		
	}catch(Exception ex){
		ex.printStackTrace();
		session.setAttribute("errcode", "Coupon-010");
		NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
	}
	ServletContext sc = getServletContext();
	RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
	rd.forward(request, response);
	}
}
