package mail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import k_jyouhou.K_Touroku_TO;
import ninsyou.N_jyouhou_TO;

public class Toiawase_DAO {

	private final static String resourceName = "jdbc/t_data";//問い合わせの内容を保存するデータベース

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
	public boolean Toiawase_Kakunou(Toiawase_Koumoku naiyou, String Now){
		
		Connection con = null;
		boolean tourokuerror = false;
		try{
			con = createConnection();
			
			String sql = "insert into toiawase (mailaddress, toiawase_syubetsu, subject, body, kakikominichiji) values(?,?,?,?,?)";//未確認の問い合わせとしてDBに保存
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, naiyou.getFrom());
			stmt.setString(2, naiyou.getToi_Syubetsu());
			stmt.setString(3, naiyou.getSubject());
			stmt.setString(4, naiyou.getBody());
			stmt.setString(5, Now);
			
			stmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			tourokuerror = true;
		}finally{
			closeConnection(con);
		}
		return tourokuerror;
	}
	
	public boolean R_Henkou_Upload(K_Touroku_TO ChangeData, N_jyouhou_TO baseData){//r_dataデータベースに対する認証情報変更処理
		Connection con = null;
		boolean tourokuerror = true;
		String sql = "";
		try{
			con = createConnection();
			
			sql = "UPDATE toiawase SET gpro_id = ? WHERE gpro_id = ?;";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, ChangeData.getKibou_Id());
			stmt.setString(2, baseData.getK_Id());
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
