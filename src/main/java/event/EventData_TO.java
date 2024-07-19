package event;

public class EventData_TO {

	private String EventCode;
	private String EventName;
	private String Grade;
	private String KaisaiDate;
	private String Kaijyoumei;
	private String Kaisaijikan;
	private String Event_Master;
	private String Uketsuke_Jyoukyou;
	private String Logofile_Name;
	
	private String Sanka_Shimekiri;
	private String Kounin_Jyoukyou;
	private String Sankahouhou;
	private String Sankahi;
	private String Judge_Master;
	private String Sanka_Shikaku;
	private String Yosen_Keishiki;
	private String Kessyou_Keishiki;
	
	private String Eventshiryou1;
	private String Eventshiryou2;
	private String Eventshiryou3;
	private double Shiryou1_Size;
	private double Shiryou2_Size;
	private double Shiryou3_Size;
	
	private String KoumokuList;
	private String InputTypeList;
	private String MojikeishikiList;
	private String MaxLengthList;
	
	private String[] KoumokuList_A;
	private String[] InputTypeList_A;
	private String[] MojikeishikiList_A;
	private String[] MaxLengthList_A;
	
	
	private String Entry_Name;
	private String Entry_Name_Yomi;
	private String Pref;
	private String MailAddress;
	
	private String Koumoku1;
	private String Koumoku2;
	private String Koumoku3;
	private String Koumoku4;
	private String Koumoku5;
	
	private String NameError;
	private String YomiError;
	private String PrefError;
	private String MailError;
	
	private String KoumokuError1;
	private String KoumokuError2;
	private String KoumokuError3;
	private String KoumokuError4;
	private String KoumokuError5;
	
	private String Bikou;
	private String BikouError;
	
	private int Option_Mode;
	private String System_URL;
	private String Toiawasesaki;
	
	private String First;//ここより大会結果用
	private String Second;
	private String Third;
	private String Fourth;
	
	private int Rank;
	
	private String ScoreKoumoku1;
	private String ScoreKoumoku2;
	private String ScoreKoumoku3;
	private String ScoreKoumoku4;
	
	private String Score1;
	private String Score2;
	private String Score3;
	private String Score4;
	private String TotalScore;
	private String Syusei_Riyu;
	
	public EventData_TO(String EventCode, String EventName, String Grade, String KaisaiDate, String Event_Master,
			String Uketsuke_Jyoukyou, String Kaijyoumei, String Logofile_Name) {
		this.EventCode = EventCode;
		this.EventName = EventName;
		this.Grade = Grade;
		this.KaisaiDate = KaisaiDate;
		this.Event_Master = Event_Master;
		this.Uketsuke_Jyoukyou = Uketsuke_Jyoukyou;
		this.Kaijyoumei = Kaijyoumei;
		this.Logofile_Name = Logofile_Name;
	}

	public EventData_TO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public EventData_TO(String EventCode, String EventName, String Grade, String KaisaiDate, String Sanka_Shimekiri, String Kounin_Jyoukyou,
			String Uketsuke_Jyoukyou, String Kaijyoumei, String Kaisaijikan, String Sankahouhou, String Sankahi, String LogoFile_Name, String Judge_Master,
			String Event_Master, String Sanka_Shikaku, String Yosen_Keishiki, String Kessyou_Keishiki, String Eventshiryou1, String Eventshiryou2, String Eventshiryou3, double Shiryou1_Size, double Shiryou2_Size, double Shiryou3_Size, int Option_Mode, String System_URL, String Toiawasesaki) {
		this.EventCode = EventCode;
		this.EventName = EventName;
		this.Grade = Grade;
		this.KaisaiDate = KaisaiDate;
		this.Sanka_Shimekiri = Sanka_Shimekiri;
		this.Kounin_Jyoukyou = Kounin_Jyoukyou;
		this.Uketsuke_Jyoukyou = Uketsuke_Jyoukyou;
		this.Kaijyoumei = Kaijyoumei;
		this.Kaisaijikan = Kaisaijikan;
		this.Sankahouhou = Sankahouhou;
		this.Sankahi = Sankahi;
		this.Logofile_Name = LogoFile_Name;
		this.Judge_Master = Judge_Master;
		this.Event_Master = Event_Master;
		this.Sanka_Shikaku = Sanka_Shikaku;
		this.Yosen_Keishiki = Yosen_Keishiki;
		this.Kessyou_Keishiki = Kessyou_Keishiki;
		this.Eventshiryou1 = Eventshiryou1;
		this.Eventshiryou2 = Eventshiryou2;
		this.Eventshiryou3 = Eventshiryou3;
		this.Shiryou1_Size = Shiryou1_Size;
		this.Shiryou2_Size = Shiryou2_Size;
		this.Shiryou3_Size = Shiryou3_Size;
		this.Option_Mode = Option_Mode;
		this.System_URL = System_URL;
		this.Toiawasesaki = Toiawasesaki;
	}

