<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="inputUtility.HttpUtility" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.lang.String" %>
<%@ page import="gpro_ron.GRon_Data_TO" %>
<%@ page import="gpro_ron.GRon_Data_DAO" %>
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
<jsp:useBean id="gronindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<gpro_ron.GRon_Data_TO>"/>
<jsp:useBean id="voexpindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<voteandExpect.VoAndExp_TO>"/>
<jsp:useBean id="infoindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<ninsyou.Infomation_TO>"/>
<jsp:useBean id="propindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<rep_upload.NewGames_TO>"/>
<jsp:useBean id="rironindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<gpro_riron.GPRiron_TO>"/>
<jsp:useBean id="eventindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<event.EventData_TO>"/>
<jsp:useBean id="pennantindex" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<pennant_race.PennantData_TO>"/>
<jsp:useBean id="enginelinks" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<ninsyou.Infomation_TO>"/>
<jsp:useBean id="bloglinks" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<ninsyou.Infomation_TO>"/>
<jsp:useBean id="locates" scope="application" class="java.util.ArrayList" type="java.util.ArrayList<java.lang.String>"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="/G-pro_Service/free_area/index.jsp"/>
<meta name="description" content="ゲーム業界に対しユーザーの皆様の意見や提案を「ダイレクトに」伝えるレビューサイトです。「メーカーにもっと面白いゲームを作ってほしい」熱いメッセージ、お待ちしております!"/>
<meta name="keywords" content="ゲーム レビュー, G-PROject, フリー、無料, 意見, 評価, 面白いゲーム"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Style-Type" content="text/css">
<link rel="stylesheet" type="text/css" href="/G-pro_Service/CSS_Files/Index_Program.css"/>
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
<body bgcolor="#FFFFFF" text="#004000" link="#0000ff" vlink="#009999" alink="#ff4a4a" background="/G-pro_Service/free_area/Ver2_Images/TopPage_Back.gif" style="font-weight : bold;">
<img alt="G-PROロゴ" src="/G-pro_Service/free_area/Ver2_Images/GPRO_Logo2.gif" width="450" height="180" border="0">
<table border="0">
<tr valign="top">
    <td colspan="2" align="center">
<ul id="jumpmenu">
<li><a href="/G-pro_Service/free_area/Tutoreal_mokuji.html">チュートリアル</a>
<ul class="sub">
<li><a href="/G-pro_Service/free_area/Tutoreal1.html" class="hpb-vmenu1-link1">G-PROject企画概要</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal2.html#koumoku2" class="hpb-vmenu1-link1">利用の流れ</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal2.html#koumoku3-1" class="hpb-vmenu1-link1">ゲームレポート概要</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal3.html#koumoku3-2" class="hpb-vmenu1-link1">ゲームレポートの作成・アップロード</a></li>
<li><a href="/G-pro_Service/free_area/Tutorial4.html#koumoku3-3" class="hpb-vmenu1-link1">ゲームレポートのルール</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal5.html#koumoku4" class="hpb-vmenu1-link1">俺にも言わせろ!G-PRO論。</a></li>
<li><a href="/G-pro_Service/free_area/GRiron_Tutoreal.html#koumoku5">熱く語れ!G-PRO_Re:論。</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal6.html#koumoku6" class="hpb-vmenu1-link1">Vote&amp;expect!</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal7.html#koumoku7">proposal(提案)レポート</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku8">各種スコア・ランキング</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku10">退会・復帰処理</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku11">利用にあたっての注意</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal8.html#koumoku12">禁止・制限事項</a></li>
<li><a href="/G-pro_Service/free_area/Tutoreal9.html#koumoku13">プライバシーポリシー</a></li>
</ul></li>
<li><a href="/G-pro_Service/free_area/Ranking_menu.html">ランキング(プレイヤー関係)</a>
      <ul class="sub">
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
      <li><a href="/G-pro_Service/free_area/Ranking_menu.html">ランキング(ゲーム関係)</a>
      <ul class="sub">
        <li><a href="/G-pro_Service/G_RankingMaker?hani=dai1_insyou">第一印象(発売1ヶ月のG-Score)</a></li>
        <li><a href="/G-pro_Service/G_RankingMaker?hani=ninkisaku">人気作(発売1年のレポート総数)</a></li>
        <li><a href="/G-pro_Service/G_RankingMaker?hani=nenkan">ビッグヒット(発売1年のG-Score)</a></li>
        <li><a href="/G-pro_Service/G_RankingMaker?hani=meisaku">名作(累計のG-Score)</a></li>
      </ul>
      </li>
      <li><a href="#NewInfo">What's NEW</a>
      <ul class="sub">
      <% for(Infomation_TO koumoku : infoindex){ %>
        <li><a href="/G-pro_Service/Infomation_SyousaiMaker?code=<%=koumoku.getInfoCode()%>&login_jyoukyou=no"><%=HttpUtility.escapeHTML(koumoku.getKenmei()) %>(<%=koumoku.getKeisaiDate() %>掲載)</a></li>
        <% } %>
      </ul>
      </li>
    </ul>

