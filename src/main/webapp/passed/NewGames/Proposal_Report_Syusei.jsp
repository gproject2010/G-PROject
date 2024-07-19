<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.util.Calendar"%>
    <%@ page import="java.util.GregorianCalendar"%>
    <%@ page import="rep_upload.NewGames_TO" %>
    <%@ page import="rep_upload.Proposal_Rep_Kakunin" %>
    <jsp:useBean id="propkoumoku" scope="session" type="rep_upload.NewGames_TO" />
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/NewGames/Proposal_Report_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>提案レポート(修正)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<form action="/G-pro_Service/Proposal_Rep_Kakunin" method="post">
<%Calendar Today = new GregorianCalendar(); %>
<p><img src="../../image/Proposal.gif" width="540" height="94" border="0"></p>
<p>レポート種別：提案レポート（添付書類）</p>
<br>
<br>
<%if(propkoumoku.isNoData() == true){ %>
<font color="#0000cc">入力されていない項目があります。確認の上再試行してください。<br></font>
<% } %><br>
<%if(propkoumoku.isNoSign() == true){ %>
<font color="#0000cc">保護者の方へ:アップロードには保護者の承諾が必要です。<br>
企画投稿規約をお読みになり、承諾のうえ「企画作品概要」の保護者欄にお名前の入力をお願いいたします。<br></font>
<% } %><br>
<%if(propkoumoku.isNGHit() == true){ %>
<font color="red">ネット上に公開できない記述があります。該当する部分を削除・訂正のうえ再試行してください。<br></font>
<% } %><br>
<%if(propkoumoku.isWrong() == true){ %>
<font color="red">無効または不正な記述があります。該当する部分を削除・訂正のうえ再試行してください。<br></font>
<% } %><br>
<p>Q1:企画作品概要<br>
<br>
ゲームタイトル(必須)：<input size="50" type="text" name="gametitle" value="<%=HttpUtility.escapeHTML(propkoumoku.getGameTitle()) %>"><br>
<br>
メインジャンル(必須)：<input size="20" type="text" name="maingenre" value="<%=HttpUtility.escapeHTML(propkoumoku.getMainGenre()) %>">　サブジャンル1：<input size="20" type="text" name="subgenre1" value="<%=HttpUtility.escapeHTML(propkoumoku.getSubGenre1()) %>">　サブジャンル2:<input size="20" type="text" name="subgenre2" value="<%=HttpUtility.escapeHTML(propkoumoku.getSubGenre2())%>"><br>
<br>
想定しているプラットフォーム（正式名称で3つまで）:<input size="40" type="text" name="platform" value="<%=HttpUtility.escapeHTML(propkoumoku.getPlatForm()) %>"><br>
<br>キャッチコピー(必須)：<input size="60" type="text" name="catchcopy" value="<%=HttpUtility.escapeHTML(propkoumoku.getCatchCopy()) %>"></p>
<p>ゲーム概要(必須)：<br>
<textarea rows="10" cols="50" name="gaiyou"><%=propkoumoku.getGaiyou() %></textarea><br>
※最大全角500文字以内。</p>
<p>Q2:応募者情報<br>
<br>
企画者の名称またはペンネーム：<input size="15" type="text" name="penname" value="<%=HttpUtility.escapeHTML(propkoumoku.getPenName()) %>"><br>
<br>
企画者氏名（グループ制作などの場合は代表者氏名）(必須):　姓<input size="10" type="text" name="kikakusya_sei" value="<%=HttpUtility.escapeHTML(propkoumoku.getKikakusya_Sei()) %>">　名<input size="20" type="text" name="kikakusya_mei" value="<%=HttpUtility.escapeHTML(propkoumoku.getKikakusya_Mei()) %>"><br>
<br>
　　　　　　　　　　　　　　　　　　　　　　　　　　　ふりがな(必須)：　姓<input size="20" type="text" name="seifurigana" value="<%=HttpUtility.escapeHTML(propkoumoku.getSeifurigana()) %>">　名<input size="20" type="text" name="meifurigana" value="<%=HttpUtility.escapeHTML(propkoumoku.getMeifurigana()) %>"><br>
<br>
<font color="#0000cc">※金銭授受の契約が発生する場合がありますので、20歳未満の方が応募する場合は保護者の方が<br>
応募規約に同意したうえで、以下の欄に保護者の方の名前を入力してください。入力がない場合、<br>
応募が受け付けられません。なお企画が企業などに採用された場合、入力された名前の保護者様に<br>
改めて同意の意思を確認させていただきます。</font><br>
<br>
　　　　　　　　保護者氏名（企画者・代表者の保護者様）:　姓<input size="10" type="text" name="hogosyasei" value="<%=HttpUtility.escapeHTML(propkoumoku.getHogosyasei()) %>">　名<input size="10" type="text" name="hogosyamei" value="<%=HttpUtility.escapeHTML(propkoumoku.getHogosyamei()) %>"><br>
<br>
<br>
<%if(propkoumoku.getSeinengappi().get(Calendar.YEAR) == 9999){ %><font color="yellow">生年月日が入力されていません！もう一度入力してください</font><br>
<% }else{ %>
現在入力されている企画者の生年月日は<%=propkoumoku.getSeinengappi().get(Calendar.YEAR) %> 年  <%=propkoumoku.getSeinengappi().get(Calendar.MONTH) + 1 %> 月 <%=propkoumoku.getSeinengappi().get(Calendar.DATE) %>日です。<br>
生年月日を変更する場合は以下のチェックボックスをオンにし、フォームに変更後の生年月日を入力してください)<br>
<br>
<input type="checkbox" name="henkou_koumoku" value="seinengappi">生年月日を変更する<br>
<% } %>
<br>
変更後の企画者の生年月日（西暦）(必須):<input size="4" type="text" name="tanjyounen">年<select name="tanjyoutsuki">
  <option value="1" selected>1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
