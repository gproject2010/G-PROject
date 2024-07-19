package k_jyouhou;

public class K_jyouhou_TO {

	int kaiin_number;//会員番号
	String k_id;//ID
	String login_name;//プレイヤーネーム

	String sei_kanji;//姓(漢字)
	String mei_kanji;//名(漢字)
	String sei_kana;//姓(カナ)
	String mei_kana;//名(カナ)
	String birthday;//生年月日
	String Job;//職業
	String Sex;//性別

	String yubin_bangou;//住所の郵便番号
	String pref;//住所(都道府県)
	String jyusyo;//住所(区市町村名以下)

	String denwabangou;//連絡先電話番号
	String mailaddress;//連絡先メールアドレス
	String keitaiaddress;//携帯メールアドレス
	
	boolean nomail;//メールアドレスの未入力フラグ
	boolean noname;//プレイヤーネームの未入力フラグ
	boolean wrong;//エラーの発生フラグ
	boolean empty;//検索結果に対する該当なしフラグ
	
	String secret_question;//秘密の質問
	String secret_answer;//秘密の質問の答え
	
	private int nextLevel;//次に昇格するレベル
	private double nextScore;//次のレベルに昇格するのに必要な経験値
	
	
	public K_jyouhou_TO(int kaiin_number, String k_id, String sei_kanji, String mei_kanji, String sei_kana, String mei_kana, String birthday, String yubin_bangou, String pref, String jyusyo,
			String denwabangou, String mailaddress, String keitaiaddress, String secret_question, String secret_answer, String Job, String Sex){//プレイヤー情報の検索結果格納用TO
		this.kaiin_number = kaiin_number;
		this.k_id = k_id;

		this.sei_kanji = sei_kanji;
		this.mei_kanji = mei_kanji;
		this.sei_kana = sei_kana;
		this.mei_kana = mei_kana;
		this.birthday = birthday;

		this.yubin_bangou = yubin_bangou;
		this.pref = pref;
		this.jyusyo = jyusyo;

		this.denwabangou = denwabangou;
		this.mailaddress = mailaddress;
		this.keitaiaddress = keitaiaddress;
		
		this.secret_question = secret_question;
		this.secret_answer = secret_answer;
		this.Job = Job;
		this.Sex = Sex;
	}
	
	public K_jyouhou_TO(String MailAddress, String KeitaiAddress){//新規会員登録時のメールアドレスの重複確認結果格納用TOとパスワードリセット後のID・仮パスワードの格納
		this.mailaddress = MailAddress;//パスワードリセット時はリセットしたID
		this.keitaiaddress = KeitaiAddress;//パスワードリセット時はリセット後の仮パスワード
	}
	
	public K_jyouhou_TO(String Login_Name, String MailAddress, String KeitaiAddress){//新規会員登録時のメールアドレスの重複確認結果格納用TO
		this.login_name = Login_Name;
		this.mailaddress = MailAddress;
		this.keitaiaddress = KeitaiAddress;
	}
	
	public K_jyouhou_TO(int nextLevel, double nextScore) {//次に昇格するレベルを表すTO
		this.nextLevel = nextLevel;
		this.nextScore = nextScore;		
	}

	public K_jyouhou_TO(){
	}

	public K_jyouhou_TO(String k_id, String Name, String Mail, String BirthDay,
			String Address_No, String Secret_Question, String Secret_Answer) {
		this.k_id = k_id;
		this.login_name = Name;
		this.mailaddress = Mail;
		this.birthday = BirthDay;
		this.yubin_bangou = Address_No;
		this.secret_question = Secret_Question;
		this.secret_answer = Secret_Answer;
	}

	public K_jyouhou_TO(String Input_Name, String Input_Mail, boolean NoMail,
			boolean NoName, boolean Wrong, boolean empty) {
		this.login_name = Input_Name;
		this.mailaddress = Input_Mail;
		this.nomail = NoMail;
		this.noname = NoName;
		this.wrong = Wrong;
		this.empty = empty;
	}

	public K_jyouhou_TO(String birthday, String addressno,
			String secret_answer, boolean wrong) {
		this.birthday = birthday;
		this.yubin_bangou = addressno;
		this.secret_answer = secret_answer;
		this.wrong = wrong;
	}

	public int getkaiin_number() {return kaiin_number;}
	public void setkaiin_number(int kaiin_number) {this.kaiin_number = kaiin_number;}

	public String getk_Id() {return k_id;}
	public void setk_Id(String k_id) {this.k_id = k_id;}

	public String getLogin_name() {return login_name;}
	public void setLogin_name(String login_name) {this.login_name = login_name;}

	
	public String getsei_kanji() {return sei_kanji;}
	public void setsei_kanji(String sei_kanji) {this.sei_kanji = sei_kanji;}

	public String getmei_kanji() {return mei_kanji;}
	public void setmei_kanji(String mei_kanji) {this.mei_kanji = mei_kanji;}

	public String getsei_kana() {return sei_kana;}
	public void setsei_kana(String sei_kana) {this.sei_kana = sei_kana;}

	public String getmei_kana() {return mei_kana;}
	public void setmei_kana(String mei_kana) {this.mei_kana = mei_kana;}

	public String getbirthday() {return birthday;}
	public void setbirthday(String birthday) {this.birthday = birthday;}

	public String getyubin_bangou() {return yubin_bangou;}
	public void setyubin_bangou(String yubin_bangou) {this.yubin_bangou = yubin_bangou;}

	public String getpref() {return pref;}
	public void setpref(String pref) {this.pref = pref;}

	public String getjyusyo() {return jyusyo;}
	public void setjyusyo(String jyusyo) {this.jyusyo = jyusyo;}


	public String getdenwabangou() {return denwabangou;}
	public void setdenwabangou(String denwabangou) {this.denwabangou = denwabangou;}

	public String getmailaddress() {return mailaddress;}
	public void setmailaddress(String mailaddress) {this.mailaddress = mailaddress;}

	public String getkeitaiaddress() {return keitaiaddress;}
	public void setkeitaiaddress(String keitaiaddress) {this.keitaiaddress = keitaiaddress;}

	public String getsecret_question() {return secret_question;}
	public void setsecret_question(String secret_question) {this.secret_question = secret_question;}
	
	public String getsecret_answer() {return secret_answer;}
	public void setsecret_answer(String secret_answer) {this.secret_answer = secret_answer;}
	

	public String getJob() {return Job;}
	public void setJob(String Job) {this.Job = Job;}

	public String getSex() {return Sex;}
	public void setSex(String Sex) {this.Sex = Sex;}

	public boolean isNomail() {return nomail;}
	public void setNomail(boolean nomail) {this.nomail = nomail;}

	public boolean isNoname() {return noname;}
	public void setNoname(boolean noname) {this.noname = noname;}

	public boolean isWrong() {return wrong;}
	public void setWrong(boolean wrong) {this.wrong = wrong;}
	
	public boolean isEmpty() {return empty;}
	public void setEmpty(boolean empty) {this.empty = empty;}

	
	public int getNextLevel() {return nextLevel;}
	public void setNextLevel(int nextLevel) {this.nextLevel = nextLevel;}

	public double getnextScore() {return nextScore;}
	public void setnextScore(double nextScore) {this.nextScore = nextScore;}

	
}
