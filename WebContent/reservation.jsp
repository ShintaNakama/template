<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:400,600"
	rel="stylesheet">
<link rel="stylesheet" href="./css/reset.css">
<!-- CSS reset -->
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet" href="./css/reservation.css">
<meta charset="utf-8">
<title>reservationPage</title>
</head>
<body>
	<div class="firstHeader">
		<s:include value="header.jsp" />
	</div>
	<section class="reservationTable">
		<s:form action="ReservationInputAction">
			<table>
				<th>ご予約希望日</th>
				<td><input type="date" name="reservationDate" required
					style="color: black; width: 12em; font-family: sans-serif; text-align: center;"
					value=" "></td>
				<th>予約開始時間</th>
				<td><input type="time" name="reservationStart" list="data1"
					min="08:00" max="21:00" required></td>
				<datalist id="data1">
					<option value="08:00"></option>
					<option value="09:00"></option>
					<option value="10:00"></option>
					<option value="11:00"></option>
					<option value="12:00"></option>
					<option value="13:00"></option>
					<option value="14:00"></option>
					<option value="15:00"></option>
					<option value="16:00"></option>
					<option value="17:00"></option>
					<option value="18:00"></option>
					<option value="19:00"></option>
					<option value="20:00"></option>
					<option value="21:00"></option>
					<option value="22:00"></option>
				</datalist>
				<th>終了時間</th>
				<td><input type="time" name="reservationEnd" list="data1"
					min="09:00" max="22:00" required></td>
				<th>予約者・団体名</th>
				<td><input type="text" name="reservationName" required></td>
			</table>
			<button class="btn" value="ReservationInputAction"
				class="reservationButton">ご予約</button>
		</s:form>

		<div class="pager">
			<ul>
				<li><s:url id="url" action="ReservationViewAction">
						<s:param name="nextWeekNumber" value="nextWeekNumber - 1" />
					</s:url>
					<s:a href="%{url}">週を戻る</s:a></li>
			</ul>
			<ul>
				<li><s:url id="url" action="ReservationViewAction">
						<s:param name="nextWeekNumber" value="0" />
					</s:url>
					<s:a href="%{url}">今週</s:a></li>
			</ul>
			<ul>
				<li><s:url id="url" action="ReservationViewAction">
						<s:param name="nextWeekNumber" value="1" />
					</s:url>
					<s:a href="%{url}">来週</s:a></li>
			</ul>
			<ul>
				<li><s:url id="url" action="ReservationViewAction">
						<s:param name="nextWeekNumber" value="2" />
					</s:url>
					<s:a href="%{url}">第3週</s:a></li>
			</ul>
			<ul>
				<li><s:url id="url" action="ReservationViewAction">
						<s:param name="nextWeekNumber" value="3" />
					</s:url>
					<s:a href="%{url}">第4週</s:a></li>
			</ul>
			<ul>

				<li><s:url id="url" action="ReservationViewAction">
						<s:param name="nextWeekNumber" value="nextWeekNumber + 1"></s:param>
					</s:url>
					<s:a href="%{url}">週を進む</s:a></li>
			</ul>
		</div>

	</section>
	<div class="cd-schedule loading">
		<div class="timeline">
			<ul>
				<li><span>08:00</span></li>
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
		</div>
		<!-- .timeline -->

		<div class="events">
			<ul>
				<li class="events-group">
					<div class="top-info">
						<span><s:property value="viewDayList[0]" /></span>
					</div>
					<ul>
						<s:if test="reservationList1 != null">
							<s:iterator value="reservationList1">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content="info"
									data-event="event-1"><a href="#0"> <em
										class="event-name"><s:property value="reservationName" /></em>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li class="single-event" data-start="<s:property value=""/>"
								data-end="<s:property value=""/>" data-content=""
								data-event="event-3"><a href="#0"><em
									class="event-name">予約無し</em> </a>
						</s:else>
					</ul>
				</li>

				<li class="events-group">
					<div class="top-info">
						<span><s:property value="viewDayList[1]" /></span>
					</div>
					<ul>
						<s:if test="reservationList2 != null">
							<s:iterator value="reservationList2">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content="info"
									data-event="event-1"><a href="#0"> <em
										class="event-name"><s:property value="reservationName" /></em>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li class="single-event" data-start="<s:property value=""/>"
								data-end="<s:property value=""/>" data-content=""
								data-event="event-3"><a href="#0"> <em
									class="event-name">予約無し</em>
							</a>
						</s:else>
					</ul>
				</li>

				<li class="events-group">
					<div class="top-info">
						<span><s:property value="viewDayList[2]" /></span>
					</div>
					<ul>
						<s:if test="reservationList3 != null">
							<s:iterator value="reservationList3">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content="info"
									data-event="event-1"><a href="#0"><em
										class="event-name"><s:property value="reservationName" /></em>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li class="single-event" data-start="<s:property value=""/>"
								data-end="<s:property value=""/>" data-content=""
								data-event="event-3"><a href="#0"> <em
									class="event-name">予約無し</em>
							</a>
						</s:else>
					</ul>
				</li>

				<li class="events-group">
					<div class="top-info">
						<span><s:property value="viewDayList[3]" /></span>
					</div>
					<ul>
						<s:if test="reservationList4 != null">
							<s:iterator value="reservationList4">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content="info"
									data-event="event-1"><a href="<s:url action="ReservationMoreDetailAction" />"> <em
										class="event-name"><s:property value="reservationName" /></em>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li class="single-event" data-start="<s:property value=""/>"
								data-end="<s:property value=""/>" data-content=""
								data-event="event-3"><a href="#0"> <em
									class="event-name">予約無し</em>
							</a>
						</s:else>
					</ul>
				</li>

				<li class="events-group">
					<div class="top-info">
						<span><s:property value="viewDayList[4]" /></span>
					</div>
					<ul>
						<s:if test="reservationList5 != null">
							<s:iterator value="reservationList5">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content="info"
									data-event="event-1"><a href="#0"> <em
										class="event-name"><s:property value="reservationName" /></em>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li class="single-event" data-start="<s:property value=""/>"
								data-end="<s:property value=""/>" data-content=""
								data-event="event-3"><a href="#0"> <em
									class="event-name">予約無し</em>
							</a>
						</s:else>
					</ul>
				</li>

				<li class="events-group">
					<div class="top-info">
						<span><s:property value="viewDayList[5]" /></span>
					</div>
					<ul>
						<s:if test="reservationList6 != null">
							<s:iterator value="reservationList6">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content="info"
									data-event="event-1"><a href="#0"> <em
										class="event-name"><s:property value="reservationName" /></em>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li class="single-event" data-start="<s:property value=""/>"
								data-end="<s:property value=""/>" data-content=""
								data-event="event-3"><a href="#0"> <em
									class="event-name">予約無し</em>
							</a>
						</s:else>
					</ul>
				</li>

				<li class="events-group">
					<div class="top-info">
						<span><s:property value="viewDayList[6]" /></span>
					</div>
					<ul>
						<s:if test="reservationList7 != null">
							<s:iterator value="reservationList7">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content="info"
									data-event="event-1"><a href="#0"> <em
										class="event-name"><s:property value="reservationName" /></em>
								</a></li>
							</s:iterator>
						</s:if>
						<s:else>
							<li class="single-event" data-start="<s:property value=""/>"
								data-end="<s:property value=""/>" data-content=""
								data-event="event-3"><a href="#0"> <em
									class="event-name">予約無し</em>
							</a>
						</s:else>
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
	</div>
	<!-- .cd-schedule -->
	<script src="./js/modernizr.js"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.0.0/jquery.min.js"></script>
	<script>
		if (!window.jQuery)
			document.write('<script src="js/jquery-3.0.0.min.js"><\/script>');
	</script>
	<script src="./js/main.js"></script>
	<!-- Resource jQuery -->
</body>
</html>