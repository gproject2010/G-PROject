<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="k_jyouhou.K_Touroku_TO" %>
    <%@ page import="k_jyouhou.Kaiin_Touroku_Kakunin" %>
    <jsp:useBean id="wrongdata_p1" scope="session" type="k_jyouhou.K_Touroku_TO"/>
    <%@ page import="ninsyou.AuthenticationController" %>
    <%@ page import="k_jyouhou.K_Touroku_TO" %>
    <%@ page import="k_jyouhou.K_Touroku_DAO" %>
    <jsp:useBean id="mailaddress" scope="session" type="k_jyouhou.K_Touroku_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p1_syusei.jsp"/>
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
<p><font size="+3">認証情報登録(修正)<br>
</font>
<font size="+2"><br>
以下のフォームに必要事項を入力し、「確定」ボタンをクリックしてください。<br>
<br>

</font></p>
<font color="#ff0000">※プレイヤー1人が使用できるG-PRO IDは1つのみです。<br></font>
<br>
<%if(wrongdata_p1.isNGHit() == true){ %>
<font color="red" size="+1">入力内容に禁止ワード（公開できない単語)が含まれています。(検出された禁止ワード:<%=wrongdata_p1.getNGWord() %>)<br>
該当する箇所を削除・修正してください。<br></font>
<% } %>
<% if(wrongdata_p1.isName_jyufuku() == true){ %>
入力されたプレイヤーネームは使用できません。以下をご確認のうえ、違うプレイヤーネームを設定してください。<br>
<% if(wrongdata_p1.getLogin_Name() == null || wrongdata_p1.getLogin_Name().equals("") || wrongdata_p1.getLogin_Name().equals("*")){ %>・プレイヤーネームの欄が空欄になっています。<br>
<% }else if(wrongdata_p1.getLogin_Name().length() > 10){ %>・プレイヤーネームの文字数が制限をオーバーしています。<br>
<% }else{ %>
・同じプレイヤーネームがすでに使用されています。<br>
<% } %>
<% } %>
<br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td><font size="+1">希望プレイヤーネーム:</font></td>
      <td>&nbsp;<input size="20" type="text" name="login_name" maxlength="20" value="<%=HttpUtility.escapeHTML(wrongdata_p1.getLogin_Name()) %>"/></td>
    </tr>
  </tbody>
</table>
<p>※最大全角10文字以内。ひらがな、カタカナ、漢字、英数字いずれも使用可。<br>
ただし既に使用されているものは使えません。
<font color="#ff0000">ほかの人の誹謗中傷が含まれていたり、ネット上に公開すべきでない名前、<br>
その他法令・公序良俗に反する名前を入力した場合、登録はすべて無効と<br>
なります</font>のでご注意ください。<br>
</p><br>
<br>
<% if(wrongdata_p1.isId_jyufuku() == true){ %>
入力されたG-PRO IDは使用できません。以下をご確認のうえ、違うG-PRO IDを設定してください。<br>
<% if(wrongdata_p1.getKibou_Id() == null || wrongdata_p1.getKibou_Id().equals("") || wrongdata_p1.getKibou_Id().equals("*")){ %><font color="red">・G-PRO IDの欄が空欄になっています。</font><br>
<% }else if(HttpUtility.digitAlphabetCheck(wrongdata_p1.getKibou_Id()) == false){ %><font color="red">・G-PRO IDに使用できない文字が含まれています。</font>
<% }else if(wrongdata_p1.getKibou_Id().length() < 8 || wrongdata_p1.getKibou_Id().length() > 16){ %><font color="red">・G-PRO IDの文字数が足りない、もしくは制限をオーバーしています。</font><br>
<% }else{ %><font color="red">・同じG-PRO IDがすでに使用されています。</font><br>
<% } %>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <td>希望G-PRO ID:&nbsp;</td>
      <td>&nbsp;<input size="16" type="text" maxlength="16" name="kibou_id" value="<%=HttpUtility.escapeHTML(wrongdata_p1.getKibou_Id()) %>"/></td>
    </tr>
  </tbody>
</table>
<p>※記号を除いた半角英数字8～16文字。すでに使用されているものは使えません。</p><br>
<br>
<br>
<% if(wrongdata_p1.isWrong_Password() == true){ %>
入力されたパスワードに不備があります。以下を確認のうえ、パスワードをもう一度入力してください。<br>
<% if(wrongdata_p1.getKibou_Password() == null || wrongdata_p1.getKibou_Password().equals("") || wrongdata_p1.getKibou_Password().equals("*")){ %><font color="red">・パスワードの欄が空欄になっています。</font><br>
<% }else if(HttpUtility.digitAlphabetCheck(wrongdata_p1.getKibou_Password()) == false){ %><font color="red">・パスワードに使用できない文字が含まれています。</font>
<% }else if(wrongdata_p1.getKibou_Password().length() < 8 || wrongdata_p1.getKibou_Password().length() > 16){ %><font color="red">・パスワードの文字数が足りない、もしくは制限をオーバーしています。</font><br>
<% }else{ %><font color="red">・パスワードが確認欄のものと一致していません。</font><br>
<% } %>
<% } %>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;パスワード：</td>
      <td>&nbsp;<input size="16" type="password" maxlength="16" name="kibou_password"/></td>
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
      <td>PCメールアドレス：&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(mailaddress.getMail_Address()) %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;携帯メールアドレス(任意)：</td>
      <td>&nbsp;<input size="52" type="text" name="keitaiaddress" maxlength="52" value="<%= HttpUtility.escapeHTML(wrongdata_p1.getKeitai_Address()) %>"/></td>
    </tr>
  </tbody>
</table>
※PC、携帯ともに最大半角50文字まで(記号も使用できます)
<br>
<br>
<font color="#0000ff">「確定」ボタンをクリックすると入力された情報が既に登録されていないかデータベースと
照合</font>を行い、使用できる場合は入力内容の確認に移ります。
<font color="#0000ff">（入力された情報がすでに使用されている場合はこの画面がもう一度表示されます。)</font>

<!-- <p align="center"><input type="image"  name="submit" src="/G-pro_Service/image/Kakutei_Button.gif" width="55" height="44" border="0"></p>-->
<input class="tourokubutton" type="submit" name="submit" value="確定">
</form>
</body>
</html>