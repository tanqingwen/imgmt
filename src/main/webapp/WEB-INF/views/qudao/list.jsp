<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 渠道报表</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" type="text/css"  href="${assets }/tongji/css/manage.css">
<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>
<link rel="stylesheet" type="text/css" href="${assets}/shift/css/bootstrap.min.css" />
<link rel="stylesheet" href="${assets}/shift/css/all.css" />

</head> 
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper" >	
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="financiallist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>渠道报表查询</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">渠道报表</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid financialList">
				<div class="row outer-wrap">
					<div class="tip-img">
						<p>渠道报表查询</p>
						<!-- 	<p>会员等级</p> -->
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form id="defaultForm" name="defaultForm" class="form-horizontal" action="" method="post">
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
										<div class="col-lg-6 col-md-6">	
											<div class="form-group ">
											<label for="ctApproveTimeStart" class="labelWidth">起始时间：</label>										
												<div class="input-group date firstCommission" style="display:inline-table;vertical-align:middle;margin-left:8px;">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly class="form-control line-input" id="ctApproveTimeStart" name="ctApproveTimeStart" 
													class="form-control dateWidth line-input" style="margin-left:0;width:250px;">
													<input type="hidden" id="startTime" name="startTime"> 
												</div>
											</div>
										</div>
										<div class="col-lg-6 col-md-6">	
											<div class="form-group ">
											<label for="ctApproveTimeStart" class="labelWidth">结束时间：</label>										
												<div class="input-group date firstCommission" style="display:inline-table;vertical-align:middle;margin-left:8px;">
													<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
													<input readonly class="form-control line-input" id="ctApproveTimeEnd" name="ctApproveTimeEnd" 
													class="form-control dateWidth line-input" style="margin-left:0;width:250px;">
													<input type="hidden" id="endTime" name="endTime"> 
												</div>
											</div>
										</div>
									</div>
								</div>
								<div class="form-line clearfix">
									<div class="col-lg-12 col-md-12 clearfix ">
										<!-- <div class="col-lg-6 col-md-6">
											<div class="form-group ">
												<label for="">报表种类</label>
												<select class="venueGrade">
													<option value="">请选择报表种类</option>
												</select>
											</div>
										</div>
										<div class="col-lg-6 col-md-6">
	
										</div> -->
									</div>
								</div>
								<div class="col-lg-12 col-md-12">
									<button type="submit" class="btn-size"
										style="width: 110px; margin: 0 25px 0 15px;" id="downLoad">下载
									</button>
									<button class="btn-size fr" type="submit" id="theIdForSubmit">查询</button>
								</div>
								</form>
								<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
								<div class="col-lg-12 col-md-12 clearfix tableContent">
									<div class="checkList">
										<table class="table table-responsive">
											<thead>
												<tr>
													<th>商户</th>
													<th>票类</th>
													<th>票数</th>
													<th>应收金额</th>
													<th>实收金额</th>
													<th>查看</th>
												</tr>
											</thead>
											<tbody>
											 <c:forEach var="var" items="${list }" varStatus="status">
												<tr>
												 <td> 
												<c:if test="${var.cpMercial eq '1' }">微信公众号</c:if> 
												<c:if test="${var.cpMercial eq '2' }">APP</c:if> 
												<c:if test="${var.cpMercial eq '3' }">现场</c:if> 
												<c:if test="${var.cpMercial eq '4' }">官网</c:if> 
												<c:if test="${var.cpMercial eq '5' }">驴妈妈</c:if> 
												<c:if test="${var.cpMercial eq '6' }">携程</c:if> 
												<c:if test="${var.cpMercial eq '7' }">途牛</c:if> 
												<c:if test="${var.cpMercial eq '8' }">同程</c:if> 
												<c:if test="${var.cpMercial eq '9' }">淘宝旅行</c:if> 
												<c:if test="${var.cpMercial eq '10' }">终端</c:if> 
												<c:if test="${var.cpMercial eq '11' }">闸机</c:if> 
												<c:if test="${var.cpMercial eq '12' }">智能pos</c:if> 
												</td> 
													<td>${var.cpTicketName }</td>
													<td>${var.cpTicketSum }</td>
													<td>${var.cpAmountsReceivable }</td>
													<td>${var.cpAmount }</td>
													<td>
														<%-- <a href=" ${ctx }/shift/view/${var.cpShiftId}/${var.cpShiftType } ">查看</a> --%>
														
													</td> 
												</tr>
											</c:forEach> 
											</tbody>
										</table>
									</div>
	
								</div>
	
								<div class="col-md-12  marginBottom">
									<a href="javascript:history.go(-1)" class="form-a">&lt;返回</a>
									<tags:pagination url="${ctx}/qudao/list"   page="${cpShift}" cssClass="pull-right"/>
								</div>
						</div>
					</div>
				</div>
			</div>

			<tags:main_footer />

			<tags:control_sidebar />

		</div>
		<!-- ./wrapper -->
	</div>
	<tags:load_common_js />
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/pdata/pdata.js"></script>
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script type="text/javascript">  
	$(function() {
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
       /*  $('#ctApproveTimeStart').datepicker(dataPickerOp); */
       $('#ctApproveTimeEnd').val( formatDate('${endTimes}'));
       $('#ctApproveTimeStart').val( formatDate('${startTimes}'));
       $('#endTime').val($('#ctApproveTimeEnd').val().split('-').join(""));
       $('#startTime').val($('#ctApproveTimeStart').val().split('-').join(""));
       $('#ctApproveTimeStart,#ctApproveTimeEnd').datepicker(dataPickerOp2);
       $('#ctApproveTimeEnd').change(function(){
        	$('#ctApproveTimeStart').datepicker('setEndDate', $(this).val());
        	var val = $(this).val();
/*         	alert(val); */
        	val = val.split('-').join("");
        	$("#endTime").val(val);
        })
    $('#ctApproveTimeStart').change(function(){
    	$('#ctApproveTimeEnd').datepicker('setStartDate', $(this).val());
    	var val = $(this).val();
/*     	alert(val); */
    	val = val.split('-').join("");
    	$("#startTime").val(val);
    })
});
		$("#theIdForSubmit").click(function() {
			$("#defaultForm").attr("action","${ctx }/qudao/list");
			$("#downLoad").attr("disabled",false);
		});							
		
		$("#downLoad").click(function(){
			$("#defaultForm").attr("action","${ctx}/qudao/isDownLoad");	
		})
		
		$(function() {
			if ($("#ctUserCreatetext").val() == "") {
				$("#ctUserCreate").val($("#ctUserCreate option:first").val());
			} else {
				$("#ctUserCreate").val($("#ctUserCreatetext").val());
			}
		});
		function formatDate(str){
			if(str==''){
				return '';
			}
			else{
             var year = str.substr(0,4);
             var month = str.substr(4,2);
             var day = str.substr(6,2);			
             return year+'-'+month+'-'+day;
			}
            }	
		
	</script>
</body>
</html>
