<%@ page language="java" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <title>统一支付 | 锁屏</title>
    <tags:head_common_content/>
  </head>
  <body class="hold-transition lockscreen">
    <!-- Automatic element centering -->
    <div class="lockscreen-wrapper">
      <div class="lockscreen-logo">
        <a href="${ctx}"><b>统一</b>支付</a>
      </div>
      <!-- User name -->
      <div class="lockscreen-name">John Doe</div>

      <!-- START LOCK SCREEN ITEM -->
      <div class="lockscreen-item">
        <!-- lockscreen image -->
        <div class="lockscreen-image">
          <img src="${assets}/AdminLTE/img/user1-128x128.jpg" alt="User Image">
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
      <div class="help-block text-center">
        Enter your password to retrieve your session
      </div>
      <div class="text-center">
        <a href="login.html">Or sign in as a different user</a>
      </div>
      <div class="lockscreen-footer text-center">
        &copy; 2015 <b><a href="http://www.coshine.com" class="text-black">上海开先软件有限公司</a></b>
      </div>
    </div><!-- /.center -->

    <!-- common js -->
    <tags:load_common_js/>
  </body>
</html>
