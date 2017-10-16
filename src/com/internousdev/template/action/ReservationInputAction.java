/**
 *
 */
package com.internousdev.template.action;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 * 予約登録できるか判別するクラス
 */
public class ReservationInputAction extends ActionSupport implements SessionAware {
  /**
   * 予約日
   */
  private String reservationDate;
  /**
   * 予約開始時間
   */
  private int reservationStart;
  /**
   * 終了時間
   */
  private int reservationEnd;
  /**
   * 予約者・団体名
   */
  private String reservationName;
  /**
   * セッション情報
   */
  private Map<String, Object> sessionMap;
  /**
   * 実行メソッド
   */
  public String execute(){
	  /**
	   * セッションに予約日を保存する
	   */
	  sessionMap.put("ReservationDate", reservationDate);
	  /**
	   *セッションに予約開始時間を保存する
	   */
	  sessionMap.put("ReservationStart", reservationStart);
	  /**
	   * セッションに予約終了時間を保存する
	   */
	  sessionMap.put("ReservationEnd", reservationEnd);
	  /**
	   * セッションに予約者名を保存する
	   */
	  sessionMap.put("ReservationName", reservationName);

	  String result = SUCCESS;
	  //時間が不正の場合
	  if(reservationStart >= reservationEnd){
		  result = ERROR;
	  }
	  return result;
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
	  return reservationEnd;
  }
  /**
   * 予約開始時間登録めそっだ
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
   * セッション情報取得メソッド
   */
  public Map<String, Object> getSessionMap(){
	  return sessionMap;
  }
  /**
   * セッション情報登録メソッド
   */
  public void setSession(Map<String, Object> sessionMap){
	  this.sessionMap = sessionMap;
  }
}
