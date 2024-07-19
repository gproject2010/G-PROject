<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="ninsyou.Infomation_TO" %>
    <%@page import="ninsyou.Infomation_DAO" %>
    <%@page import="ninsyou.Infomation_SyousaiMaker" %>
    <jsp:useBean id="infodata" scope="application" type="ninsyou.Infomation_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>G-PROからのお知らせ</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<p><img src="/G-pro_Service/image/Infomation_Logo.gif" width="227" height="50" border="0" alt="お知らせ詳細"></p>
<table border="1">
  <tbody>
    <tr>
      <td><img src="/G-pro_Service/image/InfoCode_Logo.gif" width="168" height="30" border="0" alt="インフォメーションコード"><br>
      <%=infodata.getInfoCode() %>&nbsp;</td>
      <td><img src="/G-pro_Service/image/KeisaiDate.gif" width="116" height="32" border="0" alt="掲載・訂正日"><br>
<%=infodata.getKeisaiDate() %>　掲載<br>
     <%if(!(infodata.getTeiseiDate().equals("empty"))){ %><%=infodata.getTeiseiDate() %>　訂正<% } %>&nbsp;</td>
      <td>&nbsp;<img src="/G-pro_Service/image/Hasshinsya.gif" width="89" height="40" border="0" alt="発信者"><br>
<%=infodata.getHassinmoto() %></td>
      <td>&nbsp;<img src="/G-pro_Service/image/Subject_Logo.gif" width="64" height="41" border="0" alt="件名"><br>
【<%=infodata.getInfo_Syubetsu()%>】 <%=infodata.getKenmei() %></td>
    </tr>
  </tbody>
</table>
<pre><font size="+3"><%=infodata.getHonbun_Address() %></font></pre>
<!-- <p align="center"><a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="149" height="43" border="0" alt="会員メニューに戻る"></a></p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>