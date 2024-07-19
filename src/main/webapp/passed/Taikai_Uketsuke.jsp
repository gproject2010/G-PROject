<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="ninsyou.N_jyouhou_TO" %>
    <%@page import="ninsyou.N_jyouhou_DAO" %>
    <%@page import="ninsyou.Lv2_Pass_Check" %>
    <jsp:useBean id="ninsyou_jyouhou" scope="session" type="ninsyou.N_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Taikai_Uketsuke.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>退会処理受付</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0">
<p><b><font size="+2">退会処理受付</font></b></p>
<p>G-PROjectに対する退会受付を行います。</p>
<p>会員情報は退会の受付日から3か月後の月末まで保持されます。それを過ぎると会員情報は完全に削除され、<br>
復旧ができなくなります。なお、削除されるまでに復帰処理を行うことで元の状態に戻すことができます。<br>
復帰処理に関してはチュートリアルをご覧ください。</p>
<p>「操作実行」をクリックすると退会受付を実行します。</p>
<p>退会処理を行うG-PRO_ID：<%=ninsyou_jyouhou.getK_Id() %></p>
<!-- <p align="center"><a href="/G-pro_Service/Taikai_Upload"><img src="/G-pro_Service/image/Sousa_Jikkou.gif" width="91" height="43" border="0"></a>　　　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/image/BacktoKaiinTop.gif" width="188" height="43" border="0"></a></p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/Taikai_Upload">操作実行</a></dd>
    </dl>
    <dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューへ戻る</a></dd>
    </dl>
</body>
</html>