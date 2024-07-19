<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="pennant_race.PennantData_TO" %>
    <%@ page import="pennant_race.PennantData_DAO" %>
    <%@ page import="pennant_race.PennantRace_TopMaker" %>
    <jsp:useBean id="league" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<pennant_race.PennantData_TO>"/>
    <jsp:useBean id="player" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<pennant_race.PennantData_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Pennant_Race/Pennant_Race_Top.jsp">
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
<title></title>
</head>
<body background="./Pennant_Race_Image/Pennant_Race_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<p align="center"><img src="./Pennant_Race_Image/Pennant_Race_Logo.gif" width="528" height="120" border="0"></p>
<p align="center"><font size="+3"><b>ペナントレース開催一覧</b></font></p>
<p align="center"><b><a href="/G-pro_Service/PennantRace_TopMaker?order=ruikei">累計スターランキングに切り替え</a></b></p>
<% for(int i=0; i < league.size(); i++){ %>
<table border="1">
  <tbody>
    <tr>
      <td rowspan="3" align="left"><b style="font-size : x-large;font-family : メイリオ;"><i><img src="/G-pro_Service/LogoImage_Load/<%=league.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile"><br>
      </i></b><font size="+1"><b><font size="+2"><%=HttpUtility.escapeHTML(league.get(i).getLeagueName()) %></font></b></font>　　　　　<font color="#0000ff"><b style="font-size : x-large;font-family : メイリオ;"><i>Season<%=league.get(i).getSeason() %></i></b></font></td>
      <td colspan="2"><% if(league.get(i).getKounin_Jyoukyou().indexOf("G-PRO公認") != -1){ %><img src="./Pennant_Race_Image/GPRO_Kounin_Logo.gif" width="183" height="38" border="0"><% }if(league.get(i).getKounin_Jyoukyou().indexOf("メーカー公認") != -1){ %><img src="./Pennant_Race_Image/Maker_Kounin_Logo.gif" width="180" height="38" border="0"><% } %><br>
      </td>
    </tr>
    <tr>
      <td colspan="2">&nbsp;<b><%=league.get(i).getStartDate() %>　開始　　<%=league.get(i).getEndDate() %>　終了予定</b></td>
    </tr>
    <tr>
      <td><i><b><font size="+1" style="font-family : メイリオ;" color="#009999">League-Class：<%=league.get(i).getClass() %></font></b></i></td>
      <td align="center"><font size="+1"><b>現在第<%=league.get(i).getRound() %>戦まで終了</b></font></td>
    </tr>
    <tr>
      <td align="left" colspan="3"><b><%=HttpUtility.escapeHTML(league.get(i).getDescription()) %></b></td>
    </tr>
    <tr>
      <td align="center"><b><font size="+1">獲得スターベスト3</font>　</b><input type="button" name="submit" value="上位50名のランキングを表示"></td>
      <td><b>シーズン内獲得スター</b></td>
      <td><b>累計獲得スター</b></td>
    </tr>
    <% for(int j=0; j < player.size(); j++){ %>
    <% int count = 0; %>
    <% if(player.get(j).getLeagueCode().equals(league.get(i).getLeagueCode())){ %>
    <% if(count == 0){ %>
    <tr>
      <td><b><img src="./Pennant_Race_Image/First_Logo.gif" width="56" height="39" border="0" alt="1st"></b><b><font size="+3">　<%=HttpUtility.escapeHTML(player.get(j).getPlayer_Name()) %>（<%=HttpUtility.escapeHTML(player.get(j).getPref()) %>）</font></b><b>&nbsp;</b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Ten_Stars.gif" width="54" height="58" border="0"></b><b>×<%=player.get(j).getSeason_Star() / 10 %><br>
      </b><b><img src="./Pennant_Race_Image/Five_Stars.gif" width="51" height="54" border="0"></b><b>×<%=player.get(j).getSeason_Star() % 10 / 5%><br>
      </b><b><img src="./Pennant_Race_Image/One_Star.gif" width="49" height="51" border="0"></b><b>×<%=player.get(j).getSeason_Star() % 10 % 5%></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Ten_Stars.gif" width="54" height="58" border="0"></b><b>×<%=player.get(j).getStar_Count() / 10 %><br>
      </b><b><img src="./Pennant_Race_Image/Five_Stars.gif" width="51" height="54" border="0"></b><b>×<%=player.get(j).getStar_Count() % 10 / 5 %><br>
      </b><b><img src="./Pennant_Race_Image/One_Star.gif" width="49" height="51" border="0"></b><b>×<%=player.get(j).getStar_Count() % 10 % 5 %></b></td>
    </tr>
    <% count++; %>
    <% }else if(count == 1){ %>
    <tr>
      <td><b><img src="./Pennant_Race_Image/Second_Logo.gif" width="55" height="39" border="0" alt="2nd"></b><b><font size="+3">　<%=HttpUtility.escapeHTML(player.get(j).getPlayer_Name()) %>（<%=HttpUtility.escapeHTML(player.get(j).getPref()) %>）</font></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Ten_Stars.gif" width="54" height="58" border="0"></b><b>×<%=player.get(j).getSeason_Star() / 10 %><br>
      </b><b><img src="./Pennant_Race_Image/Five_Stars.gif" width="51" height="54" border="0"></b><b>×<%=player.get(j).getSeason_Star() % 10 / 5%><br>
      </b><b><img src="./Pennant_Race_Image/One_Star.gif" width="49" height="51" border="0"></b><b>×<%=player.get(j).getSeason_Star() % 10 % 5%></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Ten_Stars.gif" width="54" height="58" border="0"></b><b>×<%=player.get(j).getStar_Count() / 10 %><br>
      </b><b><img src="./Pennant_Race_Image/Five_Stars.gif" width="51" height="54" border="0"></b><b>×<%=player.get(j).getStar_Count() % 10 / 5 %><br>
      </b><b><img src="./Pennant_Race_Image/One_Star.gif" width="49" height="51" border="0"></b><b>×<%=player.get(j).getStar_Count() % 10 % 5 %></b></td>
    </tr>
    <% count++; %>
    <% }else if(count == 2){ %>
    <tr>
      <td><b><img src="./Pennant_Race_Image/Third_Logo.gif" width="54" height="39" border="0" alt="3rd"></b><b><font size="+3">　<%=HttpUtility.escapeHTML(player.get(j).getPlayer_Name()) %>（<%=HttpUtility.escapeHTML(player.get(j).getPref()) %>）</font></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Ten_Stars.gif" width="54" height="58" border="0"></b><b>×<%=player.get(j).getSeason_Star() / 10 %><br>
      </b><b><img src="./Pennant_Race_Image/Five_Stars.gif" width="51" height="54" border="0"></b><b>×<%=player.get(j).getSeason_Star() % 10 / 5%><br>
      </b><b><img src="./Pennant_Race_Image/One_Star.gif" width="49" height="51" border="0"></b><b>×<%=player.get(j).getSeason_Star() % 10 % 5%></b></td>
      <td align="center"><b><img src="./Pennant_Race_Image/Ten_Stars.gif" width="54" height="58" border="0"></b><b>×<%=player.get(j).getStar_Count() / 10 %><br>
      </b><b><img src="./Pennant_Race_Image/Five_Stars.gif" width="51" height="54" border="0"></b><b>×<%=player.get(j).getStar_Count() % 10 / 5 %><br>
      </b><b><img src="./Pennant_Race_Image/One_Star.gif" width="49" height="51" border="0"></b><b>×<%=player.get(j).getStar_Count() % 10 % 5 %></b></td>
    </tr>
    <% break; %>
    <% } %>
    <% } %>
    <% } %>
  </tbody>
</table>
<% } %>
<p align="center"><a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="212" height="48" border="0"></a></p>
</body>
</html>