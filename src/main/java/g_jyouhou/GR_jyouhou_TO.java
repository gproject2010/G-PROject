package g_jyouhou;

public class GR_jyouhou_TO {

	private String PlatForm;
	private int MakerCode;
	private String MakerName;
	private String GameCode;
	private String GameName;
	private String Main_Genre;
	private int Report_Count;
	private double Dai1_Insyou;
	private double G_Score;
	
	private int Rank;
	private int HitCount;
	
	public GR_jyouhou_TO(){
		
	}

	/*public GR_jyouhou_TO(String PlatForm, int MakerCode, String MakerName, String GameCode, String GameName, String Main_Genre, int Report_Count, double Dai1_Insyou, double G_Score, int Rank){
		this.PlatForm = PlatForm;
		this.MakerCode = MakerCode;
		this.MakerName = MakerName;
		this.GameCode = GameCode;
		this.GameName = GameName;
		this.Main_Genre = Main_Genre;
		this.Report_Count = Report_Count;
		this.Dai1_Insyou = Dai1_Insyou;
		this.G_Score = G_Score;
		this.Rank = Rank;
	}*/

	public GR_jyouhou_TO(String PlatForm, String MakerName, String GameCode, String GameName, String Main_Genre, double G_Score, int Rank, int HitCount){
		//名作・第一印象・ビッグヒットランキングの作成処理用TO
		this.PlatForm = PlatForm;//プラットフォーム
		this.Main_Genre = Main_Genre;//メインジャンル
		this.GameName = GameName;//ゲームタイトル
		this.MakerName = MakerName;//発売元メーカー名
		this.G_Score = G_Score;//ランキング対象となるG-Score
		this.GameCode = GameCode;//ゲームコード
		this.Rank = Rank;//順位
		this.HitCount = HitCount;
		
	}
	public GR_jyouhou_TO(String PlatForm, String MakerName, String GameCode, String GameName, String Main_Genre, int Report_Count, int Rank, int HitCount){
		//人気作ランキングの作成処理用TO
		this.PlatForm = PlatForm;
		this.Main_Genre = Main_Genre;
		this.GameName = GameName;
		this.MakerName = MakerName;
		this.Report_Count = Report_Count;//そのゲームに対するレポート提出数
		this.GameCode = GameCode;
		this.Rank = Rank;
		this.HitCount = HitCount;
		
	}

	public String getPlatForm(){return PlatForm;}
	public void setPlatForm(String PlatForm) {this.PlatForm = PlatForm;}

	public int getMakerCode(){return MakerCode;}
	public void setMekerCode(int MakerCode) {this.MakerCode = MakerCode;}

	public String getMakerName(){return MakerName;}
	public void setMakerName(String MakerName) {this.MakerName = MakerName;}

	public String getGameCode(){return GameCode;}
	public void setGameCode(String GameCode) {this.GameCode = GameCode;}

	public String getGameName(){return GameName;}
	public void setGameName(String GameName) {this.GameName = GameName;}
	
	public String getMain_Genre(){return Main_Genre;}
	public void setMain_Genre(String Main_Genre){this.Main_Genre = Main_Genre;}

	public int getReport_Count(){return Report_Count;}
	public void setReport_Count(int Report_Count) {this.Report_Count = Report_Count;}

	public double getDai1_Insyou(){return Dai1_Insyou;}
	public void setDai1_Insyou(double Dai1_Insyou) {this.Dai1_Insyou = Dai1_Insyou;}

	public double getG_Score(){return G_Score;}
	public void setG_Score(double G_Score) {this.G_Score = G_Score;}

	public int getRank() {return Rank;}
	public void setRank(int Rank) {this.Rank = Rank;}

	public int getHitCount() {return HitCount;}
	public void setHitCount(int HitCount) {this.HitCount = HitCount;}

}
