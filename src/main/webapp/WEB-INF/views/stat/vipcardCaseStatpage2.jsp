<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 会员卡情况统计</title>
		<tags:head_common_content/>		
		<link rel="stylesheet" href="${assets}/datepicker/datepicker3.css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="vipCaseStat"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>会员卡情况统计</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/tjbb">统计报表</a></li>
						<li class="active">会员卡情况统计</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
		                <div class="box-header with-border">
		                  <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>		                  
		                </div><!-- /.box-header -->
		                <!-- form start -->
		                <form class="form-horizontal" id="thisform" action="" method="post">
		                  <div class="box-body">
		                  	<div class="col-sm-6">
			                	<div class="form-group date firstCommission">
									<label for="cbAnnivDateStart" class="col-sm-3 control-label">开始时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
											<input readonly  class="form-control" id="cbAnnivDateStart" name="cbAnnivDateStart" value="${cbAnnivDateStart }" onchange="buttonds()" style="width: 133.5%"/>
	                                	</div>
	                                </div>
								</div>
							</div>
							<div class="col-sm-6">								
								<div class="form-group date firstCommission">
									<label for="cbAnnivDateEnd" class="col-sm-3 control-label">结束时间 </label>
									<div class="col-sm-7">
									    <div class="input-group date firstCommission">
											<span class="input-group-addon">
												<span class="glyphicon glyphicon-calendar"></span>
											</span>
	                                    	<input readonly class="form-control" id="cbAnnivDateEnd" name="cbAnnivDateEnd" value="${cbAnnivDateEnd }" onchange="buttonds()" style="width: 133.5%"/>
	                                    </div>
	                                </div>
								</div>
							</div>
		                  	<div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbCardholderNo" class="col-sm-3 control-label">卡号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cbCardholderNo" name="cbCardholderNo" placeholder="卡号" value="${cbCardholderNo }" oninput="buttonds()" type="text">
			                      </div>
			                    </div>
		                    </div>
							<div class="col-sm-6">
			                    <div class="form-group">
				                      <label for="prGroupDesc" class="col-sm-3 control-label">卡类型</label>
				                      <div class="col-sm-9">
				                      	<input type="hidden" id="prGroupDesctext" value="${prGroupDesc }"/>
				                      	<select class="form-control" id="prGroupDesc" name="prGroupDesc" onchange="buttonds()">
				                        	<option value="" >===请选择===</option>
									    	<c:forEach var="prdGrp" items="${prdGrpList}">
									      	   <option value="${prdGrp.prGroupDesc }" >${prdGrp.prProdctGroup }--${prdGrp.prGroupDesc }</option>
									      	</c:forEach>
									    </select>
				                      </div>
				                </div>
			                </div>
			                <div class="col-sm-6">
			                    <div class="form-group">
				                      <label for="cbPlasticCd" class="col-sm-3 control-label">卡状态</label>
				                      <div class="col-sm-9">
				                        <select class="form-control" id="cbPlasticCd" name="cbPlasticCd" onchange="buttonds()">
				                        	<option value="" ${cbPlasticCd eq '' ? 'selected' : ''}>===请选择===</option>
									    	<option value="NOP" ${cbPlasticCd eq 'NOP' ? 'selected' : ''}>正常</option>
									    	<option value="L" ${cbPlasticCd eq 'L' ? 'selected' : ''}>挂失</option>
									    	<option value="D" ${cbPlasticCd eq 'D' ? 'selected' : ''}>退卡</option>
									    </select>
				                      </div>
				                </div>
			                </div>
			                <div class="col-sm-6">
			                    <div class="form-group">
			                      <label for="cbIdno" class="col-sm-3 control-label">卡主证件号</label>
			                      <div class="col-sm-9">
			                        <input class="form-control" id="cbIdno" name="cbIdno" placeholder="卡号" value="${cbIdno }" oninput="buttonds()" type="text">
			                      </div>
			                    </div>
		                    </div>
		                  </div><!-- /.box-body -->
		                  <div class="box-footer">
		                  	<div class="pull-right">
			                    <button type="submit" class="btn btn-info " id="theIdForSubmit"><i class="fa fa-search"></i> 查询</button>
			                    <a type="button" class="btn btn-info" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a>
			                    <c:if test="${app:checkPermission('VIPCARDSTAT_VIPCASESTAT_DOWNLOAD') }">
			                    	<button type="submit" class="btn btn-info " id="downLoad"><i class="fa fa-search"></i> 下载</button>
			                    </c:if>
		                    </div>
		                  </div><!-- /.box-footer -->
		                </form>
			        </div><!-- /.box -->
				
					<div class="row">
						<div class="col-md-12">
							<div class="box box-info">
								<div class="box-header with-border">
									<h3 class="box-title"><i class="fa fa-list"></i> 查询列表</h3>
									<div class="box-tools pull-right">
								        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
								    </div>
								</div><!-- /.box-header -->
				                <div class="box-body">
					                <div class="table-responsive">
						                <table class="table table-striped">
											<thead>
											    <tr>
				                                    <th>卡号</th>
				                                    <th>卡类型</th>
				                                    <th>卡状态</th>
				                                    <th>余额</th>
				                                    <th>日期</th>
				                                    <th>卡有效期</th>
				                                    <th>卡主证件类型</th>
				                                    <th>卡主证件号</th>
											    </tr>
											</thead>
											<tbody>
												<c:forEach var="item" items="${pageInfo.list}" varStatus="status">
												<tr>											
													<td>${item.cbCardholderNo}</td>
													<td>${item.prGroupDesc}</td>
				                                    <td>${item.cbPlasticCd}</td>
				                                    <td>${item.cbOutstdBal}</td>
				                                    <td>${item.cbAnnivDate}</td>
													<td>${item.cbExpiryCcyymm}</td>
				                                    <td>${item.cbIdDesc}</td>
				                                    <td>${item.cbIdno}</td>
												</tr>
											</c:forEach>
											</tbody>
										</table>
									</div>
				                </div><!-- /.box-body -->
					
								<div class="box-footer clearfix">
									<tags:pagination url="${ctx}/vipcardStat/vipCaseStat" queryString="cbAnnivDateStart=${cbAnnivDateStart }&cbAnnivDateEnd=${cbAnnivDateEnd }&cbCardholderNo=${cbCardholderNo }&prGroupDesc=${prGroupDesc }&cbPlasticCd=${cbPlasticCd }&cbIdno=${cbIdno }" page="${pageInfo}" cssClass="pull-right"/>
								</div>
							</div><!-- /.box -->
						</div><!-- /.col -->
					</div><!-- /.row -->
				</section><!-- /.content -->
			</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>
		<script src="${assets}/datepicker/locales/date.js"></script>
		<script src="${assets}/datepicker/locales/zh-CN.js"></script>
	    <script src="${assets}/validator/js/validator.js"></script>
	    <script src="${assets}/pdata/pdata.js"></script>
	    <script type="text/javascript">
	    function buttonds (){
	    	$("#downLoad").attr("disabled",true);
	    }
		    $(document).ready(function(){
				$('.firstCommission').datepicker({
		   			format: 'yyyymmdd',
					autoclose: true,
					todayBtn : "linked",  
			        autoclose : true,  
			        todayHighlight : true,  
			    });
				
				$("#theIdForSubmit").click(function(){
					var cbAnnivDateStart = $("#cbAnnivDateStart").val();
					var cbAnnivDateEnd = $("#cbAnnivDateEnd").val();
					if(cbAnnivDateStart != "" && cbAnnivDateEnd != ""){
						if(Number(cbAnnivDateStart)>Number(cbAnnivDateEnd)){
							alert("开始时间不可以大于结束时间！");
							return false;
						}
					}
					$("#thisform").attr("action", "${ctx}/vipcardStat/vipCaseStat");
					$("#downLoad").attr("disabled",false);
				});
				$("#downLoad").click(function(){
					$("#thisform").attr("action", "${ctx}/vipcardStat/vipCaseStatDownLoad");
				});
			});
		    $(function () {
		    	if($("#prGroupDesctext").val()==""){
		    		$("#prGroupDesc").val($("#prGroupDesc option:first").val());
		    	}else{
		    		$("#prGroupDesc").val($("#prGroupDesctext").val());
		    	}
		    });
	    </script>
	</body>
</html>
