<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 |终端查看</title>
<tags:head_common_content />
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
				<h1>终端查看</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/xcgl">现场管理</a></li>
            		<li><a href="${ctx }/startTreeviewDetail/cggl">场馆管理</a></li>
            		<li><a href="${ctx }/trmmstgate/mermstlist">商户管理</a></li>
            		<li><a href="${ctx }/trmmstgate/viewmermstlist/${chainNo }">商户列表</a></li>
            		<li><a href="${ctx }/trmmstgate/viewTrmmstlist/${merchantId }">终端列表</a></li>	
					<li><a href="${ctx }/machine/upunexamineList/${merchantId }">待复核列表</a></li>
					<li class="active">终端查看</li>
				</ol>
			</section>

			<!-- Main content -->
		
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-plus"></i> 查看终端
						</h3>
					</div>
					 <!-- /.box-header -->
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="id" class="col-sm-3 control-label">终端编号</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="id" name="id" value="${item.tmTerminalId}" disabled="disabled" />
										</div>
									</div>
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">商户号码</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmMerchantId}" disabled="disabled" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">终端品牌</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmBrand}" disabled="disabled" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">终端版本</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmVersionNo}" disabled="disabled" />
										</div>
									</div>
									
									<!-- 
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">票价</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmGeog}" disabled="disabled" />
										</div>
									</div>
									-->
																		
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">安装日期</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmDateInst}" disabled="disabled" />
										</div>
									</div>
									
									<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">园区类型</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmModel}" disabled="disabled" />
										</div>
									</div>
									-->
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">设备序号</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmEdcPrinterNo}" disabled="disabled" />
										</div>
									</div>
									<!-- 
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">终端类型</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmDbaName}" disabled="disabled" />
										</div>
									</div>
									-->
									<!--  
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">省份</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmPhyState}" disabled="disabled" />
										</div>
									</div>
									
									<div class="form-group">
										<label for="password" class="col-sm-3 control-label">城市</label>
										<div class="col-sm-9">
											<input type="text" class="form-control" id="name" name="name" value="${item.tmPhyCity}" disabled="disabled" />
										</div>
									</div>
									-->
									
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<!-- 
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">区域代码</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmRegionCd}" disabled="disabled" />
											</div>
										</div>
										-->
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">终端状态</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmStatus=='1'?'停用':'正常'}" disabled="disabled" />
											</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">录入人</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmSetupUser}" disabled="disabled" />
											</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">录入时间</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmSetupTimestamp}" disabled="disabled" />
											</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">授权人</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmAuthUser}" disabled="disabled" />
											</div>
										</div>
										
										<div class="form-group">
											<label for="password" class="col-sm-3 control-label">授权时间</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" id="name" name="name" value="${item.tmAuthTimestamp}" disabled="disabled" />
												<!-- 商户场馆名称 -> 商户|场馆 == 1|0 -->
												<input type="hidden" id="mm_phy_state" name="mm_phy_state" value="${mm_phy_state}">
											</div>
										</div>

									</div>
										
									</div>
								</div>
							</div>
						</div>
						<div class="box-footer">
	                  		<a type="submit" class="btn btn-default pull-right" href="${ctx }/machine/trunexamineList/${item.tmMerchantId}"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	              		</div><!-- /.box-footer -->								
				</div>
		</div><!-- /.box -->
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
	
	<script type="text/javascript">
	</script>
</body>
</html>
 