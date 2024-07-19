<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ page import="java.util.ArrayList"%>
     <%@ page import="buppan.ItemData" %>
     <%@ page import="buppan.ItemDAO"%>
     <jsp:useBean id="osusume" scope="session" type="java.util.ArrayList<buppan.ItemData>"/>
     <jsp:useBean id="doujinshi" scope="session" type="java.util.ArrayList<buppan.ItemData>"/>
     <jsp:useBean id="tankoubon" scope="session" type="java.util.ArrayList<buppan.ItemData>"/>
     <jsp:useBean id="indiesgame" scope="session" type="java.util.ArrayList<buppan.ItemData>"/>
     <jsp:useBean id="funbook" scope="session" type="java.util.ArrayList<buppan.ItemData>"/>
     <jsp:useBean id="originalsound" scope="session" type="java.util.ArrayList<buppan.ItemData>"/>
     <%@ page import="buppan.ShopData" %>
     <%@ page import="buppan.ShopDAO" %>
     <%@ page import="buppan.TopPageMaker" %>
     <jsp:useBean id="newcommer" scope="session" type="java.util.ArrayList<buppan.ShopData>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<title>G-Pro Shopトップ</title>
</head>
<body background="/G-pro_Service/passed/buppanimage/Shop_Back.gif">
<p><img src="/G-pro_Service/passed/buppanimage/G-PRO_Shop_Logo.gif" width="298" height="55" border="0" alt="G-PRO　SHOP"></p>
<p>ここでは、様々なアイテムをダウンロード販売しています。</p>
<p><img src="/G-pro_Service/passed/buppanimage/Aibory_Bunner.gif" width="512" height="12" border="0"><br>
<i><b>ショップ情報で検索(指定しない項目は空欄にしてください)</b></i><br>
<form action="/G-pro_Service/ShopSyousaMaker" method="post">
ショップID：<input size="16" type="text" name="ShopId">　商品カテゴリ：<select name="Shopcategorry">
  <option value="指定なし" selected>指定なし</option>
  <option value="同人誌">同人誌</option>
  <option value="オリジナル単行本">オリジナル単行本</option>
  <option value="インディーズゲーム">インディーズゲーム</option>
  <option value="攻略本・ファンブック">攻略本・ファンブック</option>
  <option value="オリジナルサウンド">オリジナルサウンド</option>
</select> 販売者名（あいまい検索可）：<input size="20" type="text" name="Syougou"><br>
販売代表者名：<input size="12" type="text" name="representname">　販売担当者名：<input size="12" type="text" name="chargename">　販売者の所在する都道府県：<select name="pref">
  <option value="北海道">北海道</option>
  <option value="青森県">青森県</option>
  <option value="秋田県">秋田県</option>
  <option value="岩手県">岩手県</option>
  <option value="山形県">山形県</option>
  <option value="宮城県">宮城県</option>
  <option value="福島県">福島県</option>
  <option value="新潟県">新潟県</option>
  <option value="栃木県">栃木県</option>
  <option value="群馬県">群馬県</option>
  <option value="茨城県">茨城県</option>
  <option value="埼玉県">埼玉県</option>
  <option value="東京都">東京都</option>
  <option value="千葉県">千葉県</option>
  <option value="神奈川県">神奈川県</option>
  <option value="山梨県">山梨県</option>
  <option value="長野県">長野県</option>
  <option value="静岡県">静岡県</option>
  <option value="富山県">富山県</option>
  <option value="岐阜県">岐阜県</option>
  <option value="愛知県">愛知県</option>
  <option value="石川県">石川県</option>
  <option value="福井県">福井県</option>
  <option value="滋賀県">滋賀県</option>
  <option value="三重県">三重県</option>
  <option value="京都府">京都府</option>
  <option value="奈良県">奈良県</option>
  <option value="和歌山県">和歌山県</option>
  <option value="大阪府">大阪府</option>
  <option value="兵庫県">兵庫県</option>
  <option value="鳥取県">鳥取県</option>
  <option value="岡山県">岡山県</option>
  <option value="島根県">島根県</option>
  <option value="広島県">広島県</option>
  <option value="山口県">山口県</option>
  <option value="香川県">香川県</option>
  <option value="徳島県">徳島県</option>
  <option value="高知県">高知県</option>
  <option value="愛媛県">愛媛県</option>
  <option value="福岡県">福岡県</option>
  <option value="佐賀県">佐賀県</option>
  <option value="長崎県">長崎県</option>
  <option value="大分県">大分県</option>
  <option value="熊本県">熊本県</option>
  <option value="宮崎県">宮崎県</option>
  <option value="鹿児島県">鹿児島県</option>
  <option value="沖縄県">沖縄県</option>
  <option value="指定なし" selected>指定なし</option>
