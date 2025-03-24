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

marker.setMap(map);

var mapTypeControl = new kakao.maps.MapTypeControl();

map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPLEFT);

var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.TOPRIGHT);