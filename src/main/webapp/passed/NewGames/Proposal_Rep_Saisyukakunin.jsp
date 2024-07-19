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
<base href="/G-pro_Service/passed/NewGames/Proposal_Rep_Saisyukakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>提案レポート(入力内容最終確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="../../image/Proposal.gif" width="540" height="94" border="0"></p>
<p>レポート種別：提案レポート（添付書類）</p>
<p><font color="#0000cc" size="+2">以下の内容で送信します。よろしければ一番下のフォームに<br>
アップロードするファイルを指定して「確定」をクリックしてください。</font></p>
<p>Q1:企画作品概要<br>
<br>
ゲームタイトル(必須)：<%=HttpUtility.escapeHTML(propkoumoku.getGameTitle()) %><br>
<br>
メインジャンル(必須)：<%=HttpUtility.escapeHTML(propkoumoku.getMainGenre()) %>　サブジャンル1：<%=HttpUtility.escapeHTML(propkoumoku.getSubGenre1()) %>　サブジャンル2:<%=HttpUtility.escapeHTML(propkoumoku.getSubGenre2()) %><br>
<br>
想定しているプラットフォーム（略称で3つまで）:<%=HttpUtility.escapeHTML(propkoumoku.getPlatForm()) %><br>
<br>キャッチコピー(必須)：<%=HttpUtility.escapeHTML(propkoumoku.getCatchCopy()) %></p>
<p>Q2:応募者情報<br>
<br>
企画者の名称またはペンネーム：<%=HttpUtility.escapeHTML(propkoumoku.getPenName()) %><br>
<br>

企画者氏名（グループ制作などの場合は代表者氏名）:　<%=HttpUtility.escapeHTML(propkoumoku.getKikakusya_Sei()) %>　<%=HttpUtility.escapeHTML(propkoumoku.getKikakusya_Mei()) %><br>
<br>
　　　　　　　　　　　　　　　　　　　　　　　　　　　ふりがな：　<%=HttpUtility.escapeHTML(propkoumoku.getSeifurigana()) %>　<%=HttpUtility.escapeHTML(propkoumoku.getMeifurigana()) %><br>
<br>
<font color="#0000cc">※金銭授受の契約が発生する場合がありますので、20歳未満の方が応募する場合は保護者の方が<br>
応募規約に同意したうえで、以下の欄に保護者の方の名前を入力してください。入力がない場合、<br>
応募が受け付けられません。なお企画が企業などに採用された場合、入力された名前の保護者様に<br>
改めて同意の意思を確認させていただきます。</font><br>
<br>
　　　　　　　　保護者氏名（企画者・代表者の保護者様）:　<%=HttpUtility.escapeHTML(propkoumoku.getHogosyasei()) %>　<%=HttpUtility.escapeHTML(propkoumoku.getHogosyamei()) %><br>
<br>
企画者の生年月日（西暦）(必須): <%=propkoumoku.getSeinengappi().get(Calendar.YEAR) %> 年  <%=propkoumoku.getSeinengappi().get(Calendar.MONTH) + 1 %> 月 <%=propkoumoku.getSeinengappi().get(Calendar.DATE) %>日<br>
<br>
企画者住所(必須)<br>
<br>
都道府県: <%=HttpUtility.escapeHTML(propkoumoku.getPref()) %>
<br>
住所(市町村名以下): <%=HttpUtility.escapeHTML(propkoumoku.getJyusyo()) %><br>
<br>
<br>
電話番号：　<%=HttpUtility.escapeHTML(propkoumoku.getTel_No()) %><br>
<br>
携帯電話番号: <%=HttpUtility.escapeHTML(propkoumoku.getKeitai_No()) %><br>
<br>
FAX番号：　<%=HttpUtility.escapeHTML(propkoumoku.getFax_No()) %><br>
<br>
連絡先メールアドレス（PC用）:　<%=HttpUtility.escapeHTML(propkoumoku.getMailAddress()) %><br>
<br>
企画者が開設しているHPのURL：　<%=HttpUtility.escapeHTML(propkoumoku.getUrl()) %><br>
<br>
企画者の現在の職業（仕事内容）： <%=HttpUtility.escapeHTML(propkoumoku.getSyokugyou()) %><br>
<br>
通勤・通学している会社・学校名（任意）:　<%=HttpUtility.escapeHTML(propkoumoku.getTsutomesaki()) %><br>
<br>
会社・学校の連絡先住所（任意）:<br>
<pre><%=HttpUtility.escapeHTML(propkoumoku.getTsutomesakiJyusyo()) %></pre><br>
<br>
今までに制作したゲームなどの開発履歴：<br>
<pre><%=HttpUtility.escapeHTML(propkoumoku.getSeisakurireki()) %></pre><br>
<p>Q3:企画詳細<br>
<br>
企画意図：このゲームを企画した理由、このゲームが売れると思う根拠、<br>
このゲームが持っている魅力などを自由に語ってください。(必須)<br>
<pre><%=HttpUtility.escapeHTML(propkoumoku.getKikakuito()) %></pre><br>
<br>
ターゲット層：このゲームを提案するうえでどんなお客様（プレイヤー）をターゲットとするかを記述してください。<br>
<pre><%=HttpUtility.escapeHTML(propkoumoku.getTarget()) %></pre><br>
<br>
差別化:このゲームを企画するうえで参考にした、もしくはよく似たアニメ、ゲーム、小説、ライトノベルなどがある場合、<br>
それらとの違いを記述してください。<br>
<pre><%=HttpUtility.escapeHTML(propkoumoku.getSabetsuka()) %></pre><br>
Q4：契約などの条件<br>
有利な条件:「すでにゲームのエンジンを持っている」「α版がある」「プレゼンのための<br>資料や仕様が完成している」など、これから開発するうえで有利となる条件があれば記述してください。<br>
<pre><%=HttpUtility.escapeHTML(propkoumoku.getAdvantage()) %></pre><br>
<br>
希望価格：もし企業に採用された場合、企画料をどういう方法で受け取りたいか入力してください。<br>
<br>
受け取り方法：<%=HttpUtility.escapeHTML(propkoumoku.getKikakuryou_Uketori()) %><br>
<%if(propkoumoku.getKikakuryou_Uketori().equals("企画料として一括で受け取りたい")){ %>金額:<%=propkoumoku.getKikakuryou() %>
<%}else if(propkoumoku.getKikakuryou_Uketori().equals("発生した売り上げの一部をロイヤリティとして受け取りたい")){ %>ロイヤリティ:<%=propkoumoku.getRoyality() %>%<% } %><br>
備考:<pre><%=HttpUtility.escapeHTML(propkoumoku.getBikou()) %></pre><br>

