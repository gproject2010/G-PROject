<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.lang.String" %>
     <%@ page import="java.lang.Boolean" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="gpro_riron.GPRiron_TO" %>
    <%@ page import="gpro_riron.GPRiron_DAO" %>
    <%@ page import="gpro_riron.Ronbun_SyousaiLoad" %>
    <%@ page import="gpro_riron.Ronbun_Shinki_Kakunin" %>
    <%@ page import="gpro_riron.Ronbun_Touroku_Cansel" %>
    <jsp:useBean id="source" scope="session" type="java.lang.String"/>
    <jsp:useBean id="newdata" scope="session" type="gpro_riron.GPRiron_TO"/>
    <jsp:useBean id="wrongtag" scope="session" type="java.lang.String"/>
    <jsp:useBean id="wrongtitle" scope="session" type="java.lang.String"/>
    <jsp:useBean id="wrongword" scope="session" type="java.lang.String"/>
    <jsp:useBean id="wronglength" scope="session" type="java.lang.Boolean"/>
    <jsp:useBean id="errorlist" scope="session" type="gpro_riron.GPRiron_TO"/>
    <jsp:useBean id="etcerror" scope="session" type="java.lang.Boolean"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/GPRO_Riron/Ronbun_Shinki_Syusei.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRiron.css"/>
<title>論文の新規作成（修正）</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/GRiron_Logo.gif" width="371" height="122" border="0"></p>
<p><b><font size="+3">論文の新規作成（修正）</font></b></p>
<form action="/G-pro_Service/Ronbun_Shinki_Kakunin" method="post" enctype="multipart/form-data">
<p><b>論文コード:<%=HttpUtility.escapeHTML(newdata.getRonbunCode()) %></b></p>
<p><b>論文の題名：<input type="text" name="ronbuntitle" size="50" maxlength="50" value="<%=HttpUtility.escapeHTML(newdata.getRonbunTitle()) %>"></b></p>
<p><b><font size="+2">ソースコード編集</font></b></p>
<% if(!(wrongtag.equals(""))){ %>
<p><b><font color="#ff0000" size="+1">エラー:ソースコードに使用できないタグが含まれています。（検出されたタグ:<%=wrongtag %>）訂正して再試行してください。</font></b></p>
<% } %>
<% if(!(wrongtitle.equals(""))){ %>
<p><b><font color="#ff0000" size="+1">エラー:論文のタイトルに使用できない単語が含まれています。（検出されたNGワード:<%=wrongtitle %>）訂正して再試行してください。</font></b></p>
<% } %>
<% if(!(wrongword.equals(""))){ %>
<p><b><font color="#ff0000" size="+1">エラー:ソースコードに使用できない単語が含まれています。（検出されたNGワード:<%=wrongword %>）訂正して再試行してください。</font></b></p>
<% } %>
<% if(wronglength == true){ %>
<p><b><font color="#ff0000" size="+1">エラー:ソースコードの文字数が足りないか、制限をオーバーしています。</font></b></p>
<% } %>
<% if(request.getHeader("referer").equals("/G-pro_Service/Ronbun_Touroku_Cansel") && (!(errorlist.getImgFileUploadError1().equals("") && errorlist.getImgFileUploadError2().equals("") && errorlist.getImgFileUploadError3().equals("") && errorlist.getHTMLFileUploadError().equals("") && etcerror == false))){ %>
<p><b>※前回登録をキャンセルした際に一時ファイルの削除に失敗しています。もう一度設定を行ってください。</b></p>
<% } %>
<p><b>※1:ソースに使用できるタグ（HTML5準拠）：下表のタグが使用できます。変更する前にご確認ください。</b></p>
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
      <td>&nbsp;&lt;meta&gt;</td>
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
対応しています。（閉じる必要はありません）</b></p>
<p><b>※3:背景に画像は指定できません。</b></p>
<p><b>※4:CSSを使用する場合はHTML内に直接記述してください。CSSファイルのアップロードには対応しておりませんので<br>
ご注意ください。</b></p>
<textarea rows="100" cols="200" name="sourcecode"><%=source %></textarea>
<p><b>※最大全角20文字以上、25,000文字以内（タグの記述の分も含む）<br>
なお、フォームの横幅は全角100文字分です。</b></p>
<p><b>挿入する画像データのアップロード(もう一度設定してください)</b>
<p><b>&lt;image1&gt;タグの位置に挿入する画像ファイル:<input type="file" name="imagefile1"></b></p>
<p><b>&lt;image2&gt;タグの位置に挿入する画像ファイル:<input type="file" name="imagefile2"></b></p>
<p><b>&lt;image3&gt;タグの位置に挿入する画像ファイル:<input type="file" name="imagefile3"></b></p>
<p>※画像データのサイズ:1つにつき1MBまで</p>
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Your_Data.gif" width="300" height="60" border="0"><b>※必ず確認してください。</b></p>
<p><b>G-PRO　ID:<%=HttpUtility.escapeHTML(newdata.getPlayer_Id()) %></b></p>
<p><b>プレイヤーネーム：<%=HttpUtility.escapeHTML(newdata.getPlayerName()) %></b></p>
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