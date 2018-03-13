// var userId = sessionStorage.getItem("userId");
$('.shift1').click(function(){
	layer.confirm('确定交班？', {
    btn: ['确定','取消'] //按钮
    }, function(){
    	$.ajax({
		url:urlpath+'app/shifting/duty',
		data:'',
	    dataType:'JSON',
	    // contentType:'application/x-www-form-urlencoded',
	    type:'GET',
	    beforeSend: function(xhr) {
        xhr.setRequestHeader("userId", userId);
        },
	    success:function(resultData){
         console.log(resultData);
         layer.msg("交班成功！");
	    },
	    error:function(resultData){
         console.log(resultData);
         layer.msg("网络故障")
	    }
	});
},function(){});

    });
$('.shift2').click(function(){
	layer.confirm('确定结班？', {
    btn: ['确定','取消'] //按钮
    }, function(){
    	$.ajax({
		url:urlpath+'app/shifting/shift',
		data:'',
	    dataType:'JSON',
	    // contentType:'application/x-www-form-urlencoded',
	    type:'GET',
	    beforeSend: function(xhr) {
        xhr.setRequestHeader("userId", userId);
        },
	    success:function(resultData){
         console.log(resultData);
         layer.msg("结班成功！");
	    },
	    error:function(resultData){
         console.log(resultData);
         layer.msg("网络故障");
	    }
	});
},function(){});

    });