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
<base href="/G-pro_Service/passed/NewGames/PropRep_Report_Syusei.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>プロポーサルレポート・レスポンス(修正)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/passed/NewGames/WordRep_Images/WordRep_Logo.gif" width="365" height="55" border="0" alt="-Word Report-"></p>
<p><b>レポート種別：プロポーサルレポート・レスポンス</b></p>
<p><b>ゲームタイトル：<%=HttpUtility.escapeHTML(syousai.getGameTitle()) %></b></p>
<p><b>メインジャンル:<%=syousai.getMainGenre() %>　<%if(syousai.getSubGenre1() != null){%>サブジャンル:<%=syousai.getSubGenre1() %><% } %><%if(syousai.getSubGenre2() != null){ %>、<%=syousai.getSubGenre2() %><% } %></b></p>
<p><b>企画者名称・ペンネーム：<%=HttpUtility.escapeHTML(syousai.getPenName()) %></b></p>
<p><b>企画意図:</b><br>
<pre><%=syousai.getGaiyou() %></pre>
<%if(newgamerep.isNoComment()){ %>
<p><b><font size="+2" color="yellow">コメントが入力されていません!</font></b></p>
<% }else if(newgamerep.isover() == true){ %>
<p><b><font size="+2" color="yellow">コメントの文字数が制限をオーバーしています。</font></b></p>
<% }if(newgamerep.getNGWord() != null){ %>
<p><b><font size="+2" color="red">禁止ワード（ネット上に公開できない単語）が含まれています!(検出された禁止ワード：<%=newgamerep.getNGWord() %>)
該当する箇所を削除・訂正して再試行してください。</font></b></p>
<% } %>
<form action="/G-pro_Service/NewGameRep_Kakunin" method="post">
<input type="hidden" name="rep_syubetsu" value="proprep">
<p>このレポートに対する評価・アドバイスなど(全角500文字以内。なおフォームの横幅は全角50文字分です。<br>
<textarea rows="10" cols="100"><%=HttpUtility.escapeHTML(newgamerep.getComment()) %></textarea></p>
<p><b><img src="/G-pro_Service/passed/NewGames/WordRep_Images/Your_Data.gif" width="300" height="60" border="0"><font size="+2">（必ず確認してください）</font></b></p>
<p><b>G-PRO　ID:　<%=seiseki.getk_Id() %></b></p>
<p><b>プレイヤーネーム：<%=seiseki.getlogin_name() %></b></p>
<p><font size= +1 color="red">※このレポートはレポートスコアおよびG-PROマイレージの対象にはなりません。</font></p>
<!-- <p><input type="image" src="/G-pro_Service/passed/NewGames/WordRep_Images/Kakutei_Button.gif"  alt="確定" name="submit" width="61" height="48" border="0"></p>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
</form>
</body>
</html>