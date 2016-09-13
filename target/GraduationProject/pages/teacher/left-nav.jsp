<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--左侧导航开始-->
<div class="col-xs-2 bg-blue">
	<br />
	<div class="panel-group sidebar-menu" id="accordion"
		aria-multiselectable="true">
		<div class="panel panel-default menu-first menu-first-active">
			<a data-toggle="collapse" data-parent="#accordion" href="index.html"
				aria-expanded="true" aria-controls="collapseOne"> <i
				class="icon-home icon-large"></i> 主页
			</a>
		</div>
		<div class="panel panel-default menu-first">
			<a data-toggle="collapse" data-parent="#accordion"
				href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
				<i class="icon-user-md icon-large"></i> 账户设置
			</a> 

			<div id="collapseOne" class="panel-collapse collapse ">
				<ul class="nav nav-list menu-second">
					<li><a href="${pageContext.request.contextPath}/teacher/personalData"><i class="icon-user"></i> 个人资料变更</a></li>
					<li><a href="${pageContext.request.contextPath}/teacher/changePassword"><i class="icon-edit"></i> 修改密码</a></li>
					<li><a href="${pageContext.request.contextPath}/teacher/changeEmail"><i class="glyphicon glyphicon-envelope"></i>  邮箱账号变更 </a></li>
				</ul>
			</div>
		</div>
		<div class="panel panel-default menu-first">
			<a class="collapsed" data-toggle="collapse" data-parent="#accordion"
				href="#collapseTwo" aria-expanded="false"
				aria-controls="collapseTwo"> <i class="icon-book icon-large"></i>
				毕设课题管理
			</a> 
			<div id="collapseTwo" class="panel-collapse collapse">
				<ul class="nav nav-list menu-second">
					<li><a href="${pageContext.request.contextPath}/teacher/addGraduationSubject"><i class="icon-user"></i> 发布课题</a></li>
					<li><a href="${pageContext.request.contextPath}/teacher/manageSubject"><i class="icon-edit"></i> 我的选题管理</a></li>
					<li><a href="${pageContext.request.contextPath}/teacher/confirmIdeal"><i class="icon-trash"></i> 选题志愿管理</a></li>
					<li><a href="${pageContext.request.contextPath}/teacher/myStudent"><i class="icon-list"></i>我指导的学生</a></li>
					<li><a href="${pageContext.request.contextPath}/teacher/excelDownload"><i class="icon-list"></i>选题结果Excel下载</a></li>
				</ul>
			</div>
		</div>
	</div>
</div>
<!--左侧导航结束-->