
$(function(){
	var oUser=$('#user');
	var oPass=$('#pass');
	var login=$('#login');
	//数据交互
	login.click(function(){
		if(oUser.val()!=''&&oPass.val()!=''){
			$.ajax({
				type:"POST",
				url:"login.act",
				data:{'username':oUser.val(),'password':oPass.val()},
				success:function(data){
					if(data=="1"){
						window.location="welcome.html";
					}
				}
			});
		}
		
	});
});

