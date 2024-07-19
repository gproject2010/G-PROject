<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="inputUtility.HttpUtility" %>
<%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO"/>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="rep_upload.Free_Report_Kakunin" %>
    <jsp:useBean id="freehyouka" scope="session" type="rep_upload.Rep_Koumoku"/>
    <%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="k_jyouhou.StatusMaker" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
 <html lang="ja">
<head>
<base href="/G-pro_Service/passed/Free_Report/Free_Rep_Kakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>自由形式レポート(入力内容確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left">　　　　<font size="+2">　<br>
<br>
<br>
<br>
<br>
<font color="#0000ff" size="+2">登録内容を確認し、よろしければ一番下のフォームに添付する<br>
フォルダを指定して「この内容で登録する」をクリックしてください。</font>
<br>
レポート種別：自由形式レポート・ゲーム情報から登録</font></p>
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
<table border="1" align="left">
  <tbody>
    <tr>
      <td>&nbsp;評価項目</td>
      <td>評価点&nbsp;</td>
      <td align="center">満点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;難易度の適正度</td>
      <td><%=freehyouka.getdificultty() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td><%=freehyouka.getstory() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td><%=freehyouka.getgraphic() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td><%=freehyouka.getsound() %>点</td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td><%=freehyouka.getvolume() %>点</td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td><%=freehyouka.getcontroll() %>点</td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td><%=freehyouka.getpromotion() %>点</td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td><%=freehyouka.getfree_S() %>点</td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td><%=freehyouka.gettotal() %>点</td>
      <td>&nbsp;/100点</td>
    </tr>
  </tbody>
</table>
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
      <td><%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku1()) %></td>
      <td>&nbsp;<%=freehyouka.getjiyuten_score1() %>点</td>
      <td>&nbsp;<%=freehyouka.getjiyuten_maxscore1() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku2()) %></td>
      <td>&nbsp;<%=freehyouka.getjiyuten_score2() %>点</td>
      <td>&nbsp;<%=freehyouka.getjiyuten_maxscore2() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku3()) %></td>
      <td>&nbsp;<%=freehyouka.getjiyuten_score3() %>点</td>
      <td>&nbsp;<%=freehyouka.getjiyuten_maxscore3() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku4()) %></td>
      <td>&nbsp;<%=freehyouka.getjiyuten_score4() %>点</td>
      <td>&nbsp;<%=freehyouka.getjiyuten_maxscore4() %>点</td>
    </tr>
    <tr>
      <td><%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku5()) %></td>
      <td>&nbsp;<%=freehyouka.getjiyuten_score5() %>点</td>
      <td>&nbsp;<%=freehyouka.getjiyuten_maxscore5() %>点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">&nbsp;<%=freehyouka.getjiyuten_scoretotal() %>点</td>
      <td align="center"><%=freehyouka.getjiyuten_maxscoretotal() %>点&nbsp;</td>
    </tr>
  </tbody>
</table>
※満点の合計が30点ちょうどになるように設定してください(<span id="jiyuten_maxtotal">---</span>)<br>
※評価項目は最大全角20文字まで
<br>
ゲームの概要・ストーリー：<br>
<br>
<pre><%=HttpUtility.escapeHTML(freehyouka.getoutline()) %></pre><br>
※最大全角1000文字以内
<br>
<br>
<p><br><br>
共通インタビュー項目<br>
<br>
Q1:このゲームをプレーすることを希望している人は誰ですか？<br>
該当する人すべてにチェックを入れてください。(最低1つチェックが必要です。)<br>
<%for(int i=0; i < freehyouka.getInterview1().length; i++){ %>
<%= HttpUtility.escapeHTML(freehyouka.getInterview1()[i]) %><br>
<% } %>
<br>
<br>
Q2:このゲームの発売または購入をもっとも心待ちにしていた人は誰ですか？<br>
1つだけ選んでください。(必須)
<br>
<%= HttpUtility.escapeHTML(freehyouka.getInterview2()) %><br>
<br>
<br>
Q3:このゲームに関する情報で、見聞きしたことのあるものをすべてチェックしてください。<br>
(最低1つチェックが必要です。)<br>
<br>
<%for(int i=0; i < freehyouka.getInterview3().length; i++){ %>
<%= HttpUtility.escapeHTML(freehyouka.getInterview3()[i]) %><br>
<% } %>
<br>
<br>
Q4:このゲームに関する情報で、購入の最大の決め手となったものを1つ選んでください。<br>
(必須)<br>
<%= HttpUtility.escapeHTML(freehyouka.getInterview4()) %><br>
<br>
<br>
Q5:このゲームを購入した理由として当てはまるものをすべてチェックしてください。（必須）<br>
<br>
<%for(int i=0; i < freehyouka.getInterview5().length; i++){ %>
<%= HttpUtility.escapeHTML(freehyouka.getInterview5()[i]) %><br>
<% } %><br>
<br>
<br>
Q6:ズバリ、このゲームのシリーズや続編が発売されたら購入しますか？<br>
<br>
<%= HttpUtility.escapeHTML(freehyouka.getInterview6()) %><br>
<br>
<br>
</p>
<br><form action="/G-pro_Service/Rep_Touroku" enctype="multipart/form-data" method="post">
<p><img src="/G-pro_Service/image/Your_Data.gif" width="300" height="60" border="0"><font size="+2">(必ず確認してください)</font></p><br>
<br>
<font size="+1">ID：<%=HttpUtility.escapeHTML(seiseki.getk_Id()) %><br>
<br>
ログインネーム：<%=HttpUtility.escapeHTML(seiseki.getlogin_name()) %><br>
<br>
プレイヤーレベル：<%=seiseki.getplayer_Level() %></font><br>
<br>
<br>
<font color="blue" size="+1">レポートデータのアップロード：送信するレポートデータを指定してください</font><br>
ファイル名：<br>
<input type="file" name="filename" >
<input type="hidden" name="rep" value="free">
<br>
<p><b><font size="+2" color="#0000ff">注意:レポートは一度アップロードすると加筆・訂正は一切できません!</font></b></p>
<!-- <p align="center"><input type="image" name="submit" src="/G-pro_Service/image/Touroku_Button.gif" alt="この内容で送信する" width="59" height="47" border="0"></form><a href="/G-pro_Service/passed/Free_Report/Free_Rep_Syusei.jsp"><img src="/G-pro_Service/image/Rep_Kakinaoshi.gif" alt="レポートを書き直す"></a>-->
<input class="tourokubutton" type="submit" name="submit" value="この内容で送信する">
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/Free_Report/Free_Rep_Syusei.jsp">内容を修正する</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
    </form>
</body>
</html>