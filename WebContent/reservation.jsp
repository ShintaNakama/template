<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600" rel="stylesheet">
<link rel="stylesheet" href="./css/reset.css"> <!-- CSS reset -->
<link rel="stylesheet" href="./css/style.css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reservationPage</title>
</head>
<body>
  <script type="text/javascript">
    //今日の日付データを変数nowDateに格納
    window.onload = function(){
    var nowDate = new Date();

    //月、日を取得する
    var month = nowDate.getMonth() +1;
    var day = nowDate.getDate();
    var yb = "日月火水木金土".charAt(nowDate.getDay());
    //出力用
    document.getElementById("view_time").innerHTML = month + "/" + day +"("+ yb +")";

    var view_time2 = new Date();
    view_time2.setDate(view_time2.getDate() + 1);
    //月、日を取得する
    month = view_time2.getMonth() +1;
    day = view_time2.getDate();
    yb = "日月火水木金土".charAt(view_time2.getDay());

    document.getElementById("view_time2").innerHTML = month + "/" + day +"("+ yb +")";

    }
  </script>
  <div class="firstHeader">
    <s:include value="header.jsp" />
  </div>
  <s:form action="ReservationInputAction">
    <table>
            <!--  <input type="hidden" name="reservationNumber"> -->
      <th>予約日</th>
        <td><input type="date" name="reservationDate" required style="color:black;width:12em;font-family:sans-serif;text-align:center; "value=" "></td>
      <th>予約開始時間</th>
        <td><input type="time" name="reservationStart" min="08:00" max="21:00" required></td>
      <th>終了時間</th>
        <td><input type="time" name="reservationEnd" min="09:00" max="22:00" required></td>
      <th>予約者・団体名</th>
        <td><input type="text" name="reservationName" required></td>
    </table>

    <button value="ReservationInputAction" class="reservationButton">予約</button>
  </s:form>
<div class="cd-schedule loading">
	<div class="timeline">
		<ul><li><span>08:00</span></li>
		    <li><span>08:30</span></li>
			<li><span>09:00</span></li>
			<li><span>09:30</span></li>
			<li><span>10:00</span></li>
			<li><span>10:30</span></li>
			<li><span>11:00</span></li>
			<li><span>11:30</span></li>
			<li><span>12:00</span></li>
			<li><span>12:30</span></li>
			<li><span>13:00</span></li>
			<li><span>13:30</span></li>
			<li><span>14:00</span></li>
			<li><span>14:30</span></li>
			<li><span>15:00</span></li>
			<li><span>15:30</span></li>
			<li><span>16:00</span></li>
			<li><span>16:30</span></li>
			<li><span>17:00</span></li>
			<li><span>17:30</span></li>
			<li><span>18:00</span></li>
			<li><span>18:30</span></li>
			<li><span>19:00</span></li>
			<li><span>19:30</span></li>
			<li><span>20:00</span></li>
			<li><span>20:30</span></li>
			<li><span>21:00</span></li>
			<li><span>21:30</span></li>
			<li><span>22:00</span></li>
		</ul>
	</div> <!-- .timeline -->

	<div class="events">
		<ul>
			<li class="events-group">
			    <div class="date"><s:property value="#session.reservationDate"/></div>
				<div class="top-info"><span id="view_time"></span></div>

				<ul>
					<li class="single-event" data-start="09:30" data-end="10:30" data-content="event-test1" data-event="event-1">
						<a href="#0">
							<em class="event-name">test 1</em>
						</a>
					</li>

					<li class="single-event" data-start="11:00" data-end="12:30" data-content="event-test2" data-event="event-2">
						<a href="#0">
							<em class="event-name">test 2</em>
						</a>
					</li>

					<li class="single-event" data-start="14:00" data-end="15:15"  data-content="event-test3" data-event="event-3">
						<a href="#0">
							<em class="event-name">test 3</em>
						</a>
					</li>
					<li class="single-event" data-start="<s:property value="#session.reservationStart"/>" data-end="<s:property value="#session.reservationEnd"/>"  data-content="" data-event="event-1">

							<em class="event-name"><s:property value="#session.reservationName"/></em>

					</li>
				</ul>
			</li>

			<li class="events-group">
				<div class="top-info"><span id="view_time2"></span></div>
                <ul>
                    <li>
                    </li>
                </ul>
			</li>

			<li class="events-group">
				<div class="top-info"><span id="view_time3"></span></div>
                <ul>
                    <li>
                    </li>
                </ul>
			</li>

			<li class="events-group">
				<div class="top-info"><span id="view_time(3)"></span></div>
                <ul>
                    <li>
                    </li>
                </ul>
			</li>

			<li class="events-group">
				<div class="top-info"><span id="view_time(4)"></span></div>
                <ul>
                    <li>
                    </li>
                </ul>
			</li>

			<li class="events-group">
				<div class="top-info"><span id="view_time(5)"></span></div>
                <ul>
                    <li>
                    </li>
                </ul>
			</li>

			<li class="events-group">
				<div class="top-info"><span id="view_time(6)"></span></div>
                <ul>
                    <li>
                    </li>
                </ul>
			</li>
		</ul>
	</div>

<div class="event-modal">
	 	<header class="header">
			<div class="content">
				<span class="event-date"></span>
				<h3 class="event-name"></h3>
			</div>

			<div class="header-bg"></div>
		</header>

		<div class="body">
			<div class="event-info"></div>
			<div class="body-bg"></div>
		</div>

		<a href="#0" class="close">Close</a>
	</div>

	<div class="cover-layer"></div>
</div> <!-- .cd-schedule -->
<script src="./js/modernizr.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
<script>
	if( !window.jQuery ) document.write('<script src="js/jquery-3.0.0.min.js"><\/script>');
</script>
<script src="./js/main.js"></script> <!-- Resource jQuery -->
</body>
</html>