</select><br>
取扱商品：<input size="24" type="text" name="syouhin">　販売者の問い合わせ先E-Mail：<input size="24" type="text" name="toiawase"><br>
販売者のサポート電話番号（入力例：090-1111-2222）：<input size="22" type="text" name="surpporttel"><br>
<input type="hidden" name="moveflg" value=null>
<input type="image" src="/G-pro_Service/passed/buppanimage/Soushin_Button.gif" name="submit" width="90" height="34" border="0" alt="検索">
</form>
<form action="/G-pro_Service/ItemDataMaker" method="post">
<p><img src="/G-pro_Service/passed/buppanimage/Aibory_Bunner.gif" width="512" height="12" border="0"><br>
<b><i>商品情報で検索</i></b><br>ショップID：<input size="16" type="text" name="shopid2">　商品カテゴリ：<select name="itemcategorry2">
  <option value="指定なし" selected>指定なし</option>
  <option value="同人誌">同人誌</option>
  <option value="オリジナル単行本">オリジナル単行本</option>
  <option value="インディーズゲーム">インディーズゲーム</option>
  <option value="攻略本・ファンブック">攻略本・ファンブック</option>
  <option value="オリジナルサウンド">オリジナルサウンド</option>
</select>　商品ID:<input size="18" type="text" name="itemid"><br>
商品名（あいまい検索可）：<input size="32" type="text" name="itemname"> 価格:<input size="16" type="text" name="pricemin">円　～　<input size="16" type="text" name="pricemax">円<br>
<input type="image" src="/G-pro_Service/passed/buppanimage/Soushin_Button.gif" width="90" height="34" border="0" name="submit" alt="検索"></p>
</form>

