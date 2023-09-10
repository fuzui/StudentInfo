<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
		<meta charset="UTF-8">
		<title>学生信息管理系统</title>
		<script type="text/javascript" src="/StudentInfo/utils/js/jquery-3.3.1.min.js"></script>
		<!-- Loading Bootstrap -->
		<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
		<!-- Loading Flat UI Pro -->
		<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
		<!-- Loading Flat UI JS -->
		<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>	
		<script type="text/javascript">
		$(document).ready(
			function() {
				$("#tid").change(
						function() {
							$.post("/StudentInfo/AjaxHandler/existTid?tid="
									+ $("#tid").val(), function(data, status) {
								$("#counttid").html(data);
							})

						})

			})

		</script>		
	<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>
	
	<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
	<jsp:include page="adminLeft.jsp" />
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h5>添加教师</h5>
				<form action="/StudentInfo/AdminHandler/addTeacher" method="post">
					<h6>教师编号</h6>
					
						<input type="text" name="tid" id="tid" class="form-control" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="5"></input> 
						<span id="counttid" style="color: #ff0000;"></span>
					<h6>姓名</h6>
						<input type="text" name="tname" class="form-control" onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="4"></input>
						<h6>密&nbsp;&nbsp;码</h6>
						<input type="password" name="tpassword" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"></input>
						<h6>性别</h6>
						
						<label class="radio" for="radio1">
                  		<input type="radio" name="tsex" value="男" id="radio1" data-toggle="radio" class="custom-radio">
               			<span class="icons">
               				<span class="icon-unchecked"></span>
               				<span class="icon-checked"></span>
               			</span>
               			<font style="vertical-align: inherit;">
               				<font style="vertical-align: inherit;">
               			 		男
               				</font>
               			</font>
               		</label>
               		
               		<label class="radio" for="radio2">
                  		<input type="radio" name="tsex" value="女" id="radio2" data-toggle="radio" class="custom-radio">
               			<span class="icons">
               				<span class="icon-unchecked"></span>
               				<span class="icon-checked"></span>
               			</span>
               			<font style="vertical-align: inherit;">
               				<font style="vertical-align: inherit;">
               			 		女
               				</font>
               			</font>
               		</label>
				
						<h6>个人简介</h6>
						<textarea name="introduction" cols="20" rows="6" class="form-control"></textarea>
						
						<input type="submit" value="添加" class="btn btn-primary btn-wide login-btn" style="margin-top:2rem"/>
	
				</form>
			</div>
		</div>	
	</div>
	<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>