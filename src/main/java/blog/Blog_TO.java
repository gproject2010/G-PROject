package blog;

public class Blog_TO {

	private String BlogCode;
	private String KijiCode;
	private String Title;
	private String Sakuseisya_ID;
	private String Sakuseisya_Name;
	private String UploadDate;
	private String Honbun;
	private int Lock_Info;

	public Blog_TO(String BlogCode, String KijiCode, String Title, String Sakuseisya_ID, String Sakuseisya_Name, String UploadDate,
			String Honbun, int Lock_Info) {
		this.BlogCode = BlogCode;
		this.Title = Title;
		this.Sakuseisya_ID = Sakuseisya_ID;
		this.Sakuseisya_Name = Sakuseisya_Name;
		this.UploadDate = UploadDate;
		this.Honbun = Honbun;
		this.Lock_Info = Lock_Info;
	}

	public Blog_TO() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public String getBlogCode() {return BlogCode;}
	public void setBlogCode(String BlogCode) {this.BlogCode = BlogCode;}

	public String getKijiCode() {return KijiCode;}
	public void setKijiCode(String KijiCode) {this.KijiCode = KijiCode;}

	public String getTitle() {return Title;}
	public void setTitle(String Title) {this.Title = Title;}

	public String getSakuseisya_ID() {return Sakuseisya_ID;}
	public void setSakuseisya_ID(String Sakuseisya_ID) {this.Sakuseisya_ID = Sakuseisya_ID;}

	public String getSakuseisya_Name() {return Sakuseisya_Name;}
	public void setSakuseisya_Name(String Sakuseisya_Name) {this.Sakuseisya_Name = Sakuseisya_Name;}

	public String getUploadDate() {return UploadDate;}
	public void setUploadDate(String UploadDate) {this.UploadDate = UploadDate;}

	public String getHonbun() {return Honbun;}
	public void setHonbun(String Honbun) {this.Honbun = Honbun;}

	public int getLock_Info() {return Lock_Info;}
	public void setLock_Info(int Lock_Info) {this.Lock_Info = Lock_Info;}

}
