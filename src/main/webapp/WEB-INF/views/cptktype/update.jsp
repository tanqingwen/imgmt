<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 票务信息更新</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
	<link rel="stylesheet" href="${assets }/ticketoo/css/layer.css" />
	<link rel="stylesheet" href="${assets }/css/datepicker.min.css" />
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
          <h1>票务信息更新</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/cptktype/list">票务信息管理</a></li>
            <li class="active">票务信息更新</li>
          </ol>
        </section>

        <!-- Main content -->
        <div class="container-fluid ticketUpdate ">
			<div class="row">
				<div class="tip-img">
					<p>票务信息更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">更新表单</h3>
						<form class="form-inline form-horizontal" id="stafffrom" method="post" action="${ctx }/cptktype/update">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttTypeId">票种ID <span class="color-red">*</span>:</label>
										<input type="text" class="form-control formConl line-input" id="ttTypeId" name="ttTypeId" title="不能为空" value="${item.ttTypeId}" readonly="readonly" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttTypeDesc">票种描述<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="ttTypeDesc" name="ttTypeDesc" value="${item.ttTypeDesc}"/>
									</div>
								</div>
							</div>
							<div class="col-md-12 marginTop" style="margin-top:20px;">
								 <div class="col-md-6">
									<label for="ttStartDate" class="labelWidth">允许售票起始时间<span class="color-red">*</span>：</label>
									 <div class="input-group groupDis groupDis2 date ">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input readonly  class="form-control dateWidth" type="text" id="ttStartDate" name="ttStartDate" value="${item.ttStartDate}" onchange="countttExpirePeriod()" >
									</div> 
								</div>
								<div class="col-lg-6 col-md-6">
									<label for="ttEndDate" class="labelWidth">允许售票终止时间<span class="color-red">*</span>：</label>
									<div class="input-group groupDis groupDis2 date ">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input readonly  class="form-control dateWidth" type="text" id="ttEndDate" name="ttEndDate" value="${item.ttEndDate}" onchange="countttExpirePeriod()" >
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttExpirePeriod">票务有效周期(天) <span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="ttExpirePeriod" name="ttExpirePeriod" value="${item.ttExpirePeriod}" readonly="readonly" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttAcqListsId">场馆组<span class="color-red">*</span>:</label>
										<select id="ttAcqListsId" name="ttAcqListsId" class="line-input">
										<c:forEach var="items" items="${cpAcqmer}">
								     		<option value="${items.amGroupId }" ${items.amGroupId eq item.ttAcqListsId ? 'selected' : ''}>${items.amGroupId }-${items.amUserDefine1 }</option>
								     	</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttListPrice">常规价格:</label>
										<input type="text" class="form-control formConl line-input" id="ttListPrice" name="ttListPrice" title="不能为空" value="${item.ttListPrice}" onchange="changettListPrice()" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttTypeUser">使用规则:</label>
										<select id="ttTypeUser" name="ttTypeUser" class="line-input">
										 <option value=" " ${item.ttTypeUser eq '' ? 'selected' : ''}>实名制</option>
					    				 <option value="V" ${item.ttTypeUser eq 'V' ? 'selected' : ''}>非实名</option>
										</select>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttTypeUser">是否有效:</label>
										 <select class="line-input" id="ttTypeStatus" name="ttTypeStatus">
								     	 <option value="Y" ${item.ttTypeStatus eq 'Y' ? 'selected' : ''}>有效</option>
					    				 <option value="N" ${item.ttTypeStatus eq 'N' ? 'selected' : ''}>无效</option>
								      </select>
									</div>
								</div>
							</div>

						<div class="col-lg-12 submit-group marginTop marginBottom">
							<a type="button" href="${ctx }/cptktype/list" class="form-a">&lt;返回</a>
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
   	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
    $(function() {
		 var dataPickerOp = {
			        format: 'yyyy-mm-dd',
			        weekStart: 1,
			        startDate:new Date(),
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
			    $('#ttStartDate').datepicker(dataPickerOp);
			    $('#ttEndDate').datepicker(dataPickerOp2);
			    $('#ttStartDate').change(function(){
			    	$('#ttEndDate').datepicker('setStartDate', $(this).val());
			    })
			    $('#ttEndDate').change(function(){
			    	$('#ttStartDate').datepicker('setEndDate', $(this).val());
			    })
	});
    function countttExpirePeriod(){
    	var ttStartdate = $("#ttStartDate").val();
		var ttEnddate = $("#ttEndDate").val();
		if(ttStartdate != "" && ttEnddate != ""){
			if(Number(ttStartdate)>Number(ttEnddate)){
				$("#ttExpirePeriod").val("无效");
				return false;
			}
		}
		
		var formatStart=ttStartdate.replace(/^(\d{4})(\d{2})(\d{2})$/, "$1-$2-$3");
		var formatEnd=ttEnddate.replace(/^(\d{4})(\d{2})(\d{2})$/, "$1-$2-$3");
		var days = DateDiff(formatStart,formatEnd);
		// 票务有效周期
		$("#ttExpirePeriod").val(days);
    }
    
    
  //票券周期
    function  DateDiff(sDate1,  sDate2){    //sDate1和sDate2是2006-12-18格式  
        var  aDate,  oDate1,  oDate2,  iDays;  
        aDate  =  sDate1.split("-");  
        oDate1  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0])    //转换为12-18-2006格式  
        aDate  =  sDate2.split("-");  
        oDate2  =  new  Date(aDate[1]  +  '-'  +  aDate[2]  +  '-'  +  aDate[0]);  
        iDays  =  parseInt(Math.abs(oDate1  -  oDate2)  /  1000  /  60  /  60  /24);    //把相差的毫秒数转换为天数  
        return  iDays;  
    } 
    
    function changettListPrice(){
    	countttDiscountPrice1();
    	countttDiscountPrice2();
    }
    //普通折扣价
    function countttDiscountPrice1(){
    	var ttListPrice = $("#ttListPrice").val();//常规价格
		var ttDiscountRate1 = $("#ttDiscountRate1").val();//普通折扣率
		$("#ttDiscountPrice1").val(ttListPrice*ttDiscountRate1);//普通折扣价
    }
    //特别折扣价
    function countttDiscountPrice2(){
    	var ttListPrice = $("#ttListPrice").val();//常规价格
		var ttDiscountRate2 = $("#ttDiscountRate2").val();//特别折扣率
		$("#ttDiscountPrice2").val(ttListPrice*ttDiscountRate2);//特别折扣价
    }
    
	$(document).ready(function(){
		
		
		
		$("#addButton").click(function(){
		    var ttStartdate = $("#ttStartDate").val();
			var ttEnddate = $("#ttEndDate").val();
			if(ttStartdate != "" && ttEnddate != ""){
				if(Number(ttStartdate)>Number(ttEnddate)){
					alert("售票起始时间不可以大于售票结束时间！");
					return false;
				}
			}
		});
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
 				ttStartDate: {
					validators: {
						notEmpty: {
							message: '请选择允许售票起始时间'
							}
					}
 				},
 				ttEndDate: {
					validators: {
						notEmpty: {
							message: '请选择允许售票结束时间'
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
	
	$(function () {
		$("#updateButten").click(function(){
			var role=document.getElementsByName("roles"); 
			var m=0; var n=false; 
			for(var i=0;i<role.length;i++){ 
				if(role[i].checked){ 
					n=true; m++;
				}
			}
			if(!n){
				alert("请至少选择一个用户角色");
				//role[0].checked = true;
				return false;
			}
		});
	});
    
	
    
    </script>
    
  </body>
</html>
