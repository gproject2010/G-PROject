<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="inputUtility.HttpUtility" %>
   <%@ page import="java.lang.Boolean" %>
    <%@ page import="event.EventData_TO" %>
    <%@ page import="event.EventData_DAO" %>
    <%@ page import="event.Event_SyousaiMaker" %>
    <%@ page import="event.TourokuKoumoku_Maker" %>
    <%@ page import="event.Event_Member_Touroku" %>
    <jsp:useBean id="eventsyousai" scope="session" type="event.EventData_TO"/>
    <jsp:useBean id="formdata" scope="session" type="event.EventData_TO"/>
    <jsp:useBean id="sankasyadata" scope="session" type="event.EventData_TO"/>
    <jsp:useBean id="form_empty" scope="session" type="java.lang.Boolean"/>
    <jsp:useBean id="mojisu_over" scope="session" type="java.lang.Boolean"/>
    <jsp:useBean id="ngwords" scope="session" type="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<base href="/G-pro_Service/Event/Event_Sanka_Syusei.jsp">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Event.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/pageusefiles/event.js" charset="UTF-8"></script>
<title>イベント参加登録（修正）</title>
</head>
<body background="/G-pro_Service/image/Event_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="342" height="131" border="0"></p>
<p><b><font size="+2">イベント参加登録</font></b></p>
<form action="/G-pro_Service/Event_Member_Touroku" method="post">
<p><b>参加するイベントの名称：<%=HttpUtility.escapeHTML(eventsyousai.getEventName()) %></b></p>
<p><b>参加資格：</b><pre><%=eventsyousai.getSanka_Shikaku() %></pre>
<% if(form_empty == true){ %><p><font color="#ff0000"><b>入力されていない項目があります。もう一度入力して「確定」をクリックしてください。</b></font></p><% } %>
<% if(mojisu_over == true){ %><p><font color="#ff0000"><b>文字数が制限をオーバーしている項目があります。修正して「確定」をクリックしてください。</b></font></p><% } %>
<% if(ngwords.length() > 0){ %><p><font color="#ff0000"><b>入力内容から使用が禁止されている単語（<%=HttpUtility.escapeHTML(ngwords) %>）が検出されました。修正して「確定」をクリックしてください。</b></font></p><% } %>
<p><b>エントリーネーム：<input size="40" type="text" maxlength="40" name="entry_name" value="<%=HttpUtility.escapeHTML(sankasyadata.getEntry_Name())%>">　※最大全角20文字まで</b></p>
<p><b>エントリーネームの読み：<input size="60" type="text" maxlength="60" name="entry_name_yomi" value="<%=HttpUtility.escapeHTML(sankasyadata.getEntry_Name_Yomi())%>"><br>
※最大全角30文字まで、ひらがなで入力してください。</b></p>
<p><b>メールアドレス(参加登録に必要なメールの送信にのみ使用します)<br>
<input size="60" type="text" maxlength="100" name="mailaddress" value="<%=sankasyadata.getMailAddress()%>"></b></p>
<p><b>住所(都道府県)：<font color="#0000cc">もう一度入力してください</font> <select name="pref">
  <option value="北海道">北海道</option>
  <option value="青森県">青森県</option>
  <option value="秋田県">秋田県</option>
  <option value="岩手県">岩手県</option>
  <option value="山形県">山形県</option>
  <option value="宮城県">宮城県</option>
  <option value="福島県">福島県</option>
  <option value="新潟県" selected>新潟県</option>
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
</select></b></p>
<% if(formdata.getKoumokuList_A().length > 0){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[0]) %>：<input size="<%=formdata.getMaxLengthList_A()[0] %>" type="<%=formdata.getInputTypeList_A()[0] %>" maxlength="<%=formdata.getMaxLengthList_A()[0] %>" name="koumoku1" value="<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku1()) %>"><br>
※最大全角<%=formdata.getMaxLengthList_A()[0] %>文字まで</b></p>
<% if(formdata.getKoumokuList_A().length > 1){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[1]) %>：<input size="<%=formdata.getMaxLengthList_A()[1] %>" type="<%=formdata.getInputTypeList_A()[1] %>" maxlength="<%=formdata.getMaxLengthList_A()[1] %>" name="koumoku2" value="<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku2()) %>"><br>
※最大全角<%=formdata.getMaxLengthList_A()[1] %>文字まで</b></p>
<% if(formdata.getKoumokuList_A().length > 2){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[2]) %>：<input size="<%=formdata.getMaxLengthList_A()[2] %>" type="<%=formdata.getInputTypeList_A()[2] %>" maxlength="<%=formdata.getMaxLengthList_A()[2] %>" name="koumoku3" value="<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku3()) %>"><br>
※最大全角<%=formdata.getMaxLengthList_A()[2] %>文字まで</b></p>
<% if(formdata.getKoumokuList_A().length > 3){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[3]) %>：<input size="<%=formdata.getMaxLengthList_A()[3] %>" type="<%=formdata.getInputTypeList_A()[3] %>" maxlength="<%=formdata.getMaxLengthList_A()[3] %>" name="koumoku4" value="<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku4()) %>"><br>
※最大全角<%=formdata.getMaxLengthList_A()[3] %>文字まで</b></p>
<% if(formdata.getKoumokuList_A().length > 4){ %>
<p><b><%=HttpUtility.escapeHTML(formdata.getKoumokuList_A()[4]) %>：<input size="<%=formdata.getMaxLengthList_A()[4] %>" type="<%=formdata.getInputTypeList_A()[4] %>" maxlength="<%=formdata.getMaxLengthList_A()[4] %>" name="koumoku5" value="<%=HttpUtility.escapeHTML(sankasyadata.getKoumoku5()) %>"><br>
※最大全角<%=formdata.getMaxLengthList_A()[4] %>文字まで</b></p>
<% } %>
<% } %>
<% } %>
<% } %>
<% } %>
<p>備考(他に主催者に伝えたいことがあれば入力してください)<br>
<textarea name="bikou" cols="100" rows="3" id="count_area1" maxlength="150">
<%=sankasyadata.getBikou() %></textarea><br>
※最大全角150文字以内(あと<span id="mojisu1">---</span>文字)
</p>
<p><button type="submit" name="submit" class="tourokubutton">入力内容を確認する</button></p>　　　　　　　　　　<p class="tourokubutton"><a href="/G-pro_Service/AuthenticationController" class="tourokubutton">G-PROjectトップに戻る</a></p>
</form>
</body>
</html>