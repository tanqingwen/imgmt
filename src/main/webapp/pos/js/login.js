window.onload=function(){
$('.login').click(function(){
	// alert(123);
    if($('#userno').val()==""){
    	$('.user-tip').removeClass('hide');
    }else if($('#psd').val()==""){
        $('.pwd-tip').removeClass('hide2');
    }else{
    	var staffId = $('#userno').val();
    	var password = $('#psd').val();
    		// password=CryptoJS.MD5(psd);
    	console.log('用户名：'+staffId+'密码：'+password);
    	var url = urlpath+'rest/login';
    	var data = {'staffId':staffId,'password':password,'token':''};
    	$.ajax({
    	 	url:url,
    		data:data,
    		type:'POST',
    		success:function(resultData){
    		  if(resultData.status=="STAFF_PASSWORD_ERROR"){
    		  }
    		  if(resultData.status=="OK"){
                console.log(resultData);
                layer.msg("登录成功");
                document.cookie = "userId=" + resultData.value.id;
                 alert("保存cookie"+document.cookie);
 //               sessionStorage.setItem('userId',resultData.value.id);
                window.location = '../pos/posbuyticket.html';
    		  }
    		} 	    		
    	});
    }
});
}