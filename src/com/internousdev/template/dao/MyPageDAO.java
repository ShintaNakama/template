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
	 * ログイン情報取得
	 *
	 * @return
	 * @throws SQLException
	 */
	public ArrayList<MyPageDTO> getMyPageUserInfo(String myPageId) throws SQLException {
		ArrayList<MyPageDTO> myPageDTO = new ArrayList<MyPageDTO>();

		String sql = "SELECT login_id, user_name FROM login_user_transaction WHERE login_id =?";
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, myPageId);

			ResultSet resultSet = preparedStatement.executeQuery();

			while(resultSet.next()) {
				MyPageDTO dto = new MyPageDTO();
				dto.setMyPageId(resultSet.getString("login_id"));
				dto.setUserName(resultSet.getString("user_name"));
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
