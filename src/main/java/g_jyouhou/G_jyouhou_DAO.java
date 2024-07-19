package g_jyouhou;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class G_jyouhou_DAO{

	private final static String resourceName = "jdbc/g_data";

	private Connection createConnection(){
		try{

			InitialContext ic = new InitialContext();

			DataSource ds = (DataSource)ic.lookup("java:comp/env/"+resourceName);

			Connection con = ds.getConnection();
			return con;
		}catch(SQLException ex){
			ex.printStackTrace();
		}catch(NamingException ex){
			ex.printStackTrace();
		}
		return null;
	}
	protected void closeConnection(Connection con){
		try{
			con.close();
			}catch(Exception ex){}
	}
	public ArrayList<G_jyouhou_TO> Search (G_jyouhou_TO Jyouken){
		
		ArrayList<G_jyouhou_TO> list = new ArrayList<G_jyouhou_TO>();//概要情報の検索処理
		
		String Genre_J = "";
		String GTitle_J = "";
		String Hatsubainengappi_J = "";
		String License_J = "";
		
		int HitCount = 0;
		
		if(Jyouken.getGametitle().equals("*")){
			GTitle_J = "";
		}else{
			GTitle_J = " AND gamename LIKE '%" + HttpUtility.escapeSQL(Jyouken.getGametitle()) + "%' ";
		}
		
		if(Jyouken.getMain_Genre().equals("*")){
			Genre_J = "";
		}else{
			Genre_J = "AND (main_genre = '" + HttpUtility.escapeSQL(Jyouken.getMain_Genre()) + "' OR subgenre1 = '" + HttpUtility.escapeSQL(Jyouken.getMain_Genre()) + "' or subgenre2 = '" + HttpUtility.escapeSQL(Jyouken.getMain_Genre()) + "' )";
		}
		
		if(Jyouken.getHatsubainengappi_Start().equals("0001-01-01") && Jyouken.getHatsubainengappi_Limit().equals("9999-12-31")){
			Hatsubainengappi_J = "";
		}else{
			Hatsubainengappi_J = " AND hatsubainengappi BETWEEN '" + HttpUtility.escapeSQL(Jyouken.getHatsubainengappi_Start()) + "' AND '" + HttpUtility.escapeSQL(Jyouken.getHatsubainengappi_Limit()) + "' ";
		}
		
		if(Jyouken.getLiSence().equals("*")){
			License_J = "";
		}else{
			License_J = " AND makername LIKE '" + HttpUtility.escapeSQL(Jyouken.getLiSence()) + "' ";
		}
		
		
		Connection con = null;
		try{
			con = createConnection();
			if(Jyouken.getGS_Syubetsu().equals("ruikei")){//名作ランキング(G-Scoreの累計)を検索条件にした場合
			String sql = "select distinct SQL_CALC_FOUND_ROWS gamecode, platform, gamename, main_genre, rating, hatsubainengappi,  makercode, makername, lisence, dai1_insyou, g_score " +  "from g_data.gamedata " 
			+ "where (platform = '" + HttpUtility.escapeSQL(Jyouken.getPlatform()) + "' or '" + HttpUtility.escapeSQL(Jyouken.getPlatform()) + "' = '*') " + GTitle_J + Genre_J + Hatsubainengappi_J + " and (makername like '%" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "%' or '" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "' = '*' or developer_names like '%" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "%')" + License_J  +
					" and (g_score between " + Jyouken.getG_Score_Min() + " and " + Jyouken.getG_Score_Max() + ") ORDER BY hatsubainengappi DESC LIMIT " + Jyouken.getPageSt() + " , " + Jyouken.getPageFin() + " ;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
            String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
            Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			if(rs2.next()){
			HitCount = rs2.getInt("hitcount");
			}
			while(rs.next()){

				String GameCode = rs.getString("gamecode");//ゲームコード
				String Platform = rs.getString("platform");//プラットフォーム
				String Gametitle = rs.getString("gamename");//ゲームの名称
				String Main_Genre = rs.getString("main_genre");//メインジャンル
				String Rating = rs.getString("rating");//CEROレーティング
				String Hatsubainengappi = rs.getString("hatsubainengappi");//発売年月日

				String MakerName = rs.getString("makername");//発売元メーカー
				String LiSence = rs.getString("lisence");//著作物の転載許可状況

				G_jyouhou_TO G_Data = new G_jyouhou_TO(GameCode, Platform, Gametitle, Main_Genre, Hatsubainengappi,  MakerName, Rating,    
						LiSence, HitCount);
				list.add(G_Data);
				
			}
			
			}
			else if(Jyouken.getGS_Syubetsu().equals("nenkan")){//ビッグヒットランキング(発売から１年間の獲得G-Score)を検索条件にした場合
				String sql =  "select distinct SQL_CALC_FOUND_ROWS gamecode, platform, gamename, main_genre, rating, hatsubainengappi,  makercode, makername, lisence, dai1_insyou, nenkan " +  "from g_data.gamedata " 
				+ "where (platform = '" + HttpUtility.escapeSQL(Jyouken.getPlatform()) + "' or '" + HttpUtility.escapeSQL(Jyouken.getPlatform()) + "' = '*') " + GTitle_J + Genre_J + Hatsubainengappi_J + " and (makername like '%" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "%' or '" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "' = '*' or developer_names like '%" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "%' )" + License_J +
				" and (nenkan between " + Jyouken.getG_Score_Min() + " and " + Jyouken.getG_Score_Max() + ") ORDER BY hatsubainengappi DESC LIMIT " + Jyouken.getPageSt() + " , " + Jyouken.getPageFin() + " ;";
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				 String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
				 Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					if(rs2.next()){
						HitCount = rs2.getInt("hitcount");
						//System.out.println(HitCount);
						}
					//System.out.println(HitCount);
				
				while(rs.next()){
					String GameCode = rs.getString("gamecode");
					String Platform = rs.getString("platform");
					String Gametitle = rs.getString("gamename");
					String Main_Genre = rs.getString("main_genre");
					String Rating = rs.getString("rating");

					String Hatsubainengappi = rs.getString("hatsubainengappi");

					String MakerName = rs.getString("makername");
					String LiSence = rs.getString("lisence");

					G_jyouhou_TO G_Data = new G_jyouhou_TO(Platform, Gametitle, Main_Genre, Hatsubainengappi,  MakerName, Rating,    
							LiSence, GameCode, HitCount);

					list.add(G_Data);
				}
				
		}
				
			else if(Jyouken.getGS_Syubetsu().equals("dai1_insyou")){//第一印象ランキング(発売から1か月の獲得G-Score)を検索条件にした場合
				String sql =  "select distinct SQL_CALC_FOUND_ROWS gamecode, platform, gamename, main_genre, rating, hatsubainengappi,  makercode, makername, lisence, dai1_insyou " +  "from g_data.gamedata " 
				+ "where (platform = '" + HttpUtility.escapeSQL(Jyouken.getPlatform()) + "' or '" + HttpUtility.escapeSQL(Jyouken.getPlatform()) + "' = '*') " + GTitle_J + Genre_J + Hatsubainengappi_J + "  and (makername like '%" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "%' or '" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "' = '*' or developer_names like '%" + HttpUtility.escapeSQL(Jyouken.getMakerName()) + "%' ) " + License_J +
				" and (dai1_insyou between " + Jyouken.getG_Score_Min() + " and " + Jyouken.getG_Score_Max() + ") ORDER BY hatsubainengappi DESC LIMIT " + Jyouken.getPageSt() + " , " + Jyouken.getPageFin() + " ;";
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				 String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
				 Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					if(rs2.next()){
						HitCount = rs2.getInt("hitcount");
						//System.out.println(HitCount);
						}
					//System.out.println(HitCount);
				
			while(rs.next()){

				String GameCode = rs.getString("gamecode");
				String Platform = rs.getString("platform");
				String Gametitle = rs.getString("gamename");
				String Main_Genre = rs.getString("main_genre");
				String Rating = rs.getString("rating");

				String Hatsubainengappi = rs.getString("hatsubainengappi");

				String MakerName = rs.getString("makername");
				String LiSence = rs.getString("lisence");

				G_jyouhou_TO G_Data = new G_jyouhou_TO(Platform, Gametitle, Main_Genre, Hatsubainengappi,  MakerName, Rating,    
						LiSence, GameCode, HitCount);

				list.add(G_Data);
			
			}
			}else{
				return null;
			}
			
			return list;
			
		}catch(SQLException e){

			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	public ArrayList<G_jyouhou_TO> Hatsubaimae_Serch(){
		ArrayList<G_jyouhou_TO> list = new ArrayList<G_jyouhou_TO>();//発売前ゲームの概要情報の検索処理
		Connection con = null;
		try{
			con = createConnection();
			String sql = "SELECT gamecode, gametitle, platform, publisher, main_genre, hatsubainengappi, shinchokudo FROM g_data.hatsubaimae WHERE hatsubainengappi < (SELECT CURRENT_DATE())";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()){
				String GameCode = rs.getString("gamecode");
				String GameTitle = rs.getString("gametitle");
				String Platform = rs.getString("platform");
				String Publisher = rs.getString("publisher");
				String MainGenre = rs.getString("main_genre");
				String Hatsubainengappi = rs.getString("hatsubainengappi");
				String Shinchokudo = rs.getString("shinchokudo");
				
				G_jyouhou_TO HatsubaimaeData = new G_jyouhou_TO(GameCode, GameTitle, Platform, Publisher, MainGenre, Hatsubainengappi, Shinchokudo);
				list.add(HatsubaimaeData);
			}
			return list;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
}
