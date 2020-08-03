// 삭제하기 버튼 컨트롤
/*$("body").on("click","[id^=class_tag_Div_DelImg]",function(event){
	console.log(this.id);
	$("div[id^=class_tag_Div_DeleteBox_1]").toggle("active").css("display","inline");
})*/
$("div[id^=class_tag_Div_DelImg]").click(function(){
	var id = this.id;
	console.log($("#"+id+"").children('div'));
	console.log($("div[id^=class_tag_Div_DeleteBox_1]"));
//	$("div[id^=class_tag_Div_DeleteBox_1]").toggle("active");
	//$("#"+id+"").toggle("active");
	if($("#"+id+"").children('div').css("display") == "none"){
		$("#"+id+"").children('div').show();
	}else{
		$("#"+id+"").children('div').hide();
	}
	//$("#"+id+"").css("display","inline");
	//$("div[id^=class_tag_Div_DeleteBox_1]").css("display","inline");
});

/*$("#btn_pakegeAdd").click(function(){
	location.href="../pd/productList.pd";
});*/

function pakegeAdd(num){
	$("#class_creator").load(num);
/*location.href=num;*/
};
function writePro(num){
	location.href=num;
	};
function delclick(num){
	location.href=num;

};