<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="inputUtility.HttpUtility" %>
    <%@page import="k_jyouhou.K_jyouhou_TO" %>
    <%@page import="k_jyouhou.K_jyouhou_DAO" %>
    <%@page import="n_syoukai.Nin_Syoukai_P1_Kakunin" %>
    <jsp:useBean id="wrong2" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
    <jsp:useBean id="syo_data" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Nin_Syoukai_P2_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>ID・パスワード照会申請（本人確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0">
<p><br>
<b><font size="+2">ID・パスワード照会申請（本人確認)<br>
</font><br>
以下のフォームにG-Projectに登録されている生年月日、住所地の郵便番号、秘密の質問の答えを入力し、<br>
「確定」ボタンをクリックしてください。なお、秘密の質問の答えを忘れてしまった場合、正しい情報を入力しても<br>
認証できない場合はお手数ですが問い合わせフォーム(トップページにリンクがあります)にてお問い合わせください。<br>
<br>
<font color="yellow" size="+2">認証できませんでした。入力内容をもう一度ご確認ください。</font>
</b></p>
<br>
<br>
<form action="/G-pro_Service/Nin_Syoukai_P2_Kakunin" method="post">
※生年月日はもう一度入力してください。<br>
<table border="1">
  <tbody>
    <tr>
      <td><b>&nbsp;生年月日(必須)：</b></td>
      <td><b><input size="4" type="text" name="birthyear">年（西暦)</b></td>
      <td><b>&nbsp;<select name="birthtsuki">
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
      </select>月</b></td>
      <td><b>&nbsp;<select name="birthday">
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
</select>日</b></td>
    </tr>
  </tbody>
</table>
<table border="1">
  <tbody>
    <tr>
      <td><b>&nbsp;住所地の郵便番号(必須)：</b></td>
      <td><b>&nbsp;<input size="3" type="text" name="addressno"></b></td>
    </tr>
  </tbody>
</table>
※”-”（ハイフン）は入れずに入力してください。
<b><br>
</b>
<table border="1" align="left">
  <tbody>
    <tr>
      <td><b>&nbsp;秘密の質問</b></td>
      <td><b>&nbsp;<%=HttpUtility.escapeHTML(syo_data.getsecret_question()) %></b></td>
    </tr>
    <tr>
      <td><b>&nbsp;秘密の質問の答え(必須)</b></td>
      <td><b>&nbsp;<input size="20" type="text" name="secret_answer"></b></td>
    </tr>
  </tbody>
</table>
<p><b>※文字列として完全に一致しないと認証できません。<br>
正確に入力してください。<br>
</b></p>
<p><b><br>
「確定」をクリックすると入力内容の確認を行い、認証に成功すると照会の申請が完了します。<br>
(不備があったり、認証に失敗した場合はこのページがもう一度表示されます)<br>
</b></p>
<p align="center"><br>
<p align="center"><br>
<!-- <input type="image" name="submit" alt="確定" src="/G-pro_Service/image/Kakutei_Button.gif" width="55" height="44" border="0">　　　　　　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif"></a><br>-->
<input id="tourokubutton" type="submit" name="submit" value="確定">
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
</form>
</body>
</html>