package rep_upload;

public class Rep_List_TO {//レポートのDBへの書き込み用TO

	private String gamecode;//ゲームコード
	private String gametitle;//ゲームタイトル
	
	private String catchcopy;//キャッチコピー（提案レポート用）
	private String kikakusya;//企画者（提案レポート用）
	private String kaihatsujyoukyou;//開発状況（提案レポート用）
	
	private String report_code;//レポートコード
	private String upload_date;//アップロード日
	private String upload_time;//アップロード時刻
	private String hyouka_rank;//評価ランク
	private String shinsajyoukyou;//添削したか
	private String keisaijyoukyou;//現在ゲーム情報に掲載されているか
	private double rep_score;//このレポートで獲得したレポートスコア
	
	private String k_id;//提出者のID
	private String login_name;//提出者のプレイヤーネーム
	private String Seinengappi;
	private String Sex;
	private String Job;
	private String Pref;
	private int Age;
	
	private double dificultty;//難易度の適正度
	private double story;//ストーリー・世界観
	private double graphic;//グラフィック
	private double sound;//サウンド
	private double volume;//ボリューム度・ハマり度
	private double controll;//操作性
	private double promotion;//プロモーション
	private double free_S;//自由点
	private double total;//合計(使わない予定)
	
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
	
	private double jiyuten_maxscore1;//自由点内訳の評価点数の満点
	private double jiyuten_maxscore2;
	private double jiyuten_maxscore3;
	private double jiyuten_maxscore4;
	private double jiyuten_maxscore5;
	private String outline;//ゲーム概要
	private double saiyou_bonus;
	
	private String goodies;//良かった所(OXレポート)
	private String badies;//悪かった所(OXレポート)
	
	private String midashi;//記事見出し(紹介記事レポート)
	private String feature;//ゲームの特徴・セールスポイント(紹介記事レポート)
	private String evaluate;//ゲームの評価文(紹介記事レポート)
	
	private String comment;//ゲームに対するコメント(一言レポート用)
	
	private String Konyu_houhou;//購入方法(未使用)
	
	private String[] Interview1;//プレー希望者
	private String Interview2;//最も心待ちにしていた人
	private String[] Interview3;//見聞きしたことのある情報
	
	private String Interview4;//購入を決定づけた情報
	
	private String[] Interview5;//購入理由
	
	private String Interview6;//シリーズ・続編の購入意欲
	
	private String UploadFileName;//アップロードするファイル(フォルダ)名
	
	private String MakerName;//発売元メーカ名
	private String HatsubaiNengappi;//発売年月日
	private String MainGenre;//メインジャンル
	private String PlatForm;//プラットフォーム
	
	private String ShijisyaList;
	private String FushijisyaList;
	private int Shijisyasu;
	private int Fushijisyasu;
	private String YourVote;
	
