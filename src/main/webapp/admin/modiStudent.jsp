<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<jsp:include page="adminLeft.jsp" />
	<div class="container">
		<div class="row"> 
			<div class="col-md-12">
				<h5>修改学生</h5>
				<c:forEach var="student" items="${requestScope.studentList}">
							
						<form action="../moditystud/${student.sid}" method="get">
				<div class="row">
					
							<div class="col-md-6">
								<h6>姓名</h6>
						<input type="text" name="sname" value="${student.sname }" class="form-control" onkeyup="this.value=this.value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="4"></input>
						<h6>身份证号</h6>
						<input type="text" name="sidcard" value="${student.sidcard }" class="form-control" oninput = "value=value.replace(/[^\d]/g,'')" maxlength="16"></input>
						
						<h6>性别</h6>
						<c:choose>
							<c:when test="${student.ssex == '男'}">
								<label class="radio" for="radio1">
			                  		<input type="radio" name="ssex" value="男" checked id="radio1" data-toggle="radio" class="custom-radio">
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
			                  		<input type="radio" name="ssex" value="女" id="radio2" data-toggle="radio" class="custom-radio">
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
							
							</c:when>
						
							<c:otherwise>
								<label class="radio" for="radio1">
			                  		<input type="radio" name="ssex" value="男"  id="radio1" data-toggle="radio" class="custom-radio">
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
			                  		<input type="radio" name="ssex" value="女" checked id="radio2" data-toggle="radio" class="custom-radio">
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
							
							</c:otherwise>
						</c:choose>
						
						
						<h6>密码</h6>
						<input type="password" name="spassword" value="${student.spassword }" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"></input>
								
							</div>
							<div class="col-md-6">
							
							<h6>年龄</h6>
						<input type="text" name="sage" value="${student.sage}" class="form-control" maxlength="2"></input>
							
							<h6>专业 ${student.profession }</h6>
							<select name="profession"
								class="form-control select select-primary select-block mbl" id="belongcoll">
								<option value="">-请选择学院-</option>
							</select>
							
							<h6>学院 ${student.college}</h6>
							<select name="college"
								class="form-control select select-primary select-block mbl" id="belongpro">
								<option value="">-请选择专业-</option>
							</select>
							
							<h6>班级 ${student.classr }</h6>
							<select name="classr"
								class="form-control select select-primary select-block mbl" id="belongcla">
								<option value="">-请选择班级-</option>
							</select>
							
							
							
							</div>
							<div class="col-md-12">
								<input type="submit" class="btn btn-primary btn-wide login-btn" style="margin-top:2rem" value="修改" />
							</div>
							
				</div>
	</form>
					</c:forEach>
   					
</div>
</div>
</div>


	<script type="text/javascript" src="/StudentInfo/utils/scripts/flat-ui.js"></script><script src="/StudentInfo/utils/scripts/bganimation.js"></script>
	
	
	<script type="text/javascript">
    
$("form").submit(function(){
  //当表单提交的时候，对字段验证，并根据需要放出提示
  if($.trim($("#belongcoll").val())==""){
      alert("学院不能为空");
      return false;//终止表单提交
      
  }else if($.trim($("#belongpro").val())==""){
      alert("专业不能为空");
      return false;//终止表单提交
      
  }else if($.trim($("#belongcla").val())==""){
      alert("班级不能为空");
      return false;//终止表单提交
      
  }
});
    
    
    var arr_belongcoll = ["计算机学院","建筑学院","外国语学院","人文学院"];
    var arr_belongpro = [
                    ["网络工程","软件工程","物联网","信息管理"],
                    ['土木工程','测绘工程','工程造价', '城市规划'],
                    ['英语', '日语', '俄语', '西班牙语'],
                    ['汉语言', '历史', '新闻', '网络新媒体']
                ];
     var arr_belongcla = [
                [
                    ["网络B151","网络B152","网络B161","网络B162","网络B171","网络B172"],
                    ["软件B151","软件B152","软件B161","软件B162","软件B171","软件B172"],
                    ["物联B151","物联B152","物联B161","物联B162","物联B171","物联B172"],
                    ["信管B151","信管B152","信管B161","信管B162","信管B171","信管B172"]
                    
                ],
                [
                    ["土木B151","土木B152","土木B161","土木B162","土木B171","土木B172"],
                    ["测绘B151","测绘B152","测绘B161","测绘B162","测绘B171","测绘B172"],
                    ["造价B151","造价B152","造价B161","造价B162","造价B171","造价B172"],
                    ["规划B151","规划B152","规划B161","规划B162","规划B171","规划B172"]
                    
                ],
                [
                    ["英语B151","英语B152","英语B161","英语B162","英语B171","英语B172"],
                    ["日语B151","日语B152","日语B161","日语B162","日语B171","日语B172"],
                    ["俄语B151","俄语B152","俄语B161","俄语B162","俄语B171","俄语B172"],
                    ["牙语B151","牙语B152","牙语B161","牙语B162","牙语B171","牙语B172"]
                    
                ],
                [
                    ["汉语B151","汉语B152","汉语B161","汉语B162","汉语B171","汉语B172"],
                    ["历史B151","历史B152","历史B161","历史B162","历史B171","历史B172"],
                    ["新闻B151","新闻B152","新闻B161","新闻B162","新闻B171","新闻B172"],
                    ["网媒B151","网媒B152","网媒B161","网媒B162","网媒B171","网媒B172"]
                    
                ]
                ];
  
    var ocoll=document.getElementById("belongcoll");
    var opro=document.getElementById("belongpro");
    var ocla=document.getElementById("belongcla");


    var  quanju_arr;//创建一个全局对象，用于存储一个中间数组

    function input_arr(arr,event){//封装一个函数，用于向下拉栏中添加元素
        for(var i=0;i<arr.length;i++){//下拉栏内的元素来源于数组中的元素，遍历数组
            var option=new Option(arr[i],i);//创建Option对象（这个O要大写），存入值
            event.appendChild(option);//把option添加到event对象的末尾
        }
    }

    input_arr(arr_belongcoll,ocoll);//调用,给省下拉栏添元素

    ocoll.onchange= function () {//给下拉栏绑定事件（当下拉栏元素改变时执行）
        
        opro.options.length=1;//当省下拉栏改变时，清空市的下拉栏内元素
        ocla.options.length=1;//当省下拉栏改变时，清空县的下拉栏内元素
        
        var index=this.value;//每一个option标签都有一个value值索引，获取索引，用于数组中元素的选择
        var arr_pro_next=arr_belongpro[index];//获取当前选择省的市元素并赋给一个数组
        quanju_arr=arr_belongcla[index];//获取当前选择省中市的县元素并赋给定义的中间数组
        input_arr(arr_pro_next,opro);//调用,给市下拉栏添元素
    }

    opro.onchange= function () {
        ocla.options.length=1;
        var index=this.value;
        var arr_cla_next=quanju_arr[index];
        input_arr(arr_cla_next,ocla);//调用,给县下拉栏添元素
    }


</script>
	
	
	<script>
		$("select").select2({
			dropdownCssClass : 'dropdown-inverse'
		});
	</script>
	</body>
</html>