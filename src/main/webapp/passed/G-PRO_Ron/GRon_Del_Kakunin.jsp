<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="inputUtility.HttpUtility" %>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="gpro_ron.GRon_SyousaiMaker" %>
<jsp:useBean id="keijidata" scope="session" type="gpro_ron.GRon_Data_TO"/>
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/G-PRO_Ron/GRon_Del_Kakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRon.css"/>
<title>掲示板の削除確認</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/GRon_Logo.gif" width="282" height="102" border="0"></p>
<p><font size="+3"><b>掲示板の削除</b></font></p>
<p><font color="#ff0000" size="+1"><b>現在選択されている以下の掲示板を削除します。本当によろしいですか?</b></font></p>
<p>掲示板コード：<%= HttpUtility.escapeHTML(keijidata.getKeijiban_Code()) %></p>
<p>議題:<%= HttpUtility.escapeHTML(keijidata.getGidai()) %></p>
<p>書き込み締切日時：<%= keijidata.getShimekiriNichiji() %></p>
<p><b><font color="#ff0000" size="+1">注意:一度削除すると元に戻せません!</font></b></p>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/GRon_Del_Update?keijicode=<%=keijidata.getKeijiban_Code() %>">削除する</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/passed/G-PRO_Ron/Touron_Page.jsp">削除せずに戻る</a></dd>
</dl>
</body>
</html>