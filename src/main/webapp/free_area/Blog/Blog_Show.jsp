<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="blog.Blog_TO" %>
    <%@page import="blog.Blog_DAO" %>
    <%@page import="blog.Blog_TopMaker" %>
    <jsp:useBean id="blogdata" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<blog.Blog_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/G-pro_Service/free_area/Blog/Blog_Show.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description" content="Twitterには書ききれないことをつぶやきまくるG-PROject管理人のブログです。"/>
<meta name="keywords" content="G-PROject,ゲーム,ブログ"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Blog_Prop.css"/>
<title>G-PRO_Re:論。特別編・管理人Teaのつぶやききれないこと</title>
</head>
<body background="./Blog_Back.gif">
<p><img src="./Blog_Logo.gif" width="615" height="146" border="0"></p>
<p id="goaisatsu">G-PRO管理人のTeaです。これまでもTwitterで近況報告からどーでもいいことまで、様々なことをツイートしてきましたが、<br>
ここにはTwitterには字数制限で書ききれないことを自由に書いていきたいと思います。</p>
<% for(int i=0; i < blogdata.size(); i++){ %>
<table border="0">
  <tbody>
    <tr class="data_back">
      <td><%=blogdata.get(i).getUploadDate() %></td>
      <td>記事コード：<%=blogdata.get(i).getKijiCode() %></td>
      <td>作成者：<%=blogdata.get(i).getSakuseisya_Name() %>&nbsp;</td>
    </tr>
    <tr class="title_back">
      <td colspan="3"><%=blogdata.get(i).getTitle() %></td>
    </tr>
    <tr class="honbun_back">
      <td colspan="3"><%=blogdata.get(i).getHonbun() %></td>
    </tr>
  </tbody>
</table>
<% } %>
<div id="footer">
<a href="/G-pro_Service/AuthenticationController" class="tourokubutton">G-PROjectトップへ戻る</a>
</div>
</body>
</html>