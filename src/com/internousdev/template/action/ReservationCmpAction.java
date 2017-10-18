/**
 *
 */
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Map;

import com.internousdev.template.dao.ReservationCmpDAO;
import com.internousdev.template.dto.ReservationDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 * 予約がかぶらないようにチェックするアクション
 */
public class ReservationCmpAction extends ActionSupport {
  /**
	 *
	 */
	private static final long serialVersionUID = 5238438928577368989L;

/**
   * セッション情報
   */
  private Map<String, Object> sessionMap;

  private String pay;

  /**
   * メッセージ
   */
  private String message;
  /**
   * 予約番号
   */
  private int reservationNumber;
  /**
   * 予約日
   */
  private String reservationDate;
  /**
   * 予約開始時間
   */
  private int reservationStart;
  /**
   * 予約終了時間
   */
  private int reservationEnd;
  /**
   * 予約者名
   */
  private String reservationName;
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
   * 有効期限（月/年）
   */
  private String expirationDate = cardMonth + "/" + cardYear;
  /**
   * クレジットカード名義
   */
  private String cardHolder;
  /**
   * セキュリティコード
   */
  private String securityCode;
  /**
   * 予約リスト
   */
  public ArrayList<ReservationDTO> reservationList =new ArrayList<ReservationDTO>();
  /**
   * 処理結果を格納
   */
  public String result;
  /**
   * 予約状況取得DAO
   */
  public ReservationCmpDAO reservationCmpDAO = new ReservationCmpDAO();
  /**
   * 予約状況情報格納DTO
   */
  public ReservationDTO reservationDTO = new ReservationDTO();
  /**
   * 実行メソッド
   */
  public String execute() {
	//初期値
	String pay = (String) sessionMap.get("pay");

	result = ERROR;
	//支払い方法が選択されていない場合はエラー
	  if(pay.equals(null)){
		  return result;
	  }
	  //支払い方法がクレジットカードの場合
	  if(!(pay.equals("Cash"))){
		  card = (String) sessionMap.get("Card");
		  cardNumber = (String) sessionMap.get("CardNumber");
		  cardMonth = (String) sessionMap.get("CardMonth");
		  cardYear = (String) sessionMap.get("CardYear");
		  cardHolder = (String) sessionMap.get("CardHolder");
		  securityCode = (String) sessionMap.get("SecurityCode");
	  }
      // 予約状況が被らないかチェック
     reservationDTO = reservationCmpDAO.getReservationInfo(reservationNumber, reservationDate, reservationStart, reservationEnd);

      // ログイン情報を比較
      // SELECT文で値がとれば場合TRUE
      if(reservationDTO.getIsInsertErrorFlg()) {
          result = ERROR;
      }

      // 登録用のDAOを呼び出して登録

      return result;
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
  public void setSessionMap(Map<String, Object> sessionMap){
	  this.sessionMap = sessionMap;
  }
  /**
   * メッセージ取得メソッド
   */
  public String getMessage(){
	  return message;
  }
  /**
   * メッセージ登録メソッド
   */
  public void setMessage(String message){
	  this.message = message;
  }
  /**
   * 予約番号取得メソッド
   */
  public int getReservationNumber(){
	  return reservationNumber;
  }
  /**
   * 予約番号登録メソッド
   */
  public void setReservationNumber(int reservationNumber){
	  this.reservationNumber = reservationNumber;
  }
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
  public int getReservationStart(){
	  return reservationStart;
  }
  /**
   * 予約開始時間登録メソッド
   */
  public void setReservationStart(int reservationStart){
	  this.reservationStart = reservationStart;
  }
  /**
   * 予約終了時間取得メソッド
   */
  public int getReservationEnd(){
	  return reservationEnd;
  }
  /**
   * 予約終了時間登録メソッド
   */
  public void setReservationEnd(int reservationEnd){
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
   * 有効期限（月/年）取得メソッド
   */
  public String getExpirationDate(){
	  return expirationDate;
  }
  /**
   * 有効期限（月/年）登録メソッド
   */
  public void setExpirationDate(String expirationDate){
	  this.expirationDate = expirationDate;
  }
  /**
   *クレジットカード名義取得メソッド
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
   * 決済情報の取得
   */
  public String getPay(){
	  return pay;
  }
  /**
   * 決済情報の登録
   */
  public void setPay(String pay){
	  this.pay = pay;
  }
  /**
   * 予約リストを取得するメソッド
   */
  public ArrayList<ReservationDTO> getReservationList(){
	  return reservationList;
  }
  /**
   * 予約リストを登録するメソッド
   */
  public void setReservationList(ArrayList<ReservationDTO> reservationList){
	  this.reservationList = reservationList;
  }


}
