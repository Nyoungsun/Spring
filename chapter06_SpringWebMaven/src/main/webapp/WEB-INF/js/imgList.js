$(function () {
	$.ajax({
		type: 'post',
		url: '/chapter06_SpringWebMaven/user/getImgList',
		datatype: 'json',
		success: function (data) {
			console.log(data);
			$.each(data, function(index, items){
				$('<tr/>').append($('<td/>', {
					align: 'center',
					text: items.seq
				})).append($('<td/>', {
					align: 'center',
					text: items.imgName
				})).append($('<td/>', {
					align: 'center'
					}).append($('<img/>', {
						src: '../storage/' + items.image,
						style: 'width: 70px; height: 70px;'
				}))).append($('<td/>', {
					align: 'center',
					text: items.imgContent
				})).appendTo($('#imgListTable'));
			}); //each
		},
		error: function (err) {
			console.log(err);
		}
	});
});