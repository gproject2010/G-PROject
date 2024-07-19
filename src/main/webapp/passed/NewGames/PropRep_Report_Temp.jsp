<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
   <%@ page import="rep_upload.NewGames_TO" %>
    <%@ page import="rep_upload.NewGame_DAO" %>
    <%@ page import="rep_upload.Rep_List_DAO" %>
    <%@ page import="g_jyouhou.NewGame_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="rep_upload.NewGames_TO" />
    <%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="k_jyouhou.StatusMaker" %>
    <jsp:useBean id="seiseki" scope="session" class="k_jyouhou.R_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/NewGames/PropRep_Report_Temp.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>プロポーサルレポート・レスポンス(作成)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/passed/NewGames/WordRep_Images/Rep_Logo.gif" width="408" height="87" border="0"></p>
<p><b>レポート種別：プロポーサルレポート・レスポンス</b></p>
<p><b>ゲームタイトル：<%=syousai.getGameTitle() %></b></p>
<p><b>メインジャンル:<%=syousai.getMainGenre() %>　<%if(syousai.getSubGenre1() != null){%>サブジャンル:<%=syousai.getSubGenre1() %><% } %><%if(syousai.getSubGenre2() != null){ %>、<%=syousai.getSubGenre2() %><% } %></b></p>
<p><b>企画者名称・ペンネーム:<%=syousai.getPenName() %></b></p>
<p><b>ゲーム概要:</b><br>
<pre><%=syousai.getGaiyou() %></pre>
<form action="/G-pro_Service/NewGame_Rep_Kakunin" method="post">
<input type="hidden" name="rep_syubetsu" value="propresp">
<p>このレポートに対する評価・アドバイスなど(全角500文字以内。なおフォームの横幅は全角50文字分です。<br>
<textarea name="comment" rows="10" cols="100">ここに入力してください</textarea></p>
<p><img src="/G-pro_Service/passed/NewGames/WordRep_Images/Your_Data.gif" width="300" height="60" border="0"></p>
<p><b>G-PRO　ID:　<%=seiseki.getk_Id() %></b></p>
<p><b>プレイヤーネーム：<%=seiseki.getlogin_name() %></b></p>
<!-- <p><input type="image" name="submit" src="/G-pro_Service/passed/NewGames/WordRep_Images/Kakutei_Button.gif" width="53" height="42" border="0"></p>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
</form>
</body>
</html>