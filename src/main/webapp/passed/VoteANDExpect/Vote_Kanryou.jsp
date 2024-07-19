<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="inputUtility.HttpUtility" %>
    <%@page import="voteandExpect.VoAndExp_TO" %>
    <%@page import="voteandExpect.VoAndExp_DAO" %>
    <%@page import="voteandExpect.VoAndExp_RespPageMaker" %>
    <%@page import="voteandExpect.VoAndExp_FreeRespPageMaker" %>
    <%@page import="voteandExpect.Vote_Update" %>
    <jsp:useBean id="taisyoudata" scope="session" type="voteandExpect.VoAndExp_TO"/>
    <jsp:useBean id="yourvote" scope="session" type="java.lang.String"/>
    <jsp:useBean id="yourexp" scope="session" type="java.lang.String"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/VoteANDExpect/Vote_Kanryou.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/VoAndExp.css"/>
<title>データ登録完了</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/P_Rank_Back.gif" style="font-weight : bold;">
<p><img src="./VoAndExp_Images/Vote&Expect_Logo.gif" width="273" height="98" border="0"></p>
<p><b><font size="+2">登録・変更の完了</font></b></p>
<p><b>${sessionScope.syori}の受付処理が完了しました。引き続き<br>
G-PROjectのコンテンツをお楽しみください!</b></p>
<p><img src="./VoAndExp_Images/TourokuNaiyou_Logo.gif" width="197" height="45" border="0" alt="登録・変更内容"></p>
<p>アンケートコード：<%=HttpUtility.escapeHTML(taisyoudata.getAnc_Code()) %></p>
<p>お題:<%=HttpUtility.escapeHTML(taisyoudata.getOdai()) %></p>
<p>投票した選択肢:<%=HttpUtility.escapeHTML(yourvote) %></p>
<p>1位予想選択肢:<%=HttpUtility.escapeHTML(yourexp) %></p>
<br>
<dl>
      <dd class="tourokubutton"><a href="./VoteAndExpect_Top.jsp">Vote&amp;Expect!トップへ戻る</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>