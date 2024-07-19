<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="event.EventData_TO" %>
    <%@ page import="event.EventData_DAO" %>
    <%@ page import="event.Event_SyousaiMaker" %>
    <%@ page import="event.TourokuKoumoku_Maker" %>
    <%@ page import="event.Event_Member_Touroku" %>
    <jsp:useBean id="formdata" scope="session" type="event.EventData_TO"/>
    <jsp:useBean id="eventsyousai" scope="session" type="event.EventData_TO"/>
    <jsp:useBean id="sankasyadata" scope="session" type="event.EventData_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<base href="/G-pro_Service/Event/Event_Sanka_Kakunin.jsp">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Event.css"/>
<title></title>
</head>
<body background="/G-pro_Service/image/Event_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="342" height="131" border="0"></p>
<p><b><font size="+2">イベント参加確認</font></b></p>
<p><b>以下のイベントに参加登録します。よろしければ「確定」を、登録情報を修正するには「再編集」を、<br>
登録を中止するには「G-PROjectトップに戻る」をクリックしてください。</b></p>
<p><b><font color="#ff0000">注意:一度登録すると取り消しはできません！</font></b></p>
<p><img src="/G-pro_Service/LogoImage_Load?syubetsu=event_logo&address=<%=eventsyousai.getLogofile_Name() %>" width="180" height="120"></p>
<% if(eventsyousai.getKounin_Jyoukyou().isEmpty() == false){ %>
<% if(eventsyousai.getKounin_Jyoukyou().indexOf("メーカー認定") != -1){ %>
<p><img src="/G-pro_Service/free_area/Event/Maker_Kounin_Logo.gif" width="120" height="20" border="0">
<% }if(eventsyousai.getKounin_Jyoukyou().indexOf("G-PRO認定") != -1){ %>
<img src="/G-pro_Service/free_area/Event/GPRO_Kounin_Logo.gif" width="120" height="20" border="0"></p>
<% } %>
<% } %>
<p><b>大会コード：<%=HttpUtility.escapeHTML(eventsyousai.getEventCode()) %></b></p>
<p><b>大会グレード：<%=HttpUtility.escapeHTML(eventsyousai.getGrade()) %></b></p>
<p><b>開催年月日：<%=HttpUtility.escapeHTML(eventsyousai.getKaisaiDate()) %></b></p>
<p><b>イベント主催者：<%=HttpUtility.escapeHTML(eventsyousai.getEvent_Master()) %>　　　　　　　　　　イベント責任者：<%=HttpUtility.escapeHTML(eventsyousai.getJudge_Master()) %></b></p>
参加資格：<pre><%=eventsyousai.getSanka_Shikaku() %></pre>
<p><img src="/G-pro_Service/image/Your_Data.gif" width="300" height="60" border="0"></p>
<p><b>エントリーネーム：<%=HttpUtility.escapeHTML(sankasyadata.getEntry_Name()) %>（読み:<%=HttpUtility.escapeHTML(sankasyadata.getEntry_Name_Yomi()) %>）</b></p>
<p><b>在住都道府県：<%=HttpUtility.escapeHTML(sankasyadata.getPref()) %></b></p>
<p><b>メールアドレス:<%=HttpUtility.escapeHTML(sankasyadata.getMailAddress()) %></b></p>
<% if(formdata.getKoumokuList_A().length > 0){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[0]) %>：<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku1()) %></b></p>
<% if(formdata.getKoumokuList_A().length > 1){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[1]) %>：<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku2()) %></b></p>
<% if(formdata.getKoumokuList_A().length > 2){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[2]) %>：<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku3()) %></b></p>
<% if(formdata.getKoumokuList_A().length > 3){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[3]) %>：<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku4()) %></b></p>
<% if(formdata.getKoumokuList_A().length > 4){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[4]) %>：<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku5()) %></b></p>
<% } %>
<% } %>
<% } %>
<% } %>
<% } %>
備考:
<pre><%=sankasyadata.getBikou() %></pre>
<p align="center"><a href="/G-pro_Service/Event_Sanka_Upload" class="tourokubutton">参加登録を確定する</a>　　　<a href="/G-pro_Service/Event/Event_Sanka_Syusei.jsp" class="tourokubutton">登録内容を編集する</a>　　　<a href="/G-pro_Service/AuthenticationController" class="tourokubutton">G-PROjectトップに戻る</a></p>
</body>
</html>