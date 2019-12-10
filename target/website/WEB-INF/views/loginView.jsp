<!DOCTYPE html>
<html>

<!--  <head>
      <meta charset="UTF-8">
      <link rel="stylesheet" href="src/source.css">
      <title>Login</title>
   </head> -->

<head>
<title>Login</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">


<style>
   <%@include file='css/bootstrap.min.css' %>
</style>

<style>
   <%@include file='css/main.css' %>
</style>

</head>

<body>

	<!--<jsp:include page="_menu.jsp"></jsp:include>

	<h3>Login Page</h3>

	<p style="color: red;">${errorString}</p>-->

	<span class="login-form-title"> Login </span>


	<form method="POST" action="${pageContext.request.contextPath}/login">
		<input type="hidden" name="redirectId" value="${param.redirectId}" />
		<table border="0">
			<tr>
				<td>User Name</td>
				<td><input type="text" name="userName" value="${user.userName}" />
				</td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"
					value="${user.password}" /></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Submit" /> <a
					href="${pageContext.request.contextPath}/">Cancel</a></td>
			</tr>
		</table>
	</form>




</body>
</html>