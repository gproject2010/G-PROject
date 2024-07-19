package gpro_ron;

import java.util.Calendar;

public class GRon_Data_TO {

	private String Keijiban_Code;//掲示板コード
	private String Gidai;//議題
	private String KaisetsuNichiji;//掲示板の開設日時
	private String ShimekiriNichiji;//書き込み・投票の締切日時
	private Calendar Up_Nichiji;//開設候補のアップロード日時
	private String Kaisetsukikan;//開設候補の希望開設期間
	private String Kaisetsusya;
	private String Kaisetsusya_ID;
	private String First_Write;
	private int TotalRespCount;
	
	private String JyoukenSyubetsu;
	private int PlayerLv_Min;
	private int PlayerLv_Max;
	private String Sc_Syubetsu;//集計範囲(累計、今月、先月など)
	private double Sc_Min;//対象スコア下限
	private String RankJyouken;//ランキングの種別(レポートスコア、アクションスコアなど)
	private int Rank_Min;
	private String Sex;
	
	private int KakikomiKaisu;
	private int TouhyouKaisu;
	private int KakikomiJyougen;
	private int TouhyouJyougen;
	
	private int Henshin_Lv;
	private int Kakikomi_No;
	private int Origin_Youso;
	private String Kijyutsusya_Name;
	private String Kijyutsusya_ID;
	private int Kijyutsusya_Lv;
	private String KakikomiNichiji;
	private String Kakikomi_Honbun;
	private int Shijisyasu;
	private int Fushijisyasu;
	private int Henshinsu;
	
	private int Origin_No;
	private String Command;
	private int Saikoubi;
	
	private boolean KakikomiKahi;
	private boolean TouhyouKahi;
	
	private boolean NoData;
	private boolean NGHit;
	private boolean SelectError;
	private boolean WrongMojisu;
	private String NGWord;
	
	private boolean NotEmpty_Lv1;
	private boolean NotEmpty_Lv2;
	private boolean NotEmpty_Lv3;
	
	
	public GRon_Data_TO(String Keijiban_Code, String Gidai,
			String KaisetsuNichiji, String ShimekiriNichiji, String Kaisetsusya, String Kaisetsusya_ID, String First_Write, int TotalRespCount,
			String JyoukenSyubetsu, int PlayerLv_Min, int PlayerLv_Max,
			String Sc_Syubetsu, double Sc_Min, String RankJyouken, int Rank_Min,
			int KakikomiJyougen, int TouhyouJyougen, String Sex) {
		
		this.Keijiban_Code = Keijiban_Code;
		this.Gidai = Gidai;
		this.KaisetsuNichiji = KaisetsuNichiji;
		this.ShimekiriNichiji = ShimekiriNichiji;
		this.Kaisetsusya = Kaisetsusya;
		this.Kaisetsusya_ID = Kaisetsusya_ID;
		this.First_Write = First_Write;
		this.TotalRespCount = TotalRespCount;
		this.JyoukenSyubetsu = JyoukenSyubetsu;
		this.PlayerLv_Min = PlayerLv_Min;
		this.PlayerLv_Max = PlayerLv_Max;
		this.Sc_Syubetsu = Sc_Syubetsu;
		this.Sc_Min = Sc_Min;
		this.RankJyouken = RankJyouken;
		this.Rank_Min = Rank_Min;
		this.KakikomiJyougen = KakikomiJyougen;
		this.TouhyouJyougen = TouhyouJyougen;
		this.Sex = Sex;
	}

	public GRon_Data_TO(String KeijiCode, int Henshin_Lv, int KakikomiNo, int Origin_Youso,
			String Kijyutsusya_Name, String Kijyutsusya_ID, int Kijyutsusya_Lv,
			String KakikomiNichiji, String Kakikomi_Honbun, int Shijisyasu, int Fushijisyasu,
			int Henshinsu, int KakikomiKaisu, int TouhyouKaisu, int KakikomiJyougen, int TouhyouJyougen, int Saikoubi) {
		
		this.Keijiban_Code = KeijiCode;
		this.Henshin_Lv = Henshin_Lv;
		this.Kakikomi_No = KakikomiNo;
		this.Origin_Youso = Origin_Youso;
		this.Kijyutsusya_ID = Kijyutsusya_ID;
		this.Kijyutsusya_Name = Kijyutsusya_Name;
		this.Kijyutsusya_Lv = Kijyutsusya_Lv;
		this.KakikomiNichiji = KakikomiNichiji;
		this.Kakikomi_Honbun = Kakikomi_Honbun;
		this.Shijisyasu = Shijisyasu;
		this.Fushijisyasu = Fushijisyasu;
		this.Henshinsu = Henshinsu;
		this.KakikomiKaisu = KakikomiKaisu;
		this.TouhyouKaisu = TouhyouKaisu;
		this.KakikomiJyougen = KakikomiJyougen;
		this.TouhyouJyougen = TouhyouJyougen;
		this.Saikoubi = Saikoubi;
	}
	
