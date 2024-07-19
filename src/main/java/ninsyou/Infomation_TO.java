package ninsyou;

public class Infomation_TO {

	
	private String InfoCode;
	private String Info_Syubetsu;
	private String KeisaiDate;
	private String TeiseiDate;
	private String Hassinmoto;
	private String Kenmei;
	private String Honbun_Address;
	
	private String Kanrisya;
	private String URL;
	private int Link_Syubetsu;
	private String ImageURL;
	
	public Infomation_TO(String InfoCode, String Info_Syubetsu, String KeisaiDate, String Kenmei) {
		this.InfoCode = InfoCode;
		this.Info_Syubetsu = Info_Syubetsu;
		this.KeisaiDate = KeisaiDate;
		this.Kenmei = Kenmei;
	}
	
	public Infomation_TO(String InfoCode, String Info_Syubetsu, String KeisaiDate, String TeiseiDate, String Hassinmoto, String Kenmei, String Honbun_Address) {
		this.InfoCode = InfoCode;
		this.Info_Syubetsu = Info_Syubetsu;
		this.KeisaiDate = KeisaiDate;
		this.TeiseiDate = TeiseiDate;
		this.Hassinmoto = Hassinmoto;
		this.Kenmei = Kenmei;
		this.Honbun_Address = Honbun_Address;
	}

	public Infomation_TO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public Infomation_TO(String Kanrisya, String URL, int Link_Syubetsu, String ImageURL) {
		this.Kanrisya = Kanrisya;
		this.URL = URL;
		this.Link_Syubetsu = Link_Syubetsu;
		this.ImageURL = ImageURL;
	}

	public String getInfoCode() {return InfoCode;}
	public void setInfoCode(String InfoCode) {this.InfoCode = InfoCode;}

	public String getInfo_Syubetsu() {return Info_Syubetsu;}
	public void setInfo_Syubetsu(String Info_Syubetsu) {this.Info_Syubetsu = Info_Syubetsu;}

	public String getKeisaiDate() {return KeisaiDate;}
	public void setKeisaiDate(String KeisaiDate) {this.KeisaiDate = KeisaiDate;}

	public String getTeiseiDate() {return TeiseiDate;}
	public void setTeiseiDate(String TeiseiDate) {this.TeiseiDate = TeiseiDate;}

	public String getHassinmoto() {return Hassinmoto;}
	public void setHassinmoto(String Hassinmoto) {this.Hassinmoto = Hassinmoto;}

	public String getKenmei() {return Kenmei;}
	public void setKenmei(String Kenmei) {this.Kenmei = Kenmei;}

	public String getHonbun_Address() {return Honbun_Address;}
	public void setHonbun_Address(String Info_Honbun) {this.Honbun_Address = Info_Honbun;}

	
	public String getKanrisya() {return Kanrisya;}
	public void setKanrisya(String Kanrisya) {this.Kanrisya = Kanrisya;}

	public String getURL() {return URL;}
	public void setURL(String URL) {this.URL = URL;}

	public int getLink_Syubetsu() {return Link_Syubetsu;}
	public void setLink_Syubetsu(int Link_Syubetsu) {this.Link_Syubetsu = Link_Syubetsu;}

	public String getImageURL() {return ImageURL;}
	public void setImageURL(String ImageURL) {this.ImageURL = ImageURL;}
}
