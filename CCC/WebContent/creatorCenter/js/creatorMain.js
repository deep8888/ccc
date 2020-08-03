window.onload = function(){
	
	//$("#class_creator").load("../creatorCenter/menu/myClass.jsp"); // 화면 진입시 myClass 화면 셋팅
	$("#class_creator").load("../cen/myClass.cen");
	$("#myClass").click(function(){
		$("#class_creator").load("../cen/myClass.cen");
	});
	
	$("#board").click(function(){
		$("#class_creator").load("../cen/CreateBoard.cen");
	});
	
	/*$("#commnet").click(function(){
		$("#class_creator").load("../creatorCenter/menu/comment.jsp");
	});*/
	$("#helpDesk").click(function(){
		$("#class_creator").load("../creatorCenter/menu/helpDesk.html");
	});
}