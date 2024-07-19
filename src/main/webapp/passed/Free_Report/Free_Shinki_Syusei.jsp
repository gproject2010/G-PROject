<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="indata" scope="session" type="g_jyouhou.GS_jyouhou_TO"/>
    <%@ page import="rep_upload.Rep_Koumoku" %>
    <%@ page import="rep_upload.Free_Report_Kakunin" %>
    <jsp:useBean id="freehyouka" scope="session" type="rep_upload.Rep_Koumoku"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Free_Report/Free_Rep_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/pageusefiles/Reports.js" charset="UTF-8"></script>
<title>自由形式レポート(メニューからの新規登録用)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/free_area/Ver2_Images/GReport_Logo.gif" width="400" height="90" border="0" align="left">
<form action="/G-pro_Service/Free_Shinki_Kakunin" method="post">
<br>
<br>
　ゲームレポート添付書類<br>
<br>
<font size="+2">レポート種別：自由形式レポート・メニューから新規登録</font>
<p><a href="/G-pro_Service/free_area/Tutoreal3.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<p><br>
<%if(freehyouka.isJisu_wrong() == true){ %>
<font color="ff00ff" size="+1">字数が制限を超えている項目があります。</font><br>
<% } %>
<%if(freehyouka.isover() == true){ %>
<font color="ff00ff" size="+1">評価点数に満点を超えている項目があります。</font><br>
<% } %>
<%if(freehyouka.isfew() == true){%>
<font color="ff00ff" size="+1">評価点数にマイナスの値が入力されています。<br>
入力欄の-(ハイフン)を外してください。</font><br>
<% } %>
<%if(freehyouka.isnotscore() == true){ %>
<font color="ff00ff" size="+1">評価点数に入力されていない項目があります。</font><br>
<% } %>
<%if(freehyouka.isnotmatch() == true){ %>
<font color="ff00ff" size="+1">評価欄の合計がと自由点欄のものと一致していません。<br>
2つの値が等しくなるように、再設定してください。</font><br>
<% } %>
<% if(freehyouka.isnotOutline() == true){ %>
<font color="ff00ff" size="+1">「ゲームの概要・ストーリー」が記述されていません。</font><br>
<% } %>
<% if(freehyouka.isnotAnswer() == true){ %>
<font color="ff00ff" size="+1">	選択または入力されていない項目があります。</font><br>
<% } %>
<% if(freehyouka.isnofile() == true){ %>
<font color="ff00ff" size="+1">提出するレポートデータが指定されていません。</font><br>
<% } %>
<% if(freehyouka.iswrong() == true){%>
<font color="red" size="+1">不正な値が入力されている項目があります。</font><br>
<% } %>
<% if(freehyouka.getNGWord() != null){ %>
<font color="red" size="+1">記述内容に禁止ワード(公開できない単語)が含まれています。<br>
(ヒットした入力値:<%=freehyouka.getNGWord() %>)訂正して再試行してください。</font><br>
<% } %>
<br>
ゲームタイトル：<br>
<input size="100" type="text" maxlength="50" name="Gametitle" value="<%=HttpUtility.escapeHTML(indata.getGametitle()) %>"><br>
※正式タイトルで入力してください<br>
<br>
発売メーカー:<input size="30" type="text" maxlength="15" name="Makername" value="<%=HttpUtility.escapeHTML(indata.getMakername()) %>"><br>
<br>
<br>
発売年月日(もう一度入力してください)　※最初に入力した発売年月日：<%=HttpUtility.escapeHTML(indata.getHatsubainengappi()) %><br>
　　西暦<input size="5" type="text" name="hatsubainen" value="0001">年<select name="hatsubaitsuki">
  <option value="1" selected>1</option>
  <option value="2">2</option>
  <option value="3">3</option>
  <option value="4">4</option>
  <option value="5">5</option>
  <option value="6">6</option>
  <option value="7">7</option>
  <option value="8">8</option>
  <option value="9">9</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
