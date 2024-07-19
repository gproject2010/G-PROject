package pennant_race;

public class PennantData_TO {

	
	private String LeagueCode;
	private String LeagueName;
	private String LeagueClass;
	private int Season;
	private int Round;
	private String Kounin_Jyoukyou;
	private String Description;
	private String StartDate;
	private String EndDate;
	private String Logofile_Name;
	
	private String EventCode;
	private String EventName;
	
	private String GPRO_ID;
	private String Player_Name;
	private String Pref;
	private int Star_Count;
	private int Season_Star;
	
	public PennantData_TO(String LeagueCode, String LeagueName, String LeagueClass, int Season, int Round, String Kounin_Jyoukyou,
			String Description, String StartDate, String EndDate, String Logofile_Name) {
		this.LeagueCode = LeagueCode;
		this.LeagueName = LeagueName;
		this.LeagueClass = LeagueClass;
		this.Season = Season;
		this.Round = Round;
		this.Kounin_Jyoukyou = Kounin_Jyoukyou;
		this.Description = Description;
		this.StartDate = StartDate;
		this.EndDate = EndDate;
		this.Logofile_Name = Logofile_Name;
	}

	public PennantData_TO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public PennantData_TO(String LeagueCode, String LeagueName, String GPRO_ID, String Player_Name, String Pref, int Star_Count,
			int Season_Star) {
		this.LeagueCode = LeagueCode;
		this.LeagueName = LeagueName;
		this.GPRO_ID = GPRO_ID;
		this.Player_Name = Player_Name;
		this.Pref = Pref;
		this.Star_Count = Star_Count;
		this.Season_Star = Season_Star;
	}

	public PennantData_TO(String LeagueCode, String LeagueName, String EventCode, String EventName) {
		this.LeagueCode = LeagueCode;
		this.LeagueName = LeagueName;
		this.EventCode = EventCode;
		this.EventName = EventName;
	}

	public PennantData_TO(String LeagueCode, String LeagueName, String GPRO_ID, String Player_Name,
			int Star_Count, int Season_Star, String LeagueClass, int Season, String Logofile_Name) {
		this.LeagueCode = LeagueCode;
		this.LeagueName = LeagueName;
		this.GPRO_ID = GPRO_ID;
		this.Player_Name = Player_Name;
		this.Star_Count = Star_Count;
		this.Season_Star = Season_Star;
		this.LeagueClass = LeagueClass;
		this.Season = Season;
		this.Logofile_Name = Logofile_Name;
	}

	public String getLeagueCode() {return LeagueCode;}
	public void setLeagueCode(String LeagueCode) {this.LeagueCode = LeagueCode;}

	public String getLeagueName() {return LeagueName;}
	public void setLeagueName(String LeagueName) {this.LeagueName = LeagueName;}

	public String getLeagueClass() {return LeagueClass;}
	public void setLeagueClass(String LeagueClass) {this.LeagueClass = LeagueClass;}

	public int getSeason() {return Season;}
	public void setSeason(int Season) {this.Season = Season;}

	public int getRound() {return Round;}
	public void setRound(int Round) {this.Round = Round;}

	public String getKounin_Jyoukyou() {return Kounin_Jyoukyou;}
	public void setKounin_Jyoukyou(String Kounin_Jyoukyou) {this.Kounin_Jyoukyou = Kounin_Jyoukyou;}

	public String getDescription() {return Description;}
	public void setDescription(String Description) {this.Description = Description;}

	public String getStartDate() {return StartDate;}
	public void setStartDate(String StartDate) {this.StartDate = StartDate;}

	public String getEndDate() {return EndDate;}
	public void setEndDate(String EndDate) {this.EndDate = EndDate;}

	public String getLogofile_Name() {return Logofile_Name;}
	public void setLogofile_Name(String Logofile_Name) {this.Logofile_Name = Logofile_Name;}

	public String getEventCode() {return EventCode;}
	public void setEventCode(String EventCode) {this.EventCode = EventCode;}

	public String getEventName() {return EventName;}
	public void setEventName(String EventName) {this.EventName = EventName;}

	public String getGPRO_ID() {return GPRO_ID;}
	public void setGPRO_ID(String GPRO_ID) {this.GPRO_ID = GPRO_ID;}

	public String getPlayer_Name() {return Player_Name;}
	public void setPlayer_Name(String Player_Name) {this.Player_Name = Player_Name;}

	public String getPref() {return Pref;}
	public void setPref(String Pref) {this.Pref = Pref;}

	public int getStar_Count() {return Star_Count;}
	public void setStar_Count(int Star_Count) {this.Star_Count = Star_Count;}

	public int getSeason_Star() {return Season_Star;}
	public void setSeason_Star(int Season_Star) {this.Season_Star = Season_Star;}
	
	
}
