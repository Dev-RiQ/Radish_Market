function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            let roadAddr = data.roadAddress;
            let jibunAddr = data.jibunAddress;
			if(!jibunAddr){
				jibunAddr = data.autoJibunAddress;
			}
			
            document.getElementById("calendar_address").value = roadAddr;
			getGeoCode(roadAddr)
        }
    }).open();
}

function getGeoCode(roadAddr){
	const geoCoder = new kakao.maps.services.Geocoder();
	geoCoder.addressSearch(roadAddr, (result, status) => {
		if(status === kakao.maps.services.Status.OK){
            document.getElementById("calendar_dir_x").value = result[0].x;
            document.getElementById("calendar_dir_y").value = result[0].y;
		}
	})
}