</select>月<select name="hatsubaibi">
  <option value="01"selected>01</option>
  <option value="02">02</option>
  <option value="03">03</option>
  <option value="04">04</option>
  <option value="05">05</option>
  <option value="06">06</option>
  <option value="07">07</option>
  <option value="08">08</option>
  <option value="09">09</option>
  <option value="10">10</option>
  <option value="11">11</option>
  <option value="12">12</option>
  <option value="13">13</option>
  <option value="14">14</option>
  <option value="15">15</option>
  <option value="16">16</option>
  <option value="17">17</option>
  <option value="18">18</option>
  <option value="19">19</option>
  <option value="20">20</option>
  <option value="21">21</option>
  <option value="22">22</option>
  <option value="23">23</option>
  <option value="24">24</option>
  <option value="25">25</option>
  <option value="26">26</option>
  <option value="27">27</option>
  <option value="28">28</option>
  <option value="29">29</option>
  <option value="30">30</option>
  <option value="31">31</option>
</select>日
<br>
<br>
プラットフォーム(もう一度入力してください)　※最初に入力したプラットフォーム：<%=HttpUtility.escapeHTML(indata.getPlatform()) %><br>
<b><input type="radio" name="Platform" value="ファミリーコンピュータ(ディスクシステム含む)">ファミリーコンピュータ(ディスクシステム含む)<br>
<input type="radio" name="Platform" value="スーパーファミコン">スーパーファミコン<br>
<input type="radio" name="Platform" value="バーチャルボーイ">バーチャルボーイ　　　　　　　　　<input type="radio" name="Platform" value="セガサターン">セガサターン　　　　　　　<input type="radio" name="Platform" value="メガドライブ">メガドライブ<br>
<input type="radio" name="Platform" value="ゲームボーイ">ゲームボーイ　　　　　　　　　　　 <input type="radio" name="Platform" value="ドリームキャスト">ドリームキャスト　　　　　 <input type="radio" name="Platform" value="ゲームギア">ゲームギア<br>
<input type="radio" name="Platform" value="ゲームボーイアドバンス">ゲームボーイアドバンス　　　　　 <input type="radio" name="Platform" value="プレイステーション">プレイステーション　　　　<input type="radio" name="Platform" value="PC-FX">PC-FX<br>
<input type="radio" name="Platform" value="ニンテンドウ64">ニンテンドウ64　　　　　　　　　　 <input type="radio" name="Platform" value="プレイステーション2">プレイステーション2　　　<input type="radio" name="Platform" value="ネオジオ">ネオジオ<br>
<input type="radio" name="Platform" value="ニンテンドーゲームキューブ">ニンテンドーゲームキューブ　　　<input type="radio" name="Platform" value="プレイステーション3">プレイステーション3　　　<input type="radio" name="Platform" value="ネオジオポケット">ネオジオポケット<br>
<input type="radio" name="Platform" value="Wii">Wii　　　<input type="radio" name="Platform" value="Wii_U">Wii_U　　　<input type="radio" name="Platform" value="PSP">PSP(go含む)　　　　　　 <input type="radio" name="Platform" value="3DO">３DO<br>
<input type="radio" name="Platform" value="ニンテンドーDS">ニンテンドーDS(Lite/DSiなどを含む)　　　　　 <input type="radio" name="Platform" value="Xbox">Xbox　　　　　　　　　　　　<input type="radio" name="Platform" value="ワンダースワン">ワンダースワン<br>
<input type="radio" name="Platform" value="ニンテンドー3DS">ニンテンドー3DS(LLを含む)　　　　　　　　　 <input type="radio" name="Platform" value="Xbox360">Xbox360<br>
<input type="radio" name="Platform" value="PS_Vita">PS Vita（ヴィータ）　　　　　　　　　　　　<input type="radio" name="Platform" value="プレイステーション4">プレイステーション4　　　　　<input type="radio" name="Platform" value="Xbox_One">Xbox_One<br>
<input type="radio" name="Platform" value="iOS端末">iOS端末(iPhone,iPad)　　　　　　　　　　<input type="radio" name="Platform" value="Android端末">Android端末　　　　　<input type="radio" name="Platform" value="アーケードゲーム">アーケードゲーム　　　<input type="radio" name="Platform" value="その他">その他<br>
</b>
<b><br>
メインジャンル(もう一度入力してください)　※最初に入力したメインジャンル：<%=HttpUtility.escapeHTML(indata.getMaingenre()) %></b>
<p><b>　　<input type="radio" name="Maingenre" value="アクション">アクション　<input type="radio" name="Maingenre" value="ロールプレイング">ロールプレイング　　<input type="radio" name="Maingenre" value="パズル">パズル　　　 <input type="radio" name="Maingenre" value="シューティング">シューティング　　　<input type="radio" name="Maingenre" value="対戦アクション">対戦アクション<br>
<br>
　　<input type="radio" name="Maingenre" value="FPS（一人称視点のシューティング・ガンシューティング）">FPS（一人称視点のシューティング・ガンシューティング）　　　<input type="radio" name="Maingenre" value="ドライビングシュミレータ">ドライビングシミュレータ<br>
<br>
　　<input type="radio" name="Maingenre" value="アドベンチャー">アドベンチャー　　　<input type="radio" name="Maingenre" value="ノベルティ">ノベルティ　　　<input type="radio" name="Maingenre" value="リズムアクション・音楽ゲーム">リズムアクション・音楽ゲーム<br>
<br>
　　<input type="radio" name="Maingenre" value="多人数参加型ロールプレイング">多人数参加型ロールプレイング　　　<input type="radio" name="Maingenre" value="ゲーム作成ツール">ゲーム作成ツール(RPGツクールなど)<br>
<br>
　　<input type="radio" name="Maingenre" value="恋愛シュミレーション・育成シュミレーション・目標達成型シュミレーション">恋愛シミュレーション、育成シミュレーション、目標達成型シミュレーション　　　<input type="radio" name="Maingenre" value="ファンディスク">ファンディスク<br>
<br>
　　<input type="radio" name="Maingenre" value="戦略シュミレーション・ストラテジー・カードゲーム">戦略シミュレーション、ストラテジー、カードゲーム　　　<input type="radio" name="Maingenre" value="ウォーシュミレーション">ウォーシミュレーション<br>
<br>
　　<input type="radio" name="MainGenre" value="職ゲー">職ゲー　　　<input type="radio" name="Maingenre" value="その他シュミレーション">その他シミュレーション　<input type="radio" name="Maingenre" value="ミニゲーム集">ミニゲーム集　　　<input type="radio" name="Maingenre" value="スポーツ">スポーツ　　　<br>
<br>
　　<input type="radio" name="Maingenre" value="戦略型テーブルゲーム（将棋・チェス・オセロなど）">戦略型テーブルゲーム（将棋・チェス・オセロなど）　<input type="radio" name="Maingenre" value="ギャンブル型テーブルゲーム（トランプ・花札・麻雀など）">ギャンブル型テーブルゲーム（トランプ、花札、麻雀など）<br>
<br>
　　<input type="radio" name="Maingenre" value="スゴロク">スゴロク　　　<input type="radio" name="Maingenre" value="クイズ・その他テーブルゲーム">クイズ・その他テ－ブルゲーム　　　<input type="radio" name="Maingenre" value="生活ツール・データベース">生活ツール・データベース　　　<input type="radio" name="Maingenre" value="教育ツール">教育ツール<br>
<br>
　　<input type="radio" name="Maingenre" value="コミュニケーションツール">コミュニケーションツール　　　　<input type="radio" name="Maingenre" value="その他">その他　　</b>

