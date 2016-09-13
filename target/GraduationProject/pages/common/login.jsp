<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@  taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/logo.png"/>
    <title>湘潭大学毕业设计选题管理系统</title>
    <link href="css/bootstrap.css" rel="stylesheet">
    <link href="css/login.css" rel="stylesheet">
    <!--[if lt IE 9]>
  <script src="js/html5shiv.min.js"></script>
  <script src="js/respond.min.js"></script>
  <![endif]-->
</head>
<body>
<div class="box">
    <br/>
    <div class="login-box">
        <div class="login-title text-center">
		<h1><small>湘潭大学毕业设计选题管理系统</small></h1>	           
        </div>
        
        <div class="login-content ">
            <div class="form">
                <form action="login" method="POST" name="login" id="registerForm">
                    <div class="form-group">
                        <div class="col-xs-12 ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
                                <input type="text" id="username" name="username" class="form-control" placeholder="用户名">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12 ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
                                <input type="password" id="password" name="password" class="form-control" placeholder="密码">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-xs-12  ">
                            <div class="input-group">
                                <span class="input-group-addon"><span class="glyphicon glyphicon-collapse-down"></span></span>
                               <select class="form-control" id="userType" name="userType">
									  <option value="1" selected="selected">学生</option>
									  <option value="2">教师</option>
									<!--   <option value="3">管理员</option> -->
								</select>
                            </div>
                        </div>
                    </div>

                    <div class="form-group form-actions">
                        <div class="col-xs-4 col-xs-offset-4 ">
                            <a onclick="validateLogin()" id="loginBtn" class="btn btn-sm btn-info"><span class="glyphicon glyphicon-off"></span>登录</a>
                        </div>
                    </div>
                    <br><br>
                   <!-- 登陆失败警示框 -->
                    <c:if test="${not empty requestScope.message}">
                         <div class="form-group message-box">
	                        <div class="col-xs-12 ">
	                            <div class="alert alert-danger" role="alert">
											登陆失败，请检查用户名或密码
		                        </div>
	                        </div>
	                    </div>
     				</c:if>
                   <!-- 登陆失败警示框 -->
                </form>
            </div>
        </div>
    </div>
</div>


<script src="js/jquery-1.11.3.js"></script>
<script src="js/bootstrap.js"></script>
<script src="js/formValidator.js"></script>
<script type="text/javascript" language="javascript">
	/*Bootlint工具用于对页面中的HTML标签以及Bootstrapclass的使用进行检测
    (function () {
        var s = document.createElement("script");
        s.onload = function () {
            bootlint.showLintReportForCurrentDocument([]);
        };
        s.src = "js/bootlint.js";
        document.body.appendChild(s)
    })();
	*/
    $("body").keydown(function() {
        if (event.keyCode == "13") {//keyCode=13是回车键
            $('#loginBtn').click();
        }
    });
</script>
</body>
</html>