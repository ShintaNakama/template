<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>予約内容詳細</title>
</head>
<body>
    <h1>ご予約の内容</h1>
    <div class="main">
		<table>
			<tr>
				<th>予約日</th>
				<td><s:property value="reservationDate" /></td>
			</tr>
			<tr>
				<th>予約開始時間</th>
				<td><s:property value="reservationStart" /></td>
			</tr>
			<tr>
				<th>予約終了時間</th>
				<td><s:property value="reservationEnd" /></td>
			</tr>
			<tr>
				<th>お名前・団体様名</th>
				<td><s:property value="reservationName" /></td>
			</tr>
			<tr>
				<th>決済方法</th>
				<td><s:property value="pay" /></td>
			</tr>
			<tr>
				<th>カード</th>
				<td><s:property value="card" /></td>
			</tr>
		</table>
	</div>
</body>
</html>