<p>Q5:企画書データの公開設定<br>
アップロードするデータのうち、一般会員(プレイヤー)に公開するものにチェックを入れてください。<br>
<font color="#0000cc">※1：企画書とここでチェックを入れなかったデータについては法人会員(ゲームメーカーなど)のみに配信します。</font><br>
<font color="#0000cc">※2：チェックを1つも入れなかった場合、一般会員には企画を公開しません。</font><font color="#0000cc"><br>
<font color="#ff0000">※3：ここでチェックを入れた資料はすべての一般会員も閲覧できるようになります。盗作されないよう、<br>
この項目は慎重に設定してください。</font><br>
</font><br>
一般会員に公開する資料:<%for(String list : propkoumoku.getKoukaisettei()){ %> ・<%=HttpUtility.escapeHTML(list) %> <% } %><br>
<br>
<p><font color="#0000ff">企画書データアップロード<br>
企画書、公開用体験版、その他プレゼン用資料などは同じフォルダに入れてZip圧縮し、以下のフォームから<br>
一度に送信してください。</font><br>
<form action="/G-pro_Service/Proprep_Touroku" enctype="multipart/form-data" method="post">
<font color="#ff0000"><span class="attention">・アップロード可能ファイル：Microsoft PowerPoint(ppt,pptx)、Word(doc,docx)、Excel(xls,xlsx)、<br>
Adobe Acrobat(pdf),および公開用体験版の各種ファイル(可能な限り多くのマシンで実行可能であること)</span></font><span class="attention"><br>
<br>
・アップロード可能容量：<font color="#ffff00">1GB</font>まで　　</span>
アップロードファイル名:<input type="file" name="filename"><br>
<br>
<!-- <input type="image" name="submit" src="../../image/Kakutei_Button.gif" width="61" height="48" border="0"><a href="/G-pro_Service/passed/NewGames/Proposal_Report_Syusei.jsp"><img src="../../image/Rep_Kakinaoshi.gif" width="147" height="43" border="0"></a><br>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/NewGames/Proposal_Report_Syusei.jsp">内容を修正する</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</form>
</body>
</html>