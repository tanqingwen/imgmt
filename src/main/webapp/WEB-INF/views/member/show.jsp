<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<title>综合管理系统 |会员详情</title>
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
				<h1>会员查看</h1>
				<ol class="breadcrumb">
					<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="${ctx }/startTreeviewDetail/hygl">会员管理</a></li>
					<li><a href="${ctx }/member/list">会员列表</a></li>
					<li class="active">会员查看</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<form id="assistantForm" class="form-horizontal" method="" action="">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">
								<i class="box-title"></i> 会员详情
							</h3>
						</div>
						<!-- /.box-header -->
						<div class="box-body">
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwMemberId}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbCardholderName" class="col-sm-3 control-label">持卡人姓名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbCardholderName}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbSex" class="col-sm-3 control-label">性别</label>
										<div class="col-sm-8">
											<select id="cbSex" name="cbSex" class="form-control" disabled="disabled">
									    		<option value="1" ${item.cbSex eq '1' ? 'selected':''}>男</option>
									    		<option value="2" ${item.cbSex eq '2' ? 'selected':''}>女</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbDob" class="col-sm-3 control-label">生日</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbDob}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbQualification" class="col-sm-3 control-label">学历</label>
										<div class="col-sm-8">
											<select id="cbQualification" name="cbQualification" class="form-control" disabled="disabled">
									    		<option value="1" ${item.cbQualification eq '1' ? 'selected':''}>研究生</option>
									    		<option value="2" ${item.cbQualification eq '2' ? 'selected':''}>本科</option>
									    		<option value="3" ${item.cbQualification eq '3' ? 'selected':''}>大学</option>
									    		<option value="4" ${item.cbQualification eq '4' ? 'selected':''}>大专</option>
									    		<option value="5" ${item.cbQualification eq '5' ? 'selected':''}>高中</option>
									    		<option value="6" ${item.cbQualification eq '6' ? 'selected':''}>中专</option>
									    		<option value="7" ${item.cbQualification eq '7' ? 'selected':''}>初中</option>
									    		<option value="8" ${item.cbQualification eq '8' ? 'selected':''}>小学</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbHomeCity" class="col-sm-3 control-label">所在城市</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbHomeCity}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbHomeAddr1" class="col-sm-3 control-label">家庭地址</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbHomeAddr1}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbHomePostcode" class="col-sm-3 control-label">家庭邮编</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbHomePostcode}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbNationality" class="col-sm-3 control-label">国籍</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbNationality}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbPrOfCountry" class="col-sm-3 control-label">永久居住国家</label>
										<div class="col-sm-8">
											<select id="cbPrOfCountry" name="cbPrOfCountry" class="form-control" disabled="disabled">
									    		<option value="1" ${item.cbPrOfCountry eq '1' ? 'selected':''}>中国</option>
									    		<option value="2" ${item.cbPrOfCountry eq '2' ? 'selected':''}>美国</option>
									    		<option value="3" ${item.cbPrOfCountry eq '3' ? 'selected':''}>俄罗斯</option>
									    		<option value="4" ${item.cbPrOfCountry eq '4' ? 'selected':''}>日本</option>
									    		<option value="5" ${item.cbPrOfCountry eq '5' ? 'selected':''}>英国</option>
									    		<option value="6" ${item.cbPrOfCountry eq '6' ? 'selected':''}>法国</option>
									    		<option value="7" ${item.cbPrOfCountry eq '7' ? 'selected':''}>蒙古</option>
									    		<option value="8" ${item.cbPrOfCountry eq '8' ? 'selected':''}>泰国</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbMaritalStatus" class="col-sm-3 control-label">婚姻状况</label>
										<div class="col-sm-8">
											<select id="cbMaritalStatus" name="cbMaritalStatus" class="form-control" disabled="disabled">
									    		<option value="1" ${item.cbMaritalStatus eq '1' ? 'selected':''}>是</option>
									    		<option value="2" ${item.cbMaritalStatus eq '2' ? 'selected':''}>否</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbSocialStatus" class="col-sm-3 control-label">社会状况</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbSocialStatus}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbCompanyName" class="col-sm-3 control-label">公司名称</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbCompanyName}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbCoAddr1" class="col-sm-3 control-label">公司地址</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbCoAddr1}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbCoDesgn" class="col-sm-3 control-label">职务</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbCoDesgn}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbMobileNo" class="col-sm-3 control-label">手机号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbMobileNo}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwPlateNumber1" class="col-sm-3 control-label">车牌号1</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwPlateNumber1}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwPlateNumber2" class="col-sm-3 control-label">车牌号2</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwPlateNumber2}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwStatus" class="col-sm-3 control-label">状况</label>
										<div class="col-sm-8">
											<select id="hwStatus" name="hwStatus" class="form-control" disabled="disabled">
									    		<option value="1" ${item.hwStatus eq '1' ? 'selected':''}>正常</option>
									    		<option value="2" ${item.hwStatus eq '2' ? 'selected':''}>冻结</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="hwAffiliatedMember" class="col-sm-3 control-label">所属会员</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwAffiliatedMember}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwMemberType" class="col-sm-3 control-label">会员类型</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwMemberType}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwMemberGrade" class="col-sm-3 control-label">会员等级</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwMemberGrade}" readonly="readonly" />
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="cbIdType" class="col-sm-3 control-label">证件类型</label>
										<div class="col-sm-8">
											<select id="cbIdType" name="cbIdType" class="form-control" disabled="disabled">
									    		<option value="1" ${item.cbIdType eq '1' ? 'selected':''}>身份证</option>
									    		<option value="2" ${item.cbIdType eq '2' ? 'selected':''}>军官证</option>
									    		<option value="3" ${item.cbIdType eq '3' ? 'selected':''}>护照</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbCustomerIdno" class="col-sm-3 control-label">证件号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbCustomerIdno}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbEngName" class="col-sm-3 control-label">英文名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbEngName}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbEmail" class="col-sm-3 control-label">邮箱</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbEmail}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbSpouseName" class="col-sm-3 control-label">配偶姓名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbSpouseName}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbSpouseNric" class="col-sm-3 control-label">配偶身份证</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbSpouseNric}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbSpouseEmployName" class="col-sm-3 control-label">配偶公司名称</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbSpouseEmployName}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelName" class="col-sm-3 control-label">亲属姓名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbRelName}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelNric" class="col-sm-3 control-label">亲属身份证号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbRelNric}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelSex" class="col-sm-3 control-label">亲属性别</label>
										<div class="col-sm-8">
											<select id="cbRelSex" name="cbRelSex" class="form-control" disabled="disabled">
									    		<option value="1" ${item.cbRelSex eq '1' ? 'selected':''}>男</option>
									    		<option value="2" ${item.cbRelSex eq '2' ? 'selected':''}>女</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelRelationToCh" class="col-sm-3 control-label">亲属与持卡人关系</label>
										<div class="col-sm-8">
											<select id="cbRelRelationToCh" name="cbRelRelationToCh" class="form-control" disabled="disabled">
									    		<option value="1" ${item.cbRelRelationToCh eq '1' ? 'selected':''}>父子</option>
									    		<option value="2" ${item.cbRelRelationToCh eq '2' ? 'selected':''}>父女</option>
									    		<option value="3" ${item.cbRelRelationToCh eq '3' ? 'selected':''}>母子</option>
									    		<option value="4" ${item.cbRelRelationToCh eq '4' ? 'selected':''}>母女</option>
									    		<option value="5" ${item.cbRelRelationToCh eq '5' ? 'selected':''}>姐妹</option>
									    		<option value="6" ${item.cbRelRelationToCh eq '6' ? 'selected':''}>兄妹</option>
									    		<option value="7" ${item.cbRelRelationToCh eq '7' ? 'selected':''}>兄弟</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelTelno" class="col-sm-3 control-label">亲属电话</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbRelTelno}" readonly="readonly" />
										</div>
									</div>
									<div class="form-group">
										<label for="hwBlockedBalances" class="col-sm-3 control-label">冻结金额余额</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwBlockedBalances}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwDepositBalance" class="col-sm-3 control-label">押金余额</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwDepositBalance}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwFrozenDepositBalance" class="col-sm-3 control-label">冻结押金金额余额</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwFrozenDepositBalance}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwLimit" class="col-sm-3 control-label">限额</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwLimit}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwIntegral" class="col-sm-3 control-label">积分</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwIntegral}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankNo1" class="col-sm-3 control-label">绑定第1张银行卡</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwBankNo1}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankAddress1" class="col-sm-3 control-label">银行卡1开户行</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwBankAddress1}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankNo2" class="col-sm-3 control-label">绑定第2张银行卡</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwBankNo2}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankAddress2" class="col-sm-3 control-label">银行卡2开户行</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwBankAddress2}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwRegistTime" class="col-sm-3 control-label">注册时间</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwRegistTime}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBalance" class="col-sm-3 control-label">余额</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwBalance}" readonly="readonly" />
										</div>
									</div>
								</div>
							</div>
						</div>
						<!-- /.box-body -->
						<div class="box-footer">
							<a type="submit" class="btn btn-default pull-right" href="${ctx }/member/list"><i class="glyphicon glyphicon-chevron-left"></i> 返回</a>
						</div>
						<!-- /.box-footer -->
					</div>
				</form>
			</section>


		</div>
	</div>
	<!-- /.box -->
	<!-- /.content-wrapper -->
	<tags:main_footer />

	<!-- Control Sidebar -->
	<tags:control_sidebar />
	<!-- ./wrapper -->

	<tags:load_common_js />
</body>
</html>
