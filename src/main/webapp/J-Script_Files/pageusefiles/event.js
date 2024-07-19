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
});
