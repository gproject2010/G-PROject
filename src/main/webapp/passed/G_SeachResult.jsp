<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="g_jyouhou.G_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_jyouhou_DAO" %>
    <%@ page import="g_jyouhou.G_DataMaker" %>
    <jsp:useBean id="hitresult" scope="session" type="java.util.ArrayList<g_jyouhou.G_jyouhou_TO>" />
    <jsp:useBean id="jyouken" scope="session" type="g_jyouhou.G_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/G_SeachResult.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>ゲーム検索結果</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GameData_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/passed/GData_Images/GData_Logo.gif" width="232" height="67" border="0"><br>
<br>
<font size="+3">検索結果一覧</font><br>
<br>
<font size="+2"><%=jyouken.getPageSt() + 1 %>件目から20件単位で表示中/総ヒット件数：<% if(hitresult.isEmpty() == false){ %><%=hitresult.get(0).getHitCount() %><% }else{ %>0<% } %>件</font>
<br>
</p>
<% if(hitresult.isEmpty() == false &&(jyouken.getPageFin() + 1) < (hitresult.get(0).getHitCount()) && jyouken.getPageSt() < hitresult.get(0).getHitCount() - 20){ %>
<form action="/G-pro_Service/G_DataMaker" method ="post">
<input type="hidden" name="moveflg" value="forward">
<p align="right"><input class="tourokubutton" type="submit" name="submit" value="次の20件"></p>
</form>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <th>ゲームコード&nbsp;</th>
      <th>&nbsp;プラット<br>
      フォーム</th>
      
      <th>ゲームタイトル&nbsp;</th>
      <th>メインジャンル&nbsp;</th>
      <th>発売年月日&nbsp;</th>
      <th>メーカー名&nbsp;</th>
      <th>著作物の<br>
      転載可否&nbsp;</th>
      <th>詳細&nbsp;</th>
    </tr>
    <%for (G_jyouhou_TO HitList : hitresult){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(HitList.getGameCode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(HitList.getPlatform())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(HitList.getGametitle())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(HitList.getMain_Genre())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(HitList.getHatsubainengappi())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(HitList.getMakerName())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(HitList.getLiSence())%>&nbsp;</td>
      <td>
      <form action="/G-pro_Service/G_SyousaiMaker" method="post">
      <input type="hidden" name="GameCode" value="<%=HitList.getGameCode()%>">
      <input class="tourokubutton" type="submit" name="submit" value="紹介ページ">
      </form>
      </td>
    </tr>
    <% } %>
  </tbody>
</table>
<% if(hitresult.isEmpty() == false && (jyouken.getPageSt()) < (hitresult.get(0).getHitCount()) && jyouken.getPageSt() > 0){ %>
<form action="/G-pro_Service/G_DataMaker" method = "post">
<input type="hidden" name="moveflg" value="back">
<p align="right"><input class="tourokubutton" type="submit" name="submit" value="前の20件"></p>
</form>
<% } %>
<p><font color="red" size="+2"><b>※掲載内容の盗用、無断転載、無断複製を禁止します。</b></font></p>
<!-- <p align="center"><a href="#" onClick="history.back(); return false;"><img src="/G-pro_Service/image/BacktoSerch.gif" width="125" height="42" border="0"></a>　　　　　　　　　　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="149" height="43" border="0"><br></a>
　　<b>検索画面に戻る　　　　　　会員メニューに戻る</b></p>-->
<dl>
      <dd class="tourokubutton"><a href="#" onClick="history.back(); return false;">検索画面へ戻る</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>