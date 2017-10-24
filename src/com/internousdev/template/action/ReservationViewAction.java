/**
 *
 */
package com.internousdev.template.action;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.ReservationViewDAO;
import com.internousdev.template.dto.ReservationDTO;
import com.opensymphony.xwork2.ActionSupport;

/**
 * @author internousdev
 * 予約状況表示アクション
 */
public class ReservationViewAction extends ActionSupport implements SessionAware {
	/**
	 * 生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = 4805504381097986210L;
	/**
	 * ログインフラグ
	 */
	private boolean loginFlg;
	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> session;
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
	 * りざると
	 *
  private String result;
  /**
	 * 予約リスト
	 */
	public ArrayList<ReservationDTO> reservationList1 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList2 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList3 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList4 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList5 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList6 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList7 =new ArrayList<>();


	ArrayList<String> reservationSearch = new ArrayList<>();

	/**
	 * 実行メソッド
	 * @return
	 */
	public String execute(){

		String result = ERROR;

		if(session.containsKey("loginFlg") == true) {


			ReservationViewDAO dao = new ReservationViewDAO();

			reservationSearch = dao.display();
			int size =reservationSearch.size();
			ArrayList<String> Day = new ArrayList<>();
			for(int i=0; i<7; i++){
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, 1);
				cal.add(Calendar.DATE, i);
				int year = cal.get((Calendar.YEAR));
				int month = cal.get((Calendar.MONTH));
				int date = cal.get(Calendar.DATE);
				Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
			}
			for(int i=0;Day.size()>i;i++){
				for(int j=0;size>j;j++){
					if(Day.get(i).equals(reservationSearch.get(j))) {
						if(i == 0){
							reservationList1 = dao.display2(reservationSearch.get(j));
						}else if (i == 1) {
							reservationList2 = dao.display2(reservationSearch.get(j));
						}else if (i == 2) {
							reservationList3 = dao.display2(reservationSearch.get(j));
						}else if (i == 3) {
							reservationList4 = dao.display2(reservationSearch.get(j));
						}else if (i == 4) {
							reservationList5 = dao.display2(reservationSearch.get(j));
						}else if (i == 5) {
							reservationList6 = dao.display2(reservationSearch.get(j));
						}else if (i == 6) {
							reservationList7 = dao.display2(reservationSearch.get(j));
						} else {
							continue;
						}
					}
				}
			}
		}else {
			result = LOGIN;
		}


		/**
		 * 今日の日付け
		 */
		/*
	   for(int i= 0; i<reservationList.size(); i++){

           String reservation[] = {null,null,null,null,null,null,null};
		   if(Day == reservationList.get(i).get(0).getReservationDate()) {
             reservation[i] = "1";
		   }

		   reservationList5.add((reservationList.get(1)).get(0));
	   }
		 */
		if(reservationSearch.size() > 0){
			result = SUCCESS;
		}


		return result;
	}


	public boolean getLoginFlg() {
		return loginFlg;
	}
	public void setLoginFlg(boolean loginFlg) {
		this.loginFlg = loginFlg;
	}
	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	public Map<String, Object>getSession(){
		return session;
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
	public ArrayList<ReservationDTO> getReservationList1(){
		return reservationList1;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationList1(ArrayList<ReservationDTO> reservationList1){
		this.reservationList1 = reservationList1;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationList2(){
		return reservationList2;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationList2(ArrayList<ReservationDTO> reservationList2){
		this.reservationList2 = reservationList2;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationList3(){
		return reservationList3;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationList3(ArrayList<ReservationDTO> reservationList3){
		this.reservationList3 = reservationList3;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationList4(){
		return reservationList4;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationList4(ArrayList<ReservationDTO> reservationList4){
		this.reservationList4 = reservationList4;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationList5(){
		return reservationList5;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationList5(ArrayList<ReservationDTO> reservationList5){
		this.reservationList5 = reservationList5;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationList6(){
		return reservationList6;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationList6(ArrayList<ReservationDTO> reservationList6){
		this.reservationList6 = reservationList6;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationList7(){
		return reservationList7;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationList7(ArrayList<ReservationDTO> reservationList7){
		this.reservationList7 = reservationList7;
	}

}