	public Rep_List_TO(String gamecode, String gametitle, /*String report_code, String upload_date, String hyouka_rank, boolean tensaku_flg,*/ String k_id, String login_name, String Seinengappi, String Sex, String Pref, double dificultty, double story, double graphic, double sound, double volume, double controll, double promotion, double free_S, double total,
			String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,
			String outline, String midashi, String feature, String evaluate, String Konyu_Houhou, String[] Interview1,String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, String Job){ //記事レポート
		this.gamecode = gamecode;
		this.gametitle = gametitle;
		
		/*this.report_code = report_code;
		this.upload_date = upload_date;
		this.hyouka_rank = hyouka_rank;
		this.tensaku_flg = tensaku_flg;
		*/
		this.k_id = k_id;
		this.login_name = login_name;
		this.Seinengappi = Seinengappi;
		this.Sex = Sex;
		this.Pref = Pref;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		
		this.midashi = midashi;
		this.feature = feature;
		this.evaluate = evaluate;
		
		this.Konyu_houhou = Konyu_Houhou;
		
		this.Interview1 = Interview1;
		
		this.Interview2 = Interview2;
		
		this.Interview3 = Interview3;
		
		this.Interview4 = Interview4;
		
		this.Interview5 = Interview5;
		
		this.Interview6 = Interview6;
		
		this.Job = Job;
	}
	public Rep_List_TO(){
		
	}
		
		
	public Rep_List_TO(String gamecode, String gametitle, String k_id,
			String login_name, String Seinengappi, String Sex, String Pref, double dificultty, double story,
			double graphic, double sound, double volume, double controll,
			double promotion, double free_S, double total, String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5, String outline,
			String goodies, String badies, String Konyu_Houhou,
			String[] Interview1,String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, String Job){ //○×レポート
		
		this.gamecode = gamecode;
		this.gametitle = gametitle;
		
		this.k_id = k_id;
		this.login_name = login_name;
		this.Seinengappi = Seinengappi;
		this.Sex = Sex;
		this.Pref = Pref;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		
		this.goodies = goodies;
		this.badies = badies;
		
		this.Konyu_houhou = Konyu_Houhou;
		
		this.Interview1 = Interview1;
		
		this.Interview2 = Interview2;
		
		this.Interview3 = Interview3;
		
		this.Interview4 = Interview4;
		
		this.Interview5 = Interview5;
		
		this.Interview6 = Interview6;
		this.Job = Job;
		
		// TODO 自動生成されたコンストラクター・スタブ
	}
	public Rep_List_TO(String gamecode, String gametitle, String k_id,
			String login_name, String Seinengappi, String Sex, String Pref, double dificultty, double story,
			double graphic, double sound, double volume, double controll,
			double promotion, double free_S, double total, String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,
			String outline, String Konyu_Houhou, String[] Interview1,String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, String UploadFileName, String Job){ //自由形式レポート添付書類
		// TODO 自動生成されたコンストラクター・スタブ
		
		this.gamecode = gamecode;
		this.gametitle = gametitle;
		
		this.k_id = k_id;
		this.login_name = login_name;
		this.Seinengappi = Seinengappi;
		this.Sex = Sex;
		this.Pref = Pref;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		
		this.Konyu_houhou = Konyu_Houhou;
		
this.Interview1 = Interview1;
		
		this.Interview2 = Interview2;
		
		this.Interview3 = Interview3;
		
		this.Interview4 = Interview4;
		
		this.Interview5 = Interview5;
		
		this.Interview6 = Interview6;
		
		this.UploadFileName = UploadFileName;
		this.Job = Job;
	}
	public Rep_List_TO( String GameTitle, String k_id,//新規OXレポート
			String login_name, String Seinengappi, String Sex, String Pref, double dificultty, double story,
			double graphic, double sound, double volume, double controll,
			double promotion, double free_S, double total, String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,
			String outline,	String goodies, String badies, String Konyu_Houhou,
			String[] Interview1,String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6,
			String MakerName, String HatsubaiNengappi, String MainGenre, String PlatForm, String Job) {
		// TODO 自動生成されたコンストラクター・スタブ
		
		this.gametitle = GameTitle;
		
		this.k_id = k_id;
		this.login_name = login_name;
		this.Seinengappi = Seinengappi;
		this.Sex = Sex;
		this.Pref = Pref;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		
		this.goodies = goodies;
		this.badies = badies;
		
		this.Konyu_houhou = Konyu_Houhou;
		
this.Interview1 = Interview1;
		
		this.Interview2 = Interview2;
		
		this.Interview3 = Interview3;
		
		this.Interview4 = Interview4;
		
		this.Interview5 = Interview5;
		
		this.Interview6 = Interview6;
		
		this.MakerName = MakerName;
		this.HatsubaiNengappi = HatsubaiNengappi;
		this.MainGenre = MainGenre;
		this.PlatForm = PlatForm;
		this.Job = Job;
	}
	public Rep_List_TO(String GameTitle, /*String report_code, String upload_date, String hyouka_rank, boolean tensaku_flg,*/ String k_id, String login_name, String Seinengappi, String Sex, String Pref, double dificultty, double story, double graphic, double sound, double volume, double controll, double promotion, double free_S, double total,
			
			String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,String outline, String midashi, String feature, String evaluate, String Konyu_Houhou,
			String[] Interview1,String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, 
			String MakerName, String HatsubaiNengappi, String MainGenre, String PlatForm, String Job) {//新規記事レポート
		// TODO 自動生成されたコンストラクター・スタブ
        this.gametitle = GameTitle;
		
		this.k_id = k_id;
		this.login_name = login_name;
		this.Seinengappi = Seinengappi;
		this.Sex = Sex;
		this.Pref = Pref;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		
		this.midashi = midashi;
		this.feature = feature;
		this.evaluate = evaluate;
		
		this.Konyu_houhou = Konyu_Houhou;
		
this.Interview1 = Interview1;
		
		this.Interview2 = Interview2;
		
		this.Interview3 = Interview3;
		
		this.Interview4 = Interview4;
		
		this.Interview5 = Interview5;
		
		this.Interview6 = Interview6;
		
		this.MakerName = MakerName;
		this.HatsubaiNengappi = HatsubaiNengappi;
		this.MainGenre = MainGenre;
		this.PlatForm = PlatForm;
		this.Job = Job;
	}
	public Rep_List_TO(String GameTitle, String k_id,//新規自由形式レポート
			String login_name, String Seinengappi, String Sex, String Pref, String outline, double story,double graphic,double sound,double volume,
			   double controll,double promotion,double free_S,double total,
			   String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			   double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,
			   double dificultty, String Konyu_Houhou, String[] Interview1,String Interview2, String[] Interview3, String Interview4, String[] Interview5, String Interview6, String UploadFileName, 
			String MakerName, String HatsubaiNengappi, String MainGenre, String PlatForm, String Job) {
		
        this.gametitle = GameTitle;
		
		this.k_id = k_id;
		this.login_name = login_name;
		this.Seinengappi = Seinengappi;
		this.Sex = Sex;
		this.Pref = Pref;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		
		this.Konyu_houhou = Konyu_Houhou;
		
this.Interview1 = Interview1;
		
		this.Interview2 = Interview2;
		
		this.Interview3 = Interview3;
		
		this.Interview4 = Interview4;
		
		this.Interview5 = Interview5;
		
		this.Interview6 = Interview6;
		
		this.UploadFileName = UploadFileName;
		
		this.MakerName = MakerName;
		this.HatsubaiNengappi = HatsubaiNengappi;
		this.MainGenre = MainGenre;
		this.PlatForm = PlatForm;
		this.Job = Job;
	}
	public Rep_List_TO(String report_code, String k_id, String Uploaddate, String gametitle, double rep_score, String ShinsaJyoukyou, String KeisaiJyoukyou) {
		// ステータス表示画面用レポートリスト
		this.k_id = k_id;
		this.report_code = report_code;
		this.upload_date = Uploaddate;
		this.gametitle = gametitle;
		this.rep_score = rep_score;
		this.shinsajyoukyou = ShinsaJyoukyou;
		this.keisaijyoukyou = KeisaiJyoukyou;
		
	}
	public Rep_List_TO(String Rep_Code, String gamecode, String gametitle, String playername,
			double dificultty, double story, double graphic, double sound,
			double volume, double controll, double promotion,
			String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,
			String outline, String goodies, String badies,
			String upload_date, String upload_time, int Shijisyasu, int Fushijisyasu, String Your_Vote) {
		//ゲームデータからのベストレポート呼び出し用TO（OXレポート）
		this.report_code = Rep_Code;
		this.gamecode = gamecode;
		this.gametitle = gametitle;
		this.login_name = playername;
		this.dificultty = dificultty;
		this.story = story;
		this.graphic = graphic;
		this.sound = sound;
		this.volume = volume;
		this.controll = controll;
		this.promotion = promotion;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		this.goodies = goodies;
		this.badies = badies;
		this.upload_date = upload_date;
		this.upload_time = upload_time;
		
		//this.ShijisyaList = ShijisyaList;
		//this.FushijisyaList = FushijisyaList;
		
		this.Shijisyasu = Shijisyasu;
		this.Fushijisyasu = Fushijisyasu;
		this.YourVote = Your_Vote;
	}
	public Rep_List_TO(String Rep_Code, String gamecode, String gametitle, String playername,
			double dificultty, double story, double graphic, double sound,
			double volume, double controll, double promotion,
			String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,
			String outline, String midashi, String feature, String evalate,
			String upload_date, String upload_time, int Shijisyasu, int Fushijisyasu, String Your_Vote) {
		//ゲームデータからのベストレポート呼び出し用TO（記事レポート）
		this.report_code = Rep_Code;
		this.gamecode = gamecode;
		this.gametitle = gametitle;
		this.login_name = playername;
		this.dificultty = dificultty;
		this.story = story;
		this.graphic = graphic;
		this.sound = sound;
		this.volume = volume;
		this.controll = controll;
		this.promotion = promotion;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		this.midashi = midashi;
		this.feature = feature;
		this.upload_date = upload_date;
		this.upload_time = upload_time;
		
		//this.ShijisyaList = ShijisyaList;
		//this.FushijisyaList = FushijisyaList;
		
		this.Shijisyasu = Shijisyasu;
		this.Fushijisyasu = Fushijisyasu;
		this.YourVote = Your_Vote;
	}
	public Rep_List_TO(String Rep_Code, String gamecode, String gametitle, String playername,
			double dificultty, double story, double graphic, double sound,
			double volume, double controll, double promotion,
			String jiyuten_koumoku1, String jiyuten_koumoku2, String jiyuten_koumoku3, String jiyuten_koumoku4, String jiyuten_koumoku5, double jiyuten_score1, double jiyuten_score2, double jiyuten_score3, double jiyuten_score4, double jiyuten_score5,
			double jiyuten_maxscore1, double jiyuten_maxscore2, double jiyuten_maxscore3, double jiyuten_maxscore4, double jiyuten_maxscore5,
			String outline, String upload_date, String upload_time, String uploadfilename, int Shijisyasu, int Fushijisyasu, String Your_Vote) {
		//ゲームデータからのベストレポート呼び出し用TO（自由形式レポート）
		this.report_code = Rep_Code;
		this.gamecode = gamecode;
		this.gametitle = gametitle;
		this.login_name = playername;
		this.dificultty = dificultty;
		this.story = story;
		this.graphic = graphic;
		this.sound = sound;
		this.volume = volume;
		this.controll = controll;
		this.promotion = promotion;
		
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
		
		this.jiyuten_maxscore1 = jiyuten_maxscore1;
		this.jiyuten_maxscore2 = jiyuten_maxscore2;
		this.jiyuten_maxscore3 = jiyuten_maxscore3;
		this.jiyuten_maxscore4 = jiyuten_maxscore4;
		this.jiyuten_maxscore5 = jiyuten_maxscore5;
		
		this.outline = outline;
		this.upload_date = upload_date;
		this.upload_time = upload_time;
		this.UploadFileName = uploadfilename;
		
		//this.ShijisyaList = ShijisyaList;
		//this.FushijisyaList = FushijisyaList;
		
		this.Shijisyasu = Shijisyasu;
		this.Fushijisyasu = Fushijisyasu;
		this.YourVote = Your_Vote;
	}
	public Rep_List_TO(String Rep_Code, String GameCode, String GameTitle, String Kikakusya, String MainGenre,//提案レポートの概要呼び出し
			String CatchCopy, String UploadDate) {
		this.report_code = Rep_Code;
		this.gamecode = GameCode;
		this.gametitle = GameTitle;
		this.kikakusya = Kikakusya;
		this.MainGenre = MainGenre;
		this.catchcopy = CatchCopy;
		this.upload_date = UploadDate;
	}
	
