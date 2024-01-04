<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보수정</title>
<link rel="stylesheet" href="../css/checkDiv.css">
</head>
<body>
	<h1>회원정보수정</h1>
	<a href="/chapter06_SpringWebMaven/"><img src="../img/1.jpg" alt="jennie"></a>

	<p>
		아이디 입력: <input type="text" name="searchId" id="searchId">
		<input type="button" value="검색" id="searchIdBtn">
		<div class="checkDiv" id="checkIdDiv"></div>
	</p>
	
	<div id="updateDiv">
	<form id="updateForm">
		<table>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" id="name">
				<div class="checkDiv" id="nameDiv"></div></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" readonly></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="pwd" id="pwd">
					<div class="checkDiv" id="pwdDiv"></div></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="button" value="수정" id="updateBtn"> 
				<input type="reset" value="취소" id="cancelBtn"></td>
			</tr>
		</table>
	</form>
	</div>
	<div id="result"></div>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/update.js">
	</script>
</body>
</html>