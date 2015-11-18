/*****
版本     ： 1.0
日期     ： 2015-5-30  
版权     ： Copyright ® 2008,20013 信管创业基地. All right reserved.
修改历史 ：
		2015-6-4  1.0.1   	俞常爽		 添加删除功能
*/
var pNum = 2;
var totalPageNum = 1;
$(function() {
	xg.app.toRequest();
	xg.app.toTip();
	xg.app.toMore();
	xg.app.toDetailpage();
	xg.app.toSearch();
	xg.app.toMypost();
})
var xg = {}; //命名空间

xg.ui = {}; //组件库

xg.ui.textChange = function(obj, str) {
	//光标移入的时候
	obj.onfocus = function() {
		if (this.value == str) {
			this.value = '';
		}
	};
	//光标移走的时候
	obj.onblur = function() {
		if (this.value == '') {
			this.value = str;
		}
	};
}

xg.app = {}; //应用

//input的移入移出清空
xg.app.toTip = function() {
	var oText1 = document.getElementById('selects_text');
	xg.ui.textChange(oText1, '');
};

//页面第一次请求
xg.app.toRequest = function() {
	$.ajax({
		url: 'userShowinfo.act',
		type: 'post',
		dataType: 'json',
		data: {
			'pNum': 1
		},
		success: function(data) {
			var html = '';
			for (var i = 0; i < data.user.length; i++) {
				html += '<li class="detailpage" id="">\
							<span id="">' + data.user[i].username + '</span>\
								<div class="msg">\
									<p>' + data.user[i].event_name + '</p>\
									<time>' + (1900 + data.user[i].publish_time.year) + '-' + data.user[i].publish_time.month + '-' + data.user[i].publish_time.date + ' ' + data.user[i].publish_time.hours + ':' + data.user[i].publish_time.minutes + ':' + data.user[i].publish_time.seconds + '</time>\
								</div>\
							</li>'
			};
			$('#list')[0].innerHTML += html;
			xg.app.toDetailpage();
			for (var i = 0; i < data.user.length; i++) {
				$('li').eq(i).attr('id', data.user[i].id);
				$('span').eq(i).attr('id',data.user[i].community_name);
			}
		},
		error: function(xhr, type) {
			alert('Ajax error!')
		}
	});
};
//点击加载更多
xg.app.toMore = function() {
	$('#more').click(function() {
		$.ajax({
			url: 'userpagequery.act',
			type: 'post',
			data: {
				'pNum': pNum
			},
			success: function(data) {
				var html = '';
				pNum = data.pNum;
				for (var i = 0; i < data.user.length; i++) {
					html += '<li class="detailpage" id="">\
							<span id="">' + data.user[i].username + '</span>\
								<div class="msg">\
									<p>' + data.user[i].event_name + '</p>\
									<time>' + (1900 + data.user[i].publish_time.year) + '-' + data.user[i].publish_time.month + '-' + data.user[i].publish_time.date + ' ' + data.user[i].publish_time.hours + ':' + data.user[i].publish_time.minutes + ':' + data.user[i].publish_time.seconds + '</time>\
								</div>\
							</li>'
				}
				var len = $('li').length;
				$('#list')[0].innerHTML += html;
				for (var i = 0; i < data.user.length; i++) {
					$('li').eq(i + len).attr('id', data.user[i].id);
					$('span').eq(i + len).attr('id',data.user[i].community_name);
				};
				xg.app.toDetailpage();
			},
			error: function(xhr, type) {
				alert('Ajax error!')
			}
		});
	});
}

//查询操作
xg.app.toSearch = function() {
	$('#selects_submit').click(function() {
		var selected = $('#selects option:selected');
		var condition = $('#selects_text');
		$.ajax({
			type: "POST",
			url: "userConditionSelectinfo.act",
			data: {
				'conditionName': selected.val(),
				'conditionValue': condition.val()
			},
			success: function(data) {
				var html = '';
				for (var i = 0; i < data.items.length; i++) {
					html += '<li class="detailpage" id="">\
							<span>' + data.items[i].username + '</span>\
								<div class="msg">\
									<p>' + data.items[i].event_name + '</p>\
									<time>' + (1900 + data.items[i].publish_time.year) + '-' + data.items[i].publish_time.month + '-' + data.items[i].publish_time.date + ' ' + data.items[i].publish_time.hours + ':' + data.items[i].publish_time.minutes + ':' + data.items[i].publish_time.seconds + '</time>\
								</div>\
							</li>'
				}
				$('#list')[0].innerHTML = '';
				$('#list')[0].innerHTML += html;
				xg.app.toDetailpage();
				for (var i = 0; i < data.items.length; i++) {
					$('li').eq(i).attr('id', data.items[i].id);
					$('span').eq(i).attr('id',data.user[i].community_name);
				}
			},
			error: function(xhr, type) {
				alert('Ajax error!');
			}
		});
	});

}

//跳转到详情页面
xg.app.toDetailpage = function() {
	$('.detailpage').click(function() {
		var detailid = $(this).attr("id");
		window.location = "detail_mobile.html" + '?page!' + 'show' + '?id=' + detailid;
	});
}

//跳转到我的发布界面
xg.app.toMypost = function() {
	$('#mypost').click(function() {
		window.location = 'mypost_mobile.html';
	});
}