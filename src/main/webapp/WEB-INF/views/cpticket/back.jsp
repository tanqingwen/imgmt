<%@ page language="java" pageEncoding="UTF-8"
	trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>综合管理系统 |订单退票</title>
<tags:head_common_content />
<link rel="stylesheet" type="text/css"
	href="${assets }/app/css/bounceTicket.css" />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div style="position: absolute;">
		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="cpticketback" />

		<!-- Content Wrapper. Contains page content -->
		<div>
			<div class="content-wrapper">
				<div class="context-tips">
					<tags:action_tip />
				</div>
				<section class="content-header">
					<h1>订单退票</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/pwzy">票务作业</a></li>
						<li class="active">订单退票</li>
					</ol>
				</section>

				<div class="container">
					<div class="row">
						<div class="col-lg-1 col-md-1 text-center lebelT" style="margin-top:-10px;">
							<img src="${assets }/app/img/orderBounce.png" />
						</div>
						<div class="col-lg-11 col-md-11">
							<div class="bounceContent clearfix"
								style="background-color: #fff;">
								<div class="bounceInner">
									<div class="bounceHead">
										<h3>查询订单</h3>
									</div>
									<div class="col-lg-9 ">
										<form class="form-inline">
											<div class="form-group">
												<div class="input-group">
													<input type="text" class="form-control" id="orderNum"
														placeholder="" value="${tkCardNo }">
													<div class="input-group-addon"
														style="border-bottom-right-radius: 5px; border-top-right-radius: 5px; border-color: #00a65a;">
														<input type="hidden" id="cbCardholderNo"
															name="cbCardholderNo" value="${tkCardNo }">
														<button type="button" id="checkOrder" class="btn"
															style="background-color: #00a65a;" onclick="findCard()">读卡
														</button>
													</div>
												</div>
											</div>
										</form>

									</div>


									<div class="col-lg-12 checkTitle">
										<h3 class="">查询列表</h3>
									</div>
									<div class="checkList">
										<table class="table">
											<thead>
												<tr>
													<th>票号</th>
													<th>身份证号</th>
													<th>姓名</th>
													<th>票券种类</th>
													<th>购票日期</th>
													<th>失效日期</th>
													<th>最近入园日期</th>
													<th>最近离园日期</th>
													<th>状态</th>
													<th>选择</th>

												</tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}">
													<tr>
														<td>${item.tkTicketId}</td>
														<td>${item.credentyNumber}</td>
														<td>${item.credentyName}</td>
														<td>${item.ticketName}</td>
														<td>${item.tkEffectiveDate}</td>
														<td>${item.tkExpireDate}</td>
														<td>${item.tkActiveDate}</td>
														<td>${item.tkRetriveDate}</td>
														<td><c:if test="${item.tkStatus=='T'}">未入闸</c:if> <c:if
																test="${item.tkStatus=='U'}">已入闸</c:if> <c:if
																test="${item.tkStatus=='F'}">已出闸</c:if> <c:if
																test="${item.tkStatus=='E'}">已失效</c:if> <c:if
																test="${item.tkStatus=='R'}">已退票</c:if></td>
														<td>
															<div class="btn-toolbar pull-right" role="toolbar">
																<div class="btn-group">
																	<c:if test="${item.tkStatus ne 'R'}">
																		<input type="checkbox" value="${item.tkTicketId}"
																			name="rsManagement" aa="${item.tkStatus }"
																			class="check">
																	</c:if>
																</div>
															</div>
														</td>
													</tr>
												</c:forEach>
											</tbody>
										</table>
									</div>
									<div class="col-lg-12 text-right" style="margin:20px 0 30px 0;">
										<button class="btn bounceBtn">退票</button>
									</div>
									<div class="box-footer clearfix" style="margin-bottom:30px;">
										<a href="${ctx }/startTreeviewDetail/pwzy"> &lt;返回 </a>
										<tags:pagination
											url="${ctx}/cpticket/back?tkCardNo=${tkCardNo }"
											page="${pageInfo}" cssClass="pull-right" />
									</div>
									
									<!--mark-->
									<div class="markbox" style="display: none;"></div>
									<div class="mark1" style="display: none;">
										<div class="close">
											<span><img src="${assets }/app/img/关闭.png" /></span>
										</div>
										<form class="form-horizontal all text-center">
											<div class="form-group text-center">
												<label for="Authorization"
													class="col-sm-1  col-lg-2 text-center">授权码</label>
												<div class="col-sm-4 col-lg-4 clearMargin">
													<input type="text" class="form-control" id="Authorization">
												</div>
											</div>
										</form>
										<!--<div class="all"><label for="">授权码</label><input type="text" id="Authorization " /></div>-->
										<div class="bounceSure">
											<button class="btn btn-sure">确定</button>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!-- Main footer -->
				<tags:main_footer />

				<!-- Control Sidebar -->
				<tags:control_sidebar />

			</div>
		</div>
	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>
<script src="${assets}/app/js/app.js"></script>
<script>
	function findCard(){
	    readCardNo("cbCardholderNo");
		var cardNo=$("#cbCardholderNo").val();
		if(cardNo=="undefined" || cardNo==""){
			$("#cbCardholderNo").val("");
			return;
		}
		cardNo="<%=Constants.baseBIN%>" + cardNo;
		console.log(cardNo);
		//var cardNo = '3501000100308076';
		window.location.href = "${ctx}/cpticket/back?tkCardNo=" + cardNo;

	}
	function tuipiao(rsManagement) {
		$.ajax({
			url : '${ctx}/cpticket/doRemove',
			type : 'post',
			data : {
				'rsManagement' : rsManagement
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					location.href = "${ctx}/cpticket/back";
					return;
				}
				alert("退票成功");
			}
		});
	}

	$(function() {
		$(".btn-sure").click(function() {
			var authCode = $("#Authorization").val();
			console.log(authCode);
			if (authCode != '123456') {
				alert("授权码暂时为  123456,请输入正确的授权码");
				return;
			}
			var rsManagement = '';
			$("input[class='check']:checked").each(function() {
				var ticketId = $(this).val();
				rsManagement += ticketId + ",";
			});
			tuipiao(rsManagement);

		});
		$(".close").click(function() {
			$(".markbox").hide();
			$(".mark1").hide();
		});
		$(".markbox").click(function() {
			$(".markbox").hide();
			$(".mark1").hide();
		});
		$(".bounceBtn").click(
				function() {
					var rsManagement = '';
					var statusArr = '';
					$("input[class='check']:checked").each(function() {
						var status = $(this).attr("aa");
						statusArr += status;
						var ticketId = $(this).val();
						rsManagement += ticketId + ",";
					});
					if ((statusArr.indexOf('U') != -1)
							|| (statusArr.indexOf('E') != -1)
							|| (statusArr.indexOf('F') != -1)) {
						$("#Authorization").val('');
						$(".markbox").show();
						$(".mark1").show();
						$(".bounceSure").click(function() {
							$(".markbox").hide();
							$(".mark1").hide();
						})
					} else {
						tuipiao(rsManagement);
					}

				})
	})
</script>

</html>