<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.lang.String" %>
    <%@ page import="gpro_riron.GPRiron_TO" %>
    <%@ page import="gpro_riron.GPRiron_DAO" %>
    <%@ page import="gpro_riron.Ronbun_Koushin" %>
    <%@ page import="gpro_riron.Ronbun_Touroku" %>
    <jsp:useBean id="syorisyubetsu" scope="session" type="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/GPRO_Riron/Ronbun_Touroku_Result.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRiron.css"/>
<title>論文の処理結果</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/GRiron_Logo.gif" width="371" height="122" border="0"></p>
<% if(syorisyubetsu.equals("koushin")){ %>
<p><b><font size="+2">論文の更新完了</font></b></p>
<p><b>論文を上書き更新しました。審査結果をお楽しみに!</b></p>
<% }else if(syorisyubetsu.equals("shinki")){ %>
<p><b><font size="+2">論文の更新完了</font></b></p>
<p><b>論文を新規登録しました。審査結果をお楽しみに!</b></p>
<% }else if(syorisyubetsu.equals("vote")){ %>
<p><b><font size="+2">投票完了</font></b></p>
<p><b>論文に対して投票を行いました。このタブを閉じて引き続きG-PROjectをお楽しみください!</b>
<% }else if(syorisyubetsu.equals("comment_touroku")){ %>
<p><b><font size="+2">コメント登録完了</font></b></p>
<p><b>論文に対してコメントを行いました。このタブを閉じて引き続きG-PROjectをお楽しみください!</b>
<% }else if(syorisyubetsu.equals("comment_del")){ %>
<p><b><font size="+2">コメント削除完了</font></b></p>
<p><b>論文に対するコメントを削除しました。このタブを閉じて引き続きG-PROjectをお楽しみください!</b>
<% } %>
<!-- <p align="center"><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoKaiinTop.gif" width="213" height="53" border="0"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</body>
</html>