	public GRon_Data_TO(String KeijiCode, int Henshin_Lv, int KakikomiNo, int Origin_Youso,
			String Kijyutsusya_Name, String Kijyutsusya_ID, int Kijyutsusya_Lv,
			String kakikomiNichiji_S, String Kakikomi_Honbun, int Shijisyasu, int Fushijisyasu,
			int Henshinsu, int KakikomiKaisu, int TouhyouKaisu, int KakikomiJyougen, int TouhyouJyougen) {
		
		this.Keijiban_Code = KeijiCode;
		this.Henshin_Lv = Henshin_Lv;
		this.Kakikomi_No = KakikomiNo;
		this.Origin_Youso = Origin_Youso;
		this.Kijyutsusya_Name = Kijyutsusya_Name;
		this.Kijyutsusya_ID = Kijyutsusya_ID;
		this.Kijyutsusya_Lv = Kijyutsusya_Lv;
		this.KakikomiNichiji = kakikomiNichiji_S;
		this.Kakikomi_Honbun = Kakikomi_Honbun;
		this.Shijisyasu = Shijisyasu;
		this.Fushijisyasu = Fushijisyasu;
		this.Henshinsu = Henshinsu;
		this.KakikomiKaisu = KakikomiKaisu;
		this.TouhyouKaisu = TouhyouKaisu;
		this.KakikomiJyougen = KakikomiJyougen;
		this.TouhyouJyougen = TouhyouJyougen;
	}


	public GRon_Data_TO(boolean KakikomiKahi, boolean TouhyouKahi, boolean NotEmpty_Lv1, boolean NotEmpty_Lv2, boolean NotEmpty_Lv3) {
		this.KakikomiKahi = KakikomiKahi;
		this.TouhyouKahi = TouhyouKahi;
		this.NotEmpty_Lv1 = NotEmpty_Lv1;
		this.NotEmpty_Lv2 = NotEmpty_Lv2;
		this.NotEmpty_Lv3 = NotEmpty_Lv3;
	}

	public GRon_Data_TO(String Gidai, Calendar Up_Nichiji,
			String KaisetsuKikan, String Kaisetsusya, String Kaisetsusya_ID, String First_Write,
			String JyoukenSyubetsu, int PLv_Min, int PLv_Max, String Sc_Syubetsu,
			double Sc_Min, String RankJyouken, int Rank_Min, String Sex, int KakikomiJyougen,
			boolean NoData, String NGWord, boolean SelectError, boolean WrongMojisu) {
		
		this.Gidai = Gidai;
		this.Up_Nichiji = Up_Nichiji;
		this.Kaisetsukikan = KaisetsuKikan;
		this.Kaisetsusya = Kaisetsusya;
		this.Kaisetsusya_ID = Kaisetsusya_ID;
		this.First_Write = First_Write;
		this.JyoukenSyubetsu = JyoukenSyubetsu;
		this.PlayerLv_Min = PLv_Min;
		this.PlayerLv_Max = PLv_Max;
		this.Sc_Syubetsu = Sc_Syubetsu;
		this.Sc_Min = Sc_Min;
		this.RankJyouken = RankJyouken;
		this.Rank_Min = Rank_Min;
		this.Sex = Sex;
		this.KakikomiJyougen = KakikomiJyougen;
		this.NoData = NoData;
		this.NGWord = NGWord;
		this.SelectError = SelectError;
		this.WrongMojisu = WrongMojisu;
	}

	public GRon_Data_TO(int Origin_No, String Command) {
		this.Origin_No = Origin_No;
		this.Command = Command;
	}
	
