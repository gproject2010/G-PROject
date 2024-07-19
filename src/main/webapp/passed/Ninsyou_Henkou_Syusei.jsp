<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.lang.Boolean"%>
    <%@ page import="ninsyou.N_jyouhou_TO" %>
    <%@ page import="k_jyouhou.K_jyouhou_TO" %>
    <%@ page import="k_jyouhou.K_Touroku_TO" %>
    <%@ page import="k_jyouhou.Ninsyou_Henkou_Kakunin" %>
    <jsp:useBean id="wrongdata_henkou" scope="session" type="k_jyouhou.K_Touroku_TO"/>
     <jsp:useBean id="nin_jyouhou" scope="session" type="ninsyou.N_jyouhou_TO"/>
    <jsp:useBean id="mail" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
    <jsp:useBean id="id_accept" scope="session" type="java.lang.Boolean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/Shinki_Nyukai/Kaiintouroku_p1_syusei.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>会員登録</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<form action="/G-pro_Service/Ninsyou_Henkou_Kakunin" method="POST">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<p><font size="+3">認証情報変更(修正)<br>
</font>
<font size="+2"><br>
以下のフォームに必要事項を入力し、「確定」ボタンをクリックしてください。<br>
<br>
</font></p>
<font color="#ff0000">※プレイヤー1人が使用できるIDは1つのみです。<br></font>
<% if(wrongdata_henkou.isName_jyufuku() == true){ %>
入力されたプレイヤーネームは使用できません。以下をご確認のうえ、違うプレイヤーネームを設定してください。<br>
<% if(wrongdata_henkou.getLogin_Name() == null || wrongdata_henkou.getLogin_Name().equals("") || wrongdata_henkou.getLogin_Name().equals("*")){ %>プレイヤーネームの欄が空欄になっています。<br>
<% }else if(wrongdata_henkou.getLogin_Name().length() > 10){ %>・プレイヤーネームの文字数が制限をオーバーしています。<br>
<% }else{ %>・同じプレイヤーネームがすでに使用されています。<br>
<% } %>
<% if(wrongdata_henkou.getNGWord() != null){ %>
入力されたプレイヤーネームから禁止ワード(<%=wrongdata_henkou.getNGWord() %>)が検出されました。<br>
訂正して再試行してください。<br>
<% } %>
<% } %>
<br>
<br>
<table border="1">
  <tbody>
  <tr>
      <td><font size="+1">プレイヤーネーム(変更前):</font></td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(nin_jyouhou.getlogin_name()) %></td>
    </tr>
    <tr>
      <td><font size="+1">希望プレイヤーネーム:</font></td>
      <td>&nbsp;<input size="20" type="text" name="login_name" maxlength="20" value="<%=HttpUtility.escapeHTML(wrongdata_henkou.getLogin_Name()) %>"/></td>
    </tr>
  </tbody>
