/**
 * 
 */
package com.internousdev.template.action;

import java.sql.SQLException;

import com.internousdev.template.dao.DeleteReservationDAO;

/**
 * @author nakamashinta
 * 予約を削除するアクション
 */
public class DeleteReservationAction {
	/**
	 * 削除する予約番号
	 */
	public int deleteReservationNumber;
	/**
	 * 削除用メッセージ
	 */
	public String message;
	/**
	 * 削除フラグ
	 */
	public String deleteFlg;
	public String result;
	
    public String execute() throws SQLException {
    	    
    	    int delete = DeleteReservationDAO.deleteReservation(deleteReservationNumber);
    	    if (delete > 0) {
    	    	    message = "予約を削除しました";
    	    	    result = SUCCESS;
    	    }
    	    return result;
    }

	public int getDeleteReservationNumber() {
		return deleteReservationNumber;
	}

	public void setDeleteReservationNumber(int deleteReservationNumber) {
		this.deleteReservationNumber = deleteReservationNumber;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
    
    
    
}
