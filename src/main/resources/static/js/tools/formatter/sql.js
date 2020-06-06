$(document).ready(function(){
	console.log("sql");

	function formatting() {
		var str = $("#sql_inputStr").val();
		var indent = $("select[name=sql_indent]").val();

		$.ajax({
			url : "/formatter/sql.json",
			type : "POST",
			cache : false,
			dataType : "json",
			data : { "indent": indent, "str": str },
			success : function(data){

				if (data.result == true) {
					$("#sql_outputStr").val(data.str);
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

	/********************* Pretty sql Object String (BUTTON) *********************/
	$("#sqlBtn").click(function(){
		formatting();
	});

	/********************* Pretty sql Object String (ENTER KEY) *********************/
	$("#sql_inputStr").on("keypress",function(e) {
		var key = e.keyCode;

		// If the user has pressed enter
		if (key == 13) {
			if (e.shiftKey) {
				formatting();
			}
		}
	});

	/********************* sql textarea values init *********************/
	$("#sql_init_btn").click(function(){
		$("#sql_inputStr").val('');
		$("#sql_outputStr").val('');
	});

});