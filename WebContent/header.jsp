<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="./css/header.css" type="text/css">
<title>Header</title>
</head>
<body>

	<!-- ログイン時 -->
	<s:if test="#session.loginFlg !=null">
		<section class="header">
			<div class="header-left"><a href='<s:url action="GoTopAction" />'>InternousFutCort</a></div>
			<div class="header-right">
				<a href='<s:url action="GoTopAction" />'>トップ</a>
				<a href="cortInfo.jsp">コート詳細</a>
				<a href='<s:url action="LogoutAction" />'>ログアウト</a>
			</div>
		</section>
	</s:if>
	<!-- 未ログイン時 -->
	<s:else>
		<section class="header">
			<div class="header-left"><a href='<s:url action="GoTopAction" />'>InternousFutCort</a></div>
			<div class="header-right">
				<a href='<s:url action="GoTopAction" />'>トップ</a>
				<a href="cortInfo.jsp">コート詳細</a>
				<a href='<s:url action="LoginAction" />'>ログイン</a>
				<a href='<s:url action="UserCreateAction" />'>新規ユーザ登録</a>
			</div>
		</section>
	</s:else>
</body>
</html>