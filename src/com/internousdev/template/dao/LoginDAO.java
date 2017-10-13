package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.internousdev.template.dto.LoginDTO;
import com.internousdev.template.util.DBConnector;

public class LoginDAO {

	private DBConnector dbConnector = new DBConnector();

	private Connection connection = dbConnector.getConnection();

	private LoginDTO loginDTO = new LoginDTO();

	/**
	 * ログインユーザ情報取得メソッド
	 *
	 * @param loginUserId
	 * @param loginPassword
	 * @return LoginDTO
	 */
	public LoginDTO getLoginUserInfo(String loginUserId, String loginPassword) {

		String sql = "SELECT * FROM login_user_transaction where login_id = ? AND login_pass = ?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, loginUserId);
			preparedStatement.setString(2, loginPassword);

			ResultSet resultSet = preparedStatement.executeQuery();

			if(resultSet.next()) {
				loginDTO.setLoginId(resultSet.getString("login_id"));
				loginDTO.setLoginPassword(resultSet.getString("login_pass"));
				loginDTO.setUserName(resultSet.getString("user_name"));
				loginDTO.setLoginFlg(resultSet.getBoolean("login_flg"));

				if(!(resultSet.getString("login_id").equals(null))) {
					loginDTO.setLoginFlg(true);
				}
			}

		} catch(Exception e) {
			e.printStackTrace();
		}

		return loginDTO;
	}
    /**
     * ユーザーIDを元に検索しログインフラグをFalseからTrueにUPDATEをおこなう為のメソッド
     * @return
     */
	public int update(String loginUserId, boolean loginFlg) throws SQLException{
		int count=0;
		String sql = "UPDATE login_user_transaction SET login_flg=? where login_id=?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setBoolean(1, loginFlg);
			ps.setString(2, loginUserId);

			count = ps.executeUpdate();

			return count;

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}

		return count;
	}
	public LoginDTO getLoginDTO() {
		return loginDTO;
	}
}
