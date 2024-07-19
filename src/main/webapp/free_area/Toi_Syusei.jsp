<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@page import="inputUtility.HttpUtility" %>
    <%@page import="mail.Toiawase_Koumoku" %>
    <%@page import="mail.Toiawase_Kakunin" %>
    <jsp:useBean id="toi" scope="session" type="mail.Toiawase_Koumoku"/>
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Toi_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>お問い合わせページ</title>
</head>
<body background="/G-pro_Service/image/Toiawase_Back.gif">
<form action="/G-pro_Service/Toiawase_Kakunin" method="post">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="628" height="90" border="0"><br>
<br>
<font size="+2">非会員用お問い合わせフォーム<br>
</font><br>
下記フォームにお問い合わせ内容を入力・送信してください。<br>
なお、ご返答まで時間がかかることもありますので、あらかじめご了承ください。</p>
<p>
<% if(toi.isNokoumoku() == true){ %>
<font color="yellow" size="+1">入力されていない項目があります。すべて入力してください。</font>
<% } %>
<% if(toi.isWrong() == true){ %>
<font color="red" size="+1">不正な値が入力されています。入力内容をもう一度確認してください。</font>
<% } %>
<br>
<br>
<br>
回答受信用メールアドレス：<br>
<input size="50" type="text" name="from" value="<%=HttpUtility.escapeHTML(toi.getFrom()) %>"><br>
<br>
問い合わせ種別:<br>
<select name="toi_syubetsu">
  <option value="G-PROjectが行っているサービス全般について">G-PROjectが行っているサービス全般について</option>
  <option value="入会手続きについて">入会手続きについて</option>
  <option value="レポートについて">レポートについて</option>
  <option value="レポート以外のサービスについて">レポートについて</option>
  <option value="マーケティング用データの提供について">マーケティング用データの提供について</option>
  <option value="G-PROマイレージについて">G-PROマイレージについて</option>
  <option value="システムトラブルに関する問い合わせ">レポートについて</option>
  <option value="その他" selected>その他</option>
  <option value="ご意見・ご感想">ご意見・ご感想</option>
  <option value="不具合・バグ報告">不具合・バグ報告</option>
</select><br>
<br>
件名：<br>
<input size="50" type="text" name="subject" value="<%=HttpUtility.escapeHTML(toi.getSubject()) %>"><br>
<br>
本文：
<textarea name="body" rows="8" cols="50"><%=HttpUtility.escapeHTML(toi.getBody()) %></textarea><br>
<br>
<!-- <input type="image" src="/G-pro_Service/image/Soushin_Button.gif" name="submit" width="53" height="42" border="0" alt="送信">　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="90" height="34" border="0" alt="戻る"></a><br>-->
<!-- </p>-->
<input id="tourokubutton" type="submit" name="submit" value="この内容で問い合わせる">
    <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
</form>
</body>
</html>