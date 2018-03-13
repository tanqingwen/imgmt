<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 商品信息查看</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
	<link rel="stylesheet" href="${assets }/ticketoo/css/ticketUpdate2.css" />
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="cptktypelist"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>商品信息查看</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/ywgl">业务管理</a></li>
            <li><a href="${ctx }/cptktype/list">商品信息管理</a></li>
            <li class="active">商品信息查看</li>
          </ol>
        </section>

        <!-- Main content -->
        <div class="container-fluid goodsShow">
			<div class="row">
				<div class="tip-img">
					<p>商品信息查看</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">查看表单</h3>
						<form class="form-inline form-horizontal" id="stafffrom" method="post" action="${ctx }/cpCommodity/update">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeId">商品ID <span class="color-red">*</span>:</label>
										<input type="text" class="form-control formConl line-input" id="ccTypeId" name="ccTypeId" title="不能为空" value="${item.ccTypeId}" readonly="readonly" />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTicketDes">商品描述<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="ccTicketDes" name="ccTicketDes" value="${item.ccTicketDes}" readonly="readonly"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeDesc">商品标题 <span class="color-red">*</span>:</label>
										<input type="text" class="form-control formConl line-input" id="ccTypeDesc" name="ccTypeDesc" title="不能为空" value="${item.ccTypeDesc}" readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTicketType">商品类型<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="ccTicketType" name="ccTicketType" value="${item.ccTicketType}" readonly="readonly"/>
									</div>
								</div>
							</div>
							
							
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccListPrice">商品价格:</label>
										<input type="text" class="form-control formConl line-input" id="ccListPrice" name="ccListPrice" title="不能为空" value="${item.ccListPrice }" readonly="readonly"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="ccTypeUser">是否上架:</label>
										 <select class="line-input" id="ccTypeStatus" name="ccTypeStatus"  disabled="disabled">
									     	 <option value="Y" ${item.ccTypeStatus eq 'Y' ? 'selected' : ''}>是</option>
						    				 <option value="N" ${item.ccTypeStatus eq 'N' ? 'selected' : ''}>否</option>
									      </select>
									</div>
								</div>
							</div>
							
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label style="margin-left: 6px;">上架时间<i
											class="color-red">*</i>：
										</label>
										<div class="input-group" style="margin-left: 5px;">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											<input class="form-control formConl" path="ccStartDate"
												id="ccStartDate" name="ccStartDate" disabled="disabled"
												value = "${item.ccStartDate}" style="width:220px;" />
										</div>
									</div>
								</div>
								<div class="col-md-6 ">
									<div class="form-group">
										<label style="margin-left: 6px;">下架时间<i
											class="color-red">*</i>：
										</label>
										<div class="input-group " style="margin-left: 5px;">
											<span class="input-group-addon"><i
												class="glyphicon glyphicon-calendar"></i></span>
											<input class="form-control formConl" path="ccEndDate"
												id="ccEndDate" name="ccEndDate" value = "${item.ccEndDate}" disabled="disabled" style="width:220px;" />
										</div>
									</div>
								</div>
							</div>
							
							<div class="col-md-12 clearfix">
									<div class="col-md-6">
										<div class="form-group">
											<label for="ccListPrice">商品主图片信息<span
												class="color-red">*</span>:
											</label>
											<div class="z_photo upimg-div clear a-upload">
												<input type="file" name="file" value="" />
											</div>
										</div>
									</div>

								</div>
							<div class="col-md-12 clearfix">
									<div class="col-md-6">
										<div class="form-group">
											<label for="ccListPrice">商品图片信息<span
												class="color-red">*</span>:
											</label>
											<div class="z_photo upimg-div clear a-upload">
												<input type="file" name="files" value="" /> <input
													type="file" name="files" value="" style="margin: 20px 0;" />
												<input type="file" name="files" value="" />
											</div>
										</div>
									</div>

								</div>

						<div class="col-lg-12 submit-group marginTop marginBottom">
							<a type="button" href="${ctx }/cpCommodity/list" class="form-a">&lt;返回</a>
							
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
    <script src="${assets}/validator/js/validator.js"></script>
  </body>
</html>
