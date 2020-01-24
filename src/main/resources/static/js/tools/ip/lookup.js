$(document).ready(function(){
	console.log("ipLookup");

	function lookup() {
		var str = $("#iplookup_inputStr").val();

		$.ajax({
			url : "/ip/lookup.json",
			type : "POST",
			cache : false,
			dataType : "json",
			data : "str=" + str,
			success : function(data){

				if (data.result == true) {
					$("#iplookup_outputStr").val(data.str);
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

	/********************* IP Address Infomation String (BUTTON) *********************/
	$("#iplookupBtn").click(function(){
		lookup();
	});

	/********************* IP Address Infomation String (SHIFT + ENTER KEY) *********************/
	$("#iplookup_inputStr").on("keypress",function(e) {
		var key = e.keyCode;

		// If the user has pressed enter
		if (key == 13) {
			if (e.shiftKey) {
				lookup();
			}
		}
	});

	/********************* iplookup textarea values init *********************/
	$("#iplookup_init_btn").click(function(){
		$("#iplookup_inputStr").val('');
		$("#iplookup_outputStr").val('');
	});

});