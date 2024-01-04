<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="../css/checkDiv.css">
</head>
<body>
	<h1>회원가입</h1>
	<a href="/chapter06_SpringWebMaven/"><img src="../img/1.jpg" alt="jennie"></a>
	<form id="writeForm">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name">
					<div class="checkDiv" id="nameDiv"></div></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id">
					<div class="checkDiv" id="idDiv"></div></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pwd" id="pwd">
					<div class="checkDiv" id="pwdDiv"></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="등록" id="writeBtn"> 
				<input type="reset" value="취소"></td>
			</tr>
		</table>
	</form>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/write.js"> </script>
</body>
</html>