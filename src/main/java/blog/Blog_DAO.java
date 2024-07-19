package blog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Blog_DAO {

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

	public ArrayList<Blog_TO> LastBlog_Load(){
		Blog_TO tmp = new Blog_TO();
		ArrayList<Blog_TO> Result = new ArrayList<Blog_TO>();
		Connection con = null;

		try{
			con = createConnection();

			String sql = "SELECT blogcode, kijicode, title, sakuseisya_id, sakuseisya_name, uploaddate, honbun, lock_info FROM blogdata WHERE lock_info = 0 ORDER BY uploaddate DESC LIMIT 15;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				String BlogCode = rs.getString("blogcode");
				String KijiCode = rs.getString("kijicode");
				String Title = rs.getString("title");
				String Sakuseisya_ID = rs.getString("sakuseisya_id");
				String Sakuseisya_Name = rs.getString("sakuseisya_name");
				String UploadDate = rs.getString("uploaddate");
				String Honbun = rs.getString("honbun");
				int Lock_Info = rs.getInt("lock_info");
				Honbun = Honbun.replace("<img src=", "<img src=\"/G-pro_Service/ImageFile_Load/");
				tmp = new Blog_TO(BlogCode, KijiCode, Title, Sakuseisya_ID, Sakuseisya_Name, UploadDate, Honbun, Lock_Info);
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
