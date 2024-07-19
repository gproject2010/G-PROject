package gpro_riron;

public class GPRiron_TO implements Cloneable{

	private String RonbunCode;
	private String RonbunTitle;
	private String Player_Id;
	private String PlayerName;
	private String UploadDate;
	private String KoushinDate;
	private String RespCode;
	private String Comment;
	private String[] ShijisyaList;
	private String[] FushijisyaList;
	private int Lock_Info;
	
	private String HTMLFileName;
	private String ImageFileName1;
	private String ImageFileName2;
	private String ImageFileName3;
	
	private String ImgFileUploadError1;
	private String ImgFileUploadError2;
	private String ImgFileUploadError3;
	private String HTMLFileUploadError;
	
	public GPRiron_TO(String RonbunCode, String RonbunTitle, String Player_Id, String PlayerName, String UploadDate, String KoushinDate) {
		this.RonbunCode = RonbunCode;
		this.RonbunTitle = RonbunTitle;
		this.Player_Id = Player_Id;
		this.PlayerName = PlayerName;
		this.UploadDate = UploadDate;
		this.KoushinDate = KoushinDate;
	}

	public GPRiron_TO() {
		
	}

	public GPRiron_TO(String RonbunCode, String RonbunTitle, String Player_Id, String PlayerName,
			String UploadDate, String[] ShijisyaList, String[] FushijisyaList, String HTMLFileName, String ImageFileName1, String ImageFileName2, String ImageFileName3) {
		this.RonbunCode = RonbunCode;
		this.RonbunTitle = RonbunTitle;
		this.Player_Id = Player_Id;
		this.PlayerName = PlayerName;
		this.UploadDate = UploadDate;
		this.ShijisyaList = ShijisyaList;
		this.FushijisyaList = FushijisyaList;
		this.HTMLFileName = HTMLFileName;
		this.ImageFileName1 = ImageFileName1;
		this.ImageFileName2 = ImageFileName2;
		this.ImageFileName3 = ImageFileName3;
	}

	public GPRiron_TO(String ImgFileUploadError1, String ImgFileUploadError2, String ImgFileUploadError3,
			String HTMLFileUploadError) {
		this.ImgFileUploadError1 = ImgFileUploadError1;
		this.ImgFileUploadError2 = ImgFileUploadError2;
		this.ImgFileUploadError3 = ImgFileUploadError3;
		this.HTMLFileUploadError = HTMLFileUploadError;
	}

	public GPRiron_TO(String UploadDate, String Player_Name, String Comment) {
		this.UploadDate = UploadDate;
		this.PlayerName = Player_Name;
		this.Comment = Comment;
	}

	public GPRiron_TO(String Ronbun_Code, String RespCode, String UploadDate, String Player_Name, String Comment) {
		this.RonbunCode = Ronbun_Code;
		this.RespCode = RespCode;
		this.UploadDate = UploadDate;
		this.PlayerName = Player_Name;
		this.Comment = Comment;
	}

	public String getRonbunCode() {return RonbunCode;}
	public void setRonbunCode(String RonbunCode) {this.RonbunCode = RonbunCode;}

	public String getRonbunTitle() {return RonbunTitle;}
	public void setRonbunTitle(String RonbunTitle) {this.RonbunTitle = RonbunTitle;}

	public String getPlayer_Id() {return Player_Id;}
	public void setPlayer_Id(String Player_Id) {this.Player_Id = Player_Id;}

	public String getPlayerName() {return PlayerName;}
	public void setPlayerName(String PlayerName) {this.PlayerName = PlayerName;}

	public String getUploadDate() {return UploadDate;}
	public void setUploadDate(String uploadDate) {this.UploadDate = uploadDate;}

	public String getKoushinDate() {return KoushinDate;}
	public void setKoushinDate(String KoushinDate) {this.KoushinDate = KoushinDate;}

	public String getRespCode() {return RespCode;}
	public void setRespCode(String RespCode) {this.RespCode = RespCode;}

	public String getComment() {return Comment;}
	public void setComment(String Comment) {this.Comment = Comment;}

	public String[] getShijisyaList() {return ShijisyaList;}
	public void setShijisyaList(String[] Shijisyasu) {this.ShijisyaList = Shijisyasu;}

	public String[] getFushijisyalist() {return FushijisyaList;}
	public void setFushijisyalist(String[] FushijisyaList) {this.FushijisyaList = FushijisyaList;}

	public int getLock_Info() {return Lock_Info;}
	public void setLock_Info(int Lock_Info) {this.Lock_Info = Lock_Info;}

	public String getHTMLFileName() {return HTMLFileName;}
	public void setHTMLFileName(String HTMLFileName) {this.HTMLFileName = HTMLFileName;}

	public String getImageFileName1() {return ImageFileName1;}
	public void setImageFileName1(String ImageFileName1) {this.ImageFileName1 = ImageFileName1;}

	public String getImageFileName2() {return ImageFileName2;}
	public void setImageFileName2(String ImageFileName2) {this.ImageFileName2 = ImageFileName2;}

	public String getImageFileName3() {return ImageFileName3;}
	public void setImageFileName3(String ImageFileName3) {this.ImageFileName3 = ImageFileName3;}

	public String getImgFileUploadError1() {return ImgFileUploadError1;}
	public void setImgFileUploadError1(String ImgFileUploadError1) {this. ImgFileUploadError1 = ImgFileUploadError1;}
	
	public String getImgFileUploadError2() {return ImgFileUploadError2;}
	public void setImgFileUploadError2(String ImgFileUploadError2) {this.ImgFileUploadError2 = ImgFileUploadError2;}

	public String getImgFileUploadError3() {return ImgFileUploadError3;}
	public void setImgFileUploadError3(String ImgFileUploadError3) {this.ImgFileUploadError3 = ImgFileUploadError3;}

	public String getHTMLFileUploadError() {return HTMLFileUploadError;}
	public void setHTMLFileUploadError(String HTMLFileUploadError) {this.HTMLFileUploadError = HTMLFileUploadError;}

		@Override
		public GPRiron_TO clone(){
			try{
			return (GPRiron_TO) super.clone();
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}
}
