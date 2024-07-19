<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="inputUtility.Date_Changer" %>
<%@ page import="k_jyouhou.R_jyouhou_TO" %>
<%@ page import="k_jyouhou.R_jyouhou_DAO" %>
<%@ page import="gpro_ron.GPRO_Ron_ToppageMaker" %>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="gpro_ron.GRon_SyousaiMaker" %>
<jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
<jsp:useBean id="tourondata_lv1" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="tourondata_lv2" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="tourondata_lv3" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="kakikomikahi" scope="session" type="gpro_ron.GRon_Data_TO"/>
<jsp:useBean id="keijidata" scope="session" type="gpro_ron.GRon_Data_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/G-PRO_Ron/Touron_Page.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GRon.css"/>
<title>討論ページ(議題:<%=HttpUtility.escapeHTML(keijidata.getGidai()) %>)</title> 
<script type="text/javascript"><!--
function HideCBox(boxid){
var target = document.getElementById(boxid);
if(target.style.display != "none"){
target.style.display = "none";
}
else{
target.style.display = "";
}
}
//--></script>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/GRon_Logo.gif" width="230" height="83" border="0"></p>
<p><a href="/G-pro_Service/free_area/Tutoreal5.html" target="_blank"><input type="button" name="help" value="ヘルプを表示"></a><font color="#0000ff">←クリックするとレポートの説明(チュートリアル)を表示します</font></p>
<p>掲示板コード:<%=HttpUtility.escapeHTML(keijidata.getKeijiban_Code()) %></p>
<p>開設者：<%=HttpUtility.escapeHTML(keijidata.getKaisetsusya()) %></p>
<p><font size="+3">議題：<%=HttpUtility.escapeHTML(keijidata.getGidai()) %></font></p>
<table border="1">
  <tbody>
    <tr>
      <td>No.1</td>
      <td>&nbsp;書き込み日時:<%=keijidata.getKaisetsuNichiji() %></td>
      <td rowspan="3">&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Shiji.gif" width="56" height="54" border="0" alt="Good!">×---&nbsp;<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Fushiji.gif" width="55" height="57" border="0" alt="Bad・・・">×---<img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Write_Resp.gif" width="56" height="60" border="0" alt="Write Response ">×--<br>
      この書き込みには投票・レスポンスできません</td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(keijidata.getKaisetsusya()) %></td>
    </tr>
    <tr>
      <td align="right">&nbsp;<pre><%=HttpUtility.escapeHTML(keijidata.getFirst_Write()) %></pre></td>
    </tr>
  </tbody>
