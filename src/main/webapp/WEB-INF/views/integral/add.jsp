<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 积分添加</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="profile"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>积分添加</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">积分管理</a></li>
            <li class="active">积分添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/integral/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
	                			<div class="form-group">
								    <label for="hwMemberId" class="col-sm-3 control-label">会员ID<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwMemberId" name="hwMemberId" title="不能为空" value="${item.hwMemberId}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwIntegralType" class="col-sm-3 control-label">积分类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select id="hwIntegralType" name="hwIntegralType" class="form-control" >
								                <option value="">请选择</option>
									    		<option value="01" ${item.hwIntegralType eq '01' ? 'selected':''}>购票</option>
									    		<option value="02" ${item.hwIntegralType eq '02' ? 'selected':''}>消费</option>
									    		<option value="03" ${item.hwIntegralType eq '03' ? 'selected':''}>充值</option>
									    		<option value="04" ${item.hwIntegralType eq '04' ? 'selected':''}>奖励</option>
									    	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwAvailableIntegral" class="col-sm-3 control-label">可用积分<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwAvailableIntegral" name="hwAvailableIntegral" value="${item.hwAvailableIntegral}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwExchangeIntegral" class="col-sm-3 control-label">已兑换积分<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwExchangeIntegral" name="hwExchangeIntegral" value="${item.hwExchangeIntegral}"/>
								    </div>
								</div>
							</div>
                		</div>
						<div class="col-sm-6">
                			<div class="row">
								<div class="form-group">
								    <label for="hwExchangeDate" class="col-sm-3 control-label">兑换日期<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwExchangeDate" name="hwExchangeDate" value="${item.hwExchangeDate}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwExchangeRecord" class="col-sm-3 control-label">兑换记录ID<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwExchangeRecord" name="hwExchangeRecord" value="${item.hwExchangeRecord}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwPeriodDate" class="col-sm-3 control-label">有效期<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwPeriodDate" name="hwPeriodDate" value="${item.hwPeriodDate}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwPeriodDate" class="col-sm-3 control-label">2323有效期<font color="red">*</font></label>
								    <div class="col-sm-8">
									    <select id="hwPeriodDate" name="hwPeriodDate">
								            <option value="">请选择</option>
								            <option value="1">一周前</option>
								            <option value="2">一个月前</option>
								            <option value="3">三个月前</option>
								            <option value="4">半年前</option>
								            <option value="5">一年前</option>
								            <option value="6">一年后</option>
								        </select>
								        <input type="text" id="stime" value="选择的时间"/>
								        <input type="text" id="etime" >
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwIntegralStatus" class="col-sm-3 control-label">状态<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select id="hwIntegralStatus" name="hwIntegralStatus" class="form-control" >
								                <option value="">请选择</option>
									    		<option value="1" ${item.hwIntegralStatus eq '01' ? 'selected':''}>可用</option>
									    		<option value="2" ${item.hwIntegralStatus eq '02' ? 'selected':''}>部分兑换</option>
									    		<option value="3" ${item.hwIntegralStatus eq '03' ? 'selected':''}>已兑换</option>
									    	</select>
								    </div>
								</div>
                			</div>
                		</div>
                		
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
							<button id="addButton" type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 添加</button>	                    	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/integral/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                    </div>	                 	
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
			</section>
        </div><!-- /.box -->
        <!-- /.content -->
      </div><!-- /.content-wrapper -->
      <tags:main_footer/>

      <!-- Control Sidebar -->
      <tags:control_sidebar/>
  		<!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
    <script src="${assets}/jquery/jquery.min.js"></script>
    <script type="text/javascript">
	$(document).ready(function(){
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				 id: {
 					message: '员工ID无效',
					validators: {
						notEmpty: {
							message: '员工ID无效'                  
						},
						stringLength: {
							min: 0,
							max: 20,
							message: '员工ID无效不能超过20个字符'       
							},
					}
 				}, 
 				cbCustomerIdno: {
					validators: {
						notEmpty: {
							message: '身份证号不能为空'
							}
					}
 				},
 				organizations: {
 					validators: {
 						notEmpty: {
							message: '员工机构不能为空'
							}
 					}
 				},
 				name: {
 					validators: {
 						notEmpty: {
							message: '员工姓名不能为空'
							}
 					}
 				},
 				email: {
 					validators:{
 						regexp: {
 							regexp: /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+.+[a-z]{2,4}$/,
 							message: '请输入正确邮箱地址'
 						}
 					}
 				},
 				cbMobileNo: {
 					validators:{
 						regexp: {
	 						regexp: /^[0-9]{1,11}$/,
	 						message: '请输入正确的手机号码'
	 					}
 					}
 				}
 			}
		});
	});
	
	function $(id){
        return typeof id == 'string' ? document.getElementById(id) : id;
    }
    var s = $('stime');
    var e = $('etime');
    $('time').onchange = function(){
        var d = new Date();
        e.value = d.toLocaleString().replace(/年|月/g, '-').replace('日', '');
        switch( +this.value ){
            case 1:
                s.value = setTime(d, {type:'d', value: -7});
                break;
            case 2:
                s.value = setTime(d, {type:'M', value: -1});
                break;
            case 3:
                s.value = setTime(d, {type:'M', value: -3});
                break;
            case 4:
                s.value = setTime(d, {type:'M', value: -6});
                break;
            case 5:
                s.value = setTime(d, {type:'y', value: -1});
                break;
            case 6:
                s.value = setTime(d, {type:'y', value: 1});
                break;
        }
    }
     
    function setTime(d, opts){
        if(!d) return;
        var t = opts.type || 'd',
            v = opts.value || 1;
        switch( t ){
            case 'y':
                d.setFullYear( d.getFullYear() + v );
                break;
            case 'M':
                d.setMonth( d.getMonth() + v );
                break;                       
            case 'd':
                d.setDate( d.getDate() + v );
                break;
            case 'h':
                d.setHours( d.getHours() + v );
                break;
            case 'm':
                d.setMinutes( d.getMinutes() + v );
                break;
            case 's':
                d.setSeconds( d.getSeconds() + v );
                break;                       
        }
        return d.toLocaleString().replace(/年|月/g, '-').replace('日', '');
    }
    
	
	
    </script>
  </body>
</html>
