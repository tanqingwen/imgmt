<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>
<!DOCTYPE html>
<html>
	<head>
		<title>测试</title>
		<script language="javascript">
			
			function demo(objform)
			{
//				try
//				{
					var request = new   ActiveXObject("ALLINPAY.RequestData");
					var response = new ActiveXObject("ALLINPAY.ResponseData");
					var mis = new ActiveXObject("ALLINPAY.MisPos");
					alert(objform.transtype.value);
					request.PutValue("CardType","01");
					request.PutValue("TransType",objform.transtype.value);
					request.PutValue("Amount",objform.amt.value);
					if(objform.transtype.value='38')
						request.PutValue("Authcode",objform.code.value);
					var result = mis.TransProcess(request,response);
					
					objform.funcReturn.value = result;
					objform.rejcode.value=response.GetValue("Rejcode");
					objform.rejcodeExplain.value=response.GetValue("RejCodeExplain");
					delete request;
					delete response;
					delete mis;
					CollectGarbage();
//				}catch(err){
//					alert("错误描述: " + err.description);
//				}
			}
		</script>
	</head>
	
	<body>
		<h1>ALLINPAY支付接口JavaScript调用示例</h1>
		<form>
		交易类型：<select name="transtype">
			<option value ="02">消费</option>
			<option value ="03">撤销</option>
			<option value ="04">退货</option>
			<option value ="14">结算</option>
			<option value ="38">微信支付</option>
			<option value ="21">参数设置</option>
		</select><br/>
		交易金额：<input type="text" name="amt"/><br/>
		扫码支付二维码:<input type="text" name="code" /><br>
		<input type="button" name="Button1" value="Push me" onclick="demo(this.form)"><br/>
		函数返回码：<input type="text" name="funcReturn"/><br/>
		返回码：<input type="text" name="rejcode"/><br/>
		返回码解释：<input type="text" name="rejcodeExplain"/>
	  </form>
	</body>
</html>