	public Rep_List_TO(int Shijisyasu, int Fushijisyasu, String YourVote){
		this.Shijisyasu = Shijisyasu;
		this.Fushijisyasu = Fushijisyasu;
		this.YourVote = YourVote;
	}
	
	public Rep_List_TO(String UploadDate, String Rep_Code, String GameCode, String GameTitle, String Comment, String GPRO_ID, String PlayerName, String Seinengappi,
			String Sex, String Pref, String Job) {
		this.upload_date = UploadDate;
		this.report_code = Rep_Code;
		this.gamecode = GameCode;
		this.gametitle = GameTitle;
		this.comment = Comment;
		this.k_id = GPRO_ID;
		this.login_name = PlayerName;
		this.Seinengappi = Seinengappi;
		this.Sex = Sex;
		this.Pref = Pref;
		this.Job = Job;
	}
	public Rep_List_TO(String Comment, int Nendai, String Sex) {
		this.comment = Comment;
		this.Age = Nendai;
		this.Sex = Sex;
	}
	public String getgamecode() {return gamecode;}
	public void setgamecode(String gamecode) {this.gamecode = gamecode;}
	
	public String getgametitle() {return gametitle;}
	public void setgametitle(String gametitle) {this.gametitle = gametitle;}
	
	
	public String getCatchcopy() {return catchcopy;}
	public void setCatchcopy(String CatchCopy) {this.catchcopy = CatchCopy;}
	
