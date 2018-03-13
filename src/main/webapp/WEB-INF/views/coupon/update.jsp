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
    <link rel="stylesheet" type="text/css" href="${assets }/ticketoo/css/bootstrap.min.css" />
	<link rel="stylesheet" href="${assets }/ticketoo/css/datepicker.min.css" />
	<link rel="stylesheet" href="${assets }/ticketoo/css/layer.css" />
	<link rel="stylesheet" href="${assets }/ticketoo/css/ticketUpdate2.css" />
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
            <li><a href="${ctx }/cptktype/list">优惠券管理</a></li>
            <li class="active">优惠券更新</li>
          </ol>
        </section>

        <!-- Main content -->
        <div class="container-fluid ticketUpdate ">
			<div class="row">
				<div class="tip-img">
					<p>优惠券更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">更新表单</h3>
						<form class="form-inline form-horizontal" id="stafffrom" method="post" action="${ctx }/cpCommodity/update">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeId">优惠券ID <span class="color-red">*</span>:</label>
										<input type="text" class="form-control formConl line-input" id="disId" name="disId" title="不能为空" value="${item.disId}" readonly="readonly" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTicketDes">优惠券描述<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="ccTicketDes" name="ccTicketDes" value="${item.ccTicketDes}"/>
									</div>
								</div>
							</div>
						<%-- 	<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeDesc">优惠券类型 <span class="color-red">*</span>:</label>
										<input type="text" class="form-control formConl line-input" id="ccTypeDesc" name="ccTypeDesc" title="不能为空" value="${item.ccTypeDesc}" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTicketType">使用说明<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="ccTicketType" name="ccTicketType" value="${item.ccTicketType}"/>
									</div>
								</div>
							</div>
							<div class="col-md-12 marginTop">
								<div class="col-md-6">
									<label for="ttStartDate" class="labelWidth">允许售票起始时间<span class="color-red">*</span>：</label>
									<div class="input-group groupDis groupDis2 date ">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input readonly  class="form-control dateWidth" type="text" id="ttStartDate" name="ttStartDate" value="" >
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<label for="ttEndDate" class="labelWidth">允许售票终止时间<span class="color-red">*</span>：</label>
									<div class="input-group groupDis groupDis2 date ">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input readonly  class="form-control dateWidth" type="text" id="ttEndDate" name="ttEndDate" value="" >
									</div>
								</div>
							</div> --%>
							 <div class="col-md-12">           
			                        <div class="col-md-6">
				                         <div class="form-group">
				                            <label>允许售票起始时间<i class="color-red">*</i>：</label>
				                            <div class="input-group">
					                             <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					                            <input class="form-control formConl" path="ttStartDate" id="ttStartDate" data-toggle="datepicker" />
				                            </div>
				                          </div>
			                        </div>
			                        <div class="col-md-6 ">
				                         <div class="form-group">
				                            <label>允许售票终止时间<i class="color-red">*</i>：</label>
				                            <div class="input-group ">
					                             <span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
					                            <input class="form-control formConl" path="ttEndDate" id="ttEndDate" data-toggle="datepicker"/>
				                            </div>
				                        </div>
			                        </div>
                   			 </div>
							
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccListPrice">商品价格:</label>
										<input type="text" class="form-control formConl line-input" id="ccListPrice" name="ccListPrice" title="不能为空" value="${item.ccListPrice }"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeUser">是否上架:</label>
										 <select class="line-input" id="ccTypeStatus" name="ccTypeStatus">
									     	 <option value="Y" ${item.ccTypeStatus eq 'Y' ? 'selected' : ''}>是</option>
						    				 <option value="N" ${item.ccTypeStatus eq 'N' ? 'selected' : ''}>否</option>
									      </select>
									</div>
								</div>
							</div>

						<div class="col-lg-12 col-md-12 submit-group marginTop marginBottom">
							<a type="button" href="${ctx }/cpCommodity/list" class="form-a">&lt;返回</a>
							<div class="btn-group fr">
								<button type="submit" class="btn-size" style="width:110px;" id="addButton">更新</button>
							</div>
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
    <script src="${assets}/datepicker/datepicker.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
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
	        $('#ttStartDate').datepicker(dataPickerOp);
	        $('#ttEndDate').datepicker(dataPickerOp2);
	        $('#ttStartDate').change(function(){
	        	$('#ttEndDate').datepicker('setStartDate', $(this).val());
	        })
	        $('#ttEndDate').change(function(){
	        	$('#ttStartDate').datepicker('setEndDate', $(this).val());
	        })
	        
		}); 
	 	$(document).ready(function(){
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				ttTypeDesc: {
					validators: {
						notEmpty: {
							message: '类型描述不能为空'
							}
					}
 				},
 				
 				ttListPrice: {
					validators: {
						notEmpty: {
							message: '常规价格不能为空'
							}
					}
 				}
 			}
   		}); 	
   		
	});
	
	
	
    
    </script>
    
  </body>
</html>
