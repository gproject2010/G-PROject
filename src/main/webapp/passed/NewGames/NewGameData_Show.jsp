<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="rep_upload.Rep_List_DAO" %>
    <%@ page import="g_jyouhou.NewGame_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO" />
    <jsp:useBean id="up_flg" scope="session" type="java.lang.Integer" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/NewGames/NewGameData_Show.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/NewGames.css"/>
<title>新作ゲームデータ</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/NewGame_Back.gif" style="font-weight : bold;">
<p><br>
<br>
<img src="./NewGame_Images/NewGamesTitle.gif" width="276" height="47" border="0" alt="発売・配信予定ゲームデータ"></p>
<p><img src="./NewGame_Images/GameTitle.gif" width="182" height="39" border="0" alt="ゲームタイトル">　　　<b><font size="+4"><%=HttpUtility.escapeHTML(syousai.getGametitle()) %></font></b></p>
<% if(!(syousai.getLogoaddress().equals("Empty"))){ %><p><img src="<%=syousai.getLogoaddress() %>"/></p><% } %>
<p><img src="./NewGame_Images/MainGenre.gif" width="130" height="29" border="0" alt="メインジャンル">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getMaingenre()) %></font></b>　　　　　<img src="./NewGame_Images/SubGenre1.gif" width="125" height="29" border="0" alt="サブジャンル1">　　　<font size="+3"><%=HttpUtility.escapeHTML(syousai.getSubgenre1()) %></font>　　　　　<img src="./NewGame_Images/SubGenre2.gif" width="124" height="28" border="0" alt="サブジャンル2">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getSubgenre2()) %></font></b></p>
<p><img src="./NewGame_Images/Platform.gif" width="128" height="26" border="0" alt="プラットフォーム">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getPlatform()) %></font></b>　　　　　　<img src="./NewGame_Images/Rating.gif" width="190" height="31" border="0" alt="CEROレーティング">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getRating()) %></font></b></p>
<p><img src="./NewGame_Images/HatsubaiYoteibi.gif" width="206" height="26" border="0" alt="発売・配信開始予定日">　　　<b><font size="+2"><%=HttpUtility.escapeHTML(syousai.getHatsubainengappi()) %></font></b></p>
<p><img src="./NewGame_Images/Shinchokudo.gif" width="115" height="26" border="0" alt="開発進捗度">　　　<b><font size="+2"><%=HttpUtility.escapeHTML(syousai.getShinchokudo()) %></font></b></p>
<p><img src="./NewGame_Images/Publisher.gif" width="220" height="29" border="0" alt="発売元（パブリッシャー）">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getMakername()) %></font></b></p>
<p><img src="./NewGame_Images/Developper.gif" width="219" height="28" border="0" alt="開発元（ディベロッパー）">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getDeveloper_names()) %></font></b></p>
<p><img src="./NewGame_Images/Gaiyou.gif" width="150" height="39" border="0" alt="ゲーム概要"></p>
<p><b><font size="+1"><%=HttpUtility.escapeHTML(syousai.getGaiyou()) %></font></b></p>
<p><a href="<%=syousai.getMovieaddress() %>"><img src="./NewGame_Images/Movie_DL.gif" width="200" height="57" border="0" alt="紹介映像 ダウンロード"><br></a>
※Windows Media Playerなどの<br>
動画再生ソフトが必要です。</p>
<p>
<% if(up_flg == 9999 || up_flg >= syousai.getSeigen_Kaisu()){ %>
<font size= +1 color="red">レポートの提出回数を使い切っているため、このゲームに対するレポートは作成できません。</font>
<%}else{ %>
<!-- <a href="./NewGame_Rep_Temp.jsp"><img src="./NewGame_Images/HitokotoRep_Sakusei.gif" width="139" height="73" border="0" alt="レスポンス作成"></a>-->
<dl>
      <dd class="tourokubutton"><a href="./NewGame_Rep_Temp.jsp">レスポンス作成</a></dd>
    </dl>
このゲームに対するレポートはあと <%= syousai.getSeigen_Kaisu() - up_flg %> 回作成できます。
<% } %>
<p><img src="./NewGame_Images/Comment.gif" width="424" height="34" border="0" alt="このゲームに対するプレイヤーのコメント"></p>
<% for(String com : syousai.getComments()){ %>
<p><%= HttpUtility.escapeHTML(com) %></p>
<% } %>
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>