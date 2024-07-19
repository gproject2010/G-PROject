package k_jyouhou;

public class K_Touroku_TO {
	
	String Login_Name;//プレイヤーネーム
	String Kibou_Id;//ID
	String Kibou_Password;//パスワード
	String Kakunin_Password;//パスワード(確認)
	String Mail_Address;//PCメールアドレス
	String Keitai_Address;//携帯メールアドレス
	
	boolean Name_jyufuku;//プレイヤー名重複フラグ(新規登録時)
	boolean Id_jyufuku;//ID重複フラグ(新規登録時)
	boolean Mail_jyufuku;//PCメールアドレス重複フラグ(新規登録時)
	boolean Keitai_jyufuku;//携帯メールアドレス重複フラグ(新規登録時)
	boolean Wrong_Password;//パスワード不正フラグ(新規登録時)
	boolean NGHit;//禁止ワード検出フラグ(新規登録時)
	String NGWord;//検出された禁止ワード
	
	int Password_length;//パスワードの文字数

	int Login_name_res;//プレイヤー名重複フラグ(変更時)
	int Touroku_id_res;//ID重複フラグ(変更時)
	int Mailaddress_res;//PCメールアドレス重複フラグ(変更時)
	int Keitai_address_res;//携帯メールアドレス重複フラグ(変更時)
	//ここまで認証情報の登録用
	
	String Sei_Kanji;//姓(漢字)
	String Mei_Kanji;//名(漢字)
	String Sei_Kana;//姓(カタカナ)
	String Mei_Kana;//名(カタカナ)
	
	String BirthYear;//生年月日
	String BirthTsuki;
	String BirthDay;
	String Sex;//性別
	String Job;
	
	String AddressNo;//住所(郵便番号)
	String Pref;//住所(都道府県)
	String Jyusyo;//住所(区市町村以下)
	String Telephone_No;//連絡先電話番号
	
	String Secret_Question;//秘密の質問
	String Secret_Answer;//秘密の質問の答え
	
	boolean NoName;//プレイヤー名未入力フラグ
	boolean NoBirthday;//生年月日未入力フラグ
	boolean NoJob;//職業未選択フラグ
	boolean NoAddress;//住所未入力フラグ
	boolean NoSecret;//秘密の質問未入力フラグ
	
	String Input_Id;//ID(ログイン情報からの受け取り用)
	
	String Kari_Id;//新規入会時の仮ID
	String Kari_Password;//新規入会時の仮パスワード
	
	String OldId;//変更登録時の旧ID
	
	public K_Touroku_TO(int login_name_res, int id_res, int mail_address_res, int keitai_address_res){
		this.Login_name_res = login_name_res;
		this.Touroku_id_res = id_res;
		this.Mailaddress_res = mail_address_res;
		this.Keitai_address_res = keitai_address_res; //変更登録時の重複確認用
	}
	
	public K_Touroku_TO(String Login_Name, String Kibou_Id, String Kibou_Password, String Kakunin_Password, String Mail_Address, String Keitai_Address,
			boolean Name_jyufuku, boolean Id_jyufuku, boolean Keitai_jyufuku, boolean Wrong_Password, String NGWord){
		this.Login_Name = Login_Name;
		this.Kibou_Id = Kibou_Id;
		this.Kibou_Password = Kibou_Password;
		this.Kakunin_Password = Kakunin_Password;
		this.Mail_Address = Mail_Address;
		this.Keitai_Address = Keitai_Address;
		this.Name_jyufuku = Name_jyufuku;
		this.Id_jyufuku = Id_jyufuku;
		this.Keitai_jyufuku = Keitai_jyufuku;
		this.Wrong_Password = Wrong_Password;
		this.NGWord = NGWord;//会員登録ページ1で登録失敗時に渡されるデータ(データ順がかぶっているので必要なし?)
	}
	
	public K_Touroku_TO(String Login_Name, String Kibou_Id, String Kibou_Password, String Mail_Address, String Keitai_Address, int Password_length){
	
		this.Login_Name = Login_Name;
		this.Kibou_Id = Kibou_Id;
		this.Kibou_Password = Kibou_Password;
		this.Mail_Address = Mail_Address;
		this.Keitai_Address = Keitai_Address;
		this.Password_length = Password_length;//会員登録ページ1で登録成功の場合に渡されるデータ
	}
	
	public K_Touroku_TO( String Kari_Id, String Mail_Address){
		this.Kari_Id = Kari_Id;
		this.Mail_Address = Mail_Address;//会員登録ページ0
		
		
	}
	public K_Touroku_TO(){
		
	}

