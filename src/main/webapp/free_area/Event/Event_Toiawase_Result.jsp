<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.lang.Integer" %>
    <%@ page import="event.Event_Toiawase" %>
    <jsp:useBean id="result" scope="session" type="java.lang.Integer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Event/Event_Toiawase_Result.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Event.css"/>
<title>イベント問い合わせ</title>
</head>
<body background="/G-pro_Service/image/Event_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="342" height="131" border="0"></p>
<p><b><font size="+2">イベント問い合わせ</font></b></p>
<% if(result == 0){ %>
<p><b>イベントの主催者に入力された内容を送信しました。後ほど主催者より直接回答させていただきます。しばらくお待ちください。<br>
また、ご入力いただいたメールアドレスに控えを送信しましたのでご確認ください。<br>
(控えが届かない場合はメールアドレスが間違っている可能性があります。そのときは確認の上もう一度お問い合わせください。)</b></p>
<% }else if(result == 3){ %>
<p><b>イベントの主催者へ問い合わせを送信できませんでした。もう一度お問い合わせいただくか、G-PROjectの問い合わせフォーム(トップページにリンクがあります)でお問い合わせください。</b></p>
<% }else if(result == 4){ %>
<p><b>問い合わせの控えの送信に失敗しました。主催者からの回答を受信できない可能性があります。<br>
メールアドレスを確認の上もう一度お問い合わせください。</b></p>
<% }else if(result == 2){ %>
<p><b>メールアドレスまたは問い合わせの内容が入力されていません。イベント概要に戻り、もう一度お問い合わせください。</b></p>
<% } %>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップに戻る</a></dd>
<dd class="tourokubutton"><a href="/G-pro_Service/free_area/Event/Event_Gaiyou.jsp">イベント概要に戻る</a></dd>
</body>
</html>