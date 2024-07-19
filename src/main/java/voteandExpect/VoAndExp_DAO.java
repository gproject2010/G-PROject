package voteandExpect;

import inputUtility.HttpUtility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import k_jyouhou.K_Touroku_TO;
import ninsyou.N_jyouhou_TO;

public class VoAndExp_DAO {
	private final static String resourceName = "jdbc/vote_expdata";
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
	
	public ArrayList<VoAndExp_TO> AncIndex_Serch(){
		ArrayList<VoAndExp_TO> Result = new ArrayList<VoAndExp_TO>();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT odai, vote_shimekiri, sentakushi_a, sentakushi_b, sentakushi_c, sentakushi_d FROM anc_data WHERE vote_shimekiri >= (SELECT CURRENT_DATE()) AND startdate <= (SELECT CURRENT_DATE()) AND lock_info = 0 ORDER BY vote_shimekiri DESC LIMIT 5;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Odai = rs.getString("odai");
				String Vote_Shimekiri = rs.getString("vote_shimekiri");
				String Sentakushi_A = rs.getString("sentakushi_a");
				String Sentakushi_B = rs.getString("sentakushi_b");
				String Sentakushi_C = rs.getString("sentakushi_c");
				String Sentakushi_D = rs.getString("sentakushi_d");
				VoAndExp_TO List = new VoAndExp_TO(Odai, Vote_Shimekiri, Sentakushi_A, Sentakushi_B, Sentakushi_C, Sentakushi_D);
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
	
	public ArrayList<VoAndExp_TO> FreeAnc_IndexSerch(){
		ArrayList<VoAndExp_TO> Result = new ArrayList<VoAndExp_TO>();
		VoAndExp_TO tmp = new VoAndExp_TO();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT anc_code, description, odai, startdate, vote_shimekiri, expect_shimekiri FROM freeanc_data WHERE vote_shimekiri >= (SELECT CURRENT_DATE()) AND startdate <= (SELECT CURRENT_DATE()) AND lock_info = 0 ORDER BY vote_shimekiri DESC LIMIT 5;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Anc_Code = rs.getString("anc_code");
				String Odai = rs.getString("odai");
				String StartDate = rs.getString("startdate");
				String Vote_Shimekiri = rs.getString("vote_shimekiri");
				String Expect_Shimekiri = rs.getString("expect_shimekiri");
				tmp = new VoAndExp_TO(Anc_Code, Odai, StartDate, Vote_Shimekiri, Expect_Shimekiri);
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
	
	public ArrayList<VoAndExp_TO> IndexVo_LogLoad(ArrayList<VoAndExp_TO> Ancate_Code){
		ArrayList<VoAndExp_TO> result = new ArrayList<VoAndExp_TO>();
		VoAndExp_TO tmp = new VoAndExp_TO();
		Connection con = null;
		try{

			con = createConnection();
			for(int i=0; i < Ancate_Code.size(); i++){
			String sql = "SELECT anc_code, gpro_id, ins_date, answer FROM vote_log WHERE anc_code = '" + HttpUtility.escapeSQL(Ancate_Code.get(i).getAnc_Code()) + "' GROUP BY answer ORDER BY ins_date DESC;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Anc_Code = rs.getString("anc_code");
				String GPRO_ID = rs.getString("gpro_id");
				String Ins_Date = rs.getString("ins_date");
				String Answer = rs.getString("answer");
				tmp = new VoAndExp_TO(Anc_Code, GPRO_ID, Ins_Date, Answer);
				result.add(tmp);
			}
			}
			return result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
	
	public ArrayList<VoAndExp_TO> Anc_Serch(){
		ArrayList<VoAndExp_TO> result = new ArrayList<VoAndExp_TO>();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT anc_code, odai, resp_mode, startdate, vote_shimekiri, expect_shimekiri, resp_count FROM anc_data WHERE (vote_shimekiri >= (SELECT ADDDATE(CURRENT_DATE(), -90))) AND (lock_info = 0);";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Anc_Code = rs.getString("anc_code");
				String Odai = rs.getString("odai");
				String Resp_Mode = rs.getString("resp_mode");
				String StartDate = rs.getString("startdate");
				String Vote_Shimekiri = rs.getString("vote_shimekiri");
				String Expect_Shimekiri = rs.getString("expect_shimekiri");
				int Resp_Count = rs.getInt("resp_count");
				
				
				VoAndExp_TO HitList = new VoAndExp_TO(Anc_Code, Odai, Resp_Mode, StartDate, Vote_Shimekiri, Expect_Shimekiri, Resp_Count);
				result.add(HitList);
			}
			return result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
	
	public ArrayList<VoAndExp_TO> FreeAnc_Serch(){
		ArrayList<VoAndExp_TO> result = new ArrayList<VoAndExp_TO>();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT anc_code, odai, startdate, vote_shimekiri, expect_shimekiri FROM freeanc_data WHERE (vote_shimekiri >= (SELECT ADDDATE(CURRENT_DATE(), -90))) AND (lock_info = 0);";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Anc_Code = rs.getString("anc_code");
				String Odai = rs.getString("odai");
				String StartDate = rs.getString("startdate");
				String Vote_Shimekiri = rs.getString("vote_shimekiri");
				String Expect_Shimekiri = rs.getString("expect_shimekiri");
				
				
				VoAndExp_TO HitList = new VoAndExp_TO(Anc_Code, Odai, StartDate, Vote_Shimekiri, Expect_Shimekiri);
				result.add(HitList);
			}
			return result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
	
	
	public VoAndExp_TO Anc_SyousaiSerch(String Ancate_Code){
		VoAndExp_TO result = new VoAndExp_TO();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT anc_code, odai, resp_mode, startdate, vote_shimekiri, expect_shimekiri, resp_count, vote_bonus, vbonus_sc, expect_bonus, expbonus_sc, sentakushi_a, sentakushi_b, sentakushi_c, sentakushi_d, sentakusyalist_a, sentakusyalist_b, sentakusyalist_c, sentakusyalist_d, yosousyalist_a, yosousyalist_b, yosousyalist_c, yosousyalist_d " +
					" FROM anc_data WHERE anc_code = '" + HttpUtility.escapeSQL(Ancate_Code) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Anc_Code = rs.getString("anc_code");
				String Odai = rs.getString("odai");
				String Resp_Mode = rs.getString("resp_mode");
				String StartDate = rs.getString("startdate");
				String Vote_Shimekiri = rs.getString("vote_shimekiri");
				String Expect_Shimekiri = rs.getString("expect_shimekiri");
				int Resp_Count = rs.getInt("resp_count");
				String Vote_Bonus = rs.getString("vote_bonus");
				double VBonus_Sc = rs.getDouble("vbonus_sc");
				String Expect_Bonus = rs.getString("expect_bonus");
				double ExpBonus_Sc = rs.getDouble("expbonus_sc");
				String Sentakushi_A = rs.getString("sentakushi_a");
				String Sentakushi_B = rs.getString("sentakushi_b");
				String Sentakushi_C = rs.getString("sentakushi_c");
				String Sentakushi_D = rs.getString("sentakushi_d");
				String SentakusyaList_A = rs.getString("sentakusyalist_a");
				String SentakusyaList_B = rs.getString("sentakusyalist_b");
				String SentakusyaList_C = rs.getString("sentakusyalist_c");
				String SentakusyaList_D = rs.getString("sentakusyalist_d");
				String YosousyaList_A = rs.getString("yosousyalist_a");
				String YosousyaList_B = rs.getString("yosousyalist_b");
				String YosousyaList_C = rs.getString("yosousyalist_c");
				String YosousyaList_D = rs.getString("yosousyalist_d");
				
				
				result = new VoAndExp_TO(Anc_Code, Odai, Resp_Mode, StartDate, Vote_Shimekiri, Expect_Shimekiri, Resp_Count, Vote_Bonus, VBonus_Sc, Expect_Bonus, ExpBonus_Sc, Sentakushi_A, Sentakushi_B, Sentakushi_C, Sentakushi_D,
						SentakusyaList_A, SentakusyaList_B, SentakusyaList_C, SentakusyaList_D, YosousyaList_A, YosousyaList_B, YosousyaList_C, YosousyaList_D);
			}
			return result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
	
	public VoAndExp_TO FreeAnc_SyousaiSerch(String Ancate_Code){
		VoAndExp_TO result = new VoAndExp_TO();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT anc_code, odai, description, startdate, vote_shimekiri, expect_shimekiri, vote_bonus, vbonus_sc, expect_bonus, expbonus_sc FROM freeanc_data WHERE anc_code = '" + HttpUtility.escapeSQL(Ancate_Code) + "';";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Anc_Code = rs.getString("anc_code");
				String Odai = rs.getString("odai");
				String Description = rs.getString("description");
				String StartDate = rs.getString("startdate");
				String Vote_Shimekiri = rs.getString("vote_shimekiri");
				String Expect_Shimekiri = rs.getString("expect_shimekiri");
				String Vote_Bonus = rs.getString("vote_bonus");
				double VBonus_Sc = rs.getDouble("vbonus_sc");
				String Expect_Bonus = rs.getString("expect_bonus");
				double ExpBonus_Sc = rs.getDouble("expbonus_sc");
				result = new VoAndExp_TO(Anc_Code, Odai, Description, StartDate, Vote_Shimekiri, Expect_Shimekiri, Vote_Bonus, VBonus_Sc, Expect_Bonus, ExpBonus_Sc);
			}
			return result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
			
	public ArrayList<VoAndExp_TO> Vo_LogLoad(String Ancate_Code){
		ArrayList<VoAndExp_TO> result = new ArrayList<VoAndExp_TO>();
		VoAndExp_TO tmp = new VoAndExp_TO();
		Connection con = null;
		try{

			con = createConnection();
			
			String sql = "SELECT anc_code, gpro_id, ins_date, answer FROM vote_log WHERE anc_code = '" + HttpUtility.escapeSQL(Ancate_Code) + "' ORDER BY ins_date ASC;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Anc_Code = rs.getString("anc_code");
				String GPRO_ID = rs.getString("gpro_id");
				String Ins_Date = rs.getString("ins_date");
				String Answer = rs.getString("answer");
				tmp = new VoAndExp_TO(Anc_Code, GPRO_ID, Ins_Date, Answer);
				result.add(tmp);
			}
			return result;
		}catch(SQLException e ){
			e.printStackTrace();
			return null;
			
		}finally{
			closeConnection(con);
		}
		}
		
		public ArrayList<VoAndExp_TO> Exp_LogLoad(String Ancate_Code){
			ArrayList<VoAndExp_TO> result = new ArrayList<VoAndExp_TO>();
			VoAndExp_TO tmp = new VoAndExp_TO();
			Connection con = null;
			try{

				con = createConnection();
				
				String sql = "SELECT anc_code, gpro_id, ins_date answer FROM expect_log WHERE anc_code = '" + HttpUtility.escapeSQL(Ancate_Code) + "' ORDER BY ins_date ASC;";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				while(rs.next()){
					String Anc_Code = rs.getString("anc_code");
					String GPRO_ID = rs.getString("gpro_id");
					String Ins_Date = rs.getString("ins_date");
					String Answer = rs.getString("answer");
					tmp = new VoAndExp_TO(Anc_Code, GPRO_ID, Ins_Date, Answer);
					result.add(tmp);
				}
				return result;
			}catch(SQLException e ){
				e.printStackTrace();
				return null;
				
			}finally{
				closeConnection(con);
			}
			}
		
		public int Vo_LogInsert(VoAndExp_TO InsData){
			Connection con = null;
			String sql = null;
			int errorcount = 0;
			try{
				con = createConnection();
				
				sql = "INSERT INTO vote_log(anc_code, gpro_id, ins_date, answer) VALUES(?,?,?,?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, InsData.getAnc_Code());
				pstmt.setString(2, InsData.getGPRO_ID());
				pstmt.setString(3, InsData.getIns_Date());
				pstmt.setString(4, InsData.getAnswer());
				pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			errorcount += 1;
		}finally{
			closeConnection(con);
		}
		return errorcount;
	}
		
		public int Exp_LogInsert(VoAndExp_TO InsData){
			Connection con = null;
			String sql = null;
			int errorcount = 0;
			try{
				con = createConnection();
				
				sql = "INSERT INTO expect_log(anc_code, gpro_id, ins_date, answer) VALUES(?,?,?,?);";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, InsData.getAnc_Code());
				pstmt.setString(2, InsData.getGPRO_ID());
				pstmt.setString(3, InsData.getIns_Date());
				pstmt.setString(4, InsData.getAnswer());
				pstmt.executeUpdate();
			
		}catch(SQLException e){
			e.printStackTrace();
			errorcount += 1;
		}finally{
			closeConnection(con);
		}
		return errorcount;
	}
	
	public int Vote_Update(String Anc_Code, String VoteSel, String ExpectSel, String Kaiin_ID){
		Connection con = null;
		String sql = null;
		String Vote_Select = null;
		String Exp_Select = null;
		String Vote_List = null;
		String Expect_List = null;
		try{
			
			
			if(VoteSel.equals("A")){
				Vote_Select = "sentakusyalist_a,";
			}else if(VoteSel.equals("B")){
				Vote_Select = "sentakusyalist_b,";
			}else if(VoteSel.equals("C")){
				Vote_Select = "sentakusyalist_c,";
			}else if(VoteSel.equals("D")){
				Vote_Select = "sentakusyalist_d,";
			}
			
			if(ExpectSel.equals("A")){
				Exp_Select = "yosousyalist_a";
			}else if(ExpectSel.equals("B")){
				Exp_Select = "yosousyalist_b";
			}else if(ExpectSel.equals("C")){
					Exp_Select = "yosousyalist_c";
			}else if(ExpectSel.equals("D")){
				Exp_Select = "yosousyalist_d";
			}
			
			con = createConnection();
			
			sql = "SELECT " + Vote_Select + Exp_Select + " FROM anc_data WHERE anc_code = '" + HttpUtility.escapeSQL(Anc_Code) + "' ;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
					Vote_List = rs.getString(Vote_Select.substring(0, Vote_Select.length() - 5 ));
					Expect_List = rs.getString(Exp_Select);
			}
			if(!(VoteSel.equals("empty"))){
			sql = "UPDATE anc_data SET " + Vote_Select + " = ? WHERE anc_code = ?;";
			
			PreparedStatement stmt2 = con.prepareStatement(sql);
			if(Vote_List != null){
			stmt2.setString(1, Vote_List + HttpUtility.escapeSQL(Kaiin_ID) + "plus;");
			}else{
				stmt2.setString(1, HttpUtility.escapeSQL(Kaiin_ID));
			}
			stmt2.setString(2, HttpUtility.escapeSQL(Anc_Code));
			stmt2.executeUpdate();
		}
			if(!(ExpectSel.equals("empty"))){
			sql = "UPDATE anc_data SET " + Exp_Select + " = ? WHERE anc_code = ?;";
			
			PreparedStatement stmt2 = con.prepareStatement(sql);
			if(Expect_List != null){
			stmt2.setString(1, Expect_List + HttpUtility.escapeSQL(Kaiin_ID) + "plus;");
			}else{
				stmt2.setString(1, HttpUtility.escapeSQL(Kaiin_ID));
			}
			stmt2.setString(2, HttpUtility.escapeSQL(Anc_Code));
			stmt2.executeUpdate();
			}
			return 0;
		}catch(SQLException e ){
			e.printStackTrace();
			return 1;
			
		}finally{
			closeConnection(con);
		}
	}
	
