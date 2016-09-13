<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <li class="active">个人选题志愿管理</li>
                </ol>
                <h1 class="text-center text-white">湘潭大学毕业设计选题管理系统</h1>
                <br>
                <h2 style="color:yellow">Tips<small style="color:yellow">小贴士</small></h2>
				<div style="color:blue;background-color:white">
					<blockquote>
						 <p>1.当指导教师确认了你之后,若想删除选题，请与指导教师联系!</p>
						 <p>2.若你已被指导教师确认,可打开 "我的选题结果" 页面查询你的毕设选题!</p>
					</blockquote>
				</div>
                <!----------------------------------------------------------    ------------------------------------------->
                <c:if test="${empty requestScope.mySubjects}">
					<div class="alert alert-info" role="alert">
						您尚没有选择选题或已经完成选题，请前往 "课题页面"选择选题或进入我的选题结果查看选题!
					</div>
				</c:if>
				<c:if test="${!empty requestScope.mySubjects }">
					 <table class="table table-bordered text-center" style="background-color: white;">
						<thead >
		                    <tr class="info" style="color: #CC0000;font-weight: bolder;">
		                        <th class="text-center">课题名称</th>
		                        <th class="text-center">课题教师姓名</th>
		                        <th class="text-center">课题方向 </th>
		                        <th class="text-center">课题难度</th>
		                        <th class="text-center">限选人数</th>
		                        <th class="text-center">报名人数</th>
		                        <th class="text-center">已确定人数</th>
		                        <th class="text-center">课题类型</th>
		                        <th class="text-center">操作</th>
		                    </tr>
		                </thead>
		                <tbody>
						<c:forEach items="${requestScope.mySubjects }" var="subject">
							<form id="${subject.graduationSubjectId }">
								<input type="hidden" name="graduationSubjectId" value="${subject.graduationSubjectId }">
								<input type="hidden" name="studentId" value="${sessionScope.user.studentId }">
								<tr style="color: black;" id="stuDeleteSubject${subject.graduationSubjectId}">
									<td>${subject.subjectName }</td>
									<td>${subject.teacherName }</td>
									<td>${subject.subjectOrientation }</td>
									<td>${subject.level}</td>
									<td>${subject.maxStuNum}</td>
									<td>${subject.presentStuNum}</td>
									<td>${subject.presentConfirmNum}</td>
									<td>${subject.subjectType}</td>
									<td>
										<a onclick="stuDeleteSubject(${subject.graduationSubjectId})" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-on"></span>删除选题</a>
									</td>
								</tr>
							</form>
						</c:forEach>
						</tbody>
					</table>
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

