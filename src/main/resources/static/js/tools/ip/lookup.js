$(document).ready(function(){
	console.log("ipLookup");

	function lookup() {
		let str = $("#iplookup_inputStr").val();

		$.ajax({
			url : "/ip/lookup.json",
			type : "POST",
			cache : false,
			dataType : "json",
			data : "str=" + str,
			success : function(data){

				if (data.result == true) {
					$("#iplookup_outputStr").val(data.str);
					let latitude = data.latitude;
					let longitude = data.longitude;

					/********************* KAKAO MAP API **********************/
					let container = document.getElementById('map');
					let options = {
						center: new kakao.maps.LatLng(latitude, longitude),
						level: 3
					};

					let map = new kakao.maps.Map(container, options);

					// 마커가 표시될 위치입니다
					let markerPosition  = new kakao.maps.LatLng(latitude, longitude);

					// 마커를 생성합니다
					let marker = new kakao.maps.Marker({
						position: markerPosition
					});

					// 마커가 지도 위에 표시되도록 설정합니다
					marker.setMap(map);

				} else {
					alert("에러가 발생되었습니다.\n입력값을 확인해 주세요");
				}
			},
			error :function(request, status, error){
				let msg = "ERROR : " + request.status + "<br>"
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
		let key = e.keyCode;

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