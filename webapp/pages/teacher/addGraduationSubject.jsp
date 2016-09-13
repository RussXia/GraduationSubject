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
                    <li class="active">发布课题</li>
                </ol>
                <h1 class="text-center text-white">湘潭大学毕业设计选题管理系统</h1>
               
                <!----------------------------------------------------------    ------------------------------------------->
                <form id="addGraduationSubject" name="addGraduationSubject">
                 <div class="col-xs-5" style="color: yellow">
	            	  <input type="hidden" id="teacherId" name="teacherId" value="${sessionScope.user.teacherId}" readonly="readonly">
	            	  <input type="hidden" id="teacherName" name="teacherName" value="${sessionScope.user.teacherName}" readonly="readonly">
	            	  <input type="hidden" id="departmentId" name="departmentId" value="${sessionScope.user.departmentId}" readonly="readonly">
					  <div class="form-group">
					    <label for="subjectName">课题名称</label>&nbsp;<span style="color: red;">*</span>
					    <input type="text" class="form-control" id="subjectName" name="subjectName">
					  </div>
					  <div class="form-group">
					    <label for="level">课题难度</label>&nbsp;<span style="color: red;">*</span>
					    <select class="form-control" id="level" name="level">
							  <option value="简单" selected="selected">简单</option>
							  <option value="一般">一般</option>
							  <option value="困难">困难</option>
							  <option value="非常困难">非常困难</option>
						</select>
					  </div>
					  <div class="form-group">
					    <label for="subjectOrientation">课题方向&nbsp;</label><span style="color: red;">*</span>
					    <input type="text" class="form-control" id="subjectOrientation" name="subjectOrientation">
					  </div>
					  <div class="form-group">
					    <label for="maxStuNum">限选人数</label>&nbsp;<span style="color: red;">*</span>
					    <select class="form-control" id="maxStuNum" name="maxStuNum">
							  <option value="1" selected="selected">1人</option>
							  <option value="2">2人</option>
							  <option value="3">3人</option>
							  <option value="4">4人</option>
							  <option value="5">5人</option>
						</select>
					  </div>
					  <div class="form-group">
					    <label for="subjectType">课题类型</label>&nbsp;<span style="color: red;">*</span>
					    <select class="form-control" id="subjectType" name="subjectType">
							  <option value="毕业设计" selected="selected">毕业设计</option>
							  <option value="毕业论文">毕业论文</option>
						</select>
					  </div>
					  
					  <a onclick="validateAddGraduationSubject()" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-on"></span>发布课题</a>
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

