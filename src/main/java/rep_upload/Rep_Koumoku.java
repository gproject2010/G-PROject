package rep_upload;

public class Rep_Koumoku {

	private boolean over;//評価点数の不正値フラグ
	private boolean notscore;//評価点数の未入力フラグ
	private boolean wrong;//テキスト入力部分の不正値フラグ
	
	private double dificultty;//難易度の適正度
	private double story;//シナリオ・世界観
	private double graphic;//グラフィック
	private double sound;//BGM(サウンド)
	private double volume;//ボリューム度・ハマり度
	private double controll;//操作性
	private double promotion;//プロモーション
	private double free_S;//自由点
	private double total;//合計(使わない予定)
	
	private boolean few;//マイナスの値が入力されていることを表すフラグ
	private boolean nghit;//NGワードが入力値に含まれていることを表すフラグ
	private String NGWord;//NGワードが含まれている入力値
	private boolean notmatch;//点数の合計が合っていないことを表すフラグ
	
	private String jiyuten_koumoku1;//自由点内訳の評価項目
	private String jiyuten_koumoku2;
	private String jiyuten_koumoku3;
	private String jiyuten_koumoku4;
	private String jiyuten_koumoku5;
	
	private double jiyuten_score1;//自由点内訳の評価点数
	private double jiyuten_score2;
	private double jiyuten_score3;
	private double jiyuten_score4;
	private double jiyuten_score5;
	private double jiyuten_scoretotal;
	
	private double jiyuten_maxscore1;//自由点内訳の評価点数の満点
	private double jiyuten_maxscore2;
	private double jiyuten_maxscore3;
	private double jiyuten_maxscore4;
	private double jiyuten_maxscore5;
	private double jiyuten_maxscoretotal;
	
	private boolean jisu_wrong;
	
	private String outline;//ゲーム概要
	private boolean notOutline;//概要の未入力フラグ
	
	private String goodies;//良かった所(OXレポート)
	private boolean notGoodies;//良かった所の未入力フラグ
	private String badies;//悪かった所(OXレポート)
	private boolean notBadies;
	
	private String midashi;//記事見出し(紹介記事レポート)
	private boolean notMidashi;//記事見出しの未入力フラグ
	private String feature;//ゲームの特徴・セールスポイント(紹介記事レポート)
	private boolean notFeature;//特徴・セールスポイントの未入力フラグ
	private String evaluate;//ゲームの評価文(紹介記事レポート)
	private boolean notEvaluate;//評価文の未入力フラグ
	private String Comment;
	private boolean NoComment;
	
	private String Konyu_houhou;//購入方法
	private String[] Interview1;//プレー希望者
	private String Interview2;//プレーを最も心待ちにしていた人
	private String[] Interview3;//このゲームに関して見聞きしていた情報
	private String Interview4;//購入を決定づけた情報
	private String[] Interview5;//購入理由
	private String Interview6;//シリーズ・続編の購入意欲
	private boolean notAnswer;//インタビュー欄の未入力フラグ未入力フラグ
	
	private String UploadFileName;//添付ファイル(フォルダ)名
	private boolean nofile;//ファイルの未添付フラグ
	
