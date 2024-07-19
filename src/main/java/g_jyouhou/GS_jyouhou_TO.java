package g_jyouhou;

public class GS_jyouhou_TO {

	private String Gamecode;//ゲームコード
    private String Gametitle;//ゲームタイトル
    
    private String Maingenre;//メインジャンル
    private String Subgenre1;//サブジャンル1
    private String Subgenre2;//サブジャンル2
    private String Rating;//CEROレーティング

    private String Hatsubainengappi;//発売年月日
    private String Platform;//プラットフォーム
    
    private double dificultty;//難易度の適正度
	private double story;//世界観・シナリオ
	private double graphic;//グラフィック
	private double sound;//BGMなどサウンド
	private double volume;//ボリューム度・ハマり度
	private double controll;//操作性
	private double promotion;//プロモーション
	private double free_S;//自由点

    private String Makercode;//発売元(パブリッシャー)のコード
    private String Makername;//発売元(パブリッシャー)の名称
    private String Developer_codes;//開発元(デベロッパー)のコード(分解前)
    private String Developer_names;//開発元(デベロッパー)の名称(分解前)
    private String Lisence;//著作物の転載許可状況
    private String Kyokajyouken;//著作物を使用する場合の許可条件(20)
    private String Gaiyou;//ゲームの概要
    private String Bestgaiyou;//概要作成者のプレイヤーネーム
    private String Logoaddress;//ゲームのロゴの格納アドレス
    private String Movieaddress;//ゲームのムービーの格納アドレス
    
    private String[] Developer_Code;//開発元(デベロッパー)のコード(分解後)
    private String[] Developer_Name;//開発元(デベロッパー)の名称(分解後)
    
    private String[] Goodkeyword;
    private String[] Badkeyword;
    private String[] Mainkeyword;
    private String[] Hyoukakeyword;
    private String[] Comments;
    
    private String[] BestReports;//高評価レポートのアドレスその1
    private String[] BestReporters;//↑の作成者のプレイヤーネーム
    
	private int Report_Count;//そのゲームに対するレポートの提出数
	private double Dai1_Insyou;//発売1ヶ月で獲得したG-Score
	private double Nenkan;//発売1年で獲得したG-Score
	private double G_Score;//獲得G-Score累計
	
	private int G_Score_R;//名作ランキングの順位
	private int Dai1_Insyou_R;//第一印象ランキングの順位
	private int Nenkan_R;//ビッグヒットランキングの順位
	private int Rep_Count_R;//人気作ランキングの順位
	private int G_Count;//G-Projectに登録されているゲームの数
	private int Seigen_Kaisu;
	private int Access_Count;
	
	private String Shinchokudo;
	
	private boolean Notitle;
	
	public GS_jyouhou_TO(String Gamecode, String Platform, String Gametitle, String Maingenre, String Subgenre1, String Subgenre2, 
			double dificultty, double story, double graphic, double sound, double volume, double controll, double promotion, double free_S, 
			String Makercode, String[] Developper_Code, String Makername, String[] Developper_Name, String Hatsubainengappi,String Rating, String Lisence, String Kyokajyouken, String Gaiyou, String Bestgaiyou, String Logoaddress, String Movieaddress, String[] Goodkeyword, String[] Badkeyword, String[] Mainkeyword, String[] Hyoukakeyword, 
			String[] BestReports, String[] BestReporters, double G_Score, double Dai1_Insyou, double Nenkan, int Report_Count, int G_Score_R, int Dai1_Insyou_R, int Nenkan_R, int Rep_Count_R, int G_Count, int Seigen_Kaisu, int Access_Count){
		this.Gamecode = Gamecode;//ゲームの詳細情報の格納用TO
		this.Gametitle = Gametitle;
		this.Maingenre = Maingenre;
		this.Subgenre1 = Subgenre1;
		this.Subgenre2 = Subgenre2;
		this.dificultty = dificultty;
		this.story = story;
		this.graphic = graphic;
		this.sound = sound;
		this.volume = volume;
		this.controll = controll;
		this.promotion = promotion;
		this.free_S = free_S;
		
		this.Rating = Rating;
		this.Hatsubainengappi = Hatsubainengappi;
		this.Platform = Platform;
		this.Makercode = Makercode;
		this.Developer_Code = Developper_Code;
		this.Makername = Makername;
		this.Developer_Name = Developper_Name;
		this.Lisence = Lisence;
		this.Kyokajyouken = Kyokajyouken;
		this.Gaiyou = Gaiyou;
		this.Bestgaiyou = Bestgaiyou;
		this.Logoaddress = Logoaddress;
		this.Movieaddress = Movieaddress;
		
		this.Goodkeyword = Goodkeyword;
		this.Badkeyword = Badkeyword;
		this.Mainkeyword = Mainkeyword;
		this.Hyoukakeyword = Hyoukakeyword;
		
		this.BestReports = BestReports;
		this.BestReporters = BestReporters;
		
		this.Report_Count = Report_Count;
		this.Dai1_Insyou = Dai1_Insyou;
		this.Nenkan = Nenkan;
		this.G_Score = G_Score;
		
		this.G_Score_R = G_Score_R;
		this.Dai1_Insyou_R = Dai1_Insyou_R;
		this.Nenkan_R = Nenkan_R;
		this.Rep_Count_R = Rep_Count_R;
		this.G_Count = G_Count;
		
		this.Seigen_Kaisu = Seigen_Kaisu;
		this.Access_Count = Access_Count;
	}