	public EventData_TO(String EventCode, String EventName, String KoumokuList, String InputTypeList,
			String MojikeishikiList, String MaxLengthList) {
		this.EventCode = EventCode;
		this.EventName = EventName;
		this.KoumokuList = KoumokuList;
		this.InputTypeList = InputTypeList;
		this.MojikeishikiList = MojikeishikiList;
		this.MaxLengthList = MaxLengthList;
	}

	public EventData_TO(String EventCode, String EventName, String[] KoumokuList_A, String[] InputTypeList_A, String[] MojikeishikiList_A,
			String[] MaxLengthList_A) {
		this.EventCode = EventCode;
		this.EventName = EventName;
		this.KoumokuList_A = KoumokuList_A;
		this.InputTypeList_A = InputTypeList_A;
		this.MojikeishikiList_A = MojikeishikiList_A;
		this.MaxLengthList_A = MaxLengthList_A;
	}

	public EventData_TO(String Entry_Name, String Entry_Name_Yomi, String MailAddress, String Pref, String Koumoku1, String Koumoku2,
			String Koumoku3, String Koumoku4, String Koumoku5, String NameError, String YomiError, String MailError, String PrefError,
			String KoumokuError1, String KoumokuError2, String KoumokuError3, String KoumokuError4, String KoumokuError5, String Bikou, String BikouError) {
		this.Entry_Name = Entry_Name;
		this.Entry_Name_Yomi = Entry_Name_Yomi;
		this.MailAddress = MailAddress;
		this.Pref = Pref;
		this.Koumoku1 = Koumoku1;
		this.Koumoku2 = Koumoku2;
		this.Koumoku3 = Koumoku3;
		this.Koumoku4 = Koumoku4;
		this.Koumoku5 = Koumoku5;
		this.NameError = NameError;
		this.YomiError = YomiError;
		this.MailError = MailError;
		this.PrefError = PrefError;
		this.KoumokuError1 = KoumokuError1;
		this.KoumokuError2 = KoumokuError2;
		this.KoumokuError3 = KoumokuError3;
		this.KoumokuError4 = KoumokuError4;
		this.KoumokuError5 = KoumokuError5;
		this.Bikou = Bikou;
		this.BikouError = BikouError;
	}

	public EventData_TO(String First, String Second, String Third, String Fourth, String Syusei_Riyu) {
		this.First = First;
		this.Second = Second;
		this.Third = Third;
		this.Fourth = Fourth;
		this.Syusei_Riyu = Syusei_Riyu;
	}

	public EventData_TO(String EventCode, String EventName, int Rank, String ScoreKoumoku1, String ScoreKoumoku2,
			String ScoreKoumoku3, String ScoreKoumoku4, String Score1, String Score2, String Score3, String Score4,
			String TotalScore, String Entry_Name) {
		this.EventCode = EventCode;
		this.EventName = EventName;
		this.Rank = Rank;
		this.ScoreKoumoku1 = ScoreKoumoku1;
		this.ScoreKoumoku2 = ScoreKoumoku2;
		this.ScoreKoumoku3 = ScoreKoumoku3;
		this.ScoreKoumoku4 = ScoreKoumoku4;
		this.Score1 = Score1;
		this.Score2 = Score2;
		this.Score3 = Score3;
		this.Score4 = Score4;
		this.TotalScore = TotalScore;
		this.Entry_Name = Entry_Name;
	}

	public String getEventCode() {return EventCode;}
	public void setEventCode(String EventCode) {this.EventCode = EventCode;}

	public String getEventName() {return EventName;}
	public void setEventName(String EventName) {this.EventName = EventName;}

	public String getGrade() {return Grade;}
	public void setGrade(String Grade) {this.Grade = Grade;}

	public String getKaisaiDate() {return KaisaiDate;}
	public void setKaisaiDate(String KaisaiDate) {this.KaisaiDate = KaisaiDate;}

	public String getEvent_Master() {return Event_Master;}
	public void setEvent_Master(String Event_Master) {this.Event_Master = Event_Master;}

	public String getUketsuke_Jyoukyou() {return Uketsuke_Jyoukyou;}
	public void setUketsuke_Jyoukyou(String Uketsuke_Jyoukyou) {this.Uketsuke_Jyoukyou = Uketsuke_Jyoukyou;}

	public String getKaijyoumei() {return Kaijyoumei;}
	public void setKaijyoumei(String Kaijyoumei) {this.Kaijyoumei = Kaijyoumei;}

	public String getKaisaijikan() {return Kaisaijikan;}
	public void setKaisaijikan(String Kaisaijikan) {this.Kaisaijikan = Kaisaijikan;}

