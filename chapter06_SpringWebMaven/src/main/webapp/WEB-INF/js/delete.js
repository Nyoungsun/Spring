$(function () {
	$('#deleteDiv').hide();
});

$('#searchIdBtn').click(function () {
	$('#checkidDiv').empty();

	if ($('#id').val() == '') {
		$('#updateDiv').hide();
		$('#checkidDiv').text('아이디를 입력하세요');
		$('#id').focus();
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/getUser',
			data: 'id=' + $('#id').val(),
			success: function (data) {
				//dataType 생략하여 자동으로 자료형 지정
				if (data == '') {
					$('#updateDiv').hide();
					$('#checkidDiv').css('color', 'red');
					$('#checkidDiv').text('없는 아이디입니다.');
				} else {
					$('#checkidDiv').text('');
					$('#deleteDiv').show();
				}
			},
			error: function (err) {
				console.log(err);
			}
		});
	}
});

$('#deleteBtn').click(function () {
	$('#checkPwdDiv').empty();

	if ($('#pwd').val() == '') {
		$('#checkPwdDiv').text('비밀번호를 입력하세요');
		$('#pwd').focus();
	} else {
		if (confirm('삭제하시겠습니까?')) {
			$.ajax({
				type: 'post',
				url: '/chapter06_SpringWebMaven/user/delete',
				data: 'id=' + $('#id').val() + '&pwd=' + $('#pwd').val(),
				success: function (data) {
					if (data != '0') {
						alert('성공');
						location.href = '/chapter06_SpringWebMaven/user/list';
					} else {
						$('#checkPwdDiv').text('비밀번호가 다릅니다.');
					}
				},
				error: function (err) {

				}
			});
		}
	}
});


$('#cancelBtn').click(function () {
	location.href = '/chapter06_SpringWebMaven/';
});