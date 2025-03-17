function execDaumPostcode() {
    new daum.Postcode({
        oncomplete: function(data) {
            let roadAddr = data.roadAddress;
            let jibunAddr = data.jibunAddress;
			if(!jibunAddr){
				jibunAddr = data.autoJibunAddress;
			}
			
            document.getElementById("user_address").value = roadAddr;
			setAddressData(jibunAddr)
			getGeoCode(roadAddr)
        }
    }).open();
}

function setAddressData(jibunAddr){
	const addressValues = jibunAddr.split(" ");
	let city = document.getElementById("user_city")
    let gu = document.getElementById("user_gu")
    let dong = document.getElementById("user_dong")
	city.value = "";
	gu.value = "";
	dong.value = "";
	
	for(let i = 0 ; i < addressValues.length - 1 ; i++){
		if(i == 0)
            city.value = addressValues[i];
		if(sigunguCheck(addressValues[i])){
            gu.value += " "+addressValues[i];
		}
		if(eupmyendongCheck(addressValues[i])){
            dong.value += " " + addressValues[i];
		}
	}
    gu.value = gu.value.trim();
    dong.value = dong.value.trim();
}

function sigunguCheck(value){
	let devide = value.split("");
	switch(devide[devide.length - 1]){
		case "시":return true;
		case "군":return true;
		case "구":return true;
	}
	return false
}

function eupmyendongCheck(value){
	let devide = value.split("");
	switch(devide[devide.length - 1]){
		case "읍":return true;
		case "면":return true;
		case "동":return true;
	}
	return false
}

function getGeoCode(roadAddr){
	const geoCoder = new kakao.maps.services.Geocoder();
	geoCoder.addressSearch(roadAddr, (result, status) => {
		if(status === kakao.maps.services.Status.OK){
            document.getElementById("user_dir_x").value = result[0].x;
            document.getElementById("user_dir_y").value = result[0].y;
		}
	})
}