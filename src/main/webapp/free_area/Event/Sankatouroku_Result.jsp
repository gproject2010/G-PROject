<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.lang.Boolean" %>
    <%@page import="event.Event_Sanka_Upload" %>
    <jsp:useBean id="tourokuerror" scope="session" type="java.lang.Boolean"/>
    <jsp:useBean id="mailerror" scope="session" type="java.lang.Boolean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Event.css"/>
<base href="/G-pro_Service/Event/Sankatouroku_Result.jsp">
<title>参加登録結果</title>
</head>
<body background="/G-pro_Service/image/Event_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="342" height="131" border="0"></p>
<p><b><font size="+2">イベント参加登録完了</font></b></p>
<% if(tourokuerror == false && mailerror == false){ %>
<p><b><font color="#0000ff">イベントの参加登録が完了しました。<br>
また、入力されたメールアドレス宛てに参加の控えを送信しました。参加登録の証明となりますので、大切に保管してください。</font></b></p>
<p><b>※メールが届かない場合は、以下をご確認のうえ、もう一度参加登録を行ってください。<br>
・メールアドレスが間違っていませんか？<br>
・メーラにより迷惑メールとして処理されていませんか？(迷惑メールフォルダをご確認ください)<br>
・メーラの受信拒否設定に引っかかっていませんか？(設定している場合は、New-Entry@mail.gamereporters.infoを許可してください)<br>
</b></p>
<% }else if(mailerror == true && tourokuerror == false){ %>
<p><b>メールの送信処理に失敗しました。<br>
お手数ですが、入力内容をご確認のうえ、もう一度参加登録を行い、それでも登録できない場合は、<br>
問い合わせページ(トップページにリンクがあります)でお知らせください。</b></p>
<% }else{ %>
<p><b>参加情報の登録処理に失敗しました。<br>
お手数ですが、入力内容をご確認のうえ、もう一度参加登録を行い、それでも登録できない場合は、<br>
問い合わせページ(トップページにリンクがあります)でお知らせください。</b></p>
<% } %>
<p><a href="/G-pro_Service/AuthenticationController" class="tourokubutton">G-PROjectトップに戻る</a></p>
</body>
</html>