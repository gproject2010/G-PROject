<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="k_jyouhou.K_jyouhou_TO" %>
    <%@page import="k_jyouhou.K_jyouhou_DAO" %>
    <%@page import="ninsyou.Lv2_Pass_Check" %>
    <jsp:useBean id="ninsyou_jyouhou" scope="session" type="k_jyouhou.K_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Taikai_Uketsuke_Kanryou.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>退会受付完了</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0">
<p><b><font size="+2">退会処理受付完了</font></b></p>
<p>G-PROjectに対する退会受付が完了しました。</p>
<p>会員情報は退会の受付日から3か月後の月末まで保持されます。それを過ぎると会員情報は完全に削除され、<br>
復旧ができなくなります。なお、削除されるまでに復帰処理を行うことで元の状態に戻すことができます。<br>
復帰処理に関してはチュートリアルをご覧ください。</p>
<p>退会処理を行ったG-PRO_ID：<%=ninsyou_jyouhou.getk_Id() %></p>
※終了するにはブラウザの終了ボタンでページを閉じてください。
</body>
</html>