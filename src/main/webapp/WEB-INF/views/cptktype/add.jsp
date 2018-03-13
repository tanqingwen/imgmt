<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 票务信息添加</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/validator/css/validator.css" />
<link rel="stylesheet" href="${assets }/css/datepicker.min.css" />
<link rel="stylesheet" href="${assets }/ticketoo/css/layer.css" />
<link rel="stylesheet" href="${assets }/ticketoo/css/ticketUpdate2.css" />
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
				<h1>票务信息添加</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
					<li><a href="${ctx }/cptktype/list">票务信息管理</a></li>
					<li class="active">票务信息添加</li>
				</ol>
			</section>

			<!-- Main content -->
			<div class="container-fluid ticketUpdate  ticketAdd">
				<div class="row">
					<div class="tip-img">
						<p style="line-height:30px; font-size:20px;">票务信息添加</p>
					</div>
					<div class="content">
						<div class="main">
							<h3 style="border-bottom: 2px dashed #45a0e0;">添加表单</h3>
							<form class="form-inline form-horizontal" id="stafffrom"
								method="post" action="${ctx }/cptktype/add">
								<div class="col-md-12 ticket-first">
									<div class="col-md-6">
										<div class="form-group">
											<label>票种ID <span class="color-red">*</span>:
											</label> <input class="form-control formConl line-input" type="text"
												id="ttTypeId" name="ttTypeId" readonly="readonly"
												value="${ttTypeIdd}" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="ttTypeDesc">票种描述<span class="color-red">*</span>:
											</label> <input class="form-control formConl line-input" type="text"
												id="ttTypeDesc" name="ttTypeDesc" value="" />
										</div>
									</div>
								</div>
								<div class="col-md-12" style="margin-top: 20px;">
									<div class="col-md-6">
										<label for="ttStartDate" class="labelWidth">允许售票起始时间<span
											class="color-red">*</span>：
										</label>
										<div
											class="input-group groupDis groupDis2 date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span> <input readonly
												class="form-control dateWidth" type="text" id="ttStartDate"
												name="ttStartDate" value="${nowTime}"
												onchange="countttExpirePeriod()">
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<label for="ttEndDate" class="labelWidth">允许售票终止时间<span
											class="color-red">*</span>：
										</label>
										<div
											class="input-group groupDis groupDis2 date ">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span> <input readonly
												class="form-control dateWidth" type="text" id="ttEndDate"
												name="ttEndDate" value="${nowTime}"
												onchange="countttExpirePeriod()">
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label for="ttExpirePeriod">票务有效周期(天) <span
												class="color-red">*</span>:
											</label> <input class="form-control formConl line-input" type="text"
												id="ttExpirePeriod" name="ttExpirePeriod" value="1"
												readonly="readonly" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="ttAcqListsId">场馆组<span class="color-red">*</span>:
											</label> <select name="ttAcqListsId" id="ttAcqListsId"
												class="line-input">
												<c:forEach var="item" items="${cpAcqmer}">
													<option value="${item.amGroupId }">${item.amGroupId }-${item.amUserDefine1 }</option>
												</c:forEach>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label for="ttListPrice">常规价格<span class="color-red">*</span>:
											</label> <input class="form-control formConl line-input"
												id="ttListPrice" name="ttListPrice" title="不能为空"
												onchange="changettListPrice()" value="" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="ttTypeUser">使用规则:</label> <select
												name="ttTypeUser" id="ttTypeUser" class="line-input">
												<option value="">实名制</option>
												<option value="V">非实名</option>
											</select>
										</div>
									</div>
								</div>
								<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ttListPrice">起始有效时间:</label>
										<input readonly class="form-control line-input" id="couponDate" name="couponDate" value="${ss }"class="form-control dateWidth line-input" >
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="couponsDays">有效天数:</label>
										<input class="form-control formConl line-input" type="text" id="couponDays" name="couponDays" value="" data-bv-field="couponDays">
									</div>
								</div>
							</div>
								<!-- <div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>是否有效:</label>
										<select name="" id="" class="line-input"></select>
									</div>
								</div>
							</div> -->

								<div class="col-lg-12 submit-group marginTop marginBottom">
									<a href="${ctx }/cptktype/list" class="form-a" type="button">&lt;返回</a>
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
	    var dataPickerOp3 = {
	            format: 'yyyy-mm-dd',
	            weekStart: 1,
	            startDate:new Date(),
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
		
	    $('#couponDate').datepicker(dataPickerOp3);
	   /*  $('#couponDate').change(function(){
	    	var ss=$(this).val();
		    ss = ss.replace(/\-/g,"");
		    $("#couponDate").val(ss);
	    });   */

	});
/*    alert('${ss }');
    alert('${nowTime}'); */
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
			// 票务有效周期
			$("#ttExpirePeriod").val(days+1);
		}

		//票务周期
		function DateDiff(sDate1, sDate2) { //sDate1和sDate2是2006-12-18格式  
			var aDate, oDate1, oDate2, iDays;
			aDate = sDate1.split("-");
			oDate1 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]) //转换为12-18-2006格式  
			aDate = sDate2.split("-");
			oDate2 = new Date(aDate[1] + '-' + aDate[2] + '-' + aDate[0]);
			iDays = parseInt(Math.abs(oDate1 - oDate2) / 1000 / 60 / 60 / 24); //把相差的毫秒数转换为天数  
			return iDays;
		}

		function changettListPrice() {
			countttDiscountPrice1();
			countttDiscountPrice2();
		}
		//普通折扣价
		function countttDiscountPrice1() {
			var ttListPrice = $("#ttListPrice").val();//常规价格
			var ttDiscountRate1 = $("#ttDiscountRate1").val();//普通折扣率
			$("#ttDiscountPrice1").val(ttListPrice * ttDiscountRate1);//普通折扣价
		}
		//特别折扣价
		function countttDiscountPrice2() {
			var ttListPrice = $("#ttListPrice").val();//常规价格
			var ttDiscountRate2 = $("#ttDiscountRate2").val();//特别折扣率
			$("#ttDiscountPrice2").val(ttListPrice * ttDiscountRate2);          //特别折扣价
		}

		$(document).ready(
				function() {					
					$('#ttDiscountRate1').change(
							function(event) {
								if ($(this).val() != 0) {
									$('#ttDiscountRate2').attr('disabled',
											'disabled');
								} else {
									$('#ttDiscountRate2').removeAttr(
											'disabled', 'disabled');
								}
							})
					
					
							
					$('#stafffrom').bootstrapValidator({
						message : 'This value is not valid',
						feedbackIcons : {
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							ttTypeDesc : {
								validators : {
									notEmpty : {
										message : '类型描述不能为空'
									}
								}
							},
							ttStartDate : {
								validators : {
									notEmpty : {
										message : '请选择允许售票起始时间'
									}
								}
							},
							ttEndDate : {
								validators : {
									notEmpty : {
										message : '请选择允许售票结束时间'
									}
								}
							},
							ttListPrice : {
								validators : {
									notEmpty : {
										message : '常规价格不能为空'
									},
									regexp: {
			                            regexp: /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/,
			                            message: '请输入正确的价格'
			                        }
								}
							},
							couponDays : {
								validators : {
									notEmpty : {
										message : '有效天数不能为空'
									},
									regexp: {
			                            regexp: /^([1-9]\d*|[0]{1,1})$/,
			                            message: '请输入正确的有效天数'
			                        }
								}
							}
						}
					});
				});
	</script>
</body>
</html>