	private String ShinkiFlg;//ゲーム情報からの登録か新規登録か
	private boolean Notitle;//ゲームタイトルの未入力フラグ
	private String Rep_Code;//レポートコード
	private String Rep_Syubetsu;
	private String UploadTime;//レポートのアップロード日時
	private String GameTitle;//ゲームタイトル
	private String MakerName;//発売元メーカ名
	private String HatsubaiNengappi;//発売年月日
	private String MainGenre;//メインジャンル
	private String PlatForm;//プラットフォーム
	
	
	public Rep_Koumoku(){
	}
	public Rep_Koumoku(boolean Jisu_Wrong, boolean over, boolean notscore, boolean wrong, boolean few, String NGWord, boolean notmatch, double dificultty, double story, double graphic, double sound, double volume, double controll, double promotion, double free_S, double total,
			String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_scoretotal, double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5, double jiyuten_maxscoretotal,
			String outline, boolean notOutline, String goodies, boolean notGoodies, String badies, boolean notBadies, String Konyu_Houhou, String[] Interview1, String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, boolean notAnswer){
		this.jisu_wrong = Jisu_Wrong;
		this.over = over;  //OXレポート
		this.notscore = notscore;
		this.wrong = wrong;
		this.few = few;
		this.notmatch = notmatch;
		this.NGWord = NGWord;
		
		this.dificultty = dificultty;
		this.story = story;
		this.graphic = graphic;
		this.sound = sound;
		this.volume = volume;
		this.controll = controll;
		this.promotion = promotion;
		this.free_S = free_S;
		this.total = total;

		this.jiyuten_koumoku1 = jiyuten_koumoku1;
		this.jiyuten_koumoku2 = jiyuten_koumoku2;
		this.jiyuten_koumoku3 = jiyuten_koumoku3;
		this.jiyuten_koumoku4 = jiyuten_koumoku4;
		this.jiyuten_koumoku5 = jiyuten_koumoku5;
		
		this.jiyuten_score1 = jiyuten_score1;
		this.jiyuten_score2 = jiyuten_score2;
		this.jiyuten_score3 = jiyuten_score3;
		this.jiyuten_score4 = jiyuten_score4;
		this.jiyuten_score5 = jiyuten_score5;
		this.jiyuten_scoretotal = jiyuten_scoretotal;
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		this.jiyuten_maxscoretotal = jiyuten_maxscoretotal;
		
		this.outline = outline;
		this.notOutline = notOutline;
		this.goodies = goodies;
		this.notGoodies = notGoodies;
		this.badies = badies;
		this.notBadies = notBadies;
		
		this.Konyu_houhou = Konyu_Houhou;
		
		this.Interview1 = Interview1;
		this.Interview2 = Interview2;
		this.Interview3 = Interview3;
		this.Interview4 = Interview4;
		this.Interview5 = Interview5;
		this.Interview6 = Interview6;
		this.notAnswer = notAnswer;
	}
	public Rep_Koumoku(boolean Jisu_Wrong, boolean over, boolean notscore, boolean wrong, boolean few, String NGWord, boolean notmatch, double dificultty, double story, double graphic, 
			double sound,double volume, double controll, double promotion, double free_S, double total,
			String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5,
			double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5, double jiyuten_scoretotal,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5, double jiyuten_maxscoretotal, 
			String outline, boolean notOutline,String midashi, boolean notMidashi, String feature,boolean notFeature, String evaluate, boolean notEvaluate, String Konyu_Houhou,
			String[] Interview1, String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, boolean notAnswer) {
		//紹介記事レポート
		this.jisu_wrong = Jisu_Wrong;
		this.over = over;
		this.notscore = notscore;
		this.wrong = wrong;
		this.few = few;
		this.notmatch = notmatch;
		this.NGWord = NGWord;
		
		this.dificultty = dificultty;
		this.story = story;
		this.graphic = graphic;
		this.sound = sound;
		this.volume = volume;
		this.controll = controll;
		this.promotion = promotion;
		this.free_S = free_S;
		this.total = total;

		this.jiyuten_koumoku1 = jiyuten_koumoku1;
		this.jiyuten_koumoku2 = jiyuten_koumoku2;
		this.jiyuten_koumoku3 = jiyuten_koumoku3;
		this.jiyuten_koumoku4 = jiyuten_koumoku4;
		this.jiyuten_koumoku5 = jiyuten_koumoku5;
		
		this.jiyuten_score1 = jiyuten_score1;
		this.jiyuten_score2 = jiyuten_score2;
		this.jiyuten_score3 = jiyuten_score3;
		this.jiyuten_score4 = jiyuten_score4;
		this.jiyuten_score5 = jiyuten_score5;
		this.jiyuten_scoretotal = jiyuten_scoretotal;
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		this.jiyuten_maxscoretotal = jiyuten_maxscoretotal;
		
		this.outline = outline;
		this.notOutline = notOutline;
		
		this.midashi = midashi;
		this.notMidashi = notMidashi;
		this.feature = feature;
		this.notFeature = notFeature;
		this.evaluate = evaluate;
		this.notEvaluate = notEvaluate;
		
		this.Konyu_houhou = Konyu_Houhou;
		
		this.Interview1 = Interview1;
		this.Interview2 = Interview2;
		this.Interview3 = Interview3;
		this.Interview4 = Interview4;
		this.Interview5 = Interview5;
		this.Interview6 = Interview6;
		this.notAnswer = notAnswer;
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Rep_Koumoku(boolean Jisu_Wrong, boolean over, boolean notscore, boolean wrong, boolean few, String NGWord, boolean notmatch, boolean nofile,//自由形式レポート
			double dificultty, double story, double graphic, double sound,
			double volume, double controll, double promotion, double free_S,
			double total, String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5, double jiyuten_scoretotal, double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5, double jiyuten_maxscoretotal, String outline, boolean notOutline,
			String Konyu_Houhou, String[] Interview1, String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, boolean notAnswer){//, String UploadFileName) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.jisu_wrong = Jisu_Wrong;
		this.over = over;
		this.notscore = notscore;
		this.wrong = wrong;
		this.few = few;
		this.notmatch = notmatch;
		this.nofile = nofile;
		this.dificultty = dificultty;
		this.story = story;
		this.graphic = graphic;
		this.sound = sound;
		this.volume = volume;
		this.controll = controll;
		this.promotion = promotion;
		this.free_S = free_S;
		this.total = total;
		
		this.jiyuten_koumoku1 = jiyuten_koumoku1;
		this.jiyuten_koumoku2 = jiyuten_koumoku2;
		this.jiyuten_koumoku3 = jiyuten_koumoku3;
		this.jiyuten_koumoku4 = jiyuten_koumoku4;
		this.jiyuten_koumoku5 = jiyuten_koumoku5;
		
		this.jiyuten_score1 = jiyuten_score1;
		this.jiyuten_score2 = jiyuten_score2;
		this.jiyuten_score3 = jiyuten_score3;
		this.jiyuten_score4 = jiyuten_score4;
		this.jiyuten_score5 = jiyuten_score5;
		this.jiyuten_scoretotal = jiyuten_scoretotal;
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		this.jiyuten_maxscoretotal = jiyuten_maxscoretotal;
		
		this.outline = outline;
		this.notOutline = notOutline;
		
		this.Konyu_houhou = Konyu_Houhou;
		
		this.Interview1 = Interview1;
		this.Interview2 = Interview2;
		this.Interview3 = Interview3;
		this.Interview4 = Interview4;
		this.Interview5 = Interview5;
		this.Interview6 = Interview6;
		this.notAnswer = notAnswer;
		this.NGWord = NGWord;
		
		//this.UploadFileName = UploadFileName;
	}
	
	public Rep_Koumoku(String ShinkiFlg, boolean Notitle, String GameTitle, String MakerName,
			String HatsubaiNengappi, String MainGenre, String PlatForm) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.ShinkiFlg = ShinkiFlg;
		this.Notitle = Notitle;
		this.GameTitle = GameTitle;
		this.MakerName = MakerName;
		this.HatsubaiNengappi = HatsubaiNengappi;
		this.MainGenre = MainGenre;
		this.PlatForm = PlatForm;
	}
	public Rep_Koumoku(String Comment, boolean NoComment, String NGWord, boolean MojisuOver) {
		this.Comment = Comment;
		this.NoComment = NoComment;
		this.NGWord = NGWord;
		this.over = MojisuOver;
	}
	
