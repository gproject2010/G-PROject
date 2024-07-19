package g_jyouhou;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class GR_jyouhou_DAO {

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

	public ArrayList<GR_jyouhou_TO> GameRankAll(String hani, int Pagest, int Pagefin){

		ArrayList<GR_jyouhou_TO> list = new ArrayList<GR_jyouhou_TO>();
		int HitCount = 0;
		Connection con = null;
		try{
			con = createConnection();

			if(hani.equals("meisaku")){//名作ランキングデータの作成処理
			String sql = "select SQL_CALC_FOUND_ROWS gamecode, platform, makername, gamename, main_genre, g_score from g_data.gamedata ORDER BY g_score DESC LIMIT " + Pagest + " , " + Pagefin + " ;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			int Rank = Pagest + 1;//順位(一番上に表示されているものが基準)

			 String sql2 = "SELECT FOUND_ROWS() AS hitcount;";
	            Statement stmt2 = con.createStatement();
				ResultSet rs2 = stmt2.executeQuery(sql2);
				if(rs2.next()){
				HitCount = rs2.getInt("hitcount");
				}
			
			while(rs.next()){
				String Platform = rs.getString("platform");//プラットフォーム
				String Makername = rs.getString("makername");//発売元メーカー名称
				String Gamecode = rs.getString("gamecode");//ゲームコード
				String Gamename = rs.getString("gamename");//ゲームタイトル
				String Main_Genre = rs.getString("main_genre");//メインジャンル
				double G_score = rs.getDouble("g_score");//累計G-Score
				GR_jyouhou_TO G_data = new GR_jyouhou_TO(Platform,  Makername, Gamecode, Gamename, Main_Genre, G_score, Rank, HitCount);

				list.add(G_data);
				Rank++;
			}
			}
			else if(hani.equals("dai1_insyou")){//第一印象ランキングデータの作成処理
				String sql = "select SQL_CALC_FOUND_ROWS gamecode, platform, makername, gamename, main_genre, dai1_insyou from g_data.gamedata order by dai1_insyou DESC LIMIT " + Pagest + " , " + Pagefin + " ;";
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
					String Platform = rs.getString("platform");
					String Makername = rs.getString("makername");
					String Gamecode = rs.getString("gamecode");
					String Gamename = rs.getString("gamename");
					String Main_Genre = rs.getString("main_genre");
					double Dai1_Insyou = rs.getDouble("dai1_insyou");//発売1ヶ月で獲得したG-Score
					GR_jyouhou_TO G_data = new GR_jyouhou_TO(Platform, Makername, Gamecode, Gamename, Main_Genre, Dai1_Insyou, Rank, HitCount);

					list.add(G_data);
					Rank++;
				}
			}
			else if(hani.equals("nenkan")){//ビッグヒットランキングデータの作成処理
				String sql = "select SQL_CALC_FOUND_ROWS gamecode, platform, makername, gamename, main_genre, nenkan from g_data.gamedata order by nenkan DESC LIMIT " + Pagest + " , " + Pagefin + " ;";
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
					String Platform = rs.getString("platform");
					String Makername = rs.getString("makername");
					String Gamecode = rs.getString("gamecode");
					String Gamename = rs.getString("gamename");
					String Main_Genre = rs.getString("main_genre");
					double nenkan = rs.getDouble("nenkan");//発売1年で獲得したG-Score
					GR_jyouhou_TO G_data = new GR_jyouhou_TO(Platform, Makername, Gamecode, Gamename, Main_Genre, nenkan, Rank, HitCount);

					list.add(G_data);
					Rank++;
				}
			}
			else if(hani.equals("ninkisaku")){//人気作ランキングデータの作成処理
			String sql = "select SQL_CALC_FOUND_ROWS gamecode, platform, makername, gamename, main_genre, report_count from g_data.gamedata order by report_count DESC LIMIT " + Pagest + " , " + Pagefin + " ;";
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
				String PlatForm = rs.getString("platform");
				String MakerName = rs.getString("makername");
				String GameCode = rs.getString("gamecode");
				String GameName = rs.getString("gamename");
				String Main_Genre = rs.getString("main_genre");
				int Report_Count = rs.getInt("report_count");//今までにそのゲームに対して提出されたレポートの件数
				GR_jyouhou_TO G_data = new GR_jyouhou_TO(PlatForm,  MakerName, GameCode, GameName, Main_Genre, Report_Count, Rank, HitCount);

				list.add(G_data);
				Rank++;
			}
			}else{
				return null;
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