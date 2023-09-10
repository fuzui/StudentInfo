<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse navbar-expand-lg" role="navigation">
  <a class="navbar-brand" href="#">学生信息管理系统</a>
  <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar-collapse-01"></button>
  <div class="collapse navbar-collapse" id="navbar-collapse-01">
  <ul class="nav navbar-nav mr-auto">
			<li><a href="/StudentInfo/CoursePlanHandler/addquery/1"><strong>添加教学课程</strong></a>
			
			<li><a
				href="/StudentInfo/TeacherHandler/managecou/${sessionScope.tid }/1"><strong>管理教学课程</strong></a>
			
			<li><a
				href="/StudentInfo/TeacherHandler/sercsc/${sessionScope.tid }/1"><strong>查看名单/结课</strong></a>
			
			<li><a
				href="/StudentInfo/TeacherHandler/queryvita/${sessionScope.tid }"><strong>管理本人信息</strong></a>
			
		</ul>
	<p class="navbar-text navbar-right">你好！ ${sessionScope.tname} &nbsp;老师<a href="/StudentInfo/LoginHandler/teacherlogout" class="navbar-link" href="#">注销</a></p>
	<!--
    <ul class="nav navbar-nav mr-auto">
      <li class="active"><a href="#fakelink">Products</a></li>
      <li><a href="#fakelink">Features</a></li>
    </ul>-->
  </div> <!--/.navbar-collapse -->
</nav><!-- /navbar -->

