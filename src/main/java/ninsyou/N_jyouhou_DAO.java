package ninsyou;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import inputUtility.HttpUtility;
import k_jyouhou.K_Touroku_TO;

public class N_jyouhou_DAO{

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

	private final static String resourceName3 = "jdbc/contents_lock";

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
	public N_jyouhou_TO findkaiin_NById(String Input_Id){
		N_jyouhou_TO Kaiin_n = null;//会員の基本情報を取得
		Connection con = null;
		try{

			con = createConnection();

			String sql = "select k_number, k_id, login_name, lock_flg," + " case when l_limit < current_date then -1 when l_limit >= date_add(current_date, interval 3 day) then datediff(l_limit, current_date) else 0 end as l_limit " + "from ninsyoudata where (k_id <=> '" + HttpUtility.escapeSQL(Input_Id) + "');";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				int k_number = rs.getInt("k_number");//会員番号
				String k_Id = rs.getString("k_id");//ID
				String login_name = rs.getString("login_name");//プレイヤーネーム
				int lock_flg = rs.getInt("lock_flg");//ID・パスワードのロック状態
				int l_limit = rs.getInt("l_limit");//ライセンス期限
				boolean Auth = true;
				Kaiin_n = new N_jyouhou_TO(k_number, k_Id, login_name, lock_flg, l_limit, Auth);
			}
			return Kaiin_n;

		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}

	public N_jyouhou_TO PassCheck_Lv2(String Kakunin_Id){//追加認証用ID・パスワードの取得
		N_jyouhou_TO CheckResult = null;
		Connection con = null;


		try{

		con = createConnection();

		String sql = "SELECT k_id, password FROM ninsyoudata WHERE k_id = '" + HttpUtility.escapeSQL(Kakunin_Id) + "';";
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		if(rs.next()){
			String IdResult = rs.getString("k_id");
			String PassResult = rs.getString("password");
			CheckResult = new N_jyouhou_TO(IdResult, PassResult);
		}
		return CheckResult;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
	}

	public boolean Mail_jyufuku(String MailAddress){//メールアドレス・携帯メールアドレスの重複確認
		Connection con = null;
		String Jyufuku = null;

		try{
			con = createConnection();

			String sql = "SELECT mailaddress FROM ninsyoudata WHERE mailaddress = '" + HttpUtility.escapeSQL(MailAddress) + "' AND login_name IS NOT NULL;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				Jyufuku = rs.getString("mailaddress");//同じメールアドレスがすでに登録されていればtrueを返す
				}
			if(Jyufuku == null){
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

	public boolean Karininsyou(K_Touroku_TO Karijyouhou){//仮ID、仮パスワードの登録処理
		Connection con = null;
		boolean tourokuerror = false;
		try{
			con = createConnection2();

			String sql = "INSERT INTO users ( id, mailaddress, password ) VALUES(?,?,?);";//usersテーブルへの挿入
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, Karijyouhou.getKari_Id());
			stmt.setString(2, Karijyouhou.getMail_Address());
			stmt.setString(3, Karijyouhou.getKari_Password());
			stmt.executeUpdate();

			sql = "INSERT INTO roles (id, role ) VALUES(?,?);";//rolesテーブルへの挿入
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Karijyouhou.getKari_Id());
			stmt.setString(2, "shinki");

			stmt.executeUpdate();



		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}

	public boolean N_Data_Upload(K_Touroku_TO ChangeData, N_jyouhou_TO baseData, String Now){//n_dataデータベースに対する変更処理
		Connection con = null;
		Connection con2 = null;
		boolean tourokuerror = false;
		try{
			con = createConnection2();

			String sql = "UPDATE roles SET id = ?, username = ? WHERE id = ?;";//ninsyoudataテーブルへの挿入
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getKibou_Id());
			stmt.setString(2, ChangeData.getLogin_Name());
			stmt.setString(3, baseData.getK_Id());
			stmt.executeUpdate();

			sql = "UPDATE users SET id = ?, username = ?, password = ?, mailaddress = ? WHERE id = ?;";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getKibou_Id());
			stmt.setString(2, ChangeData.getLogin_Name());
			stmt.setString(3, ChangeData.getKibou_Password());
			stmt.setString(4, ChangeData.getMail_Address());
			stmt.setString(5, baseData.getK_Id());
			stmt.executeUpdate();

			con2 = createConnection3();
			sql = "INSERT INTO idchange_log (lastupdate, before_id, after_id) VALUES(?,?,?);";
			stmt = con.prepareStatement(sql);
			stmt.setString(1, Now);
			stmt.setString(2, baseData.getK_Id());
			stmt.setString(3, ChangeData.getKibou_Id());
			stmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
			closeConnection(con2);
		}
		return tourokuerror;
	}

