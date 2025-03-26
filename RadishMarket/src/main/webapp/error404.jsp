<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="/radish_favicon.ico" type="image/x-icon">
<link rel="icon" href="/radish_favicon.ico" type="image/x-icon">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.1/css/all.min.css">
<title>무엇이든 우리동네 무우</title>
<style>
body {
	height: 100vh;
	margin: auto;
}

.error404 {
	width: 100%;
	height: 100%;
	display: flex;
	justify-content: center;
	align-items: center;
	text-align: center;
	flex-direction: column;
}

.content {
	width: 100%;
	display: flex;
	justify-content: center;
}

h1 {
	font-size: 90px;
	margin: 10px;
}

h1 i {
	font-size: 90px;
	color: #5fcc29;
}

h3 {
	font-size: 40px;
	margin: 10px;
}

p {
	font-size: 20px;
}

p i {
	font-size: 100px;
	color: orange;
}

span {
	color: #5fcc29;
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
	<div class="error404">
		<div class="content">
			<h1>
				<i class="fa-solid fa-tv"></i> 404 <span>E</span>RROR
			</h1>
		</div>

		<p class="msg">죄송합니다. 페이지를 찾을수 없습니다.</p>

		<p>
			<br>
			<i class="fa-solid fa-box-open"></i>
		</p>
		<button onclick="location.href='/index.jsp'">HOME</button>
	</div>
</body>
</html>