window.onload=function(){
	var strFullPath = window.document.location.href;
	var strPath = window.document.location.pathname;
	var prePath = strFullPath.split("/");
	var basePath = strPath.split("/");
	var webPath = "/" + basePath[1];
	prePath.pop();
	var cmPath = prePath.join("/");
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
    	var url = 'http://58.246.52.102:3551/imgmt/rest/login';
    	var data = {'staffId':staffId,'password':password,'token':''};
    	$.ajax({
    	 	url:url,
    		data:data,
    		type:'post',
    		success:function(resultData){
    		  if(resultData.ok == false){
                layer.msg(resultData.comment);
                $('#userno').val('');
                $('#password').val('');
    		  }
    		  if(resultData.status=="OK"){
                layer.msg("成功");
                setCookie('userno',staffId,30);
//                document.cookie = "username"
//                $.ajax({
//                	url:'/app/feishiming',
//                });    
                window.location.href = cmPath+"/feishiming";
    		  }
              console.log(resultData);
    		} 	    		
    	});
    }
});

function setCookie(cname,cvalue,exdays)
{
  var d = new Date();
  d.setTime(d.getTime()+(exdays*24*60*60*1000));
  var expires = "expires="+d.toGMTString();
  document.cookie = cname + "=" + cvalue + "; " + expires;
}
 
function getCookie(cname)
{
  var name = cname + "=";
  var ca = document.cookie.split(';');
  for(var i=0; i<ca.length; i++) 
  {
    var c = ca[i].trim();
    if (c.indexOf(name)==0) return c.substring(name.length,c.length);
  }
  return "";
}
}