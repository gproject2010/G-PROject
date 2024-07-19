package rep_upload;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inputUtility.HttpUtility;

/**
 * Servlet implementation class Proposal_Rep_Kakunin
 */
public class Proposal_Rep_Kakunin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Proposal_Rep_Kakunin() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);
		session.setAttribute("errcode", "Rep-009");
		String NextPage = "/passed/Error_Gamen.jsp";
		
		NewGames_TO PropData = new NewGames_TO();
		//boolean LinkFrom = request.getHeader("referer").equals("http://localhost/G-pro_Service/passed/NewGames/Proposal_Report_Temp.html");
		boolean NGHit = false;//NGワードを検出したことを表すフラグ
		boolean Nosign = false;//未成年で保護者の入力がないことを表すフラグ
		boolean NoData = false;//未入力の必須項目があることを表すフラグ
		boolean Wrong = false;//無効もしくは不正な値が入力されていることを表すフラグ
		try{
		String GameTitle = request.getParameter("gametitle");//ゲームタイトル
		String MainGenre = request.getParameter("maingenre");//メインジャンル
		String SubGenre1 = request.getParameter("subgenre1");//サブジャンル1
		String SubGenre2 = request.getParameter("subgenre2");//サブジャンル2
		String PlatForm = request.getParameter("platform");//想定しているプラットフォーム
		String CatchCopy = request.getParameter("catchcopy");//キャッチコピー
		String Gaiyou = request.getParameter("gaiyou");//ゲーム概要
		
		String PenName = request.getParameter("penname");
		String Kikakusya_sei = request.getParameter("kikakusya_sei");//企画者名(姓)
		String Kikakusya_mei = request.getParameter("kikakusya_mei");//企画者名(名)
		String Seifurigana = request.getParameter("seifurigana");//企画者名ふりがな(姓)
		String Meifurigana = request.getParameter("meifurigana");//企画者名ふりがな(名)
		String Hogosyasei = request.getParameter("hogosyasei");//保護者名(姓)
		String Hogosyamei = request.getParameter("hogosyamei");//保護者名(名)
		String Tanjyounen_S = request.getParameter("tanjyounen");//生年月日(年)
		String Tanjyoutsuki_S = request.getParameter("tanjyoutsuki");//生年月日(月)
		String Tanjyoubi_S = request.getParameter("tanjyoubi");//生年月日(日)
		Calendar Seinengappi = new GregorianCalendar();//日付型に変換後の生年月日
		Seinengappi = Calendar.getInstance();
		Calendar Today = new GregorianCalendar();//今日の日付
		Today = Calendar.getInstance();
		
		String Pref = request.getParameter("pref");//企画者住所(都道府県)
		String Jyusyo = request.getParameter("jyusyo");//企画者住所(市町村名以下)
		String Tel_No1 = request.getParameter("telno1");//企画者電話番号(市外局番)
		String Tel_No2 = request.getParameter("telno2");//企画者電話番号(市内局番)
		String Tel_No3 = request.getParameter("telno3");//企画者電話番号(番号)
		String KeitaiNo1 = request.getParameter("keitaino1");//企画者携帯電話番号(上3ケタ)
		String KeitaiNo2 = request.getParameter("keitaino2");//企画者携帯番号(中4ケタ)
		String KeitaiNo3 = request.getParameter("keitaino3");//企画者携帯番号(下4桁)
		String FaxNo1 = request.getParameter("faxno1");//企画者FAX番号(市外局番)
		String FaxNo2 = request.getParameter("faxno2");//企画者FAX番号(市内局番)
		String FaxNo3 = request.getParameter("faxno3");//企画者FAX番号(番号)
		String MailAddress = request.getParameter("mailaddress");//企画者メールアドレス
		String Url = request.getParameter("url");//企画者開設のHPのURL
		String Syokugyou = request.getParameter("syokugyou");//企画者職業
		String Tsutomesaki = request.getParameter("tsutomesaki");//企画者勤務・通学先名称
		String TsutomesakiJyusyo = request.getParameter("tsutomesakijyusyo");//企画者勤務・通学先住所
		String Seisakurireki = request.getParameter("seisakurireki");//ゲームなどの制作・開発履歴
		
		String Kikakuito = request.getParameter("kikakuito");//企画意図
		String Target = request.getParameter("target");//ターゲットとしているユーザ層
		String Sabetsuka = request.getParameter("sabetsuka");//他作品との差別化
		String Advantage = request.getParameter("advantage");//有利な条件
		
		String Kikakuryou_Uketori = request.getParameter("kikakuryou_uketori");//企画料の受け取り方法
		String Kikakuryou_S = request.getParameter("kikakuryou");//希望企画料
		if(Kikakuryou_S == null || Kikakuryou_S.equals("")){//空欄の場合は0を設定
			Kikakuryou_S = "0";
		}
		String Royality_S = request.getParameter("royality");//希望ロイヤリティ
		if(Royality_S == null || Royality_S.equals("")){//空欄の場合は0を設定
			Royality_S = "0";
		}
		String Bikou = request.getParameter("bikou");//契約条件備考
		if(Bikou == null || Bikou.equals("")){//空欄の場合は「なし」を設定
			Bikou = "なし";
		}
		String[] Koukaisettei = request.getParameterValues("koukaisettei");//レポートデータの公開設定
		String Koukaisettei_etc = request.getParameter("koukaisettei_etc");//データ公開設定：その他
		if(Koukaisettei != null){
		for(String Kokai : Koukaisettei){//公開設定に「ここで挙げられている以外の資料」が含まれていたら
			if(!(Kokai.equals("その他"))){
				continue;
			}
				Koukaisettei[Koukaisettei.length + 1] = Koukaisettei_etc;//ファイル名を登録
		}
		}
		
		String[] Henkou_Koumoku = request.getParameterValues("henkou_koumoku");//変更する項目
		if(Henkou_Koumoku == null || Henkou_Koumoku.length == 0){//変更チェックを一つもつけなかった(処理が不要な)場合
			Henkou_Koumoku = new String[]{"Enpty"};//デフォルト値として「Enpty」を設定
		}
		NewGames_TO BeforeData = (NewGames_TO)session.getAttribute("propkoumoku");//変更前の入力値
		if(BeforeData == null){//初回の実行の場合は
			BeforeData = new NewGames_TO();//オブジェクトだけ新規に作成
		}
		
		
		String Tel_No = "Enpty";//デフォルト値として「Enpty」を設定
		String Keitai_No = "Enpty";
		String Fax_No = "Enpty";
		int Kikakuryou = 0;//デフォルト値として0を設定
		double Royality = 0;
		
		ArrayList<String> InputList_Hissu = new ArrayList<String>();//入力検査を行う必須項目のリスト
		ArrayList<String> InputList_Hold = new ArrayList<String>();//入力検査を行う(検査時にnullやEmptyで上書きしない)必須項目のリスト
		ArrayList<String> InputList_Nini = new ArrayList<String>();//入力検査を行う任意項目のリスト
		InputList_Hissu.add(GameTitle);
		InputList_Hissu.add(MainGenre);
		InputList_Nini.add(SubGenre1);
		InputList_Nini.add(SubGenre2);
		InputList_Nini.add(PlatForm);
		InputList_Hissu.add(CatchCopy);
		InputList_Hissu.add(Gaiyou);
		InputList_Nini.add(PenName);
		InputList_Hissu.add(Kikakusya_sei);
		InputList_Hissu.add(Kikakusya_mei);
		InputList_Hissu.add(Seifurigana);
		InputList_Hissu.add(Meifurigana);
		InputList_Nini.add(Hogosyasei);
		InputList_Nini.add(Hogosyamei);
		InputList_Hold.add(Tanjyounen_S);
		InputList_Hold.add(Tanjyoutsuki_S);
		InputList_Hold.add(Tanjyoubi_S);
		InputList_Hissu.add(Pref);
		InputList_Hissu.add(Jyusyo);
		InputList_Hold.add(Tel_No1);
		InputList_Hold.add(Tel_No2);
		InputList_Hold.add(Tel_No3);
		InputList_Nini.add(KeitaiNo1);
		InputList_Nini.add(KeitaiNo2);
		InputList_Nini.add(KeitaiNo3);
		InputList_Nini.add(FaxNo1);
		InputList_Nini.add(FaxNo2);
		InputList_Nini.add(FaxNo3);
		InputList_Hissu.add(MailAddress);
		//InputList_Nini.add(Url);//URLに対しては入力値チェックを行わない
		InputList_Nini.add(Syokugyou);
		InputList_Nini.add(Tsutomesaki);
		InputList_Nini.add(TsutomesakiJyusyo);
		InputList_Nini.add(Seisakurireki);
		InputList_Hissu.add(Kikakuito);
		InputList_Nini.add(Target);
		InputList_Nini.add(Sabetsuka);
		InputList_Nini.add(Advantage);
		InputList_Hissu.add(Kikakuryou_Uketori);
		InputList_Nini.add(Kikakuryou_S);
		InputList_Nini.add(Royality_S);
		InputList_Nini.add(Bikou);
		InputList_Nini.add(Koukaisettei_etc);
		
		try{
		for(String inp : InputList_Hissu){//String型の項目の入力検査(必須項目)
			if(inp == null || inp.equals("")){//空欄またはnullを検出した場合は
				NoData = true;
				inp = "Enpty";//nullの代わりに「Enpty」を設定
			}
			//HttpUtility.escapeHTML(inp);//入力値の検査
			if(HttpUtility.NG_Word_Check(inp) != null){//NGワードを検出した場合は
				NGHit = true;//フラグON
				inp = "";//検出した項目の入力値を消去
		}
		}
		for(String inp : InputList_Hold){//String型の項目の入力検査(必須項目)
			if(inp == null || inp.equals("")){//空欄またはnullを検出した場合は
				inp = "Enpty";//nullの代わりに「Enpty」を設定
			}
			//HttpUtility.escapeHTML(inp);//入力値の検査
			//inp = inp.replaceAll("\n", "<br>");
			if(HttpUtility.NG_Word_Check(inp) != null){//NGワードを検出した場合は
				NGHit = true;//フラグON
				inp = "";//検出した項目の入力値を消去
		}
		}
		for(String inp2 : InputList_Nini){//String型の項目の入力検査(任意項目)
			if(inp2 == null || inp2.equals("")){//空欄またはnullを検出した場合は
				inp2 = "なし";//空欄を表す文字列として「なし」を設定
			}
			//HttpUtility.escapeHTML(inp2);//入力値の検査
			//inp2 = inp2.replaceAll("\n", "<br>");
			if(HttpUtility.NG_Word_Check(inp2) != null){//NGワードを検出した場合は
				NGHit = true;//フラグON
				inp2 = "";//検出した項目の入力値を消去
		}
		}
		
		if(Koukaisettei == null){
			Koukaisettei = new String[]{"Enpty"};
			if(Koukaisettei[0].equals("Enpty")){//一般会員に配信しない(公開設定のチェックを1つもつけなかった場合)は
				Koukaisettei[0] = "企業会員のみに配信";//企業会員のみに配信することとする
			}else{
		for(String inp3 : Koukaisettei){//公開設定(配列)の入力検査
			//HttpUtility.escapeHTML(inp3);//公開設定の入力値検査
			if(HttpUtility.NG_Word_Check(inp3) != null){//NGワードを検出した場合は
				NGHit = true;//フラグON
				break;
			}
			}
			for(String inp : Henkou_Koumoku){
				if(!(inp.equals("koukaisettei"))){//変更項目に公開設定が含まれていた場合は
			Koukaisettei = (String[])BeforeData.getKoukaisettei().clone();//前回入力された値をコピー
			break;
				}
		}
		}
		}
		}catch(Exception e){
			Wrong = true;
			e.printStackTrace();
		}
		int Tanjyounen = 9999;//生年月日
		int Tanjyoutsuki = 11;
		int Tanjyoubi = 29;
		int Comp_Hantei = 0;
		int Birth_Hantei = 0;//企画者が20歳になる時の年
		Calendar Birth = new GregorianCalendar();//企画者が20歳になる時の日付
		int Age_Hantei = 0;//20歳以上かどうかを判定する変数
		try{
		
			if(!(Henkou_Koumoku[0].equals("Enpty"))){//変更チェックを一つでもつけた(処理が必要な)場合
				for(String list : Henkou_Koumoku){
					if(!(list.equals("seinengappi"))){//生年月日の変更チェックが入っていない場合は
						continue;
					}
						Tanjyounen = BeforeData.getSeinengappi().get(Calendar.YEAR);//変更前の値で上書き
						Tanjyoutsuki = BeforeData.getSeinengappi().get(Calendar.MONTH);
						Tanjyoubi = BeforeData.getSeinengappi().get(Calendar.DATE);
				}
				}
		if(Tanjyounen_S == null || Tanjyounen_S.equals("") || Tanjyounen_S.equals("Enpty") || Tanjyoutsuki_S == null || Tanjyoutsuki_S.equals("") || Tanjyoutsuki_S.equals("Enpty")|| Tanjyoubi_S == null || Tanjyoubi_S.equals("") || Tanjyoubi_S.equals("Enpty")){
			if(BeforeData.getSeinengappi() != null){
				Tanjyounen = BeforeData.getSeinengappi().get(Calendar.YEAR);//変更前の値で上書き
				Tanjyoutsuki = BeforeData.getSeinengappi().get(Calendar.MONTH) + 1;
				Tanjyoubi = BeforeData.getSeinengappi().get(Calendar.DATE);
			}else{
			NoData = true;//生年月日に入力漏れがある場合はフラグON
			Tanjyounen = 9999;//生年月日
			Tanjyoutsuki = 11;
			Tanjyoubi = 29;
			}
		}else{
			Tanjyounen = Integer.parseInt(Tanjyounen_S);//生年月日をそれぞれint型に変換
			Tanjyoutsuki = Integer.parseInt(Tanjyoutsuki_S);
			Tanjyoubi = Integer.parseInt(Tanjyoubi_S);
		}
		}catch(Exception e){//無効、もしくは不正な値によりエラーとなった場合は
			Wrong = true;//フラグON
			e.printStackTrace();
		}
		try{
			Birth_Hantei = Tanjyounen + 20;//企画者が20歳になる時の年を算出
			Seinengappi.set(Tanjyounen, (Tanjyoutsuki - 1), Tanjyoubi);//生年月日をCalendar型に変換
			Birth.set(Birth_Hantei, (Tanjyoutsuki - 1), Tanjyoubi);//企画者が20歳になる時の日付を変換
			
		Comp_Hantei = Seinengappi.compareTo(Today);
		if(Comp_Hantei > 0 && Tanjyounen != 9999){//ありえない生年月日が入力されている場合は
			Wrong = true;//フラグON&何もしない
		}else{
		Age_Hantei = Today.compareTo(Birth);//企画者の20歳の誕生日が今日の日付より早いか遅いか
			if(Age_Hantei < 0 && (Hogosyasei == null || Hogosyasei == "" ||Hogosyasei == "なし" || Hogosyamei == null || Hogosyamei == "" || Hogosyamei == "なし")){//もし年齢が20歳未満で保護者名が入力されていなかったら
			Nosign = true;//未成年で保護者の入力がないことを表すフラグON
		}
			}
		}catch(NumberFormatException e){//エラーになった場合は
			Wrong = true;//フラグON
			Tanjyounen_S = "";//入力値を消去してもう一度入力してもらう
			Tanjyoutsuki_S = "";
			Tanjyoubi_S = "";
			e.printStackTrace();
		}
		try{
		if(Tel_No == null || Tel_No.equals("ERROR") || Tel_No.equals("") || Tel_No.equals("Enpty")){//初回の入力でないか、および電話番号が空欄になっていないか
			if(Tel_No1 == null || Tel_No1.equals("") || Tel_No1.equals("Enpty") || Tel_No2 == null || Tel_No2.equals("") || Tel_No2.equals("Enpty") || Tel_No3 == null || Tel_No3.equals("") || Tel_No3.equals("Enpty")){
				if(BeforeData.getTel_No() == null || BeforeData.getTel_No().equals("") || BeforeData.getTel_No().equals("ERROR")){
				NoData = true;//フラグON
				Tel_No = "ERROR";
				}else{
					Tel_No = BeforeData.getTel_No();
				}
			}else{
		Tel_No = Tel_No1 + "-" + Tel_No2 + "-" + Tel_No3;//電話番号、
			}
		if(KeitaiNo1 == null || KeitaiNo1.equals("") || KeitaiNo2 == null || KeitaiNo2.equals("") || KeitaiNo3 == null || KeitaiNo3.equals("") || Keitai_No == null || Keitai_No.equals("")){
			Keitai_No = "無し";
		}else{
		Keitai_No = KeitaiNo1 + "-" + KeitaiNo2 + "-" + KeitaiNo3;//携帯番号、
		}
		if(FaxNo1 == null || FaxNo1.equals("") || FaxNo2 == null || FaxNo2.equals("") || FaxNo3 == null || FaxNo3.equals("") || Fax_No == null || Fax_No.equals("")){
			Fax_No = "無し";
		}else{
		Fax_No = FaxNo1 + "-" + FaxNo2 + "-" + FaxNo3;//FAX番号の形式を変換
		}
		}else{
			if(Henkou_Koumoku[0].equals("Enpty")){//変更チェックを一つもつけなかった(処理が不要な)場合は最初に入力した値をそのまま代入
				Tel_No = BeforeData.getTel_No();
				Keitai_No = BeforeData.getKeitai_No();
				Fax_No = BeforeData.getFax_No();
				}else{
					for(String list : Henkou_Koumoku){
						if(list.equals("telno") == true){//電話番号、携帯番号、FAX番号それぞれで変更のチェックが入っている場合は変更後の値で上書き(入っている場合は変更・設定前の値を設定)
					Tel_No = Tel_No1 + "-" + Tel_No2 + "-" + Tel_No3;//電話番号、	
					}else{
						Tel_No = BeforeData.getTel_No();
					}
			if(list.equals("keitaino") == true){
				if(KeitaiNo1 == null || KeitaiNo1.equals("") || KeitaiNo2 == null || KeitaiNo2.equals("") || KeitaiNo3 == null || KeitaiNo3.equals("") || Keitai_No == null || Keitai_No.equals("")){
					Keitai_No = "無し";
				}else{
				Keitai_No = KeitaiNo1 + "-" + KeitaiNo2 + "-" + KeitaiNo3;//携帯番号、
				}
			}else{
				Keitai_No = BeforeData.getKeitai_No();
			}
			if(list.equals("faxno") == true){
				if(FaxNo1 == null || FaxNo1.equals("") || FaxNo2 == null || FaxNo2.equals("") || FaxNo3 == null || FaxNo3.equals("") || Fax_No == null || Fax_No.equals("")){
					Fax_No = "無し";
				}else{
				Fax_No = FaxNo1 + "-" + FaxNo2 + "-" + FaxNo3;//FAX番号の形式を変換
				}
			}else{
				Fax_No = BeforeData.getFax_No();
				}
					}
				}
		}
		}catch(Exception e){
			e.printStackTrace();
		}
		//if(LinkFrom == true){//初回の入力(リンク元がProposal_Report_Temp)かどうか
			if(Kikakuryou_Uketori.equals("企画料として一括で受け取りたい")){//入力が初回の場合の処理
				if(Kikakuryou_S == null || Kikakuryou_S.equals("")){
					Kikakuryou = 0;
				}else{
				Kikakuryou = Integer.parseInt(Kikakuryou_S);
				}
				}else if(Kikakuryou_Uketori.equals("発生した売り上げの一部をロイヤリティとして受け取りたい")){
					try{
					if(Royality_S == null || Royality_S.equals("")){
						Royality = 0;
					}else{
					Royality = Double.parseDouble(Royality_S);
					}
					}catch(NumberFormatException e){
						Wrong = true;
					}
					}else{
			if(Henkou_Koumoku == null || Henkou_Koumoku.length == 0){//変更チェックを一つもつけなかった(処理が不要な)場合は何もしない
				for(String list2 : Henkou_Koumoku){
					if(list2.equals("keiyakujyouken") == true){//契約条件の変更チェックが入っている場合は
						if(Kikakuryou_Uketori.equals("企画料として一括で受け取りたい")){//入力が2回目以降の場合の処理
							try{
							if(Kikakuryou_S == null || Kikakuryou_S.equals("")){
								Kikakuryou = 0;
							}else{
							Kikakuryou = Integer.parseInt(Kikakuryou_S);
							}
							}catch(NumberFormatException e){
								Wrong = true;
							}
							}else if(Kikakuryou_Uketori.equals("発生した売り上げの一部をロイヤリティとして受け取りたい")){
								try{
								if(Royality_S == null || Royality_S.equals("")){
									Royality = 0;
								}else{
								Royality = Double.parseDouble(Royality_S);
								}
								}catch(NumberFormatException e){
									Wrong = true;
								}
						break;//変更チェックを検出した時点で処理終了
				}else{//契約条件の変更チェックが入っていない場合は変更前の値で上書き
					Kikakuryou_Uketori = BeforeData.getKikakuryou_Uketori();
					Kikakuryou = BeforeData.getKikakuryou();
					Royality = BeforeData.getRoyality();
					}
					}
			}
			}
			}
		//}
		
		
			PropData = new NewGames_TO(GameTitle, MainGenre, SubGenre1, SubGenre2, PlatForm, CatchCopy, Gaiyou,
					PenName, Kikakusya_sei, Kikakusya_mei, Seifurigana, Meifurigana, Hogosyasei, Hogosyamei, Seinengappi,
					Pref, Jyusyo, Tel_No, Keitai_No, Fax_No, MailAddress, Url, Syokugyou, Tsutomesaki, TsutomesakiJyusyo,
					Seisakurireki, Kikakuito, Target, Sabetsuka, Advantage, Kikakuryou_Uketori, Kikakuryou, Royality, Bikou, Koukaisettei, Koukaisettei_etc, NGHit, Nosign, NoData, Wrong);
			
			BeforeData = new NewGames_TO(GameTitle, MainGenre, SubGenre1, SubGenre2, PlatForm, CatchCopy, Gaiyou,
					PenName, Kikakusya_sei, Kikakusya_mei, Seifurigana, Meifurigana, Hogosyasei, Hogosyamei, Seinengappi,
					Pref, Jyusyo, Tel_No, Keitai_No, Fax_No, MailAddress, Url, Syokugyou, Tsutomesaki, TsutomesakiJyusyo,
					Seisakurireki, Kikakuito, Target, Sabetsuka, Advantage, Kikakuryou_Uketori, Kikakuryou, Royality, Bikou, Koukaisettei, Koukaisettei_etc, NGHit, Nosign, NoData, Wrong);
			session.setAttribute("propkoumoku", PropData);
			session.setAttribute("beforekoumoku", BeforeData);
			/*if(LinkFrom == false){
				NextPage = "/passed/NewGames/Proposal_Report_Temp.html";
			}
			else*/ if(NGHit == false && Nosign == false && NoData == false && Wrong == false){
				NextPage = "/passed/NewGames/Proposal_Rep_Saisyukakunin.jsp";
			}else{
				NextPage = "/passed/NewGames/Proposal_Report_Syusei.jsp";
			}
			/*
			System.out.println(Seifurigana);
			System.out.println(Meifurigana);
			System.out.println(Hogosyasei);
			System.out.println(Hogosyamei);
			System.out.println(Tanjyounen_S);
			System.out.println(Tanjyoutsuki_S);
			System.out.println(Tanjyoubi_S);
			System.out.println(Pref);
			System.out.println(Jyusyo);
			System.out.println(Tel_No1);
			System.out.println(Tel_No2);
			System.out.println(Tel_No3);
			System.out.println(KeitaiNo1);
			System.out.println(KeitaiNo2);
			System.out.println(KeitaiNo3);
			System.out.println(FaxNo1);
			System.out.println(FaxNo2);
			System.out.println(FaxNo3);
			System.out.println(MailAddress);
			System.out.println(Url);
			System.out.println(Syokugyou);
			System.out.println(Tsutomesaki);
			System.out.println(TsutomesakiJyusyo);
			System.out.println(Seisakurireki);
			System.out.println(Kikakuito);
			System.out.println(Target);
			System.out.println(Sabetsuka);
			System.out.println(Advantage);
			System.out.println(Kikakuryou_Uketori);
			System.out.println(Kikakuryou_S);
			System.out.println(Royality_S);
			System.out.println(Bikou);
			System.out.println(Koukaisettei_etc);
			*/
			
	}catch(Exception e){
		e.printStackTrace();
		session.setAttribute("errcode", "Rep-009");
		NextPage = "/passed/Error_Gamen.jsp";
	}
			ServletContext sc = getServletContext();
			RequestDispatcher rd = sc.getRequestDispatcher(NextPage);
			rd.forward(request, response);
	}

}
