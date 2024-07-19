package gpro_ron;

import inputUtility.Date_Changer;
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
import ninsyou.N_jyouhou_TO;

public class GRon_Data_DAO {
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
	public ArrayList<GRon_Data_TO> GRon_Gaiyou_Load(){//検索結果表示用の概要データ
		ArrayList<GRon_Data_TO> Gaiyou = new ArrayList<GRon_Data_TO>();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT keijiban_code, gidai, kaisetsunichiji, shimekirinichiji, kaisetsusya, gp_id, first_write, totalrespcount, jyoukensyubetsu, playerlv_min, playerlv_max, sc_syubetsu, sc_min, rankjyouken, rank_min, kakikomijyougen, touhyoujyougen, sex " +
					"FROM grondata WHERE (DATEDIFF(kaisetsunichiji, NOW()) <= 0) AND (DATEDIFF(shimekirinichiji, NOW()) <= 365) AND (lock_info = 0);";
			//lock_infoは掲示板のロック状態。0＝公開、1＝開設者都合による削除、2=ゲームマスターの判断による削除、3=システムエラーが発生した場合の一時退避データ。なお、このプログラムでは0から1への変更以外はできない
			//System.out.println(sql);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
			String Keijiban_Code = rs.getString("keijiban_code");//掲示板コード
			String Gidai = rs.getString("gidai");//議題
			String KaisetsuNichiji = rs.getString("kaisetsunichiji");//開設された日時
			String ShimekiriNichiji = rs.getString("shimekirinichiji");//書き込み受付の締切日時
			String Kaisetsusya = rs.getString("kaisetsusya");//開設者プレイヤーネーム
			String Kaisetsusya_ID = rs.getString("gp_id");
			String First_Write = rs.getString("first_write");
			int TotalRespCount = rs.getInt("totalrespcount");//レスポンス数合計
			String JyoukenSyubetsu = rs.getString("jyoukensyubetsu");//書き込み条件の種別
			int PlayerLv_Min = rs.getInt("playerlv_min");//プレイヤーレベル・年齢の下限(書き込み条件)
			int PlayerLv_Max = rs.getInt("playerlv_max");//プレイヤーレベル・年齢の上限(書き込み条件)
			String Sc_Syubetsu = rs.getString("sc_syubetsu");//条件とするパラメータ
			double Sc_Min = rs.getDouble("sc_min");//各種スコアの下限
			String RankJyouken = rs.getString("rankjyouken");//条件とするプレイヤーの順位
			int Rank_Min = rs.getInt("rank_min");//順位の下限
			int KakikomiJyougen = rs.getInt("kakikomijyougen");//この掲示板に(1人で)書き込める回数
			int TouhyouJyougen = rs.getInt("touhyoujyougen");
			String Sex = rs.getString("sex");
			
			GRon_Data_TO Log = new GRon_Data_TO(Keijiban_Code, Gidai, KaisetsuNichiji, ShimekiriNichiji, Kaisetsusya, Kaisetsusya_ID, First_Write, TotalRespCount, JyoukenSyubetsu, PlayerLv_Min, PlayerLv_Max, Sc_Syubetsu, Sc_Min, RankJyouken, Rank_Min, KakikomiJyougen, TouhyouJyougen, Sex);
			
			//System.out.println(Log.getKeijiban_Code());
			Gaiyou.add(Log);
			}
		return Gaiyou;
		
	}catch(SQLException e ){
		e.printStackTrace();
		return null;
		
	}finally{
		closeConnection(con);
	}
	}
	
	
	public ArrayList<GRon_Data_TO> GRon_Kakikomi_Load(String Keijiban_Code, String Kaiin_ID){//書き込みのロード
		ArrayList<GRon_Data_TO> Syousai = new ArrayList<GRon_Data_TO>();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT keijiban_code, henshin_lv, kakikomi_no, origin_youso, gp_player_name, gp_id, gp_player_lv, kakikominichiji, kakikomi_honbun, shijisyasu, fushijisyasu, henshinsu, (SELECT COUNT(gp_id) FROM kakikomidata WHERE gp_id = '" + HttpUtility.escapeSQL(Kaiin_ID) + "') AS kakikomikaisu, vote_list, kakikomijyougen, touhyoujyougen, (SELECT MAX(kakikomi_no) FROM kakikomidata WHERE keijiban_code = '" + HttpUtility.escapeSQL(Keijiban_Code) + "' ) AS saikoubi FROM kakikomidata " +
					" WHERE keijiban_code = '" + HttpUtility.escapeSQL(Keijiban_Code) + "' AND lock_info = 0; ";
			//lock_infoは掲示板のロック状態。0＝公開、1＝違反報告による一時削除、2=ゲームマスターの判断による一時削除、3=システムエラーが発生した場合の一時退避データ。なお、このプログラムでは0から1への変更以外はできない
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String KeijiCode = rs.getString("keijiban_code");//掲示板コード
				int Henshin_Lv = rs.getInt("henshin_lv");//返信レベル
				int Kakikomi_No = rs.getInt("kakikomi_no");//書き込みの整理番号
				int Origin_Youso = rs.getInt("origin_youso");//どの書き込みに対する返信か
				String Kijyutsusya_Name = rs.getString("gp_player_name");//記述者のプレイヤーネーム
				String Kijyutsusya_ID = rs.getString("gp_id");//記述者のID
				int Kijyutsusya_Lv = rs.getInt("gp_player_lv");//記述者の投稿時のプレイヤーレベル
				String KakikomiNichiji = rs.getString("kakikominichiji");//この書き込みがされた日時
				String Kakikomi_Honbun = rs.getString("kakikomi_honbun");//書き込み本文
				int Shijisyasu = rs.getInt("shijisyasu");//支持者数
				int Fushijisyasu = rs.getInt("fushijisyasu");//不支持者数
				int Henshinsu = rs.getInt("henshinsu");//返信数
				int Kakikomi_Kaisu = rs.getInt("kakikomikaisu");//この書き込みに対して閲覧者個人が返信した回数（SQL内でカウント)
				int KakikomiJyougen = rs.getInt("kakikomijyougen");//この書き込みに対して返信できる回数の合計
				int TouhyouJyougen = rs.getInt("touhyoujyougen");//この書き込みに対して投票できる回数の合計
				String Vote_List_S = rs.getString("vote_list");//投票者IDのリスト
				int Saikoubi = rs.getInt("saikoubi");//一番最後に書き込まれた書き込みの整理番号
				int Touhyou_Kaisu = 0;//この書き込みに対して閲覧者個人が投票した回数
				
				if(!(Kaiin_ID.equals("guest"))){
					Touhyou_Kaisu = 0;
				}else{
				
				String[] Vote_List = null;
				if(Vote_List_S != null){
					if(Vote_List_S.substring(Vote_List_S.length() - 5, Vote_List_S.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
					Vote_List_S = Vote_List_S.substring(0, Vote_List_S.length() - 5);//最後の"plus;"を削除
					}
				Vote_List = Vote_List_S.split("plus;");
				for(String Key : Vote_List){
					if(Key.equals(HttpUtility.escapeSQL(Kaiin_ID))){
					Touhyou_Kaisu++;	
					}
				}
				}else{
					Vote_List = new String[1];
					Vote_List[0] = "";
				}
				}
				//Calendar KakikomiNichiji = Date_Changer.toCalendar(KakikomiNichiji_S);
				GRon_Data_TO Log = new GRon_Data_TO(KeijiCode, Henshin_Lv, Kakikomi_No, Origin_Youso, Kijyutsusya_Name, Kijyutsusya_ID, Kijyutsusya_Lv, KakikomiNichiji, Kakikomi_Honbun, Shijisyasu, Fushijisyasu, Henshinsu, Kakikomi_Kaisu, Touhyou_Kaisu, KakikomiJyougen, TouhyouJyougen, Saikoubi);
				Syousai.add(Log);
			}
			return Syousai;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
			
			public GRon_Data_TO GRon_SyousaiLoad(String Keijiban_Code){//討論ページ用詳細データのロード
				Connection con = null;
				GRon_Data_TO Syousai = new GRon_Data_TO();
				try{

					con = createConnection();
					
			String sql = "SELECT keijiban_code, gidai, kaisetsunichiji, shimekirinichiji, kaisetsusya, gp_id, first_write, totalrespcount, jyoukensyubetsu, playerlv_min, playerlv_max, sc_syubetsu, sc_min, rankjyouken, rank_min, kakikomijyougen, touhyoujyougen, sex " +
			" FROM grondata WHERE (keijiban_code = '" + HttpUtility.escapeSQL(Keijiban_Code) + "') AND (lock_info = 0);";
			//lock_infoは掲示板のロック状態。0＝公開、1＝開設者都合による削除、2=ゲームマスターの判断による削除、3=システムエラーが発生した場合の一時退避データ。なお、このプログラムでは0から1への変更以外はできない
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Keijiban_code = rs.getString("keijiban_code");//掲示板コード
				String Gidai = rs.getString("gidai");//議題
				String KaisetsuNichiji = rs.getString("kaisetsunichiji");//開設日時
				String ShimekiriNichiji = rs.getString("shimekirinichiji");//書き込みの締切日時
				String Kaisetsusya = rs.getString("kaisetsusya");//開設者プレイヤーネーム
				String Kaisetsusya_ID = rs.getString("gp_id");
				String First_Write = rs.getString("first_write");
				int TotalRespCount = rs.getInt("totalrespcount");//レスポンス数合計(バッチ処理時に再計算)
				String JyoukenSyubetsu = rs.getString("jyoukensyubetsu");//書き込み条件の種別
				int PlayerLv_Min = rs.getInt("playerlv_min");//プレイヤーレベル下限(書き込み条件)
				int PlayerLv_Max = rs.getInt("playerlv_max");//プレイヤーレベル上限(書き込み条件)
				String Sc_Syubetsu = rs.getString("sc_syubetsu");//条件とするパラメータ
				double Sc_Min = rs.getDouble("sc_min");//スコア下限(書き込み条件)
				String RankJyouken = rs.getString("rankjyouken");//条件とする順位の種類
				int Rank_Min = rs.getInt("rank_min");//順位下限
				int KakikomiJyougen = rs.getInt("kakikomijyougen");//この掲示板に書き込める回数
				int TouhyouJyougen = rs.getInt("touhyoujyougen");
				String Sex = rs.getString("sex");
				
				Syousai = new GRon_Data_TO(Keijiban_code, Gidai, KaisetsuNichiji, ShimekiriNichiji, Kaisetsusya, Kaisetsusya_ID, First_Write, TotalRespCount, JyoukenSyubetsu, PlayerLv_Min, PlayerLv_Max, Sc_Syubetsu, Sc_Min, RankJyouken, Rank_Min, KakikomiJyougen, TouhyouJyougen, Sex);
				}
			return Syousai;
			
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
				}
			
			public ArrayList<GRon_Data_TO> GRon_IndexLoad(){//index.jsp用データのロード
				Connection con = null;
				ArrayList<GRon_Data_TO> Result = new ArrayList<GRon_Data_TO>();
				try{

					con = createConnection();
					
			String sql = "SELECT keijiban_code, gidai, shimekirinichiji, first_write FROM grondata WHERE shimekirinichiji >= NOW() AND lock_info = 0;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Keijiban_Code = rs.getString("keijiban_code");
				String Gidai = rs.getString("gidai");
				String ShimekiriNichiji = rs.getString("shimekirinichiji");
				String First_Write = rs.getString("first_write");
				GRon_Data_TO List = new GRon_Data_TO(Keijiban_Code, Gidai, ShimekiriNichiji, First_Write);
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

			public boolean Vote_CountUp(String Keijiban_Code, String Vote, int Kakikomi_No,  String Kaiin_Id ){//投票が行われた時の書き込み回数のアップ処理
				Connection con = null;
				String Vote_Syubetsu = null;
				if(Vote.equals("shiji")){
					Vote_Syubetsu = "shijisyasu";
				}else if(Vote.equals("fushiji")){
					Vote_Syubetsu = "fushijisyasu";
				}else{
					return false;
				}
				
				try{
					con = createConnection();
					
			String sql = "SELECT keijiban_code, kakikomi_no, shijisyasu, fushijisyasu, vote_list FROM kakikomidata WHERE keijiban_code = '" +  HttpUtility.escapeSQL(Keijiban_Code) + "' AND kakikomi_no = " + Kakikomi_No + ";";
			
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				int KakikomiNo = rs.getInt("kakikomi_no");//書き込みの整理番号
				int Shijisyasu = rs.getInt("shijisyasu");//支持者数
				int Fushijisyasu = rs.getInt("fushijisyasu");//不支持者数
				String Vote_List = rs.getString("vote_list");//投票者リスト
				int Hendou = 0;
				
				if(KakikomiNo == Kakikomi_No){
					if(Vote.equals("shiji")){//支持した場合は
						Hendou = Shijisyasu + 1;
					}else if(Vote.equals("fushiji")){//不支持の場合は
						Hendou = Fushijisyasu + 1;
					}
				}
					if(KakikomiNo == Kakikomi_No){
					}		
			sql = "UPDATE kakikomidata SET " + Vote_Syubetsu + " = ?, vote_list = ? WHERE keijiban_code = ? AND kakikomi_no = ?;";
			PreparedStatement stmt2 = con.prepareStatement(sql);
			
					stmt2.setInt(1, Hendou);//支持者数を1上げて書き戻す
					if(Vote_List != null){
					stmt2.setString(2, Vote_List + HttpUtility.escapeSQL(Kaiin_Id) + "plus;");//投票者リストに投票者のIDを追加
					}else{
						stmt2.setString(2, HttpUtility.escapeSQL(Kaiin_Id));//投票者リストに投票者のIDを追加
					}
					
				stmt2.setString(3, HttpUtility.escapeSQL(Keijiban_Code));
				stmt2.setInt(4, Kakikomi_No);
				stmt2.executeUpdate();
				}
			}catch(SQLException e ){
				e.printStackTrace();
				return false;
				
			}finally{
				closeConnection(con);
			}
				return true;
			}	
			public boolean Resp_Update(GRon_Data_TO TourokuData, String Command, boolean Koushin_Flg){//書き込み(返信)の登録・編集・削除処理
				Connection con = null;
				String sql = null;
				boolean tourokuerror = false;
				try{
					con = createConnection();
					
					if(Command.equals("insert")){//登録・変更を選択した場合
					sql = "INSERT INTO kakikomidata ( keijiban_code, henshin_lv, kakikomi_no, origin_youso, gp_player_name, gp_id, gp_player_lv, kakikominichiji, kakikomi_honbun, shijisyasu, fushijisyasu, henshinsu, kakikomijyougen, touhyoujyougen, lock_info )  " +
							" VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?);";//新たに記述データを追加
					PreparedStatement stmt = con.prepareStatement(sql);
					
					stmt.setString(1, TourokuData.getKeijiban_Code());
					stmt.setInt(2, TourokuData.getHenshin_Lv());
					stmt.setInt(3, TourokuData.getKakikomi_No());
					stmt.setInt(4, TourokuData.getOrigin_Youso());
					stmt.setString(5, TourokuData.getKijyutsusya_Name());
					stmt.setString(6, TourokuData.getKijyutsusya_ID());
					stmt.setInt(7, TourokuData.getKijyutsusya_Lv());
					stmt.setString(8, TourokuData.getKakikomiNichiji());
					stmt.setString(9, TourokuData.getKakikomi_Honbun());
					stmt.setInt(10, TourokuData.getShijisyasu());
					stmt.setInt(11, TourokuData.getFushijisyasu());
					stmt.setInt(12, TourokuData.getHenshinsu());
					/*stmt.setInt(13, TourokuData.getKakikomiKaisu());
					stmt.setInt(14, TourokuData.getTouhyouKaisu());*/
					stmt.setInt(13, TourokuData.getKakikomiJyougen());
					stmt.setInt(14, TourokuData.getTouhyouJyougen());
					stmt.setInt(15, 0);//Lock_Infoは事後審査のため登録時は0(公開);
					
					stmt.executeUpdate();
						}else if(Command.equals("update")  && Koushin_Flg == true){//既に存在する書き込みを編集する場合
							sql = "UPDATE kakikomidata SET kakikominichiji = ?, kakikomi_honbun = ? WHERE keijiban_code = ? AND kakikomi_no = ? AND gp_id = ?;";//変更日時と本文を入力値で更新
							PreparedStatement stmt = con.prepareStatement(sql);
							stmt.setString(1, TourokuData.getKakikomiNichiji());
							stmt.setString(2, TourokuData.getKakikomi_Honbun());
							stmt.setString(3, TourokuData.getKeijiban_Code());
							stmt.setInt(4, TourokuData.getKakikomi_No());
							stmt.setString(5, TourokuData.getKijyutsusya_ID());
							
							stmt.executeUpdate();
						}
					
					else if(Command.equals("delete")){//System.out.println("delpoint!");//削除を選択した場合
						sql = "DELETE FROM kakikomidata WHERE keijiban_code = ? AND kakikomi_no = ? AND gp_id = ?";//該当する記述を削除
						PreparedStatement stmt = con.prepareStatement(sql);
						stmt.setString(1, TourokuData.getKeijiban_Code());
						stmt.setInt(2, TourokuData.getKakikomi_No());
						stmt.setString(3, TourokuData.getKijyutsusya_ID());
						
						stmt.executeUpdate();
					}
					
				}catch(SQLException e){
					e.printStackTrace();
					tourokuerror = true;
				}finally{
					closeConnection(con);
				}
				return tourokuerror;
			}
			
			public boolean Kouho_Update(GRon_Data_TO TourokuData){//掲示板の新規開設の申請データ(掲示板のデータとは違う)の登録処理
				Connection con = null;
				String sql = null;
				boolean tourokuerror = false;
				
				String Gidai = "";
				String GPRO_Id = "";
				try{
					con = createConnection();
					
					sql = "SELECT gidai, gp_id FROM gron_kouhodata WHERE kouho_no = (SELECT MAX(kouho_no));";
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					
					if(rs.next()){
						Gidai = rs.getString("gidai");
						GPRO_Id = rs.getString("gp_id");
					}
					
					if(!(Gidai.equals(TourokuData.getGidai()) && GPRO_Id.equals(TourokuData.getKaisetsusya_ID()))){
					sql = "INSERT INTO gron_kouhodata (gidai, up_nichiji, kaisetsukikan, kaisetsusya, gp_id, first_write, jyoukensyubetsu, playerlv_min, playerlv_max, sc_syubetsu, sc_min, rankjyouken, rank_min, kakikomijyougen, sex ) " +
							" VALUES (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?);";
					PreparedStatement pstmt = con.prepareStatement(sql);
					pstmt.setString(1, TourokuData.getGidai());
					pstmt.setString(2, Date_Changer.CalToString(TourokuData.getUp_Nichiji()));
					pstmt.setString(3, TourokuData.getKaisetsukikan());
					pstmt.setString(4, TourokuData.getKaisetsusya());
					pstmt.setString(5, TourokuData.getKaisetsusya_ID());
					pstmt.setString(6, TourokuData.getFirst_Write());
					pstmt.setString(7, TourokuData.getJyoukenSyubetsu());
					pstmt.setInt(8, TourokuData.getPlayerLv_Min());
					pstmt.setInt(9, TourokuData.getPlayerLv_Max());
					pstmt.setString(10, TourokuData.getSc_Syubetsu());
					pstmt.setDouble(11, TourokuData.getSc_Min());
					pstmt.setString(12, TourokuData.getRankJyouken());
					pstmt.setInt(13, TourokuData.getRank_Min());
					pstmt.setInt(14, TourokuData.getKakikomiJyougen());
					pstmt.setString(15, TourokuData.getSex());
					
					pstmt.executeUpdate();
					}
			}catch(SQLException e){
				e.printStackTrace();
				tourokuerror = true;
			}finally{
				closeConnection(con);
			}
			return tourokuerror;
		}
			
			public boolean Del_Update(String KeijibanCode){
				Connection con = null;
				String sql = null;
				boolean tourokuerror = false;
				try{
					con = createConnection();
					
					sql = "UPDATE grondata SET lock_info = 1 WHERE keijiban_Code = ?;";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, HttpUtility.escapeSQL(KeijibanCode));
					
					stmt.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
					tourokuerror = true;
				}finally{
					closeConnection(con);
				}
				return tourokuerror;
			}
			
			public boolean Kakikomi_KariSakujyo(String KeijibanCode, int Kakikomi_No, String Sakujyosya_ID){
				Connection con = null;
				String sql = null;
				boolean tourokuerror = false;
				try{
					con = createConnection();
					
					sql = "UPDATE kaikomidata SET lock_info = 1, tsuhousya_id = ? WHERE keijiban_Code = ? AND kakikomi_no = ?;";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, HttpUtility.escapeSQL(Sakujyosya_ID));//通報したプレイヤーのID(バッチ処理時に専用テーブルにリスト化)
					stmt.setString(2, HttpUtility.escapeSQL(KeijibanCode));
					stmt.setInt(3, Kakikomi_No);
					
					stmt.executeUpdate();
				}catch(SQLException e){
					e.printStackTrace();
					tourokuerror = true;
				}finally{
					closeConnection(con);
				}
				return tourokuerror;
			}
			
			public boolean ID_Henkou_Upload(K_Touroku_TO ChangeData, N_jyouhou_TO baseData){//r_dataデータベースに対する認証情報変更処理
				Connection con = null;
				boolean tourokuerror = true;
				String sql = "";
				try{
					con = createConnection();
					
					String[] yobidashi = new String[3];//提出者会員IDのカラム名が「gp_id」のテーブル
					yobidashi[0] = "grondata";
					yobidashi[1] = "gron_kouhodata";
					yobidashi[2] = "kakikomidata";
					
					for(int i=0; i < yobidashi.length; i++){
					sql = "UPDATE " + yobidashi[i] + " SET gp_id = ? WHERE gp_id = ?;";
					PreparedStatement stmt = con.prepareStatement(sql);
					stmt.setString(1, ChangeData.getKibou_Id());
					stmt.setString(2, baseData.getK_Id());
					stmt.executeUpdate();
					}
					
				}catch(SQLException e){
					e.printStackTrace();
					tourokuerror = true;
				}finally{
					closeConnection(con);
				}
				return tourokuerror;
			}
}
