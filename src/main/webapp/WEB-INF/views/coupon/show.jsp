<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 优惠券更新</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
	<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
	<link rel="stylesheet" href="${assets }/ticketoo/css/ticketUpdate2.css" />
	<link rel="stylesheet" href="${assets }/css/multiple-select.css" />
	</head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="cptktypelist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>优惠券更新</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/cpDiscount/list">优惠券管理</a></li>
            <li class="active">优惠券更新</li>
          </ol>
        </section>

        <!-- Main content -->
        <div class="container-fluid ticketUpdate Coupon couponUpdate">
			<div class="row">
				<div class="tip-img">
					<p>优惠券更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看表单</h3>
						<form class="form-inline form-horizontal" id="stafffrom" method="post" action="${ctx }/cpDiscount/updateShow"
							enctype="multipart/form-data">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeId">优惠券ID：</label>
										<input type="text" class="form-control formConl line-input" id="disId" name="disId" title="不能为空" value="${item.disId}" readonly />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTicketDes">优惠券描述：</label>
										<input class="form-control formConl line-input" type="text" id="disDesc" name="disDesc" value="${item.disDesc}" ${readonlyIf}/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeDesc">优惠券类型：</label>
										<input type="text" class="form-control formConl line-input" id="disType" name="disType" value="${item.disType}" ${readonlyIf} />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccListPrice">优惠券金额：</label>
										<input type="text" class="form-control formConl line-input" id="disMoney" name="disMoney" value="${item.disMoney}" ${readonlyIf}/>
									</div>
								</div>
								
							</div>
							  <div class="col-md-12">           
			                        <div class="col-md-6">
				                         <div class="form-group">
				                            <label>允许售票起始时间<i class="color-red">*</i>：</label>
				                            <div class="input-group">
					                             <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					                            <input class="form-control formConl" path="disBeginTime" id="disBeginTime" name="disBeginTime" data-toggle="datepicker"  value="${item.disBeginTime }" ${disabledIf}/>
				                            </div>
				                          </div>
			                        </div>
			                        <div class="col-md-6 ">
				                         <div class="form-group">
				                            <label>允许售票终止时间<i class="color-red">*</i>：</label>
				                            <div class="input-group ">
					                             <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					                            <input class="form-control formConl" path="disEndTime" id="disEndTime" name="disEndTime" data-toggle="datepicker"  value="${item.disEndTime }" ${disabledIf}/>
				                            </div>
				                        </div>
			                        </div>
                   			 </div>
							 
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeUser">是否有效：</label>
										 <select class="line-input" id="disStatus" name="disStatus" ${disabledIf} >
									     	 <option value="Y" ${item.disStatus eq 'Y' ? 'selected' : ''}>有效</option>
						    				 <option value="N" ${item.disStatus eq 'N' ? 'selected' : ''}>无效</option>
									      </select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="hasUsed">是否已使用：</label>
										<input type="text" class="form-control formConl line-input" id="hasUsed" name="hasUsed" value="${item.hasUsed eq 'Y' ? '已使用' : '未使用'}" readonly />
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeUser">指定用户：</label>
										 <select multiple="multiple" id="amMerchantId" name="user">
										 	<c:forEach items="${users}" var="item1" >
									     		<option value="${item1.cbMemberCode }" ${item1.selectedIf} >${item1.cbMemberCode }-${item1.cbCardholderName }</option>
									     	</c:forEach>
									     </select>
									     <input type="hidden" id="usersId" name="usersId"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeUser">优惠券图片：</label>
										<div class="z_photo upimg-div clear a-upload">
											<img alt="" src="${assets }/${item.disUrl}" width="100%" height="100%">
										</div>
										<input type="hidden" name="disUrl" id="disUrl" value="${item.disUrl}" />
									</div>
								</div>
								<div class="col-md-6">
									
									<div class="form-group">
										<label for="ccTicketType">使用说明：</label>
										<%-- <input class="form-control formConl line-input" type="text"  value="${item.disService}"/> --%>
										<textarea rows="10" cols="30"  id="disService" name="disService" style="width: 256px;margin-left: 10px;vertical-align: top;border: lightblue 1px solid;border-radius: 5px;" ${disabledIf}>${item.disService}</textarea>
									</div>
								</div>
							</div> 
							<div class="col-md-12">
								
							</div>

						<div class="col-lg-12 submit-group marginTop marginBottom">
							
							<a type="button" href="${ctx }/cpDiscount/list" class="form-a">&lt;返回</a>
							<button type="button" class="btn-size" style="width:110px;float:right;" onclick="add()">确认</button>
						</div>
						</form>
					</div>
				</div>
			</div>

		</div>
        </div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>
      <!-- Control Sidebar -->
      <tags:control_sidebar/>
   		<!-- ./wrapper --> 
    <tags:load_common_js/>
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets }/js/multiple-select.js"></script>
   <script type="text/javascript">
   $(function() {
       var dataPickerOp = {
           format: 'yyyy-mm-dd',
           weekStart: 1,
           startDate: new Date(),
           days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
           daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
           daysMin: ['日', '一', '二', '三', '四', '五', '六'],
           months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
           monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
           autoHide: true
       };
       var dataPickerOp2 = {
	            format: 'yyyy-mm-dd',
	            weekStart: 1,
	            days: ['星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六'],
	            daysShort: ['周日', '周一', '周二', '周三', '周四', '周五', '周六'],
	            daysMin: ['日', '一', '二', '三', '四', '五', '六'],
	            months: ['一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月', '九月', '十月', '十一月', '十二月'],
	            monthsShort: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
	            autoHide: true,
	           
	        };
       //营业执照时间
       $('#disBeginTime').datepicker(dataPickerOp);
       $('#disEndTime').datepicker(dataPickerOp2);
       $('#disBeginTime').change(function(){
       	$('#disEndTime').datepicker('setStartDate', $(this).val());
       })
       $('#disEndTime').change(function(){
       	$('#disBeginTime').datepicker('setEndDate', $(this).val());
       })
       $('#disBeginTime').datepicker(dataPickerOp);
       $('#disEndTime').datepicker(dataPickerOp2);
       $('#disBeginTime').change(function(){
       	$('#disEndTime').datepicker('setStartDate', $(this).val());
       })
       $('#disEndTime').change(function(){
       	$('#disBeginTime').datepicker('setEndDate', $(this).val());
       })
   });
   $(function() {
		$('#amMerchantId').change(function() {
//			console.log($(this).val());
		}).multipleSelect({
			width: '259px'
		});
		/* var usersId = "${item.usersId}";
 		for(var i=0;i<document.getElementById("amMerchantId").options.length;i++){
 			var trimab1 = document.getElementById("amMerchantId").options[i].value;
 			if(usersId.indexOf(trimab1) > 0){
 				document.getElementById("amMerchantId").options[i].selected='selected';
 			}
 		} */
	});
   
   function add(){
	   var usersId=$("#amMerchantId").val();
	   var disStatus = $("#disStatus").val();
	   if(usersId != '' && usersId != null && disStatus == "N"){
		   alert("票券无效");
		   return;
	   }
	   $("#usersId").val(usersId);
	   $("#stafffrom").submit();
	   /* var usersId=$("#amMerchantId").val();
	   var disId = $("#disId").val();
	   if(usersId == null || usersId == ""){
		   alert("请选择用户");
		   return false;
	   } */
	  // window.location.href="${ctx }/cpDiscount/addUsers?disId="+disId+"&&usersId="+usersId;
   }
   </script>
  </body>
</html>
