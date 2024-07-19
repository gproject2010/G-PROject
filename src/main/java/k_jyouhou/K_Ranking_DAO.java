package k_jyouhou;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class K_Ranking_DAO {//会員に関するランキングの検索

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

	public ArrayList<K_Ranking_TO> All_Rank (String hani, int Pagest, int Pagefin){
		
		ArrayList<K_Ranking_TO> list = new ArrayList<K_Ranking_TO>();
		
		
		K_Ranking_TO result = null;
		Connection con = null;
		try{
			int HitCount = 0;
			
			con = createConnection();
			
			if(hani.equals("kongetsu")){//今月の月間レポートスコアランキング
				String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, reportscore_kongetsu from reportdata order by reportscore_kongetsu desc LIMIT " + Pagest + " , " + Pagefin + " ;";
				
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int Rank = Pagest + 1;
				
				String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
	            Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				if(rs2.next()){
				HitCount = rs2.getInt("hitcount");
				}
				
				while(rs.next()){
					int k_Number = rs.getInt("k_number");//会員番号
					int player_Level = rs.getInt("player_level");//プレイヤーレベル
					String login_Name = rs.getString("login_name");//プレイヤー名
					double reportScore_Kongetsu = rs.getDouble("reportscore_kongetsu");//今月のレポートスコア
					
					result = new K_Ranking_TO(k_Number, player_Level, login_Name, reportScore_Kongetsu, Rank, HitCount);
					
					list.add(result);
					Rank++;
					
				}
			}
			else if(hani.equals("sengetsu")){//先月の月間レポートスコアランキング
				String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, reportscore_sengetsu from reportdata order by reportscore_sengetsu desc LIMIT " + Pagest + " , " + Pagefin + " ;";	
			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int Rank = Pagest + 1;
				
				String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
	            Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				if(rs2.next()){
				HitCount = rs2.getInt("hitcount");
				}
				
				while(rs.next()){
					int k_Number = rs.getInt("k_number");
					int player_Level = rs.getInt("player_level");
					String login_Name = rs.getString("login_name");
					double reportScore_Sengetsu = rs.getDouble("reportscore_sengetsu");//先月の月間レポートスコア
					
					result = new K_Ranking_TO(k_Number, player_Level, login_Name, reportScore_Sengetsu, Rank, HitCount);
					
					list.add(result);
					Rank++;
					
				}
			}
			else if(hani.equals("nenkan")){//年間レポートスコアランキング
				String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, reportscore_nenkan from reportdata order by reportscore_nenkan desc LIMIT " + Pagest + " , " + Pagefin + " ;";	
			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int Rank = Pagest + 1;
				
				String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
	            Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				if(rs2.next()){
				HitCount = rs2.getInt("hitcount");
				}
				
				while(rs.next()){
					int k_Number = rs.getInt("k_number");
					int player_Level = rs.getInt("player_level");
					String login_Name = rs.getString("login_name");
					double reportScore_Nenkan = rs.getDouble("reportscore_nenkan");//今年の年間レポートスコア
					
					result = new K_Ranking_TO(k_Number, player_Level, login_Name, reportScore_Nenkan, Rank, HitCount);
					
					list.add(result);
					Rank++;
					
				}
			}
			else if(hani.equals("ruikei")){//累計のレポートスコアランキング
				String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, reportscore_ruikei from reportdata order by reportscore_ruikei desc LIMIT " + Pagest + " , " + Pagefin + " ;";	
			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int Rank = Pagest + 1;
				
				String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
	            Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				if(rs2.next()){
				HitCount = rs2.getInt("hitcount");
				}
				
				while(rs.next()){
					int k_Number = rs.getInt("k_number");
					int player_Level = rs.getInt("player_level");
					String login_Name = rs.getString("login_name");
					double reportScore_Ruikei = rs.getDouble("reportscore_ruikei");//累計レポートスコア
					
					result = new K_Ranking_TO(k_Number, player_Level, login_Name, reportScore_Ruikei, Rank, HitCount);
					
					list.add(result);
					Rank++;
					
				}
			}
			
			else if(hani.equals("r_count")){//レポート提出数ランキング
				String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, report_count from reportdata order by report_count desc LIMIT " + Pagest + " , " + Pagefin + " ;";
			
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				int Rank = Pagest + 1;
				
				String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
	            Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				if(rs2.next()){
				HitCount = rs2.getInt("hitcount");
				}
				
				while(rs.next()){
					int k_Number = rs.getInt("k_number");
					int player_Level = rs.getInt("player_level");
					String login_Name = rs.getString("login_name");
					int report_Count = rs.getInt("report_count");//レポート提出数累計
					
					result = new K_Ranking_TO(k_Number, player_Level, login_Name, report_Count, Rank, HitCount);
					
					list.add(result);
					Rank++;
					
				}
				
			}
				if(hani.equals("act_kongetsu")){//今月の月間レポートスコアランキング
					String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, actionscore_kongetsu from reportdata order by actionscore_kongetsu desc LIMIT " + Pagest + " , " + Pagefin + " ;";
					
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					int Rank = Pagest + 1;
					
					String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
		            Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					if(rs2.next()){
					HitCount = rs2.getInt("hitcount");
					}
					
					while(rs.next()){
						int k_Number = rs.getInt("k_number");//会員番号
						int player_Level = rs.getInt("player_level");//プレイヤーレベル
						String login_Name = rs.getString("login_name");//プレイヤー名
						double ActionScore_Kongetsu = rs.getDouble("actionscore_kongetsu");//今月のレポートスコア
						
						result = new K_Ranking_TO(k_Number, player_Level, login_Name, ActionScore_Kongetsu, Rank, HitCount);
						
						list.add(result);
						Rank++;
						
					}
				}
				else if(hani.equals("act_sengetsu")){//先月の月間レポートスコアランキング
					String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, actionscore_sengetsu from reportdata order by actionscore_sengetsu desc LIMIT " + Pagest + " , " + Pagefin + " ;";	
				
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					int Rank = Pagest + 1;
					
					String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
		            Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					if(rs2.next()){
					HitCount = rs2.getInt("hitcount");
					}
					
					while(rs.next()){
						int k_Number = rs.getInt("k_number");
						int player_Level = rs.getInt("player_level");
						String login_Name = rs.getString("login_name");
						double ActionScore_Sengetsu = rs.getDouble("actionscore_sengetsu");//先月の月間レポートスコア
						
						result = new K_Ranking_TO(k_Number, player_Level, login_Name, ActionScore_Sengetsu, Rank, HitCount);
						
						list.add(result);
						Rank++;
						
					}
				}
				else if(hani.equals("act_nenkan")){//年間レポートスコアランキング
					String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, actionscore_nenkan from reportdata order by actionscore_nenkan desc LIMIT " + Pagest + " , " + Pagefin + " ;";	
				
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					int Rank = Pagest + 1;
					
					String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
		            Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					if(rs2.next()){
					HitCount = rs2.getInt("hitcount");
					}
					
					while(rs.next()){
						int k_Number = rs.getInt("k_number");
						int player_Level = rs.getInt("player_level");
						String login_Name = rs.getString("login_name");
						double ActionScore_Nenkan = rs.getDouble("actionscore_nenkan");//今年の年間レポートスコア
						
						result = new K_Ranking_TO(k_Number, player_Level, login_Name, ActionScore_Nenkan, Rank, HitCount);
						
						list.add(result);
						Rank++;
						
					}
				}
				else if(hani.equals("act_ruikei")){//累計のレポートスコアランキング
					String sql = "select SQL_CALC_FOUND_ROWS k_number, player_level, login_name, actionscore_ruikei from reportdata order by actionscore_ruikei desc LIMIT " + Pagest + " , " + Pagefin + " ;";	
				
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(sql);
					int Rank = Pagest + 1;
					
					String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
		            Statement stmt2 = con.createStatement();
					ResultSet rs2 = stmt2.executeQuery(sql2);
					if(rs2.next()){
					HitCount = rs2.getInt("hitcount");
					}
					
					while(rs.next()){
						int k_Number = rs.getInt("k_number");
						int player_Level = rs.getInt("player_level");
						String login_Name = rs.getString("login_name");
						double ActionScore_Ruikei = rs.getDouble("actionscore_ruikei");//累計レポートスコア
						
						result = new K_Ranking_TO(k_Number, player_Level, login_Name, ActionScore_Ruikei, Rank, HitCount);
						
						list.add(result);
						Rank++;
					}
					}
			
			return list;
					
			}catch(SQLException e ){
				e.printStackTrace();
				return null;

			}finally{
				closeConnection(con);
			}
	}
}