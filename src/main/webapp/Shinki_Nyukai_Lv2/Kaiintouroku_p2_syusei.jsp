<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="inputUtility.HttpUtility" %>
     <%@page import="k_jyouhou.K_Touroku_TO" %>
    <%@page import="k_jyouhou.Kaiin_Touroku_Kakunin_p2" %>
    <jsp:useBean id="wrongdata_p2" scope="session" type="k_jyouhou.K_Touroku_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>会員登録</title>
</head>
<base href="/G-pro_Service/Shinki_Nyukai_Lv2/Kaiintouroku_p2_nyuryoku.html"/>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif" style="font-weight : bold;">
<form action="/G-pro_Service/Kaiin_Touroku_Kakunin_p2"  method="POST">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<ul class="bread">
<li><a href="#">Step1:注意事項の確認・メールアドレスの登録</a></li>
<li><a href="#">Step2:G-PRO ID、パスワードの登録</a></li>
<li class="current"><a href="#">Step3:プロフィール情報の登録</a></li>
<li><a href="#">登録する情報の最終確認</a></li>
<li><a href="#">利用登録の完了</a></li>
</ul>
<p><font size="+3">プロフィール情報登録(修正)</font><br>
<font size="+2"><br>
以下のフォームに必要事項を入力し、「確定」ボタンをクリックしてください。<br>
なお、このページで入力された情報が公開されることはありません。<br>
</font></p><br>
<br>
<%if(wrongdata_p2.isNoName()){ %>
<font color="red" size="+1">本名の欄が入力されていません。</font><br>
<br>
<% } %>
<%if(wrongdata_p2.isNoBirthday()){ %>
<font color="red" size="+1">生年月日が入力されていません。</font><br>
<br>
<% } %>
<%if(wrongdata_p2.isNoAddress()){ %>
<font color="red" size="+1">都道府県が入力されていません。</font><br>
<br>
<% } %>
<%if(wrongdata_p2.isNoSecret()){ %>
<font color="red" size="+1">秘密の質問が入力されていません。</font><br>
<br>
<% } %>
<%if(wrongdata_p2.isNoJob()){ %>
<font color="red" size="+1">職業が選択されていません。もう一度入力してください。</font><br>
<br>
<% } %>
<%if(wrongdata_p2.isNGHit()){ %>
<font color="red" size="+1">入力内容に禁止ワード（公開できない単語)が含まれています。(ヒットした禁止ワード:<%=wrongdata_p2.getNGWord() %>)<br>
該当する箇所を削除・修正してください。<br></font>
<br>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <td>本名(姓)(必須)：&nbsp;</td>
      <td><input size="16" type="text" maxlength="8" name="sei_kanji" value="<%=HttpUtility.escapeHTML(wrongdata_p2.getSei_Kanji()) %>">&nbsp;</td>
      <td>本名(名)(必須)：&nbsp;</td>
      <td><input size="16" type="text" name="mei_kanji" maxlength="8" value="<%=HttpUtility.escapeHTML(wrongdata_p2.getMei_Kanji()) %>">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;本名(セイ)(必須)：</td>
      <td>&nbsp;<input size="12" type="text" name="sei_kana" maxlength="12" value="<%=HttpUtility.escapeHTML(wrongdata_p2.getSei_Kana()) %>"></td>
      <td>&nbsp;本名(メイ)(必須)：</td>
      <td>&nbsp;<input size="12" type="text" name="mei_kana" maxlength="12" value="<%=HttpUtility.escapeHTML(wrongdata_p2.getMei_Kana()) %>"></td>
    </tr>
  </tbody>
</table>
<br>
※姓のみ変更できます。<br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;生年月日(もう一度入力してください)(必須)：</td>
      <td><input size="4" type="text" maxlength="4" name="birthyear">年(西暦)</td>
      <td>&nbsp;<select name="birthtsuki">
        <option value="12">12</option>
        <option value="11">11</option>
        <option value="10">10</option>
        <option value="09">9</option>
        <option value="08">8</option>
        <option value="07">7</option>
        <option value="06">6</option>
        <option value="05">5</option>
        <option value="04">4</option>
        <option value="03">3</option>
        <option value="02">2</option>
        <option value="01" selected>1</option>
      </select>月</td>
      <td>&nbsp;<select name="birthday">
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
</select>日</td>
    </tr>
  </tbody>
