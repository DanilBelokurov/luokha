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
	
	<div class="limiter">
		<div class="container-login100">
			<div class="wrap-login100 p-t-50 p-b-90">
				<form method="POST" action="${pageContext.request.contextPath}/login" class="login100-form validate-form flex-sb flex-w">
					<span class="login100-form-title p-b-51">
						Login
					</span>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Username is required">
						<input class="input100" type="text" name="username" placeholder="Username" value="${user.userName}">
						<span class="focus-input100"></span>
					</div>
					
					<div class="wrap-input100 validate-input m-b-16" data-validate = "Password is required">
						<input class="input100" type="password" name="pass" placeholder="Password" value="${user.password}">
						<span class="focus-input100"></span>
					</div>
					
					<div class="container-login100-form-btn m-t-17">
						<button class="login100-form-btn" input type="submit" value="Submit">
							Login
						</button>
					</div>
			
				</form>
			</div>
		</div>
	</div>
<!--  
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
	</form>-->




</body>
</html>