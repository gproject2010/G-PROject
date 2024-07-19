<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
   <%@ page import="rep_upload.NewGames_TO" %>
   <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="rep_upload.NewGame_DAO" %>
    <%@ page import="rep_upload.Rep_List_DAO" %>
    <%@ page import="rep_upload.NewGame_Rep_Kakunin" %>
    <%@ page import="g_jyouhou.NewGame_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="rep_upload.NewGames_TO" />
    <jsp:useBean id="newgamerep" scope="session" type="rep_upload.Rep_Koumoku" />
    <%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="k_jyouhou.StatusMaker" %>
    <jsp:useBean id="seiseki" scope="session" class="k_jyouhou.R_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/NewGames/PropRep_Report_Kakunin.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>プロポーサルレポート・レスポンス(確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/passed/NewGames/WordRep_Images/Rep_Logo.gif" width="365" height="55" border="0" alt="-Word Report-"></p>
<p><b><font color="#0000cc" size="+2">以下の内容をG-PROjectに登録します。よろしいですか?</font></b></p>
<p><b>レポート種別：プロポーサルレポート・レスポンス</b></p>
<p><b>ゲームタイトル：<%=HttpUtility.escapeHTML(syousai.getGameTitle()) %></b></p>
<p><b>メインジャンル:<%=syousai.getMainGenre() %>　<%if(syousai.getSubGenre1() != null){%>サブジャンル:<%=syousai.getSubGenre1() %><% } %><%if(syousai.getSubGenre2() != null){ %>、<%=syousai.getSubGenre2() %><% } %></b></p>
<p><b>企画者名称・ペンネーム：<%=HttpUtility.escapeHTML(syousai.getPenName()) %></b></p>
<p><b>企画意図:</b><br>
<pre><%=syousai.getGaiyou() %></pre>
<p>このレポートに対する評価・アドバイスなど<br>
<pre><%=HttpUtility.escapeHTML(newgamerep.getComment()) %></pre>
<p><b><img src="/G-pro_Service/passed/NewGames/WordRep_Images/Your_Data.gif" width="300" height="60" border="0"><font size="+2">（必ず確認してください）</font></b></p>
<p><b>G-PRO　ID:　<%=seiseki.getk_Id() %></b></p>
<p><b>プレイヤーネーム(ゲーム紹介ページに表示されます)：<%=seiseki.getlogin_name() %></b></p>
<!-- <p><a href="/G-pro_Service/PropRep_Report_Touroku"><img src="/G-pro_Service/passed/NewGames/WordRep_Images/Touroku_Button.gif"  alt="登録"  width="61" height="48" border="0"></a></p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/PropRep_Report_Touroku">登録</a></dd>
    </dl>
</body>
</html>