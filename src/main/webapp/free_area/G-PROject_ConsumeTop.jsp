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
<base href="/G-pro_Service/free_area/G-PROject_ConsumeTop.jsp"/>
<meta name="description" content="ゲーム業界に対しユーザーの皆様の意見や提案を「ダイレクトに」伝えるレビューサイトです。「メーカーにもっと面白いゲームを作ってほしい」熱いメッセージ、お待ちしております!"/>
<meta name="keywords" content="ゲーム レビュー, G-PROject,"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Top_Program.css"/>
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/GPRO_Consume.css"/>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/masonry.pkgd.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/jquery-1.11.3.min.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/pageusefiles/G-PROject_Top.js" charset="UTF-8"></script>
<script type="text/javascript" language="JavaScript" src="/G-pro_Service/J-Script_Files/hanyou_files/CountdownTimer.js" charset="UTF-8"></script>
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
    <a href="#"><button class="tourokubutton">ID取得</button></a></div>
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
<h3 class="tab"><a href="./G-PROject_Top.jsp#kyoutsu"><img class="tablogo" src="/G-pro_Service/free_area/Ver2_Images/Contents_Tab.gif" width="270" height="147" border="0"></a></h3>
</div>

<div id="consume" class="page"></div>
<div id="consume_tag" class="tab-content">
<h3 class="tab"><a href="#consume"><img class="tablogo" src="/G-pro_Service/free_area/Ver2_Images/Consumer_Tab.gif" width="297" height="141" border="0"></a></h3>
<div class="description">
<div class="js-masonry">
<table border="1" class="item" background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif">
      <tbody>
        <tr>
          <td class="logo"><img src="/G-pro_Service/image/GReport_Logo.gif" width="185" height="39" border="0"></td>
          <td colspan="3" class="comment"> 最近アップロードされたレポート↓です。</td>
        </tr>
        <tr>
          <td class="title">&nbsp;ゲームタイトル</td>
          <td class="title">&nbsp;レポート種別</td>
          <td class="suchi">&nbsp;トータルスコア</td>
          <td>&nbsp;詳細を表示</td>
        </tr>
        <% for(int i=0; i < wordrepindex.size(); i++){ %>
	<tr>
          <td class="title"><%=HttpUtility.escapeHTML(wordrepindex.get(i).getGameTitle()) %>&nbsp;</td>
          <td class="title"><%=HttpUtility.escapeHTML(wordrepindex.get(i).getRep_Syubetsu()) %>&nbsp;</td>
          <td class="suchi"><%=wordrepindex.get(i).gettotal() %>&nbsp;</td>
          <td>
          <form name="wordrep_syousai<%=i %>" action="/G-pro_Service/WordRep_Load" method="post">
      <input type="hidden" name="rep_code" value="<%=wordrepindex.get(i).getRep_Code() %>">
          <dl class="list">
      <dd class="button"><a href="javascript:document.wordrep_syousai<%=i %>.submit()">表示</a></dd>
      </dl></form></td>
        </tr>
        <% } %>
        <tr>
        <td colspan="4">
        全レポートから検索する場合は検索範囲を選択し、<br>
        「検索」をクリックしてください↓
        <form name="wordsyousai" action="/G-pro_Service/WordRep_Kensaku" method="post">
        <dl class="list">
        <dd>
        <input type="radio" checked name="hyoujihani" value="1week">過去1週間  <input type="radio" name="hyoujihani" value="1month">過去1ヶ月  <input type="radio" name="hyoujihani" value="3months">過去3ヶ月  </dd>
        <dd class="button"><a href="javascript:document.wordsyousai.submit()">検索</a></dd>
      </dl>
        </form>
      </tbody>
    </table>
