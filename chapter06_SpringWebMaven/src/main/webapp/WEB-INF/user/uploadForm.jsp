<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>업로드</title>
<link rel="stylesheet" href="../css/checkDiv.css">
<style>
#upload_file{
	visibility: hidden;
}

#upload_icon:hover {
	cursor: pointer;
}
</style>
</head>
<body>
	<!-- 단순 submit -->
	<form id="uploadForm" enctype="multipart/form-data" method="post"
		action="/chapter06_SpringWebMaven/user/upload">
		<table border="1">
			<tr>
				<th>파일명</td>
				<td><input type="text" name="imgName"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="imgContent" rows="15" cols="50"></textarea></td>
			</tr>
			
			<!-- 다중 파일 업로드 시 name 속성을 같은 이름으로 지정 -->
<!-- 			<tr> -->
<!-- 				<td colspan="2"><input type="file" name="img"></td> -->
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td colspan="2"><input type="file" name="img"></td> -->
<!-- 			</tr> -->

			<tr>
				<td colspan="2">
					<img id="upload_icon" src="../img/upload.png" width="25" height="25" alt="업로드">
					<!-- 선택한 파일 미리보기 -->
					<img id="show_file" width="50" height="50">
					<input id="upload_file" type="file" name="img[]" multiple>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" id="uploadBtn" value="등록"></td>
			</tr>
		</table>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script>
		$('#upload_icon').click(function () {
			$('#upload_file').trigger('click');
		});
		
		<!-- 선택한 파일 미리보기 -->
		$('#upload_file').change(function() {
			readURL(this);
		});
		
		function readURL(input) {
			var fileReader = new FileReader();
			
			fileReader.onload = function(e) {
				$('#show_file').attr('src', e.target.result); //File 또는 Blob 객체를 읽어서 result 속성에 저장한다.
			}
			
			fileReader.readAsDataURL(input.files[0]);
		}
	</script>
</body>
</html>

<!-- 
FileReader 란?
FileReader는 type이 file인 input 태그 또는 API 요청과 같은 인터페이스를 통해 
File 또는 Blob 객체를 편리하게 처리할수있는 방법을 제공하는 객체이며
abort, load, error와 같은 이벤트에서 발생한 프로세스를 처리하는데 주로 사용되며,
File 또는 Blob 객체를 읽어서 result 속성에 저장한다.

FileReader도 비동기로 동작한다.

FileReader.onload()
load 이벤트의 핸들러. 이 이벤트는 읽기 동작이 성공적으로 완료되었을 때마다 발생한다.
 -->