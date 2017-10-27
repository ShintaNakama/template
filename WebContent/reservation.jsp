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
						<span><s:property value="Day[0]" /></span>
					</div>
					<ul>
						<s:if test="reservationList1 != null">
							<s:iterator value="reservationList1">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content=""
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
						<span><s:property value="Day[1]" /></span>
					</div>
					<ul>
						<s:if test="reservationList2 != null">
							<s:iterator value="reservationList2">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content=""
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
						<span><s:property value="Day[2]" /></span>
					</div>
					<ul>
						<s:if test="reservationList3 != null">
							<s:iterator value="reservationList3">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content=""
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
						<span><s:property value="Day[3]" /></span>
					</div>
					<ul>
						<s:if test="reservationList4 != null">
							<s:iterator value="reservationList4">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content=""
									data-event="event-1"><a href="reservationData.jsp"> <em
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
						<span><s:property value="Day[4]" /></span>
					</div>
					<ul>
						<s:if test="reservationList5 != null">
							<s:iterator value="reservationList5">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content=""
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
						<span><s:property value="Day[5]" /></span>
					</div>
					<ul>
						<s:if test="reservationList6 != null">
							<s:iterator value="reservationList6">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content=""
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
						<span><s:property value="Day[6]" /></span>
					</div>
					<ul>
						<s:if test="reservationList7 != null">
							<s:iterator value="reservationList7">
								<li class="single-event"
									data-start="<s:property value="reservationStart"/>"
									data-end="<s:property value="reservationEnd"/>" data-content=""
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

		<s:form action="ReservationViewAction">
		</s:form>
		<div class="pager">
			<ul>
				<li><input type="hidden" name="nextWeekNumber" value=1><a
					href="ReservationViewAction">1</a></li>
			</ul>
			<ul>
				<li><input type="hidden" name="nextWeekNumber" value=2><a
					href="ReservationViewAction">2</a></li>
			</ul>
			<ul>
				<li><input type="hidden" name="nextWeekNumber" value=3><a
					href="ReservationViewAction">3</a></li>
			</ul>
			<ul>
				<li><input type="hidden" name="nextWeekNumber" value=4><a
					href="ReservationViewAction">4</a></li>
			</ul>
			<ul>
				<li><input type="hidden" name="nextWeekNumber" value=5><a
					href="ReservationViewAction">5</a></li>
			</ul>
		</div>
		<!-- <script type="text/javascript">
		var nextWeekNumber =1;
            while(nextWeekNumber < 14){
            	nextWeekNumber++;
            	document.write(
            			"<s:form action='ReservationViewAction'>
            			<div class='pager'>
            				<ul>
            					<li><input type='hidden' name='nextWeekNumber' value='nextWeekNumber'><a
            						href='ReservationViewAction'>'nextWeekNumber'</a></li></ul>
            						</div>
            						</s:form>"
            	);
            }
		</script> -->

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