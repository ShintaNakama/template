<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>MyPage画面</title>
<style type="text/css">
.userInfo table {
	text-align: center;
	margin: 0 auto;
	padding: 0;
	border-collapse: collapse;
}

.userInfo th {
	border: 1px solid #000;
	padding: 10px;
}

.userInfo td {
	border: 1px solid #000;
	padding: 10px;
}

.myReservation table {
	text-align: center;
	margin: 0 auto;
	padding: 0;
	border-collapse: collapse;
}

.myReservation th {
	border: 1px solid #000;
	padding: 10px;
}

.myReservation td {
	border: 1px solid #000;
	padding: 10px;
}

#top {
	width: 780px;
	margin: 30px auto;
	border: 1px solid #333;
}

#main {
	width: 100%;
	height: 500px;
	text-align: center;
}

#text-right {
	display: inline-block;
	text-align: right;
}
</style>
</head>
<body>
	<div id="header">
		<s:include value="header.jsp" />
	</div>
	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>
		<div class="userInfo">
			<table>
				<s:iterator value="myPageList">
					<tr>
						<th scope="row">ログインID</th>
						<td><s:property value="myPageId" /></td>
					</tr>
					<tr>
						<th scope="row">ユーザー名</th>
						<td><s:property value="userName" /></td>
					</tr>
				</s:iterator>
			</table>
		</div>
		<div class="myReservation">
			<s:if test="myPageList != null">
				<h3>ご予約内容は以下になります。</h3>
				<table>
					<tr>
						<th>予約名</th>
						<th>予約日</th>
						<th>開始時間</th>
						<th>終了時間</th>
					</tr>
					<s:iterator value="myPageList">
						<tr>
							<td><s:property value="reservationName" /></td>
							<td><s:property value="reservationDay" /></td>
							<td><s:property value="reservationStart" /></td>
							<td><s:property value="reservationEnd" /></td>
						</tr>
					</s:iterator>
				</table>
			</s:if>
			<s:else>
				<h3>現在のご予約はありません。</h3>
			</s:else>
		</div>
		<s:if test="message != null">
			<h3>
				<s:property value="message" />
			</h3>
		</s:if>
		<div id="text-right">
			<s:form action="MyPageAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete" />
			</s:form>
			<p>
				トップへ戻る場合は<a href='<s:url action="GoTopAction" />'>こちら</a>
			</p>
			<p>
				ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a>
			</p>
		</div>

	</div>
</body>
</html>