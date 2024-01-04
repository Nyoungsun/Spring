$(function(){
	$('#updateDiv').hide();
});

$('#searchIdBtn').click(function () {
	$('.checkDiv').empty();

	if ($('#searchId').val() == '') {
		$('#updateDiv').hide();
		$('#checkIdDiv').text('아이디를 입력하세요');
		$('#searchId').focus();
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/getUser',
			data: 'id=' + $('#searchId').val(),
			success: function (data) {
				//dataType 생략하여 자동으로 자료형 지정
				if (data == '') {
					$('#updateDiv').hide();
					$('#checkIdDiv').text('없는 아이디입니다.');
				} else {
					$('#checkIdDiv').text('');
					$('#updateDiv').show();
					$('#name').val(data.name);
					$('#id').val(data.id);
					$('#pwd').val(data.pwd);
				}
			},
			error: function (err) {
				console.log(err);
			}
		});
	}
});

$('#updateBtn').click(function () {
	$('.checkDiv').empty();

	if ($('#name').val() == '') {
		$('#nameDiv').text('이름을 입력하세요.');
		$('#name').focus();
	} else if ($('#pwd').val() == '') {
		$('#pwdDiv').text('비밀번호를 입력하세요');
		$('#pwd').focus();
	} else {
		$.ajax({
			type: 'post',
			url: '/chapter06_SpringWebMaven/user/update',
			data: $('#updateForm').serialize(),
			success: function () {
				alert('성공');
				location.href = '/chapter06_SpringWebMaven/user/list';
			},
			error: function (err) {
				console.log(err);
			}
		});
	}
});

$('#cancelBtn').click(function(){
	$('#searchIdBtn').trigger('click');
});