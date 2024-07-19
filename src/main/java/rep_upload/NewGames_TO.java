package rep_upload;

import java.util.Calendar;

public class NewGames_TO {

	private String Rep_Code;
	private String GameCode;
	private String GameTitle;//ゲームタイトル(企画名称)
	private String MainGenre;//メインジャンル
	private String SubGenre1;//サブジャンル1
	private String SubGenre2;//サブジャンル2
	private String PlatForm;//想定しているプラットフォーム
	private String CatchCopy;//企画のキャッチコピー
	
	private String PenName;
	private String Kikakusya_Sei;//企画者(共同制作の場合は代表者)の本名(姓)
	private String Kikakusya_Mei;//企画者の本名(名)
	private String Seifurigana;//企画者本名（姓ふりがな）
	private String Meifurigana;//企画者本名（名ふりがな）
	private String Hogosyasei;//保護者名(姓)
	private String Hogosyamei;//保護者名(名)
	private Calendar Seinengappi;//企画者生年月日(日付処理の都合上Calendar型)
	private String Seinengappi_S;//企画者生年月日（Stringに変換後）
	private String Pref;//企画者住所(都道府県)
	private String Jyusyo;//企画者住所(市町村名以下)
	private String Tel_No;//電話番号(固定電話)
	private String Keitai_No;//携帯番号
	private String Fax_No;//FAX番号
	private String MailAddress;//メールアドレス
	private String Url;//企画者が開設しているHPのURL
	private String Syokugyou;//企画者の現在の職業
	private String Tsutomesaki;//勤務・通学先名称
	private String TsutomesakiJyusyo;//勤務・通学先住所
	private String Seisakurireki;//ゲーム企画の制作履歴
	
	private String Gaiyou;
	private String Kikakuito;//企画意図
	private String Target;//ターゲット層
	private String Sabetsuka;//他作品との差別化
	private String Advantage;//企画の実現に有利な条件
	
	private String Kikakuryou_Uketori;//企画料の受け取り方法
	private int Kikakuryou;//一括で受け取る場合の企画料(具体的な金額が決まっている場合)
	private double Royality;//ロイヤリティで受け取る場合(具体的に何％かが決まっている場合)
	private String Bikou;//その他の条件
	
	private String[] Koukaisettei;//一般会員に公開するデータのリスト
	private String Koukaisettei_S;
	private String Koukaisettei_etc;//公開設定のその他項目
	
	private String FileName;//企画資料のファイル名
	private String LogoAddress;
	private String SetteiShiryou;
	private String KikakuKaisetsusyo;
	private String Taikenban;
	private String MovieAddress;
	private String EtcData;
	
	private String Kaiin_ID;
	private String Kaiin_Name;
	private String UploadTime_S;
	private int Seigen_Kaisu;
	
	private boolean NGHit;//NGワードを検出したことを表すフラグ
	private boolean NoSign;//保護者名の入力が必要な場合、入力がないことを表すフラグ
	private boolean NoData;
	private boolean Wrong;
	
	public NewGames_TO(String GameTitle, String MainGenre, String SubGenre1,
			String SubGenre2, String PlatForm, String CatchCopy, String Gaiyou, String PenName,
			String Kikakusya_Sei, String Kikakusya_Mei, String Seifurigana,
			String Meifurigana, String Hogosyasei, String Hogosyamei,
			Calendar Seinengappi, String Pref, String Jyusyo, String Tel_No,
			String Keitai_No, String Fax_No, String MailAddress, String Url,
			String Syokugyou, String Tsutomesaki, String TsutomesakiJyusyo,
			String Seisakurireki, String Kikakuito, String Target,
			String Sabetsuka, String Advantage, String Kikakuryou_Uketori, int Kikakuryou,
			double Royality, String Bikou, String[] Koukaisettei,
			String Koukaisettei_etc, boolean NGHit, boolean NoSign, boolean NoData, boolean Wrong) {
		// TODO 自動生成されたコンストラクター・スタブ
		
		this.GameTitle = GameTitle;
		this.MainGenre = MainGenre;
		this.SubGenre1 = SubGenre1;
		this.SubGenre2 = SubGenre2;
		this.PlatForm = PlatForm;
		this.CatchCopy = CatchCopy;
		this.Gaiyou = Gaiyou;
		this.PenName = PenName;
		this.Kikakusya_Sei = Kikakusya_Sei;
		this.Kikakusya_Mei = Kikakusya_Mei;
		this.Seifurigana = Seifurigana;
		this.Meifurigana = Meifurigana;
		this.Hogosyasei = Hogosyasei;
		this.Hogosyamei = Hogosyamei;
		this.Seinengappi = Seinengappi;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Tel_No = Tel_No;
		this.Keitai_No = Keitai_No;
		this.Fax_No = Fax_No;
		this.MailAddress = MailAddress;
		this.Url = Url;
		this.Syokugyou = Syokugyou;
		this.Tsutomesaki = Tsutomesaki;
		this.TsutomesakiJyusyo = TsutomesakiJyusyo;
		this.Seisakurireki = Seisakurireki;
		this.Kikakuito = Kikakuito;
		this.Target = Target;
		this.Sabetsuka = Sabetsuka;
		this.Advantage = Advantage;
		this.Kikakuryou_Uketori = Kikakuryou_Uketori;
		this.Kikakuryou = Kikakuryou;
		this.Royality = Royality;
		this.Bikou = Bikou;
		this.Koukaisettei = Koukaisettei;
		this.Koukaisettei_etc = Koukaisettei_etc;
		
		this.NGHit = NGHit;
		this.NoSign = NoSign;
		this.NoData = NoData;
		this.Wrong = Wrong;
	}

