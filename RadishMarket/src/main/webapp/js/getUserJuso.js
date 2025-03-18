let address = '';
let dong = '';

function getAddressFromCoords(lat, lon) {
	var geocoder = new kakao.maps.services.Geocoder();

	geocoder.coord2Address(lon, lat, function(result, status) {
		if (status === kakao.maps.services.Status.OK) {
			setAddressData(result[0].address.address_name);
		} else {
			document.getElementById("address").innerText = "주소를 찾을 수 없습니다.";
		}
	});
}



function setAddressData(jibunAddr) {
	const addressValues = jibunAddr.split(" ");

	for (let i = 0; i < addressValues.length - 1; i++) {
		if (i == 0)
			address = addressValues[i];
		if (sigunguCheck(addressValues[i])) {
			address += " " + addressValues[i];
		}
		if (eupmyendongCheck(addressValues[i])) {
			address += " " + addressValues[i]
			dong += " " + addressValues[i];
		}
	}
	dong = dong.trim();
	if (!document.querySelector('#address').value) {
		fetch(`/main.do?address=${address}&dong=${dong}`)
			.then(response => response.text())
			.catch(error => console.log(error))
	}
}

function sigunguCheck(value) {
	let devide = value.split("");
	switch (devide[devide.length - 1]) {
		case "시": return true;
		case "군": return true;
		case "구": return true;
	}
	return false
}

function eupmyendongCheck(value) {
	let devide = value.split("");
	switch (devide[devide.length - 1]) {
		case "읍": return true;
		case "면": return true;
		case "동": return true;
	}
	return false
}

function getLocation() {
	if (navigator.geolocation) {
		console.log(1)
		navigator.geolocation.getCurrentPosition(
			function(position) {
		console.log(2)
				let lat = position.coords.latitude;
		console.log(lat)
				let lon = position.coords.longitude;
		console.log(lon)

				getAddressFromCoords(lat, lon); // 📌 위경도를 주소로 변환
			},
			function(error) {
				alert("위치 정보를 가져올 수 없습니다. 오류 코드: " + error.code);
			}
		);
	} else {
		alert("이 브라우저에서는 Geolocation을 지원하지 않습니다.");
	}
}

setTimeout(() => {
	getLocation();
}, 10)