<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 会员添加</title>
    <tags:head_common_content/>
    <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
    <link rel="stylesheet" href="${assets}/validator/css/validator.css"/>
  </head>
  <body class="hold-transition skin-blue-light sidebar-mini">
    <div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="profile"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>会员添加</h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="#">会员&积分</a></li>
            <li class="active">会员添加</li>
          </ol>
        </section>

        <!-- Main content -->
        <section class="content">
          	<div class="box box-primary">
          		<div class="box-header with-border">
                  <h3 class="box-title"><i class="fa fa-plus"></i> 添加表单</h3>
                </div><!-- /.box-header -->
                <form  id="stafffrom"  class="form-horizontal" method="post" action="${ctx }/member/add">
                	<div class="box-body">
                		<div class="col-sm-6">
                			<div class="row">
                			<!-- 
                			    <div class="form-group">
								    <label for="hwMemberId" class="col-sm-3 control-label">会员ID</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwMemberId" name="hwMemberId" value="${item.hwMemberId}"  readonly="readonly"/>
								    </div>
								</div>
								 -->
	                			<div class="form-group">
								    <label for="cbCustomerIdno" class="col-sm-3 control-label">身份证号<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbCustomerIdno" name="cbCustomerIdno" title="不能为空" value="${item.cbCustomerIdno}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbEmail" class="col-sm-3 control-label">邮箱<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbEmail" name="cbEmail" value="${item.cbEmail}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbIdType" class="col-sm-3 control-label">证件类型<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select id="cbIdType" name="cbIdType" class="form-control" >
								                <option value="">请选择</option>
									    		<option value="1" ${item.cbIdType eq '1' ? 'selected':''}>身份证</option>
									    		<option value="2" ${item.cbIdType eq '2' ? 'selected':''}>军官证</option>
									    		<option value="3" ${item.cbIdType eq '3' ? 'selected':''}>护照</option>
									    	</select>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbMobileNo" class="col-sm-3 control-label">手机号码<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbMobileNo" name="cbMobileNo" value="${item.cbMobileNo}"/>
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
								    <label for="hwBalance" class="col-sm-3 control-label">余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwBalance" name="hwBalance" value="${item.hwBalance}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwBlockedBalances" class="col-sm-3 control-label">冻结金额余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwBlockedBalances" name="hwBlockedBalances" value="${item.hwBlockedBalances}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwDepositBalance" class="col-sm-3 control-label">押金余额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwDepositBalance" name="hwDepositBalance" value="${item.hwDepositBalance}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwFrozenDepositBalance" class="col-sm-3 control-label">冻结押金余额金额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwFrozenDepositBalance" name="hwFrozenDepositBalance" value="${item.hwFrozenDepositBalance}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwLimit" class="col-sm-3 control-label">限额</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwLimit" name="hwLimit" value="${item.hwLimit}"/>
								    </div>
								</div>
                			</div>
                		</div>
                		<div class="col-sm-6">
                			<div class="row">
                			    <div class="form-group">
								    <label for="cbCardholderName" class="col-sm-3 control-label">持卡人姓名<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="cbCardholderName" name="cbCardholderName"  title="不能为空"  value="${item.cbCardholderName}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="cbSex" class="col-sm-3 control-label">性别</label>
								    <div class="col-sm-8">
								      	<label class="radio-inline">
										  	<input type="radio" name="cbSex" id="cbSex" value="1" checked="checked">男
										</label>
										<label class="radio-inline">
										  	<input type="radio" name="cbSex" id="cbSex" value="2">女
										</label>
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
								    <label for="hwAffiliatedMember" class="col-sm-3 control-label">所属会员</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwAffiliatedMember" name="hwAffiliatedMember" value="${item.hwAffiliatedMember}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwIntegral" class="col-sm-3 control-label">积分</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwIntegral" name="hwIntegral" value="${item.hwIntegral}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwBankNo1" class="col-sm-3 control-label">绑定第1张银行卡卡号</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwBankNo1" name="hwBankNo1" value="${item.hwBankNo1}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwBankAddress1" class="col-sm-3 control-label">银行卡1开户行</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwBankAddress1" name="hwBankAddress1" value="${item.hwBankAddress1}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwBankNo2" class="col-sm-3 control-label">绑定第2张银行卡卡号</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwBankNo2" name="hwBankNo2" value="${item.hwBankNo2}"/>
								    </div>
								</div>
								<div class="form-group">
								    <label for="hwBankAddress2" class="col-sm-3 control-label">银行卡2开户行</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwBankAddress2" name="hwBankAddress2" value="${item.hwBankAddress2}"/>
								    </div>
								</div>
								<!-- 
								<div class="form-group">
								    <label for="hwRegistTime" class="col-sm-3 control-label">注册时间</label>
								    <div class="col-sm-8">
								      <input type="text" class="form-control" id="hwRegistTime" name="hwRegistTime" value="${item.hwRegistTime}" readonly="readonly"/>
								    </div>
								</div>
								 -->
								<div class="form-group">
								    <label for="hwStatus" class="col-sm-3 control-label">状况<font color="red">*</font></label>
								    <div class="col-sm-8">
								      <select id="hwStatus" name="hwStatus" class="form-control" >
								                <option value="">请选择</option>
									    		<option value="1" ${item.hwStatus eq '1' ? 'selected':''}>正常</option>
									    		<option value="2" ${item.hwStatus eq '2' ? 'selected':''}>冻结</option>
									    	</select>
								    </div>
								</div>
                			</div>
                		</div>
					</div>
					<div class="box-footer">
					 	<div class="col-sm-10 ">						
						</div>
						<div class="col-sm-1 ">	
							<button id="addButton" type="submit" class="btn btn-info pull-right"><i class="fa fa-plus"></i> 添加</button>	                    	
	                    </div>
	                    <div class="col-sm-1 ">
	                    	<a type="button" class="btn btn-default pull-right" href="${ctx }/ywmember/list"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
	                    </div>	                 	
	                </div><!-- /.box-footer -->
	        	</form>
			</div>
			</section>
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
