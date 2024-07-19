package ninsyou;

public class Cookie_TO {

	private String GPRO_ID;
	private String Cookie;
	private String HostName;
	private String Hakkounichiji;
	
	public Cookie_TO(String GPRO_Id, String Cookie, String HostName, String Hakkounichiji) {
		this.GPRO_ID = GPRO_Id;
		this.Cookie = Cookie;
		this.HostName = HostName;
		this.Hakkounichiji = Hakkounichiji;
	}
	
	public Cookie_TO(String GPRO_Id, String Cookie, String HostName) {
		this.GPRO_ID = GPRO_Id;
		this.Cookie = Cookie;
		this.HostName = HostName;
	}

	public Cookie_TO() {
		
	}

	public String getGPRO_ID() {return GPRO_ID;}
	public void setGPRO_ID(String GPRO_ID) {this.GPRO_ID = GPRO_ID;}

	public String getCookie() {return Cookie;}
	public void setCookie(String Cookie) {this.Cookie = Cookie;}

	public String getHostName() {return HostName;}
	public void setHostName(String HostName) {this.HostName = HostName;}

	public String getHakkounichiji() {return Hakkounichiji;}
	public void setHakkounichiji(String Hakkounichiji) {this.Hakkounichiji = Hakkounichiji;
	
	}
}
