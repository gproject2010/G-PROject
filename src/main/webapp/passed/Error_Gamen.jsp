<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/Error_Gamen.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>エラー画面</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<p><img src="/G-pro_Service/image/GPRO_Logo.gif" width="232" height="67" border="0"></p>
<p><font color="#0000ff" size="+2">ERROR!!</font></p>
<p>処理中にエラーが発生しました。お手数ですが会員メニューからもう一度アクセスしてください。<br>
それでも解決しない場合はお問い合わせフォームにて以下のエラーコードとどんな状況で発生したかをお知らせください。</p>
<p><font size="+1"><b>エラーコード：${sessionScope.errcode}</b></font></p>
<!-- <p><a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/image/BacktoSiteTop.gif" width="188" height="43" border="0"></a></p>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">トップへ戻る</a></dd>
    </dl>
</body>
</html>