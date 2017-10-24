<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css" />
<meta http-equiv="Content-Script-Type" content="text/javascript" />
<meta http-equiv="imagetoolbar" content="no" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<link rel="stylesheet" href="./css/login.css" type="text/css">

<meta charset="utf-8">
<title>Login画面</title>

</head>

<body>
	<header>
		<s:include value="header.jsp" />
	</header>
	<section class="main">
		<div class="container">
			<div class="login-container">
				<h1>Login</h1>
				<p>ログインIDとパスワードを入力して下さい</p>
				<div id="output"></div>
				<div class="avatar"></div>
				<div class="form-box">
					<s:form action="LoginAction">
						<input type="text" name="loginUserId" placeholder="loginUserId">
						<input type="password" name="loginPassword"
							placeholder="loginPassword">
						<button class="login" type="submit">LOGIN</button>
					</s:form>
				</div>
			</div>
		</div>
		<section class="text-link">
			<a class="btn1" href='<s:url action="UserCreateAction" />'>新規ユーザー登録はこちら</a>
			<a class="btn2" href='<s:url action="GoTopAction" />'>TOPへ戻る場合はこちら</a>
		</section>
	</section>
	</div>
	<section class="footer"></section>
</body>
</html>