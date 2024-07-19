<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.lang.Boolean" %>
    <%@page import="coupon.Coupon_Naiyou_Update" %>
    <jsp:useBean id="result" scope="session" type="java.lang.Integer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Coupon/Coupon_Tekiyou_Result.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<title>クーポン適用結果</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"></p>
<% if(result == 0){ %>
<p><b><font size="+2">クーポン適用完了</font></b></p>
<p><b><font color="#0000cc" size="+1">ログイン中のG-PRO IDへクーポンを適用しました。引き続きG-PROjectをお楽しみください！</font></b></p>
<p><b>※クーポンの内容が反映されていない場合は、お手数ですが<br>
問い合わせフォーム(トップページにリンクがあります)からお問い合わせください。</b></p>
<% }else{ %>
<p><b><font size="+2">クーポン適用失敗</font></b></p>
<p><b><font color="#ff0000" size="+1">クーポンの適用に失敗しました。</font></b></p>
<p><b>お手数ですが問い合わせフォーム(トップページにリンクがあります)からお問い合わせください。</b></p>
<% } %>
<p align="center"><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="213" height="53" border="0"></a>　　　　　<a href="/G-pro_Service/Logout"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="213" height="53" border="0"></a></p>
</body>
</html>