</select>月<input size="2" type="text" name="tanjyoubi">日<br>
<br>
現在選択されている住所の都道府県：<%=HttpUtility.escapeHTML(propkoumoku.getPref()) %><br>
住所(都道府県)を変更する場合は以下のチェックボックスをオンにし、<br>
フォームで変更後の都道府県を選択してください)<br>
<br>
<input type="checkbox" name="henkou_koumoku" value="pref">住所(都道府県)を変更する<br>
<br>
変更後の都道府県:<select name="pref">
   <option value="北海道">北海道</option>
  <option value="青森県">青森県</option>
  <option value="秋田県">秋田県</option>
  <option value="岩手県">岩手県</option>
  <option value="山形県">山形県</option>
  <option value="宮城県">宮城県</option>
  <option value="福島県">福島県</option>
  <option value="新潟県">新潟県</option>
  <option value="栃木県">栃木県</option>
  <option value="群馬県">群馬県</option>
  <option value="茨城県">茨城県</option>
  <option value="埼玉県">埼玉県</option>
  <option value="東京都" selected>東京都</option>
  <option value="千葉県">千葉県</option>
  <option value="神奈川県">神奈川県</option>
  <option value="山梨県">山梨県</option>
  <option value="長野県">長野県</option>
  <option value="静岡県">静岡県</option>
  <option value="富山県">富山県</option>
  <option value="岐阜県">岐阜県</option>
  <option value="愛知県">愛知県</option>
  <option value="石川県">石川県</option>
  <option value="福井県">福井県</option>
  <option value="滋賀県">滋賀県</option>
  <option value="三重県">三重県</option>
  <option value="京都府">京都府</option>
  <option value="奈良県">奈良県</option>
  <option value="和歌山県">和歌山県</option>
  <option value="大阪府">大阪府</option>
  <option value="兵庫県">兵庫県</option>
  <option value="鳥取県">鳥取県</option>
  <option value="岡山県">岡山県</option>
  <option value="島根県">島根県</option>
  <option value="広島県">広島県</option>
  <option value="山口県">山口県</option>
  <option value="香川県">香川県</option>
  <option value="徳島県">徳島県</option>
  <option value="高知県">高知県</option>
  <option value="愛媛県">愛媛県</option>
  <option value="福岡県">福岡県</option>
  <option value="佐賀県">佐賀県</option>
  <option value="長崎県">長崎県</option>
  <option value="大分県">大分県</option>
  <option value="熊本県">熊本県</option>
  <option value="宮崎県">宮崎県</option>
  <option value="鹿児島県">鹿児島県</option>
  <option value="沖縄県">沖縄県</option>
  </select>
