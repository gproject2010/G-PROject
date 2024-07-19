<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="inputUtility.HttpUtility" %>
    <%@page import="k_jyouhou.K_jyouhou_TO" %>
    <%@page import="k_jyouhou.K_jyouhou_DAO" %>
    <%@page import="n_syoukai.Nin_Syoukai_P1_Kakunin" %>
    <jsp:useBean id="wrong" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Nin_Syoukai_P1_Syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>ID・パスワード照会（登録情報入力)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0">
<p><br>
<font size="+2"><b>ID・パスワード照会申請（登録情報入力)<br>
</b></font><b><br>
以下のフォームにG-projectに登録されているPCのメールアドレス・プレイヤーネームを入力し、「確定」ボタンを<br>
クリックしてください。なおPCのメールアドレス、プレイヤーネーム、秘密の質問の答えのいずれかでも<br>
忘れてしまった場合、現在の住所・PCのメールアドレスがG-Projectに登録されているものと違う場合はお手数ですが<br>
問い合わせフォーム(トップページにリンクがあります）にてお問い合わせください。(身分証明書のコピーが必要です。)<br>
</b></p>
<form action="/G-pro_Service/Nin_Syoukai_P1_Kakunin" method="post">
<%if(wrong.isNomail()){ %>
メールアドレスが入力されていません。<br>
<br>
<% } %>
<%if(wrong.isNoname()){ %>
プレイヤーネームが入力されていません。<br>
<br>
<% } %>
<%if(wrong.isWrong()){ %>
不正な値が入力されています。入力内容をもう一度ご確認ください。<br>
<br>
<% } %>
<%if(wrong.isEmpty()){ %>
該当するデータは登録されていません。入力内容をもう一度ご確認ください。<br>
<br>
<% } %>
<table border="1" align="left">
  <tbody>
    <tr>
      <td><b>&nbsp;PCメールアドレス(照合用・必須)</b></td>
      <td><b>&nbsp;<input size="30" type="text" name="mailaddress" value="<%=HttpUtility.escapeHTML(wrong.getmailaddress()) %>"></b></td>
    </tr>
    <tr>
      <td><b>&nbsp;プレイヤーネーム(照合用・必須)</b></td>
      <td><b>&nbsp;<input size="20" type="text" name="player_name" value="<%=HttpUtility.escapeHTML(wrong.getLogin_name()) %>"></b></td>
    </tr>
  </tbody>
</table>
<p><b><br>
※文字列として完全に一致しないと認証できません。<br>
正確に入力してください。<br>
<br>
</b><b><br>
「確定」をクリックすると入力内容の確認を行い、不備がなければ本人確認のページへ移動します。<br>
(不備があったり、該当するプレイヤー情報が存在しない場合はこのページがもう一度表示されます)<br>
</b></p>
<!-- <p align="center"><br>
 <input type="image" name="submit" alt="確定" src="/G-pro_Service/image/Kakutei_Button.gif" width="55" height="44" border="0">　　　　　　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif"></a><br>-->
<input id="tourokubutton" type="submit" name="submit" value="確定">
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
<!-- </p>-->
<p>
※照会申請を行ったのにメールが届いていない場合は、以下をご確認のうえ、もう一度照会申請を行ってください。<br>
・メールアドレスが間違っていませんか？<br>
・メーラにより迷惑メールとして処理されていませんか？(迷惑メールフォルダをご確認ください)<br>
・メーラの受信拒否設定に引っかかっていませんか？(設定している場合は無効にするか、「PW-Reset@mail.gamereporters.info」を許可してください)<br>
</p>
</form>
</body>
</html>