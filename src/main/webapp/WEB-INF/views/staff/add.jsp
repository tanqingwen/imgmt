<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta http-equiv="X-UA-Compatible" content="IE=edge" />
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets }/css/others.css" />
		<title>综合管理系统 | 员工添加</title>

	</head>

	<body class="hold-transition skin-blue-light sidebar-mini">
	
	<div class="wrapper">

	  <!-- Main header -->
      <tags:main_header/>
      
      <!-- Left side column. contains the logo and sidebar -->
      <tags:main_sidebar active="staff"/>
      
      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
      	<div class="context-tips">
      		<tags:action_tip/>
      	</div>
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>员工添加</h1>
          <ol class="breadcrumb">
            <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
            <li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
            <li><a href="${ctx }/staff/list">员工管理</a></li>
            <li class="active">员工添加</li>
          </ol>
        </section>
	
		<div class="container-fluid common staffAdd">
			<div class="row">
				<div class="tip-img">
					<p>员工添加</p>
				</div>
				<div class="content">
					<div class="main">
						<h3 style="border-bottom: 2px dashed #45a0e0;">添加表单</h3>
						<form class="form-inline form-horizontal" id="stafffrom" method="post" action="${ctx }/staff/add">
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工ID<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="id" name="id" title="不能为空"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>登录密码<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="password" name="password" />
									</div>
								</div>
							</div>

							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工部门<span class="color-red">*</span>:</label>
										<select id="organizations"  name="organizations" class="line-input">
											<c:forEach var="org" items="${organizations}"> 
	 									      	 <option value="${org.deptId }" >${org.deptId }--${org.deptName }</option>
	 									      </c:forEach>
										</select>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>员工姓名<span class="color-red">*</span>:</label>
										<input class="form-control formConl line-input" type="text" id="name" name="name"/>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工邮箱:</label>
										<input class="form-control formConl line-input" type="text" id="email" name="email"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="radio-inline" for="inlineRadioOptions">员工性别:</label>
										<label class="radio-inline">
  											<input type="radio" name="gender" id="gender" value="Male"> 男
										</label>
										<label class="radio-inline">
  											<input type="radio" name="gender" id="gender" value="Female"> 女
										</label>
									</div>
								</div>
							</div>
								<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>电话号码:</label>
										<input class="form-control formConl line-input" type="text" id="phoneNumber" name="phoneNumber"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label>员工卡号:</label>
										<input class="form-control formConl line-input cardNumWidth" type="text" id="totpKey" name="totpKey"/>
										<button class="btn btn-size readStaffCard" onclick="mifareOneCard()">读卡</button>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="col-md-6">
									<div class="form-group">
										<label>员工状态:</label>
										<select id="status" name="status" class="line-input">
											<option value="NORMAL">正常</option>
								    		<option value="LOCK">锁定</option>
								    		<option value="CANCEL">注销</option>
										</select>
									</div>
								</div>
							</div>
						

						<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">角色列表</h3>
						<div class="clearfix tableContent roleContent">
							<div class="roleList col-md-12">
							<c:forEach var="item" items="${roles }">
								<div class="col-md-6">
									<div class="listBox"><span class="listBoxLeft col-md-1 text-center">
									<input type="checkbox" name="roles" value="${item.id }"/></span>
									<span class="col-md-8">${item.name }</span></div>
								</div>
							</c:forEach>	
							</div>
						</div>
						<div class="col-lg-12 submit-group marginBottom">
							<a href="${ctx }/staff/list" class="form-a">&lt;返回</a>
							<div class="btn-group fr">
								<button id="addButton" type="submit" class="btn-size" style="width:110px;">添加</button>

							</div>
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
    <script src="${assets}/datepicker/datepicker.js"></script>
    <script src="${assets}/validator/js/validator.js"></script>
    <script type="text/javascript">
     var MWRFATL = new ActiveXObject("MWREADERRF.mwReaderRfCtrl.1"); //启用控件
        //打开读写器
        function readerOpen() {
            try {
		
                var version = MWRFATL.openReader(1, 9600);
		
                if (MWRFATL.LastRet != 0) {
                   // msg.value = "打开读写器失败" + "\n";
                    return;
                }
                else {
                   // msg.value = version + "\n";
                }

                MWRFATL.readerLoadKey(0, 0, "A0A1A2A3A4A5"); //加载1扇区密码,对M1卡操作时使用加载密码认证
                if (MWRFATL.LastRet != 0) {
                   // msg.value = msg.value + "1扇区加载密码失败" + "\n";
                }
            }
            catch (e) {
                //alert(e.Message);
            }
        }

      

      
        //M1卡操作
        function mifareOneCard() {
        	readerOpen();
            try {
                var result = MWRFATL.openCard(1, 10);  //打开卡片,以10进制字符串显示卡号
                if (MWRFATL.LastRet != 0) {
                	alert("打开卡片失败!");
                   // msg.value = msg.value + "打开卡片失败" + "\n";
                    return;
                }
                else {
                	document.getElementById("totpKey").value=result;
                    //msg.value = msg.value + "打开卡片成功,卡片序列号: " + result + "\n";
                }
            }
            catch (e) {
                alert(e.Message);
            }
            readerClose() ;
        }
        function readerClose() {
            try {
                var result = MWRFATL.closeReader();
            }
            catch (e) {
                alert(e.Message);
            }
        }

        
    </script>
    <script type="text/javascript">
	$(document).ready(function(){
		
		$('#stafffrom').bootstrapValidator({
   			message: 'This value is not valid',   
   			feedbackIcons: {
 				 
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
 				password: {
					validators: {
						notEmpty: {
							message: '登陆密码不能为空'
							},
							stringLength: {
								min: 6,
								max: 20,
								message: '员工密码不能少于6位'       
							},
					}
 				},
 				organizations: {
 					validators: {
 						notEmpty: {
							message: '员工机构不能为空'
							}
 					}
 				},
 				name: {
 					validators: {
 						notEmpty: {
							message: '员工姓名不能为空'
							}
 					}
 				},
 				email: {
 					validators:{
 						notEmpty: {
							message: '邮箱不能为空'
							},
 						regexp: {
 							regexp: /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+.+[a-z]{2,4}$/,
 							message: '请输入正确邮箱地址'
 						}
 					}
 				},
 				phoneNumber: {
 					validators:{
	 					notEmpty: {
							message: '手机号码不能为空'
							},
						regexp: {
	 						regexp: /^1[34578]\d{9}$/,
	 						message: '请输入正确的电话号码'
	 					}
 					}
 				}
 			}
   		});
   		
	});
    
	$(function () {
		$("#addButton").click(function(){
			var role=document.getElementsByName("roles"); 
			var m=0; var n=false; 
			for(var i=0;i<role.length;i++){ 
				if(role[i].checked){ 
					n=true; m++;
				}
			}
			if(!n){
				alert("请至少选择一个用户角色");
				//role[0].checked = true;
				return false;
			}
			var password =$("#password");		 
			password.val(CryptoJS.MD5(password.val()));			 	
		});
	});
	
	
    </script>
	</body>

</html>