<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
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
<jsp:include page="teacherLeft.jsp" />
<div class="container">
	<div class="row">
		<div class="col-md-12">
			<div class="row">
			<div class="col-md-12" >
				<h5>管理教学课程</h5>
				<div class="margin:0 15px" style="overflow-x: scroll;"><table  style="overflow:scroll;" class="table table-striped table-hover animated fadeIn">
				<thead>
					<tr>
						<th>所建班级</th>
						<th>上课周</th>
						<th>上课时间</th>
						
						<th>课程名</th>
						<th>上课教室</th>
						<th>学分</th>
						<th>学时</th>
						<th>总人数</th>
	
						<th>修改</th>
						<th>删除</th>
	
					</tr>
				</thead>
				<c:forEach var="courseplan" items="${sessionScope.coursePlanList}"
					varStatus="loop">
					<tr>
						<td>${courseplan.courseclass }</td>
						<td>${courseplan.courseweek}</td>
						<td>${courseplan.coursetime }</td>
						

						<td>${sessionScope.couList[loop.count-1].cname }</td>

						<td>${courseplan.classroom}</td>
						<td>${courseplan.credits}</td>
						<td>${courseplan.period}</td>
						<td>${courseplan.totalnum}</td>


						<td><a class="btn btn-default"
							href="/StudentInfo/CoursePlanHandler/modicouplan/${courseplan.courseclass}">
								修改 </a></td>
						<td><a class="btn btn-default"
							href="/StudentInfo/CoursePlanHandler/delcouplan/${courseplan.courseclass}/${tid}">
								删除 </a></td>

					</tr>
				</c:forEach>
			</table></div></div></div>
		</div>
	</div>
	
	
	
	
	
	
	
	
			<!-- 显示分页信息 -->
	<div class="row">
		<!--分页文字信息  -->
		<div class="col-md-6">当前 ${pageInfo.pageNum }页,总${pageInfo.pages }
			页,总 ${pageInfo.total } 条记录</div>
		<!-- 分页条信息 -->
		<div class="col-md-6">
			<nav aria-label="Page navigation">
			<ul class="pagination">
				<li><a href="/StudentInfo/TeacherHandler/managecou/${sessionScope.tid }/1">首页</a></li>
				<c:if test="${pageInfo.hasPreviousPage }">
					<li><a href="/StudentInfo/TeacherHandler/managecou/${sessionScope.tid }/${pageInfo.pageNum-1}"
						aria-label="Previous"> <span aria-hidden="true">«</span>
					</a></li>
				</c:if>
 
				<c:forEach items="${pageInfo.navigatepageNums }" var="page_Num">
					<c:if test="${page_Num == pageInfo.pageNum }">
						<li class="active"><a href="#">${page_Num }</a></li>
					</c:if>
					<c:if test="${page_Num != pageInfo.pageNum }">
						<li><a href="/StudentInfo/TeacherHandler/managecou/${sessionScope.tid }/${page_Num }">${page_Num }</a></li>
					</c:if>
 
				</c:forEach>
				<c:if test="${pageInfo.hasNextPage }">
					<li><a href="/StudentInfo/TeacherHandler/managecou/${sessionScope.tid }/${pageInfo.pageNum+1 }"
						aria-label="Next"> <span aria-hidden="true">»</span>
					</a></li>
				</c:if>
				<li><a href="/StudentInfo/TeacherHandler/managecou/${sessionScope.tid }/${pageInfo.pages}">末页</a></li>
			</ul>
			</nav>
		</div>
	</div>
	
	
	
	
	
	
	
	
	
	
</div>
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>