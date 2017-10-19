<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>予約完了画面</title>
</head>
<body>
  <header>
    <s:include value="header.jsp" />
  </header>

  <h1>ご予約ありがとうございます！</h1><br>
  <h1>コートでお待ちしております！</h1>
  <s:form action="GoTopAction">
  <button value="GoTopAction" class="GoTopButton">トップページへ戻る</button>
  </s:form>
</body>
</html>