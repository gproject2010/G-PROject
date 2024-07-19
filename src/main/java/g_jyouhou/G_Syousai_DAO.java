package g_jyouhou;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class G_Syousai_DAO {

	private final static String resourceName = "jdbc/g_data";

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
	public GS_jyouhou_TO SyousaiSeach(String GameCode){
		GS_jyouhou_TO GSData = null;
		Connection con = null;
		int Access_Count = 0;
		try{
			con = createConnection();
			
			
			String sql = "select gamecode, platform, gamename, main_genre, subgenre1, subgenre2, dificultty, story, graphic, sound, volume, controll, promotion, free_s, g_score, dai1_insyou, nenkan, report_count, makercode, developer_codes, makername, developer_names, hatsubainengappi, rating, lisence, kyokajyouken, gaiyou, bestgaiyou, logoaddress, movieaddress, " +
					"goodkeywords, badkeywords, mainkeywords, hyoukakeywords, bestreports, bestreporters, access_count, " +
					" (select count(distinct(g_score))+1 from gamedata where g_score > (select g_score from gamedata where gamecode = '" + HttpUtility.escapeSQL(GameCode) + "' )) as Gsc, " + //G-Scoreランキングの順位を算出
					" (select count(distinct(dai1_insyou))+1 from gamedata where dai1_insyou > (select dai1_insyou from gamedata where gamecode = '" + HttpUtility.escapeSQL(GameCode) + "' )) as Dai1, " + //第一印象ランキングの順位を算出
					" (select count(distinct(nenkan))+1 from gamedata where nenkan > (select nenkan from gamedata where gamecode = '" + HttpUtility.escapeSQL(GameCode) + "' )) as year, " + //ビッグヒットランキングの順位を算出
							" (select count(distinct(report_count))+1 from gamedata where report_count > (select report_count from gamedata where gamecode = '" + HttpUtility.escapeSQL(GameCode) + "' )) as Repc, " +
							" (SELECT COUNT(*) FROM gamedata) AS g_count, seigen_kaisu " +
			" from gamedata " + " where gamecode = '" + HttpUtility.escapeSQL(GameCode) + "'  ; ";
			
			Statement stmt = con.createStatement();
					//ResultSet.TYPE_SCROLL_SENSITIVE,
					//ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = stmt.executeQuery(sql);
			
			
			if(rs.next()){
				String Gamecode = rs.getString("gamecode");//ゲームコード
				String Platform = rs.getString("platform");//プラットフォーム
				String Gametitle = rs.getString("gamename");//ゲームタイトル
				String Maingenre = rs.getString("main_genre");//メインジャンル
				String Subgenre1 = rs.getString("subgenre1");//サブジャンル1
				String Subgenre2 = rs.getString("subgenre2");//サブジャンル2
				
				double dificultty = 0;//難易度の適正度(ここから)
				double story = 0;//世界観・シナリオ
				double graphic = 0;//グラフィック
				double sound = 0;//BGMなどの音楽
				double volume = 0;//ハマり度・ボリューム
				double controll = 0;//操作性
				double promotion = 0;//プロモーション
				double free_S = 0;//自由点(ここまで:全提出者の合計)
				
				double G_score = rs.getDouble("g_score");//累計G-Score
				double Dai1_Insyou = rs.getDouble("dai1_insyou");//発売1ヶ月で獲得したG-Score
				double Nenkan = rs.getDouble("nenkan");//発売1年で獲得したG-Score
				int Report_count = rs.getInt("report_count");//ゲームに対するレポートの提出数
				
				if(Report_count > 0){
				dificultty = rs.getDouble("dificultty");//難易度の適正度(ここから)
				story = rs.getDouble("story");//世界観・シナリオ
				graphic = rs.getDouble("graphic");//グラフィック
				sound = rs.getDouble("sound");//BGMなどの音楽
				volume = rs.getDouble("volume");//ハマり度・ボリューム
				controll = rs.getDouble("controll");//操作性
				promotion = rs.getDouble("promotion");//プロモーション
				free_S = rs.getDouble("free_s");//自由点(ここまで:全提出者の合計)
				}else{
					dificultty = 0;
					story = 0;
					graphic = 0;
					sound = 0;
					volume = 0;
					controll = 0;
					promotion = 0;
					free_S = 0;
				}
				
				String Makercode = rs.getString("makercode");//発売元(パブリッシャー)のコード
				String Makername = rs.getString("makername");//発売元(パブリッシャー)の名称
				String Developer_codes = rs.getString("developer_codes");//開発元(デベロッパー)のコード(分解前)(まだ作ってない)
				String Developer_names = rs.getString("developer_names");//開発元(デベロッパー)の名称(分解前)(まだ作ってない)
				String Hatsubainengappi = rs.getString("hatsubainengappi");//発売年月日
				String Rating = rs.getString("rating");//CEROレーティング
				String Lisence = rs.getString("lisence");//著作物の転載許可状況
				String Kyokajyouken = rs.getString("kyokajyouken");//著作物の転載許可条件
				String Gaiyou = rs.getString("gaiyou");//ゲームの概要
				String BestGaiyou = rs.getString("bestgaiyou");//概要作成者のプレイヤーネーム
				String Logoaddress = rs.getString("logoaddress");//ゲームロゴの格納アドレス
				String Movieaddress = rs.getString("movieaddress");//紹介ムービーの格納アドレス
				
				String Goodkeyword = rs.getString("goodkeywords");//OXレポートの「良かった所」キーワード
				String Badkeyword = rs.getString("badkeywords");//OXレポートの「今後の課題」キーワード
				String Mainkeyword = rs.getString("mainkeywords");//記事・自由形式レポートのメインキーワード
				String Hyoukakeyword = rs.getString("hyoukakeywords");//記事・自由形式レポートの評価キーワード
				
				String[] Developer_Code = null;
				String[] Developer_Name = null;
				
				if(Developer_codes == null){
					Developer_Code = new String[1];
					Developer_Code[0] = "NO_DATA";
				}else{
					if(Developer_codes.length() > 5 && Developer_codes.substring(Developer_codes.length() - 5, Developer_codes.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
				Developer_codes = Developer_codes.substring(0, Developer_codes.length() - 5);//最後の"plus"を削除
					}
				Developer_Code = Developer_codes.split("plus;");//開発元(デベロッパー)のコード(分解後)
				}
				if(Developer_names == null){
					Developer_Name = new String[1];
					Developer_Name[0] = "NO_DATA";
				}else{
					if(Developer_names.length() > 5 && Developer_names.substring(Developer_names.length() - 5, Developer_names.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Developer_names = Developer_names.substring(0, Developer_names.length() - 5);
					}
				Developer_Name = Developer_names.split("plus;");//開発元(デベロッパー)の名称(分解後)
				}
				String[] GoodKeyWords = null;
				String[] BadKeyWords = null;
				String[] MainKeyWords = null;
				String[] HyoukaKeyWords = null;
				
				if(Goodkeyword == null){
					GoodKeyWords = new String[1];
					GoodKeyWords[0] = "NO_DATA";
				}else{
					if(Goodkeyword.length() > 5 && Goodkeyword.substring(Goodkeyword.length() - 5, Goodkeyword.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Goodkeyword = Goodkeyword.substring(0, Goodkeyword.length() - 5);
					}
				GoodKeyWords = Goodkeyword.split("plus;");//カンマ区切りで分解し配列に格納
				}
				if(Badkeyword == null){
					BadKeyWords = new String[1];
					BadKeyWords[0] = "NO_DATA";
				}else{
					if(Badkeyword.length() > 5 && Badkeyword.substring(Badkeyword.length() - 5, Badkeyword.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Badkeyword = Badkeyword.substring(0, Badkeyword.length() - 5);
					}
				BadKeyWords = Badkeyword.split("plus;");
				}
				if(Mainkeyword == null){
					MainKeyWords = new String[1];
					MainKeyWords[0] = "NO_DATA";
				}else{
					if(Mainkeyword.length() > 5 && Mainkeyword.substring(Mainkeyword.length() - 5, Mainkeyword.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Mainkeyword = Mainkeyword.substring(0, Mainkeyword.length() - 5);
					}
				MainKeyWords = Mainkeyword.split("plus;");
				}
				if(Hyoukakeyword == null){
					HyoukaKeyWords = new String[1];
					HyoukaKeyWords[0] = "NO_DATA";
				}else{
					if(Hyoukakeyword.length() > 5 && Hyoukakeyword.substring(Hyoukakeyword.length() - 5, Hyoukakeyword.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Hyoukakeyword = Hyoukakeyword.substring(0, Hyoukakeyword.length() - 5);
					}
				HyoukaKeyWords = Hyoukakeyword.split("plus;");
				}
				String Bestreport = rs.getString("bestreports");//掲載されたレポートのレポートコード(カンマ区切り）
				String Bestreporter = rs.getString("bestreporters");//掲載されたレポートの提出者のプレイヤーネーム（カンマ区切り）
				
				String[] BestReports = null;//カンマで区切って分解し配列に格納
				String[] BestReporters = null;
				
				if(Bestreport == null || Bestreport.equals("")){
					BestReports = new String[1];
					BestReports[0] = "NO_DATA";
				}else{
					if(Bestreport.length() > 5 && Bestreport.substring(Bestreport.length() - 5, Bestreport.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Bestreport = Bestreport.substring(0, Bestreport.length() - 5);
					}
				BestReports = Bestreport.split("plus;");//カンマで区切って分解し配列に格納
				}
				if(Bestreporter == null || Bestreporter.equals("")){
					BestReporters = new String[1];
					BestReporters[0] = "NO_DATA";
				}else{
					if(Bestreporter.length() > 5 && Bestreporter.substring(Bestreporter.length() - 5, Bestreporter.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Bestreporter = Bestreporter.substring(0, Bestreporter.length() - 5);
					}
				BestReporters = Bestreporter.split("plus;");
				}
				int G_Score_R = rs.getInt("Gsc");//名作ランキングの順位
				int Dai1_insyou_R = rs.getInt("Dai1");//第一印象ランキングの順位
				int Nenkan_R = rs.getInt("year");//ビッグヒットランキングの順位
				int Rep_Count_R = rs.getInt("Repc");//人気作ランキングの順位
				int G_Count = rs.getInt("g_count");//G-proに登録されている全作品の数
				
				int Seigen_Kaisu = rs.getInt("seigen_kaisu");//同一ゲームのレポート提出制限数
				Access_Count = rs.getInt("access_count");//このゲームデータへのアクセス回数(マーケティング分析用)
				//rs.updateInt("access_count", Access_Count + 1);//アクセスが行われたのでアクセス回数を1回追加
				//rs.updateRow();
				
				GSData = new GS_jyouhou_TO(Gamecode, Platform, Gametitle, Maingenre, Subgenre1, Subgenre2,  dificultty, story, graphic, sound, volume, controll, promotion, free_S,  Makercode, Developer_Code, Makername, Developer_Name, Hatsubainengappi, Rating, Lisence, Kyokajyouken, Gaiyou, BestGaiyou, Logoaddress, Movieaddress,
						 GoodKeyWords, BadKeyWords, MainKeyWords, HyoukaKeyWords, BestReports, BestReporters, G_score, Dai1_Insyou, Nenkan, Report_count,	G_Score_R, Dai1_insyou_R, Nenkan_R, Rep_Count_R, G_Count, Seigen_Kaisu, Access_Count);
			}
			//con.commit();
			
			
			sql = "UPDATE gamedata SET access_count = ? WHERE gamecode = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, Access_Count + 1);
			pstmt.setString(2, GameCode);
			pstmt.executeUpdate();
			
			return GSData;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}

	public GS_jyouhou_TO NewGames_SyousaiSeach(String Gamecode){
		GS_jyouhou_TO NewGSData = null;
		Connection con = null;
		try{
			con = createConnection();
			
			String sql = "SELECT gamecode, gametitle, platform, davelopper, publisher, maingenre, subgenre1, subgenre2, rating, gaiyou, hatsubainengappi, shinchokudo, logoaddress, movieaddress, access_count, comment FROM hatsubaimae WHERE gamecode = " + HttpUtility.escapeSQL(Gamecode) + ";";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String GameCode = rs.getString("gamecode");
				String GameTitle = rs.getString("gametitle");
				String PlatForm = rs.getString("platform");
				String Publisher = rs.getString("publisher");
				String Developper = rs.getString("developper");
				String MainGenre = rs.getString("maingenre");
				String SubGenre1 = rs.getString("subgenre1");
				String SubGenre2 = rs.getString("subgenre2");
				String Rating = rs.getString("rating");
				String Gaiyou = rs.getString("gaiyou");
				String Hatsubainengappi = rs.getString("hatsubainengappi");
				String Shinchokudo = rs.getString("shinchokudo");
				String Logoaddress = rs.getString("logoaddress");
				String Movieaddress = rs.getString("movieaddress");
				String Comment_S = rs.getString("comment");
				int Access_Count = rs.getInt("access_count");//このゲームデータへのアクセス回数(マーケティング分析用)
				rs.updateInt("access_count", Access_Count + 1);//アクセスが行われたのでアクセス回数を1回追加
				Comment_S = Comment_S.substring(0, Comment_S.length() - 5);
				String[] Comments = Comment_S.split("plus;");
				
				NewGSData = new GS_jyouhou_TO(GameCode, GameTitle, PlatForm, Publisher, Developper, MainGenre, SubGenre1, SubGenre2, Rating, Gaiyou, Hatsubainengappi, Shinchokudo, Logoaddress, Movieaddress, Access_Count, Comments);
			}
			return NewGSData;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}
}
