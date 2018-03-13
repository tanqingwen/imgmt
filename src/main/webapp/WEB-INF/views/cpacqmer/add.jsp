<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/layer/skin/layer.css" />
		<title>场馆配置添加</title>
		<link rel="stylesheet" href="${assets }/css/venueAllocationAdd.css" />
		<link rel="stylesheet" href="${assets }/css/index.css" />
		<link rel="stylesheet" href="${assets }/css/multiple-select.css" />
	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="venue_list"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>场馆配置添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx}/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
			<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
			<li><a href="${ctx }/cpacqmer/list">场馆配置</a></li>
            <li class="active">场馆配置添加</li>
          </ol>
        </section>
	
		<div class="container-fluid">
			<div class="row">
				<div class="tip-img">
					<p>场馆配置添加</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">添加表单</h3>
						<form  id="stafffrom"  class="form-horizontal" enctype="multipart/form-data"  method="post" action="${ctx }/cpacqmer/add">
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venuesNum">场馆组编号<span class="star">*</span>：</label>
											<input class="form-control formConl line-input" type="text" readonly="readonly" id="amGroupId" name="amGroupId" value="${cpAcqmer.amGroupId}" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNum">场馆组名称<span class="star">*</span>：</label>
											<input class="form-control formConl line-input" type="text" id="amUserDefine1" name="amUserDefine1" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venuesNum">场馆开馆时间<span class="star">*</span>：</label>
											<input class="form-control formConl line-input" type="text" id="amUserDefine3" name="amUserDefine3"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="venueNum">场馆闭馆时间<span class="star">*</span>：</label>
											<input class="form-control formConl line-input" type="text" id="amUserDefine4" name="amUserDefine4" />
										</div>
									</div>
								</div>
							</div>
							<div class="form-line clearfix">
								<div class=" col-md-12 clearfix ">
									<div class="col-lg-6 col-md-6">
										<div class="form-group">
											<label for="venuesNum">场馆编号<span class="star">*</span>：</label>
											<select  multiple="multiple" id="amMerchantId" name ="amMerchantId">
												<c:forEach var="item" items="${cpMermsts}">
													<option value="${item.mmMerchantNo }">${item.mmMerchantNo }-${item.mmBizName }</option>
												</c:forEach>
											</select>
										</div>
									</div>
									<!-- <div class="col-lg-6 col-md-6">
										<div class="form-group ">
											<label for="DuplicateEntry">重复入园标志<span class="star">*</span>：</label>
											<select class="DuplicateEntry" id="amRecycleType" name="amRecycleType">
												<option value='Y'>Y-是</option>
											</select>
										</div>
									</div> -->
								</div>
							</div>
							<div class="VenueMaster clearfix">
								<div class="col-md-12">
									<div class="col-md-2 text-right" style="width: 110px;">场馆主图<span class="star">*</span></div>
									<div class="col-md-10">
										<div class="z_photo upimg-div clear a-upload">
											<input type="file" name="file" value=""/>
										</div>
									</div>
								</div>
							</div>
							<div class="VenueMaster clearfix">
								<div class="col-md-12">
									<div class="col-md-2 text-right" style="width: 110px;">场馆详细图<span class="star">*</span></div>
									<div class="col-md-10">
										<div class="z_photo upimg-div clear a-upload">
											<input type="file" name="files" value=""/>
											<input type="file" name="files" value=""/>
											<input type="file" name="files" value=""/>
											<input type="file" name="files" value=""/>
										</div>
									</div>
								</div>
							</div>
							<input type="hidden" name="tag" id="tag" value="">
                             <input type="hidden" name="tags" id="tags" value="">
							<div class="col-md-12 AddBottom">
								<a href="javascript:history.go(-1)" style="font-size:18px;color:#333;">&lt;返回</a>
								<button type="submit" id="addButton" class="btn btnAdd btn-size" style="background-color:#00a65a;">添加</button>
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
    <script src="${assets}/underscore/underscore.min.js"></script>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script src="${assets}/bootstrap/js/bootstrap.min.js"></script>
    <script src="${assets}/crypto/md5.js"></script>
		<aside class="mask works-mask">
			<div class="mask-content">
				<p class="del-p">您确定要删除作品图片吗？</p>
				<p class="check-p"><span class="del-com wsdel-ok">确定</span><span class="wsdel-no">取消</span></p>
			</div>
		</aside>
		<input type="hidden" value="3" id="test" />
		<script src="${assets }/layer/layer.js"></script>
		<script src="${assets }/js/multiple-select.js"></script>
		<script src="${assets }/js/imgUp.js"></script>
		<script>
		$(function() {
			$('#amMerchantId').change(function() {
//				console.log($(this).val());
			}).multipleSelect({
				width: '290px'
			});
		});
		</script>

	</body>

</html>