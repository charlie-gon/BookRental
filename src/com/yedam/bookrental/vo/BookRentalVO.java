package com.yedam.bookrental.vo;

import java.sql.Date;

public class BookRentalVO {
	
	private Date rentalDate; // 대여일자
	private String bCode; // 도서코드
	private String mId; // 회원아이디
	private String returnDate; // 반납일자
	
	public BookRentalVO() {
		// TODO Auto-generated constructor stub
	}

	public Date getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(Date rentalDate) {
		this.rentalDate = rentalDate;
	}

	public String getbCode() {
		return bCode;
	}

	public void setbCode(String bCode) {
		this.bCode = bCode;
	}

	public String getmId() {
		return mId;
	}

	public void setmId(String mId) {
		this.mId = mId;
	}

	public String getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(String returnDate) {
		this.returnDate = returnDate;
	}
	
	

}
