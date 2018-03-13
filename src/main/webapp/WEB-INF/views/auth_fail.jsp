<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>综合管理系统 | 授权失败</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition lockscreen">
    <!-- Automatic element centering -->
    <div class="lockscreen-wrapper">
      <div class="lockscreen-logo">
        <a href="${ctx}"><b>授权</b>失败</a>
      </div>
      <!-- User name --> 
      <div class="lockscreen-name">${currentStaff.name }</div>

      <!-- START LOCK SCREEN ITEM -->
      <div class="lockscreen-item">
        <!-- lockscreen image -->
        <div class="lockscreen-image">
          <img src="${assets}/app/img/logo-76x76.png" alt="User Image">
        </div>
        <!-- /.lockscreen-image -->

        <!-- lockscreen credentials (contains the form) -->
        <form class="lockscreen-credentials">
          <div class="input-group">
            <input type="password" class="form-control" placeholder="password">
            <div class="input-group-btn">
              <button class="btn"><i class="fa fa-arrow-right text-muted"></i></button>
            </div>
          </div>
        </form><!-- /.lockscreen credentials -->

      </div><!-- /.lockscreen-item -->
      <div class="help-block text-center">您没有权限操作些功能</div>
      <div class="text-center">
        <a href="#" onClick="javascript :history.back(-1);">返回</a>
      </div>
      <div class="lockscreen-footer text-center">
        &copy; 2017 <b><a href="#" class="text-black">综合管理系统</a></b>
      </div>
    </div><!-- /.center -->

    <!-- common js -->
    <tags:load_common_js/>
  </body>
</html>
