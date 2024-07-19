package k_jyouhou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import inputUtility.HttpUtility;
import ninsyou.N_jyouhou_TO;

public class K_jyouhou_DAO {

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

	private final static String resourceName2 = "jdbc/authorization";

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

	protected void closeConnection(Connection con ){
		try{
			con.close();
		}catch(Exception ex ){}

	}
	public K_jyouhou_TO findkaiin_NById(String k_id){//プレイヤー情報の検索用DAO
		K_jyouhou_TO K_Data = null;
		Connection con = null;
		try{

			con = createConnection();

			String sql = "select k_number, k_id, sei_kanji, mei_kanji, sei_kana, mei_kana, birthday, address_no, pref, jyusyo, denwabangou, mailaddress, keitaiaddress, " +
					"seclet_question, seclet_answer, job, sex from kojindata " + "where k_id = '" + HttpUtility.escapeSQL(k_id) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				int k_number = rs.getInt("k_number");//会員番号
				String k_Id = rs.getString("k_id");//会員ID

				String sei_kanji = rs.getString("sei_kanji");//姓(漢字)
				String mei_kanji = rs.getString("mei_kanji");//名(漢字)
				String sei_kana = rs.getString("sei_kana");//姓(カタカナ)
				String mei_kana = rs.getString("mei_kana");//名(カタカナ)
				String birthday = rs.getString("birthday");//生年月日

				String yubin_bangou = rs.getString("address_no");//住所の郵便番号
				String pref = rs.getString("pref");//住所の都道府県
				String jyusyo = rs.getString("jyusyo");//区市町村名以下の住所

				String denwabangou = rs.getString("denwabangou");//連絡先電話番号
				String mailaddress = rs.getString("mailaddress");//連絡用メールアドレス
				String keitaiaddress = rs.getString("keitaiaddress");//携帯メールアドレス(任意のためnullも許可)

				String secret_question = rs.getString("seclet_question");//秘密の質問
				String secret_answer = rs.getString("seclet_answer");//秘密の質問の答え

				String Job = rs.getString("job");
				String Sex = rs.getString("sex");

				K_Data = new K_jyouhou_TO(k_number, k_Id, sei_kanji, mei_kanji, sei_kana, mei_kana, birthday, yubin_bangou, pref, jyusyo, denwabangou,
						mailaddress, keitaiaddress, secret_question, secret_answer, Job, Sex);
			}
			return K_Data;

		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}
	public K_Touroku_TO JyufukuKakunin(String Login_Name, String Kibou_Id, String Mail_Address, String KeitaiAddress){
		K_Touroku_TO SyougouData = null;//認証情報を変更登録する場合の重複チェック用DAO
		Connection con = null;
		try{

			con = createConnection();

			String sql = "SELECT login_name, k_id, mailaddress, keitaiaddress, (SELECT COUNT(login_name) FROM n_data.ninsyoudata WHERE EXISTS ( SELECT login_name FROM n_data.ninsyoudata WHERE login_name = '" + HttpUtility.escapeSQL(Login_Name) + "' )) AS name_jyufuku, " +
					"(SELECT COUNT(k_id) FROM ninsyoudata WHERE EXISTS ( SELECT k_id FROM n_data.ninsyoudata WHERE k_id = '" + HttpUtility.escapeSQL(Kibou_Id) + "' )) AS id_jyufuku, (SELECT COUNT(mailaddress) FROM n_data.ninsyoudata WHERE EXISTS ( SELECT mailaddress FROM n_data.ninsyoudata WHERE mailaddress = '" + HttpUtility.escapeSQL(Mail_Address) + "' )) AS mail_jyufuku, " +
					"(SELECT COUNT(keitaiaddress) FROM ninsyoudata WHERE EXISTS ( SELECT keitaiaddress FROM n_data.ninsyoudata WHERE keitaiaddress = '" + HttpUtility.escapeSQL(KeitaiAddress) + "' AND keitaiaddress != null)) AS keitai_jyufuku FROM n_data.ninsyoudata;";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				int Login_name_res = rs.getInt("name_jyufuku");//プレイヤーネームの重複
				int Id_res = rs.getInt("id_jyufuku");//IDの重複
				int Mail_address_res = rs.getInt("mail_jyufuku");//メールアドレスの重複
				int Keitai_address_res = rs.getInt("keitai_jyufuku");//携帯メールアドレスの重複

				SyougouData = new K_Touroku_TO(Login_name_res, Id_res, Mail_address_res, Keitai_address_res);
			}
			return SyougouData;

		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}

	public K_jyouhou_TO MailCheck_Lv2(String Id){//新規会員登録時のメールアドレスの重複確認
		K_jyouhou_TO Result = null;
		Connection con = null;


		try{

		con = createConnection();

		String sql = "SELECT login_name, mailaddress, keitaiaddress FROM ninsyoudata WHERE k_id = '" + HttpUtility.escapeSQL(Id) + "';";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if(rs.next()){
			String Login_Name = rs.getString("login_name");
			String MailAddress = rs.getString("mailaddress");//PCメールアドレス
			String KeitaiAddress = rs.getString("keitaiaddress");//携帯メールアドレス
			Result = new K_jyouhou_TO(Login_Name, MailAddress, KeitaiAddress);
		}
		return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}

	public K_jyouhou_TO ToNextScore (int player_Level){
		K_jyouhou_TO next_S = new K_jyouhou_TO();
		Connection con = null;
		try{
			con = createConnection();

			String sql = "SELECT nextlevel, nextscore FROM nextscoredata WHERE nextlevel = " + player_Level  + ";";//レベルアップに必要な経験値の問い合わせ処理
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				int nextLevel = rs.getInt("nextlevel");//次に昇格するレベル
				double nextScore = rs.getDouble("nextscore");//次のレベル昇格に必要な経験値
				next_S = new K_jyouhou_TO(nextLevel, nextScore);
			}
			return next_S;

		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}

	public void LevelUpdate (int player_Level, String k_Id){//レベルアップ処理
		Connection con = null;
		PreparedStatement pstmt = null;
		try{
			con = createConnection();

			String sql = "UPDATE reportdata SET player_level = ? WHERE k_id = ? ;";
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, player_Level);
			pstmt.setString(2, HttpUtility.escapeSQL(k_Id));
			pstmt.executeUpdate();//プレイヤーレベルを更新

		}catch(SQLException e ){
			e.printStackTrace();

		}finally{
			closeConnection(con);
		}
	}

