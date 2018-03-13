<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<title>终端更新</title>
		<tags:head_common_content />
		<link rel="stylesheet" href="${assets }/css/model.css" />
		<link rel="stylesheet" href="${assets }/css/siteManagement.css">
		<link rel="stylesheet" href="${assets }/css/datepicker.min.css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="profile" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>终端更新</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">商户管理</a></li>
            		<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">商户列表</a></li>
            		<li><a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">终端查询列表</a></li>
					<li class="active">终端更新</li>
				</ol>
			</section>
	
		<div class="container-fluid venue-entry">
			<div class="row outer-wrap">
				<div class="tip-img">
					<p>终端更新</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">更新列表</h3>
						<form:form action="${ctx}/machine/updateTe" modelAttribute="cpTrmacc" method="post" id="machinefrom" name="machinefrom" class="form-horizontal">
							<div class="form-group">
								<div class="col-md-6 col-sm-6 col-sm-6">
									<label>终端编号：</label>
									<input class="form-control formConl" type="text" id="updateCpTrmmst" name="tmTerminalId" value="${item.tmTerminalId}" readonly="readonly" />
								</div>
								<div class="col-md-6 col-sm-6">
									<label>终端状态：</label>
									<select  id="tmStatus"  name="tmStatus">
										<option value="1" ${item.tmStatus == '1' ? 'selected':''}>停用</option>
									    <option value="0" ${item.tmStatus == '0' ? 'selected':''}>正常 </option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6">
									<label>商户号码：</label>
									<input class="form-control formConl" type="text" id="tmMerchantId" name="tmMerchantId" readonly="readonly" value="${item.tmMerchantId}"/>

								</div>
								<div class="col-md-6 col-sm-6">
									<label>安装日期<i class="color-red">*</i>：</label>
									<div class="input-group groupDis">
										<span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>
										<input type="text" class="form-control" id="tmDateInst" name="tmDateInst"  value="${item.tmDateInst}" data-toggle="datepicker">
									</div>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6">
									<label>终端品牌<i class="color-red">*</i>：</label>
									<select id="tmBrand"  name="tmBrand">
										<option value="" >-----请选择品牌------</option>
										      <c:forEach var="cpPosprm" items="${cpPosprmList}" >
										      	 <option value="${cpPosprm.ppBrand}" ${item.tmBrand == cpPosprm.ppBrand ? 'selected':''}>${cpPosprm.ppBrand}</option>
										      </c:forEach>
									      	</select>
									</select>
								</div>
								<div class="col-md-6 col-sm-6">
									<label>设备序号：</label>
									<input class="form-control formConl" type="text" id="tmEdcPrinterNo" name="tmEdcPrinterNo" value="${item.tmEdcPrinterNo}" />

								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6">
									<label>终端名称：<i class="color-red">*</i>：</label>
									<input class="form-control formConl" type="text" id="tmDateCanx" name="tmDateCanx" value="${item.tmDateCanx}"/>
								</div>
								<div class="col-md-6">
									<label>终端IP：</label>
									<input class="form-control formConl" type="text" id="tmHostSerial" name="tmHostSerial" value="${item.tmHostSerial}"/>
								</div>
							</div>
							<div class="form-group">
								<div class="col-md-6 col-sm-6">
									<label>终端版本<i class="color-red">*</i>：</label>
									<select id="tmVersionNo"  name="tmVersionNo" >
										<option value="" >-----请选择版本------</option>
									      	 <option value="${item.tmVersionNo }" ${item.tmVersionNo == "1.0"? 'selected':'' }>-----1.0-----</option>
									      	 <option value="${item.tmVersionNo }" ${item.tmVersionNo == "2.0"? 'selected':'' }>-----2.0-----</option>
									</select>

								</div>
								
							</div>
							

							<!--<div class="clearfix"></div>-->

							<div class="col-lg-12 submit-group">
								<a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">&lt;返回</a>
								<button  type="submit" class="btn-size" style="width:110px;margin:0 25px 0 15px;" id="memberShip">更新</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
		</div><!-- /.box-footer -->
		</div><!-- /.box -->
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/datepicker/locales/date.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/pdata/pdata.js"></script>
		<script src="${assets }/js/datepicker.min.js"></script>
		<script language="javascript">
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
				$('[data-toggle="datepicker"]').datepicker(dataPickerOp)
			});
		</script>
	</body>

</html>