<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="k_jyouhou.Kaiin_Touroku_Kakunin" %>
    <jsp:useBean id="tourokudata_p1" scope="session" type="k_jyouhou.K_Touroku_TO"/>
     <%@page import="k_jyouhou.Kaiin_Touroku_Kakunin_p2" %>
    <jsp:useBean id="tourokudata_p2" scope="session" type="k_jyouhou.K_Touroku_TO"/>
     <%@ page import="ninsyou.AuthenticationController" %>
    <%@ page import="k_jyouhou.K_Touroku_TO" %>
    <%@ page import="k_jyouhou.K_Touroku_DAO" %>
    <jsp:useBean id="mailaddress" scope="session" type="k_jyouhou.K_Touroku_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/Shinki_Nyukai_Lv2/Kaiin_SaisyuKakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>プロフィール情報最終確認</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif" style="font-weight : bold;">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<ul class="bread">
<li><a href="#">Step1:注意事項の確認・メールアドレスの登録</a></li>
<li><a href="#">Step2:G-PRO ID、パスワードの登録</a></li>
<li><a href="#">Step3:プロフィール情報の登録</a></li>
<li class="current"><a href="#">登録する情報の最終確認</a></li>
<li><a href="#">利用登録の完了</a></li>
</ul>
<p><font size="+3">G-Project会員登録(登録内容確認)<br>
</font><font size="+2"><br>
会員登録を行う前にチュートリアルの項目をよく読んでください。<br>
<br>
</font>
<font size="+2"><br>
この内容で登録しますか？登録するには「登録」を、修正するには「キャンセル」をクリックしてください。<br>
<br>
</font></p>
<table border="1">
  <tbody>
    <tr>
      <td><font size="+1">プレイヤーネーム:</font></td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(tourokudata_p1.getLogin_Name()) %></td>
    </tr>
  </tbody>
</table>
<table border="1">
  <tbody>
    <tr>
      <td>ID:&nbsp;</td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(tourokudata_p1.getKibou_Id()) %></td>
    </tr>
  </tbody>
</table>
<p>※記号を除いた半角英数字8～16文字。すでに使用されているものは使えません。</p>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;パスワード：</td>
      <td>&nbsp;<%for(int i=0; i < tourokudata_p1.getKibou_Password().length(); i++){ %>*<% } %></td>
    </tr>
  </tbody>
</table>
<p>　※記号を除いた半角英数字で8～16文字。大文字・小文字は区別しません。<br>
　※ゾロ目、続き数字、キリ番(1000、2000など)、ほかの個人情報から推測できるものなどは避けてください。<br>
</p>
<table border="1">
  <tbody>
    <tr>
      <td>PCメールアドレス：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(mailaddress.getMail_Address()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;携帯メールアドレス(任意)：</td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(tourokudata_p1.getKeitai_Address()) %></td>
    </tr>
  </tbody>
</table>
<p>※最大半角50文字まで(記号も使用できます)</p>
<br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>本名（姓）：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(tourokudata_p2.getSei_Kanji()) %>&nbsp;</td>
      <td>本名（名）：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(tourokudata_p2.getMei_Kanji()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;本名（セイ）：</td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(tourokudata_p2.getSei_Kana()) %></td>
      <td>&nbsp;本名（メイ）：</td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(tourokudata_p2.getMei_Kana()) %></td>
    </tr>
  </tbody>
</table>
<br><p>
※姓のみ、利用開始後も変更できます。<br>
</p>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;生年月日：</td>
      <td><%=HttpUtility.escapeHTML(tourokudata_p2.getBirthYear()) %>年(西暦)</td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(tourokudata_p2.getBirthTsuki()) %>月</td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(tourokudata_p2.getBirthDay()) %>日</td>
    </tr>
  </tbody>
</table>
<br>

<br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>性別：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(tourokudata_p2.getSex()) %></td>
    </tr>
  </tbody>
</table>
<br>
※生年月日・性別は一度登録すると原則変更できません。ご注意ください。<br>
<br>
現在の職業：<%=HttpUtility.escapeHTML(tourokudata_p2.getJob()) %>
<br>
<br>
郵便番号：<%=HttpUtility.escapeHTML(tourokudata_p2.getAddressNo()) %><br>
<br>
住所(都道府県）：<br>
<%=HttpUtility.escapeHTML(tourokudata_p2.getPref()) %><br>
<br>
住所(市町村名～）：<br>
<%=HttpUtility.escapeHTML(tourokudata_p2.getJyusyo()) %><br>
<table border="1">
  <tbody>
    <tr>
      <td>連絡先電話番号(携帯可）：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(tourokudata_p2.getTelephone_No()) %>&nbsp;</td>
    </tr>
  </tbody>
</table><br>
※住所・連絡先電話番号ともに利用開始後でも変更できます。<br>
<br>
<br>
秘密の質問(ID・パスワードを忘れた場合に必要となります。あなただけが分かることを入力してください)<br>
<br>
質問:<%=HttpUtility.escapeHTML(tourokudata_p2.getSecret_Question()) %><br>
<br>
答え:<%=HttpUtility.escapeHTML(tourokudata_p2.getSecret_Answer()) %><br>
<br>
※1:照合する際、文字列が完全に一致しないと確認できません。はっきりと覚えているものを使用してください。<br>
※2:質問とそれに対する答えとして成立していない場合、会員登録ができないことがあります。<br>
※3:質問・答えともに利用開始後でも変更できます。<br>
<br>
<br>
<!-- <a href="/G-pro_Service/New_Kaiin_Maker"><img alt="この内容で登録する" src="/G-pro_Service/image/Touroku_Button.gif"></a><a href="/G-pro_Service/Logout"><img src="/G-pro_Service/image/Cansel_Button.gif" width="82" height="45" border="0"/></a>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/New_Kaiin_Maker">この内容で登録する</a>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/Logout">キャンセルしてトップへ戻る</a>
    </dl>

<br>

</body>
</html>