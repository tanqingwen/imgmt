<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>

<head>
	<title>综合管理系统 | 机具收费管理</title>
	<tags:head_common_content/>
</head>

<body class="hold-transition skin-blue-light sidebar-mini">

<div class="wrapper">

	<!-- Main header -->
	<tags:main_header/>
	
	<!-- Left side column. contains the logo and sidebar -->
	<tags:main_sidebar active="cpprdtrm"/>
	
	<!-- Content Wrapper. Contains page content -->
	<div class="content-wrapper">
		<div class="context-tips">
      		<tags:action_tip/>
      	</div>
		<!-- Content Header (Page header) -->
		<section class="content-header">
			<h1>机具收费管理</h1>
			<ol class="breadcrumb">
				<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
				<li><a href="#">机具收费管理</a></li>
				<li class="active">详情列表</li>
			</ol>
		</section>

		<!-- Main content -->
		<section class="content">
			<div class="box box-primary">

                <div>
                  <h4><i class="fa fa-search"></i> 查询表单</h4>
                </div>
                <form class="form-horizontal" action="${ctx}/cpprdtrm/mainpage">
	                <table>
	                	<tr>
	                		<td>
	                			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                			机具号&nbsp;&nbsp;&nbsp;</label>
	                		</td>
	                		<td>
	                			<input class="form-control" name="pt_terminal_id" placeholder="机具号" type="text"  style="width: 300px" >
	                		</td>
	                		<td>
	                			&nbsp;
	                		</td>
	                		<td>
	                			<label>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	                			产品组&nbsp;&nbsp;&nbsp;</label>
	                		</td>
	                		<td>
	                			<input class="form-control" name="pt_prodct_group" placeholder="产品组" type="text"  style="width: 300px" >
	                		</td>
	                		<td>
	                			<button type="submit" class="btn btn-info pull-right" ><i class="fa fa-search"></i> 查询</button>
	                		</td>
	                	</tr>
	                	<tr></tr>
	                </table>
                </form>
                <div>&nbsp;</div>
	        </div><!-- /.box -->
		
			<div class="box box-info">
				<div >
					<h4><i class="fa fa-list"></i> 机具列表</h4>
				</div>
				
               <div class="box-body">
                <div class="table-responsive">
	                <table class="table table-striped">
						<thead>
						    <tr>
						    	   <th>选择</th>
						           <th>机具号</th>
                                   <th>产品组</th>
                                   <th>时间间隔</th>
                                   <th>折扣</th>
						    </tr>
						</thead>
						<tbody>
						<c:forEach var="item" items="${pageInfo.list}">
							<tr>	
								   <td><input type='checkbox' name='choose' id="choose" value="${item.pt_terminal_id}:${item.pt_prodct_group}"></td>
                                   <td>${item.pt_terminal_id}</td>
                                   <td>${item.pt_prodct_group}</td>
                                   <td>${item.pt_time_interval}</td>
                                   <td>${item.pt_discount}</td>
								<%-- <td>
									<div class="btn-toolbar pull-right" role="toolbar">
										<div class="btn-group">
											<c:if test="${app:checkPermission('STAFF_UPDATE') }">
												<a type="button" class="btn btn-default btn-xs" title="修改" href="${ctx}/cpprdtrm/toUpdatePage?id=${item.pt_terminal_id}&level=${item.pt_prodct_group}"><i class="fa fa-fw fa-edit" aria-hidden="true"></i></a>
											</c:if>
											<c:if test="${app:checkPermission('STAFF_RESET_PASSWORD') }">
												<a type="button" class="btn btn-default btn-xs" title="删除" href="${ctx}/cpprdtrm/delete?id=${item.pt_terminal_id}&&level=${item.pt_prodct_group}" onclick="return confirm('确认删除?')"><i class="glyphicon glyphicon-trash" aria-hidden="true"></i></a>
											</c:if>
										</div>
									</div>
								</td> --%>
							</tr>
						</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="box-footer clearfix">
					<div class="pull-left">
						<table>
							<tr>
								<button id="theIdForAdd" class="btn btn-sm btn-default btn-flat">添加</button>
								<button id="theIdForDel" class="btn btn-sm btn-default btn-flat">删除</button>
								<button id="theIdForUpdate" class="btn btn-sm btn-default btn-flat">更新</button>
							</tr>
						</table>
					</div>
					<div class="box-footer clearfix">
						<tags:pagination url="${ctx}/cpprdtrm/mainpage" page="${pageInfo}" cssClass="pull-right"/>
					</div>
				</div>
               </div><!-- /.box-body -->
			</div><!-- /.box -->
		</section><!-- /.content -->
	</div><!-- /.content-wrapper -->
	<!-- Main footer -->
	<tags:main_footer/>
	<!-- Control Sidebar -->
	<tags:control_sidebar/>
</div><!-- ./wrapper -->
<tags:load_common_js/>
<script type="text/javascript">
	$().ready(function(){
		$("#theIdForAdd").click(function(){
			location.href="${ctx}/cpprdtrm/toAddPage";
		});
		$("#theIdForDel").click(function(){
			if ($("input[name=choose]:checked").length == 0) {
				alert("请选择您要删除的机具！");
				return;
			}else if($("input[name=choose]:checked").length > 1) {
				alert("一次只能删除一个机具！");
				return;
			}else{
				if(confirm("您确定要删除该机具？")){
					var id = $("input[name=choose]:checked").val().split(":")[0];
					var level = $("input[name=choose]:checked").val().split(":")[1];
					location.href = "${ctx}/cpprdtrm/delete?id="+id+"&level="+level;
				}
			}
		});
		$("#theIdForUpdate").click(function(){
			if ($("input[name=choose]:checked").length == 0) {
				alert("请选择您要更新的机具！");
				return;
			}else if($("input[name=choose]:checked").length > 1) {
				alert("一次只能更新一个机具！");
				return;
			}else{
				var id = $("input[name=choose]:checked").val().split(":")[0];
				var level = $("input[name=choose]:checked").val().split(":")[1];
				location.href="${ctx}/cpprdtrm/toUpdatePage?id="+id+"&level="+level;
			}
		});
	});
</script>
</body>
</html>
