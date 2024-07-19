<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@page import="k_jyouhou.R_jyouhou_TO" %>
    <%@page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="ninsyou.Cookie_TO" %>
    <%@ page import="ninsyou.Cookie_DAO" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
    <jsp:useBean id="cookies" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<ninsyou.Cookie_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Top_Program.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<title>PRO×PRO用Cookie発行(上書き登録)</title>
</head>
<body>
<div id="title">
<p><img src="image9.gif" width="390" height="150" border="0"></p>
</div>
<p>PRO×PRO用Cookie発行</p>
<% if(cookies.size() >= 5){ %><p>すでにCookieが５台分以上発行されています。<br><% } %>
上書きする端末情報の「上書きする」をクリックしてください。</p>
<p>書き込み対象のG-PRO　ID:<%=seiseki.getk_Id() %></p>
<table border="1">
  <tbody>
    <tr>
      <td>PCの名前</td>
      <td>発行日時</td>
      <td>上書き登録</td>
    </tr>
    <% for(int i=0; i < cookies.size(); i++){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(cookies.get(i).getHostName()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(cookies.get(i).getHakkounichiji()) %>&nbsp;</td>
      <td><form action="/G-pro_Service/Cookie_Uwagakitouroku">
      <input type="hidden" name="hostname" value="<%=cookies.get(i).getHostName() %>">
      <input type="hidden" name="nichiji" value="<%=cookies.get(i).getHakkounichiji() %>">
      <input type="submit" name="submit" value="上書きする"></form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<dl>
  <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</body>
</html>