<br>
評価点数(必須)※整数または第2位までの小数で入力してください。
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;評価項目</td>
      <td>評価点&nbsp;</td>
      <td align="center">満点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;難易度の適正度</td>
      <td>
      <input size="4" type="text" maxlength="4" name="difficulty" value="<%=freehyouka.getdificultty() %>" id="dificultty" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td>
      <input size="4" type="text" maxlength="4" name="story" value="<%=freehyouka.getstory() %>" id="story" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td>
      <input size="4" type="text" maxlength="4" name="graphic" value="<%=freehyouka.getgraphic() %>" id="graphic" class="score">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td>
      <input size="4" type="text" maxlength="4" name="sound" value="<%=freehyouka.getsound() %>" id="sound" class="score">点
      </td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td>
      <input size="4" type="text" maxlength="4" name="volume" value="<%=freehyouka.getvolume() %>" id="volume" class="score">点
      </td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td>
      <input size="4" type="text" maxlength="4" name="controll" value="<%=freehyouka.getcontroll() %>" id="controll" class="score">点
      </td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td>
      <input size="4" type="text" maxlength="4" name="promotion" value="<%=freehyouka.getpromotion() %>" id="promotion" class="score">点
      </td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td>
      
      <input size="5" type="text" maxlength="5" name="free_s" value="<%=freehyouka.getfree_S() %>" id="jiyuten_set" class="score">点
      </td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td>
      <span id="totalscore_hyouji">---</span>点
      <input size="6" type="hidden" maxlength="6" name="total" value="<%=freehyouka.gettotal() %>" id="totalscore_set">
      </td>
      <td>&nbsp;/100点</td>
    </tr>
  </tbody>
