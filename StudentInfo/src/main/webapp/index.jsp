<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<link rel="shortcut icon" href="/StudentInfo/utils/image/favicon.ico"
	type="utils/image/x-icon" />
<meta charset="UTF-8">
<title>学生信息管理系统</title>

<script type="text/javascript" src="utils/js/jquery-3.3.1.min.js"></script>

<!-- Loading Bootstrap -->
<link href="utils/css/vendor/bootstrap.min.css" rel="stylesheet">

<!-- Loading Flat UI Pro -->
<link href="utils/css/flat-ui.css" rel="stylesheet">

<!-- Loading Flat UI Pro -->
<link href="utils/css/animate.css" rel="stylesheet">

<link href='http://fonts.googleapis.com/css?family=Montserrat:400,700'
	rel='stylesheet' type='text/css'>
<script type='text/javascript' src='utils/scripts/particles.js'></script>
<!--<script type='text/javascript' src='scripts/jquery.particleground.js'></script>-->
<script src="utils/js/bootstrap.min.js"></script>
<style>
.login-plane {
	padding: 2rem;
	margin-top: 3rem;
}

.center-block {
	display: block;
	margin-left: auto;
	margin-right: auto;
}

.center-carousel {
	width: 33%;
	margin-left: auto;
	margin-right: auto;
}

.login-btn {
	width: 100%;
	margin-top: 1rem;
}

.container {
	padding-top: 4rem;
}

body {
	/*background: url(image/bj.jpg)*/
	
}
</style>

