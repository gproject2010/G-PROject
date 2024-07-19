package buppan;

import java.sql.*;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.util.ArrayList;

public class ShopDAO {
	
	private final static String resourceName = "jdbc/malldata";

	private Connection createConnection(){
		try{
			
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/"+resourceName);
			Connection con = ds.getConnection();
			return con;
			
		}catch(SQLException ex){
			System.out.println("SQL failed");
			ex.printStackTrace();
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
	
	private void closeConnection(Connection con){
		try{
			con.close();
		}catch(Exception ex){
			
		}
	}
	
	public ArrayList<ShopData> ShopSarch(String Shopid, String Itemcategorry, String Syougou, String Representname, String Chargename, String pref, String Syouhin, String Toiawase, String SurpportTel, int Pagest, int Pagefin){
		ArrayList<ShopData> shoplist = new ArrayList<ShopData>();
		
		Connection con = null;
		try{
			con = createConnection();
			String sql = "SELECT DISTINCT shopid, itemcategorry, chargename, pref, syougou, pagepass, shoppicture, shoppr FROM malldata.shopdata " + 
				"WHERE (shopid = '" + Shopid + "' OR '" + Shopid + "' = '*') AND (itemcategorry = '" + Itemcategorry + "' OR '" + Itemcategorry + "' = '*') AND (syougou LIKE '%" + Syougou + "%' OR '" + Syougou + "' = '*') " + 
				" AND (representname = '" + Representname + "' OR '" + Representname + "' = '*') AND (chargename = '" + Chargename + "' OR '" + Chargename + "' = '*') AND (pref = '" + pref + "' OR '" + pref + "' = '*') " + 
				" AND (syouhin = '" + Syouhin + "' OR '" + Syouhin + "' = '*') AND (toiawase = '" + Toiawase + "' OR '" + Toiawase + "' = '*') AND (surpporttel = '" + SurpportTel + "' OR '" + SurpportTel + "' = '*') " + 
				" ORDER BY shopid DESC LIMIT " + Pagest + " , " + Pagefin + " ;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String ShopId = rs.getString("shopid");
				String ItemCategorry = rs.getString("itemcategorry");
				String ChargeName = rs.getString("chargename");
				String Pref = rs.getString("pref");
				String SyouGou = rs.getString("syougou");
				String PagePass = rs.getString("pagepass");
				String ShopPicture = rs.getString("shoppicture");
				String ShopPr = rs.getString("shoppr");
				ShopData S_Data = new ShopData(ShopId, ItemCategorry, ChargeName, Pref, SyouGou, PagePass, ShopPicture, ShopPr);
				shoplist.add(S_Data);
			}
			
			rs.close();
			stmt.close();
			
			return shoplist;
			
		}catch(SQLException ex){
			System.out.println("SQL failed");
			ex.printStackTrace();
		}finally{
			closeConnection(con);
		}
		return null;
	}
	
	public ShopData ShopSyousaiSarch(String ShopId){
		ShopData S_data = null;
		
		Connection con = createConnection();
		try{
			String sql = "SELECT shopid, itemcategorry, compname, representname, chargename, addressno, pref, city, address, tatemono, syougou, syouhin, service, toiawase, surpporttel, annaijyusyo, pagepass, shoppicture FROM malldata.shopdata " + 
				"WHERE shopid = '" + ShopId + "';";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Shopid = rs.getString("shopid");
				String Itemcategorry = rs.getString("itemcategorry");
				String Compname = rs.getString("compname");
				String Representname = rs.getString("representname");
				String Chargename = rs.getString("chargename");
				String Addressno = rs.getString("addressno");
				String Pref = rs.getString("pref");
				String City = rs.getString("city");
				String Address = rs.getString("address");
				String Tatemono = rs.getString("tatemono");
				String Syougou = rs.getString("syougou");
				String Syouhin = rs.getString("syouhin");
				String Service = rs.getString("service");
				String Toiawase = rs.getString("toiawase");
				String Surpporttel = rs.getString("Surpporttel");
				String PagePass = rs.getString("pagepass");
				String ShopPicture = rs.getString("shoppicture");
				S_data = new ShopData(Shopid, Itemcategorry, Compname, Representname, Chargename, Addressno, Pref, City, Address, Tatemono, Syougou, Syouhin, Service, Toiawase, Surpporttel, PagePass, ShopPicture);
				
			}
			
			rs.close();
			stmt.close();
			
			return S_data;
			
		}catch(SQLException ex){
			System.out.println("SQL failed");
			ex.printStackTrace();
		}finally{
			closeConnection(con);
		}
		return null;
	}
	public ArrayList<ShopData> NewShops(){
		ArrayList<ShopData> NewShopList = new ArrayList<ShopData>();
		
		Connection con = createConnection();
		
		try{
			String sql = "SELECT shopid, syougou, shoppicture, pagepass, shoppr FROM malldata.shopdata WHERE kaigyoubi <= (SELECT DATE_ADD(current_date, interval 30 day));";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String ShopId = rs.getString("shopid");
				String ShopPicture = rs.getString("shoppicture");
				String SyouGou = rs.getString("syougou");
				String PagePass = rs.getString("pagepass");
				String ShopPr = rs.getString("shoppr");
				ShopData NewShop = new ShopData(ShopId, ShopPicture, SyouGou, PagePass, ShopPr);
				NewShopList.add(NewShop);
			}
			rs.close();
			stmt.close();
			
			return NewShopList;
			
			}catch(SQLException ex){
				System.out.println("SQL failed");
				ex.printStackTrace();
			}finally{
				closeConnection(con);
			}
			return null;
	}
}