	public N_jyouhou_TO SousaLock_Data(){//コンテンツのロック状態を取得
		Connection con = null;
		N_jyouhou_TO Lock_List = new N_jyouhou_TO();

		try{
			con = createConnection3();

			String sql = "SELECT login_lock, seiseki_lock, getsuran_lock, normalrep_lock, newgame_lock, shinkirep_lock,  gron_lock, voandexp_lock, proprep_lock, k_henkoulock, griron_lock, coupon_lock FROM blockdata;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
			boolean Login_Lock = rs.getBoolean("login_lock");
			boolean Seiseki_Lock = rs.getBoolean("seiseki_lock");
			boolean Getsuran_Lock = rs.getBoolean("getsuran_lock");
			boolean NormalRep_Lock = rs.getBoolean("normalrep_lock");
			boolean NewGame_Lock = rs.getBoolean("newgame_lock");
			boolean ShinkiRep_Lock = rs.getBoolean("shinkirep_lock");
			boolean GRon_Lock = rs.getBoolean("gron_lock");
			boolean VoAndExp_Lock = rs.getBoolean("voandexp_lock");
			boolean PropRep_Lock = rs.getBoolean("proprep_lock");
			boolean K_HenkouLock = rs.getBoolean("k_henkoulock");
			boolean GRiron_Lock = rs.getBoolean("griron_lock");
			boolean Coupon_Lock = rs.getBoolean("coupon_lock");
			Lock_List = new N_jyouhou_TO(Login_Lock, Seiseki_Lock, Getsuran_Lock, NormalRep_Lock, NewGame_Lock, ShinkiRep_Lock, GRon_Lock, VoAndExp_Lock, PropRep_Lock, K_HenkouLock, GRiron_Lock, Coupon_Lock);
			}
			return Lock_List;

		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}finally{
			closeConnection(con);
		}
	}

	public boolean Change_Kaisu(String Kaiin_ID){
		Connection con = null;
		int Change_Kaisu = 0;

		try{
			con = createConnection3();

			String sql = "SELECT COUNT(after_id) AS change_kaisu FROM idchange_log WHERE lastupdate > date_add(current_date, interval -1 month) AND after_id = '" + HttpUtility.escapeSQL(Kaiin_ID) + "';";
			Statement stmt = con.createStatement();//過去1ヶ月にすでに変更してないか調査
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				Change_Kaisu = rs.getInt("change_kaisu");//すでに変更しているとこの値が1になる
			}
			//System.out.println(Change_Kaisu);
			if(Change_Kaisu == 0){//認証情報の変更は1ヶ月につき1回のみ(注:アルゴリズム上変更不可)
			return true;//過去1ヶ月の履歴がなければ変更を許可
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

	public int N_ErrorLog_Search(String IpAddress){//認証失敗回数の確認
		Connection con = null;
		int HitCount = 20;

		try{
			con = createConnection3();

			String sql = "SELECT COUNT(ipaddress) AS hitcount FROM n_errorlog WHERE ipaddress = '" + HttpUtility.escapeSQL(IpAddress) + "' AND kirokunichiji > DATE_ADD(current_date, interval -1 month);";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				HitCount = rs.getInt("hitcount");//過去1ヶ月の認証失敗回数を算出
			}
			return HitCount;
		}catch(SQLException e){
			e.printStackTrace();
			return 20;
		}finally{
			closeConnection(con);
		}
	}

	public boolean N_ErrorLog_Upload(String InputId, String InputPassword, String IpAddress){//n_dataデータベースに対する変更処理
		Connection con = null;
		boolean tourokuerror = false;
		try{
			con = createConnection3();

			String sql = "INSERT INTO n_errorlog (input_id, input_password, ipaddress, kirokunichiji) VALUES(?,?,?, now());";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, InputId);
			stmt.setString(2, InputPassword);
			stmt.setString(3, IpAddress);
			stmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}
}
