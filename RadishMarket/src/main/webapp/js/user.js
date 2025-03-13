/* 
	회원가입 주소 검색, 주소 정보, 좌표 가져오기 
*/
function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            let roadAddr = '';
            let jibunAddr = '';
			roadAddr = data.roadAddress;
            jibunAddr = data.jibunAddress;
			if(!jibunAddr){
				jibunAddr = data.autoJibunAddress;
			}
			const addressValues = jibunAddr.split(" ");
			
            document.getElementById("user_address").value = roadAddr;
            document.getElementById("user_city").value = addressValues[0];
            document.getElementById("user_gu").value = addressValues[1];
            document.getElementById("user_dong").value = addressValues[2];
			const geoCoder = new kakao.maps.services.Geocoder();
			geoCoder.addressSearch(roadAddr, (result, status) => {
				if(status === kakao.maps.services.Status.OK){
		            document.getElementById("user_dir_x").value = result[0].x;
		            document.getElementById("user_dir_y").value = result[0].y;
				}
			})
        }
    }).open();
}