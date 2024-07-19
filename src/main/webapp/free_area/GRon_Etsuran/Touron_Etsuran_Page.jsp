<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="inputUtility.Date_Changer" %>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="gpro_ron.GRon_Etsuran_Load" %>
<jsp:useBean id="tourondata_lv1" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="tourondata_lv2" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="tourondata_lv3" scope="session" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="keijidata" scope="session" type="gpro_ron.GRon_Data_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<base href="/G-pro_Service/free_area/GRon_Etsuran/Touron_Etsuran_Page.jsp"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title>G-PRO論。討論ページ(閲覧専用)</title>
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
// --></script>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
<p><img src="/G-pro_Service/image/GRon_Logo.gif" width="230" height="83" border="0"></p>
<p>※このページはJavaScriptを使用しています。</p>
<p><b>掲示板コード:<%=keijidata.getKeijiban_Code() %></b></p>
<p><b>開設者：<%=keijidata.getKaisetsusya() %></b></p>
<p><font size="+3">議題：<%=keijidata.getGidai() %></font></p>
<p><b>この掲示板の書き込み条件：
<% if(keijidata.getJyoukenSyubetsu().equals("G-PROjectランキング上位者")){ %>
      <%=keijidata.getSc_Syubetsu() %>の<%=keijidata.getRankJyouken() %><br>
      ランキング<%=keijidata.getRank_Min() %>位以上
      <% }else if(keijidata.getJyoukenSyubetsu().equals("アクションスコア")){ %>
      <%=keijidata.getSc_Syubetsu() %>のアクションスコア<br>
      <%=keijidata.getSc_Min() %>以上
      <% }else if(keijidata.getJyoukenSyubetsu().equals("レポートスコア")){ %>
      <%=keijidata.getSc_Syubetsu() %>のレポートスコア<br>
      <%=keijidata.getSc_Min() %>以上
      <% }else if(keijidata.getJyoukenSyubetsu().equals("プレイヤーレベル")){ %>
      プレイヤーレベル<br>
      <%=keijidata.getPlayerLv_Min() %>以上<%=keijidata.getPlayerLv_Max() %>以下
       <% }else if(keijidata.getJyoukenSyubetsu().equals("年齢")){ %>
      年齢<br>
      <%=keijidata.getPlayerLv_Min() %>歳以上<%=keijidata.getPlayerLv_Max() %>歳以下
      <% }else if(keijidata.getJyoukenSyubetsu().equals("性別")){ %>
      性別：<%=keijidata.getSex() %>
      <% }else if(keijidata.getJyoukenSyubetsu().equals("フリー(条件なし)")){ %>
      フリー(条件なし)
      <% }else{ %>
      ERROR
      <% } %></b></p>
<table border="1">
  <tbody>
    <tr>
      <td>開設者からのメッセージ</td>
    </tr>
    <tr>
      <td><pre><%=keijidata.getFirst_Write() %></pre></td>
    </tr>
  </tbody>
</table>
<br>
<br>
<form action="j_security_check" method="post">
<table>
  <tbody>
    <tr>
      <td colspan="2">&nbsp;<img src="/G-pro_Service/image/LetsKakikomi.gif" width="299" height="28" border="0" alt="今すぐログインしてこの掲示板に書き込もう!"><br>
      ※会員メニューに移動します&nbsp;</td>
    </tr>
    <tr>
      <td>&nbsp;G-PRO ID:<input size="20" type="text" name="j_username">　パスワード：<input size="20" type="password" name="j_password">&nbsp;</td>
      <td><input type="image" name="submit" src="/G-pro_Service/image/Login_Button.gif" width="62" height="40" border="0"></td>
    </tr>
    <tr>
      <td>&nbsp;<font color="#0000cc">※<b>未登録の方はこの機会にG-PROjectへ新規登録!→</b></font></td>
      <td><a href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p0.html"><img src="/G-pro_Service/image/button221.gif" width="74" height="42" border="0"></a></td>
    </tr>
  </tbody>
</table>
</form>
<br>
<br>
<% for(GRon_Data_TO lv1 : tourondata_lv1){ %>
<table border="1">
  <tbody>
    <tr>
      <td>No.<%=lv1.getKakikomi_No() %></td>
      <td>&nbsp;書き込み日時:</td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(lv1.getKijyutsusya_Name()) %></td>
    </tr>
    <tr>
      <td align="right" colspan="2"><pre><%=HttpUtility.escapeHTML(lv1.getKakikomi_Honbun()) %></pre></td>
    </tr>
  </tbody>
</table>
<% for(GRon_Data_TO lv2 : tourondata_lv2){ %>
<div class="CollapsibleBox1" id="CBoxCover1">
<div class="CollapsibleBoxTitle1">
<p class="cBoxButtons"><a href="#" onclick="HideCBox('CBoxBody1'); return false;" title="折りたたみ/表示">折りたたみ</a></p>
<p class="cBoxTitle">No.<%=lv2.getOrigin_Youso() %>に対するレスポンス</p>
</div>
<div class="CollapsibleBoxBody" id="CBoxBody1">
<table border="1">
  <tbody>
    <tr>
      <td>No.<%=lv2.getKakikomi_No() %></td>
      <td>&nbsp;書き込み日時:<%=HttpUtility.escapeHTML(lv2.getKakikomiNichiji()) %></td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(lv2.getKijyutsusya_Name()) %>(PLv.<%=lv2.getKijyutsusya_Lv() %>)</td>
    </tr>
    <tr>
      <td align="right" colspan="2"><pre><%=HttpUtility.escapeHTML(lv2.getKakikomi_Honbun()) %></pre><br></td>
    </tr>
  </tbody>
</table>
<% for(GRon_Data_TO lv3 : tourondata_lv3){ %>
<div class="CollapsibleBox1-1" id="CBoxCover1-1">
<div class="CollapsibleBoxTitle1-1">
<p class="cBoxButtons"><a href="#" onclick="HideCBox('CBoxBody1-1'); return false;" title="折りたたみ/表示">折りたたみ</a></p>
<p class="cBoxTitle">No.<%=lv3.getOrigin_Youso() %>に対するレスポンス</p>
</div>
<div class="CollapsibleBoxBody1-1" id="CBoxBody1-1">
<table border="1">
  <tbody>
    <tr>
      <td>No.<%=lv3.getKakikomi_No() %></td>
      <td>&nbsp;書き込み日時:<%=HttpUtility.escapeHTML(lv3.getKakikomiNichiji()) %></td>
    </tr>
    <tr>
      <td colspan="2">記述者：<%=HttpUtility.escapeHTML(lv3.getKijyutsusya_Name()) %>(PLv.<%=lv3.getKijyutsusya_Lv() %>)</td>
    </tr>
    <tr>
      <td align="right" colspan="2"><pre><%=HttpUtility.escapeHTML(lv3.getKakikomi_Honbun()) %></pre><br></td>
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
<p><font color="red" size="+2"><b>※掲載内容の盗用、無断転載、無断複製を禁止します。</b></font></p>
<!-- <p align="center">　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="188" height="43" border="0"></a></p>-->
<dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a>
    </dl>
</body>
</html>