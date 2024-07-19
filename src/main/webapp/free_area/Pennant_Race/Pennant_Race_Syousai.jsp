<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="pennant_race.PennantData_TO" %>
    <%@ page import="pennant_race.PennantData_DAO" %>
    <%@ page import="event.EventData_TO" %>
    <%@ page import="event.EventData_DAO" %>
    <%@ page import="pennant_race.PennantRace_SyousaiMaker" %>
    <jsp:useBean id="leaguesyousai" scope="application" type="pennant_race.PennantData_TO"/>
    <jsp:useBean id="playersyousai" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<pennant_race.PennantData_TO>"/>
    <jsp:useBean id="eventlist" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<event.EventData_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Pennant_Race/Pennant_Race_Syousai.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title><%=HttpUtility.escapeHTML(leaguesyousai.getLeagueName()) %>詳細</title>
</head>
<body background="./Pennant_Race_Image/Pennant_Race_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<p align="center"><img src="./Pennant_Race_Image/Pennant_Race_Logo.gif" width="528" height="120" border="0"></p>
<p align="center"><b><font size="+3">リーグ詳細</font></b></p>
<p align="center"><b><a href="/G-pro_Service/PennantRace_SyousaiMaker?order=ruikei&league_id=<%=leaguesyousai.getLeagueCode() %>">累計スターランキングに切り替え</a></b></p>
<table border="1">
  <tbody>
    <tr>
      <td rowspan="3" align="left"><b style="font-size : x-large;font-family : メイリオ;"><i><img src="/G-pro_Service/LogoImage_Load/<%=leaguesyousai.getLogofile_Name() %>?syubetsu=event_logo" id="sumneile"><br>
      </i></b><font size="+1"><b><font size="+2"><%=HttpUtility.escapeHTML(leaguesyousai.getLeagueName()) %></font></b></font>　　　　　<font color="#0000ff"><b style="font-size : x-large;font-family : メイリオ;"><i>Season<%=leaguesyousai.getSeason() %></i></b></font></td>
      <td colspan="2"><% if(leaguesyousai.getKounin_Jyoukyou().indexOf("G-PRO公認") != -1){ %><img src="./Pennant_Race_Image/GPRO_Kounin_Logo.gif" width="183" height="38" border="0"><% }if(leaguesyousai.getKounin_Jyoukyou().indexOf("メーカー公認") != -1){ %><img src="./Pennant_Race_Image/Maker_Kounin_Logo.gif" width="180" height="38" border="0"><% } %><br>
      </td>
    </tr>
    <tr>
      <td colspan="2">&nbsp;<b><%=leaguesyousai.getStartDate() %>　開始　　<%=leaguesyousai.getEndDate() %>　終了予定</b></td>
    </tr>
    <tr>
      <td><i><b><font size="+1" style="font-family : メイリオ;" color="#009999">League-Class：<%=leaguesyousai.getLeagueClass() %></font></b></i></td>
      <td align="center"><font size="+1"><b>現在第<%=leaguesyousai.getRound() %>戦まで終了</b></font></td>
    </tr>
    <tr>
      <td align="left" colspan="3"><b><%=HttpUtility.escapeHTML(leaguesyousai.getDescription()) %></b></td>
    </tr>
    <tr>
      <td align="center"><b><font size="+1">獲得スターランキング</font></b></td>
      <td><b>シーズン内獲得スター</b></td>
      <td><b>累計獲得スター</b></td>
    </tr>
    <% for(int i=0; i < playersyousai.size(); i++){ %>
    <% if(i == 0){ %>
    <tr>
      <td><b><img src="./Pennant_Race_Image/First_Logo.gif" width="56" height="39" border="0" alt="1st"></b><b><font size="+3">　<%=HttpUtility.escapeHTML(playersyousai.get(i).getPlayer_Name()) %>（<%=HttpUtility.escapeHTML(playersyousai.get(i).getPref()) %>）</font></b><b>&nbsp;</b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Single_Star.gif" width="37" height="41" border="0"></b><b>×<%=playersyousai.get(i).getSeason_Star() %></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Single_Star.gif" width="37" height="41" border="0"></b><b>×<%=playersyousai.get(i).getStar_Count() %></b></td>
    </tr>
    <% }else if(i == 1){ %>
    <tr>
      <td><b><img src="./Pennant_Race_Image/Second_Logo.gif" width="55" height="39" border="0" alt="2nd"></b><b><font size="+3">　<%=HttpUtility.escapeHTML(playersyousai.get(i).getPlayer_Name()) %>（<%=HttpUtility.escapeHTML(playersyousai.get(i).getPref()) %>）</font></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Single_Star.gif" width="37" height="41" border="0"></b><b>×<%=playersyousai.get(i).getSeason_Star() %></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Single_Star.gif" width="37" height="41" border="0"></b><b>×<%=playersyousai.get(i).getStar_Count() %></b></td>
    </tr>
    <% }else if(i == 2){ %>
    <tr>
      <td><b><img src="./Pennant_Race_Image/Third_Logo.gif" width="54" height="39" border="0" alt="3rd"></b><b><font size="+3">　<%=HttpUtility.escapeHTML(playersyousai.get(i).getPlayer_Name()) %>（<%=HttpUtility.escapeHTML(playersyousai.get(i).getPref()) %>）</font></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Single_Star.gif" width="37" height="41" border="0"></b><b>×<%=playersyousai.get(i).getSeason_Star() %></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Single_Star.gif" width="37" height="41" border="0"></b><b>×<%=playersyousai.get(i).getStar_Count() %></b></td>
    </tr>
    <% }else{ %>
    <tr>
      <td><b><%=i+1 %>ｔｈ　<%=HttpUtility.escapeHTML(playersyousai.get(i).getPlayer_Name()) %>（<%=HttpUtility.escapeHTML(playersyousai.get(i).getPref()) %>）</b></td>
      <td align="center"><b>☆×<%=playersyousai.get(i).getSeason_Star() %>&nbsp;</b></td>
      <td align="center"><b>☆×<%=playersyousai.get(i).getStar_Count() %>&nbsp;</b></td>
    </tr>
    <% } %>
    <% } %>
  </tbody>
</table>
<p><b><font size="+2">このリーグの大会開催履歴</font></b></p>
<table border="1">
  <tbody>
    <tr>
      <td>イベントロゴ</td>
      <td>イベント名称</td>
      <td>グレード</td>
      <td>主催者</td>
      <td>開催年月日</td>
      <td>会場</td>
      <td>紹介ページリンク</td>
    </tr>
    <% for(int i=0; i < eventlist.size(); i++){ %>
    <tr>
      <td><img src="/G-pro_Service/LogoImage_Load/<%=eventlist.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile">&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(eventlist.get(i).getEventName()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(eventlist.get(i).getGrade()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(eventlist.get(i).getEvent_Master()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(eventlist.get(i).getKaisaiDate()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(eventlist.get(i).getKaijyoumei()) %>&nbsp;</td>
      <td>
      <form action="/G-pro_Service/Event_SyousaiMaker" method="post">
      <input type="hidden" name="eventcode" value="<%=eventlist.get(i).getEventCode() %>">
      <input type="submit" name="submit" value="イベント情報ページへ"></form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<p align="center"><a href="/G-pro_Service/PennantRace_TopMaker?order=season"><img src="./Pennant_Race_Image/BacktoPennantTop.gif" width="280" height="53" border="0" alt="ペナントレーストップへ戻る"></a>　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="212" height="48" border="0"></a></p>
</body>
</html>