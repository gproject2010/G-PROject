package location;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class LocateData_DAO {

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
	
	public ArrayList<String> NewLocate_Load(){
		ArrayList<String> Result = new ArrayList<String>();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT locatename FROM locatedata ORDER BY keisaidate DESC LIMIT 10;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Locate_Name = rs.getString("locatename");
				Result.add(Locate_Name);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
}
	
	public LocateData_TO LocateSyubetsu_Load(String LocateName){
		LocateData_TO Result = new LocateData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT locatename, locatecode, locate_syubetsu FROM location WHERE locatename = '" + HttpUtility.escapeSQL(LocateName) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Locate_Name = rs.getString("locatename");
				String Locate_Code = rs.getString("locatecode");
				String Locate_Syubetsu = rs.getString("locate_syubetsu");
				Result = new LocateData_TO(Locate_Name, Locate_Code, Locate_Syubetsu);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
}
	
	public LocateData_TO AmuseData_Load(String LocateName){
		LocateData_TO Result = new LocateData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT freefile_name, locatename, address, telno, eigyoujikan, locate_hp, parking, cigar, bariafree, indoor_shisetsu, outdoor_shisetsu, games, access FROM locatedata WHERE locatename = '" + HttpUtility.escapeSQL(LocateName) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String FreeFile_Name = rs.getString("freefile_name");
				String Locate_Name = rs.getString("locatename");
				String Address = rs.getString("address");
				String TelNo = rs.getString("telno");
				String Eigyoujikan = rs.getString("eigyoujikan");
				String Locate_HP = rs.getString("locate_hp");
				String Parking = rs.getString("parking");
				String Cigar = rs.getString("cigar");
				String BariaFree = rs.getString("bariafree");
				String Indoor_Shisetsu = rs.getString("indoor_shisetsu");
				String Outdoor_Shisetsu = rs.getString("outdoor_shisetsu");
				String Games = rs.getString("games");
				String Access = rs.getString("access");
				Result = new LocateData_TO(FreeFile_Name, Locate_Name, Address, TelNo, Eigyoujikan, Locate_HP, Parking, Cigar, BariaFree, Indoor_Shisetsu, Outdoor_Shisetsu, Games, Access);
			}
				return Result;
			}catch(SQLException e ){
				e.printStackTrace();
				return null;
				
			}finally{
				closeConnection(con);
			}
	}
	
	public LocateData_TO ConsumeData_Load(String LocateName){
		LocateData_TO Result = new LocateData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT freefile_name, locatename, address, telno, eigyoujikan, locate_hp, parking, access, platform, cardgame, oldgames FROM locatedata WHERE locatename = '" + HttpUtility.escapeSQL(LocateName) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String FreeFile_Name = rs.getString("freefile_name");
				String Locate_Name = rs.getString("locatename");
				String Address = rs.getString("address");
				String TelNo = rs.getString("telno");
				String Eigyoujikan = rs.getString("eigyoujikan");
				String Locate_HP = rs.getString("locate_hp");
				String Parking = rs.getString("parking");
				String Access = rs.getString("access");
				String Platform = rs.getString("platform");
				String CardGame = rs.getString("cardgame");
				String OldGames = rs.getString("oldgames");
				Result = new LocateData_TO(FreeFile_Name, Locate_Name, Address, TelNo, Eigyoujikan, Locate_HP, Parking, Access, Platform, CardGame, OldGames);
			}
				return Result;
			}catch(SQLException e ){
				e.printStackTrace();
				return null;
				
			}finally{
				closeConnection(con);
			}
	}
	
	public LocateData_TO TokusetsuData_Load(String LocateName){
		LocateData_TO Result = new LocateData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT freefile_name, locatename, address, telno, eigyoujikan, locate_hp, parking, access FROM locatedata WHERE locatename = '" + HttpUtility.escapeSQL(LocateName) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String FreeFile_Name = rs.getString("freefile_name");
				String Locate_Name = rs.getString("locatename");
				String Address = rs.getString("address");
				String TelNo = rs.getString("telno");
				String Eigyoujikan = rs.getString("eigyoujikan");
				String Locate_HP = rs.getString("locate_hp");
				String Parking = rs.getString("parking");
				String Access = rs.getString("access");
				Result = new LocateData_TO(FreeFile_Name, Locate_Name, Address, TelNo, Eigyoujikan, Locate_HP, Parking, Access);
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
