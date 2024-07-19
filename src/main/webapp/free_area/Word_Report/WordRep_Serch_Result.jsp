<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.lang.String" %>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="g_jyouhou.Rep_Load_DAO" %>
    <%@ page import="g_jyouhou.WordRep_Kensaku" %>
    <jsp:useBean id="replist" scope="session" type="java.util.ArrayList<rep_upload.Rep_Koumoku>"/>
    <jsp:useBean id="hyoujihani" scope="session" type="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Word_Report/WordRep_Serch_Result"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>一言レポート一覧</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/image/GReport_Logo.gif" width="408" height="87" border="0"><br>
<p><b><font size="+2">過去<% if(hyoujihani.equals("1week")){ %>1週間<% }else if(hyoujihani.equals("1month")){ %>1ヶ月<% }else if(hyoujihani.equals("3months")){ %>3か月<% } %>にアップロードされた一言レポート一覧</font></b></p>
<p><b>閲覧したいレポートの「閲覧」ボタンをクリックしてください。</b></p>
<table border="1">
  <tbody>
    <tr>
      <td>レポートコード</td>
      <td>ゲームタイトル</td>
      <td>アップロード日時</td>
      <td>評価点数</td>
      <td>閲覧</td>
    </tr>
    <% for(Rep_Koumoku list : replist){ %>
    <tr>
      <td><%=list.getRep_Code() %>&nbsp;</td>
      <td><%=list.getGameTitle() %>&nbsp;</td>
      <td><%=list.getUploadTime() %>&nbsp;</td>
      <td><%=list.gettotal() %>点&nbsp;</td>
      <td><form action="/G-pro_Service/WordRep_Load" method="post">
      <input type="hidden" name="rep_code" value="<%=list.getRep_Code() %>">
      <input type="submit" name="submit" value="閲覧"></form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<!-- <p><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="206" height="47" border="0"></a></p>-->
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップに戻る</a></dd>
    </dl>
</body>
</html>