<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "Error.jsp"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="http://localhost/G-pro_Service/passed/buppancorner/G-Pro_Shop_Top"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>G-Pro Shopトップ</title>
</head>
<body background="../buppanimage/wallppr043.gif">
<%--ここにヘッダ部を挿入 --%>
<jsp:include page="header.jsp" flush="true"/>
<table align = "center">
<tr valign="top">
<td>
<%--ここにコマンド部を挿入 --%>
</td>
<td>
<%--ここにキャンパス部を挿入 --%>
<jsp:include page="splineup.jsp" flush="true"/>
</td>
</tr>
</table>
<%--ここにフッタ部を挿入 --%>
<jsp:include page="footer.jsp" flush="true"/>"
</body>
</html>