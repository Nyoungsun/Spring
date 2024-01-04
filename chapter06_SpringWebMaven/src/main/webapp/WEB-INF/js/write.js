$('#writeBtn').click(function() {
			$('#nameDiv').empty();
			$('#idDiv').empty();
			$('#pwdDiv').empty();

			if ($('#name').val() == '') {
				$('#nameDiv').text('이름을 입력하세요');
				$('#name').focus();
			} else if ($('#id').val() == '') {
				$('#idDiv').text('아이디를 입력하세요');
				$('#id').focus();
			} else if ($('#pwd').val() == '') {
				$('#pwdDiv').text('비밀번호를 입력하세요');
				$('#pwd').focus();
			} else {
				$.ajax({
					type: 'post',
					url: '/chapter06_SpringWebMaven/user/write',
					data: $('#writeForm').serialize(),
					success: function(){
						alert('성공');
						location.href='/chapter06_SpringWebMaven/user/list';
					}, 
					error: function(err) {
						alert('실패');
					}
				});
			}
		});
		
$('#id').focusout(function(){
	$('#idDiv').empty();
	
	if($('#id').val() == '') {
		$('#idDiv').text('먼저 아이디를 입력하세요.');
		$('#id').focus();
		} else {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/isExist',
				data: 'id=' + $('#id').val(),
				datatype: 'text',
				success: function(data) {
					if(data == 'exist') {
					    $('#idDiv').css('color', 'red');
						$('#idDiv').text('아이디 사용 불가');	
					} else if(data == 'nonExist') {
					   $('#idDiv').css('color', 'blue');
					   $('#idDiv').text('아이디 사용 가능');	
					 }
				},
				error: function(err) {
					console.log(err);
				}
			});
		}
});