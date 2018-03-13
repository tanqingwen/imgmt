<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 财务报表下载</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
</head>
<script src="http://cdn.bootcss.com/jquery/1.11.3/jquery.min.js"></script>
<body class="hold-transition skin-blue-light sidebar-mini"
	onload="getNowFormatDate()">
	<div class="wrapper">
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
				<h1>财务报表下载</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
					<li class="active">财务报表下载</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-search"></i> 查询表单
						</h3>

					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form id="thisform" class="form-horizontal" id="thisform" action=""
						method="post">
						<div class="box-body">
							<div class="col-sm-6">
								<div class="form-group date firstCommission">
									<label for="ctApproveTimeStart" class="col-sm-3 control-label">起始时间
									</label>
									<div class="col-sm-7">
										<div class="input-group date firstCommission">
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span> <input readonly class="form-control" id="ctApproveTimeStart"
												name="ctApproveTimeStart" value="${ctApproveTimeStart }"
												onchange="buttonds()" style="width: 133.5%" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group date firstCommission">
									<label for="ctApproveTimeEnd" class="col-sm-3 control-label">结束时间
									</label>
									<div class="col-sm-7">
										<div class="input-group date firstCommission">
											<span class="input-group-addon"> <span
												class="glyphicon glyphicon-calendar"></span>
											</span> <input readonly class="form-control" id="ctApproveTimeEnd"
												name="ctApproveTimeEnd" value="${ctApproveTimeEnd }"
												onchange="buttonds()" style="width: 133.5%" />
										</div>
									</div>
								</div>
							</div>
							<!-- 		                  	<div class="col-sm-6"> -->
							<!-- 			                    <div class="form-group"> -->
							<!-- 			                      <label for="ctCardNumber" class="col-sm-3 control-label">卡号</label> -->
							<!-- 			                      <div class="col-sm-9"> -->
							<%-- 			                        <input class="form-control" id="ctCardNumber" name="ctCardNumber" placeholder="卡号" value="${ ctCardNumber}" oninput="buttonds()" type="text"> --%>
							<!-- 			                      </div> -->
							<!-- 			                    </div> -->
							<!-- 		                    </div> -->
							<div class="col-sm-6">
								<div class="form-group">
									<label for="ctTranCode" class="col-sm-3 control-label">操作类型</label>
									<div class="col-sm-9">
										<select class="form-control" id="classes"
											onchange="buttonds()" name="classes">
											<option value="" ${classes eq '' ? 'selected' : ''}>全部</option>
											<option value="zc" ${classes eq 'zc' ? 'selected' : ''}>资产</option>
											<option value="fz" ${classes eq 'fz' ? 'selected' : ''}>负债</option>
											<option value="gtong" ${classes eq 'gtong' ? 'selected' : ''}>共同</option>
											<option value="qy" ${classes eq 'qy' ? 'selected' : ''}>权益</option>
											<option value="cb" ${classes eq 'cb' ? 'selected' : ''}>成本</option>
											<option value="sy" ${classes eq 'sy' ? 'selected' : ''}>损益</option>
										</select>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<div class="pull-right">
								<button type="submit" class="btn btn-info " id="theIdForSubmit">
									<i class="fa fa-search"></i> 查询
								</button>
								<a type="button" class="btn btn-info" href="${ctx }/"><i
									class="glyphicon glyphicon-chevron-left"></i> 返回</a>
								<c:if test="${app:checkPermission('FINANCIAL_LIST_DOWNLOAD') }">
									<button type="submit" class="btn btn-info " id="downLoad">
										<i class="fa fa-search"></i> 下载
									</button>
								</c:if>
							</div>
						</div>
						<!-- /.box-footer -->
					</form>
				</div>
				<!-- /.box -->

				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">
									<i class="fa fa-list"></i> 查询列表
								</h3>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table table-striped">
										<thead>
											<tr>
												<!-- 											        <th>序号</th> -->
												<th>级次</th>
												<th>科目编码</th>
												<th>科目名称</th>
												<!-- 				                                    <th>类别</th> -->
												<th>币种</th>
												<th>金额</th>
												<th>批注</th>
												<!-- <th class="text-right">操作</th> -->
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}"
												varStatus="status">
												<tr>
													<%-- 													<td>${(pageInfo.pageNum-1)*pageInfo.pageSize+(status.index+1)}</td> --%>
													<td>${item.level}</td>
													<td>${item.subjectCode}</td>
													<td>${item.subjectName}</td>
													<%-- 				                                    <td>${item.classes}</td> --%>
													<td>${item.currency}</td>
													<td>${item.money}</td>
													<td>${item.postil}</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- /.box-body -->

							<div class="box-footer clearfix">
								<tags:pagination url="${ctx }/financial/list" page="${pageInfo}"
									queryString="ctApproveTimeStart=${ ctApproveTimeStart}&ctApproveTimeEnd=${ctApproveTimeEnd }&classes=${classes }"
									cssClass="pull-right" />
							</div>
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main footer -->
		<tags:main_footer />

		<!-- Control Sidebar -->
		<tags:control_sidebar />

	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script src="${assets}/pdata/pdata.js"></script>
	<script type="text/javascript">
	    function buttonds (){
	    	$("#downLoad").attr("disabled",true);
	    }
		$(document).ready(function(){
			$('.firstCommission').datepicker({
	   			format: 'yyyymmdd',
				autoclose: true
	   		});
			$("#theIdForSubmit").click(function(){
				var mmAgreementStartDate = $("#ctApproveTimeStart").val();
				var mmAgreementEndDate = $("#ctApproveTimeEnd").val();
				if(mmAgreementStartDate != "" && mmAgreementEndDate != ""){
					if(Number(mmAgreementStartDate)>Number(mmAgreementEndDate)){
						alert("起始时间不可以大于结束时间！");
						return false;
					}
				}
				$("#thisform").attr("action", "${ctx }/financial/list");
				$("#downLoad").attr("disabled",false);
			});
			$("#downLoad").click(function(){
				$("#thisform").attr("action", "${ctx}/financial/listDownLoad");
			});
		});
		$(function () {
	    	if($("#ctUserCreatetext").val()==""){
	    		$("#ctUserCreate").val($("#ctUserCreate option:first").val());
	    	}else{
	    		$("#ctUserCreate").val($("#ctUserCreatetext").val());
	    	}
	    });
	    </script>

</body>
</html>