</table>
※トータル点数は自動で計算されます。
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
      <td><input size="20" type="text" name="jiyuten_koumoku1" value="<%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku1()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score1" value="<%=freehyouka.getjiyuten_score1() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore1" value="<%=freehyouka.getjiyuten_maxscore1() %>">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku2" value="<%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku2()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score2" value="<%=freehyouka.getjiyuten_score2() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore2" value="<%=freehyouka.getjiyuten_maxscore2() %>">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku3" value="<%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku3()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score3" value="<%=freehyouka.getjiyuten_score3() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore3" value="<%=freehyouka.getjiyuten_maxscore3() %>">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku4" value="<%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku4()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score4" value="<%=freehyouka.getjiyuten_score4() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore4" value="<%=freehyouka.getjiyuten_maxscore4() %>">点</td>
    </tr>
    <tr>
      <td><input size="20" type="text" name="jiyuten_koumoku5" value="<%=HttpUtility.escapeHTML(freehyouka.getjiyuten_koumoku5()) %>"></td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_score5" value="<%=freehyouka.getjiyuten_score5() %>">点</td>
      <td>&nbsp;<input size="5" type="text" maxlength="5" name="jiyuten_maxscore5" value="<%=freehyouka.getjiyuten_maxscore5() %>">点</td>
    </tr>
    <tr>
      <td>&nbsp;自由点トータル</td>
      <td align="center">
	<span id="jiyuten_totalscore_hyouji"><%=freehyouka.getjiyuten_scoretotal() %></span>点
      <input size="6" type="hidden" maxlength="6" name="total" value="<%=freehyouka.getjiyuten_scoretotal() %>" id="jiyuten_totalscore_set">
	</td>
      <td align="center"><span id="jiyuten_maxtotalscore_hyouji"><%=freehyouka.getjiyuten_maxscoretotal() %></span>点
      <input size="6" type="hidden" maxlength="6" name="total" value="<%=freehyouka.getjiyuten_maxscoretotal() %>" id="jiyuten_maxtotalscore_set">
</td>
    </tr>
  </tbody>
