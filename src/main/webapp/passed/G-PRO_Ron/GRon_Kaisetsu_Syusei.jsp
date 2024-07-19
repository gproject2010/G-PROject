<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="gpro_ron.GPRO_Ron_ToppageMaker" %>
    <%@ page import= "gpro_ron.GRon_Kaisetsu_Uketsuke"%>
    <jsp:useBean id="kouhodata" scope="session" type="gpro_ron.GRon_Data_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/G-pro_Service/passed/G-PRO_Ron/GRon_Kaisetsu_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRon.css"/>
<title>掲示板開設設定(修正)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<form action="/G-pro_Service/GRon_Kaisetsu_Uketsuke" method="post">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/ShinkiKaisetsu_Logo.gif" width="286" height="52" border="0" alt="掲示板の新規開設"></p>
<p><font color="red"><%if(kouhodata.isNGHit() == true){ %>ネット上に公開できない内容が検出されました。(検出された禁止ワード:<%=kouhodata.getNGWord() %>)訂正して再試行してください。<% } %></font></p>
<p><font color="yellow"><%if(kouhodata.isNoData() == true){ %>入力されていない項目があります。内容をもう一度確認してください。<% } %></font></p>
<p><font color="yellow"><%if(kouhodata.isSelectError() == true){ %>選択肢の認識でエラーが発生しました。選択していない項目がないか確認してください。<% } %></font></p>
<p>議題:<input size="30" type="text" maxlength="30" name="gidai" value=<%=HttpUtility.escapeHTML(kouhodata.getGidai()) %>>(最大全角30文字)</p>
<p>最初の書き込み(開設のあいさつ、どんな理由で開設したか、期待している書き込みの内容など)<br>
<textarea rows="5" cols="50" name="1st_write"><%=HttpUtility.escapeHTML(kouhodata.getFirst_Write()) %></textarea><br>
(最大全角120文字)</p>
書き込み可能条件<br>
<br>
<input type="radio" name="jyouken_henkou" value="nochange" checked>変更しない:
<% if(kouhodata.getJyoukenSyubetsu().equals("G-PROjectランキング上位者")){ %>
      <%=HttpUtility.escapeHTML(kouhodata.getSc_Syubetsu()) %>の<%=HttpUtility.escapeHTML(kouhodata.getRankJyouken()) %><br>
      ランキング<%=kouhodata.getRank_Min() %>位以上
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("アクションスコア")){ %>
      <%=HttpUtility.escapeHTML(kouhodata.getSc_Syubetsu()) %>のアクションスコア<br>
      <%=kouhodata.getSc_Min() %>以上
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("レポートスコア")){ %>
      <%=HttpUtility.escapeHTML(kouhodata.getSc_Syubetsu()) %>のレポートスコア<br>
      <%=kouhodata.getSc_Min() %>以上
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("プレイヤーレベル")){ %>
      プレイヤーレベル<br>
      <%=kouhodata.getPlayerLv_Min() %>以上<%=kouhodata.getPlayerLv_Max() %>以下
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("年齢")){ %>
      年齢<br>
      <%=kouhodata.getPlayerLv_Min() %>歳以上<%=kouhodata.getPlayerLv_Max() %>歳以下
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("性別")){ %>
      性別：<%=kouhodata.getSex() %>
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("フリー(条件なし)")){ %>
      フリー(条件なし)
      <% }else{ %>
      ERROR
      <% } %>
のまま確定する<br>
<br>
<input type="radio" name="jyouken_henkou" value="change">変更する:以下から選択・入力してください<br>
<br>
<input type="radio" name="jyoukensyubetsu" value="フリー(条件なし)" checked>フリー(条件なし)<br>
<br>
<input type="radio" name="jyoukensyubetsu" value="プレイヤーレベル">プレイヤーレベル<input size="4" type="text" maxlength="4" name="playerlv_min" value="0">以上、<input size="4" type="text" maxlength="4" name="playerlv_max" value="9999">以下<br>
<br>
<input type="radio" name="jyoukensyubetsu" value="レポートスコア"><select name="sc_syubetsu">
  <option value="累計" selected>累計</option>
  <option value="年間">年間</option>
  <option value="先月">先月</option>
  <option value="今月">今月</option>