<% if(lockdata.isVoAndExp_Lock() == false){ %>
<table border="1" class="item" background="/G-pro_Service/free_area/Ver2_Images/P_Rank_Back.gif">
      <tbody>
        <tr>
          <td colspan="2" class="logo"><img src="/G-pro_Service/image/VoAndExp_Logo.gif" width="192" height="46" border="0"></td>
          <td class="comment">投票受付中のお題はこちら↓です。投票はログイン後、「Vote&amp;Expect!」から。</td>
        </tr>
        <tr>
		<td colspan="3" class="title">通常アンケート</td>
		</tr>
        <tr>
          <td class="title">&nbsp;お題</td>
          <td class="date">&nbsp;回答締切日</td>
          <td class="comment">&nbsp;選択肢</td>
        </tr>
        <% for(int i=0; i < voexpindex.size(); i++){ %>
        <tr>
          <td class="title"><%=HttpUtility.escapeHTML(voexpindex.get(i).getOdai()) %>&nbsp;</td>
          <td class="date"><%=HttpUtility.escapeHTML(voexpindex.get(i).getVote_Shimekiri()) %>&nbsp;</td>
          <td class="comment">・<%=HttpUtility.escapeHTML(voexpindex.get(i).getSentakushi_A()) %>,<br>・<%=HttpUtility.escapeHTML(voexpindex.get(i).getSentakushi_B()) %>,<br>
      <%if(!(voexpindex.get(i).getSentakushi_C() == null && voexpindex.get(i).getSentakushi_C().equals("") && voexpindex.get(i).getSentakushi_C().equals("null"))){ %>・<%=HttpUtility.escapeHTML(voexpindex.get(i).getSentakushi_C()) %>,<br><% } %><%if(!(voexpindex.get(i).getSentakushi_D() == null && voexpindex.get(i).getSentakushi_D().equals("") && voexpindex.get(i).getSentakushi_D().equals("null"))){ %>・<%=HttpUtility.escapeHTML(voexpindex.get(i).getSentakushi_D()) %><% } %></td>
        </tr>
        <% } %>
        <tr>
		<td colspan="3">項目追加型アンケート</td>
		</tr>
		 <tr>
              <td class="title">&nbsp;お題</td>
              <td class="date">&nbsp;回答締切日時</td>
              <td class="comment">&nbsp;登録されている選択肢(上位3つまで)</td>
            </tr>
            <%for(int i=0; i < freevoexpindex.size(); i++){ %>
		<tr>
              <td class="title"><%=HttpUtility.escapeHTML(freevoexpindex.get(i).getOdai()) %>&nbsp;</td>
              <td class="date"><%=HttpUtility.escapeHTML(freevoexpindex.get(i).getVote_Shimekiri()) %>&nbsp;</td>
              <td class="comment">
              <%int anscnt = 0;
              for(int j=0; j < freevoexpvote.size(); j++){
              if(freevoexpvote.get(j).getAnc_Code() != null && freevoexpvote.get(j).getAnc_Code().equals(freevoexpindex.get(i).getAnc_Code())){
              %>
              <%=HttpUtility.escapeHTML(freevoexpvote.get(j).getAnswer()) %><br>
              <% anscnt++;
              if(anscnt >= 3){
            	anscnt = 0;
              break;
              }
              }
              }
              } %>
              </td>
            </tr>
      </tbody>
    </table>
    <% } %>
    <% if(lockdata.isPropRep_Lock() == false){ %>
  <table border="1" class="item" background="/G-pro_Service/image/PropRep_Back.gif">
      <tbody>
        <tr>
          <td colspan="2" class="logo">&nbsp;<img src="/G-pro_Service/image/Proposal.gif" width="200" height="20" border="0"></td>
          <td colspan="2" class="comment">現在公開されている企画はこちら↓です。企画とそのアドバイスの投稿は<br>
          ログイン後、「企画提案レポートの閲覧」から。</td>
        </tr>
        <tr>
          <td class="title">&nbsp;ゲームタイトル</td>
          <td class="name">&nbsp;制作者</td>
          <td class="name">&nbsp;メインジャンル</td>
          <td class="title">キャッチコピー&nbsp;</td>
        </tr>
        <%for(int i=0; i < propindex.size(); i++){ %>
        <tr>
          <td class="title"><%=HttpUtility.escapeHTML(propindex.get(i).getGameTitle()) %>&nbsp;</td>
          <td class="name"><%=HttpUtility.escapeHTML(propindex.get(i).getPenName()) %>&nbsp;</td>
          <td class="name"><%=HttpUtility.escapeHTML(propindex.get(i).getMainGenre()) %>&nbsp;</td>
          <td class="title"><pre><%=propindex.get(i).getCatchCopy() %></pre></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    <% } %>
    <% if(lockdata.isGRiron_Lock() == false){ %>
  <table border="1" class="item" background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
      <tbody>
        <tr>
          <td class="logo"><img src="/G-pro_Service/image/GRiron_Logo.gif" width="185" height="61" border="0"></td>
          <td colspan="3" class="comment">現在公開中の論文はこちら↓です。ログインしてからアクセスするとコメント、支持・不支持の投票を<br>
          することができます。</td>
        </tr>
        <tr>
          <td class="title">論文タイトル</td>
          <td class="name">作成者&nbsp;</td>
          <td class="date">&nbsp;アップロード日時</td>
          <td>&nbsp;論文の表示<br>
          (閲覧専用)</td>
        </tr>
        <%for(int i=0; i < rironindex.size(); i++){ %>
        <tr>
          <td class="title"><%=HttpUtility.escapeHTML(rironindex.get(i).getRonbunTitle()) %></td>
          <td class="name"><%=HttpUtility.escapeHTML(rironindex.get(i).getPlayerName()) %></td>
          <td class="date"><%=HttpUtility.escapeHTML(rironindex.get(i).getUploadDate()) %>&nbsp;</td>
          <td><form name="griron_syousai<%=i %>" action="/G-pro_Service/Riron_EtsuranLoad" method="post">
          <input type="hidden" name="ronbuncode" value="<%=rironindex.get(i).getRonbunCode() %>">
          <dl class="list">
      <dd class="button"><a href="javascript:document.griron_syousai<%=i %>.submit()">表示・閲覧</a></dd>
      </dl></form></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    <% } %>
    </div>
    </div>
    <div class="description">
    <% if(lockdata.isGRiron_Lock() == false){ %>
 <table border="1" id="bigtable" background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
      <tbody>
        <tr>
          <td class="logo"><img src="/G-pro_Service/image/GRon_Logo.gif" width="179" height="64" border="0"></td>
          <td colspan="3" class="comment">書き込み・投票受付中の議題はこちら↓です。投稿はログイン後、「俺にも言わせろ!G-PRO論。」から。</td>
        </tr>
        <tr>
          <td class="title">&nbsp;議題</td>
          <td class="date">&nbsp;書き込み・投票締切日</td>
          <td class="comment">&nbsp;開設者からのメッセージ</td>
          <td>&nbsp;討論ページリンク<br>
      ボタン(閲覧専用)</td>
        </tr>
        <% for(int i=0; i < gronindex.size(); i++){ %>
        <tr>
          <td class="title"><pre><%=gronindex.get(i).getGidai() %></pre></td>
          <td class="date"><%=HttpUtility.escapeHTML(gronindex.get(i).getShimekiriNichiji()) %>&nbsp;</td>
          <td class="comment"><pre><%=gronindex.get(i).getFirst_Write() %></pre></td>
          <td>
          <form name="gron_syousai<%=i %>" action="/G-pro_Service/GRon_Etsuran_Load" method="post">
      <input type="hidden" name="taisyoucode" value="<%=gronindex.get(i).getKeijiban_Code() %>">
      <dl class="list">
      <dd class="button"><a href="javascript:document.gron_syousai<%=i %>.submit()">討論ページへ</a></dd>
      </dl>
      </form>
          </td>
        </tr>
        <% } %>
      </tbody>
    </table>
    <% } %>
</div>
<div class="description">
  <table border="1" id="bigtable" background="/G-pro_Service/image/Event_Back.gif">
      <tbody>
        <tr>
          <td colspan="2" class="logo"><img src="/G-pro_Service/image/Event_Logo.gif" width="247" height="44" border="0">&nbsp;</td>
          <td colspan="4" class="comment"><form action="/G-pro_Service/Event_RirekiMaker" method="post">
          <input type="hidden" name="time" value="rireki">
          現在下記のイベントが開催中または参加受付中です。ここにないイベントに<br>
          ついては結果などをこのボタンから閲覧できます。→<input type="submit" name="submit" value="イベントの結果をすべて表示する"><br>
          </form></td>
        </tr>
        <tr>
          <td class="logo"><b>ロゴ</b></td>
          <td class="name"><b>イベント名称</b></td>
          <td class="date"><b>開催日</b></td>
          <td class="suchi"><b>イベントの</b><b><br>
          </b><b>状況</b></td>
          <td class="name"><b>主催者</b></td>
          <td><b>詳細閲覧・</b><b><br>
          </b><b>参加登録&nbsp;</b></td>
        </tr>
        <% for(int i=0; i < eventindex.size(); i++){ %>
        <tr>
          <td class="logo"><img src="/G-pro_Service/LogoImage_Load/<%=eventindex.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile"></td>
          <td class="name"><%=HttpUtility.escapeHTML(eventindex.get(i).getEventName()) %></td>
          <td class="date"><%=HttpUtility.escapeHTML(eventindex.get(i).getKaisaiDate()) %>&nbsp;</td>
          <td class="suchi"><%=HttpUtility.escapeHTML(eventindex.get(i).getUketsuke_Jyoukyou()) %></td>
          <td class="name"><%=HttpUtility.escapeHTML(eventindex.get(i).getEvent_Master()) %></td>
          <td><form name="event_syousai<%=i %>" action="/G-pro_Service/Event_SyousaiMaker" method="post">
          <input type="hidden" name="eventcode" value="<%=eventindex.get(i).getEventCode() %>">
          <dl class="list">
      <dd class="button"><a href="javascript:document.event_syousai<%=i %>.submit()">詳細ページへ</a></dd>
      </dl></form></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    </div>
    <div class="description">
  <table border="1" id="bigtable" background="/G-pro_Service/image/Pennant_Race_Back.gif">
      <tbody>
        <tr>
          <td><b><img src="/G-pro_Service/image/Pennant_Image.gif" width="266" height="61" border="0"></b></td>
          <td colspan="4"><b>最新のリーグ情報はこちら↓です。なお、このコンテンツへの参加にはサイト登録が必要です。</b></td>
        </tr>
        <tr>
          <td class="logo"><b>ロゴ</b></td>
          <td class="name"><b>リーグ名称</b></td>
          <td class="suchi"><b>クラス</b></td>
          <td class="suchi"><b>ラウンド</b></td>
          <td><b>詳細リンク</b></td>
        </tr>
        <% for(int i=0; i < pennantindex.size(); i++){ %>
        <tr>
          <td class="logo"><img src="/G-pro_Service/LogoImage_Load/<%=pennantindex.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile"></td>
          <td class="name"><%=HttpUtility.escapeHTML(pennantindex.get(i).getLeagueName()) %></td>
          <td class="suchi"><%=pennantindex.get(i).getLeagueClass() %></td>
          <td class="suchi"><%=pennantindex.get(i).getRound() %></td>
          <td><form name="league_syousai<%=i %>" action="/G-pro_Service/PennantRace_SyousaiMaker" method="post">
          <input type="hidden" name="league_id" value="<%=pennantindex.get(i).getLeagueCode() %>">
          <input type="hidden" name="order" value="season">
          <dl class="list">
      <dd class="button"><a href="javascript:document.league_syousai<%=i %>.submit()">詳細ページへ</a></dd>
      </dl></form></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    </div>
<div class="description">
<br>
<br>
<img src="/G-pro_Service/image/Shop_Syoukai_Logo.gif" width="250" height="60" border="0" alt="ショップ紹介">
<div class="js-masonry">
<% for(int i=0; i < locates.size(); i++){ %>
    <table border="1" class="item">
  <tbody>
    <tr>
      <td>
      <form action="/G-pro_Service/LocateData_Maker" method="post">
      <input type="hidden" name="shopname" value="<%=locates.get(i) %>">
      <input type="image" name="submit" src="/G-pro_Service/LogoImage_Load/<%=locates.get(i) %>?syubetsu=shop_photo" width="480" height="270">
      </form></td>
    </tr>
    <tr>
      <td><b><font size="+1"><%=HttpUtility.escapeHTML(locates.get(i)) %></font></b></td>
    </tr>
  </tbody>
</table>
<% } %>
</div>
</div>


<div class="item">
            <a class="twitter-timeline"  href="https://twitter.com/gproject2010" data-widget-id="657751290798194688">@gproject2010さんのツイート</a>
            <script>!function(d,s,id){var js,fjs=d.getElementsByTagName(s)[0],p=/^http:/.test(d.location)?'http':'https';if(!d.getElementById(id)){js=d.createElement(s);js.id=id;js.src=p+"://platform.twitter.com/widgets.js";fjs.parentNode.insertBefore(js,fjs);}}(document,"script","twitter-wjs");</script>
</div>


</div>
<div id="arcade" class="page"></div>
<div class="tab-content">
<h3 class="tab"><a href="./G-PROject_ArcadeTop.jsp#arcade"><img class="tablogo" src="/G-pro_Service/free_area/Ver2_Images/Arcade_Tab.gif" width="295" height="136" border="0"></a></h3>

</div>
</div>
</body>
</html>