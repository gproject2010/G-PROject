<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="inputUtility.HttpUtility" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="gpro_ron.GPRO_Ron_ToppageMaker" %>
<%@ page import="k_jyouhou.R_jyouhou_TO" %>
<%@ page import="k_jyouhou.R_jyouhou_DAO" %>
<%@ page import="ninsyou.AuthenticationController" %>
<jsp:useBean id="nowinfo" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="endinfo" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRon.css"/>
<title>G-PRO論。トップ</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/GRon_Logo.gif" width="393" height="141" border="0"></p>
<p>ここでは、ゲームに関する様々な「議題」に対し、あなたの意見を書き込んでいく「討論型掲示板」を提供しています。</p>
<p><a href="/G-pro_Service/free_area/Tutoreal5.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/NowInfo_Logo.gif" width="343" height="52" border="0" alt="書き込み受付中の議題"></p>
<table border="1">
  <tbody>
    <tr>
      <td>掲示板<br>
      コード&nbsp;</td>
      <td>&nbsp;議題</td>
      <td>開設日時&nbsp;</td>
      <td>開設者<br>
      プレイヤーネーム&nbsp;</td>
      <td>トータル<br>
      レスポンス数&nbsp;</td>
      <td>書き込み<br>
      締切予定日時&nbsp;</td>
      <td>書き込み<br>
      可能条件&nbsp;</td>
      <td>書き込み<br>
      上限回数&nbsp;</td>
      <td>討論ページ<br>
      リンク&nbsp;</td>
    </tr>
    <% for(GRon_Data_TO list : nowinfo){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(list.getKeijiban_Code()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(list.getGidai()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(list.getKaisetsuNichiji()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(list.getKaisetsusya()) %>&nbsp;</td>
      <td><%=list.getTotalRespCount() %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(list.getShimekiriNichiji()) %>&nbsp;</td>
      <td><% if(list.getJyoukenSyubetsu().equals("G-PROjectランキング上位者")){ %>
      <%=list.getSc_Syubetsu() %>の<%=list.getRankJyouken() %><br>
      ランキング<%=list.getRank_Min() %>位以上
      <% }else if(list.getJyoukenSyubetsu().equals("アクションスコア")){ %>
      <%=list.getSc_Syubetsu() %>のアクションスコア<br>
      <%=list.getSc_Min() %>以上
      <% }else if(list.getJyoukenSyubetsu().equals("レポートスコア")){ %>
      <%=list.getSc_Syubetsu() %>のレポートスコア<br>
      <%=list.getSc_Min() %>以上
      <% }else if(list.getJyoukenSyubetsu().equals("プレイヤーレベル")){ %>
      プレイヤーレベル<br>
      <%=list.getPlayerLv_Min() %>以上<%=list.getPlayerLv_Max() %>以下
       <% }else if(list.getJyoukenSyubetsu().equals("年齢")){ %>
      年齢<br>
      <%=list.getPlayerLv_Min() %>歳以上<%=list.getPlayerLv_Max() %>歳以下
      <% }else if(list.getJyoukenSyubetsu().equals("性別")){ %>
      性別：<%=list.getSex() %>
      <% }else if(list.getJyoukenSyubetsu().equals("フリー(条件なし)")){ %>
      フリー(条件なし)
      <% }else{ %>
      ERROR
      <% } %>
      &nbsp;</td>
      <td><%=list.getKakikomiJyougen() %>回&nbsp;</td>
      <td>
      <form action="/G-pro_Service/GRon_SyousaiMaker" method="post">
      <input type="hidden" name="taisyoucode" value="<%=list.getKeijiban_Code()%>">
      <input type="submit" value="討論ページへ">
      </form>
      &nbsp;</td>
    </tr>
    <% } %>
  </tbody>
</table>
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/EndInfo_Logo.gif" width="418" height="52" border="0" alt="書き込みが締め切られた議題">(過去1年分)</p>
<table border="1">
  <tbody>
    <tr>
      <td>掲示板<br>
      コード&nbsp;</td>
      <td>議題&nbsp;</td>
      <td>&nbsp;開設時期</td>
      <td>開設者<br>
      プレイヤーネーム</td>
      <td>トータル<br>
      レスポンス数</td>
      <td>開設当時の<br>
      書き込み可能条件&nbsp;</td>
      <td>討論ページ<br>
      リンク&nbsp;</td>
    </tr>
    <% for(GRon_Data_TO list2 : endinfo){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(list2.getKeijiban_Code()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(list2.getGidai()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(list2.getKaisetsuNichiji()) %>~<%=HttpUtility.escapeHTML(list2.getShimekiriNichiji()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(list2.getKaisetsusya()) %>&nbsp;</td>
      <td><%=list2.getTotalRespCount() %>&nbsp;</td>
      <td><% if(list2.getJyoukenSyubetsu().equals("G-PROjectランキング上位者")){ %>
      <%=HttpUtility.escapeHTML(list2.getSc_Syubetsu()) %>の<%=HttpUtility.escapeHTML(list2.getRankJyouken()) %><br>
      ランキング<%=list2.getRank_Min() %>位以上
      <% }else if(list2.getJyoukenSyubetsu().equals("アクションスコア")){ %>
      <%=HttpUtility.escapeHTML(list2.getSc_Syubetsu()) %>のアクションスコア<br>
      <%=list2.getSc_Min() %>以上
      <% }else if(list2.getJyoukenSyubetsu().equals("レポートスコア")){ %>
      <%=HttpUtility.escapeHTML(list2.getSc_Syubetsu()) %>のレポートスコア<br>
      <%=list2.getSc_Min() %>以上
      <% }else if(list2.getJyoukenSyubetsu().equals("プレイヤーレベル")){ %>
      プレイヤーレベル<br>
      <%=list2.getPlayerLv_Min() %>以上<%=list2.getPlayerLv_Max() %>以下
      <% }else if(list2.getJyoukenSyubetsu().equals("年齢")){ %>
      年齢<br>
      <%=list2.getPlayerLv_Min() %>歳以上<%=list2.getPlayerLv_Max() %>歳以下
      <% }else if(list2.getJyoukenSyubetsu().equals("性別")){ %>
      性別：<%=list2.getSex() %>
      <% }else if(list2.getJyoukenSyubetsu().equals("フリー(条件なし)")){ %>
      フリー(条件なし)
      <% }else{ %>
     ERROR!
      <% } %>
      &nbsp;</td>
      <td>
      <form action="/G-pro_Service/GRon_SyousaiMaker" method="post">
      <input type="hidden" name="taisyoucode" value="<%= list2.getKeijiban_Code() %>">
      <input type="submit" value="討論ページへ">
      </form>
      &nbsp;</td>
    </tr>
    <% } %>
  </tbody>
</table>
<% if(seiseki.getplayer_Level() >= 20){ %>
<form action="/G-pro_Service/GRon_Kaisetsu_Uketsuke" method="post">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/ShinkiKaisetsu_Logo.gif" width="286" height="52" border="0" alt="掲示板の新規開設"></p>
<p>以下の項目をすべて入力し、「確定」をクリックしてください。</p>
<p>議題:<input size="30" type="text" maxlength="30" name="gidai" value="入力してください">(最大全角30文字)</p>
<p>最初の書き込み(開設のあいさつ、どんな理由で開設したか、期待している書き込みの内容など)<br>
<textarea rows="5" cols="50" name="1st_write">ここに入力してください</textarea><br>
(最大全角200文字)</p>
書き込み可能条件：以下から選択・入力してください<br>
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
<p>開設期間：以下から選択してください<br>
<input type="radio" checked name="kaisetsukikan" value="1週間">1週間<br>
<input type="radio" name="kaisetsukikan" value="2週間">2週間<br>
<input type="radio" name="kaisetsukikan" value="1ヶ月">1か月<br>
<input type="radio" name="kaisetsukikan" value="3ヶ月">3ヶ月<br>
※いずれも掲載開始からの期間<br>
<br>
書き込み上限回数(プレイヤー1人がこの掲示板に書き込める回数)：以下から選択してください<br>
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
<p>
<!-- <input type="image" name="submit" alt="確定" src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Kakutei.gif" width="160" height="70" border="0">-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
<% } %>　　　<!-- <a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</form>
</body>
</html>