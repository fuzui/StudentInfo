<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
  <a class="navbar-brand" href="#">学生信息管理系统</a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
  <div class="collapse navbar-collapse" id="navbar-collapse-01">
  <ul class="nav navbar-nav mr-auto">
			<li><a href="/StudentInfo/StudentHandler/selqueryy/1"><strong>选课</strong></a>
			<li><a href="/StudentInfo/StudentHandler/selcouresult/${sessionScope.sid }/1"><strong>查看选课结果</strong></a>
			
			<li><a href="/StudentInfo/StudentHandler/exitchoose/${sessionScope.sid }/1"><strong>退选</strong></a>
			<li><a href="/StudentInfo/StudentHandler/endcourse/${sessionScope.sid }/1"><strong>查看已修课程</strong></a>
			<li><a href="/StudentInfo/StudentHandler/queryvitastu/${sessionScope.sid }"><strong>管理个人信息</strong></a>
    </ul>
	<p class="navbar-text navbar-right">你好！${sessionScope.sname}<a href="/StudentInfo/LoginHandler/studentlogout" class="navbar-link" href="#">注销</a></p>
	<!--
    <ul class="nav navbar-nav mr-auto">
      <li class="active"><a href="#fakelink">Products</a></li>
      <li><a href="#fakelink">Features</a></li>
    </ul>-->
  </div> <!--/.navbar-collapse -->
</nav><!-- /navbar -->




 


<!-- 
<div class="page">
	<section class="demo">
		<ul class="menu">

			<li><a href="/online/StudentController/selqueryy"><strong>选课</strong></a>
			<br>
			<li><a href="/online/StudentController/selcouresult/${sessionScope.sid }"><strong>查看选课结果</strong></a>
			<br>

			<li><a href="/online/StudentController/exitchoose/${sessionScope.sid }"><strong>退选</strong></a>
			<br>
			<li><a href="/online/StudentController/queryvitastu/${sessionScope.sid }"><strong>管理个人信息</strong></a>

			<br>

	</ul>
	</section>

</div> -->