</table><br>
※生年月日・性別は一度登録すると原則変更できません。ご注意ください。
<br>
<p>現在の職業(もう一度選択してください)(必須)<br>
<input type="radio" name="job" value="小学生">小学生　　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="会社員">会社員<br>
<input type="radio" name="job" value="中学生">中学生　　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="自営業・自由業">自営業・自由業<br>
<input type="radio" name="job" value="高校生">高校生　　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="主婦(夫)">主婦(夫)<br>
<input type="radio" name="job" value="予備校生">予備校生　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="フリーター">フリーター<br>
<input type="radio" name="job" value="専門・専修学校生(ゲーム系)">専門・専修学校生(ゲーム系)　　　　　　　　　　　　<input type="radio" name="job" value="その他">その他<br>
<input type="radio" name="job" value="専門・専修学校生(ゲーム系以外)">専門・専修学校生(ゲーム系以外)　　　　　　　　　<input type="radio" name="job" value="答えたくない">答えたくない<br>
<input type="radio" name="job" value="大学生">大学生
</p>
<br>
<p>郵便番号(任意)：<input size="10" type="text" maxlength="10" name="addressno"><br>
※”-”（ハイフン）は入れずに入力してください。（入力例:9501234）</p><br>
<br>
<p>
住所(都道府県)(もう一度入力してください)(必須)：<br>
<select name="pref">
<option value="選択してください" selected>選択してください</option>
  <option value="北海道">北海道</option>
  <option value="青森県">青森県</option>
  <option value="秋田県">秋田県</option>
  <option value="岩手県">岩手県</option>
  <option value="山形県">山形県</option>
  <option value="宮城県">宮城県</option>
  <option value="福島県">福島県</option>
  <option value="新潟県">新潟県</option>
  <option value="栃木県">栃木県</option>
  <option value="群馬県">群馬県</option>
  <option value="茨城県">茨城県</option>
  <option value="埼玉県">埼玉県</option>
  <option value="東京都">東京都</option>
  <option value="千葉県">千葉県</option>
  <option value="神奈川県">神奈川県</option>
  <option value="山梨県">山梨県</option>
  <option value="長野県">長野県</option>
  <option value="静岡県">静岡県</option>
  <option value="富山県">富山県</option>
  <option value="岐阜県">岐阜県</option>
  <option value="愛知県">愛知県</option>
  <option value="石川県">石川県</option>
  <option value="福井県">福井県</option>
  <option value="滋賀県">滋賀県</option>
  <option value="三重県">三重県</option>
  <option value="京都府">京都府</option>
  <option value="奈良県">奈良県</option>
  <option value="和歌山県">和歌山県</option>
  <option value="大阪府">大阪府</option>
  <option value="兵庫県">兵庫県</option>
  <option value="鳥取県">鳥取県</option>
  <option value="岡山県">岡山県</option>
  <option value="島根県">島根県</option>
  <option value="広島県">広島県</option>
  <option value="山口県">山口県</option>
  <option value="香川県">香川県</option>
  <option value="徳島県">徳島県</option>
  <option value="高知県">高知県</option>
  <option value="愛媛県">愛媛県</option>
  <option value="福岡県">福岡県</option>
  <option value="佐賀県">佐賀県</option>
  <option value="長崎県">長崎県</option>
  <option value="大分県">大分県</option>
  <option value="熊本県">熊本県</option>
  <option value="宮崎県">宮崎県</option>
  <option value="鹿児島県">鹿児島県</option>
  <option value="沖縄県">沖縄県</option>
</select><br>
<br>
住所(市町村名～)(任意)：<br>
<textarea rows="2" cols="50" name="jyusyo"><%=HttpUtility.escapeHTML(wrongdata_p2.getJyusyo()) %></textarea></p>
<table border="1">
  <tbody>
    <tr>
      <td>連絡先電話番号(携帯可)(任意)：&nbsp;</td>
      <td><input size="20" type="text" name="telephone_no" maxlength="20" value="<%=HttpUtility.escapeHTML(wrongdata_p2.getTelephone_No()) %>">&nbsp;</td>
    </tr>
  </tbody>
</table><br>
※”-”（ハイフン）は入れずに入力してください。（入力例:09012349876）<br>
※住所・連絡先電話番号ともに変更できます。<br>
<br>
<br>
秘密の質問(ID・パスワードを忘れた場合に必要となります。あなただけが分かることを入力してください)(必須)<br>
<br>
質問:<input size="30" type="text" name="secret_question" value="<%=HttpUtility.escapeHTML(wrongdata_p2.getSecret_Question()) %>"><br>
<br>
答え:<input size="30" type="text" name="secret_answer" value="<%=HttpUtility.escapeHTML(wrongdata_p2.getSecret_Answer()) %>"><br>
<br>
※1:照合する際、文字列として完全に一致しないと確認できません。はっきりと覚えているものを使用してください。<br>
※2:質問とそれに対する答えとして成立していない場合、変更登録ができないことがあります。<br>
※3:質問・答えともに利用開始後でも変更できます。<br>
<!-- <p align="center"><input type="image" name="submit" src="/G-pro_Service/image/Kakutei_Button.gif" width="82" height="45" border="0"></p><br>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
<br>
<br>
</form>
</body>
</html>