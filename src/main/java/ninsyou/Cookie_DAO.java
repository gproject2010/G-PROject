package ninsyou;

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

public class Cookie_DAO {

	private final static String resourceName = "jdbc/n_data";

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
	
	public ArrayList<Cookie_TO> Cookie_TourokuCounter(String GPRO_ID){
		Connection con = null;
		Cookie_TO tmp = new Cookie_TO();
		ArrayList<Cookie_TO> Result = new ArrayList<Cookie_TO>();
		try{

			con = createConnection();

			String sql = "SELECT gpro_id, cookie, hostname, hakkounichiji FROM cookies WHERE gpro_id = '" + HttpUtility.escapeSQL(GPRO_ID) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String GPRO_Id = rs.getString("gpro_id");
				String Cookie = rs.getString("cookie");
				String HostName = rs.getString("hostname");
				String Hakkounichiji = rs.getString("hakkounichiji");
				tmp = new Cookie_TO(GPRO_Id, Cookie, HostName, Hakkounichiji);
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
	
	public int Cookie_ShinkiTouroku(Cookie_TO TourokuData){
		Connection con = null;
		try{
			con = createConnection();
			
			String sql = "INSERT INTO cookies (gpro_id, cookie, hostname, hakkounichiji) VALUES(?,?,?,NOW());";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, TourokuData.getGPRO_ID());
			pstmt.setString(2, TourokuData.getCookie());
			pstmt.setString(3, TourokuData.getHostName());
			pstmt.setString(4, TourokuData.getHakkounichiji());
			pstmt.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}finally{
			closeConnection(con);
		}
		return 0;
	}
	
	public int Cookie_UwagakiTouroku(Cookie_TO TourokuData, String GPRO_ID, String HostName, String HakkouNichiji){
		Connection con = null;
		try{
			con = createConnection();
			
			String sql = "UPDATE cookies SET gpro_id = ?, cookie = ?, hostname = ?, hakkounichiji = ? WHERE gpro_id = ? AND hostname = ?, hakkounichiji = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, TourokuData.getGPRO_ID());
			pstmt.setString(2, TourokuData.getCookie());
			pstmt.setString(3, TourokuData.getHostName());
			pstmt.setString(4, TourokuData.getHakkounichiji());
			pstmt.setString(5, GPRO_ID);
			pstmt.setString(6, HostName);
			pstmt.setString(7, HakkouNichiji);
pstmt.executeUpdate();
			
			
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}finally{
			closeConnection(con);
		}
		return 0;
	}
}
