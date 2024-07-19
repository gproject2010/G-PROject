<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="inputUtility.HttpUtility" %>
    <%@ page import="inputUtility.Date_Changer" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.lang.String" %>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
<%@ page import="rep_upload.Rep_Koumoku" %>
<%@ page import="g_jyouhou.Rep_Load_DAO" %>
<%@ page import="voteandExpect.VoAndExp_DAO" %>
<%@ page import="voteandExpect.VoAndExp_TO" %>
<%@ page import="ninsyou.Infomation_TO" %>
<%@ page import="ninsyou.Infomation_DAO" %>
<%@ page import="rep_upload.NewGames_TO" %>
<%@ page import="rep_upload.NewGame_DAO" %>
<%@ page import="gpro_riron.GPRiron_TO" %>
<%@ page import="gpro_riron.GPRiron_DAO" %>
<%@ page import="event.EventData_TO" %>
<%@ page import="event.EventData_DAO" %>
<%@ page import="pennant_race.PennantData_TO" %>
<%@ page import="pennant_race.PennantData_DAO" %>
<%@ page import="location.LocateData_DAO" %>
<%@ page import="ninsyou.Contents_Data_Load" %>
<jsp:useBean id="wordrepindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<rep_upload.Rep_Koumoku>"/>
<jsp:useBean id="gronindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="voexpindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
<jsp:useBean id="freevoexpindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
<jsp:useBean id="freevoexpvote" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
<jsp:useBean id="infoindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<ninsyou.Infomation_TO>"/>
<jsp:useBean id="propindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<rep_upload.NewGames_TO>"/>
<jsp:useBean id="rironindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<gpro_riron.GPRiron_TO>"/>
<jsp:useBean id="raitenindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<location.RaitenData_TO>"/>
<jsp:useBean id="eventindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<event.EventData_TO>"/>
<jsp:useBean id="pennantindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<pennant_race.PennantData_TO>"/>
<jsp:useBean id="enginelinks" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<ninsyou.Infomation_TO>"/>
<jsp:useBean id="bloglinks" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<ninsyou.Infomation_TO>"/>
<jsp:useBean id="locates" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<java.lang.String>"/>
<jsp:useBean id="lockdata" scope="application" type="ninsyou.N_jyouhou_TO"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/G-pro_Service/free_area/G-PROject_Top.jsp"/>
<meta name="description" content="ゲーム業界に対しユーザーの皆様の意見や提案を「ダイレクトに」伝えるレビューサイトです。「メーカーにもっと面白いゲームを作ってほしい」熱いメッセージ、お待ちしております!"/>
<meta name="keywords" content="ゲーム レビュー, G-PROject,"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Top_Program.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/masonry.pkgd.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/pageusefiles/G-PROject_Top.js" charset="UTF-8"></script>
<!-- Google Tag Manager -->
<noscript><iframe src="//www.googletagmanager.com/ns.html?id=GTM-W4QJX6"
height="0" width="0" style="display:none;visibility:hidden"></iframe></noscript>
<script>(function(w,d,s,l,i){w[l]=w[l]||[];w[l].push({'gtm.start':
new Date().getTime(),event:'gtm.js'});var f=d.getElementsByTagName(s)[0],
j=d.createElement(s),dl=l!='dataLayer'?'&l='+l:'';j.async=true;j.src=
'//www.googletagmanager.com/gtm.js?id='+i+dl;f.parentNode.insertBefore(j,f);
})(window,document,'script','dataLayer','GTM-W4QJX6');</script>
<!-- End Google Tag Manager -->
<title>G-PROjectトップ | ゲームについて考えるゲームレビューサイト</title>
</head>
<body>
<div id="loginform">
<form action="j_security_check" name="login" method="post">
<img src="/G-pro_Service/image/Login_Logo.gif" width="100" height="50" border="0"><br>
G-PRO ID:<input size="20" type="text" name="j_username" maxlength="20"><br>
パスワード：<input size="20" type="password" maxlength="20" name="j_password"><br>
    <a href="javascript:document.login.submit()">
    <button class="tourokubutton">ログイン</button>
    </a>
    </form>
    <a href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p0.html"><button class="tourokubutton">ID取得</button></a></div>
    <p id="pankuzulist"><a href="http://www.gamereporters.info/">GATEWAY</a> &gt; G-PROjectトップ<br></p>
