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
                <section class="content"> 
                    <div class="box box-primary"> 
                        <div class="box-header with-border"> 
                          <h3 class="box-title"><i class="fa fa-search"></i> 查询表单</h3>                           
                        </div><!-- /.box-header --> 
                        <!-- form start --> 
                        <form class="form-horizontal" id="thisform" action="${ctx}/vipcardStat/vipInfoStat"> 
                          <div class="box-body"> 
                              <div class="col-sm-6"> 
                                <div class="form-group"> 
                                  <label for="cbCardholderNo" class="col-sm-3 control-label">卡号</label> 
                                  <div class="col-sm-9"> 
                                    <input class="form-control" id="cbCardholderNo" name="cbCardholderNo" placeholder="卡号" value="${cbCardholderNo }" type="text"> 
                                  </div> 
                                </div> 
                            </div> 
                            <div class="col-sm-6"> 
                                <div class="form-group"> 
                                  <label for="cbEmbossname" class="col-sm-3 control-label">姓名</label> 
                                  <div class="col-sm-9"> 
                                    <input class="form-control" id="cbEmbossname" name="cbEmbossname" placeholder="姓名" value="${cbEmbossname }" type="text"> 
                                  </div> 
                                </div> 
                            </div> 
                            <div class="col-sm-6"> 
                                <div class="form-group"> 
                                  <label for="cbSourceCd" class="col-sm-3 control-label">手机号码</label> 
                                  <div class="col-sm-9"> 
                                    <input class="form-control" id="cbSourceCd" name="cbSourceCd" placeholder="手机号码" value="${cbSourceCd }" type="text"> 
                                  </div> 
                                </div> 
                            </div> 
                              <div class="col-sm-6"> 
                                <div class="form-group"> 
                                  <label for="cbIdno" class="col-sm-3 control-label">证件号码</label> 
                                  <div class="col-sm-9"> 
                                    <input class="form-control" id="cbIdno" name="cbIdno" placeholder="证件号码" value="${cbIdno }" type="text"> 
                                  </div> 
                                </div> 
                            </div> 
                          </div><!-- /.box-body --> 
                          <div class="box-footer"> 
                              <div class="pull-right"> 
                                <button type="submit" class="btn btn-info " id="theIdForSubmit"><i class="fa fa-search"></i> 查询</button> 
                                <a type="button" class="btn btn-info" href="${ctx }/"><i class="glyphicon glyphicon-chevron-left" ></i> 返回</a> 
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
                                    </div> 
                                </div><!-- /.box-body --> 
                                <div class="box-footer clearfix"> 
                                    <tags:pagination url="${ctx}/vipcardStat/vipInfoStat" queryString="cbCardholderNo=${cbCardholderNo }&cbEmbossname=${cbEmbossname }&cbSourceCd=${cbSourceCd }&cbIdno=${cbIdno }" page="${pageInfo}" cssClass="pull-right"/> 
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
    </body> 
</html>  