	public Rep_Koumoku(String GameTitle, double Dificultty, double Story, double Graphic, double Sound,
			double Volume, double Controll, double Promotion, double Free_S, double Total,
			String Jiyuten_Koumoku1, String Jiyuten_Koumoku2, String Jiyuten_Koumoku3, double Jiyuten_Score1,
			double Jiyuten_Score2, double Jiyuten_Score3, double Jiyuten_TotalScore, double Jiyuten_MaxScore1, double Jiyuten_MaxScore2,
			double Jiyuten_MaxScore3, double Jiyuten_TotalMaxScore, String Comment, boolean NoTitle, boolean Jisu_Wrong, boolean Over,
			boolean Notscore, boolean Wrong, boolean Few, boolean Notmatch, boolean Nocomment, String NGWord) {
		this.GameTitle = GameTitle;
		this.dificultty = Dificultty;
		this.story = Story;
		this.graphic = Graphic;
		this.sound = Sound;
		this.volume = Volume;
		this.controll = Controll;
		this.promotion = Promotion;
		this.free_S = Free_S;
		this.total = Total;
		this.jiyuten_koumoku1 = Jiyuten_Koumoku1;
		this.jiyuten_koumoku2 = Jiyuten_Koumoku2;
		this.jiyuten_koumoku3 = Jiyuten_Koumoku3;
		this.jiyuten_score1 = Jiyuten_Score1;
		this.jiyuten_score2 = Jiyuten_Score2;
		this.jiyuten_score3 = Jiyuten_Score3;
		this.jiyuten_scoretotal = Jiyuten_TotalScore;
		this.jiyuten_maxscore1 = Jiyuten_MaxScore1;
		this.jiyuten_maxscore2 = Jiyuten_MaxScore2;
		this.jiyuten_maxscore3 = Jiyuten_MaxScore3;
		this.jiyuten_maxscoretotal = Jiyuten_TotalMaxScore;
		this.Comment = Comment;
		this.Notitle = NoTitle;
		this.jisu_wrong = Jisu_Wrong;
		this.over = Over;
		this.notscore = Notscore;
		this.wrong = Wrong;
		this.few = Few;
		this.notmatch = Notmatch;
		this.NoComment = Nocomment;
		this.NGWord = NGWord;
	}
	public Rep_Koumoku(String GameTitle, double Dificultty, double Story, double Graphic, double Sound,
			double Volume, double Controll, double Promotion, double Free_S, double Total,
			String Jiyuten_Koumoku1, String Jiyuten_Koumoku2, String Jiyuten_Koumoku3, double Jiyuten_Score1,
			double Jiyuten_Score2, double Jiyuten_Score3, double Jiyuten_ScoreTotal, double Jiyuten_MaxScore1,
			double Jiyuten_MaxScore2, double Jiyuten_MaxScore3, double Jiyuten_MaxScoreTotal, String Comment) {
		this.GameTitle = GameTitle;
		this.dificultty = Dificultty;
		this.story = Story;
		this.graphic = Graphic;
		this.sound = Sound;
		this.volume = Volume;
		this.controll = Controll;
		this.promotion = Promotion;
		this.free_S = Free_S;
		this.total = Total;
		this.jiyuten_koumoku1 = Jiyuten_Koumoku1;
		this.jiyuten_koumoku2 = Jiyuten_Koumoku2;
		this.jiyuten_koumoku3 = Jiyuten_Koumoku3;
		this.jiyuten_score1 = Jiyuten_Score1;
		this.jiyuten_score2 = Jiyuten_Score2;
		this.jiyuten_score3 = Jiyuten_Score3;
		this.jiyuten_scoretotal = Jiyuten_ScoreTotal;
		this.jiyuten_maxscore1 = Jiyuten_MaxScore1;
		this.jiyuten_maxscore2 = Jiyuten_MaxScore2;
		this.jiyuten_maxscore3 = Jiyuten_MaxScore3;
		this.jiyuten_maxscoretotal = Jiyuten_MaxScoreTotal;
		this.Comment = Comment;
	}
	public Rep_Koumoku(String Rep_Code, String GameTitle, String UploadTime, double Dificultty, double Story,
			double Graphic, double Sound, double Volume, double Controll, double Promotion, double Free_S,
			String Jiyuten_Koumoku1, String Jiyuten_Koumoku2, String Jiyuten_Koumoku3, double Jiyuten_Score1,
			double Jiyuten_Score2, double Jiyuten_Score3, double Jiyuten_MaxScore1, double Jiyuten_MaxScore2,
			double Jiyuten_MaxScore3, String Rep_Syubetsu) {
		this.Rep_Code = Rep_Code;
		this.GameTitle = GameTitle;
		this.dificultty = Dificultty;
		this.story = Story;
		this.graphic = Graphic;
		this.sound = Sound;
		this.volume = Volume;
		this.controll = Controll;
		this.promotion = Promotion;
		this.free_S = Free_S;
		this.jiyuten_koumoku1 = Jiyuten_Koumoku1;
		this.jiyuten_koumoku2 = Jiyuten_Koumoku2;
		this.jiyuten_koumoku3 = Jiyuten_Koumoku3;
		this.jiyuten_score1 = Jiyuten_Score1;
		this.jiyuten_score2 = Jiyuten_Score2;
		this.jiyuten_score3 = Jiyuten_Score3;
		this.jiyuten_maxscore1 = Jiyuten_MaxScore1;
		this.jiyuten_maxscore2 = Jiyuten_MaxScore2;
		this.jiyuten_maxscore3 = Jiyuten_MaxScore3;
		this.Rep_Syubetsu = Rep_Syubetsu;
	}
	
