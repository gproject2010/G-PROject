package buppan;

public class ShopData {

	private String ShopId;//ショップID
	private String ShopPassword;//ショップパスワード
	private String ItemCategorry;//扱う商品のカテゴリ
	private String CompName;//法人名・屋号
	//担当者名
	private String ApplyName;//申込者名
	private String ApplyKana;//申込者名カナ
	private String RepresentName;//代表者名
	private String ChargeName;//ショップ担当者名
	private String Kaigyoubi;//開業年月日
	//所在地
	private String AddressNo;//郵便番号
	private String Pref;//都道府県名
	private String City;//市町村区郡
	private String Address;//町名・番地
	private String Tatemono;//建物・ビル名
	//連絡先
	private String Tel;//電話番号
	private String Fax;//FAX番号
	private String E_Mail;//Eメールアドレス
	
	//会社情報
	private String SyouGou;//商号(ショップ名)
	private String Syouhin;//販売予定商材
	private String Service;//サービス内容
	private String ShopPicture;//ショップの紹介写真へのパス
	private String ShopPr;//ショップの紹介文
	private String PagePass;//商品の紹介ページへのパス
	
	//ショップ用メールアドレス
	private String Toiawase;//お問い合わせ用メール
	private String SurpportTel;//サポートセンター電話番号
	
	public ShopData(){
	}
	
	public ShopData(String ShopId, String ShopPassword, String ItemCategorry, String CompName, String ApplyName, String ApplyKana, String RepresentName, String ChargeName,
			String AddressNo, String Pref, String City, String Address, String Tatemono, String Tel, String Fax, String E_Mail, String SyouGou, String Syouhin, String Service,
			String Toiawase, String SurpportTel, String PagePass, String ShopPicture){
		
		this.ShopId = ShopId;
		this.ShopPassword = ShopPassword;
		this.ItemCategorry = ItemCategorry;
		this.CompName = CompName;
		this.ApplyName = ApplyName;
		this.ApplyKana = ApplyKana;
		this.RepresentName = RepresentName;
		this.ChargeName = ChargeName;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.City = City;
		this.Address = Address;
		this.Tatemono = Tatemono;
		this.Tel = Tel;
		this.Fax = Fax;
		this.E_Mail = E_Mail;
		this.SyouGou = SyouGou;
		this.Syouhin = Syouhin;
		this.Service = Service;
		this.Toiawase = Toiawase;
		this.SurpportTel = SurpportTel;
		this.PagePass = PagePass;
		this.ShopPicture = ShopPicture;
	}

	public ShopData(String ShopId, String ItemCategorry, String CompName,
			String RepresentName, String ChargeName, String Addressno, String Pref,
			String City, String Address, String Tatemono, String SyouGou, String Syouhin, String Service,
			String Toiawase, String Surpporttel, String PagePass, String ShopPicture) {
		
		this.ItemCategorry = ItemCategorry;
		this.ShopPicture = ShopPicture;
		this.ShopId = ShopId;
		this.CompName = CompName;
		this.RepresentName = RepresentName;
		this.ChargeName = ChargeName;
		this.AddressNo = Addressno;
		this.Pref = Pref;
		this.City = City;
		this.Address = Address;
		this.Tatemono = Tatemono;
		this.SyouGou = SyouGou;
		this.Syouhin = Syouhin;
		this.Service = Service;
		this.Toiawase = Toiawase;
		this.SurpportTel = Surpporttel;
		this.PagePass = PagePass;
		
	}

	public ShopData(String ShopId, String ShopPicture, String SyouGou,  String PagePass, String ShopPr) {
		
		this.ShopId = ShopId;
		this.ShopPicture = ShopPicture;
		this.SyouGou = SyouGou;
		this.PagePass = PagePass;
		this.ShopPr = ShopPr;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ShopData(String ShopId, String ItemCategorry, 
			String ChargeName, String Pref, String SyouGou,
			String PagePass, String ShopPicture, String ShopPr) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.ShopId = ShopId;
		this.ItemCategorry = ItemCategorry;
		this.ChargeName = ChargeName;
		this.Pref = Pref;
		this.SyouGou = SyouGou;
		this.PagePass = PagePass;
		this.ShopPicture = ShopPicture;
		this.ShopPr = ShopPr;
	}

	public String getShopId() {return ShopId;}
	public void setShopId(String ShopId) {this.ShopId = ShopId;}

	public String getShopPassword() {return ShopPassword;}
	public void setShopPassword(String ShopPassword) {this.ShopPassword = ShopPassword;}

	public String getItemCategorry() {return ItemCategorry;}
	public void setItemCategorry(String ItemCategorry) {this.ItemCategorry = ItemCategorry;}

	public String getCompName() {return CompName;}
	public void setCompName(String CompName) {this.CompName = CompName;}

	public String getApplyName() {return ApplyName;}
	public void setApplyName(String ApplyName) {this.ApplyName = ApplyName;}

	public String getApplyKana() {return ApplyKana;}
	public void setApplyKana(String ApplyKana) {this.ApplyKana = ApplyKana;
	}

	public String getRepresentName() {return RepresentName;}
	public void setRepresentName(String RepresentName) {this.RepresentName = RepresentName;}

	public String getChargeName() {return ChargeName;}
	public void setChargeName(String ChargeName) {this.ChargeName = ChargeName;}

	public String getAddressNo() {return AddressNo;}
	public void setAddressNo(String AddressNo) {this.AddressNo = AddressNo;}

	public String getPref() {return Pref;}
	public void setPref(String Pref) {this.Pref = Pref;}

	public String getCity() {return City;}
	public void setCity(String City) {this.City = City;}

	public String getAddress() {return Address;}
	public void setAddress(String Address) {this.Address = Address;}

	public String getTatemono() {return Tatemono;}
	public void setTatemono(String Tatemono) {this.Tatemono = Tatemono;}

	public String getTel() {return Tel;}
	public void setTel(String Tel) {this.Tel = Tel;}

	public String getFax() {return Fax;}
	public void setFax(String Fax) {this.Fax = Fax;}

	public String getE_Mail() {return E_Mail;}
	public void setE_Mail(String E_Mail) {this.E_Mail = E_Mail;}

	public String getSyouGou() {return SyouGou;}
	public void setSyouGou(String SyouGou) {this.SyouGou = SyouGou;}

	public String getSyouhin() {return Syouhin;}
	public void setSyouhin(String Syouhin) {this.Syouhin = Syouhin;}

	public String getService() {return Service;}
	public void setService(String Service) {this.Service = Service;}

	public String getToiawase() {return Toiawase;}
	public void setToiawase(String Toiawase) {this.Toiawase = Toiawase;
	}

	public String getSurpportTel() {return SurpportTel;}
	public void setSurpportTel(String SurpportTel) {this.SurpportTel = SurpportTel;}

	public String getKaigyoubi() {return Kaigyoubi;}
	public void setKaigyoubi(String kaigyoubi) {this.Kaigyoubi = kaigyoubi;}

	public String getShopPicture() {return ShopPicture;}
	public void setShopPicture(String ShopPicture) {this.ShopPicture = ShopPicture;}

	public String getShopPr() {return ShopPr;}
	public void setShopPr(String shopPr) {this.ShopPr = shopPr;}

	public String getPagePass() {return PagePass;}
	public void setPagePass(String pagePass) {this.PagePass = pagePass;}
}
