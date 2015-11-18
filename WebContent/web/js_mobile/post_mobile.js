/*****
版本     ： 1.0
日期     ： 2015-5-30  
版权     ： Copyright ® 2008,20013 信管创业基地. All right reserved.
修改历史 ：
	2015-6-4  1.0.1   	俞常爽		 添加返回功能
*/

$(function() {
	xg.app.toPost();
	xg.app.toResetext();
	xg.app.toReturn();
})
var xg = {}; //命名空间

xg.ui = {}; //组件库

xg.app = {};

//传送页面数据
xg.app.toPost = function() {

	$('#btn1').click(function() {

		if (confirm('你确定要发布？')) {
			$.ajax({
				type: "POST",
				url: "useraddinfo.act",
				data: {
					'username': $('#username').val(),
					'student_id': $('#student_id').val(),
					'community_name': $('#community_name').val(),
					'event_name': $('#event_name').val(),
					'event_content': $('#event_content').val()
				},
				success: function(data) {
					if (data == 'true') {
						window.location = "show_mobile.html";
					} else {
						alert('发布失败...');
					}
				}
			});
		} else {
			return false;
		};
	});
};
//重置表单和文本域

xg.app.toResetext = function() {
	$('#btn2').click(function(ev) {
		var oIput = $('#post').find('input');
		var oTextarea = $('#post').find('#event_content');
		if (confirm('你确定要重置？')) {
			for (var i = 0; i < oIput.length; i++) {
				oIput[i].value = '';
			}
			oTextarea.val('');
		} else {
			return false;
		};

	});
};

//返回操作
xg.app.toReturn = function() {
	$('#return').click(function() {
		window.location = 'show_mobile.html';
	});
};