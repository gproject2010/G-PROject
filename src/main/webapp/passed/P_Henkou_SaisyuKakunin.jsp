<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="inputUtility.HttpUtility" %>
<%@page import="k_jyouhou.K_Touroku_TO" %>
    <%@page import="k_jyouhou.P_Henkou_Kakunin" %>
    <jsp:useBean id="h_tourokudata" scope="session" type="k_jyouhou.K_Touroku_TO"/>
    <%@page import="k_jyouhou.K_jyouhou_DAO" %>
    <%@page import="ninsyou.Lv2_Pass_Check" %>
    <jsp:useBean id="pdata" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>会員登録</title>
</head>
<base href="/G-pro_Service/passed/P_Henkou_SaisyuKakunin.jsp"/>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<p><font size="+3">プロフィール情報最終確認</font><br>
<font size="+2"><br>
この内容に変更しますか?よろしければ「変更を確定する」ボタンを、もう一度変更する場合は「キャンセル」をクリックしてください。<br>
※この変更は次回のサーバメンテナンス時に反映されます。
</font></p><br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>本名（姓）：&nbsp;</td>
      <td><%if(h_tourokudata.getSei_Kanji().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getSei_Kanji()) %><% }else{ %>変更しません<% } %>&nbsp;</td>
      <td>本名（名）：&nbsp;</td>
      <td><%if(h_tourokudata.getMei_Kanji().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getMei_Kanji()) %><% }else{ %>変更しません<% } %>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;本名（セイ）：</td>
      <td>&nbsp;<%if(h_tourokudata.getSei_Kana().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getSei_Kana()) %><% }else{ %>変更しません<% } %></td>
      <td>&nbsp;本名（メイ）：</td>
      <td>&nbsp;<%if(h_tourokudata.getMei_Kana().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getMei_Kana()) %><% }else{ %>変更しません<% } %></td>
    </tr>
  </tbody>
</table>
<br>
<br>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;生年月日：</td>
      <td><%=HttpUtility.escapeHTML(pdata.getbirthday()) %></td>
    </tr>
  <tr>
      <td>&nbsp;性別：</td>
      <td><%if(pdata.isEmpty() == false){ %><%=HttpUtility.escapeHTML(pdata.getSex()) %><% }else{ %>＊＊＊<% } %></td>
    </tr>
  </tbody>
</table><br>
※生年月日・性別は変更できません。やむを得ない事情により変更する場合は問い合わせフォームにてお知らせください。
<br>
<p>職業：<%=HttpUtility.escapeHTML(h_tourokudata.getJob()) %></p>
<br>
<p>郵便番号：<%if(h_tourokudata.getAddressNo().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getAddressNo()) %><% }else{ %>変更しません<% } %><br>
<br>
住所(都道府県)：<br>
<%if(h_tourokudata.getPref().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getPref()) %><% }else{ %>変更しません<% } %><br>
<br>
住所(市町村名～）：<br>
<%if(h_tourokudata.getJyusyo().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getJyusyo()) %><% }else{ %>変更しません<% } %></p>
<table border="1">
  <tbody>
    <tr>
      <td>連絡先電話番号(携帯可）：&nbsp;</td>
      <td><%if(h_tourokudata.getTelephone_No().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getTelephone_No()) %><% }else{ %>変更しません<% } %>&nbsp;</td>
    </tr>
  </tbody>
</table><br>
※住所・連絡先電話番号ともに変更できます。<br>
<br>
<br>
秘密の質問(ID・パスワードを忘れた場合に必要となります。あなただけが分かることを入力してください)<br>
<br>
質問:<%if(h_tourokudata.getSecret_Question().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getSecret_Question()) %><% }else{ %>変更しません<% } %><br>
<br>
答え:<%if(h_tourokudata.getSecret_Answer().equals("＊＊＊") == false){%><%=HttpUtility.escapeHTML(h_tourokudata.getSecret_Answer()) %><% }else{ %>変更しません<% } %><br>
<br>
※1:照合する際、文字列が完全に一致しないと確認できません。はっきりと覚えているものを使用してください。<br>
※2:質問とそれに対する答えとして成立していない場合、会員登録ができないことがあります。<br>
<br>
<p align="center"><a href='/G-pro_Service/P_Henkoutouroku'><img src="/G-pro_Service/image/Kakutei_Button.gif" width="61" height="48" border="0"></a><a href="#" onClick="history.back(); return false;"><img src="/G-pro_Service/image/Cansel_Button.gif" width="83" height="46" border="0"></a></p>
<input class="tourokubutton" type="submit" name="submit" value="変更を確定する">
<dl>
      <dd class="tourokubutton"><a href="#" onClick="history.back(); return false;">キャンセル</a></dd>
    </dl>
</body>
</html>