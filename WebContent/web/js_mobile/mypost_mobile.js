/*****
版本     ： 1.0
日期     ： 2015-6-3  
版权     ： Copyright ® 2008,20013 信管创业基地. All right reserved.
修改历史 ：
		2015-6-4  1.0.1   	俞常爽		 添加删除功能
*/
var pNum = 2;
var totalPageNum = 1;
$(function() {
	xg.app.toRequest();
	xg.app.toDelpage();
	xg.app.toDetailpage();
	xg.app.toReturn();
})
var xg = {}; //命名空间

xg.ui = {}; //组件库

xg.app = {};//应用

//页面第一次请求
xg.app.toRequest = function() {
	$.ajax({
		url: '',
		type: 'post',
		dataType: 'json',
		data: {'student_id'},
		success: function(data) {
			var html = '';
			for (var i = 0; i < data.user.length; i++) {
				html += '<li class="detailpage" id="">\
							<span id="">' + data.user[i].username + '</span>\
								<div class="msg">\
									<p>' + data.user[i].event_name + '</p>\
									<time>' + (1900+data.user[i].publish_time.year) + '-' + (data.user[i].publish_time.month + 1) + '-'+ data.user[i].publish_time.date + ' ' + data.user[i].publish_time.hours + ':' + data.user[i].publish_time.minutes + ':' + data.user[i].publish_time.seconds + '</time>\
									<a href="javascript:;" class="delpage">' + '删除' + '</a>\
								</div>\
						</li>'
			};
			$('#list')[0].innerHTML += html;
			for (var i = 0; i < data.user.length; i++){
				$('li').eq(i).attr('id',data.user[i].id);
				$('span').eq(i).attr('id',data.user[i].community_name);
			}
		},
		error: function(xhr, type) {
			alert('Ajax error!')
		}
	});
};

//页面删除功能
xg.app.toDelpage = function() {
	$('.delpage').click(function() {
		var _this = this;
		$.ajax({
			type: "POST",
			url: "",
			data: {
				'id': $(this).parent().siblings(".id").html()
			},
			success: function() {
				$(_this).val('已删除').attr('disabled', true).addClass('notava');
			}
		})
	});
}

//跳转到详情页面
xg.app.toDetailpage = function() {
	$('.detailpage').click(function() {
		var detailid = $(this).attr("id");
		window.location = "detail_mobile.html" + '?page!' + 'mypt' + '?id=' + detailid;
	});
}

//返回操作
xg.app.toReturn = function() {
	$('#return').click(function() {
		window.location = 'show_mobile.html';
	});
};

