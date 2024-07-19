<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.lang.Integer" %>
    <%@ page import="ninsyou.Cookie_Hakkou" %>
    <%@ page import="ninsyou.Cookie_UwagakiTouroku" %>
    <jsp:useBean id="errorcount" scope="session" type="java.lang.Integer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Top_Program.css"/>
<title>Cookie登録結果</title>
</head>
<body>
<div id="title">
<p><img src="image9.gif" width="390" height="150" border="0"></p>
</div>
<p>PRO×PRO用Cookie発行</p>
<% if(errorcount == 0){ %>
<p>PRO×PROのログイン用Cookieを書き込みました。<br>
このブラウザでPRO×PROのサービスが利用できます。</p>
<% }else{ %>
<p>ブラウザの情報の登録に失敗しました。<br>
会員メニューからもう一度Cookieを発行しなおしてください。</p>
<% } %>
<dl>
<% if(errorcount == 0){ %>
<dd id="tourokubutton"><a href="#">さっそくPRO×PROを利用する</a><br>
  </dd>
  <% } %>
  <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>

</body>
</html>