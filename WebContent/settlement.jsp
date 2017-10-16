<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<!-- フォントの読み込み -->
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300'
	rel='stylesheet' type='text/css'>
<!-- jQueryの読み込み -->
<script type="text/javascript"
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
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
        <input type="text" name="cardHolder" size="30" maxlength="20" pattern="^[A-Z| |]{,20}" title="大文字アルファベット20文字以内で入力してください。" placeholder="名前を入力してください" required />
        </td>
      </tr>
      <tr>
        <th>カード番号</th>
        <!-- カード番号を入力 -->
        <td>
        <input type="text" name="cardNumber" size="30" pattern="[0-9]{16}" maxlength="16" title="数字のみ16桁を入力してください。" placeholder="カード番号を入力してください" required />
        </td>
      </tr>
      <tr>
        <th>有効期限</th>
        <!-- 有効期限を選択 -->
        <td>
        <select name="cardMonth" required>
          <option value=""></option>
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
          <option value="9">9</option>
          <option value="10">10</option>
          <option value="11">11</option>
          <option value="12">12</option>
        </select>
        <select name="cardYear" required>
          <option value=""></option>
          <option value="17">17</option>
          <option value="18">18</option>
          <option value="19">19</option>
          <option value="20">20</option>
          <option value="21">21</option>
          <option value="22">22</option>
        </select>
        </td>
      </tr>
      <tr>
        <th>セキュリティコード</th>
        <!-- セキュリティコード入力 -->
        <td>
        <input type="password" name="securityCode" size="30" maxlength="4" pattern="[0-9]{3,4}" title="数字のみ3桁または4桁を入力してください。" placeholder="セキュリティコードを入力してください" required />
        </td>
      </tr>
    </table>
    <p align="center" class="pinput">
      <input type="submit" name="ReservationCmpBtn" value="決済内容確認画面へ" class="ReservationCmpBtn" />
    </p>
  </form>
  <script>
    function changeDisabled(){
    	  //クレジットカード情報の入力可にする
    	   if(document.settlement["pay"][1].checked){
    		  document.settlement["card"].disabled = false;
    		  document.settlement["cardHolder"].disabled = false;
    		  document.settlement["cardNumber"].disabled = false;
    		  document.settlement["cardMonth"].disabled = false;
    		  document.settlement["cardYear"].disabled = false;
    		  document.settlement["securityCode"].disabled = false;
    	  }
    	  //クレジットカード情報の入力不可にする
    	  else{
    		  document.settlement["card"].disabled = true;
    		  document.settlement["cardHolder"].disabled = true;
    		  document.settlement["cardNumber"].disabled = true;
    		  document.settlement["cardMonth"].disabled = true;
    		  document.settlement["cardYear"].disabled = true;
    		  document.settlement["securityCode"].disabled = true;
    	  }
    }
    //ページを表示したとき、changeDisabled()を呼び出す
    window.onload = changeDisabled;
  </script>
</body>
</html>