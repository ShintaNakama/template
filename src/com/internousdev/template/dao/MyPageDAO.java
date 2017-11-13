package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.internousdev.template.dto.MyPageDTO;
import com.internousdev.template.util.DBConnector;

public class MyPageDAO {
	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();
	
	/**
	 * ログインIDとユーザ名とそのログインIDの予約情報を取得
	 *
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MyPageDTO> getMyPageUserInfo(String myPageId) throws SQLException {
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();
	    

		String sql = "SELECT * FROM reservation_info WHERE reservation_login_user =? and reservation_date > now()";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, myPageId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setReservationName(resultSet.getString("reservation_name"));
				dto.setReservationDay(resultSet.getString("reservation_date"));
				dto.setReservationStart(resultSet.getString("reservation_start"));
				dto.setReservationEnd(resultSet.getString("reservation_end"));
				myPageDTO.add(dto);
			}
			

		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return myPageDTO;
	}

}
