<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="g_jyouhou.G_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_jyouhou_DAO" %>
    <%@ page import="rep_upload.Rep_List_TO" %>
    <%@ page import="rep_upload.Rep_List_DAO" %>
    <%@ page import="g_jyouhou.NewGame_Serch" %>
    <jsp:useBean id="newgames" scope="session" type="java.util.ArrayList<g_jyouhou.G_jyouhou_TO>"/>
    <jsp:useBean id="proprepo" scope="session" type="java.util.ArrayList<rep_upload.Rep_List_TO>"/>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/NewGames/NewGame_Ichiran.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/NewGames.css"/>
<title>発売前のゲーム・投稿されたゲーム企画一覧</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/NewGame_Back.gif" style="font-weight : bold;">
<p><img src="./NewGame_Images/GPRO_Logo.gif" width="628" height="90" border="0"></p>
<p><br>
<font size="+2"><b>発売前のゲームおよび投稿されたゲームの企画一覧<br>
</b></font><b>発売前のゲーム、およびProposal Report（企画提案レポート）に投稿されたゲーム企画の一覧です。<font size="+2"><br>
</font></b></p>
<p><b><br>
発売前のゲーム（発売日が近い順）</b></p>
<table border="1">
  <tbody>
    <tr>
      <td><b>&nbsp;ゲームコード</b></td>
      <td><b>&nbsp;ゲームタイトル</b></td>
      <td><b>プラットフォーム&nbsp;</b></td>
      <td><b>発売元会社名&nbsp;</b></td>
      <td><b>メインジャンル&nbsp;</b></td>
      <td><b>&nbsp;発売年月日（予定）</b></td>
      <td><b>開発進捗度&nbsp;</b></td>
      <td><b>&nbsp;詳細閲覧</b></td>
    </tr>
    <%for (G_jyouhou_TO Glist : newgames){ %>
    <tr>
      <td><b><%=HttpUtility.escapeHTML(Glist.getGameCode()) %>&nbsp;</b></td>
      <td><b><%=HttpUtility.escapeHTML(Glist.getGametitle()) %>&nbsp;</b></td>
      <td><b><%=HttpUtility.escapeHTML(Glist.getPlatform()) %>&nbsp;</b></td>
      <td><b><%=HttpUtility.escapeHTML(Glist.getMakerName()) %>&nbsp;</b></td>
      <td><b><%=HttpUtility.escapeHTML(Glist.getMain_Genre()) %>&nbsp;</b></td>
      <td><b><%=HttpUtility.escapeHTML(Glist.getHatsubainengappi()) %>&nbsp;</b></td>
      <td><b><%=HttpUtility.escapeHTML(Glist.getShinchoku()) %>&nbsp;</b></td>
      <td>
      <form action="/G-pro_Service/NewGame_SyousaiMaker" method="post">
      <input type="hidden" name="GameCode" value="<%=Glist.getGameCode() %>">
      <input type="hidden" name="Data_Syubetsu" Value="newgames">"
      <!-- <input type="submit" value="紹介ページ">-->
      <input class="tourokubutton" type="submit" name="submit" value="紹介ページ">
      </form>
      </td>
    </tr>
    <% } %>
  </tbody>
</table>
<p><b><br>
Proposal Report（企画提案レポート）に投稿されたゲーム企画（アップロード日時が遅い順）<br>
</b></p>
<table border="1">
  <tbody>
    <tr>
      <td><b>&nbsp;ゲームコード</b></td>
      <td><b>&nbsp;ゲームタイトル</b></td>
      <td><b>制作者&nbsp;</b></td>
      <td><b>メインジャンル&nbsp;</b></td>
      <td><b>キャッチコピー&nbsp;</b></td>
      <td><b>&nbsp;アップロード日時</b></td>
      <td><b>&nbsp;詳細閲覧</b></td>
    </tr>
    <%for(Rep_List_TO Rlist : proprepo){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(Rlist.getgamecode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(Rlist.getgametitle()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(Rlist.getKikakusya()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(Rlist.getMainGenre()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(Rlist.getCatchcopy()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(Rlist.getupload_date()) %>&nbsp;</td>
      <td>
      <form action="/G-pro_Service/NewGame_SyousaiMaker" method="post">
      <input type="hidden" name="rep_code" value="<%=Rlist.getreport_code() %>">
      <input type="hidden" name="Data_Syubetsu" value="proprep">
      <!-- <input type="submit" value="紹介ページ">-->
      <input class="tourokubutton" type="submit" name="submit" value="紹介ページ">
      </form>
      </td>
    </tr>
    <% } %>
  </tbody>
</table>
<p align="center"><br>
<!-- <a href="#" onClick="history.back(); return false;"><img src="./NewGame_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a><br>
会員メニューに戻る</p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>