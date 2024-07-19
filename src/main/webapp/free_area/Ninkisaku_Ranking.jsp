<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="g_jyouhou.GR_jyouhou_TO" %>
    <%@ page import="g_jyouhou.GR_jyouhou_DAO" %>
    <%@ page import="g_jyouhou.G_RankingMaker" %>
<jsp:useBean id="ranklist" scope="session" type="java.util.ArrayList<g_jyouhou.GR_jyouhou_TO>"/>
<jsp:useBean id="pages" scope="session" type="g_jyouhou.G_jyouhou_TO"/>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Ninkisaku_Ranking.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="description" content="ゲームについて考えるサイト「G-PROject」で算出されたゲームの発売から1ヶ月間の人気度ランキングです。">
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Rankings.css"/>
<title>人気作ランキング</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<br>
<br>
<img src="/G-pro_Service/free_area/Ver2_Images/Ninkisaku_Logo.gif" width="670" height="130" border="0"><br>
<br>
<br>
<p><b><font size="+1">ゲームの発売から１か月間に獲得したレポートの受付数のランキングです。</font></b></p><br>
<br>
<font size="+2"><%=pages.getPageSt() + 1 %>件目から20件単位で表示中/総ヒット件数：<% if(ranklist.isEmpty() == false){ %><%=ranklist.get(0).getHitCount() %><% }else{ %>0<% } %>件</font>
<% if(ranklist.isEmpty() == false && (pages.getPageSt()) < (ranklist.get(0).getHitCount()) && pages.getPageSt() > 0){ %>
<p><form action='/G-pro_Service/G_RankingMaker?moveflg=back'>
<input type="hidden" name="moveflg" value="back">
<input type="hidden" name="hani" value="ninkisaku">
<p align="right"><input type="submit" value="<<前の20件"></p>
</form>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <td><b>&nbsp;順位</b></td>
      <td align="center"><b>プラット<br>
      フォーム</b></td>
      <td><b>メインジャンル</b></td>
      <td><b>メーカー名&nbsp;</b></td>
      <td><b>&nbsp;ゲーム名称</b></td>
      <td><b><font size="+1">レポート提出数</font></b></td>
      <td><b><font size="+1">ゲームコード</font></b></td>
    </tr>
    <% for (GR_jyouhou_TO rankList : ranklist){ %>
      <tr> 
      <td><%=rankList.getRank()%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(rankList.getPlatForm())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(rankList.getMain_Genre())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(rankList.getMakerName())%></td>
      <td><%=HttpUtility.escapeHTML(rankList.getGameName())%>&nbsp;</td>
      <td><%=rankList.getReport_Count()%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(rankList.getGameCode())%>&nbsp;</td>
      </tr>
      <% } %>
  </tbody>
</table><br>
<% if(ranklist.isEmpty() == false && (pages.getPageFin() + 1) < (ranklist.get(0).getHitCount()) && pages.getPageSt() < ranklist.get(0).getHitCount() - 20){ %>
<p align="right"><form action="/G-pro_Service/G_RankingMaker" method="post">
<input type="hidden" name="moveflg" value="forward">
<input type="hidden" name="hani" value="ninkisaku">
<p align="right"><input type="submit" value=">>次の20件"></p>
</form>
<% } %>
<!-- <p align="center"><a href="/G-pro_Service/free_area/Ranking_menu.html"><img src="/G-pro_Service/image/BacktoRanking.gif" width="153" height="42" border="0"></a>　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="188" height="43" border="0"></a></p>-->
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/free_area/Ranking_menu.html">ランキングメニューへ戻る</a></dd>
    </dl>
      <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
</body>
</html>