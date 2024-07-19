<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="rep_upload.Word_Rep_Kakunin" %>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <jsp:useBean id="repdata" scope="session" type="rep_upload.Rep_Koumoku"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<base href="/G-pro_Service/free_area/Word_Report/Word_Report_Kakunin.jsp">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>一言レポート(入力内容確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left">
<font color="#0000ff"><b>入力値チェックの結果、問題は検出されなかったようです。<br>
それでは入力内容を確認したうえで、レポートを正式にアップロードしてみましょう。</b></font>
<p><b><font color="#0000ff" size="+2">以下の内容で登録します。よろしいですか?</font></b></p>
<p><b>レポート種別：一言レポート</b></p>
<p><b>ゲームタイトル：</b><%=HttpUtility.escapeHTML(repdata.getGameTitle()) %></p>
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
      <td align="center">&nbsp;<%=repdata.getjiyuten_scoretotal() %>点</td>
      <td align="center"><%=repdata.getjiyuten_maxscoretotal() %>点&nbsp;</td>
    </tr>
  </tbody>
</table>
<p><b><br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
コメント入力：このゲームについて現在あなたが思っていることを一言で記述してください。</b></p>
<b>あなたの記述:</b><br>
<pre><%=HttpUtility.escapeHTML(repdata.getComment()) %></pre>
<p><font color="#0000ff"><b>G-PROject公式のレポートでは他にもたくさんお聞きすることがあるのですが、基本的な入力項目は以上となります。<br>
では下記の注意をよく読んだうえで、「確定」ボタンをクリックしてみましょう。レポートがG-PROjectのサーバに<br>
アップロードされます。なお、一度アップロードすると訂正、変更、削除はできないので注意!</b></font></p>
<p><b><font color="#ff0000">注意！<br>
1:このレポートはG-PROject公式のものではないため、レポートスコアやG-PROマイレージの対象にはなりません。<br>
ただし会員登録後、同じタイトルのゲームレポートを1つ作成することができます。<br>
2:セキュリティ確保のため同じIPアドレスからの一言レポートの送信は１ヶ月につき３通までに制限されています。
3:アップロードされたレポートは審査の結果、ゲームマスターが有効と判断した場合のみ公開されます。また、審査結果に関する<br>
質問・問い合わせにはお答えできません。あらかじめご了承ください。</font></b></p>
<!-- <p><a href="/G-pro_Service/WordRep_Touroku"><img src="/G-pro_Service/image/Kakutei_Button.gif" width="65" border="0" alt="確定" height="51"></a>     <a href="/G-pro_Service/free_area/Word_Report/Word_Report_Syusei.jsp"><img src="/G-pro_Service/image/Cansel_Button.gif" width="88" height="48" border="0"></a>     <a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoTutoTop.gif" width="206" height="47" border="0"></a></p>-->
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/WordRep_Touroku">確定</a></dd>
    </dl>
    <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/free_area/Word_Report/Word_Report_Syusei.jsp">内容の修正</a></dd>
    </dl>
    <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップに戻る</a></dd>
    </dl>
</body>
</html>