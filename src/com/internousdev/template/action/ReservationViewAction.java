/**
 *
 */
package com.internousdev.template.action;

import java.util.ArrayList;

import com.internousdev.template.dao.ReservationViewDAO;
import com.internousdev.template.dto.ReservationDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 * 予約状況表示アクション
 */
public class ReservationViewAction extends ActionSupport {
  /**
   * 生成されたシリアルナンバー
   */
	private static final long serialVersionUID = 4805504381097986210L;
  /**
   * 予約番号
   */
  private int reservationNumber;
  /**
   * 予約者名
   */
  private String reservationName;
  /**
   * 予約日
   */
  private String reservationDate;
  /**
   * 予約開始
   */
  private String reservatinStart;
  /**
   * 予約終了時間
   */
  private String reservationEnd;
  /**
   * 予約リスト
   */
  public ArrayList<ReservationDTO> reservationList =new ArrayList<ReservationDTO>();
  /**
   * 実行メソッド
   * @return
   */
   public String execute(){
	   String result = ERROR;

	   ReservationViewDAO dao = new ReservationViewDAO();

	   reservationList = dao.display();

	   if(reservationList.size() > 0){
		   result = SUCCESS;
	   }
	   return result;
   }

  public int getReservationNumber() {
    return reservationNumber;
  }
  public void setReservationNumber(int reservationNumber) {
    this.reservationNumber = reservationNumber;
  }
  public String getReservationName() {
    return reservationName;
  }

  public void setReservationName(String reservationName) {
	this.reservationName = reservationName;
  }
  public String getReservationDate() {
	return reservationDate;
  }
  public void setReservationDate(String reservationDate) {
	this.reservationDate = reservationDate;
  }
  public String getReservatinStart() {
	return reservatinStart;
  }
  public void setReservatinStart(String reservatinStart) {
	this.reservatinStart = reservatinStart;
  }
  public String getReservationEnd() {
	return reservationEnd;
  }
  public void setReservationEnd(String reservationEnd) {
	this.reservationEnd = reservationEnd;
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
