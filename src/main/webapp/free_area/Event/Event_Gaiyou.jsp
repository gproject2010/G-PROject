<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="inputUtility.FileSizeMaker" %>
    <%@ page import="event.EventData_TO" %>
    <%@ page import="event.EventData_DAO" %>
    <%@ page import="event.Event_SyousaiMaker" %>
    <jsp:useBean id="eventsyousai" scope="session" type="event.EventData_TO"/>
    <jsp:useBean id="filesize1" scope="session" class="inputUtility.FileSizeMaker"/>
    <jsp:useBean id="filesize2" scope="session" class="inputUtility.FileSizeMaker"/>
    <jsp:useBean id="filesize3" scope="session" class="inputUtility.FileSizeMaker"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/free_area/Event/Event_Gaiyou.jsp"/>
<meta name="description" content="G-PROjectやゲームメーカーが主催するイベントの概要です。"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Event.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/pageusefiles/event.js" charset="UTF-8"></script>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title>イベント概要 | G-PROject</title>
</head>
<body background="/G-pro_Service/image/Event_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="342" height="131" border="0"></p>
<p><b><font size="+2">イベント概要</font></b></p>
<p><img src="/G-pro_Service/LogoImage_Load/<%=eventsyousai.getLogofile_Name() %>?syubetsu=event_logo" width="180" height="120"></p>
<p><b>大会名称：<%=HttpUtility.escapeHTML(eventsyousai.getEventName()) %></b></p>
<% if(eventsyousai.getKounin_Jyoukyou().isEmpty() == false){ %>
<% if(eventsyousai.getKounin_Jyoukyou().indexOf("メーカー認定") != -1){ %>
<p><img src="/G-pro_Service/free_area/Event/Maker_Kounin_Logo.gif" width="120" height="20" border="0">
<% }if(eventsyousai.getKounin_Jyoukyou().indexOf("G-PRO認定") != -1){ %>
<img src="/G-pro_Service/free_area/Event/GPRO_Kounin_Logo.gif" width="120" height="20" border="0"></p>
<% } %>
<% } %>
<p><b>イベントコード：<%=HttpUtility.escapeHTML(eventsyousai.getEventCode()) %></b></p>
<p><b>イベントグレード：<%=HttpUtility.escapeHTML(eventsyousai.getGrade()) %></b></p>
<p><b>開催年月日：<%=HttpUtility.escapeHTML(eventsyousai.getKaisaiDate()) %>　　　　　開催時間：<%=HttpUtility.escapeHTML(eventsyousai.getKaisaijikan()) %></b></p>
<p><b>イベント主催者：<%=HttpUtility.escapeHTML(eventsyousai.getEvent_Master()) %>　　　　　　　　　　イベント責任者：<%=HttpUtility.escapeHTML(eventsyousai.getJudge_Master()) %></b></p>
<p><b>イベント主催者URL:<a href="<%=eventsyousai.getSystem_URL() %>" target="_blank"><%=eventsyousai.getSystem_URL() %></a></b></p>
<p><b>会場：<%=HttpUtility.escapeHTML(eventsyousai.getKaijyoumei()) %></b></p>
参加費:<pre><%=eventsyousai.getSankahi() %></pre>
参加資格：<pre><%=eventsyousai.getSanka_Shikaku() %></pre>
<p><b>イベント概要</b></p>
<pre><%=eventsyousai.getYosen_Keishiki() %></pre>
<% if(eventsyousai.getKessyou_Keishiki().isEmpty() == false){ %><pre><%=eventsyousai.getKessyou_Keishiki() %></pre><% } %>
<% if(eventsyousai.getSankahouhou().isEmpty() == true || eventsyousai.getSankahouhou().equals("事前登録受付終了")){ %><p><font color="#ff0000"><b>このイベントの事前登録受付は終了しました。</b></font></p>
<% }else if(eventsyousai.getUketsuke_Jyoukyou().equals("開催準備中")){ %><p><font color="#ff0000"><b>このイベントは現在開催準備中です。受付開始までもうしばらくお待ちください。</b></font></p>
<% }else if(eventsyousai.getUketsuke_Jyoukyou().equals("当日参加")){ %><p><font color="#0000cc"><b>このイベントは事前登録不要です。参加する方は直接会場にお越しください。</b></font></p>
<% }else if(eventsyousai.getUketsuke_Jyoukyou().equals("事前登録受付中")){ %><p><font color="#0000cc"><b>このイベントの参加を受け付けています。参加するには下のボタンから受付ページへ進んでください。</b></font></p>
<p><b><a href="/G-pro_Service/TourokuKoumoku_Maker?event_code=<%=eventsyousai.getEventCode()%>"><p><b class="tourokubutton">このイベントに事前登録する</b></p>
</a></b></p>
<% }else if(eventsyousai.getUketsuke_Jyoukyou().equals("開催中")){ %><p><font color="#0000cc"><b>このイベントは現在開催中です。</b></font></p>
<% }else if(eventsyousai.getUketsuke_Jyoukyou().equals("終了")){ %><p><font color="#0000cc"><b>このイベントは終了しました。結果を表示するには下の「結果を表示する」をクリックしてください。</b></font></p>
<p><a href="/G-pro_Service/Event_Result_Maker?event_code=<%=eventsyousai.getEventCode()%>"><img src="/G-pro_Service/free_area/Event/Event_Result_Hyouji.gif" width="358" height="62" border="0" alt="このイベントの結果を表示する"></a></p>
<% }else if(eventsyousai.getUketsuke_Jyoukyou().equals("会員専用")){ %><p><font color="#0000cc"><b>このイベントはG-PROjectの会員のみ参加できます。参加するにはログイン後、会員メニューから受付ページへ進んでください。</b></font></p>
<p><b><img src="/G-pro_Service/image/Login_Logo.gif" width="97" height="43" border="0"></b></p>
<form action="j_security_check" method="post">
<p><b>G-PRO ID:<input size="20" type="text" name="j_username" maxlength="20"></b></p>
<p><b>パスワード:<input size="20" type="password" maxlength="20" name="j_password"></b></p>
<p><b class="tourokubutton">ログイン</b></p>
</form>
<p><b><font color="#0000cc">サイト登録がまだの方はぜひ利用登録を！↓</font></b></p>
<p class="tourokubutton">サイト登録する</p>
<% } %>
<dl>
<p><img src="/G-pro_Service/free_area/Event/Event_Kaijyou.gif" width="158" height="39" border="0" alt="イベント会場"><br>
<b>写真をクリックすると紹介ページを表示します。</b></p>
<table border="1" class="datatable">
  <tbody>
    <tr>
      <td>
      <form action="/G-pro_Service/LocateData_Maker" method="post">
      <input type="hidden" name="shopname" value="<%=eventsyousai.getKaijyoumei() %>">
      <input type="image" name="submit" src="/G-pro_Service/LogoImage_Load/<%=eventsyousai.getKaijyoumei() %>?syubetsu=shop_photo" width="180" height="120" class="shop_photo">
      </form></td>
    </tr>
    <tr>
      <td><b><font size="+1"><%=HttpUtility.escapeHTML(eventsyousai.getKaijyoumei()) %></font></b></td>
    </tr>
  </tbody>
