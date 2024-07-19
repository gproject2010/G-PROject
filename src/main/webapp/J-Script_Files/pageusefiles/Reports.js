$(function(){
$("#count_area1").keyup(function(){
var text1 = $(this).val();
text1 = text1.replace((new RegExp("\r\n","g")),"");
text1 = text1.replace((new RegExp("\n","g")),"");
var lencount1 = text1.length;
var lenlimit1 = $(this).attr("maxlength");
$("#mojisu1").text(lenlimit1 - lencount1);

if(lencount1 == 0){
$("#mojisu1").text(lenlimit1);
}else if(lencount1 > lenlimit1){
$("#mojisu1").css("color", "red");
}else{
$("#mojisu1").css("color", "");
}
});

$("#count_area2").keyup(function(){
var text2 = $(this).val();
text2 = text2.replace((new RegExp("\r\n","g")),"");
text2 = text2.replace((new RegExp("\n","g")),"");
var lencount2 = text2.length;
var lenlimit2 = $(this).attr("maxlength");
$("#mojisu2").text(lenlimit2 - lencount2);

if(lencount2 == 0){
$("#mojisu2").text(lenlimit2);
}else if(lencount2 > lenlimit2){
$("#mojisu2").css("color", "red");
}else{
$("#mojisu2").css("color", "");
}
});

$("#count_area3").keyup(function(){
var text3 = $(this).val();
text3 = text3.replace((new RegExp("\r\n","g")),"");
text3 = text3.replace((new RegExp("\n","g")),"");
var lencount3 = text3.length;
var lenlimit3 = $(this).attr("maxlength");
$("#mojisu3").text(lenlimit3 - lencount3);

if(lencount3 == 0){
$("#mojisu3").text(lenlimit3);
}else if(lencount3 > lenlimit3){
$("#mojisu3").css("color", "red");
}else{
$("#mojisu3").css("color", "");
}
});

$(".score").keyup(function(){
var Jiyuten_Total = 0;
var Total = 0;

Jiyuten_Total = Jiyuten_Total + parseFloat($("#jiyuten_score1").val());
Jiyuten_Total = Jiyuten_Total + parseFloat($("#jiyuten_score2").val());
Jiyuten_Total = Jiyuten_Total + parseFloat($("#jiyuten_score3").val());
Jiyuten_Total = Jiyuten_Total + parseFloat($("#jiyuten_score4").val());
Jiyuten_Total = Jiyuten_Total + parseFloat($("#jiyuten_score5").val());

if($.isNumeric(Jiyuten_Total) == true){
$("#jiyuten_totalscore_hyouji").text(Jiyuten_Total);
$("#jiyuten_totalscore_set").val(Jiyuten_Total);
$("#jiyuten_hyouji").text(Jiyuten_Total);
$("#jiyuten_set").val(Jiyuten_Total);
}else{
$("#jiyuten_totalscore_hyouji").text("---");
$("#jiyuten_totalscore_set").val("0");
$("#jiyuten_hyouji").val("---");
$("#jiyuten_set").val("0");
}

Total = Total + parseFloat($("#dificultty").val());
Total = Total + parseFloat($("#story").val());
Total = Total + parseFloat($("#graphic").val());
Total = Total + parseFloat($("#sound").val());
Total = Total + parseFloat($("#volume").val());
Total = Total + parseFloat($("#controll").val());
Total = Total + parseFloat($("#promotion").val());
Total = Total + Jiyuten_Total;
if($.isNumeric(Total) == true){
$("#totalscore_hyouji").text(Total);
$("#totalscore_set").val(Total);
}else{
$("#totalscore_hyouji").text("---");
$("#totalscore_set").val("0");
}
});

$(".jiyuten_maxscore").keyup(function(){
var Total = 0;
Total = Total + parseFloat($("#jiyuten_maxscore1").val());
Total = Total + parseFloat($("#jiyuten_maxscore2").val());
Total = Total + parseFloat($("#jiyuten_maxscore3").val());
Total = Total + parseFloat($("#jiyuten_maxscore4").val());
Total = Total + parseFloat($("#jiyuten_maxscore5").val());
if($.isNumeric(Total) == true){
$("#jiyuten_maxtotalscore_hyouji").text(Total);
$("#jiyuten_maxtotalscore_set").val(Total);
var MaxTotal = 30.00;
var Diff = Total - MaxTotal;
if(Diff == 0){
$("#jiyuten_maxtotal").text("OK!");
}else if(Diff > 0){
$("#jiyuten_maxtotal").css("color", "red");
$("#jiyuten_maxtotal").text("30点との誤差:" + Diff + "点");
}else{
$("#jiyuten_maxtotal").css("color", "blue");
$("#jiyuten_maxtotal").text("30点との誤差:" + Diff + "点");
}
}else{
$("#jiyuten_maxtotalscore_hyouji").text("---");
$("#jiyuten_maxtotalscore_set").val("0");
}
});
});
