<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="g_jyouhou.Rep_Load_DAO" %>
    <%@ page import="g_jyouhou.WordRep_Load" %>
    <jsp:useBean id="repdata" scope="session" type="rep_upload.Rep_Koumoku"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Word_Report/WordRep_Show.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/LoginForm.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/hanyou_files/LoginForm.js" charset="UTF-8"></script>
<title>レポート詳細(評価点数)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<div id="loginform">
<form action="j_security_check" name="login" method="post">
<img src="/G-pro_Service/image/Login_Logo.gif" width="100" height="50" border="0"><br>
G-PRO ID:<input size="20" type="text" name="j_username" maxlength="20"><br>
パスワード：<input size="20" type="password" maxlength="20" name="j_password"><br>
    <a href="javascript:document.login.submit()">
    <button class="tourokubutton">ログイン</button>
    </a>
    </form>
    <a href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p0.html"><button class="tourokubutton">ID取得</button></a></div>
<p><img src="image11.gif" width="408" height="87" border="0"></p>
<p><img src="/G-pro_Service/image/GReport_Logo.gif" width="408" height="87" border="0"><br>
<p><b>レポート種別：<%=HttpUtility.escapeHTML(repdata.getRep_Syubetsu()) %></b></p>
<p><b>ゲームタイトル：<%=HttpUtility.escapeHTML(repdata.getGameTitle()) %></b></p>
<p><b>評価点数</b></p>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>&nbsp;評価項目</td>
      <td>評価点&nbsp;</td>
      <td align="center">満点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;難易度の適正度</td>
      <td><%=repdata.getdificultty() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td><%=repdata.getstory() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td><%=repdata.getgraphic() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td><%=repdata.getsound() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td><%=repdata.getvolume() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td><%=repdata.getcontroll() %>点</td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td><%=repdata.getpromotion() %>点</td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td><%=repdata.getfree_S() %>点</td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td><%=repdata.gettotal() %>点</td>
      <td>&nbsp;/100点</td>
    </tr>
  </tbody>
</table>
<p><br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
</p>
<p><b>自由点内訳</b></p>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>評価項目&nbsp;</td>
      <td>評価点&nbsp;</td>
      <td>満点&nbsp;</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(repdata.getjiyuten_koumoku1()) %></td>
      <td>&nbsp;<%=repdata.getjiyuten_score1() %>点</td>
      <td>&nbsp;<%=repdata.getjiyuten_maxscore1() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(repdata.getjiyuten_koumoku2()) %></td>
      <td>&nbsp;<%=repdata.getjiyuten_score2() %>点</td>
      <td>&nbsp;<%=repdata.getjiyuten_maxscore2() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(repdata.getjiyuten_koumoku3()) %></td>
      <td>&nbsp;<%=repdata.getjiyuten_score3() %>点</td>
      <td>&nbsp;<%=repdata.getjiyuten_maxscore3() %>点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">&nbsp;<%=repdata.getjiyuten_score1() + repdata.getjiyuten_score2() + repdata.getjiyuten_score3() %>点</td>
      <td align="center">30点&nbsp;</td>
    </tr>
  </tbody>
</table>
<p><br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<%if(repdata.gettotal() <= 40){ %>
<p>なぜこのような低い評価になったのか?<a href="#" id="login_button">ログイン</a>して投稿者のコメントを確認しよう!</p>
<%}else if(repdata.gettotal() <= 80){ %>
<p>なぜこのような評価になったのか?<a href="#" id="login_button">ログイン</a>して投稿者のコメントを確認しよう!</p>
<%}else if(repdata.gettotal() > 80){ %>
<p>なぜ投稿者はこのゲームを推しているのか?<a href="#" id="login_button">ログイン</a>してコメントを確認しよう!</p>
<% } %>
<p><font color="red" size="+2"><b>※掲載内容の盗用、無断転載、無断複製を禁止します。</b></font></p>
<!-- <p><a href="/G-pro_Service/free_area/Word_Report/WordRep_Serch_Result.jsp"><img src="/G-pro_Service/image/BacktoSerchResult.gif" width="125" height="42" border="0"></a>　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="206" height="47" border="0"></a></p>-->
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/free_area/Word_Report/WordRep_Serch_Result.jsp">検索結果に戻る</a></dd>
    </dl>
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップに戻る</a></dd>
    </dl>
</body>
</html>