	public K_Touroku_TO(String Sei_Kanji, String Mei_Kanji, String Sei_Kana,
			String Mei_Kana, String BirthYear, String BirthTsuki,
			String BirthDay, String Sex, String AddressNo, String Pref, String Jyusyo,
			String Telephone_No, String Secret_Question, String Secret_Answer,
			boolean NoName, boolean NoBirthday, boolean NoAddress,
			boolean NoSecret, boolean NGHit) {//会員登録ページ2
		
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthYear = BirthYear;
		this.BirthTsuki = BirthTsuki;
		this.BirthDay = BirthDay;
		this.Sex = Sex;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.NoName = NoName;
		this.NoBirthday = NoBirthday;
		this.NoAddress = NoAddress;
		this.NoSecret = NoSecret;//会員登録ページ2で登録失敗時に渡されるデータ
		this.NGHit = NGHit;
	}
	
	public K_Touroku_TO(String Sei_Kanji, String Mei_Kanji, String Sei_Kana,
			String Mei_Kana, String BirthYear, String BirthTsuki,
			String BirthDay, String Sex, String AddressNo, String Pref, String Jyusyo,
			String Telephone_No, String Secret_Question, String Secret_Answer, String Input_Id, String Job){
		
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthYear = BirthYear;
		this.BirthTsuki = BirthTsuki;
		this.BirthDay = BirthDay;
		this.Sex = Sex;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.Input_Id = Input_Id;//会員登録ページ2で登録成功時に渡されるデータ
		this.Job = Job;
	}

	public K_Touroku_TO(String Login_Name, String Kibou_Id, String Kibou_Password,
			boolean Name_jyufuku, boolean Id_jyufuku,
			boolean Wrong_Password) {
		// TODO 自動生成されたコンストラクター・スタブ
		this.Login_Name = Login_Name;
		this.Kibou_Id = Kibou_Id;
		this.Name_jyufuku = Name_jyufuku;
		this.Id_jyufuku = Id_jyufuku;
		this.Wrong_Password = Wrong_Password;//会員登録ページ1
	}
	
	public K_Touroku_TO(String Mail_Address, String Kari_Id, String Kari_Password){
		this.Mail_Address = Mail_Address;
		this.Kari_Id = Kari_Id;
		this.Kari_Password = Kari_Password;//仮登録時に発行するID・パスワード
	}
	
	public K_Touroku_TO(String Login_Name, String Kibou_Id, String Kibou_Password, String Kakunin_Password, String Mail_Address, String Keitai_Address,
			boolean Name_jyufuku, boolean Id_jyufuku, boolean Mail_jyufuku, boolean Keitai_jyufuku, boolean Wrong_Password, String NGWord){
		this.Login_Name = Login_Name;
		this.Kibou_Id = Kibou_Id;
		this.Kibou_Password = Kibou_Password;
		this.Kakunin_Password = Kakunin_Password;
		this.Mail_Address = Mail_Address;
		this.Keitai_Address = Keitai_Address;
		this.Name_jyufuku = Name_jyufuku;
		this.Id_jyufuku = Id_jyufuku;
		this.Mail_jyufuku = Mail_jyufuku;
		this.Keitai_jyufuku = Keitai_jyufuku;
		this.NGWord = NGWord;
		this.Wrong_Password = Wrong_Password;//会員登録ページ１で登録失敗時に渡されるデータ
	}

	public K_Touroku_TO(String Login_Name, String Kibou_Id, String Kibou_Password,
			String Mail_Address, String Keitai_Address, String Sei_Kanji,
			String Mei_Kanji, String Sei_Kana, String Mei_Kana, String BirthYear,
			String BirthTsuki, String BirthDay, String AddressNo,
			String Pref, String Jyusyo, String Telephone_No,
			String Secret_Question, String Secret_Answer, String Job, String OldId) {
		// 正式登録データ
		this.Login_Name = Login_Name;
		this.Kibou_Id = Kibou_Id;
		this.Kibou_Password = Kibou_Password;
		this.Mail_Address = Mail_Address;
		this.Keitai_Address = Keitai_Address;
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthYear = BirthYear;
		this.BirthTsuki = BirthTsuki;
		this.BirthDay = BirthDay;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.Job = Job;
		this.OldId = OldId;
	}

	public K_Touroku_TO(String Sei_Kanji, String Mei_Kanji, String Sei_Kana,
			String Mei_Kana, String BirthDay, String AddressNo, String Pref,
			String Jyusyo, String Telephone_No, String Secret_Question,
			String Secret_Answer, boolean NoName, boolean NoAddress,
			boolean NoSecret) {
		
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthDay = BirthDay;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.NoName = NoName;
		this.NoAddress = NoAddress;
		this.NoSecret = NoSecret;//会員情報変更登録ページで登録失敗時に渡されるデータ
	}

