package buppan;

public class ItemData {

	private String ShopId;
	private String Syougou;//ショップID（ShopDataと共通）
	private String ItemId;//商品ID
	private String ItemCategorry;//商品のカテゴリ（ジャンル）
	private String ItemName;//商品名
	private String InsertPage;//挿入する紹介ページへのパス
	private String ItemDitail;//商品説明
	private String PictureName;//商品写真データへのパス
	private int Price;//商品の価格
	private int Zaikosu;//商品の在庫数
	private int OrderCount;//商品の注文数(先月)
	
	public ItemData(){
	}
	
	public ItemData(String ShopId, String Syougou, String ItemId, String ItemCategorry,String ItemName, String PictureName, String ItemDitail, String InsertPage, int Price, int Zaikosu){
		
		this.ItemId = ItemId;
		this.ItemCategorry = ItemCategorry;
		this.ShopId = ShopId;
		this.Syougou = Syougou;
		this.PictureName = PictureName;
		this.ItemName = ItemName;
		this.ItemDitail = ItemDitail;
		this.InsertPage = InsertPage;
		this.Price = Price;
		this.Zaikosu = Zaikosu;
		
	}


	public ItemData(String Shopid, String Syougou, String ItemId, String ItemCategorry, String Itemname,
			String InsertPage, String PictureName, int Price, int OrderCount) {
		this.ShopId = Shopid;
		this.Syougou = Syougou;
		this.ItemId = ItemId;
		this.ItemCategorry = ItemCategorry;
		this.ItemName = Itemname;
		this.InsertPage = InsertPage;
		this.PictureName = PictureName;
		this.Price = Price;
		this.OrderCount = OrderCount;
	}

	public String getShopId() {return ShopId;}
	public void setShopId(String ShopId) {this.ShopId = ShopId;}

	public String getItemId() {return ItemId;}
	public void setItemId(String ItemId) {this.ItemId = ItemId;}
	
	public String getSyougou() {return Syougou;}
	public void setSyougou(String Syougou) {this.Syougou = Syougou;}

	public String getItemCategorry() {return ItemCategorry;}
	public void setItemCategorry(String ItemCategorry) {this.ItemCategorry = ItemCategorry;}

	public String getItemName() {return ItemName;}
	public void setItemName(String ItemName) {this.ItemName = ItemName;}

	public String getInsertPage() {return InsertPage;}
	public void setInsertPage(String InsertPage) {this.InsertPage = InsertPage;}
	
	public String getItemDitail() {return ItemDitail;}
	public void setItemDitail(String ItemDitail) {this.ItemDitail = ItemDitail;}

	public String getPictureName() {return PictureName;}
	public void setPictureName(String PictureName) {this.PictureName = PictureName;}

	public int getPrice() {return Price;}
	public void setPrice(int Price) {this.Price = Price;}

	public int getZaikosu() {return Zaikosu;}
	public void setZaikosu(int Zaikosu) {this.Zaikosu = Zaikosu;}

	public int getOrderCount() {return OrderCount;}
	public void setOrderCount(int OrderCount) {this.OrderCount = OrderCount;}
	
}
