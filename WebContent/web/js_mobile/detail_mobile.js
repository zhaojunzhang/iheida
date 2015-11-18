/*****
版本     ： 1.0
日期     ： 2015-5-30  
版权     ： Copyright ® 2008,20013 信管创业基地. All right reserved.
修改历史 ：
    2015-6-4  1.0.1     俞常爽      添加返回功能
*/
$(function() {
    xg.app.toShow();
    xg.app.toReturn();
})

var xg = {}; //命名空间

xg.ui = {}; //组件库

xg.app = {}; //应用

//显示详细信息
xg.app.toShow = function() {
    var url = window.location.href;
    var index = url.substring(url.lastIndexOf('=') + 1);
    $.ajax({
        type: "POST",
        url: "selectidinfo.act",
        data: {
            'id': index
        },
        success: function(data) {
            $('#event_name').html(data.event_name);
            $('#username').html(data.username);
            $('#community_name').html(data.community_name);
            $('#publish_time').html(data.publish_time.year + 1900 + '-' + (data.publish_time.month + 1) + '-' + data.publish_time.date);
            $('#event_content').html(data.event_content);
        }
    });
}

//返回操作
xg.app.toReturn = function() {
    var url = window.location.href;
    var started = url.lastIndexOf('!') + 1;
    var ended = url.lastIndexOf('!') + 4;
    var index = url.substring(started, ended);
    if (index = 'show') {
        $('#return').click(function() {
            window.location = 'show_mobile.html';
        });
    } else if (index = 'mypt') {
        $('#return').click(function() {
            window.location = 'mypost_mobile.html';
        });
    }
}