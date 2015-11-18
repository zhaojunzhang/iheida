$(function() {
	

    var pNum=1;
    var totalPageNum=1;
    
    //全选功能
    $("#checkAll").click(function() {
        $('input[name="subBox"]').prop("checked", this.checked);
    });
    $('input[name="subBox"]').click(function() {
        $("#checkAll").attr("checked", $('input[name="subBox"]').length == $("input[name='subBox']:checked").length ? true : false);
    });
  //详情功能
    function detailpage(){
    	$('.detailpage').click(function() {
            var detailid = $(this).parent().siblings(".id").html();
            window.location = "detail.html" + '?posted&id=' + detailid;
        });
    }
    //页码点击功能
    function evpage(){
    	$('.ev_page').click(function(){
        	pNum=$(this).val();
        	$.ajax({
        		type: "POST",
                url: "userShowinfo.act",
                data: {
                    'pNum':pNum
                },
                success:function(data){
                	pNum=data.pNum-1;
                	totalPageNum=data.totalPageNum;
                	$('.userlist').html('');
                    for (var i = 0; i < data.user.length; i++) {
                        var oUl = $('<ul class="userlist"><li><input type="checkbox" name="subBox" /></li><li class="id"></li><li class="username"></li><li class="student_id"></li><li class="publish_time"></li><li class="event_name"></li><li class="community_name"></li><li class="event_content"></li><li class="manage"><input type="button" class="detailpage" value="详情" /></li></ul>');
                        oUl.appendTo($('.list form').eq(0));
                        $('.id').eq(i).html(data.user[i].id);
                        $('.username').eq(i).html(data.user[i].username);
                        $('.student_id').eq(i).html(data.user[i].student_id);
                        $('.publish_time').eq(i).html(data.user[i].publish_time.year + 1900 + '-' + (data.user[i].publish_time.month + 1) + '-' + data.user[i].publish_time.date);
                        $('.event_name').eq(i).html(data.user[i].event_name);
                        $('.community_name').eq(i).html(data.user[i].community_name);
                        $('.event_content').eq(i).html(data.user[i].event_content);
                    };
                    $('.userlist').addClass('clearfix');
                    if(totalPageNum<7){
                    	$('.page').html('');
                    	 var opage = $('<input type="button" id="first_page" value="首页" /><input type="button" id="prev_page" value="上一页" /><input type="button" id="next_page" value="下一页" /><input type="button" id="last_page" value="尾页" />');
                         opage.appendTo($('.page').eq(0));
                    	for(var i=0;i<totalPageNum;i++){
                        	var ev_page=$('<input type="button" class="ev_page" value="'+(i+1)+'">');
                        	ev_page.insertBefore($('#next_page'));
                        };
                    }else if(totalPageNum>=7){
                    	if(pNum>=4&&pNum<=totalPageNum-3){
                    		$('.page').html('');
                       	 var opage = $('<input type="button" id="first_page" value="首页" /><input type="button" id="prev_page" value="上一页" /><input type="button" id="next_page" value="下一页" /><input type="button" id="last_page" value="尾页" />');
                            opage.appendTo($('.page').eq(0));
                    		var ev_page=$('<input type="button" class="ev_page" value="1" /><input type="button" class="dot" value="..." /><input type="button" class="ev_page" value="'+(pNum-1)+'" /><input type="button" class="ev_page" value="'+(pNum)+'" /><input type="button" class="ev_page" value="'+(pNum+1)+'" /><input type="button" class="dot" value="..." /><input type="button" class="ev_page" value="'+(totalPageNum)+'" />');
                    		ev_page.insertBefore($('#next_page'));
                    	}else if(pNum<4){
                    		$('.page').html('');
                       	 var opage = $('<input type="button" id="first_page" value="首页" /><input type="button" id="prev_page" value="上一页" /><input type="button" id="next_page" value="下一页" /><input type="button" id="last_page" value="尾页" />');
                            opage.appendTo($('.page').eq(0));
                    		var ev_page=$('<input type="button" class="ev_page" value="1" /><input type="button" class="ev_page" value="2" /><input type="button" class="ev_page" value="3" /><input type="button" class="ev_page" value="4" /><input type="button" class="dot" value="..." /><input type="button" class="ev_page" value="'+(totalPageNum)+'" />');
                    		ev_page.insertBefore($('#next_page'));
                    	}else {
                    		$('.page').html('');
                       	 	var opage = $('<input type="button" id="first_page" value="首页" /><input type="button" id="prev_page" value="上一页" /><input type="button" class="ev_page" value="1" /><input type="button" class="dot" value="..." /><input type="button" id="next_page" value="下一页" /><input type="button" id="last_page" value="尾页" />');
                            opage.appendTo($('.page').eq(0));
                    		for(var i=pNum-1;i<totalPageNum+1;i++){
                    			var ev_page=$('<input type="button" class="ev_page" value="'+(i)+'">');
                    			ev_page.insertBefore($('#next_page'));
                    		}
                    	}
                    }
                	
                    evpage();
                    pagestyle();
                    detailpage();
                    nextpage();
                    prevpage();
                    firstpage();
                    lastpage();
                }
                
        	});
        });
    }

    //ajax成功
    function pagesuccess(data,body){
    	$('.userlist').html('');
    	$('.page').html('');
        for (var i = 0; i < data.length; i++) {
            var oUl = $('<ul class="userlist"><li><input type="checkbox" name="subBox" /></li><li class="id"></li><li class="username"></li><li class="student_id"></li><li class="publish_time"></li><li class="event_name"></li><li class="community_name"></li><li class="event_content"></li><li class="manage"><input type="button" class="detailpage" value="详情" /></li></ul>');
            oUl.appendTo($('.list form').eq(0));
            $('.id').eq(i).html(data[i].id);
            $('.username').eq(i).html(data[i].username);
            $('.student_id').eq(i).html(data[i].student_id);
            $('.publish_time').eq(i).html(data[i].publish_time.year + 1900 + '-' + (data[i].publish_time.month + 1) + '-' + data[i].publish_time.date);
            $('.event_name').eq(i).html(data[i].event_name);
            $('.community_name').eq(i).html(data[i].community_name);
            $('.event_content').eq(i).html(data[i].event_content);
        };
        $('.userlist').addClass('clearfix');
        if(body==1){
            var opage = $('<input type="button" id="first_page" value="首页" /><input type="button" id="prev_page" value="上一页" /><input type="button" id="next_page" value="下一页" /><input type="button" id="last_page" value="尾页" />');
            opage.appendTo($('.page').eq(0));
            if(totalPageNum<7){
            	for(var i=0;i<totalPageNum;i++){
                	var ev_page=$('<input type="button" class="ev_page" value="'+(i+1)+'">');
                	ev_page.insertBefore($('#next_page'));
                };
            }else if(totalPageNum>=7){
            	if(pNum>=4&&pNum<=totalPageNum-3){
            		var ev_page=$('<input type="button" class="ev_page" value="1" /><input type="button" class="dot" value="..." /><input type="button" class="ev_page" value="'+(pNum-1)+'" /><input type="button" class="ev_page" value="'+(pNum)+'" /><input type="button" class="ev_page" value="'+(pNum+1)+'" /><input type="button" class="dot" value="..." /><input type="button" class="ev_page" value="'+(totalPageNum)+'" />');
            		ev_page.insertBefore($('#next_page'));
            	}else if(pNum<4){
            		var ev_page=$('<input type="button" class="ev_page" value="1" /><input type="button" class="ev_page" value="2" /><input type="button" class="ev_page" value="3" /><input type="button" class="ev_page" value="4" /><input type="button" class="dot" value="..." /><input type="button" class="ev_page" value="'+(totalPageNum)+'" />');
            		ev_page.insertBefore($('#next_page'));
            	}else {
            		var ev_page=$('<input type="button" class="ev_page" value="1" /><input type="button" class="dot" value="..." /><input type="button" class="ev_page" value="'+(pNum-1)+'" /><input type="button" class="ev_page" value="'+(pNum)+'" /><input type="button" class="ev_page" value="'+(pNum+1)+'" /><input type="button" class="ev_page" value="'+(totalPageNum)+'" />');
            		ev_page.insertBefore($('#next_page'));
            	}
            }
            evpage();
            detailpage();
            nextpage();
            prevpage();
            firstpage();
            lastpage();
            pagestyle();
        }else  if(body==2){
        	detailpage();
        }

    }
    //下一页功能
    function nextpage(){
        $('#next_page').click(function() {
        	if(pNum==totalPageNum)return false;
            pNum++;
            $.ajax({
                type: "POST",
                url: "userShowinfo.act",
                data: {
                    'pNum':pNum
                },
                success:function(data){
                	pNum=data.pNum-1;
                	totalPageNum=data.totalPageNum;
                    pagesuccess(data.user,1);
                }
            });
        });
    }
    //上一页功能
    function prevpage(){
        $('#prev_page').click(function() {
        	if(pNum==1)return false;
            pNum--;
            $.ajax({
                type: "POST",
                url: "userShowinfo.act",
                data: {
                    'pNum':pNum
                },
                success:function(data){
                	pNum=data.pNum-1;
                	totalPageNum=data.totalPageNum;
                    pagesuccess(data.user,1);
                }
            });
        });
    }
  //首页功能
    function firstpage(){
        $('#first_page').click(function() {
        	if(pNum==1)return false;
        	pNum=1;
            $.ajax({
                type: "POST",
                url: "userShowinfo.act",
                data: {
                    'pNum':pNum
                },
                success:function(data){
                	pNum=data.pNum-1;
                	totalPageNum=data.totalPageNum;
                    pagesuccess(data.user,1);
                }
            });
        });
    }
  //尾页功能
    function lastpage(){
        $('#last_page').click(function() {
        	if(pNum==totalPageNum)return false;
        	pNum=totalPageNum;
            $.ajax({
                type: "POST",
                url: "userShowinfo.act",
                data: {
                    'pNum':pNum
                },
                success:function(data){
                	pNum=data.pNum-1;
                	totalPageNum=data.totalPageNum;
                    pagesuccess(data.user,1);
                }
            });
        });
    }
    //每一页样式
    function pagestyle(){
    		if(pNum==1){
    			$('.page input').attr('disabled',false).removeClass('onpage');
    			$('#first_page').attr('disabled',true).addClass('onpage');
    			$('#prev_page').attr('disabled',true).addClass('onpage');
    			$('.ev_page').first().attr('disabled',true).addClass('onpage');
    		}else if(pNum==totalPageNum){
    			$('.page input').attr('disabled',false).removeClass('onpage');
    			$('#last_page').attr('disabled',true).addClass('onpage');
    			$('#next_page').attr('disabled',true).addClass('onpage');
    			$('.ev_page').last().attr('disabled',true).addClass('onpage');
    		}else{
    			$('.page input').attr('disabled',false).removeClass('onpage');
    			$(".ev_page").each(function(){
    				if($(this).val()==pNum){
    					$(this).addClass('onpage');
    				}
    			});
    		}
    }
    //页面加载时显示数据
    $.ajax({
        type: "POST",
        url: "userShowinfo.act",
        data: {
            'pNum':1
        },
        success: function(data) {
        	pNum=data.pNum-1;
        	totalPageNum=data.totalPageNum;
            pagesuccess(data.user,1);
        }
    });

        //查询功能
        $('#search').click(function() {
            var selected = $('#selected option:selected');
            var condition = $('#ser_input');
            $.ajax({
                type: "POST",
                url: "userConditionSelectinfo.act",
                data: {
                    'conditionName': selected.val(),
                    'conditionValue': condition.val()
                },
                success: function(data) {
                	pNum=data.pNum-1;
                	totalPageNum=data.totalPageNum;
                    pagesuccess(data.items,2);
                }
            });
        });

    



});
