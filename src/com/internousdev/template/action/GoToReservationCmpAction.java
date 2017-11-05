/**
 *
 */
package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.util.CreditCard;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nakamashinta
 * 予約決済内容確認画面へ遷移するためのクラス
 */
public class GoToReservationCmpAction extends ActionSupport implements SessionAware {
  /**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = -2339931343794613721L;
/**
   * 予約番号
   */
  //private int reservationNumber;
  /**
   * 予約日
   */
  private String reservationDate;
  /**
   * 予約開始時間
   */
  private String reservationStart;
  /**
   * 終了時間
   */
  private String reservationEnd;
  /**
   * 予約者名
   */
  private String reservationName;
  /**
   * ログインユーザ名
   */
  private String reservationLoginUser;
  /**
   * 支払い方法
   */
  private String pay;
  /**
   * クレジットカード種別
   */
  private String card;
  /**
   * クレジットカード番号
   */
  private String cardNumber;
  /**
   * 有効期限（月）
   */
  private String cardMonth;
  /**
   * 有効期限（年）
   */
  private String cardYear;
  /**
   * クレジッットカード名義
   */
  private String cardHolder;
  /**
   * セキュリティコード
   */
  private String securityCode;
  /**
   * エラーメッセージ
   */
  private String cardErrorMessage;
  /**
   * カレンダー
   */
  private String calendar;
  /**
   * セッション情報
   */
  private Map<String, Object> sessionMap;
  /*
   * 支払い方法未選択時のエラーメッセージ
   */
  private String payNotFundErrorMessage;
  /**
   *
   * セッションから予約情報を取得する。 クレジットカード情報に未入力があればエラーメッセージを表示し、エラーを返す。
   * 引数にてクレジットカード番号を指定する事で該当するものが存在するか確認できます。
   */
  public String execute(){
	  /**
	   * セッションから予約番号を取得する
	   */
	  //reservationNumber = (int) sessionMap.get("ReservationNumber");
	  /**
	   * セッションから予約日を取得する
	   */
	  reservationDate = (String) sessionMap.get("ReservationDate");

	  /**
	   * セッションから予約開始時間を取得する
	   */
	  reservationStart = (String) sessionMap.get("ReservationStart");

	  /**
	   * セッションから予約終了時間を取得する
	   */
	  reservationEnd = (String) sessionMap.get("ReservationEnd");

	  /**
	   * セッションから予約者名を取得する
	   */
	  reservationName = (String) sessionMap.get("ReservationName");
      
	  /**
	   * セッションからログインユーザ名を取得する
	   */
	  reservationLoginUser = (String) sessionMap.get("ReservationLoginUser");
	  /**
	   * クレジット有効期限日設定
	   */
	  calendar = (String) sessionMap.get("Calendar");
	  String expirationDate = cardMonth + cardYear;

	  /**
	   * セッションにクレジットカード種別を保存する
	   */
	  sessionMap.put("Card", card);

	  /*
	   * セッションにクレジットかード番号を保存する
	   */
	  sessionMap.put("CardNumber", cardNumber);
	  /*
	   * セッションに有効期限（月）を保存する
	   */
	  sessionMap.put("CardMonth", cardMonth);
	  /*
	   * セッションに有効期限（年）を保存する
	   */
	  sessionMap.put("CardYear", cardYear);
	  /*
	   * セッションにクレジットカード名義を保存する
	   */
	  sessionMap.put("CardHolder", cardHolder);
	  /*
	   * セッションにセキュリティコードを保存する;
	   */
	  sessionMap.put("SecurityCode", securityCode);
	  /*
	   * すべて成功した場合にSUCCESS
	   *
	   */
	  if(pay == null){
		  payNotFundErrorMessage = "お支払い方法が未選択です。";
		  return ERROR;
	  }

	  if(!pay.equals("Cash")){
		  /*
		   * カード番号もしくは有効期限が未入力だったらエラーを返す
		   */
		  if(!cardNumber.equals("")){
			  if(card.equals("") || cardHolder.equals("") || cardNumber.equals("")
					  || cardYear.equals("") || cardMonth.equals("") || securityCode.equals("")){
				  cardErrorMessage = "クレジットカード情報に未入力の項目があります。";
				  return ERROR;
			  }
		  }

		  CreditCard creditCard = new CreditCard();
		  /*
		   * 引数にてクレジットカード番号を指定する事で該当するものが存在するか確認できます。
		   */
		  if(creditCard.isExists(cardNumber)){
			  //insert 処理
			  creditCard.add(cardNumber, cardHolder, expirationDate, securityCode, (String) sessionMap.get("UserId"));

		  }else {
			  return ERROR;
		  }
	  }
	  //支払い方法の値をsessionに格納
	  sessionMap.put("pay", pay);

	  return SUCCESS;
  }
  /**
   * 予約番号取得メソッド
   */
  //public int getReservationNumber(){
	  //return reservationNumber;
 // }
  /**
   * 予約番号登録メソッド
   */
 // public void setReservationNumber(int reservationNumber){
	  //this.reservationNumber = reservationNumber;
  //}
  /**
   * 予約日取得メソッド
   */
  public String getReservationDate(){
	  return reservationDate;
  }
  /**
   * 予約日登録メソッド
   */
  public void setReservationDate(String reservationDate){
	  this.reservationDate = reservationDate;
  }
  /**
   * 予約開始時間取得メソッド
   */
  public String getReservationStart(){
	  return reservationStart;
  }
  /**
   * 予約開始時間登録メソッド
   */
  public void setReservationStart(String reservationStart){
	  this.reservationStart = reservationStart;
  }
  /**
   * 予約終了時間取得メソッド
   */
  public String getReservationEnd(){
	  return reservationEnd;
  }
  /**
   * 予約終了時間登録メソッド
   */
  public void setReservationEnd(String reservationEnd){
	  this.reservationEnd = reservationEnd;
  }
  /**
   * 予約者名取得メソッド
   */
  public String getReservationName(){
	  return reservationName;
  }
  /**
   * 予約者名登録メソッド
   */
  public void setReservationName(String reservationName){
	  this.reservationName = reservationName;
  }
  /**
   * ログインユーザ名取得メソッド
   */
  public String getReservationLoginUser() {
		return reservationLoginUser;
	}
  public void setReservationLoginUser(String reservationLoginUser) {
		this.reservationLoginUser = reservationLoginUser;
	}
  /**
   * 支払い方法取得メソッド
   */
  public String getPay(){
	  return pay;
  }
  
/**
   * 支払い方法登録メソッド
   */
  public void setPay(String pay){
	  this.pay = pay;
  }
  /**
   * クレジットカード種別取得メソッド
   */
  public String getCard(){
	  return card;
  }
  /**
   * クレジットカード種別登録メソッド
   */
  public void setCard(String card){
	  this.card = card;
  }
  /**
   * クレジットカード番号取得メソッド
   */
  public String getCardNumber(){
	  return cardNumber;
  }
  /**
   * クレジットカード番号登録メソッド
   */
  public void setCardNumber(String cardNumber){
	  this.cardNumber = cardNumber;
  }
  /**
   * 有効期限（月）取得メソッド
   */
  public String getCardMonth(){
	  return cardMonth;
  }
  /**
   * 有効期限（月）登録メソッド
   */
 public void setCardMonth(String cardMonth){
	 this.cardMonth = cardMonth;
 }
 /**
  * 有効期限（年）取得メソッド
  */
 public String getCardYear(){
	 return cardYear;
 }
 /**
  * 有効期限（年）登録メソッド
  */
 public void setCardYear(String cardYear){
	 this.cardYear = cardYear;
 }
 /**
  * クレジットカード名義取得メソッド
  */
 public String getCardHolder(){
	 return cardHolder;
 }
 /**
  * クレジットカード名義登録メソッド
  */
 public void setCardHolder(String cardHolder){
	 this.cardHolder = cardHolder;
 }
 /**
  * セキュリティコード取得メソッド
  */
 public String getSecurityCode(){
	 return securityCode;
 }
 /**
  * セキュリティコード登録メソッド
  */
 public void setSecurityCode(String securityCode){
	 this.securityCode = securityCode;
 }
 /**
  * エラーメッセージ取得メソッド
  */
 public String getCardErrorMessage(){
	 return cardErrorMessage;
 }
 /**
  * エラーメッセージ登録メソッド
  */
 public void setCardErrorMesasge(String cardErrorMessage){
	 this.cardErrorMessage = cardErrorMessage;
 }
 /**
  * セッション情報取得メソッド
  */
 public Map<String, Object> getSessionMap(){
	 return sessionMap;
 }
 /**
  * セッション情報登録メソッド
  */
 @Override
 public void setSession(Map<String, Object> sessionMap){
	 this.sessionMap = sessionMap;
 }
 public String getPayNotFundErrorMessage(){
	 return payNotFundErrorMessage;
 }
 public void setPayNotFundErrorMessage(String payNotFundErrorMessage){
	 this.payNotFundErrorMessage = payNotFundErrorMessage;
 }
}
