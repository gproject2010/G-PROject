<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="voteandExpect.VoAndExp_TO" %>
    <%@ page import="voteandExpect.VoAndExp_DAO" %>
    <%@ page import="voteandExpect.VoAndExp_RespPageMaker" %>
    <jsp:useBean id="taisyoudata" scope="session" type="voteandExpect.VoAndExp_TO"/>
    <jsp:useBean id="votedata" scope="session" type="voteandExpect.VoAndExp_TO"/>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html lang="ja">
<head>
<base href="/G-pro_Service/passed/VoteANDExpect/Vote_Uketsuke.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/VoAndExp.css"/>
<title>VoteAndExpect!投票受付</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/P_Rank_Back.gif" style="font-weight : bold;">
<p><img src="./VoAndExp_Images/Vote&Expect_Logo.gif" width="373" height="89" border="0"></p>
<p><b><font size="+3">回答・結果予想受付ページ</font></b></p>
<p><a href="/G-pro_Service/free_area/Tutoreal6.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<p><b><font size="+2">お題：<%=HttpUtility.escapeHTML(taisyoudata.getOdai()) %></font></b></p>
<p><b>受付開始：<%=HttpUtility.escapeHTML(taisyoudata.getStart_Date()) %></b></p>
<p><b>回答締切：<%=HttpUtility.escapeHTML(taisyoudata.getVote_Shimekiri()) %></b></p>
<p><b>結果予想締切:<%=HttpUtility.escapeHTML(taisyoudata.getExpect_Shimekiri()) %></b></p>
<p><b>総回答数：<%=taisyoudata.getResp_Count() %></b></p>
<p><b><img src="./VoAndExp_Images/Bonus_Logo.gif" width="339" height="55" border="0" alt="回答・予想的中ボーナス"></b></p>
<p><b>回答ボーナス:<%=HttpUtility.escapeHTML(taisyoudata.getVote_Bonus()) %> +<%=taisyoudata.getVBonus_Sc() %>Pts.</b></p>
<p><b>予想的中ボーナス：<%=HttpUtility.escapeHTML(taisyoudata.getExpect_Bonus()) %> +<%=taisyoudata.getExpBonus_SC() %>Pts.</b></p>
<% if(votedata.getKaitouKahi().equals("end")){ %>
<p><img src="./VoAndExp_Images/Anc_Result_Logo.gif" width="213" height="55" border="0" alt="アンケート結果"></p>
<!-- <p><img src="VoAndExp_RespPageMaker.png" border = 1 width=200 height=150/></p> -->
<table border="1">
  <tbody>
    <tr>
      <td><img src="./VoAndExp_Images/Sentakushi_A.gif" width="33" height="30" border="0" alt="A:"><b><font size="+2"><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_A()) %></font></b><br>
      <font color="#0000ff">選択者数：<%=votedata.getSentakusyasu_A() %>（<%= (double)votedata.getSentakusyasu_A() / votedata.getSentakusyasu_Total() * 100 %>％）<br>
      </font><font color="#009900">予想者数：<%=votedata.getYosousyasu_A() %>（<%= (double)votedata.getYosousyasu_A() / votedata.getYosousyasu_Total() * 100 %>％）</font></td>
      <td><img src="./VoAndExp_Images/Sentakushi_B.gif" width="31" height="30" border="0" alt="B:"><b><font size="+2"><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_B()) %></font></b><br>
      <font color="#0000ff">選択者数：<%=votedata.getSentakusyasu_B() %>（<%= (double)votedata.getSentakusyasu_B() / votedata.getSentakusyasu_Total() * 100 %>％）<br>
      </font><font color="#009900">予想者数：<%=votedata.getYosousyasu_B() %>（<%=(double)votedata.getYosousyasu_B() / votedata.getYosousyasu_Total() * 100 %>％）</font></td>
    </tr>
    <tr>
      <td><img src="./VoAndExp_Images/Sentakushi_C.gif" width="29" height="27" border="0" alt="C:"><b><font size="+2"><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_C()) %></font></b><br>
      <font color="#0000ff">選択者数：<%=votedata.getSentakusyasu_C() %>（<%= (double)votedata.getSentakusyasu_C() / votedata.getSentakusyasu_Total() * 100 %>％）<br>
      </font><font color="#009900">予想者数：<%=votedata.getYosousyasu_C() %>（<%= (double)votedata.getYosousyasu_C() / votedata.getYosousyasu_Total() * 100 %>％）</font></td>
      <td><img src="./VoAndExp_Images/Sentakushi_D.gif" width="33" height="30" border="0" alt="D:"><font size="+2"><b><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_D()) %></b></font><br>
      <font color="#009900"><font color="#0000ff">選択者数：<%=votedata.getSentakusyasu_D() %>（<%=(double)votedata.getSentakusyasu_D() / votedata.getSentakusyasu_Total() * 100 %>％）<br>
      </font>予想者数：<%=votedata.getYosousyasu_D() %>（<%= (double)votedata.getYosousyasu_D() / votedata.getYosousyasu_Total() * 100 %>％）</font></td>
    </tr>
  </tbody>
