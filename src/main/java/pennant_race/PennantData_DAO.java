package pennant_race;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import k_jyouhou.K_Touroku_TO;
import k_jyouhou.R_jyouhou_TO;
import ninsyou.N_jyouhou_TO;
import coupon.Coupon_Data_TO;

public class PennantData_DAO {

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
	
	public PennantData_TO League_Load(String League_Code){
		PennantData_TO Result = new PennantData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT leaguecode, leaguename, leagueclass, season, round, kounin_jyoukyou, description, startdate, enddate, logofile_name FROM pennantleagues WHERE leaguecode = '" + HttpUtility.escapeSQL(League_Code) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String LeagueCode = rs.getString("leaguecode");
				String LeagueName = rs.getString("leaguename");
				String LeagueClass = rs.getString("leagueclass");
				int Season = rs.getInt("season");
				int Round = rs.getInt("round");
				String Kounin_Jyoukyou = rs.getString("kounin_jyoukyou");
				String Description = rs.getString("description");
				String StartDate = rs.getString("startdate");
				String EndDate = rs.getString("enddate");
				String Logofile_Name = rs.getString("logofile_name");
				Result = new PennantData_TO(LeagueCode, LeagueName, LeagueClass, Season, Round, Kounin_Jyoukyou, Description, StartDate, EndDate, Logofile_Name);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<PennantData_TO> League_Load_All(int Limit){
		ArrayList<PennantData_TO> Result = new ArrayList<PennantData_TO>();
		PennantData_TO list = new PennantData_TO();
		Connection con = null;
		
		try{
			
			String InsertSQL = "";
			if(Limit == 0){
				InsertSQL = " ORDER BY enddate DESC ";
			}else{
				InsertSQL = " ORDER BY enddate DESC LIMIT " + Limit;
			}

			con = createConnection();
			
			String sql = "SELECT leaguecode, leaguename, leagueclass, season, round, kounin_jyoukyou, description, startdate, enddate, logofile_name FROM pennantleagues " + InsertSQL + ";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String LeagueCode = rs.getString("leaguecode");
				String LeagueName = rs.getString("leaguename");
				String LeagueClass = rs.getString("leagueclass");
				int Season = rs.getInt("season");
				int Round = rs.getInt("round");
				String Kounin_Jyoukyou = rs.getString("kounin_jyoukyou");
				String Description = rs.getString("description");
				String StartDate = rs.getString("startdate");
				String EndDate = rs.getString("enddate");
				String Logofile_Name = rs.getString("logofile_name");
				list = new PennantData_TO(LeagueCode, LeagueName, LeagueClass, Season, Round, Kounin_Jyoukyou, Description, StartDate, EndDate, Logofile_Name);
				Result.add(list);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<PennantData_TO> RuikeiStar_Rank(String League_Code, String Order){
		ArrayList<PennantData_TO> Result = new ArrayList<PennantData_TO>();
		PennantData_TO list = new PennantData_TO();
		String insertsql = "";
		Connection con = null;
		
		try{
			
			if(Order == null || Order.equals("ruikei")){
				insertsql = " ORDER BY star_count DESC ";
			}else if(Order.equals("season")){
				insertsql = " ORDER BY season_star DESC ";
			}

			con = createConnection();
			
			String sql = "SELECT leaguecode, leaguename, gpro_id, playername, pref, star_count, season_star FROM pennant_players WHERE leaguecode = '" + HttpUtility.escapeSQL(League_Code) + "'" + insertsql + " LIMIT 50;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String LeagueCode = rs.getString("leaguecode");
				String LeagueName = rs.getString("leaguename");
				String GPRO_ID = rs.getString("gpro_id");
				String Player_Name = rs.getString("playername");
				String Pref = rs.getString("pref");
				int Star_Count = rs.getInt("star_count");
				int Season_Star = rs.getInt("season_star");
				list = new PennantData_TO(LeagueCode, LeagueName, GPRO_ID, Player_Name, Pref, Star_Count, Season_Star);
				Result.add(list);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<PennantData_TO> LeagueTaikaiRireki(String League_Code){
		ArrayList<PennantData_TO> Result = new ArrayList<PennantData_TO>();
		PennantData_TO list = new PennantData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT leaguecode, leaguename, eventcode, eventname FROM league_event WHERE leaguecode = '" + HttpUtility.escapeSQL(League_Code) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String LeagueCode = rs.getString("leaguecode");
				String LeagueName = rs.getString("leaguename");
				String EventCode = rs.getString("eventcode");
				String EventName = rs.getString("eventname");
				list = new PennantData_TO(LeagueCode, LeagueName, EventCode, EventName);
				Result.add(list);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<PennantData_TO> PlayerSeiseki_Load(String Player_ID, String League_Code){
		ArrayList<PennantData_TO> Result = new ArrayList<PennantData_TO>();
		PennantData_TO list = new PennantData_TO();
		Connection con = null;
		
		try{
			con = createConnection();
			
			String sql = "SELECT pennant_players.leaguecode, pennant_players.leaguename, pennant_players.gpro_id, pennant_players.playername, pennant_players.star_count, pennant_players.season_star, pennantleagues.leagueclass, pennantleagues.season" +
					" FROM pennant_players INNER JOIN pennantleagues ON pennant_players.leaguecode = pennantleagues.leaguecode WHERE pennant_players.gpro_id = '" + HttpUtility.escapeSQL(Player_ID) + "' AND pennant_players.leaguecode = '" + HttpUtility.escapeSQL(League_Code) + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String LeagueCode = rs.getString("pennant_players.leaguecode");
				String LeagueName = rs.getString("pennant_players.leaguename");
				String GPRO_ID = rs.getString("pennant_players.gpro_id");
				String Player_Name = rs.getString("pennant_players.playername");
				int Star_Count = rs.getInt("pennant_players.star_count");
				int Season_Star = rs.getInt("pennant_players.season_star");
				String LeagueClass = rs.getString("pennantleagues.leagueclass");
				int Season = rs.getInt("pennantleagues.season");
				String Logofile_Name = rs.getString("pennantleagues.logofile_name");
				list = new PennantData_TO(LeagueCode, LeagueName, GPRO_ID, Player_Name, Star_Count, Season_Star, LeagueClass, Season, Logofile_Name);
				Result.add(list);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public boolean PlayerSeiseki_Upload(PennantData_TO Target, Coupon_Data_TO CouponData){
		Connection con = null;
		String sql = null;
		try{
			con = createConnection();
			
			sql = "UPDATE pennant_players SET star_count = ?, season_star = ? WHERE leaguecode = ? AND gpro_id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Target.getStar_Count() + CouponData.getStar_Bonus());
			pstmt.setInt(2, Target.getSeason_Star() + CouponData.getStar_Bonus());
			pstmt.setString(3, Target.getLeagueCode());
			pstmt.setString(4, Target.getGPRO_ID());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
		return false;
	}
	
	public boolean PlayerSeiseki_Shinki(R_jyouhou_TO PlayerData, PennantData_TO LeagueData, Coupon_Data_TO CouponData){
		Connection con = null;
		String sql = null;
		try{
			con = createConnection();
			
			sql = "INSERT INTO pennant_players(leaguecode, leaguename, gpro_id, playername, pref, star_count, season_star) VALUES(?,?,?,?,?, ?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, LeagueData.getLeagueCode());
			pstmt.setString(2, LeagueData.getLeagueName());
			pstmt.setString(3, PlayerData.getk_Id());
			pstmt.setString(4, PlayerData.getlogin_name());
			pstmt.setString(5, PlayerData.getPref());
			pstmt.setInt(6, CouponData.getStar_Bonus());
			pstmt.setInt(7, CouponData.getStar_Bonus());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
		return false;
	}
	
	public boolean IDHenkou_Upload(K_Touroku_TO ChangeData, N_jyouhou_TO BaseData){
		Connection con = null;
		String sql = null;
		try{
			con = createConnection();
			
			sql = "UPDATE pennant_players SET gpro_id = ? WHERE gpro_id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ChangeData.getKibou_Id());
			pstmt.setString(2, BaseData.getK_Id());
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
		return false;
	}
}