	public K_Touroku_TO(String Sei_Kanji, String Mei_Kanji, String Sei_Kana,
			String Mei_Kana, String BirthDay, String AddressNo, String Pref,
			String Jyusyo, String Telephone_No, String Secret_Question,
			String Secret_Answer, String Input_Id, String Job) {
		
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthDay = BirthDay;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.Input_Id = Input_Id;
		this.Job = Job;
	}

	public K_Touroku_TO(String Sei_Kanji, String Mei_Kanji, String Sei_Kana, String Mei_Kana, String BirthYear,
			String BirthTsuki, String BirthDay, String Sex, String AddressNo, String Pref, String Jyusyo,
			String Telephone_No, String Secret_Question, String Secret_Answer, boolean NoName, boolean NoBirthday,
			boolean NoAddress, boolean NoSecret, String NGWord, boolean NoJob, String Job) {
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthDay = BirthDay;
		this.Sex = Sex;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.NoName = NoName;
		this.NoAddress = NoAddress;
		this.NoSecret = NoSecret;
		this.NGWord = NGWord;
		this.NoJob = NoJob;
		this.Job = Job;
	}

	public K_Touroku_TO(String Sei_Kanji, String Mei_Kanji, String Sei_Kana, String Mei_Kana, String BirthDay,
			String AddressNo, String Pref, String Jyusyo, String Telephone_No, String Secret_Question,
			String Secret_Answer, boolean NoName, boolean NoAddress, boolean NoSecret, String NGWord) {
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthDay = BirthDay;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.NoName = NoName;
		this.NoAddress = NoAddress;
		this.NoSecret = NoSecret;
		this.NGWord = NGWord;
	}

	public K_Touroku_TO(String Sei_Kanji, String Mei_Kanji, String Sei_Kana, String Mei_Kana, String BirthDay,
			String AddressNo, String Pref, String Jyusyo, String Telephone_No, String Secret_Question,
			String Secret_Answer, boolean NoName, boolean NoAddress, boolean NoSecret, String NGWord, String Job) {
		this.Sei_Kanji = Sei_Kanji;
		this.Mei_Kanji = Mei_Kanji;
		this.Sei_Kana = Sei_Kana;
		this.Mei_Kana = Mei_Kana;
		this.BirthDay = BirthDay;
		this.AddressNo = AddressNo;
		this.Pref = Pref;
		this.Jyusyo = Jyusyo;
		this.Telephone_No = Telephone_No;
		this.Secret_Question = Secret_Question;
		this.Secret_Answer = Secret_Answer;
		this.NoName = NoName;
		this.NoAddress = NoAddress;
		this.NoSecret = NoSecret;
		this.NGWord = NGWord;
		this.Job = Job;
	}

	public int getLogin_name_res() {return Login_name_res;}
	public void setLogin_name_res(int Login_name_res) {this.Login_name_res = Login_name_res;}

	public int getTouroku_id_res() {return Touroku_id_res;}
	public void setTouroku_id_res(int Touroku_id_res) {this.Touroku_id_res = Touroku_id_res;}

	public int getMailaddress_res() {return Mailaddress_res;}
	public void setMailaddress_res(int Mailaddress_res) {this.Mailaddress_res = Mailaddress_res;
	}

	public int getKeitai_address_res() {return Keitai_address_res;}
	public void setKeitai_address_res(int Keitai_address_res) {this.Keitai_address_res = Keitai_address_res;}

	
	public String getLogin_Name() {return Login_Name;}
	public void setLogin_Name(String Login_Name) {this.Login_Name = Login_Name;}

	public String getKibou_Id() {return Kibou_Id;}
	public void setKibou_Id(String Kibou_Id) {this.Kibou_Id = Kibou_Id;}

	public String getKibou_Password() {return Kibou_Password;}
	public void setKibou_Password(String Kibou_Password) {this.Kibou_Password = Kibou_Password;}

	public String getKakunin_Password() {return Kakunin_Password;}
	public void setKakunin_Password(String Kakunin_Password) {this.Kakunin_Password = Kakunin_Password;}

	public String getMail_Address() {return Mail_Address;}
	public void setMail_Address(String Mail_Address) {this.Mail_Address = Mail_Address;}

	public String getKeitai_Address() {return Keitai_Address;}
	public void setKeitai_Address(String Keitai_Address) {this.Keitai_Address = Keitai_Address;}
	
