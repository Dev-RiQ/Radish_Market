<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<style>
      .loading-main {
        height: 100vh;
        margin: 0;
      }
      .loading-inner {
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
  <div class="loading-main">
    <div class="loading-inner">
      <h1>Loding......</h1>

      <div class="loader"></div>
    </div>
  </div>
