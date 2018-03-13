<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
	<title>综合管理系统 | 会员更新</title>
	<tags:head_common_content/>
	<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	<link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

		<!-- Main header -->
		<tags:main_header/>
		
		<!-- Left side column. contains the logo and sidebar -->
		<tags:main_sidebar active="assistant"/>
      
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<div class="context-tips">
				<tags:action_tip/>
			</div>
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>会员更新</h1>
				<ol class="breadcrumb">
					<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
					<li><a href="#">会员&积分</a></li>
					<li class="active">会员更新</li>
				</ol>
			</section>

			<!-- Main content -->
			<section class="content">
				<form id="assistantForm" class="form-horizontal" method="post" action="${ctx }/member/update">
					<div class="box box-primary">
			 			<div class="box-header with-border">
			       			<h3 class="box-title">会员信息</h3>
						</div><!-- /.box-header -->
						<div class="box-body">
						<input type="hidden" value="${item.hwMemberId }" id="hwMemberId" name="hwMemberId"/>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwMemberId}" readonly="readonly"/>
										</div>
									</div>
									
									<div class="form-group">
										<label for="hwRegistTime" class="col-sm-3 control-label">注册时间</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.hwRegistTime}" readonly="readonly"/>
										</div>
									</div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="cbCustomerIdno" class="col-sm-3 control-label">身份证号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbCustomerIdno}" readonly="readonly"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbCardholderName" class="col-sm-3 control-label">持卡人姓名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" value="${item.cbCardholderName}" readonly="readonly"/>
										</div>
									</div>
								</div>
							</div>
						</div><!-- /.box-body -->
					</div>
			        
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">会员更新</h3>
						</div><!-- /.box-header -->
						<div class="box-body">            
							<div class="col-sm-6">
								<div class="row">
									<div class="form-group">
										<label for="cbMobileNo" class="col-sm-3 control-label">手机号<font color="red">*</font></label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbMobileNo" name="cbMobileNo" value="${item.cbMobileNo}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbQualification" class="col-sm-3 control-label">学历</label>
										<div class="col-sm-8">
											<select id="cbQualification" name="cbQualification" class="form-control">
									    		<option value="1" ${item.cbQualification eq '1' ? 'selected':'' }>研究生</option>
									    		<option value="2" ${item.cbQualification eq '2' ? 'selected':'' }>本科</option>
									    		<option value="3" ${item.cbQualification eq '3' ? 'selected':'' }>大学</option>
									    		<option value="4" ${item.cbQualification eq '4' ? 'selected':'' }>大专</option>
									    		<option value="5" ${item.cbQualification eq '5' ? 'selected':'' }>高中</option>
									    		<option value="6" ${item.cbQualification eq '6' ? 'selected':'' }>中专</option>
									    		<option value="7" ${item.cbQualification eq '7' ? 'selected':'' }>初中</option>
									    		<option value="8" ${item.cbQualification eq '8' ? 'selected':'' }>小学</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbHomeCity" class="col-sm-3 control-label">所在城市</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbHomeCity" name="cbHomeCity" value="${item.cbHomeCity}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbHomeAddr1" class="col-sm-3 control-label">家庭地址</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbHomeAddr1" name="cbHomeAddr1" value="${item.cbHomeAddr1}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbHomePostcode" class="col-sm-3 control-label">家庭邮编</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbHomePostcode" name="cbHomePostcode" value="${item.cbHomePostcode}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbNationality" class="col-sm-3 control-label">国籍</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbNationality" name="cbNationality" value="${item.cbNationality}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbPrOfCountry" class="col-sm-3 control-label">永久居住国家</label>
										<div class="col-sm-8">
											<select id="cbPrOfCountry" name="cbPrOfCountry" class="form-control">
									    		<option value="1" ${item.cbPrOfCountry eq '1' ? 'selected':'' }>中国</option>
									    		<option value="2" ${item.cbPrOfCountry eq '2' ? 'selected':'' }>美国</option>
									    		<option value="3" ${item.cbPrOfCountry eq '3' ? 'selected':'' }>俄罗斯</option>
									    		<option value="4" ${item.cbPrOfCountry eq '4' ? 'selected':'' }>日本</option>
									    		<option value="5" ${item.cbPrOfCountry eq '5' ? 'selected':'' }>英国</option>
									    		<option value="6" ${item.cbPrOfCountry eq '6' ? 'selected':'' }>法国</option>
									    		<option value="7" ${item.cbPrOfCountry eq '7' ? 'selected':'' }>蒙古</option>
									    		<option value="8" ${item.cbPrOfCountry eq '8' ? 'selected':'' }>泰国</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbMaritalStatus" class="col-sm-3 control-label">婚姻状况</label>
										<div class="col-sm-8">
											<select id="cbMaritalStatus" name="cbMaritalStatus" class="form-control">
									    		<option value="1" ${item.cbMaritalStatus eq '1' ? 'selected':'' }>是</option>
									    		<option value="2" ${item.cbMaritalStatus eq '2' ? 'selected':'' }>否</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbSocialStatus" class="col-sm-3 control-label">社会状况</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbSocialStatus" name="cbSocialStatus" value="${item.cbSocialStatus}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbCompanyName" class="col-sm-3 control-label">公司名称</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbCompanyName" name="cbCompanyName" value="${item.cbCompanyName}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbCoAddr1" class="col-sm-3 control-label">公司地址</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbCoAddr1" name="cbCoAddr1" value="${item.cbCoAddr1}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbCoDesgn" class="col-sm-3 control-label">职务</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbCoDesgn" name="cbCoDesgn" value="${item.cbCoDesgn}"/>
										</div>
									</div>
									<div class="form-group">
									    <label for="hwPlateNumber1" class="col-sm-3 control-label">车牌号1</label>
									    <div class="col-sm-8">
									    	<input type="text" class="form-control" id="hwPlateNumber1" name="hwPlateNumber1" value="${item.hwPlateNumber1}"/>
									    </div>
									</div>
									<div class="form-group">
			   							<label for="hwPlateNumber2" class="col-sm-3 control-label">车牌号2</label>
			   							<div class="col-sm-8">
			     							<input type="text" class="form-control" id="hwPlateNumber2" name="hwPlateNumber2" value="${item.hwPlateNumber2}"/>
			    						</div>
									</div>
									<div class="form-group">
									    <label for="hwStatus" class="col-sm-3 control-label">状况<font color="red">*</font></label>
									    <div class="col-sm-8">
									    	<select id="hwStatus" name="hwStatus" class="form-control">
									    		<option value="01" ${item.hwStatus eq '01' ? 'selected':'' }>正常</option>
									    		<option value="02" ${item.hwStatus eq '02' ? 'selected':'' }>冻结</option>
									    	</select>
								    	</div>
									</div>
									<div class="form-group">
									    <label for="hwAffiliatedMember" class="col-sm-3 control-label">所属会员</label>
									    <div class="col-sm-8">
									    	<input type="text" class="form-control" id="hwAffiliatedMember" name="hwAffiliatedMember" value="${item.hwAffiliatedMember}"/>
										</div>
									</div>
									<div class="form-group">
									    <label for="hwMemberType" class="col-sm-3 control-label">会员类型</label>
									    <div class="col-sm-8">
											<input type="text" class="form-control" id="hwMemberType" name="hwMemberType" value="${item.hwMemberType}"/>
									    </div>
									</div>
									<div class="form-group">
									    <label for="hwMemberGrade" class="col-sm-3 control-label">会员等级</label>
									    <div class="col-sm-8">
											<input type="text" class="form-control" id="hwMemberGrade" name="hwMemberGrade" value="${item.hwMemberGrade}"/>
								    	</div>
									</div>
									<div class="form-group">
										<label for="hwBlockedBalances" class="col-sm-3 control-label">冻结金额余额</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwBlockedBalances" id="hwBlockedBalances" value="${item.hwBlockedBalances}"/>
										</div>
								    </div>
								</div>
							</div>
							<div class="col-sm-6">
								<div class="row">
								    <div class="form-group">
										<label for="cbEngName" class="col-sm-3 control-label">英文名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbEngName" name="cbEngName" value="${item.cbEngName}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbEmail" class="col-sm-3 control-label">邮箱<font color="red">*</font></label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbEmail" name="cbEmail" value="${item.cbEmail}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbSpouseName" class="col-sm-3 control-label">配偶姓名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbSpouseName" name="cbSpouseName" value="${item.cbSpouseName}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbSpouseNric" class="col-sm-3 control-label">配偶身份证</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbSpouseNric" name="cbSpouseNric" value="${item.cbSpouseNric}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbSpouseEmployName" class="col-sm-3 control-label">配偶公司名称</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbSpouseEmployName" name="cbSpouseEmployName" value="${item.cbSpouseEmployName}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelName" class="col-sm-3 control-label">亲属姓名</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbRelName" name="cbRelName" value="${item.cbRelName}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelNric" class="col-sm-3 control-label">亲属身份证号</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbRelNric" name="cbRelNric" value="${item.cbRelNric}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelSex" class="col-sm-3 control-label">亲属性别</label>
										<div class="col-sm-8">
											<select id="cbRelSex" name="cbRelSex" class="form-control">
									    		<option value="1" ${item.cbRelSex eq '1' ? 'selected':'' }>男</option>
									    		<option value="2" ${item.cbRelSex eq '2' ? 'selected':'' }>女</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelRelationToCh" class="col-sm-3 control-label">亲属与持卡人关系</label>
										<div class="col-sm-8">
											<select id="cbRelRelationToCh" name="cbRelRelationToCh" class="form-control">
									    		<option value="1" ${item.cbRelRelationToCh eq '1' ? 'selected':'' }>父子</option>
									    		<option value="2" ${item.cbRelRelationToCh eq '2' ? 'selected':'' }>父女</option>
									    		<option value="3" ${item.cbRelRelationToCh eq '3' ? 'selected':'' }>母子</option>
									    		<option value="4" ${item.cbRelRelationToCh eq '4' ? 'selected':'' }>母女</option>
									    		<option value="5" ${item.cbRelRelationToCh eq '5' ? 'selected':'' }>姐妹</option>
									    		<option value="6" ${item.cbRelRelationToCh eq '6' ? 'selected':'' }>兄妹</option>
									    		<option value="7" ${item.cbRelRelationToCh eq '7' ? 'selected':'' }>兄弟</option>
									    	</select>
										</div>
									</div>
									<div class="form-group">
										<label for="cbRelTelno" class="col-sm-3 control-label">亲属电话</label>
										<div class="col-sm-8">
											<input type="text" class="form-control" id="cbRelTelno" name="cbRelTelno" value="${item.cbRelTelno}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwDepositBalance" class="col-sm-3 control-label">押金余额</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwDepositBalance" id="hwDepositBalance" value="${item.hwDepositBalance}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwFrozenDepositBalance" class="col-sm-3 control-label">冻结押金余额金额</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwFrozenDepositBalance" id="hwFrozenDepositBalance" value="${item.hwFrozenDepositBalance}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwLimit" class="col-sm-3 control-label">限额</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwLimit" id="hwLimit" value="${item.hwLimit}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwIntegral" class="col-sm-3 control-label">积分</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwIntegral" id="hwIntegral" value="${item.hwIntegral}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankNo1" class="col-sm-3 control-label">绑定第1张银行卡</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwBankNo1" id="hwBankNo1" value="${item.hwBankNo1}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankAddress1" class="col-sm-3 control-label">银行卡1开户行</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwBankAddress1" id="hwBankAddress1" value="${item.hwBankAddress1}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankNo2" class="col-sm-3 control-label">绑定第2张银行卡</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwBankNo2" id="hwBankNo2" value="${item.hwBankNo2}"/>
										</div>
									</div>
									<div class="form-group">
										<label for="hwBankAddress2" class="col-sm-3 control-label">银行卡2开户行</label>
										<div class="col-sm-8" >
											<input type="text" class="form-control" name="hwBankAddress2" id="hwBankAddress2" value="${item.hwBankAddress2}"/>
										</div>
									</div>
									<div class="form-group">
								    	<label for="hwBalance" class="col-sm-3 control-label">余额</label>
								    	<div class="col-sm-8">
								    		<input type="text" class="form-control" id="hwBalance" name="hwBalance" value="${item.hwBalance}"/>
								    	</div>
									</div>
								</div>
							</div>
						</div>
			
						<div class="box-footer">
				            <div class="pull-right">
								<button type="submit" class="btn btn-info btn-flat"><i class="fa fa-plus"></i> 更新</button>	                    	
				                <a type="button" class="btn btn-default btn-flat" href="${ctx }/member/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
							</div>
						</div><!-- /.box-footer -->
					</div>
				</form>
			</section><!-- /.content -->
		</div><!-- /.content-wrapper -->
		
		<!-- Footer Sidebar -->
		<tags:main_footer/>
	
		<!-- Control Sidebar -->
		<tags:control_sidebar/>
		
	</div><!-- ./wrapper -->
    
    <tags:load_common_js/>
    <script src="${assets}/datepicker/datepicker.js"></script>
	<script src="${assets}/datepicker/locales/zh-CN.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
	$(document).ready(function(){
		
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				valid: 'glyphicon glyphicon-ok',         
 				invalid: 'glyphicon glyphicon-remove',         
 				validating: 'glyphicon glyphicon-refresh'    
 			},
 			fields: {
 				 id: {
 					message: '员工ID无效',
					validators: {
						notEmpty: {
							message: '员工ID无效'                  
						},
						stringLength: {
							min: 0,
							max: 20,
							message: '员工ID无效不能超过20个字符'       
							},
					}
 				}, 
 				cbCustomerIdno: {
 					message: '身份证号码无效',
					validators: {
						notEmpty: {
							message: '身份证不能为空'                  
						},
						stringLength: {
							min: 0,
							max: 18,
							message: '身份证号码不能超过18个字符'       
							},
						regexp:{
							regexp: /^[1-9]{1}[0-9]{14}$|^[1-9]{1}[0-9]{16}([0-9]|[xX])$/,
							message: '请输入正确的身份证号码，身份证号码为15或18个字符' 
						},
					}
 				},
 				cbIdType: {
 					validators: {
 						notEmpty: {
							message: '证件类型不能为空'
							}
 					}
 				},
 				cbCardholderName: {
 					validators: {
 						notEmpty: {
							message: '持卡人姓名不能为空'
							}
 					}
 				},
 				hwStatus: {
 					validators: {
 						notEmpty: {
							message: '状况不能为空'
							}
 					}
 				},
 				cbEmail: {
 					validators:{
 						notEmpty: {
							message: '邮箱不能为空'                  
						},
 						regexp: {
 							regexp: /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+.+[a-z]{2,4}$/,
 							message: '您输入的邮箱地址不正确，请重新输入！'
 						}
 					}
 				},
 				cbMobileNo: {
 					validators:{
 						notEmpty: {
							message: '手机号码不能为空'                  
						},
 						regexp: {
	 						regexp: /(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/,
	 						message: '您输入的手机号码不正确，请重新输入！'
	 					}
 					}
 				}
 			}
   		});
   		
	});
    
    </script>
</body>
</html>
