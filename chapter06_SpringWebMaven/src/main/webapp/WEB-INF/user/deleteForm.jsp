<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>탈퇴</title>
<link rel="stylesheet" href="../css/checkDiv.css">
</head>
<body>
	<h1>탈퇴</h1>
	<a href="/chapter06_SpringWebMaven/"><img src="../img/1.jpg"
		alt="jennie"></a>

	<p>
		아이디 입력: <input type="text" name="id" id="id"> 
		<input type="button" value="검색" id="searchIdBtn">
	<div class="checkDiv" id="checkidDiv"></div>
	</p>

	<div id="deleteDiv">
		<form id="deleteForm">
			<p>
				비밀번호 입력: <input type="text" name="pwd" id="pwd"> 
			<div class="checkDiv" id="checkPwdDiv"></div>
			</p>
			<input type="button" value="탈퇴" id="deleteBtn"> 
			<input type="reset" value="취소" id="cancelBtn">
		</form>
	</div>
	<div id="result"></div>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/delete.js">
		
	</script>
</body>
</html>