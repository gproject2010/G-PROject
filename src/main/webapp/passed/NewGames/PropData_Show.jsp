<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="java.util.ArrayList" %>
    <%@ page import="rep_upload.NewGames_TO" %>
    <%@ page import="rep_upload.NewGame_DAO" %>
    <%@ page import="rep_upload.Rep_List_TO" %>
    <%@ page import="rep_upload.Rep_List_DAO" %>
    <%@ page import="g_jyouhou.NewGame_SyousaiMaker" %>
    <jsp:useBean id="syousai" scope="session" type="rep_upload.NewGames_TO" />
    <jsp:useBean id="comments" scope="session" type="java.util.ArrayList<rep_upload.Rep_List_TO>" />
    <jsp:useBean id="up_flg" scope="session" type="java.lang.Integer" />
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
<base href="/G-pro_Service/passed/NewGames/PropData_Show.jsp"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<meta name="robots" content="noindex"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/NewGames.css"/>
<title>Proposal(提案)レポート閲覧</title>
</head>
<body background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif" style="font-weight : bold;">
<p><img src="/G-pro_Service/passed/NewGames/PropRep_Images/KikakuSyousai_Logo.gif" width="437" height="100" border="0" alt="-Proposal Report- 企画内容詳細"></p>
<p><br>
<%if(syousai.getLogoAddress() != null && (!(syousai.getLogoAddress().equals("")))){%>
<img src="/G-pro_Service/LogoImage_Load/<%=syousai.getLogoAddress()%>?syubetsu=proprep"><br>
<br>
<% } %>
<br>
<img src="/G-pro_Service/passed/NewGames/PropRep_Images/GameTitle.gif" width="160" height="33" border="0" alt="ゲームタイトル">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getGameTitle()) %></font></b></p>
<p><img src="/G-pro_Service/passed/NewGames/PropRep_Images/MainGenre.gif" width="117" height="24" border="0" alt="メインジャンル">　　　<font size="-1"><b><font size="+2"><%=HttpUtility.escapeHTML(syousai.getMainGenre()) %></font></b></font>　　　　　<img src="/G-pro_Service/passed/NewGames/PropRep_Images/SubGenre1.gif" width="110" height="23" border="0" alt="サブジャンル1">　　　<b><font size="+2"><%=HttpUtility.escapeHTML(syousai.getSubGenre1()) %></font></b>　　　<img src="/G-pro_Service/passed/NewGames/PropRep_Images/SubGenre2.gif" width="106" height="23" border="0" alt="サブジャンル2">　　　<b><font size="+2"><%=HttpUtility.escapeHTML(syousai.getSubGenre2()) %></font></b></p>
<p><img src="/G-pro_Service/passed/NewGames/PropRep_Images/CatchCopy.gif" width="150" height="33" border="0" alt="キャッチコピー">　　　<b><font size="+3"><%=HttpUtility.escapeHTML(syousai.getCatchCopy()) %></font></b></p>
<p><img src="/G-pro_Service/passed/NewGames/PropRep_Images/PenName.gif" width="224" height="25" border="0" alt="企画者名称・ペンネーム">　　　<b><font size="+2"><%=HttpUtility.escapeHTML(syousai.getPenName()) %></font></b></p>
<p><img src="/G-pro_Service/passed/NewGames/PropRep_Images/Kikakusya_HP.gif" width="95" height="24" border="0" alt="企画者HP">　　　<b><font size="+2"><a href="/G-pro_Service/Logout?url=<%=HttpUtility.escapeHTML(syousai.getUrl()) %>"><%=HttpUtility.escapeHTML(syousai.getUrl()) %></a></font><br>
※HPに移動する前にログアウトを行います</b></p>
<p><img src="/G-pro_Service/passed/NewGames/PropRep_Images/GameGaiyou.gif" width="132" height="33" border="0" alt="ゲーム概要"></p>
<p><b><font size="+2"><%=HttpUtility.escapeHTML(syousai.getGaiyou()) %></font></b></p>
<p><img src="/G-pro_Service/passed/NewGames/PropRep_Images/KoukaiJyouhou_Logo.gif" width="247" height="41" border="0" alt="公開情報ダウンロード"><br>
企画者が公開している各種データをダウンロードできます。<br></p>

