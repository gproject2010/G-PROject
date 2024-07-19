<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="inputUtility.HttpUtility" %>
<%@ page import="inputUtility.Date_Changer" %>
<%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="k_jyouhou.StatusMaker" %>
    <%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="gpro_ron.GRon_Kaisetsu_Uketsuke" %>
<jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<jsp:useBean id="kouhodata" scope="session" type="gpro_ron.GRon_Data_TO"/>
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/G-PRO_Ron/GRon_Kaisetsu_Kakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRon.css"/>
<title>掲示板開設設定確認</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/GRon_Logo.gif" width="311" height="112" border="0">　　　　　</p>
<p><b><font size="+3">開設情報確認</font></b></p>
<p><b><font size="+1" color="#0000cc">以下の内容で掲示板の開設を申請します。よろしいですか?</font></b></p>
<p><b><font size="+1">議題:<%= HttpUtility.escapeHTML(kouhodata.getGidai()) %></font></b></p>
<p><b>書き込み可能条件：<br>
<% if(kouhodata.getJyoukenSyubetsu().equals("G-PROjectランキング上位者")){ %>
      <%=HttpUtility.escapeHTML(kouhodata.getSc_Syubetsu()) %>の<%=HttpUtility.escapeHTML(kouhodata.getRankJyouken()) %><br>
      ランキング<%=kouhodata.getRank_Min() %>位以上
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("アクションスコア")){ %>
      <%=HttpUtility.escapeHTML(kouhodata.getSc_Syubetsu()) %>のアクションスコア<br>
      <%=kouhodata.getSc_Min() %>以上
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("レポートスコア")){ %>
      <%=HttpUtility.escapeHTML(kouhodata.getSc_Syubetsu()) %>のレポートスコア<br>
      <%=kouhodata.getSc_Min() %>以上
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("プレイヤーレベル")){ %>
      プレイヤーレベル<br>
      <%=kouhodata.getPlayerLv_Min() %>以上<%=kouhodata.getPlayerLv_Max() %>以下
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("年齢")){ %>
      年齢<br>
      <%=kouhodata.getPlayerLv_Min() %>歳以上<%=kouhodata.getPlayerLv_Max() %>歳以下
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("性別")){ %>
      性別：<%=kouhodata.getSex() %>
      <% }else if(kouhodata.getJyoukenSyubetsu().equals("フリー(条件なし)")){ %>
      フリー(条件なし)
      <% }else{ %>
      ERROR
      <% } %>
</b></p>
<p><b>書き込み制限回数(プレイヤー1人がこの掲示板に書き込める回数)：<br>
<%=kouhodata.getKakikomiJyougen() %>回<br>
</b></p>
<p><b>開設期間：掲載開始から<%= HttpUtility.escapeHTML(kouhodata.getKaisetsukikan()) %></b></p>
<p><b>最初の書き込みプレビュー：</b></p>
<table border="1">
  <tbody>
    <tr>
      <td>No.1</td>
      <td>&nbsp;書き込み日時:<%=Date_Changer.CalToString(kouhodata.getUp_Nichiji()) %></td>
      <td rowspan="3">&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Shiji.gif" width="56" height="54" border="0" alt="Good!">×0&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Fushiji.gif" width="55" height="57" border="0" alt="Bad・・・">×0<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Write_Resp.gif" width="56" height="60" border="0" alt="Write Response ">×0<br>
      この記述を変更・削除する</td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(kouhodata.getKaisetsusya()) %></td>
    </tr>
    <tr>
      <td align="right" colspan="2">&nbsp;<pre><%=HttpUtility.escapeHTML(kouhodata.getFirst_Write()) %></pre><br>
      <font size="-1">違反報告</font></td>
    </tr>
  </tbody>
</table>
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Your_Data.gif" width="185" height="37" border="0">※必ず確認してください<br>
<br>
G-PRO_ID：<%=HttpUtility.escapeHTML(seiseki.getk_Id()) %><br>
<br>
プレイヤーネーム：<%=HttpUtility.escapeHTML(seiseki.getlogin_name()) %></p>
<p>注意:<BR>
・開設してから1週間、他のプレイヤーからのレスポンスがなかった掲示板は自動で削除されます。<BR>
・開設した掲示板に対し、不適切な書き込みがされた場合、記述の削除だけでなく、管理者の判断により<BR>
掲示板自体を削除する場合があります。</p>
<!-- <a href="/G-pro_Service/GRon_Kaisetsu_Update"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Kakutei.gif" width="160" height="70" border="0"></a>　　　<a href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoGRonTop.gif" width="158" height="42" border="0"></a>　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/GRon_Kaisetsu_Update">この内容で申請する</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp">G-PRO論。トップに戻る</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</body>
</html>