<link href="/StudentInfo/utils/css/animate.css" rel="stylesheet">
</head>
<body style="display: flex;">











	<div id="particles-js">
		<canvas class="particles-js-canvas-el" width="1322" height="774"
			style="width: 100%; height: 100%;">
    </canvas>
	</div>
	<div class="container" id="particles"
		style="position: relative; top: -4rem; margin: auto;">
		<div class="row">
			<div class="col-md-12">
				<h4 class="text-center animated bounceInDown">学生信息管理系统</h4>







				<!-- 轮播图部分-->

				<div class="wwze">
					<!-- 模态框 -->
					<div class="modal fade" id="myModal">
						<div class="modal-dialog modal-lg">
							<div class="modal-content">

								<!-- 模态框头部 -->
								<div class="modal-header">
									<h4 class="modal-title">项目必读：相关技术、技术、测试数据、版本更新</h4>
									<button type="button" class="close" data-dismiss="modal">&times;</button>
								</div>

								<!-- 模态框主体 -->
								<div class="modal-body">

									<jsp:include page="Introduction.jsp" />
								</div>

								<!-- 模态框底部 -->
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-dismiss="modal">关闭</button>
								</div>

							</div>
						</div>
					</div>
				</div>


				<div class="center-carousel">
					<div id="demo" class="carousel slide" data-ride="carousel">

						<!-- 指示符 -->
						<ul class="carousel-indicators">
							<li data-target="#demo" data-slide-to="0" class="active"></li>
							<li data-target="#demo" data-slide-to="1"></li>
							<li data-target="#demo" data-slide-to="2"></li>
							<li data-target="#demo" data-slide-to="4"></li>
						</ul>

						<!-- 轮播图片 -->
						<div class="carousel-inner">
							<div class="carousel-item active">
								<a data-toggle="modal" data-target="#myModal" href=""><img
									src="https://fuzui.oss-cn-shenzhen.aliyuncs.com/img/img001.png"></a>
							</div>
							<div class="carousel-item">
								<a href="https://github.com/fuzui/" target="_blank"><img
									src="https://fuzui.oss-cn-shenzhen.aliyuncs.com/img/github.jpg"></a>
							</div>
							<div class="carousel-item">
								<a href="https://fuzui.net" target="_blank"><img
									src="https://fuzui.oss-cn-shenzhen.aliyuncs.com/img/myblog.jpg"></a>
							</div>
							<div class="carousel-item">
								<a href="https://blog.csdn.net/qq_39329616" target="_blank"><img
									src="https://fuzui.oss-cn-shenzhen.aliyuncs.com/img/myinfo.jpg"></a>
							</div>
						</div>

						<!-- 左右切换按钮 -->
						<a class="carousel-control-prev" href="#demo" data-slide="prev">
							<span class="carousel-control-prev-icon"></span>
						</a> <a class="carousel-control-next" href="#demo" data-slide="next">
							<span class="carousel-control-next-icon"></span>
						</a>

					</div>
				</div>


				<!-- 轮播图部分结束-->







			</div>
			<div class="col-md-12">
				<div class="row login-plane animated fadeIn">
					<div class="col-md-4 center-block">
						<form method="post" name="login" id="login" action=""
							onsubmit="return submitHandler()">
							<strong>账号信息</strong>
							<div class="form-group has-feedback">
								<input name="" type="text" id="userid" value=""
									placeholder="userid" class="form-control" m="userid"
									onkeyup="value=value.replace(/[\u4e00-\u9fa5]|(^\s+)|(\s+$)/ig,'')"
									maxlength="12" /> <span class="form-control-feedback fui-user"></span>
							</div>
							<div class="form-group has-feedback">
								<input name="" type="password" value="" id="password"
									placeholder="password" class="form-control" m="password"
									onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');"
									maxlength="16" /> <span class="form-control-feedback fui-lock"></span>
							</div>

							<div class="row">
								<div class="col-md-12">
									<strong>角色信息</strong>
								</div>
								<div class="col-md-4">
									<label class="radio" for="radio1"> <input type="radio"
										name="optionsRadios1" value="student" checked="checked"
										id="radio1" data-toggle="radio" class="custom-radio">
										<span class="icons"> <span class="icon-unchecked"></span>
											<span class="icon-checked"></span>
									</span> <font style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;"> 学生 </font>
									</font>
									</label>
								</div>
								<div class="col-md-4">
									<label class="radio" for="radio2"> <input type="radio"
										name="optionsRadios1" value="teacher" id="radio2"
										data-toggle="radio" class="custom-radio"> <span
										class="icons"> <span class="icon-unchecked"></span> <span
											class="icon-checked"></span>
									</span> <font style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;"> 老师 </font>
									</font>
									</label>
								</div>
								<div class="col-md-4">
									<label class="radio" for="radio3"> <input type="radio"
										name="optionsRadios1" value="admin" id="radio3"
										data-toggle="radio" class="custom-radio"> <span
										class="icons"> <span class="icon-unchecked"></span> <span
											class="icon-checked"></span>
									</span> <font style="vertical-align: inherit;"> <font
											style="vertical-align: inherit;"> 管理员 </font>
									</font>
									</label>
								</div>
							</div>

							<input class="btn btn-primary btn-wide login-btn" value="LOGIN"
								type="submit" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		var useridEle = document.getElementById("userid");
		var passwordEle = document.getElementById("password");
		var roleRadio = document.getElementsByName("optionsRadios1");

		/*
		 * 点击登录执行的逻辑
		 */
		function submitHandler() {

			if (!vali()) {
				return false;
			}

			var role = 'student';

			for (var i = 0; i < roleRadio.length; i++) {
				if (roleRadio[i].checked) {
					role = roleRadio[i].value;
				}
			}

			var action = null;
			if (role == 'student') {
				action = "/StudentInfo/LoginHandler/studentlogin";
				useridEle.name = "sid";
				passwordEle.name = "spassword";
			} else if (role == 'teacher') {
				action = "/StudentInfo/LoginHandler/teacherlogin";
				useridEle.name = "tid";
				passwordEle.name = "tpassword";
			} else {
				action = "/StudentInfo/LoginHandler/adminlogin";
				useridEle.name = "aname";
				passwordEle.name = "apassword";
			}
			document.getElementById("login").action = action;

			return true;
		}

		function vali() {
			var valiObjs = createInputMsgObj([ 'userid', 'password' ])

			for (var i = 0; i < valiObjs.length; i++) {
				console.log(valiObjs[i].el.val())
				if (valiObjs[i].el.val() == null || valiObjs[i].el.val() == '') {
					valiObjs[i].el.css({
						"border-color" : "red"
					})
					console.log(valiObjs[i].el)
					var alertEl = $("<div style=\"position:fixed;top:1rem;right:1rem;\" class=\"alert alert-warning\">"
							+ valiObjs[i].msg + "没有填写！" + "</h5></div>")
					$("body").append(alertEl);
					setTimeout(function() {
						alertEl.remove();
					}, 1000)
					return false;
				}
			}
			return true;
		}

		function createInputMsgObj(ids) {
			var objs = [];

			for (var i = 0; i < ids.length; i++) {

				var obj = {
					el : $("#" + ids[i]),
					msg : $("#" + ids[i]).attr('m')
				}
				objs.push(obj);
			}

			return objs;
		}
	</script>
	<script src="utils/scripts/bganimation.js"></script>
</body>
</html>