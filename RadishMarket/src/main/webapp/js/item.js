/* 
	아이템 정보 판매자 기준 주소 지도 보여주기
*/

const user_y = document.querySelector('#user_dir_y').value;
const user_x = document.querySelector('#user_dir_x').value;

var container = document.getElementById('map');
var options = {
	center: new kakao.maps.LatLng(user_y, user_x),
	level: 3
};

var map = new kakao.maps.Map(container, options);

var markerPosition  = new kakao.maps.LatLng(user_y, user_x); 

var marker = new kakao.maps.Marker({
    position: markerPosition
});

marker.setMap(map);

// 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
var mapTypeControl = new kakao.maps.MapTypeControl();

// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);