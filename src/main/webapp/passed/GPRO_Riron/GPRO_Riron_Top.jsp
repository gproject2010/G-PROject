<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="gpro_riron.GPRiron_TO" %>
    <%@ page import="gpro_riron.GPRiron_DAO" %>
    <%@ page import="gpro_riron.Riron_TopPageMaker" %>
    <jsp:useBean id="mydata" scope="session" type="java.util.ArrayList<gpro_riron.GPRiron_TO>"/>
    <jsp:useBean id="otherdata" scope="session" type="java.util.ArrayList<gpro_riron.GPRiron_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/GPRO_Riron/GPRO_Riron_Top.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRiron.css"/>
<title>G-PRO_Re:論。トップ</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/GRiron_Logo.gif" width="371" height="122" border="0"></p>
<p><b><font size="+3">論文一覧</font></b></p>
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Your_Upload.gif" width="293" height="41" border="0" alt="あなたがアップロードした論文"></p>
<table border="1">
  <tbody>
    <tr>
      <td>論文コード</td>
      <td>論文タイトル</td>
      <td>アップロード日時</td>
      <td>閲覧・編集</td>
    </tr>
    <% for(GPRiron_TO mylist : mydata){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(mylist.getRonbunCode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(mylist.getRonbunTitle()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(mylist.getUploadDate()) %>&nbsp;</td>
      <td>
      <form action="/G-pro_Service/Ronbun_SyousaiLoad" method="post">
      <input type="hidden" name="ronbuncode" value="<%=mylist.getRonbunCode() %>">
      <input type="hidden" name="ronbunsyubetsu" value="mydata">
      <input class="tourokubutton" type="submit" name="submit" value="編集">
      </form>
      </td>
    </tr>
    <% } %>
  </tbody>
</table>
<p><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Other_Upload.gif" width="374" height="41" border="0" alt="他のプレイヤーがアップロードした論文"></p>
<table border="1">
  <tbody>
    <tr>
      <td>論文コード</td>
      <td>論文タイトル</td>
      <td>アップロード者<br>
      プレイヤーネーム</td>
      <td>アップロード日時</td>
      <td>閲覧・<br>
      レスポンス作成</td>
    </tr>
    <% for(GPRiron_TO otherlist : otherdata){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(otherlist.getRonbunCode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(otherlist.getRonbunTitle()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(otherlist.getPlayerName()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(otherlist.getUploadDate()) %>&nbsp;</td>
      <td>
      <form action="/G-pro_Service/Ronbun_SyousaiLoad" method="post">
      <input type="hidden" name="ronbuncode" value="<%=otherlist.getRonbunCode() %>">
      <input type="hidden" name="ronbunsyubetsu" value="otherdata">
      <input class="tourokubutton" type="submit" name="submit" value="閲覧・レスポンス">
      </form>
      </td>
    </tr>
    <% } %>
  </tbody>
</table>
<!-- <p><a href="/G-pro_Service/passed/GPRO_Riron/Ronbun_ShinkiSakusei.jsp"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/Ronbun_Shinkisakusei.gif" width="273" height="39" border="0" alt="論文の新規作成"></a></p>
<p><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/passed/GPRO_Riron/GRiron_Images/BacktoKaiinTop.gif" width="129" height="42" border="0" alt="会員メニューに戻る"></a></p>
-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/passed/GPRO_Riron/Ronbun_ShinkiSakusei.jsp">論文の新規作成</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</body>
</html>