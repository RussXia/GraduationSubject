<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
    <div class="container-fluid navbar-fixed-top bg-primary" style="padding-top: 15px;">
        <ul class="nav navbar-nav  left">
            <li class="text-white h4">
                &nbsp;&nbsp;&nbsp;&nbsp;<span class="glyphicon glyphicon-leaf"></span>&nbsp;&nbsp;<b>湘潭大学毕业设计选题系统</b>
            </li>
        </ul>
        <ul class="nav navbar-nav nav-pills right ">
            <li class="bg-info dropdown" style="padding-right: 90px;">
                <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user"></span>&nbsp;<span>${sessionScope.userType}</span><span class="caret"></span>
                </a>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li class="text-center"><a href="${pageContext.request.contextPath}/index.jsp" target="view_window"><span class="text-primary">联系我们</span></a></li>
                    <li class="text-center"><a href="${pageContext.request.contextPath}/pages/common/error.jsp"><span class="text-primary">帮助中心</span></a></li>
                    <li class="divider"><a href="#"></a></li>
                    <li class="text-center"><a href="${pageContext.request.contextPath}/login"><span class="text-primary">退出</span></a></li>
                </ul>
            </li>
        </ul>
    </div>
</header>
<!-- system modal start -->
    <div id="ycf-alert" class="modal">
      <div class="modal-dialog modal-sm">
        <div class="modal-content">
          <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <h3 class="modal-title" style="font-size: 20px;"><i class="fa fa-exclamation-circle"></i> [Title]</h3>
          </div>
          <div class="modal-body small" style="color: blue;text-align: center;font-size: 18px;">
            <p>[Message]</p>
          </div>
          <div class="modal-footer" >
            <button type="button" class="btn btn-primary ok" data-dismiss="modal">[BtnOk]</button>
            <button type="button" class="btn btn-default cancel" data-dismiss="modal">[BtnCancel]</button>
          </div>
        </div>
      </div>
    </div>
  <!-- system modal end -->