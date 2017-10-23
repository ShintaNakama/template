<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="./css/cortInfo.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CortInfo</title>
</head>
<body>
	<header>
		<s:include value="header.jsp" />
	</header>

	<section class="infoTable">
		<h1>コート詳細</h1>
		<table>
			<tr>
				<th scope="row">住所</th>
				<td>〒113-0034 東京都文京区湯島3丁目2-12 御茶ノ水天神ビル2F</td>
			</tr>
			<tr>
				<th scope="row">電話番号</th>
				<td>Tel. 01-2345-6789</td>
			</tr>
			<tr>
				<th scope="row">メールアドレス</th>
				<td>futcort@internous.co.jp</td>
			</tr>
			<tr>
				<th scope="row">料金（1時間当たり）</th>
				<td>5,000円</td>
			</tr>
		</table>
	</section>
	<div id="shopinfobb" align="center">
		<h2 id="shopinfo" class="bline" style="width: 5.5em" align="center">CortMap</h2>

	</div>
	<div style="width: 500px; margin: auto;">
		<!-- GoogleMap -->
		<iframe
			src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3239.910248408922!2d139.76482297877934!3d35.70382618382467!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x60188c18b82a5b79%3A0xf4b11fd9c5add54c!2z44CSMTEzLTAwMzQg5p2x5Lqs6YO95paH5Lqs5Yy65rmv5bO277yT5LiB55uu77yS4oiS77yR77ySIOW-oeiMtuODjuawtOWkqeelnuODk-ODqw!5e0!3m2!1sja!2sjp!4v1460439784843"
			width="500" height="300" style="border: 0"></iframe>
	</div>
	<section class="reservationBtn">
		<h2>ご予約、コート空き情報の確認はこちらから</h2>
		<a class="btn" href="<s:url action="ReservationViewAction" />"> 
		<i class="fa fa-external-link" aria-hidden="true"></i>予約ページへ</a>
	</section>
</body>
</html>