$("#creatorImg").on('change', function(){
	readURL(this);
});

// 이미지 미리보기
function readURL(input){
	var reader = new FileReader();
	reader.onload = function(e){
		$("#preImage").attr('src', e.target.result);
	}
	reader.readAsDataURL(input.files[0]);
}