<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Password_Reset_Kanryou.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>ID・パスワード照会（認証成功)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0">
<p><br>
<b><font size="+2">ID・パスワード照会（認証成功)<br>
</font><br>
会員情報による認証に成功しましたのでG-PROjectに登録されているメールアドレス宛てにリセット後の仮パスワードを<br>
送信しました。メール内のG-PRO_IDと仮パスワードでログイン後、会員メニューの「8：会員情報の変更」から<br>
パスワードを新しいものに変更してください。
<br>
※メールが届かない場合は、以下をご確認のうえ、もう一度認証情報の登録を行ってください。<br>
・メールアドレスが間違っていませんか？<br>
・メーラにより迷惑メールとして処理されていませんか？(迷惑メールフォルダをご確認ください)<br>
・メーラの受信拒否設定に引っかかっていませんか？(設定している場合は無効にするか、PW-Reset@mail.gamereporters.infoを許可してください)<br>
(上記の理由で登録しなおす場合、ほかの項目は変更する必要はありません。)<br>
・Yahoo!メールのアドレスを登録している場合、メールの到着が数時間～2日程度遅れる場合があります。<br>
(Yahoo!メールのシステムの仕様によるもので、G-PROjectの異常ではありません)<br>
<br>
照会を行ったG-PRO_ID：${sessionScope.k_id }</b><br>
<br>
<!-- <a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif"></a><br>-->
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
</body>
</html>