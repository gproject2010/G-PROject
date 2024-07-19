<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <%@ page import="java.util.ArrayList"%>
    <%@ page import="buppan.ShopData" %>
     <%@ page import="buppan.ShopDAO" %>
     <%@ page import="buppan.ShopDataMaker" %>
     <jsp:useBean id="s_hitlist" scope="session" type="java.util.ArrayList<buppan.ShopData>"/>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="http://localhost/G-pro_Service/passed/buppancorner/ShopSerchResult.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<title></title>
</head>
<body background="../buppanimage/wallppr043.gif">
<jsp:include page="header.jsp" flush="true"/>
<p><font size="+3">検索結果</font></p>
<p><br>
<font size="+2">${sessionScope.pagest + 1}～${sessionScope.pagefin}件目を表示中/ヒット件数：${sessionScope.s_resultcount}件</font></p>
<p><br>
</p>
<c:if test="${(sessionScope.pagefin + 1) < (sessionScope.s_resultcount)}">
<p align="right"><a href='http://localhost/G-pro_Service/ShopDataMaker?moveflg=forward'>次の20件</a></p>
</c:if>
<% for(ShopData S_Hitlist : s_hitlist){ %>
<p><img src="<%=S_Hitlist.getShopPicture() %>" width="90" height="120" border="0" align="left"></p>
<p style="background-color : lime;"><%=S_Hitlist.getSyouGou() %></p>
<p><%=S_Hitlist.getShopPr() %><br>
<br>
<br>
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<a href='http://localhost/G-pro_Service/ShopSyousaiMaker?sid=<%=S_Hitlist.getShopId() %>'><img src="../buppanimage/button22.gif" width="111" height="26" border="0" alt="詳細ページへ"></a><br>
<br>
ショップID:<%=S_Hitlist.getShopId() %>　商品カテゴリ：<%= S_Hitlist.getItemCategorry() %>　 所在都道府県：<%=S_Hitlist.getPref() %>　　ショップ担当者名：<%=S_Hitlist.getChargeName() %></p>
<c:if test="${(sessionScope.pagest) > (sessionScope.s_resultcount)}">
<p><a href='http://localhost/G-pro_Service/ShopDataMaker?moveflg=back'>前の20件</a></p>
</c:if>
<% } %>
<p align="center"><a href="G-Pro_Shop_Top.jsp"><img src="../buppanimage/01c.gif" width="63" height="63" border="0"></a><br>
G-Proショップのトップに戻る</p>
<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>