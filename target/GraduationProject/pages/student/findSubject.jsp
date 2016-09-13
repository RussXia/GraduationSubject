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
                    <li class="active">选择课题</li>
                </ol>
                <h1 class="text-center text-white">湘潭大学毕业设计选题管理系统</h1>
                <h2 style="color:yellow">Tips<small style="color:yellow">小贴士</small></h2>
				<div style="color:blue;background-color:white">
					<blockquote>
						 <p>1.报名人数包含已确定人数!</p>
						 <p>2.完成选题后,可以在 "个人选题管理" 中查看和删除我的选题!</p>
					</blockquote>
				</div>
                <!----------------------------------------------------------    ------------------------------------------->
                <form action="../studentSubject/searchSubjct" method="POST">
	                <div class="input-group line left">
	                    <span class="input-group-addon">课题名称</span></span>
	                    <input type="text" class="form-control" name="subjectNameSerach"  placeholder="课题名称" aria-describedby="basic-addon2">
	                </div>
	                 <div class="input-group line left">
	                    <span class="input-group-addon">课题教师姓名</span></span>
	                    <input type="text" class="form-control" name="teacherNameSerach" placeholder="课题教师姓名" aria-describedby="basic-addon2">
	                </div>
	                 <div class="input-group line left">
	                    <span class="input-group-addon">课题方向</span></span>
	                    <input type="text" class="form-control" name="subjectOrientationSearch" placeholder="课题方向" aria-describedby="basic-addon2">
	                </div>
	                <div class="input-group line left">
	                    <span class="input-group-addon">课题难度</span></span>
	                    <select class="form-control" name="levelSearch">
	                    			  <option value="" selected="selected">请选择</option>
									  <option value="简单" >简单</option>
									  <option value="一般">一般</option>
									  <option value="困难">困难</option>
									  <option value="困难">非常困难</option>
						</select>
	                </div>
	                <div class="input-group line left">
	                    <span class="input-group-addon">课题类型</span></span>
	                    <select class="form-control" name="subjectTypeSearch">
	                    			  <option value="" selected="selected">请选择</option>
									  <option value="毕业设计" >毕业设计</option>
									  <option value="毕业论文">毕业论文</option>
						</select>
	                </div>
	                <input type="hidden" name="studentDepartmentId" value="${sessionScope.user.departmentId}">
	                <input type="hidden" name="studentStudentId" value="${sessionScope.user.studentId}">
	                <input type="submit" class=" btn btn-primary" value="搜索">
                </form>
                <br><br>
                <c:if test="${empty requestScope.subjects}">
					<div class="alert alert-info" role="alert">未发现匹配的课题</div>
				</c:if>
				<c:if test="${!empty requestScope.subjects }">
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
						<c:forEach items="${requestScope.subjects }" var="subject">
							<form id="${subject.graduationSubjectId }">
								<input type="hidden" name="graduationSubjectId" value="${subject.graduationSubjectId }">
								<input type="hidden" name="studentId" value="${sessionScope.user.studentId }">
								<tr style="color: black;" id="stuChooseSubject${subject.graduationSubjectId}">
									<td>${subject.subjectName }</td>
									<td>${subject.teacherName }</td>
									<td>${subject.subjectOrientation }</td>
									<td>${subject.level}</td>
									<td>${subject.maxStuNum}</td>
									<td>${subject.presentStuNum}</td>
									<td>${subject.presentConfirmNum}</td>
									<td>${subject.subjectType}</td>
									<td>
										<a onclick="stuChooseSubject(${subject.graduationSubjectId })" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-on"></span>选择课题</a>
									</td>
								</tr>
							</form>
						</c:forEach>
						</tbody>
					</table>
					<!-- 分页开始 -->
					<div class="btn-group" role="group" aria-label="..." style="float: right;">
					 	<input id="countPage" type="hidden" value="${requestScope.countPage}">
					  	<form id="nextPageForm" style="float: right;" action="../student/findSubject" method="GET">
		                    <input type="hidden" name="studentId" value="${sessionScope.user.studentId}">
		                    <input type="hidden" id="currentPage" name="currentPage" value="${requestScope.currentPage}">
		                    <input type="hidden" name="operate" value="1">
		                    <input id="nextPage" type="submit" value="下一页" class="btn btn-default">
						</form>
						<form id="prePageForm"  style="float: right;" action="../student/findSubject" method="GET">
							<input type="hidden" name="currentPage" value="${requestScope.currentPage}">
		                    <input type="hidden" name="studentId" value="${sessionScope.user.studentId}">
		                    <input type="hidden" name="operate" value="-1">
		                    <input id="prePage" type="submit" value="上一页" class="btn btn-default">
						</form>
						<span style="float: right;font-size: 20px;" class="label label-primary">当前页面: 第${requestScope.currentPage}页,共${requestScope.countPage}页</span>
					</div>
					<!-- 分页结束 -->
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
		  if($("#currentPage").val()==1){
			  $("#prePageForm").remove();
		  };
		  if($("#countPage").val() == $("#currentPage").val()){
			  $("#nextPageForm").remove();
		  }
		  //alert($("#countPage").val());
		 
		  
	});
    $(function () {
        $('dt').click(function () {
            $(this).parent().find('dd').show().end().siblings().find('dd').hide();
        });
    });
</script>
</body>
</html>

