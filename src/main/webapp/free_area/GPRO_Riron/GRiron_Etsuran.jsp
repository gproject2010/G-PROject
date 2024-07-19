<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="gpro_riron.GPRiron_TO" %>
    <%@ page import="gpro_riron.GPRiron_DAO" %>
    <%@ page import="gpro_riron.Riron_EtsuranLoad" %>
    <jsp:useBean id="ronbundata" scope="session" type="gpro_riron.GPRiron_TO"/>
    <jsp:useBean id="comment" scope="session" type="java.util.ArrayList<gpro_riron.GPRiron_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/GPRO_Riron/GRiron_Etsuran.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title>G-PRO_Re:論。論文閲覧</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/GRiron_Logo.gif" width="371" height="122" border="0"></p>
<p><b><font size="+3">論文閲覧</font></b></p>
<p><b>（このページにはインラインフレームが使用されています）</b></p>
<p><b>論文コード:<%=HttpUtility.escapeHTML(ronbundata.getRonbunCode()) %></b></p>
<p><b><font size="+2">論文タイトル：<%=ronbundata.getRonbunTitle() %></font></b></p>
<p><b>アップロード者プレイヤーネーム:<%=HttpUtility.escapeHTML(ronbundata.getPlayerName()) %></b></p>
<p><b>アップロード:<%=HttpUtility.escapeHTML(ronbundata.getUploadDate()) %></b>　　　　　<b>最終更新：<% if(HttpUtility.escapeHTML(ronbundata.getKoushinDate()) == null){ %>----------<% }else{ %><%=HttpUtility.escapeHTML(ronbundata.getKoushinDate()) %><% } %></b></p>
<p><iframe src="/G-pro_Service/Ronbun_BodyLoad?time=hensyumae" width="640" height="1280">
<font color="red" size="+1">ブラウザがインラインフレームに対応していないため表示できません。<br>
対応しているブラウザでご覧ください。</font></iframe></p>
<p><b>支持・不支持状況</b><br>
<img src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/Good_Icon.gif" width="64" height="64" border="0"><b>×<%if(ronbundata.getShijisyaList()[0].equals("empty")){ %>0<% }else{ %><%=ronbundata.getShijisyaList().length %><% } %></b>　　　　　<img src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/Bad_Icon.gif" width="64" height="64" border="0"><b>×<%if(ronbundata.getFushijisyalist()[0].equals("empty")){ %>0<% }else{ %><%=ronbundata.getFushijisyalist().length %><% } %></b></p>
<p><img src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/Response_Icon.gif" width="60" height="64" border="0"><b>この論文に寄せられたコメント:</b></p>
<% if(comment.size() != 0){ %>
<% for(int i=0; i < comment.size(); i++){ %>
<pre><b><%=comment.get(i).getComment() %></b></pre><br>
<font size="+1">by:<%=comment.get(i).getPlayerName() %></font>
<% } %>
<% }else{ %>
<b>コメントはまだ書き込まれていません。</b>
<% } %>
<p><img src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/Login_Logo.gif" width="131" height="59" border="0"><br>
<br>
<b>ログインすると、論文に対してコメントを書き込んだり、支持・不支持の投票を行うことができます。<br>
</b><br>
<br>
<form action="j_security_check" method="post">
<b>G-PRO ID:</b><input size="30" type="text" name="j_username"><b><br>
<br>
パスワード:</b><input size="30" type="password" name="j_password">
<p><!-- <input type="image" name="submit" src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/Login_Button.gif" width="66" height="42" border="0">--><input id="tourokubutton" type="submit" name="submit" value="ログイン">　　※会員メニューに移動します　　　</p>
</form>
<p><b>↓まだサイトに登録していないならぜひ利用登録を!</b><br>
<dl>
<dd id="tourokubutton"><a href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p0.html">利用登録する<!-- <img src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/RiyouTouroku_Button.gif" width="193" height="34" border="0">--></a></dd>
</dl>
<dl>
<!-- <p align="center">-->　　　　　<dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/free_area/GPRO_Riron/Riron_Image/BacktoSiteTop.gif" width="188" height="43" border="0"></a></dd>
</dl>
</body>
</html>