	public boolean VoteId_Change(K_Touroku_TO ChangeData, N_jyouhou_TO BaseData){
		Connection con = null;
		//String sql = null;
		String sql2 = null;
		String sql3 = null;
		//VoAndExp_TO List = new VoAndExp_TO();
		//ArrayList<VoAndExp_TO> Result = new ArrayList<VoAndExp_TO>();
		
		con = createConnection();
		try{
		/*
		//アンケートデータに実装の選択者・予想者リストは使用せず、新設のログから情報を抜き出す
		sql = "SELECT anc_code, sentakusyalist_a, sentakushalist_b, sentakushalist_c, sentakushalist_d, yosousyalist_a, yosousyalist_b, yosousyalist_c, yosousyalist_d FROM anc_data;";
		
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()){
			String Anc_Code = rs.getString("anc_code");
			String SentakusyaList_A = rs.getString("sentakusyalist_a");
			String SentakusyaList_B = rs.getString("sentakusyalist_b");
			String SentakusyaList_C = rs.getString("sentakusyalist_c");
			String SentakusyaList_D = rs.getString("sentakusyalist_d");
			String YosousyaList_A = rs.getString("yosousyalist_a");
			String YosousyaList_B = rs.getString("yosousyalist_b");
			String YosousyaList_C = rs.getString("yosousyalist_c");
			String YosousyaList_D = rs.getString("yosousyalist_d");
			List = new VoAndExp_TO(Anc_Code, SentakusyaList_A, SentakusyaList_B, SentakusyaList_C, SentakusyaList_D, YosousyaList_A, YosousyaList_B, YosousyaList_C, YosousyaList_D);
			Result.add(List);
		}
		
		for(int i=0; i < Result.size(); i++){
			Result.get(i).setSentakusyaList_A(Result.get(i).getSentakusyaList_A().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			Result.get(i).setSentakusyaList_B(Result.get(i).getSentakusyaList_B().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			Result.get(i).setSentakusyaList_C(Result.get(i).getSentakusyaList_C().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			Result.get(i).setSentakusyaList_D(Result.get(i).getSentakusyaList_D().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			Result.get(i).setYosousyaList_A(Result.get(i).getYosousyaList_A().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			Result.get(i).setYosousyaList_B(Result.get(i).getYosousyaList_B().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			Result.get(i).setYosousyaList_C(Result.get(i).getYosousyaList_C().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			Result.get(i).setYosousyaList_D(Result.get(i).getYosousyaList_D().replaceAll(BaseData.getK_Id(), ChangeData.getKibou_Id()));
			
			sql = "UPDATE anc_data SET sentakusyalist_a = ?, sentakushalist_b = ?, sentakushalist_c = ?, sentakushalist_d = ?, yosousyalist_a = ?, yosousyalist_b = ?, yosousyalist_c = ?, yosousyalist_d = ? WHERE anc_code = ?;";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, Result.get(i).getSentakusyaList_A());
			pstmt.setString(2, Result.get(i).getSentakusyaList_B());
			pstmt.setString(3, Result.get(i).getSentakusyaList_C());
			pstmt.setString(4, Result.get(i).getSentakusyaList_D());
			pstmt.setString(5, Result.get(i).getYosousyaList_A());
			pstmt.setString(6, Result.get(i).getYosousyaList_B());
			pstmt.setString(7, Result.get(i).getYosousyaList_C());
			pstmt.setString(8, Result.get(i).getYosousyaList_D());
			pstmt.setString(9, Result.get(i).getAnc_Code());
			pstmt.executeUpdate();
		}
		*/
		sql2 = "UPDATE vote_log SET gpro_id = ?;";
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		pstmt2.setString(1, ChangeData.getKibou_Id());
		pstmt2.executeUpdate();
		
		sql3 = "UPDATE expect_log SET gpro_id = ?;";
		PreparedStatement pstmt3 = con.prepareStatement(sql3);
		pstmt3.setString(1, ChangeData.getKibou_Id());
		pstmt3.executeUpdate();
			return false;
		}catch(SQLException e ){
			e.printStackTrace();
			return true;
			
		}finally{
			closeConnection(con);
		}
	}
}
