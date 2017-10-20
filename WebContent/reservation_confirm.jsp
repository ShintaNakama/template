<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>reservationConfirm</title>
</head>
<body>
  <header>

  </header>
  <h1>予約内容確認画面</h1>
  <div class="contents">
    <p>以下の内容でご予約を承ります。<br>お間違いはないですか？</p>
  </div>
  <table>
    <tr>
    <th>予約日</th>
    <td><s:property value="reservationDate"/></td>
    </tr>
    <tr>
    <th>予約開始時間</th>
    <td><s:property value="reservationStart"/></td>
    </tr>
    <tr>
    <th>予約終了時間</th>
    <td><s:property value="reservationEnd"/></td>
    </tr>
    <tr>
    <th>お名前・団体様名</th>
    <td><s:property value="reservationName"/></td>
    </tr>
    <tr>
    <th>決済方法</th>
    <td><s:property value="pay"/></td>
    </tr>
    <tr>
    <th>カード</th>
    <td><s:property value="card"/></td>
    </tr>
  </table>
  <p>上記の内容でよろしいでしょうか？</p>
  <form action="ReservationCmpAction">
    <input type=hidden name="reservationDate" value="<s:property value="reservationDate"/>">
    <input type=hidden name="reservationStart" value="<s:property value="reservationStart"/>">
    <input type=hidden name="reservationEnd" value="<s:property value="reservationEnd"/>">
    <input type=hidden name="reservationName" value="<s:property value="reservationName"/>">
    <input type=hidden name="pay" value="<s:property value="pay"/>">
    <button class="Reservation">予約を完了します</button>
  </form>
</body>
</html>