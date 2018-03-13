<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 会员卡充值统计</title>
<tags:head_common_content />
<%-- <link rel="stylesheet" type="text/css" href="${assets }/tongji/css/bootstrap.min.css" /> --%>
<link rel="stylesheet" href="${assets }/tongji/css/layer.css" />
<link rel="stylesheet" href="${assets }/tongji/css/model.css" />
<link rel="stylesheet" href="${assets }/tongji/css/manage.css">
<link rel="stylesheet" href="${assets}/gatesManagement/css/datepicker.min.css"/>

</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="rechargelist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<section class="content-header">
				<h1>会员卡充值统计</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">会员卡充值统计</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid reCharge">
				<div class="row outer-wrap">
					<div class="consumecount-tip-img"></div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>
							<form class="form-inline form-horizontal" id="thisform" action="" method="post">
									<div class="col-md-12">
										<div class="col-md-6">
											<div class="form-group">
												<label for="rechargeName">姓名11：</label> <input
													class="form-control formConl line-input" id="cbEmbossname"
													name="cbEmbossname" value="${cbEmbossname }"
													oninput="buttonds()" type="text" placeholder="姓名" />
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="rechargeFlag">状态：</label>
												<!--<input
													class="form-control formConl line-input" type="text"
													placeholder="场馆号" style="margin-left: 50px;" /> -->
												<select class="form-control formConl line-input" id="ctReversalFlag" name="ctReversalFlag" onchange="buttonds()">
									    			<option value="0" ${ ctReversalFlag eq '0' ? 'selected' :''}>正常</option>
	    											<option value="1" ${ ctReversalFlag eq '1' ? 'selected' :''}>已撤销</option>
									   			 </select>
											</div>
										</div>
									</div>
									<div class="col-md-12 marginTop">
										<div class="col-md-6">
											<div class="form-group">
												<label for="rechargeNo">卡号：</label>
												 <input
													class="form-control formConl line-input" id="ctCardNumber"
													name="ctCardNumber" value="${ctCardNumber }"
													placeholder="卡号" oninput="buttonds()" type="text"
													placeholder="卡号" >
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<input type="hidden" id="prProdctGrouptext"
													value="${prProdctGroup }" /> 
												<label for="rechargeType">卡种：</label>
												<select class="consume-select formConl line-input"
													id="prProdctGroup" name="prProdctGroup"
													onchange="buttonds()">
													<option value="">===请选择===</option>
													<c:forEach var="item" items="${prdgrp}">
														<option value="${item.prProdctGroup}">${item.prProdctGroup}-${item.prGroupDesc }</option>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
										<div class="col-md-12 marginTop">
											<div class="col-md-6" style="padding-left:0;">	
												<label for="rechargeStart" class="labelWidth">充值起始时间：</label>											
												<div class="input-group">
													<span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"></span>
													</span>
													<input readonly  class="form-control dateWidth  line-input" id="ctApproveTimeStart" 
													name="ctApproveTimeStart" value="${ctApproveTimeStart }" ><!-- onchange="buttonds()" -->
												</div>
											</div>
											<div class="col-lg-6 col-md-6">	
												<label for="rechargeEnd" class="labelWidth">充值结束时间：</label>										
												<div class="input-group ">
													<span class="input-group-addon">
														<span class="glyphicon glyphicon-calendar"></span>
													</span>
													<input class="form-control dateWidth line-input" readonly="readonly" 
													type="text" size="18" id="ctApproveTimeEnd" value="${ctApproveTimeEnd }" 
													name="ctApproveTimeEnd" onchange="buttonds()">
												</div>
											</div>
									   </div>
									<div class="col-md-12 marginTop">
										<div class="col-md-6">
											<div class="form-group">
												<label for="rechargeUser">操作员：</label>
												<input type="hidden" id="ctUserCreatetext" value="${ctUserCreate }"/>
												<select class="form-control line-input" id="ctUserCreate" name="ctUserCreate" onchange="buttonds()">
													<option value="">===请选择===</option>
									    			<c:forEach var="item" items="${aclUsers}" varStatus="status">
									    			<option value="${item.userId}">${item.userId}-${item.userName }</option>
									    			</c:forEach>
												</select>
											</div>
										</div>
										<div class="col-md-6">
											<div class="form-group">
												<label for="rechargeUserNull" class="col-sm-3 control-label">排除操作员:</label>
												<input type="hidden" id="ctUserCreateNulltext" value="${ctUserCreateNull }"/>
						                        <select class="form-control line-input" id="ctUserCreateNull" name="ctUserCreateNull" onchange="buttonds()">
											    	<option value="">===请选择===</option>
											    	<c:forEach var="item" items="${aclUsers}" varStatus="status">
											    		<option value="${item.userId}">${item.userId}-${item.userName }</option>
											    	</c:forEach>
											    </select>
											</div>
										</div>
									</div>				
									<div class=" submit-group fr">
										 <div class="box-footer">
											<c:if test="${app:checkPermission('RECHARGE_LIST_DOWNLOAD') }">
											<button type="submit"  class="btn-size"
												style="width: 110px; margin: 0 25px 0 15px;" id="downLoad" >下载</button>
											</c:if>
											<button type="submit" class="btn-size btn-info"
												style="width: 110px; margin: 0 25px 0 15px;" id="theIdForSubmit">查询</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					<h3
						style="border-bottom: 2px dashed #DACA99; margin: 15px 15px; line-height: 50px;"
						class="clearfix">查询列表</h3>
					<div class="col-lg-12 col-md-12 clearfix tableContent">
						<div class="checkList">
							<table class="table table-responsive">
								<thead>
									<tr>
										<th>卡号</th>
										<th>卡产品</th>
										<th>姓名</th>
										<th>充值时间</th>
										<th>充值金额</th>
										<th>操作员</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="item" items="${pageInfo.list}"
										varStatus="status">
										<tr>
											<td>${item.ctCardNumber}</td>
											<td>${item.prGroupDesc}</td>
											<td>${item.cbEmbossname}</td>
											<td><tags:format_string patten="####/##/## ##:##:##"
													value="${item.ctApproveTime}" /></td>
											<td>${item.ctBillCurrAmt}</td>
											<td>${item.ctUserCreate}</td>

										</tr>
									</c:forEach>
								</tbody>
							</table>
							<div class="box-footer clearfix">
								<a type="button" href="${ctx }/startTreeviewDetail/tjbb" class="form-a"
										style="margin-left: 25px;">&lt;返回</a>
								<tags:pagination url="${ctx}/recharge/list" queryString="cbEmbossname=${cbEmbossname }&ctReversalFlag=${ctReversalFlag }&ctCardNumber=${ctCardNumber }&prProdctGroup=${prProdctGroup }&ctApproveTimeStart=${ctApproveTimeStart }&ctApproveTimeEnd=${ctApproveTimeEnd }&ctUserCreate=${ctUserCreate }&ctUserCreateNull=${ctUserCreateNull }" page="${pageInfo}" cssClass="pull-right"/>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.content-wrapper -->
	<!-- Main footer -->
	<tags:main_footer />
	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->
	<tags:load_common_js />
	<script src="${assets}/validator/js/validator.js"></script>
	 <script src="${assets}/pdata/pdata.js"></script> 
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
   <%--  <script src="${assets}/datepicker/locales/zh-CN.js"></script>  --%>
	<script type="text/javascript">
	$(function() {
        var dataPickerOp = {
            format: 'yyyy-mm-dd',
            weekStart: 1,
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
        $('#ctApproveTimeStart').datepicker(dataPickerOp);
        $('#ctApproveTimeEnd').datepicker(dataPickerOp2);
        $('#ctApproveTimeStart').change(function(){
        	$('#ctApproveTimeEnd').datepicker('setStartDate', $(this).val());
        })
        $('#ctApproveTimeEnd').change(function(){
        	$('#ctApproveTimeStart').datepicker('setEndDate', $(this).val());
        })
    });
	function buttonds (){
    	//$("#downLoad").attr("disabled",true);
    }
	
			$("#theIdForSubmit").click(function(){
				$("#thisform").attr("action", "${ctx}/recharge/list");
				$("#downLoad").attr("disabled",false);
			});
			$("#downLoad").click(function(){
				$("#thisform").attr("action", "${ctx}/recharge/rechargeDownLoad");
			});
		
	    $(function () {
	    	if($("#prProdctGrouptext").val()==""){
	    		$("#prProdctGroup").val($("#prProdctGroup option:first").val());
	    	}else{
	    		$("#prProdctGroup").val($("#prProdctGrouptext").val());
	    	}
	    	if($("#ctUserCreatetext").val()==""){
	    		$("#ctUserCreate").val($("#ctUserCreate option:first").val());
	    	}else{
	    		$("#ctUserCreate").val($("#ctUserCreatetext").val());
	    	}
	    	if($("#ctUserCreateNulltext").val()==""){
	    		$("#ctUserCreateNull").val($("#ctUserCreateNull option:first").val());
	    	}else{
	    		$("#ctUserCreateNull").val($("#ctUserCreateNulltext").val());
	    	}
	    });
	</script>
</body>
</html>
