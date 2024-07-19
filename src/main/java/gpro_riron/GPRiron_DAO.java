package gpro_riron;

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

public class GPRiron_DAO {
	private final static String resourceName = "jdbc/gpro_ron";
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
	
	public ArrayList<GPRiron_TO> RironGaiyou_Load(){
		GPRiron_TO list = new GPRiron_TO();
		ArrayList<GPRiron_TO> Gaiyou = new ArrayList<GPRiron_TO>();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT ronbuncode, ronbuntitle, player_id, player_name, uploaddate, koushindate FROM rirondata WHERE (DATEDIFF(uploaddate, NOW()) <= 0) AND (DATEDIFF(uploaddate, NOW()) <= 365) AND (lock_info = 1);";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String RonbunCode = rs.getString("ronbuncode");
				String RonbunTitle = rs.getString("ronbuntitle");
				String Player_Id = rs.getString("player_id");
				String PlayerName = rs.getString("player_name");
				String UploadDate = rs.getString("uploaddate");
				String KoushinDate = rs.getString("koushindate");
				list = new GPRiron_TO(RonbunCode, RonbunTitle, Player_Id, PlayerName, UploadDate, KoushinDate);
				Gaiyou.add(list);
			}
			return Gaiyou;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
	
	public GPRiron_TO RironSyousai_Load(String RonbunCode){
		GPRiron_TO Result = new GPRiron_TO();
		Connection con = null;
		try{
			String[] ShijisyaList = null;
			String[] FushijisyaList = null;
			con = createConnection();
			
			String sql = "SELECT ronbuncode, ronbuntitle, player_id, player_name, uploaddate, koushindate, shijisyalist, fushijisyalist, htmlfilename, imagefilename1, imagefilename2, imagefilename3 FROM rirondata WHERE ronbuncode = '" + HttpUtility.escapeSQL(RonbunCode) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Ronbun_Code = rs.getString("ronbuncode");
				String RonbunTitle = rs.getString("ronbuntitle");
				String Player_Id = rs.getString("player_id");
				String PlayerName = rs.getString("player_name");
				String UploadDate = rs.getString("uploaddate");
				String ShijisyaList_S = rs.getString("shijisyalist");
				if(ShijisyaList_S != null && (!(ShijisyaList_S.equals("")))){
					if(ShijisyaList_S.substring(ShijisyaList_S.length() - 5, ShijisyaList_S.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
						ShijisyaList_S = ShijisyaList_S.substring(0, ShijisyaList_S.length() - 5);
					}
				ShijisyaList = rs.getString("shijisyalist").split("plus;");
				}else{
					ShijisyaList = new String[1];
					ShijisyaList[0] = "empty";
				}
				String FushijisyaList_S = rs.getString("fushijisyalist");
				if(FushijisyaList_S != null && (!(FushijisyaList_S.equals("")))){
					if(FushijisyaList_S.substring(FushijisyaList_S.length() - 5, FushijisyaList_S.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
						ShijisyaList_S = ShijisyaList_S.substring(ShijisyaList_S.length() - 5, ShijisyaList_S.length());
					}
					FushijisyaList = rs.getString("fushijisyalist").split("plus;");
					}else{
						FushijisyaList = new String[1];
						FushijisyaList[0] = "empty";
					}
				String HTMLFileName = rs.getString("htmlfilename");
				String ImageFileName1 = rs.getString("imagefilename1");
				String ImageFileName2 = rs.getString("imagefilename2");
				String ImageFileName3 = rs.getString("imagefilename3");
				Result = new GPRiron_TO(Ronbun_Code, RonbunTitle, Player_Id, PlayerName, UploadDate, ShijisyaList, FushijisyaList, HTMLFileName, ImageFileName1, ImageFileName2, ImageFileName3);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
	
	public ArrayList<GPRiron_TO> Comment_Load(String RonbunCode){
		GPRiron_TO List = new GPRiron_TO();
		ArrayList<GPRiron_TO> Result = new ArrayList<GPRiron_TO>();
		Connection con = null;
		try{
			
			con = createConnection();
			
			String sql = "SELECT ronbuncode, respcode, uploaddate, player_name, comment FROM riron_comment WHERE ronbuncode = '" + HttpUtility.escapeSQL(RonbunCode) + "' AND lock_info = 1;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Ronbun_Code = rs.getString("ronbuncode");
				String RespCode = rs.getString("respcode");
				String UploadDate = rs.getString("uploaddate");
				String Player_Name = rs.getString("player_name");
				String Comment = rs.getString("comment");
				List = new GPRiron_TO(Ronbun_Code, RespCode, UploadDate, Player_Name, Comment);
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
	
	public boolean Ronbun_Koushin(GPRiron_TO NewData, GPRiron_TO OldData){
		Connection con = null;
		String sql = null;
		boolean tourokuerror = false;
		try{
			con = createConnection();
			
			sql = "UPDATE rirondata SET ronbuntitle = ?, koushindate = ?,  htmlfilename = ?, imagefilename1 = ?, imagefilename2 = ?, imagefilename3 = ?, lock_info = ? WHERE ronbuncode = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, NewData.getRonbunTitle());
			stmt.setString(2, NewData.getKoushinDate());
			stmt.setString(3, NewData.getHTMLFileName());
			stmt.setString(4, NewData.getImageFileName1());
			stmt.setString(5, NewData.getImageFileName2());
			stmt.setString(6, NewData.getImageFileName3());
			stmt.setInt(7, 0);//0=審査前、1=公開、2=管理者判断により非公開
			stmt.setString(8, OldData.getRonbunCode());
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}
	
	public boolean Ronbun_Shinkitouroku(GPRiron_TO NewData, R_jyouhou_TO KaiinData){
		Connection con = null;
		String sql = null;
		boolean tourokuerror = false;
		try{
			con = createConnection();
			
			sql = "INSERT INTO rirondata (ronbuncode, ronbuntitle, player_id, player_name, uploaddate, htmlfilename, imagefilename1, imagefilename2, imagefilename3, lock_info) VALUES(?,?,?,?,?, ?,?,?,?,?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, NewData.getRonbunCode());
			stmt.setString(2, NewData.getRonbunTitle());
			stmt.setString(3, KaiinData.getk_Id());
			stmt.setString(4, KaiinData.getlogin_name());
			stmt.setString(5, NewData.getUploadDate());
			stmt.setString(6, NewData.getHTMLFileName());
			stmt.setString(7, NewData.getImageFileName1());
			stmt.setString(8, NewData.getImageFileName2());
			stmt.setString(9, NewData.getImageFileName3());
			stmt.setInt(10, 0);//0=審査前、1=公開、2=管理者判断により非公開
			stmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}
	
	public void BeforeData_Error_Log(GPRiron_TO ErrorData){
		Connection con = null;
		String sql = null;
		try{
			ArrayList<String> FileList = new ArrayList<String>();
			if(ErrorData.getImageFileName1() != null){
				FileList.add(ErrorData.getImageFileName1());
			}
			if(ErrorData.getImageFileName1() != null){
				FileList.add(ErrorData.getImageFileName2());
			}
			if(ErrorData.getImageFileName1() != null){
				FileList.add(ErrorData.getImageFileName3());
			}
			if(ErrorData.getHTMLFileName() != null){
				FileList.add(ErrorData.getHTMLFileName());
			}
			
			for(String FileName : FileList){
			con = createConnection();
			
			sql = "INSERT INTO deletelog (uploadtime, filename) VALUES(now(),?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, FileName);
			stmt.executeUpdate();
			}
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				closeConnection(con);
			}
	}
	
	public boolean ID_Henkoutouroku(K_Touroku_TO ChangeData, N_jyouhou_TO BaseData){
		Connection con = null;
		String sql = null;
		try{
			con = createConnection();
			
			sql = "UPDATE rirondata SET player_id = ? WHERE player_id = ?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ChangeData.getKibou_Id());
			pstmt.setString(2, BaseData.getK_Id());
			pstmt.executeUpdate();
			
			sql = "UPDATE rirondata SET shijisyalist = REPLACE(shijisyalist,?,?), fushijisyalist = REPLACE(fushijisyalist,?,?);";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ChangeData.getKibou_Id());
			pstmt.setString(2, BaseData.getK_Id());
			pstmt.setString(3, ChangeData.getKibou_Id());
			pstmt.setString(4, BaseData.getK_Id());
			pstmt.executeUpdate();
			
			sql = "UPDATE riron_comment SET kaiin_id = ? WHERE kaiin_id = ?;";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ChangeData.getKibou_Id());
			pstmt.setString(2, BaseData.getK_Id());
			pstmt.executeUpdate();
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
}
	
	public boolean Vote_Upload(String RonbunCode, String Kaiin_Id, String Vote){
		Connection con = null;
		try{
			
			String Ronbun_Code = "";
			String ShijisyaList = "";
			String FushijisyaList= "";
			
			con = createConnection();
			
			String sql = "SELECT ronbuncode, shijisyalist, fushijisyalist FROM rirondata WHERE ronbuncode = '" + HttpUtility.escapeSQL(RonbunCode) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				Ronbun_Code = rs.getString("ronbuncode");
				ShijisyaList = rs.getString("shijisyalist");
				FushijisyaList = rs.getString("fushijisyalist");
			}
			
			if(Vote.equals("shiji")){
				ShijisyaList = ShijisyaList + Kaiin_Id + "plus;";
			}else if(Vote.equals("fushuji")){
				FushijisyaList = FushijisyaList + Kaiin_Id + "plus;";
			}
			
			sql = "UPDATE rirondata SET shijisyalist = ?, fushijisyalist = ? WHERE ronbuncode = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ShijisyaList);
			pstmt.setString(2, FushijisyaList);
			pstmt.setString(3, Ronbun_Code);
			pstmt.executeUpdate();
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
}
	
	public boolean Comment_Upload(String Ronbun_Code, String RespCode, String Now, String Kaiin_Id, String Kaiin_Name, String Comment){
		Connection con = null;
		String sql = null;
		try{
			con = createConnection();
			
			sql = "INSERT INTO riron_comment(ronbuncode, respcode, uploaddate, kaiin_id, player_name, comment, lock_info) VALUES (?,?,?,?,?, ?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Ronbun_Code);
			pstmt.setString(2, RespCode);
			pstmt.setString(3, Now);
			pstmt.setString(4, Kaiin_Id);
			pstmt.setString(5, Kaiin_Name);
			pstmt.setString(6, Comment);
			pstmt.setInt(7, 1);
			pstmt.executeUpdate();
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
}
	
	public boolean Comment_Delete(String Ronbun_Code, String RespCode, String Kaiin_Id){
		Connection con = null;
		String sql = null;
		try{
			con = createConnection();
			
			sql = "DELETE FROM riron_comment WHERE ronbuncode = ? AND respcode = ? AND kaiin_id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Ronbun_Code);
			pstmt.setString(2, RespCode);
			pstmt.setString(3, Kaiin_Id);
			pstmt.executeUpdate();
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
	}
}
