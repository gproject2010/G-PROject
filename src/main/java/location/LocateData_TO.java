package location;

public class LocateData_TO {

	
	private String FreeFile_Name;
	private String Locate_Code;
	private String Locate_Name;
	private String Locate_Syubetsu;
	private String Address;
	private String TelNo;
	private String Eigyoujikan;
	private String Locate_HP;
	private String Parking;
	private String Cigar;
	private String BariaFree;
	private String Indoor_Shisetsu;
	private String Outdoor_Shisetsu;
	private String Games;
	private String Access;
	
	private String Platform;
	private String CardGame;
	private String OldGames;
	
	public LocateData_TO(String FreeFile_Name, String Locate_Name, String Address, String TelNo,
			String Eigyoujikan, String Locate_HP, String Parking, String Cigar, String BariaFree,
			String Indoor_Shisetsu, String Outdoor_Shisetsu, String Games, String Access) {
		this.FreeFile_Name = FreeFile_Name;
		this.Locate_Name = Locate_Name;
		this.Address = Address;
		this.TelNo = TelNo;
		this.Eigyoujikan = Eigyoujikan;
		this.Locate_HP = Locate_HP;
		this.Parking = Parking;
		this.Cigar = Cigar;
		this.BariaFree = BariaFree;
		this.Indoor_Shisetsu = Indoor_Shisetsu;
		this.Outdoor_Shisetsu = Outdoor_Shisetsu;
		this.Games = Games;
		this.Access = Access;
	}


	public LocateData_TO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public LocateData_TO(String Locate_Name, String Locate_Code, String Locate_Syubetsu) {
		this.Locate_Name = Locate_Name;
		this.Locate_Code = Locate_Code;
		this.Locate_Syubetsu = Locate_Syubetsu;
	}


	public LocateData_TO(String FreeFile_Name, String Locate_Name, String Address, String TelNo,
			String Eigyoujikan, String Locate_HP, String Parking, String Access, String Platform, String CardGame,
			String OldGames) {
		this.FreeFile_Name = FreeFile_Name;
		this.Locate_Name = Locate_Name;
		this.Address = Address;
		this.TelNo = TelNo;
		this.Eigyoujikan = Eigyoujikan;
		this.Locate_HP = Locate_HP;
		this.Parking = Parking;
		this.Access = Access;
		this.Platform = Platform;
		this.CardGame = CardGame;
		this.OldGames = OldGames;
	}


	public LocateData_TO(String FreeFile_Name, String Locate_Name, String Address, String TelNo,
			String Eigyoujikan, String Locate_HP, String Parking, String Access) {
		this.FreeFile_Name = FreeFile_Name;
		this.Locate_Name = Locate_Name;
		this.Address = Address;
		this.TelNo = TelNo;
		this.Eigyoujikan = Eigyoujikan;
		this.Locate_HP = Locate_HP;
		this.Parking = Parking;
		this.Access = Access;
	}


	public String getFreeFile_Name() {return FreeFile_Name;}
	public void setFreeFile_Name(String FreeFile_Name) {this.FreeFile_Name = FreeFile_Name;}


	public String getLocate_Code() {return Locate_Code;}
	public void setLocate_Code(String Locate_Code) {this.Locate_Code = Locate_Code;}


	public String getLocate_Syubetsu() {return Locate_Syubetsu;}
	public void setLocate_Syubetsu(String Locate_Syubetsu) {this.Locate_Syubetsu = Locate_Syubetsu;}


	public String getLocate_Name() {return Locate_Name;}
	public void setLocate_Name(String Locate_Name) {this.Locate_Name = Locate_Name;}


	public String getAddress() {return Address;}
	public void setAddress(String Address) {this.Address = Address;}


	public String getTelNo() {return TelNo;}
	public void setTelNo(String TelNo) {this.TelNo = TelNo;}


	public String getEigyoujikan() {return Eigyoujikan;}
	public void setEigyoujikan(String Eigyoujikan) {this.Eigyoujikan = Eigyoujikan;}


	public String getLocate_HP() {return Locate_HP;}
	public void setLocate_HP(String Locate_HP) {this.Locate_HP = Locate_HP;}


	public String getParking() {return Parking;}
	public void setParking(String Parking) {this.Parking = Parking;}


	public String getCigar() {return Cigar;}
	public void setCigar(String Cigar) {this.Cigar = Cigar;}


	public String getBariaFree() {return BariaFree;}
	public void setBariaFree(String BariaFree) {this.BariaFree = BariaFree;}


	public String getIndoor_Shisetsu() {return Indoor_Shisetsu;}
	public void setIndoor_Shisetsu(String Indoor_Shisetsu) {this.Indoor_Shisetsu = Indoor_Shisetsu;}


	public String getOutdoor_Shisetsu() {return Outdoor_Shisetsu;}
	public void setOutdoor_Shisetsu(String Outdoor_Shisetsu) {this.Outdoor_Shisetsu = Outdoor_Shisetsu;}


	public String getGames() {return Games;}
	public void setGames(String Games) {this.Games = Games;}


	public String getAccess() {return Access;}
	public void setAccess(String Access) {this.Access = Access;}


	public String getPlatform() {return Platform;}
	public void setPlatform(String Platform) {this.Platform = Platform;}


	public String getCardGame() {return CardGame;}
	public void setCardGame(String CardGame) {this.CardGame = CardGame;}


	public String getOldGames() {return OldGames;}
	public void setOldGames(String OldGames) {this.OldGames = OldGames;
	}
}
