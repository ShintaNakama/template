<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>settlementPage</title>
</head>
<body>
  <h1>決済方法選択</h1>
  <form name="settlement" action="GoToSettlementAction">
    <table>
      <!-- 支払い方法の選択 -->
      <tr>
        <td><input type="radio" id="cash" name="pay" value="Cash" onClick="changeDisabled()" checked>
            <label for="cash">現金支払い</label>
        </td>
      </tr>
      <tr>
        <td><input type="radio" id="credit" name="pay" value="Credit card" onClick="changeDisabled()">
            <label for="credit">クレジットカード</label>
        </td>
      </tr>
    </table>
    <br>
    <table>
      <tr id="cardSelect">
        <th>カードを選択</th>
        <td>
          <!-- カードの種類を選択 -->
          <select name="card" required>
            <option value=""></option>
            <option value="VISA">VISA</option>
            <option value="MASTER">MASTER</option>
            <option value="AMEX">AMEX</option>
          </select>
        </td>
      </tr>
      <tr>
        <th>カード名義</th>
        <!-- カード名義を入力 -->
        <td>
        <input type="text" name="cardHolder" size="30" maxlength-"20" pattern="^[A-Z| |]{,20}" title="大文字アルファベット20文字以内で入力してください。" placeholder="名前を入力してください" required />
        </td>
      </tr>
      <tr>
        <th>カード番号</th>
        <!-- カード番号を入力 -->

      </tr>
    </table>
  </form>
</body>
</html>