<p>※1：ここでダウンロードできるデータは当社において不正な内容が含まれていないかチェックを行っておりますが、<br>
　<font color="#ff0000"><b>動作に関しては保証しておりません。もし不具合などが発生しても<br>
　G-PROduce、企画者ともに一切の責任を負いかねますのでご注意ください。</b><br>
※2:ダウンロードしたデータを企画者および当社の許可なく複製(コピー)、データの解析(リバースエンジニアリング等)、改変、レンタル、プレー以外の<br>
目的での使用、盗作、公に上映・送信(動画サイトなどへの投稿など)することは法律上違法であるかを問わず禁止します。これらのことを行った場合、<br>
法的措置(告訴・仮処分の申請など)を行う場合がありますのでご注意ください。</font></p>
<% String FilePath = null; %>
<p><% if(syousai.getSetteiShiryou() != null && (!syousai.getSetteiShiryou().equals(""))){ %><a href='/G-pro_Service/PropFileDownload/<%=syousai.getSetteiShiryou() %>?FileSyubetsu=setteishiryou'><img src="/G-pro_Service/passed/NewGames/PropRep_Images/SetteiShiryou_DL.gif" width="118" height="78" border="0" alt="設定資料 ダウンロード"></a><% } %>　　　<% if(syousai.getKikakuKaisetsusyo() != null && (!syousai.getKikakuKaisetsusyo().equals(""))){ %><a href='/G-pro_Service/PropFileDownload/<%=syousai.getKikakuKaisetsusyo() %>?FileSyubetsu=kikakukaisetsusyo'><img src="/G-pro_Service/passed/NewGames/PropRep_Images/KikakuKaisetsu_DL.gif" width="135" height="75" border="0" alt="企画解説書 ダウンロード"></a><% } %>　　　<% if(syousai.getTaikenban() != null && (!syousai.getTaikenban().equals(""))){ %><a href='/G-pro_Service/PropFileDownload/<%=syousai.getTaikenban() %>?FileSyubetsu=taikenban'><img src="/G-pro_Service/passed/NewGames/PropRep_Images/TaikenBan_DL.gif" width="171" height="73" border="0" alt="公開用体験版 ダウンロード"></a><% } %>　　　　<% if(syousai.getEtcData() != null && (!syousai.getEtcData().equals(""))){ %><a href='/G-pro_Service/PropFileDownload/<%=syousai.getEtcData() %>?FileSyubetsu=etcdata'><img src="/G-pro_Service/passed/NewGames/PropRep_Images/Sonotashiryou.gif" width="126" height="73" border="0" alt="その他資料 ダウンロード"></a><% } %></p>
<p><% if(syousai.getMovieAddress() != null && (!syousai.getMovieAddress().equals(""))){ %><a href="/G-pro_Service/Movie_Load/<%=syousai.getMovieAddress() %>?FileSyubetsu=proprep"><img src="/G-pro_Service/passed/NewGames/PropRep_Images/ImageVTR_DL.gif" width="216" height="88" border="0" alt="紹介・イメージVTR ダウンロード"></a><% } %></p><br>
※3:公開用体験版はzip形式で圧縮されています。解凍してご使用ください。<br>
※4:紹介ムービーの再生にはWindows Media Playerなどの動画再生ソフトが必要です。<br>
<% if(up_flg == 9999 || up_flg >= syousai.getSeigen_Kaisu()){ %>
<p><font size= +1 color="red">レポートの提出回数を使い切っているため、このゲームに対するレポートは作成できません。</font></p>
<%}else{ %>
<!-- <p><a href="/G-pro_Service/passed/NewGames/PropRep_Report_Temp.jsp" target="_blank"><img src="/G-pro_Service/passed/NewGames/NewGame_Images/HitokotoRep_Sakusei.gif" width="139" height="73" border="0" alt="ひと言レポート 作成"></a><br>-->
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/passed/NewGames/PropRep_Report_Temp.jsp" target="_blank">レスポンスレポート作成</a></dd>
    </dl>
この提案に対するレポートはあと<%=syousai.getSeigen_Kaisu() - up_flg %>回作成できます。<br>
<% } %>
<br>
<% if(comments.size() >= 1){ %>
<p><img src="/G-pro_Service/passed/NewGames/NewGame_Images/Comment.gif" width="424" height="34" border="0" alt="このゲームに対するプレイヤーのコメント"></p>
<% for(int i=0; i < comments.size(); i++){ %>
<p><%= HttpUtility.escapeHTML(comments.get(i).getComment()) %><br>
(<%=comments.get(i).getAge() %>代・<%=comments.get(i).getSex() %>)</p>
<% } %>
<% } %>
<!-- 　　　　　　　　　　　<a href="#" onClick="history.back(); return false;"><img src="/G-pro_Service/passed/NewGames/NewGame_Images/BacktoSerchResult.gif" height="63" border="0"/></a>　　　　　　　　　　　　　　　　　　　　　　<a href="/G-pro_Service/passed/Kaiin_Menu_Top.jsp"><img src="/G-pro_Service/passed/NewGames/NewGame_Images/BacktoKaiinTop.gif" height="63" border="0"/><br></a>-->
<dl>
      <dd class="tourokubutton"><a href="#" onClick="history.back(); return false;">検索結果に戻る</a></dd>
    </dl>
<dl>
      <dd class="tourokubutton"><a href="/G-pro_Service/AuthenticationController">会員メニューに戻る</a></dd>
    </dl>
</body>
</html>