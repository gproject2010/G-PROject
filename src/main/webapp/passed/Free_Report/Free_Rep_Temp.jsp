<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO"/>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Free_Report/Free_Rep_Temp.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/pageusefiles/Reports.js" charset="UTF-8"></script>
<title>自由形式レポート(ゲーム情報からの登録用)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left">　　　　<font size="+2">　<br>
<br>
　ゲームレポート添付書類<br>
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
<p>
<br>
評価点数(必須)※整数または第2位までの小数で入力してください。</p>
<form action="/G-pro_Service/Free_Report_Kakunin" method="post">
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
      <input size="5" type="text" maxlength="5" name="difficulty" value="0" id="dificultty" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td>
      <input size="5" type="text" maxlength="5" name="story" value="0" id="story" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td>
      <input size="5" type="text" maxlength="5" name="graphic" value="0" id="graphic" class="score">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td>
      <input size="5" type="text" maxlength="5" name="sound" value="0" id="sound" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td>
      <input size="5" type="text" maxlength="5" name="volume" value="0" id="volume" class="score">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td>
      <input size="5" type="text" maxlength="5" name="controll" value="0" id="controll" class="score">点
      </td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td>
      <input size="5" type="text" maxlength="5" name="promotion" value="0" id="promotion" class="score">点
      </td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td>
      <span id="jiyuten_hyouji">---</span>点
      <input size="6" type="hidden" maxlength="6" name="free_s" value="0" id="jiyuten_set" class="score">
      </td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td>
      <span id="totalscore_hyouji">---</span>点
      <input size="6" type="hidden" maxlength="6" name="total" value="0" id="totalscore_set">
      </td>
      <td>&nbsp;/100点</td>
    </tr>
  </tbody>
</table>
※トータル点数は自動で計算されます。
<br>
<p>
自由点評価<br>
<table border="1">
  <tbody>
    <tr>
      <td>評価項目&nbsp;</td>
      <td>評価点&nbsp;</td>
      <td>満点&nbsp;</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku1"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score1" value="0" id="jiyuten_score1" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore1" value="0" id="jiyuten_maxscore1" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku2"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score2" value="0" id="jiyuten_score2" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore2" value="0" id="jiyuten_maxscore2" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku3"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score3" value="0" id="jiyuten_score3" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore3" value="0" id="jiyuten_maxscore3" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku4"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score4" value="0" id="jiyuten_score4" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore4" value="0" id="jiyuten_maxscore4" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku5"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score5" value="0" id="jiyuten_score5" class="score">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore5" value="0" id="jiyuten_maxscore5" class="jiyuten_maxscore">点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">
	<span id="jiyuten_totalscore_hyouji">---</span>点
      <input size="6" type="hidden" maxlength="6" name="jiyuten_total" value="0" id="jiyuten_totalscore_set">
	</td>
      <td align="center"><span id="jiyuten_maxtotalscore_hyouji">---</span>点
      <input size="6" type="hidden" maxlength="6" name="jiyuten_maxtotal" value="0" id="jiyuten_maxtotalscore_set">
</td>
    </tr>
  </tbody>