</td>
</tr>
<tr valign="top">
<td width="768" align="center">
<p align="center"><img src="/G-pro_Service/image/rapidssl_seal.gif">このサイトの通信はすべてSSLにより暗号化されています。</p>
<table border="1">
  <tbody>
    <tr>
      <td align="center">G-PROjectへようこそ！このサイトは、ゲームのレビューやクリエイターとの直接討論などを通して<br>
      ゲーム業界を盛り上げていくための<h1>「ゲームについて考えるサイト」</h1>です。このサイトに用意されている<br>
      コンテンツを通してあなたが持っている意見やアイディアを<b>ゲーム業界に</b>ダイレクトに提案し、<br>
      このサイトから<h2>面白いゲームをたくさん発信しましょう!</h2><br>
      </td>
    </tr>
  </tbody>
</table>
<br>
<br>
<br>
<br>
<table border="0">
  <tbody>
    <tr align="center">
          <td background="/G-pro_Service/image/Toiawase_Back.gif" class="toibutton"><a href="/G-pro_Service/free_area/Toiawase.html"><img src="/G-pro_Service/image/Toiawase_Icon.gif" width="64" height="56" border="0"></a><br>
      お問い合わせ</td>
          <td background="/G-pro_Service/image/Toiawase_Back.gif">&nbsp;お問い合わせは左のボタンからお願いいたします。<br>
          また、不具合、バグ等に関するお問い合わせの場合は<br>
          どんな操作をしようとして発生したのかといった状況も<br>
          忘れずに記述してください。</td>
        </tr>
  </tbody>
</table>
    <br>

