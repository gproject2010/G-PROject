<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="rep_upload.Marubatsu_Report_Kakunin" %>
    <jsp:useBean id="hyouka" scope="session" type="rep_upload.Rep_Koumoku"/>  
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO"/>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/OX_Report/MaruBatsu_Rep_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/pageusefiles/Reports.js" charset="UTF-8"></script>
<title>○×レポート(ゲーム検索からの登録用)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left"><br>
<br>
<br>
<font size="+2">レポート種別：○×レポート・ゲーム情報から登録</font></p>
<p><a href="/G-pro_Service/free_area/Tutoreal3.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<form action="/G-pro_Service/Marubatsu_Report_Kakunin" method="post">
<p><br>
<%if(hyouka.isJisu_wrong()){ %>
<font color="ff00ff" size="+1">文字数が制限を超えている項目があります。</font><br>
<% } %>
<%if(hyouka.isover() == true){ %>
<font color="ff00ff" size="+1">評価点数に満点を超えている項目があります。</font><br>
<% } %>

<%if(hyouka.isfew() == true){%>
<font color="ff00ff" size="+1">評価点数にマイナスの値が入力されています。<br>
入力欄の-(ハイフン)を外してください。</font><br>
<% } %>

<%if(hyouka.isnotscore() == true){ %>
<font color="ff00ff" size="+1">評価点数に入力されていない項目があります。</font><br>
<% } %>

<%if(hyouka.isnotmatch() == true){ %>
<font color="ff00ff" size="+1">評価欄の合計がと自由点欄のものと一致していません。<br>
2つの値が等しくなるように、再設定してください。</font><br>
<% } %>

<% if(hyouka.isnotOutline() == true){ %>
<font color="ff00ff" size="+1">「ゲームの概要・ストーリー」が記述されていません。</font><br>
<% } %>

<% if(hyouka.isnotGoodies() == true){ %>
<font color="ff00ff" size="+1">「このゲームの良かった所」の欄が記述されていません。</font><br>
<% } %>

<% if(hyouka.isnotAnswer() == true){ %>
<font color="ff00ff" size="+1">選択もしくは入力されていないところがあります。</font><br>
<% } %>

<% if(hyouka.iswrong() == true){%>
<font color="red" size="+1">不正な値が入力されている項目があります。</font><br>
<% } %>

<% if(hyouka.getNGWord() != null){ %>
<font color="red" size="+1">記述内容に禁止ワード(公開できない単語)が含まれています。<br>
(ヒットした入力値:<%=hyouka.getNGWord() %>)訂正して再試行してください。</font><br>
<% } %>
<br>
ゲームタイトル：<br>
<%=HttpUtility.escapeHTML(syousai.getGametitle()) %><br>
<br>
発売メーカー:<%=HttpUtility.escapeHTML(syousai.getMakername()) %><br>
<br>
発売年月日：<%=HttpUtility.escapeHTML(syousai.getHatsubainengappi()) %><br>
<br>
メインジャンル：<%=HttpUtility.escapeHTML(syousai.getMaingenre()) %>　　　　　サブジャンル１：<%=HttpUtility.escapeHTML(syousai.getSubgenre1()) %><br>
<br>
サブジャンル2：<%=HttpUtility.escapeHTML(syousai.getSubgenre2()) %>　　　　　プラットフォーム：<%=HttpUtility.escapeHTML(syousai.getPlatform()) %><br>
<br>
評価点数(必須)※整数または第2位以内の小数で入力してください</p>
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
      <input size="5" type="text" maxlength="5" name="difficulty" value="<%=hyouka.getdificultty() %>" id="dificultty" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td>
      <input size="5" type="text" maxlength="5" name="story" value="<%=hyouka.getstory() %>" id="story" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td>
      <input size="5" type="text" maxlength="5" name="graphic" value="<%=hyouka.getgraphic() %>" id="graphic" class="score">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td>
      <input size="5" type="text" maxlength="5" name="sound" value="<%=hyouka.getsound() %>" id="sound" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td>
      <input size="5" type="text" maxlength="4" name="volume" value="<%=hyouka.getvolume() %>" id="volume" class="score">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td>
      <input size="5" type="text" maxlength="5" name="controll" value="<%=hyouka.getcontroll() %>" id="controll" class="score">点
      </td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td>
      <input size="5" type="text" maxlength="5" name="promotion" value="<%=hyouka.getpromotion() %>" id="promotion" class="score">点
      </td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td>
      <span id="jiyuten_hyouji">---</span>点
      <input size="6" type="hidden" maxlength="6" name="free_s" value="<%=hyouka.getfree_S() %>" id="jiyuten_set" class="score">点
      </td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td>
      <span id="totalscore_hyouji"><%=hyouka.gettotal() %></span>点
      <input size="6" type="hidden" maxlength="6" name="total" value="<%=hyouka.gettotal() %>" id="totalscore_set">
      </td>
      <td>&nbsp;/100点</td>
    </tr>
  </tbody>
