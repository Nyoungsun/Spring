$(function (){
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getUserList',
		data: 'pg=' + $('#pg').val(),
		datatype: 'json',
		success: function(data){
		//console.log(data);
			$.each(data.list, function(index, items){
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.name
				})).append($('<td/>', {
					align: 'center',
					text: items.id
				})).append($('<td/>', {
					align: 'center',
					text: items.pwd
				})).appendTo($('#userListTable'));
			});
			
			//페이징 처리
			$('#userPagingDiv').html(data.userPaging.pagingHTML);
		},
		error: function(err){
			console.log(err);
		}
	});
});