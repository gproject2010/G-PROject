package k_jyouhou;

public class K_Ranking_TO {

	private int k_Number;  //会員番号
	private String k_Id;//ID
	private int player_Level;//プレイヤーレベル
	private String login_Name;//プレイヤーネーム
	private double reportScore_Kongetsu;//今月のレポートスコア
	private double reportScore_Sengetsu;//先月のレポートスコア
	private double reportScore_Nenkan;//今年のレポートスコア
	private double reportScore_Ruikei;//レポートスコア累計
	private int report_Count;
	private int Rank;
	private int HitCount;
	
	private int PageSt;
	private int PageFin;
	
	/*public K_Ranking_TO(int k_Number, String k_Id, int player_Level, String login_Name, double reportScore_Ruikei, double reportScore_Kongetsu, double reportScore_Sengetsu, double reportScore_Nenkan, int report_Count, int Rank){

		this.k_Number = k_Number;
		this.k_Id = k_Id;
		this.player_Level = player_Level;
		this.login_Name = login_Name;
		this.reportScore_Ruikei =  reportScore_Ruikei;
		this.reportScore_Kongetsu = reportScore_Kongetsu;
		this.reportScore_Sengetsu = reportScore_Sengetsu;
		this.reportScore_Nenkan = reportScore_Nenkan;	
		this.report_Count = report_Count;
		this.Rank = Rank;
		
	}*/
	public K_Ranking_TO() {
		
	}
	
	public K_Ranking_TO(int k_Number, int player_Level, String login_Name, int report_Count, int Rank, int HitCount){
		this.k_Number = k_Number;//累計のレポート提出数ランキングのコンストラクタ
		this.player_Level = player_Level;
		this.login_Name = login_Name;
		this.report_Count = report_Count;
		this.Rank = Rank;
		this.HitCount = HitCount;
	}
	
	public K_Ranking_TO(int k_Number, int player_Level, String login_Name,
			double reportScore_Kongetsu, int Rank, int HitCount) {
		this.k_Number = k_Number;//レポートスコアに関する各種ランキングのコンストラクタ
		this.player_Level = player_Level;
		this.login_Name = login_Name;
		this.reportScore_Kongetsu = reportScore_Kongetsu;
		this.Rank = Rank;
		this.HitCount = HitCount;
		
	}

	public K_Ranking_TO(int PageSt, int PageFin) {
		this.PageSt = PageSt;
		this.PageFin = PageFin;
	}

	public int getk_Number() {return k_Number;}
	public void setk_Number(int k_Number) {this.k_Number = k_Number;}
	
	public String getk_Id() {return k_Id;}
	public void setk_Id(String k_Id) {this.k_Id = k_Id;}
	
	public int getplayer_Level() {return player_Level;}
	public void setplayer_Level(int player_Level) {this.player_Level = player_Level;}
	
	public String getlogin_Name() {return login_Name;}
	public void setlogin_Name(String login_Name) {this.login_Name = login_Name;}
	
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
	
	public int getRank() {return Rank;}
	public void setRank(int Rank) {this.Rank = Rank;}

	public int getHitCount() {return HitCount;}
	public void setHitCount(int HitCount) {this.HitCount = HitCount;}

	public int getPageSt() {return PageSt;}
	public void setPageSt(int PageSt) {this.PageSt = PageSt;}

	public int getPageFin() {return PageFin;}
	public void setPageFin(int PageFin) {this.PageFin = PageFin;}

}