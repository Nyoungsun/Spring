<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>성적 입력</title>
</head>
<body>
	<form action="/chapter06_1/sungJuk/result.do" method="post">
		이름: <input type="text" name="name"><br> 
		국어: <input type="text" name="kor"><br>
		영어: <input type="text" name="eng"><br>
		수학: <input type="text" name="math"><br>
		
		<input type="submit" value="계산">
	</form>
</body>
</html>