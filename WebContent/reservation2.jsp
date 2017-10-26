<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<link rel="stylesheet" href="./css/reservation2.css">
<meta charset="utf-8">
<title>予約画面</title>

</head>
<body>
	<header>
		<s:include value="header.jsp" />
	</header>
	<section class="reservationTable">
		<s:form action="ReservationInputAction">
			<table>
				<th>予約日</th>
				<td><input type="date" name="reservationDate" required
					style="color: black; width: 12em; font-family: sans-serif; text-align: center;"
					value=" "></td>
				<th>予約開始時間</th>
				<td><input type="time" name="reservationStart" min="08:00"
					max="21:00" required></td>
				<th>終了時間</th>
				<td><input type="time" name="reservationEnd" min="09:00"
					max="22:00" required></td>
				<th>予約者・団体名</th>
				<td><input type="text" name="reservationName" required></td>
			</table>
			<button class="btn" value="ReservationInputAction"
				class="reservationButton">ご予約</button>
		</s:form>
	</section>
	<section class="main">
		<table>
			<tbody>
				<tr>
					<th></th>
					<th>月</th>
					<th>火</th>
					<th>水</th>
					<th>木</th>
					<th>金</th>
					<th>土</th>
					<th>日</th>
				</tr>
				<tr>
					<td>08:00</td>

					<td><div id="reservationData">ppp<s:property value="reservationName" /></div></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>09:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>10:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>11:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>12:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>13:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>14:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>15:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>16:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>17:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>18:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>19:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>20:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>21:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
				<tr>
					<td>22:00</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
				</tr>
			</tbody>
		</table>
	</section>
	<div id="modal" class="hidden">
    <h3>予約内容</h3>
    <s:property value="reservationName" />
    <s:property value="reservationStart"/>
    <s:property value="reservationEnd"/>
    <div id="close">
      Close
    </div>
  </div>
  <div id="mask" class="hidden"></div>

  <script src="js/reservation2.js"></script>
	<script type="text/javascript">
$('#pagination-demo').twbsPagination({
    totalPages: 16,
    visiblePages: 6,
    next: 'Next',
    prev: 'Prev',
    onPageClick: function (event, page) {
        //fetch content and render here
        $('#page-content').text('Page ' + page) + ' content here';
    }
});
</script>
	<div class="wrapper">
		<div class="container">

			<div class="row">
				<div class="col-sm-12">
					<h1>Page</h1>
					<p>pageネーションつけれたらつける</p>
					<ul id="pagination-demo" class="pagination-sm"></ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>