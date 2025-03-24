/* 
	아이템 정보 판매자 기준 주소 지도 보여주기
*/

// 카카오맵
const user_y = document.querySelector('#user_dir_y').value;
const user_x = document.querySelector('#user_dir_x').value;

var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(user_y, user_x),
	level: 3
};

var map = new kakao.maps.Map(container, options);

var markerPosition = new kakao.maps.LatLng(user_y, user_x);

var marker = new kakao.maps.Marker({
	position: markerPosition
});

//
if (marker) {
	marker.setMap(null);
}
var imageSrc = '/images/marker.png', // 마커이미지의 주소입니다    
	imageSize = new kakao.maps.Size(64, 69), // 마커이미지의 크기입니다
	imageOption = { offset: new kakao.maps.Point(27, 69) }; // 마커이미지의 옵션입니다. 마커의 좌표와 일치시킬 이미지 안에서의 좌표를 설정합니다.

// 마커의 이미지정보를 가지고 있는 마커이미지를 생성합니다
var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
marker = new kakao.maps.Marker({
	position: markerPosition,
	image: markerImage // 마커이미지 설정 
});
//

marker.setMap(map);

var mapTypeControl = new kakao.maps.MapTypeControl();

map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPLEFT);

var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.TOPRIGHT);