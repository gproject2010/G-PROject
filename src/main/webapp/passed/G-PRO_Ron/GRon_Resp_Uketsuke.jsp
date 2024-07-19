<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="k_jyouhou.R_jyouhou_TO" %>
<%@ page import="k_jyouhou.R_jyouhou_DAO" %>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="gpro_ron.GRon_Resp_PageMaker" %>
<jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<jsp:useBean id="resp_taisyou" scope="session" type="gpro_ron.GRon_Data_TO"/>
<jsp:useBean id="kakikomikahi" scope="session" type="gpro_ron.GRon_Data_TO"/>
<jsp:useBean id="origin_no" scope="session" type="gpro_ron.GRon_Data_TO"/>
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/G-PRO_Ron/GRon_Resp_Uketsuke.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRon.css"/>
<title>書き込み受付</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">

<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/GRon_Logo.gif" width="244" height="88" border="0"></p>
<p><b><font size="+3">書き込み・編集・削除の受付</font></b></p>
<p><b>レスポンスする書き込み</b></p>
<table border="1">
  <tbody>
    <tr>
      <td>No.<%=resp_taisyou.getKakikomi_No() %></td>
      <td>&nbsp;書き込み日時:<%=resp_taisyou.getKakikomiNichiji() %></td>
      <td rowspan="3">&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Shiji.gif" width="56" height="54" border="0" alt="Good!">×<%=resp_taisyou.getShijisyasu() %>&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Fushiji.gif" width="55" height="57" border="0" alt="Bad・・・">×<%=resp_taisyou.getFushijisyasu() %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Write_Resp.gif" width="56" height="60" border="0" alt="Write Response ">×<%=resp_taisyou.getHenshinsu() %></td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=resp_taisyou.getKijyutsusya_Name() %></td>
    </tr>
    <tr>
      <td align="right" colspan="2">&nbsp;<%=resp_taisyou.getKakikomi_Honbun() %></td>
    </tr>
  </tbody>
</table>

<form action="/G-pro_Service/GRon_Resp_Update" method="post">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Kakikomi_Honbun.gif" width="137" height="38" border="0" alt="書き込み本文"><br>
<textarea rows="6" cols="60" name="honbun"><% if(seiseki.getk_Id().equals(resp_taisyou.getKijyutsusya_ID()) && kakikomikahi.isKakikomiKahi()){ %><%=resp_taisyou.getKakikomi_Honbun() %><% }else{ %>ここに入力してください<% } %></textarea><br>
※全角120文字まで<br>
※編集する場合はフォームの内容をそのまま変更してください</p>
<p><b><font size="+1" color="#0000ff">返信枠数：この書き込みに対して返信できるプレイヤー数を設定してください<br>
</font></b></p>
<b><input type="radio" name="henshinwaku" value="0" checked>返信を許可しない<br>
<input type="radio" name="henshinwaku" value="1">1人<br>
<input type="radio" name="henshinwaku" value="3">3人<br>
<input type="radio" name="henshinwaku" value="5">5人<br>
<input type="radio" name="henshinwaku" value="10">10人<br>
<input type="radio" name="henshinwaku" value="20">20人</b>
<input type="hidden" name="command" value="touroku">
<p><input class="tourokubutton" type="submit" name="submit" value="登録・更新"><br>
</form>
<br>
<% if(seiseki.getk_Id().equals(resp_taisyou.getKijyutsusya_ID())){ %>
<form action="/G-pro_Service/GRon_Resp_Update" method="post">
<input type="hidden" name="command" value="delete">
<input type="hidden" name="honbun" value="記述は削除されています">
<input type="hidden" name="henshinwaku" value="0">
<input type="hidden" name="command" value="delete">
<input type="submit" value="この記述を削除する"><br>
<b><font size="+1" color="#ff0000">注意:一度削除すると元に戻せません!<br>
(書き込み可能回数も増えません)</font><% } %></b>
<!-- <p align="center"><a href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoGRonTop.gif" width="158" height="42" border="0"></a>　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp">G-PRO論。トップに戻る</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</form>
</body>
</html>