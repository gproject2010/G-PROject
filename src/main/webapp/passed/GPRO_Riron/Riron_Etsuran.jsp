<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="java.lang.Boolean" %>
    <%@ page import="java.lang.String" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="gpro_riron.GPRiron_TO" %>
    <%@ page import="gpro_riron.GPRiron_DAO" %>
    <%@ page import="gpro_riron.Ronbun_SyousaiLoad" %>
    <%@ page import="gpro_riron.Comment_Upload" %>
    <jsp:useBean id="ronbundata" scope="session" type="gpro_riron.GPRiron_TO"/>
    <jsp:useBean id="comment" scope="session" type="java.util.ArrayList<gpro_riron.GPRiron_TO>"/>
    <jsp:useBean id="touhyou" scope="session" type="java.lang.Boolean"/>
    <jsp:useBean id="ngword" scope="session" type="java.lang.String"/>
    <jsp:useBean id="over" scope="session" type="java.lang.Boolean"/>
    <%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="ninsyou.AuthenticationController" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/GPRO_Riron/Riron_Etsuran.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRiron.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/hanyou_files/LengthCount.js" charset="UTF-8"></script>
<title>論文閲覧</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/GRiron_Logo.gif" width="371" height="122" border="0"></p>
<p><b><font size="+3">論文閲覧</font></b></p>
<p><b>（このページにはインラインフレームが使用されています）</b></p>
<p><b>論文コード:<%=HttpUtility.escapeHTML(ronbundata.getRonbunCode()) %></b></p>
<p><b>アップロード者プレイヤーネーム:<%=HttpUtility.escapeHTML(ronbundata.getPlayerName()) %></b></p>
<p><b>アップロード:<%=HttpUtility.escapeHTML(ronbundata.getUploadDate()) %></b>　　　　　<b>更新：<%=HttpUtility.escapeHTML(ronbundata.getKoushinDate()) %></b></p>
<p><iframe src="/G-pro_Service/Ronbun_BodyLoad/<%=ronbundata.getHTMLFileName() %>?time=hensyumae">
<font color="red" size="+1">ブラウザがインラインフレームに対応していないため表示できません。<br>
対応しているブラウザでご覧ください。</font></iframe></p>
<% if(touhyou == false){ %>
<p>支持・不支持投票：投票するにはアイコンをクリックしてください。<br>
<a href="/G-pro_Service/Riron_Vote?vote=shiji" target="_blank"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Good_Icon.gif" width="106" height="52" border="0"><b>×<%=ronbundata.getShijisyaList().length %></b></a>　　　　　<a href="/G-pro_Service/Riron_Vote?vote=fushiji" target="_blank"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Bad_Icon.gif" width="106" height="52" border="0"><b>×<%=ronbundata.getFushijisyalist().length %></b></a></p>
<% }else{ %>
<p><font color="#ff0000">すでに投票を受け付けているため、この論文に対する投票はできません。</font><br>
<img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Good_Icon.gif" width="106" height="52" border="0"><b>×<%if(HttpUtility.escapeHTML(ronbundata.getShijisyaList()[0]).equals("empty")){%>0<%}else{%><%=ronbundata.getShijisyaList().length %><% } %></b>　　　　　<img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Bad_Icon.gif" width="106" height="52" border="0"><b>×<%if(HttpUtility.escapeHTML(ronbundata.getFushijisyalist()[0]).equals("empty")){%>0<%}else{%><%=ronbundata.getFushijisyalist().length %><% } %></b></p>
<% } %>
<p><b>この論文に寄せられたコメント:</b></p>
<% for(int i=0; i < comment.size(); i++){ %>
<pre><b><%=comment.get(i).getComment() %></b></pre><br>
<font size="+1">by:<%=comment.get(i).getPlayerName() %></font>
<% if(comment.get(i).getPlayer_Id().equals(request.getRemoteUser())){ %>
<p><a href="/G-pro_Service/Comment_upload?respcode=<%=comment.get(i).getRespCode()%>" target="_blank">このコメントを取り消す</a></p>
<% } %>
<% } %>
<p><b>下記のフォームでコメントを送信できます。</b></p>
<% if(ngword != null || (!(ngword.equals("")))){ %>コメントから禁止ワード(<%=ngword %>)が検出されたため、登録を行いませんでした。<% } %>
<% if(over == true){ %>コメントの文字数が少なすぎるか、制限をオーバーしていたため、登録を行いませんでした。<% } %>
<form action="/G-pro_Service/Comment_Upload" method="post">
<p><textarea rows="6" cols="50" name="comment" id="count_area1" maxlength="300">入力して「送信」をクリックしてください</textarea><br>
（最大全角3文字以上300文字まで。あと<span id="mojisu1">---</span>文字です。）</p>
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Your_Data.gif" width="189" height="37" border="0"></p>
<p><b>プレイヤーネーム:<%=seiseki.getlogin_name() %></b></p>
<!-- <p align="center"><input type="image" name="submit" src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Soushin_Button.gif" width="53" height="42" border="0">　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoKaiinTop.gif" width="178" height="43" border="0"></a>　　　　　<a href="/G-pro_Service/Riron_TopPageMaker"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoRironTop.gif" width="271" height="42" border="0"></a></p>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/Riron_TopPageMaker">G-PRO_Re:論。トップに戻る</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</form>
</body>
</html>