<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.lang.Boolean" %>
    <%@ page import="java.lang.String" %>
    <%@ page import="gpro_riron.GPRiron_TO" %>
    <%@ page import="gpro_riron.GPRiron_DAO" %>
    <%@ page import="gpro_riron.Ronbun_Shinki_Kakunin" %>
    <%@ page import="gpro_riron.Ronbun_Update_Kakunin" %>
    <jsp:useBean id="errorlist" scope="session" type="gpro_riron.GPRiron_TO"/>
    <jsp:useBean id="syorisyubetsu" scope="session" type="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/GPRO_Riron/Ronbun_Touroku_Result.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRiron.css"/>
<title>論文登録の処理結果</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="G-PRO_Reron_Logo.gif" width="371" height="122" border="0"></p>
<% if (syorisyubetsu.equals("koushin")){ %>
<p><font size="+2">エラー:論文の更新に失敗しました</font></p>
<% if(!(errorlist.getImgFileUploadError1().equals(""))){ %>
<p><b><font color="#ff0000">&lt;image1&gt;タグに対応している画像データの更新に失敗しました。(登録に失敗したファイル:<%=errorlist.getImgFileUploadError1() %>)<br>
お手数ですが会員メニューからもう一度変更をお願いいたします。</font></b></p>
<% }if(!(errorlist.getImgFileUploadError2().equals(""))){ %>
<p><b><font color="#ff0000">&lt;image2&gt;タグに対応している画像データの更新に失敗しました。(登録に失敗したファイル:<%=errorlist.getImgFileUploadError2() %>)<br>
お手数ですが会員メニューからもう一度変更をお願いいたします。</font></b></p>
<% }if(!(errorlist.getImgFileUploadError3().equals(""))){ %>
<p><b><font color="#ff0000">&lt;image3&gt;タグに対応している画像データの更新に失敗しました。(登録に失敗したファイル:<%=errorlist.getImgFileUploadError3() %>)<br>
お手数ですが会員メニューからもう一度変更をお願いいたします。</font></b></p>
<% }if(!(errorlist.getHTMLFileUploadError().equals(""))){ %>
<p><b><font color="#ff0000">ソースコードの更新に失敗しました。お手数ですが会員メニューからもう一度変更をお願いいたします。</font></b></p>
<% } %>
<% }else if(syorisyubetsu.equals("shinki")){ %>
<p><font size="+2">エラー:論文の登録に失敗しました</font></p>
<% if(!(errorlist.getImgFileUploadError1().equals(""))){ %>
<p><b><font color="#ff0000">&lt;image1&gt;タグに対応している画像データの登録に失敗しました。(登録に失敗したファイル:<%=errorlist.getImgFileUploadError1() %>)<br>
お手数ですが会員メニューからもう一度登録をお願いいたします。</font></b></p>
<% }if(!(errorlist.getImgFileUploadError2().equals(""))){ %>
<p><b><font color="#ff0000">&lt;image2&gt;タグに対応している画像データの登録に失敗しました。(登録に失敗したファイル:<%=errorlist.getImgFileUploadError2() %>)<br>
お手数ですが会員メニューからもう一度登録をお願いいたします。</font></b></p>
<% }if(!(errorlist.getImgFileUploadError3().equals(""))){ %>
<p><b><font color="#ff0000">&lt;image3&gt;タグに対応している画像データの登録に失敗しました。(登録に失敗したファイル:<%=errorlist.getImgFileUploadError3() %>)<br>
お手数ですが会員メニューからもう一度登録をお願いいたします。</font></b></p>
<% }if(!(errorlist.getHTMLFileUploadError().equals(""))){ %>
<p><b><font color="#ff0000">ソースコードの登録に失敗しました。お手数ですが会員メニューからもう一度登録をお願いいたします。</font></b></p>
<% } %>
<% } %>
<!-- <p align="center"><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoKaiinTop.gif" width="213" height="53" border="0"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</body>
</html>