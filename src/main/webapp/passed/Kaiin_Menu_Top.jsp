<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="ninsyou.N_jyouhou_TO" %>
    <%@page import="ninsyou.N_jyouhou_DAO" %>
    <%@page import="ninsyou.Infomation_TO" %>
    <%@page import="ninsyou.Infomation_DAO" %>
    <%@page import="ninsyou.AuthenticationController" %>
    <jsp:useBean id="infomation" scope="session" type="java.util.ArrayList<ninsyou.Infomation_TO>"/>
    <jsp:useBean id="brock" scope="session" type="ninsyou.N_jyouhou_TO"/>
<html lang="ja">
<base href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"/>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex,nofollow"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
<title>会員メニュー</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif">
<p><img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0"></p>
<p><b><font size="+3">会員メニュー</font>　　　${sessionScope.seiseki.login_name}さん、ようこそG-Projectへ！</b><br>
<br>
ログイン時刻:${sessionScope.nowtime}
<br>
<br>
<% if(brock.isSeiseki_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">1：個人ステータス</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br><% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2"><a href="/G-pro_Service/StatusMaker">1：個人ステータス</a></font><br>
あなたの現在の成績が閲覧できます。<br>
<br><% } %>
<% if(brock.isGetsuran_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">2：ゲーム検索</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><a href="/G-pro_Service/passed/game_kensaku.html"><font size="+2">2：ゲーム検索</font></a><br>
G-projectに登録されているゲームの情報を検索・閲覧できるほか、その場でレポートの作成もできます。<br>
<br>
<% } %>
<% if(brock.isNewGame_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">3：?????</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2"><a href="/G-pro_Service/NewGame_Serch">3：発売前のゲーム、企画提案レポートの閲覧</a></font><br>
発売前のゲーム、および企画提案レポートに投稿されたゲーム企画を閲覧し、それに対するレポートを作成できます。<br>
<br>
<% } %>
<% if(brock.isShinkiRep_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">4：?????</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2"><a href="./Temp_Download.html" target="_blank">4：新規登録ゲームレポートの提出</a></font><br>
G-PROjectに登録されていないゲーム(2012年12月以前に発売されたゲーム、ダウンロード専用タイトル、モバイル機器のゲームアプリ、アーケードゲームなど)のレポートを作成します。<br>
<br>
<% } %>
<% if(brock.isGRon_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">5:?????</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2"><a href="/G-pro_Service/GPRO_Ron_ToppageMaker">5:オレにも言わせろ!G-PRO論。</a></font><br>
ゲームに関する様々な「議題」に対して掲示板上で討論を行います。<br>
<br>
<% } %>
<% if(brock.isVoAndExp_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">6:?????</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2"><a href="/G-pro_Service/VoteAndExpect_TopMaker">6:Vote＆Expect!</a></font><br>
ゲームに関する簡単な質問に投票＆結果を予想してスコアをゲット!<br>
<br>
<% } %>
<% if(brock.isGRiron_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">7:?????</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2"><a href="/G-pro_Service/Riron_TopPageMaker">7:熱く語れ!G-PRO_Re:論。</a></font><br>
ゲーム業界に対する意見や提案だけでなく、「今後のゲーム業界はこうなる」など、とにかくゲームに関することなら何でもOK!あなたの考えを熱く語りましょう!<br>
<br>
<% } %>
<% if(brock.isPropRep_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">8:?????</font><br>
準備中のためこのコンテンツは現在利用できません。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Pink.gif" width="45" height="30" border="0"><a href="/G-pro_Service/passed/NewGames/Proposal_Report_Kiyaku.html"><font size="+2">8:企画提案レポート(上級者向け)</font><br>
</a>あなたが考えたゲームの企画を発表するためのレポートを作成・提出するための添付書類のテンプレートです。
企画書とプレゼン用資料、公開用の体験版ソフトを用意しよう。※企画投稿規約への同意が必要です。<br>
<br>
<% } %>
<% if(brock.isK_HenkouLock() == true){ %>
<img src="/G-pro_Service/image/Right_Orange.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">9：会員情報の変更</font><br>
準備中のため現在変更できません。お急ぎの方はお問い合わせフォームにてお知らせ下さい。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Orange.gif" width="45" height="30" border="0"><font size="+2"><a href="./Kaiin_Henkou_Menu.html">9：会員情報の変更</a></font><br>
<br>
<% } %>
<% if(brock.isCoupon_Lock() == true){ %>
<img src="/G-pro_Service/image/Right_Orange.gif" width="45" height="30" border="0"><font size="+2" color="ff0000">10：G-PROクーポンの適用</font><br>
準備中のため現在適用できません。お急ぎの方はお問い合わせフォームにてお知らせ下さい。<br>
<br>
<% }else{ %>
<img src="/G-pro_Service/image/Right_Orange.gif" width="45" height="30" border="0"><font size="+2"><a href="./Coupon/Coupon_Code_Nyuryoku.jsp">10:G-PROクーポンの適用</a></font><br>
<br>
<% } %>
<img src="/G-pro_Service/image/Left_Red.gif" width="45" height="30" border="0"><font size="+2"><a href="/G-pro_Service/Logout">11：ログアウト(トップページへ)</a></font>
<br>
<% if(infomation.size() > 0){ %>
<p align="center"><b><img src="/G-pro_Service/image/WhatsNew.gif" width="260" height="55" border="0" alt="What's　NEW"></b></p>
<% for(Infomation_TO List : infomation){ %>
<form action="/G-pro_Service/Infomation_SyousaiMaker"><input type="hidden" name="code" value="<%=List.getInfoCode() %>"><input type="hidden" name="login_jyoukyou" value="yes"><p align="center">【<%=List.getInfo_Syubetsu() %>】<%=List.getKeisaiDate() %>　　　<%=List.getKenmei() %><input type="submit" name="syousai" value="詳細閲覧"></p></form>
<% } %>
<% } %>
<br>
<!-- 
<p><a href='/G-pro_Service/TopPageMaker'><img src="/G-pro_Service/image/Gp_Shop_Logo.gif" width="485" height="127" border="0" align="left"></a></p>
<p>←レポート提出時などにもらえる「G-PROマイレージ(MR)」が<br>
使用できるショッピングモールです。まずはクリック！</p>
-->
</body>
</html>