	public GS_jyouhou_TO(boolean Notitle, String Gametitle,
			String Makername, String Hatsubainengappi, String Maingenre,
			String Platform) {//新規登録レポート用
		// TODO 自動生成されたコンストラクター・スタブ
		this.Notitle = Notitle;
		this.Gametitle = Gametitle;
		this.Makername = Makername;
		this.Hatsubainengappi = Hatsubainengappi;
		this.Maingenre = Maingenre;
		this.Platform = Platform;
	}

	public GS_jyouhou_TO(){
		
	}

	public GS_jyouhou_TO(String GameCode, String GameTitle, String PlatForm,
			String Publisher, String Developer,  String MainGenre,
			String SubGenre1, String SubGenre2, String Rating,
			String Gaiyou, String Hatsubainengappi, String Shinchokudo,
			String Logoaddress, String Movieaddress, int Access_Count, String[] Comments) {
		
		this.Gamecode = GameCode;
		this.Gametitle = GameTitle;
		this.Platform = PlatForm;
		this.Makername = Publisher;
		this.Developer_names = Developer;//変数名が間違っている可能性あり
		this.Maingenre = MainGenre;
		this.Subgenre1 = SubGenre1;
		this.Subgenre2 = SubGenre2;
		this.Rating = Rating;
		this.Gaiyou = Gaiyou;
		this.Hatsubainengappi = Hatsubainengappi;
		this.Shinchokudo = Shinchokudo;
		this.Logoaddress = Logoaddress;
		this.Movieaddress = Movieaddress;
		this.Access_Count = Access_Count;
		this.Comments = Comments;
	}


	public String getGamecode() {return Gamecode;}
	public void setGamecode(String Gamecode){this.Gamecode = Gamecode;}
	
	public String getGametitle() {return Gametitle;}
	public void setGametitle(String Gametitle) {this.Gametitle = Gametitle;}
	
	public String getMaingenre() {return Maingenre;}
	public void setMaingenre(String Maingenre) {this.Maingenre = Maingenre;}
	
	public String getSubgenre1() {return Subgenre1;}
	public void setSubgenre1(String Subgenre1) {this.Subgenre1 = Subgenre1;}
	
	public String getSubgenre2() {return Subgenre2;}
	public void setSubgenre2(String Subgenre2) {this.Subgenre2 = Subgenre2;}
	
	
	public double getdificultty() {return dificultty;}
	public void setdificultty(double dificultty) {this.dificultty = dificultty;}
	
	public double getstory() {return story;}
	public void setstory(double story) {this.story = story;}
	
	public double getgraphic() {return graphic;}
	public void setgraphic(double graphic) {this.graphic = graphic;}
	
	public double getsound() {return sound;}
	public void setsound(double sound) {this.sound = sound;}
	
	public double getvolume() {return volume;}
	public void setvolume(double volume) {this.volume = volume;}
	
	public double getcontroll() {return controll;}
	public void setcontroll(double controll) {this.controll = controll;}
	
	public double getpromotion() {return promotion;}
	public void setpromotion(double promotion) {this.promotion = promotion;}
	
	public double getfree_S() {return free_S;}
	public void setfree_S(double free_S) {this.free_S = free_S;}
	
	
	public String getRating() {return Rating;}
	public void setRating(String Rating) {this.Rating = Rating;}
	
	public String getHatsubainengappi() {return Hatsubainengappi;}
	public void setHatsubainengappi(String Hatsubainengappi) {this.Hatsubainengappi = Hatsubainengappi;}
	
	public String getPlatform() {return Platform;}
	public void setPlatform(String Platform) {this.Platform = Platform;}
	
	public String getMakercode() {return Makercode;}
	public void setMakercode(String Makercode) {this.Makercode = Makercode;}
	
	public String getDeveloper_codes() {return Developer_codes;}
	public void setDeveloper_codes(String Developer_Codes) {this.Developer_codes = Developer_Codes;}

