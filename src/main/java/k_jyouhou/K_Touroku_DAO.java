package k_jyouhou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
/*import java.sql.PreparedStatement;*/

import inputUtility.HttpUtility;

public class K_Touroku_DAO {

	//private final static String resourceName = "jdbc/r_data";
	private final static String resourceName2 = "jdbc/n_data";
	private final static String resourceName3 = "jdbc/authorization";

	/*private Connection createConnection(){
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
	}*/

	private Connection createConnection2(){
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

	private Connection createConnection3(){
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

	protected void closeConnection(Connection con ){
		try{
			con.close();
		}catch(Exception ex ){}

	}

	/*public boolean Karitouroku(K_Touroku_TO UpData){//使われていないようなのでコメントアウト
		Connection con = null;
		boolean tourokuerror = false;
		try{
			con = createConnection();

			String sql = "INSERT INTO authorization.users VALUES(?,?,?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, UpData.getKibou_Id());
			stmt.setString(2, UpData.getLogin_Name());
			stmt.setString(3, UpData.getKibou_Password());

			sql = "INSERT INTO authorization.roles VALUES(?,?,?)";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, UpData.getKibou_Id());
			stmt.setString(2, UpData.getLogin_Name());
			stmt.setString(3, "shinki");

			stmt.executeUpdate();



		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}*/


	public K_Touroku_TO Kari_Load(String Id){//Kaiin_Touroku_Kakunin_p0.javaで発行され、メールで通知した仮ID、メールアドレスをDBから抽出
		Connection con = null;
		K_Touroku_TO Mail_Address = null;

		try{
			con = createConnection3();

			String sql = "SELECT id, mailaddress FROM users WHERE id = '"+ HttpUtility.escapeSQL(Id) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				String KariId = rs.getString("id");
				String Mailaddress = rs.getString("mailaddress");
				Mail_Address = new K_Touroku_TO(KariId, Mailaddress);
			}
			return Mail_Address;

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}

	public boolean K_Touroku(K_Touroku_TO NyukaiData){//プレイヤー情報の本登録
		Connection con = null;
		Connection con2 = null;
		boolean tourokuerror = false;
		PreparedStatement pstmt = null;
		try{
			con = createConnection3();

			String sql = "UPDATE roles SET id = ?," +
			"username = ?, role = 'General_User' WHERE id = ? ;";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, NyukaiData.getKibou_Id());
		pstmt.setString(2, NyukaiData.getLogin_Name());
		pstmt.setString(3, NyukaiData.getOldId());
		pstmt.executeUpdate();

		sql = "UPDATE users SET id = ?, username = ?," +
		"password = ? WHERE id = ?;";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, NyukaiData.getKibou_Id());
		pstmt.setString(2, NyukaiData.getLogin_Name());
		pstmt.setString(3, NyukaiData.getKibou_Password());
		pstmt.setString(4, NyukaiData.getOldId());
		pstmt.executeUpdate();
		//closeConnection(con);

		con2 = createConnection2();
		sql = "INSERT INTO kojindata (k_id, sei_kanji, mei_kanji, sei_kana, mei_kana, birthday, sex, address_no, pref, jyusyo, denwabangou, mailaddress, keitaiaddress, seclet_question, seclet_answer, job) " +
		"VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?);";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, NyukaiData.getKibou_Id());
		pstmt.setString(2, NyukaiData.getSei_Kanji());
		pstmt.setString(3, NyukaiData.getMei_Kanji());
		pstmt.setString(4, NyukaiData.getSei_Kana());
		pstmt.setString(5, NyukaiData.getMei_Kana());
		pstmt.setString(6, NyukaiData.getBirthYear() + "-" + NyukaiData.getBirthTsuki() + "-" + NyukaiData.getBirthDay());
		pstmt.setString(7, NyukaiData.getSex());
		pstmt.setString(8, NyukaiData.getAddressNo());
		pstmt.setString(9, NyukaiData.getPref());
		pstmt.setString(10, NyukaiData.getJyusyo());
		pstmt.setString(11, NyukaiData.getTelephone_No());
		pstmt.setString(12, NyukaiData.getMail_Address());
		pstmt.setString(13, NyukaiData.getKeitai_Address());
		pstmt.setString(14, NyukaiData.getSecret_Question());
		pstmt.setString(15, NyukaiData.getSecret_Answer());
		pstmt.setString(16, NyukaiData.getJob());
		pstmt.executeUpdate();

		sql = "INSERT INTO reportdata (k_id, login_name, player_level, reportscore_ruikei, reportscore_kongetsu, reportscore_sengetsu, reportscore_nenkan," +
				" actionscore_ruikei, actionscore_kongetsu, actionscore_sengetsu, actionscore_nenkan, report_count, seinengappi, sex, pref, mailage)" +
				" VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?);";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, NyukaiData.getKibou_Id());
		pstmt.setString(2, NyukaiData.getLogin_Name());
		pstmt.setInt(3, 0);
		pstmt.setDouble(4, 0);
		pstmt.setDouble(5, 0);
		pstmt.setDouble(6, 0);
		pstmt.setDouble(7, 0);
		pstmt.setDouble(8, 0);
		pstmt.setDouble(9, 0);
		pstmt.setDouble(10, 0);
		pstmt.setDouble(11, 0);
		pstmt.setInt(12, 0);
		pstmt.setString(13, NyukaiData.getBirthYear() + "-" + NyukaiData.getBirthTsuki() + "-" + NyukaiData.getBirthDay());
		pstmt.setString(14, NyukaiData.getSex());
		pstmt.setString(15, NyukaiData.getPref());
		pstmt.setDouble(16, 0);
		pstmt.executeUpdate();

		sql = "INSERT INTO ninsyoudata (k_id, password, login_name, mailaddress, keitaiaddress) VALUES (?,?,?,?,?);";
		pstmt = con.prepareStatement(sql);

		pstmt.setString(1, NyukaiData.getKibou_Id());
		pstmt.setString(2, NyukaiData.getKibou_Password());
		pstmt.setString(3, NyukaiData.getLogin_Name());
		pstmt.setString(4, NyukaiData.getMail_Address());
		pstmt.setString(5, NyukaiData.getMail_Address());
		pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
			closeConnection(con2);
		}
		return tourokuerror;
	}


}
