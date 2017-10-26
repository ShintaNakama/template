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
public class ReservationViewAction2 extends ActionSupport implements SessionAware {
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
	 * 予約リスト(1日）
	 */
	public ArrayList<ReservationDTO> reservationDayList1 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationDayList2 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationDayList3 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationDayList4 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationDayList5 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationDayList6 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationDayList7 =new ArrayList<>();
	/**
	 * 予約リスト（週）
	 */
	public ArrayList<ArrayList<ReservationDTO>> reservationWeek = new ArrayList<>();


	ArrayList<String> reservationSearch = new ArrayList<>();

	/**
	 * 総データ数
	 */
	private int number;

	/**
	 * 総ページ数
	 */
	private int maxPage;

	/**
	 * 現在のページ
	 */
	private int pageNum = 1;

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
							reservationDayList1 = dao.display2(reservationSearch.get(j));
						}else if (i == 1) {
							reservationDayList2 = dao.display2(reservationSearch.get(j));
						}else if (i == 2) {
							reservationDayList3 = dao.display2(reservationSearch.get(j));
						}else if (i == 3) {
							reservationDayList4 = dao.display2(reservationSearch.get(j));
						}else if (i == 4) {
							reservationDayList5 = dao.display2(reservationSearch.get(j));
						}else if (i == 5) {
							reservationDayList6 = dao.display2(reservationSearch.get(j));
						}else if (i == 6) {
							reservationDayList7 = dao.display2(reservationSearch.get(j));
						} else {
							continue;
						}
					}
				}
			}

		}else {
			result = LOGIN;
		}
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
	public ArrayList<ReservationDTO> getReservationDayList1(){
		return reservationDayList1;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationDayList1(ArrayList<ReservationDTO> reservationDayList1){
		this.reservationDayList1 = reservationDayList1;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationDayList2(){
		return reservationDayList2;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationDayList2(ArrayList<ReservationDTO> reservationDayList2){
		this.reservationDayList2 = reservationDayList2;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationDayList3(){
		return reservationDayList3;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationDayList3(ArrayList<ReservationDTO> reservationDayList3){
		this.reservationDayList3 = reservationDayList3;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationDayList4(){
		return reservationDayList4;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationDayList4(ArrayList<ReservationDTO> reservationDayList4){
		this.reservationDayList4 = reservationDayList4;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationDayList5(){
		return reservationDayList5;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationDayList5(ArrayList<ReservationDTO> reservationDayList5){
		this.reservationDayList5 = reservationDayList5;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationDayList6(){
		return reservationDayList6;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationDayList6(ArrayList<ReservationDTO> reservationDayList6){
		this.reservationDayList6 = reservationDayList6;
	}

	/**
	 * 予約リストを取得するメソッド
	 */
	public ArrayList<ReservationDTO> getReservationDayList7(){
		return reservationDayList7;
	}
	/**
	 * 予約リストを登録するメソッド
	 */
	public void setReservationDayList7(ArrayList<ReservationDTO> reservationDayList7){
		this.reservationDayList7 = reservationDayList7;
	}

}