	public String[] getDeveloper_Code() {return Developer_Code;}
	public void setDeveloper_Code(String[] Developper_Code) {this.Developer_Code = Developper_Code;}

	public String getMakername() {return Makername;}
	public void setMakername(String Makername) {this.Makername = Makername;}
	
	public String getDeveloper_names() {return Developer_names;}
	public void setDeveloper_names(String Developer_Names) {this.Developer_names = Developer_Names;}

	public String[] getDeveloper_Name() {return Developer_Name;}
	public void setDeveloper_Name(String[] Developer_Name) {this.Developer_Name = Developer_Name;}


	public String getLisence() {return Lisence;}
	public void setLisence(String Lisence) {this.Lisence = Lisence;}
	
	public String getKyokajyouken() {return Kyokajyouken;}
	public void setKyokajyouken(String Kyokajyouken) {this.Kyokajyouken = Kyokajyouken;}

	public String getGaiyou() {return Gaiyou;}
	public void setGaiyou(String Gaiyou) {this.Gaiyou = Gaiyou;}
	
	public String getBestgaiyou() {return Bestgaiyou;}
	public void setBestgaiyou(String Bestgaiyou) {this.Bestgaiyou = Bestgaiyou;}

	public String getLogoaddress() {return Logoaddress;}
	public void setLogoaddress(String Logoaddress) {this.Logoaddress = Logoaddress;}

	public String getMovieaddress() {return Movieaddress;}
	public void setMovieaddress(String Movieaddress) {this.Movieaddress = Movieaddress;}
	

	public String[] getGoodkeyword() {return Goodkeyword;}
	public void setGoodkeyword(String[] Goodkeyword) {this.Goodkeyword = Goodkeyword;}

	public String[] getBadkeyword() {return Badkeyword;}
	public void setBadkeyword(String[] Badkeyword) {this.Badkeyword = Badkeyword;}

	public String[] getMainkeyword() {return Mainkeyword;}
	public void setMainkeyword(String[] Mainkeyword) {this.Mainkeyword = Mainkeyword;}

	public String[] getHyoukakeyword() {return Hyoukakeyword;}
	public void setHyoukakeyword(String[] Hyoukakeyword) {this.Hyoukakeyword = Hyoukakeyword;}

	public String[] getComments() {return Comments;}
	public void setComments(String[] Comments) {this.Comments = Comments;}


	public String[] getBestReports() {return BestReports;}
	public void setBestReports(String[] BestReports) {this.BestReports = BestReports;}

	public String[] getBestReporters() {return BestReporters;}
	public void setBestReporters(String[] BestReporters) {this.BestReporters = BestReporters;}


	public int getReport_Count() {return Report_Count;}
	public void setReport_Count(int Report_Count) {this.Report_Count = Report_Count;}
	
	public double getDai1_Insyou() {return Dai1_Insyou;}
	public void setDai1_Insyou(double Dai1_Insyou) {this.Dai1_Insyou = Dai1_Insyou;}
	
	public double getNenkan() {return Nenkan;}
	public void setNenkan(double Nenkan) {this.Nenkan = Nenkan;}
	
	public double getG_Score() {return G_Score;}
	public void setG_Score(double G_Score) {this.G_Score = G_Score;}
	
	
	public int getG_Score_R() {return G_Score_R;}
	public void setG_Score_R(int G_Score_R) {this.G_Score_R = G_Score_R;}

	public int getDai1_Insyou_R() {return Dai1_Insyou_R;}
	public void setDai1_Insyou_R(int Dai1_Insyou_R) {this.Dai1_Insyou_R = Dai1_Insyou_R;}

	public int getNenkan_R() {return Nenkan_R;}
	public void setNenkan_R(int Nenkan_R) {this.Nenkan_R = Nenkan_R;}

	public int getRep_Count_R() {return Rep_Count_R;}
	public void setRep_Count_R(int Rep_Count_R) {this.Rep_Count_R = Rep_Count_R;}

	public int getG_Count() {return G_Count;}
	public void setG_Count(int G_Count) {this.G_Count = G_Count;}

	
	public int getSeigen_Kaisu() {return Seigen_Kaisu;}
	public void setSeigen_Kaisu(int Seigen_Kaisu) {this.Seigen_Kaisu = Seigen_Kaisu;}


	public int getAccess_Count() {return Access_Count;}
	public void setAccess_Count(int Access_Count) {this.Access_Count = Access_Count;}


	public String getShinchokudo() {return Shinchokudo;}
	public void setShinchokudo(String Shinchokudo) {this.Shinchokudo = Shinchokudo;}

	
	public boolean isNotitle() {return Notitle;}
	public void setNotitle(boolean notitle) {this.Notitle = notitle;}

}
