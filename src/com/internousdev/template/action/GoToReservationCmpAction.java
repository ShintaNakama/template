/**
 * 
 */
package com.internousdev.template.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author nakamashinta
 * 予約決済内容確認画面へ遷移するためのクラス
 */
public class GoToReservationCmpAction extends ActionSupport implements SessionAware {
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
   * 予約者名
   */
  private String reservationName;
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
   * セッション情報
   */
  private Map<String, Object> sessionMap;
  /**
   * 
   * セッションから予約情報を取得する。 クレジットカード情報に未入力があればエラーメッセージを表示し、エラーを返す。
   * 引数にてクレジットカード番号を指定する事で該当するものが存在するか確認できます。
   */
}
