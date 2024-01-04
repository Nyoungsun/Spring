<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이미지 목록</title>
<style>
table {
	width: 800px;
}
</style>
</head>
<body>
	<a href="/chapter06_SpringWebMaven/"><img src="../img/1.jpg" alt="jennie"></a>
	<table id="imgListTable" border="1" cellspacing="0" cellpadding="5" frame="hsides" rules="rows">
		<tr>
			<th>번호</th>	
			<th>제목</th>
			<th>이미지</th>
			<th>내용</th>
		</tr>
		<tr>
			<!-- 동적 처리 -->
		</tr>
	</table>
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/imgList.js"></script>
</body>
</html>