</table>
※トータル点数は自動で計算されます。
<br>
<br>
自由点評価
<table border="1">
  <tbody>
    <tr>
      <td>評価項目&nbsp;</td>
      <td>評価点&nbsp;</td>
      <td>満点&nbsp;</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku1" value="<%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku1()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score1" value="<%=hyouka.getjiyuten_score1() %>" id="jiyuten_score1" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore1" value="<%=hyouka.getjiyuten_maxscore1() %>" id="jiyuten_maxscore1" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku2" value="<%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku2()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score2" value="<%=hyouka.getjiyuten_score2() %>" id="jiyuten_score2" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore2" value="<%=hyouka.getjiyuten_maxscore2() %>" id="jiyuten_maxscore2" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku3" value="<%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku3()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score3" value="<%=hyouka.getjiyuten_score3() %>" id="jiyuten_score3" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore3" value="<%=hyouka.getjiyuten_maxscore3() %>" id="jiyuten_maxscore3" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku4" value="<%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku4()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score4" value="<%=hyouka.getjiyuten_score4() %>" id="jiyuten_score4" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore4" value="<%=hyouka.getjiyuten_maxscore4() %>" id="jiyuten_maxscore4" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku5" value="<%=HttpUtility.escapeHTML(hyouka.getjiyuten_koumoku5()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score5" value="<%=hyouka.getjiyuten_score5() %>" id="jiyuten_score5" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore5" value="<%=hyouka.getjiyuten_maxscore5() %>" id="jiyuten_maxscore5" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">
	<span id="jiyuten_totalscore_hyouji"><%=hyouka.getjiyuten_scoretotal() %></span>点
      <input size="6" type="hidden" maxlength="6" name="トータル" value="<%=hyouka.getjiyuten_scoretotal() %>" id="jiyuten_totalscore_set">
	</td>
      <td align="center"><span id="jiyuten_maxtotalscore_hyouji"><%=hyouka.getjiyuten_maxscoretotal() %></span>点
      <input size="6" type="hidden" maxlength="6" name="トータル" value="<%=hyouka.getjiyuten_maxscoretotal() %>" id="jiyuten_maxtotalscore_set">
</td>
    </tr>
  </tbody>
</table>
※満点の合計が30点ちょうどになるように設定してください(<span id="jiyuten_maxtotal">---</span>)<br>
※評価項目は最大全角20文字まで
<p>
ゲームの概要・ストーリー(必須)<br>
<br>
<textarea rows="5" cols="100" name="outline" id="count_area1" maxlength="500"><%=HttpUtility.escapeHTML(hyouka.getoutline()) %></textarea><br>
※最大全角500文字以内(あと<span id="mojisu1">---</span>文字)</p>
<br>
<p>購入方法：<%if(hyouka.isnotAnswer() == true){%>(もう一度入力してください)<% } %>このゲームをどのように入手しましたか?以下から選んでください。(必須)<br>
<br>
<%if(hyouka.isnotAnswer() == true){ %>
<input type="radio" name="konyu_houhou" value="新品(限定版)を予約して購入">新品(限定版)を予約して購入<br>
<input type="radio" name="konyu_houhou" value="新品(通常版)を予約して購入">新品(通常版)を予約して購入<br>
<input type="radio" name="konyu_houhou" value="新品(限定版)を発売日に予約なしで購入">新品(限定版)を発売日に予約なしで購入<br>
<input type="radio" name="konyu_houhou" value="新品(通常版)を発売日に予約なしで購入">新品(通常版)を発売日に予約なしで購入<br>
<input type="radio" name="konyu_houhou" value="新品(限定版)を発売日後に購入">新品(限定版)を発売日後に購入<br>
<input type="radio" name="konyu_houhou" value="新品(通常版)を発売日後に購入">新品(通常版)を発売日後に購入<br>
<input type="radio" name="konyu_houhou" value="ダウンロード版を発売日に購入">ダウンロード版を発売日に購入<br>
<input type="radio" name="konyu_houhou" value="ダウンロード版を発売日後に購入">ダウンロード版を発売日後に購入<br>
<input type="radio" name="konyu_houhou" value="新品の廉価版を購入">新品の廉価版を購入<br>
<input type="radio" name="konyu_houhou" value="中古品を購入">中古品を購入<br>
<input type="radio" name="konyu_houhou" value="プレゼントとしてもらったのでよくわからない">プレゼントとしてもらったのでよくわからない<br>
<input type="radio" name="konyu_houhou" value="覚えていない">覚えていない
<%}else{ %>
あなたの回答:<%=hyouka.getKonyu_houhou() %><br>
<% } %>
</p>
<br>
<br>
共通インタビュー項目<%if(hyouka.isnotAnswer() == true){%>(もう一度入力してください)<% } %><br>
<br>
Q1:このゲームをプレーすることを希望している人は誰ですか？<br>
該当する人すべてにチェックを入れてください。<br>
<br>
<%if(hyouka.isnotAnswer() == true){ %>
<input type="checkbox" name="Interview1" value="あなた本人">あなた本人<br>
<input type="checkbox" name="Interview1" value="父親・母親">父親・母親<br>
<input type="checkbox" name="Interview1" value="兄弟・姉妹">兄弟・姉妹<br>
<input type="checkbox" name="Interview1" value="子ども(息子・娘)">子ども(息子・娘)<br>
<input type="checkbox" name="Interview1" value="その他家族(親戚など)">その他家族(親戚など)<br>
<input type="checkbox" name="Interview1" value="友達">友達<br>
<input type="checkbox" name="Interview1" value="その他">その他<br>
<%}else{%>
あなたの回答：<%for(String Inter1 : hyouka.getInterview1()){ %><%=HttpUtility.escapeHTML(Inter1) + ", " %><br>
<% } %>
<% } %>
<br>
Q2:このゲームがプレーできることをもっとも心待ちにしていた人は誰ですか？<br>
1つだけ選んでください。(必須)<br>
<br>
<%if(hyouka.isnotAnswer() == true){ %>
<input type="radio" name="Interview2" value="あなた本人">あなた本人<br>
<input type="radio" name="Interview2" value="父親・母親">父親・母親<br>
<input type="radio" name="Interview2" value="兄弟・姉妹">兄弟・姉妹<br>
<input type="radio" name="Interview2" value="子ども(息子・娘)">子ども(息子・娘)<br>
<input type="radio" name="Interview2" value="その他家族(親戚など)">その他家族(親戚など)<br>
<input type="radio" name="Interview2" value="友達">友達<br>
<input type="radio" name="Interview2" value="その他">その他<br>
<% }else{ %>
あなたの回答：<%=HttpUtility.escapeHTML(hyouka.getInterview2()) %>
<% } %>
<br>
Q3:このゲームに関する情報で、見聞きしたことのあるものすべてにチェックを入れてください。<br>
<br>
<%if(hyouka.isnotAnswer() == true){ %>
<input type="checkbox" name="Interview3" value="テレビのCM">テレビのCM<br>
<input type="checkbox" name="Interview3" value="ゲーム雑誌">ゲーム雑誌<br>
<input type="checkbox" name="Interview3" value="ゲーム誌以外の雑誌・新聞">ゲーム誌以外の雑誌・新聞<br>
<input type="checkbox" name="Interview3" value="ゲーム機メーカーのHP">ゲーム機メーカーのHP<br>
<input type="checkbox" name="Interview3" value="ゲームソフトのメーカーのHP">ゲームソフトのメーカーのHP<br>
<input type="checkbox" name="Interview3" value="ゲームに関するニュースサイト">ゲーム関係のニュースサイト<br>
<input type="checkbox" name="Interview3" value="ゲーム関係以外のニュースサイト">ゲーム関係以外のニュースサイト<br>
<input type="checkbox" name="Interview3" value="SNS(mixi・ツイッターなど)">SNS(mixi・ツイッターなど)<br>
<input type="checkbox" name="Interview3" value="SNS以外の掲示板・ブログ">SNS以外の掲示板・ブログ<br>
<input type="checkbox" name="Interview3" value="ゲーム機のインターネットサービス">ゲーム機のインターネットサービス（みんなのニンテンドーチャンネル、プレイステーション　ネットワークなど)<br>
<input type="checkbox" name="Interview3" value="家族や友人からの口コミ">家族や友人からの口コミ<br>
<input type="checkbox" name="Interview3" value="新聞の折り込みチラシ">新聞の折り込みチラシ<br>
<input type="checkbox" name="Interview3" value="お店の商品パッケージやチラシ、パンフレット">お店の商品パッケージやチラシ<br>
<input type="checkbox" name="Interview3" value="家族や友人から借りて">家族や友人から借りて<br>
<input type="checkbox" name="Interview3" value="前作をプレーして">前作をプレーして(シリーズ・続編の場合)<br>
<input type="checkbox" name="Interview3" value="お店などで行われている試遊台や体験版のダウンロードサービス">お店などで行われている試遊台や体験版のダウンロードサービス<br>
<input type="checkbox" name="Interview3" value="ゲームに関するイベント(東京ゲームショウなど)">ゲームに関するイベント(東京ゲームショウなど)<br>
<input type="checkbox" name="Interview3" value="ゲームとは直接関係しないイベント">ゲームとは直接関係しないイベント<br>
<input type="checkbox" name="Interview3" value="このゲームの元となったマンガ・アニメ・小説・ライトノベルなどを見て">このゲームの元となったマンガ・アニメ・小説・ライトノベルなどを見て<br>
<input type="checkbox" name="Interview3" value="このゲームが原作の漫画・アニメ・小説・ライトノベルなどを見て">このゲームが原作の漫画・アニメ・小説・ライトノベルなどを見て<br>
<input type="checkbox" name="Interview3" value="その他">その他
<% }else{ %>
あなたの回答:<% for(String inter3 : hyouka.getInterview3()){ %><%= HttpUtility.escapeHTML(inter3) + ", " %><br>
<% } %>
<% } %>
<br>
<br>
Q4:このゲームに関する情報で、購入の最大の決め手となったものを1つ選んでください。(必須)<br>
<br>
<%if(hyouka.isnotAnswer() == true){ %>
<input type="radio" name="Interview4" value="テレビのCM">テレビのCM<br>
<input type="radio" name="Interview4" value="ゲーム雑誌">ゲーム雑誌<br>
<input type="radio" name="Interview4" value="ゲーム誌以外の雑誌・新聞">ゲーム誌以外の雑誌・新聞<br>
<input type="radio" name="Interview4" value="ゲーム機メーカーのHP">ゲーム機メーカーのHP<br>
<input type="radio" name="Interview4" value="ゲームソフトのメーカーのHP">ゲームソフトのメーカーのHP<br>
<input type="radio" name="Interview4" value="ゲームに関するニュースサイト">ゲーム関係のニュースサイト<br>
<input type="radio" name="Interview4" value="ゲーム関係以外のニュースサイト">ゲーム関係以外のニュースサイト<br>
<input type="radio" name="Interview4" value="SNS(mixi・ツイッターなど)">SNS(mixi・ツイッターなど)<br>
<input type="radio" name="Interview4" value="SNS以外の掲示板・ブログ">SNS以外の掲示板・ブログ<br>
<input type="radio" name="Interview4" value="ゲーム機のインターネットサービス">ゲーム機のインターネットサービス（みんなのニンテンドーチャンネル、プレイステーション　ネットワークなど)<br>
<input type="radio" name="Interview4" value="家族や友人からの口コミ">家族や友人からの口コミ<br>
<input type="radio" name="Interview4" value="新聞の折り込みチラシ">新聞の折り込みチラシ<br>
<input type="radio" name="Interview4" value="お店の商品パッケージやチラシ、パンフレット">お店の商品パッケージやチラシ、パンフレット<br>
<input type="radio" name="Interview4" value="お店などで行われている試遊台や体験版のダウンロードサービス">お店などで行われている試遊台や体験版のダウンロードサービス<br>
<input type="radio" name="Interview4" value="家族や友人から借りて">家族や友人から借りて<br>
<input type="radio" name="Interview4" value="前作をプレーして">前作をプレーして(シリーズ・続編の場合)<br>
<input type="radio" name="Interview4" value="ゲームに関するイベント(東京ゲームショウなど)">ゲームに関するイベント(東京ゲームショウなど)<br>
<input type="radio" name="Interview4" value="ゲームとは直接関係しないイベント">ゲームとは直接関係しないイベント<br>
<input type="radio" name="Interview4" value="このゲームの元となったマンガ・アニメ・小説・ライトノベルなどを見て">このゲームの元となったマンガ・アニメ・小説・ライトノベルなどを見て<br>
<input type="radio" name="Interview4" value="このゲームが原作の漫画・アニメ・小説・ライトノベルなどを見て">このゲームが原作の漫画・アニメ・小説・ライトノベルなどを見て<br>
<input type="radio" name="Interview4" value="よく覚えていない">よく覚えていない<br>
<input type="radio" name="Interview4" value="その他">その他<br>
<% }else{ %>
あなたの回答：<%=HttpUtility.escapeHTML(hyouka.getInterview4()) %>
<% } %>
<br>
Q5:このゲームを購入した理由として当てはまるものすべてにチェックを入れてください。(必須)<br>
<br>
<%if(hyouka.isnotAnswer() == true){ %>
<input type="checkbox" name="Interview5" value="プロモーションを見て欲しいと思った">プロモーションを見て欲しいと思った<br>
<input type="checkbox" name="Interview5" value="ほかの人がプレイしているところを見て欲しいと思った">ほかの人がプレイしているところを見て欲しいと思った<br>
<input type="checkbox" name="Interview5" value="好きなキャラクターが登場しているから">好きなキャラクターが登場しているから<br>
<input type="checkbox" name="Interview5" value="世界観やストーリーが好き">世界観やストーリーが好き<br>
<input type="checkbox" name="Interview5" value="制作したメーカーや開発チームに期待して">制作したメーカーや開発チームに期待して<br>
<input type="checkbox" name="Interview5" value="好きなシリーズの作品だから">好きなシリーズの作品だから(シリーズ・続編の場合)<br>
<input type="checkbox" name="Interview5" value="価格が手ごろだったから">価格が手ごろだったから<br>
<input type="checkbox" name="Interview5" value="大会の参加・研究用として">大会の参加・研究用として<br>
<input type="checkbox" name="Interview5" value="なんとなく">なんとなく<br>
<input type="checkbox" name="Interview5" value="その他">その他<input size="30" type="text" name="Interview5_etc" value="ここに入力してください"><br>
<% }else{ %>
あなたの回答:<% for(String inter5 : hyouka.getInterview5()){ %><%= HttpUtility.escapeHTML(inter5) + ", " %><br>
<% } %>
<% } %>
<br>
Q6:ズバリ、このゲームのシリーズや続編が発売されたら購入しますか？<br>
<br>
<% if(hyouka.isnotAnswer() == true){ %>
<input type="radio" name="Interview6" value="絶対にプレーすると思う">絶対にプレーすると思う<br>
<input type="radio" name="Interview6" value="たぶんプレーすると思う">たぶんプレーすると思う<br>
<input type="radio" name="Interview6" value="内容による">内容による<br>
<input type="radio" name="Interview6" value="プレーすることはないと思う">プレーすることはないと思う<br>
<input type="radio" name="Interview6" value="絶対にプレーしないと思う">絶対にプレーしないと思う<br>
<input type="radio" name="Interview6" value="今の状況では何とも言えない">今の状況では何とも言えない<br>
<% }else{ %>
あなたの回答：<%=HttpUtility.escapeHTML(hyouka.getInterview6()) %>
<% } %>
<br>
<p><img src="/G-pro_Service/image/Good_Logo2.gif" width="266" height="58" border="0" alt="↑GOOD!!">このゲームの良かった所(必須)<br>
<textarea rows="5" cols="100" name="goodies" id="count_area2" maxlength="1000"><%=HttpUtility.escapeHTML(hyouka.getgoodies()) %></textarea>　<br>
※全角1000文字以内(あと<span id="mojisu2">---</span>文字)<br>
<br>
今後の課題<img src="/G-pro_Service/image/Bad_Logo2.gif" width="72" height="52" border="0" alt="Bad・・・"><br>
<textarea rows="5" cols="100" name="badies" id="count_area3" maxlength="1000"><%=HttpUtility.escapeHTML(hyouka.getbadies()) %></textarea><br>
※全角1000文字以内(あと<span id="mojisu3">---</span>文字) <br>
<br>
<br>
<p><b><font size="+2" color="#0000ff">注意:レポートは一度アップロードすると加筆・訂正は一切できません!</font></b></p>
<input type="hidden" name="shinkiflg" value="false">
<!-- <p align="center"><input type="image"  src="/G-pro_Service/image/Kakutei_Button.gif" alt="確定" name="submit" width="61" height="48" border="0">　　　<a href="/G-pro_Service/passed/G_SeachResult.jsp"><img src="/G-pro_Service/passed/GData_Images/BacktoSerchResult.gif" alt="検索結果に戻る"></a>　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/GData_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p><br>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/G_SeachResult.jsp">検索結果に戻る</a></dd>
    </dl>
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
    </dl>
</form>
</body>
</html>