	public String getKikakusya() {return kikakusya;}
	public void setKikakusya(String Kikakusya) {this.kikakusya = Kikakusya;}
	
	public String getKaihatsujyoukyou() {return kaihatsujyoukyou;}
	public void setKaihatsujyoukyou(String KaihatsuJyoukyou) {this.kaihatsujyoukyou = KaihatsuJyoukyou;}
	
	
	public String getreport_code() {return report_code;}
	public void setreportcode(String report_code) {this.report_code = report_code;}
	
	public double getSaiyou_bonus() {return saiyou_bonus;}
	public void setSaiyou_bonus(double saiyou_bonus) {this.saiyou_bonus = saiyou_bonus;}
	
	public String getupload_date() {return upload_date;}
	public void setupload_date(String upload_date) {this.upload_date = upload_date;}
	
	public String gethyouka_rank() {return hyouka_rank;}
	public void sethyouka_rank(String hyouka_rank) {this.hyouka_rank = hyouka_rank;}
	
	public String getShinsaJyoukyou() {return shinsajyoukyou;}
	public void setShinsaJyoukyou(String ShinsaJyoukyou) {this.shinsajyoukyou = ShinsaJyoukyou;}
	
	
	public String getk_id() {return k_id;}
	public void setk_id(String k_id) {this.k_id = k_id;}
	
