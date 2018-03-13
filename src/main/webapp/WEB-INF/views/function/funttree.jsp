<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 权限管理</title>
		<link rel="stylesheet" href="${assets}/ztree/css/metro/demo.css" type="text/css">
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets}/ztree/css/metro/metro.css" type="text/css">
		<link rel="stylesheet" href="${assets}/ztree/css/metro/department.css"/> 
        <link rel="stylesheet" href="${assets}/ztree/css/metro/metroStyle.css" type="text/css">
        <style>
        	.content1{
        		    width: 960px;
				    margin: 0 auto;
				    height: auto;
        	}
        	.btnStyle{
        		    width: 77px;
				    height: 40px;
				    background: #00a65a;
				    color: white;
				    border: none;
				    border-radius: 4px;
				    outline: none;
				    font-size: 16px;
				    font-family: "微软雅黑";
				    font-weight: 500;
        	}
        </style>
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="function"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper" style="height:auto;">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>权限管理</h1>
					<ol class="breadcrumb">
						<li><a href="${ctx }/"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="${ctx }/startTreeviewDetail/xtgl">系统管理</a></li>
						<li class="active">权限列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="container-fluid">
						<div class="row">
							<div class="tip-img">
								<p>权限管理</p>
							</div>
							<div class="content1">
								<div class="main clearfix">
									<form class="form-inline form-horizontal" id="defaultForm" name="defaultForm">
										<h3 style="border-bottom: 2px dashed #45a0e0;">权限信息</h3>
										<div class="departinfo">
											<div class="col-md-6">
												<label>权限&nbsp;&nbsp;ID:</label>
										        <input class="form-control  line-input" type="text" id="funtid" name="funtid" readonly="readonly"/>
										        <label>上级权限:</label>
										        <input class="form-control  line-input" type="text" id="funtparentId" name="funtparentId" readonly="readonly"/>
											</div>
											<div class="col-md-6">
												<label>权限名称:</label>
										        <input class="form-control  line-input" type="text" id="name_name" name="name_name" />
										        <label>权限描述:</label>
										        <input class="form-control  line-input" type="text" id="id_id" name="id_id" />											
											</div>
											<div class="col-md-12" style="padding-left:790px;">
												<input type="button" class="btnStyle" onclick ="update();" value ="更新">
											</div>
											<h3 style="border-bottom: 2px dashed #45a0e0;">权限结构树</h3>
											<div class="content_wrap center">
												<div class="zTreeDemoBackground">
													<ul id="deptTree" class="ztree"></ul>
												</div>
											</div>
										</div>
									</form>
									<a href="${ctx }/startTreeviewDetail/xtgl" class="form-a" style="margin-left: 15px;">&lt;返回</a>
								</div>
							</div>
						</div>
					</div>
				</section><!-- /.content -->
			</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->
		
		<%-- 添加节点开始 --%>
		<div class="modal fade departtree" id="addNodeModal" role="dialog" aria-labelledby="addNodeLabel">
			<div class="modal-dialog" role="document">
				<div class="modal-content appreance">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<h4 class="modal-title" id="addNodeLabel">节点添加</h4>
					</div>
					<div class="modal-body">
						<form class="form-horizontal" id="funtaddform" name="funtaddform">
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">上级目录</label>
						    	<div class="col-sm-10 ">
						    	<!-- <input type="text" class="form-control" id="deptparentId_pid" name="deptparentId_pid" readonly="readonly"></input>-->
						    		<input type="text" class="form-control" id="funtparentId_pid" name="funtparentId_pid" readonly="readonly"></input>
						    	</div>
							</div>
							<div class="form-group">
								<label for="id" class="col-sm-2 control-label">权限&nbsp;&nbsp;ID</label>
								<div class="col-sm-10 ">
								<!-- 	<input type="text" class="form-control" id="deptname_name" name="deptname_name"/> -->
									<input type="text" class="form-control" id="funtid_id" name="funtid_id"/>
								</div>
							</div>
							<div class="form-group">
								<label for="password" class="col-sm-2 control-label">权限名称</label>
								<div class="col-sm-10 ">
								<!-- 	<textarea  class="form-control" rows="3" id="deptremark_remark" name="deptremark_remark"></textarea> -->
								<textarea  class="form-control" rows="3" id="funtname_name" name="funtname_name"></textarea>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-sm btn-default btn-flat" data-dismiss="modal">取消</button>
						<c:if test="${app:checkPermission('PERMISSION_MANAGEMENT_ADD')}">
							<button type="button" class="btn btn-sm btn-primary btn-flat btn-color" id="btnAddNode">确认添加</button>
						</c:if>
					</div>
				</div>
			</div>
		</div>
		<%-- 添加节点结束 --%>
		

		<tags:load_common_js/>
		<script type="text/javascript" src="${assets}/ztree/js/ztree.all.min.js"></script>
        <script type="text/javascript" src="${assets}/ztree/js/ztree.core.js"></script>
        <script type="text/javascript" src="${assets}/ztree/js/ztree.excheck.js"></script>
        <script type="text/javascript" src="${assets}/ztree/js/ztree.exedit.js"></script>
		<script type="text/javascript">
		var newCount = 1;
		var treeNodes = [{name:"${deptparent.name}", id:"${deptparent.funtId}", parentId:"${deptparent.funtParentId}",remark:"${deptparent.id}", isParent:true}];
        var treeSettings = {
			check: {
				enable: true
			},
			data: {
				simpleData: {
					enable: true
				}
			},
			edit: {
				enable: true 
			},
			view: {
				addHoverDom: function (treeId, treeNode) {
			
					var sObj = $("#" + treeNode.tId + "_span");
					if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0){ 
						return;
					}
					var addStr = "<span class='button add' id='addBtn_" + treeNode.tId + "' title='add node' onfocus='this.blur();'></span>";
					sObj.after(addStr);
					var btn = $("#addBtn_"+treeNode.tId);
					if (btn) {
						btn.bind("click", function(){
							var zTree = $.fn.zTree.getZTreeObj("deptTree");
							document.getElementById("funtparentId_pid").value=treeNode.id;
							$("#addNodeModal").modal("show");
						 	$("#btnAddNode").click(function(){						 		
								var p_id = document.getElementById("funtparentId_pid").value;
								var n_name = document.getElementById("funtid_id").value;
								var r_remark = document.getElementById("funtname_name").value;
							//	var data = {deptId:'',deptLevel:treeNode.level,deptParentId:p_id,deptName:n_name,deptRemark:r_remark};
								var data = {funtId:'',funtLevel:treeNode.level,funtParentId:p_id,id:n_name,name:r_remark};
								console.log(data);
					             $.ajax({  
					                 async: false,  
					                 type: "post",  
					                 data:data,  
					                 url: "${ctx}/function/update_nodename",  					                 
					                 success : function(data){
					                	 if(data.status=="OK"){
					                		 var funtdata = data.value;
						                	 	 zTree.addNodes(treeNode, {id:funtdata.funtId, parentId:funtdata.funtParentId,name:funtdata.name,remark:funtdata.id});
						                		 alert('操作成功!');
							                	 /* document.getElementById("funtparentId_pid").value="";
												 document.getElementById("funtid_id").value="";
												 document.getElementById("funtname_name").value=""; */
					                	 }else{
					                		 alert('亲，网络有点不给力呀!');
					                	 }
					                 },  
					                 
					            }); 
					             $("#addNodeModal").modal("hide");
					             //zTree.updateNode(treeNodes);
					             //ajaxGetNodes(treeNodes, "refresh");
						 	});
						})
					}
				},
				removeHoverDom: function (treeId, treeNode) {
					$("#addBtn_"+treeNode.tId).unbind().remove();
				},
				selectedMulti: false,
				expandSpeed: ""
			},
			async: {
				enable: true,
				url: function (treeId, treeNode) {
					return "${ctx}/function/search_childrens?parentId=" + treeNode.id;
				}
			},
			callback: {
				beforeExpand: function (treeId, treeNode) {
					if (!treeNode.isAjaxing) {
						ajaxGetNodes(treeNode, "refresh");
						return true;
					} else {
						alert("zTree 正在下载数据中，请稍后展开节点。。。");
						return false;
					}
				},
				onAsyncSuccess: function (event, treeId, treeNode, msg) {
					if (!msg || msg.length == 0) {
						return;
					}
					var zTree = $.fn.zTree.getZTreeObj("deptTree");
					treeNode.icon = "";
					zTree.updateNode(treeNode);
					//zTree.selectNode(treeNode.children[0]);
				},
				onAsyncError: function (event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
					var zTree = $.fn.zTree.getZTreeObj("deptTree");
					alert("异步获取数据出现异常。");
					treeNode.icon = "";
					zTree.updateNode(treeNode);
				},
				beforeRename: beforeRename,
				beforeRemove: beforeRemove,
				onRemove: onRemove,
				onRename: onRename,
				onClick: zTreeOnClick
			}
        }
        
        function update(){
        	var funtid = $("#funtid").val();
        	var funtparentId = $("#funtparentId").val();
        	var name_name = $("#name_name").val();
        	var id_id = $("#id_id").val();
        	$.ajax({  
                /* async: false, */  
                type: "post",  
                data:{"funtid":funtid,"funtparentId":funtparentId, "name_name":name_name, "id_id":id_id},   
                url: "${ctx}/function/update",  
                success : function(data){  
               	 if(data.status=="OK"){
               		 alert('修改成功!');
                   	 ajaxGetNodes(treeNode, "refresh");
               	 }else{
               		 alert('亲，网络有点不给力呀!'); 
               	 }
                },  
                error : function()    {  
            		 	alert('亲，网络有点不给力呀!');  
                }  
           });
        	
        } 
        
        
        //click 事件填充
        function zTreeOnClick(event, treeId, treeNode) {
            document.getElementById("funtid").value=treeNode.id;
            document.getElementById("funtparentId").value=treeNode.parentId;
            document.getElementById("name_name").value=treeNode.name;
            document.getElementById("id_id").value=treeNode.remark;
        };
        
   	    
   		//用于捕获分类编辑名称结束（Input 失去焦点 或 按下 Enter 键）之后，更新分类名称数据之前的事件回调函数  
        function beforeRename(treeId, treeNode, newName) {
               if (newName.length == 0 || newName.indexOf("请输入名称")>=0) {  
           			 alert('亲，请输入分类名称!');  
                    var zTree = $.fn.zTree.getZTreeObj("deptTree");  
                    setTimeout( function(){zTree.editName(treeNode)}, 10);  
                    return false;  
              }  
               if(newName.length > 15){  
          			 alert('亲，分类名称过长!');  
                   var zTree = $.fn.zTree.getZTreeObj("deptTree");  
                   setTimeout( function(){zTree.editName(treeNode)}, 10);  
                   return false; 
              }  
              native_name = treeNode.name;  
              return true;  
        } 

   		//执行编辑操作  
        function onRename(e, treeId, treeNode) {
             if(native_name == treeNode.name){  
                  return;  
             }  
             //var data = {deptId:treeNode.deptid,deptLlevel:treeNode.level,deptParentId:treeNode.pId,name:treeNode.deptname};
             var data = {funtId:treeNode.id,funtLevel:treeNode.level,name:treeNode.name};
             $.ajax({  
                 async: false,  
                 type: "post",  
                 data:data,  
                 url: "${ctx}/function/update_nodename",  
                 success : function(data){  
                	 if(data.status=="OK"){
                		 alert('修改成功!');
                    	 ajaxGetNodes(treeNode, "refresh");
                	 }else{
                		 alert('亲，网络有点不给力呀!'); 
                	 }
                 },  
                 error : function()    {  
             		 	alert('亲，网络有点不给力呀!');  
                 }  
            });  
        }
   		
     	//移除分类前执行  
        function beforeRemove(treeId, treeNode) {  
               var zTree = $.fn.zTree.getZTreeObj("deptTree");  
               zTree.selectNode(treeNode);  
               var confirmFlag = confirm("确认删除[ " + treeNode.name + " ]吗?" )  
               var confirmVal = false;  
               if(confirmFlag){  
                    var data = {funtId:treeNode.id};  
                   $.ajax({  
                        async: false,  
                        type: "post",  
                        data:data,  
                        url: "${ctx}/function/delete_nodename",  
                        success: function(json){  
                               if(json == "success" ){  
                                   confirmVal = true;  
                              } else{  
                 				   alert('亲，删除失败!');  
                              }  
                        }/* ,  
                        error: function(){  
                              alert('亲，删除失败!');  
                        } */  
                   });  
              }  
               return confirmVal;  
        }

        
        //执行删除操作后提示  
        function onRemove(e, treeId, treeNode) {  
               alert('亲，删除成功！');  
         }

   		
        //父级分类去除删除功能  
        function setRemoveBtn(treeId, treeNode) {  
           return !treeNode.isParent;  
        }  

   		
		function ajaxGetNodes(treeNode, reloadType) {
			var zTree = $.fn.zTree.getZTreeObj("deptTree");
			if (reloadType == "refresh") {
				treeNode.icon = "${assets}/ztree/css/ztree/img/loading.gif";
				zTree.updateNode(treeNode);
			}
			zTree.reAsyncChildNodes(treeNode, reloadType, true);
		}
        
    	$(document).ready(function(){
    		$.fn.zTree.init($("#deptTree"), treeSettings, treeNodes);
        });
    </script>
	</body>
</html>
