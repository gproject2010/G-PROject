<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="inputUtility.HttpUtility" %>
<%@page import="rep_upload.Rep_List_TO" %>
<%@page import="g_jyouhou.Rep_Load_DAO" %>
<%@page import="g_jyouhou.BestReportMaker" %>
<jsp:useBean id="bestrep" scope="session" type="rep_upload.Rep_List_TO"/>
<jsp:useBean id="vote" scope="session" type="rep_upload.Rep_List_TO"/>

<%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO"/>
    
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/OX_Report/OX_BestReport.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>○×レポートベストレポート</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left">　　　　<font size="+2">　<br>
<br>
<br>
<br>
レポート種別：○×レポート</font></p>
<p><a href="/G-pro_Service/free_area/Tutoreal3.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<p><br>
<br><br>
プレイヤーネーム：<%=HttpUtility.escapeHTML(bestrep.getlogin_name()) %><br>
<br>
ゲームタイトル：<br>
<%=HttpUtility.escapeHTML(syousai.getGametitle()) %><br>
<br>
発売メーカー:<%=HttpUtility.escapeHTML(syousai.getMakername()) %><br>
<br>
発売年月日：<%=HttpUtility.escapeHTML(syousai.getHatsubainengappi())%><br>
<br>
メインジャンル：<%=HttpUtility.escapeHTML(syousai.getMaingenre())%>　　　　　サブジャンル１：<%=HttpUtility.escapeHTML(syousai.getSubgenre1())%><br>
<br>
サブジャンル2：<%=HttpUtility.escapeHTML(syousai.getSubgenre2())%>　　　　　　プラットフォーム：<%=HttpUtility.escapeHTML(syousai.getPlatform())%></p>
<p><br>
評価点数(必須)</p>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>&nbsp;評価項目</td>
      <td>評価点&nbsp;</td>
      <td align="center">満点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;難易度の適正度</td>
      <td><%=bestrep.getdificultty() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td><%=bestrep.getstory() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td><%=bestrep.getgraphic() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td><%=bestrep.getsound() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td><%=bestrep.getvolume() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td><%=bestrep.getcontroll() %>点</td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td><%=bestrep.getpromotion() %>点</td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td><%=bestrep.getjiyuten_score1() + bestrep.getjiyuten_score2() + bestrep.getjiyuten_score3() + bestrep.getjiyuten_score4() + bestrep.getjiyuten_score5() %>点</td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td><%=bestrep.getdificultty() + bestrep.getstory() + bestrep.getgraphic() + bestrep.getsound() + bestrep.getvolume() + bestrep.getcontroll() + bestrep.getpromotion() + bestrep.getjiyuten_score1() + bestrep.getjiyuten_score2() + bestrep.getjiyuten_score3() + bestrep.getjiyuten_score4() + bestrep.getjiyuten_score5() %>点</td>
      <td>&nbsp;/100点</td>
    </tr>
  </tbody>
</table>
<br>
<br>
自由点内訳<br>
<table border="1">
  <tbody>
    <tr>
      <td>評価項目&nbsp;</td>
      <td>評価点&nbsp;</td>
      <td>満点&nbsp;</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(bestrep.getjiyuten_koumoku1()) %></td>
      <td>&nbsp;<%=bestrep.getjiyuten_score1() %>点</td>
      <td>&nbsp;<%=bestrep.getjiyuten_maxscore1() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(bestrep.getjiyuten_koumoku2()) %></td>
      <td>&nbsp;<%=bestrep.getjiyuten_score2() %>点</td>
      <td>&nbsp;<%=bestrep.getjiyuten_maxscore2() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(bestrep.getjiyuten_koumoku3()) %></td>
      <td>&nbsp;<%=bestrep.getjiyuten_score3() %>点</td>
      <td>&nbsp;<%=bestrep.getjiyuten_maxscore3() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(bestrep.getjiyuten_koumoku4()) %></td>
      <td>&nbsp;<%=bestrep.getjiyuten_score4() %>点</td>
      <td>&nbsp;<%=bestrep.getjiyuten_maxscore4() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(bestrep.getjiyuten_koumoku5()) %></td>
      <td>&nbsp;<%=bestrep.getjiyuten_score5() %>点</td>
      <td>&nbsp;<%=bestrep.getjiyuten_maxscore5() %>点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">&nbsp;<%=bestrep.getjiyuten_score1() + bestrep.getjiyuten_score2() + bestrep.getjiyuten_score3() + bestrep.getjiyuten_score4() + bestrep.getjiyuten_score5() %>点</td>
      <td align="center"><%=bestrep.getjiyuten_maxscore1() + bestrep.getjiyuten_maxscore2() + bestrep.getjiyuten_maxscore3() + bestrep.getjiyuten_maxscore4() + bestrep.getjiyuten_maxscore5() %>点&nbsp;</td>
    </tr>
  </tbody>
</table>
<br>
<br>
ゲームの概要・ストーリー<br>
<pre><%=HttpUtility.escapeHTML(bestrep.getoutline())%></pre><br>
<br>
<p><img src="/G-pro_Service/image/Goodies_Logo.gif" width="67" height="52" border="0" alt="Good!">このゲームの良かった所(必須)</p><br>
<pre><%=HttpUtility.escapeHTML(bestrep.getgoodies()) %></pre><br>
<br>
今後の課題<img src="/G-pro_Service/image/Badies_Logo.gif" width="72" height="52" border="0" alt="Bad・・・"><br>
<pre><%=HttpUtility.escapeHTML(bestrep.getbadies()) %></pre><br>
※良かった所・今後の課題ともに各全角1000文字以内<br>
<br>
<br>
<p><font color="#0000ff">このレポートに対するみんなの評価は？</font></p>
<table border="1">
  <tbody>
    <tr>
      <td><% if(vote.getYourVote() != null && vote.getYourVote().equals("empty")){ %><a href="/G-pro_Service/Rep_Vote_Upload?rep_code=<%=bestrep.getreport_code() %>&command=shiji"><% } %><img src="/G-pro_Service/image/Good_Icon.gif" width="106" height="52" border="0">&nbsp;<font size="+1"><b>×<%=vote.getShijisyasu() %></b></font><% if(vote.getYourVote() != null && vote.getYourVote().equals("empty")){ %></a><% } %></td>
      <td><% if(vote.getYourVote() != null && vote.getYourVote().equals("empty")){ %><a href="/G-pro_Service/Rep_Vote_Upload?rep_code=<%=bestrep.getreport_code() %>&command=fushiji"><% } %><img src="/G-pro_Service/image/Bad_Button.gif" width="106" height="52" border="0"><font size="+1"><b>×<%=vote.getFushijisyasu() %></b></font><% if(vote.getYourVote() != null && vote.getYourVote().equals("empty")){ %></a><% } %></td>
    </tr>
  </tbody>
</table>
<% if(vote.getYourVote() != null && !(vote.getYourVote().equals("empty"))){ %><p><font color="#ff0000">※あなたはこのレポートに投票済みです。</font></p><% } %>
<p><font color="red" size="+2"><b>※掲載内容の盗用、無断転載、無断複製を禁止します。</b></font></p>
<!-- <p align="center"><a href="/G-pro_Service/passed/G_SeachResult.jsp"><img src="/G-pro_Service/passed/GData_Images/BacktoSerchResult.gif" width="125" height="42" border="0" alt="検索結果に戻る"></a>　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/GData_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/G_SeachResult.jsp">検索結果に戻る</a></dd>
    </dl>
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
    </dl>
</body>
</html>