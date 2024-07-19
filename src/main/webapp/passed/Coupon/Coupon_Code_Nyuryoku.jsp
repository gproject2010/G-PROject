<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@page import="k_jyouhou.R_jyouhou_TO" %>
    <%@page import="k_jyouhou.R_jyouhou_DAO" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Coupon/Coupon_Code_Nyuryoku.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<title>G-PROクーポン適用(コード入力)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"></p>
<p><b><font size="+2">G-PROクーポン適用</font></b></p>
<p><font color="#0000cc">現在ログイン中のG-PRO IDにクーポンを適用します。<br>
クーポンに記載されている12ケタのコードを“-”(ハイフン)も含めて半角英数字で入力し、「送信」をクリックしてください。<br>
※スペースは取り除いてください</font></p>
<p><b>適用先のG-PRO ID:</b><%=seiseki.getk_Id() %></p>
<form action="/G-pro_Service/Coupon_NaiyouMaker" method="post">
<p><b>適用するクーポンコード：</b><input size="30" type="text" maxlength="30" name="coupon_code" value="入力してください"></p>
<p align="center"><input type="image" name="submit" src="/G-pro_Service/image/Soushin_Button.gif" width="66" height="52" border="0">　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="213" height="53" border="0"></a></p>
</form>
</body>
</html>