</table>
<p>※1:最大全角10文字以内。ひらがな、カタカナ、漢字、英数字いずれも使用可。<br>
ただし既に使用されているものは使えません。
<font color="#ff0000">ほかの人の誹謗中傷が含まれていたり、ネット上に公開すべきでない名前、<br>
その他法令・公序良俗に反する名前を入力した場合、登録はすべて無効と<br>
なります</font>のでご注意ください。<br>
<br>
※2:プレイヤーネームを変更した場合でも、変更前に投稿したコンテンツのプレイヤーネームは変更前のままになります。<br>
(スコアやG-PROマイレージの変動には影響はありません)<br>
</p><br>
<br>
<% if(id_accept == true){ %>
<% if(wrongdata_henkou.isId_jyufuku() == true){ %>
入力されたG-PRO IDは使用できません。以下をご確認のうえ、違うG-PRO IDを設定してください。<br>
<% if(wrongdata_henkou.getKibou_Id() == null || wrongdata_henkou.getKibou_Id().equals("") || wrongdata_henkou.getKibou_Id().equals("*")){ %>・G-PRO IDの欄が空欄になっています。<br>
<% }else if(!(HttpUtility.digitAlphabetCheck(wrongdata_henkou.getKibou_Id()))){ %>・G-PRO IDに使用できない文字が含まれています。<br>
<% }else if(wrongdata_henkou.getKibou_Id().length() < 8 || wrongdata_henkou.getKibou_Id().length() > 16){ %>・G-PRO IDの文字数が足りないか、制限をオーバーしています。<br>
<% }else{ %>・同じG-PRO IDがすでに使用されています。<br>
<% } %>
<% } %>
<table border="1">
  <tbody>
  <tr>
      <td>G-PRO ID(変更前):&nbsp;</td>
      <td>&nbsp;<%=HttpUtility.escapeHTML(nin_jyouhou.getK_Id()) %></td>
    </tr>
    <tr>
      <td>希望ID:&nbsp;</td>
      <td>&nbsp;<input size="16" type="text" maxlength="16" name="kibou_id" value="<%=HttpUtility.escapeHTML(wrongdata_henkou.getKibou_Id()) %>"/></td>
    </tr>
  </tbody>
</table>
<p>※記号を除いた半角英数字8～16文字。すでに使用されているものは使えません。</p><br>
<% }else{ %><font color="#ff0000">※過去1か月以内に変更を受け付けているため、G-PRO IDの変更は現在できません。</font><% } %>
<br>
<br>
<% if(wrongdata_henkou.isWrong_Password() == true){ %>
入力されたパスワードに不備があります。以下を確認のうえ、パスワードをもう一度入力してください。<br>
<% if(wrongdata_henkou.getKibou_Password() == null || wrongdata_henkou.getKibou_Password().equals("") || !(wrongdata_henkou.getKibou_Password().equals(wrongdata_henkou.getKakunin_Password()))){ %>・パスワードが確認欄のものと一致していません。<br>
<% }else if(wrongdata_henkou.getKibou_Password() == null || wrongdata_henkou.getKibou_Password().equals("") || wrongdata_henkou.getKibou_Password().equals("*")){ %>・パスワードの欄が空欄になっています。<br>
<% }else if(!(HttpUtility.digitAlphabetCheck(wrongdata_henkou.getKibou_Password()))){ %>・パスワードに使用できない文字が含まれています。
<% }else if(wrongdata_henkou.getKibou_Password().length() < 8 || wrongdata_henkou.getKibou_Password().length() > 16){ %>・パスワードの文字数が足りないか、制限をオーバーしています。<br>
<% } %>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;パスワード：</td>
      <td>&nbsp;<input size="16" type="password" maxlength="16" name="new_password" value="<%=wrongdata_henkou.getKibou_Password() %>"/></td>
    </tr>
    <tr>
      <td>&nbsp;パスワード（確認）：</td>
      <td>&nbsp;<input size="16" type="password" maxlength="16" name="kakunin_password"/></td>
    </tr>
  </tbody>
</table>
※1:記号を除いた半角英数字で8～16文字。大文字・小文字は区別しません。<br>
※2:ゾロ目、続き数字、キリ番(1000、2000など)、ほかの個人情報から推測できるものなどは避けてください。<br>
※3:既に使用されているかにかかわらず好きなパスワードを設定できます。<br>
<br>
<table border="1">
  <tbody>
  <tr>
      <td>PCメールアドレス(変更前)：&nbsp;</td>
      <td><%=mail.getmailaddress() %>&nbsp;</td>
    </tr>
    <tr>
      <td>PCメールアドレス(変更後)：&nbsp;</td>
      <td><input size="52" type="text" name="mailaddress" maxlength="52" value="<%=wrongdata_henkou.getMail_Address() %>"/>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;携帯メールアドレス(任意)(変更前)：</td>
      <td>&nbsp;<%=mail.getkeitaiaddress() %></td>
    </tr>
    <tr>
      <td>&nbsp;携帯メールアドレス(任意)：</td>
      <td>&nbsp;<input size="52" type="text" name="keitaiaddress" maxlength="52" value="<%=wrongdata_henkou.getKeitai_Address() %>"/></td>
    </tr>
  </tbody>
</table>
<br>
※最大半角50文字まで(記号も使用できます)
<br>
<font color="#0000ff">「確定」ボタンをクリックすると入力された情報が既に登録されていないかデータベースと
照合</font>を行い、使用できる場合は入力内容の確認に移ります。
<font color="#0000ff">（入力された情報がすでに使用されている場合はこの画面がもう一度表示されます。)</font>

<!-- <p align="center"><input type="image"  name="submit" src="/G-pro_Service/image/Kakutei_Button.gif" width="61" height="48" border="0"></p>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
</form>
</body>
</html>