package location;

import java.util.Calendar;

public class RaitenData_TO {

	private String GPRO_ID;
	private String Player_Name;
	private String Area;
	private String Shop_Code;
	private String Shop_Name;
	private String City;
	private String Login_Date;
	private String Logout_Date;
	private Calendar Now;
	
	public RaitenData_TO(){
		
	}
	
	public RaitenData_TO(String GPRO_ID, String Player_Name, String Area, String Shop_Code, String Shop_Name,
			String City, String Login_Date, String Logout_Date, Calendar Now) {
		this.GPRO_ID = GPRO_ID;
		this.Player_Name = Player_Name;
		this.Area = Area;
		this.Shop_Code = Shop_Code;
		this.Shop_Name = Shop_Name;
		this.City = City;
		this.Login_Date = Login_Date;
		this.Logout_Date = Logout_Date;
		this.Now = Now;
	}

	public String getGPRO_ID() {return GPRO_ID;}
	public void setGPRO_ID(String GPRO_ID) {this.GPRO_ID = GPRO_ID;}

	public String getPlayer_Name() {return Player_Name;}
	public void setPlayer_Name(String Player_Name) {this.Player_Name = Player_Name;}

	public String getArea() {return Area;}
	public void setArea(String Area) {this.Area = Area;}

	public String getShop_Code() {return Shop_Code;}
	public void setShop_Code(String Shop_Code) {this.Shop_Code = Shop_Code;}

	public String getShop_Name() {return Shop_Name;}
	public void setShop_Name(String Shop_Name) {this.Shop_Name = Shop_Name;}

	public String getCity() {return City;}
	public void setCity(String City) {this.City = City;}

	public String getLogin_Date() {return Login_Date;}
	public void setLogin_Date(String Login_Date) {this.Login_Date = Login_Date;}

	public String getLogout_Date() {return Logout_Date;}
	public void setLogout_Date(String Logout_Date) {this.Logout_Date = Logout_Date;}

	public Calendar getNow() {return Now;}
	public void setNow(Calendar Now) {this.Now = Now;}

}
