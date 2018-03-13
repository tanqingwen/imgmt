<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<%@ page import="cn.happyworlds.imgmt.to.Constants"%>

<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 |订单退票</title>
		<tags:head_common_content/>
		<link rel="stylesheet" type="text/css" href="${assets }/app/css/bounceTicket.css" />
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini"  >
	<div style="position: absolute;">
		<jsp:include flush="true" page="/WEB-INF/tags/IDM10.jsp"></jsp:include>
		<jsp:include flush="true" page="/WEB-INF/tags/RFEYEU010.jsp"></jsp:include>
	</div>
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="cpticketback"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div >
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>

		<div class="container">
			<div class="row">
				<div class="col-lg-1 col-md-1 text-center lebelT"><img src="${assets }/app/img/orderBounce.png" /></div>
				<div class="col-lg-11 col-md-11">
					<div class="bounceContent clearfix">
						<div class="bounceInner">
							<div class="bounceHead">
								<h3>查询订单</h3>
							</div>
							<div class="col-lg-9 ">
								<form class="form-inline">
									<div class="form-group">
										<div class="input-group">
											<input type="text" class="form-control" id="orderNum" placeholder="">
											<div class="input-group-addon">
											<input type="hidden" id="cbCardholderNo" name="cbCardholderNo" value="">
											<button type="button" id="checkOrder" class="btn btn-blue" onclick="findCard()"/>读卡</button>
											</div>
										</div>
									</div>
								</form>
								
							</div>
							<div class="col-lg-3 ">
								<div class="bounceBack text-right">
									<a href="JavaScript:history.Go(-1)">
									&it;返回 </a>
								</div>
							</div>

							<div class="col-lg-12 checkTitle">
								<h3 class="">查询列表</h3></div>
							<div class="checkList">
								<table class="table">
									<thead>
										<tr>
											<th>票号</th>
											<th>卡号</th>
											<th>票券种类</th>
											<th>生效日期</th>
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
				                                    <td>${item.tkCardNo}</td>
				                                    <td>${item.ticketName}</td>
				                                    <td>${item.tkEffectiveDate}</td>
				                                    <td>${item.tkExpireDate}</td>
				                                    <td>${item.tkActiveDate}</td>
				                                    <td>${item.tkRetriveDate}</td>
				                                    <td>
				                                    <c:if test="${item.tkStatus=='T'}">待使用</c:if>
				                                    <c:if test="${item.tkStatus=='U'}">使用中</c:if>
				                                    <c:if test="${item.tkStatus=='F'}">使用完成</c:if>
				                                    <c:if test="${item.tkStatus=='E'}">过期</c:if>
				                                    <c:if test="${item.tkStatus=='R'}">退单</c:if>
				                                    </td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<input type="checkbox" value="${item.tkTicketId}" name="rsManagement">
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="box-footer clearfix">
								<tags:pagination url="${ctx}/cpticket/back" page="${pageInfo}" cssClass="pull-right"/>
								</div>
							<div class="col-lg-12 text-right  btnMargin"><button class="btn bounceBtn">退票</button></div>
							<!--mark-->
							<div class="markbox" style="display:none;"></div>
							<div class="mark1" style="display:none;">
								<div class="close">
									<span><img src="${assets }/app/img/关闭.png" /></span>
								</div>
								<form class="form-horizontal all text-center">
									<div class="form-group text-center">
										<label for="Authorization" class="col-sm-1  col-lg-2 text-center">授权码</label>
										<div class="col-sm-4 col-lg-4 clearMargin">
											<input type="text" class="form-control" id="Authorization">
										</div>
									</div>
								</form>
								<!--<div class="all"><label for="">授权码</label><input type="text" id="Authorization " /></div>-->
								<div class="bounceSure"><button class="btn ">确定</button></div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>

	</body>
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
		$.ajax({
			type : "POST",
			url : "${ctx}/cpticket/ticket/queryByCardNo",
			dataType : "json",
			data : {
				cardNo : cardNo
			},
			success : function(data) {
				if(data.status='SUCCESS'){
					var  tickets = data.value;
					for(var i=0;i<tickets.length;i++){
						$("tbody").empty().append("<tr><td>"+tickets[i].tkTicketId+"</td><td>"+tickets[i].tkCardNo+"</td><td>"+tickets[i].ticketName+"</td><td>"+tickets[i].tkEffectiveDate+"</td><td>"+tickets[i].tkExpireDate+"</td><td>"+tickets[i].tkActiveDate+"</td></tr>");
					}
				
				}
				
			}
		});
	}
	
	
		$(function() {
			$(".close").click(function() {
				$(".markbox").hide();
				$(".mark1").hide();
			});
			$(".markbox").click(function() {
				$(".markbox").hide();
				$(".mark1").hide();
			});
			$(".bounceBtn").click(function() {
				$("input[class='check']:checked").each(function() {
					var a = $(this).parent().siblings(".status").text();
					console.log(a);
					$(this).parent().siblings(".status").text("已退票");
					$(this).css('display', 'none');
					if(a == "已使用") {
						$(".markbox").show();
						$(".mark1").show();
						$(".bounceSure").click(function() {
							$(".markbox").hide();
							$(".mark1").hide();
						})
					}

				});

			})
		})
	</script>

</html>