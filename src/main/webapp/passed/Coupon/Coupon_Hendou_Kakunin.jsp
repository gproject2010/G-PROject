<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.lang.Integer" %>
    <%@ page import="k_jyouhou.R_jyouhou_TO" %>
    <%@ page import="k_jyouhou.R_jyouhou_DAO" %>
    <%@ page import="pennant_race.PennantData_TO" %>
    <%@ page import="pennant_race.PennantData_DAO" %>
    <%@ page import="coupon.Coupon_Data_TO" %>
    <%@ page import="coupon.Coupon_Data_DAO" %>
    <%@ page import="coupon.Coupon_NaiyouMaker" %>
    <jsp:useBean id="seiseki" scope="session" type="k_jyouhou.R_jyouhou_TO"/>
    <jsp:useBean id="coupondata" scope="session" type="coupon.Coupon_Data_TO"/>
    <jsp:useBean id="leaguedata" scope="session" class="java.util.ArrayList" type="java.util.ArrayList<pennant_race.PennantData_TO>"/>
    <jsp:useBean id="leaguecount" scope="session" type="java.lang.Integer"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Coupon/Coupon_Hendou_Kakunin.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<meta name="robots" content="noindex,nofollow"/>
<title>G-PROクーポン(適用確認)</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"></p>
<p><b><font size="+2">クーポンによるパラメータ変動の確認</font></b></p>
<p><b><font color="#0000cc">今回適用するクーポンにより、下記のパラメータが変動します。<br>
適用を確定するには「確定」を、適用を中止して戻る場合は「会員メニューに戻る」をクリックしてください。</font></b></p>
<p><b><font size="+1">クーポン名：<%=HttpUtility.escapeHTML(coupondata.getCoupon_Name()) %></font></b></p>
<p><b>適用先G-PRO ID：<%=HttpUtility.escapeHTML(seiseki.getk_Id()) %></b></p>
<p><b>クーポンの発行者:<%=HttpUtility.escapeHTML(coupondata.getCoupon_From()) %></b></p>
<p><b>クーポン有効期限：<%=HttpUtility.escapeHTML(coupondata.getUse_Limit()) %></b></p>
<p><b>基本パラメータへの影響</b></p>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>レポートスコア</td>
      <td>適用前</td>
      <td>適用後</td>
    </tr>
    <tr>
      <td>累計</td>
      <td><%=seiseki.getreportScore_Ruikei() %>&nbsp;</td>
      <td><%=seiseki.getreportScore_Ruikei() + coupondata.getRepscore_Bonus() %>&nbsp;</td>
    </tr>
    <tr>
      <td>今月</td>
      <td><%=seiseki.getreportScore_Kongetsu() %>&nbsp;</td>
      <td><%=seiseki.getreportScore_Kongetsu() + coupondata.getRepscore_Bonus() %>&nbsp;</td>
    </tr>
    <tr>
      <td>年間</td>
      <td><%=seiseki.getreportScore_Nenkan() %>&nbsp;</td>
      <td><%=seiseki.getreportScore_Nenkan() + coupondata.getRepscore_Bonus() %>&nbsp;</td>
    </tr>
  </tbody>
</table>
<table border="1" align="left">
  <tbody>
    <tr>
      <td>アクションスコア</td>
      <td>適用前</td>
      <td>適用後</td>
    </tr>
    <tr>
      <td>累計</td>
      <td><%=seiseki.getActionScore_Ruikei() %>&nbsp;</td>
      <td><%=seiseki.getActionScore_Ruikei() + coupondata.getActscore_Bonus() %>&nbsp;</td>
    </tr>
    <tr>
      <td>今月</td>
      <td><%=seiseki.getactionScore_Kongetsu() %>&nbsp;</td>
      <td><%=seiseki.getactionScore_Kongetsu() + coupondata.getActscore_Bonus() %>&nbsp;</td>
    </tr>
    <tr>
      <td>年間</td>
      <td><%=seiseki.getActionScore_Nenkan() %>&nbsp;</td>
      <td><%=seiseki.getActionScore_Nenkan() + coupondata.getActscore_Bonus() %>&nbsp;</td>
    </tr>
  </tbody>
</table>
<table border="1">
  <tbody>
    <tr>
      <td>全リーグ合計☆(スター)</td>
      <td>適用前</td>
      <td>適用後</td>
    </tr>
    <tr>
      <td>累計</td>
      <td><%=seiseki.getStar_Count() %>&nbsp;</td>
      <td><%=seiseki.getStar_Count() + coupondata.getStar_Bonus() %>&nbsp;</td>
    </tr>
  </tbody>
