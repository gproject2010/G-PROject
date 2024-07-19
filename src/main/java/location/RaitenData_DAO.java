package location;

import inputUtility.Date_Changer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class RaitenData_DAO {

	private final static String resourceName = "jdbc/event";
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
	
	public ArrayList<RaitenData_TO> SyutsubotsuJyouhou_Load(){
		RaitenData_TO tmp = new RaitenData_TO();
		ArrayList<RaitenData_TO> Result = new ArrayList<RaitenData_TO>();
		Calendar now = Calendar.getInstance();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT gpro_id, player_name, area, shop_code, shop_name, city, login_date, logout_date FROM raiten_log AS log" +
					" WHERE NOT EXISTS(SELECT gpro_id, player_name, area, shop_code, shop_name, city, login_date, logout_date FROM raiten_log" +
					" WHERE login_date >= '" + Date_Changer.CalToString(now) + "00:00:00'" + " AND player_name = log.player_name AND login_date > log.login_date) LIMIT 10;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String GPRO_ID = rs.getString("gpro_id");
				String Player_Name = rs.getString("player_name");
				String Area = rs.getString("area");
				String Shop_Code = rs.getString("shop_code");
				String Shop_Name = rs.getString("shop_name");
				String City = rs.getString("city");
				String Login_Date = rs.getString("login_date");
				String Logout_Date = rs.getString("logout_date");
				tmp = new RaitenData_TO(GPRO_ID, Player_Name, Area, Shop_Code, Shop_Name, City, Login_Date, Logout_Date, now);
				Result.add(tmp);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
}
