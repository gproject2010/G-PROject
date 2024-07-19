<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.lang.Double" %>
    <%@ page import="java.util.ArrayList"%>
    <%@page import="k_jyouhou.R_jyouhou_TO" %>
    <%@page import="k_jyouhou.K_jyouhou_TO" %>
    <%@page import="rep_upload.Rep_List_TO" %>
    <%@page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@page import="k_jyouhou.K_jyouhou_DAO" %>
    <%@page import="rep_upload.Rep_List_DAO" %>
    <%@page import="k_jyouhou.StatusMaker" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
    <jsp:useBean id="nextsc" scope="session" type="java.lang.Double"/>
    <jsp:useBean id="r_rireki" scope="session" type="java.util.ArrayList<rep_upload.Rep_List_TO>"/>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Kaiin_Status.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>ステータス確認画面</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"></p>
<p><br>

<font size="+2"><%=HttpUtility.escapeHTML(seiseki.getSyougou())%>   <%=HttpUtility.escapeHTML(seiseki.getlogin_name()) %>さんの現在のステータス</font><br>
<br>
<% if(seiseki.isLv_Up_Flg()){ %>
<br>
<img src="/G-pro_Service/image/Level_Up!.gif" width="336" height="76" border="0"><br>
<br>
おめでとうございます！プレイヤーレベルが上がりました！<br>
<br>
<% } %>
<br>
<font size="+2">・プレイヤーレベル:　Lｖ.<%=seiseki.getplayer_Level() %></font><br>
<br>
<b><font size="+1">・レポートスコア累計:　<%=HttpUtility.Round(seiseki.getreportScore_Ruikei(), 2, "cut") %>SC.(全国ランキング:<%=seiseki.getReportScore_Ruikei_Rank() %>位)</font></b><br>
<br>
<b><font size="+1">・アクションスコア累計:　<%=HttpUtility.Round(seiseki.getActionScore_Ruikei(), 2, "cut") %>SC.(全国ランキング:<%=seiseki.getActionScore_Ruikei_Rank() %>位)</font></b><br>
<br>
<b><font size="+1">・現在のEXP:　<%=HttpUtility.Round(seiseki.getreportScore_Ruikei(), 2, "cut") + HttpUtility.Round(seiseki.getActionScore_Ruikei(), 2, "cut") %>SC.　　⇒　　Lv.<%=seiseki.getplayer_Level() + 1 %>まであと  <%=HttpUtility.Round((nextsc - seiseki.getreportScore_Ruikei() - seiseki.getActionScore_Ruikei()), 2,"cut") %>SC.</font></b><br>
<font size="+2"><br>
・レポートスコア詳細<br>
<br>
</font><font size="+1">・先月：<%=HttpUtility.Round(seiseki.getreportScore_Sengetsu(), 2, "cut") %>(全国ランキング:<%=seiseki.getReportScore_Sengetsu_Rank() %>位)<br>
<br>
・今月:<%=HttpUtility.Round(seiseki.getreportScore_Kongetsu(), 2, "cut") %>(全国ランキング:<%=seiseki.getReportScore_Kongetsu_Rank() %>位)<br>
<br>
・今年：<%=HttpUtility.Round(seiseki.getreportScore_Nenkan(), 2, "cut") %>(全国ランキング:<%=seiseki.getReportScore_Nenkan_Rank() %>位)<br>
<br>
・レポート採用数：<%=seiseki.getreport_Count() %>(全国ランキング:<%=seiseki.getReport_Count_Rank() %>位)<br></font>
</p>
<p>
<font size="+2"><br>
・アクションスコア詳細<br>
<br>
</font><font size="+1">・先月：<%=HttpUtility.Round(seiseki.getActionScore_Sengetsu(), 2, "cut") %>(全国ランキング:<%=seiseki.getActionScore_Sengetsu_Rank() %>位)<br>
<br>
・今月:<%=HttpUtility.Round(seiseki.getactionScore_Kongetsu(), 2, "cut") %>(全国ランキング:<%=seiseki.getActionScore_Kongetsu_Rank() %>位)<br>
<br>
・今年:<%=HttpUtility.Round(seiseki.getActionScore_Nenkan(), 2, "cut") %>(全国ランキング:<%=seiseki.getActionScore_Nenkan_Rank() %>位)</font><br>
<br>
</p>
<p>
<font size="+2"><br>
・獲得スター詳細<br>
</font><font size="+1">・リーグシーズン内：<%=seiseki.getSeason_Star() %>(全国ランキング:<%=seiseki.getSeason_Star_Rank() %>位)<br>
<br>
・累計：<%=seiseki.getStar_Count() %>(全国ランキング:<%=seiseki.getStar_Count_Rank() %>位);<br>
<br>
</font>
</p>
<%if(seiseki.getSyougouList() != null && seiseki.getSyougouList().length > 0){ %>
<p><font size="+2">・所持している称号一覧</font></p>
<table border="1">
  <tbody>
    <tr>
      <td>獲得称号</td>
      <td>獲得日</td>
      <td>付け替え</td>
    </tr>
    <% for(int i=0; i < seiseki.getSyougouList().length; i++){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(seiseki.getSyougouList()[i]) %>&nbsp;</td>
      <td><%=seiseki.getS_KakutokubiList()[i] %>&nbsp;</td>
      <td align="center">
      <form action="/G-pro_Service/Syougou_Henkou" method="post">
      <input type="hidden" name="syougou_num" value="<%=i %>">
      <input type="hidden" name="syougou_name" value="<%=seiseki.getSyougouList()[i] %>">
      <input type="hidden" name="kakutokubi" value="<%=seiseki.getS_KakutokubiList()[i] %>">
      <input type="submit" name="change" value="SET"></form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<% } %>
<br>
<p>過去1年間に提出したレポートの履歴</p>
<table border="1">
  <tbody>
    <tr>
      <td>レポートコード&nbsp;</td>
      <td>提出日&nbsp;</td>
      <td>ゲームタイトル&nbsp;</td>
      <td>レポートスコア合計</td>
      <td>現在のレポートの状態</td>
      <td>ゲーム情報ページへの採用状況&nbsp;</td>
    </tr>
    <%for(Rep_List_TO LogList : r_rireki){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(LogList.getreport_code()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(LogList.getupload_date()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(LogList.getgametitle()) %>&nbsp;</td>
      <td><%=LogList.getRep_score() %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(LogList.getShinsaJyoukyou())%>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(LogList.getKeisaiJyoukyou()) %>&nbsp;</td>
      </tr>
    <% } %>
  </tbody>
</table>
<p>現在所持しているG-PROマイレージ:<%=HttpUtility.Round(seiseki.getMailage(), 2, "cut") %>miles</p>
<br>
<!-- <p align="center"><a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="149" height="43" border="0"></a>
会員メニューに戻る</p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>