	public GRon_Data_TO(){
	
	}
	public GRon_Data_TO(String Keijiban_Code, String Gidai, String ShimekiriNichiji, String First_Write) {
		this.Keijiban_Code = Keijiban_Code;
		this.Gidai = Gidai;
		this.ShimekiriNichiji = ShimekiriNichiji;
		this.First_Write = First_Write;
	}

	public String getKeijiban_Code() {return Keijiban_Code;}
	public void setKeijiban_Code(String Keijiban_Code) {this.Keijiban_Code = Keijiban_Code;}

	public String getGidai() {return Gidai;}
	public void setGidai(String Gidai) {this.Gidai = Gidai;}

	public String getKaisetsuNichiji() {return KaisetsuNichiji;}
	public void setKaisetsuNichiji(String KaisetuNichiji) {this.KaisetsuNichiji = KaisetuNichiji;}

	public String getShimekiriNichiji() {return ShimekiriNichiji;}
	public void setShimekiriNichiji(String ShimekiriNichiji) {this.ShimekiriNichiji = ShimekiriNichiji;}

	public Calendar getUp_Nichiji() {return Up_Nichiji;}
	public void setUp_Nichiji(Calendar Up_Nichiji) {this.Up_Nichiji = Up_Nichiji;}

	public String getKaisetsukikan() {return Kaisetsukikan;}
	public void setKaisetsukikan(String Kaisetsukikan) {this.Kaisetsukikan = Kaisetsukikan;}

	public String getKaisetsusya() {return Kaisetsusya;}
	public void setKaisetsusya(String Kaisetsusya) {this.Kaisetsusya = Kaisetsusya;}

	public String getKaisetsusya_ID() {return Kaisetsusya_ID;}
	public void setKaisetsusya_ID(String Kaisetsusya_ID) {this.Kaisetsusya_ID = Kaisetsusya_ID;}

	public String getFirst_Write() {return First_Write;}
	public void setFirst_Write(String First_Write) {this.First_Write = First_Write;}

	public int getTotalRespCount() {return TotalRespCount;}
	public void setTotalRespCount(int TotalRespCount) {this.TotalRespCount = TotalRespCount;}

	public String getJyoukenSyubetsu() {return JyoukenSyubetsu;}
	public void setJyoukenSyubetsu(String JyoukenSyubetsu) {this.JyoukenSyubetsu = JyoukenSyubetsu;}

	public int getPlayerLv_Min() {return PlayerLv_Min;}
	public void setPlayerLv_Min(int PlayerLv_Min) {this.PlayerLv_Min = PlayerLv_Min;}

	public int getPlayerLv_Max() {return PlayerLv_Max;}
	public void setPlayerLv_Max(int PlayerLv_Max) {this.PlayerLv_Max = PlayerLv_Max;}

	public String getSc_Syubetsu() {return Sc_Syubetsu;}
	public void setSc_Syubetsu(String Sc_Syubetsu) {this.Sc_Syubetsu = Sc_Syubetsu;}

	public double getSc_Min() {return Sc_Min;}
	public void setSc_Min(double Sc_Min) {this.Sc_Min = Sc_Min;}

	public String getRankJyouken() {return RankJyouken;}
	public void setRankJyouken(String RankJyouken) {this.RankJyouken = RankJyouken;}

	public int getRank_Min() {return Rank_Min;}
	public void setRank_Min(int Rank_Min) {this.Rank_Min = Rank_Min;}

	public int getKakikomiKaisu() {return KakikomiKaisu;}
	public void setKakikomiKaisu(int KakikomiKaisu) {this.KakikomiKaisu = KakikomiKaisu;}

	public int getTouhyouKaisu() {return TouhyouKaisu;}
	public void setTouhyouKaisu(int TouhyouKaisu) {this.TouhyouKaisu = TouhyouKaisu;}

	public int getKakikomiJyougen() {return KakikomiJyougen;}
	public void setKakikomiJyougen(int KakikomiJyougen) {this.KakikomiJyougen = KakikomiJyougen;}

	public int getTouhyouJyougen() {return TouhyouJyougen;}
	public void setTouhyouJyougen(int TouhyouJyougen) {this.TouhyouJyougen = TouhyouJyougen;}

	public String getSex() {return Sex;}
	public void setSex(String Sex) {this.Sex = Sex;}

