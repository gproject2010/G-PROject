<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="inputUtility.HttpUtility" %>
    <%@page import="voteandExpect.VoAndExp_TO" %>
    <%@page import="voteandExpect.VoAndExp_DAO" %>
    <%@page import="voteandExpect.VoAndExp_FreeRespPageMaker" %>
    <jsp:useBean id="taisyoudata" scope="session" type="voteandExpect.VoAndExp_TO"/>
    <jsp:useBean id="votedata" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
    <jsp:useBean id="expectdata" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
    <jsp:useBean id="maxexp" scope="session" type="java.lang.String"/>
    <jsp:useBean id="maxexpcount" scope="session" type="java.lang.Integer"/>
    <jsp:useBean id="your_vote" scope="session" type="java.lang.String"/>
    <jsp:useBean id="your_exp" scope="session" type="java.lang.String"/>
    <jsp:useBean id="kaitoukahi" scope="session" type="java.lang.String"/>
    <jsp:useBean id="diff" scope="session" type="java.lang.Integer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/G-pro_Service/passed/VoteANDExpect/NewVote_Uketsuke.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/VoAndExp.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/hanyou_files/Form_Submit.js" charset="UTF-8"></script>
<title>アンケート詳細(項目追加型アンケート)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/P_Rank_Back.gif">
<p><img src="./VoAndExp_Images/Vote&Expect_Logo.gif" width="490" height="117" border="0"></p>
<p>アンケートの現在状況</p>
<p>お題:<%=HttpUtility.escapeHTML(taisyoudata.getOdai()) %></p>
<p><%=HttpUtility.escapeHTML(taisyoudata.getDescription()) %></p>
<p>回答受付期間：<%=HttpUtility.escapeHTML(taisyoudata.getStart_Date()) %> ～ <%=HttpUtility.escapeHTML(taisyoudata.getVote_Shimekiri()) %></p>
<p>結果予想受付期間：<%=HttpUtility.escapeHTML(taisyoudata.getStart_Date()) %> ～ <%=HttpUtility.escapeHTML(taisyoudata.getExpect_Shimekiri()) %></p>
<p><img src="./VoAndExp_Images/Bonus_Logo.gif" width="339" height="55" border="0"></p>
<p>回答ボーナス：<%=HttpUtility.escapeHTML(taisyoudata.getVote_Bonus()) %>:<%=taisyoudata.getVBonus_Sc() %>Pts.<br>
<br>
結果予想的中ボーナス:<%=HttpUtility.escapeHTML(taisyoudata.getExpect_Bonus()) %>:<%=taisyoudata.getExpBonus_SC() %>Pts.</p>
<% if(votedata.size() != 0){ %>
<p><img src="./VoAndExp_Images/Sentakushi_Logo.gif" width="126" height="55" border="0"></p>
<% if(!(your_vote.equals("未回答"))){ %>
<p><font color="#ff0000">既に回答済みのため、このお題には回答できません</font></p>
<% } %>
<% if(diff < 0){ %>
<p><font color="#ff0000">結果予想の締切日時を過ぎているため、このお題に対する結果予想への投票はできません。</font></p>
<% }else if(!(your_exp.equals("未投票"))){ %>
<font color="#ff0000">既に投票済みのため、このお題に対する結果予想への投票はできません。</font>
<% } %>
<form action="/G-pro_Service/FreeVote_Update" name="form1" method="post">
<table border="1">
  <tbody>
    <tr>
    <td>投票総数<br>
    順位</td>
      <td>選択肢</td>
      <td>現在の<br>
      得票数</td>
      <td>現在の<br>
      予想者数</td>
      <td>投票フォーム</td>
    </tr>
    <%for(int i=0; i < votedata.size(); i++){ %>
    <tr>
    <td><%=i+1 %></td>
      <td><%=HttpUtility.escapeHTML(votedata.get(i).getAnswer()) %></td>
      <td><%=votedata.get(i).getAnswer_Count() %>人</td>
      <td><%=expectdata.get(i).getAnswer_Count() %></td>
      <td>
      <%if(diff >= 0){ %>
      <% if(your_vote.equals("未回答")){ %>
      <input type="radio" name="vote" value="<%=votedata.get(i).getAnswer() %>"><font COLOR="#0000ff">選択</font><br>
      <% } %>
      <% if(your_exp.equals("未投票")){ %>
      <input type="radio" name="expect" value="<%=votedata.get(i).getAnswer() %>"><font COLOR="#009900">1位予想</font>
      <% } %>
      <% } %>
      </td>
    </tr>
    <% } %>
  </tbody>
</table>
<% if(your_exp.equals("未投票")){ %>
<p><input type="radio" checked name="expect" value="未投票">結果予想は行わない</p>
<% } %>
<p class="tourokubutton" onclick="onSubmit()">投票を確定する</p>
</form>
<% } %>
<% if(diff >= 0){ %>
<p><img src="./VoAndExp_Images/Sentakushi_Tsuika.gif" width="216" height="55" border="0" alt="選択肢の追加"><br>
このアンケートにはあなた独自の選択肢を追加することができます。<br>
追加したい選択肢がある場合は下記のフォームに入力してください。</p>
<form action="/G-pro_Service/FreeVote_Update" name="form2" method="post">
<table border="1">
  <tbody>
    <tr>
      <td>追加する選択肢</td>
      <td>投票フォーム</td>
    </tr>
    <tr>
      <td><input size="50" type="text" maxlength="50" name="vote" value="入力してください"></td>
      <% if(your_exp.equals("未投票")){ %>
      <td><input type="radio" name="expect" value="newsel"><font COLOR="#009900">1位予想</font>&nbsp;</td>
      <% } %>
    </tr>
  </tbody>
</table>
<% if(your_exp.equals("未投票")){ %>
<p><input type="radio" name="expect" value="empty" checked>結果予想は行わない(この選択肢は1位にはならない)</p>
<% } %>
<p class="tourokubutton" onclick="onSubmit2()">この選択肢を追加して投票する</p>
</form>
<% } %>
<p></p>
<p class="tourokubutton">アンケート一覧に戻る</p>
</body>
</html>