<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="k_jyouhou.K_Ranking_TO" %>
    <%@ page import="k_jyouhou.K_Ranking_DAO" %>
    <%@ page import="k_jyouhou.K_RankingMaker" %>
<jsp:useBean id="ranklist" scope="session" type="java.util.ArrayList<k_jyouhou.K_Ranking_TO>"/>
<jsp:useBean id="pages" scope="session" type="k_jyouhou.K_Ranking_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Actsc_Ranking_Ruikei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="description" content="ゲームについて考えるサイト「G-PROject」の累計のアクションスコアのランキングです。">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Rankings.css"/>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title>累計レポートスコアランキング</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/P_Rank_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<br>
<br>
<img src="/G-pro_Service/free_area/Ver2_Images/Act_Ruikei.gif" width="630" height="100" border="0"><br>
<br>
<br>
<b><font size="+1">会員登録直後から今までのアクションスコアの累計を競います。</font></b><br>
<br>
<font size="+2"><%=pages.getPageSt() + 1 %>から20件単位で表示中/総ヒット件数：<% if(ranklist.isEmpty() == false){ %><%=ranklist.get(0).getHitCount() %><% }else{ %>0<% } %>件</font>
<br>
<% if(ranklist.isEmpty() == false && (pages.getPageSt()) < (ranklist.get(0).getHitCount()) && pages.getPageSt() > 0){ %>
<form action="/G-pro_Service/G_DataMaker" method = "post">
<input type="hidden" name="moveflg" value="back">
<input type="hidden" name="hani" value="act_ruikei">
<p align="right"><input type="submit" value="<<前の20件"></p>
</form>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <td><b>&nbsp;順位</b></td>
      <td align="center"><b>プレイヤー<br>
      LV.&nbsp;</b></td>
      <td><b>プレイヤーネーム&nbsp;</b></td>
      <td><b>&nbsp;.累計アクションスコア</b></td>
    </tr>
    <%for (K_Ranking_TO rankList : ranklist){ %>
      <tr> 
      <td><%=rankList.getRank()%>&nbsp;</td>
      <td><%=rankList.getplayer_Level()%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(rankList.getlogin_Name())%>&nbsp;</td>
      <td><%=rankList.getreportScore_Kongetsu()%>&nbsp;</td>
      </tr>
      <% } %>
  </tbody>
</table><br>
<% if(ranklist.isEmpty() == false && (pages.getPageFin() + 1) < (ranklist.get(0).getHitCount()) && pages.getPageSt() < ranklist.get(0).getHitCount() - 20){ %>
<form action="/G-pro_Service/G_DataMaker" method = "post">
<input type="hidden" name="moveflg" value="forward">
<input type="hidden" name="hani" value="act_ruikei">
<p align="right"><input type="submit" value=">>次の20件"></p>
</form>
<% } %>
<!-- <p align="center"><a href="/G-pro_Service/free_area/Ranking_menu.html"><img src="/G-pro_Service/image/BacktoRanking.gif" width="188" height="43" border="0"></a>　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="153" height="42" border="0"></a></p>-->
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/free_area/Ranking_menu.html">ランキングメニューへ戻る</a></dd>
    </dl>
      <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
</body>
</html>
