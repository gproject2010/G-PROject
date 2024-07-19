package inputUtility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CodeMaker {
private final static String resourceName = "jdbc/g_data";//レポート対象のゲームのデータのDB
	
	private static Connection createConnection(){//ゲームデータへの接続メソッド
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
	
private final static String resourceName2 = "jdbc/r_data";//レポート対象のゲームのデータのDB
	
	private static Connection createConnection2(){//ゲームデータへの接続メソッド
		try{
			
			InitialContext ic = new InitialContext();

			DataSource ds = (DataSource)ic.lookup("java:comp/env/"+resourceName2);

			Connection con = ds.getConnection();
			return con;
		}catch(SQLException ex ){
			ex.printStackTrace();
		}catch(NamingException ex ){
			ex.printStackTrace();
		}
		return null;
	}
	
private final static String resourceName3 = "jdbc/gpro_ron";//レポート対象のゲームのデータのDB
	
	private static Connection createConnection3(){//ゲームデータへの接続メソッド
		try{
			
			InitialContext ic = new InitialContext();

			DataSource ds = (DataSource)ic.lookup("java:comp/env/"+resourceName3);

			Connection con = ds.getConnection();
			return con;
		}catch(SQLException ex ){
			ex.printStackTrace();
		}catch(NamingException ex ){
			ex.printStackTrace();
		}
		return null;
	}
	
	protected static void closeConnection(Connection con){
		try{
			con.close();
			}catch(Exception ex){}
	}
	
	public static String GameCodeMaker(String PlatForm, String Hatsubainen){
		
		String GameCode = null;
		String Saikoubi_S = null;
		Connection con = null;
		String sql = null;
		
		try{
			con = createConnection();
			sql = "SELECT COUNT(gamecode) AS saikoubi FROM gamedata WHERE platform = '" + PlatForm + "' AND hatsubainengappi BETWEEN '" + Hatsubainen + "-01-01' AND '" + Hatsubainen + "-12-31';";
			//すでに登録されているゲームコードの行列の最後尾の位置を抽出
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			String PlatForm_Ryaku = null;
			if(rs.next()){
				int Saikoubi = rs.getInt("saikoubi");
			Saikoubi_S = Integer.toString(Saikoubi);//文字列型に変換
			if(PlatForm.equals("ファミリーコンピュータ")){//プラットフォームを略称に変換(コード用)
				PlatForm_Ryaku = "FC";
			}else if(PlatForm.equals("スーパーファミコン")){
				PlatForm_Ryaku = "SFC";
			}else if(PlatForm.equals("バーチャルボーイ")){
				PlatForm_Ryaku = "VB";
			}else if(PlatForm.equals("ゲームボーイ")){
				PlatForm_Ryaku = "GB";
			}else if(PlatForm.equals("ゲームボーイアドバンス")){
					PlatForm_Ryaku = "GBA";
			}else if(PlatForm.equals("ニンテンドウ64")){
				PlatForm_Ryaku = "N64";
			}else if(PlatForm.equals("ニンテンドーゲームキューブ")){
				PlatForm_Ryaku = "GC";
			}else if(PlatForm.equals("Wii")){
				PlatForm_Ryaku = "Wii";
			}else if(PlatForm.equals("Wii_U")){
				PlatForm_Ryaku = "WIIU";
			}else if(PlatForm.equals("ニンテンドーDS")){
				PlatForm_Ryaku = "DS";
			}else if(PlatForm.equals("ニンテンドー3DS")){
				PlatForm_Ryaku = "3DS";
			}else if(PlatForm.equals("PS_Vita")){
				PlatForm_Ryaku = "PS_Vita";
			}else if(PlatForm.equals("セガサターン")){
				PlatForm_Ryaku = "SS";
			}else if(PlatForm.equals("ドリームキャスト")){
				PlatForm_Ryaku = "DC";
			}else if(PlatForm.equals("プレイステーション")){
				PlatForm_Ryaku = "PS";
			}else if(PlatForm.equals("プレイステーション2")){
				PlatForm_Ryaku = "PS2";
			}else if(PlatForm.equals("プレイステーション3")){
				PlatForm_Ryaku = "PS3";
			}else if(PlatForm.equals("プレイステーション4")){
				PlatForm_Ryaku = "PS4";
			}else if(PlatForm.equals("PSP")){
				PlatForm_Ryaku = "PSP";
			}else if(PlatForm.equals("Xbox")){
				PlatForm_Ryaku = "Xbox";
			}else if(PlatForm.equals("Xbox360")){
				PlatForm_Ryaku = "Xbox360";
			}else if(PlatForm.equals("Xbox_one")){
				PlatForm_Ryaku = "Xbox_one";
			}else if(PlatForm.equals("メガドライブ")){
				PlatForm_Ryaku = "MD";
			}else if(PlatForm.equals("ゲームギア")){
				PlatForm_Ryaku = "GG";
			}else if(PlatForm.equals("PC-FX")){
				PlatForm_Ryaku = "PCFX";
			}else if(PlatForm.equals("ネオジオ")){
				PlatForm_Ryaku = "NG";
			}else if(PlatForm.equals("ネオジオポケット")){
				PlatForm_Ryaku = "NGP";
			}else if(PlatForm.equals("3DO")){
				PlatForm_Ryaku = "3DO";
			}else if(PlatForm.equals("ワンダースワン")){
				PlatForm_Ryaku = "WS";
			}else if(PlatForm.equals("アーケードゲーム")){
				PlatForm_Ryaku = "AC";
			}else{
				PlatForm_Ryaku = "ETC";
			}
			GameCode = PlatForm_Ryaku + Hatsubainen + Saikoubi_S;//[プラットフォーム(略称)][発売年][通し番号]
			}
			return GameCode;//完成したゲームコードを返す
		}catch(SQLException e){

			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public static String Rep_Code_Maker(String Rep_Syubetsu, Calendar Uploaddate){
		String TableName = null;
		int Saikoubi = 0;
		String Saikoubi_S = null;
		Connection con = null;
		String sql = null;
		String Rep_Code = null;
		
		if(Rep_Syubetsu.equals("ox")){
			TableName = "oxdata";
		}else if(Rep_Syubetsu.equals("oxshinki")){
			TableName = "oxshinkidata";
		}else if(Rep_Syubetsu.equals("kiji")){
			TableName = "kijidata";
		}else if(Rep_Syubetsu.equals("kijishinki")){
			TableName = "kijishinkidata";
		}else if(Rep_Syubetsu.equals("free")){
			TableName = "freedata";
		}else if(Rep_Syubetsu.equals("freeshinki")){
			TableName = "freeshinkidata";
		}else if(Rep_Syubetsu.equals("prop")){
			TableName = "propdata";
		}else if(Rep_Syubetsu.equals("word")){
			TableName = "wordrepdata";
		}else if(Rep_Syubetsu.equals("propresp")){
			TableName = "proprespdata";
		}
		
		try{
			con = createConnection2();
			sql = "SELECT COUNT(rep_code) AS saikoubi FROM " + HttpUtility.escapeSQL(TableName) + " WHERE uploadtime BETWEEN '" + Uploaddate.get(Calendar.YEAR) + "-01-01' AND '" + Uploaddate.get(Calendar.YEAR) + "-12-31';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//すでに登録されているゲームコードの行列の最後尾の位置を抽出
			if(rs.next()){
				Saikoubi = rs.getInt("saikoubi");
			}
			Saikoubi_S = Integer.toString(Saikoubi);
			Rep_Code = Rep_Syubetsu + " - " + Uploaddate.get(Calendar.YEAR) + " - " + Saikoubi_S;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return Rep_Code;
}
	
	public static String Riron_Code_Maker(String Rep_Syubetsu, Calendar Uploaddate){
		String TableName = null;
		int Saikoubi = 0;
		String Saikoubi_S = null;
		Connection con = null;
		String sql = null;
		String Rep_Code = null;
		
		if(Rep_Syubetsu.equals("gpriron")){
			TableName = "rirondata";
		}else if(Rep_Syubetsu.equals("rironresp")){
			TableName = "riron_comment";
		}
		
		try{
			con = createConnection3();
			sql = "SELECT COUNT(ronbuncode) AS saikoubi FROM " + HttpUtility.escapeSQL(TableName) + " WHERE uploaddate BETWEEN '" + Uploaddate.get(Calendar.YEAR) + "-01-01' AND '" + Uploaddate.get(Calendar.YEAR) + "-12-31';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			//すでに登録されているゲームコードの行列の最後尾の位置を抽出
			if(rs.next()){
				Saikoubi = rs.getInt("saikoubi");
			}
			Saikoubi_S = Integer.toString(Saikoubi);
			Rep_Code = Rep_Syubetsu + " - " + Uploaddate.get(Calendar.YEAR) + " - " + Saikoubi_S;
			
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return Rep_Code;
	}
}