</table>
※満点の合計が30点ちょうどになるように設定してください(<span id="jiyuten_maxtotal">---</span>)<br>
※評価項目は最大全角20文字まで
<br>
<p>
ゲームの概要・ストーリー(必須)<br>
<textarea rows="5" cols="100" name="outline" id="count_area1" maxlength="500"></textarea><br>
※最大全角500文字以内(あと<span id="mojisu1">---</span>文字)</p>
<p>購入方法<%if(freehyouka.isnotAnswer() == true){%>(もう一度入力してください)<% } %>：このゲームをどのように入手しましたか?以下から選んでください。(必須)<br>
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
<br>
<br>
<p><br>
共通インタビュー項目<%if(freehyouka.isnotAnswer() == true){%>(もう一度入力してください)<% } %><br>
<br>
Q1:このゲームをプレーすることを希望している人は誰ですか？<br>
該当する人すべてにチェックを入れてください。<br>
<br>
<%if(freehyouka.isnotAnswer() == true){ %>
<input type="checkbox" name="Interview1" value="あなた本人">あなた本人<br>
<input type="checkbox" name="Interview1" value="父親・母親">父親・母親<br>
<input type="checkbox" name="Interview1" value="兄弟・姉妹">兄弟・姉妹<br>
<input type="checkbox" name="Interview1" value="子ども(息子・娘)">子ども(息子・娘)<br>
<input type="checkbox" name="Interview1" value="その他家族(親戚など)">その他家族(親戚など)<br>
<input type="checkbox" name="Interview1" value="友達">友達<br>
<input type="checkbox" name="Interview1" value="その他">その他<br>
<%}else{%>
あなたの回答：<%for(String Inter1 : freehyouka.getInterview1()){ %><%=HttpUtility.escapeHTML(Inter1) + ", " %><br>
<% } %>
<% } %>
<br>
Q2:このゲームがプレーできることをもっとも心待ちにしていた人は誰ですか？<br>
1つだけ選んでください。(必須)<br>
<br>
<%if(freehyouka.isnotAnswer() == true){ %>
<input type="radio" name="Interview2" value="あなた本人">あなた本人<br>
<input type="radio" name="Interview2" value="父親・母親">父親・母親<br>
<input type="radio" name="Interview2" value="兄弟・姉妹">兄弟・姉妹<br>
<input type="radio" name="Interview2" value="子ども(息子・娘)">子ども(息子・娘)<br>
<input type="radio" name="Interview2" value="その他家族(親戚など)">その他家族(親戚など)<br>
<input type="radio" name="Interview2" value="友達">友達<br>
<input type="radio" name="Interview2" value="その他">その他<br>
<% }else{ %>
あなたの回答：<%=HttpUtility.escapeHTML(freehyouka.getInterview2()) %>
<% } %>
<br>
Q3:このゲームに関する情報で、見聞きしたことのあるものすべてにチェックを入れてください。<br>
<br>
<%if(freehyouka.isnotAnswer() == true){ %>
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
<% }else{ %>
あなたの回答:<% for(String inter3 : freehyouka.getInterview3()){ %><%= HttpUtility.escapeHTML(inter3) + ", " %><br>
<% } %>
<% } %>
<br>
<br>
Q4:このゲームに関する情報で、購入の最大の決め手となったものを1つ選んでください。(必須)<br>
<br>
<%if(freehyouka.isnotAnswer() == true){ %>
<input type="radio" name="Interview4" value="テレビのCM">テレビのCM<br>
<input type="radio" name="Interview4" value="ゲーム雑誌">ゲーム雑誌<br>
<input type="radio" name="Interview4" value="ゲーム誌以外の雑誌・新聞">ゲーム誌以外の雑誌・新聞<br>
<input type="radio" name="Interview4" value="ゲーム機メーカーのHP">ゲーム機メーカーのHP<br>
<input type="radio" name="Interview4" value="ゲームソフトのメーカーのHP">ゲームソフトのメーカーのHP<br>
<input type="radio" name="Interview3" value="ゲームに関するニュースサイト">ゲーム関係のニュースサイト<br>
<input type="radio" name="Interview3" value="ゲーム関係以外のニュースサイト">ゲーム関係以外のニュースサイト<br>
<input type="radio" name="Interview4" value="SNS(mixi・ツイッターなど)">SNS(mixi・ツイッターなど)<br>
<input type="radio" name="Interview4" value="SNS以外の掲示板・ブログ">SNS以外の掲示板・ブログ<br>
<input type="radio" name="Interview4" value="ゲーム機のインターネットサービス">ゲーム機のインターネットサービス（Wiiの”みんなのニンテンドーチャンネル”など)<br>
<input type="radio" name="Interview4" value="家族や友人からの口コミ">家族や友人からの口コミ<br>
<input type="radio" name="Interview4" value="新聞の折り込みチラシ">新聞の折り込みチラシ<br>
<input type="radio" name="Interview4" value="お店の商品パッケージやチラシ、パンフレット">お店の商品パッケージやチラシ、パンフレット<br>
<input type="radio" name="Interview4" value="お店などで行われている試遊台や体験版のダウンロードサービス">お店などで行われている試遊台や体験版のダウンロードサービス<br>
<input type="radio" name="Interview3" value="前作をプレーして">前作をプレーして(シリーズ・続編の場合)<br>
<input type="radio" name="Interview4" value="ゲームに関するイベント(東京ゲームショウなど)">ゲームに関するイベント(東京ゲームショウなど)<br>
<input type="radio" name="Interview4" value="ゲームとは直接関係しないイベント">ゲームとは直接関係しないイベント<br>
<input type="radio" name="Interview4" value="よく覚えていない">よく覚えていない<br>
<input type="radio" name="Interview4" value="その他">その他<br>
<% }else{ %>
あなたの回答：<%=HttpUtility.escapeHTML(freehyouka.getInterview4()) %>
<% } %>
<br>
<br>Q5:このゲームを購入した理由として当てはまるものすべてにチェックを入れてください。(必須)<br>
<br>
<%if(freehyouka.isnotAnswer() == true){ %>
<input type="checkbox" name="Interview5" value="プロモーションを見て欲しいと思った">プロモーションを見て欲しいと思った<br>
<input type="checkbox" name="Interview5" value="ほかの人がプレイしているところを見て欲しいと思った">ほかの人がプレイしているところを見て欲しいと思った<br>
<input type="checkbox" name="Interview5" value="好きなキャラクターが登場しているから">好きなキャラクターが登場しているから<br>
<input type="checkbox" name="Interview5" value="世界観やストーリーが好き">世界観やストーリーが好き<br>
<input type="checkbox" name="Interview5" value="制作したメーカーや開発チームに期待して">制作したメーカーや開発チームに期待して<br>
<input type="checkbox" name="Interview5" value="好きなシリーズの作品だから">好きなシリーズの作品だから<br>
<input type="checkbox" name="Interview5" value="価格が手ごろだったから">価格が手ごろだったから<br>
<input type="checkbox" name="Interview5" value="大会の参加・研究用として">大会の参加・研究用として<br>
<input type="checkbox" name="Interview5" value="なんとなく">なんとなく<br>
<input type="checkbox" name="Interview5" value="その他">その他<input size="30" type="text" name="Interview5_etc" value="ここに入力してください"><br>
<% }else{ %>
あなたの回答:<% for(String inter5 : freehyouka.getInterview5()){ %><%= HttpUtility.escapeHTML(inter5) + ", " %><br>
<% } %>
<% } %>
<br>
Q6:ズバリ、このゲームのシリーズや続編が発売されたらプレーしますか？<br>
<br>
<% if(freehyouka.isnotAnswer() == true){ %>
<input type="radio" name="Interview6" value="絶対にプレーすると思う">絶対にプレーすると思う<br>
<input type="radio" name="Interview6" value="たぶんプレーすると思う">たぶんプレーすると思う<br>
<input type="radio" name="Interview6" value="内容による">内容による<br>
<input type="radio" name="Interview6" value="プレーすることはないと思う">プレーすることはないと思う<br>
<input type="radio" name="Interview6" value="絶対にプレーしないと思う">絶対にプレーしないと思う<br>
<input type="radio" name="Interview6" value="今の状況では何とも言えない">今の状況では何とも言えない<br>
<% }else{ %>
あなたの回答：<%=HttpUtility.escapeHTML(freehyouka.getInterview6()) %>
<% } %>
<br>
<br>
<font color="#0000ff">※レポートの登録を中止するにはブラウザの「閉じる」ボタンをクリックしてください</font>
<!-- <p align="center"><input type="image" alt="確定" name="submit" src="/G-pro_Service/image/Kakutei_Button.gif" width="61" height="48" border="0"></p><br>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
</form>
</body>
</html>