</table>
<p><img src="/G-pro_Service/free_area/Event/Toiawase_Logo.gif" width="167" height="39" border="0" alt="お問い合わせ"></p>
<p><b><font color="#0000cc">このイベントの主催者に問い合わせを行う場合は下記のフォームに返信用のメールアドレスと<br>
問い合わせ内容を入力し、「送信」をクリックしてください。</font></b></p>
<form action="/G-pro_Service/Event_Toiawase" method="post">
<p><b>返信用メールアドレス：<input size="50" type="text" value="入力してください" name="mailaddress"></b></p>
<p><font color="#ff0000">※返信は主催者が直接行います。そのため主催者に入力されたメールアドレスを通知します。</font></p>
<p><b>問い合わせの内容：</b><br>
<textarea rows="5" cols="60" name="naiyou" id="count_area1" maxlength="300">入力してください</textarea></p>
※最大全角300文字以内(あと<span id="mojisu1">292</span>文字)
<p><input type="image" name="submit" src="/G-pro_Service/image/Soushin_Button.gif" width="53" height="42" border="0"></p>
</form>
<p><img src="/G-pro_Service/free_area/Event/Shiryou_DL_Logo.gif" width="300" height="39" border="0" alt="イベント資料ダウンロード"></p>
<p><b><font size="+1">リンクをクリックするとこのイベントの資料がダウンロードされます。</font></b></p>
<% if(eventsyousai.getEventshiryou1().isEmpty() == false){ %>
<p><a href="/G-pro_Service/EventFileDownload/<%=eventsyousai.getEventshiryou1()%>?filesyubetsu=shiryou1"><b><%=HttpUtility.escapeHTML(eventsyousai.getEventshiryou1()) %>(サイズ:<%=filesize1.FileSizeMake("shiryou1", eventsyousai.getEventshiryou1()) %>MB)</b></a></p>
<% }if(eventsyousai.getEventshiryou2().isEmpty() == false){ %>
<p><a href="/G-pro_Service/EventFileDownload/<%=eventsyousai.getEventshiryou2()%>?filesyubetsu=shiryou2"><b><%=HttpUtility.escapeHTML(eventsyousai.getEventshiryou2()) %>(サイズ:<%=filesize2.FileSizeMake("shiryou2", eventsyousai.getEventshiryou2()) %>MB)</b></a></p>
<% }if(eventsyousai.getEventshiryou3().isEmpty() == false){ %>
<p><a href="/G-pro_Service/EventFileDownload/<%=eventsyousai.getEventshiryou3()%>?filesyubetsu=shiryou3"><b><%=HttpUtility.escapeHTML(eventsyousai.getEventshiryou3()) %>(サイズ:<%=filesize3.FileSizeMake("shiryou3", eventsyousai.getEventshiryou3()) %>MB)</b></a></p>
<% } %>
<p class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップに戻る</a></p>
</dl>
</body>
</html>