package g_jyouhou;

public class G_jyouhou_TO {

    private String GameCode;//ゲームコード
    private String Gametitle;//ゲームの名称

    private String Main_Genre;//メインジャンル
   /* private String SubGenre1;//サブジャンル1
    private String SubGenre2;//サブジャンル2 */
    private String Rating;//CEROレーティング

    private String Hatsubainengappi;//発売年月日
    private String Platform;//プラットフォーム

    private String MakerCode;//発売元メーカーのコード
    private String MakerName;//発売元メーカーの名称
    private String LiSence;//著作物の転載許可状況
    
    private String Shinchoku;//開発の進捗度
    
    private String Hatsubainengappi_Start;
    private String Hatsubainengappi_Limit;
    
    private String GS_Syubetsu;
    
    private double G_Score_Min;
    private double G_Score_Max;
    
    private int PageSt;
    private int PageFin;
    private int HitCount;
    
    /*public G_jyouhou_TO(String GameCode, String Gametitle, String Main_Genre, String SubGenre1, String SubGenre2, String Rating, String Hatsubainengappi, String Platform,  String MakerCode, String MakerName, String LiSence){
        this.GameCode = GameCode;//将来の拡張用(現在は使用せず)
        this.Gametitle = Gametitle;

        this.Main_Genre = Main_Genre;
        this.SubGenre1 = SubGenre1;
        this.SubGenre2 = SubGenre2;
        this.Rating = Rating;

        this.Hatsubainengappi = Hatsubainengappi;
        this.Platform = Platform;

        this.MakerCode = MakerCode;
        this.MakerName = MakerName;
        this.LiSence = LiSence;
    }*/

	public G_jyouhou_TO(String GameCode, String Platform, String Gametitle, String Main_Genre, String Hatsubainengappi, String MakerName, String Rating, String LiSence, int HitCount ) {
		this.GameCode = GameCode;//ゲームの検索処理用TO
		this.Platform = Platform;
		this.Gametitle = Gametitle;
		this.Main_Genre = Main_Genre;
		this.Hatsubainengappi = Hatsubainengappi;
		this.MakerName = MakerName;
		this.Rating = Rating;
		this.LiSence = LiSence;
		this.HitCount = HitCount;
		
		// TODO 自動生成されたコンストラクター・スタブ
	}
	
	public G_jyouhou_TO(){
		
	}

	public G_jyouhou_TO(String GameCode, String GameTitle, String Platform, String Publisher,//発売前のゲームの概要呼び出し
			String MainGenre, String Hatsubaiyoteibi, String Shinchokudo) {
		this.GameCode = GameCode;
		this.Gametitle = GameTitle;
		this.Platform = Platform;
		this.MakerName = Publisher;
		this.Main_Genre = MainGenre;
		this.Hatsubainengappi = Hatsubaiyoteibi;
		this.Shinchoku = Shinchokudo;
	}

	public G_jyouhou_TO(int PageSt, int PageFin) {
		this.PageSt = PageSt;
		this.PageFin = PageFin;
	}

	public G_jyouhou_TO(String GameTitle, String Maker_Name, String Main_Genre, String Platform,
			String Hatsubainengappi_Start, String Hatsubainengappi_Limit, String GS_Syubetsu, double G_Score_Min,
			double G_Score_Max, String Lisence, int PageSt, int PageFin) {
		this.Gametitle = GameTitle;
		this.MakerName = Maker_Name;
		this.Main_Genre = Main_Genre;
		this.Platform = Platform;
		this.Hatsubainengappi_Start = Hatsubainengappi_Start;
		this.Hatsubainengappi_Limit = Hatsubainengappi_Limit;
		this.GS_Syubetsu = GS_Syubetsu;
		this.G_Score_Min = G_Score_Min;
		this.G_Score_Max = G_Score_Max;
		this.LiSence = Lisence;
		this.PageSt = PageSt;
		this.PageFin = PageFin;
	}

	public String getGameCode() {return GameCode;}
    public void setGameCode(String GameCode) {this.GameCode = GameCode;}
    
    public String getGametitle() {return Gametitle;}
    public void setGametitle(String Gametitle) {this.Gametitle = Gametitle;}


    public String getMain_Genre() {return Main_Genre;}
    public void setMain_Genre(String Main_Genre) {this.Main_Genre = Main_Genre;}

    /*public String getSubGenre1() {return SubGenre1;}
    public void setSubGenre1(String SubGenre1) {this.SubGenre1 = SubGenre1;}

    public String getSubGenre2() {return SubGenre2;}
    public void setSubGenre2(String SubGenre2) {this.SubGenre2 = SubGenre2;}*/

    public String getRating() {return Rating;}
    public void setRating(String Rating) {this.Rating = Rating;}


    public String getHatsubainengappi() {return Hatsubainengappi;}
    public void setHatsubainengappi(String Hatsubainengappi) {this.Hatsubainengappi = Hatsubainengappi;}

    public String getPlatform() {return Platform;}
    public void setPlatform(String Platform) {this.Platform = Platform;}


    public String getMakerCode() {return MakerCode;}
    public void setMakerCode(String MakerCode) {this.MakerCode = MakerCode;}

    public String getMakerName() {return MakerName;}
    public void setMakerName(String MakerName){this.MakerName = MakerName;}

    public String getLiSence() {return LiSence;}
    public void setLiSence(String LiSence) {this.LiSence = LiSence;}

	public String getShinchoku() {return Shinchoku;}
	public void setShinchoku(String Shinchoku) {this.Shinchoku = Shinchoku;}

	public int getPageSt() {return PageSt;}
	public void setPageSt(int PageSt) {this.PageSt = PageSt;}

	public int getPageFin() {return PageFin;}
	public void setPageFin(int PageFin) {this.PageFin = PageFin;}

	public int getHitCount() {return HitCount;}
	public void setHitCount(int HitCount) {this.HitCount = HitCount;}

	public String getHatsubainengappi_Start() {return Hatsubainengappi_Start;}
	public void setHatsubainengappi_Start(String Hatsubainengappi_Start) {this.Hatsubainengappi_Start = Hatsubainengappi_Start;}

	public String getHatsubainengappi_Limit() {return Hatsubainengappi_Limit;}
	public void setHatsubainengappi_Limit(String Hatsubainengappi_Limit) {this.Hatsubainengappi_Limit = Hatsubainengappi_Limit;}

	public String getGS_Syubetsu() {return GS_Syubetsu;}
	public void setGS_Syubetsu(String GS_Syubetsu) {this.GS_Syubetsu = GS_Syubetsu;}

	public double getG_Score_Min() {return G_Score_Min;}
	public void setG_Score_Min(double G_Score_Min) {this.G_Score_Min = G_Score_Min;}

	public double getG_Score_Max() {return G_Score_Max;}
	public void setG_Score_Max(double G_Score_Max) {this.G_Score_Max = G_Score_Max;}
    
    

}