	public boolean N_Data_Upload(K_Touroku_TO ChangeData, N_jyouhou_TO baseData){//n_dataデータベースに対する認証情報変更処理
		Connection con = null;
		boolean tourokuerror = false;
		try{
			con = createConnection();

			String sql = "UPDATE ninsyoudata SET k_id = ?, password = ?, login_name = ?, mailaddress = ?, keitaiaddress = ? WHERE k_id = ?;";//ninsyoudataテーブルへの挿入
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getKibou_Id());
			stmt.setString(2, ChangeData.getKibou_Password());
			stmt.setString(3, ChangeData.getLogin_Name());
			stmt.setString(4, ChangeData.getMail_Address());
			stmt.setString(5, ChangeData.getKeitai_Address());
			stmt.setString(6, baseData.getK_Id());
			stmt.executeUpdate();

			sql = "UPDATE reportdata SET k_id = ? WHERE k_id = ?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getKibou_Id());
			stmt.setString(2, baseData.getK_Id());
			stmt.executeUpdate();

			sql = "UPDATE kojindata SET k_id = ?, login_name = ? WHERE k_id = ?:";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getKibou_Id());
			stmt.setString(2, ChangeData.getLogin_Name());
			stmt.setString(3, baseData.getK_Id());
			stmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}

	public boolean P_Data_Upload(K_Touroku_TO ChangeData, K_jyouhou_TO BaseData){
		Connection con = null;
		try{
			con = createConnection();

			String sql = "UPDATE kojindata SET sei_kanji = ?, sei_kana = ?, address_no = ?, pref = ?, jyusyo = ?, denwabangou = ?, seclet_question = ?, seclet_answer = ?, job = ? WHERE k_id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getSei_Kanji());
			stmt.setString(2, ChangeData.getSei_Kana());
			stmt.setString(3, ChangeData.getAddressNo());
			stmt.setString(4, ChangeData.getPref());
			stmt.setString(5, ChangeData.getJyusyo());
			stmt.setString(6, ChangeData.getTelephone_No());
			stmt.setString(7, ChangeData.getSecret_Question());
			stmt.setString(8, ChangeData.getSecret_Answer());
			stmt.setString(9, ChangeData.getJob());
			stmt.setString(10, BaseData.getk_Id());
			stmt.executeUpdate();

			sql = "UPDATE reportdata SET pref = ?, job = ? WHERE k_id = ?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getPref());
			stmt.setString(2, ChangeData.getJob());
			stmt.setString(3, BaseData.getk_Id());
			stmt.executeUpdate();

		}catch(Exception e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
		return false;
	}

	public K_jyouhou_TO Nin_Syougou(String Input_Name, String Input_Mail){//認証情報照会のためのメールアドレス・プレイヤーネームの照合
		Connection con = null;

		try{
			con = createConnection();

			String sql = "SELECT k_id, login_name, mailaddress, birthday, address_no, seclet_question, seclet_answer FROM kojindata WHERE login_name = '" + HttpUtility.escapeSQL(Input_Name) + "' AND mailaddress = '" + HttpUtility.escapeSQL(Input_Mail) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			K_jyouhou_TO SyougouData = null;

			if(rs.next()){
				String Id = rs.getString("k_id");
				String Name = rs.getString("login_name");
				String Mail = rs.getString("mailaddress");
				String BirthDay = rs.getString("birthday");
				String Address_No = rs.getString("address_no");
				String Secret_Question = rs.getString("seclet_question");
				String Secret_Answer = rs.getString("seclet_answer");
				SyougouData = new K_jyouhou_TO(Id, Name, Mail, BirthDay, Address_No, Secret_Question, Secret_Answer);
				}
			return SyougouData;

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}

	public boolean Password_Reset(String Kaiin_Id, String Password){
		Connection con = null;
		Connection con2 = null;
		try{
			con = createConnection2();

			String sql = "UPDATE users SET password = ? WHERE id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Password);
			stmt.setString(2, Kaiin_Id);
			stmt.executeUpdate();

			con2 = createConnection();

			sql = "UPDATE ninsyoudata SET password = ? WHERE k_id = ?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Password);
			stmt.setString(2, Kaiin_Id);
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
			closeConnection(con2);
		}
		return false;
	}

	public boolean Taikai_Uketsuke(String K_Id, String Role, String Now){
		Connection con = null;
		try{
			con = createConnection2();

			String sql = "UPDATE roles SET role = ?, lastupdate = ?, WHERE id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Role);
			stmt.setString(2, Now);
			stmt.setString(3, K_Id);
			stmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			return true;
		}finally{
			closeConnection(con);
		}
		return false;
	}
}

