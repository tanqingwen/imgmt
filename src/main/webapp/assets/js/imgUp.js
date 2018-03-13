$(function() {
	var delParent,img_id;
	var imgArr = []; //图片地址"blob:http://127.0.0.1:8020/8c59f3c5-4aef-4a85-88b7-70240c32789d"格式
	var imgArr1 = [];
	var arr = []; //图片名称"4545.jpg"名称
	var arr2 = []
	var defaults = {
		fileType: ["jpg", "png", "bmp", "jpeg"], // 上传文件的类型
		fileSize: 1024 * 1024 * 10 // 上传文件的大小 10M
	};
	var filesurl1=[];
	var filesurl=[];
	/*点击图片的文本框*/
	$(".file").change(function() {
		var idFile = $(this).attr("id");
		var file = document.getElementById(idFile);
		var imgContainer = $(this).parents(".z_photo"); //存放图片的父亲元素
		var fileList = file.files; //获取的图片文件
		var input = $(this).parent(); //文本框的父亲元素
		//遍历得到的图片文件
		var numUp = imgContainer.find(".up-section").length;
		var totalNum = numUp + fileList.length; //总的数量
		if(fileList.length > 1 || totalNum > 1) {
			alert("上传图片数目不可以超过1个，请重新选择"); //一次选择上传超过5个 或者是已经上传和这次上传的到的总数也不可以超过5个
		} else if(numUp < 1) {
			fileList = validateUp(fileList);
			for(var i = 0; i < fileList.length; i++) {
				var imgUrl = window.URL.createObjectURL(fileList[i]);
				imgArr1.push(imgUrl);
				filesurl1.push(imgUrl);
				var $section = $("<section class='up-section fl loading'>");
				imgContainer.prepend($section);
				var $span = $("<span class='up-span'>");
				$span.appendTo($section);

				var $img0 = $("<img class='close-upimg'>").on("click", function(event) {
					event.preventDefault();
					event.stopPropagation();
					$(".works-mask").show();
					delParent = $(this).parent();
					delParent.attr("data-id",i);
				});
				$img0.attr("src", "../assets/app/img/a7.png").appendTo($section);
				var $img = $("<img class='up-img up-opcity'>");
				$img.attr("src", imgArr1[filesurl1.length-1]);
				// $img0.attr("id",filesurl.length-1);
				$img.appendTo($section);
				var $p = $("<p class='img-name-p'>");
				$p.html(fileList[i].name).appendTo($section);
				// var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
				// $input.appendTo($section);
				// var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
				// $input2.appendTo($section);

			}
		}
		// var $input = $("<input id='tag' name='tag' value='' type='hidden'>");
		// $input.appendTo($section);
		setTimeout(function() {
			$(".up-section").removeClass("loading");
			$(".up-img").removeClass("up-opcity");
		}, 450);
		numUp = imgContainer.find(".up-section").length;
		if(numUp >= 1) {
			$(this).parent().hide();
		}
		//input内容清空
		$(this).val("");
		$('#tag').val(imgArr1);
		alert($('#tag').val());
		console.log($('#tag').val());
	});

	$(".file1").change(function() {
		var file = document.getElementById("file1");
		var imgContainer = $(this).parents(".z_photo"); //存放图片的父亲元素
		var fileList = file.files; //获取的图片文件
		var input = $(this).parent(); //文本框的父亲元素		
		//遍历得到的图片文件
		var numUp = imgContainer.find(".up-section").length;
		var totalNum = numUp + fileList.length; //总的数量
		if(fileList.length > 5 || totalNum > 5) {
			alert("上传图片数目不可以超过5个，请重新选择"); //一次选择上传超过5个 或者是已经上传和这次上传的到的总数也不可以超过5个
		} else if(numUp < 5) {
			fileList = validateUp(fileList);
			for(var i = 0; i < fileList.length; i++) {
				var imgUrl = window.URL.createObjectURL(fileList[i]); //生成图片地址"blob:http://127.0.0.1:8020/8c59f3c5-4aef-4a85-88b7-70240c32789d"格式
				var imgsrc = fileList[i].name; //获取图片名称
				imgArr.push(imgUrl); //把图片地址"blob:http://127.0.0.1:8020/8c59f3c5-4aef-4a85-88b7-70240c32789d"格式 放入数组
				arr.push(imgsrc); //把图片名称"4545.jpg"名称 放入数组
				var $section = $("<section class='up-section fl loading'>");
				imgContainer.prepend($section);
				var $span = $("<span class='up-span'>");
				$span.appendTo($section);
				var $inputs = $("<input name='tags' value='' type='hidden'/>");
				var $img0 = $("<img class='close-upimg'>").on("click", function(event) {
					event.preventDefault();
					event.stopPropagation();
					$(".works-mask").show();
					delParent = $(this).parent();
					img_id = parseInt($(this).attr("id"));
				});
				$img0.attr("src", "../assets/app/img/a7.png").appendTo($section);
				var $img = $("<img class='up-img up-opcity'>");
				filesurl.push(fileList[i]);
				console.log(filesurl);
				$img.attr("src", imgArr[filesurl.length-1]);
				$img0.attr("id",filesurl.length-1);
				$img.appendTo($section);
				var $p = $("<p class='img-name-p'>");
				$p.html(fileList[i].name).appendTo($section);
				// var $input = $("<input id='taglocation' name='taglocation' value='' type='hidden'>");
				// $input.appendTo($section);
				// var $input2 = $("<input id='tags' name='tags' value='' type='hidden'/>");
				// $input2.appendTo($section);
				var url = $(this).val();
				var road = "input框的值是:" + $(this).val();
		        arr2.push(road);
			}
		}
		// var $input = $("<input id='tags' name='tags' value='' type='hidden'>");
		// $input.appendTo($section);
		setTimeout(function() {
			$(".up-section").removeClass("loading");
			$(".up-img").removeClass("up-opcity");
		}, 450);
		numUp = imgContainer.find(".up-section").length;
		if(numUp >= 5) {
			$(this).parent().hide();
		}
		// var url = $(this).val();
		// var road = "input框的值是:" + $(this).val();
		// arr2.push(road);
		// console.log("arr2的长度是"+arr2.length);
		// console.log(imgArr);
		//input内容清空
		$('#tags').val(imgArr1);
		console.log($('#tags').val());
	});
	// $(".z_photo").delegate(".close-upimg", "click", function() {
	// 	$(".works-mask").show();
	// 	delParent = $(this).parent();
	// });
	$(".wsdel-ok").click(function(){
		$(".works-mask").hide();
		
		if(delParent.parent().hasClass('mainpic')){
		var numUp = delParent.siblings().length;
		if(numUp < 2) {
		delParent.parent().find(".z_file").show();
		}	
		imgArr1.splice(img_id,1);
		filesurl1.splice(img_id,1);
		delParent.remove();
		arr.splice(img_id,1);
	}else if(delParent.parent().hasClass('detailpic')){
		var numUp = delParent.siblings().length;
		if(numUp < 6) {
			delParent.parent().find(".z_file").show();
		}
		imgArr.splice(img_id,1);
		filesurl.splice(img_id,1);
		delParent.remove();
		arr2.splice(img_id,1);
	}

	});
	$(".wsdel-no").click(function() {
		$(".works-mask").hide();
	});
	function validateUp(files) {
		var arrFiles = []; //替换的文件数组
		for(var i = 0, file; file = files[i]; i++) {
			//获取文件上传的后缀名
			var newStr = file.name.split("").reverse().join("");
			if(newStr.split(".")[0] != null) {
				var type = newStr.split(".")[0].split("").reverse().join("");
				if(jQuery.inArray(type, defaults.fileType) > -1) {
					// 类型符合，可以上传
					if(file.size >= defaults.fileSize) {
						alert(file.size);
						alert('您这个"' + file.name + '"文件大小过大');
					} else {
						// 在这里需要判断当前所有文件中
						arrFiles.push(file);
					}
				} else {
					alert('您这个"' + file.name + '"上传类型不符合');
				}
			} else {
				alert('您这个"' + file.name + '"没有类型, 无法识别');
			}
		}
		return arrFiles;
	}

})