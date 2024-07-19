<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@page import="inputUtility.HttpUtility" %>
    <%@page import="mail.Toiawase_Koumoku" %>
    <%@page import="mail.Toiawase_Kakunin" %>
    <jsp:useBean id="toi" scope="session" type="mail.Toiawase_Koumoku"/>
<html lang="ja">
<head>
<base href="/G-pro_Service/free_Area/Toi_Kakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>お問い合わせページ</title>
</head>
<body background="/G-pro_Service/image/Toiawase_Back.gif">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"><br>
<br>
<font size="+2">お問い合わせ用フォーム<br>
</font><br>
<font color="blue" size="+1">お問い合わせの内容を確認し、よろしければ「この内容で登録する」をクリックしてください。</font><br>
<br>
<br>
回答受信用メールアドレス：<%=HttpUtility.escapeHTML(toi.getFrom()) %><br>
<br>
問い合わせ種別:<%=HttpUtility.escapeHTML(toi.getToi_Syubetsu()) %><br>

件名:<%=HttpUtility.escapeHTML(toi.getSubject()) %><br>
<br>
本文：
<%=HttpUtility.escapeHTML(toi.getBody()) %><br>
<br>
<!-- <a href="/G-pro_Service/Toiawase_Touroku"><img src="/G-pro_Service/image/Soushin_Button.gif" name="submit" width="53" height="42" border="0" alt="この内容で登録する"></a>　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="188" height="43" border="0" alt="サイトトップに戻る"></a><br>-->
<input id="tourokubutton" type="submit" name="submit" value="この内容で問い合わせる">
    <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
</body>
</html>