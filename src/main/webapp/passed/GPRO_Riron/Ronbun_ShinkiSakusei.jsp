<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="ninsyou.AuthenticationController" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/GPRO_Riron/Ronbun_ShinkiSakusei.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRiron.css"/>
<title>論文の新規作成 | 熱く語れ!G-PRO_Re:論。</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/GRiron_Logo.gif" width="371" height="122" border="0"></p>
<p><b><font size="+3">論文の新規作成</font></b></p>
<form action="/G-pro_Service/Ronbun_Shinki_Kakunin" method="post" enctype="multipart/form-data">
<p><b>論文の題名：</b><input size="50" type="text" maxlength="50" name="ronbuntitle" value="入力してください"></p>
<p><b><font size="+2">ソースコード</font></b></p>
<p><b>※1:ソースに使用できるタグ（HTML5準拠）：下表のタグが使用できます。作成する前にご確認ください。</b></p>
<table border="1">
  <tbody>
    <tr>
      <td>&lt;html&gt;</td>
      <td>&lt;head&gt;</td>
      <td>&lt;title&gt;</td>
      <td>&lt;body&gt;</td>
      <td>&lt;section&gt;</td>
      <td>&lt;nav&gt;</td>
      <td>&lt;article&gt;</td>
      <td>&lt;aside&gt;</td>
      <td>&lt;h1&gt;～&lt;h6&gt;</td>
      <td>&lt;hgroup&gt;</td>
    </tr>
    <tr>
      <td>&lt;header&gt;</td>
      <td>&lt;footer&gt;</td>
      <td>&lt;address&gt;</td>
      <td>&lt;p&gt;</td>
      <td>&lt;hr&gt;</td>
      <td>&lt;blockquote&gt;</td>
      <td>&lt;ol&gt;</td>
      <td>&lt;ul&gt;</td>
      <td>&lt;li&gt;&nbsp;</td>
      <td>&nbsp;&lt;dl&gt;</td>
    </tr>
    <tr>
      <td>&lt;dt&gt;</td>
      <td>&lt;dd&gt;</td>
      <td>&lt;figure&gt;</td>
      <td>&lt;figcaption&gt;</td>
      <td>&lt;div&gt;</td>
      <td>&lt;em&gt;</td>
      <td>&lt;strong&gt;</td>
      <td>&lt;small&gt;</td>
      <td>&lt;s&gt;&nbsp;</td>
      <td>&nbsp;&lt;cite&gt;</td>
    </tr>
    <tr>
      <td>&lt;q&gt;</td>
      <td>&lt;dfn&gt;</td>
      <td>&lt;abbr&gt;</td>
      <td>&lt;time&gt;</td>
      <td>&lt;sub&gt;</td>
      <td>&lt;sup&gt;</td>
      <td>&lt;i&gt;</td>
      <td>&lt;b&gt;</td>
      <td>&lt;u&gt;&nbsp;</td>
      <td>&lt;mark&gt;&nbsp;</td>
    </tr>
    <tr>
      <td>&lt;ruby&gt;</td>
      <td>&lt;rt&gt;&nbsp;</td>
      <td>&lt;rp&gt;&nbsp;</td>
      <td>&lt;bdi&gt;&nbsp;</td>
      <td>&lt;bdo&gt;&nbsp;</td>
      <td>&lt;span&gt;&nbsp;</td>
      <td>&lt;br&gt;&nbsp;</td>
      <td>&lt;wbr&gt;&nbsp;</td>
      <td>&lt;ins&gt;&nbsp;</td>
      <td>&lt;del&gt;&nbsp;</td>
    </tr>
    <tr>
      <td>&lt;table&gt;&nbsp;</td>
      <td>&lt;caption&gt;&nbsp;</td>
      <td>&lt;colgroup&gt;&nbsp;</td>
      <td>&lt;col&gt;&nbsp;</td>
      <td>&lt;tbody&gt;&nbsp;</td>
      <td>&lt;thead&gt;&nbsp;</td>
      <td>&lt;tfoot&gt;&nbsp;</td>
      <td>&lt;tr&gt;&nbsp;</td>
      <td>&lt;td&gt;&nbsp;</td>
      <td>&lt;th&gt;&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;&lt;style&gt;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
      <td>&nbsp;</td>
    </tr>
  </tbody>
</table>
<p><b>※2:論文には3つまで画像を使用できます。挿入位置に下記の専用タグを記述の上、最下部のフォームに<br>
挿入位置に対応するファイルを指定してください。<br>
<br>
・画像挿入専用のタグ：&lt;image1&gt;、&lt;image2&gt;、&lt;image3&gt;の3つです。最下部にあるそれぞれのアップロードフォームに<br>
対応しています。(閉じる必要はありません)</b></p>
<p><b>※3:背景に画像は指定できません。</b></p>
<p><b>※4:CSSを使用する場合はHTML内に直接記述してください。CSSファイルのアップロードには対応しておりませんので<br>
ご注意ください。</b></p>
<textarea rows="100" cols="100" name="sourcecode">ここにHTMLを記述してください</textarea>
<p><b>※最大全角20文字以上、25,000文字以内（タグの記述の分も含む）</b></p>
<p><b>挿入する画像データのアップロード</b></p>
<p><b>&lt;image1&gt;タグの位置に挿入する画像ファイル:<input type="file" name="imagefile1"></b></p>
<p><b>&lt;image2&gt;タグの位置に挿入する画像ファイル:<input type="file" name="imagefile2"></b></p>
<p><b>&lt;image3&gt;タグの位置に挿入する画像ファイル:<input type="file" name="imagefile3"></b></p>
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Your_Data.gif" width="300" height="60" border="0"><b>※必ず確認してください。</b></p>
<p><b>G-PRO　ID:<%=HttpUtility.escapeHTML(seiseki.getk_Id()) %></b></p>
<p><b>プレイヤーネーム：<%=HttpUtility.escapeHTML(seiseki.getlogin_name()) %></b></p>
<!-- <p><input type="image" name="submit" src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Kakutei_Button.gif"  width="67" height="52" border="0" alt="確定">　　　　　<img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoRironTop.gif"  width="328" height="53" border="0" alt="G-PRO_Re:論。トップに戻る">　　　　　<img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoKaiinTop.gif"  width="213" height="53" border="0" alt="会員メニューに戻る"></p>-->
<input class="tourokubutton" type="submit" name="submit" value="論文を登録する">
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/Riron_TopPageMaker">G-PRO_Re:論。トップに戻る</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</form>
</body>
</html>