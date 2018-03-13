<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 客户信息</title>
<tags:head_common_content />
<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">

		<%-- 头顶工具栏 --%>
		<tags:main_header />

		<%-- 左边菜单栏 --%>
		<tags:main_sidebar active="profile" />

		<%-- 网页内容栏 --%>
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>

			<%-- 内容头 --%>
			<section class="content-header">
				<h1>客户中心<small>（客户ID：${userInfo.userId }）</small></h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">客户管理</a></li>
					<li class="active">客户中心</li>
				</ol>
			</section>

			<%-- 内容体 --%>
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
						<div class="col-md-3">
							<!-- Profile Image -->
							<img class="profile-user-img img-responsive img-circle" src="${assets}/app/img/logo-88x881.jpg" alt="客户图像"> <br />
							<h3 class="profile-username text-center">${userInfo.realName } - (${app:calcGender(userInfo.idCardNo)})</h3>
							<%-- <h3 class="profile-username text-center">${userInfo.realName }(${userInfo.gender })</h3> --%>
						</div>
						<!-- /.col -->

						<div class="col-md-9">
							<div class="row">
								<div class="col-md-3">
									<strong><i class="fa fa-book margin-r-5"></i> 身份证</strong>
									<p class="text-muted">${userInfo.idCardNo }</p>
									<hr>

									<%-- <strong><i class="fa fa-book margin-r-5"></i> 生日</strong>
									<p class="text-muted">${fn:substring(userInfo.idCardNo, 6, 14)}</p>
									<hr> --%>
									
									<strong><i class="fa fa-book margin-r-5"></i> QQ</strong>
									<p class="text-muted">${empty userInfo.qq ? '--' : userInfo.qq}</p>
									<hr>

									<strong><i class="fa fa-mobile margin-r-5"></i> 手机号</strong>
									<p><a href="javascript:;" id="btnShowPhoneRepoModal">${userInfo.mobile }</a></p>
								</div>
								<!-- /.col -->

								<div class="col-md-3">
									<strong><i class="fa fa-map-marker margin-r-5"></i> 首付支付方式</strong>
									<p class="text-muted">--</p>
									<hr>

									<strong><i class="fa fa-pencil margin-r-5"></i> 还款方式</strong>
									<p class="text-muted">--</p>
									<hr/>

									<strong><i class="fa fa-map-marker margin-r-5"></i> 银行卡号</strong>
									<%-- <p><a href="javascript:;" id="userBankCard" data-toggle="modal" data-target="#updateBankInfoModal">${userInfo.bankCardNo }</a></p> --%>
									<p class="text-muted">${userInfo.bankCardNo }</p>
								</div>
								<!-- /.col -->

								<div class="col-md-6">
									<strong><i class="fa fa-book margin-r-5"></i> 现居住地址</strong>
									<p><a href="javascript:;" id="userHomeAddr" data-toggle="modal" data-target="#updateAddrModal">${userInfo.address }</a></p>
									<hr>

									<strong><i class="fa fa-pencil margin-r-5"></i> 单位地址</strong>
									<p><a href="javascript:;" id="userCompanyAddr" data-toggle="modal" data-target="#updateAddrModal">${userInfo.companyAddress }</a></p>
									<hr>

									<strong><i class="fa fa-map-marker margin-r-5"></i> 开户行</strong>
									<%-- <p><a href="javascript:;" id="userBankName" data-toggle="modal" data-target="#updateBankInfoModal">${userInfo.bankName }</a></p> --%>
									<p class="text-muted">${userInfo.bankName }</p>
								</div>
								<!-- /.col -->
							</div>
						</div>
					</div>
					<div class="box-footer clearfix">
						<a href="javascript:;" class="btn btn-sm btn-default btn-flat" data-toggle="modal" data-target="#attachDownModal">附件下载</a>
						<div class="pull-right">
							<a href="javascript:;" class="btn btn-sm btn-default btn-flat" data-toggle="modal" data-target="#resetPasswordModal">重置密码</a>
							<a href="javascript:;" class="btn btn-sm btn-default btn-flat" data-toggle="modal" data-target="#activityCenterModal">活动中心</a>
						</div>
					</div>
				</div>
				<!-- /.box -->

				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">贷款信息</h3>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th>合同状态</th>
												<th>合同编号</th>
												<th>申请日期</th>
												<th>商品类型</th>
												<th>商品型号</th>
												<th>商品价格</th>
												<th>首付金额</th>
												<th>贷款金额</th>
												<th>期数</th>
												<th>每月还款金额</th>
											</tr>
										</thead>
										<tbody id="loanInfos">
											<c:forEach var="item" items="${loanInfo}">
												<tr id="tr_${item.contractId }">
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">
														<c:choose>
															<c:when test="${item.busiStatus eq '0' }">待审核</c:when>
															<c:when test="${item.busiStatus eq '1' }">审核中</c:when>
															<c:when test="${item.busiStatus eq '2' }">审核通过</c:when>
															<c:when test="${item.busiStatus eq '3' }">合同激活</c:when>
															<c:when test="${item.busiStatus eq '50' }">合同完结</c:when>
															<c:when test="${item.busiStatus eq '51' }">审核未通过</c:when>
															<c:when test="${item.busiStatus eq '52' }">撤销</c:when>
															<c:otherwise>${item.busiStatus }</c:otherwise>
														</c:choose>
													</td>
													<td><a href="${ctx }/customer/contract?id=${item.contractId }">${item.contractId }</a></td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');"><fmt:formatDate value="${item.createTime }" pattern="yyyy-MM-dd"/></td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">${item.contractGoods[0].title }</td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">${item.contractGoods[0].modelNum }</td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">${item.contractGoods[0].goodsAmount }</td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">${item.downPayment }</td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">${item.contractAmount }</td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">${item.term }</td>
													<td onclick="selectContract('${item.contractId }','${item.contractGoods[0].hasInsurance }');">${item.phaseAmount }</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- /.tab-pane -->
						</div>

						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">还款信息</h3>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th>期数</th>
												<th>还款日期</th>
												<th>应还金额</th>
												<th>应还本金</th>
												<th>应还利息</th>
												<th>印花税</th>
												<th>客户服务费</th>
												<th>保险费</th>
												<th>滞纳金</th>
												<th>实际还款金额</th>
												<th>实际到账日期</th>
											</tr>
										</thead>
										<tbody id="contractRepayments">
											
										</tbody>
									</table>
								</div>
								<div class="box-footer clearfix">
									<div class="pull-right">
										<button class="btn btn-sm btn-default btn-flat" id="btnCancelInsurence">申请取消保险</button>
										<button class="btn btn-sm btn-default btn-flat" id="btnContractBankInfo">修改代扣银行信息</button>
										<button class="btn btn-sm btn-default btn-flat" id="btnPreRepayment">提前还款</button>
									</div>
								</div>
							</div>
							<!-- /.tab-pane -->
						</div>

						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">事件记录</h3>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table no-margin">
										<thead>
											<tr>
												<th>合同编号</th>
												<th>事件类型</th>
												<th>事件详情</th>
												<th>记录人</th>
												<th>部门</th>
												<th>记录日期</th>
											</tr>
										</thead>
										<tbody id="contractEvents">
											
										</tbody>
									</table>
								</div>
								<div class="box-footer clearfix">
									<a href="javascript:;" class="btn btn-sm btn-default btn-flat pull-right" data-toggle="modal" data-target="#addEventModal">事件记录</a>
								</div>
							</div>
							<!-- /.tab-pane -->
						</div>
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<tags:main_footer />

		<%-- 右边控制栏 --%>
		<tags:control_sidebar />

	</div>
	<!-- ./wrapper -->

	<%-- 查看电话仓库 --%>
	<div class="modal fade" id="showPhoneRepoModal" tabindex="-1" role="dialog" aria-labelledby="showPhoneRepoModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="showPhoneRepoModalLabel">电话仓库</h4>
				</div>
				<div class="modal-body">					
					<div class="table-responsive">
		                <table class="table no-margin">
							<thead>
							    <tr>
							        <th>是否验证</th>
							        <th>联系类型</th>
							        <th>区号</th>
							        <th>电话号码</th>
							        <th>持有人姓名</th>
							        <th>状态</th>
							    </tr>
							</thead>
							<tbody id="userPhoneRepos">
								
							</tbody>
						</table>
					</div>
					
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnAddContactInfo">新增联系方式</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 查看电话仓库结束 --%>
	
	<%-- 新增联系方式 --%>
	<div class="modal fade" id="addContactInfoModal" role="dialog" aria-labelledby="addContactInfoModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="addContactInfoModalLabel">新增联系方式</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="formAddContactInfo">
						<div class="form-group">
							<label class="col-sm-3 control-label">联系类型</label>
							<div class="col-sm-8">
								<select class="form-control" id="contactType">
									<option value="office">办公电话</option>
									<option value="home">家庭电话</option>
									<option value="emergency">紧急联系电话</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">区号</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="areaCode"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">电话号码</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="phoneNumber"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">持有人姓名</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="holderName"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">状态</label>
							<div class="col-sm-8">
								<select class="form-control" id="repoStatus">
									<option value="enabled">生效的</option>
									<option value="unable">未生效</option>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">是否验证</label>
							<div class="col-sm-8">
								<select class="form-control" id="isValidated">
									<option value="yes">是</option>
									<option value="no">否</option>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnSaveContactInfo">确认保存</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 新增联系方式结束 --%>
	
	<%-- 更新客户地址 --%>
	<div class="modal fade" id="updateAddrModal" role="dialog" aria-labelledby="updateAddrModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="updateAddrModalLabel">更改客户地址</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="formUpdateAddr">
						<%-- <div class="form-group">
							<label class="col-sm-3 control-label">户籍地址</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="idcardAddr" value="${userInfo.familyAddress }"/>
							</div>
						</div> --%>
						<div class="form-group">
							<label class="col-sm-3 control-label">现居住地址</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="residentialAddr" value="${userInfo.address }"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">单位地址</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="companyAddr" value="${userInfo.companyAddress }"/>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnUpdateAddr">确认保存</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 更新客户地址结束 --%>
	
	<%-- 更改银行代扣账户信息 --%>
	<div class="modal fade" id="updateBankInfoModal" role="dialog" aria-labelledby="updateBankInfoModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="updateBankInfoModalLabel">更改银行代扣账户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="formUpdateBankInfo">
						<div class="form-group">
							<label class="col-sm-3 control-label">银行账户</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="bankCard" value="${userInfo.bankCardNo }"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">银行账户开户行</label>
							<div class="col-sm-8">
								<select class="form-control" id="bankName">
								</select>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-3 control-label">是否申请银行代扣</label>
							<div class="col-sm-8 checkbox">
								<label>
									<input type="checkbox"> 是
								</label>
							</div>
						</div> -->
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnUpdateBankInfo">确认保存</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 更改银行代扣账户信息结束 --%>
	
	<%-- 更改合同银行代扣账户信息 --%>
	<div class="modal fade" id="updateContractBankInfoModal" role="dialog" aria-labelledby="updateContractBankInfoLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="updateContractBankInfoLabel">更改银行代扣账户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="formUpdateContractBankInfo">
						<div class="form-group">
							<label class="col-sm-3 control-label">银行账户</label>
							<div class="col-sm-8">
								<input class="form-control" type="text" id="contractBankCard"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">银行账户开户行</label>
							<div class="col-sm-8">
								<select class="form-control"  id="contractBankName">
								
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label">是否申请银行代扣</label>
							<div class="col-sm-8 checkbox">
								<label>
									<input type="checkbox" checked="checked" id="withholdingFlag" value="true"> 是
								</label>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnUpdateContractBankInfo">确认保存</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 更改合同银行代扣账户信息结束 --%>

	<%-- 取消保险开始 --%>
	<div class="modal fade" id="cancelInsuranceModal" tabindex="-1" role="dialog" aria-labelledby="cancelInsuranceModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="cancelInsuranceModalLabel">保险信息</h4>
				</div>
				<div class="modal-body">
					<table class="table">
						<tr>
							<td>保险公司名称</td>
							<td>保险类型</td>
							<td>保险生效时间</td>
							<td>保险截止时间</td>
							<td>保险时间</td>
							<td>操作人</td>
						</tr>
						<tbody>
							<c:forEach var="ite" items="">
								<tr>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
									<td></td>
								<tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" id="btnCancelInsuranceNext" class="btn btn-sm btn-primary btn-flat">取消保险</a>
				</div>
			</div>
		</div>
	</div>
	<%-- 取消保险结束 --%>

	<%-- 取消保险确认框开始 --%>
	<div class="modal fade" id="cancelInsuranceConfirmModal" role="dialog" aria-labelledby="cancelInsuranceConfirmModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="cancelInsuranceConfirmModalLabel">取消保险</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">取消原因</label>
							<div class="col-sm-10">
								<select id="cancelInsuranceReason" class="form-control">
									<option value="不需要">不需要</option>
									<option value="费用高">费用高</option>
									<option value="申请时并不知情">申请时并不知情</option>
									<option value="其他">其他</option>
								</select>
							</div>
						</div>
						<!-- <div class="form-group">
							<label class="col-sm-2 control-label">生效时间</label>
							<div class="col-sm-10">
								<input class="form-control" type="text" id="cancelInsuranceDate" />
							</div>
						</div> -->
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnCancelInsuranceConfirm">确定</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 取消保险确认框结束 --%>

	<%-- 事件记录开始 --%>
	<div class="modal fade" id="addEventModal" role="dialog" aria-labelledby="addEventModalLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="addEventModalLabel">事件记录</h4>
				</div>
				<div class="modal-body">
					<form id="formAddEvent">
						<div class="row">
							<div class="col-sm-2">
								<div class="form-group">
									<label>申请</label>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et01">申请条件</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et02">申请渠道相关</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et03">二次申请咨询</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et04">合同状态查询</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et05">审核进度</label>
									</div>
								</div>
							</div>

							<div class="col-sm-2">
								<div class="form-group">
									<label>商品相关</label>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et06">商品质量咨询</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et07">退换货咨询</label>
									</div>
								</div>
							</div>

							<div class="col-sm-2">
								<div class="form-group">
									<label>还款相关</label>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et08">还款渠道</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et09">还款金额</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et10">提前还款咨询</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et11">还款日期</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et12">款项是否到账</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et13">退款</label>
									</div>
								</div>
							</div>

							<div class="col-sm-2">
								<div class="form-group">
									<label>客户请求</label>
									<!-- <div class="radio">
										<label><input type="radio" name="eventType" value="et14">查询个人信息</label>
									</div> -->
									<div class="radio">
										<label><input type="radio" name="eventType" value="et15">更改个人信息</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et16">投诉</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et17">上传照片</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et18">取消合同</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et19">VOC</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et20">取消保险</label>
									</div>
								</div>
							</div>

							<div class="col-sm-2">
								<div class="form-group">
									<label>回拨</label>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et21">欢迎电话回拨</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et22">审核电话回拨</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et23">短信回拨</label>
									</div>
								</div>
							</div>

							<div class="col-sm-2">
								<div class="form-group">
									<label>闪银相关</label>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et24">放款信息</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et25">修改信息</label>
									</div>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et26">申请相关</label>
									</div>
								</div>
								<div class="form-group">
									<label>其他</label>
									<div class="radio">
										<label><input type="radio" name="eventType" value="et27">其他</label>
									</div>
								</div>
							</div>
						</div>
						
						<div class="form-group">
							<label for="eventContent" class="control-label">详细情况</label>
							<textarea class="form-control" id="eventContent"></textarea>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnAddContractEvent">保存事件</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 事件记录结束 --%>

	<%-- 附件下载开始 --%>
	<div class="modal fade" id="attachDownModal" role="dialog" aria-labelledby="attachDownLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="attachDownLabel">下载附件</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal">
						<div class="form-group">
							<label class="col-sm-2 control-label">附件类型</label>
							<div class="col-sm-10 ">
								<select id="attachType" class="form-control">
									<option value="cancellation_insurance">取消保险申请表</option>
									<option value="customer_info_change">客户信息变更申请表</option>
									<%-- <c:forEach var="item" items="${loanInfo }">
										<option value="${item.contractId }">${item.contractId } - 结清证明</option>
									</c:forEach> --%>
								</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnAttachDown">下载</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 附件下载结束 --%>

	<%-- 活动中心开始 --%>
	<div class="modal fade" id="activityCenterModal" role="dialog" aria-labelledby="activityCenterLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="activityCenterLabel">活动中心</h4>
				</div>
				<div class="box-body">
					<div class="col-sm-6">
						<form method="post" action="${ctx }/customer/contract">
							<div class="form-group">
								<label for="id">客户姓名</label>
								<div>
									<input type="text" class="form-control" id="id" name="id" value="" />
								</div>
							</div>
							<div class="form-group">
								<label for="name">身份证号码</label>
								<div>
									<input type="text" class="form-control" id="idCardNo" name="idCardNo" value="" />
								</div>
							</div>
							<button type="submit" class="btn btn-sm btn-info btn-flat">搜索</button>
						</form>
					</div>
					<div class="col-sm-6">
						<form method="post" action="${ctx }/customer/compians?id=${userInfo.userId}">
							<div class="form-group">
								<label for="roles">封闭式活动</label>
								<div class="input-group">
									<span class="input-group-addon"><input name="activityType" id="activityType1" value="option1" type="radio"></span> 
									<span class="form-control">欢迎电话</span>
								</div>
								<!-- /input-group -->
								<div class="input-group">
									<span class="input-group-addon"><input name="activityType" id="activityType2" value="option2" type="radio"></span> 
									<span class="form-control">营销活动</span>
								</div>
								<!-- /input-group -->
							</div>
							<div class="form-group">
								<label for="roles">开放式活动</label>
								<div class="input-group">
									<span class="input-group-addon"><input name="activityType" id="activityType3" value="option3" type="radio" checked="checked"></span> 
									<span class="form-control">客户投诉</span>
								</div>
								<!-- /input-group -->
								<div class="input-group">
									<span class="input-group-addon"><input name="activityType" id="activityType4" value="option4" type="radio"></span>
									<span class="form-control">退货申请</span>
								</div>
								<!-- /input-group -->
							</div>
							<button type="submit" class="btn btn-sm btn-info btn-flat">指派活动</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- 活动中心结束 --%>
	
	<%-- 提前还款开始 --%>
	<div class="modal fade" id="preRepaymentModal" role="dialog" aria-labelledby="preRepaymentLabel">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="preRepaymentLabel">提前还款</h4>
				</div>
				<div class="box-body">
					<div class="col-xs-12">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<c:forEach var="item" items="${loanInfo}" varStatus="status">
								<li role="presentation" class="${status.index eq 0 ? 'active':''}"><a href="#pre_repay_${item.contractId }" aria-controls="pre_repay_${item.contractId }" role="tab" data-toggle="tab">${item.contractId }</a></li>
							</c:forEach>
						</ul>
						<!-- Tab panes -->
						<div class="tab-content">
							<c:forEach var="item" items="${loanInfo}" varStatus="status">
								<div role="tabpanel" class="tab-pane ${status.index eq 0 ? 'active':''}" id="pre_repay_${item.contractId }">
									<br/>
									<table class="table table-striped">
										<tbody>
											<tr>
												<th width="15%">首付金额</th>
												<td width="35%">${item.downPayment }</td>
												<th width="15%">最晚申请日期</th>
												<td width="35%">--</td>
											</tr>
											<tr>
												<th>贷款本金</th>
												<td>${item.contractAmount }</td>
												<th>提前还款金额</th>
												<td>--</td>
											</tr>
											<tr>
												<th>分期期数</th>
												<td>${item.term }</td>
												<th>最晚到账日</th>
												<td>--</td>
											</tr>
											<tr>
												<th>每月还款金额</th>
												<td>${item.phaseAmount }</td>
												<th></th>
												<td></td>
											</tr>
										</tbody>
									</table>
						              
									<table class="table table-striped">
										<thead>
											<tr>
												<th>费用构成</th>
												<th>分期费用</th>
												<th>提前还款费用</th>
												<th>节省费用</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<th>本金</th>
												<td>--</td>
												<td>--</td>
												<td>--</td>
											</tr>
											<tr>
												<th>利息</th>
												<td>--</td>
												<td>--</td>
												<td>--</td>
											</tr>
											<tr>
												<th>贷款管理费</th>
												<td>--</td>
												<td>--</td>
												<td>--</td>
											</tr>
											<tr>
												<th>客户服务费</th>
												<td>--</td>
												<td>--</td>
												<td>--</td>
											</tr>
											<tr>
												<th>总计</th>
												<td>--</td>
												<td>--</td>
												<td>--</td>
											</tr>
										</tbody>
									</table>
									<div>
										<div class="pull-right">
											<button class="btn btn-sm btn-default btn-flat" onclick="applyPreRepayment('${item.contractId}')"><i class="fa fa-download"></i> 申请提前还款</button>
											<button class="btn btn-sm btn-default btn-flat" onclick="cancelPreRepayment('${item.contractId}')"><i class="fa fa-credit-card"></i> 取消提前还款</button>
											<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
										</div>
									</div>
								</div>
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%-- 提前还款结束 --%>
	
	<%-- 重置密码开始 --%>
	<div class="modal fade" id="resetPasswordModal" role="dialog" aria-labelledby="resetPasswordLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="resetPasswordLabel">重置密码</h4>
				</div>
				<div class="box-body">
					确认重置密码吗？
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
					<button type="button" class="btn btn-sm btn-primary btn-flat" id="btnResetPassword">确认重置</button>
				</div>
			</div>
		</div>
	</div>
	<%-- 重置密码结束 --%>
	
	<tags:load_common_js />
	<script src="${assets}/underscore/underscore.min.js"></script>
	<script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	<script src="${assets}/moment/moment.min.js"></script>
	<script src="${assets}/app/js/datadict.js"></script>
	<script type="text/javascript">
	_.templateSettings = {
		interpolate: /\<\@\=(.+?)\@\>/gim,
	    evaluate: /\<\@(.+?)\@\>/gim,
	    escape: /\<\@\-(.+?)\@\>/gim
	};
	
	var selectedContractId = "${loanInfo[0].contractId}";
	
	function applyPreRepayment(contractNo) {
		$.ajax({
			type : "POST",
			url : "${ctx}/yycore_api/apply_pre_repayment",
			dataType : "json",
			data : {
				userId: "${userInfo.userId}",
				contractId : contractNo,
				idNo: "${userInfo.idCardNo}"
			},
			success : function(data) {
				loadUserEvents(contractNo);
				if (failureProcess("${ctx}", data)) {
					return;
				}
				var resVal = data.value;
				alert("申请提前还款成功" + 
						"\r\n合同编号：" + resVal.contractNo + 
						"\r\n还款金额：" + resVal.totalAmount + 
						"\r\n还款日期：" + resVal.prepaymentDate);
				$("#preRepaymentModal").modal("hide");
			}
		});
	}
	
	function cancelPreRepayment(contractNo) {
		$.ajax({
			type : "POST",
			url : "${ctx}/yycore_api/cancel_pre_repayment",
			dataType : "json",
			data : {
				userId: "${userInfo.userId}",
				contractId : contractNo,
				idNo: "${userInfo.idCardNo}"
			},
			success : function(data) {
				loadUserEvents(contractNo);
				if (failureProcess("${ctx}", data)) {
					return;
				}
				alert("取消提前还款成功");
				$("#preRepaymentModal").modal("hide");
			}
		});
	}
	
	function dateFormat(dateString) {
		return dateString && moment(dateString).format("YYYY-MM-DD");
	}
	
	function loadRepaymentPlans(id){
		// 查询还款信息
		$.ajax({
			type : "POST",
			url : "${ctx}/yycore_api/search_contract_repayments",
			dataType : "json",
			data : {
				contractId : id
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				
				var repayments = data.value;
				var stats = {
					totalPlannedAmount: 0,
					totalPlannedPrincipal: 0,
					totalPlannedInterest: 0,
					totalPlannedOverdueFine: 0,
					totalIndeedAmount: 0,
					totalIndeedPrincipal: 0,
					totalIndeedInterest: 0,
					totalIndeedOverdueFine: 0,
					totalPrepaymentAmount: 0
				};
				_.each(repayments, function(repay){
					stats.totalPlannedAmount += repay.plannedTotalAmount;
					stats.totalPlannedPrincipal += repay.plannedPrinciple;
					stats.totalPlannedInterest += repay.plannedInterest;
					stats.totalPlannedOverdueFine += repay.plannedOverdueFine;
					stats.totalIndeedAmount += repay.indeedTotalAmount;
					stats.totalIndeedPrincipal += repay.indeedPrinciple;
					stats.totalIndeedInterest += repay.indeedInterest;
					stats.totalIndeedOverdueFine += repay.indeedOverdueFine;
					if (repay.indeedTotalAmount > repay.plannedTotalAmount) {
						stats.totalPrepaymentAmount += (repay.indeedTotalAmount - repay.plannedTotalAmount);
					}
				});
				$("#contractRepayments").html(_.template($("#tplContractRepayments").html(), {variable: "model"})({
					repayments: repayments,
					stats: stats
				}));
			}
		});
	}
	
	function loadUserEvents(id) {
		// 查询事件信息
		$.ajax({
			type : "POST",
			url : "${ctx}/contract_event/list_by_contract",
			dataType : "json",
			data : {
				contractId : id
			},
			success : function(data) {
				if (failureProcess("${ctx}", data)) {
					return;
				}
				contractEvents = data.value;
				$("#contractEvents").html(_.template($('#tplContractEvents').html(), contractEvents));
			}
		});
	}
	
	function selectContract(contractId, hasInsurance) {
		if (hasInsurance === "1") {
			$("#btnCancelInsurence").attr("disabled", false);
		} else {
			$("#btnCancelInsurence").attr("disabled", true);
		}
		if (contractId != null) {
			loadRepaymentPlans(contractId);
			loadUserEvents(contractId);
			$("#loanInfos > tr").removeClass("bg-select-contract");
			$("#tr_" + contractId).addClass("bg-select-contract");
			selectedContractId = contractId;
		}
	}
	
	function showNextModal(currentModel, callback) {
		var isShowNext = true;
		$(currentModel).modal("hide").on('hidden.bs.modal', function (e) {
			if(isShowNext){
				callback();
				isShowNext = false;
			}
		});
	}
	
	$(document).ready(function(){		
		selectContract(selectedContractId, "${loanInfo[0].contractGoods[0].hasInsurance}");
		
		$('#cancelInsuranceDate').datepicker({
			format: 'yyyy/mm/dd',
			startDate: '-3d',
			autoclose: true
		});
		
		// 显示电话仓库
		$("#btnShowPhoneRepoModal").click(function(){
			$.ajax({
				type : "POST",
				url : "${ctx}/customer/search_phone_repos",
				dataType : "json",
				data : {
					userId : "${userInfo.userId}"
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					phoneRepos = data.value;
					$("#userPhoneRepos").html(_.template($('#tplUserPhoneRepos').html(), phoneRepos));
					$("#showPhoneRepoModal").modal("show");
				}
			});
		});
		
		// 显示添加电话仓库表单
		$("#btnAddContactInfo").click(function(){
			showNextModal("#showPhoneRepoModal", function(){
				$("#addContactInfoModal").modal("show");
			});
		});
		
		// 保存联系方式
		$("#btnSaveContactInfo").click(function(){
			$.ajax({
				type : "POST",
				url : "${ctx}/customer/save_phone_repo",
				dataType : "json",
				data : {
					customerId : "${userInfo.userId}",
					contactType : $("#contactType").val(),
					phoneAreaCode : $("#areaCode").val(),
					phoneNo : $("#phoneNumber").val(),
					customerName : $("#holderName").val(),
					status : $("#repoStatus").val(),
					isValidated : $("#isValidated").val()
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					alert("添加成功");
					$("#addContactInfoModal").modal("hide");
					document.getElementById("formAddContactInfo").reset();
				}
			});
		});
		
		// 更新客户信息
		$("#btnUpdateAddr").click(function(){
			$.ajax({
				type : "POST",
				url : "${ctx}/yycore_api/change_user_addresses",
				dataType : "json",
				data : {
					userId : "${userInfo.userId}",
					idNo : "${userInfo.idCardNo}",
					//idcardAddr : $("#idcardAddr").val(),
					residentialAddr : $("#residentialAddr").val(),
					companyAddr : $("#companyAddr").val()
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					$("#userHomeAddr").text($("#residentialAddr").val());
					$("#userCompanyAddr").text($("#companyAddr").val());
					alert("更改客户地址信息成功");
					$("#updateAddrModal").modal("hide");
				}
			});
		});
		
		// 更新银行账户信息
		$("#btnUpdateBankInfo").click(function(){
			$.ajax({
				type : "POST",
				url : "${ctx}/yycore_api/change_user_bank_info",
				dataType : "json",
				data : {
					userId : "${userInfo.userId}",
					idNo : "${userInfo.idCardNo}",
					bankCard : $("#bankCard").val(),
					bankName : $("#bankName").val()
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					$("#userBankCard").text($("#bankCard").val());
					$("#userBankName").text($("#bankName").val());
					alert("更新客户银行信息成功");
					$("#updateBankInfoModal").modal("hide");
				}
			});
		});
		
		// 添加事件信息
		$("#btnAddContractEvent").click(function(){
			if("" == selectedContractId){
				alert("请先选择一个合同");
				return;
			}
			$.ajax({
				type : "POST",
				url : "${ctx}/contract_event/add",
				dataType : "json",
				data : {
					contractId : selectedContractId,
					eventType : $("#addEventModal input[name='eventType']:checked").val(),
					eventContent : $("#eventContent").val(),
					contractNo : "${userInfo.userId}"
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					alert("添加成功");
					$("#addEventModal").modal("hide");
					document.getElementById("formAddEvent").reset();
					selectContract(selectedContractId);
				}
			});
		});
		
		// 提前还款
		$("#btnPreRepayment").click(function(){
			if("" == selectedContractId){
				alert("请先选择一个合同");
				return;
			}
			$("#preRepaymentModal").modal("show");
		});
		
		// 更新合同代扣账户
		$("#btnContractBankInfo").click(function(){
			if("" == selectedContractId){
				alert("请先选择一个合同");
				return;
			}
			$.ajax({
				type : "POST",
				url : "${ctx}/yycore_api/search_contract_detial",
				dataType : "json",
				data : {
					contractId : selectedContractId
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					var contract = data.value;
					$("#contractBankCard").val(contract.bankCardNo);
					$("#contractBankName").html(_.template($("#tplBankCodeSelect").html(), {variable: "model"})({
						banks: datadict.bankNameToCodeMap,
						current: "${userInfo.bankName }"
					}));
					$("#updateContractBankInfoModal").modal("show");
				}
			});
		});
		
		// 更新合同代扣账户
		$("#btnUpdateContractBankInfo").click(function(){
			$.ajax({
				type : "POST",
				url : "${ctx}/yycore_api/change_contract_bank_info",
				dataType : "json",
				data : {
					userId : "${userInfo.userId}",
					contractId : selectedContractId,
					idNo : "${userInfo.idCardNo}",
					bankCard : $("#contractBankCard").val(),
					bankName : $("#contractBankName").val(),
					bankCode : datadict.bankNameToCodeMap[$("#contractBankName").val()],
					withholdingFlag: $("#withholdingFlag:checked").val() || false
				},
				success : function(data) {
					loadUserEvents(selectedContractId);
					if (failureProcess("${ctx}", data)) {
						return;
					}
					alert("合同代扣账户更新成功");
					$("#updateContractBankInfoModal").modal("hide");
					document.getElementById("formUpdateContractBankInfo").reset();
				}
			});
		});
		
		// 取消合同保险
		$("#btnCancelInsurence").click(function(){
			if("" == selectedContractId){
				alert("请先选择一个合同");
				return;
			}
			$("#cancelInsuranceModal").modal("show");
		});
		
		$("#btnCancelInsuranceNext").click(function(){
			showNextModal("#cancelInsuranceModal", function() {
				$("#cancelInsuranceConfirmModal").modal("show");
			});
		});
		
		// 取消合同保险
		$("#btnCancelInsuranceConfirm").click(function(){
			if("" == selectedContractId){
				alert("请先选择一个合同");
				return;
			}
			$.ajax({
				type : "POST",
				url : "${ctx}/yycore_api/cancel_contract_insurence",
				dataType : "json",
				data : {
					userId : "${userInfo.userId}",
					contractId : selectedContractId,
					idNo : "${userInfo.idCardNo}",
					reason : $("#cancelInsuranceReason").val()
				},
				success : function(data) {
					loadUserEvents(selectedContractId);
					if (failureProcess("${ctx}", data)) {
						return;
					}
					alert("取消合同保险成功");
					$("#cancelInsuranceConfirmModal").modal("hide");
				}
			});
		});
		
		// 密码重置
		$("#btnResetPassword").click(function(){
			$.ajax({
				type : "POST",
				url : "${ctx}/yycore_api/reset_query_password",
				dataType : "json",
				data : {
					mobile : "${userInfo.mobile }",
				},
				success : function(data) {
					if (failureProcess("${ctx}", data)) {
						return;
					}
					alert("重置密码成功");
					$("#resetPasswordModal").modal("hide");
				}
			});
		});
		
		// 附件下载
		$("#btnAttachDown").click(function(){
			var attachType = $("#attachType").val();
			if (attachType === "cancellation_insurance") {
				location.href = "${assets}/docs/cancellation_insurance.docx";
			} else if (attachType === "customer_info_change") {
				location.href = "${assets}/docs/customer_info_change.docx";
			} else {
				alert("Coming soon!!!");
			}
			$("#attachDownModal").modal("hide");
		});
		
		$("#bankName").html(_.template($("#tplBankCodeSelect").html(), {variable: "model"})({
			banks: datadict.bankNameToCodeMap,
			current: "${userInfo.bankName }"
		}));
	});
    </script>
    
	<!-- 还款信息显示模板 -->
	<script type="text/template" id="tplContractRepayments">
	<@ _.each(model.repayments, function (repay) { @>
		<tr>
			<td><@= repay.period @></td>
			<td><@= dateFormat(repay.plannedDate) @></td>
			<td><@= (0 + repay.plannedTotalAmount).toFixed(2) @></td>
			<td><@= (0 + repay.plannedPrinciple).toFixed(2) @></td>
			<td><@= (0 + repay.plannedInterest).toFixed(2) @></td>
			<td><@= (0 + repay.plannedStampDuty).toFixed(2) @></td>
			<td><@= (0 + repay.plannedClientCharge).toFixed(2) @></td>
			<td><@= (0 + repay.plannedInsurance).toFixed(2) @></td>
			<td><@= (0 + repay.plannedOverdueFine).toFixed(2) @></td>
			<td><@= (0 + repay.indeedTotalAmount).toFixed(2) @></td>
			<td><@= dateFormat(repay.repayDate) @></td>
		</tr>
	<@ }); @>
	<tr>
		<td colspan="11">
			<table class="table table-bordered" style="margin-bottom: 0px; ">
				<tbody>
					<tr>
						<td class="td-stat-label">剩余总金额</td>
						<td><@= (model.stats.totalPlannedAmount - model.stats.totalIndeedAmount).toFixed(2) @></td>
						<td class="td-stat-label">剩余本金</td>
						<td><@= (model.stats.totalPlannedPrincipal).toFixed(2) @></td>
						<td class="td-stat-label">剩余利息</td>
						<td><@= (model.stats.totalPlannedInterest).toFixed(2) @></td>
						<td class="td-stat-label">剩余滞纳金</td>
						<td><@= (model.stats.totalPlannedOverdueFine).toFixed(2) @></td>
						<td class="td-stat-label">预付金额</td>
						<td><@= (model.stats.totalPrepaymentAmount).toFixed(2) @></td>
					</tr>
					<tr>
						<td class="td-stat-label">已付总金额</td>
						<td><@= (model.stats.totalIndeedAmount).toFixed(2) @></td>
						<td class="td-stat-label">已付本金</td>
						<td><@= (model.stats.totalIndeedPrincipal).toFixed(2) @></td>
						<td class="td-stat-label">已付利息</td>
						<td><@= (model.stats.totalIndeedInterest).toFixed(2) @></td>
						<td class="td-stat-label">已付滞纳金</td>
						<td colspan="3"><@= (model.stats.totalIndeedOverdueFine).toFixed(2) @></td>
					</tr>
				</tbody>
			</table>
		</td>
	</tr>
	</script>

	<!-- 电话仓库显示模板 -->
	<script type="text/template" id="tplUserPhoneRepos">
	<@ _.each(phoneRepos, function (repo) { @>
		<tr>
			<td><@= datadict.phoneValidStatus[repo.isValidated] @></td>
			<td><@= datadict.phoneRepoType[repo.contactType] @></td>
			<td><@= repo.phoneAreaCode @></td>
			<td><@= repo.phoneNo @></td>
			<td><@= repo.customerName @></td>
			<td><@= datadict.phoneRepoStatus[repo.status] @></td>
		</tr>
	<@ }); @>
	</script>
	
	<!-- 合同事件显示模板 -->
	<script type="text/template" id="tplContractEvents">
	<@ _.each(contractEvents, function (evt) { @>
		<tr>
			<td><@= evt.contractId @></td>
			<td><@= datadict.eventType[evt.eventType] @></td>
			<td><@= evt.eventContent @></td>
			<td><@= evt.createdBy @></td>
			<td><@= evt.department @></td>
			<td><@= formatString(evt.createdAt, "####-##-## ##:##:##") @></td>
		</tr>
	<@ }); @>
	</script>
	
	<!-- 用户银行下拉列表模板 -->
	<script type="text/template" id="tplBankCodeSelect">
	<@ for(var key in model.banks){ @>
		<option value="<@= key @>" <@= (model.current === key ? 'selected="selected"' : null) @>><@= key @></option>
	<@ }; @>
	</script>
</body>
</html>
