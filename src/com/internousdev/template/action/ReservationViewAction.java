/**
 *
 */
package com.internousdev.template.action;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
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
	 * 次の週へ行くたびに１をたすための数
	 */
	public int nextWeekNumber =1;
	/**
	 * 次の週の初めの日(String)
	 */
	private String nextWeekFarstDay;
	/**
	 *今日の日付け
	 */
	private LocalDate nowDay = LocalDate.now();
	/**
	 * 今日の曜日
	 */
	private DayOfWeek youbi;
    /**
     * nextWeekNumberから7日間の日付けリスト
     */
	/*switch分で取得した日付から7回まわし、７日後までを格納したリスト Dayを作成*/
	ArrayList<String> Day = new ArrayList<>();
	/**
	 * 日付け表示用Dayリスト
	 */
    ArrayList<String> viewDayList = new ArrayList<>();


	ArrayList<String> reservationSearch = new ArrayList<>();

	/**
	 * 実行メソッド
	 * @return
	 */
	public String execute(){

		String result = ERROR;
		/*ログイン中かチェック*/
		if(session.containsKey("loginFlg") == true) {


            /*ReservationDAOを取得*/
			ReservationViewDAO dao = new ReservationViewDAO();
			/*今日の日付けをnextWeekFarstDayに格納*/
			nextWeekFarstDay = nowDay.toString();
			/*nextWeekFarstDayから7日間の予約日リスト（reservationSearchList)を取得しその内容量をsizeに格納*/
			reservationSearch = dao.display(nextWeekFarstDay);
			int size =reservationSearch.size();





			for(int i=0; i<7; i++){
				/**
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.MONTH, 1);
				cal.add(Calendar.DATE, i);
				int year = cal.get((Calendar.YEAR));
				int month = cal.get((Calendar.MONTH));
				int date = cal.get(Calendar.DATE);
                */


				/*nextWeekNumberに合わせてaddDayメソッドを呼び出しDayリストに格納*/
				switch (nextWeekNumber) {
				case 1:
					Day = addDay(nowDay, 0);
					viewDayList = addViewDayList(nowDay,youbi,0);
					break;
				case 2:
					Day = addDay(nowDay, 1);
					viewDayList = addViewDayList(nowDay,youbi,1);
					break;
				case 3:
					Day = addDay(nowDay, 2);
					viewDayList = addViewDayList(nowDay,youbi,2);
					break;
				case 4:
					Day = addDay(nowDay, 3);
					viewDayList = addViewDayList(nowDay,youbi,3);
					break;
				case 5:
					Day = addDay(nowDay, 4);
					viewDayList = addViewDayList(nowDay,youbi,4);
					break;
				case 6:
					Day = addDay(nowDay, 5);
					viewDayList = addViewDayList(nowDay,youbi,5);
					break;
				case 7:
					Day = addDay(nowDay, 6);
					viewDayList = addViewDayList(nowDay,youbi,6);
					break;
				case 8:
					Day = addDay(nowDay, 7);
					viewDayList = addViewDayList(nowDay,youbi,7);
					break;
				case 9:
					Day = addDay(nowDay, 8);
					viewDayList = addViewDayList(nowDay,youbi,8);
					break;
				case 10:
					Day = addDay(nowDay, 9);
					viewDayList = addViewDayList(nowDay,youbi,9);
					break;
				case 11:
					Day = addDay(nowDay, 10);
					viewDayList = addViewDayList(nowDay,youbi,10);
					break;
				case 12:
					Day = addDay(nowDay, 11);
					viewDayList = addViewDayList(nowDay,youbi,11);
					break;
				case 13:
					Day = addDay(nowDay, 12);
					viewDayList = addViewDayList(nowDay,youbi,12);
					break;
				default:
					break;
				}
			}
			/*Dayリストの値の分、reservationSerachListの値とDayリストの日付が同じ予約情報を
			 * reservationList1~7に格納*/
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
			result = SUCCESS;
		}else {
			result = LOGIN;
		}
        /**
		if(reservationSearch.size() >= 0){
			result = SUCCESS;
		}
		*/
		return result;
	}

	/**addDayメソッド
     * nextWeekFarstDayに1週間後の日付けを格納し、DayリストにString型で格納、さらにnextWeekFarstDayの1日後の日付けを
     * 代入する。それを7回繰り返すメソッド。
     * */
	public ArrayList<String> addDay(LocalDate nextWeekFarstDay, int addWeek){
	    ArrayList<String> Day = new ArrayList<>();
	    
		nextWeekFarstDay = nextWeekFarstDay.plusWeeks(addWeek);
		for(int d = 0; d < 7; d++){
			Day.add(nextWeekFarstDay.toString() + " 00:00:00.0");
			nextWeekFarstDay = nextWeekFarstDay.plusDays(1);
		}
		return Day;
	}
	public ArrayList<String> addViewDayList(LocalDate nextWeekFarstDay, DayOfWeek youbi, int addWeek){
		ArrayList<String> viewDayList = new ArrayList<>();
		nextWeekFarstDay = nextWeekFarstDay.plusWeeks(addWeek);
		
		for(int n = 0; n < 7; n++) {
			youbi = nextWeekFarstDay.getDayOfWeek();
			viewDayList.add(nextWeekFarstDay.toString() + " " + youbi);
			nextWeekFarstDay = nextWeekFarstDay.plusDays(1);
		}
		return viewDayList;
	}


	 public ArrayList<String> getViewDayList() {
			return viewDayList;
		}
		public void setViewDayList(ArrayList<String> viewDayList) {
			this.viewDayList = viewDayList;
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

	public String getNextWeekFarstDay() {
		return nextWeekFarstDay;
	}


	public void setNextWeekFarstDay(String nextWeekFarstDay) {
		this.nextWeekFarstDay = nextWeekFarstDay;
	}

}
