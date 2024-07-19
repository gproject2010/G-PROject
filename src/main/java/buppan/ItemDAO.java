package buppan;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ItemDAO {

	private Connection createConnection(){
		try{
			
			InitialContext ic = new InitialContext();
			DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/malldata");
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
	
	public ArrayList<ItemData> ItemSyousai(String ShopId){//商品詳細を店舗IDをキーに検索
		ArrayList<ItemData> S_List = new ArrayList<ItemData>();
		
		Connection con = createConnection();
		
		try{
			String sql = "SELECT ShopId, syougou, picturename, itemid, itemcategorry, itemname, itemditail, insertpage, price, zaikosu FROM malldata.itemdata " + 
			"WHERE shopid = '" + ShopId + "' ;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Shopid = rs.getString("shopid");
				String Syougou = rs.getString("syougou");
				String PictureName = rs.getString("picturename");
				String Itemid = rs.getString("itemid");
				String Itemcategorry = rs.getString("itemcategorry");
				String Itemname = rs.getString("itemname");
				String ItemDitail = rs.getString("itemditail");
				String Insertpage = rs.getString("insertpage");
				int Price = rs.getInt("price");
				int Zaikosu = rs.getInt("zaikosu");
				
				ItemData I_List = new ItemData(Shopid, Syougou,  Itemid, Itemcategorry, Itemname, PictureName,  ItemDitail,  Insertpage, Price, Zaikosu);
				S_List.add(I_List);
			}
			
				rs.close();
				stmt.close();
				
				return S_List;
				
			}catch(SQLException ex){
				System.out.println("SQL failed");
				ex.printStackTrace();
			}finally{
				closeConnection(con);
			}
			return null;
		}
	
	public ItemData Sin_ItemSyousai(String ItemId){//商品の詳細を商品IDをキーに検索
		ItemData I_List = null;
		
		Connection con = createConnection();
		
		try{
			String sql = "SELECT ShopId, syougou, picturename, itemid, itemcategorry, itemname, itemditail, insertpage, price, zaikosu FROM malldata.itemdata " + 
			"WHERE shopid = '" + ItemId + "' ;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()){
				String Shopid = rs.getString("shopid");
				String Syougou = rs.getString("syougou");
				String PictureName = rs.getString("picturename");
				String Itemid = rs.getString("itemid");
				String Itemcategorry = rs.getString("itemcategorry");
				String Itemname = rs.getString("itemname");
				String ItemDitail = rs.getString("itemditail");
				String Insertpage = rs.getString("insertpage");
				int Price = rs.getInt("price");
				int Zaikosu = rs.getInt("zaikosu");
				
				I_List = new ItemData(Shopid, Syougou,  Itemid, Itemcategorry, Itemname, PictureName,  ItemDitail,  Insertpage, Price, Zaikosu);
			}
			
				rs.close();
				stmt.close();
				
				return I_List;
				
			}catch(SQLException ex){
				System.out.println("SQL failed");
				ex.printStackTrace();
			}finally{
				closeConnection(con);
			}
			return null;
		}
	public ArrayList<ItemData> ItemSarch(String ShopId, String ItemId, String ItemCategorry, String ItemName, int PriceMin, int PriceMax, int PageSt, int PageFin){
		ArrayList<ItemData> itemlist = new ArrayList<ItemData>();
		
		Connection con = createConnection();
		
		try{
			String sql = "SELECT shopid, syougou, itemid, itemcategorry, itemname, insertpage, itemditail, picturename, price, zaikosu FROM malldata.itemdata " + 
			"WHERE (shopid = '" + ShopId + "' OR '" + ShopId + "' = '*') AND (itemid = '" + ItemId + "' OR '" + ItemId + "' = '*')" + 
			" AND (itemcategorry = '" + ItemCategorry + "' OR '" + ItemCategorry + "' = '*')" + 
			" AND (itemname LIKE '%" + ItemName + "%' OR '" + ItemName + "' = '*') AND (price BETWEEN " + PriceMin + " AND " + PriceMax + ")" + 
			" ORDER BY shopid DESC LIMIT " + PageSt + " , " + PageFin + " ;";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Shopid = rs.getString("shopid");
				String Syougou = rs.getString("syougou");
				String Itemid = rs.getString("itemid");
				String Itemcategorry = rs.getString("itemcategorry");
				String Itemname = rs.getString("itemname");
				String Insertpage = rs.getString("insertpage");
				String Itemditail = rs.getString("itemditail");
				String Picturename = rs.getString("picturename");
				int Price = rs.getInt("price");
				int Zaikosu = rs.getInt("zaikosu");		
				
				ItemData I_Data = new ItemData(Shopid, Syougou,Itemid, Itemcategorry, Itemname, Insertpage, Itemditail, Picturename, Price, Zaikosu );
				itemlist.add(I_Data);
			}
			rs.close();
			stmt.close();
			
			return itemlist;
		}catch(SQLException ex){
			System.out.println("SQL failed");
			ex.printStackTrace();
		}finally{
			closeConnection(con);
		}
		return null;
	}
	public ArrayList<ItemData> Osusume(){
		ArrayList<ItemData>Susume = new ArrayList<ItemData>();
		
		Connection con = createConnection();
		
		try{
			String sql = "SELECT shopid, syougou, itemid, itemcategorry, itemname, insertpage, itemditail, picturename, price, zaikosu FROM malldata.itemdata WHERE osusumeflg = 1;";
			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Shopid = rs.getString("shopid");
				String Syougou = rs.getString("syougou");
				String ItemId = rs.getString("itemid");
				String ItemCategorry = rs.getString("itemcategorry");
				String Itemname = rs.getString("itemname");
				String PictureName = rs.getString("picturename");
				String Insertpage = rs.getString("insertpage");
				String Itemditail = rs.getString("itemditail");
				
				int Price = rs.getInt("price");
				int Zaikosu = rs.getInt("zaikosu");
				
				ItemData O_Data = new ItemData(Shopid, Syougou, ItemId, ItemCategorry, Itemname, PictureName, Itemditail, Insertpage,   Price, Zaikosu);
				Susume.add(O_Data);
			}rs.close();
			stmt.close();
			
			return Susume;
		}catch(SQLException ex){
			System.out.println("SQL failed");
			ex.printStackTrace();
		}finally{
			closeConnection(con);
		}
		return null;
	}
	
	public ArrayList<ItemData> Order_Rank(){
		ArrayList<ItemData> Result = new ArrayList<ItemData>();
		
		String[] Categorry = new String[5];
		Categorry[0] = "同人誌";
		Categorry[1] = "オリジナル単行本";
		Categorry[2] = "インディーズゲーム";
		Categorry[3] = "攻略本・ファンブック";
		Categorry[4] = "オリジナルサウンド";
		
Connection con = createConnection();
		
		try{
			for(int i=0; i < Categorry.length; i++){
			String sql = "SELECT shopid, syougou, itemid, itemcategorry, itemname, insertpage, picturename, price, ordercount FROM malldata.itemdata WHERE itemcategorry = '" + Categorry + "' ORDER BY ordercount DESC LIMIT 3;";

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()){
				String Shopid = rs.getString("shopid");
				String Syougou = rs.getString("syougou");
				String ItemId = rs.getString("itemid");
				String ItemCategorry = rs.getString("itemcategorry");
				String Itemname = rs.getString("itemname");
				String InsertPage = rs.getString("insertpage");
				String PictureName = rs.getString("picturename");
				int Price = rs.getInt("price");
				int OrderCount = rs.getInt("ordercount");
				
				ItemData R_Data = new ItemData(Shopid, Syougou, ItemId, ItemCategorry, Itemname, InsertPage, PictureName, Price, OrderCount);
				Result.add(R_Data);
			}
			}
			return Result;
		}catch(SQLException ex){
			System.out.println("SQL failed");
			ex.printStackTrace();
		}finally{
			closeConnection(con);
		}
		return null;
	}
}