	public Rep_Koumoku(String Rep_Code, String GameTitle, String UploadTime, double Total, String Rep_Syubetsu) {
		this.Rep_Code = Rep_Code;
		this.GameTitle = GameTitle;
		this.UploadTime = UploadTime;
		this.total = Total;
		this.Rep_Syubetsu = Rep_Syubetsu;
	}
	
	public boolean isJisu_wrong() {return jisu_wrong;}
	public void setJisu_wrong(boolean jisu_wrong) {this.jisu_wrong = jisu_wrong;}
	
	public boolean isover(){return over;} //共通項目
	public void setover(boolean over) {this.over = over;}
	
	public boolean isnotscore() {return notscore;}
	public void setnotscore(boolean notscore) {this.notscore = notscore;}
	
	public boolean iswrong() {return wrong;}
	public void setwrong(boolean wrong) {this.wrong = wrong;}
	
	public boolean isnofile() {return nofile;}
	public void setnofile(boolean nofile) {this.nofile = nofile;}
	
	
	public String getRep_Code() {return Rep_Code;}
	public void setRep_Code(String Rep_Code) {this.Rep_Code = Rep_Code;}

	public String getRep_Syubetsu() {return Rep_Syubetsu;}
	public void setRep_Syubetsu(String Rep_Syubetsu) {this.Rep_Syubetsu = Rep_Syubetsu;}
	public String getUploadTime() {return UploadTime;}
	public void setUploadTime(String UploadTime) {this.UploadTime = UploadTime;}
	
	
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
	
