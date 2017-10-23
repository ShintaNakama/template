/**
 *
 */
package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.internousdev.template.dto.ReservationDTO;
import com.internousdev.template.util.DBConnector;

/**
 * @author internousdev
 * 予約状況を表示させるためのDAO
 */
public class ReservationViewDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();


	ArrayList<ReservationDTO> reservationList =new ArrayList<ReservationDTO>();

	ArrayList<ArrayList<ReservationDTO>> reservationList2 = new ArrayList<>();

	public ArrayList<String> display(){

		String sql = "SELECT reservation_date FROM reservation_info where reservation_date between now() AND now() + INTERVAL 7 DAY GROUP BY reservation_date";
		ArrayList<String> reservationSearch = new ArrayList<>();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, reservationNumber);
			//preparedStatement.setString(2, reservationName);
			//preparedStatement.setString(3, reservationDate);
			//preparedStatement.setString(4, reservationStart);
			//preparedStatement.setString(5, reservationEnd);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){

				reservationSearch.add(resultSet.getString("reservation_date"));
				//				/ReservationDTO reservationDTO = new ReservationDTO();
				//reservationDTO.setReservationNumber(resultSet.getInt("reservation_number"));
				//reservationDTO.setReservationName(resultSet.getString("reservation_name"));
				//reservationDTO.setReservationDate(resultSet.getString("reservation_date"));
				//reservationDTO.setReservationStart(resultSet.getString("reservation_start"));
				//reservationDTO.setReservationEnd(resultSet.getString("reservation_end"));

				//reservationList.add(reservationDTO);
			}
			//			return reservationDay;
		}catch(Exception e){
			e.printStackTrace();
		}
		return reservationSearch;
	}

	public ArrayList<ReservationDTO> display2(String reservationDay){
		ArrayList<ReservationDTO> reservationList = new ArrayList<ReservationDTO>();
		try {
			/*Calendar cal = Calendar.getInstance();
			cal.add(Calendar.MONTH, 1);
			int year = cal.get((Calendar.YEAR));
			int month = cal.get((Calendar.MONTH));
			int date = cal.get(Calendar.DATE);

			String nextDate = year + "-" + month + "-" + date + " 00:00:00";*/
			String reservationSql = "SELECT * FROM reservation_info where reservation_date = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(reservationSql);
			System.out.println(reservationDay);
			preparedStatement.setString(1, reservationDay);
			//preparedStatement.setString(2, reservationName);
			//preparedStatement.setString(3, reservationDate);
			//preparedStatement.setString(4, reservationStart);
			//preparedStatement.setString(5, reservationEnd);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				ReservationDTO reservationDTO = new ReservationDTO();
				reservationDTO.setReservationNumber(resultSet.getInt("reservation_number"));
				reservationDTO.setReservationName(resultSet.getString("reservation_name"));
				reservationDTO.setReservationDate(resultSet.getString("reservation_date"));
				reservationDTO.setReservationStart(resultSet.getString("reservation_start"));
				reservationDTO.setReservationEnd(resultSet.getString("reservation_end"));

				reservationList.add(reservationDTO);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return reservationList;
	}

}
