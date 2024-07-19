package coupon;

import inputUtility.Date_Changer;
import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Coupon_Data_DAO {
	private final static String resourceName = "jdbc/event";
	public static double Hendou_D = 0;
	private Connection createConnection(){
		try{
			InitialContext ic = new InitialContext();

			DataSource ds = (DataSource)ic.lookup("java:comp/env/"+resourceName);

			Connection con = ds.getConnection();
			return con;
		}catch(SQLException ex ){
			ex.printStackTrace();
		}catch(NamingException ex ){
			ex.printStackTrace();
		}
		return null;
	}

	protected void closeConnection(Connection con ){
		try{
			con.close();
		}catch(Exception ex ){}

	}
	
	public Coupon_Data_TO Coupon_Data_Load(String Coupon_Code, Calendar Now){
		Coupon_Data_TO Result = new Coupon_Data_TO();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT coupon_code, league_code, coupon_name, coupon_from, use_limit, repscore_bonus, actscore_bonus, star_bonus, syougou_list, coupon_jyoukyou FROM coupon_release " +
					" WHERE coupon_code = '" + HttpUtility.escapeSQL(Coupon_Code) + "' AND use_limit > '" + Date_Changer.toDateString(Now) + "' AND coupon_jyoukyou != '受取済';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String[] SyougouList = null;
				
				String CouponCode = rs.getString("coupon_code");
				String LeagueCode = rs.getString("league_code");//特典を適用するペナントレースのリーグコード
				String CouponName = rs.getString("coupon_name");
				String CouponFrom = rs.getString("coupon_from");
				String UseLimit = rs.getString("use_limit");
				double RepscoreBonus = rs.getDouble("repscore_bonus");
				double ActscoreBonus = rs.getDouble("actscore_bonus");
				int StarBonus = rs.getInt("star_bonus");
				String SyougouList_S = rs.getString("syougou_list");
				String CouponJyoukyou = rs.getString("coupon_jyoukyou");
				
				if(SyougouList_S != null && (!(SyougouList_S.equals("")))){
					SyougouList = SyougouList_S.split("plus;");
				}else{
					SyougouList = new String[1];
					SyougouList[0] = "今回称号の獲得はありません";
				}
				
				Result = new Coupon_Data_TO(CouponCode, LeagueCode, CouponName, CouponFrom, UseLimit, RepscoreBonus, ActscoreBonus, StarBonus, SyougouList, CouponJyoukyou);
			}
			return Result;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
				}
	
	public boolean Coupon_Mukouka(String CouponCode){
		Connection con = null;
		boolean TourokuError = false;
		try{

			con = createConnection();
			String sql = "UPDATE coupon_release SET coupon_jyoukyou = ? WHERE coupon_code = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, "受取済み");
			pstmt.setString(2, CouponCode);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			TourokuError = true;
		}finally{
			closeConnection(con);
		}
		return TourokuError;
	}
}
