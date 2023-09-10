<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico"
	type="image/x-icon" />
<meta charset="UTF-8">
<title>学生信息管理系统</title>

<!-- 标题图标、CSS、js、jQ 
<link href="/online/image/favicon.ico" rel="shortcut icon">
<link rel="stylesheet" type="text/css" href="/online/css/main.css">
<script src="/online/js/fun.js" type="text/javascript"></script>-->
<script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>
<!-- Loading Bootstrap -->
<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI Pro -->
<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
<!-- Loading Flat UI JS -->
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>

<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>

<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>

	<jsp:include page="studentLeft.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<h5>确认选课</h5>
				<div class="alert alert-info" role="alert">
					<h5>课程名</h5>
					<p>${cname}</p>

					<h5>代课教师</h5>

					<p>${tname}</p>
					<h5>教师简介</h5>
					<p>${inroduction}</p>
				</div>
			</div>
			<div class="col-md-12">
				<div class="row">
					<div class="col-sm-3" style="margin-top:1rem">
						<form action="/StudentInfo/StudentHandler/seling" method="get">
	
	
							<input type="hidden" name="cid" value="${cid }" /> <input
								type="hidden" name="sid" value="${sessionScope.sid }" /> <input
								type="submit" class="btn btn-primary btn-wide login-btn"
								value="确定选课" />
	
						</form>
						
						
					</div>
					<div class="col-sm-3" style="margin-top:1rem">
						<form action="../backseling/${cid }" method="get">
	
	
							<input type="submit" class="btn btn-primary btn-wide login-btn"
								value="取消选课" />
	
						</form>
					</div>
				</div>
			</div>	
		</div>
	</div>

	<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script>
<script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>