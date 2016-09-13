<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>很抱歉，此页面暂时找不到！</title>

<style type="text/css">
body {margin: 0px; padding:0px; font-family:"微软雅黑", Arial, "Trebuchet MS", Verdana, Georgia,Baskerville,Palatino,Times; font-size:16px;}
div{margin-left:auto; margin-right:auto;}
a {text-decoration: none; color: #1064A0;}
a:hover {color: #0078D2;}
img { border:none; }
h1,h2,h3,h4 {
/*	display:block;*/
	margin:0;
	font-weight:normal; 
	font-family: "微软雅黑", Arial, "Trebuchet MS", Helvetica, Verdana ; 
}
h1{font-size:44px; color:#0188DE; padding:20px 0px 10px 0px;}
h2{color:#0188DE; font-size:16px; padding:10px 0px 40px 0px;}

#page{width:910px; padding:20px 20px 40px 20px; margin-top:80px;}
.button{width:180px; height:28px; margin-left:0px; margin-top:10px; background:#009CFF; border-bottom:4px solid #0188DE; text-align:center;}
.button a{width:180px; height:28px; display:block; font-size:14px; color:#fff; }
.button a:hover{ background:#5BBFFF;}
</style>

</head>
<body>


<div id="page" style="border-style:dashed;border-color:#e4e4e4;line-height:30px;background:url(images/sorry.png) no-repeat right;">
	<h1>抱歉，服务器好像发生了一点小问题</h1>
	<h2>Sorry, the site now can not be accessed. </h2>
	<font color="#666666">好像发生了一点小问题，请尝试进入首页重新登陆！</font><br /><br />
	<div class="button">
		<a href="${pageContext.request.contextPath}" title="进入首页">进入首页</a>
	</div>
</div>
</body>
</html>

