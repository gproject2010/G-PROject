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
});