	public double gettotal() {return total;}
	public void settotal(double total) {this.total = total;}
	
	
	public boolean isfew() {return few;}
	public void setfew(boolean few) {this.few = few;}
	
	public boolean isnghit() {return nghit;}
	public void setnghit(boolean nghit) {this.nghit = nghit;}
	
	public String getNGWord() {return NGWord;}
	public void setNGWord(String NGWord) {this.NGWord = NGWord;}
	
	public boolean isnotmatch() {return notmatch;}
	public void setnotmatch(boolean notmatch) {this.notmatch = notmatch;}
	
	
	public String getjiyuten_koumoku1() {return jiyuten_koumoku1;}
	public void setjiyuten_koumoku1(String jiyuten_koumoku1) {this.jiyuten_koumoku1 = jiyuten_koumoku1;}
	
	public String getjiyuten_koumoku2() {return jiyuten_koumoku2;}
	public void setjiyuten_koumoku2(String jiyuten_koumoku2) {this.jiyuten_koumoku2 = jiyuten_koumoku2;}
	
	public String getjiyuten_koumoku3() {return jiyuten_koumoku3;}
	public void setjiyuten_koumoku3(String jiyuten_koumoku3) {this.jiyuten_koumoku3 = jiyuten_koumoku3;}
	
	public String getjiyuten_koumoku4() {return jiyuten_koumoku4;}
	public void setjiyuten_koumoku4(String jiyuten_koumoku4) {this.jiyuten_koumoku4 = jiyuten_koumoku4;}
	