</table>
※満点の合計が30点ちょうどになるように設定してください(<span id="jiyuten_maxtotal">---</span>)<br>
※評価項目は最大全角20文字まで
<p>
<p>
ゲームの概要・ストーリー(必須)<br>
<textarea rows="5" cols="100" name="outline" id="count_area1" maxlength="500"></textarea><br>
※最大全角500文字以内(あと<span id="mojisu1">---</span>文字)</p>
<br>
<p>購入方法：このゲームをどのように入手しましたか?以下から選んでください。<br>
<br>
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
</p>
<br>
<p><br>
共通インタビュー項目<br>
<br>
Q1:このゲームをプレーすることを希望している人は誰ですか？<br>
該当する人すべてにチェックを入れてください。<br>
<br>
<input type="checkbox" name="Interview1" value="あなた本人">あなた本人<br>
<input type="checkbox" name="Interview1" value="父親・母親">父親・母親<br>
<input type="checkbox" name="Interview1" value="兄弟・姉妹">兄弟・姉妹<br>
<input type="checkbox" name="Interview1" value="子ども(息子・娘)">子ども(息子・娘)<br>
<input type="checkbox" name="Interview1" value="その他家族(親戚など)">その他家族(親戚など)<br>
<input type="checkbox" name="Interview1" value="友達">友達<br>
<input type="checkbox" name="Interview1" value="その他">その他<br>
<br>
Q2:このゲームがプレーできることをもっとも心待ちにしていた人は誰ですか？<br>
1つだけ選んでください。(必須)<br>
<br>
<input type="radio" name="Interview2" value="あなた本人">あなた本人<br>
<input type="radio" name="Interview2" value="父親・母親">父親・母親<br>
<input type="radio" name="Interview2" value="兄弟・姉妹">兄弟・姉妹<br>
<input type="radio" name="Interview2" value="子ども(息子・娘)">子ども(息子・娘)<br>
<input type="radio" name="Interview2" value="その他家族(親戚など)">その他家族(親戚など)<br>
<input type="radio" name="Interview2" value="友達">友達<br>
<input type="radio" name="Interview2" value="その他">その他<br>
<br>
Q3:このゲームに関する情報で、見聞きしたことのあるものすべてにチェックを入れてください。<br>
(最低1つチェックが必要です)<br>
<br>
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
<input type="checkbox" name="Interview3" value="前作をプレーして">前作をプレーして(シリーズ・続編の場合)<br>
<input type="checkbox" name="Interview3" value="お店などで行われている試遊台や体験版のダウンロードサービス">お店などで行われている試遊台や体験版のダウンロードサービス<br>
<input type="checkbox" name="Interview3" value="ゲームに関するイベント(東京ゲームショウなど)">ゲームに関するイベント(東京ゲームショウなど)<br>
<input type="checkbox" name="Interview3" value="ゲームとは直接関係しないイベント">ゲームとは直接関係しないイベント<br>
<input type="checkbox" name="Interview3" value="その他">その他
<br>
<br>
Q4:このゲームに関する情報で、購入の最大の決め手となったものを1つ選んでください。(必須)<br>
<br>
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
<input type="radio" name="Interview4" value="前作をプレーして">前作をプレーして(シリーズ・続編の場合)<br>
<input type="radio" name="Interview4" value="ゲームに関するイベント(東京ゲームショウなど)">ゲームに関するイベント(東京ゲームショウなど)<br>
<input type="radio" name="Interview4" value="ゲームとは直接関係しないイベント">ゲームとは直接関係しないイベント<br>
<input type="radio" name="Interview4" value="よく覚えていない">よく覚えていない<br>
<input type="radio" name="Interview4" value="その他">その他<br>
<br>
Q5:このゲームを購入した理由として当てはまるものすべてにチェックを入れてください。<br>
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
<br>
Q6:ズバリ、このゲームのシリーズや続編が発売されたらプレーしますか？<br>
<br>
<input type="radio" name="Interview6" value="絶対にプレーすると思う">絶対にプレーすると思う<br>
<input type="radio" name="Interview6" value="たぶんプレーすると思う">たぶんプレーすると思う<br>
<input type="radio" name="Interview6" value="内容による">内容による<br>
<input type="radio" name="Interview6" value="プレーすることはないと思う">プレーすることはないと思う<br>
<input type="radio" name="Interview6" value="絶対にプレーしないと思う">絶対にプレーしないと思う<br>
<input type="radio" name="Interview6" value="今の状況では何とも言えない">今の状況では何とも言えない<br>
<br>
<br>
<!-- <p align="center"><input type="image" src="/G-pro_Service/image/Kakutei_Button.gif" alt="確定" name="submit" width="61" height="48" border="0"><a href="/G-pro_Service/passed/G_SeachResult.jsp"><img src="/G-pro_Service/passed/GData_Images/BacktoSerchResult.gif" width="125" height="42" border="0" alt="検索結果に戻る"></a>　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/GData_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p><br>-->
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