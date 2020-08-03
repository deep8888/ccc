window.onload = function(){
	
	
	
	$("#myClass").click(function(){
		$("#class_creator").load("../creatorCenter/menu/myClass.jsp");
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
	function class_Info(){
		
	};
}