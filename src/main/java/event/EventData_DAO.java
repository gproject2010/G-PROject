package event;

import inputUtility.Date_Changer;
import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class EventData_DAO {
	private final static String resourceName = "jdbc/event";
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
	
	public ArrayList<EventData_TO> EventIndex_Load(){
		ArrayList<EventData_TO> Result = new ArrayList<EventData_TO>();
		EventData_TO list = new EventData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT DISTINCT(eventcode) eventcode, eventname, grade, kaisaidate, event_master, uketsuke_jyoukyou, logofile_name, kaijyoumei FROM event_syousai ORDER BY kaisaidate DESC LIMIT 5;;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String EventCode = rs.getString("eventcode");
				String EventName = rs.getString("eventname");
				String Grade = rs.getString("grade");
				String KaisaiDate = rs.getString("kaisaidate");
				String Event_Master = rs.getString("event_master");
				String Uketsuke_Jyoukyou = rs.getString("uketsuke_jyoukyou");
				String Logofile_Name = rs.getString("logofile_name");
				String Kaijyoumei = rs.getString("kaijyoumei");
				list = new EventData_TO(EventCode, EventName, Grade, KaisaiDate, Event_Master, Uketsuke_Jyoukyou, Kaijyoumei, Logofile_Name);
				Result.add(list);
			}
				return Result;
			}catch(SQLException e ){
				e.printStackTrace();
				return null;
				
			}finally{
				closeConnection(con);
			}
	}
	
	public EventData_TO EventIndex_SyousaiLoad(String TaisyouCode){
		EventData_TO Result = new EventData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT DISTINCT(eventcode) eventcode, eventname, grade, kaisaidate, sanka_shimekiri, kounin_jyoukyou, uketsuke_jyoukyou, sankahouhou, sankahi, logofile_name, judge_master, event_master, sanka_shikaku, yosen_keishiki, kessyou_keishiki, shiryou1, shiryou2, shiryou3, shiryou1_size, shiryou2_size, shiryou3_size, option_mode, system_url, toiawasesaki, kaijyoumei, kaisaijikan FROM event_syousai " +
					" WHERE eventcode = '" + HttpUtility.escapeSQL(TaisyouCode) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String EventCode = rs.getString("eventcode");
				String EventName = rs.getString("eventname");
				String Grade = rs.getString("grade");
				String KaisaiDate = rs.getString("kaisaidate");
				String Sanka_Shimekiri = rs.getString("sanka_shimekiri");
				String Kounin_Jyoukyou = rs.getString("kounin_jyoukyou");
				String Uketsuke_Jyoukyou = rs.getString("uketsuke_jyoukyou");
				String Kaijyoumei = rs.getString("kaijyoumei");
				String Kaisaijikan = rs.getString("kaisaijikan");
				String Sankahouhou = rs.getString("sankahouhou");
				String Sankahi = rs.getString("sankahi");
				String LogoFile_Name = rs.getString("logofile_name");
				String Judge_Master = rs.getString("judge_master");
				String Event_Master = rs.getString("event_master");
				String Sanka_Shikaku = rs.getString("sanka_shikaku");
				String Yosen_Keishiki = rs.getString("yosen_keishiki");
				String Kessyou_Keishiki = rs.getString("kessyou_keishiki");
				String Eventshiryou1 = rs.getString("shiryou1");
				String Eventshiryou2 = rs.getString("shiryou2");
				String Eventshiryou3 = rs.getString("shiryou3");
				double Shiryou1_Size = rs.getDouble("shiryou1_size");
				double Shiryou2_Size = rs.getDouble("shiryou2_size");
				double Shiryou3_Size = rs.getDouble("shiryou3_size");
				int Option_Mode = rs.getInt("option_mode");//オプションサービスの種別
				String System_URL = rs.getString("system_url");//特設サイトを用意する場合、そのURL
				String Toiawasesaki = rs.getString("toiawasesaki");
				Result = new EventData_TO(EventCode, EventName, Grade, KaisaiDate, Sanka_Shimekiri, Kounin_Jyoukyou, Uketsuke_Jyoukyou, Kaijyoumei, Kaisaijikan, Sankahouhou, Sankahi, LogoFile_Name, Judge_Master, Event_Master, Sanka_Shikaku, Yosen_Keishiki, Kessyou_Keishiki, Eventshiryou1, Eventshiryou2, Eventshiryou3, Shiryou1_Size, Shiryou2_Size, Shiryou3_Size, Option_Mode, System_URL, Toiawasesaki);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
}
	
	public EventData_TO EventInterview_Load(String TaisyouCode){//イベント参加時の入力項目のリスト
		EventData_TO Result = new EventData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT DISTINCT(eventcode) eventcode, eventname, koumokulist, inputtypelist, mojikeishiki, maxlengthlist FROM tourokukoumoku WHERE eventcode = '" + HttpUtility.escapeSQL(TaisyouCode) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String EventCode = rs.getString("eventcode");
				String EventName = rs.getString("eventname");
				String KoumokuList = rs.getString("koumokulist");
				String InputTypeList = rs.getString("inputtypelist");
				String MojikeishikiList = rs.getString("mojikeishiki");
				String MaxLengthList = rs.getString("maxlengthlist");
				Result = new EventData_TO(EventCode, EventName, KoumokuList, InputTypeList, MojikeishikiList, MaxLengthList);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public int Sankasya_Touroku(EventData_TO EventSyousai, EventData_TO SankasyaData, int ran, Calendar Now){
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "INSERT INTO event_sankasya(eventcode, eventname, tourokudate, entry_name, entry_name_yomi, pref, sankasya_id, koumoku1, koumoku2, koumoku3, koumoku4, koumoku5, bikou, mailaddress) VALUES(?,?,?,?,?, ?,?,?,?,?, ?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, EventSyousai.getEventCode());
			pstmt.setString(2, EventSyousai.getEventName());
			pstmt.setString(3, Date_Changer.toDateString(Now));
			pstmt.setString(4, SankasyaData.getEntry_Name());
			pstmt.setString(5, SankasyaData.getEntry_Name_Yomi());
			pstmt.setString(6, SankasyaData.getPref());
			pstmt.setInt(7, ran);
			pstmt.setString(8, SankasyaData.getKoumoku1());
			pstmt.setString(9, SankasyaData.getKoumoku2());
			pstmt.setString(10, SankasyaData.getKoumoku3());
			pstmt.setString(11, SankasyaData.getKoumoku4());
			pstmt.setString(12, SankasyaData.getKoumoku5());
			pstmt.setString(13, SankasyaData.getBikou());
			pstmt.setString(14, SankasyaData.getMailAddress());
			pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			return 1;
			}finally{
			closeConnection(con);
			}
		return 0;
}
	
	public int Toiawase_Touroku(EventData_TO EventData, String MailAddress, String Naiyou, Calendar Now, int Result){
Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "INSERT INTO event_toiawase(eventcode, eventname, toiawasedate, mailaddress, naiyou, result) VALUES(?,?,?,?,?, ?);";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, EventData.getEventCode());
			pstmt.setString(2, EventData.getEventName());
			pstmt.setString(3, Date_Changer.toDateString(Now));
			pstmt.setString(4, MailAddress);
			pstmt.setString(5, Naiyou);
			pstmt.setInt(6, Result);
			pstmt.executeUpdate();

		}catch(SQLException e){
			e.printStackTrace();
			return 1;
			}finally{
			closeConnection(con);
			}
		return 0;
}
	
	
	public EventData_TO EventWinner_Load(String TaisyouCode){//イベント参加時の入力項目のリスト
		EventData_TO Result = new EventData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT DISTINCT first, second, third, fourth, syusei_riyu FROM winnerdata WHERE eventcode = '" + HttpUtility.escapeSQL(TaisyouCode) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if(rs.next()){
				String First = rs.getString("first");
				String Second = rs.getString("second");
				String Third = rs.getString("third");
				String Fourth = rs.getString("fourth");
				String Syusei_Riyu = rs.getString("syusei_riyu");
				Result = new EventData_TO(First, Second, Third, Fourth, Syusei_Riyu);
			}
			return Result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public ArrayList<EventData_TO> EventRank_Load(String TaisyouCode){//イベント参加時の入力項目のリスト
		ArrayList<EventData_TO> Result = new ArrayList<EventData_TO>();
		EventData_TO List = new EventData_TO();
		Connection con = null;
		
		try{

			con = createConnection();
			
			String sql = "SELECT DISTINCT(eventcode) eventcode, eventname, rank, scorekoumoku1, scorekoumoku2, scorekoumoku3, scorekoumoku4, score1, score2, score3, score4, totalscore, entry_name FROM rankingdata WHERE eventcode = '" + HttpUtility.escapeSQL(TaisyouCode) + "' ORDER BY rank ASC LIMIT 10;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String EventCode = rs.getString("eventcode");
				String EventName = rs.getString("eventname");
				int Rank = rs.getInt("rank");
				String ScoreKoumoku1 = rs.getString("scorekoumoku1");
				String ScoreKoumoku2 = rs.getString("scorekoumoku2");
				String ScoreKoumoku3 = rs.getString("scorekoumoku3");
				String ScoreKoumoku4 = rs.getString("scorekoumoku4");
				String Score1 = rs.getString("score1");
				String Score2 = rs.getString("score2");
				String Score3 = rs.getString("score3");
				String Score4 = rs.getString("score4");
				String TotalScore = rs.getString("totalscore");
				String Entry_Name = rs.getString("entry_name");
				
				List = new EventData_TO(EventCode, EventName, Rank, ScoreKoumoku1, ScoreKoumoku2, ScoreKoumoku3, ScoreKoumoku4, Score1, Score2, Score3, Score4, TotalScore, Entry_Name);
				Result.add(List);
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
