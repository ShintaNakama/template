<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Info</title>
</head>
<body>
	<div class="event-info">
		<h1>ご予約の詳細</h1>
		<s:iterator value="reservationList4">
			<ul>
				<li>お名前・団体名：<s:property value="reservationName" />様
				</li>
				<li>ご利用時間：<s:property value="reservationStart" />～<s:property
						value="reservationEnd" /></li>
			</ul>
		</s:iterator>
		<h1>注意事項</h1>
        <ul>
		<li>ご利用時間を守るようにしてください。</li>
		<li>ご延長の場合は、別料金になります。</li>
		</ul>
	</div>
</body>
</html>