	public String getLogofile_Name() {return Logofile_Name;}
	public void setLogofile_Name(String Logofile_Name) {this.Logofile_Name = Logofile_Name;}

	public String getSanka_Shimekiri() {return Sanka_Shimekiri;}
	public void setSanka_Shimekiri(String Sanka_Shimekiri) {this.Sanka_Shimekiri = Sanka_Shimekiri;}

	public String getKounin_Jyoukyou() {return Kounin_Jyoukyou;}
	public void setKounin_Jyoukyou(String Kounin_Jyoukyou) {this.Kounin_Jyoukyou = Kounin_Jyoukyou;}

	public String getSankahouhou() {return Sankahouhou;}
	public void setSankahouhou(String Sankahouhou) {this.Sankahouhou = Sankahouhou;}

	public String getSankahi() {return Sankahi;}
	public void setSankahi(String Sankahi) {this.Sankahi = Sankahi;}

	public String getJudge_Master() {return Judge_Master;}
	public void setJudge_Master(String Judge_Master) {this.Judge_Master = Judge_Master;}

	public String getSanka_Shikaku() {return Sanka_Shikaku;}
	public void setSanka_Shikaku(String Sanka_Shikaku) {this.Sanka_Shikaku = Sanka_Shikaku;}

	public String getYosen_Keishiki() {return Yosen_Keishiki;}
	public void setYosen_Keishiki(String Yosen_Keishiki) {this.Yosen_Keishiki = Yosen_Keishiki;}

	public String getKessyou_Keishiki() {return Kessyou_Keishiki;}
	public void setKessyou_Keishiki(String Kessyou_Keishiki) {this.Kessyou_Keishiki = Kessyou_Keishiki;}

	public String getEventshiryou1() {return Eventshiryou1;}
	public void setEventshiryou1(String Eventshiryou1) {this.Eventshiryou1 = Eventshiryou1;}

	public String getEventshiryou2() {return Eventshiryou2;}
	public void setEventshiryou2(String Eventshiryou2) {this.Eventshiryou2 = Eventshiryou2;}

	public String getEventshiryou3() {return Eventshiryou3;}
	public void setEventshiryou3(String Eventshiryou3) {this.Eventshiryou3 = Eventshiryou3;}

	public double getShiryou1_Size() {return Shiryou1_Size;}
	public void setShiryou1_Size(double Shiryou1_Size) {this.Shiryou1_Size = Shiryou1_Size;}

	public double getShiryou2_Size() {return Shiryou2_Size;}
	public void setShiryou2_Size(double Shiryou2_Size) {this.Shiryou2_Size = Shiryou2_Size;}

	public double getShiryou3_Size() {return Shiryou3_Size;}
	public void setShiryou3_Size(double Shiryou3_Size) {this.Shiryou3_Size = Shiryou3_Size;}

	public String getKoumokuList() {return KoumokuList;}
	public void setKoumokuList(String KoumokuList) {this.KoumokuList = KoumokuList;}

	public String getInputTypeList() {return InputTypeList;}
	public void setInputTypeList(String InputTypeList) {this.InputTypeList = InputTypeList;}

	public String getMojikeishikiList() {return MojikeishikiList;}
	public void setMojikeishikiList(String MojikeishikiList) {this.MojikeishikiList = MojikeishikiList;}

	public String getMaxLengthList() {return MaxLengthList;}
	public void setMaxLengthList(String MaxLengthList) {this.MaxLengthList = MaxLengthList;}

	public String[] getKoumokuList_A() {return KoumokuList_A;}
	public void setKoumokuList_A(String[] KoumokuList_A) {this.KoumokuList_A = KoumokuList_A;}

	public String[] getInputTypeList_A() {return InputTypeList_A;}
	public void setInputTypeList_A(String[] InputTypeList_A) {this.InputTypeList_A = InputTypeList_A;}

	public String[] getMojikeishikiList_A() {return MojikeishikiList_A;}
	public void setMojikeishikiList_A(String[] MojikeishikiList_A) {this.MojikeishikiList_A = MojikeishikiList_A;}

	public String[] getMaxLengthList_A() {return MaxLengthList_A;}
	public void setMaxLengthList_A(String[] MaxLengthList_A) {this.MaxLengthList_A = MaxLengthList_A;}

	public String getEntry_Name() {return Entry_Name;}
	public void setEntry_Name(String Entry_Name) {this.Entry_Name = Entry_Name;}

	public String getEntry_Name_Yomi() {return Entry_Name_Yomi;}
	public void setEntry_Name_Yomi(String Entry_Name_Yomi) {this.Entry_Name_Yomi = Entry_Name_Yomi;}

	public String getMailAddress() {return MailAddress;}
	public void setMailAddress(String MailAddress) {this.MailAddress = MailAddress;}

	public String getPref() {return Pref;}
	public void setPref(String Pref) {this.Pref = Pref;}

