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
	private ReservationDTO reservationDTO = new ReservationDTO();

	ArrayList<ReservationDTO> reservationList =new ArrayList<ReservationDTO>();

	public ArrayList<ReservationDTO> display(){

		String sql = "SELECT * FROM reservation_info ";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, reservationNumber);
			//preparedStatement.setString(2, reservationName);
			//preparedStatement.setString(3, reservationDate);
			//preparedStatement.setString(4, reservationStart);
			//preparedStatement.setString(5, reservationEnd);
			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){

				reservationDTO.setReservationNumber(resultSet.getInt("reservation_number"));
				reservationDTO.setReservationName(resultSet.getString("reservation_name"));
				reservationDTO.setReservationDate(resultSet.getString("reservation_date"));
				reservationDTO.setReservationStart(resultSet.getString("reservation_start"));
				reservationDTO.setReservationEnd(resultSet.getString("reservation_end"));

				reservationList.add(reservationDTO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return reservationList;
	}

}
