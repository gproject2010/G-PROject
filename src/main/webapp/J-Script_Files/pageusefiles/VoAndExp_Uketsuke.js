$(document).ready(function(){
$("#newsubmit").click(function(){
var vote = $("#newsel #newvote");
var expect = "empty";
if($("#newsel #expectsel").is(":checked") == true){
	expect = vote;
	}else{
		expect = "empty";
	}
$("#newsel #expect").val(expect);
$("#newsel").submit();
});
});