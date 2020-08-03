// 파일 업로드시 미리보기 기능
$("#classesPhoto").on('change', function(){
	readURL(this);
});

function readURL(input){
	var reader = new FileReader();
	reader.onload = function(e){
		$("#preImage").attr('src', e.target.result);
	}
	reader.readAsDataURL(input.files[0]);
}