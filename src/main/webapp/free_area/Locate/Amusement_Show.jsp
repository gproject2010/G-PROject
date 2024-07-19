<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="inputUtility.HttpUtility" %>
    <%@page import="location.LocateData_TO" %>
    <%@page import="location.LocateData_DAO" %>
    <%@page import="location.LocateData_Maker" %>
    <jsp:useBean id="locatedata" scope="session" type="location.LocateData_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<style type="text/css">
img#sumneile{
	max-width:360px;
	max-height:240px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title><%=locatedata.getLocate_Name() %>の情報</title>
</head>
<body background="/G-pro_Service/image/Event_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="342" height="131" border="0"></p>
<p><b><font size="+2">ゲームショップ情報(アミューズメント施設)</font></b></p>
<table border="0">
<tr>
<td>
<table border="1" align="left">
  <tbody>
    <tr>
      <td><img src="/G-pro_Service/LogoImage_Load/<%=locatedata.getFreeFile_Name() %>?syubetsu=shop_syoukai" id="sumneile"/>
    </tr>
    <tr>
      <td><b><font size="+1">アクセス<br></font></b>
      <pre><%=locatedata.getAccess() %></pre></td>
    </tr>
  </tbody>
</table>
</td>
<td>
<table border="1">
  <tbody>
    <tr>
      <td><b><font size="+2"><%=HttpUtility.escapeHTML(locatedata.getLocate_Name()) %></font></b></td>
    </tr>
    <tr>
      <td>住所:<%=HttpUtility.escapeHTML(locatedata.getAddress()) %></td>
    </tr>
    <tr>
      <td>TEL:<%=HttpUtility.escapeHTML(locatedata.getTelNo()) %></td>
    </tr>
    <tr>
      <td>営業時間：<%=HttpUtility.escapeHTML(locatedata.getEigyoujikan()) %></td>
    </tr>
    <tr>
      <td>店舗HP:<%=locatedata.getLocate_HP() %></td>
    </tr>
    <tr>
      <td>駐車場：<pre><%=locatedata.getParking() %></pre></td>
    </tr>
    <tr>
      <td>喫煙可否:<pre><%=locatedata.getCigar() %></pre></td>
    </tr>
    <tr>
      <td>バリアフリー対応:<pre><%=locatedata.getBariaFree() %></pre></td>
    </tr>
    <tr>
      <td><font size="+1"><b>建物内施設</b></font><br>
      <pre><%=locatedata.getIndoor_Shisetsu() %></pre></td>
    </tr>
    <tr>
      <td><b><font size="+1">周辺施設</font></b><br>
      <pre><%=locatedata.getOutdoor_Shisetsu() %></pre></td>
    </tr>
    <tr>
      <td><font size="+1"><b>設置ゲーム機</b></font><br>
      <pre><%=locatedata.getGames() %></pre></td>
    </tr>
  </tbody>
</table>
</td>
</tr>
</table>
<b><font size="+1"><a href="#" onClick="history.back(); return false;"><img src="/G-pro_Service/image/Modoru_Button.gif" width="68" height="54" border="0" alt="戻る"></a></font></b>
</body>
</html>