<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.lang.String" %>
    <%@page import="java.lang.Boolean" %>
    <%@page import="k_jyouhou.New_Kaiin_Maker" %>
    <jsp:useBean id="mailerror" scope="request" class="java.lang.Boolean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/Shinki_Nyukai_Lv2/Kaiin_Touroku_Kanryou.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>確認メール送信完了</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif" style="font-weight : bold;">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<ul class="bread">
<li><a href="#">Step1:注意事項の確認・メールアドレスの登録</a></li>
<li><a href="#">Step2:G-PRO ID、パスワードの登録</a></li>
<li><a href="#">Step3:プロフィール情報の登録</a></li>
<li><a href="#">登録する情報の最終確認</a></li>
<li class="current"><a href="#">利用登録の完了</a></li>
</ul>
<p><br>
<% if(mailerror == false){ %>
<p align="center"><font size="+3">サイト登録受付完了</font><br>
<br>
<b><font size="+1">プロフィールデータのアップロードが完了しました。
また、登録されたメールアドレス宛てに登録の完了メールを送信しましたのでご確認ください。
下記の「G-PROjectトップに戻る」をクリックするといったんログアウト処理を行い、トップページに戻ります。<br>
それでは設定したG-PRO ID・パスワードでトップページからログインし、G-PROjectをお楽しみください!</font></b><br>
<br>
<br>
<!-- <a href="/G-pro_Service/Logout"><img alt="G-PROjectトップに戻る" src="/G-pro_Service/image/BacktoSiteTop.gif"></a>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/Logout">G-PROjectトップへ戻る</a>
    </dl>
<br>
<p>
※メールが届かない場合は、以下をご確認のうえ、<a href="/G-pro_Service/Kakunin_Mail_Saisou">こちら</a>をクリックして確認メールを受信しなおしてください。<br>
　メールを受信できない状態ですと、G-PRO IDやパスワードを失念した(忘れた)際に照会できないことがあります。<br>
<br>
・メーラにより迷惑メールとして処理されていませんか？(迷惑メールフォルダをご確認ください)<br>
・メーラの受信拒否設定に引っかかっていませんか？もし設定している場合は無効にするか、「PW-Reset@mail.gamereporters.info」
(G-PRO ID、パスワードを照会する際に使用するメールアドレスです。再送の場合はこちらを使用します)を許可してください。<br>
・Yahoo!メールのアドレスを登録した場合、メールの到着が数時間～2日程度遅れる場合があります。<br>
(Yahoo!メールのシステムの仕様によるもので、G-PROjectの異常ではありません)<br>
<br>
なお、これらを行っても受信できない場合は、恐れ入りますが問い合わせフォームにてお知らせください。
(トップページにリンクがあります)
</p>
<% }else{ %>
<p><br>
<b><font size="+1">メールの送信処理に失敗しました。</font><br>
お手数ですが、以下をご確認のうえ、<a href="/G-pro_Service/Kakunin_Mail_Saisou">こちら</a>をクリックして確認メールを受信しなおしてください。<br>
メールを受信できない状態ですと、G-PRO IDやパスワードを失念した(忘れた)際に照会できないことがあります。<br>
<br>
・メーラにより迷惑メールとして処理されていませんか？(迷惑メールフォルダをご確認ください)<br>
・メーラの受信拒否設定に引っかかっていませんか？もし設定している場合は無効にするか、「PW-Reset@mail.gamereporters.info」
(G-PRO ID、パスワードを照会する際に使用するメールアドレスです。再送の場合はこちらを使用します)を許可してください。<br>
・Yahoo!メールのアドレスを登録した場合、メールの到着が数時間～2日程度遅れる場合があります。<br>
(Yahoo!メールのシステムの仕様によるもので、G-PROjectの異常ではありません)<br>
<br>
なお、これらを行っても受信できない場合は、恐れ入りますが問い合わせフォームにてお知らせください。
(トップページにリンクがあります)</b></p>
<% } %>
</body>
</html>