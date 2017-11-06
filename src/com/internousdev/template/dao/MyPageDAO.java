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
	    MyPageDTO dto = new MyPageDTO();

		String sql = "SELECT login_id, user_name FROM login_user_transaction WHERE login_id =?";
		String sql2 = "SELECT * FROM reservation_info WHERE reservation_login_user =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			PreparedStatement preparedStatement2 = connection.prepareStatement(sql2);
			preparedStatement.setString(1, myPageId);
			preparedStatement2.setString(1, myPageId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				
				dto.setMyPageId(resultSet.getString("login_id"));
				dto.setUserName(resultSet.getString("user_name"));
				
			}
			ResultSet resultSet2 = preparedStatement2.executeQuery();

			while(resultSet2.next()) {
				
				dto.setReservationName(resultSet2.getString("reservation_name"));
				dto.setReservationDay(resultSet2.getString("reservation_date"));
				dto.setReservationStart(resultSet2.getString("reservation_start"));
				dto.setReservationEnd(resultSet2.getString("reservation_end"));
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
