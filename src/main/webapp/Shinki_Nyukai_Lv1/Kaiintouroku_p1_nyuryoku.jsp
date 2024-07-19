<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="ninsyou.AuthenticationController" %>
    <%@ page import="k_jyouhou.K_Touroku_TO" %>
    <%@ page import="k_jyouhou.K_Touroku_DAO" %>
    <jsp:useBean id="mailaddress" scope="session" type="k_jyouhou.K_Touroku_TO"/>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p1_nyuryoku.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Nyukai_Program.css"/>
<title>会員登録</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif" style="font-weight : bold;">
<form action="/G-pro_Service/Kaiin_Touroku_Kakunin" method="POST">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<ul class="bread">
<li><a href="#">Step1:注意事項の確認・メールアドレスの登録</a></li>
<li class="current"><a href="#">Step2:G-PRO ID、パスワードの登録</a></li>
<li><a href="#">Step3:プロフィール情報の登録</a></li>
<li><a href="#">登録する情報の最終確認</a></li>
<li><a href="#">利用登録の完了</a></li>
</ul>
<p><font size="+3">G-PRO ID、パスワードの登録<br>
</font><font size="+2"><br>
会員登録を行う前にチュートリアルの項目をよく読んでください。<br>
<br>
</font>
<font size="+2"><br>
以下のフォームに必要事項を入力し、「確定」ボタンをクリックしてください。<br>
<br>
</font></p>
<table border="1">
  <tbody>
    <tr>
      <td><font size="+1">希望プレイヤーネーム:</font></td>
      <td>&nbsp;<input size="20" type="text" name="login_name" maxlength="20"></td>
    </tr>
  </tbody>
</table>
<p>※最大全角10文字以内。ひらがな、カタカナ、漢字、英数字いずれも使用可。<br>
<font color="#ff0000">ほかの人の誹謗中傷が含まれていたり、ネット上に公開すべきでない名前、<br>
その他法令・公序良俗に反する名前を入力した場合、登録はすべて無効と<br>
なります</font>のでご注意ください。<br>
</p>
<table border="1">
  <tbody>
    <tr>
      <td>希望G-PRO ID:&nbsp;</td>
      <td>&nbsp;<input size="16" type="text" maxlength="16" name="kibou_id"></td>
    </tr>
  </tbody>
</table>
<p>※記号を除いた半角英数字8～16文字。すでに使用されているものは使えません。</p>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;パスワード：</td>
      <td>&nbsp;<input size="16" type="password" maxlength="16" name="kibou_password"></td>
    </tr>
    <tr>
      <td>&nbsp;パスワード（確認）：</td>
      <td>&nbsp;<input size="16" type="password" maxlength="16" name="kakunin_password"></td>
    </tr>
  </tbody>
</table>
<p>※1:記号を除いた半角英数字で8～16文字。大文字・小文字は区別しません。<br>
※2:ゾロ目、続き数字、キリ番(1000、2000など)、ほかの個人情報から推測できるものなどは避けてください。<br>
※3:既に使用されているかにかかわらず好きなパスワードを設定できます。
</p>
<table border="1">
  <tbody>
    <tr>
      <td>PCメールアドレス：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(mailaddress.getMail_Address()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;携帯メールアドレス(任意)：</td>
      <td>&nbsp;<input size="52" type="text" name="keitaiaddress" maxlength="52"></td>
    </tr>
  </tbody>
</table>
<p>※PC、携帯ともに最大半角50文字まで(記号も使用できます)</p>
<br>
<br>
<font color="#0000ff">「確定」ボタンをクリックするとG-PRO IDが使用できるか確認</font>を行い、使用できる場合はプロフィール情報の登録に移ります。<br>
<font color="#0000ff">（すでに使用されているG-PRO IDの場合はこの画面がもう一度表示されます。)</font><br>
<br>
<p align="center"><br>
<br>

<!-- <input type="image" name="submit" value="確定" src="/G-pro_Service/image/Kakutei_Button.gif" width="55" height="44" border="0">-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
</form><br>

</body>
</html>