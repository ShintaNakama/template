<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>MyPage画面</title>
	<style type="text/css">
		table {
			text-align:center;
			margin:0 auto;
		}
		#top {
		   width:780px;
		   margin:30px auto;
		   border:1px solid #333;
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
	 	<div id="pr">
		</div>
		<s:include value="header.jsp" />
	</div>
	<div id="main">
		<div id="top">
			<p>MyPage</p>
		</div>
		<div>
		
			<h3>現在のご予約はありません。</h3>
			<h3>ご予約内容は以下になります。</h3>
			<table border="1">
			<tr>
				<th>ユーザー名</th>
				<th>ユーザーID</th>
				<th>予約日</th>
				<th>開始時間</th>
				<th>終了時間</th>
			</tr>
			<s:iterator value="myPageList">
				<tr>
					<td><s:property value="itemName" /></td>
					<td><s:property value="totalPrice" /><span>円</span></td>
					<td><s:property value="totalCount" /><span>個</span></td>
					<td><s:property value="payment" /></td>
					<td><s:property value="insert_date" /></td>
				</tr>
			</s:iterator>
			</table>
			<s:form action="MyPageAction">
				<input type="hidden" name="deleteFlg" value="1">
				<s:submit value="削除" method="delete" />
			</s:form>

		<s:if test="message != null">
			<h3><s:property value="message"/></h3>
		</s:if>
			<div id="text-right">
				<p>トップへ戻る場合は<a href='<s:url action="GoTopAction" />'>こちら</a></p>
				<p>ログアウトする場合は<a href='<s:url action="LogoutAction" />'>こちら</a></p>
			</div>
		</div>
	</div>
</body>
</html>