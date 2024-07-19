$(function(){
var submenu1 = false;
var submenu2 = false;
var submenu3 = false;
var submenu4 = false;

$('#mainmenubutton').on('click', function(){
$('#title').css('opacity', '0.3');
$('#jumpmenu').slideToggle(400);
$('#mainmenubutton').css('display', 'none');
});

$('#submenubutton1').on('click', function(){
	$('#pankuzulist').css('top', '400px');
if(submenu1 == false){
submenu1 = true;
$('#tab-unit').css('top', setTop);
$('#title').css('opacity', '0.3');
$('.submenu1').slideDown(400);
}else{
submenu1 = false;
$('#tab-unit').css('top', setTop);
$('.submenu1').slideUp(400);
}
});
$('#submenubutton2').on('click', function(){
if(submenu2 == false){
submenu2 = true;
$('#tab-unit').css('top', setTop);
$('#title').css('opacity', '0.3');
$('.submenu2').slideDown(400);
}else{
submenu2 = false;
$('#tab-unit').css('top', setTop);
$('.submenu2').slideUp(400);
}
});
$('#submenubutton3').on('click', function(){
if(submenu3 == false){
submenu3 = true;
$('#tab-unit').css('top', setTop);
$('#title').css('opacity', '0.3');
$('.submenu3').slideDown(400);
}else{
submenu3 = false;
$('#tab-unit').css('top', setTop);
$('.submenu3').slideUp(400);
}
});
$('#submenubutton4').on('click', function(){
if(submenu4 == false){
submenu4 = true;
$('#tab-unit').css('top', setTop);
$('#title').css('opacity', '0.3');
$('.submenu4').slideDown(400);
}else{
submenu4 = false;
$('#tab-unit').css('top', setTop);
$('.submenu4').slideUp(400);
}
});

$('#login_button').on('click', function(){
$('#loginform').slideToggle(400);
});
function setTop(){
var Top = 100;
if(submenu1 == true){
Top = Top + (($('.submenu1 > li').length) * 10);
}
if(submenu2 == true){
Top = Top + (($('.submenu2 > li').length) * 10);
}
if(submenu3 == true){
Top = Top + (($('.submenu3 > li').length) * 10);
}
if(submenu4 == true){
Top = Top + (($('.submenu4 > li').length) * 10);
}
if(submenu1 == false && submenu2 == false && submenu3 == false && submenu4 == false){
	Top = 400;
}
return Top;
}
});
