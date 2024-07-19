package k_jyouhou;

public class R_jyouhou_TO {
	
	private int k_Number;//会員番号
	private String k_Id;//ID
	private String login_name;//プレイヤーネーム
	private double reportScore_Kongetsu;//今月の暫定レポートスコア
	private double reportScore_Sengetsu;//先月のレポートスコア
	private double reportScore_Nenkan;//今年の暫定レポートスコア
	private double reportScore_Ruikei;//レポートスコア累計
	private int report_Count;//レポート提出数
	private int player_Level;//プレイヤーレベル
	private String SeinenGappi;
	private String Sex;
	private String Job;
	private String Pref;
	private double Mailage;
	private double actionScore_Kongetsu;//今月の暫定アクションスコア
	private double actionScore_Sengetsu;//先月のアクションスコア
	private double actionScore_Nenkan;//今年の暫定アクションスコア
	private double actionScore_Ruikei;//アクションスコア累計
	
	private int reportScore_Kongetsu_Rank;//今月の暫定レポートスコア
	private int reportScore_Sengetsu_Rank;//先月のレポートスコア
	private int reportScore_Nenkan_Rank;//今年の暫定レポートスコア
	private int reportScore_Ruikei_Rank;//レポートスコア累計
	private int report_Count_Rank;
	
	private int actionScore_Kongetsu_Rank;//今月の暫定レポートスコア
	private int actionScore_Sengetsu_Rank;//先月のレポートスコア
	private int actionScore_Nenkan_Rank;//今年の暫定レポートスコア
	private int actionScore_Ruikei_Rank;//レポートスコア累計
	
	private int Star_Count;
	private int Star_Count_Rank;
	private int Season_Star;
	private int Season_Star_Rank;
	
	private String Syougou;
	private String[] SyougouList;
	private String[] S_KakutokubiList;
	
	private boolean Lv_Up_Flg;//レベルアップしたことを表すフラグ
	
	/*public R_jyouhou_TO(int k_Number, String k_Id, String login_name, double reportScore_Ruikei, double reportScore_Kongetsu, double reportScore_Sengetsu, double reportScore_Nenkan, int report_Count, int player_Level,
			double actionScore_Kongetsu, double actionScore_Sengetsu, double actionScore_Nenkan, double actionScore_Ruikei, int nextLevel, double nextScore){

	this.k_Number = k_Number;
	this.k_Id = k_Id;
	this.login_name = login_name;
	this.reportScore_Ruikei =  reportScore_Ruikei;
	this.reportScore_Kongetsu = reportScore_Kongetsu;
	this.reportScore_Sengetsu = reportScore_Sengetsu;
	this.reportScore_Nenkan = reportScore_Nenkan;	
	this.report_Count = report_Count;
	this.player_Level = player_Level;
	this.actionScore_Kongetsu = actionScore_Kongetsu;
	this.actionScore_Sengetsu = actionScore_Sengetsu;
	this.actionScore_Nenkan = actionScore_Nenkan;
	this.actionScore_Ruikei = actionScore_Ruikei;
	this.nextLevel = nextLevel;
	this.nextScore = nextScore;
}*/
	