	public NewGames_TO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public NewGames_TO(String Rep_Code, String GameTitle, String MainGenre, String SubGenre1,
			String SubGenre2, String PlatForm, String CatchCopy, String Gaiyou, String PenName,
			String Kikakusya_Sei, String Kikakusya_Mei, String Seifurigana,
			String Meifurigana, String Hogosyasei, String Hogosyamei,
			String Seinengappi_S, String Pref, String Jyusyo, String Tel_No,
			String Keitai_No, String Fax_No, String Mailaddress, String URL,
			String Syokugyou, String Kinmusaki, String KinmusakiJyusyo,
			String Seisakurireki, String Kikakuito, String Target,
			String Sabetsuka, String Advantage, String Kikakuryou_Uketori,
			int Kikakuryou, double Royality, String Bikou,
			String Koukaisettei_S, String FileName, String Kaiin_ID,
			String Kaiin_Name, String UploadTime_S) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.Rep_Code = Rep_Code;
		this.GameTitle = GameTitle;
		this.MainGenre = MainGenre;
		this.SubGenre1 = SubGenre1;
		this.SubGenre2 = SubGenre2;
		this.PlatForm = PlatForm;
		this.CatchCopy = CatchCopy;
		this.Gaiyou = Gaiyou;
		this.PenName = PenName;
		this.Kikakusya_Sei = Kikakusya_Sei;
		this.Kikakusya_Mei = Kikakusya_Mei;
		this.Seifurigana = Seifurigana;
		this.Meifurigana = Meifurigana;
		this.Hogosyasei = Hogosyasei;
		this.Hogosyamei = Hogosyamei;
		this.Seinengappi_S = Seinengappi_S;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Tel_No = Tel_No;
		this.Keitai_No = Keitai_No;
		this.Fax_No = Fax_No;
		this.MailAddress = Mailaddress;
		this.Url = URL;
		this.Syokugyou = Syokugyou;
		this.Tsutomesaki = Kinmusaki;
		this.TsutomesakiJyusyo = KinmusakiJyusyo;
		this.Seisakurireki = Seisakurireki;
		this.Kikakuito = Kikakuito;
		this.Target = Target;
		this.Sabetsuka = Sabetsuka;
		this.Advantage = Advantage;
		this.Kikakuryou_Uketori = Kikakuryou_Uketori;
		this.Kikakuryou = Kikakuryou;
		this.Royality = Royality;
		this.Bikou = Bikou;
		this.Koukaisettei_S = Koukaisettei_S;
		this.FileName = FileName;
		this.Kaiin_ID = Kaiin_ID;
		this.Kaiin_Name = Kaiin_Name;
		this.UploadTime_S = UploadTime_S;
	}

	public NewGames_TO(String ReportCode, String GameCode, String GameTitle, String MainGenre,
			String SubGenre1, String SubGenre2, String CatchCopy,
			String PenName, String URL, String Gaiyou, String LogoAddress,
			String SetteiShiryou, String Kikakukaisetsusyo,
			String Taikenban, String EtcData, String MovieAddress, int Seigen_Kaisu) {
		this.Rep_Code = ReportCode;
		this.GameCode = GameCode;
		this.GameTitle = GameTitle;
		this.MainGenre = MainGenre;
		this.SubGenre1 = SubGenre1;
		this.SubGenre2 = SubGenre2;
		this.CatchCopy = CatchCopy;
		this.PenName = PenName;
		this.Url = URL;
		this.Gaiyou = Gaiyou;
		this.LogoAddress = LogoAddress;
		this.SetteiShiryou = SetteiShiryou;
		this.KikakuKaisetsusyo = Kikakukaisetsusyo;
		this.Taikenban = Taikenban;
		this.EtcData = EtcData;
		this.MovieAddress = MovieAddress;
		this.Seigen_Kaisu = Seigen_Kaisu;
	}

	public NewGames_TO(String GameTitle, String MainGenre, String CatchCopy, String PenName) {
		this.GameTitle = GameTitle;
		this.MainGenre = MainGenre;
		this.CatchCopy = CatchCopy;
		this.PenName = PenName;
	}

	public String getRep_Code() {return Rep_Code;}
	public void setRep_Code(String Rep_Code) {this.Rep_Code = Rep_Code;}

	public String getGameCode() {return GameCode;}
	public void setGameCode(String GameCode) {this.GameCode = GameCode;}

	public String getGameTitle() {return GameTitle;}
	public void setGameTitle(String GameTitle) {this.GameTitle = GameTitle;}

	public String getMainGenre() {return MainGenre;}
	public void setMainGenre(String MainGenre) {this.MainGenre = MainGenre;}

	public String getSubGenre1() {return SubGenre1;}
	public void setSubGenre1(String SubGenre1) {this.SubGenre1 = SubGenre1;}

	public String getSubGenre2() {return SubGenre2;}
	public void setSubGenre2(String SubGenre2) {this.SubGenre2 = SubGenre2;}

	public String getPlatForm() {return PlatForm;}
	public void setPlatForm(String PlatForm) {this.PlatForm = PlatForm;}

	public String getCatchCopy() {return CatchCopy;}
	public void setCatchCopy(String CatchCopy) {this.CatchCopy = CatchCopy;}

	public String getPenName() {return PenName;}
	public void setPenName(String PenName) {this.PenName = PenName;}

	public String getKikakusya_Sei() {return Kikakusya_Sei;}
	public void setKikakusya_Sei(String Kikakusya_Sei) {this.Kikakusya_Sei = Kikakusya_Sei;}

	public String getKikakusya_Mei() {return Kikakusya_Mei;}
	public void setKikakusya_Mei(String Kikakusya_Mei) {this.Kikakusya_Mei = Kikakusya_Mei;}

	public String getSeifurigana() {return Seifurigana;}
	public void setSeifurigana(String Seifurigana) {this.Seifurigana = Seifurigana;}

	public String getMeifurigana() {return Meifurigana;}
	public void setMeifurigana(String Meifurigana) {this.Meifurigana = Meifurigana;}

	public String getHogosyasei() {return Hogosyasei;}
	public void setHogosyasei(String Hogosyasei) {this.Hogosyasei = Hogosyasei;}

	public String getHogosyamei() {return Hogosyamei;}
	public void setHogosyamei(String Hogosyamei) {this.Hogosyamei = Hogosyamei;}

	public Calendar getSeinengappi() {return Seinengappi;}
	public void setSeinengappi(Calendar Seinengappi) {this.Seinengappi = Seinengappi;}

	public String getSeinengappi_S() {return Seinengappi_S;}
	public void setSeinengappi_S(String Seinengappi_S) {this.Seinengappi_S = Seinengappi_S;}

	public String getPref() {return Pref;}
	public void setPref(String Pref) {this.Pref = Pref;}

	public String getJyusyo() {return Jyusyo;}
	public void setJyusyo(String Jyusyo) {this.Jyusyo = Jyusyo;}

	public String getTel_No() {return Tel_No;}
	public void setTel_No(String Tel_No) {this.Tel_No = Tel_No;}

	public String getKeitai_No() {return Keitai_No;}
	public void setKeitai_No(String Keitai_No) {this.Keitai_No = Keitai_No;}

	public String getFax_No() {return Fax_No;}
	public void setFax_No(String Fax_No) {this.Fax_No = Fax_No;}

	public String getMailAddress() {return MailAddress;}
	public void setMailAddress(String MailAddress) {this.MailAddress = MailAddress;}

	public String getUrl() {return Url;}
	public void setUrl(String Url) {this.Url = Url;}

	public String getSyokugyou() {return Syokugyou;}
	public void setSyokugyou(String Syokugyou) {this.Syokugyou = Syokugyou;}

	public String getTsutomesaki() {return Tsutomesaki;}
	public void setTsutomesaki(String Tsutomesaki) {this.Tsutomesaki = Tsutomesaki;}

	public String getTsutomesakiJyusyo() {return TsutomesakiJyusyo;}
	public void setTsutomesakiJyusyo(String TsutomesakiJyusyo) {this.TsutomesakiJyusyo = TsutomesakiJyusyo;}

	public String getSeisakurireki() {return Seisakurireki;}
	public void setSeisakurireki(String Seisakurireki) {this.Seisakurireki = Seisakurireki;}

	public String getGaiyou() {return Gaiyou;}
	public void setGaiyou(String Gaiyou) {this.Gaiyou = Gaiyou;}

	public String getKikakuito() {return Kikakuito;}
	public void setKikakuito(String Kikakuito) {this.Kikakuito = Kikakuito;}

	public String getTarget() {return Target;}
	public void setTarget(String Target) {this.Target = Target;}

	public String getSabetsuka() {return Sabetsuka;}
	public void setSabetsuka(String Sabetsuka) {this.Sabetsuka = Sabetsuka;}

	public String getAdvantage() {return Advantage;}
	public void setAdvantage(String Advantage) {this.Advantage = Advantage;}

	
	public String getKikakuryou_Uketori() {return Kikakuryou_Uketori;}
	public void setKikakuryou_Uketori(String Kikakuryou_Uketori) {this.Kikakuryou_Uketori = Kikakuryou_Uketori;}

	public int getKikakuryou() {return Kikakuryou;}
	public void setKikakuryou(int Kikakuryou) {this.Kikakuryou = Kikakuryou;}

	public double getRoyality() {return Royality;}
	public void setRoyality(double Royality) {this.Royality = Royality;}

	public String getBikou() {return Bikou;}
	public void setBikou(String Bikou) {this.Bikou = Bikou;}

	public String[] getKoukaisettei() {return Koukaisettei;}
	public void setKoukaisettei(String[] Koukaisettei) {this.Koukaisettei = Koukaisettei;}

	public String getKoukaisettei_etc() {return Koukaisettei_etc;}
	public void setKoukaisettei_etc(String Koukaisettei_etc) {this.Koukaisettei_etc = Koukaisettei_etc;}

	public String getFileName() {return FileName;}
	public void setFileName(String FileName) {this.FileName = FileName;}

	
	public String getLogoAddress() {return LogoAddress;}
	public void setLogoAddress(String LogoAddress) {this.LogoAddress = LogoAddress;}

	public String getSetteiShiryou() {return SetteiShiryou;}
	public void setSetteiShiryou(String SetteiShiryou) {this.SetteiShiryou = SetteiShiryou;}

	public String getKikakuKaisetsusyo() {return KikakuKaisetsusyo;}
	public void setKikakuKaisetsusyo(String KikakuKaisetsusyo) {this.KikakuKaisetsusyo = KikakuKaisetsusyo;}

	public String getTaikenban() {return Taikenban;}
	public void setTaikenban(String Taikenban) {this.Taikenban = Taikenban;}

	public String getEtcData() {return EtcData;}
	public void setEtcData(String EtcData) {this.EtcData = EtcData;}

	public String getMovieAddress() {return MovieAddress;}
	public void setMovieAddress(String MovieAddress) {this.MovieAddress = MovieAddress;}

	public String getKoukaisettei_S() {return Koukaisettei_S;}
	public void setKoukaisettei_S(String Koukaisettei_S) {this.Koukaisettei_S = Koukaisettei_S;}
	

	public String getKaiin_ID() {return Kaiin_ID;}
	public void setKaiin_ID(String Kaiin_ID) {this.Kaiin_ID = Kaiin_ID;}

	public String getKaiin_Name() {return Kaiin_Name;}
	public void setKaiin_Name(String Kaiin_Name) {this.Kaiin_Name = Kaiin_Name;}

	public String getUploadTime_S() {return UploadTime_S;}
	public void setUploadTime_S(String UploadTime_S) {this.UploadTime_S = UploadTime_S;}
	
	public int getSeigen_Kaisu() {return Seigen_Kaisu;}
	public void setSeigen_Kaisu(int Seigen_Kaisu) {this.Seigen_Kaisu = Seigen_Kaisu;}

	public boolean isNGHit() {return NGHit;}
	public void setNGHit(boolean NGHit) {this.NGHit = NGHit;}

	public boolean isNoSign() {return NoSign;}
	public void setNoSign(boolean NoSign) {this.NoSign = NoSign;}

	public boolean isNoData() {return NoData;}
	public void setNoData(boolean NoData) {this.NoData = NoData;}

	public boolean isWrong() {return Wrong;}
	public void setWrong(boolean Wrong) {this.Wrong = Wrong;}
	
}
