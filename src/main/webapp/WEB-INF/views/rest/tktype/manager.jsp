<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 票务信息管理</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets }/ticket/css/layer.css" />
<link rel="stylesheet" href="${assets }/ticket/css/model.css" />
<link rel="stylesheet" href="${assets }/ticket/css/ticketManagement.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />
		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="cptktypelist" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>票务信息管理</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
					<li class="active">票务信息管理</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid gateReviewList ticketMan">
				<div class="row outer-wrap">
					<div class="list-tip-img">
					<p>票务信息管理</p> 
				</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;margin-bottom:25px;">查询表单
								<a class="" href="${ctx}/rest/tktype/add.htm"><span
									class="fr" style="float:right; color:rgb(71,159,222);">+添加</span></a>
							</h3>
							<form id="defaultForm" action="${ctx}/cptktype/list"  method="POST">
								<div class="form-group">
									<div class="col-md-6">
										<label>票种ID：</label> <input
											class="form-control formConl line-input" id="ttTypeId"  name="ttTypeId" placeholder="票种ID" value="${ttTypeId }" type="text" />
									</div>
									<div class="col-md-6">
										<label>票种描述：</label> <input
											class="form-control formConl line-input" id="ttTypeDesc"  name="ttTypeDesc" placeholder="票种描述" value="${ttTypeDesc }" type="text">

									</div>
								</div> 
							<div class="col-md-12 submit-group" style="height:50px;line-height:50px;margin-top:20px;">
								<!--<div class="clearfix"></div>-->
								<div class="fr">
									<button type="submit" class="btn-size" style="width: 110px;line-height:40px;" id="memberShip">查询</button>
								</div>
							</div>
								<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表<span class="fr toggle"></span></h3>
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>票种ID</th>
												<th>票种描述</th>
												<th>允许售票起始时间</th>
												<th>允许售票结束时间</th>
												<th>票务有效周期(天)</th>
												<th>场馆组编号</th>
												<th>常规价格</th>
												<th>是否有效</th>
												<th>操作</th>
											</tr>
										</thead>
										<tbody id="ticketList"></tbody>
									</table>
									<div class="box-footer clearfix">
										<a type="button" href="${ctx }/startTreeviewDetail/ywgl" class="form-a">&lt;返回</a>
										<tags:pagination url="${ctx}/cptktype/list" page="${pageInfo}" cssClass="pull-right"/>
									</div>
								</div>
							</form>
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

	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
	
	<script>
	// 获取票种类型接口
	function getTicketType() {
	    $.ajax({
	        url: "http://localhost:3551/rest/tktype/list",
	        type: "GET",
	        dataType: "json",
	        success: function (data) {
	            console.log(data);
	            if (data.status == "OK") {
	                var list = data.value.list;
	                var list_tbody = "";
	                for (var i in list) {
	                    var status = (list[i].ttTypeStatus == 'Y') ?'有效':'无效';
	                    list_tbody += '<tr>\
	                        <td>'+list[i].ttTypeId+'</td>\
	                        <td>'+list[i].ttTypeDesc+'</td>\
	                        <td>'+list[i].ttStartDate+'</td>\
	                        <td>'+list[i].ttEndDate+'</td>\
	                        <td>'+list[i].ttExpirePeriod+'</td>\
	                        <td>'+list[i].ttAcqListsId+'</td>\
	                        <td>'+list[i].ttListPrice+'</td>\
	                        <td>'+status+'</td>\
	                        <td><div class="btn-toolbar pull-right" role="toolbar"><div class="btn-group"><a href="update.htm?ttTypeId='+list[i].ttTypeId+'">更新</a><a href="view.htm?ttTypeId='+list[i].ttTypeId+'">查看</a><a href="/imgmt/cptktype/delete?ttTypeId=1012" onclick="return confirm("确认删除?")">删除</a></div></td>\
	                    </tr>';
	                }
	                $('#ticketList').append(list_tbody);
	            } else {
	                alert("获取票种ID失败");
	            }
	        },
	        error: function (XMLHttpRequest, textStatus, errorThrown) {
	            alert("error");
	            console.log(XMLHttpRequest + textStatus + errorThrown);
	        }
	    });
	}

	$(document).ready(function () {
	    // 初始化
	    getTicketType();
	    /* setPage(document.getElementById("page"), 2, 1); */
	});
	</script>
</body>
</html>
