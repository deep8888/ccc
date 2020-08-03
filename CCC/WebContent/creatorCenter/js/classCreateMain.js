window.onload = function(){
	
	$("#nextBtn").attr("disabled","disabled"); // 다음버튼 비활성화
	
	// 초기 화면 세팅
	if(!$("#classesStepChk").val() || $("#classesStepChk").val() ==1 || $("#classesStepChk").val() ==0){
		$("#form_contents").load("../creatorCenter/menu/class_Info.jsp");
	}else if($("#classesStepChk").val() == 2){
		$("#form_contents").load("../creatorCenter/menu/class_Video.jsp");
	}else if($("#classesStepChk").val() == 3){
		//$("#form_contents").load("../creatorCenter/menu/class_creator.jsp");
		$("#form_contents").load("../creatorCenter/menu/class_Intro.jsp");
	}else if($("#classesStepChk").val() == 4){
		$("#form_contents").load("../creatorCenter/menu/class_openck.jsp");
	}
	
	// 메뉴탭 클릭시 JSP 화면 출력
	$("#defaltInfo").click(function(){
		$("#form_contents").load("../creatorCenter/menu/class_Info.jsp");
	});
	$("#classIntro").click(function(){
		$("#form_contents").load("../creatorCenter/menu/class_Video.jsp");
	});
	$("#creatorIntro").click(function(){
		//$("#form_contents").load("../creatorCenter/menu/class_creator.jsp");
		$("#form_contents").load("../creatorCenter/menu/class_Intro.jsp");
	});
	$("#openChk").click(function(){
		$("#form_contents").load("../creatorCenter/menu/class_openck.jsp");
	});
	// 다음 버튼 클릭시 다음단계 화면 호출
	$("#nextBtn").click(function(){
		if($("#classesStep").val() == 1){
			$("#form_contents").load("../creatorCenter/menu/class_Video.jsp");
			
		}else if($("#classesStep").val() == 2){
			$("#form_contents").load("../creatorCenter/menu/class_Intro.jsp");
			
		}else if($("#classesStep").val() == 3){
			$("#form_contents").load("../creatorCenter/menu/class_openck.jsp");
		}
	});
	// 이전 버튼 클릭이벤트 제어문
	$("#backBtn").click(function(){
		if($("#classesStep").val() == 2){
			$("#form_contents").load("../creatorCenter/menu/class_Info.jsp");
			
		}else if($("#classesStep").val() == 3){
			$("#form_contents").load("../creatorCenter/menu/class_Video.jsp");
			
		}else if($("#classesStep").val() == 4){
			$("#form_contents").load("../creatorCenter/menu/class_Intro.jsp");
		}
	});
	// 저장 버튼 클릭시 컨트롤러 세팅
	$("#saveBtn").click(function(){
		var step = $("#classesStep").val();
		
		if(step == 1){
			//기본정보
			if(textInputChk(step)){
				$('form').attr('action', 'classWritePro.cen');
				$('form').attr('enctype', 'multipart/form-data');
				$("#classform").submit();
				$("#nextBtn").removeAttr("disabled");
			}
		}else if(step == 2){
			// 클래스 등록
			if(textInputChk(step)){
				$("#classform").attr("action", "classAddURL.cen");
				$("#classform").removeAttr("enctype");
				$("#classform").submit();
				$("#nextBtn").removeAttr("disabled");
			}
			
		}else if(step == 3){
			if(textInputChk(step)){ 
				$('form').attr('action', 'classCreatorWrite.cen');
				$('form').attr('enctype', 'multipart/form-data');
				$("#classform").submit();
				$("#nextBtn").removeAttr("disabled");
			}
			
		}else if(step == 4){
			// 오픈전 확인사항 체크
			if(textInputChk(step)){ 
				$("#classform").attr("action", "openChekResult.cen");
				$("#classform").removeAttr("enctype");
				$("#classform").submit();
				$("#nextBtn").prop("disable", false);
			}
		}
	});
	
	// 저장 버튼 클릭시 입력여부 체크 함수
	function textInputChk(chk){
		if(chk == 1){
			if($("#classSubject").val().length < 1){
				$("#waring-1").css("display", "flex");
				$("#waring-2").css("display", "none");
				$("#waring-3").css("display", "none");
				$("#waring-4").css("display", "none");
				$("#waring-5").css("display", "none");
				return false;
			}else if($("#classCategory").val().length < 1){
				$("#waring-2").css("display", "flex");
				$("#waring-1").css("display", "none");
				$("#waring-3").css("display", "none");
				$("#waring-4").css("display", "none");
				$("#waring-5").css("display", "none");
				return false;
			}else if($("#classContent").val().length < 1){
				$("#waring-3").css("display", "flex");
				$("#waring-1").css("display", "none");
				$("#waring-2").css("display", "none");
				$("#waring-4").css("display", "none");
				$("#waring-5").css("display", "none");
				return false;
			}else if($("#classSubMent").val().length < 1){
				$("#waring-4").css("display", "flex");
				$("#waring-1").css("display", "none");
				$("#waring-2").css("display", "none");
				$("#waring-3").css("display", "none");
				$("#waring-5").css("display", "none");
				return false;
			}else if($("#classPrice").val().length < 1){
				$("#waring-4").css("display", "none");
				$("#waring-1").css("display", "none");
				$("#waring-2").css("display", "none");
				$("#waring-3").css("display", "none");
				$("#waring-5").css("display", "flex");
				return false;
			}
		}else if(chk == 2){
			
		}else if(chk == 3){
			
		}else if(chk == 4){
			if(!$("#agree1").prop("checked")){
				alert("확인사항 모두 체크 되어야 오픈 가능합니다.");
				return false;
			}else if(!$("#agree2").prop("checked")){
				alert("확인사항 모두 체크 되어야 오픈 가능합니다.");
				return false;
			}else if(!$("#agree3").prop("checked")){
				alert("확인사항 모두 체크 되어야 오픈 가능합니다.");
				return false;
			}else if(!$("#agree4").prop("checked")){
				alert("확인사항 모두 체크 되어야 오픈 가능합니다.");
				return false;
			}
		}
		return true;
	}
}