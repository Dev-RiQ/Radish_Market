function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            let addr = '';
            let addrR = '';
            addr = data.jibunAddress;
			addrR = data.roadAddress;
			const addrs = addr.split(" ");
            document.getElementById("user_address").value = addrR;
            document.getElementById("user_city").value = addrs[0];
            document.getElementById("user_gu").value = addrs[1];
            document.getElementById("user_dong").value = addrs[2];
			const geoCoder = new kakao.maps.services.Geocoder();
			geoCoder.addressSearch(addrR, (result, status) => {
				if(status === kakao.maps.services.Status.OK){
		            document.getElementById("user_dir_x").value = result[0].x;
		            document.getElementById("user_dir_y").value = result[0].y;
					console.log(result[0].x)
					console.log(result[0].y)
				}
			})
        }
    }).open();
}