$(document).ready(function(){
	console.log("encoder");
	function encoder(){
		var params = [];
		var str = $("#base64_encode_inputStr").val();

		$.ajax({
			url : "/encoder/base64.json",
			type : "POST",
			cache : false,
			dataType : "json",
			data : "str=" + str,
			success : function(data){

				if (data.result == true) {
					$("#base64_encode_outputStr").val(data.str);
				} else {
					alert("통신 실패!");
				}
			},
			error :function(request, status, error){
				var msg = "ERROR : " + request.status + "<br>"
				msg += + "내용 : " + request.responseText + "<br>"
				alert(msg);
			}
		});
	}

	function decoder() {
		var params = [];
		var str = $("#base64_decode_inputStr").val();

		$.ajax({
			url : "/decoder/base64.json",
			type : "POST",
			cache : false,
			dataType : "json",
			data : "str=" + str,
			success : function(data){

				if (data.result == true) {
					$("#base64_decode_outputStr").val(data.str);
				} else {
					alert("통신 실패!");
				}
			},
			error :function(request, status, error){
				var msg = "ERROR : " + request.status + "<br>"
				msg += + "내용 : " + request.responseText + "<br>"
				alert(msg);
			}
		});
	}
	/********************* String to Base64 *********************/
	$("#base64_encodeBtn").click(function(){
		encoder();
	});

	$("#base64_encode_inputStr").on("keypress",function(e) {
		var key = e.keyCode;

		// If the user has pressed enter
		if (key == 13) {
			if (e.shiftKey) {
				encoder();
			}
		}
	});

	// encode_base64_input values init.
	$("#base64_encode_input_init_btn").click(function(){
		$(base64_encode_inputStr).val('');
		$(base64_encode_outputStr).val('');
	});

	/********************* Base64 to String *********************/
	$("#base64_decodeBtn").click(function(){
		decoder();
	});

	$("#base64_decode_inputStr").on("keypress",function(e) {
		var key = e.keyCode;

		// If the user has pressed enter
		if (key == 13) {
			if (e.shiftKey) {
				decoder();
			}
		}
	});

	// decode_base64_input values init.
	$("#base64_decode_input_init_btn").click(function(){
		$(base64_decode_inputStr).val('');
		$(base64_decode_outputStr).val('');
	});
});