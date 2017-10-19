package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.internousdev.template.dto.ReservationDTO;
import com.internousdev.template.util.DBConnector;

public class ReservationCmpDAO {
	private DBConnector dbConnector = new DBConnector();
	private Connection connection = dbConnector.getConnection();
	private ReservationDTO reservationDTO = new ReservationDTO();

	/**
	 * 予約情報取得メソッド
	 *
	 * 日時 開始時間 終了時間でSELECT発行
	 * もしデータがなければ登録でき
	 * データがあるならば登録できない
	 */
	public ReservationDTO getReservationInfo(String reservationName, String reservationDate, String reservationStart, String reservationEnd){
		String sql = "SELECT * FROM reservation_info where reservation_name = ? AND reservation_date = ? AND reservation_start = ? AND reservation_end = ?";

		// SELECT文発行
		// reservationDTO = "データあり";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			//preparedStatement.setInt(1, reservationNumber);
			preparedStatement.setString(1, reservationName);
			preparedStatement.setString(2, reservationDate);
			preparedStatement.setString(3, reservationStart);
			preparedStatement.setString(4, reservationEnd);


			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()){
				//reservationDTO.setReservationNumber(resultSet.getInt("reservationNumber"));
				reservationDTO.setReservationName(resultSet.getString("reservationName"));
				reservationDTO.setReservationDate(resultSet.getString("reservationDate"));
				reservationDTO.setReservationStart(resultSet.getString("reservationStart"));
				reservationDTO.setReservationEnd(resultSet.getString("reservationEnd"));


			}

		    // データの有無を比較
		    if(reservationDTO.getReservationNumber() > 0) {
			    // エラーフラグを立てる
			    reservationDTO.setInsertErrorFlg(true);
		    }

		} catch(Exception e){
			e.printStackTrace();
		}
		return reservationDTO;
	}

}
