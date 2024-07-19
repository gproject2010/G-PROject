<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="g_jyouhou.GS_jyouhou_TO" %>
    <%@ page import="g_jyouhou.G_Syousai_DAO" %>
    <%@ page import="g_jyouhou.G_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="g_jyouhou.GS_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Rep_Yobidashi.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>テンプレートのダウンロード</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"><br>
<br>
<font size="+3">レポート作成用フォームの呼び出し<br>
</font><font size="+2"><br>
使用するテンプレートを選択してください<br>
<br>
選択中のゲーム：<%=HttpUtility.escapeHTML(syousai.getGametitle())%><br>
<br>
<a href="/G-pro_Service/passed/OX_Report/MaruBatsu_Rep_Temp.jsp" target="_blank">・○×レポート</a><br>
</font>対象となるゲームの「良かった所」と「今後の課題」を列挙していく、もっとも簡単なテンプレート。<br>
<br>
<a href="/G-pro_Service/passed/Kiji_Report/Kiji_Rep_Temp.jsp" target="_blank"><font size="+2">・紹介記事レポート</font></a><br>
ゲームの紹介記事と同じように作成するテンプレート。<br>
<br>
<a href="/G-pro_Service/passed/Free_Report/Free_Rep_Temp.jsp" target="_blank"><font size="+2">・自由形式レポート(上級者向け)<br>
</font></a>基本情報の入力だけを添付書類としてテンプレート上で用意し、<br>
それ以外はすべて自由に作成できるテンプレート。<br>
</p>
<!-- <p align="center"><a href="/G-pro_Service/passed/Game_Data_Show.jsp"><img src="/G-pro_Service/image/Cansel_Button.gif" width="83" height="46" border="0"></a>          <a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/image/BacktoKaiinTop.gif"></a><br>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/Game_Data_Show.jsp">ゲーム情報へ戻る</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>