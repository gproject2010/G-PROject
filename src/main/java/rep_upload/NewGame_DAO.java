package rep_upload;

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

public class NewGame_DAO {

	private final static String resourceName = "jdbc/r_data";

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
	
	/**
	 * @param TourokuData
	 * @return
	 */
	public boolean Proprep_Touroku(NewGames_TO TourokuData){//プロポーサルレポートの登録
		Connection con = null;
		boolean tourokuerror = false;
		try{
			con = createConnection();
			
			String sql = "INSERT INTO propdata (rep_code, gametitle, main_genre, subgenre1, subgenre2, platform, catchcopy, gaiyou, penname, kikakusya_sei, kikakusya_mei, seifurigana, meifurigana, hogosyasei, hogosyamei, seinengappi, pref, jyusyo," +
					"tel, keitai, fax, mailaddress, url, syokugyou, tsutomesaki, tsutomesakijyusyo, seisakurireki, kikakuito, target, sabetsuka, advantage, " +
					"kikakuryou_uketori, kikakuryou, royality, bikou, koukaisettei, filename, kaiin_id, kaiin_name, uploadtime, lock_info ) " +
					" VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, TourokuData.getRep_Code());
			stmt.setString(2, TourokuData.getGameTitle());
			stmt.setString(3, TourokuData.getMainGenre());
			stmt.setString(4, TourokuData.getSubGenre1());
			stmt.setString(5, TourokuData.getSubGenre2());
			stmt.setString(6, TourokuData.getPlatForm());
			stmt.setString(7, TourokuData.getCatchCopy());
			stmt.setString(8, TourokuData.getGaiyou());
			stmt.setString(9, TourokuData.getPenName());
			stmt.setString(10, TourokuData.getKikakusya_Sei());
			stmt.setString(11, TourokuData.getKikakusya_Mei());
			stmt.setString(12, TourokuData.getSeifurigana());
			stmt.setString(13, TourokuData.getMeifurigana());
			stmt.setString(14, TourokuData.getHogosyasei());
			stmt.setString(15, TourokuData.getHogosyamei());
			stmt.setString(16, TourokuData.getSeinengappi_S());
			stmt.setString(17, TourokuData.getPref());
			stmt.setString(18, TourokuData.getJyusyo());
			stmt.setString(19, TourokuData.getTel_No());
			stmt.setString(20, TourokuData.getKeitai_No());
			stmt.setString(21, TourokuData.getFax_No());
			stmt.setString(22, TourokuData.getMailAddress());
			stmt.setString(23, TourokuData.getUrl());
			stmt.setString(24, TourokuData.getSyokugyou());
			stmt.setString(25, TourokuData.getTsutomesaki());
			stmt.setString(26, TourokuData.getTsutomesakiJyusyo());
			stmt.setString(27, TourokuData.getSeisakurireki());
			stmt.setString(28, TourokuData.getKikakuito());
			stmt.setString(29, TourokuData.getTarget());
			stmt.setString(30, TourokuData.getSabetsuka());
			stmt.setString(31, TourokuData.getAdvantage());
			stmt.setString(32, TourokuData.getKikakuryou_Uketori());
			stmt.setInt(33, TourokuData.getKikakuryou());
			stmt.setDouble(34, TourokuData.getRoyality());
			stmt.setString(35, TourokuData.getBikou());
			stmt.setString(36, TourokuData.getKoukaisettei_S());
			stmt.setString(37, TourokuData.getFileName());
			stmt.setString(38, TourokuData.getKaiin_ID());
			stmt.setString(39, TourokuData.getKaiin_Name());
			stmt.setString(40, TourokuData.getUploadTime_S());
			stmt.setInt(41, 0);//ロック状態(0=初期状態(公開せず)、1=公開、2=公開停止中)
			
stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}
	
	public NewGames_TO Prop_Syousai(String Rep_Code){//プロポーサルレポートの詳細(一般ユーザへの表示用)
		NewGames_TO PropData = null;
		Connection con = null;
		try{
			con = createConnection();
			
			String sql = "SELECT rep_code, gamecode, gametitle, main_genre, subgenre1, subgenre2, catchcopy, penname, url, kikakuito, logoaddress, setteishiryou, kikakukaisetsusyo, taikenban, etcdata, movieaddress, seigen_kaisu FROM propdata WHERE rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				String ReportCode = rs.getString("rep_code");
				String GameCode = rs.getString("gamecode");
				String GameTitle = rs.getString("gametitle");
				String MainGenre = rs.getString("main_genre");
				String SubGenre1 = rs.getString("subgenre1");
				String SubGenre2 = rs.getString("subgenre2");
				String CatchCopy = rs.getString("catchcopy");
				String PenName = rs.getString("penname");
				String URL = rs.getString("url");
				String Gaiyou = rs.getString("kikakuito");
				String LogoAddress = rs.getString("logoaddress");
				String SetteiShiryou = rs.getString("setteishiryou");
				String Kikakukaisetsusyo = rs.getString("kikakukaisetsusyo");
				String Taikenban = rs.getString("taikenban");
				String EtcData = rs.getString("etcdata");
				String MovieAddress = rs.getString("movieaddress");
				int Seigen_Kaisu = rs.getInt("seigen_kaisu");
				
				PropData = new NewGames_TO(ReportCode, GameCode, GameTitle, MainGenre, SubGenre1, SubGenre2, CatchCopy, PenName, URL, Gaiyou, LogoAddress, SetteiShiryou, Kikakukaisetsusyo, Taikenban, EtcData, MovieAddress, Seigen_Kaisu); 
			}
			return PropData;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<NewGames_TO> Prop_Info(int Hani){//プロポーサルレポートの概要(トップページ用)
		NewGames_TO PropData = new NewGames_TO();
		ArrayList<NewGames_TO> List = new ArrayList<NewGames_TO>();
		Connection con = null;
		String Limits = "";
		try{

			if(Hani > 0){
				Limits = "LIMIT " + Hani;
			}
			con = createConnection();
			
			String sql = "SELECT gametitle, main_genre, catchcopy, penname FROM propdata WHERE lock_info = 1 ORDER BY uploadtime DESC " + Limits + ";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String GameTitle = rs.getString("gametitle");
				String MainGenre = rs.getString("main_genre");
				String CatchCopy = rs.getString("catchcopy");
				String PenName = rs.getString("penname");
				
				PropData = new NewGames_TO(GameTitle, MainGenre, CatchCopy, PenName);
				List.add(PropData);
			}
			return List;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
}
