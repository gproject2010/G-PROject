/**
 *
 */
function set2fig(num) {
   // 数値が1桁だったら2桁の文字列にして返す
   var ret;
   if( num < 10 ) { ret = "0" + num; }
   else { ret = num; }
   return ret;
}
function isNumOrZero(num) {
   // 数値でなかったら0にして返す
   if( isNaN(num) ) { return 0; }
   return num;
}
function showCountdown(target) {
   // 現在日時を数値(1970-01-01 00:00:00からのミリ秒)に変換
   var nowDate = new Date();
   var dnumNow = nowDate.getTime();
 
   // 指定日時を数値(1970-01-01 00:00:00からのミリ秒)に変換
	var targetDate_S = target.replace(/-/g, '/');
   var targetDate = Date.parse(targetDate_S + " 23:59:59");
   var dnumTarget = targetDate.getTime();
 
   // 引き算して日数(ミリ秒)の差を計算
   var diff2Dates = dnumTarget - dnumNow;
   if( dnumTarget < dnumNow ) {
      // 期限が過ぎた場合は -1 を掛けて正の値に変換
      diff2Dates *= -1;
   }
 
   // 差のミリ秒を、日数・時間・分・秒に分割
   var dDays  = diff2Dates / ( 1000 * 60 * 60 * 24 );   // 日数
   diff2Dates = diff2Dates % ( 1000 * 60 * 60 * 24 );
   var dHour  = diff2Dates / ( 1000 * 60 * 60 );   // 時間
   diff2Dates = diff2Dates % ( 1000 * 60 * 60 );
   var dMin   = diff2Dates / ( 1000 * 60 );   // 分
   diff2Dates = diff2Dates % ( 1000 * 60 );
   var dSec   = diff2Dates / 1000;   // 秒
   var msg2 = Math.floor(dDays) + "日"
            + Math.floor(dHour) + "時間"
            + Math.floor(dMin) + "分"
            + Math.floor(dSec) + "秒";
 
   // 表示文字列の作成
   var msg;
   if( dnumTarget > dnumNow ) {
      // まだ期限が来ていない場合
      msg ="(あと" + msg2 + ")";
   }
   else {
      // 期限が過ぎた場合
      msg = "(投稿を締め切りました)";
   }
 
   // 作成した文字列を返す
   return msg;
}

function setCountdownEvent(){
var countdownList = document.getElementsByClassName("countdown");
for(var i = 0,l = countdownList.length; l > i; i++){
	var Koumoku = countdownList[i].textContent;
	var Result = showCountdown(Koumoku);
	Koumoku.innerHTML = Result;
}
}
// 1秒ごとに実行
setInterval('setCountdownEvent()',1000);