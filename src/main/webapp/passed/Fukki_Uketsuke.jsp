<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="ninsyou.AuthenticationController" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Fukki_Uketsuke.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>復帰処理受付</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"></p>
<p><font size="+2"><b>G-PROject復帰受付</b></font></p>
<p>入力されたIDには退会処理が行われています。復帰処理（IDの復活）を行う場合は「操作実行」をクリックしてください。<br>
<br>
※1復帰処理後に<font color="#0000ff"><b>会員情報の確認、ID・パスワードの変更</b></font>を行うことを強くお勧めします。<br>
※2復帰処理を行うと、退会処理からの経過時間はリセットされます。</p>
<p>入力されたID:<%=request.getRemoteUser() %></p>
<p align="center"><a href="/G-pro_Service/Fukki_Update"><img src="/G-pro_Service/image/Sousa_Jikkou.gif" width="91" height="43" border="0"></a>　　　　　<a href="/G-pro_Service/AuthenticationController"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="188" height="43" border="0"></a></p>
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/Fukki_Update">G-PRO IDを復活させる</a></dd>
    </dl>
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">G-PROjectトップへ戻る</a></dd>
    </dl>
</body>
</html>