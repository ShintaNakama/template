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
  <s:if test="#session.userId !=null && #session.loginFlg !=0">
    <ul class="manu">
      <li><a href="">トップ</a></li>
      <li><a href="">コート詳細</a></li>
      <li><a href='<s:url action="UserCreateAction" />'>新規ユーザ登録</a></li>
      <li><a href='<s:url action="LogoutAction" />'>ログアウト</a></li>
    </ul>
  </s:if>
<!-- 未ログイン時 -->
  <s:else>
    <ul class="manu">
      <li><a href="">トップ</a></li>
      <li><a href="">コート詳細</a></li>
      <li><a href='<s:url action="LoginAction" />'>ログイン</a></li>
      <li><a href='<s:url action="UserCreateAction" />'>新規ユーザ登録</a></li>
    </ul>
  </s:else>

</body>
</html>