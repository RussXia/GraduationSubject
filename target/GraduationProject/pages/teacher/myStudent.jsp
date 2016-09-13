<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="icon" href="img/logo.png" />
<title>湘潭大学毕业设计选题管理系统</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap-theme.css"
	rel="stylesheet">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/mmss.css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/css/font-awesome.min.css" />
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
				<br />
				<ol class="breadcrumb">
					<li class="active"><span class="glyphicon glyphicon-home"></span>&nbsp;后台首页</li>
					<li class="active">我指导的学生</li>
				</ol>
				<h1 class="text-center text-white">湘潭大学毕业设计选题管理系统</h1>
				<br>
				<br>
				<!----------------------------------------------------------    ------------------------------------------->
				<c:if test="${empty requestScope.mySubjectResults}">
					<div class="alert alert-info" role="alert">
						您尚未确定学生!
					</div>
				</c:if>
				<c:if test="${!empty requestScope.mySubjectResults }">
					<table class="table table-bordered text-center"
						style="background-color: white;">
						<thead>
							<tr class="info" style="color: #CC0000; font-weight: bolder;">
								<th class="text-center">课题名称</th>
								<th class="text-center">学生姓名</th>
								<th class="text-center">学生电话</th>
								<th class="text-center">学生邮箱</th>
								<th class="text-center">所属院系</th>
								<th class="text-center">课题方向</th>
								<th class="text-center">课题难度</th>
								<th class="text-center">课题类型</th>
								<th class="text-center">操作</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${requestScope.mySubjectResults }" var="result" varStatus="status">
								<form id="${result.subjectResultId }">
									<input type="hidden" name="subjectResultId" value="${result.subjectResultId }">
									<tr style="color: black;" id="deleteMyStudent${result.subjectResultId}">
										<td>${result.subjectName }</td>
										<td>${result.studentName}</td>
										<td>${result.studentCellPhone}</td>
										<td>${result.studentEmail}</td>
										<td>${result.departName}</td>
										<td>${result.subjectOrientation }</td>
										<td>${result.level}</td>
										<td>${result.subjectType}</td>
										<td>
											<a onclick="deleteMyStudent(${result.subjectResultId})" class="btn btn-sm btn-info">
													<span class="glyphicon glyphicon-on"></span>删除学生
											</a>
										</td>
									</tr>
								</form>
								<!-- Model Begin -->
								<div class="modal fade" id="edit${subject.graduationSubjectId }" tabindex="-1" role="dialog" aria-labelledby="edit">
									<div class="modal-dialog" role="document">
										<div class="modal-content">
											<div class="modal-header">
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true">&times;</span>
												</button>
												<h4 class="modal-title" id="myModalLabel1">修改</h4>
											</div>
											<form class="teacherSubjectForm">
												<input type="hidden" name="graduationSubjectId"
													value="${subject.graduationSubjectId }"> 
												<div class="modal-body">
													<div class="form-group">
														<label><span>课题名称 :</span></label> <input type="text"
															value="${subject.subjectName }" class="form-control"
															 name="subjectName" />
													</div>
													<div class="form-group">
														<label><span>课题方向 :</span></label> <input type="text"
															value="${subject.subjectOrientation }"
															class="form-control"
															name="subjectOrientation" />
													</div>
													<div class="form-group">
														<label><span>课题难度:</span></label> <select
															class="form-control" name="level"
															style="width: 200px;">
															<option value="简单"
																<c:if test="${subject.level == '简单'}">selected="selected"</c:if>>简单</option>
															<option value="一般"
																<c:if test="${subject.level == '一般'}">selected="selected"</c:if>>一般</option>
															<option value="困难"
																<c:if test="${subject.level == '困难'}">selected="selected"</c:if>>困难</option>
															<option value="非常困难"
																<c:if test="${subject.level == '非常困难'}">selected="selected"</c:if>>非常困难</option>
														</select>
													</div>
													<div class="form-group">
														<label><span>课题类型 ：</span></label> <select
															class="form-control" name="subjectType"
															style="width: 200px;">
															<option value="毕业设计"
																<c:if test="${subject.subjectType == '毕业设计'}">selected="selected"</c:if>>毕业设计</option>
															<option value="毕业论文"
																<c:if test="${subject.subjectType == '毕业论文'}">selected="selected"</c:if>>毕业论文</option>
														</select>
													</div>

												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-default btn-sm" 
														data-dismiss="modal">取消</button>
													<button type="button" class="btn btn-primary btn-sm" data-dismiss="modal"
													onclick="teacherUpdateSubject(${ status.index})">保存</button>
												</div>
											</form>
										</div>
									</div>
								</div>
								<!--Modal end-->
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

	<script src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"
		charset="UTF-8"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.js"></script>
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

		$(document).ready(function() {
			$("#collapseTwo").attr("class", "in");
			$("#collapseOne").removeClass("in");
		});
		$(function() {
			$('dt').click(
					function() {
						$(this).parent().find('dd').show().end().siblings()
								.find('dd').hide();
					});
		});
	</script>
</body>
</html>