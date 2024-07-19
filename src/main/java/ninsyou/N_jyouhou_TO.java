package ninsyou;

public class N_jyouhou_TO {

	private int k_number;//会員番号
	private String k_id;//ID
	private String login_name;//プレイヤーネーム
	private int lock_flg;//ID・パスワードのロック状態
	private int l_limit;//ライセンス期限
	
	private boolean Login_Lock;
	private boolean Seiseki_Lock;
	private boolean Getsuran_Lock;
	private boolean NormalRep_Lock;
	private boolean NewGame_Lock;
	private boolean ShinkiRep_Lock;
	private boolean GRon_Lock;
	private boolean VoAndExp_Lock;
	private boolean PropRep_Lock;
	private boolean K_HenkouLock;
	private boolean GRiron_Lock;
	private boolean Coupon_Lock;
	
	/*private boolean Auth;*/
	
	private String K_Id;
	private String K_Password;

	public N_jyouhou_TO(int k_number, String k_id, String login_name, int lock_flg, int l_limit, boolean Auth){
		this.k_number = k_number;
		this.k_id = k_id;
		this.login_name = login_name;
		this.lock_flg = lock_flg;
		this.l_limit = l_limit;
		/*this.Auth = Auth;*/
	}
	
	public N_jyouhou_TO(String K_Id, String K_Password){
		this.K_Id = K_Id;
		this.K_Password = K_Password;
	}

	public N_jyouhou_TO(){
	}

	public N_jyouhou_TO(boolean Login_Lock, boolean Seiseki_Lock, boolean Getsuran_Lock, boolean NormalRep_Lock, boolean NewGame_Lock, boolean ShinkiRep_Lock,
			boolean GRon_Lock, boolean VoAndExp_Lock, boolean PropRep_Lock, boolean K_HenkouLock, boolean GRiron_Lock, boolean Coupon_Lock) {
		this.Login_Lock = Login_Lock;
		this.Seiseki_Lock = Seiseki_Lock;
		this.Getsuran_Lock = Getsuran_Lock;
		this.NormalRep_Lock = NormalRep_Lock;
		this.NewGame_Lock = NewGame_Lock;
		this.ShinkiRep_Lock = ShinkiRep_Lock;
		this.GRon_Lock = GRon_Lock;
		this.VoAndExp_Lock = VoAndExp_Lock;
		this.PropRep_Lock = PropRep_Lock;
		this.K_HenkouLock = K_HenkouLock;
		this.GRiron_Lock = GRiron_Lock;
		this.Coupon_Lock = Coupon_Lock;
	}

	public int getk_number() {return k_number;}
	public void setk_number(int k_number){this.k_number = k_number;}

	public String getid() {return k_id;}
	public void setid(String k_id) {this.k_id = k_id;}

	public String getlogin_name() {return login_name;}
	public void setlogin_name(String login_name) {this.login_name = login_name;}

	public int getlock_flg() {return lock_flg;}
	public void setlock_flg (int lock_flg) {this.lock_flg = lock_flg;}

	public int getl_limit() {return l_limit;}
	public void setl_limit(int l_limit) {this.l_limit = l_limit;}


	/*public boolean isAuth() {return Auth;}
	public void setAuth(boolean Auth) {this.Auth = Auth;
	}*/

	
	public boolean isLogin_Lock() {return Login_Lock;}
	public void setLogin_Lock(boolean Login_Lock) {this.Login_Lock = Login_Lock;}

	public boolean isSeiseki_Lock() {return Seiseki_Lock;}
	public void setSeiseki_Lock(boolean Seiseki_Lock) {this.Seiseki_Lock = Seiseki_Lock;}

	public boolean isGetsuran_Lock() {return Getsuran_Lock;}
	public void setGetsuran_Lock(boolean Getsuran_Lock) {this.Getsuran_Lock = Getsuran_Lock;}

	public boolean isNormalRep_Lock() {return NormalRep_Lock;}
	public void setNormalRep_Lock(boolean NormalRep_Lock) {this.NormalRep_Lock = NormalRep_Lock;}

	public boolean isGRon_Lock() {return GRon_Lock;}
	public void setGRon_Lock(boolean GRon_Lock) {this.GRon_Lock = GRon_Lock;}

	public boolean isVoAndExp_Lock() {return VoAndExp_Lock;}
	public void setVoAndExp_Lock(boolean VoAndExp_Lock) {this.VoAndExp_Lock = VoAndExp_Lock;}

	public boolean isK_HenkouLock() {return K_HenkouLock;}
	public void setK_HenkouLock(boolean K_HenkouLock) {this.K_HenkouLock = K_HenkouLock;}

	public boolean isNewGame_Lock() {return NewGame_Lock;}
	public void setNewGame_Lock(boolean NewGame_Lock) {this.NewGame_Lock = NewGame_Lock;}

	public boolean isShinkiRep_Lock() {return ShinkiRep_Lock;}
	public void setShinkiRep_Lock(boolean ShinkiRep_Lock) {this.ShinkiRep_Lock = ShinkiRep_Lock;}

	public boolean isPropRep_Lock() {return PropRep_Lock;}
	public void setPropRep_Lock(boolean PropRep_Lock) {this.PropRep_Lock = PropRep_Lock;}

	public boolean isGRiron_Lock() {return GRiron_Lock;}
	public void setGRiron_Lock(boolean GRiron_Lock) {this.GRiron_Lock = GRiron_Lock;}

	public String getK_Id() {return K_Id;}
	public void setK_Id(String K_Id) {this.K_Id = K_Id;}

	public String getK_Password() {return K_Password;}
	public void setK_Password(String K_Password) {this.K_Password = K_Password;}

	public boolean isCoupon_Lock() {return Coupon_Lock;}
	public void setCoupon_Lock(boolean Coupon_Lock) {this.Coupon_Lock = Coupon_Lock;}

}
