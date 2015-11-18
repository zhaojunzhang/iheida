$(function(){
	var url= window.location.href;
	var index = url.substring(url.lastIndexOf('=') + 1);
    var tourl=url.substring(url.lastIndexOf('?') + 1,url.lastIndexOf('&'))+'.html';
	$.ajax({
		type: "POST",
        url: "selectidinfo.act",
        data: {
            'id': index
        },
        success:function(data){
        	$('#event_name').html(data.event_name);
        	$('#username').html(data.username);
        	$('#community_name').html(data.community_name);
        	$('#publish_time').html(data.publish_time.year+1900 + '-' + (data.publish_time.month+1) + '-' + data.publish_time.date);
        	$('#event_content').html(data.event_content);
        }
	});
    $('.return').attr('href',tourl);
});