/**
 *
 */
package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;

/**
 * @author internousdev
 * DBへ予約情報を登録するためのDAO
 */
public class InsertReservationDAO {

	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	//private ReservationDTO reservationDTO = new ReservationDTO();
	//データベースへの予約内容登録

	public int InsertReservation(String reservationName, String reservationDate, String reservationStart, String reservationEnd) throws SQLException {

		int count = 0;
		//データベースへの予約内容登録
	    String reservationSql ="INSERT INTO reservation_info (reservation_name, reservation_date, reservation_start, reservation_end) VALUES(?,?,?,?)";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(reservationSql);
			preparedStatement.setString(1, reservationName);
			preparedStatement.setString(2, reservationDate);
			preparedStatement.setString(3, reservationStart);
			preparedStatement.setString(4, reservationEnd);


			count =  preparedStatement.executeUpdate();


		} catch(Exception e){
			e.printStackTrace();
		}
		return count;
	}

}