	public String getjiyuten_koumoku5() {return jiyuten_koumoku5;}
	public void setjiyuten_koumoku5(String jiyuten_koumoku5) {this.jiyuten_koumoku5 = jiyuten_koumoku5;}
	
	
	public double getjiyuten_score1() {return jiyuten_score1;}
	public void setjiyuten_score1(double jiyuten_score1) {this.jiyuten_score1 = jiyuten_score1;}
	
	public double getjiyuten_score2() {return jiyuten_score2;}
	public void setjiyuten_score2(double jiyuten_score2) {this.jiyuten_score2 = jiyuten_score2;}
	
	public double getjiyuten_score3() {return jiyuten_score3;}
	public void setjiyuten_score3(double jiyuten_score3) {this.jiyuten_score3 = jiyuten_score3;}
	
	public double getjiyuten_score4() {return jiyuten_score4;}
	public void setjiyuten_score4(double jiyuten_score4) {this.jiyuten_score4 = jiyuten_score4;}
	
	public double getjiyuten_score5() {return jiyuten_score5;}
	public void setjiyuten_score5(double jiyuten_score5) {this.jiyuten_score5 = jiyuten_score5;}
	
	public double getjiyuten_scoretotal() {return jiyuten_scoretotal;}
	public void setjiyuten_scoretotal(double jiyuten_scoretotal) {this.jiyuten_scoretotal = jiyuten_scoretotal;}
	
	
	public double getjiyuten_maxscore1() {return jiyuten_maxscore1;}
	public void setjiyuten_maxscore1(double jiyuten_maxscore1) {this.jiyuten_maxscore1 = jiyuten_maxscore1;}
	
	public double getjiyuten_maxscore2() {return jiyuten_maxscore2;}
	public void setjiyuten_maxscore2(double jiyuten_maxscore2) {this.jiyuten_maxscore2 = jiyuten_maxscore2;}
	
	public double getjiyuten_maxscore3() {return jiyuten_maxscore3;}
	public void setjiyuten_maxscore3(double jiyuten_maxscore3) {this.jiyuten_maxscore3 = jiyuten_maxscore3;}
	
	public double getjiyuten_maxscore4() {return jiyuten_maxscore4;}
	public void setjiyuten_maxscore4(double jiyuten_maxscore4) {this.jiyuten_maxscore4 = jiyuten_maxscore4;}
	
	public double getjiyuten_maxscore5() {return jiyuten_maxscore5;}
	public void setjiyuten_maxscore5(double jiyuten_maxscore5) {this.jiyuten_maxscore5 = jiyuten_maxscore5;}
	
	public double getjiyuten_maxscoretotal() {return jiyuten_maxscoretotal;}
	public void setjiyuten_maxscoretotal(double jiyuten_maxscoretotal) {this.jiyuten_maxscoretotal = jiyuten_maxscoretotal;}
	
	
	public String getoutline() {return outline;}
	public void setoutline(String outline) {this.outline = outline;}
	
	public boolean isnotOutline() {return notOutline;}
	public void setnotOutline(boolean notOutline) {this.notOutline = notOutline;}
	
	
	public String getgoodies() {return goodies;} //○×レポート用
	public void setgoodies(String goodies) {this.goodies = goodies;}
	
