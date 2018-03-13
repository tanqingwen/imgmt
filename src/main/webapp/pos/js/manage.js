// var userId = sessionStorage.getItem("userId");
$('.logout').click(function(){
   $.ajax({
   		url:urlpath+'rest/loginout',
		data:'',
	    dataType:'JSON',
	    // contentType:'application/x-www-form-urlencoded',
	    type:'POST',
	    beforeSend: function(xhr) {
        xhr.setRequestHeader("userId", userId);
        },
	    success:function(resultData){
         if(resultData.status=='OK'){
         	layer.msg(resultData.value);
         	sessionStorage.setItem("userId","");
         	window.location='login.html';
         }
	    },
	    error:function(resultData){
         console.log(resultData);
	    }
   });
});