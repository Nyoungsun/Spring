<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<style>
#paging {
	text-decoration: none;
	color: #1B2021;
	border: 1px solid;
	margin: 5px;
	padding: 10px;
	cursor: pointer;
}

#currentPaging {
	text-decoration: none;
	background-color: #1B2021;
	border: 1px solid;
	margin: 5px;
	padding: 10px;
	cursor: pointer;
	border: 1px solid;	
}

#userPagingDiv {
	width: 800px;
	text-align: center; 
	margin-top: 10px;
	padding: 10px;
}

table {
	width: 800px;
}
</style>
</head>
<body>
<a href="/chapter06_SpringWebMaven/"><img src="../img/1.jpg" alt="jennie"></a>
<p><input type="hidden" id="pg" value="${pg }"></p>
	<table id="userListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
		</tr>
		<tr>
		<!-- 동적 처리 -->
		</tr>
	</table>
	
	<div id="userPagingDiv"></div>
	<script>
	function userPaging(pg) {
		location.href = "/chapter06_SpringWebMaven/user/list?pg=" + pg;
	}
	</script>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/list.js"></script>
</body>
</html>