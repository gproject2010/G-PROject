package coupon;

public class Coupon_Data_TO {

	private String Coupon_Code;
	private String League_Code;
	private String Coupon_Name;
	private String Coupon_From;
	private String Use_Limit;
	private double Repscore_Bonus;
	private double Actscore_Bonus;
	private int Star_Bonus;
	private String[] Syougou_List;
	private String Coupon_Jyoukyou;
	
	
	public Coupon_Data_TO(String CouponCode, String LeagueCode, String CouponName, String CouponFrom, String UseLimit,
			double RepscoreBonus, double ActscoreBonus, int StarBonus, String[] SyougouList, String CouponJyoukyou) {
		this.Coupon_Code = CouponCode;
		this.League_Code = LeagueCode;
		this.Coupon_Name = CouponName;
		this.Coupon_From = CouponFrom;
		this.Use_Limit = UseLimit;
		this.Repscore_Bonus = RepscoreBonus;
		this.Actscore_Bonus = ActscoreBonus;
		this.Star_Bonus = StarBonus;
		this.Syougou_List = SyougouList;
		this.Coupon_Jyoukyou = CouponJyoukyou;
	}
	
	public Coupon_Data_TO(){
		
	}

	public String getCoupon_Code() {return Coupon_Code;}
	public void setCoupon_Code(String Coupon_Code) {this.Coupon_Code = Coupon_Code;}

	public String getLeague_Code() {return League_Code;}
	public void setLeague_Code(String League_Code) {this.League_Code = League_Code;}

	public String getCoupon_Name() {return Coupon_Name;}
	public void setCoupon_Name(String Coupon_Name) {this.Coupon_Name = Coupon_Name;}

	public String getCoupon_From() {return Coupon_From;}
	public void setCoupon_From(String Coupon_From) {this.Coupon_From = Coupon_From;}

	public String getUse_Limit() {return Use_Limit;}
	public void setUse_Limit(String Use_Limit) {this.Use_Limit = Use_Limit;}

	public double getRepscore_Bonus() {return Repscore_Bonus;}
	public void setRepscore_Bonus(double Repscore_Bonus) {this.Repscore_Bonus = Repscore_Bonus;}

	public double getActscore_Bonus() {return Actscore_Bonus;}
	public void setActscore_Bonus(double Actscore_Bonus) {this.Actscore_Bonus = Actscore_Bonus;}

	public int getStar_Bonus() {return Star_Bonus;}
	public void setStar_Bonus(int Star_Bonus) {this.Star_Bonus = Star_Bonus;}

	public String[] getSyougou_List() {return Syougou_List;}
	public void setSyougou_List(String[] Syougou_List) {this.Syougou_List = Syougou_List;}

	public String getCoupon_Jyoukyou() {return Coupon_Jyoukyou;}
	public void setCoupon_Jyoukyou(String Coupon_Jyoukyou) {this.Coupon_Jyoukyou = Coupon_Jyoukyou;}
}
