<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="gpro_ron.GRon_Wrong_Uketsuke" %>
<jsp:useBean id="wrong_taisyou" scope="session" type="gpro_ron.GRon_Data_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRon.css"/>
<title>書き込みに対する違反報告</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/G-PRO-Ron_Logo.gif" width="282" height="102" border="0"></p>
<p><b><font size="+2">書き込みに対する違反報告</font></b></p>
<p><b><font color="#ff0000" size="+1">以下の書き込みが規約違反であることをG-PROjectに報告します。よろしいですか?</font></b></p>
<table border="1">
  <tbody>
    <tr>
      <td><b>No.</b></td>
      <td><b>&nbsp;書き込み日時:<%=wrong_taisyou.getKakikomiNichiji() %></b></td>
      <td rowspan="3"><b>&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Shiji.gif" width="56" height="54" border="0" alt="Good!">×<%=wrong_taisyou.getShijisyasu() %>&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Fushiji.gif" width="55" height="57" border="0" alt="Bad・・・">×<%=wrong_taisyou.getFushijisyasu() %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Write_Resp.gif" width="56" height="60" border="0" alt="Write Response ">×<%=wrong_taisyou.getHenshinsu() %></b></td>
    </tr>
    <tr>
      <td colspan="2"><b>記述者：<%=wrong_taisyou.getKijyutsusya_Name() %></b></td>
    </tr>
    <tr>
      <td align="right" colspan="2"><b>&nbsp;<%=wrong_taisyou.getKakikomi_Honbun() %><br>
      <font size="-1">違反報告</font></b></td>
    </tr>
  </tbody>
</table>
<p><b>※1:あなたがこの違反報告を行ったことが公表されることはありません。(法令による場合を除く)</b></p>
<p><b>※2:違反報告がされた書き込みは、サイトを巡回している管理者のチェックを受けるまで一時的に表示されなくなります。<br>
(チェックを受けるまでの期間の目安は1か月～2か月です。ただしサイトのアクセス状況によって大きく前後する場合があります)</b></p>
<p><b>※3:管理者によるチェックの結果、不適切な書き込みであると判断された場合は書き込みが完全に削除され、<br>
書き込みを行ったプレイヤーが「注意が必要なプレイヤー」としてマークされます。</b></p>
<!-- <p align="center"><a href="/G-pro_Service/GRon_Wrong_Update"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Kakutei.gif" width="164" height="43" border="0" alt="違反報告を確定する"></a>　　　　　<a href="/G-PRO_Ron_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoGRonTop.gif" width="158" height="42" border="0" alt="G-PRO論。トップに戻る"></a>　　　　　<a href="./G-pro_Service/passed/G-PRO_Ron/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoKaiinTop.gif" width="129" height="42" border="0" alt="会員メニューに戻る"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/GRon_Wrong_Update">違反報告を確定する</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp">G-PRO論。トップに戻る</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</body>
</html>