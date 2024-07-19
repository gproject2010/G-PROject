<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="gpro_riron.GPRiron_TO" %>
    <%@ page import="gpro_riron.GPRiron_DAO" %>
    <%@ page import="gpro_riron.Ronbun_Shinki_Kakunin" %>
    <jsp:useBean id="newdata" scope="session" type="gpro_riron.GPRiron_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/GPRO_Riron/Ronbun_Shinki_Kakunin.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRiron.css"/>
<title>論文の登録確認</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/GRiron_Logo.gif" width="371" height="122" border="0"></p>
<p><b><font size="+2">論文更新確認</font></b></p>
<p><b><font size="+1" color="#0000cc">下記の内容で新規登録します。登録するには「確定」を<br>
論文のタイトル、ソースコードを編集しなおすには「再編集」を<br>
論文を登録せずに終了する場合は「会員メニューに戻る」を<br>
クリックしてください。</font></b></p>
<p><b><font size="+1">論文コード:<%=newdata.getRonbunCode() %></font></b></p>
<p>更新後の論文（インラインフレームを使用しています）</p>
<p><b><font size="+2">論文タイトル：<%=newdata.getRonbunTitle() %></font></b></p>
<p><iframe src="/G-pro_Service/Ronbun_BodyLoad/<%=newdata.getHTMLFileName() %>?time=hensyugo" width="640" height="1280">
<font color="red" size="+1">ブラウザがインラインフレームに対応していないため表示できません。<br>
対応しているブラウザでご覧ください。</font></iframe></p>
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Your_Data.gif" width="300" height="60" border="0"><b>※必ず確認してください。</b></p>
<p><b>G-PRO　ID:<%=HttpUtility.escapeHTML(newdata.getPlayer_Id()) %></b></p>
<p><b>プレイヤーネーム：<%=HttpUtility.escapeHTML(newdata.getPlayerName()) %></b></p>
<!-- <p align="center"><a href="/G-pro_Service/Ronbun_Touroku"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Kakutei_Button.gif"  width="67" height="52" border="0" alt="確定"></a>　　　　　<a href="/G-pro_Service/Ronbun_Touroku_Cansel?syubetsu=shinki"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Saihensyu_Button.gif" width="99" height="53" border="0" alt="再編集"></a>　　　　　<a href="/G-pro_Service/Ronbun_Touroku_Cansel?syubetsu=back"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoKaiinTop.gif" width="213" height="53" border="0"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/Ronbun_Touroku">この論文を登録</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/Ronbun_Touroku_Cansel?syubetsu=shinki">論文を編集しなおす</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/Ronbun_Touroku_Cansel?syubetsu=back">更新せずに会員メニューへ戻る</a></dd>
</dl>
</body>
</html>