<div id="title-back">
  <img src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif"width="365" height="140" border="0" id="title">
<a href="#" class="button" id="mainmenubutton">MENU</a>
</div>
<ul id="jumpmenu">
<li><a href="#" id="submenubutton1">チュートリアル</a>
<ul class="submenu1">
<li><a href="/G-pro_Service/free_area/Tutoreal1.html">G-PROject企画意図・サイト登録の流れ</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal2.html">ゲームレポート概要</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal3.html">ゲームレポート作成方法</a></li>
<li><a href="/G-pro_Service/free_area/Tutorial4.html">ゲームの評価基準</a></li>
<li><a href="/G-pro_Service/free_area/Tutorial4-1.html">ゲームレポートの審査</a></li>
<li><a href="/G-pro_Service/free_area/Tutorial4-2.html">レポートスコア・アクションスコア</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal5.html#koumoku4">俺にも言わせろ!G-PRO論。</a></li>
<li><a href="/G-pro_Service/free_area/GRiron_Tutoreal.html#koumoku5">熱く語れ!G-PRO_Re:論。</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal6.html#koumoku6">Vote&amp;expect!</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal7.html#koumoku7">proposal(提案)レポート</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku8">各種スコア・ランキング</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku10">退会・復帰処理</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku11">利用にあたっての注意</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku12">禁止・制限事項</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal9.html#koumoku13">プライバシーポリシー</a></li>
</ul></li>
<li><a href="#" id="submenubutton2">ランキング(プレイヤー関係)</a>
      <ul class="submenu2">
        <li><a href="/G-pro_Service/K_RankingMaker?hani=kongetsu">レポートスコア(今月)</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=sengetsu">レポートスコア(先月)</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=nenkan">レポートスコア(年間)</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=ruikei">レポートスコア(累計)</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=r_count">レポートアップロード数</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=act_kongetsu">アクションスコア(今月)</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=act_sengetsu">アクションスコア(先月)</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=act_nenkan">アクションスコア(年間)</a></li>
        <li><a href="/G-pro_Service/K_RankingMaker?hani=act_ruikei">アクションスコア(累計)</a></li>
      </ul>
      </li>
      <li><a href="#" id="submenubutton3">ランキング(ゲーム関係)</a>
      <ul class="submenu3">
        <li><a href="/G-pro_Service/G_RankingMaker?hani=dai1_insyou">第一印象(発売1ヶ月のG-Score)</a></li>
        <li><a href="/G-pro_Service/G_RankingMaker?hani=ninkisaku">人気作(発売1年のレポート総数)</a></li>
        <li><a href="/G-pro_Service/G_RankingMaker?hani=nenkan">ビッグヒット(発売1年のG-Score)</a></li>
        <li><a href="/G-pro_Service/G_RankingMaker?hani=meisaku">名作(累計のG-Score)</a></li>
      </ul>
      </li>
      <li><a href="#" id="submenubutton4">What's NEW</a>
      <ul class="submenu4">
      <% for(Infomation_TO koumoku : infoindex){ %>
        <li><a href="/G-pro_Service/Infomation_SyousaiMaker?code=<%=koumoku.getInfoCode()%>&login_jyoukyou=no"><%=HttpUtility.escapeHTML(koumoku.getKenmei()) %>(<%=koumoku.getKeisaiDate() %>掲載)</a></li>
        <% } %>
      </ul>
      </li>
      <li id="login_button"><a href="#">ログイン/G-PRO_ID取得</a></li>
    </ul>