	public String getKoumoku1() {return Koumoku1;}
	public void setKoumoku1(String Koumoku1) {this.Koumoku1 = Koumoku1;}

	public String getKoumoku2() {return Koumoku2;}
	public void setKoumoku2(String Koumoku2) {this.Koumoku2 = Koumoku2;}

	public String getKoumoku3() {return Koumoku3;}
	public void setKoumoku3(String Koumoku3) {this.Koumoku3 = Koumoku3;}

	public String getKoumoku4() {return Koumoku4;}
	public void setKoumoku4(String Koumoku4) {this.Koumoku4 = Koumoku4;}

	public String getKoumoku5() {return Koumoku5;}
	public void setKoumoku5(String Koumoku5) {this.Koumoku5 = Koumoku5;}

	public String getNameError() {return NameError;}
	public void setNameError(String NameError) {this.NameError = NameError;}

	public String getYomiError() {return YomiError;}
	public void setYomiError(String YomiError) {this.YomiError = YomiError;}

	public String getMailError() {return MailError;}
	public void setMailError(String MailError) {this.MailError = MailError;}

	public String getPrefError() {return PrefError;}
	public void setPrefError(String PrefError) {this.PrefError = PrefError;}

	public String getKoumokuError1() {return KoumokuError1;}
	public void setKoumokuError1(String KoumokuError1) {this.KoumokuError1 = KoumokuError1;}

	public String getKoumokuError2() {return KoumokuError2;}
	public void setKoumokuError2(String KoumokuError2) {this.KoumokuError2 = KoumokuError2;}

	public String getKoumokuError3() {return KoumokuError3;}
	public void setKoumokuError3(String KoumokuError3) {this.KoumokuError3 = KoumokuError3;}

	public String getKoumokuError4() {return KoumokuError4;}
	public void setKoumokuError4(String KoumokuError4) {this.KoumokuError4 = KoumokuError4;}

	public String getKoumokuError5() {return KoumokuError5;}
	public void setKoumokuError5(String KoumokuError5) {this.KoumokuError5 = KoumokuError5;}

	public String getBikou() {return Bikou;}
	public void setBikou(String Bikou) {this.Bikou = Bikou;}

	public String getBikouError() {return BikouError;}
	public void setBikouError(String BikouError) {this.BikouError = BikouError;}

	public int getOption_Mode() {return Option_Mode;}
	public void setOption_Mode(int Option_Mode) {this.Option_Mode = Option_Mode;}

	public String getSystem_URL() {return System_URL;}
	public void setSystem_URL(String System_URL) {this.System_URL = System_URL;}

	public String getToiawasesaki() {return Toiawasesaki;}
	public void setToiawasesaki(String Toiawasesaki) {this.Toiawasesaki = Toiawasesaki;}

	public String getFirst() {return First;}
	public void setFirst(String First) {this.First = First;}

	public String getSecond() {return Second;}
	public void setSecond(String Second) {this.Second = Second;}

	public String getThird() {return Third;}
	public void setThird(String Third) {this.Third = Third;}

	public String getFourth() {return Fourth;}
	public void setFourth(String Fourth) {this.Fourth = Fourth;}

	public String getScoreKoumoku1() {return ScoreKoumoku1;}
	public void setScoreKoumoku1(String ScoreKoumoku1) {this.ScoreKoumoku1 = ScoreKoumoku1;}

	public String getScoreKoumoku2() {return ScoreKoumoku2;}
	public void setScoreKoumoku2(String ScoreKoumoku2) {this.ScoreKoumoku2 = ScoreKoumoku2;}

	public String getScoreKoumoku3() {return ScoreKoumoku3;}
	public void setScoreKoumoku3(String ScoreKoumoku3) {this.ScoreKoumoku3 = ScoreKoumoku3;}

	public String getScoreKoumoku4() {return ScoreKoumoku4;}
	public void setScoreKoumoku4(String ScoreKoumoku4) {this.ScoreKoumoku4 = ScoreKoumoku4;}

	public String getScore1() {return Score1;}
	public void setScore1(String Score1) {this.Score1 = Score1;}

	public String getScore2() {return Score2;}
	public void setScore2(String Score2) {this.Score2 = Score2;}

	public String getScore3() {return Score3;}
	public void setScore3(String Score3) {this.Score3 = Score3;}

	public String getScore4() {return Score4;}
	public void setScore4(String Score4) {this.Score4 = Score4;}

	public String getTotalScore() {return TotalScore;}
	public void setTotalScore(String TotalScore) {this.TotalScore = TotalScore;}

	public int getRank() {return Rank;}
	public void setRank(int Rank) {this.Rank = Rank;}

	public String getSyusei_Riyu() {return Syusei_Riyu;}
	public void setSyusei_Riyu(String Syusei_Riyu) {this.Syusei_Riyu = Syusei_Riyu;}
}
