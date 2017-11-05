/**
 *
 */
package com.internousdev.template.action;


import java.time.LocalTime;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 * 予約登録できるか判別するクラス
 */
public class ReservationInputAction extends ActionSupport implements SessionAware {
  /**
	 * 生成されたシリアルコード
	 */
	private static final long serialVersionUID = -3801291606374757979L;
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
  private String reservationStart;
  /**
   * 終了時間
   */
  private String reservationEnd;
  /**
   * 予約者・団体名
   */
  private String reservationName;
  /**
   * ログインユーザ名
   */
  private String reservationLoginUser;
  /**
   * セッション情報
   */
  private Map<String, Object> sessionMap;
  /**
   * 実行メソッド
   */
  public String execute(){
	  /*
	   * セッションに予約番号を保存する
	   */
	  sessionMap.put("ReservationNumber", reservationNumber);
	  /*
	   * セッションに予約日を保存する
	   */
	  sessionMap.put("ReservationDate", reservationDate);
	  /*
	   *セッションに予約開始時間を保存する
	   */
	  sessionMap.put("ReservationStart", reservationStart);
	  /*
	   * セッションに予約終了時間を保存する
	   */
	  sessionMap.put("ReservationEnd", reservationEnd);
	  /*
	   * セッションに予約者名を保存する
	   */
	  sessionMap.put("ReservationName", reservationName);
      /*
       * セッションにログインユーザ名を保存する
       */
	  sessionMap.put("ReservationLoginUser", reservationLoginUser);


	  LocalTime startTime =  LocalTime.parse(reservationStart);

	  LocalTime endTime =  LocalTime.parse(reservationEnd);

	  String result = SUCCESS;
	  try {


        int diff = startTime.compareTo(endTime);

  	  //時間が不正の場合
  	  if(diff == 1 ){
  		  return ERROR;
  	  }

	} catch (Exception e) {

		e.printStackTrace();
	}


	  return result;
  }
  /**
   * 予約番号取得メソッド
   */
  //public int getReservationNumber(){
	  //return reservationNumber;
  //}
  /**
   * 予約番号登録メソッド
   * @param reservationNumber
   */
  //public void setReservationNumber(int reservationNumber){
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
   * 予約開始時間登録めそっだ
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
   * ログインユーザ取得メソッド
   * @return
   */
  public String getReservationLoginUser() {
	return reservationLoginUser;
  }
  public void setReservationLoginUser(String reservationLoginUser) {
	this.reservationLoginUser = reservationLoginUser;
  }
/**
   * セッション情報取得メソッド
   */
  //public Map<String, Object> getSessionMap(){
	  //return sessionMap;
  //}
  /**
   * セッション情報登録メソッド
   */
  @Override
  public void setSession(Map<String, Object> sessionMap){
	  this.sessionMap = sessionMap;
  }
}
