$("#replied_notPost").css("color", "#ff6a22");
$("#replied_notPost").css("border-bottom-color", "#ff6a22");

$("#replied_notPost").click(function(){
	$("#replied_notPost").css("color", "#ff6a22");
	$("#replied_notPost").css("border-bottom-color", "#ff6a22");
	$("#replied_Post").css("color", "");
	$("#replied_Post").css("border-bottom-color", "");
});

$("#replied_Post").click(function(){
	$("#replied_Post").css("color", "#ff6a22");
	$("#replied_Post").css("border-bottom-color", "#ff6a22");
	$("#replied_notPost").css("color", "");
	$("#replied_notPost").css("border-bottom-color", "");
})
