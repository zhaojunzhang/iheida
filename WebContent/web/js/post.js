
$(function(){
	$('#sub').click(function(){
		$.ajax({
			type: "POST",
	        url: "addinfo.act",
	        data: {
		            'username': $('#username').val(),
		            'student_id': $('#student_id').val(),
		            'event_name':$('#event_name').val(),
		            'community_name':$('#community_name').val(),
		            'event_content':$('#event_content').val()
	        	},
	        success: function(data) {
	            if(data=='true'){
	            	alert('恭喜发布成功！');
	            	window.location="welcome.html";
	            }else{
	            	alert('发布失败...');
	            }
        	}
		});
	});
});