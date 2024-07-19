<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="rep_upload.Rep_List_DAO" %>
    <%@ page import="rep_upload.NewGame_Rep_Kakunin" %>
    <%@ page import="g_jyouhou.NewGame_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO" />
    <jsp:useBean id="newgamerep" scope="session" type="rep_upload.Rep_Koumoku" />
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/NewGames/NewGame_Rep_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>ひと言レポート(修正)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="./WordRep_Images/WordRep_Logo.gif" width="365" height="55" border="0" alt="-Word Report-"></p>
<p><b>レポート種別：一言レポート(新作ゲーム)</b></p>
<p><b>ゲームコード：<%=HttpUtility.escapeHTML(syousai.getGamecode()) %></b></p>
<p><b>ゲームタイトル：<%=HttpUtility.escapeHTML(syousai.getGametitle()) %></b></p>
<p><b>メインジャンル:<%=HttpUtility.escapeHTML(syousai.getMaingenre()) %></b></p>
<p><b>サブジャンル1：<%=HttpUtility.escapeHTML(syousai.getSubgenre1()) %>　　　　　サブジャンル2:<%=HttpUtility.escapeHTML(syousai.getSubgenre2()) %></b></p>
<p><b>パブリッシャー：<%=HttpUtility.escapeHTML(syousai.getMakername()) %></b></p>
<p><b>ディベロッパー：<%=HttpUtility.escapeHTML(syousai.getDeveloper_names()) %></b></p>
<p><b>ゲーム概要：<%=HttpUtility.escapeHTML(syousai.getGaiyou()) %></b></p>
<p><b>コメント入力：このゲームについて現在あなたが思っていることを一言で記述してください。</b></p>
<%if(newgamerep.isNoComment()){ %>
<p><b><font size="+2" color="yellow">コメントが入力されていません!</font></b></p>
<% }else if(newgamerep.isnghit() == true){ %>
<p><b><font size="+2" color="red">ネット上に公開できない単語が含まれています!
該当する箇所を削除・訂正して再試行してください。</font></b></p>
<% } %>
<form action="/G-pro_Service/NewGameRep_Kakunin?rep_syubetsu=newgame" method="post">
<b><textarea rows="8" cols="50" name="comment"><%=HttpUtility.escapeHTML(newgamerep.getComment()) %></textarea></b>
<p><b>(最大全角400文字以内）</b></p>
<p><b><img src="./WordRep_Images/Your_Data.gif" width="300" height="60" border="0"><font size="+2">（必ず確認してください）</font></b></p>
<p><b>G-PRO　ID:　${sessionScope.seiseki.k_Id}</b></p>
<p><b>プレイヤーネーム：${sessionScope.seiseki.login_name}</b></p>
<p><b>プレイヤーレベル:${sessionScope.seiseki.player_Level}</b></p>
<!-- <p><input type="image" src="./WordRep_Images/Kakutei_Button.gif"  alt="確定" name="submit" width="65" height="51" border="0"></p>-->
<input class="tourokubutton" type="submit" name="submit" value="紹介ページ">
</form>
</body>
</html>