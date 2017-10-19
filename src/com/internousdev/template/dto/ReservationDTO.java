package com.internousdev.template.dto;

public class ReservationDTO {
    /**
     * 予約判断のエラーフラグ
     */
	private boolean insertErrorFlg = false;
    /**
     * 予約番号（id)
     */
	private int reservationNumber;
    /**
     * 予約日
     */
	private String reservationDate;
    /**
     * 予約開始時間
     */
	private String reservationStart;
    /**
     * 予約終了時間
     */
	private String reservationEnd;
	/**
	 * 予約者名
	 */
	private String reservationName;
	/**
	 * クレジットカード種別
	 */
	private String card;
    /**
	 * クレジットカード番号
	 */
	private String cardNumber;
	/**
	 * 有効期限（月）
	 */
	private String cardMonth;
	/**
	 * 有効期限（年）
	 */
	private String cardYear;
	/**
	 * 有効期限（月/年）
	 */
	private String expirationDate = cardMonth + "/" + cardYear;
	/**
	 * クレジットカード名義
	 */
	private String cardHolder;
	/**
	 * セキュリティコード
	 */
	private String securityCode;



	public String getReservationName() {
		return reservationName;
	}

	public void setReservationName(String reservationName) {
		this.reservationName = reservationName;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardMonth() {
		return cardMonth;
	}

	public void setCardMonth(String cardMonth) {
		this.cardMonth = cardMonth;
	}

	public String getCardYear() {
		return cardYear;
	}

	public void setCardYear(String cardYear) {
		this.cardYear = cardYear;
	}

	public String getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getCardHolder() {
		return cardHolder;
	}

	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}

	public String getSecurityCode() {
		return securityCode;
	}

	public void setSecurityCode(String securityCode) {
		this.securityCode = securityCode;
	}
	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationStart() {
		return reservationStart;
	}

	public void setReservationStart(String reservationStart) {
		this.reservationStart = reservationStart;
	}

	public String getReservationEnd() {
		return reservationEnd;
	}

	public void setReservationEnd(String reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public boolean getIsInsertErrorFlg() {
		return insertErrorFlg;
	}

	public void setInsertErrorFlg(boolean insertErrorFlg) {
		this.insertErrorFlg = insertErrorFlg;
	}

	public int getReservationNumber() {
		return reservationNumber;
	}

	public void setReservationNumber(int reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

}
