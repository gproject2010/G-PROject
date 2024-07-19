<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.lang.String" %>
    <%@page import="k_jyouhou.Kaiin_Touroku_Kakunin_p0" %>
    <jsp:useBean id="tourokuerror" scope="session" type="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p1_sousin.jsp"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<title>確認メール送信完了</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif" style="font-weight : bold;">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<ul class="bread">
<li class="current"><a href="#">Step1:注意事項の確認・メールアドレスの登録</a></li>
<li><a href="#">Step2:G-PRO ID、パスワードの登録</a></li>
<li><a href="#">Step3:プロフィール情報の登録</a></li>
<li><a href="#">登録する情報の最終確認</a></li>
<li><a href="#">利用登録の完了</a></li>
</ul>
<p><br>
<% if(tourokuerror.equals("success")){ %>
<b>登録したメールアドレスに確認メールを送信しました。<br>
メールをご確認のうえ、G-PROjectのトップページからメールに記載されているID・パスワードでログインするとプロフィール情報の登録に進みます。<br>
<br>
※メールが届かない場合は、以下をご確認のうえ、もう一度認証情報の登録を行ってください。<br>
・メールアドレスが間違っていませんか？<br>
・メーラにより迷惑メールとして処理されていませんか？(迷惑メールフォルダをご確認ください)<br>
・メーラの受信拒否設定に引っかかっていませんか？(設定している場合は無効にするか、「GameMaster@mail.gamereporters.info」を許可してください)<br>
・Yahoo!メールのアドレスを登録した場合、メールの到着が数時間～2日程度遅れる場合があります。<br>
(Yahoo!メールのシステムの仕様によるもので、G-PROjectの異常ではありません)<br>
<br>
</b></p>
<% }else{ %>
<p><br>
<b>メールの送信処理に失敗しました。<br>
お手数ですが、もう一度認証情報の登録を行い、それでも登録できない場合は、<br>
問い合わせページ(トップページにリンクがあります)でお知らせください。</b></p>
<% } %>
<!-- <p align="center"><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="188" height="43" border="0"></a><br>
トップページに戻る</p>-->
      <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a>
    </dl>
</body>
</html>