<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
     <%@ page import="buppan.ItemData" %>
     <%@ page import="buppan.ItemDAO"%>
     <jsp:useBean id="i_syousai" scope="session" type="java.util.ArrayList<buppan.ItemData>"/>
     <%@ page import="buppan.ShopData" %>
     <%@ page import="buppan.ShopDAO" %>
     <%@ page import="buppan.ShopSyousaiMaker" %>
     <jsp:useBean id="s_syousai" scope="session" type="buppan.ShopData"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="http://localhost/G-pro_Service/passed/buppancorner/Shoppage"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<title></title>
</head>
<body background="../buppanimage/wallppr043.gif">
<jsp:include page="header.jsp" flush="true"/>"
<p>ショップID:<%=s_syousai.getShopId() %>　ショップ名:<%=s_syousai.getSyouGou() %>　ショップ代表者：<%=s_syousai.getRepresentName() %><br>
</p>
<jsp:include page="<%=s_syousai.getPagePass() %>" flush="true"/>"
<br>
<img src="../buppanimage/line045.gif" width="750" height="18" border="0"><br>
<% for(ItemData I_Syousai : i_syousai){ %>
<form action="http://localhost/G-pro_Service/CartController" method="post">
<img src="<%=I_Syousai.getPictureName() %>" width="90" height="120" border="0" align="left">
<p style="background-color : orange;">商品ID:<%=I_Syousai.getItemId()%>商品カテゴリ：<%=I_Syousai.getItemCategorry() %>  商品名： <%=I_Syousai.getItemName() %> 価格：<%=I_Syousai.getPrice() %></p>
<p><%=I_Syousai.getItemDitail() %><br>
<br>
<br>
<input type="hidden" name="action" value="add">
<input type="hidden" name="index" value="<%=I_Syousai.getItemId() %>">
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<input type="image" name="submit" src="../buppanimage/button13.gif" width="111" height="26" border="0" alt="カートに入れる"></form><br>

<% } %>
<p><br>
　　　ショップ担当者名：<%=s_syousai.getChargeName() %>　　発売元問い合わせ用電話番号：<%=s_syousai.getSurpportTel() %><br>
発売元問い合わせ用E-Mail：<%=s_syousai.getToiawase() %><br>
          ショップ住所：郵便番号<%=s_syousai.getAddressNo() %>  <%=s_syousai.getPref() %><%=s_syousai.getCity() %>
<%=s_syousai.getAddress() %><%=s_syousai.getTatemono() %></p><br>
<br>
<p align="center"><a href="#" onClick="history.back(); return false;"><img src="../buppanimage/01c.gif" width="63" height="63" border="0"></a>　　　　　　　　　　　　　　　　<a href="http://localhost/G-pro_Service/passed/buppancorner/G-Pro_Shop_Top.jsp"><img src="../buppanimage/01a.gif" width="63" height="63" border="0"></a><br>
　　　　検索結果に戻る　　　　　　　　G-Proショップのトップに戻る</p>
<jsp:include page="footer.jsp" flush="true"/>
</body>
</html>