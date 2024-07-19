<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="voteandExpect.VoAndExp_DAO" %>
    <%@ page import="voteandExpect.VoAndExp_TO" %>
    <%@ page import="voteandExpect.VoteAndExpect_TopMaker" %>
    <jsp:useBean id="nowinfo" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
    <jsp:useBean id="endinfo" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
     <jsp:useBean id="freenowinfo" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
    <jsp:useBean id="freeendinfo" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/VoteANDExpect/VoteAndExpect_Top.jsp">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/VoAndExp.css"/>
<title>VoteAndExpect!トップ</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/P_Rank_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/passed/VoteANDExpect/VoAndExp_Images/Vote&Expect_Logo.gif" width="490" height="117" border="0"></p>
<p><b><font size="+1">このページでは、簡単なアンケートに回答したり、その結果を予想したりすることにより<br>
レポートスコアやアクションスコア、G-PROマイレージなどを獲得できます。</font></b></p>
<p><a href="/G-pro_Service/free_area/Tutoreal6.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<p><img src="/G-pro_Service/passed/VoteANDExpect/VoAndExp_Images/NowInfo_Logo.gif" width="482" height="55" border="0" alt="回答・結果予想募集中のアンケート"></p>
<p>通常アンケート</p>
<table border="1">
  <tbody>
    <tr>
      <td>アンケート<br>
      コード&nbsp;</td>
      <td>お題&nbsp;</td>
      <td>回答方法&nbsp;</td>
      <td>募集開始<br>
      日時&nbsp;</td>
      <td>結果予想の<br>
      締切日時&nbsp;</td>
      <td>回答の<br>
      締切日時&nbsp;</td>
      <td>現在の<br>
      回答者数&nbsp;</td>
      <td>回答・結果予想<br>
      ページリンク&nbsp;</td>
    </tr>
    <% for(VoAndExp_TO now : nowinfo){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(now.getAnc_Code()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(now.getOdai()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(now.getResp_Mode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(now.getStart_Date()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(now.getExpect_Shimekiri()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(now.getVote_Shimekiri()) %>&nbsp;</td>
      <td><%=now.getResp_Count() %>&nbsp;</td>
      <td><form action="/G-pro_Service/VoAndExp_RespPageMaker" method="post">
      <input type="hidden" name="taisyoucode" value="<%=now.getAnc_Code() %>">
      <input type="hidden" name="kaitoukahi" value="now">
      <input class="tourokubutton" type="submit" name="submit" value="回答・予想ページへ">
      </form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<p>項目追加型アンケート</p>
<table border="1">
  <tbody>
    <tr>
      <td>アンケート<br>
      コード&nbsp;</td>
      <td>お題&nbsp;</td>
      <td>回答方法&nbsp;</td>
      <td>募集開始<br>
      日時&nbsp;</td>
      <td>結果予想の<br>
      締切日時&nbsp;</td>
      <td>回答の<br>
      締切日時&nbsp;</td>
      <td>現在の<br>
      回答者数&nbsp;</td>
      <td>回答・結果予想<br>
      ページリンク&nbsp;</td>
    </tr>
    <% for(VoAndExp_TO frnow : freenowinfo){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(frnow.getAnc_Code()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frnow.getOdai()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frnow.getResp_Mode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frnow.getStart_Date()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frnow.getExpect_Shimekiri()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frnow.getVote_Shimekiri()) %>&nbsp;</td>
      <td><%=frnow.getResp_Count() %>&nbsp;</td>
      <td><form action="/G-pro_Service/VoAndExp_FreeRespPageMaker" method="post">
      <input type="hidden" name="taisyoucode" value="<%=frnow.getAnc_Code() %>">
      <input type="hidden" name="kaitoukahi" value="now">
      <input class="tourokubutton" type="submit" name="submit" value="回答・予想ページへ">
      </form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<p><img src="/G-pro_Service/passed/VoteANDExpect/VoAndExp_Images/EndInfo_Logo.gif" width="241" height="55" border="0" alt="過去のアンケート">(過去3か月分)</p>
<p>通常アンケート</p>
<table border="1">
  <tbody>
    <tr>
      <td>アンケートコード&nbsp;</td>
      <td>お題&nbsp;</td>
      <td>&nbsp;回答方法</td>
      <td>募集時期&nbsp;</td>
      <td>トータル<br>
      回答者数&nbsp;</td>
      <td>閲覧ページ<br>
      リンク&nbsp;</td>
    </tr>
    <% for(VoAndExp_TO end : endinfo){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(end.getAnc_Code()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(end.getOdai()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(end.getResp_Mode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(end.getStart_Date()) %>~<br>
      <%=HttpUtility.escapeHTML(end.getVote_Shimekiri()) %>&nbsp;</td>
      <td><%=end.getResp_Count() %>&nbsp;</td>
      <td><form action="/G-pro_Service/VoAndExp_RespPageMaker" method="post">
      <input type="hidden" name="taisyoucode" value="<%=end.getAnc_Code() %>">
      <input type="hidden" name="kaitoukahi" value="end">
      <input class="tourokubutton" type="submit" name="submit" value="閲覧ページへ">
      </form>&nbsp;</td>
    </tr>
    <% } %>
  </tbody>
</table>
<p>項目追加型アンケート</p>
<table border="1">
  <tbody>
    <tr>
      <td>アンケートコード&nbsp;</td>
      <td>お題&nbsp;</td>
      <td>&nbsp;回答方法</td>
      <td>募集時期&nbsp;</td>
      <td>トータル<br>
      回答者数&nbsp;</td>
      <td>閲覧ページ<br>
      リンク&nbsp;</td>
    </tr>
    <% for(VoAndExp_TO frend : freeendinfo){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(frend.getAnc_Code()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frend.getOdai()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frend.getResp_Mode()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(frend.getStart_Date()) %>~<br>
      <%=HttpUtility.escapeHTML(frend.getVote_Shimekiri()) %>&nbsp;</td>
      <td><%=frend.getResp_Count() %>&nbsp;</td>
      <td><form action="/G-pro_Service/VoAndExp_FreeRespPageMaker" method="post">
      <input type="hidden" name="taisyoucode" value="<%=frend.getAnc_Code() %>">
      <input type="hidden" name="kaitoukahi" value="end">
      <input class="tourokubutton" type="submit" name="submit" value="閲覧ページへ">
      </form>&nbsp;</td>
    </tr>
    <% } %>
  </tbody>
</table>
<!-- <p align="center"><a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/VoteANDExpect/VoAndExp_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>