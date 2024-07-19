<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO" class="g_jyouhou.GS_jyouhou_TO"/>
    <jsp:useBean id="up_flg" scope="session" type="java.lang.Integer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Game_Data_Show.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Reports.css"/>
<title>ゲームデータ詳細</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GameData_Back.gif" style="font-weight : bold;">
<p style="font-weight : bolder;border-spacing : inherit;">　　　<img src="/G-pro_Service/passed/GData_Images/GData_Logo.gif" width="232" height="67" border="0" align="left"/><br>
<br>
　　　<img src="/G-pro_Service/passed/GData_Images/GCode_Logo.gif" width="87" height="32" border="0"/>　<font size="+3"><%=HttpUtility.escapeHTML(syousai.getGamecode())%><br>
<br>
</font></p>
<p><img src="/G-pro_Service/passed/GData_Images/GTitle_Logo.gif" width="140" border="0"/><font size="+4"><b>　<%=HttpUtility.escapeHTML(syousai.getGametitle())%></b></font></p><br>
<br>
<%if(syousai.getLogoaddress() != null && (!(syousai.getLogoaddress().equals("")))){%>
<img src="/G-pro_Service/LogoImage_Load/<%=syousai.getLogoaddress()%>?syubetsu=gamedata"><br>
<% } %>
<br>
<p style="font-weight : bold;"><img src="/G-pro_Service/passed/GData_Images/Publisher_Logo.gif" width="87" height="32" border="0"><b><font size="+2">　<%=HttpUtility.escapeHTML(syousai.getMakername()) %>　　　　　</font><img src="/G-pro_Service/passed/GData_Images/Developer_Logo.gif" width="89" border="0"/>   <%for(String Devname : syousai.getDeveloper_Name()){ %> <%=HttpUtility.escapeHTML(Devname) %>, <% } %><br>
<img src="/G-pro_Service/passed/GData_Images/Platform_Logo.gif" width="86" height="30" border="0"/><font size="+2"><%=HttpUtility.escapeHTML(syousai.getPlatform())%></font><br>
<font size="+2">
<br>
<img src="/G-pro_Service/passed/GData_Images/Rating_Logo.gif" width="118" border="0"/>　<%=HttpUtility.escapeHTML(syousai.getRating())%>　　　<img src="/G-pro_Service/passed/GData_Images/Hatsubaibi_Logo.gif" width="98" border="0"/>　<%=HttpUtility.escapeHTML(syousai.getHatsubainengappi())%>
<br>
<img src="/G-pro_Service/passed/GData_Images/MainGenre_Logo.gif" width="110" border="0"/>　<%=HttpUtility.escapeHTML(syousai.getMaingenre())%>　　　　　<br>
<br>
<img src="/G-pro_Service/passed/GData_Images/SubGenre1_Logo.gif" width="102" border="0"/>　<%=HttpUtility.escapeHTML(syousai.getSubgenre1())%></font></b>　　　　　　　　<img src="/G-pro_Service/passed/GData_Images/SubGenre2_Logo.gif" width="102" border="0"/>　　　<font size="+2"><%=HttpUtility.escapeHTML(syousai.getSubgenre2())%></font><br>
</p>
<p><br>
<img src="/G-pro_Service/passed/GData_Images/Gaiyou_Logo.gif" width="232" border="0" height="51"/><br>
<b><%=HttpUtility.escapeHTML(syousai.getGaiyou())%><br>
Reported By <%=HttpUtility.escapeHTML(syousai.getBestgaiyou()) %><br>
</b><br>
<br>
<img src="/G-pro_Service/passed/GData_Images/Lisence_Logo.gif" width="195" height="64" border="0" align="left"/><br>
<font size="+2"><b><%=HttpUtility.escapeHTML(syousai.getLisence())%>:<%if(syousai.getLisence().equals("条件有り")){ %><%=HttpUtility.escapeHTML(syousai.getKyokajyouken()) %><% } %></b></font><br>
<br>
<br>
<%if(syousai.getMovieaddress() != null && (!(syousai.getMovieaddress().equals("")))){ %>
<a href="<%=syousai.getMovieaddress() %>"><img src="/G-pro_Service/passed/GData_Images/Syoukai_Movie.gif" width="171" height="69" border="0"/></a><br>
<b>↑クリックするとこのゲームの紹介ムービーが閲覧できます。<br>
（Windows Media Playerなどの動画再生ソフトが必要です。)<br>
</b><br>
<% } %>
<br>
<br>
<br>
<img src="/G-pro_Service/passed/GData_Images/G-Score_Bunner.jpg" width="256" height="45" border="0"/><br>
<br>
<img src="/G-pro_Service/passed/GData_Images/Dai1insyou_R.gif" width="195" height="26" border="0"/>　　　　　獲得G-Score：<%if(syousai.getReport_Count() > 0){%><%=HttpUtility.Round(syousai.getDai1_Insyou(), 2, "cut") %>　　　　　 ランキング：<%=syousai.getDai1_Insyou_R() %>位/全<%=syousai.getG_Count() %>作品中<%}else{%>NO_DATA<% } %><br>
<br>
<br>
<img src="/G-pro_Service/passed/GData_Images/Ninkisaku_R.gif" width="187" height="23" border="0"/>　　　　　　レポート受付数累計：<%if(syousai.getReport_Count() > 0){%><%=syousai.getReport_Count()%>　ランキング：<%=syousai.getRep_Count_R() %>位/全<%=syousai.getG_Count() %>作品中<%}else{%>NO_DATA<% } %><br>
<br>
<br>
<img src="/G-pro_Service/passed/GData_Images/BigHit_R.gif" width="182" height="22" border="0"/>　　　　　　年間獲得G-Score：<%if(syousai.getReport_Count() > 0){%><%=HttpUtility.Round(syousai.getNenkan(), 2, "cut")%>　ランキング:<%=syousai.getNenkan_R() %>位/全<%=syousai.getG_Count() %>作品中<%}else{%>NO_DATA<% } %><br>
<br>
<br>
<img src="/G-pro_Service/passed/GData_Images/Meisaku_R.gif" width="188" height="23" border="0"/>　　　　　獲得G-Score累計：<%if(syousai.getReport_Count() > 0){%><%=HttpUtility.Round(syousai.getG_Score(), 2, "cut") %>　ランキング:<%=syousai.getG_Score_R() %>位/全<%=syousai.getG_Count() %>作品中<%}else{%>NO_DATA<% } %><br>
<br>
<br>
<img src="/G-pro_Service/passed/GData_Images/Hyoukatensu_Bunner.jpg" width="243" height="42" border="0"/><br>
<br>
<br>
全提出者の平均点数：</p>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>&nbsp;評価項目</td>
      <td>評価点&nbsp;</td>
      <td align="center">満点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;難易度の適正度</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getdificultty() / (double)syousai.getReport_Count()%>" max="10"></meter><%=HttpUtility.Round(syousai.getdificultty() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;キャラクター・シナリオ（世界観）</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getstory() / (double)syousai.getReport_Count()%>" max="10"></meter><%=HttpUtility.Round(syousai.getstory() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;グラフィック </td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getgraphic() / (double)syousai.getReport_Count()%>" max="10"></meter><%=HttpUtility.Round(syousai.getgraphic() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;サウンド</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getsound() / (double)syousai.getReport_Count()%>" max="10"></meter><%=HttpUtility.Round(syousai.getsound() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td>&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;ボリューム度・ハマり度</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getvolume() / (double)syousai.getReport_Count()%>" max="10"></meter><%=HttpUtility.Round(syousai.getvolume() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td align="center">/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;操作性</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getcontroll() / (double)syousai.getReport_Count()%>" max="10"></meter><%=HttpUtility.Round(syousai.getcontroll() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td align="center">&nbsp;/10点</td>
    </tr>
    <tr>
      <td>&nbsp;プロモーション</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getpromotion() / (double)syousai.getReport_Count()%>" max="10"></meter><%=HttpUtility.Round(syousai.getpromotion() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td>/10点&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;提出者の考えによる自由点</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=syousai.getfree_S() / (double)syousai.getReport_Count()%>" max="30"></meter><%=HttpUtility.Round(syousai.getfree_S() / (double)syousai.getReport_Count(), 2, "4/5")%>点<%}else{%>NO_DATA<% } %></td>
      <td>&nbsp;/30点</td>
    </tr>
    <tr>
      <td>&nbsp;トータル</td>
      <td><%if(syousai.getReport_Count() > 0){%><meter value="<%=(syousai.getdificultty() + syousai.getstory() + syousai.getgraphic() + syousai.getsound() + syousai.getvolume() + syousai.getcontroll() + syousai.getpromotion() + syousai.getfree_S()) / syousai.getReport_Count() %>" max="100"></meter><%=(syousai.getdificultty() + syousai.getstory() + syousai.getgraphic() + syousai.getsound() + syousai.getvolume() + syousai.getcontroll() + syousai.getpromotion() + syousai.getfree_S()) / syousai.getReport_Count() %>点<%}else{%>NO_DATA<% } %></td>
      <td>&nbsp;/100点</td>
    </tr>
  </tbody>
</table>
<p><br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<% if(up_flg == 9999 || up_flg >= syousai.getSeigen_Kaisu()){ %>
<font size="+1" color="red">レポートの提出回数を使い切っているため、このゲームに対するレポートは作成できません。</font>
<%}else{ %>
<a href="/G-pro_Service/passed/Rep_Yobidashi.jsp" target="_blank"><img src="/G-pro_Service/passed/GData_Images/Report_Make.gif" width="157" height="65" border="0" align="middle"/></a><br>
このゲームに対するレポートはあと　<%= syousai.getSeigen_Kaisu() - up_flg %>　回作成できます。<br>
<% } %>
<br>
<br>
<%if(syousai.getReport_Count() > 0){ %>
<img src="/G-pro_Service/passed/GData_Images/Report_Naiyou_Bunner.jpg" width="240" height="36" border="0"/><br>
<br>
<img src="/G-pro_Service/passed/GData_Images/Marubatsu_Logo.jpg" width="240" height="46" border="0"/>○×レポートで目立った記述を紹介します。<br>
<br>
「良かった所」キーワード<br>
<%if(syousai.getGoodkeyword()[0].equals("NO_DATA")){ %>
NO DATA
<%}else{%>
<%for(int i=0; i < syousai.getGoodkeyword().length; i++){ %>
<%=HttpUtility.escapeHTML(syousai.getGoodkeyword()[i]) %>     <%if (i % 3 == 0){ %><br><% } %>
<% } %>
<% } %>
<br>
「今後の課題」キーワード<br>
<%if(syousai.getBadkeyword()[0].equals("NO_DATA")){ %>
NO DATA
<%}else{ %>
<%for(int j = 0; j < syousai.getBadkeyword().length; j++){ %><br>
<%=HttpUtility.escapeHTML(syousai.getBadkeyword()[j]) %>     <%if (j % 3 == 0){ %><br><% } %>
<% } %>
<% } %>
<br>
<br>
<br>
<img src="GData_Images/Kiji_Report_Logo.jpg" width="245" height="67" border="0"/>紹介記事レポート・自由形式レポートに記述されたコメントを紹介します。<br>
<br>
<%if(syousai.getMainkeyword()[0].equals("NO_DATA")){ %>
NO DATA
<%}else{ %>
</p>
<table border="1">
  <tbody>
    <tr>
      <td>レポートで目立った記述（キーワード）&nbsp;</td>
      <td>記述に関するコメント（抜粋）&nbsp;</td>
    </tr>
    <%for(int k=0; k < syousai.getMainkeyword().length; k++){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(syousai.getMainkeyword()[k]) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(syousai.getHyoukakeyword()[k]) %>&nbsp;</td>
    </tr>
    <% } %>
  </tbody>
</table>
<% } %>
<% } %>
<p>
<br>
<%if(!(syousai.getBestReports()[0].equals("NO_DATA"))){ %>
<img src="GData_Images/Report_Etsuran_Bunner.gif" width="253" height="31" border="0"/>リンクをクリックすることで高評価を得たレポートを閲覧できます。<br>
<%for(int l=0; l < syousai.getBestReports().length; l++){ %>
<br>
<dl>
<dd><a href="/G-pro_Service/BestReportMaker?rep_code=<%=syousai.getBestReports()[l] %>" target="_blank"><%=syousai.getBestReporters()[l] %>さん</a></dd>
</dl>
<% } %>
<% } %>
<br>
<p><font color="red" size="+2"><b>※掲載内容の盗用、無断転載、無断複製を禁止します。</b></font></p>
<br>
<br>
<!-- <p align="center"><a href="/G-pro_Service/passed/G_SeachResult.jsp"><img src="/G-pro_Service/passed/GData_Images/BacktoSerchResult.gif" width="125" height="42" border="0" alt="検索結果に戻る"></a>　　　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="GData_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"/><br></a></p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/G_SeachResult.jsp">検索結果へ戻る</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>