<p><br>
<br>
<b><font size="+1">今月のおすすめ商品<br>
<br>
<% for (ItemData Osusume : osusume){ %>
</font></b><img src="<%=Osusume.getPictureName() %>" width="90" height="120" border="0" align="left"></p>
<form action="/G-pro_Service/CartController" method="post">
<p style="background-color : orange;"><%=Osusume.getItemName() %>          価格:<%=Osusume.getPrice() %>円                    残り在庫数：<%=Osusume.getZaikosu() %></p>
<p><%=Osusume.getItemDitail() %><br>
<br><%System.out.println(Osusume.getPictureName()); %>
<br>
<input type="hidden" name="action" value="add">
<input type="hidden" name="index" value="<%=Osusume.getItemId() %>">
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=Osusume.getShopId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>　　<input type="image" name="submit" src="/G-pro_Service/passed/buppanimage/IntoCart.gif" width="111" height="26" border="0" alt="カートに入れる">
</form>
<% } %>
<p><br>
<b><font size="+1">今月の新規出店者紹介<br>
<br>
<% for (ShopData NewCommer : newcommer){ %>
</font></b><img src="<%=NewCommer.getShopPicture() %>" width="90" height="120" border="0" align="left"></p>
<p style="background-color : lime;"><%=NewCommer.getSyouGou() %></p>
<p><%=NewCommer.getShopPr() %><br>
<br>
<br>
　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　　<a href='/G-pro_Service/ShopSyousaiMaker?sid=<%=NewCommer.getShopId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a></p>
<% } %>
<p><img src="/G-pro_Service/passed/buppanimage/Ranking_Logo.gif" width="152" height="47" border="0" alt="人気ランキング"></p>
<table border="1">
  <tbody>
    <tr>
      <td>&nbsp;</td>
      <td>&nbsp;<img src="/G-pro_Service/passed/buppanimage/Doujinshi_Logo.gif" width="124" height="55" border="0" alt="同人誌"></td>
      <td><img src="/G-pro_Service/passed/buppanimage/Tankoubon_Logo.gif" width="150" height="84" border="0" alt="オリジナル単行本">&nbsp;</td>
      <td><img src="/G-pro_Service/passed/buppanimage/IndiesGame_Logo.gif" width="174" height="84" border="0" alt="インディーズゲーム"></td>
      <td>&nbsp;<img src="/G-pro_Service/passed/buppanimage/FunBook_Logo.gif" width="159" height="84" border="0" alt="攻略本・ファンブック"></td>
      <td><img src="/G-pro_Service/passed/buppanimage/OriginalSound_Logo.gif" width="150" height="84" border="0" alt="オリジナルサウンド">&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;<img src="/G-pro_Service/passed/buppanimage/Rank1st.gif" width="66" height="55" border="0" alt="1st"></td>
      <td><img src="<%=doujinshi.get(0).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=doujinshi.get(0).getItemName() %><br>
      <%=doujinshi.get(0).getSyougou() %><br>
      <%=doujinshi.get(0).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=doujinshi.get(0).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a></td>
      <td><img src="<%=tankoubon.get(0).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=tankoubon.get(0).getItemName() %><br>
      <%=tankoubon.get(0).getSyougou() %><br>
      <%=tankoubon.get(0).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=tankoubon.get(0).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
      <td><img src="<%=indiesgame.get(0).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=indiesgame.get(0).getItemName() %><br>
      <%=indiesgame.get(0).getSyougou() %><br>
      <%=indiesgame.get(0).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=indiesgame.get(0).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
      <td>&nbsp;<img src="<%=funbook.get(0).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=funbook.get(0).getItemName() %><br>
      <%=funbook.get(0).getSyougou() %><br>
      <%=funbook.get(0).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=funbook.get(0).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a></td>
      <td><img src="<%=originalsound.get(0).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=originalsound.get(0).getItemName() %><br>
      <%=originalsound.get(0).getSyougou() %><br>
      <%=originalsound.get(0).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=originalsound.get(0).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;<img src="/G-pro_Service/passed/buppanimage/Rank2nd.gif" width="66" height="55" border="0" alt="1st"></td>
      <td><img src="<%=doujinshi.get(1).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=doujinshi.get(1).getItemName() %><br>
      <%=doujinshi.get(1).getSyougou() %><br>
      <%=doujinshi.get(1).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=doujinshi.get(1).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a></td>
      <td><img src="<%=tankoubon.get(1).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=tankoubon.get(1).getItemName() %><br>
      <%=tankoubon.get(1).getSyougou() %><br>
      <%=tankoubon.get(1).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=tankoubon.get(1).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
      <td><img src="<%=indiesgame.get(1).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=indiesgame.get(1).getItemName() %><br>
      <%=indiesgame.get(1).getSyougou() %><br>
      <%=indiesgame.get(1).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=indiesgame.get(1).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
      <td>&nbsp;<img src="<%=funbook.get(1).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=funbook.get(1).getItemName() %><br>
      <%=funbook.get(1).getSyougou() %><br>
      <%=funbook.get(1).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=funbook.get(1).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a></td>
      <td><img src="<%=originalsound.get(1).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=originalsound.get(1).getItemName() %><br>
      <%=originalsound.get(1).getSyougou() %><br>
      <%=originalsound.get(1).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=originalsound.get(1).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;<img src="/G-pro_Service/passed/buppanimage/Rank3rd.gif" width="66" height="55" border="0" alt="1st"></td>
      <td><img src="<%=doujinshi.get(2).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=doujinshi.get(2).getItemName() %><br>
      <%=doujinshi.get(2).getSyougou() %><br>
      <%=doujinshi.get(2).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=doujinshi.get(2).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a></td>
      <td><img src="<%=tankoubon.get(2).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=tankoubon.get(2).getItemName() %><br>
      <%=tankoubon.get(2).getSyougou() %><br>
      <%=tankoubon.get(2).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=tankoubon.get(2).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
      <td><img src="<%=indiesgame.get(2).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=indiesgame.get(2).getItemName() %><br>
      <%=indiesgame.get(2).getSyougou() %><br>
      <%=indiesgame.get(2).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=indiesgame.get(2).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
      <td>&nbsp;<img src="<%=funbook.get(2).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=funbook.get(2).getItemName() %><br>
      <%=funbook.get(2).getSyougou() %><br>
      <%=funbook.get(2).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=funbook.get(2).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a></td>
      <td><img src="<%=originalsound.get(2).getPictureName() %>" width="90" height="120" border="0"><br>
      <%=originalsound.get(2).getItemName() %><br>
      <%=originalsound.get(2).getSyougou() %><br>
      <%=originalsound.get(2).getPrice() %>　　　<a href='/G-pro_Service/ItemSyousaiMaker?itemid=<%=originalsound.get(2).getItemId() %>'><img src="/G-pro_Service/passed/buppanimage/GotoSyousai.gif" width="111" height="26" border="0" alt="詳細ページへ"></a>&nbsp;</td>
    </tr>
  </tbody>
</table>
<p align="center"><br>
<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/buppanimage/Backto.gif" width="63" height="63" border="0"></a><br>
会員メニューに戻る</p>
</body>
</html>
