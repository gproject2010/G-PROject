<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="inputUtility.HttpUtility" %>
<%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="k_jyouhou.StatusMaker" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/RepFile_Upload.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>レポートデータアップロード</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"></p>
<p><b><font size="+2">レポートファイルのアップロード</font></b></p>
<form action="/G-pro_Service/Shinki_Report_jyushin" enctype="multipart/form-data" method="post">
<p>ログイン情報を確認し、間違いがなければファイル名を指定して「送信」をクリックしてください。<br>
<br>
<img src="/G-pro_Service/image/Your_Data.gif" width="300" height="60" border="0"><br>
<br>
<b><font size="+1">ID:</font><%=HttpUtility.escapeHTML(seiseki.getk_Id())%><br>
<br>
ログインネーム：<%=HttpUtility.escapeHTML(seiseki.getlogin_name())%><br>
<br>
プレイヤーレベル:<%=seiseki.getplayer_Level()%><br>
<br>
<br>
送信するファイル：<input type="file" name="filename"></input></b><br>
<br>
<br>
<br>
<!-- <input type="image" src="/G-pro_Service/image/Soushin_Button.gif" width="58" height="45" border="0" alt="送信" name="submit"/>-->
<input class="tourokubutton" type="submit" name="submit" value="送信">
</form>
<p align="center"><br>
<!-- <a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="149" height="43" border="0"/></a><br>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>