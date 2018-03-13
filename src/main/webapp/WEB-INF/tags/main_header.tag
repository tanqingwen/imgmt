<%@ tag language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="app" uri="http://www.hp.com/jsp/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<header class="main-header">

  <!-- Logo -->
  <a href="${ctx }/" class="logo">
    <!-- mini logo for sidebar mini 50x50 pixels -->
    <span class="logo-mini"><b>综合管理系统</b></span>
    <!-- logo for regular state and mobile devices -->
    <span class="logo-lg"><b>综合管理系统</b></span>
  </a>

  <!-- Header Navbar -->
  <nav class="navbar navbar-static-top" role="navigation">
    <!-- Sidebar toggle button-->
    <a href="#"  data-toggle="offcanvas" role="button">
      <span class="sr-only">切换导航</span>
    </a>
    <!-- Navbar Right Menu -->
    <div class="navbar-custom-menu" style="margin-right:50px;">
      <ul class="nav navbar-nav">
        <!-- User Account Menu -->
        <li class="dropdown user user-menu">
          <!-- Menu Toggle Button -->
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <!-- The user image in the navbar-->
            <img src="${assets}/app/img/logo-76x761.png" class="user-image" alt="员工头像">
            <!-- hidden-xs hides the username on small devices so only the image appears. -->
            <span class="hidden-xs">${currentStaff.id }</span>
          </a>
          <ul class="dropdown-menu">
            <!-- The user image in the menu -->
            <li class="user-header">
              <img src="${assets}/app/img/logo-76x761.png" class="img-circle" alt="员工头像">
              <p>
                <span>${currentStaff.id }</span>
                <small>创建于: ${currentStaff.createdAt }</small>
              </p>
            </li>
            <!-- Menu Footer-->
            <li class="user-footer">
 
 			<c:if test="${app:checkPermission('STAFF_CHANGE_PASSWORD')}">           
              <div class="pull-left">
                <a href="${ctx }/staff/change_password" class="btn btn-default btn-flat">密码修改</a>
              </div>
            </c:if>
            <c:if test="${app:checkPermission('ROOT_LOGOUT')}">
              <div class="pull-right">
                <a href="${ctx }/logout" class="btn btn-default btn-flat">安全退出</a>
              </div>
           </c:if>
            </li>
          </ul>
        </li>
        <!-- Control Sidebar Toggle Button -->
 <!--        <li>
          <a href="#" data-toggle="control-sidebar"><i class="fa fa-gears"></i></a>
        </li> -->
      </ul>
    </div>
  </nav>
</header>