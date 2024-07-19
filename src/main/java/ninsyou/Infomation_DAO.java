package ninsyou;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Infomation_DAO {

	private final static String resourceName = "jdbc/t_data";

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
	public ArrayList<Infomation_TO> Info_Serch(int Hani){
		Infomation_TO List = new Infomation_TO();
		ArrayList<Infomation_TO> Result = new ArrayList<Infomation_TO>();
		Connection con = null;
		String Limits = "";
		
		if(Hani > 0){
			Limits = "LIMIT " + Hani;
		}
		
		try{

			con = createConnection();

			String sql = "SELECT infocode, info_syubetsu, keisaidate, subject FROM infodata WHERE (DATEDIFF(ADDDATE(keisaidate, INTERVAL 12 MONTH), NOW()) >= 0) ORDER BY keisaidate DESC " + Limits + ";";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String InfoCode = rs.getString("infocode");
				String Info_Syubetsu = rs.getString("info_syubetsu");
				String KeisaiDate = rs.getString("keisaidate");
				String Kenmei = rs.getString("subject");
				List = new Infomation_TO(InfoCode, Info_Syubetsu, KeisaiDate, Kenmei);
				Result.add(List);
			}
			return Result;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}
	
	public Infomation_TO Info_SyousaiSerch(String Infomation_Code){
		Infomation_TO Result = new Infomation_TO();
		Connection con = null;
		try{

			con = createConnection();

			String sql = "SELECT infocode, info_syubetsu, keisaidate, teiseidate, hasshinmoto, subject, body FROM infodata WHERE (DATEDIFF(ADDDATE(keisaidate, INTERVAL 6 MONTH), NOW()) >= 0) AND infocode = '" + HttpUtility.escapeSQL(Infomation_Code) + "';";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String InfoCode = rs.getString("infocode");
				String Info_Syubetsu = rs.getString("info_syubetsu");
				String KeisaiDate = rs.getString("keisaidate");
				String TeiseiDate = rs.getString("teiseidate");
				String Hassinmoto = rs.getString("hasshinmoto");
				String Kenmei = rs.getString("subject");
				String Honbun_Address = rs.getString("body");
				Result = new Infomation_TO(InfoCode, Info_Syubetsu, KeisaiDate, TeiseiDate, Hassinmoto, Kenmei, Honbun_Address);
			}
			return Result;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}
	public ArrayList<Infomation_TO> Links_Serch(){
		Infomation_TO List = new Infomation_TO();
		ArrayList<Infomation_TO> Result = new ArrayList<Infomation_TO>();
		Connection con = null;
		try{

			con = createConnection();

			String sql = "SELECT sitename, url, link_syubetsu, imageurl FROM linksdata WHERE lock_info = 1;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Kanrisya = rs.getString("sitename");
				String URL = rs.getString("url");
				int Link_Syubetsu = rs.getInt("link_syubetsu");//1=検索エンジン、2=ゲーム関連ブログ
				String ImageURL = rs.getString("imageurl");
				List = new Infomation_TO(Kanrisya, URL, Link_Syubetsu, ImageURL);
				Result.add(List);
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
