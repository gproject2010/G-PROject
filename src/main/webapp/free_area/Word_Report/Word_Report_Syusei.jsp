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
<base href="/G-pro_Service/free_area/Word_Report/Word_Report_Syusei.jsp">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>一言レポート(修正)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left">
<font color="#0000ff"><b>入力内容に不備があったようです。メッセージに従って修正してみましょう。</b></font></p>
<% if(repdata.isJisu_wrong() == true){ %><p><b><font color="#ff0000">※字数が制限を超えている項目があります。</font><font color="#0000ff">←ゲームタイトルやコメントの字数制限が守られているか確認しましょう。</font></b><br><% } %>
<% if(repdata.isover() == true){ %><b><font color="#ff0000">※評価点数に満点を超えている項目があります。</font><font color="#0000ff">←「満点」の欄の点数を超えた評価点を設定していないか確認しましょう。</font></b><br><% } %>
<% if(repdata.isfew() == true){ %><b><font color="#ff0000">※評価点数にマイナスの値が入力されている項目があります。</font><font color="#0000ff">←入力した数値に「-」(ハイフン)が付いていないか確認しましょう。</font></b><br><% } %>
<% if(repdata.isnotscore() == true){ %><b><font color="#ff0000">※評価点数に入力されていない項目があります。</font><font color="#0000ff">←入力漏れがあります。「自由点内訳」以外に空欄がないか確認しましょう。</font></b><br><% } %>
<% if(repdata.isnotmatch() == true){ %><b><font color="#ff0000">※評価欄の合計が自由点欄のものと一致していません。２つの値が等しくなるように再設定して下さい。</font><br>
<font color="#0000ff">↑自由点欄の評価点、満点の合計が評価点数欄の「提出者の考えによる自由点」と合っていません。<br>
計算が合うように点数を修正してください。</font></b><br><% } %>
<% if(repdata.isNoComment() == true){ %><b><font color="#ff0000">※コメントが記述されていません。</font><font color="#0000ff">←コメント欄が空欄のままです。あなたの考えをありのまま入力してください。</font></b><br><% } %>
<% if(repdata.iswrong() == true){ %><b><font color="#ff0000">※不正な値が入力されています。</font><font color="#0000ff">←処理できない特殊な文字が入力されています。思い当たる文字を削除してみてください。</font></b><br><% } %>
<% if(repdata.getNGWord() != null){ %><b><font color="#ff0000">※記述内容に禁止ワード(公開できない単語)が含まれています。(ヒットした入力値:<%=repdata.getNGWord() %>)訂正して再試行してください。</font><br>
<font color="#0000ff">↑G-PROjectで使用が禁止されている単語が入力されています。メッセージに表示されている単語を削除してください。</font></b></p><% } %>
<p><b>レポート種別：一言レポート</b></p>
<form action="/G-pro_Service/Word_Rep_Kakunin" method="post">
<p><b>ゲームタイトル：</b><input size="50" type="text" name="gametitle" value="<%=HttpUtility.escapeHTML(repdata.getGameTitle())%>"></p>
<p><b>評価点数(トータル点数は自動で計算されます)</b></p>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>&nbsp;評価項目</td>
      <td>評価点&nbsp;</td>
      <td align="center">満点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;難易度の適正度</td>
      <td>
      <input size="4" type="text" maxlength="4" name="dificultty" value="<%=repdata.getdificultty() %>">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td>
      <input size="4" type="text" maxlength="4" name="story" value="<%=repdata.getstory() %>">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td>
      <input size="4" type="text" maxlength="4" name="graphic" value="<%=repdata.getgraphic() %>">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td>
      <input size="4" type="text" maxlength="4" name="sound" value="<%=repdata.getsound() %>">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td>
      <input size="4" type="text" maxlength="4" name="volume" value="<%=repdata.getvolume() %>">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td>
      <input size="4" type="text" maxlength="4" name="controll" value="<%=repdata.getcontroll() %>">点
      </td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td>
      <input size="4" type="text" maxlength="4" name="promotion" value="<%=repdata.getpromotion() %>">点
      </td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td>
      <input size="5" type="text" maxlength="5" name="free_s" value="<%=repdata.getfree_S() %>">点
      </td>
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
<b>←チュートリアルの説明を参考に、評価点数を入力してください。<br>
空欄、もしくは0～満点の数値以外が入力されている項目があると入力が<br>
受け付けられません。</b><br>
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
<p><b>自由点内訳(トータル点数は自動で計算されます)</b></p>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>評価項目&nbsp;</td>
      <td>評価点&nbsp;</td>
      <td>満点&nbsp;</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku1" value="<%=HttpUtility.escapeHTML(repdata.getjiyuten_koumoku1()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score1" value="<%=repdata.getjiyuten_score1() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore1" value="<%=repdata.getjiyuten_maxscore1() %>">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku2" value="<%=HttpUtility.escapeHTML(repdata.getjiyuten_koumoku2()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score2" value="<%=repdata.getjiyuten_score2() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore2" value="<%=repdata.getjiyuten_maxscore2() %>">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku3" value="<%=HttpUtility.escapeHTML(repdata.getjiyuten_koumoku3()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score3" value="<%=repdata.getjiyuten_score3() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore3" value="<%=repdata.getjiyuten_maxscore3() %>">点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">&nbsp;<%=repdata.getjiyuten_scoretotal() %>点</td>
      <td align="center"><%=repdata.getjiyuten_maxscoretotal() %>点&nbsp;</td>
    </tr>
  </tbody>
</table>
<p><b>←評価点数のうち30点は提出者オリジナルの評価項目に割り当てられています。<br>
点数を割り当てる評価項目(全角30文字以内)、その項目の評価点数、満点とする点数を<br>
入力してください。<br>
※１:評価項目が１～2つの場合は設定しないフォームをすべて空欄にしてください。<br>
※２:満点の合計は30点、評価点の合計は上記評価項目の「提出者の考えによる<br>
自由点」に入力した点数と同じにしてください。違っていると入力が受け付けられません。<br>
※３:このレポートでは設定できる項目が3つに制限されています。<br>
<br>
<br>
<br>
コメント入力：このゲームについて現在あなたが思っていることを一言で記述してください。</b></p>
<b><textarea rows="8" cols="100" name="comment"><%=HttpUtility.escapeHTML(repdata.getComment()) %></textarea></b>
<p><b>(最大全角200文字以内。なお、フォームの横幅は全角50文字分です。）</b></p>
<p><font color="#0000ff"><b>G-PROject公式のレポートでは他にもたくさんお聞きすることがあるのですが、基本的な入力項目は以上となります。<br>
では下記の注意をよく読んだうえで、「確定」ボタンをクリックしてみましょう。</b></font></p>
<p><b><font color="#ff0000">注意！<br>
1:このレポートはG-PROject公式のものではないため、レポートスコアやG-PROマイレージの対象にはなりません。<br>
ただし会員登録後、同じタイトルのゲームレポートを1つ作成することができます。<br>
2:セキュリティ確保のため同じIPアドレスからの一言レポートの送信は１ヶ月につき３通までに制限されています。<br>
3:アップロードされたレポートは審査の結果、管理者が有効と判断した場合のみ公開されます。また、審査結果に関する<br>
質問・問い合わせにはお答えできません。あらかじめご了承ください。</font></b></p>
<!-- <p><input type="image" src="/G-pro_Service/image/Kakutei_Button.gif" width="65" border="0" alt="確定" height="51">     <a href="/G-pro_Service/free_area/Tutoreal_mokuji.jsp"><img src="/G-pro_Service/image/BacktoTutoTop.gif" width="206" height="47" border="0"></a></p>-->
<input id="tourokubutton" type="submit" name="submit" value="確定">
    <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/free_area/Word_Report/Word_Report_Syusei.jsp">内容の修正</a></dd>
    </dl>
    <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップに戻る</a></dd>
    </dl>
</form>
</body>
</html>