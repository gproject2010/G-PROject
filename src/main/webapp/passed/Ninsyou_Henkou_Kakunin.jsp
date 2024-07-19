<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="k_jyouhou.K_Touroku_TO" %>
    <%@ page import="k_jyouhou.Ninsyou_Henkou_Kakunin" %>
    <jsp:useBean id="n_henkoudata" scope="session" type="k_jyouhou.K_Touroku_TO"/>
    <%@ page import="ninsyou.N_jyouhou_TO" %>
    <%@ page import="ninsyou.Lv2_Pass_Check" %>
    <%@ page import="ninsyou.AuthenticationController" %>
    <jsp:useBean id="nin_jyouhou" scope="session" type="ninsyou.N_jyouhou_TO"/>
    <jsp:useBean id="mail" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Ninsyou_Henkou_Kakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>認証情報変更(確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<p><font size="+3">G-Project会員登録<br>
</font><font size="+2"><br>
以下の内容で変更します。変更を反映するには「確定」を、<br>
変更しなおす場合は「内容を変更する」をクリックしてください。<br>
</font></p>
<table border="1">
  <tbody>
    <tr>
      <td><font size="+1">プレイヤーネーム(変更前):</font></td>
      <td><%=HttpUtility.escapeHTML(mail.getLogin_name()) %>&nbsp;</td>
    </tr>
    <tr>
      <td><font size="+1">プレイヤーネーム(変更後)：</font></td>
      <td><font size="+1"><%=HttpUtility.escapeHTML(n_henkoudata.getLogin_Name()) %>&nbsp;</font></td>
    </tr>
  </tbody>
</table>
<p>※1:最大全角12文字以内。ひらがな、カタカナ、漢字、英数字いずれも使用可。<br>
<font color="#ff0000">ほかの人の誹謗中傷が含まれていたり、ネット上に公開すべきでない名前、<br>
その他法令・公序良俗に反する名前を入力した場合、登録はすべて無効と<br>
なります</font>のでご注意ください。<br>
<br>
※2:プレイヤーネームを変更した場合でも、変更前にアップロードしたレポートのプレイヤーネームは変更前のままになります。<br>
(レポートの採用ボーナスは変更前のものも含めすべて受け取れます)<br>
</p>
<table border="1">
  <tbody>
    <tr>
      <td>G-PRO ID(変更前)：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(nin_jyouhou.getK_Id()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;G-PRO ID(変更後):</td>
      <td><%=HttpUtility.escapeHTML(n_henkoudata.getKibou_Id()) %>&nbsp;</td>
    </tr>
  </tbody>
</table>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;パスワード(変更前)：</td>
      <td>文字数は<%=nin_jyouhou.getK_Password().length() %>文字です。&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;パスワード（変更後）：</td>
      <td>文字数は<%=n_henkoudata.getPassword_length() %>文字です。&nbsp;</td>
    </tr>
  </tbody>
</table>
　※セキュリティ確保のため、文字数だけを表示しています。<br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>PCメールアドレス(変更前)：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(mail.getmailaddress()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;PCメールアドレス(変更後):</td>
      <td><%=HttpUtility.escapeHTML(n_henkoudata.getMail_Address()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;携帯メールアドレス(変更前)：</td>
      <td><%=HttpUtility.escapeHTML(mail.getkeitaiaddress()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;携帯メールアドレス(変更後)：</td>
      <td><%=HttpUtility.escapeHTML(n_henkoudata.getKeitai_Address()) %>&nbsp;</td>
    </tr>
  </tbody>
</table>
<br>
<br>
<!-- <p align="center"><a href='/G-pro_Service/Nin_Henkoutouroku'><img src="/G-pro_Service/image/Kakutei_Button.gif" width="61" height="48" border="0"></a><a href="#" onClick="history.back(); return false;"><img src="/G-pro_Service/image/Cansel_Button.gif" width="83" height="46" border="0"></a></p>-->
<dl>
      <dd class="tourokubutton"><a href='/G-pro_Service/Nin_Henkoutouroku'>変更を確定する</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">変更せず会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>