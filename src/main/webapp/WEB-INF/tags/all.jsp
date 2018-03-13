<!--author Hugh 20161001-->
<!--content 填充卡号-->
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<body>
</body>
<script src="${assets}/yanwu/js/jquery-1.4.4.min.js"></script>
<script language="javascript">
$(document).ready(function(){
	$("input[proxy='true']").each(function(i){
		if(this.type!="hidden"){
			var obj = $(this);
			var name = this.name;
			var source ;
			var front;
			//if($.browser.msie){ IE 7-10
			var sUserAgent = navigator.userAgent;
			if(sUserAgent.toLowerCase().indexOf("trident") > -1 && sUserAgent.indexOf("rv") > -1){	
				var t = this.outerHTML;
				var idx = t.indexOf(" ")+1;
				t=t.substring(0,idx)+"type='hidden' "+t.substring(idx);
				//source = document.createElement(t);
				source = document.createElement("input");
				source.setAttribute("type", "hidden");
				source.setAttribute("name", "cbCardholderNo");
				source.setAttribute("class", "form-control");
				//source.setAttribute("id", "cbCardholderNo");
				//source.setAttribute("value", "");
				source.setAttribute("proxy", "true");
			
				//front = document.createElement(this.outerHTML);
				front = document.createElement("input");
				front.setAttribute("name", "cbCardholderNo");
				front.setAttribute("class", "form-control");
				//front.setAttribute("id", "cbCardholderNo");
				//front.setAttribute("value", "");
				front.setAttribute("proxy", "true");
								
			}else {
				alert("Only support IE");
				return;
			}
			var frontElement ="";
			front.id = "proxy"+i;
			front.size = 8;
			front.maxLength = 8;
			front.removeAttribute("proxy");
			front.removeAttribute("readOnly");
			front.removeAttribute("name");
			frontElement = front.outerHTML;
			// source.proxy="proxy"+i;
			source.setAttribute("proxy", "proxy"+i);
			//this change to hidden
			obj.before(source.outerHTML);
			alert("source.outerHTML:  " + source.outerHTML);
			//front is view
			obj.after(frontElement);
			alert("frontElement:  " + frontElement);
			//this is unview
			this.style.display="none";
			this.removeAttribute("name");
			this.removeAttribute("proxy");
			$("#proxy"+i).bind('input propertychange', function() {
				document.getElementsByName(name)[0].value="<%=Constants.baseBIN%>"+this.value;
			});
			alert("zuihou: " + document.getElementsByName(name)[0].value);
		}
	});
	try{
		document.getElementById(form1.varCb_cardholder_no.proxy).focus();
		document.getElementById(form1.varOld_Cb_cardholder_no.proxy).focus();
	}catch(e){
	}
		
});
function cardview(cardno){
	if(cardno!=null&&cardno.length==16){
		return cardno.substr(10);
		//return cardno.substr(10,5)+"-"+cardno.substr(15);
	}else {
		return cardno;
	}
}
</script>
</head>
</html>

 