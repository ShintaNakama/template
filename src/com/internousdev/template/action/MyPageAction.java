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
	 * マイページ情報格納DTO
	 */
	public ArrayList<MyPageDTO> myPageList = new ArrayList<MyPageDTO>();

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
		if (!loginInfoMap.containsKey("id")) {
			return ERROR;
		}
        String myPageId = loginInfoMap.get("login_user_id").toString();
        myPageList = myPageDAO.getMyPageUserInfo(myPageId);
		
		result = SUCCESS;
		return result;
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