</select>のレポートスコア<input size="10" type="text" maxlength="10" name="sc_min" value="0">以上(小数第3位以下四捨五入、半角数字で入力し、小数点はピリオド(.)を使用してください)<br>
<br>
<input type="radio" name="jyoukensyubetsu" value="アクションスコア"><select name="sc_syubetsu">
  <option value="累計" selected>累計</option>
  <option value="年間">年間</option>
  <option value="先月">先月</option>
  <option value="今月">今月</option>
</select>のアクションスコア<input size="10" type="text" maxlength="10" name="sc_min" value="0">以上(小数第3位以下四捨五入、半角数字で入力し、小数点はピリオド(.)を使用してください)<br>
<br>
<input type="radio" name="jyoukensyubetsu" value="G-PROjectランキング上位者">G-PROjectランキング上位者(ラジオボタンを選択後、詳細を入力してください)<br>
<select name="sc_syubetsu">
  <option value="累計" selected>累計</option>
  <option value="年間">年間</option>
  <option value="先月">先月</option>
  <option value="今月">今月</option>
</select>の<select name="rankjyouken">
  <option value="アクションスコア">アクションスコア</option>
  <option value="レポートスコア" selected>レポートスコア</option>
  <option value="レポートスコア・アクションスコア合計">レポートスコア・アクションスコア合計</option>
</select>ランキング<select name="rank_min">
  <option value="10000" selected>上位10000名</option>
  <option value="5000">上位5000名</option>
  <option value="2000">上位2000名</option>
  <option value="1000">上位1000名</option>
  <option value="500">上位500名</option>
  <option value="100">上位100名</option>
  <option value="50">上位50名</option>
</select>
<br>
<br>
<input type="radio" name="jyoukensyubetsu" value="年齢">年齢<input size="4" type="text" maxlength="4" name="player_lv_min" value="0">歳以上、<input size="3" type="text" maxlength="3" name="player_lv_max" value="999">歳以下<br>
<br>
<input type="radio" name="jyoukensyubetsu" value="性別">性別：　<input type="radio" checked name="sex" value="男性">男性　<input type="radio" name="sex" value="女性">女性<br>
<p>開設期間<br>
<br>
<input type="radio" name="kaisetsukikan_henkou" value="nochange" checked>変更しない：<%=HttpUtility.escapeHTML(kouhodata.getKaisetsukikan()) %>で確定します<br>
<br>
<input type="radio" name="kaisetsukikan_henkou" value="change">変更する：以下から選択してください<br>
<br>
<input type="radio" checked name="kaisetsukikan" value="1週間">1週間<br>
<input type="radio" name="kaisetsukikan" value="2週間">2週間<br>
<input type="radio" name="kaisetsukikan" value="1ヶ月">1か月<br>
<input type="radio" name="kaisetsukikan" value="3ヶ月">3ヶ月<br>
※いずれも掲載開始からの期間<br>
<br>
書き込み上限回数(プレイヤー1人がこの掲示板に書き込める回数)<br>
<br>
<input type="radio" name="kakikomijyougen_henkou" value="nochange" checked>変更しない：<%=HttpUtility.escapeHTML(kouhodata.getKaisetsukikan()) %>で確定します<br>
<br>
<input type="radio" name="kakikomijyougen_henkou" value="change">変更する：以下から選択してください<br>
<br>
<input type="radio" checked name="kakikomijyougen" value="1">1回<br>
<input type="radio" name="kakikomijyougen" value="2">2回<br>
<input type="radio" name="kakikomijyougen" value="3">3回<br>
<input type="radio" name="kakikomijyougen" value="5">5回<br>
</p>
<br>
<p>注意:<br>
・審査のため、開設の申し込みから実際の開設まで3~5日程度時間がかかります。<br>
・開設してから1週間、他のプレイヤーからのレスポンスがなかった掲示板は自動で削除されます。<br>
・開設した掲示板に対し、不適切な書き込みがされた場合、記述の削除だけでなく、管理者の判断により<br>
掲示板自体を削除する場合があります。</p>
<!-- <p><input type="image" name="submit" alt="確定" src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Kakutei.gif" width="160" height="70" border="0">　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</form>
</body>
</html>