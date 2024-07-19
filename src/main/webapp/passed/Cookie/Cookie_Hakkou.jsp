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
<html>
<head>
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Top_Program.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Top_Program.css"/>
<title>PRO×PRO用Cookie発行(新規発行)</title>
</head>
<body>
<div id="title"><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></div>
<p>PRO×PRO用Cookie発行</p>
<p>PRO×PROで使用するオートログイン用Cookieを<br>
ブラウザに書き込みます。下記の注意をよく読み、<br>
承諾する場合は下部のボタンをクリックしてください。</p>
<p>※Cookieは端末5台分まで発行できます。６台目以降を登録するには<br>
「登録済みのブラウザ情報に上書き登録し、Cookieをブラウザに書き込む」をクリック後、
上書きする端末情報を選択してください。</p>
<p class="danger">注意：Cookieの内容が盗まれると第三者があなたの情報を盗み見たり、<br>
犯罪行為に利用されたりする可能性があります。<br>
Cookieを書き込んだ端末は管理に十分注意し、端末やCookieの<br>
盗難が判明した場合はすぐにG-PROまでお知らせください！</p>
<p>書き込み対象のG-PRO ID:<%=HttpUtility.escapeHTML(seiseki.getk_Id()) %></p>
<%if(cookies.size() > 0){ %>
登録済みの端末情報(一部)
<table border="1">
  <tbody>
    <tr>
      <td>PCの名前</td>
      <td>発行日時</td>
    </tr>
    <% for(int i=0; i < cookies.size(); i++){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(cookies.get(i).getHostName()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(cookies.get(i).getHakkounichiji()) %>&nbsp;</td>
    </tr>
    <% } %>
  </tbody>
</table>
<% } %>
<dl>
<% if(cookies.size() <= 5){ %>
      <dd id="tourokubutton"><a href="/G-pro_Service/Cookie_Hakkou">このブラウザを新規登録し、Cookieをブラウザに書き込む</a><br>
  </dd>
  <% } %>
  <%if(cookies.size() > 0){ %>
  <dd id="tourokubutton"><a href="/G-pro_Service/passed/Cookie/Cookie_Uwagaki.jsp">登録済みのブラウザ情報に上書き登録し、Cookieをブラウザに書き込む</a><br>
  </dd>
  <% } %>
  <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a>
  </dd>
    </dl>
</body>
</html>