		public R_jyouhou_TO(int k_Number, String k_Id, String login_name, String SeinenGappi, String Sex, String Pref, double Mailage, double reportScore_Ruikei, double reportScore_Kongetsu, double reportScore_Sengetsu, double reportScore_Nenkan, int player_Level, int report_Count, 
				double actionScore_Kongetsu, double actionScore_Sengetsu, double actionScore_Nenkan, double actionScore_Ruikei, boolean Lv_Up_Flg, int reportScore_Ruikei_Rank, int reportScore_Kongetsu_Rank, int reportScore_Sengetsu_Rank, int reportScore_Nenkan_Rank, int report_Count_Rank,
				int actionScore_Ruikei_Rank, int actionScore_Kongetsu_Rank, int actionScore_Sengetsu_Rank, int actionScore_Nenkan_Rank, int Star_Count, int Star_Count_Rank, int Season_Star, int Season_Star_Rank, String Job, String Syougou, String[] SyougouList, String[] S_KakutokubiList){//会員ステータスを表すTO

		this.k_Number = k_Number;
		this.k_Id = k_Id;
		this.login_name = login_name;
		this.SeinenGappi = SeinenGappi;
		this.Sex = Sex;
		this.Pref = Pref;
		this.Mailage = Mailage;
		this.reportScore_Ruikei =  reportScore_Ruikei;
		this.reportScore_Kongetsu = reportScore_Kongetsu;
		this.reportScore_Sengetsu = reportScore_Sengetsu;
		this.reportScore_Nenkan = reportScore_Nenkan;	
		this.player_Level = player_Level;
		this.report_Count = report_Count;
		this.actionScore_Kongetsu = actionScore_Kongetsu;
		this.actionScore_Sengetsu = actionScore_Sengetsu;
		this.actionScore_Nenkan = actionScore_Nenkan;
		this.actionScore_Ruikei = actionScore_Ruikei;
		this.Lv_Up_Flg = Lv_Up_Flg;
		
		this.reportScore_Ruikei_Rank = reportScore_Ruikei_Rank;
		this.reportScore_Kongetsu_Rank = reportScore_Kongetsu_Rank;
		this.reportScore_Sengetsu_Rank = reportScore_Sengetsu_Rank;
		this.reportScore_Nenkan_Rank = reportScore_Nenkan_Rank;	
		this.report_Count_Rank = report_Count_Rank;
		
		this.Star_Count = Star_Count;
		this.Star_Count_Rank = Star_Count_Rank;
		this.Season_Star = Season_Star;
		this.Season_Star_Rank = Season_Star_Rank;
		
		this.actionScore_Kongetsu_Rank = actionScore_Kongetsu_Rank;
		this.actionScore_Sengetsu_Rank = actionScore_Sengetsu_Rank;
		this.actionScore_Nenkan_Rank = actionScore_Nenkan_Rank;
		this.actionScore_Ruikei_Rank = actionScore_Ruikei_Rank;
		this.Job = Job;
		
		this.Syougou = Syougou;
		this.SyougouList = SyougouList;
		this.S_KakutokubiList = S_KakutokubiList;
	}
	
	public R_jyouhou_TO(){
	}
	
	
	

	public int getk_Number() {return k_Number;}
	public void setk_Number(int k_Number) {this.k_Number = k_Number;}
	
	public String getk_Id() {return k_Id;}
	public void setk_Id(String k_Id) {this.k_Id = k_Id;}
	
	public String getlogin_name() {return login_name;}
	public void setlogin_name(String login_name) {this.login_name = login_name;}
	
	public String getSeinenGappi() {return SeinenGappi;}
	public void setSeinenGappi(String SeinenGappi) {this.SeinenGappi = SeinenGappi;}

	public String getSex() {return Sex;}
	public void setSex(String Sex) {this.Sex = Sex;}

	public String getJob() {return Job;}
	public void setJob(String Job) {this.Job = Job;}

	public String getPref() {return Pref;}
	public void setPref(String Pref) {this.Pref = Pref;}

	public double getMailage() {return Mailage;}
	public void setMailage(double Mailage) {this.Mailage = Mailage;}

	public double getreportScore_Kongetsu() {return reportScore_Kongetsu;}
	public void setreportScore_Kongetsu(double reportScore_Kongetsu) {this.reportScore_Kongetsu = reportScore_Kongetsu;}

	public double getreportScore_Sengetsu() {return reportScore_Sengetsu;}
	public void setreportScore_Sengetsu(double reportScore_Sengetsu) {this.reportScore_Sengetsu = reportScore_Sengetsu;}

	public double getreportScore_Nenkan() {return reportScore_Nenkan;}
	public void setreportScore_Nenkan(double reportScore_Nenkan) {this.reportScore_Nenkan = reportScore_Nenkan;}

	public double getreportScore_Ruikei() {return reportScore_Ruikei;}
	public void setreportScore_Ruikei(double reportScore_Ruikei) {this.reportScore_Ruikei = reportScore_Ruikei;}

	public int getreport_Count() {return report_Count;}
	public void setreport_Count(int report_Count) {this.report_Count = report_Count;}

	public int getStar_Count() {return Star_Count;}
	public void setStar_Count(int Star_Count) {this.Star_Count = Star_Count;}

	public int getStar_Count_Rank() {return Star_Count_Rank;}
	public void setStar_Count_Rank(int Star_Count_Rank) {this.Star_Count_Rank = Star_Count_Rank;}

	public int getSeason_Star() {return Season_Star;}
	public void setSeason_Star(int Season_Star) {this.Season_Star = Season_Star;}

