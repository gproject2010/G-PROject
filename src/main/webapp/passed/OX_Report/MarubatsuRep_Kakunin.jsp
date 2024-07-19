<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO"/>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="rep_upload.Marubatsu_Report_Kakunin" %>
    <jsp:useBean id="hyouka" scope="session" type="rep_upload.Rep_Koumoku"/>
    <%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="k_jyouhou.StatusMaker" %>
    <jsp:useBean id="seiseki" scope="session" class="k_jyouhou.R_jyouhou_TO"/>
    <html lang="ja">
<head>
<base href="/G-pro_Service/passed/OX_Report/MaruBatsu_Rep_Kakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>○×レポート(入力内容確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left">　　　　<font size="+2">　<br>
<br>
<br>
<br>
<br>
<font color="#0000ff" size="+2">以下の内容で登録します。よろしいですか？</font>
<br>
レポート種別：○×レポート・ゲーム情報から登録</font></p>
<p><a href="/G-pro_Service/free_area/Tutoreal3.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<p><br>
ゲームタイトル：<br>
<%=HttpUtility.escapeHTML(syousai.getGametitle())%><br>
<br>
発売メーカー:<%=HttpUtility.escapeHTML(syousai.getMakername())%><br>
<br>
発売年月日：<%=HttpUtility.escapeHTML(syousai.getHatsubainengappi())%><br>
<br>
メインジャンル：<%=HttpUtility.escapeHTML(syousai.getMaingenre())%>　　　　　サブジャンル１：<%=HttpUtility.escapeHTML(syousai.getSubgenre1())%><br>
<br>
サブジャンル2：<%=HttpUtility.escapeHTML(syousai.getSubgenre2())%>　　　　　プラットフォーム：<%=HttpUtility.escapeHTML(syousai.getPlatform())%></p>
<p><br>
評価点数(必須)</p>
<table border="1" >
  <tbody>
    <tr>
      <td>&nbsp;評価項目</td>
      <td>評価点&nbsp;</td>
      <td align="center">満点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;難易度の適正度</td>
      <td><%=hyouka.getdificultty() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td><%=hyouka.getstory() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td><%=hyouka.getgraphic() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td><%=hyouka.getsound() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td><%=hyouka.getvolume() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td><%=hyouka.getcontroll() %>点</td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td><%=hyouka.getpromotion() %>点</td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td><%=hyouka.getfree_S() %>点</td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td><%=hyouka.gettotal() %>点</td>
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
      <td><%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku1()) %></td>
      <td>&nbsp;<%=hyouka.getjiyuten_score1() %>点</td>
      <td>&nbsp;<%=hyouka.getjiyuten_maxscore1() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku2()) %></td>
      <td>&nbsp;<%=hyouka.getjiyuten_score2() %>点</td>
      <td>&nbsp;<%=hyouka.getjiyuten_maxscore2() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku3()) %></td>
      <td>&nbsp;<%=hyouka.getjiyuten_score3() %>点</td>
      <td>&nbsp;<%=hyouka.getjiyuten_maxscore3() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku4()) %></td>
      <td>&nbsp;<%=hyouka.getjiyuten_score4() %>点</td>
      <td>&nbsp;<%=hyouka.getjiyuten_maxscore4() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku5()) %></td>
      <td>&nbsp;<%=hyouka.getjiyuten_score5() %>点</td>
      <td>&nbsp;<%=hyouka.getjiyuten_maxscore5() %>点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">&nbsp;<%=hyouka.getjiyuten_scoretotal() %>点</td>
      <td align="center"><%=hyouka.getjiyuten_maxscoretotal() %>点&nbsp;</td>
    </tr>
  </tbody>
</table>
※満点の欄の合計が30点になるよう必ず確認してください。<br>
<br>
<br>
ゲームの概要・ストーリー(必須)：<br>
<br>
<pre><%=HttpUtility.escapeHTML(hyouka.getoutline())%></pre><br>
※最大全角1000文字以内<br>
<br>
<p><br><br>
共通インタビュー項目<br>
<br>
Q1:このゲームをプレーすることを希望している人は誰ですか？<br>
該当する人すべてにチェックを入れてください。(最低1つチェックが必要です)<br>
<br>
<%for(int i=0; i < hyouka.getInterview1().length; i++){ %>
<%= HttpUtility.escapeHTML(hyouka.getInterview1()[i]) %><br>
<% } %>
<br>
<br>
Q2:このゲームの発売または購入をもっとも心待ちにしていた人は誰ですか？<br>
1つだけ選んでください。(必須)<br>
<br>
<%= HttpUtility.escapeHTML(hyouka.getInterview2()) %><br>
<br>
<br>
Q3:このゲームに関する情報で、見聞きしたことのあるものをすべてチェックしてください。<br>
(最低1つチェックが必要です。)<br>
<br>
<%for(int i=0; i < hyouka.getInterview3().length; i++){ %>
<%= HttpUtility.escapeHTML(hyouka.getInterview3()[i]) %><br>
<% } %>
<br>
<br>
Q4:このゲームに関する情報で、購入の最大の決め手となったものを1つ選んでください。<br>
(必須)<br>
<%= HttpUtility.escapeHTML(hyouka.getInterview4()) %><br>
<br>
<br>
Q5:このゲームを購入した理由として当てはまるものをすべてチェックしてください。（必須）<br>
<br>
<%for(int i=0; i < hyouka.getInterview5().length; i++){ %>
<%= HttpUtility.escapeHTML(hyouka.getInterview5()[i]) %><br>
<% } %><br>
<br>
<br>
Q6:ズバリ、このゲームのシリーズや続編が発売されたら購入しますか？<br>
<%= HttpUtility.escapeHTML(hyouka.getInterview6()) %>
<br>
<br>
<img src="/G-pro_Service/image/Goodies_Logo.gif" width="67" height="52" border="0" alt="Good!">このゲームの良かった所(必須)<br></p>
<pre><%=HttpUtility.escapeHTML(hyouka.getgoodies()) %></pre><br>
<br>
今後の課題<img src="/G-pro_Service/image/Badies_Logo.gif" width="72" height="52" border="0" alt="Bad・・・"><br>
<pre><%=HttpUtility.escapeHTML(hyouka.getbadies())%></pre><br>
※良かった所・今後の課題ともに各全角1000文字以内<br>
<br>
<img src="/G-pro_Service/image/Your_Data.gif" width="300" height="60" border="0"><font size="+2">(必ず確認してください)</font><br>
<br>
<font size="+1">ID：<%=HttpUtility.escapeHTML(seiseki.getk_Id()) %><br>
<br>
ログインネーム：<%=HttpUtility.escapeHTML(seiseki.getlogin_name()) %><br>
<br>
プレイヤーレベル：<%=seiseki.getplayer_Level() %></font><br>
<p><b><font size="+2" color="#0000ff">注意:レポートは一度アップロードすると加筆・訂正は一切できません!</font></b></p>
<form action="/G-pro_Service/Rep_Touroku" enctype="multipart/form-data" method="post">
<input type="hidden" name="rep" value="marubatsu">
<!-- <p align="center"><input type="image" name="submit" src="/G-pro_Service/image/Touroku_Button.gif" alt="この内容で送信する"  width="59" height="47">　　<a href="/G-pro_Service/passed/OX_Report/MaruBatsu_Syusei.jsp"><img src="/G-pro_Service/image/Rep_Kakinaoshi.gif" alt="レポートを書き直す"></a></p>-->
<input class="tourokubutton" type="submit" name="submit" value="この内容で送信する">
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/Free_Report/MaruBatsu_Syusei.jsp">内容を修正する</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</form>
</body>
</html>