	public boolean isnotGoodies() {return notGoodies;}
	public void setnotGoodies(boolean notGoodies) {this.notGoodies = notGoodies;}
	
	public String getbadies() {return badies;}
	public void setbadies(String badies) {this.badies = badies;}
	
	public boolean isNotBadies() {return notBadies;}
	public void setNotBadies(boolean notBadies) {this.notBadies = notBadies;}
	
	public String getmidashi() {return midashi;} //記事レポート用
	public void setmidashi(String midashi) {this.midashi = midashi;}
	
	public boolean isnotMidashi() {return notMidashi;}
	public void setnotMidashi(boolean notMidashi) {this.notMidashi = notMidashi;}
	
	public String getfeature() {return feature;}
	public void setfeature(String feature) {this.feature = feature;}
	
	public boolean isnotFeature() {return notFeature;}
	public void setnotFeature(boolean notFeature) {this.notFeature = notFeature;}
	
	public String getevaluate() {return evaluate;}
	public void setevaluate(String evaluate) {this.evaluate = evaluate;}
	
	public boolean isnotEvaluate() {return notEvaluate;}
	public void setnotEvaluate(boolean notEvaluate) {this.notEvaluate = notEvaluate;}
	
	public String getComment() {return Comment;}
	public void setComment(String Comment) {this.Comment = Comment;}
	
	public boolean isNoComment() {return NoComment;}
	public void setNoComment(boolean NoComment) {this.NoComment = NoComment;}
	
	
	public String getKonyu_houhou() {return Konyu_houhou;}
	public void setKonyu_houhou(String Konyu_Houhou) {Konyu_houhou = Konyu_Houhou;}
		
	public String[] getInterview1() {return Interview1;}      //共通インタビュー項目
	public void setInterview1(String[] Interview1) {this.Interview1 = Interview1;}
	
	public String getInterview2() {return Interview2;}
	public void setInterview2(String Interview2) {this.Interview2 = Interview2;}
	
	public String[] getInterview3() {return Interview3;}
	public void setInterview3(String[] Interview3) {this.Interview3 = Interview3;}
	
	public String getInterview4() {return Interview4;}
	public void setInterview4(String Interview4) {this.Interview4 = Interview4;}
	
	public String[] getInterview5() {return Interview5;}
	public void setInterview5(String[] Interview5) {this.Interview5 = Interview5;}
	
	public String getInterview6() {return Interview6;}
	public void setInterview6(String interview6) {this.Interview6 = interview6;}
	
	public boolean isnotAnswer() {return notAnswer;}
	public void setnotAnswer(boolean notAnswer) {this.notAnswer = notAnswer;}
	
	public String getUploadFileName() {return UploadFileName;}
	public void setUploadFileName(String UploadFileName) {this.UploadFileName = UploadFileName;}
	
	public String getShinkiFlg() {return ShinkiFlg;}
	public void setShinkiFlg(String ShinkiFlg) {this.ShinkiFlg = ShinkiFlg;}
	
	public boolean isNotitle() {return Notitle;}
	public void setNotitle(boolean Notitle) {this.Notitle = Notitle;}
	
	public String getGameTitle() {return GameTitle;}
	public void setGameTitle(String GameTitle) {this.GameTitle = GameTitle;}
	
	public String getMakerName() {return MakerName;}
	public void setMakerName(String MakerName) {this.MakerName = MakerName;}
	
	public String getHatsubaiNengappi() {return HatsubaiNengappi;}
	public void setHatsubaiNengappi(String HatsubaiNengappi) {this.HatsubaiNengappi = HatsubaiNengappi;}
	
	public String getMainGenre() {return MainGenre;}
	public void setMainGenre(String MainGenre) {this.MainGenre = MainGenre;}
	
	public String getPlatForm() {return PlatForm;}
	public void setPlatForm(String PlatForm) {this.PlatForm = PlatForm;}
}
