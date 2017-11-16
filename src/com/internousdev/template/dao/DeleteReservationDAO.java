/**
 * 
 */
package com.internousdev.template.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.internousdev.template.util.DBConnector;

/**
 * @author nakamashinta
 *
 */
public class DeleteReservationDAO {
	
	
	
    public static int deleteReservation(int deleteReservationNumber) throws SQLException {
    	DBConnector dbConnector = new DBConnector();

    	Connection connection = dbConnector.getConnection();
    	String sql = "DELETE FROM reservation_info where reservation_number = ?";
    	
    	PreparedStatement preparedStatement;
    	int result = 0;
    	try {
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setInt(1, deleteReservationNumber);
    		
    		result = preparedStatement.executeUpdate();
    	} catch (SQLException e) {
    		e.printStackTrace();
    	} finally {
    		connection.close();
    	}
    	return result;
    }
}
