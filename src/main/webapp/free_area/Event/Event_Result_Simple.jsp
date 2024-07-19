<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
   <%@ page import="java.lang.Boolean" %>
    <%@ page import="event.EventData_TO" %>
    <%@ page import="event.EventData_DAO" %>
    <%@ page import="event.Event_Result_Maker" %>
    <jsp:useBean id="gaiyou" scope="application" class="event.EventData_TO" type="event.EventData_TO"/>
    <jsp:useBean id="winners" scope="application" class="event.EventData_TO" type="event.EventData_TO"/>
    <jsp:useBean id="rank" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<event.EventData_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Event/Event_Result_Simple.jsp"/>
<meta keywords="G-PROject, <%=gaiyou.getEventName()%>, 結果"/>
<meta name="description" content="G-PROjectやゲームメーカーが主催するイベントの結果です。"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Event.css"/>
<link rel="canonical" href="http://www.gamereporters.info/"/>
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title>イベント結果(大会)</title>
</head>
<body background="/G-pro_Service/image/Event_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="342" height="131" border="0"></p>
<p><b><font size="+2">イベント結果(大会)</font></b></p>
<p><img src="/G-pro_Service/LogoImage_Load/<%=gaiyou.getLogofile_Name() %>?syubetsu=event_logo" width="180" height="120" alt="大会ロゴ"></p>
<p><b><font size="+1">大会コード:<%=HttpUtility.escapeHTML(gaiyou.getEventCode()) %>　　　　　大会名称:<%=HttpUtility.escapeHTML(gaiyou.getEventName()) %>　　主催者:<%=HttpUtility.escapeHTML(gaiyou.getEvent_Master()) %>　　　　大会責任者:<%=HttpUtility.escapeHTML(gaiyou.getJudge_Master()) %></font></b></p>
<p><b><font size="+1">グレード：<%=HttpUtility.escapeHTML(gaiyou.getGrade()) %>　　　<%=HttpUtility.escapeHTML(gaiyou.getKaisaiDate()) %>　開催</font></b></p>
<p><b><font size="+1">大会結果</font></b></p>
<div align="center">
<table border="0">
  <tbody>
    <tr>
      <td><img src="/G-pro_Service/free_area/Event/Winner_Logo.gif" width="64" height="39" border="0" alt="優勝"></td>
      <td><%=HttpUtility.escapeHTML(winners.getFirst()) %></td>
      <td><img src="/G-pro_Service/free_area/Event/Second_Logo.gif" width="50" height="47" border="0" alt="2位"></td>
      <td><%=HttpUtility.escapeHTML(winners.getSecond()) %></td>
      <td><img src="/G-pro_Service/free_area/Event/Third_Logo.gif" width="48" height="47" border="0" alt="3位"></td>
      <td><%=HttpUtility.escapeHTML(winners.getThird()) %></td>
      <td><img src="/G-pro_Service/free_area/Event/Fourth_Logo.gif" width="49" height="47" border="0" alt="4位"></td>
      <td><%=HttpUtility.escapeHTML(winners.getFourth()) %></td>
    </tr>
  </tbody>
</table>
</div>
<% if(rank.size() > 0){ %>
<p><b><font size="+1">大会成績一覧</font></b></p>
<div align="center">
<table border="1">
  <tbody>
    <tr>
      <td>順位</td>
      <td>エントリーネーム</td>
       <% if(rank.get(0).getScoreKoumoku1() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(0).getScoreKoumoku1()) %>&nbsp;</td>
      <% if(rank.get(0).getScoreKoumoku2() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(0).getScoreKoumoku2()) %>&nbsp;</td>
      <% if(rank.get(0).getScoreKoumoku3() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(0).getScoreKoumoku3()) %>&nbsp;</td>
      <% if(rank.get(0).getScoreKoumoku4() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(0).getScoreKoumoku4()) %>&nbsp;</td>
      <% if(rank.get(0).getTotalScore() != null){ %>
      <td>獲得スコア</td>
      <% }
         }
         }
         }
         }%>
      
    </tr>
    <% for(int i=0; i < rank.size(); i++){ %>
    <tr>
      <td><%=rank.get(i).getRank() %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(rank.get(i).getEntry_Name()) %>&nbsp;</td>
      <% if(rank.get(i).getScore1() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(i).getScore1()) %>&nbsp;</td>
       <% if(rank.get(i).getScore2() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(i).getScore2()) %>&nbsp;</td>
       <% if(rank.get(i).getScore3() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(i).getScore3()) %>&nbsp;</td>
       <% if(rank.get(i).getScore4() != null){ %>
      <td><%=HttpUtility.escapeHTML(rank.get(i).getScore4()) %>&nbsp;</td>
      <% if(rank.get(i).getTotalScore() != null){ %>
      <td><%= rank.get(i).getTotalScore() %></td>
      <% }
         }
         }
         }
         }%>
    </tr>
    <% } %>
  </tbody>
</table>
</div>
<% if(winners.getSyusei_Riyu() != null && (!(winners.getSyusei_Riyu().equals("")))) %>
<p><b>※この大会の結果には修正が加えられています。<br>
理由:<br>
<pre><%=winners.getSyusei_Riyu() %></pre></b></p>
<% } %>
<p><a href="/G-pro_Service/free_area/Event/Event_Gaiyou.jsp" class="tourokubutton">イベント概要に戻る</a></p>
</body>
</html>