<br>
<br>
<a name="GRon"></a>
<table border="1" background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
      <tbody>
        <tr>
          <td><img src="/G-pro_Service/image/GRon_Logo.gif" width="179" height="64" border="0"></td>
          <td colspan="3">設定された「議題」に沿って、皆さんと管理スタッフ、そして時には<br>
          ゲーム業界関係者が参加し、直接討論を行う「討論型掲示板」です。<br>
          <b>皆さんの意見や提案が</b><h2>ゲーム業界の未来を大きく動かします!</h2><br>
          <a href="/G-pro_Service/free_area/Tutoreal5.html" target="_blank">詳しい説明を見る</a>←チュートリアルの該当ページを表示します</td>
        </tr>
        <tr>
          <td colspan="4" align="center">&nbsp;書き込み・投票受付中の議題はこちら↓です。投稿は<b>ログイン後、「俺にも言わせろ!G-PRO論。」から。</b></td>
        </tr>
        <tr>
          <td align="center">&nbsp;議題</td>
          <td align="center">&nbsp;書き込み・投票締切日</td>
          <td align="center">&nbsp;開設者からのメッセージ</td>
          <td align="center">&nbsp;討論ページリンク<br>
      ボタン(閲覧専用)</td>
        </tr>
    <% for(GRon_Data_TO GRonList : gronindex){ %>
    <tr>
      <td><pre><%=GRonList.getGidai() %>&nbsp;</pre></td>
      <td><%=HttpUtility.escapeHTML(GRonList.getShimekiriNichiji()) %>&nbsp;</td>
      <td><pre><%=GRonList.getFirst_Write() %></pre></td>
      <td align="center">&nbsp;
      <form action="/G-pro_Service/GRon_Etsuran_Load" method="post">
      <input type="hidden" name="taisyoucode" value="<%=GRonList.getKeijiban_Code() %>">
      <input type="submit" name="submit" value="G-PRO論。討論ページへ">
      </form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<br>
<br>
<br>
<a name="VoandExp"></a>
 <table border="1" background="/G-pro_Service/free_area/Ver2_Images/P_Rank_Back.gif">
      <tbody>
        <tr>
          <td><img src="/G-pro_Service/image/VoAndExp_Logo.gif" width="192" height="46" border="0"></td>
          <td>設定された「お題」に対し、皆さんが２～４択で答えるアンケート形式のコンテンツです。<br>
          ただ回答するだけでなく結果も予想してボーナススコア獲得を狙え!<br>
          <a href="/G-pro_Service/free_area/Tutoreal6.html" target="_blank" >詳しい説明を見る</a>←チュートリアルの該当ページを表示します&nbsp;</td>
        </tr>
        <tr>
          <td colspan="3" align="center">&nbsp;投票受付中のお題はこちら↓です。<b>投票はログイン後、「Vote&amp;Expect!」から。</b></td>
        </tr>
        <tr>
          <td>&nbsp;お題</td>
          <td>投票締切日</td>
          <td>&nbsp;選択肢</td>
        </tr>
    <% for(VoAndExp_TO VoData : voexpindex){ %>
    <tr>
      <td><pre><%=VoData.getOdai() %></pre></td>
      <td><pre><%=VoData.getVote_Shimekiri() %></pre></td>
      <td>・<%=HttpUtility.escapeHTML(VoData.getSentakushi_A()) %>,<br>・<%=HttpUtility.escapeHTML(VoData.getSentakushi_B()) %>,<br>
      <%if(!(VoData.getSentakushi_C() == null && VoData.getSentakushi_C().equals("") && VoData.getSentakushi_C().equals("null"))){ %>・<%=HttpUtility.escapeHTML(VoData.getSentakushi_C()) %>,<br><% } %><%if(!(VoData.getSentakushi_D() == null && VoData.getSentakushi_D().equals("") && VoData.getSentakushi_D().equals("null"))){ %>・<%=HttpUtility.escapeHTML(VoData.getSentakushi_D()) %><% } %></td>
    </tr>
    <% } %>
  </tbody>
</table>
<br>
<br>
<br>
<a name="GReport"></a>
<form action="/G-pro_Service/WordRep_Kensaku" method="post">
<table border="1" background="/G-pro_Service/free_area/Ver2_Images/GRank-Rep_Back.gif">
      <tbody>
        <tr>
          <td><img src="/G-pro_Service/image/GReport_Logo.gif" width="185" height="39" border="0"></td>
          <td colspan="3"><h2>ゲームに対する評価や意見を様々な形式でレビューする「ゲームレポート」。</h2>
          ここではその中で利用登録・ログインなしでアップロードできる「一言レポート」が閲覧できます。<br>
          投稿はチュートリアルのどこかにある作成ボタンから。<br>
          <a href="/G-pro_Service/free_area/Tutoreal3.html" target="_blank">詳しい説明を見る</a>←チュートリアルの該当ページを表示します</td>
        </tr>
        <tr>
          <td colspan="4">&nbsp;一言レポート閲覧：アップロード日時の検索範囲を選択し、「表示」をクリックしてください。<br>
          なお<b>G-PROjectにログインすると、すべての形式のレポートが投稿・閲覧できるようになります。</b></td>
        </tr>
        <tr>
          <td align="center">&nbsp;<input type="radio" checked name="hyoujihani" value="1week">過去1週間</td>
          <td align="center">&nbsp;<input type="radio" name="hyoujihani" value="1month">過去1ヶ月</td>
          <td align="center">&nbsp;<input type="radio" name="hyoujihani" value="3months">過去3ヶ月</td>
          <td align="center"><input type="submit" name="submit" value="     表示     "></td>
        </tr>
      </tbody>
    </table>
    </form>
    <br>
    <br>
    <table border="1" background="/G-pro_Service/image/PropRep_Back.gif">
      <tbody>
        <tr>
          <td>&nbsp;<img src="/G-pro_Service/image/Proposal.gif" width="218" height="38" border="0"></td>
          <td colspan="3">皆さんが考えたゲームのアイディアをG-PROject上に公開し、他のユーザーやゲームメーカーの担当者から<br>
          アドバイスなどを受けられるコンテンツです。投稿された企画はゲームメーカーに採用される可能性も!<br>
          <a href="/G-pro_Service/free_area/Tutoreal7.html" target="_blank">詳しい説明を見る</a>←チュートリアルの該当ページへ移動します&nbsp;</td>
        </tr>
        <tr>
          <td colspan="4">&nbsp;現在公開されている企画はこちら↓です。企画とそのアドバイスの投稿はログイン後、<br>
          「発売前のゲーム、企画提案レポートの閲覧」から。</td>
        </tr>
        <tr>
          <td>&nbsp;ゲームタイトル</td>
          <td>&nbsp;制作者</td>
          <td>&nbsp;メインジャンル</td>
          <td>キャッチコピー&nbsp;</td>
        </tr>
        <%for(int i=0; i < propindex.size(); i++){ %>
        <tr>
          <td><%=HttpUtility.escapeHTML(propindex.get(i).getGameTitle()) %>&nbsp;</td>
          <td><%=HttpUtility.escapeHTML(propindex.get(i).getPenName()) %>&nbsp;</td>
          <td><%=HttpUtility.escapeHTML(propindex.get(i).getMainGenre()) %>&nbsp;</td>
          <td><pre><%=propindex.get(i).getCatchCopy() %></pre></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    <br> 
    <br>
    <a name="GRiron"></a>
    <table border="1" background="/G-pro_Service/free_area/Ver2_Images/Riron_Back.gif">
      <tbody>
        <tr>
          <td><img src="/G-pro_Service/image/GRiron_Logo.gif" width="185" height="61" border="0"></td>
          <td colspan="3">ゲーム業界に対するあなたの意見や提案はもちろん、ゲームを語るうえで必要な知識の解説など、<br>
          何でも自由に語ってもらおう！<br>
          というコンテンツです。ゲームに関することなら何でもOK！あなたの考えをどんどん広めましょう！<br>
          <a href="/G-pro_Service/free_area/GRiron_Tutoreal.html" target="_blank">詳しい説明を見る</a>←チュートリアルの該当ページへ移動します&nbsp;</td>
        </tr>
        <tr>
          <td colspan="4">現在公開中の論文はこちら↓です。ログインしてからアクセスするとコメント、支持・不支持の投票を<br>
          することができます。</td>
        </tr>
        <tr>
          <td>論文タイトル</td>
          <td>作成者&nbsp;</td>
          <td>&nbsp;アップロード日時</td>
          <td>&nbsp;論文の表示<br>
          (閲覧専用)</td>
        </tr>
        <%for(int i=0; i < rironindex.size(); i++){ %>
        <tr>
          <td><%=HttpUtility.escapeHTML(rironindex.get(i).getRonbunTitle()) %>&nbsp;</td>
          <td><%=HttpUtility.escapeHTML(rironindex.get(i).getPlayerName()) %>&nbsp;</td>
          <td><%=HttpUtility.escapeHTML(rironindex.get(i).getUploadDate()) %>&nbsp;</td>
          <td><form action="/G-pro_Service/Riron_EtsuranLoad" method="post">
          <input type="hidden" name="ronbuncode" value="<%=rironindex.get(i).getRonbunCode() %>">
          <input type="submit" name="submit" value="表示・閲覧"></form></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    <br>
    <a name="Event"></a>
    <table border="1" background="/G-pro_Service/image/Event_Back.gif">
      <tbody>
        <tr>
          <td colspan="2"><b><img src="/G-pro_Service/image/Event_Logo.gif" width="247" height="44" border="0"></b><b>&nbsp;</b></td>
          <td colspan="3"><b>ゲームメーカーやG-PROが主催する各種イベントの</b><b><br>
          </b><b>参加登録や結果の閲覧ができます。</b><b><br>
          </b></td>
        </tr>
        <tr>
          <td colspan="5">
          <form action="/G-pro_Service/Event_RirekiMaker" method="post">
          <input type="hidden" name="time" value="rireki">
          現在下記のイベントが開催中または参加受付中です。開催が終了したイベントについては、<br>
          結果などをこのボタンから閲覧できます。→<input type="submit" name="submit" value="イベントの結果をすべて表示する"></form></td>
        </tr>
        <tr>
          <td align="center"><b>ロゴ</b></td>
          <td><b>イベント名称</b></td>
           <td><b>開催日&nbsp;</b></td>
          <td><b>イベントの</b><b><br>
          </b><b>状況</b></td>
          <td><b>主催者</b></td>
          <td><b>詳細閲覧・</b><b><br>
          </b><b>参加登録&nbsp;</b></td>
        </tr>
        <% for(int i=0; i < eventindex.size(); i++){ %>
        <tr>
          <td><b><img src="/G-pro_Service/LogoImage_Load/<%=eventindex.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile">&nbsp;</b></td>
          <td><b><%=HttpUtility.escapeHTML(eventindex.get(i).getEventName()) %>&nbsp;</b></td>
          <td><b><%=HttpUtility.escapeHTML(eventindex.get(i).getKaisaiDate()) %>&nbsp;</b></td>
          <td><b><%=HttpUtility.escapeHTML(eventindex.get(i).getUketsuke_Jyoukyou()) %>&nbsp;</b></td>
          <td><b><%=HttpUtility.escapeHTML(eventindex.get(i).getEvent_Master()) %>&nbsp;</b></td>
          <td align="center" valign="middle">
          <form action="/G-pro_Service/Event_SyousaiMaker" method="post">
          <input type="hidden" name="eventcode" value="<%=eventindex.get(i).getEventCode() %>">
          <b><input type="submit" name="submit" value="詳細ページへ"></b></form></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    <br>
     <table border="1" background="/G-pro_Service/image/Pennant_Race_Back.gif">
      <tbody>
        <tr>
          <td><b><img src="/G-pro_Service/image/Pennant_Image.gif" width="266" height="61" border="0"></b></td>
          <td colspan="4"><b>イベントで獲得した☆（スター）の数を競うリーグ戦です。</b><b><br>
          </b><b>スターは対象のイベントで入手できるシリアルコードを</b><b><br>
          </b><b>登録することで獲得できます。</b></td>
        </tr>
        <tr>
          <td colspan="5"><b>最新のリーグ情報はこちら↓です。なお、このコンテンツへの参加にはサイト登録が必要です。</b></td>
        </tr>
        <tr>
          <td><b>ロゴ</b></td>
          <td><b>リーグ名称</b></td>
          <td><b>クラス</b></td>
          <td><b>ラウンド</b></td>
          <td><b>詳細リンク</b></td>
        </tr>
        <% for(int i=0; i < pennantindex.size(); i++){ %>
        <tr>
          <td><b><img src="/G-pro_Service/LogoImage_Load/<%=pennantindex.get(i).getLogofile_Name() %>?syubetsu=event_logo" id="sumneile">&nbsp;</b></td>
          <td><b><%=HttpUtility.escapeHTML(pennantindex.get(i).getLeagueName()) %></b></td>
          <td><b><%=pennantindex.get(i).getLeagueClass() %>&nbsp;</b></td>
          <td><b><%=pennantindex.get(i).getRound() %>&nbsp;</b></td>
          <td><form action="/G-pro_Service/PennantRace_SyousaiMaker" method="post">
          <input type="hidden" name="league_id" value="<%=pennantindex.get(i).getLeagueCode() %>">
          <input type="hidden" name="order" value="season">
          <b><input type="submit" name="submit" value="詳細ページへ"></b></form></td>
        </tr>
        <% } %>
      </tbody>
    </table>
    
    <img src="/G-pro_Service/image/Shop_Syoukai_Logo.gif" width="148" height="39" border="0" alt="ショップ紹介">
    <table border="1">
  <tbody>
    <tr>
    <% for(int i=0; i < locates.size(); i++){ %>
      <td>
      <form action="/G-pro_Service/LocateData_Maker" method="post">
      <input type="hidden" name="shopname" value="<%=locates.get(i) %>">
      <input type="image" name="submit" src="/G-pro_Service/LogoImage_Load/<%=locates.get(i) %>?syubetsu=shop_photo" width="180" height="120">
      </form></td>
      <% } %>
    </tr>
    <tr>
    <% for(int i=0; i < locates.size(); i++){ %>
      <td><b><font size="+1"><%=HttpUtility.escapeHTML(locates.get(i)) %></font></b></td>
      <% } %>
    </tr>
  </tbody>
</table>
    <br>
    <br>
    <div align="center">
    <b>利用登録するとG-PROjectへの正式な投稿、ランキングへの参加など、あらゆる機能が<br>
    使用できるようになります。この機会に下のボタンからぜひ利用登録を!</b><br>
    <!-- <p class="button"><a href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p0.html"><img src="/G-pro_Service/image/Riyoutouroku_Button.gif" width="193" height="34" border="0" alt="利用登録する"></a></p>-->
    <dl>
    <dd id="tourokubutton"><a href="/G-pro_Service/Shinki_Nyukai_Lv1/Kaiintouroku_p0.html">利用登録する</a></dl>
    <br>
<br>
    <img src="/G-pro_Service/image/Login_Logo.gif" width="122" height="55" border="0" alt="ログイン">
<br>
    
<form action="j_security_check" method="post">
<p>
<b>G-PRO ID・パスワードをお持ちの方はこちら↓からログインしてください</b><br>
<br>
<b>G-PRO ID:<input size="20" type="text" name="j_username" ></b><br>
<br>
<b>パスワード：<input size="20" type="password" name="j_password"></b><br>
<br>
<input id="tourokubutton" type="submit" name="submit" value="ログイン">
</p>
<br>
</form>
<p>
<font size="+1">G-PRO ID・パスワードを失念した（忘れた）方は<a href="/G-pro_Service/free_area/Nin_Syoukai_P1.html">こちら</a>から照会申請を行ってください。</font><br>
<br>
<br>
<br>
</p>
<img src="/G-pro_Service/image/WhatsNew.gif" width="260" height="55" border="0" alt="What's　NEW"><br>
</div>
<table border="0" align="center">
  <tbody>
    <tr>
      <td>お知らせ種別</td>
      <td>掲載日</td>
      <td>件名</td>
      <td>詳細</td>
    </tr>
    <% for(Infomation_TO InfoList : infoindex){ %>
    <tr>
      <td><%=HttpUtility.escapeHTML(InfoList.getInfo_Syubetsu()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(InfoList.getKeisaiDate()) %>&nbsp;</td>
      <td><%=HttpUtility.escapeHTML(InfoList.getKenmei()) %>&nbsp;</td>
      <td>
      <form action="/G-pro_Service/Infomation_SyousaiMaker" method="post">
      <input type="hidden" name="code" value="<%=InfoList.getInfoCode() %>">
      <input type="hidden" name="login_jyoukyou" value="no">
      <input type="submit" name="syousai" value="詳細閲覧">&nbsp;
      </form></td>
    </tr>
    <% } %>
  </tbody>
</table>
<br>
<p align="center"><img alt="区切り用バナー" width="512" height="10" border="0" src="/G-pro_Service/image/st10_l2.gif">
©2014　G-PROduce</p>
<td width="256"><img src="/G-pro_Service/image/Links_Logo.gif" width="98" height="50" border="0" alt="リンク集"><b>関連リンク集<br>
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
    <% } %>
    </td>
    </tr>
</table>
</body>
</html>