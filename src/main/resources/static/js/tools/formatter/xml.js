$(document).ready(function(){
	console.log("xml");

	function formatting() {
		var str = $("#xml_inputStr").val();
		var indent = $("select[name=xml_indent]").val();

		$.ajax({
			url : "/formatter/xml.json",
			type : "POST",
			cache : false,
			dataType : "json",
			data : { "indent": indent, "str": str },
			success : function(data){

				if (data.result == true) {
					$("#xml_outputStr").val(data.str);
				} else {
					alert("에러가 발생되었습니다.\n입력값을 확인해 주세요");
				}
			},
			error :function(request, status, error){
				var msg = "ERROR : " + request.status + "<br>"
				msg += + "내용 : " + request.responseText + "<br>"
				alert(msg);
			}
		});
	}

	/********************* Pretty XML Object String (BUTTON) *********************/
	$("#xmlBtn").click(function(){
		formatting();
	});

	/********************* Pretty XML Object String (ENTER KEY) *********************/
	$("#xml_inputStr").on("keypress",function(e) {
		var key = e.keyCode;

		// If the user has pressed enter
		if (key == 13) {
			if (e.shiftKey) {
				formatting();
			}
		}
	});

	/********************* XML textarea values init *********************/
	$("#xml_init_btn").click(function(){
		$("#xml_inputStr").val('');
		$("#xml_outputStr").val('');
	});

});