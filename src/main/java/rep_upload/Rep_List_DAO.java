package rep_upload;

import inputUtility.CodeMaker;
import inputUtility.Date_Changer;
import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import k_jyouhou.K_Touroku_TO;
import ninsyou.N_jyouhou_TO;
import times.Date_Maker;

public class Rep_List_DAO {

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
	
	public String ox_touroku(Rep_List_TO oxdata){//OXレポート(ゲーム情報からの登録)
		Connection con = null;
		Calendar Now = new GregorianCalendar();
		try{
			String Rep_Code = CodeMaker.Rep_Code_Maker("ox", Now);
			con = createConnection();
			
			String sql = "INSERT INTO oxdata (rep_code, uploaddate, uploadtime, gamecode, gametitle, platform, k_id, login_name, seinengappi, sex, pref, dificultty, story, graphic, sound, volume, controll, promotion, free_s, total, " +
					" jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5, jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5, jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5, " +
					" outline, outline_koushin, goodies, badies, interview1, interview2, interview3, interview4, interview5, interview6, kounyu_houhou, " +
					" shinsajyoukyou, keisaijyoukyou, hyouka_rank, rep_score, saiyou_bonus, job ) " +
					" values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Rep_Code);
			stmt.setDate(2, new java.sql.Date(new Date().getTime()));//提出日時
			stmt.setTime(3, new java.sql.Time(new Date().getTime()));
			stmt.setString(4, oxdata.getgamecode());
			stmt.setString(5, oxdata.getgametitle());
			stmt.setString(6, oxdata.getPlatForm());
			
			stmt.setString(7, oxdata.getk_id());
			stmt.setString(8, oxdata.getlogin_name());
			stmt.setString(9, oxdata.getSeinengappi());
			stmt.setString(10, oxdata.getSex());
			stmt.setString(11, oxdata.getPref());
			
			stmt.setDouble(12, oxdata.getdificultty());
			stmt.setDouble(13, oxdata.getstory());
			stmt.setDouble(14, oxdata.getgraphic());
			stmt.setDouble(15, oxdata.getsound());
			stmt.setDouble(16, oxdata.getvolume());
			stmt.setDouble(17, oxdata.getcontroll());
			stmt.setDouble(18, oxdata.getpromotion());
			stmt.setDouble(19, oxdata.getfree_S());
			stmt.setDouble(20, oxdata.gettotal());
			
			stmt.setString(21, oxdata.getjiyuten_koumoku1());
			stmt.setString(22, oxdata.getjiyuten_koumoku2());
			stmt.setString(23, oxdata.getjiyuten_koumoku3());
			stmt.setString(24, oxdata.getjiyuten_koumoku4());
			stmt.setString(25, oxdata.getjiyuten_koumoku5());
			
			stmt.setDouble(26, oxdata.getjiyuten_score1());
			stmt.setDouble(27, oxdata.getjiyuten_score2());
			stmt.setDouble(28, oxdata.getjiyuten_score3());
			stmt.setDouble(29, oxdata.getjiyuten_score4());
			stmt.setDouble(30, oxdata.getjiyuten_score5());
			
			stmt.setDouble(31, oxdata.getjiyuten_maxscore1());
			stmt.setDouble(32, oxdata.getjiyuten_maxscore2());
			stmt.setDouble(33, oxdata.getjiyuten_maxscore3());
			stmt.setDouble(34, oxdata.getjiyuten_maxscore4());
			stmt.setDouble(35, oxdata.getjiyuten_maxscore5());
			
			stmt.setString(36, oxdata.getoutline());
			stmt.setString(37, "");//概要を更新するか(outline_koushin)
			stmt.setString(38, oxdata.getgoodies());
			stmt.setString(39, oxdata.getbadies());
			
			String[] Set1 = oxdata.getInterview1();//配列の内容をカンマ区切りで1つの文字列として格納
			int i=0;
			String Res1 = "";
			for (String int1 : Set1){
				int1 = Set1[i];
				Res1 = Res1 + int1 + "plus;";
				i++;
			}
			//Res1 = Res1.substring(0, Res1.length() - 5);//最後の切り分け用文字列を消去
			stmt.setString(40, Res1);
			
			stmt.setString(41, oxdata.getInterview2());
			
			String[] Set2 = oxdata.getInterview3();//配列の内容をカンマ区切りで1つの文字列として格納
			i=0;
			String Res2 = "";
			for (String int2 : Set2){
				int2 = Set2[i];
				Res2 = Res2 + int2 + "plus;";
				i++;
			}
			//Res2 = Res2.substring(0, Res2.length() - 5);
			stmt.setString(42, Res2);
			
			stmt.setString(43, oxdata.getInterview4());
			
			String[] Set3 = oxdata.getInterview5_1();//配列の内容をカンマ区切りで1つの文字列として格納
			i=0;
			String Res3 = "";
			for (String int3 : Set3){
				int3 = Set3[i];
				Res3 = Res3 + int3 + "plus;";
				i++;
			}
			//Res3 = Res3.substring(0, Res3.length() - 5);
			stmt.setString(44, Res3);
			
			stmt.setString(45, oxdata.getInterview6_1());
			
			stmt.setString(46, oxdata.getKonyu_houhou());
			
			
			stmt.setString(47, "未審査");//添削したか
			stmt.setString(48, "未審査");//現在ゲーム情報に掲載されているか
			stmt.setString(49, "未審査");//評価ランク(まだDBに追加してない）
			
			stmt.setDouble(50, 0);//そのレポートの獲得レポートスコア
			stmt.setDouble(51, 0);//採用ボーナス
			
			stmt.setString(52, oxdata.getJob());
			
			stmt.executeUpdate();
			
			return Rep_Code;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	
	public String newox_touroku(Rep_List_TO newoxdata){//OXレポート(メニューからの新規登録)
		Connection con = null;
		Calendar Now = new GregorianCalendar();
		try{
			String Rep_Code = CodeMaker.Rep_Code_Maker("oxshinki", Now);
			
			con = createConnection();
			
			String sql = "INSERT INTO oxshinkidata (rep_code, uploaddate, uploadtime, gamecode, gametitle, makername, hatsubainengappi, maingenre, subgenre1, subgenre2, platform, k_id, login_name, seinengappi, sex, pref, dificultty, story, graphic, sound, volume, controll, promotion, free_s, total, " +
					" jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5, jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5, jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5, " +
					" outline, outline_koushin, goodies, badies, interview1, interview2, interview3, interview4, interview5, interview6, kounyu_houhou, " +
					" shinsajyoukyou, keisaijyoukyou, hyouka_rank, rep_score, saiyou_bonus, job ) " +
					" VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, Rep_Code);
			
			stmt.setDate(2, new java.sql.Date(new Date().getTime()));
			stmt.setTime(3, new java.sql.Time(new Date().getTime()));
			
			if(!(newoxdata.getHatsubaiNengappi().equals("不明"))){
			stmt.setString(4, CodeMaker.GameCodeMaker(newoxdata.getPlatForm(), newoxdata.getHatsubaiNengappi().substring(0, 4)));//ゲームコード
			}else{
				stmt.setString(4, "未設定");
			}
			stmt.setString(5, newoxdata.getgametitle());
			stmt.setString(6, newoxdata.getMakerName());
			
			if(newoxdata.getHatsubaiNengappi().equals("不明")){
				stmt.setString(7, "0000-01-01");
			}else{
			stmt.setString(7, newoxdata.getHatsubaiNengappi());
			}
			
			stmt.setString(8, newoxdata.getMainGenre());
			stmt.setString(9, "");//サブジャンル1
			stmt.setString(10, "");//サブジャンル2
			stmt.setString(11, newoxdata.getPlatForm());
			
			stmt.setString(12, newoxdata.getk_id());
			stmt.setString(13, newoxdata.getlogin_name());
			stmt.setString(14, newoxdata.getSeinengappi());
			stmt.setString(15, newoxdata.getSex());
			stmt.setString(16, newoxdata.getPref());
			
			stmt.setDouble(17, newoxdata.getdificultty());
			stmt.setDouble(18, newoxdata.getstory());
			stmt.setDouble(19, newoxdata.getgraphic());
			stmt.setDouble(20, newoxdata.getsound());
			stmt.setDouble(21, newoxdata.getvolume());
			stmt.setDouble(22, newoxdata.getcontroll());
			stmt.setDouble(23, newoxdata.getpromotion());
			stmt.setDouble(24, newoxdata.getfree_S());
			stmt.setDouble(25, newoxdata.gettotal());
			
			stmt.setString(26, newoxdata.getjiyuten_koumoku1());
			stmt.setString(27, newoxdata.getjiyuten_koumoku2());
			stmt.setString(28, newoxdata.getjiyuten_koumoku3());
			stmt.setString(29, newoxdata.getjiyuten_koumoku4());
			stmt.setString(30, newoxdata.getjiyuten_koumoku5());
			
			stmt.setDouble(31, newoxdata.getjiyuten_score1());
			stmt.setDouble(32, newoxdata.getjiyuten_score2());
			stmt.setDouble(33, newoxdata.getjiyuten_score3());
			stmt.setDouble(34, newoxdata.getjiyuten_score4());
			stmt.setDouble(35, newoxdata.getjiyuten_score5());
			
			stmt.setDouble(36, newoxdata.getjiyuten_maxscore1());
			stmt.setDouble(37, newoxdata.getjiyuten_maxscore2());
			stmt.setDouble(38, newoxdata.getjiyuten_maxscore3());
			stmt.setDouble(39, newoxdata.getjiyuten_maxscore4());
			stmt.setDouble(40, newoxdata.getjiyuten_maxscore5());
			
			stmt.setString(41, newoxdata.getoutline());
			stmt.setString(42, "");//概要を更新するか(outline_koushin)
			stmt.setString(43, newoxdata.getgoodies());
			stmt.setString(44, newoxdata.getbadies());
			
			String[] Set1 = newoxdata.getInterview1();
			int i=0;
			String Res1 = "";
			for (String int1 : Set1){
				int1 = Set1[i];
				Res1 = Res1 + int1 + "plus;";
				i++;
			}
			//Res1 = Res1.substring(0, Res1.length() - 5);
			stmt.setString(45, Res1);
			
			stmt.setString(46, newoxdata.getInterview2());
			
			String[] Set2 = newoxdata.getInterview3();
			i=0;
			String Res2 = "";
			for (String int2 : Set2){
				int2 = Set2[i];
				Res2 = Res2 + int2 + "plus;";
				i++;
			}
			//Res2 = Res2.substring(0, Res2.length() - 5);
			stmt.setString(47, Res2);
			
			stmt.setString(48, newoxdata.getInterview4());
			
			String[] Set3 = newoxdata.getInterview5_1();//配列の内容をカンマ区切りで1つの文字列として格納
			i=0;
			String Res3 = "";
			for (String int3 : Set3){
				int3 = Set3[i];
				Res3 = Res3 + int3 + "plus;";
				i++;
			}
			//Res3 = Res3.substring(0, Res3.length() - 5);
			stmt.setString(49, Res3);
			
			stmt.setString(50, newoxdata.getInterview6_1());
			
			stmt.setString(51, newoxdata.getKonyu_houhou());
			
			
			stmt.setString(52, "未審査");//添削状況
			stmt.setString(53, "未審査");//ゲーム情報に掲載されたか
			stmt.setString(54, "未審査");//評価ランク
			
			stmt.setDouble(55, 0);//そのレポートの基本レポートスコア
			stmt.setDouble(56, 0);//採用ボーナス
			stmt.setString(57, newoxdata.getJob());
			
			stmt.executeUpdate();
			
			return Rep_Code;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	public String kiji_touroku(Rep_List_TO kijidata){//紹介記事レポート(ゲーム情報からの登録)
		Connection con = null;
		Calendar Now = new GregorianCalendar();
		try{
			String Rep_Code = CodeMaker.Rep_Code_Maker("kiji", Now);
			
			con = createConnection();
			
			String sql = "INSERT INTO kijidata (rep_code, uploaddate, uploadtime, gamecode, gametitle, platform, k_id, login_name, seinengappi, sex, pref, dificultty, story, graphic, sound, volume, controll, promotion, free_s, total, " +
					" jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5, jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5, jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5, " +
					" outline, outline_koushin, midashi, feature, evaluate, interview1, interview2, interview3, interview4, interview5, interview6, kounyu_houhou, " +
					" shinsajyoukyou, keisaijyoukyou, hyouka_rank, rep_score, saiyou_bonus, job ) VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Rep_Code);
			stmt.setDate(2, new java.sql.Date(new Date().getTime()));
			stmt.setTime(3, new java.sql.Time(new Date().getTime()));
			stmt.setString(4, kijidata.getgamecode());
			stmt.setString(5, kijidata.getgametitle());
			stmt.setString(6, "");//ゲームのプラットフォーム
			
			stmt.setString(7, kijidata.getk_id());
			stmt.setString(8, kijidata.getlogin_name());
			stmt.setString(9, kijidata.getSeinengappi());
			stmt.setString(10, kijidata.getSex());
			stmt.setString(11, kijidata.getPref());
			
			stmt.setDouble(12, kijidata.getdificultty());
			stmt.setDouble(13, kijidata.getstory());
			stmt.setDouble(14, kijidata.getgraphic());
			stmt.setDouble(15, kijidata.getsound());
			stmt.setDouble(16, kijidata.getvolume());
			stmt.setDouble(17, kijidata.getcontroll());
			stmt.setDouble(18, kijidata.getpromotion());
			stmt.setDouble(19, kijidata.getfree_S());
			stmt.setDouble(20, kijidata.gettotal());
			
			stmt.setString(21, kijidata.getjiyuten_koumoku1());
			stmt.setString(22, kijidata.getjiyuten_koumoku2());
			stmt.setString(23, kijidata.getjiyuten_koumoku3());
			stmt.setString(24, kijidata.getjiyuten_koumoku4());
			stmt.setString(25, kijidata.getjiyuten_koumoku5());
			
			stmt.setDouble(26, kijidata.getjiyuten_score1());
			stmt.setDouble(27, kijidata.getjiyuten_score2());
			stmt.setDouble(28, kijidata.getjiyuten_score3());
			stmt.setDouble(29, kijidata.getjiyuten_score4());
			stmt.setDouble(30, kijidata.getjiyuten_score5());
			
			stmt.setDouble(31, kijidata.getjiyuten_maxscore1());
			stmt.setDouble(32, kijidata.getjiyuten_maxscore2());
			stmt.setDouble(33, kijidata.getjiyuten_maxscore3());
			stmt.setDouble(34, kijidata.getjiyuten_maxscore4());
			stmt.setDouble(35, kijidata.getjiyuten_maxscore5());
			
			stmt.setString(36, kijidata.getoutline());
			stmt.setString(37, "");//概要を更新するか(outline_koushin)
			stmt.setString(38, kijidata.getmidashi());
			stmt.setString(39, kijidata.getfeature());
			stmt.setString(40, kijidata.getevaluate());
			
			String[] Set1 = kijidata.getInterview1();
			int i=0;
			String Res1 = "";
			for (String int1 : Set1){
				int1 = Set1[i];
				Res1 = Res1 + int1 + "plus;";
				i++;
			}
			//Res1 = Res1.substring(0, Res1.length() - 5);
			stmt.setString(41, Res1);
			
			stmt.setString(42, kijidata.getInterview2());
			
			String[] Set2 = kijidata.getInterview3();
			i=0;
			String Res2 = "";
			for (String int2 : Set2){
				int2 = Set2[i];
				Res2 = Res2 + int2 + "plus;";
				i++;
			}
			//Res2 = Res2.substring(0, Res2.length() - 5);
			stmt.setString(43, Res2);
			
			stmt.setString(44, kijidata.getInterview4());
			
			String[] Set3 = kijidata.getInterview5_1();//配列の内容をカンマ区切りで1つの文字列として格納
			i=0;
			String Res3 = "";
			for (String int3 : Set3){
				int3 = Set3[i];
				Res3 = Res3 + int3 + "plus;";
				i++;
			}
			//Res3 = Res3.substring(0, Res3.length() - 5);
			stmt.setString(45, Res3);
			
			
			stmt.setString(46, kijidata.getInterview6_1());
			stmt.setString(47, kijidata.getKonyu_houhou());
		    
			
			stmt.setString(48, "未審査");//添削状況
			stmt.setString(49, "未審査");//ゲーム情報に掲載されたか
			stmt.setString(50, "未審査");//評価ランク
			
			stmt.setDouble(51, 0);//基本レポートスコア
			stmt.setDouble(52, 0);//採用ボーナス
			
			stmt.setString(53, kijidata.getJob());
			
			stmt.executeUpdate();
			
			return Rep_Code;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	
	public String newkiji_touroku(Rep_List_TO newkijidata){//紹介記事レポート(メニューからの新規登録)
		Connection con = null;
		Calendar Now = new GregorianCalendar();
		try{
			String Rep_Code = CodeMaker.Rep_Code_Maker("kijishinki", Now);
			
			con = createConnection();
			
			String sql = "INSERT INTO kijishinkidata (rep_code, uploaddate, uploadtime, gamecode, gametitle, makername, hatsubainengappi, maingenre, subgenre1, subgenre2, platform, k_id, login_name, seinengappi, sex, pref, dificultty, story, graphic, sound, volume, controll, promotion, free_s, total, " +
					" jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5, jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5, jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5, " +
					" outline, outline_koushin,  midashi, feature, evaluate, interview1, interview2, interview3, interview4, interview5, interview6, kounyu_houhou, " +
					" shinsajyoukyou, keisaijyoukyou, hyouka_rank, rep_score, saiyou_bonus, job ) VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Rep_Code);
			stmt.setDate(2, new java.sql.Date(new Date().getTime()));
			stmt.setTime(3, new java.sql.Time(new Date().getTime()));
			
			if(!(newkijidata.getHatsubaiNengappi().equals("不明"))){
			stmt.setString(4, CodeMaker.GameCodeMaker(newkijidata.getPlatForm(), newkijidata.getHatsubaiNengappi().substring(0, 4)));//ゲームコード
			}else{
				stmt.setString(4, "未設定");
			}
			stmt.setString(5, newkijidata.getgametitle());
			
			stmt.setString(6, newkijidata.getMakerName());

			if(newkijidata.getHatsubaiNengappi().equals("不明")){
				stmt.setString(7, "0000-01-01");
			}else{
			stmt.setString(7, newkijidata.getHatsubaiNengappi());
			}
			
			stmt.setString(8, newkijidata.getMainGenre());
			stmt.setString(9, "");//サブジャンル1
			stmt.setString(10, "");//サブジャンル2
			stmt.setString(11, newkijidata.getPlatForm());
			
			stmt.setString(12, newkijidata.getk_id());
			stmt.setString(13, newkijidata.getlogin_name());
			stmt.setString(14, newkijidata.getSeinengappi());
			stmt.setString(15, newkijidata.getSex());
			stmt.setString(16, newkijidata.getPref());
			
			stmt.setDouble(17, newkijidata.getdificultty());
			stmt.setDouble(18, newkijidata.getstory());
			stmt.setDouble(19, newkijidata.getgraphic());
			stmt.setDouble(20, newkijidata.getsound());
			stmt.setDouble(21, newkijidata.getvolume());
			stmt.setDouble(22, newkijidata.getcontroll());
			stmt.setDouble(23, newkijidata.getpromotion());
			stmt.setDouble(24, newkijidata.getfree_S());
			stmt.setDouble(25, newkijidata.gettotal());
			
			stmt.setString(26, newkijidata.getjiyuten_koumoku1());
			stmt.setString(27, newkijidata.getjiyuten_koumoku2());
			stmt.setString(28, newkijidata.getjiyuten_koumoku3());
			stmt.setString(29, newkijidata.getjiyuten_koumoku4());
			stmt.setString(30, newkijidata.getjiyuten_koumoku5());
			
			stmt.setDouble(31, newkijidata.getjiyuten_score1());
			stmt.setDouble(32, newkijidata.getjiyuten_score2());
			stmt.setDouble(33, newkijidata.getjiyuten_score3());
			stmt.setDouble(34, newkijidata.getjiyuten_score4());
			stmt.setDouble(35, newkijidata.getjiyuten_score5());
			
			stmt.setDouble(36, newkijidata.getjiyuten_maxscore1());
			stmt.setDouble(37, newkijidata.getjiyuten_maxscore2());
			stmt.setDouble(38, newkijidata.getjiyuten_maxscore3());
			stmt.setDouble(39, newkijidata.getjiyuten_maxscore4());
			stmt.setDouble(40, newkijidata.getjiyuten_maxscore5());
			
			
			stmt.setString(41, newkijidata.getoutline());
			stmt.setString(42, "");//概要を更新するか(outline_koushin)
			stmt.setString(43, newkijidata.getmidashi());
			stmt.setString(44, newkijidata.getfeature());
			stmt.setString(45, newkijidata.getevaluate());
			
			String[] Set1 = newkijidata.getInterview1();
			int i=0;
			String Res1 = "";
			for (String int1 : Set1){
				int1 = Set1[i];
				Res1 = Res1 + int1 + "plus;";
				i++;
			}
			//Res1 = Res1.substring(0, Res1.length() - 5);
			stmt.setString(46, Res1);
		
			stmt.setString(47, newkijidata.getInterview2());
			
			String[] Set2 = newkijidata.getInterview3();
			i=0;
			String Res2 = "";
			for (String int2 : Set2){
				int2 = Set2[i];
				Res2 = Res2 + int2 + "plus;";
				i++;
			}
			//Res2 = Res2.substring(0, Res2.length() - 5);
			stmt.setString(48, Res2);
			
			stmt.setString(49, newkijidata.getInterview4());
			
			String[] Set3 = newkijidata.getInterview5_1();//配列の内容をカンマ区切りで1つの文字列として格納
			i=0;
			String Res3 = "";
			for (String int3 : Set3){
				int3 = Set3[i];
				Res3 = Res3 + int3 + "plus;";
				i++;
			}
			//Res3 = Res3.substring(0, Res3.length() - 5);
			stmt.setString(50, Res3);
			
			stmt.setString(51, newkijidata.getInterview6_1());
			stmt.setString(52, newkijidata.getKonyu_houhou());
			
			
			stmt.setString(53, "未審査");//添削状況
			stmt.setString(54, "未審査");//ゲーム情報に掲載されたか
			stmt.setString(55, "未審査");//評価ランク
			
			stmt.setDouble(56, 0);//そのレポートの基本レポートスコア
			stmt.setDouble(57, 0);//採用ボーナス
			
			stmt.setString(58, newkijidata.getJob());
			
			stmt.executeUpdate();
			
			return Rep_Code;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	
	public String free_touroku(Rep_List_TO freedata){//自由形式レポート(ゲーム情報からの登録)
		Connection con = null;
		Calendar Now = new GregorianCalendar();
		try{
			String Rep_Code = CodeMaker.Rep_Code_Maker("free", Now);
			
			con = createConnection();
			
			String sql = "INSERT INTO freedata (rep_code, uploaddate, uploadtime, gamecode, gametitle, platform, k_id, login_name, seinengappi, sex, pref, dificultty, story, graphic, sound, volume, controll, promotion, free_s, total, " +
					" jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5, jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5, jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5, " +
					" outline, outline_koushin, uploadfilename, interview1, interview2, interview3, interview4, interview5, interview6, kounyu_houhou, " + 
					" shinsajyoukyou, keisaijyoukyou, hyouka_rank, rep_score, saiyou_bonus, job ) VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Rep_Code);
			stmt.setDate(2, new java.sql.Date(new Date().getTime()));
			stmt.setTime(3, new java.sql.Time(new Date().getTime()));
			stmt.setString(4, freedata.getgamecode());
			stmt.setString(5, freedata.getgametitle());
			stmt.setString(6, "");//ゲームのプラットフォーム
			
			stmt.setString(7, freedata.getk_id());
			stmt.setString(8, freedata.getlogin_name());
			stmt.setString(9, freedata.getSeinengappi());
			stmt.setString(10, freedata.getSex());
			stmt.setString(11, freedata.getPref());
			
			stmt.setDouble(12, freedata.getdificultty());
			stmt.setDouble(13, freedata.getstory());
			stmt.setDouble(14, freedata.getgraphic());
			stmt.setDouble(15, freedata.getsound());
			stmt.setDouble(16, freedata.getvolume());
			stmt.setDouble(17, freedata.getcontroll());
			stmt.setDouble(18, freedata.getpromotion());
			stmt.setDouble(19, freedata.getfree_S());
			stmt.setDouble(20, freedata.gettotal());
			
			stmt.setString(21, freedata.getjiyuten_koumoku1());
			stmt.setString(22, freedata.getjiyuten_koumoku2());
			stmt.setString(23, freedata.getjiyuten_koumoku3());
			stmt.setString(24, freedata.getjiyuten_koumoku4());
			stmt.setString(25, freedata.getjiyuten_koumoku5());
			
			stmt.setDouble(26, freedata.getjiyuten_score1());
			stmt.setDouble(27, freedata.getjiyuten_score2());
			stmt.setDouble(28, freedata.getjiyuten_score3());
			stmt.setDouble(29, freedata.getjiyuten_score4());
			stmt.setDouble(30, freedata.getjiyuten_score5());
			
			stmt.setDouble(31, freedata.getjiyuten_maxscore1());
			stmt.setDouble(32, freedata.getjiyuten_maxscore2());
			stmt.setDouble(33, freedata.getjiyuten_maxscore3());
			stmt.setDouble(34, freedata.getjiyuten_maxscore4());
			stmt.setDouble(35, freedata.getjiyuten_maxscore5());
			
			stmt.setString(36, freedata.getoutline());
			stmt.setString(37, "");//概要を更新するか(outline_koushin)
			stmt.setString(38, freedata.getUploadFileName());
			
			String[] Set1 = freedata.getInterview1();
			int i=0;
			String Res1 = "";
			for (String int1 : Set1){
				int1 = Set1[i];
				Res1 = Res1 + int1 + "plus;";
				i++;
			}
			//Res1 = Res1.substring(0, Res1.length() - 5);
			stmt.setString(39, Res1);
			
			stmt.setString(40, freedata.getInterview2());
			
			String[] Set2 = freedata.getInterview3();
			i=0;
			String Res2 = "";
			for (String int2 : Set2){
				int2 = Set2[i];
				Res2 = Res2 + int2 + "plus;";
				i++;
			}
			//Res2 = Res2.substring(0, Res2.length() - 5);
			stmt.setString(41, Res2);
			
			stmt.setString(42, freedata.getInterview4());
			
			String[] Set3 = freedata.getInterview5_1();//配列の内容をカンマ区切りで1つの文字列として格納
			i=0;
			String Res3 = "";
			for (String int3 : Set3){
				int3 = Set3[i];
				Res3 = Res3 + int3 + "plus;";
				i++;
			}
			//Res3 = Res3.substring(0, Res3.length() - 5);
			stmt.setString(43, Res3);
			
			
			stmt.setString(44, freedata.getInterview6_1());
			stmt.setString(45, freedata.getKonyu_houhou());
			
			
			stmt.setString(46, "未審査");//審査状況
			stmt.setString(47, "未審査");//ゲーム情報に掲載されたか
			stmt.setString(48, "未審査");//評価ランク
			
			stmt.setDouble(49, 0);//そのレポートの基本レポートスコア
			stmt.setDouble(50, 0);//採用ボーナス
			
			stmt.setString(51, freedata.getJob());
			
			stmt.executeUpdate();
			
			return Rep_Code;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	public String newfree_touroku(Rep_List_TO newfreedata){//自由形式レポート(メニューからの新規登録)
		Connection con = null;
		Calendar Now = new GregorianCalendar();
		try{
			String Rep_Code = CodeMaker.Rep_Code_Maker("freeshinki", Now);
			
			con = createConnection();
			
			String sql = "INSERT INTO freeshinkidata (rep_code, uploaddate, uploadtime, gamecode, gametitle, makername, hatsubainengappi, maingenre, platform, k_id, login_name, seinengappi, sex, pref, dificultty, story, graphic, sound, volume, controll, promotion, free_s, total, " +
					" jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_koumoku4, jiyuten_koumoku5, jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_score4, jiyuten_score5, jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscore4, jiyuten_maxscore5, " +
					" outline, outline_koushin, uploadfilename, interview1, interview2, interview3, interview4, interview5, interview6, kounyu_houhou, " + 
					" shinsajyoukyou, keisaijyoukyou, hyouka_rank, rep_score, saiyou_bonus, job ) values(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, Rep_Code);
			stmt.setDate(2, new java.sql.Date(new Date().getTime()));
			stmt.setTime(3, new java.sql.Time(new Date().getTime()));
			
			if(!(newfreedata.getPlatForm() == null) || (newfreedata.getPlatForm().equals("")) || (newfreedata.getHatsubaiNengappi() == null) || (newfreedata.getHatsubaiNengappi().equals("")) || (newfreedata.getHatsubaiNengappi().equals("不明"))){
			stmt.setString(4, CodeMaker.GameCodeMaker(newfreedata.getPlatForm(), newfreedata.getHatsubaiNengappi().substring(0, 4)));//ゲームコード
			}else{
				stmt.setString(4, "未設定");
			}
			
			stmt.setString(5, newfreedata.getgametitle());
			stmt.setString(6, newfreedata.getMakerName());

			if(newfreedata.getHatsubaiNengappi().equals("不明")){
				stmt.setString(7, "0000-01-01");
			}else{
			stmt.setString(7, newfreedata.getHatsubaiNengappi());
			}
			
			stmt.setString(8, newfreedata.getMainGenre());
			stmt.setString(9, newfreedata.getPlatForm());
			
			stmt.setString(10, newfreedata.getk_id());
			stmt.setString(11, newfreedata.getlogin_name());
			stmt.setString(12, newfreedata.getSeinengappi());
			stmt.setString(13, newfreedata.getSex());
			stmt.setString(14, newfreedata.getPref());
			
			stmt.setDouble(15, newfreedata.getdificultty());
			stmt.setDouble(16, newfreedata.getstory());
			stmt.setDouble(17, newfreedata.getgraphic());
			stmt.setDouble(18, newfreedata.getsound());
			stmt.setDouble(19, newfreedata.getvolume());
			stmt.setDouble(20, newfreedata.getcontroll());
			stmt.setDouble(21, newfreedata.getpromotion());
			stmt.setDouble(22, newfreedata.getfree_S());
			stmt.setDouble(23, newfreedata.gettotal());
			
			stmt.setString(24, newfreedata.getjiyuten_koumoku1());
			stmt.setString(25, newfreedata.getjiyuten_koumoku2());
			stmt.setString(26, newfreedata.getjiyuten_koumoku3());
			stmt.setString(27, newfreedata.getjiyuten_koumoku4());
			stmt.setString(28, newfreedata.getjiyuten_koumoku5());
			
			stmt.setDouble(29, newfreedata.getjiyuten_score1());
			stmt.setDouble(30, newfreedata.getjiyuten_score2());
			stmt.setDouble(31, newfreedata.getjiyuten_score3());
			stmt.setDouble(32, newfreedata.getjiyuten_score4());
			stmt.setDouble(33, newfreedata.getjiyuten_score5());
			
			stmt.setDouble(34, newfreedata.getjiyuten_maxscore1());
			stmt.setDouble(35, newfreedata.getjiyuten_maxscore2());
			stmt.setDouble(36, newfreedata.getjiyuten_maxscore3());
			stmt.setDouble(37, newfreedata.getjiyuten_maxscore4());
			stmt.setDouble(38, newfreedata.getjiyuten_maxscore5());
			
			stmt.setString(39, newfreedata.getoutline());
			stmt.setString(40, "");//概要を更新するか(outline_koushin)
			
			stmt.setString(41, newfreedata.getUploadFileName());
			
			String[] Set1 = newfreedata.getInterview1();
			int i=0;
			String Res1 = "";
			for (String int1 : Set1){
				int1 = Set1[i];
				Res1 = Res1 + int1 + "plus;";
				i++;
			}
			//Res1 = Res1.substring(0, Res1.length() - 5);
			stmt.setString(42, Res1);
			
			stmt.setString(43, newfreedata.getInterview2());
			
			String[] Set2 = newfreedata.getInterview3();
			i=0;
			String Res2 = "'";
			for (String int2 : Set2){
				int2 = Set2[i];
				Res2 = Res2 + int2 + "plus;";
				i++;
			}
			//Res2 = Res2.substring(0, Res2.length() - 5);
			stmt.setString(44, Res2);
			
			stmt.setString(45, newfreedata.getInterview4());
			
			String[] Set3 = newfreedata.getInterview5_1();//配列の内容をカンマ区切りで1つの文字列として格納
			i=0;
			String Res3 = "";
			for (String int3 : Set3){
				int3 = Set3[i];
				Res3 = Res3 + int3 + "plus;";
				i++;
			}
			//Res3 = Res3.substring(0, Res3.length() - 5);
			stmt.setString(46, Res3);
			
			
			stmt.setString(47, newfreedata.getInterview6_1());
			stmt.setString(48, newfreedata.getKonyu_houhou());
			
			
			stmt.setString(49, "未審査");//審査状況
			stmt.setString(50, "未審査");//ゲーム情報に掲載されたか
			stmt.setString(51, "未審査");//評価ランク
			
			stmt.setDouble(52, 0);//そのレポートの基本レポートスコア
			stmt.setDouble(53, 0);//採用ボーナス
			
			stmt.setString(54, newfreedata.getJob());
			
			stmt.executeUpdate();
			
			return Rep_Code;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	
	public boolean Rep_RollBack(String Rep_Code, String Rep_Syubetsu){
		Connection con = null;
		String Table = null;
		String sql = null;
		
		try{
			if(Rep_Syubetsu.equals("marubatsu")){Table = "oxdata";}
			else if(Rep_Syubetsu.equals("newox")){Table = "oxshinkidata";}
			else if(Rep_Syubetsu.equals("kiji")){Table = "kijidata";}
			else if(Rep_Syubetsu.equals("newkiji")){Table = "kijishinkidata";}
			else if(Rep_Syubetsu.equals("free")){Table = "freedata";}
			else if(Rep_Syubetsu.equals("newfree")){Table = "freeshinkidata";}
			else{return true;}
			
			con = createConnection();
			
			sql = "DELETE FROM " + HttpUtility.escapeSQL(Table) + " WHERE rep_code = ?;";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Rep_Code);
			stmt.executeUpdate();
			
			return false;
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<Rep_List_TO> Report_Rireki(String key){//レポート提出履歴の呼び出し
		ArrayList<Rep_List_TO> Rireki = new ArrayList<Rep_List_TO>();
		Connection con = null;
		try{
			con = createConnection();
			String[] yobidashi = new String[6];
			yobidashi[0] = "oxdata";
			yobidashi[1] = "oxshinkidata";
			yobidashi[2] = "kijidata";
			yobidashi[3] = "kijishinkidata";
			yobidashi[4] = "freedata";
			yobidashi[5] = "freeshinkidata";
			
			String sql = null;
			
			for(int i=0; i < yobidashi.length; i++){
				String Re = yobidashi[i];
			sql = "SELECT k_id, gametitle, uploaddate, uploadtime, rep_score, shinsajyoukyou, keisaijyoukyou, rep_code, hyouka_rank, saiyou_bonus FROM " + Re + " WHERE ( k_id = '" + HttpUtility.escapeSQL(key) + "' ) AND (uploaddate >= (SELECT CURRENT_DATE() - INTERVAL 1 YEAR));";
			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					String report_code = rs.getString("rep_code");
					String k_id = rs.getString("k_id");
					String upload_date = rs.getString("uploaddate");
					String gametitle = rs.getString("gametitle");
					double rep_score = rs.getDouble("rep_score") + rs.getDouble("saiyou_bonus");
					String ShinsaJyoukyou = rs.getString("shinsajyoukyou");
					String KeisaiJyoukyou = rs.getString("keisaijyoukyou");
					
					Rep_List_TO Log = new Rep_List_TO(report_code, k_id, upload_date,  gametitle, rep_score, ShinsaJyoukyou, KeisaiJyoukyou);
				Rireki.add(Log);
				}
			}
		return Rireki;
		
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}
	
	public int UpKaisu(String K_ID, String GameCode, String Now){//同一のゲームに対するプレイヤーのレポート提出回数のカウント処理
		Connection con = null;
		int HitCount = 0;
		int TotalCount = 0;
		try{
			con = createConnection();
			String[] yobidashi = new String[6];
			yobidashi[0] = "oxdata";
			yobidashi[1] = "oxshinkidata";
			yobidashi[2] = "kijidata";
			yobidashi[3] = "kijishinkidata";
			yobidashi[4] = "freedata";
			yobidashi[5] = "freeshinkidata";
			
			
			String sql = null;
			
			for(int i=0; i<=2; i++){
				String Re = yobidashi[i];
			sql = "SELECT COUNT(DISTINCT(rep_code)) AS hitcount FROM " + Re + " WHERE (k_id = '" + HttpUtility.escapeSQL(K_ID) + "') AND (gamecode = '" + HttpUtility.escapeSQL(GameCode) + "') AND ((shinsanichiji >= '" + HttpUtility.escapeSQL(Now) + "') OR (shinsanichiji IS NULL)) ;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				HitCount = rs.getInt("hitcount");
			}
			TotalCount = TotalCount + HitCount;
			}
			return TotalCount;
			
			}catch(SQLException e){
				e.printStackTrace();
				return 9999;
	}finally{
		closeConnection(con);
	}
}
	
	public int HitokotoKaisu(String K_ID, String Rep_Code, String Now, String CountTaisyou){//同一のゲームに対するプレイヤーのレポート提出回数のカウント処理(テーブル単体、一言レポート用)
		Connection con = null;
		int HitCount = 0;
		int TotalCount = 0;
		try{
			con = createConnection();
			String sql = null;
			
			sql = "SELECT COUNT(rep_code) AS hitcount FROM " + HttpUtility.escapeSQL(CountTaisyou) + " WHERE (k_id = '" + HttpUtility.escapeSQL(K_ID) + "') AND (rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "') AND ((shinsanichiji >= '" + HttpUtility.escapeSQL(Now) + "') OR (shinsanichiji IS NULL)) ;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				HitCount = rs.getInt("hitcount");
			}
			TotalCount = TotalCount + HitCount;
			return TotalCount;
			
			}catch(SQLException e){
				e.printStackTrace();
				return 9999;
	}finally{
		closeConnection(con);
	}
}
	
	public int R_Data_Upload(K_Touroku_TO ChangeData, N_jyouhou_TO baseData){//r_dataデータベースに対する認証情報変更処理
		Connection con = null;
		int affected = 0;
		try{
			con = createConnection();
			String[] yobidashi = new String[6];//提出者会員IDのカラム名が「k_id」のテーブル
			yobidashi[0] = "oxdata";
			yobidashi[1] = "oxshinkidata";
			yobidashi[2] = "kijidata";
			yobidashi[3] = "kijishinkidata";
			yobidashi[4] = "freedata";
			yobidashi[5] = "freeshinkidata";
			yobidashi[6] = "proprespdata";
			
			String sql = null;
			
			for(int i=0; i < yobidashi.length; i++){
				String Re = yobidashi[i];
			sql = "UPDATE " + Re + " SET k_id = ? WHERE k_id = ?;";
			//System.out.println(sql);
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ChangeData.getKibou_Id());
			pstmt.setString(2, baseData.getK_Id());
				affected = pstmt.executeUpdate();
			}
			
			for(int i=0; i < yobidashi.length; i++){
				String Re = yobidashi[i];
				sql = "UPDATE " + Re + " SET shijisyalist = REPLACE(shijisyalist,?,?), fushijisyalist = REPLACE(fushijisyalist,?,?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ChangeData.getKibou_Id());
				pstmt.setString(2, baseData.getK_Id());
				pstmt.setString(3, ChangeData.getKibou_Id());
				pstmt.setString(4, baseData.getK_Id());
				affected = pstmt.executeUpdate();
			}
			
			sql = "UPDATE propdata SET kaiin_id = ? WHERE kaiin_id = ?;";//プロポーサルレポートはカラム名が「kaiin_id」なので別記述
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, ChangeData.getKibou_Id());
			pstmt.setString(2, baseData.getK_Id());
				affected = affected + pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			affected = -1;
		}finally{
			closeConnection(con);
		}
		return affected;
	}
	
	public ArrayList<Rep_List_TO> Prop_Serch(){
		ArrayList<Rep_List_TO> list = new ArrayList<Rep_List_TO>();
		Connection con = null;
		try{
			con = createConnection();
			String sql = "SELECT rep_code, gamecode, gametitle, penname, main_genre, catchcopy, uploadtime FROM propdata WHERE lock_info = 1 ORDER BY uploadtime desc;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String Rep_Code = rs.getString("rep_code");
				String GameCode = rs.getString("gamecode");
				String GameTitle = rs.getString("gametitle");
				String Kikakusya = rs.getString("penname");
				String MainGenre = rs.getString("main_genre");
				String CatchCopy = rs.getString("catchcopy");
				String UploadDate = rs.getString("uploadtime");
				
				Rep_List_TO PropIchiran = new Rep_List_TO(Rep_Code, GameCode, GameTitle, Kikakusya, MainGenre, CatchCopy, UploadDate);
				list.add(PropIchiran);
			}
			return list;
			
			}catch(SQLException e){
				e.printStackTrace();
				return null;
				
			}finally{
				closeConnection(con);
		}
	}
	/*public boolean VoteCount_Upload(String Rep_Code, String Command, String Kaiin_ID){
		String Taisyou_Field = null;
		Connection con = null;
		
		String Report_Code = null;
		String ShijisyaList = null;
		String FushijisyaList = null;
		try{
			con = createConnection();
			String sql = "SELECT rep_code, shijisyalist, fushijisyalist FROM bestrepdata WHERE rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				Report_Code = rs.getString("rep_code");
				ShijisyaList = rs.getString("shijisyalist");
				FushijisyaList = rs.getString("fushijisyalist");
			}
			if(Rep_Code.equals(Report_Code)){
			if(Command.equals("shiji")){
				Taisyou_Field = "shijisyalist";
			}else if(Command.equals("fushiji")){
				Taisyou_Field = "fushijisyalist";
			}
			sql = "UPDATE bestrepdata SET " + Taisyou_Field + " = ? WHERE rep_code = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			if(Command.equals("shiji")){
				if(ShijisyaList != null){
			pstmt.setString(1, ShijisyaList + Kaiin_ID);
				}else{
					pstmt.setString(1, Kaiin_ID);
				}
			}else if(Command.equals("fushiji")){
				if(FushijisyaList != null){
				pstmt.setString(1, FushijisyaList + Kaiin_ID);
				}else{
					pstmt.setString(1, Kaiin_ID);
				}
			}else{
				return false;
			}
			pstmt.setString(2, Report_Code);
			
			pstmt.executeUpdate();
			
			return true;
		}else{
			return false;
		}
		}catch(SQLException e){
			e.printStackTrace();
			return false;
			
		}finally{
			closeConnection(con);
	}
	}
	*/
	
	public boolean VoteCount_Upload(String Rep_Code, String Command, String Kaiin_ID){
		Connection con = null;
		
		try{
			con = createConnection();
			int VoteCount = -1;
			String sql = "SELECT COUNT(*) AS votecount FROM rep_vote WHERE rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "' AND k_id = '" + HttpUtility.escapeSQL(Kaiin_ID) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				VoteCount = rs.getInt("votecount");
			}
			
			if(VoteCount > 0){
				String sql2 = "UPDATE rep_vote SET rep_code = ?, k_id = ?, vote_date = NOW(), answer = ? WHERE rep_code = ? AND k_id = ?;";
				PreparedStatement pstmt = con.prepareStatement(sql2);
				pstmt.setString(1, Rep_Code);
				pstmt.setString(2, Kaiin_ID);
				pstmt.setString(3, Command);
				pstmt.setString(4, Rep_Code);
				pstmt.setString(5, Kaiin_ID);

				pstmt.executeUpdate();
				
				return false;
			}else if(VoteCount == 0){
			String sql3 = "INSERT INTO rep_vote(rep_code, k_id, vote_date, answer) VALUES(?,?,NOW(),?);";
			PreparedStatement pstmt = con.prepareStatement(sql3);
			pstmt.setString(1, Rep_Code);
			pstmt.setString(2, Kaiin_ID);
			pstmt.setString(3, Command);

			pstmt.executeUpdate();
			
			return false;
			}else{
				return true;
			}
		}catch(SQLException e){
			e.printStackTrace();
			return true;
			
			
		}finally{
			closeConnection(con);
		}
	}
	
	public int WordRep_Jyufukukakunin(String IPAddress){
		Connection con = null;
		
		con = createConnection();
		
		int HitCount = 0;
		try{
		String sql = " SELECT COUNT(*) AS hitcount FROM wordrepdata WHERE uploadtime > (SELECT DATE_ADD(now(), interval -1 MONTH) AND ipaddress = '" + HttpUtility.escapeSQL(IPAddress) + "';";
		Statement stmt1 = con.createStatement();
		ResultSet rs = stmt1.executeQuery(sql);
		if(rs.next()){
			HitCount = rs.getInt("hitcount");
		}
		return HitCount;
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
			
		}finally{
			closeConnection(con);
	}
	}
	
	public String WordRep_Touroku(Rep_Koumoku RepData, String IPAddress){//一言レポート
		Connection con = null;
		Calendar Now = new GregorianCalendar();
		try{
			String Rep_Code = CodeMaker.Rep_Code_Maker("word", Now);
			con = createConnection();
			
			String sql = "INSERT INTO wordrepdata (rep_code, gametitle, uploadtime, ipaddress, dificultty, story, graphic, sound, volume, controll, promotion, free_s, total," +
					"jiyuten_koumoku1, jiyuten_koumoku2, jiyuten_koumoku3, jiyuten_score1, jiyuten_score2, jiyuten_score3, jiyuten_scoretotal, " +
					" jiyuten_maxscore1, jiyuten_maxscore2, jiyuten_maxscore3, jiyuten_maxscoretotal, comment, lock_info) VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?)";
			
			PreparedStatement stmt2 = con.prepareStatement(sql);
			stmt2.setString(1, Rep_Code);
			stmt2.setString(2, HttpUtility.escapeSQL(RepData.getGameTitle()));
			stmt2.setString(3, HttpUtility.escapeSQL(Date_Changer.CalToString(Now)));
			stmt2.setString(4, HttpUtility.escapeSQL(IPAddress));
			stmt2.setDouble(5, RepData.getdificultty());
			stmt2.setDouble(6, RepData.getstory());
			stmt2.setDouble(7, RepData.getgraphic());
			stmt2.setDouble(8, RepData.getsound());
			stmt2.setDouble(9, RepData.getvolume());
			stmt2.setDouble(10, RepData.getcontroll());
			stmt2.setDouble(11, RepData.getpromotion());
			stmt2.setDouble(12, RepData.getfree_S());
			stmt2.setDouble(13, RepData.gettotal());
			stmt2.setString(14, RepData.getjiyuten_koumoku1());
			stmt2.setString(15, RepData.getjiyuten_koumoku2());
			stmt2.setString(16, RepData.getjiyuten_koumoku3());
			stmt2.setDouble(17, RepData.getjiyuten_score1());
			stmt2.setDouble(18, RepData.getjiyuten_score2());
			stmt2.setDouble(19, RepData.getjiyuten_score3());
			stmt2.setDouble(20, RepData.getjiyuten_scoretotal());
			stmt2.setDouble(21, RepData.getjiyuten_maxscore1());
			stmt2.setDouble(22, RepData.getjiyuten_maxscore2());
			stmt2.setDouble(23, RepData.getjiyuten_maxscore3());
			stmt2.setDouble(24, RepData.getjiyuten_maxscoretotal());
			stmt2.setString(25, HttpUtility.escapeSQL(RepData.getComment()));
			stmt2.setInt(26, 0);//Lock_info:0=初期状態（未公開）、1=公開中、2=ゲームマスター判断による公開停止

			stmt2.executeUpdate();
			
			return Rep_Code;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}
	
	public boolean Rep_Response_Touroku(Rep_List_TO RepData){//プロポーサルレポート・レスポンス
		Connection con = null;
		try{
			con = createConnection();
			
			String sql = "INSERT INTO proprespdata(rep_code, gamecode, gametitle, comment, k_id, playername, seinengappi, sex, pref, job, lock_info) VALUES (?,?,?,?,?, ?,?,?,?,?, ?);";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, RepData.getupload_date());
			stmt.setString(1, RepData.getreport_code());
			stmt.setString(2, RepData.getgamecode());
			stmt.setString(3, RepData.getgametitle());
			stmt.setString(4, RepData.getComment());
			stmt.setString(5, RepData.getk_id());
			stmt.setString(6, RepData.getlogin_name());
			stmt.setString(7, RepData.getSeinengappi());
			stmt.setString(8, RepData.getSex());
			stmt.setString(9, RepData.getPref());
			stmt.setString(10, RepData.getJob());
			stmt.setInt(11, 1);//Lock_info:0=初期状態（未公開）、1=公開中、2=ゲームマスター判断による公開停止
			stmt.executeUpdate();
			
			return false;
			
		}catch(SQLException e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<Rep_List_TO>Comment_Loader(String Rep_Code){
		Calendar Now = Date_Maker.nowGetter();
		Calendar Datediff = Calendar.getInstance();
		ArrayList<Rep_List_TO> List = new ArrayList<Rep_List_TO>();
		Rep_List_TO Result = new Rep_List_TO();
		int Nendai = 0;
		Connection con = null;
		con = createConnection();
		try{
		String sql = "SELECT comment, seinengappi, sex FROM proprespdata WHERE rep_code = '" + HttpUtility.escapeSQL(Rep_Code) + "';";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			String Comment = rs.getString("comment");
			String Seinengappi = rs.getString("seinengappi");
			String Sex = rs.getString("sex");
			long Diff = Now.getTimeInMillis() - Date_Changer.toCalendar(Seinengappi).getTimeInMillis();
			Datediff.setTimeInMillis(Diff);
			Nendai = Datediff.get(Calendar.YEAR / 10 * 10);
			
			Result = new Rep_List_TO(Comment, Nendai, Sex);
			List.add(Result);
		}
		return List;
		
		}catch(SQLException e){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
	}
}
}
