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
	 * 予約リスト(日）
	 */
	public ArrayList<ReservationDTO> reservationList1 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList2 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList3 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList4 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList5 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList6 =new ArrayList<>();
	public ArrayList<ReservationDTO> reservationList7 =new ArrayList<>();
	/**
	 * 予約リスト（週）
	 */
	public ArrayList<ArrayList<ReservationDTO>> reservationWeek =new ArrayList<>();
	/**
	 * 次の週へ行くたびに１をたすための数
	 */
	private int nextWeekNumber =1;
	/**
	 * 次の週の初めの日
	 */
	private int nextWeekFarstDay;


	
	ArrayList<String> reservationSearch = new ArrayList<>();

	/**
	 * 実行メソッド
	 * @return
	 */
	public String execute(){

		String result = ERROR;
         /*ログイン中かチェック*/
		if(session.containsKey("loginFlg") == true) {



			ReservationViewDAO dao = new ReservationViewDAO();
            /*今日から7日間の予約日リスト（reservationSearchList)を取得しその内容量をsizeに格納*/
			reservationSearch = dao.display(nextWeekFarstDay);
			int size =reservationSearch.size();
			/*今日の日付を取得し、switch分で取得した日付から７日後までを格納したリスト Dayを作成*/
			ArrayList<String> Day = new ArrayList<>();
			
			for(int i=0; i<7; i++){
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, 1);
				cal.add(Calendar.DATE, i);
				int year = cal.get((Calendar.YEAR));
				int month = cal.get((Calendar.MONTH));
				int date = cal.get(Calendar.DATE);
				
				/*次週へ遷移するとき、nextWeekNumberの値に合わせて13週間の最初の日を取得*/
				switch (nextWeekNumber) {
				case 1:
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 2:
					cal.add(Calendar.DATE, 7);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 3:
					cal.add(Calendar.DATE, 14);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 4:
					cal.add(Calendar.DATE, 21);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 5:
					cal.add(Calendar.DATE, 28);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 6:
					cal.add(Calendar.DATE, 35);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 7:
					cal.add(Calendar.DATE, 42);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 8:
					cal.add(Calendar.DATE, 49);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 9:
					cal.add(Calendar.DATE, 56);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 10:
					cal.add(Calendar.DATE, 63);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 11:
					cal.add(Calendar.DATE, 70);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 12:
					cal.add(Calendar.DATE, 77);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				case 13:
					cal.add(Calendar.DATE, 84);
					date = cal.get(Calendar.DATE);
					nextWeekFarstDay = date;
					Day.add(year + "-" + month + "-" + date + " 00:00:00.0");
					break;
				default:
					break;
				}
			}
            /*Dayリストの値の分、reservationSerachListの値とDayリストの日付が同じ予約情報を
             * reservationList1~7に格納*/
			for(int i=0;Day.size()>i;i++){
				while(size > nextWeekFarstDay){
					if(Day.get(i).equals(reservationSearch.get(nextWeekFarstDay))) {
						if(i == 0){
							reservationList1 = dao.display2(reservationSearch.get(nextWeekFarstDay));
						}else if (i == 1) {
							reservationList2 = dao.display2(reservationSearch.get(nextWeekFarstDay));
						}else if (i == 2) {
							reservationList3 = dao.display2(reservationSearch.get(nextWeekFarstDay));
						}else if (i == 3) {
							reservationList4 = dao.display2(reservationSearch.get(nextWeekFarstDay));
						}else if (i == 4) {
							reservationList5 = dao.display2(reservationSearch.get(nextWeekFarstDay));
						}else if (i == 5) {
							reservationList6 = dao.display2(reservationSearch.get(nextWeekFarstDay));
						}else if (i == 6) {
							reservationList7 = dao.display2(reservationSearch.get(nextWeekFarstDay));
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
	public int getNextWeekNumber() {
		return nextWeekNumber;
	}


	public void setNextWeekNumber(int nextWeekNumber) {
		this.nextWeekNumber = nextWeekNumber;
	}


	public int getNextWeekFarstDay() {
		return nextWeekFarstDay;
	}


	public void setNextWeekFarstDay(int nextWeekFarstDay) {
		this.nextWeekFarstDay = nextWeekFarstDay;
	}

}
