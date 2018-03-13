<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" isErrorPage="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
	<head>
		<title>综合管理系统 | 机构管理</title>
		<tags:head_common_content/>
		<link rel="stylesheet" href="${assets}/ztree/css/metro/metro.css" type="text/css">
	</head>
	<body class="hold-transition skin-blue-light sidebar-mini">
		<div class="wrapper">
			<!-- Main header -->
			<tags:main_header/>
			
			<!-- Left side column. contains the logo and sidebar -->
			<tags:main_sidebar active="organization"/>
			
			<!-- Content Wrapper. Contains page content -->
			<div class="content-wrapper">
				<div class="context-tips">
		      		<tags:action_tip/>
		      	</div>
				<!-- Content Header (Page header) -->
				<section class="content-header">
					<h1>机构管理</h1>
					<ol class="breadcrumb">
						<li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
						<li><a href="#">机构管理</a></li>
						<li class="active">机构列表</li>
					</ol>
				</section>

				<!-- Main content -->
				<section class="content">
					<div class="box box-primary">
						<div class="box-header with-border">
							<h3 class="box-title">
								<i class="fa fa-plus"></i> 机构管理
							</h3>
						</div>
						<div class="box-body">
							<div class="col-md-3">
								<div class="panel panel-default">
									<div class="panel-heading">机构信息</div>
  									<div class="panel-body">
  										<div class="col-md-12">
										    <form class="form-horizontal">
												<div class="form-group">
													<label for="id" class="control-label">机构ID</label>
													<input type="text" class="form-control" id="id" name="id" readonly="readonly" />
												</div>
												<div class="form-group">
													<label for="password" class="control-label">父级机构</label>
													<%-- <select id="parentId" name="parentId" class="form-control"  >
											    		<c:forEach var="org" items="${organizations }">
											    			<option value="${org.id }" ${org.id eq item.parentId ? 'checked' : '' }>${org.id } - ${org.name }</option>
											    		</c:forEach>
											    	</select> --%>
											    	<input type="text" class="form-control" id="parentId" name="parentId" readonly="readonly"></input>
												</div>
												<div class="form-group">
													<label for="id" class="control-label">机构名称</label>
													<input type="text" class="form-control" id="name" name="name" readonly="readonly" />
												</div>
												<div class="form-group">
													<label for="password" class="control-label">机构描述</label>
													<textarea  class="form-control" rows="3" id="remark" name="remark" readonly="readonly" ></textarea>
												</div>
											</form>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-9">
								<div class="panel panel-default">
									<div class="panel-heading"><i class="fa fa-tree"></i> 机构树</div>
  									<div class="panel-body">
										<ul id="orgsTree" class="ztree"></ul>
									</div>
									<div class="panel-footer">
										<span class="text-muted"><strong>提示：</strong>我是一棵树</span>
									</div>
								</div>
							</div><!-- /.row -->
						</div>
					</div>
				</section><!-- /.content -->
			</div><!-- /.content-wrapper -->
	      
			<!-- Main footer -->
			<tags:main_footer/>
			
			<!-- Control Sidebar -->
			<tags:control_sidebar/>
      
		</div><!-- ./wrapper -->

		<tags:load_common_js/>
		<script type="text/javascript" src="${assets}/ztree/js/ztree.all.min.js"></script>
		<script type="text/javascript">
		var newCount = 1;
		var treeNodes = [{name:"${parent.name}", id:"${parent.id}", pId:"${parent.parentId}", isParent:true}];
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
							 var zTree = $.fn.zTree.getZTreeObj("orgsTree");
							 alert("====ztree="+zTree);
							 var treeNodes ;
							 $.ajax({  
				                  async: false,  
				                  type: "post",  
				                  url: "${ctx}/organization/getorgid?parentId="+treeNode.getParentNode().id+"&levelId="+treeNode.level,
				                  success : function(parentId){ 
				                	  alert("===parentid=="+parentId);
				                         if(parentId != "" ){ 
				                             treeNodes = zTree.addNodes(treeNode, {id:(Number(parentId)+ Number(newCount)), pId:treeNode.id, name:"请输入名称" });  
				                         }
				                         if (treeNodes) {  
				                             zTree.editName(treeNodes[0]);  
				                         }
				                   },  
				                   error : function(){  
				                         alert('亲，网络有点不给力呀！');  
				                   }  
				              }); 
							 //zTree.addNodes(treeNode, {id:(Number(treeNode.id) + Number(newCount)), pId:treeNode.id, name:"new node" + (newCount++)});
						 	 return false;
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
					return "${ctx}/organization/search_childrens?parentId=" + treeNode.id;
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
					var zTree = $.fn.zTree.getZTreeObj("orgsTree");
					treeNode.icon = "";
					zTree.updateNode(treeNode);
					//zTree.selectNode(treeNode.children[0]);
				},
				onAsyncError: function (event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
					var zTree = $.fn.zTree.getZTreeObj("orgsTree");
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

        //click 事件填充
        function zTreeOnClick(event, treeId, treeNode) {
            document.getElementById("id").value=treeNode.id;
            document.getElementById("parentId").value=treeNode.getParentNode().id +"---"+treeNode.getParentNode().name;
            document.getElementById("name").value=treeNode.name;
            document.getElementById("remark").value=treeNode.name;
        };
        
   	    
   		//用于捕获分类编辑名称结束（Input 失去焦点 或 按下 Enter 键）之后，更新分类名称数据之前的事件回调函数  
        function beforeRename(treeId, treeNode, newName) {
               if (newName.length == 0 || newName.indexOf("请输入名称")>=0) {  
           			 alert('亲，请输入分类名称！');  
                    var zTree = $.fn.zTree.getZTreeObj("orgsTree");  
                    setTimeout( function(){zTree.editName(treeNode)}, 10);  
                    return false;  
              }  
               if(newName.length > 15){  
          			 alert('亲，分类名称过长！');  
                   var zTree = $.fn.zTree.getZTreeObj("orgsTree");  
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
             var data = {id:treeNode.id,levelId:treeNode.level,parentId:treeNode.pId,name:treeNode.name};  
             $.ajax({  
                 async: false,  
                 type: "post",  
                 data:data,  
                 url: "${ctx}/organization/update_nodename",  
                 success : function(json){  
                      if(json == "success" ){  
               			 alert('操作成功!');
                      } else{  
              		  	alert('亲，操作失败，请稍后再试！');  
                      }  
                 },  
                 error : function()    {  
             		 	alert('亲，网络有点不给力呀！');  
                 }  
            });  
        }
   		
     	//移除分类前执行  
        function beforeRemove(treeId, treeNode) {  
               var zTree = $.fn.zTree.getZTreeObj("orgsTree");  
               zTree.selectNode(treeNode);  
               var confirmFlag = confirm("确认删除[ " + treeNode.name + " ]吗？" )  
               var confirmVal = false;  
               if(confirmFlag){  
                    var data = {id:treeNode.id};  
                   $.ajax({  
                        async: false,  
                        type: "post",  
                        data:data,  
                        url: "${ctx}/organization/delete_nodename",  
                        success: function(json){  
                               if(json == "success" ){  
                                   confirmVal = true;  
                              } else{  
                 				   alert('亲，删除失败！');  
                              }  
                        },  
                        error: function(){  
                              alert('亲，删除失败！');  
                        }  
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
			var zTree = $.fn.zTree.getZTreeObj("orgsTree");
			if (reloadType == "refresh") {
				treeNode.icon = "${assets}/ztree/css/ztree/img/loading.gif";
				zTree.updateNode(treeNode);
			}
			zTree.reAsyncChildNodes(treeNode, reloadType, true);
		}
        
    	$(document).ready(function(){
    		$.fn.zTree.init($("#orgsTree"), treeSettings, treeNodes);
        });
    </script>
	</body>
</html>
