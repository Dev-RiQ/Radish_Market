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
        margin: 0;
      }
      main {
        width: 100vw;
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-direction: column;
      }
      .loader {
        width: 60px;
        height: 60px;
        border: 16px solid #ddd;
        border-radius: 50%;
        border-top: 16px solid #5fcc29;

        -webkit-animation: spin 2s linear infinite;
        animation: spin 2s linear infinite;
      }

      @-webkit-keyframes spin {
        0% {
          -webkit-transform: rotate(0deg);
        }
        100% {
          -webkit-transform: rotate(360deg);
        }
      }

      @keyframes spin {
        0% {
          transform: rotate(0deg);
        }
        100% {
          transform: rotate(360deg);
        }
      }
    </style>
  </head>
  <body>
    <main>
      <h1>Loding......</h1>

      <div class="loader"></div>
    </main>
  </body>
</html>