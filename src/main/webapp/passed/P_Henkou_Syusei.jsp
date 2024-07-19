<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
<%@page import="k_jyouhou.K_Touroku_TO" %>
    <%@page import="k_jyouhou.P_Henkou_Kakunin" %>
    <jsp:useBean id="h_wrongdata" scope="session" type="k_jyouhou.K_Touroku_TO"/>
    <%@page import="k_jyouhou.K_jyouhou_DAO" %>
    <%@page import="ninsyou.Lv2_Pass_Check" %>
    <jsp:useBean id="pdata" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>会員登録</title>
</head>
<base href="/G-pro_Service/passed/P_Henkou_Syusei.jsp"/>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<form action="/G-pro_Service/P_Henkou_Kakunin"  method="POST">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<p><font size="+3">プロフィール情報変更(修正)</font><br>
<font size="+2"><br>
以下のフォームの必要な部分を変更し、「確定」ボタンをクリックしてください。<br>
※セキュリティ確保のため、変更前の情報の代わりに「＊＊＊」を表示しています。<br>
変更しない項目のフォームは「＊＊＊」のまま変更しないでください。
</font></p><br>
<br>
<%if(h_wrongdata.isNoName()){ %>
<font color="red" size="+1">本名の欄が入力されていません。</font><br>
<br>
<% } %>
<%if(h_wrongdata.isNoBirthday()){ %>
<font color="red" size="+1">生年月日が入力されていません。</font><br>
<br>
<% } %>
<%if(h_wrongdata.isNoAddress()){ %>
<font color="red" size="+1">住所が入力されていません。</font><br>
<br>
<% } %>
<%if(h_wrongdata.isNoSecret()){ %>
<font color="red" size="+1">秘密の質問が入力されていません。</font><br>
<br>
<% } %>
<%if(h_wrongdata.getNGWord() != null){ %>
<font color="red" size="+1">禁止ワード(使用できない単語)が含まれています。<br>
(ヒットした禁止ワード:<%=h_wrongdata.getNGWord() %>)訂正して再試行してください。</font><br>
<br>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <td>本名（姓）：&nbsp;</td>
      <td><input size="16" type="text" maxlength="8" name="sei_kanji" value="<%=HttpUtility.escapeHTML(h_wrongdata.getSei_Kanji()) %>">&nbsp;</td>
      <td>本名（名）：&nbsp;</td>
      <td><input size="16" type="text" maxlength="8" name="mei_kanji" value="<%if(pdata.isEmpty() == false){ %><%=HttpUtility.escapeHTML(pdata.getmei_kanji()) %><% }else{ %>＊＊＊<% } %>">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;本名（セイ）：</td>
      <td>&nbsp;<input size="12" type="text" name="sei_kana" maxlength="12" value="<%=HttpUtility.escapeHTML(h_wrongdata.getSei_Kana()) %>"></td>
      <td>&nbsp;本名（メイ）：</td>
      <td>&nbsp;<input size="16" type="text" maxlength="8" name="mei_kana" value="<%if(pdata.isEmpty() == false){ %><%=HttpUtility.escapeHTML(pdata.getmei_kana()) %><% }else{ %>＊＊＊<% } %>"></td>
    </tr>
  </tbody>
</table>
<br>
※姓のみ変更できます。<br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;生年月日：</td>
      <td><%if(pdata.isEmpty() == false){ %><%=HttpUtility.escapeHTML(pdata.getbirthday()) %><% }else{ %>＊＊＊<% } %></td>
    </tr>
     <tr>
      <td>&nbsp;性別：</td>
      <td><%if(pdata.isEmpty() == false){ %><%=HttpUtility.escapeHTML(pdata.getSex()) %><% }else{ %>＊＊＊<% } %></td>
    </tr>
  </tbody>
</table><br>
※生年月日・性別は変更できません。やむを得ない事情により変更する場合は問い合わせフォームにてお知らせください。
<br>
<p>職業(※現在選択中の職業：<%=HttpUtility.escapeHTML(h_wrongdata.getJob()) %>)<br>
<input type="radio" name="job" value="小学生">小学生　　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="会社員">会社員<br>
<input type="radio" name="job" value="中学生">中学生　　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="自営業・自由業">自営業・自由業<br>
<input type="radio" name="job" value="高校生">高校生　　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="主婦(夫)">主婦(夫)<br>
<input type="radio" name="job" value="予備校生">予備校生　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" name="job" value="フリーター">フリーター<br>
<input type="radio" name="job" value="専門・専修学校生(ゲーム系)">専門・専修学校生(ゲーム系)　　　　　　　　　　　　<input type="radio" name="job" value="その他">その他<br>
<input type="radio" name="job" value="専門・専修学校生(ゲーム系以外)">専門・専修学校生(ゲーム系以外)　　　　　　　　　<input type="radio" name="job" value="答えたくない">答えたくない<br>
<input type="radio" name="job" value="大学生">大学生　　　　　　　　　　　　　　　　　　　　　　　　　<input type="radio" checked name="job" value="変更しない">選択中の職業のまま変更しない
</p>
<br>
<p>郵便番号：<input size="10" type="text" maxlength="10" name="addressno" value="<%=HttpUtility.escapeHTML(h_wrongdata.getAddressNo()) %>"><br>
<br>
住所(都道府県）<br>
(※現在設定されている都道府県：<%=HttpUtility.escapeHTML(pdata.getpref()) %>)<br>
<select name="pref">
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
  <option value="変更しない" selected>設定されているまま変更しない</option>
</select><br>
<br>
住所(市町村名～）：<br>
<textarea rows="2" cols="50" name="jyusyo"><%=HttpUtility.escapeHTML(h_wrongdata.getJyusyo()) %></textarea></p>
<table border="1">
  <tbody>
    <tr>
      <td>連絡先電話番号(携帯可）：&nbsp;</td>
      <td><input size="15" type="text" name="telephone_no" maxlength="15" value="<%=HttpUtility.escapeHTML(h_wrongdata.getTelephone_No()) %>">&nbsp;</td>
    </tr>
  </tbody>
</table><br>
※住所・連絡先電話番号ともに利用開始後でも変更できます。<br>
<br>
<br>
秘密の質問(ID・パスワードを忘れた場合に必要となります。あなただけが分かることを入力してください)<br>
<br>
質問:<input size="30" type="text" name="secret_question" value="<%=HttpUtility.escapeHTML(h_wrongdata.getSecret_Question()) %>"><br>
<br>
答え:<input size="30" type="text" name="secret_answer" value="<%=HttpUtility.escapeHTML(h_wrongdata.getSecret_Answer()) %>"><br>
<!-- <p align="center"><input type="image" name="submit" src="/G-pro_Service/image/Kakutei_Button.gif" width="61" height="48"></p><br>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
<br>
※1:照合する際、文字列が完全に一致しないと確認できません。はっきりと覚えているものを使用してください。<br>
※2:質問とそれに対する答えとして成立していない場合、会員登録ができないことがあります。<br>
※3:質問・答えともに利用開始後でも変更できます。<br>
<br>
</form>
</body>
</html>