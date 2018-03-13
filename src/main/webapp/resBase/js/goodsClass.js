$(function(){
	//第二级
	$("#goodsClassId").change(function(){
		$("#spanerji").empty();
		$("#spansanji").empty();
		
		var id = $(this).val();
		var gc = $(this).find("option:selected").text;
	  	$.ajax({
             type: "post",
             url: APP_BASE+"/pro/findChildClass?id="+id,
             dataType: "json",
			 success:function(data) {
				var $li = "";
			 	if(data.result!='null'){
			 		$li ='<select name="gc2" class="select" id="gc2" onchange="getgc3(this);">';
			 		$li +='<option selected="selected" value="">请选择</option>';
				 	var jsonObj = eval("(" + data.result + ")");
					for ( var i = 0; i < jsonObj.length; i++) {
						$li += '<option value='+jsonObj[i].gcId+'>'+jsonObj[i].gcName+'</option>'
					}
					$li += "</select>";
			 	}
				$("#spanerji").append($li);
			}
	  	});
	});
});


function getgc3(obj){
	$("#spansanji").empty();
	var id = $(obj).val();
	var gc = $(obj).find("option:selected").text;
  	$.ajax({
         type: "post",
         url: APP_BASE+"/pro/findChildClass?id="+id,
         dataType: "json",
		 success:function(data) {
			var $li = "";
		 	if(data.result!='null'){
		 		$li ='<select name="gc3" class="select" id="gc3">';
		 		$li +='<option selected="selected" value="">请选择</option>';
			 	var jsonObj = eval("(" + data.result + ")");
				for ( var i = 0; i < jsonObj.length; i++) {
					$li += '<option value='+jsonObj[i].gcId+'>'+jsonObj[i].gcName+'</option>'
				}
				$li += "</select>";
		 	}
			$("#spanerji").append($li);
		}
  	});
}
