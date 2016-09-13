<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="icon" href="${pageContext.request.contextPath}/img/logo.png" />
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
                    <li class="active">我的选题结果</li>
                </ol>
                <h1 class="text-center text-white">湘潭大学毕业设计选题管理系统</h1>
                <br>
                <h2 style="color:yellow">Tips<small style="color:yellow">小贴士</small></h2>
				<div style="color:blue;background-color:white">
					<blockquote>
						 <p>1.报名人数包含已确定人数!</p>
						 <p>2.完成选题后,可以在 "个人选题管理" 中查看和删除我的选题!</p>
					</blockquote>
				</div>
                <!----------------------------------------------------------    ------------------------------------------->
                <c:if test="${empty requestScope.mySubjectResult}">
					<div class="alert alert-info" role="alert">
						您尚未完成选课!
					</div>
				</c:if>
				<c:if test="${!empty requestScope.mySubjectResult }">
					<div class="row">
						<div class="col-xs-3">
						</div>
					 	<div class="col-xs-5" style="font-size: 20px;">
					 	<h3 class="text-center" style="color: yellow">我的选题结果</h3>
						 <table class="table table-bordered text-center table-striped" style="background-color: white;">
			                    <tr class="info" style="height: 50px;" >
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">课题名称</th>
			                        <td class="text-center">${mySubjectResult.subjectName }</td>
			                    </tr>
			                    
			                     <tr class="info" style="height: 50px;">
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">课题教师姓名</th>
			                        <td class="text-center">${mySubjectResult.teacherName }</td>
			                    </tr>
			                    
			                     <tr class="info" style="height: 50px;">
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">教师电话</th>
			                        <td class="text-center">${mySubjectResult.teacherCellPhone}</td>
			                    </tr>
			                    
			                     <tr class="info" style="height: 50px;">
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">教师邮箱</th>
			                        <td class="text-center">${mySubjectResult.teacherEmail}</td>
			                    </tr>
			                    
			                     <tr class="info" style="height: 50px;">
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">课题方向</th>
			                        <td class="text-center">${mySubjectResult.subjectOrientation}</td>
			                    </tr>
			                    
			                     <tr class="info" style="height: 50px;">
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">课题难度</th>
			                        <td class="text-center">${mySubjectResult.level}</td>
			                    </tr>
			                    
			                     <tr class="info" style="height: 50px;">
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">课题类型</th>
			                        <td class="text-center">${mySubjectResult.subjectType}</td>
			                    </tr>
			                    
			                    <tr class="info" style="height: 50px;">
			                        <td style="color: #CC0000;font-weight: bolder;" class="text-center">所属院系</th>
			                        <td class="text-center">${mySubjectResult.departName}</td>
			                    </tr>
						</table>
						</div>
					</div>
				</c:if>
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
		  $("#collapseTwo").attr("class","in");
		  $("#collapseOne").removeClass("in");		 		  
	});
    $(function () {
        $('dt').click(function () {
            $(this).parent().find('dd').show().end().siblings().find('dd').hide();
        });
    });
</script>
</body>
</html>

