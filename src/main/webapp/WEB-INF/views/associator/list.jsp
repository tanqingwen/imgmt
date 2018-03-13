<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 | 会员注册</title>
<tags:head_common_content />
</head>
<body class="hold-transition skin-blue-light sidebar-mini">
	<div class="wrapper">
		<!-- Main header -->
		<tags:main_header />

		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="staff" />

		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip />
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>会员列表</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">会员&积分</a></li>
					<li class="active">会员列表</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<div class="box box-primary">
					<div class="box-header with-border">
						<h3 class="box-title">
							<i class="fa fa-search"></i> 查询表单
						</h3>
						<div class="box-tools">
							<c:if test="${app:checkPermission('STAFF_ADD') }"><a class="btn pull-right" href="${ctx}/associator/add"><i class="fa fa-plus"></i> 添加</a>
							</c:if>
						</div>
					</div>
					<!-- /.box-header -->
					<!-- form start -->
					<form class="form-horizontal">
						<div class="box-body">
							<div class="col-sm-6">
								<div class="form-group">
									<label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
									<div class="col-sm-9">
										<input class="form-control" id="hwMemberId" name="hwMemberId" placeholder="会员ID" type="text">
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="cbCustomerIdno" class="col-sm-3 control-label">身份证号</label>
									<div class="col-sm-9">
										<input class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" placeholder="身份证号" type="text">
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="cbCardholderName" class="col-sm-3 control-label">持卡人姓名</label>
									<div class="col-sm-9">
										<input class="form-control" id="cbCardholderName" name="cbCardholderName" placeholder="持卡人姓名" type="text">
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="form-group">
									<label for="cbMobileNo" class="col-sm-3 control-label">手机号码</label>
									<div class="col-sm-9">
										<input class="form-control" id="cbMobileNo" name="cbMobileNo" placeholder="手机号码" type="text">
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<button type="submit" class="btn btn-info pull-right"><i class="fa fa-search"></i>查询</button>
						</div>
						<!-- /.box-footer -->
					</form>
				</div>
				<!-- /.box -->

				<div class="row">
					<div class="col-md-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title"><i class="fa fa-list"></i>会员列表 </h3>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								</div>
							</div>
							<!-- /.box-header -->
							<div class="box-body">
								<div class="table-responsive">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>会员ID</th>
												<th>身份证号</th>
												<th>持卡人姓名</th>
												<th>证件类型</th>
												<th>手机号码</th>
												<th>性别</th>
												<th>状态</th>
												<th>邮箱</th>
												<th>注册时间</th>
												<th class="text-right">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach var="item" items="${pageInfo.list}">
												<tr>
													<td>${item.hwMemberId}</td>
													<td>${item.cbCustomerIdno}</td>
													<td>${item.cbCardholderName}</td>
													<td>
													    <c:choose>
															<c:when test="${item.cbIdType == '1'}">身份证</c:when>
															<c:when test="${item.cbIdType == '2'}">军官证</c:when>
															<c:when test="${item.cbIdType == '3'}">护照</c:when>
														</c:choose>
													</td>
													<td>${item.cbMobileNo}</td>
													<td>
														<c:choose>
															<c:when test="${item.cbSex == '1'}">男</c:when>
															<c:when test="${item.cbSex == '2'}">女</c:when>
														</c:choose>
													</td>
													<td><c:choose>
															<c:when test="${item.hwStatus == '1'}">正常</c:when>
															<c:when test="${item.hwStatus == '2'}">冻结</c:when>
														</c:choose></td>
													<td>${item.cbEmail}</td>
													<td>${item.hwRegistTime}</td>
													<td>
														<div class="btn-toolbar pull-right" role="toolbar">
															<div class="btn-group">
																<c:if test="${app:checkPermission('STAFF_UPDATE') }">
																	<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/associator/update?id=${item.hwMemberId}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
																</c:if>
																
																<c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<button type="button" class="btn btn-default btn-xs" title="查看" onclick="showMemberModal('${item.hwMemberId}');"><i class="fa fa-fw fa-eye" aria-hidden="true"></i>
																	</button>
																</c:if>
																 <!--
																 <c:if test="${app:checkPermission('STAFF_SHOW') }">
																	<a type="button" class="btn btn-default btn-xs" title="查看" href="${ctx}/associator/show?id=${item.hwMemberId}"><i class="fa fa-fw fa-eye" aria-hidden="true"></i></a>
																</c:if>
																   -->
																<c:if
																	test="${app:checkPermission('ORGANIZATION_DELETE')}">
																	<a type="button" class="btn btn-default btn-xs" title="删除" href="${ctx}/associator/delete?id=${item.hwMemberId}" onclick="return confirm('确认删除?')"><i class="glyphicon glyphicon-trash" aria-hidden="true"></i></a>
																</c:if>
															</div>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							<!-- /.box-body -->


							<!-- sample modal content -->
							<div id="myModal" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-lg" style="width:1200px;">
									<div class="modal-content">
										<div class="modal-header">
											<button type="button" class="close" data-dismiss="modal">
												<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
											</button>
											<h4 class="modal-title" id="myModalLabel">会员详情</h4>
										</div>
										<form id="assistantForm" class="form-horizontal" method="" action="">
											
												<div class="col-sm-6">
													<div class="row">
														<div class="form-group">
															<label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalMemberId" name="hwMemberId" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="hwMemberId" class="col-sm-3 control-label">持卡人姓名</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalCardName" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbSex" class="col-sm-3 control-label">性别</label>
															<div class="col-sm-8">
																<select id="modalSex" name="modalSex" class="form-control" disabled="disabled">
														    		<option value="1" ${item.modalSex eq '1' ? 'selected':''}>男</option>
														    		<option value="2" ${item.modalSex eq '2' ? 'selected':''}>女</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="cbDob" class="col-sm-3 control-label">生日</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalDob" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbQualification" class="col-sm-3 control-label">学历</label>
															<div class="col-sm-8">
																<select id="modalQualification" name="modalQualification" class="form-control" disabled="disabled">
														    		<option value="1" ${item.modalQualification eq '1' ? 'selected':''}>研究生</option>
														    		<option value="2" ${item.modalQualification eq '2' ? 'selected':''}>本科</option>
														    		<option value="3" ${item.modalQualification eq '3' ? 'selected':''}>大学</option>
														    		<option value="4" ${item.modalQualification eq '4' ? 'selected':''}>大专</option>
														    		<option value="5" ${item.modalQualification eq '5' ? 'selected':''}>高中</option>
														    		<option value="6" ${item.modalQualification eq '6' ? 'selected':''}>中专</option>
														    		<option value="7" ${item.modalQualification eq '7' ? 'selected':''}>初中</option>
														    		<option value="8" ${item.modalQualification eq '8' ? 'selected':''}>小学</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="cbHomeCity" class="col-sm-3 control-label">所在城市</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalHomeCity" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbHomeAddr1" class="col-sm-3 control-label">家庭地址</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalHomeAddr1" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbHomePostcode" class="col-sm-3 control-label">家庭邮编</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalHomePostcode" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbNationality" class="col-sm-3 control-label">国籍</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalNationality" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbPrOfCountry" class="col-sm-3 control-label">永久居住国家</label>
															<div class="col-sm-8">
																<select id="modalPrOfCountry" name="modalPrOfCountry" class="form-control" disabled="disabled">
														    		<option value="1" ${item.modalPrOfCountry eq '1' ? 'selected':''}>中国</option>
														    		<option value="2" ${item.modalPrOfCountry eq '2' ? 'selected':''}>美国</option>
														    		<option value="3" ${item.modalPrOfCountry eq '3' ? 'selected':''}>俄罗斯</option>
														    		<option value="4" ${item.modalPrOfCountry eq '4' ? 'selected':''}>日本</option>
														    		<option value="5" ${item.modalPrOfCountry eq '5' ? 'selected':''}>英国</option>
														    		<option value="6" ${item.modalPrOfCountry eq '6' ? 'selected':''}>法国</option>
														    		<option value="7" ${item.modalPrOfCountry eq '7' ? 'selected':''}>蒙古</option>
														    		<option value="8" ${item.modalPrOfCountry eq '8' ? 'selected':''}>泰国</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="cbMaritalStatus" class="col-sm-3 control-label">婚姻状况</label>
															<div class="col-sm-8">
																<select id="modalMaritalStatus" name="modalMaritalStatus" class="form-control" disabled="disabled">
														    		<option value="1" ${item.modalMaritalStatus eq '1' ? 'selected':''}>是</option>
														    		<option value="2" ${item.modalMaritalStatus eq '2' ? 'selected':''}>否</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="cbSocialStatus" class="col-sm-3 control-label">社会状况</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalSocialStatus" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbCompanyName" class="col-sm-3 control-label">公司名称</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalCompanyName" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbCoAddr1" class="col-sm-3 control-label">公司地址</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalCoAddr1" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbCoDesgn" class="col-sm-3 control-label">职务</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalCoDesgn" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbMobileNo" class="col-sm-3 control-label">手机号</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalMobileNo" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="hwPlateNumber1" class="col-sm-3 control-label">车牌号1</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalPlateNumber1" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="hwPlateNumber2" class="col-sm-3 control-label">车牌号2</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalPlateNumber2" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="hwStatus" class="col-sm-3 control-label">状况</label>
															<div class="col-sm-8">
																<select id="modalStatus" name="modalStatus" class="form-control" disabled="disabled">
														    		<option value="01" ${item.modalStatus eq '01' ? 'selected':''}>正常</option>
														    		<option value="02" ${item.modalStatus eq '02' ? 'selected':''}>冻结</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="hwAffiliatedMember" class="col-sm-3 control-label">所属会员</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalAffiliatedMember" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="hwMemberType" class="col-sm-3 control-label">会员类型</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalMemberType" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="hwMemberGrade" class="col-sm-3 control-label">会员等级</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalMemberGrade" readonly="readonly" />
															</div>
														</div>
													</div>
												</div>
												<div class="col-sm-6">
													<div class="row">
														<div class="form-group">
															<label for="cbIdType" class="col-sm-3 control-label">证件类型</label>
															<div class="col-sm-8">
																<select id="modalIdType" name="modalIdType" class="form-control" disabled="disabled">
														    		<option value="1" ${item.modalIdType eq '1' ? 'selected':''}>身份证</option>
														    		<option value="2" ${item.modalIdType eq '2' ? 'selected':''}>军官证</option>
														    		<option value="3" ${item.modalIdType eq '3' ? 'selected':''}>护照</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="hwMemberId" class="col-sm-3 control-label">证件号</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalIdno" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbEngName" class="col-sm-3 control-label">英文名</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalEngName" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbEmail" class="col-sm-3 control-label">邮箱</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalEmail" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbSpouseName" class="col-sm-3 control-label">配偶姓名</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalSpouseName" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbSpouseNric" class="col-sm-3 control-label">配偶身份证</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalSpouseNric" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbSpouseEmployName" class="col-sm-3 control-label">配偶公司名称</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalSpouseEmployName" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbRelName" class="col-sm-3 control-label">亲属姓名</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalRelName" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbRelNric" class="col-sm-3 control-label">亲属身份证号</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalRelNric" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="cbRelSex" class="col-sm-3 control-label">亲属性别</label>
															<div class="col-sm-8">
																<select id="modalRelSex" name="modalRelSex" class="form-control" disabled="disabled">
														    		<option value="1" ${item.modalRelSex eq '1' ? 'selected':''}>男</option>
														    		<option value="2" ${item.modalRelSex eq '2' ? 'selected':''}>女</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="cbRelRelationToCh" class="col-sm-3 control-label">亲属与持卡人关系</label>
															<div class="col-sm-8">
																<select id="modalRelRelationToCh" name="modalRelRelationToCh" class="form-control" disabled="disabled">
														    		<option value="1" ${item.modalRelRelationToCh eq '1' ? 'selected':''}>父子</option>
														    		<option value="2" ${item.modalRelRelationToCh eq '2' ? 'selected':''}>父女</option>
														    		<option value="3" ${item.modalRelRelationToCh eq '3' ? 'selected':''}>母子</option>
														    		<option value="4" ${item.modalRelRelationToCh eq '4' ? 'selected':''}>母女</option>
														    		<option value="5" ${item.modalRelRelationToCh eq '5' ? 'selected':''}>姐妹</option>
														    		<option value="6" ${item.modalRelRelationToCh eq '6' ? 'selected':''}>兄妹</option>
														    		<option value="7" ${item.modalRelRelationToCh eq '7' ? 'selected':''}>兄弟</option>
														    	</select>
															</div>
														</div>
														<div class="form-group">
															<label for="cbRelTelno" class="col-sm-3 control-label">亲属电话</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalRelTelno" readonly="readonly" />
															</div>
														</div>
														<div class="form-group">
															<label for="hwBlockedBalances" class="col-sm-3 control-label">冻结金额余额</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalBlockedBalances" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwDepositBalance" class="col-sm-3 control-label">押金余额</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalDepositBalance" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwFrozenDepositBalance" class="col-sm-3 control-label">冻结押金金额余额</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalFrozenDepositBalance" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwLimit" class="col-sm-3 control-label">限额</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalLimit" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwIntegral" class="col-sm-3 control-label">积分</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalIntegral" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwBankNo1" class="col-sm-3 control-label">绑定第1张银行卡</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalBankNo1" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwBankAddress1" class="col-sm-3 control-label">银行卡1开户行</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalBankAddress1" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwBankNo2" class="col-sm-3 control-label">绑定第2张银行卡</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalBankNo2" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwBankAddress2" class="col-sm-3 control-label">银行卡2开户行</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalBankAddress2" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwRegistTime" class="col-sm-3 control-label">注册时间</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalRegistTime" readonly="readonly"/>
															</div>
														</div>
														<div class="form-group">
															<label for="hwBalance" class="col-sm-3 control-label">余额</label>
															<div class="col-sm-8">
																<input type="text" class="form-control" id="modalBalance" readonly="readonly" />
															</div>
														</div>
													</div>
												</div>
                                              </form>
										
										<div class="modal-footer">
											<button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
										</div>

									</div>
									<!-- /.modal-content -->
								</div>
								<!-- /.modal-dialog -->
							</div>
							<!-- /.modal -->


							<div class="box-footer clearfix">
								<tags:pagination url="${ctx}/associator/list" page="${pageInfo}" cssClass="pull-right" />
							</div>
						</div>
						<!-- /.box -->
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</section>
			<!-- /.content -->
		</div>
		<!-- /.content-wrapper -->

		<!-- Main footer -->
		<tags:main_footer />

		<!-- Control Sidebar -->
		<tags:control_sidebar />

	</div>
	<!-- ./wrapper -->

	<tags:load_common_js />
	
	<script type="text/javascript">
	function showMemberModal(hwMemberId) {
		if("" == hwMemberId) {
			alert("会员号不能为空！！！");
			return false;
		}
		$.ajax({
			type: "GET",
			url:"${ctx}/associator/query_member_by_id",
			data: {
				memberId: hwMemberId
			},
			dataType:'json',
			success:function(data){
				$("#modalMemberId").val(data.hwMemberId);
				$("#modalCardName").val(data.cbCardholderName);
				$("#modalIdno").val(data.cbCustomerIdno);
				$("#modalIdType").val(data.cbIdType);
				$("#modalMobileNo").val(data.cbMobileNo);
				$("#modalSex").val(data.cbSex);
				$("#modalDob").val(data.cbDob);
				$("#modalQualification").val(data.cbQualification);
				$("#modalHomeCity").val(data.cbHomeCity);
				$("#modalHomeAddr1").val(data.cbHomeAddr1);
				$("#modalHomePostcode").val(data.cbHomePostcode);
				$("#modalNationality").val(data.cbNationality);
				$("#modalPrOfCountry").val(data.cbPrOfCountry);
				$("#modalMaritalStatus").val(data.cbMaritalStatus);
				$("#modalSocialStatus").val(data.cbSocialStatus);
				$("#modalCompanyName").val(data.cbCompanyName);
				$("#modalCoAddr1").val(data.cbCoAddr1);
				$("#modalCoDesgn").val(data.cbCoDesgn);
				$("#modalMobileNo").val(data.cbMobileNo);
				$("#modalPlateNumber1").val(data.hwPlateNumber1);
				$("#modalPlateNumber2").val(data.hwPlateNumber2);
				$("#modalStatus").val(data.hwStatus);
				$("#modalAffiliatedMember").val(data.hwAffiliatedMember);
				$("#modalMemberType").val(data.hwMemberType);
				$("#modalMemberGrade").val(data.hwMemberGrade);
				$("#modalEngName").val(data.cbEngName);
				$("#modalEmail").val(data.cbEmail);
				$("#modalSpouseName").val(data.cbSpouseName);
				$("#modalSpouseNric").val(data.cbSpouseNric);
				$("#modalSpouseEmployName").val(data.cbSpouseEmployName);
				$("#modalRelName").val(data.cbRelName);
				$("#modalRelNric").val(data.cbRelNric);
				$("#modalRelSex").val(data.cbRelSex);
				$("#modalRelRelationToCh").val(data.cbRelRelationToCh);
				$("#modalRelTelno").val(data.cbRelTelno);
				$("#modalBlockedBalances").val(data.hwBlockedBalances);
				$("#modalDepositBalance").val(data.hwDepositBalance);
				$("#modalFrozenDepositBalance").val(data.hwFrozenDepositBalance);
				$("#modalLimit").val(data.hwLimit);
				$("#modalIntegral").val(data.hwIntegral);
				$("#modalBankNo1").val(data.hwBankNo1);
				$("#modalBankAddress1").val(data.hwBankAddress1);
				$("#modalBankNo2").val(data.hwBankNo2);
				$("#modalBankAddress2").val(data.hwBankAddress2);
				$("#modalRegistTime").val(data.hwRegistTime);
				$("#modalBalance").val(data.hwBalance);
		        $("#myModal").modal('show');
			}
		});
	};
	$(document).ready(function(){
		if($('body').hasClass('sidebar-collapse')){
			$('body').removeClass('sidebar-collapse');
		}
		
	});
</script>
</body>
</html>