<!-- <p><a href="/G-pro_Service/Blog_TopMaker"><img src="/G-pro_Service/free_area/Blog/Blog_Logo.gif" width="750" height="178" border="0"><br>
↑管理人の「つぶやき」公開中！</a></p>-->

<div id="tab-unit">
<div id="kyoutsu" class="page"></div>
<div class="tab-content">
<h3 class="tab"><a href="#kyoutsu"><img class="tablogo" src="/G-pro_Service/free_area/Ver2_Images/Contents_Tab.gif" width="270" height="147" border="0"></a></h3>
<div id="contents">
<div id="main">
	<img src="/G-pro_Service/LogoImage_Load/TopEvent?syubetsu=event_poster" border="0" class="contentimage">
	<form name="event_syousai" action="/G-pro_Service/Event_SyousaiMaker" method="post">
          <input type="hidden" name="eventcode" value="<%=eventindex.get(0).getEventCode() %>">
          <dl class="list">
      <dd class="button"><a href="javascript:document.event_syousai.submit()">詳細ページへ</a></dd>
      </dl>
      </form>
          <div class="description">
          <br>
          <br>
 <p><strong>G-PRO IDを取得するとG-PROjectへの正式な投稿、ランキングへの参加など、あらゆる機能が<br>
    使用できるようになります。この機会に下のボタンからぜひご登録ください！!</strong></p>
    <dl>
      <dd id="tourokubutton"><a href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p0.html">G-PRO IDを取得する</a></dd>
    </dl>
<dl class="list">
	<dd>G-PRO ID・パスワードを失念した(忘れてしまった)方はこちら→</dd>
      <dd class="button"><a href="/G-pro_Service/free_area/Nin_Syoukai_P1.html">G-PRO ID・<br>パスワード照会</a></dd>
    </dl>
<br>
</div>
</div>
<div id="sub"><img src="/G-pro_Service/image/Links_Logo.gif" width="98" height="50" border="0" alt="リンク集"><b>関連リンク集<br>
    <br>
    <img src="/G-pro_Service/image/Kensaku_Engine_Logo.gif" width="132" height="47" border="0" alt="検索エンジン"><br>
    <% for(Infomation_TO list : enginelinks){ %>
    ・<%=list.getKanrisya() %><br>
    <a href="<%=list.getURL() %>" target="blank"><% if(list.getImageURL() == null || list.getImageURL().equals("") || list.getImageURL().equals("null")){%><%=list.getURL() %><% }else{ %><img src="<%=list.getImageURL() %>" width="256" height="64"><% } %></a><br>
    <br>
    <% } %>
    <img src="/G-pro_Service/image/Game_Blog_Logo.gif" width="171" height="47" border="0" alt="ゲーム関連ブログ"><br>
    <% for(Infomation_TO list : bloglinks){ %>
    ・<%=list.getKanrisya() %><br>
    <a href="<%=list.getURL() %>" target="blank"><% if(list.getImageURL() == null || list.getImageURL().equals("") || list.getImageURL().equals("null")){%><%=list.getURL() %><% }else{ %><img src="<%=list.getImageURL() %>" width="256" height="64"><% } %></a><br>
    <br></b>
    <% } %></div>
<div id="extra"></div>
</div>
</div>
<div id="consume" class="page"></div>
<div class="tab-content">
<h3 class="tab"><a href="./G-PROject_ConsumeTop.jsp#consume"><img class="tablogo" src="/G-pro_Service/free_area/Ver2_Images/Consumer_Tab.gif" width="297" height="141" border="0"></a></h3>
</div>
<div id="arcade" class="page"></div>
<div class="tab-content">
<h3 class="tab"><a href="./G-PROject_ArcadeTop.jsp#arcade"><img class="tablogo" src="/G-pro_Service/free_area/Ver2_Images/Arcade_Tab.gif" width="295" height="136" border="0"></a></h3>
</div>
</div>
</body>
</html>