</table>
<% if(kakikomikahi.isKakikomiKahi() == true){ %>
<dl>
<dd><a href='/G-pro_Service/GRon_Resp_PageMaker?no=0'>レスポンス元を指定せずに新規書き込み</a></dd>
</dl>
<% }else{ %>
<p><font color="#ff0000">書き込み条件を満たしていないため、支持・不支持の投票ボタンのみ使用できます。</font></p>
<% } %>
<% if(keijidata.getKaisetsusya_ID().equals(seiseki.getk_Id())){ %>
<p><a href='/G-pro_Service/passed/G-PRO_Ron/GRon_Del_Kakunin.jsp'>この掲示板を削除する</a></p>
<% } %>
<% for(GRon_Data_TO lv1 : tourondata_lv1){ %>
<table border="1">
  <tbody>
    <tr>
      <td>No.<%= lv1.getKakikomi_No() %>&nbsp;</td>
      <td>書き込み日時:<%=HttpUtility.escapeHTML(lv1.getKakikomiNichiji()) %>&nbsp;</td>
      <td rowspan="3"><%if(lv1.getTouhyouKaisu() <= lv1.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %><a href='/G-pro_Service/GRon_Vote_Uketsuke?vote=shiji&no=<%=lv1.getKakikomi_No() %>'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Shiji.gif" width="56" height="54" border="0" alt="Good!">×<%=lv1.getShijisyasu() %><% if(lv1.getTouhyouKaisu() <= lv1.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %></a><% } if(lv1.getTouhyouKaisu() <= lv1.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %><a href='/G-pro_Service/GRon_Vote_Uketsuke?vote=fushiji&no=<%=lv1.getKakikomi_No() %>'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Fushiji.gif" width="55" height="57" border="0" alt="Bad・・・">×<%=lv1.getFushijisyasu() %><% if(lv1.getTouhyouKaisu() <= lv1.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %></a><% } if(lv1.getKakikomiKaisu() <= lv1.getKakikomiJyougen() && kakikomikahi.isKakikomiKahi() == true){ %><a href='/G-pro_Service/GRon_Resp_PageMaker?no=<%=lv1.getKakikomi_No() %>&command=insert'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Write_Resp.gif" width="56" height="60" border="0" alt="Write Response ">×<%= lv1.getHenshinsu() %><% if(lv1.getKakikomiKaisu() <= lv1.getKakikomiJyougen() && kakikomikahi.isKakikomiKahi() == true){ %></a><% } %><br>
     <% if(lv1.getKijyutsusya_ID().equals(seiseki.getk_Id())){ %>
     <a href='/G-pro_Service/GRon_Resp_PageMaker?no=<%=lv1.getKakikomi_No() %>&command=update'>この記述を変更・削除する</a>
     <% }else if(lv1.getKakikomiKaisu() < lv1.getKakikomiJyougen() && kakikomikahi.isTouhyouKahi() == true){ %> この記述に対してレスポンス可能です<br>
     <% }else{ %> この記述に対してレスポンスできません<% } %><br>&nbsp;
     </td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(lv1.getKijyutsusya_Name()) %>(PLv.<%=lv1.getKijyutsusya_Lv() %>)&nbsp;</td>
    </tr>
    <tr>
      <td align="right" colspan="2"><pre><%=HttpUtility.escapeHTML(lv1.getKakikomi_Honbun()) %></pre><br>
      <font size="-1"><a href='/G-pro_Service/GRon_Wrong_Uketsuke?no=<%=lv1.getKakikomi_No() %>'>違反報告</a></font>&nbsp;</td>
    </tr>
  </tbody>
</table>
<% for(GRon_Data_TO lv2 : tourondata_lv2){ %>
<% if(lv1.getKakikomi_No() == lv2.getOrigin_Youso()){ %>
<div class="CollapsibleBox1" id="CBoxCover1">
<div class="CollapsibleBoxTitle1">
<p class="cBoxButtons"><a href="#" onclick="HideCBox('CBoxBody1'); return false;" title="折りたたみ/表示">折りたたみ</a></p>
<p class="cBoxTitle">No.<%=lv2.getOrigin_Youso() %>に対するレスポンス</p>
</div>
<div class="CollapsibleBoxBody" id="CBoxBody1">
<table border="1">
  <tbody>
    <tr>
      <td>No.<%=lv2.getKakikomi_No() %>&nbsp;</td>
      <td>書き込み日時:<%=HttpUtility.escapeHTML(lv2.getKakikomiNichiji()) %>&nbsp;</td>
      <td rowspan="3"><%if(lv2.getTouhyouKaisu() <= lv2.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %><a href='/G-pro_Service/GRon_Vote_Uketsuke?vote=shiji&no=<%=lv2.getKakikomi_No() %>'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Shiji.gif" width="56" height="54" border="0" alt="Good!">×<%=lv2.getShijisyasu() %><%if(lv2.getTouhyouKaisu() <= lv2.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %></a><% } if(lv2.getTouhyouKaisu() <= lv2.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %><a href='/G-pro_Service/GRon_Vote_Uketsuke?vote=fushiji&no=<%=lv2.getKakikomi_No() %>'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Fushiji.gif" width="55" height="57" border="0" alt="Bad・・・">×<%=lv2.getFushijisyasu() %><%if(lv2.getTouhyouKaisu() <= lv2.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %></a><% } if(lv2.getKakikomiKaisu() <= lv2.getKakikomiJyougen() && kakikomikahi.isKakikomiKahi() == true){ %><a href='/G-pro_Service/GRon_Resp_PageMaker?no=<%=lv2.getKakikomi_No() %>&command=insert'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Write_Resp.gif" width="56" height="60" border="0" alt="Write Response ">×<%= lv2.getHenshinsu() %><% if(lv2.getKakikomiKaisu() <= lv2.getKakikomiJyougen() && kakikomikahi.isKakikomiKahi() == true){ %></a><% } %><br>
      <% if(lv2.getKijyutsusya_ID().equals(seiseki.getk_Id())){ %>
     <a href='/G-pro_Service/GRon_Resp_PageMaker?no=<%=lv2.getKakikomi_No() %>&command=update'>この記述を変更・削除する</a>
     <% }else if(lv2.getKakikomiKaisu() < lv2.getKakikomiJyougen() && kakikomikahi.isTouhyouKahi() == true){ %> この記述に対してレスポンス可能です<br>
     <% }else{ %> この記述に対してレスポンスできません<% } %><br>&nbsp;
     </td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(lv2.getKijyutsusya_Name()) %>(PLv.<%=lv2.getKijyutsusya_Lv() %>)&nbsp;</td>
    </tr>
    <tr>
      <td align="right" colspan="2"><pre><%=HttpUtility.escapeHTML(lv2.getKakikomi_Honbun()) %></pre><br>
      <font size="-1"><a href='/G-pro_Service/GRon_Wrong_Uketsuke?no=<%=lv2.getKakikomi_No() %>'>違反報告</a></font>&nbsp;</td>
    </tr>
  </tbody>
</table>
<% } %>
<% for(GRon_Data_TO lv3 : tourondata_lv3){ %>
<% if(lv2.getKakikomi_No() == lv3.getOrigin_Youso()){ %>
<div class="CollapsibleBox1-1" id="CBoxCover1-1">
<div class="CollapsibleBoxTitle1-1">
<p class="cBoxButtons"><a href="#" onclick="HideCBox('CBoxBody1-1'); return false;" title="折りたたみ/表示">折りたたみ</a></p>
<p class="cBoxTitle">No.<%=lv3.getOrigin_Youso() %>に対するレスポンス</p>
</div>
<div class="CollapsibleBoxBody1-1" id="CBoxBody1-1">
<table border="1">
  <tbody>
    <tr>
      <td>No.<%=lv3.getKakikomi_No() %>&nbsp;</td>
      <td>書き込み日時:<%=HttpUtility.escapeHTML(lv3.getKakikomiNichiji()) %>&nbsp;</td>
      <td rowspan="3"><%if(lv3.getTouhyouKaisu() <= lv3.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %><a href='/G-pro_Service/GRon_Vote_Uketsuke?vote=shiji&no=<%=lv3.getKakikomi_No() %>'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Shiji.gif" width="56" height="54" border="0" alt="Good!">×<%=lv3.getShijisyasu() %><%if(lv3.getTouhyouKaisu() <= lv3.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %></a><% } if(lv3.getTouhyouKaisu() <= lv3.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %><a href='/G-pro_Service/GRon_Vote_Uketsuke?vote=fushiji&no=<%=lv3.getKakikomi_No() %>'><% } %><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/Vote_Fushiji.gif" width="55" height="57" border="0" alt="Bad・・・">×<%=lv3.getFushijisyasu() %><%if(lv3.getTouhyouKaisu() <= lv3.getTouhyouJyougen() && kakikomikahi.isTouhyouKahi() == true){ %></a><% } %><br>
     <% if(lv3.getKijyutsusya_ID().equals(seiseki.getk_Id())){ %>
     <a href='/G-pro_Service/GRon_Resp_PageMaker?no=<%=lv3.getKakikomi_No() %>&command=update'>この記述を変更・削除する</a>
     <% }else if(lv3.getKakikomiKaisu() < lv3.getKakikomiJyougen() && kakikomikahi.isTouhyouKahi() == true){ %> この記述に対してレスポンス可能です<br>
     <% }else{ %> この記述に対してレスポンスできません<% } %><br>&nbsp;
     </td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(lv3.getKijyutsusya_Name()) %>(PLv.<%=lv3.getKijyutsusya_Lv() %>)&nbsp;</td>
    </tr>
    <tr>
      <td align="right" colspan="2"><pre><%=HttpUtility.escapeHTML(lv3.getKakikomi_Honbun()) %></pre><br>
      <font size="-1"><a href='/G-pro_Service/GRon_Wrong_Uketsuke?no=<%=lv3.getKakikomi_No() %>'>違反報告</a></font>&nbsp;</td>
    </tr>
  </tbody>
</table>
<% } %>
</div>
</div>
<% } %>
</div>
</div>
<% } %>
<% } %>
<p><font color="red" size="+2"><b>※掲載内容の盗用、無断転載、無断複製を禁止します。</b></font></p>
<!-- <p align="center"><a href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoGRonTop.gif" width="158" height="42" border="0"></a>　　　<a href="./G-pro_Service/passed/G-PRO_Ron/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/G-PRO_Ron/GRon_Images/BacktoKaiinTop.gif" width="149" height="43" border="0"></a></p>-->
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/passed/G-PRO_Ron/G-PRO_Ron_Top.jsp">G-PRO論。トップに戻る</a></dd>
</dl>
<dl>
<dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
</dl>
</body>
</html>