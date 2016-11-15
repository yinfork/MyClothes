<%@ page import="com.yin.clothes.dto.Clothes"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css"
	href="resources/css/header_foot.css" />
<link rel="stylesheet" type="text/css" href="resources/css/clothes.css" />
<script src="resources/js/jquery-2.1.1.min.js"></script>
<script src="resources/js/clothes.js"></script>
<title>My Clothes</title>
</head>
<body>
	<div class="container">
		<div class="wrapper">
			<div class="heading">
				<div class="heading_title">我的分布式衣柜</div>
				<div class="heading_nav_bar">
					<ul>
						<li><a href="clothesServlet">衣服管理</a></li>
						<li><a href="account.html">帐号中心</a></li>
						<li><a href="login.html">安全退出</a></li>
					</ul>
				</div>
			</div>

			<div class="body">
				<div class="body_title">
					<h3>欢迎衣服管理</h3>
				</div>
				<hr />
				<hr />
				<div class="wardrobe">
					<%
						List clothesList = (List) session.getAttribute("ClothesList");
						// out.print(stus.size());  
						Iterator iter = clothesList.iterator();
						while (iter.hasNext()) {
							Clothes clothes = (Clothes) iter.next();
					%>
					<div class="img_box">
						<div class="img_content">
							<img src=<%=clothes.getClothesImgPath()%> />
						</div>
					</div>
					<%
						}
					%>
				</div>
			</div>
		</div>

		<div class="footing">@我的分布式衣柜</div>
	</div>

</body>
</html>