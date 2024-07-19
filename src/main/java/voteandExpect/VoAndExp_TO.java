package voteandExpect;


public class VoAndExp_TO {

	
	private String Anc_Code;
	private String Odai;
	private String Description;
	private String Resp_Mode;
	
	private String Start_Date;//日付処理の都合上Calendar型
	private String Vote_Shimekiri;
	private String Expect_Shimekiri;
	
	private String Vote_Bonus;
	private double VBonus_Sc;
	private String Expect_Bonus;
	private double ExpBonus_SC;
	
	private String Sentakushi_A;
	private String Sentakushi_B;
	private String Sentakushi_C;
	private String Sentakushi_D;
	
	private String SentakusyaList_A;
	private String SentakusyaList_B;
	private String SentakusyaList_C;
	private String SentakusyaList_D;
	
	private String YosousyaList_A;
	private String YosousyaList_B;
	private String YosousyaList_C;
	private String YosousyaList_D;
	
	private int Sentakusyasu_A;
	private int Sentakusyasu_B;
	private int Sentakusyasu_C;
	private int Sentakusyasu_D;
	private int Sentakusyasu_Total;
	
	private int Yosousyasu_A;
	private int Yosousyasu_B;
	private int Yosousyasu_C;
	private int Yosousyasu_D;
	private int Yosousyasu_Total;
	
	private String KaitouKahi;
	//private String vote_list;
	//private String Exp_List;
	
	private int Resp_Count;
	private int diff;
	
	private String Your_Vote;
	private String Your_Exp;
	private String MaxVote;
	private String MaxExp;
	
	private String GPRO_ID;
	private String Ins_Date;
	private String Answer;
	
	private int Answer_Count;
	
