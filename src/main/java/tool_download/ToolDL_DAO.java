package tool_download;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import inputUtility.HttpUtility;

public class ToolDL_DAO {

	private final static String resourceName = "jdbc/tooldata";
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

	public ArrayList<ToolDL_TO> ToolGaiyou_Maker(){
		ArrayList<ToolDL_TO> Result = new ArrayList<ToolDL_TO>();
		ToolDL_TO tmp = new ToolDL_TO();
		Connection con = null;
		try{

			con = createConnection();

			String sql = "SELECT toolcode, tooltitle, uploadtime, seisakusya_name, taisyougametitle, lock_info FROM tooldata ORDER BY uploadtime DESC LIMIT 30;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				String ToolCode = rs.getString("toolcode");
				String ToolTitle = rs.getString("tooltitle");
				String UploadTime = rs.getString("uploadtime");
				String Seisakusya_Name = rs.getString("seisakusya_name");
				String TaisyouGameTitle = rs.getString("taisyougametitle");
				int Lock_Info = rs.getInt("lock_info");
				tmp = new ToolDL_TO(ToolCode, ToolTitle, UploadTime, Seisakusya_Name, TaisyouGameTitle, Lock_Info);
				Result.add(tmp);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
		}

	public ArrayList<ToolDL_TO> ToolSyousai_Maker(String Toolcode){
		ArrayList<ToolDL_TO> Result = new ArrayList<ToolDL_TO>();
		ToolDL_TO tmp = new ToolDL_TO();
		Connection con = null;
		try{

			con = createConnection();

			String sql = "SELECT toolcode, tooltitle, uploadtime, seisakusya_id, seisakusya_name, youto, taisyougametitle, description, filename, readme_filename, lock_info FROM tooldata "
					+ " WHERE toolcode = '" + HttpUtility.escapeSQL(Toolcode) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				String ToolCode = rs.getString("toolcode");
				String ToolTitle = rs.getString("tooltitle");
				String UploadTime = rs.getString("uploadtime");
				String Seisakusya_ID = rs.getString("seisakusya_id");
				String Seisakusya_Name = rs.getString("seisakusya_name");
				String Youto = rs.getString("youto");
				String TaisyouGameTitle = rs.getString("taisyougametitle");
				String Description = rs.getString("description");
				String FileName = rs.getString("filename");
				String Readme_FileName = rs.getString("readme_filename");
				int Lock_Info = rs.getInt("lock_info");
				tmp = new ToolDL_TO(ToolCode, ToolTitle, UploadTime, Seisakusya_ID, Seisakusya_Name, Youto, TaisyouGameTitle, Description, FileName, Readme_FileName, Lock_Info);
				Result.add(tmp);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;

		}finally{
			closeConnection(con);
		}
		}
}
