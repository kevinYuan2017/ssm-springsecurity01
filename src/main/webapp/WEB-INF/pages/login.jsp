<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页 所有人可访问</title>
</head>
<body>
<h1>登录页, 所有人都可以访问</h1>
<form action="login" method="post">
<!-- 记住: 如果这里的登录用的是spring security的登录权限确认, 那么用户名和密码的参数名(name)必须是: j_username和j_password -->
	<label for="username">用户名: </label><input id="username" name="j_username">
	<label for="password">密码框: </label><input id="password" name="j_password">
	<button type="submit">提交</button>
</form>
</body>
</html>