</table>
<br>
<br>
<p><b><font size="+1">称号獲得:</font></b><br>
<%for(int i=0; i < coupondata.getSyougou_List().length; i++){ %>
・<%=coupondata.getSyougou_List()[i] %><br>
<% } %></p>
<p><b>G-PROペナントレースへの影響</b></p>
<% if(leaguecount == 0){ %>
<p><b><font color="#0000cc">適用先のリーグにあなたの情報が見つからなかったため、登録情報を新たに作成します。</font></b></p>
<p><b>クーポン適用後に作成されるあなたのリーグ情報</b></p>
<table border="1">
  <tbody>
    <tr>
      <td><b>リーグ名称</b></td>
      <td><b>シーズン・リーグクラス</b></td>
      <td width="65"><b>シーズン獲得<br>
      スター</b></td>
      <td><b>累計獲得<br>
      スター</b></td>
    </tr>
    <tr>
      <td height="56"><b><img src="/G-pro_Service/LogoImage_Load/<%=leaguedata.get(0).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile">&nbsp;<br>
      <i style="font-family : メイリオ;"><%=HttpUtility.escapeHTML(leaguedata.get(0).getLeagueName()) %></i></b></td>
      <td height="56" style="font-family : メイリオ;"><b><i><font size="+1" color="#0000cc">Season <%=leaguedata.get(0).getSeason() %></font><font size="+1"><br>
      </font><font color="#00cc00"><font size="+1">League Class <%=leaguedata.get(0).getLeagueClass() %>&nbsp;</font></font></i></b></td>
      <td align="center"><b>&nbsp;<img src="/G-pro_Service/image/Single_Star.gif" width="40" height="44" border="0"><br>
      ×<%=coupondata.getStar_Bonus() %></b></td>
      <td align="center"><b><img src="/G-pro_Service/image/Single_Star.gif" width="40" height="44" border="0"><br>
      ×<%=coupondata.getStar_Bonus() %>&nbsp;</b></td>
    </tr>
  </tbody>
</table>
<% }else{ %>
<p><b>クーポン適用前</b></p>
<table border="1">
  <tbody>
    <tr>
      <td><b>リーグ名称</b></td>
      <td><b>シーズン・リーグクラス</b></td>
      <td width="65"><b>シーズン順位/<br>
      獲得<br>
      スター</b></td>
      <td><b>累計順位/<br>
      獲得<br>
      スター</b></td>
    </tr>
    <% for(int i=0; i < leaguedata.size(); i++){ %>
    <% if(leaguedata.get(i).getLeagueCode().equals(coupondata.getLeague_Code())){ %>
    <tr>
      <td height="56"><b><img src="/G-pro_Service/LogoImage_Load/<%=leaguedata.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile">&nbsp;<br>
      <i style="font-family : メイリオ;"><%=HttpUtility.escapeHTML(leaguedata.get(i).getLeagueName()) %></i></b></td>
      <td height="56" style="font-family : メイリオ;"><b><i><font size="+1" color="#0000cc">Season <%=leaguedata.get(i).getSeason() %></font><font size="+1"><br>
      </font><font color="#00cc00"><font size="+1">League Class <%=leaguedata.get(i).getLeagueClass() %>&nbsp;</font></font></i></b></td>
      <td align="center"><b>&nbsp;<img src="/G-pro_Service/image/Single_Star.gif" width="40" height="44" border="0"><br>
      ×<%=leaguedata.get(i).getSeason_Star() %></b></td>
      <td align="center"><b><img src="/G-pro_Service/image/Single_Star.gif" width="40" height="44" border="0"><br>
      ×<%=leaguedata.get(i).getStar_Count() %>&nbsp;</b></td>
    </tr>
    <% } %>
    <% } %>
  </tbody>
</table>
<p><b>クーポン適用後</b></p>
<table border="1">
  <tbody>
    <tr>
      <td><b>リーグ名称</b></td>
      <td><b>シーズン・リーグクラス</b></td>
      <td width="65"><b>シーズン獲得<br>
      スター</b></td>
      <td><b>累計獲得<br>
      スター</b></td>
    </tr>
    <% for(int i=0; i < leaguedata.size(); i++){ %>
    <% if(leaguedata.get(i).getLeagueCode().equals(coupondata.getLeague_Code())){ %>
    <tr>
      <td height="56"><b><img src="/G-pro_Service/LogoImage_Load/<%=leaguedata.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile">&nbsp;<br>
      <i style="font-family : メイリオ;">ミュージックゲームリーグ</i></b></td>
      <td height="56" style="font-family : メイリオ;"><b><i><font size="+1" color="#0000cc">Season <%=leaguedata.get(i).getSeason() %></font><font size="+1"><br>
      </font><font color="#00cc00"><font size="+1">League Class <%=leaguedata.get(i).getLeagueClass() %>&nbsp;</font></font></i></b></td>
      <td width="65" height="56" align="center"><b>&nbsp;<img src="/G-pro_Service/image/Single_Star.gif" width="40" height="44" border="0"><br>
      ×<%=leaguedata.get(i).getSeason_Star() + coupondata.getStar_Bonus() %></b></td>
      <td align="center"><b><img src="/G-pro_Service/image/Single_Star.gif" width="40" height="44" border="0"><br>
      ×<%=leaguedata.get(i).getStar_Count() + coupondata.getStar_Bonus() %>&nbsp;</b></td>
    </tr>
    <% } %>
    <% } %>
  </tbody>
</table>
<% } %>
<p align="center"><a href="/G-pro_Service/Coupon_Naiyou_Update"><img src="/G-pro_Service/image/Kakutei_Button.gif" width="67" height="52" border="0"></a>　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="213" height="53" border="0"></a></p>
</body>
</html>