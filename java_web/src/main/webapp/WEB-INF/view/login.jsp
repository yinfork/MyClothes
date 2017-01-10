<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="resources/css/header_foot.css" />
<link rel="stylesheet" type="text/css" href="resources/css/login.css" />
<title>我的分布式衣柜</title>
</head>
<body>

	<div class="container">
		<div class="wrapper">
			<div class="heading">
				<div class="heading_title">我的分布式衣柜</div>
			</div>

			<div class="body">
				<div class="login">
					<form action="doLogin" method="post">

						<div id="login_input">
							<input id="username" type="text" name="uname" placeholder="请输入帐号">
							<input id="pwd" type="password" name="upwd" placeholder="请输入密码">
							<input id="submit" type="submit" value="登陆">
						</div>

					</form>
				</div>
			</div>
		</div>

		<div class="footing">@MyClothes</div>
	</div>


</body>
</html>