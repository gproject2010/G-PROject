package mail;

public class Toiawase_Koumoku {

	private String From;
	private String Toi_Syubetsu;
	private String Subject;
	private String Body;
	
	private boolean Nokoumoku;
	private boolean Wrong;
	
	public Toiawase_Koumoku(String From, String Toi_Syubetsu, String Subject, String Body, boolean Nokoumoku, boolean Wrong){
		this.From = From;//送信元メールアドレス
		this.Toi_Syubetsu = Toi_Syubetsu;//問い合わせ種別
		this.Subject = Subject;//題名
		this.Body = Body;//メール本文
		this.Nokoumoku = Nokoumoku;//入力されていない項目があるかを表すフラグ
		this.Wrong = Wrong;//不正な入力があるかを表すフラグ
	}
	
	public Toiawase_Koumoku(){
		
	}

	public String getFrom() {return From;}
	public void setFrom(String From) {this.From = From;}

	public String getToi_Syubetsu() {return Toi_Syubetsu;}
	public void setToi_Syubetsu(String Toi_Syubetsu) {this.Toi_Syubetsu = Toi_Syubetsu;}

	public String getSubject() {return Subject;}
	public void setSubject(String Subject) {this.Subject = Subject;}

	public String getBody() {return Body;}
	public void setBody(String Body) {this.Body = Body;}

	public boolean isNokoumoku() {return Nokoumoku;}
	public void setNokoumoku(boolean Nokoumoku) {this.Nokoumoku = Nokoumoku;}

	public boolean isWrong() {return Wrong;}
	public void setWrong(boolean Wrong) {this.Wrong = Wrong;}
}
