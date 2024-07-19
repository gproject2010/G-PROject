package tool_download;

public class ToolDL_TO {

	private String ToolCode;
	private String ToolTitle;
	private String UploadTime;
	private String Seisakusya_ID;
	private String Seisakusya_Name;
	private String Youto;
	private String TaisyouGameTitle;
	private String Description;
	private String FileName;
	private String Readme_FileName;
	private int Lock_Info;

	public ToolDL_TO(String ToolCode, String ToolTitle, String UploadTime, String Seisakusya_Name,
			String TaisyouGameTitle, int Lock_Info) {
		this.ToolCode = ToolCode;
		this.ToolTitle = ToolTitle;
		this.UploadTime = UploadTime;
		this.Seisakusya_Name = Seisakusya_Name;
		this.TaisyouGameTitle = TaisyouGameTitle;
		this.Lock_Info = Lock_Info;
	}

	public ToolDL_TO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ToolDL_TO(String ToolCode, String ToolTitle, String UploadTime, String Seisakusya_ID,
			String Seisakusya_Name, String Youto, String TaisyouGameTitle, String Description, String FileName,
			String Readme_FileName, int Lock_Info) {
		this.ToolCode = ToolCode;
		this.ToolTitle = ToolTitle;
		this.UploadTime = UploadTime;
		this.Seisakusya_ID = Seisakusya_ID;
		this.Seisakusya_Name = Seisakusya_Name;
		this.Youto = Youto;
		this.TaisyouGameTitle = TaisyouGameTitle;
		this.Description = Description;
		this.FileName = FileName;
		this.Readme_FileName = Readme_FileName;
		this.Lock_Info = Lock_Info;
	}

	public String getToolCode() {return ToolCode;}
	public void setToolCode(String ToolCode) {this.ToolCode = ToolCode;}

	public String getToolTitle() {return ToolTitle;}
	public void setToolTitle(String ToolTitle) {this.ToolTitle = ToolTitle;}

	public String getUploadTime() {return UploadTime;}
	public void setUploadTime(String UploadTime) {this.UploadTime = UploadTime;}

	public String getSeisakusya_ID() {return Seisakusya_ID;}
	public void setSeisakusya_ID(String Seisakusya_ID) {this.Seisakusya_ID = Seisakusya_ID;}

	public String getSeisakusya_Name() {return Seisakusya_Name;}
	public void setSeisakusya_Name(String Seisakusya_Name) {this.Seisakusya_Name = Seisakusya_Name;}

	public String getYouto() {return Youto;}
	public void setYouto(String Youto) {this.Youto = Youto;}

	public String getTaisyouGameTitle() {return TaisyouGameTitle;}
	public void setTaisyouGameTitle(String TaisyouGameTitle) {this.TaisyouGameTitle = TaisyouGameTitle;}

	public String getDescription() {return Description;}
	public void setDescription(String Description) {this.Description = Description;}

	public String getFileName() {return FileName;}
	public void setFileName(String FileName) {this.FileName = FileName;}

	public String getReadme_FileName() {return Readme_FileName;}
	public void setReadme_FileName(String Readme_FileName) {this.Readme_FileName = Readme_FileName;}

	public int getLock_Info() {return Lock_Info;}
	public void setLock_Info(int Lock_Info) {this.Lock_Info = Lock_Info;}
}