<br>
住所(市町村名以下)(必須):（アパート・マンション名・部屋番号など正確に入力してください。）<br>
　<textarea rows="5" cols="25" name="jyusyo"><%=HttpUtility.escapeHTML(propkoumoku.getJyusyo()) %></textarea><br>
<br>
<br>
現在入力されている電話番号は<br><br>
電話番号：<%if(propkoumoku.getTel_No().equals("ERROR")){%><font color="yellow">もう一度入力してください</font><%}else{%><%=HttpUtility.escapeHTML(propkoumoku.getTel_No()) %><% } %><br>
携帯番号:<%=HttpUtility.escapeHTML(propkoumoku.getKeitai_No()) %><br>
FAX番号：<%=HttpUtility.escapeHTML(propkoumoku.getFax_No()) %><br>
です。
変更する場合は以下のチェックボックスをオンにし、フォームに変更後の番号を入力してください。<br>
<br>
<input type="checkbox" name="henkou_koumoku" value="telno">電話番号を変更する<br>
<input type="checkbox" name="henkou_koumoku" value="keitaino">携帯番号を変更する<br>
<input type="checkbox" name="henkou_koumoku" value="faxno">FAX番号を変更する<br>
<br>
電話番号(必須)：　　　<input size="15" type="text" name="telno1">-<input size="8" type="text" name="telno2">-<input size="8" type="text" name="telno3"><br>
<br>
予備電話番号:<input size="15" type="text" name="keitaino1">-<input size="8" type="text" name="keitaino2">-<input size="8" type="text" name="keitaino3"><br>
<br>
FAX番号：　　　<input size="15" type="text" name="faxno1">-<input size="8" type="text" name="faxno2">-<input size="8" type="text" name="faxno3"><br>
<br>
連絡先メールアドレス（PC用）(必須):　　　<input size="50" type="text" name="mailaddress" value="<%=HttpUtility.escapeHTML(propkoumoku.getMailAddress()) %>"><br>
<br>
企画者が開設しているHPのURL：　<input size="50" type="text" name="url" value="<%=HttpUtility.escapeHTML(propkoumoku.getUrl()) %>"><br>
<br>
企画者の現在の職業（仕事内容）：<input size="10" type="text" name="syokugyou" value="<%=HttpUtility.escapeHTML(propkoumoku.getSyokugyou()) %>"><br>
<br>
通勤・通学している会社・学校名（任意）:　<input size="30" type="text" name="tsutomesaki" value="<%=HttpUtility.escapeHTML(propkoumoku.getTsutomesaki()) %>"><br>
<br>
会社・学校の連絡先住所（任意）:<br>
<textarea rows="4" cols="20" name="tsutomesakijyusyo"><%=HttpUtility.escapeHTML(propkoumoku.getTsutomesakiJyusyo()) %></textarea><br>
<br>
今までに制作したゲームなどの開発履歴：<br>
<textarea rows="4" cols="25" name="seisakurireki"><%=HttpUtility.escapeHTML(propkoumoku.getSeisakurireki()) %></textarea><br>
</p>
<p>Q3:企画詳細<br>
<br>
企画意図：このゲームを企画した理由、このゲームが売れると思う根拠、<br>このゲームが持っている魅力などを自由に語ってください。(必須)<br>
<textarea rows="10" cols="100" name="kikakuito"><%=HttpUtility.escapeHTML(propkoumoku.getKikakuito()) %></textarea><br>
<br>
ターゲット層：このゲームを提案するうえでどんなお客様（プレイヤー）をターゲットとするかを記述してください。<br>
<br>
<textarea rows="5" cols="60" name="target"><%=HttpUtility.escapeHTML(propkoumoku.getTarget()) %></textarea><br>
<br>
差別化:このゲームを企画するうえで参考にした、もしくはよく似たアニメ、ゲーム、小説、ライトノベルなどがある場合、<br>
それらとの違いを記述してください。<br>
<textarea rows="5" cols="60" name="sabetsuka"><%=propkoumoku.getSabetsuka() %></textarea><br>
</p>
Q4：契約などの条件<br>
有利な条件:「すでにゲームのエンジンを持っている」「α版がある」「プレゼンのための<br>資料や仕様が完成している」など、これから開発するうえで有利となる条件があれば記述してください。<br>
<textarea rows="5" cols="60" name="advantage"><%=HttpUtility.escapeHTML(propkoumoku.getAdvantage()) %></textarea><br>
<br>
希望価格：もし企業に採用された場合、企画料をどういう方法で受け取りたいか入力してください。<br>
現在設定されている方法：<%=HttpUtility.escapeHTML(propkoumoku.getKikakuryou_Uketori()) %><br>
<%if(propkoumoku.getKikakuryou_Uketori().equals("企画料として一括で受け取りたい")){ %>
企画料：<%=propkoumoku.getKikakuryou() %>円
<%}else if(propkoumoku.getKikakuryou_Uketori().equals("発生した売り上げの一部をロイヤリティとして受け取りたい")){%>
ロイヤリティ：<%=propkoumoku.getRoyality() %>％
<% } %>
<br>
変更する場合は以下のチェックボックスをオンにし、フォームに変更後の条件を入力してください。<br>
<br>
<input type="checkbox" name="henkou_koumoku" value="keiyakujyouken">条件を変更する<br>
<br>
<input type="radio" name="kikakuryou_uketori" value="今のところ考えていない" checked>今のところ考えていない<br>
<br>
<input type="radio" name="kikakuryou_uketori" value="企画料として一括で受け取りたい">企画料として一括で受け取りたい<br>
※「千」、「万」、「,」(カンマ)などは使用せず、半角数字だけで入力してください。<br>
<input size="12" type="text" name="kikakuryou">円<br>
<br>
<input type="radio" name="kikakuryou_uketori" value="発生した売り上げの一部をロイヤリティとして受け取りたい">発生した売り上げの一部をロイヤリティとして受け取りたい<br>
・具体的に何％と決めている場合は以下のフォームに入力してください。<br>
※半角数字と小数点を表す「.」(ピリオド)だけで入力してください。<br>
<input size="5" type="text" name="royality">％<br>
<br>
<input type="radio" name="kikakuryou_uketori" value="その他">その他：希望価格・ロイヤリティ以外に条件などがある場合もここへ記述してください。<br>
<textarea rows="5" cols="50" name="bikou"></textarea>
<p>Q5:企画書データの公開設定<br>
アップロードするデータのうち、一般会員(プレイヤー)に公開するものにチェックを入れてください。<br>
現在の設定では<%for(String List : propkoumoku.getKoukaisettei()){ %>・<%=List %>  <% } %>が選択されています。<br>
変更する場合は以下のチェックボックスをオンにし、フォームに変更後の設定を入力してください。<br>
<br>
<input type="checkbox" name="henkou_koumoku" value="koukaisettei">公開設定を変更する<br>
<br>
<!-- <font color="#0000cc">※1：企画書とここでチェックを入れなかったデータについては法人会員(ゲームメーカーなど)のみに配信します。</font><br>
<font color="#0000cc">※2：チェックを1つも入れなかった場合、一般会員には企画を公開しません。</font><font color="#0000cc"><br>-->
<font color="#ff0000">※ここでチェックを入れた資料はすべての一般会員も閲覧できるようになります。盗作されないよう、<br>
この項目は慎重に設定してください。<br>
</font><br>
<input type="checkbox" name="koukaisettei" value="設定資料">設定資料　<input type="checkbox" name="koukaisettei" value="企画解説書">企画解説書　<input type="checkbox" name="koukaisettei" value="公開用体験版">公開用体験版　　<input type="checkbox" name="koukaisettei" value="紹介・イメージVTR">紹介・イメージVTR<br>
<input type="checkbox" name="koukaisettei" value="題字・ロゴ">題字・ロゴ　<input type="checkbox" name="koukaisettei" value="その他プレゼン用資料">その他プレゼン用資料　　<input type="checkbox" name="koukaisettei" value="その他">ここに挙げられているもの以外のファイル<input size="30" type="text" name="koukaisettei_etc" value="ここにファイル名を入力してください"></p>

<!-- <input type="image" name="submit" value="確定" src="../../image/Kakutei_Button.gif" width="61" height="48" border="0">-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
</form>
</body>
</html>