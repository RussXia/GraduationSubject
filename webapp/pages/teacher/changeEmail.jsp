<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="img/logo.png" />
	<title>湘潭大学毕业设计选题管理系统</title>
	<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap-theme.css" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mmss.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/font-awesome.min.css"/>
	<!--[if lt IE 9]>
	  <script src="js/html5shiv.min.js"></script>
	  <script src="js/respond.min.js"></script>
	  <![endif]-->
</head>
<body>
	<!-- 顶部 -->
	<jsp:include page="../common/fixed-top.jsp"></jsp:include>
	
	<section>
    <div class="container-fluid">
        <div class="row ">
        	<!--左侧导航开始-->
        	<jsp:include page="left-nav.jsp"></jsp:include>
        	<!--左侧导航结束-->
            <!--右侧内容开始-->
            <div class="col-xs-10">
                <br/>
                <ol class="breadcrumb">
                    <li class="active"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</li>
                    <li class="active">邮箱账号变更</li>
                </ol>
                <h1 class="text-center text-white">湘潭大学毕业设计选题管理系统</h1>
               
                <!----------------------------------------------------------    ------------------------------------------->
                <form id="changeEmail" name="changeEmail">
                 <div class="col-xs-5" style="color: yellow">
	            	  <input type="hidden" id="teacherId" name="teacherId" value="${sessionScope.user.teacherId}" readonly="readonly">
					  <div class="form-group">
					    <label for="oldEmail">原邮箱</label>
					    <input type="email" class="form-control" id="oldEmail" name="oldEmail" value="${sessionScope.user.email}" readonly>
					  </div>
					  <div class="form-group">
					    <label for="newEmail">新邮箱</label>
					    <input type="email" class="form-control" id="newEmail" name="newEmail" value="">
					  </div>
					  <a onclick="validateTeacherChangeEmail()" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-on"></span>变更邮箱</a>
				</div>
				</form>
            </div>
            <!--右侧内容结束-->
        </div>
    </div>
</section>

<footer class="bg-primary navbar-fixed-bottom">
    <p class="text-center text-white">版权所有&copy;Author Xia</p>
</footer>

<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js" charset="UTF-8"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.js" ></script>
<script src="${pageContext.request.contextPath}/js/formValidator.js"></script>
<script type="text/javascript">
    /*Bootlint工具用于对页面中的HTML标签以及Bootstrapclass的使用进行检测
    (function () {
        var s = document.createElement("script");
        s.onload = function () {
            bootlint.showLintReportForCurrentDocument([]);
        };
        s.src = "js/bootlint.js";
        document.body.appendChild(s)
    })();
	*/
	$(document).ready(function(){
		  $("#collapseOne").attr("class","in");
		  $("#collapseTwo").removeClass("in");
	});
    $(function () {
        $('dt').click(function () {
            $(this).parent().find('dd').show().end().siblings().find('dd').hide();
        });
    });
</script>
</body>
</html>