</table>
<p><img src="./VoAndExp_Images/Your_Sel_Logo.gif" width="235" height="37" border="0" alt="あなたの選択・結果予想"></p>
<p><font size="+1"><b>選択：<%=HttpUtility.escapeHTML(votedata.getYour_Vote()) %>、結果予想：<%=HttpUtility.escapeHTML(votedata.getYour_Exp()) %></b></font></p>
<% if(votedata.getYour_Exp().equals(votedata.getMaxExp())){ %><p><b><font color="#0000ff">予想的中!ボーナス加算の対象になります!</font></b></p><% } %>
<% }else if(votedata.getKaitouKahi().equals("now")){ %>
<p><img src="./VoAndExp_Images/Your_Sel_Logo.gif" width="235" height="37" border="0" alt="あなたの選択・結果予想"></p>
<p><font size="+1"><b>選択：<%=HttpUtility.escapeHTML(votedata.getYour_Vote()) %>、結果予想：<%=HttpUtility.escapeHTML(votedata.getYour_Exp()) %></b></font></p>
<!-- <p><b><img src="VoAndExp_Images/Others_Expect.gif" width="365" height="55" border="0" alt="他のプレイヤーの結果予想"></b></p>
<p><img src="VoAndExp_RespPageMaker.png" border = 1 width=200 height=150/></p>
<p><img src="VoAndExp_Images/Sentakushi_Logo.gif" width="126" height="55" border="0" alt="選択肢"></p>-->
<% if(!(votedata.getYour_Vote().equals("未回答"))){ %>
<p><font color="#ff0000">既に回答済みのため、このお題には回答できません</font></p>
<% } %>
<% if(votedata.getDiff() < 0){ %>
<p><font color="#ff0000">結果予想の締切日時を過ぎているため、このお題に対する結果予想への投票はできません。</font></p>
<% }else if(!(votedata.getYour_Exp().equals("未投票"))){ %>
<font color="#ff0000">既に投票済みのため、このお題に対する結果予想への投票はできません。</font>
<% } %>
<form action="/G-pro_Service/Vote_Update" method="post">
<table border="1">
  <tbody>
    <tr>
      <td><img src="./VoAndExp_Images/Sentakushi_A.gif" width="33" height="30" border="0" alt="A:"><b><font size="+2"><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_A()) %></font></b><br>
      <%if(votedata.getYour_Vote().equals("未回答")){ %><font color="#0000ff"><input type="radio" checked name="vote" value="A">選択</font><% } if(votedata.getYour_Exp().equals("未投票") && votedata.getDiff() >= 0){ %><font color="#009900"><input type="radio" name="expect" value="A">予想</font><% } %></td>
      <td><img src="./VoAndExp_Images/Sentakushi_B.gif" width="31" height="30" border="0" alt="B:"><b><font size="+2"><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_B()) %></font></b><br>
      <%if(votedata.getYour_Vote().equals("未回答")){ %><font color="#0000ff"><input type="radio" name="vote" value="B">選択</font><% } if(votedata.getYour_Exp().equals("未投票") && votedata.getDiff() >= 0){ %><font color="#009900"><input type="radio" name="expect" value="B">予想</font><% } %></td>
    </tr>
    <% if(taisyoudata.getResp_Mode().equals("三択") || taisyoudata.getResp_Mode().equals("四択")){ %>
    <tr>
      <td><img src="./VoAndExp_Images/Sentakushi_C.gif" width="29" height="27" border="0" alt="C:"><b><font size="+2"><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_C()) %></font></b><br>
      <%if(votedata.getYour_Vote().equals("未回答")){ %><font color="#0000ff"><input type="radio" name="vote" value="C">選択</font><% } if(votedata.getYour_Exp().equals("未投票") && votedata.getDiff() >= 0){ %><font color="#009900"><input type="radio" name="expect" value="C">予想</font><% } %></td>
      <% if(taisyoudata.getResp_Mode().equals("四択")){ %>
      <td><img src="./VoAndExp_Images/Sentakushi_D.gif" width="33" height="30" border="0" alt="D:"><font size="+2"><b><%=HttpUtility.escapeHTML(taisyoudata.getSentakushi_D()) %></b></font><br>
      <%if(votedata.getYour_Vote().equals("未回答")){ %><font color="#0000ff"><input type="radio" name="vote" value="D">選択</font><% } if(votedata.getYour_Exp().equals("未投票") && votedata.getDiff() >= 0){ %>&nbsp;<font color="#009900"><input type="radio" name="expect" value="D">予想<% } %></font></td>
    <% } %>
    </tr>
    <% } %>
  </tbody>
</table>
<%if(votedata.getYour_Exp().equals("empty") && votedata.getDiff() <= 0){ %><font color="#009900"><input type="radio" checked name="expect" value="empty">結果予想を行わない</font><% } %>
<!-- <p align="center"><input type="image" name="submit" src="./VoAndExp_Images/Kakutei_Button.gif" width="61" height="48" border="0"><a href="./VoteAndExpect_Top.jsp">　　　<img src="./VoAndExp_Images/BacktoVoExpTop.gif" width="185" height="42" border="0" alt="Vote&Expect!トップに戻る"></a> 　　　<a href="/G-pro_Service/passed/VoteANDExpect/Kaiin_Menu_Top.jsp"><img src="./VoAndExp_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<input class="tourokubutton" type="submit" name="submit" value="閲覧ページへ">
<% } %>
<dl>
      <dd class="tourokubutton"><a href="./VoteAndExpect_Top.jsp">Vote&amp;Expect!トップへ戻る</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</form>
</body>
</html>