<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" >
<head>
  <meta charset="UTF-8">
  <title>CodePen - Flat Login Form 3.0</title>
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/meyer-reset/2.0/reset.min.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,500,700,900|RobotoDraft:400,100,300,500,700,900'>
<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript">
	window.onload = function(e) {
		var resultMsg = "${resultMsg}"
		if(resultMsg.length > 0) {
			alert(resultMsg);
		}
	}
</script>
</head>
<body>
<!-- partial:index.partial.html -->
<!-- Form Mixin-->
<!-- Input Mixin-->
<!-- Button Mixin-->
<!-- Pen Title-->
<div class="pen-title">
  <h1>Flat Login Form</h1><span>Pen <i class='fa fa-paint-brush'></i> + <i class='fa fa-code'></i> by <a href='http://andytran.me'>Andy Tran</a></span>
</div>
<!-- Form Module-->
<div class="module form-module">
  <div class="toggle"><i class="fa fa-times fa-pencil"></i>
    <div class="tooltip">Click Me</div>
  </div>
  <div class="form">
    <h2>Login to your account</h2>
    <form action="<c:url value='/login.do'/>" method="post">
      <input type="text" name="memberId" placeholder="ID" required/>
      <input type="password" name="passwd" placeholder="Password" required/>
      <button>Login</button>
    </form>
  </div>
  <div class="form">
    <h2>Create an account</h2>
    <form action="<c:url value='/join.do'/>" method="post">
	  <input type="text" name="memberId" id="memberId" placeholder="ID" required/>
	  <label id="idCheckMsg" style="display:block; margin-top: -18px; margin-bottom: 0;"></label>
	  <div style="height:20px"></div>
      <input type="password" name="passwd" placeholder="Password" required/>
      <input type="text" name="memberName" placeholder="Name" required/>
      <input type="text" name="nickname" placeholder="Nickname" required/>
      <input type="email" name="email" placeholder="Email Address" required/>
      <button type="submit">Register</button>
    </form>
  </div>
  <div class="cta"><a href="http://andytran.me">Forgot your password?</a></div>
</div>
<!-- partial -->
<!--  <script src='//cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script> -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script src='https://codepen.io/andytran/pen/vLmRVp.js'></script>
<script  src="${pageContext.request.contextPath}/resources/js/script.js"></script>
<!-- 아이디 자리수 및 중복 검사 -->
<script>
	$(document).ready(function(){
		// ID 중복 확인 - ID의 input 태그 벗어나면 작동
		$('#memberId').on("focusout", function() {
			// 6자리 이하이면 x
			var memberId = $("#memberId").val();
			if(memberId.trim() == '' || memberId.length <= 6) {
				$("#idCheckMsg").css("color", "red").text("ID는 7자리 이상이어야 합니다.");
				return false;
			}
			console.log(memberId);
			// Ajax로 전송
			$.ajax({
				url: './confirmId.do',
				type: 'POST',
				data: {
					'memberId': memberId
				},
				dataType:'json',
				success: function(result) { // 컨트롤러에서 넘어온 result를 받는다.
					console.log("result : " + result);
					if(result == "0") {
						$("#idCheckMsg").css("color", "green").text("사용 가능한 ID입니다.");
					} else {
						$("#idCheckMsg").css("color", "red").text("ID 중복입니다.");
						$("#memberId").val('');
					}
				},
				error:function(){
	                alert("에러입니다");
	            }
			}); // ajax end
		});
	})
</script>
</body>
</html>