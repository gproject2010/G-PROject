package k_jyouhou;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import coupon.Coupon_Data_TO;


public class R_jyouhou_DAO {
	
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

	public R_jyouhou_TO findkaiin_NById(String Input_Id){
		R_jyouhou_TO Status = null;//会員ステータスデータの抽出用DAO
		Connection con = null;
		String[] SyougouList = null;
		String[] S_KakutokubiList = null;
		try{

			con = createConnection();
			

			String sql = "select k_number, k_id, login_name, player_level, syougou, syougoulist, s_kakutokubilist, reportscore_ruikei, reportscore_kongetsu, reportscore_sengetsu, reportscore_nenkan, report_count, actionscore_kongetsu, actionscore_sengetsu, actionscore_nenkan, actionscore_ruikei, star_count, season_star, seinengappi, sex, pref, mailage, job, " +
					
			" (SELECT COUNT(DISTINCT(reportscore_ruikei))+1 FROM reportdata WHERE reportscore_ruikei > (SELECT reportscore_ruikei from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as repsc_ruikei_rank," +
			" (SELECT COUNT(DISTINCT(reportscore_kongetsu))+1 FROM reportdata WHERE reportscore_kongetsu > (SELECT reportscore_kongetsu from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as repsc_kongetsu_rank," +
			" (SELECT COUNT(DISTINCT(reportscore_sengetsu))+1 FROM reportdata WHERE reportscore_sengetsu > (SELECT reportscore_sengetsu from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as repsc_sengetsu_rank," +
			" (SELECT COUNT(DISTINCT(reportscore_nenkan))+1 FROM reportdata WHERE reportscore_nenkan > (SELECT reportscore_nenkan from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as repsc_nenkan_rank," +
			" (SELECT COUNT(DISTINCT(report_count))+1 FROM reportdata WHERE report_count > (SELECT report_count from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as rep_count_rank," +
													
			" (SELECT COUNT(DISTINCT(actionscore_ruikei))+1 FROM reportdata WHERE actionscore_ruikei > (SELECT actionscore_ruikei from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as actsc_ruikei_rank," +
			" (SELECT COUNT(DISTINCT(actionscore_kongetsu))+1 FROM reportdata WHERE actionscore_kongetsu > (SELECT actionscore_kongetsu from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as actsc_kongetsu_rank," +
			" (SELECT COUNT(DISTINCT(actionscore_sengetsu))+1 FROM reportdata WHERE actionscore_sengetsu > (SELECT actionscore_sengetsu from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as actsc_sengetsu_rank," +
			" (SELECT COUNT(DISTINCT(actionscore_nenkan))+1 FROM reportdata WHERE actionscore_nenkan > (SELECT actionscore_nenkan from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as actsc_nenkan_rank, " +
			
			" (SELECT COUNT(DISTINCT(star_count))+1 FROM reportdata WHERE star_count > (SELECT star_count from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as star_count_rank, " +
			" (SELECT COUNT(DISTINCT(season_star))+1 FROM reportdata WHERE season_star > (SELECT season_star from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "' )) as season_star_rank " +
			
					
			"from reportdata where k_id = '" + HttpUtility.escapeSQL(Input_Id) + "';";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				int k_Number = rs.getInt("k_Number");//会員番号
				String k_Id = rs.getString("k_id");//ID
				String login_Name = rs.getString("login_name");//プレイヤーネーム
				int player_Level = rs.getInt("player_level");//プレイヤーレベル
				String Syougou = rs.getString("syougou");
				String SyougouList_S = rs.getString("syougoulist");
				String S_KakutokubiList_S = rs.getString("s_kakutokubilist");
				
				double reportScore_Ruikei = rs.getDouble("reportscore_ruikei");//レポートスコア累計
				double reportScore_Kongetsu = rs.getDouble("reportscore_kongetsu");//今月の暫定レポートスコア
				double reportScore_Sengetsu = rs.getDouble("reportscore_sengetsu");//先月のレポートスコア
				double reportScore_Nenkan = rs.getDouble("reportscore_nenkan");//今年の暫定レポートスコア
				int report_Count = rs.getInt("report_count");//累計レポート提出数
				double actionScore_Kongetsu = rs.getDouble("actionscore_kongetsu");//今月の暫定アクションスコア
				double actionScore_Sengetsu = rs.getDouble("actionscore_sengetsu");//先月のアクションスコア
				double actionScore_Nenkan = rs.getDouble("actionscore_nenkan");//今年の暫定アクションスコア
				double actionScore_Ruikei = rs.getDouble("actionscore_ruikei");//アクションスコア累計
				
				int reportScore_Ruikei_Rank = rs.getInt("repsc_ruikei_rank");
				int reportScore_Kongetsu_Rank = rs.getInt("repsc_kongetsu_rank");
				int reportScore_Sengetsu_Rank = rs.getInt("repsc_sengetsu_rank");
				int reportScore_Nenkan_Rank = rs.getInt("repsc_nenkan_rank");
				int report_Count_Rank = rs.getInt("rep_count_rank");
				
				int actionScore_Ruikei_Rank = rs.getInt("actsc_ruikei_rank");
				int actionScore_Kongetsu_Rank = rs.getInt("actsc_kongetsu_rank");
				int actionScore_Sengetsu_Rank = rs.getInt("actsc_sengetsu_rank");
				int actionScore_Nenkan_Rank = rs.getInt("actsc_nenkan_rank");
				
				int Star_Count = rs.getInt("star_count");
				int Star_Count_Rank = rs.getInt("star_count_rank");
				int Season_Star = rs.getInt("season_star");
				int Season_Star_Rank = rs.getInt("season_star_rank");
				
				String SeinenGappi = rs.getString("seinengappi");
				String Sex = rs.getString("sex");
				String Pref = rs.getString("pref");
				double Mailage = rs.getDouble("mailage");
				String Job = rs.getString("job");
				
				if(SyougouList_S != null && (!(SyougouList_S.equals(""))) && (!(SyougouList_S.equals("plus;")))){
					if(SyougouList_S.substring(SyougouList_S.length() - 5, SyougouList_S.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
						SyougouList_S = SyougouList_S.substring(0, SyougouList_S.length() - 5);
					}
					SyougouList = SyougouList_S.split("plus;");
					if(S_KakutokubiList_S.substring(S_KakutokubiList_S.length() - 5, S_KakutokubiList_S.length()).equals("plus;")){//最後が「plus;」で終わっている場合は
						S_KakutokubiList_S = S_KakutokubiList_S.substring(0, S_KakutokubiList_S.length() - 5);
					}
					S_KakutokubiList = S_KakutokubiList_S.split("plus;");
				}
				
				boolean Lv_Up_Flg = false;//レベルアップしたことを表すフラグ
				
				Status = new R_jyouhou_TO(k_Number, k_Id, login_Name, SeinenGappi, Sex, Pref, Mailage, reportScore_Ruikei, reportScore_Kongetsu, reportScore_Sengetsu, reportScore_Nenkan, player_Level, report_Count, actionScore_Kongetsu, actionScore_Sengetsu, actionScore_Nenkan, actionScore_Ruikei, Lv_Up_Flg,
						reportScore_Ruikei_Rank, reportScore_Kongetsu_Rank, reportScore_Sengetsu_Rank, reportScore_Nenkan_Rank, report_Count_Rank, actionScore_Ruikei_Rank, actionScore_Kongetsu_Rank, actionScore_Sengetsu_Rank, actionScore_Nenkan_Rank, Star_Count, Star_Count_Rank, Season_Star, Season_Star_Rank, Job, Syougou, SyougouList, S_KakutokubiList);
			}
			return Status;

		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}
	
	public boolean Coupon_Tekiyou(R_jyouhou_TO PlayerData, Coupon_Data_TO CouponData, String Now){
		Connection con = null;
		boolean TourokuError = false;
		try{

			con = createConnection();
			String sql = "SELECT k_id, reportscore_ruikei, reportscore_kongetsu, reportscore_nenkan, actionscore_ruikei, actionscore_kongetsu, actionscore_nenkan, star_count, season_star, syougoulist, s_kakutokubilist FROM reportdata WHERE k_id = '" + HttpUtility.escapeSQL(PlayerData.getk_Id()) + "';";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				String k_id = rs.getString("k_id");//ID
				double ReportScore_Ruikei = rs.getDouble("reportscore_ruikei");//レポートスコア累計
				double ReportScore_Kongetsu = rs.getDouble("reportscore_kongetsu");//今月の暫定レポートスコア
				double ReportScore_Nenkan = rs.getDouble("reportscore_nenkan");//今年の暫定レポートスコア
				double ActionScore_Ruikei = rs.getDouble("actionscore_ruikei");//アクションスコア累計
				double ActionScore_Kongetsu = rs.getDouble("actionscore_kongetsu");//今月の暫定アクションスコア
				double ActionScore_Nenkan = rs.getDouble("actionscore_nenkan");//今年の暫定アクションスコア
				int Star_Count = rs.getInt("star_count");
				int Season_Star = rs.getInt("season_star");
				String SyougouList_S = rs.getString("syougoulist");
				String S_KakutokubiList = rs.getString("s_kakutokubilist");
				
				String SyougouList_Add = "";
				String S_KakutokubiList_Add = "";
				if(CouponData.getSyougou_List() != null && CouponData.getSyougou_List().length > 0 && (!(CouponData.getSyougou_List()[0].equals("今回称号の獲得はありません")))){
				for(int i=0; i < CouponData.getSyougou_List().length; i++){
					SyougouList_Add = SyougouList_Add + CouponData.getSyougou_List()[i] + "plus;";
					S_KakutokubiList_Add = S_KakutokubiList_Add + Now + "plus;";
				}
				}
				String NewSyougouList = "";
				String NewS_KakutokubiList = "";
				if(SyougouList_S == null || S_KakutokubiList == null){
					NewSyougouList = SyougouList_Add;
					NewS_KakutokubiList = S_KakutokubiList_Add;
				}else{
					NewSyougouList = SyougouList_S + SyougouList_Add;
					NewS_KakutokubiList = S_KakutokubiList + S_KakutokubiList_Add;
				}
			
			String sql2 = "UPDATE reportdata SET reportscore_ruikei = ?, reportscore_kongetsu = ?, reportscore_nenkan = ?, actionscore_ruikei = ?, actionscore_kongetsu = ?, actionscore_nenkan = ?, star_count = ?, season_star = ?, syougoulist = ?, s_kakutokubilist = ? WHERE k_id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql2);
			
			pstmt.setDouble(1, ReportScore_Ruikei + CouponData.getRepscore_Bonus());
			pstmt.setDouble(2, ReportScore_Kongetsu + CouponData.getRepscore_Bonus());
			pstmt.setDouble(3, ReportScore_Nenkan + CouponData.getRepscore_Bonus());
			pstmt.setDouble(4, ActionScore_Ruikei + CouponData.getActscore_Bonus());
			pstmt.setDouble(5, ActionScore_Kongetsu + CouponData.getActscore_Bonus());
			pstmt.setDouble(6, ActionScore_Nenkan + CouponData.getActscore_Bonus());
			pstmt.setInt(7, Star_Count + CouponData.getStar_Bonus());
			pstmt.setInt(8, Season_Star + CouponData.getStar_Bonus());
			pstmt.setString(9, NewSyougouList);
			pstmt.setString(10, NewS_KakutokubiList);
			pstmt.setString(11, k_id);
			pstmt.executeUpdate();
			}
			}catch(SQLException e){
				e.printStackTrace();
				TourokuError = true;
			}finally{
				closeConnection(con);
			}
			return TourokuError;
		}
	
	public boolean Syougou_Koushin(String K_ID, String NewSyougou){
		Connection con = null;
		boolean TourokuError = false;
		try{

			con = createConnection();
			String sql = "UPDATE reportdata SET syougou = ? WHERE k_id = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, NewSyougou);
			pstmt.setString(2, K_ID);
			pstmt.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			TourokuError = true;
		}finally{
			closeConnection(con);
		}
		return TourokuError;
	}
}
