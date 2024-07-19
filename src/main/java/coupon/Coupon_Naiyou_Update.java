package coupon;

import inputUtility.Date_Changer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k_jyouhou.R_jyouhou_DAO;
import k_jyouhou.R_jyouhou_TO;
import pennant_race.PennantData_DAO;
import pennant_race.PennantData_TO;

/**
 * Servlet implementation class Coupon_Naiyou_Update
 */
public class Coupon_Naiyou_Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Coupon_Naiyou_Update() {
        super();
        // TODO Auto-generated constructor stub
    }

    @SuppressWarnings("unchecked")
    public static <T> T automaticCast(Object src) {
        T castedObject = (T) src;  
        return castedObject;
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
		Calendar Now = Calendar.getInstance();
		String Now_S = Date_Changer.toDateString(Now);
		boolean TourokuError = false;
		int ErrorCount = 0;
		session.setAttribute("errcode", "Coupon-002");
		String NextPage = "/passed/Error_Gamen.jsp";
		try{
			R_jyouhou_TO PlayerData = new R_jyouhou_TO();
			PlayerData = (R_jyouhou_TO)session.getAttribute("seiseki");
			
			Coupon_Data_TO CouponData = new Coupon_Data_TO();
			CouponData = (Coupon_Data_TO)session.getAttribute("coupondata");
			
			ArrayList<PennantData_TO> LeagueData = new ArrayList<PennantData_TO>();
			LeagueData = automaticCast(session.getAttribute("leaguedata"));
			
			int LeagueCount = (Integer)session.getAttribute("leaguecount");
			
			Coupon_Data_DAO cdao = new Coupon_Data_DAO();
			TourokuError = cdao.Coupon_Mukouka(CouponData.getCoupon_Code());
			if(TourokuError == true){
				ErrorCount++;
			}
			
			PennantData_DAO pdao = new PennantData_DAO();
			if(LeagueCount == 0){
				TourokuError = pdao.PlayerSeiseki_Shinki(PlayerData, LeagueData.get(0), CouponData);
			}else{
			for(int i=0; i < LeagueData.size(); i++){
				if(CouponData != null && CouponData.getLeague_Code().equals(LeagueData.get(i).getLeagueCode())){
					TourokuError = pdao.PlayerSeiseki_Upload(LeagueData.get(i), CouponData);
					if(TourokuError == true){
						ErrorCount++;
					}
				}
			}
			}
			R_jyouhou_DAO rdao = new R_jyouhou_DAO();
			TourokuError = rdao.Coupon_Tekiyou(PlayerData, CouponData, Now_S);
			if(TourokuError == true){
				ErrorCount++;
			}
			
			
			session.setAttribute("result", ErrorCount);
			session.removeAttribute("coupondata");
			NextPage = "/passed/Coupon/Coupon_Tekiyou_Result.jsp";
			
		}catch(Exception ex){
			ex.printStackTrace();
			session.setAttribute("errcode", "Coupon-110");
			NextPage = "/passed/Error_Gamen.jsp";//まだ作ってない
		}
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
		rd.forward(request, response);
		}
}
