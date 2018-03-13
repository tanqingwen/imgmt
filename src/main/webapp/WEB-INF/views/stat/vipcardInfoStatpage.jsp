<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 
<!DOCTYPE html> 
<html> 
    <head> 
        <title>综合管理系统  | 会员卡信息查询</title> 
        <tags:head_common_content/>         
        <link rel="stylesheet" href="${assets}/datepicker/datepicker3.css"> 
        <link rel="stylesheet" type="${assets}/yewuchaxun/text/css" href="css/bootstrap.min.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/layer.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/model.css" />
		<link rel="stylesheet" href="${assets}/yewuchaxun/css/memberCardInfo.css">
    </head> 
    <body class="hold-transition skin-blue-light sidebar-mini"> 
        <div class="wrapper"> 
            <!-- Main header --> 
            <tags:main_header/> 
            <!-- Left side column. contains the logo and sidebar --> 
            <tags:main_sidebar active="vipInfoStat"/> 
            <!-- Content Wrapper. Contains page content --> 
            <div class="content-wrapper"> 
                <div class="context-tips"> 
                      <tags:action_tip/> 
                  </div> 
                <!-- Content Header (Page header) --> 
                <section class="content-header"> 
                    <h1>会员卡信息查询</h1> 
                    <ol class="breadcrumb"> 
                        <li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li> 
                        <li><a href="${ctx }/startTreeviewDetail/ywcx">业务查询</a></li> 
                        <li class="active">会员卡信息查询</li> 
                    </ol> 
                </section> 
                <!-- Main content --> 
         <div class="container-fluid gateReviewList vipInfoCheck">
			<div class="row outer-wrap">
				<div class="tip-img reviewList">
				<!-- 	<p>会员等级</p> -->
				</div>
				<div class="content">
					<div class="main">

						<h3 style="border-bottom: 2px dashed #45a0e0;">查询表单</h3>

						<form  class="form-horizontal" id="thisform" action="${ctx}/vipcardStat/vipInfoStat">
							
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label for="cbCardholderNo">卡号：</label>
											<input class="form-control formConl line-input" id="cbCardholderNo" name="cbCardholderNo" placeholder="卡号" value="${cbCardholderNo }" type="text" />
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label for="cbEmbossname">姓名：</label>
											<input class="form-control formConl line-input" id="cbEmbossname" name="cbEmbossname" placeholder="姓名" value="${cbEmbossname }" type="text" />
										</div>
									</div>
								</div>
								<%-- <div class="col-md-6">
									<label>手机号码：</label>
									<input class="form-control formConl line-input timepicker" id="cbSourceCd" name="cbSourceCd" placeholder="手机号码" value="${cbSourceCd }" type="text"/>
								</div> --%>
								<div class="col-md-12">
									<div class="col-md-6">
										<div class="form-group">
											<label for="cbIdno">证件号码：</label>
											<input class="form-control formConl line-input timepicker" id="cbIdno" name="cbIdno" placeholder="证件号码" value="${cbIdno }" type="text"/>
										</div>
									</div>
								</div>												
							<div class=" submit-group fr">
								<button type="submit" class="btn-size" style="width:110px;margin:0 25px 0 15px;" id="theIdForSubmit">查询</button>
							</div>
				<h3 style="border-bottom: 2px dashed #6fba2c;" class="clearfix">查询列表</h3>
				</form>
							<div class="col-lg-12 col-md-12 clearfix tableContent">
								<div class="checkList">
									<table class="table table-responsive">
										<thead>
											<tr>
												<th>卡号</th>
												<th>姓名</th>
												<th>证件类型</th>
												<th>客户等级</th>
												<th>证件号码</th>
												<th>会员积分</th>
												<th>会员余额</th>
												<th>激活日期</th>
												<th>手机号码</th>
												<th>状态</th>
												<th>操作员</th>
											</tr>
										</thead>
										<tbody> 
                                                <c:forEach var="item" items="${pageInfo.list}"> 
                                                <tr> 
                                                	<td>${item.cbCardholderNo }</td>    
                                                	<%-- <td>${fn:substring(item.cbCardholderNo,0,16)}</td> --%>                                       
                                                    <td>${item.cbEmbossname}</td> 
                                                    <td>${item.cbIdType}</td> 
                                                    <td>${item.prGroupDesc}</td> 
                                                    <td>${item.cbIdno}</td> 
                                                    <td>${item.cbExternalBranch }</td>
                                                    <td>${item.cbOutstdBal }</td>
                                                    <td>${item.cbAnnivDate}</td> 
                                                    <td>${item.cbSourceCd}</td> 
                                                    <td>${item.cbPlasticCd}</td> 
                                                    <td>${item.cbModUser}</td>
                                                </tr> 
                                            </c:forEach> 
                                            </tbody> 
									</table>
									<div class="box-footer clearfix" > 
										<a type="button" href="${ctx }/startTreeviewDetail/ywcx" class="form-a">&lt;返回</a>
                                    	<tags:pagination url="${ctx}/vipcardStat/vipInfoStat" queryString="cbCardholderNo=${cbCardholderNo }&cbEmbossname=${cbEmbossname }&cbSourceCd=${cbSourceCd }&cbIdno=${cbIdno }" page="${pageInfo}" cssClass="pull-right"/> 
                                	</div> 
								</div>
								</div>
						</div>
					</div>
				</div>
			</div>
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
    </body> 
</html>  