	public int getSeason_Star_Rank() {return Season_Star_Rank;}
	public void setSeason_Star_Rank(int Season_Star_Rank) {this.Season_Star_Rank = Season_Star_Rank;}

	public int getplayer_Level() {return player_Level;}
	public void setplayer_Level(int player_Level) {this.player_Level = player_Level;}

	public double getactionScore_Kongetsu() {return actionScore_Kongetsu;}
	public void setactionScore_Kongetsu(double actionScore_Kongetsu) {this.actionScore_Kongetsu = actionScore_Kongetsu;}

	public double getActionScore_Sengetsu() {return actionScore_Sengetsu;}
	public void setActionScore_Sengetsu(double actionScore_Sengetsu) {this.actionScore_Sengetsu = actionScore_Sengetsu;}

	public double getActionScore_Nenkan() {return actionScore_Nenkan;}
	public void setActionScore_Nenkan(double actionScore_Nenkan) {this.actionScore_Nenkan = actionScore_Nenkan;}

	public double getActionScore_Ruikei() {return actionScore_Ruikei;}
	public void setActionScore_Ruikei(double actionScore_Ruikei) {this.actionScore_Ruikei = actionScore_Ruikei;}

	
	public int getReportScore_Kongetsu_Rank() {return reportScore_Kongetsu_Rank;}
	public void setReportScore_Kongetsu_Rank(int reportScore_Kongetsu_Rank) {this.reportScore_Kongetsu_Rank = reportScore_Kongetsu_Rank;}

	public int getReportScore_Sengetsu_Rank() {return reportScore_Sengetsu_Rank;}
	public void setReportScore_Sengetsu_Rank(int reportScore_Sengetsu_Rank) {this.reportScore_Sengetsu_Rank = reportScore_Sengetsu_Rank;}

	public int getReportScore_Nenkan_Rank() {return reportScore_Nenkan_Rank;}
	public void setReportScore_Nenkan_Rank(int reportScore_Nenkan_Rank) {this.reportScore_Nenkan_Rank = reportScore_Nenkan_Rank;}

	public int getReportScore_Ruikei_Rank() {return reportScore_Ruikei_Rank;}
	public void setReportScore_Ruikei_Rank(int reportScore_Ruikei_Rank) {this.reportScore_Ruikei_Rank = reportScore_Ruikei_Rank;}

	public int getReport_Count_Rank() {return report_Count_Rank;}
	public void setReport_Count_Rank(int report_Count_Rank) {this.report_Count_Rank = report_Count_Rank;}

	public int getActionScore_Kongetsu_Rank() {return actionScore_Kongetsu_Rank;}
	public void setActionScore_Kongetsu_Rank(int actionScore_Kongetsu_Rank) {this.actionScore_Kongetsu_Rank = actionScore_Kongetsu_Rank;}

	public int getActionScore_Sengetsu_Rank() {return actionScore_Sengetsu_Rank;}
	public void setActionScore_Sengetsu_Rank(int actionScore_Sengetsu_Rank) {this.actionScore_Sengetsu_Rank = actionScore_Sengetsu_Rank;}

	public int getActionScore_Nenkan_Rank() {return actionScore_Nenkan_Rank;}
	public void setActionScore_Nenkan_Rank(int actionScore_Nenkan_Rank) {this.actionScore_Nenkan_Rank = actionScore_Nenkan_Rank;}

	public int getActionScore_Ruikei_Rank() {return actionScore_Ruikei_Rank;}
	public void setActionScore_Ruikei_Rank(int actionScore_Ruikei_Rank) {this.actionScore_Ruikei_Rank = actionScore_Ruikei_Rank;}

	
	public boolean isLv_Up_Flg() {return Lv_Up_Flg;}
	public void setLv_Up_Flg(boolean Lv_Up_Flg) {this.Lv_Up_Flg = Lv_Up_Flg;}

	public String getSyougou() {return Syougou;}
	public void setSyougou(String Syougou) {this.Syougou = Syougou;}

	public String[] getSyougouList() {return SyougouList;}
	public void setSyougouList(String[] SyougouList) {this.SyougouList = SyougouList;}

	public String[] getS_KakutokubiList() {return S_KakutokubiList;}
	public void setS_KakutokubiList(String[] S_KakutokubiList) {this.S_KakutokubiList = S_KakutokubiList;}


}