	public String getlogin_name() {return login_name;}
	public void setlogin_name(String login_name) {this.login_name = login_name;}
	
	
	public String getSeinengappi() {return Seinengappi;}
	public void setSeinengappi(String Seinengappi) {this.Seinengappi = Seinengappi;}
	
	public String getSex() {return Sex;}
	public void setSex(String Sex) {this.Sex = Sex;}
	
	public String getJob() {return Job;}
	public void setJob(String Job) {this.Job = Job;}
	
	public String getPref() {return Pref;}
	public void setPref(String Pref) {this.Pref = Pref;}
	
	public int getAge() {return Age;}
	public void setAge(int Age) {this.Age = Age;}
	
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
	
	
	public String getoutline() {return outline;}
	public void setoutline(String outline) {this.outline = outline;}
	
	
	public String getgoodies() {return goodies;} //○×レポート用
	public void setgoodies(String goodies) {this.goodies = goodies;}
	
	public String getbadies() {return badies;}
	public void setbadies(String badies) {this.badies = badies;}
	
	
	public String getmidashi() {return midashi;} //記事レポート用
	public void setmidashi(String midashi) {this.midashi = midashi;}
	
	public String getfeature() {return feature;}
	public void setfeature(String feature) {this.feature = feature;}
	
	public String getevaluate() {return evaluate;}
	public void setevaluate(String evaluate) {this.evaluate = evaluate;}
	
	
	public String getComment() {return comment;}
	public void setComment(String comment) {this.comment = comment;
	}
	public String getKonyu_houhou() {return Konyu_houhou;}
	public void setKonyu_houhou(String Konyu_Houhou) {Konyu_houhou = Konyu_Houhou;}
	
	
	public String[] getInterview1() {return Interview1;} //共通インタビュー項目
	public void setInterview1(String[] interview1) {this.Interview1 = interview1;}
	
	
	public String getInterview2() {return Interview2;}
	public void setInterview2(String interview2) {this.Interview2 = interview2;}
	
	
	public String[] getInterview3() {return Interview3;}
	public void setInterview3(String interview3[]) {this.Interview3 = interview3;}
	
	
	public String getInterview4() {return Interview4;}
	public void setInterview4(String interview4) {this.Interview4 = interview4;}
	
	public String[] getInterview5_1() {return Interview5;}
	public void setInterview5_1(String[] interview5) {this.Interview5 = interview5;}
	
	public String getInterview6_1() {return Interview6;}
	public void setInterview6_1(String interview6) {this.Interview6 = interview6;	}
	
	
	public String getUploadFileName() {return UploadFileName;}
	public void setUploadFileName(String UploadFileName) {this.UploadFileName = UploadFileName;}
	
	
	public String getMakerName() {return MakerName;}
	public void setMakerName(String makerName) {this.MakerName = makerName;}
	
	public String getHatsubaiNengappi() {return HatsubaiNengappi;}
	public void setHatsubaiNengappi(String hatsubaiNengappi) {this.HatsubaiNengappi = hatsubaiNengappi;}
	
	public String getMainGenre() {return MainGenre;}
	public void setMainGenre(String mainGenre) {this.MainGenre = mainGenre;}
	
	public String getPlatForm() {return PlatForm;}
	public void setPlatForm(String platForm) {this.PlatForm = platForm;}
	
	public String getUpload_time() {return upload_time;}
	public void setUpload_time(String upload_time) {this.upload_time = upload_time;}
	
	public String getKeisaiJyoukyou() {return keisaijyoukyou;}
	public void setKeisaiJyoukyou(String KeisaiJyoukyou) {this.keisaijyoukyou = KeisaiJyoukyou;}
	
	public double getRep_score() {return rep_score;}
	public void setRep_score(double rep_score) {this.rep_score = rep_score;}
	
	
	public String getShijisyaList() {return ShijisyaList;}
	public void setShijisyaList(String shijisyaList) {this.ShijisyaList = shijisyaList;}
	
	public String getFushijisyaList() {	return FushijisyaList;}
	public void setFushijisyaList(String FushijisyaList) {this.FushijisyaList = FushijisyaList;}
	
	public int getShijisyasu() {return Shijisyasu;}
	public void setShijisyasu(int Shijisyasu) {this.Shijisyasu = Shijisyasu;}
	
	public int getFushijisyasu() {return Fushijisyasu;}
	public void setFushijisyasu(int Fushijisyasu) {this.Fushijisyasu = Fushijisyasu;}
	
	public String getYourVote() {return YourVote;}
	public void setYourVote(String YourVote) {this.YourVote = YourVote;}
}
