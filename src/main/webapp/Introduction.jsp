<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head><script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico" type="image/x-icon" />
<meta charset="UTF-8">
<title>项目必读</title>
<!-- Loading Bootstrap -->
<link href="/StudentInfo/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
<!-- Loading Flat UI Pro -->
<link href="/StudentInfo/utils/css/flat-ui.css" rel="stylesheet">
<!-- Loading Flat UI JS -->
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.min.js"></script>
<script type='text/javascript' src='/StudentInfo/utils/scripts/particles.js'></script><link href="/StudentInfo/utils/css/animate.css" rel="stylesheet"></head>
<body>
	
	
	<div class="jumbotron text-center">
  <h1>学生信息管理系统</h1>
  <p>V1.0</p> 
</div>
	<div class="container">
  <div class="row">
      <font color="red">因为mysql连接失效问题，有时候登录会出现异常，返回再次登录即可！(待修复)</font>
      <br>
      <h5>应用技术</h5>
      <br>
      
        <ul class="list-group">
          <li class="list-group-item">工具：eclipse、navicat</li>
          <li class="list-group-item">环境：JDK1.8、tomcat9.0、mysql8.0</li>
          <li class="list-group-item">前端：JavaScript、jQuery、bootstrap4、particles.js</li>
          <li class="list-group-item">后端：maven、SpringMVC、MyBatis、ajax、mysql读写分离、mybatis分页</li>
        </ul>
        
        <br>
        <h5>简介</h5>
      
        由SpringMVC+MyBatis为主要框架，mysql8.0配置主从复制实现读写分离，主机丛机分别为腾讯云的服务器，而项目部署在阿里云上。前端主要由bootstrap完成，背景用particles.js插件。数据库交互查询用到pagehelper分页。在添加修改相关功能时通过ajax来验证其主键是否存在可用。代码层次清晰，输入框约束较高，已配置登录拦截。
    
    <br>
    <h5>主要功能模块图</h5>
    <img src="https://fuzui.oss-cn-shenzhen.aliyuncs.com/img/20190414000551.png"/>
    其中查询拥有多种查询方式，功能持续更新中······
    <br>
    <h5>部分测试数据</h5>
    <div class="alert alert-danger">提示：除管理员外其他测试数据均可能被修改，介意登录管理员查看其他角色账号密码测试</div>
   <table class="table table-hover">
    <thead>
      <tr>
        <th>角色</th>
        <th>账号</th>
        <th>密码</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>管理员</td>
        <td>admin</td>
        <td>admin</td>
      </tr>
      <tr>
        <td>教师</td>
        <td>0002</td>
        <td>111111</td>
      </tr>
      <tr>
        <td>教师</td>
        <td>1003</td>
        <td>123456</td>
      </tr>
      <tr>
        <td>学生</td>
        <td>201107024126</td>
        <td>000000</td>
      </tr>
      <tr>
        <td>学生</td>
        <td>201220122016</td>
        <td>111111</td>
      </tr>
    </tbody>
  </table>
  </div>
</div>

<h5>更新日志</h5>


<ul class="list-group">
          <li class="list-group-item">
              <p>2019.4.14：发布第一个版本</p>
              <p>预计下一版本于4.25，将会新增排课查重、选课限制、学分统计、教师系别等功能</p>
              <p>2019.6.19：新增结课、学分统计、成绩录入功能/p>
              <p>鉴于这是一个简单的学习项目，因为时间问题暂停更新，会陆续解决已有bug</p>
          </li>
          <li class="list-group-item">······</li>
        </ul>
 <br>
 <br>       
 <center><font face="华文行楷" size=6 color="blue">
当你的才华还撑不起你的野心的时候，<br>你就应该静下心来学习。</font>
</center>
	
<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script></body>
</html>