package com.internousdev.template.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.template.dao.MyPageDAO;
import com.internousdev.template.dto.MyPageDTO;
import com.opensymphony.xwork2.ActionSupport;

public class MyPageAction extends ActionSupport implements SessionAware{

	/**
	 * 　生成されたシリアルナンバー
	 */
	private static final long serialVersionUID = -3316901123677984300L;
    
    private String myPageId;
	
	private String userName;
	/**
	 * ログイン情報を格納
	 */
	public Map<String, Object> loginInfoMap = new HashMap<>();
	/**
	 * マイページ情報取得DAO
	 */
	public MyPageDAO myPageDAO = new MyPageDAO();
	/**
	 * マイページ情報格納DTO
	 */
	public MyPageDTO myPageDTO = new MyPageDTO();

	/**
	 * マイページユーザ情報格納リスト
	 */
	public ArrayList<MyPageDTO> myPageUserList = new ArrayList<MyPageDTO>();
    /**
     * マイページ予約情報格納リスト
     */
	public ArrayList<MyPageDTO> myPageReservationList = new ArrayList<MyPageDTO>();
	/**
	 * 削除フラグ
	 */
	public String deleteFlg;

	/**
	 * 処理結果
	 */
	public String result;
	
	public String message = null;

	/**
	 * MyPage情報取得メソッド
	 *
	 * @author internous
	 */
	public String execute() throws SQLException {
		String result = ERROR;
		/*ログイン情報確認*/
		if (!loginInfoMap.containsKey("id")) {
			return ERROR;
		}
		/*ログインIDをmyPageIdに格納し、
		 * myPageDAOからログインID、ユーザ名、予約情報を取得しmyPageListに格納*/
        myPageId = loginInfoMap.get("login_user_id").toString();
        userName = loginInfoMap.get("login_user_name").toString();
        myPageUserList = myPageDAO.getMyPageUserInfo(myPageId);
        
		result = SUCCESS;
		return result;
	}
    
	
	
	public String getMyPageId() {
		return myPageId;
	}



	public void setMyPageId(String myPageId) {
		this.myPageId = myPageId;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getDeleteFlg() {
		return deleteFlg;
	}

	public void setDeleteFlg(String deleteFlg) {
		this.deleteFlg = deleteFlg;
	}

	@Override
	public void setSession(Map<String, Object> loginSessionMap) {
		this.loginInfoMap = loginSessionMap;
	}
}
