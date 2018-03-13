<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 优惠券添加</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets }/ticketoo/css/layer.css" />
<link rel="stylesheet" href="${assets }/ticketoo/css/ticketUpdate2.css" />
<link rel="stylesheet"
	href="${assets}/gatesManagement/css/datepicker.min.css" />
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
				<h1>优惠券添加</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
					<li><a href="${ctx }/cptktype/list">优惠券管理</a></li>
					<li class="active">优惠券添加</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid ticketUpdate common Coupon">
				<div class="row">
					<div class="tip-img">
						<p style="line-height:35px;font-size:20px;width:15px;">优惠券添加</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">添加表单</h3>
							<form class="form-inline form-horizontal" id="stafffrom"
								method="post" action="${ctx }/cpDiscount/add"
								enctype="multipart/form-data">
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>优惠券ID <span class="color-red">*</span>:
											</label> <input class="form-control formConl line-input" type="text"
												id="disId" name="disId" readonly="readonly"
												value="${disId }" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="ccTicketDes">优惠券描述<span class="color-red">*</span>:
											</label> <input class="form-control formConl line-input" type="text"
												id="disDesc" name="disDesc" value="" />
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label for="ccTypeDesc">优惠券类型 <span class="color-red">*</span>:
											</label> <input type="text" class="form-control formConl line-input"
												id="disType" name="disType" title="不能为空" value="" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="ccListPrice">优惠券金额<span class="color-red">*</span>:
											</label> <input type="text" class="form-control formConl line-input"
												id="disMoney" name="disMoney" title="不能为空" value="" />
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>允许售票起始时间<i class="color-red">*</i>：
											</label>
											<div class="input-group">
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-calendar"></i></span> <input
													class="form-control formConl line-input" type="text"
													id="ttStartDate" name="disBeginTime" value=""
													onchange="countttExpirePeriod()" style="margin-left: 0px;" />
											</div>
										</div>
									</div>
									<div class="col-md-6 ">
										<div class="form-group">
											<label>允许售票终止时间<i class="color-red">*</i>：
											</label>
											<div class="input-group ">
												<span class="input-group-addon"><i
													class="glyphicon glyphicon-calendar"></i></span> <input
													class="form-control formConl line-input" type="text"
													id="ttEndDate" name="disEndTime" value=""
													onchange="countttExpirePeriod()" style="margin-left: 0px;" />
											</div>
										</div>
									</div>
								</div>
								<!-- <div class="col-md-12 marginTop">
								<div class="col-md-6">
									<label for="ttStartDate" class="labelWidth">允许售票起始时间<span class="color-red">*</span>：</label>
									<div class="input-group groupDis groupDis2 date ">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input   class="form-control dateWidth" type="text" id="ttStartDate" name="disBeginTime" value="" onchange="countttExpirePeriod()">
									</div>
								</div>
								<div class="col-lg-6 col-md-6">
									<label for="ttEndDate" class="labelWidth">允许售票终止时间<span class="color-red">*</span>：</label>
									<div class="input-group groupDis groupDis2 date ">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input   class="form-control dateWidth" type="text" id="ttEndDate" name="disEndTime" value="" onchange="countttExpirePeriod()"  >
									</div>
								</div>
							</div>
							 -->
								<div class="col-md-12">

									<div class="col-md-6">
										<div class="form-group">
											<label for="ccTypeUser">是否有效<span class="color-red">*</span>:
											</label> <select class="line-input" id="disStatus" name="disStatus">
												<option value="Y">是</option>
												<option value="N">否</option>
											</select>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="ccListPrice">优惠券图片<span class="color-red">*</span>:
											</label>
											<div class="z_photo upimg-div clear a-upload">
												<input type="file" name="file" value="" />
											</div>
										</div>
									</div>
								</div>

								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label>使用说明<span class="color-red">*</span>:
											</label>
											<textarea rows="10" cols="30"  id="disService" name="disService" style="width: 256px;margin-left: 10px;vertical-align: top;border: lightblue 1px solid;border-radius: 5px;"></textarea>
											<!-- <input class="form-control formConl line-input" type="text"
												id="disService" name="disService" value="" /> -->
										</div>
									</div>

									<div class="col-md-6"></div>
								</div>
								<div class="col-lg-12 submit-group marginTop marginBottom">
									<a href="${ctx }/cpDiscount/list" class="form-a" type="button">&lt;返回</a>
									<div class="btn-group fr">
										<button type="submit" class="btn-size" style="width: 110px;"
											id="addButton" onclick="return isnull()">添加</button>
									</div>
								</div>
							</form>

						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- /.box -->
		<!-- /.content -->
	</div>
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/gatesManagement/js/datepicker.min.js"></script>
	<script src="${assets}/validator/js/validator.js"></script>
	<script type="text/javascript">
		$(function() {
			var dataPickerOp = {
				format : 'yyyy-mm-dd',
				startDate:new Date(),
				weekStart : 1,
				days : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
				daysShort : [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
				daysMin : [ '日', '一', '二', '三', '四', '五', '六' ],
				months : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				monthsShort : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
						'9月', '10月', '11月', '12月' ],
				autoHide : true
			};
			var dataPickerOp2 = {
				format : 'yyyy-mm-dd',
				weekStart : 1,
				days : [ '星期日', '星期一', '星期二', '星期三', '星期四', '星期五', '星期六' ],
				daysShort : [ '周日', '周一', '周二', '周三', '周四', '周五', '周六' ],
				daysMin : [ '日', '一', '二', '三', '四', '五', '六' ],
				months : [ '一月', '二月', '三月', '四月', '五月', '六月', '七月', '八月',
						'九月', '十月', '十一月', '十二月' ],
				monthsShort : [ '1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月',
						'9月', '10月', '11月', '12月' ],
				autoHide : true,

			};
			//营业执照时间
			$('#ttStartDate').datepicker(dataPickerOp);
			$('#ttEndDate').datepicker(dataPickerOp2);
			$('#ttStartDate').change(function() {
				$('#ttEndDate').datepicker('setStartDate', $(this).val());
			})
			$('#ttEndDate').change(function() {
				$('#ttStartDate').datepicker('setEndDate', $(this).val());
			})
		});
		function countttExpirePeriod() {
			var ttStartdate = $("#ttStartDate").val();
			var ttEnddate = $("#ttEndDate").val();
			if (ttStartdate != "" && ttEnddate != "") {
				if (Number(ttStartdate) > Number(ttEnddate)) {
					$("#ttExpirePeriod").val("无效");
					return false;
				}
			}
			var formatStart = ttStartdate.replace(/^(\d{4})(\d{2})(\d{2})$/,
					"$1-$2-$3");
			var formatEnd = ttEnddate.replace(/^(\d{4})(\d{2})(\d{2})$/,
					"$1-$2-$3");
			var days = DateDiff(formatStart, formatEnd);
			// 票劵有效周期
			$("#ttExpirePeriod").val(days);
		}

		//票券周期
		function DateDiff(sDate1, sDate2) { //sDate1和sDate2是2006-12-18格式  
			var aDate, oDate1, oDate2, iDays;
			aDate = sDate1.split("-");
			oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]) //转换为12-18-2006格式  
			aDate = sDate2.split("-");
			oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
			iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数  
			return iDays;
		}

		/*  $(document).ready(function(){
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
		  	$('.firstCommission').datepicker({
		 			format: 'yyyymmdd',
				autoclose: true,
				todayBtn : "linked",  
		        todayHighlight : true,  
		    }).on('hide',function(e){
		    	$('#stafffrom').data('bootstrapValidator').updateStatus('ttStartDate','NOT_VALIDATED',null).validateField('ttStartDate');
		    	$('#stafffrom').data('bootstrapValidator').updateStatus('ttEndDate','NOT_VALIDATED',null).validateField('ttEndDate');
		    });
		  	$('#ttDiscountRate1').change(function(event){
		  		
		  		if($(this).val()!=0){
		      		$('#ttDiscountRate2').attr('disabled','disabled');
		      	}else{
		      		$('#ttDiscountRate2').removeAttr('disabled','disabled');
		      	}
		  	}) */

		$('#stafffrom').bootstrapValidator({
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				disDesc : {
					validators : {
						notEmpty : {
							message : '优惠券描述描述不能为空'
						}
					}
				},
				disType : {
					validators : {
						notEmpty : {
							message : '优惠券类型不能为空'
						}
					}
				},
				disService : {
					validators : {
						notEmpty : {
							message : '使用说明不能为空'
						}
					}
				},
				ttStartDate : {
					validators : {
						notEmpty : {
							message : '起始时间不能为空'
						}
					}
				},
				ttEndDate : {
					validators : {
						notEmpty : {
							message : '结束时间不能为空'
						}
					}
				},
				disMoney : {
					validators : {
						notEmpty : {
							message : '优惠券金额不能为空'
						}
					}
				},
				disStatus : {
					validators : {
						notEmpty : {
							message : '是否有效不能为空'
						}
					}
				}

			}
		});
	</script>
</body>
</html>
