package g_jyouhou;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import rep_upload.Rep_Koumoku;
import rep_upload.Rep_List_TO;

public class Rep_Load_DAO {

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
	
	public Rep_List_TO BestRep_Load(String Rep_Code, String Kaiin_ID){
		Connection con = null;
		Rep_List_TO Rep_Data = null;
		try{
			con = createConnection();
			String sql = null;
			String sql2 = null;
			
			String Rep_Syubetsu = Rep_Code.substring(0, 2);
			//System.out.println("RS="+Rep_Syubetsu);
			
			int Shijisyasu = 0;
			int Fushijisyasu = 0;
			String Your_Vote = "empty";
			
			if(Rep_Syubetsu.equals("ox")){
			sql = "SELECT oxdata.rep_code, oxdata.gamecode, oxdata.gametitle, oxdata.login_name, oxdata.dificultty, oxdata.story, oxdata.graphic, oxdata.sound, oxdata.volume, oxdata.controll, oxdata.promotion, oxdata.outline, oxdata.goodies, oxdata.badies, " +
					" oxdata.uploaddate, oxdata.uploadtime, oxdata.rep_code, oxdata.jiyuten_koumoku1, oxdata.jiyuten_koumoku2, oxdata.jiyuten_koumoku3, oxdata.jiyuten_koumoku4, oxdata.jiyuten_koumoku5," +
					" oxdata.jiyuten_score1, oxdata.jiyuten_score2, oxdata.jiyuten_score3, oxdata.jiyuten_score4, oxdata.jiyuten_score5," +
					" oxdata.jiyuten_maxscore1, oxdata.jiyuten_maxscore2, oxdata.jiyuten_maxscore3, oxdata.jiyuten_maxscore4, oxdata.jiyuten_maxscore5 " +
					" FROM oxdata WHERE oxdata.rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Repo_Code = rs.getString("oxdata.rep_code");
				String GameCode = rs.getString("oxdata.gamecode");
				String GameTitle = rs.getString("oxdata.gametitle");
				String Player_Name = rs.getString("oxdata.login_name");
				
				double Dificultty = rs.getDouble("oxdata.dificultty");
				double Story = rs.getDouble("oxdata.story");
				double Graphic = rs.getDouble("oxdata.graphic");
				double Sound = rs.getDouble("oxdata.sound");
				double Volume = rs.getDouble("oxdata.volume");
				double Controll = rs.getDouble("oxdata.controll");
				double Promotion = rs.getDouble("oxdata.promotion");
				
				String OutLine = rs.getString("oxdata.outline");
				String Goodies = rs.getString("oxdata.goodies");
				String Badies = rs.getString("oxdata.badies");
				
				String UpLoadDate = rs.getString("oxdata.uploaddate");
				String UpLoadTime = rs.getString("oxdata.uploadtime");
				

				String jiyuten_koumoku1 = rs.getString("oxdata.jiyuten_koumoku1");
				String jiyuten_koumoku2 = rs.getString("oxdata.jiyuten_koumoku2");
				String jiyuten_koumoku3 = rs.getString("oxdata.jiyuten_koumoku3");
				String jiyuten_koumoku4 = rs.getString("oxdata.jiyuten_koumoku4");
				String jiyuten_koumoku5 = rs.getString("oxdata.jiyuten_koumoku5");
				
				double jiyuten_score1 = rs.getDouble("oxdata.jiyuten_score1");
				double jiyuten_score2 = rs.getDouble("oxdata.jiyuten_score2");
				double jiyuten_score3 = rs.getDouble("oxdata.jiyuten_score3");
				double jiyuten_score4 = rs.getDouble("oxdata.jiyuten_score4");
				double jiyuten_score5 = rs.getDouble("oxdata.jiyuten_score5");
				
				double jiyuten_maxscore1 = rs.getDouble("oxdata.jiyuten_maxscore1");
				double jiyuten_maxscore2 = rs.getDouble("oxdata.jiyuten_maxscore2");
				double jiyuten_maxscore3 = rs.getDouble("oxdata.jiyuten_maxscore3");
				double jiyuten_maxscore4 = rs.getDouble("oxdata.jiyuten_maxscore4");
				double jiyuten_maxscore5 = rs.getDouble("oxdata.jiyuten_maxscore5");
				
				/*
				String ShijisyaList = rs.getString("bestrepdata.shijisyalist");
				String FushijisyaList = rs.getString("bestrepdata.fushijisyalist");
				System.out.println("SHIJISYA="+ShijisyaList);*/
				
				/*
				if(ShijisyaList != null){
					if(ShijisyaList.substring(ShijisyaList.length() - 5, ShijisyaList.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					ShijisyaList = ShijisyaList.substring(0, ShijisyaList.length() - 5);//最後の"plus"を削除
					}
					Shijisyasu = ShijisyaList.split("plus;").length;
				}else{
					Shijisyasu = 0;
					ShijisyaList = "NO_DATA";
				}
				if(FushijisyaList != null){
					if(FushijisyaList.substring(FushijisyaList.length() - 5, FushijisyaList.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					FushijisyaList = ShijisyaList.substring(0, FushijisyaList.length() - 5);//最後の"plus"を削除
					}
					Fushijisyasu = FushijisyaList.split("plus;").length;
				}else{
					Fushijisyasu = 0;
					FushijisyaList = "NO_DATA";
				}
				*/
				//System.out.println("GC="+GameCode);
				
				sql2 = "SELECT k_id, answer FROM rep_vote WHERE rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
				
				Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				
				while(rs2.next()){
					String GPRO_ID = rs2.getString("k_id");
					String Answer = rs2.getString("answer");
					
					if(GPRO_ID != null && Answer != null){
					if(Answer.equals("shiji")){
						Shijisyasu++;
					}else if(Answer.equals("fushiji")){
						Fushijisyasu++;
					}
					if(GPRO_ID.equals(Kaiin_ID)){
						Your_Vote = GPRO_ID;
					}
					}
				}
				
				Rep_Data = new Rep_List_TO(Repo_Code, GameCode, GameTitle, Player_Name, Dificultty, Story, Graphic, Sound, Volume, Controll, Promotion,
						jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
						jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
						jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
						OutLine, Goodies, Badies, UpLoadDate, UpLoadTime, Shijisyasu, Fushijisyasu, Your_Vote);
			}
			
			}
			else if(Rep_Syubetsu.equals("ki")){
				sql = "SELECT kijidata.rep_code, kijidata.gamecode, kijidata.gametitle, kijidata.login_name, kijidata.dificultty, kijidata.story, kijidata.graphic, kijidata.sound, kijidata.volume, kijidata.controll, kijidata.promotion," +
				" kijidata.jiyuten_koumoku1, kijidata.jiyuten_koumoku2, kijidata.jiyuten_koumoku3, kijidata.jiyuten_koumoku4, kijidata.jiyuten_koumoku5," +
				" kijidata.jiyuten_score1, kijidata.jiyuten_score2, kijidata.jiyuten_score3, kijidata.jiyuten_score4, kijidata.jiyuten_score5," +
				" kijidata.jiyuten_maxscore1, kijidata.jiyuten_maxscore2, kijidata.jiyuten_maxscore3, kijidata.jiyuten_maxscore4, kijidata.jiyuten_maxscore5," +
				" kijidata.outline, kijidata.midashi, kijidata.feature, kijidata.evalate, kijidata.uploaddate, kijidata.updatetime, kijidata.rep_code " +
				" FROM kijidata WHERE kijidata.rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "' AND bestrepdata.rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()){
			String Repo_Code = rs.getString("rep_code");
			String GameCode = rs.getString("kijidata.gamecode");
			String GameTitle = rs.getString("kijidata.gametitle");
			String Player_Name = rs.getString("kijidata.login_name");
			
			double Dificultty = rs.getDouble("kijidata.dificultty");
			double Story = rs.getDouble("kijidata.story");
			double Graphic = rs.getDouble("kijidata.graphic");
			double Sound = rs.getDouble("kijidata.sound");
			double Volume = rs.getDouble("kijidata.volume");
			double Controll = rs.getDouble("kijidata.controll");
			double Promotion = rs.getDouble("kijidata.promotion");
			
			String OutLine = rs.getString("kijidata.outline");
			String Midashi = rs.getString("kijidata.midashi");
			String Feature = rs.getString("kijidata.feature");
			String Evalate = rs.getString("kijidata.evalate");
			
			String UpLoadDate = rs.getString("kijidata.uploaddate");
			String UpLoadTime = rs.getString("kijidata.uploadtime");
			
			String jiyuten_koumoku1 = rs.getString("kijidata.jiyuten_koumoku1");
			String jiyuten_koumoku2 = rs.getString("kijidata.jiyuten_koumoku2");
			String jiyuten_koumoku3 = rs.getString("kijidata.jiyuten_koumoku3");
			String jiyuten_koumoku4 = rs.getString("kijidata.jiyuten_koumoku4");
			String jiyuten_koumoku5 = rs.getString("kijidata.jiyuten_koumoku5");
			
			double jiyuten_score1 = rs.getDouble("kijidata.jiyuten_score1");
			double jiyuten_score2 = rs.getDouble("kijidata.jiyuten_score2");
			double jiyuten_score3 = rs.getDouble("kijidata.jiyuten_score3");
			double jiyuten_score4 = rs.getDouble("kijidata.jiyuten_score4");
			double jiyuten_score5 = rs.getDouble("kijidata.jiyuten_score5");
			
			double jiyuten_maxscore1 = rs.getDouble("kijidata.jiyuten_maxscore1");
			double jiyuten_maxscore2 = rs.getDouble("kijidata.jiyuten_maxscore2");
			double jiyuten_maxscore3 = rs.getDouble("kijidata.jiyuten_maxscore3");
			double jiyuten_maxscore4 = rs.getDouble("kijidata.jiyuten_maxscore4");
			double jiyuten_maxscore5 = rs.getDouble("kijidata.jiyuten_maxscore5");
		/*
			String ShijisyaList = rs.getString("bestrepdata.shijisyalist");
			String FushijisyaList = rs.getString("bestrepdata.fushijisyalist");
			*/
			/*
			if(ShijisyaList != null){
				if(ShijisyaList.substring(ShijisyaList.length() - 5, ShijisyaList.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
				ShijisyaList = ShijisyaList.substring(0, ShijisyaList.length() - 5);//最後の"plus"を削除
				}
				Shijisyasu = ShijisyaList.split("plus;").length;
			}else{
				Shijisyasu = 0;
				ShijisyaList = "NO_DATA";
			}
			if(FushijisyaList != null){
				if(FushijisyaList.substring(FushijisyaList.length() - 5, FushijisyaList.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
				FushijisyaList = FushijisyaList.substring(0, FushijisyaList.length() - 5);//最後の"plus"を削除
				}
				Fushijisyasu = FushijisyaList.split("plus;").length;
			}else{
				Fushijisyasu = 0;
				FushijisyaList = "NO_DATA";
			}
			*/
			
			sql2 = "SELECT k_id, answer FROM rep_vote WHERE rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
			
			
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			
			while(rs2.next()){
				String GPRO_ID = rs.getString("k_id");
				String Answer = rs.getString("answer");
				
				if(GPRO_ID != null && Answer != null){
				if(Answer.equals("shiji")){
					Shijisyasu++;
				}else if(Answer.equals("fushiji")){
					Fushijisyasu++;
				}
				if(GPRO_ID.equals(Kaiin_ID)){
					Your_Vote = GPRO_ID;
				}
				}
			}
			
			Rep_Data = new Rep_List_TO(Repo_Code, GameCode, GameTitle, Player_Name, Dificultty, Story, Graphic, Sound, Volume, Controll, Promotion,
					jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
					jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
					jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
					OutLine, Midashi, Feature, Evalate, UpLoadDate, UpLoadTime, Shijisyasu, Fushijisyasu, Your_Vote);
		}
		}	
			else if(Rep_Syubetsu.equals("fr")){
				sql = "SELECT freedata.rep_code, freedata.gamecode, freedata.gametitle, freedata.login_name, freedata.dificultty, freedata.story, freedata.graphic, freedata.sound, freedata.volume, freedata.controll, freedata.promotion, " +
				" freedata.jiyuten_koumoku1, freedata.jiyuten_koumoku2, freedata.jiyuten_koumoku3, freedata.jiyuten_koumoku4, freedata.jiyuten_koumoku5, " +
				" freedata.jiyuten_score1, freedata.jiyuten_score2, freedata.jiyuten_score3, freedata.jiyuten_score4, freedata.jiyuten_score5, " +
				" freedata.jiyuten_maxscore1, freedata.jiyuten_maxscore2, freedata.jiyuten_maxscore3, freedata.jiyuten_maxscore4, freedata.jiyuten_maxscore5, " +
				" freedata.outline, freedata.uploaddate, freedata.uploadtime, freedata.rep_code, freedata.uploadfilename " +
				" FROM freedata WHERE freedata.rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "' AND bestrepdata.rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()){
			String Repo_Code = rs.getString("rep_code");
			String GameCode = rs.getString("freedata.gamecode");
			String GameTitle = rs.getString("freedata.gametitle");
			String Player_Name = rs.getString("freedata.login_name");
			
			double Dificultty = rs.getDouble("freedata.dificultty");
			double Story = rs.getDouble("freedata.story");
			double Graphic = rs.getDouble("freedata.graphic");
			double Sound = rs.getDouble("freedata.sound");
			double Volume = rs.getDouble("freedata.volume");
			double Controll = rs.getDouble("freedata.controll");
			double Promotion = rs.getDouble("freedata.promotion");
			
			String OutLine = rs.getString("freedata.outline");
			
			String UpLoadDate = rs.getString("freedata.uploaddate");
			String UpLoadTime = rs.getString("freedata.uploadtime");
			
			String UpLoadFileName = rs.getString("freedata.uploadfilename");
			
			String jiyuten_koumoku1 = rs.getString("freedata.jiyuten_koumoku1");
			String jiyuten_koumoku2 = rs.getString("freedata.jiyuten_koumoku2");
			String jiyuten_koumoku3 = rs.getString("freedata.jiyuten_koumoku3");
			String jiyuten_koumoku4 = rs.getString("freedata.jiyuten_koumoku4");
			String jiyuten_koumoku5 = rs.getString("freedata.jiyuten_koumoku5");
			
			double jiyuten_score1 = rs.getDouble("freedata.jiyuten_score1");
			double jiyuten_score2 = rs.getDouble("freedata.jiyuten_score2");
			double jiyuten_score3 = rs.getDouble("freedata.jiyuten_score3");
			double jiyuten_score4 = rs.getDouble("freedata.jiyuten_score4");
			double jiyuten_score5 = rs.getDouble("freedata.jiyuten_score5");
			
			double jiyuten_maxscore1 = rs.getDouble("freedata.jiyuten_maxscore1");
			double jiyuten_maxscore2 = rs.getDouble("freedata.jiyuten_maxscore2");
			double jiyuten_maxscore3 = rs.getDouble("freedata.jiyuten_maxscore3");
			double jiyuten_maxscore4 = rs.getDouble("freedata.jiyuten_maxscore4");
			double jiyuten_maxscore5 = rs.getDouble("freedata.jiyuten_maxscore5");
		/*
			String ShijisyaList = rs.getString("bestrepdata.shijisyalist");
			String FushijisyaList = rs.getString("bestrepdata.fushijisyalist");
			*/
			/*
			if(ShijisyaList != null){
				if(ShijisyaList.substring(ShijisyaList.length() - 5, ShijisyaList.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
				ShijisyaList = ShijisyaList.substring(0, ShijisyaList.length() - 5);//最後の"plus"を削除
				}
				Shijisyasu = ShijisyaList.split("plus;").length;
			}else{
				Shijisyasu = 0;
				ShijisyaList = "NO_DATA";
			}
			if(FushijisyaList != null){
				if(FushijisyaList.substring(FushijisyaList.length() - 5, FushijisyaList.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
				FushijisyaList = FushijisyaList.substring(0, FushijisyaList.length() - 5);//最後の"plus"を削除
				}
				Fushijisyasu = FushijisyaList.split("plus;").length;
			}else{
				Fushijisyasu = 0;
				FushijisyaList = "NO_DATA";
			}
			*/
			
			sql2 = "SELECT k_id, answer FROM rep_vote WHERE rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
			
			
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			
			while(rs2.next()){
				String GPRO_ID = rs.getString("k_id");
				String Answer = rs.getString("answer");
				
				if(GPRO_ID != null && Answer != null){
				if(Answer.equals("shiji")){
					Shijisyasu++;
				}else if(Answer.equals("fushiji")){
					Fushijisyasu++;
				}
				if(GPRO_ID.equals(Kaiin_ID)){
					Your_Vote = GPRO_ID;
				}
				}
			}
			
			Rep_Data = new Rep_List_TO(Repo_Code, GameCode, GameTitle, Player_Name, Dificultty, Story, Graphic, Sound, Volume, Controll, Promotion,
					jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5,
					jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5,
					jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5,
					OutLine, UpLoadDate, UpLoadTime, UpLoadFileName, Shijisyasu, Fushijisyasu, Your_Vote);
		}
		}
			
			return Rep_Data;
			
			}catch(SQLException e){
				e.printStackTrace();
				return null;
		
			}finally{
				closeConnection(con);
			}
	}
	
	public ArrayList<Rep_Koumoku> WordRep_TopLoad(){
		Connection con = null;
		Rep_Koumoku Rep_Data = null;
		ArrayList<Rep_Koumoku> Result = new ArrayList<Rep_Koumoku>();
		try{
			con = createConnection();
			String sql = null;
			String sql2 = null;
			
			sql = "SELECT rep_code, gametitle, uploadtime, total, '一言' AS rep_syubetsu FROM wordrepdata WHERE lock_info = 1 ORDER BY uploadtime DESC LIMIT 3;";
			//Lock_info:0=初期状態（未公開）、1=公開中、2=ゲームマスター判断による公開停止
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			String Rep_Code = rs.getString("rep_code");
			String GameTitle = rs.getString("gametitle");
			String UploadTime = rs.getString("uploadtime");
			double Total = rs.getDouble("total");
			String Rep_Syubetsu = rs.getString("rep_syubetsu");
			
			Rep_Data = new Rep_Koumoku(Rep_Code, GameTitle, UploadTime, Total, Rep_Syubetsu);
			Result.add(Rep_Data);
			}
			
			sql2 = "SELECT rep_code, gametitle, uploaddate, uploadtime, total, '○×' AS rep_syubetsu FROM oxdata WHERE hyouka_rank  = 'S' OR hyouka_rank = 'A' OR hyouka_rank = 'B' OR hyouka_rank = 'C'" +
					" UNION ALL SELECT rep_code, gametitle, uploaddate, uploadtime, total, '○×(新規追加)' AS rep_syubetsu FROM oxshinkidata WHERE hyouka_rank  = 'S' OR hyouka_rank = 'A' OR hyouka_rank = 'B' OR hyouka_rank = 'C'" +
					" UNION ALL SELECT rep_code, gametitle, uploaddate, uploadtime, total, '紹介記事' AS rep_syubetsu FROM kijidata WHERE hyouka_rank  = 'S' OR hyouka_rank = 'A' OR hyouka_rank = 'B' OR hyouka_rank = 'C'" +
					" UNION ALL SELECT rep_code, gametitle, uploaddate, uploadtime, total, '紹介記事(新規追加)' AS rep_syubetsu FROM kijishinkidata WHERE hyouka_rank  = 'S' OR hyouka_rank = 'A' OR hyouka_rank = 'B' OR hyouka_rank = 'C'" +
					" UNION ALL SELECT rep_code, gametitle, uploaddate, uploadtime, total, '自由形式' AS rep_syubetsu FROM freedata WHERE hyouka_rank  = 'S' OR hyouka_rank = 'A' OR hyouka_rank = 'B' OR hyouka_rank = 'C'" +
					" UNION ALL SELECT rep_code, gametitle, uploaddate, uploadtime, total, '自由形式(新規追加)' AS rep_syubetsu FROM freeshinkidata WHERE hyouka_rank  = 'S' OR hyouka_rank = 'A' OR hyouka_rank = 'B' OR hyouka_rank = 'C' ORDER BY uploaddate DESC LIMIT 7;";
			//Lock_info:0=初期状態（未公開）、1=公開中、2=ゲームマスター判断による公開停止
			Statement stmt2 = con.createStatement();
			ResultSet rs2 = stmt2.executeQuery(sql2);
			
			while(rs2.next()){
			String Rep_Code = rs2.getString("rep_code");
			String GameTitle = rs2.getString("gametitle");
			String UploadDate = rs2.getString("uploaddate");
			String UploadTime = rs2.getString("uploadtime");
			double Total = rs2.getDouble("total");
			String Rep_Syubetsu = rs2.getString("rep_syubetsu");
			
			Rep_Data = new Rep_Koumoku(Rep_Code, GameTitle, UploadDate + " " + UploadTime, Total, Rep_Syubetsu);
			Result.add(Rep_Data);
}
			Date_Sort(Result);
			return Result;
			
			}catch(SQLException e){
				e.printStackTrace();
				return null;
		
			}finally{
				closeConnection(con);
			}
	}
	
	public ArrayList<Rep_Koumoku> WordRep_Kensaku(String Now){
		Connection con = null;
		Rep_Koumoku Rep_Data = null;
		ArrayList<Rep_Koumoku> Result = new ArrayList<Rep_Koumoku>();
		try{
			con = createConnection();
			String sql = null;
			
			sql = "SELECT rep_code, gametitle, uploadtime, total, '一言' AS rep_syubetsu FROM wordrepdata WHERE uploadtime >= '" + HttpUtility.escapeSQL(Now) + "' AND lock_info = 1 ORDER BY uploadtime DESC LIMIT 150;";
			//Lock_info:0=初期状態（未公開）、1=公開中、2=ゲームマスター判断による公開停止
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			String Rep_Code = rs.getString("rep_code");
			String GameTitle = rs.getString("gametitle");
			String UploadTime = rs.getString("uploadtime");
			double Total = rs.getDouble("total");
			String Rep_Syubetsu = rs.getString("rep_syubetsu");
			
			Rep_Data = new Rep_Koumoku(Rep_Code, GameTitle, UploadTime, Total, Rep_Syubetsu);
			Result.add(Rep_Data);
}
			
			return Result;
			
			}catch(SQLException e){
				e.printStackTrace();
				return null;
		
			}finally{
				closeConnection(con);
			}
	}
	
	public Rep_Koumoku WordRep_Load(String SerchRep_Code){
		Connection con = null;
		Rep_Koumoku Rep_Data = null;
		try{
			con = createConnection();
			String sql = null;
			
			sql = "SELECT rep_code, gametitle, uploadtime, dificultty, story, graphic, sound, volume, controll, promotion, free_s, " +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, '一言レポート' AS rep_syubetsu FROM wordrepdata WHERE rep_code = '" + HttpUtility.escapeSQL(SerchRep_Code) + "'" +
							" UNION ALL SELECT rep_code, gametitle, uploadtime, dificultty, story, graphic, sound, volume, controll, promotion, free_s, " +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, '○×レポート' AS rep_syubetsu FROM oxdata WHERE rep_code = '" + HttpUtility.escapeSQL(SerchRep_Code) + "'" +
							" UNION ALL SELECT rep_code, gametitle, uploadtime, dificultty, story, graphic, sound, volume, controll, promotion, free_s, " +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, '○×レポート(新規登録)' AS rep_syubetsu FROM oxshinkidata WHERE rep_code = '" + HttpUtility.escapeSQL(SerchRep_Code) + "'" +
							" UNION ALL SELECT rep_code, gametitle, uploadtime, dificultty, story, graphic, sound, volume, controll, promotion, free_s, " +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, '紹介記事レポート' AS rep_syubetsu FROM kijidata WHERE rep_code = '" + HttpUtility.escapeSQL(SerchRep_Code) + "'" +
							" UNION ALL SELECT rep_code, gametitle, uploadtime, dificultty, story, graphic, sound, volume, controll, promotion, free_s, " +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, '紹介記事レポート(新規登録)' AS rep_syubetsu FROM kijishinkidata WHERE rep_code = '" + HttpUtility.escapeSQL(SerchRep_Code) + "'" +
							" UNION ALL SELECT rep_code, gametitle, uploadtime, dificultty, story, graphic, sound, volume, controll, promotion, free_s, " +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, '自由形式レポート' AS rep_syubetsu FROM freedata WHERE rep_code = '" + HttpUtility.escapeSQL(SerchRep_Code) + "'" +
							" UNION ALL SELECT rep_code, gametitle, uploadtime, dificultty, story, graphic, sound, volume, controll, promotion, free_s, " +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, '自由形式レポート(新規登録)' AS rep_syubetsu FROM freeshinkidata WHERE rep_code = '" + HttpUtility.escapeSQL(SerchRep_Code) + "';";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Rep_Code = rs.getString("rep_code");
				String GameTitle = rs.getString("gametitle");
				String UploadTime = rs.getString("uploadtime");
				double Dificultty = rs.getDouble("dificultty");
				double Story = rs.getDouble("story");
				double Graphic = rs.getDouble("graphic");
				double Sound = rs.getDouble("sound");
				double Volume = rs.getDouble("volume");
				double Controll = rs.getDouble("controll");
				double Promotion = rs.getDouble("promotion");
				double Free_S = rs.getDouble("free_s");
				String Jiyuten_Koumoku1 = rs.getString("jiyuten_koumoku1");
				String Jiyuten_Koumoku2 = rs.getString("jiyuten_koumoku2");
				String Jiyuten_Koumoku3 = rs.getString("jiyuten_koumoku3");
				double Jiyuten_Score1 = rs.getDouble("jiyuten_score1");
				double Jiyuten_Score2 = rs.getDouble("jiyuten_score2");
				double Jiyuten_Score3 = rs.getDouble("jiyuten_score3");
				double Jiyuten_MaxScore1 = rs.getDouble("jiyuten_maxscore1");
				double Jiyuten_MaxScore2 = rs.getDouble("jiyuten_maxscore2");
				double Jiyuten_MaxScore3 = rs.getDouble("jiyuten_maxscore3");
				String Rep_Syubetsu = rs.getString("rep_syubetsu");
				
				Rep_Data = new Rep_Koumoku(Rep_Code, GameTitle, UploadTime, Dificultty, Story, Graphic, Sound, Volume, Controll, Promotion, Free_S,
						Jiyuten_Koumoku1, Jiyuten_Koumoku2, Jiyuten_Koumoku3, Jiyuten_Score1, Jiyuten_Score2, Jiyuten_Score3, Jiyuten_MaxScore1, Jiyuten_MaxScore2, Jiyuten_MaxScore3, Rep_Syubetsu);
}
			
			return Rep_Data;
			
			}catch(SQLException e){
				e.printStackTrace();
				return null;
		
			}finally{
				closeConnection(con);
			}
	}
	
	private static ArrayList<Rep_Koumoku> Date_Sort(ArrayList<Rep_Koumoku> MyData){
		Collections.sort(MyData, new Comparator<Rep_Koumoku>(){
			public int compare(Rep_Koumoku Data1, Rep_Koumoku Data2){
				if(Data1.getUploadTime() == null || Data2.getUploadTime() == null){
					return 0;
				}
				return Data1.getUploadTime().compareTo(Data2.getUploadTime());
			}
		});
		return MyData;
	}
}
