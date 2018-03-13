<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 合同信息</title>
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
				<h1>合同信息<small>（编号：${contractInfo.contractId }）</small></h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">客户管理</a></li>
					<li class="active">合同信息</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h1 class="box-title">客户信息</h1>
						<div class="box-tools pull-right">
							<button class="btn btn-box-tool" data-widget="collapse">
								<i class="fa fa-minus"></i>
							</button>
						</div>
					</div>
					<div class="box-body box-profile">
						<br />
						<div class="col-md-3">
							<!-- Profile Image -->
							<img class="profile-user-img img-responsive img-circle" src="${assets}/app/img/logo-88x881.jpg" alt="客户图像"> <br />
							<h3 class="profile-username text-center">${userInfo.realName } - (${app:calcGender(userInfo.idCardNo)})</h3>
						</div>
						<!-- /.col -->

						<div class="col-md-9">
							<div class="row">
								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i> 身份证</strong>
									<p class="text-muted">${userInfo.idCardNo }</p>
									<hr/>

									<%-- <strong><i class="fa fa-book margin-r-5"></i> 生日</strong>
									<p class="text-muted">${fn:substring(userInfo.idCardNo, 6, 14)}</p>
									<hr/> --%>
									
									<strong><i class="fa fa-book margin-r-5"></i> QQ</strong>
									<p class="text-muted">${empty userInfo.qq ? '--' : userInfo.qq}</p>
									<hr>

									<strong><i class="fa fa-mobile margin-r-5"></i> 手机号</strong>
									<p>${userInfo.mobile }</p>
								</div>
								<!-- /.col -->

								<div class="col-md-3">
									<strong><i class="fa fa-map-marker margin-r-5"></i> 首付支付方式</strong>
									<p class="text-muted">--</p>
									<hr/>

									<strong><i class="fa fa-pencil margin-r-5"></i> 还款方式</strong>
									<p>--</p>
									<hr/>

									<strong><i class="fa fa-map-marker margin-r-5"></i> 银行卡号</strong>
									<p class="text-muted">${userInfo.bankCardNo }</p>
								</div>
								<!-- /.col -->

								<div class="col-md-6">
									<strong><i class="fa fa-book margin-r-5"></i> 现居住地址</strong>
									<p>${userInfo.address }</p>
									<hr/>

									<strong><i class="fa fa-pencil margin-r-5"></i> 单位地址</strong>
									<p>${userInfo.companyAddress }</p>
									<hr/>

									<strong><i class="fa fa-map-marker margin-r-5"></i> 开户行</strong>
									<p class="text-muted">${userInfo.bankName }</p>
								</div>
								<!-- /.col -->
							</div>
						</div>
					</div>
				</div>
				<!-- /.box -->
				
				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h1 class="box-title">贷款信息</h1>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							
							<div class="box-body">
								<div class="col-md-12">
									<div class="row">
										
										<div class="col-md-3">
											<strong><i class="fa fa-book margin-r-5"></i> 合同状态</strong>
											<p>
												<c:choose>
													<c:when test="${contractInfo.busiStatus eq '0' }">待审核</c:when>
													<c:when test="${contractInfo.busiStatus eq '1' }">审核中</c:when>
													<c:when test="${contractInfo.busiStatus eq '2' }">审核通过</c:when>
													<c:when test="${contractInfo.busiStatus eq '3' }">合同激活</c:when>
													<c:when test="${contractInfo.busiStatus eq '50' }">合同完结</c:when>
													<c:when test="${contractInfo.busiStatus eq '51' }">审核未通过</c:when>
													<c:when test="${contractInfo.busiStatus eq '52' }">撤销</c:when>
													<c:otherwise>${contractInfo.busiStatus }</c:otherwise>
												</c:choose>
											</p>
											<hr>
											
											<strong><i class="fa fa-book margin-r-5"></i> 首付金额</strong>
											<p>${contractInfo.downPayment }</p>
											<hr/>
											
											<strong><i class="fa fa-book margin-r-5"></i>商品类型</strong>
											<p class="text-muted">${contractInfo.contractGoods[0].title }</p>
										</div>
										<!-- /.col -->

										<div class="col-md-3">
											<strong><i class="fa fa-server margin-r-5"></i>	分期期数</strong>
											<p class="text-muted">${contractInfo.term }</p>
											<hr/>
											
											<strong><i class="fa fa-calculator margin-r-5"></i> 每月还款金额</strong>
											<p class="text-muted">${contractInfo.phaseAmount }</p>
											<hr/>
											
											<strong><i class="fa fa-book margin-r-5"></i>商品品牌</strong>
											<p class="text-muted">${contractInfo.contractGoods[0].brand }</p>
										</div>
										<!-- /.col -->

										<div class="col-md-3">
											<strong><i class="fa fa-newspaper-o margin-r-5"></i> 代扣银行名称</strong>
											<p class="text-muted">${contractInfo.bankName }</p>
											<hr/>
										
											<strong><i class="fa fa-calendar margin-r-5"></i> 每月还款日</strong>
											<p>--</p>
											<hr/>
											
											<strong><i class="fa fa-newspaper-o margin-r-5"></i> 商品型号</strong>
											<p class="text-muted">${contractInfo.contractGoods[0].modelNum }</p>
										</div>
										<!-- /.col -->

										<div class="col-md-3">
											<strong><i class="fa fa-newspaper-o margin-r-5"></i> 代扣银行账户</strong>
											<p class="text-muted">${contractInfo.bankCardNo }</p>
											<hr/>
											
											<strong><i class="fa fa-book margin-r-5"></i> 保险费</strong>
											<p>--</p>
											<hr>
											
											<strong><i class="fa fa-book margin-r-5"></i>商品价格</strong>
											<p class="text-muted">${contractInfo.contractGoods[0].goodsAmount }</p>
										</div>																		
									</div>
								</div>
								<!-- /.box -->								
							</div>
							<!-- <div class="box-footer clearfix">
								<div class="pull-right">
									<button href="javascript:;" class="btn btn-sm btn-default btn-flat" data-toggle="modal" data-target="#refundModal" disabled="disabled">退货</button>
								</div>
							</div>	 -->											
						</div>
					</div>
				</div>
					
				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h1 class="box-title">客户工作信息</h1>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							
							<div class="box-body">
								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i>单位/个体全称</strong>
									<p class="text-muted">${empty contractInfo.companyName ? '--' : contractInfo.companyName}</p>
									<hr/>

									<strong><i class="fa fa-newspaper-o margin-r-5"></i>单位性质</strong>
									<p class="text-muted">--</p>
								</div>
								<!-- /.col -->
										
								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i>任职部门</strong>									
									<p class="text-muted">--</p>
									<hr/>

									<strong><i class="fa fa-book margin-r-5"></i>单位地址</strong>
									<p class="text-muted">${contractInfo.companyAddress }</p>
								</div>
								<!-- /.col -->

								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i>职位</strong>
									<p class="text-muted">
										<c:choose>
											<c:when test="${contractInfo.workinfoPosition == 0}">基础员工</c:when>
											<c:when test="${contractInfo.workinfoPosition == 1}">管理人员</c:when>
											<c:when test="${contractInfo.workinfoPosition == 2}">其它</c:when>
											<c:otherwise>${empty contractInfo.workinfoPosition ? '--' : contractInfo.workinfoPosition}</c:otherwise>
										</c:choose>
									</p>
									<hr>
								</div>
								<!-- /.col -->
								
								<div class="col-md-3">
									<strong><i class="fa fa-calculator margin-r-5"></i> 行业类别</strong>
									<p class="text-muted">
										<c:choose>
											<c:when test="${contractInfo.industry == 1}">计算机/互联网/通信/电子</c:when>
											<c:when test="${contractInfo.industry == 2}">会计/金融/银行/保险</c:when>
											<c:when test="${contractInfo.industry == 3}">贸易/消费/制造/营运</c:when>
											<c:when test="${contractInfo.industry == 4}">制药/医疗</c:when>
											<c:when test="${contractInfo.industry == 5}">广告/媒体</c:when>
											<c:when test="${contractInfo.industry == 6}">房地产/建筑</c:when>
											<c:when test="${contractInfo.industry == 7}">专业服务/教育/培训</c:when>
											<c:when test="${contractInfo.industry == 8}">服务业</c:when>
											<c:when test="${contractInfo.industry == 9}">物流/运输</c:when>
											<c:when test="${contractInfo.industry == 10}">能源/原材料</c:when>
											<c:when test="${contractInfo.industry == 11}">政府/非赢利机构</c:when>
											<c:otherwise>其他</c:otherwise>
										</c:choose>
									</p>
									<hr>
								</div>
								<!-- /.col -->
							</div>													
						</div>
					</div>
				</div>
				<!-- row -->
				
				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h1 class="box-title">客户家庭信息</h1>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							
							<div class="box-body">
								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i>婚姻状况</strong>
									<p class="text-muted">--</p>
									<hr>

									<strong><i class="fa fa-newspaper-o margin-r-5"></i>住房状况</strong>
									<p class="text-muted">--</p>
									<hr>
									
									<strong><i class="fa fa-book margin-r-5"></i>家庭成员电话</strong>
									<p class="text-muted">--</p>										
								</div>
								<!-- /.col -->
										
								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i>子女数目</strong>
									<p class="text-muted">--</p>									
									<hr>
									
									<strong><i class="fa fa-book margin-r-5"></i>家庭成员联系地址</strong>	
									<p class="text-muted">--</p>
									<hr>
								</div>
								<!-- /.col -->

								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i>配偶姓名</strong>
									<p class="text-muted">--</p>
									<hr>
									
									<strong><i class="fa fa-book margin-r-5"></i>家庭成员</strong>
									<p class="text-muted">--</p>
									<hr>
								</div>
								<!-- /.col -->
								
								<div class="col-md-3">
									<strong><i class="fa fa-calculator margin-r-5"></i> 配偶移动电话</strong>
									<p class="text-muted">--</p>
									<hr>
									
									<strong><i class="fa fa-book margin-r-5"></i>家庭成员类型</strong>	
									<p class="text-muted">--</p>								
									<hr>
								</div>
								<!-- /.col -->
															
							</div>													
						</div>
					</div>
				</div>
				<!-- row -->
				
			</section>
			<!-- /.content -->									
		</div>
	<!-- /.content-wrapper -->
	<tags:main_footer />
	<!-- Control Sidebar -->
	<tags:control_sidebar />
	</div>
	<!-- ./wrapper -->

	<div class="modal fade" id="refundModal" role="dialog" aria-labelledby="refundLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="refundLabel">退货确认</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group" align="center">是否确认退货？</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-primary">保存</button>
				</div>
			</div>
		</div>
	</div>
	<tags:load_common_js />
</body>
</html>
