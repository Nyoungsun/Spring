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
	<form id="uploadForm">
		<table border="1">
			<tr>
				<th>파일명</td>
				<td><input type="text" name="imgName"></td>
			</tr>
			<tr>
				<td colspan="2"><textarea name="imgContent" rows="15" cols="50"></textarea></td>
			</tr>
			
			<tr>
				<td colspan="2">
					<img id="upload_icon" src="../img/upload.png" width="25" height="25" alt="업로드">
					<!-- 선택한 파일 미리보기 -->
					<img id="show_file" width="50" height="50">
					<input id="upload_file" type="file" name="img[]" multiple>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="button" id="uploadBtn" value="등록"></td>
			</tr>
		</table>
	</form>
	
	<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
	<script src="../js/upload.js"></script>
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