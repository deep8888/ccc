$("#videoAdd").click(function(){
	//divAdd();
	//divAdd_2();
});

function divAdd(){
	var div = document.createElement('div');
	div.innerHTML = document.getElementById('classInput').innerHTML;
	//document.getElementById('classOrderNum').
//	$('#classOrderNum').append('<option value="'+ i++ +'">' + i++ + '</option>');
	div.setAttribute('class', 'classInput');
	document.getElementById('classBox').appendChild(div);
}

function divAdd_2(){
	/*var div = document.createElement('div');
	div.innerHTML = document.getElementById('classInput').innerHTML;
	console.log(div);
	//div.innerHTML = $("#classInput").innerHTML;
//	div.children('select').removeAttr('text');
//	div.children('select').removeAttr('value');
	console.log("reremoveAttr 이전----");
	console.log(document.getElementById('classOrderNum'));
	document.getElementById('classOrderNum').remove('option');
	document.getElementById('classUrl').value = '';
	document.getElementById('classListSubject').value = '';
	var selListNum = document.getElementById('classOrderNum');
	for(var i=1; i<=20; i++){
		var op = document.createElement('option');
		op.value = i;
		op.text = i+"강";
		//document.getElementById('classOrderNum').append('<option value="'+ i +'">' + i||강 + '</option>');
		selListNum.add(op);
	}
	console.log("reremoveAttr 이후----");
	console.log(document.getElementById('classOrderNum'));
	div.setAttribute('class', 'classInput');
	document.getElementById('classBox').appendChild(div);*/
	
	var clone = $("#classInput").clone();
	console.log(clone);
	clone.find("input").val("");
	clone.find("select[name=classOrderNum]").val();
	clone.find("select[name=classOrderNum] option").remove();
	for(var i=1; i<=20; i++){
		console.log(i);
		clone.find("select[name=classOrderNum]").append("<option value='"+i+"'>"+i+"강</option>");
	}
	$("#classBox1").append(clone);
}