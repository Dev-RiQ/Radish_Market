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

if (marker) {
	marker.setMap(null);
}
var imageSrc = '/images/marker.png', 
	imageSize = new kakao.maps.Size(64, 69), 
	imageOption = { offset: new kakao.maps.Point(27, 69) }; 

var markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imageOption);
marker = new kakao.maps.Marker({
	position: markerPosition,
	image: markerImage
});

marker.setMap(map);

var mapTypeControl = new kakao.maps.MapTypeControl();

map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPLEFT);

var zoomControl = new kakao.maps.ZoomControl();
map.addControl(zoomControl, kakao.maps.ControlPosition.TOPRIGHT);

const item_status_value = document.querySelector('.item-status-value');
const add_zzim_btn = document.querySelector('.add-zzim-btn');
const remove_zzim_btn = document.querySelector('.remove-zzim-btn');
const send_letter_btn = document.querySelector('.send-letter-btn');

if(item_status_value.value === 3 || item_status_value.value === '3'){
	if(add_zzim_btn){
		add_zzim_btn.classList.add('block-btn');
	}	
	if(remove_zzim_btn){
		remove_zzim_btn.classList.add('block-btn');
	}	
	if(send_letter_btn){
		send_letter_btn.classList.add('block-btn');
	}	
}