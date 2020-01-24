$(document).ready(function(){
	console.log("jsonFormatter");

	function formatting() {
		var params = [];
		var str = $("#jsonformatter_inputStr").val();

		$.ajax({
			url : "/formatter/jsonformatter.json",
			type : "POST",
			cache : false,
			dataType : "json",
			data : "str=" + str,
			success : function(data){

				if (data.result == true) {
					$("#jsonformatter_outputStr").val(data.str);
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

	/********************* Pretty Json Object String (BUTTON) *********************/
	$("#jsonformatterBtn").click(function(){
		formatting();
	});

	/********************* Pretty Json Object String (ENTER KEY) *********************/
	$("#jsonformatter_inputStr").on("keypress",function(e) {
		var key = e.keyCode;

		// If the user has pressed enter
		if (key == 13) {
			if (e.shiftKey) {
				formatting();
			}
		}
	});

	/********************* jsonformatter textarea values init *********************/
	$("#jsonformatter_init_btn").click(function(){
		$("#jsonformatter_inputStr").val('');
		$("#jsonformatter_outputStr").val('');
	});

});