	public VoAndExp_TO(String Anc_Code, String Odai, String Resp_Mode, String Start_Date,
			String Vote_Shimekiri, String Expect_Shimekiri, int Resp_Count) {
		
		this.Anc_Code = Anc_Code;
		this.Odai = Odai;
		this.Resp_Mode = Resp_Mode;
		this.Start_Date = Start_Date;
		this.Vote_Shimekiri = Vote_Shimekiri;
		this.Expect_Shimekiri = Expect_Shimekiri;
		this.Resp_Count = Resp_Count;
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public VoAndExp_TO(){
		
	}

	public VoAndExp_TO(String Anc_Code, String Odai, String Resp_Mode,
			String Start_Date, String Vote_Shimekiri, String Expect_Shimekiri, int Resp_Count,
			String Vote_Bonus, double VBonus_Sc, String Expect_Bonus, double ExpBonus_Sc, 
			String Sentakushi_A, String Sentakushi_B, String Sentakushi_C, String Sentakushi_D,
			 String SentakusyaList_A, String SentakusyaList_B,
			String SentakusyaList_C, String SentakusyaList_D, String YosousyaList_A,
			String YosousyaList_B, String YosousyaList_C, String YosousyaList_D) {
		
		this.Anc_Code = Anc_Code;
		this.Odai = Odai;
		this.Resp_Mode = Resp_Mode;
		this.Start_Date = Start_Date;
		this.Vote_Shimekiri = Vote_Shimekiri;
		this.Expect_Shimekiri = Expect_Shimekiri;
		this.Resp_Count = Resp_Count;
		this.Vote_Bonus = Vote_Bonus;
		this.VBonus_Sc = VBonus_Sc;
		this.Expect_Bonus = Expect_Bonus;
		this.ExpBonus_SC = ExpBonus_Sc;
		this.Sentakushi_A = Sentakushi_A;
		this.Sentakushi_B = Sentakushi_B;
		this.Sentakushi_C = Sentakushi_C;
		this.Sentakushi_D = Sentakushi_D;
		this.SentakusyaList_A = SentakusyaList_A;
		this.SentakusyaList_B = SentakusyaList_B;
		this.SentakusyaList_C = SentakusyaList_C;
		this.SentakusyaList_D = SentakusyaList_D;
		this.YosousyaList_A = YosousyaList_A;
		this.YosousyaList_B = YosousyaList_B;
		this.YosousyaList_C = YosousyaList_C;
		this.YosousyaList_D = YosousyaList_D;
	}

	public VoAndExp_TO(int Sentakusyasu_A, int Sentakusyasu_B, int Sentakusyasu_C,
			int Sentakusyasu_D, int Sentakusyasu_Total, int Yosousyasu_A, int Yosousyasu_B,
			int Yosousyasu_C, int Yosousyasu_D, int Yosousyasu_Total, String KaitouKahi, String Your_Vote, String Your_Exp, int diff, String MaxVote, String MaxExp) {
		
		this.Sentakusyasu_A = Sentakusyasu_A;
		this.Sentakusyasu_B = Sentakusyasu_B;
		this.Sentakusyasu_C = Sentakusyasu_C;
		this.Sentakusyasu_D = Sentakusyasu_D;
		this.Sentakusyasu_Total = Sentakusyasu_Total;
		this.Yosousyasu_A = Yosousyasu_A;
		this.Yosousyasu_B = Yosousyasu_B;
		this.Yosousyasu_C = Yosousyasu_C;
		this.Yosousyasu_D = Yosousyasu_D;
		this.Yosousyasu_Total = Yosousyasu_Total;
		this.KaitouKahi = KaitouKahi;
		this.Your_Vote = Your_Vote;
		this.Your_Exp = Your_Exp;
		this.diff = diff;
		this.MaxVote = MaxVote;
		this.MaxExp = MaxExp;
	}

	public VoAndExp_TO(String Odai, String Vote_Shimekiri, String Sentakushi_A, String Sentakushi_B, String Sentakushi_C,
			String Sentakushi_D) {
		this.Odai = Odai;
		this.Vote_Shimekiri = Vote_Shimekiri;
		this.Sentakushi_A = Sentakushi_A;
		this.Sentakushi_B = Sentakushi_B;
		this.Sentakushi_C = Sentakushi_C;
		this.Sentakushi_D = Sentakushi_D;
	}

	public VoAndExp_TO(String Anc_Code, String SentakusyaList_A, String SentakusyaList_B, String SentakusyaList_C,
			String SentakusyaList_D, String YosousyaList_A, String YosousyaList_B, String YosousyaList_C,
			String YosousyaList_D) {
		this.Anc_Code = Anc_Code;
		this.SentakusyaList_A = SentakusyaList_A;
		this.SentakusyaList_B = SentakusyaList_B;
		this.SentakusyaList_C = SentakusyaList_C;
		this.SentakusyaList_D = SentakusyaList_D;
		this.YosousyaList_A = YosousyaList_A;
		this.YosousyaList_B = YosousyaList_B;
		this.YosousyaList_C = YosousyaList_C;
		this.YosousyaList_D = YosousyaList_D;
	}

	public VoAndExp_TO(String Anc_Code, String GPRO_ID, String Ins_Date, String Answer) {
		this.Anc_Code = Anc_Code;
		this.GPRO_ID = GPRO_ID;
		this.Ins_Date = Ins_Date;
		this.Answer = Answer;
	}

	public VoAndExp_TO(String Anc_Code, String Odai, String Description, String Start_Date, String Vote_Shimekiri,
			String Expect_Shimekiri, String Vote_Bonus, double VBonus_Sc, String Expect_Bonus,
			double ExpBonus_Sc) {

		this.Anc_Code = Anc_Code;
		this.Odai = Odai;
		this.Description = Description;
		this.Start_Date = Start_Date;
		this.Vote_Shimekiri = Vote_Shimekiri;
		this.Expect_Shimekiri = Expect_Shimekiri;
		this.Vote_Bonus = Vote_Bonus;
		this.VBonus_Sc = VBonus_Sc;
		this.Expect_Bonus = Expect_Bonus;
		this.ExpBonus_SC = ExpBonus_Sc;
	}
	
	public VoAndExp_TO(String Anc_Code, String Answer, int Answer_Count){
		this.Anc_Code = Anc_Code;
		this.Answer = Answer;
		this.Answer_Count = Answer_Count;
	}

	public VoAndExp_TO(String Anc_Code, String Odai, String StartDate, String Vote_Shimekiri,
			String Expect_Shimekiri) {
		this.Anc_Code = Anc_Code;
		this.Odai = Odai;
		this.Start_Date = StartDate;
		this.Vote_Shimekiri = Vote_Shimekiri;
		this.Expect_Shimekiri = Expect_Shimekiri;
	}

	public String getAnc_Code() {return Anc_Code;}
	public void setAnc_Code(String Anc_Code) {this.Anc_Code = Anc_Code;}

	public String getOdai() {return Odai;}
	public void setOdai(String Odai) {this.Odai = Odai;}

	public String getDescription() {return Description;}
	public void setDescription(String Description) {this.Description = Description;}

	public String getResp_Mode() {return Resp_Mode;}
	public void setResp_Mode(String Resp_Mode) {this.Resp_Mode = Resp_Mode;}

	public String getStart_Date() {return Start_Date;}
	public void setStart_Date(String Start_Date) {this.Start_Date = Start_Date;}

	public String getVote_Shimekiri() {return Vote_Shimekiri;}
	public void setVote_Shimekiri(String Vote_Shimekiri) {this.Vote_Shimekiri = Vote_Shimekiri;}

	public String getExpect_Shimekiri() {return Expect_Shimekiri;}
	public void setExpect_Shimekiri(String Expect_Shimekiri) {this.Expect_Shimekiri = Expect_Shimekiri;}

	public int getResp_Count() {return Resp_Count;}
	public void setResp_Count(int Resp_Count) {this.Resp_Count = Resp_Count;}

	public String getVote_Bonus() {return Vote_Bonus;}
	public void setVote_Bonus(String Vote_Bonus) {this.Vote_Bonus = Vote_Bonus;}

	public double getVBonus_Sc() {return VBonus_Sc;}
	public void setVBonus_Sc(double VBonus_Sc) {this.VBonus_Sc = VBonus_Sc;}

	public String getExpect_Bonus() {return Expect_Bonus;}
	public void setExpect_Bonus(String Expect_Bonus) {this.Expect_Bonus = Expect_Bonus;}

	public double getExpBonus_SC() {return ExpBonus_SC;}
	public void setExpBonus_SC(double ExpBonus_SC) {this.ExpBonus_SC = ExpBonus_SC;}

	
	public String getSentakushi_A() {return Sentakushi_A;}
	public void setSentakushi_A(String Sentakushi_A) {this.Sentakushi_A = Sentakushi_A;}

	public String getSentakushi_B() {return Sentakushi_B;}
	public void setSentakushi_B(String Sentakushi_B) {this.Sentakushi_B = Sentakushi_B;}

	public String getSentakushi_C() {return Sentakushi_C;}
	public void setSentakushi_C(String Sentakushi_C) {this.Sentakushi_C = Sentakushi_C;}

	public String getSentakushi_D() {return Sentakushi_D;}
	public void setSentakushi_D(String Sentakushi_D) {this.Sentakushi_D = Sentakushi_D;}

	public String getSentakusyaList_A() {return SentakusyaList_A;}
	public void setSentakusyaList_A(String SentakusyaList_A) {this.SentakusyaList_A = SentakusyaList_A;}

	public String getSentakusyaList_B() {return SentakusyaList_B;}
	public void setSentakusyaList_B(String SentakusyaList_B) {this.SentakusyaList_B = SentakusyaList_B;}

	public String getSentakusyaList_C() {return SentakusyaList_C;}
	public void setSentakusyaList_C(String SentakusyaList_C) {this.SentakusyaList_C = SentakusyaList_C;}

	public String getSentakusyaList_D() {return SentakusyaList_D;}
	public void setSentakusyaList_D(String SentakusyaList_D) {this.SentakusyaList_D = SentakusyaList_D;}

	public String getYosousyaList_A() {return YosousyaList_A;}
	public void setYosousyaList_A(String YosousyaList_A) {this.YosousyaList_A = YosousyaList_A;}

	public String getYosousyaList_B() {return YosousyaList_B;}
	public void setYosousyaList_B(String YosousyaList_B) {this.YosousyaList_B = YosousyaList_B;}

	public String getYosousyaList_C() {return YosousyaList_C;}
	public void setYosousyaList_C(String YosousyaList_C) {this.YosousyaList_C = YosousyaList_C;}

	public String getYosousyaList_D() {return YosousyaList_D;}
	public void setYosousyaList_D(String YosousyaList_D) {this.YosousyaList_D = YosousyaList_D;}

	public int getSentakusyasu_A() {return Sentakusyasu_A;}
	public void setSentakusyasu_A(int Sentakusyasu_A) {this.Sentakusyasu_A = Sentakusyasu_A;}

	public int getSentakusyasu_B() {return Sentakusyasu_B;}
	public void setSentakusyasu_B(int Sentakusyasu_B) {this.Sentakusyasu_B = Sentakusyasu_B;}

	public int getSentakusyasu_C() {return Sentakusyasu_C;}
	public void setSentakusyasu_C(int Sentakusyasu_C) {this.Sentakusyasu_C = Sentakusyasu_C;}

	public int getSentakusyasu_D() {return Sentakusyasu_D;}
	public void setSentakusyasu_D(int Sentakusyasu_D) {this.Sentakusyasu_D = Sentakusyasu_D;}

	public int getSentakusyasu_Total() {return Sentakusyasu_Total;}
	public void setSentakusyasu_Total(int Sentakusyasu_Total) {this.Sentakusyasu_Total = Sentakusyasu_Total;}

	public int getYosousyasu_A() {return Yosousyasu_A;}
	public void setYosousyasu_A(int Yosousyasu_A) {this.Yosousyasu_A = Yosousyasu_A;}

	public int getYosousyasu_B() {return Yosousyasu_B;}
	public void setYosousyasu_B(int Yosousyasu_B) {this.Yosousyasu_B = Yosousyasu_B;}

	public int getYosousyasu_C() {return Yosousyasu_C;}
	public void setYosousyasu_C(int Yosousyasu_C) {this.Yosousyasu_C = Yosousyasu_C;}

	public int getYosousyasu_D() {return Yosousyasu_D;}
	public void setYosousyasu_D(int Yosousyasu_D) {this.Yosousyasu_D = Yosousyasu_D;}

	public int getYosousyasu_Total() {return Yosousyasu_Total;}
	public void setYosousyasu_Total(int Yosousyasu_Total) {this.Yosousyasu_Total = Yosousyasu_Total;}

	public String getKaitouKahi() {return KaitouKahi;}
	public void setKaitouKahi(String KaitouKahi) {this.KaitouKahi = KaitouKahi;}

	public String getYour_Vote() {return Your_Vote;}
	public void setYour_Vote(String Your_Vote) {this.Your_Vote = Your_Vote;}

	public String getYour_Exp() {return Your_Exp;}
	public void setYour_Exp(String Your_Exp) {this.Your_Exp = Your_Exp;}

	public int getDiff() {return diff;}
	public void setDiff(int diff) {this.diff = diff;}

	public String getMaxVote() {return MaxVote;}
	public void setMaxVote(String MaxVote) {this.MaxVote = MaxVote;}

	public String getMaxExp() {return MaxExp;}
	public void setMaxExp(String MaxExp) {this.MaxExp = MaxExp;}

	public String getGPRO_ID() {return GPRO_ID;}
	public void setGPRO_ID(String GPRO_ID) {this.GPRO_ID = GPRO_ID;}

	public String getIns_Date() {return Ins_Date;}
	public void setIns_Date(String Ins_Date) {this.Ins_Date = Ins_Date;}

	public String getAnswer() {return Answer;}
	public void setAnswer(String Answer) {this.Answer = Answer;}

	public int getAnswer_Count() {return Answer_Count;}
	public void setAnswer_Count(int Answer_Count) {this.Answer_Count = Answer_Count;}

}