	public int getSaikoubi() {return Saikoubi;}
	public void setSaikoubi(int Saikoubi) {this.Saikoubi = Saikoubi;}

	public int getHenshin_Lv() {return Henshin_Lv;}
	public void setHenshin_Lv(int Henshin_Lv) {this.Henshin_Lv = Henshin_Lv;}

	public int getKakikomi_No() {return Kakikomi_No;}
	public void setKakikomi_No(int Kakikomi_No) {this.Kakikomi_No = Kakikomi_No;}

	public int getOrigin_Youso() {return Origin_Youso;}
	public void setOrigin_Youso(int Origin_Youso) {this.Origin_Youso = Origin_Youso;}

	public String getKijyutsusya_Name() {return Kijyutsusya_Name;}
	public void setKijyutsusya_Name(String Kijyutsusya_Name) {this.Kijyutsusya_Name = Kijyutsusya_Name;}

	public String getKijyutsusya_ID() {return Kijyutsusya_ID;}
	public void setKijyutsusya_ID(String Kijyutsusya_ID) {this.Kijyutsusya_ID = Kijyutsusya_ID;}

	public int getKijyutsusya_Lv() {return Kijyutsusya_Lv;}
	public void setKijyutsusya_Lv(int Kijyutsusya_Lv) {this.Kijyutsusya_Lv = Kijyutsusya_Lv;}

	public String getKakikomiNichiji() {return KakikomiNichiji;}
	public void setKakikomiNichiji(String KakikomiNichiji) {this.KakikomiNichiji = KakikomiNichiji;}

	public String getKakikomi_Honbun() {return Kakikomi_Honbun;}
	public void setKakikomi_Honbun(String Kakikomi_Honbun) {this.Kakikomi_Honbun = Kakikomi_Honbun;}

	public int getShijisyasu() {return Shijisyasu;}
	public void setShijisyasu(int Shijisyasu) {this.Shijisyasu = Shijisyasu;}

	public int getFushijisyasu() {return Fushijisyasu;}
	public void setFushijisyasu(int Fushijisyasu) {this.Fushijisyasu = Fushijisyasu;}

	public int getHenshinsu() {return Henshinsu;}
	public void setHenshinsu(int Henshinsu) {this.Henshinsu = Henshinsu;}

	public boolean isKakikomiKahi() {return KakikomiKahi;}
	public void setKakikomiKahi(boolean Kakikomi_Kahi) {this.KakikomiKahi = Kakikomi_Kahi;}

	public boolean isTouhyouKahi() {return TouhyouKahi;}
	public void setTouhyouKahi(boolean Touhyou_Kahi) {this.TouhyouKahi = Touhyou_Kahi;}

	public boolean isNoData() {return NoData;}
	public void setNoData(boolean NoData) {this.NoData = NoData;}

	public boolean isNGHit() {return NGHit;}
	public void setNGHit(boolean NGHit) {this.NGHit = NGHit;}

	public String getNGWord() {return NGWord;}
	public void setNGWord(String NGWord) {this.NGWord = NGWord;}

	public boolean isSelectError() {return SelectError;}
	public void setSelectError(boolean SelectError) {this.SelectError = SelectError;}

	public boolean isWrongMojisu() {return WrongMojisu;}
	public void setWrongMojisu(boolean WrongMojisu) {this.WrongMojisu = WrongMojisu;}

	public boolean isNotEmpty_Lv1() {return NotEmpty_Lv1;}
	public void setNotEmpty_Lv1(boolean NotEmpty_Lv1) {this.NotEmpty_Lv1 = NotEmpty_Lv1;}

	public boolean isNotEmpty_Lv2() {return NotEmpty_Lv2;}
	public void setNotEmpty_Lv2(boolean NotEmpty_Lv2) {this.NotEmpty_Lv2 = NotEmpty_Lv2;}

	public boolean isNotEmpty_Lv3() {return NotEmpty_Lv3;}
	public void setNotEmpty_Lv3(boolean NotEmpty_Lv3) {this.NotEmpty_Lv3 = NotEmpty_Lv3;}

	public int getOrigin_No() {return Origin_No;}
	public void setOrigin_No(int Origin_No) {this.Origin_No = Origin_No;}

	public String getCommand() {return Command;}
	public void setCommand(String Command) {this.Command = Command;}
}
