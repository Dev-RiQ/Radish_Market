<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/radish_favicon.ico" type="image/x-icon">
<link rel="icon" href="/radish_favicon.ico" type="image/x-icon">
<title>무엇이든 우리동네 무우</title>
<style>
body {
	height: 100vh;
	margin: auto;
}

.error505 {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

.errorbox {
	width: 100%;
	height: 200px;
	display: flex;
	justify-content: center;
	align-items: center;
}

.monitorbox {
	width: 300px;
	height: 300px;
	display: flex;
	justify-content: center;
	align-items: center;
	flex-direction: column;
}

.monitor {
	width: 260px;
	height: 150px;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 10px;
	border: 3px solid #5fcc29;;
}

.monitor h1 {
	font-size: 40px;
	color: red;
}

.lineheight {
	width: 5px;
	height: 30px;
	background-color: #5fcc29;
}

.linewidte {
	width: 70px;
	height: 10px;
	background-color: #5fcc29;
	border-radius: 10px;
}

.sorry {
	width: 500px;
	height: 200px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

button {
	width: 170px;
	border-radius: 10px;
	border: none;
	background: #5fcc29;
	margin-top: 20px;
	font-size: 20px;
	padding:20px;
}

button:hover {
	opacity: 0.7;
}

button:hover {
	opacity: 0.5;
}
.msg {
	font-size: 28px;
}
</style>
</head>
<body>
	<div class="error505">
		<div class="errorbox">
			<div class="monitorbox">
				<div class="monitor">
					<h1>500 ERROR</h1>
				</div>
				<div class="lineheight"></div>
				<div class="linewidte"></div>
			</div>
			<div class="sorry">
				<p class="msg">
					죄송합니다. 고객님<br> 서버 문제로 이용 하실수 없습니다.
				</p>
				<button onclick="location.href='/index.jsp'">HOME</button>
			</div>
		</div>
	</div>
</body>
</html>