	public int getPassword_length() {return Password_length;}
	public void setPassword_length(int Password_Length) {this.Password_length = Password_Length;}

	
	public boolean isName_jyufuku() {return Name_jyufuku;}
	public void setName_jyufuku(boolean Name_Jyufuku) {this.Name_jyufuku = Name_Jyufuku;}

	public boolean isId_jyufuku() {return Id_jyufuku;}
	public void setId_jyufuku(boolean Id_Jyufuku) {this.Id_jyufuku = Id_Jyufuku;}

	public boolean isMail_jyufuku() {return Mail_jyufuku;}
	public void setMail_jyufuku(boolean Mail_Jyufuku) {this.Mail_jyufuku = Mail_Jyufuku;}

	public boolean isKeitai_jyufuku() {return Keitai_jyufuku;}
	public void setKeitai_jyufuku(boolean Keitai_Jyufuku) {this.Keitai_jyufuku = Keitai_Jyufuku;}

	public boolean isWrong_Password() {return Wrong_Password;}
	public void setWrong_Password(boolean Wrong_Password) {this.Wrong_Password = Wrong_Password;}

	
	public String getSei_Kanji() {return Sei_Kanji;}
	public void setSei_Kanji(String Sei_Kanji) {this.Sei_Kanji = Sei_Kanji;}

	public String getMei_Kanji() {return Mei_Kanji;}
	public void setMei_Kanji(String Mei_Kanji) {this.Mei_Kanji = Mei_Kanji;}

	public String getSei_Kana() {return Sei_Kana;}
	public void setSei_Kana(String Sei_Kana) {this.Sei_Kana = Sei_Kana;}

	public String getMei_Kana() {return Mei_Kana;}
	public void setMei_Kana(String Mei_Kana) {this.Mei_Kana = Mei_Kana;}

	public String getBirthYear() {return BirthYear;}
	public void setBirthYear(String BirthYear) {this.BirthYear = BirthYear;}

	public String getBirthTsuki() {return BirthTsuki;}
	public void setBirthTsuki(String BirthTsuki) {this.BirthTsuki = BirthTsuki;}

	public String getBirthDay() {return BirthDay;}
	public void setBirthDay(String BirthDay) {this.BirthDay = BirthDay;}

	public String getSex() {return Sex;}
	public void setSex(String Sex) {this.Sex = Sex;}

	public String getJob() {return Job;}
	public void setJob(String Job) {this.Job = Job;}

	public boolean isNoJob() {return NoJob;}
	public void setNoJob(boolean NoJob) {this.NoJob = NoJob;}

	public String getAddressNo() {return AddressNo;}
	public void setAddressNo(String AddressNo) {this.AddressNo = AddressNo;}

	public String getPref() {return Pref;}
	public void setPref(String Pref) {this.Pref = Pref;}

	public String getJyusyo() {return Jyusyo;}
	public void setJyusyo(String Jyusyo) {this.Jyusyo = Jyusyo;}

	public String getTelephone_No() {return Telephone_No;}
	public void setTelephone_No(String Telephone_No) {this.Telephone_No = Telephone_No;}

	public String getSecret_Question() {return Secret_Question;}
	public void setSecret_Question(String Secret_Question) {this.Secret_Question = Secret_Question;}

	public String getSecret_Answer() {return Secret_Answer;}
	public void setSecret_Answer(String Secret_Answer) {this.Secret_Answer = Secret_Answer;}

	public boolean isNoName() {return NoName;}
	public void setNoName(boolean NoName) {this.NoName = NoName;}

	public boolean isNoBirthday() {return NoBirthday;}
	public void setNoBirthday(boolean NoBirthday) {this.NoBirthday = NoBirthday;}

	public boolean isNoAddress() {return NoAddress;}
	public void setNoAddress(boolean NoAddress) {this.NoAddress = NoAddress;}

	public boolean isNoSecret() {return NoSecret;}
	public void setNoSecret(boolean NoSecret) {this.NoSecret = NoSecret;}

	public boolean isNGHit() {return NGHit;}
	public void setNGHit(boolean NGHit) {this.NGHit = NGHit;}

	public String getInput_Id() {return Input_Id;}
	public void setInput_Id(String Input_Id) {this.Input_Id = Input_Id;}

	
	public String getKari_Id() {return Kari_Id;}
	public void setKari_Id(String Kari_Id) {this.Kari_Id = Kari_Id;}

	public String getKari_Password() {return Kari_Password;}
	public void setKari_Password(String Kari_Password) {this.Kari_Password = Kari_Password;}

	public String getOldId() {return OldId;}
	public void setOldId(String OldId) {this.OldId = OldId;}

	public String getNGWord() {return NGWord;}
	public void setNGWord(String NGWord) {this.NGWord = NGWord;}
}
