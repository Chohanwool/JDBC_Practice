package com.chw.model.vo;

import java.sql.Date;

public class Member {

	// 필드부 => DB에 존재하는 컬럼명과 유사하게 지어주는게 좋다.
	/* MEMBER TABLE의 컬럼명들
	USERNO	NUMBER
	USERID	VARCHAR2(15 BYTE)
	USERPWD	VARCHAR2(20 BYTE)
	USERNAME	VARCHAR2(20 BYTE)
	GENDER	CHAR(1 BYTE)
	AGE	NUMBER
	EMAIL	VARCHAR2(30 BYTE)
	PHONE	VARCHAR2(13 BYTE)
	ADDRESS	VARCHAR2(100 BYTE)
	INFO	VARCHAR2(500 BYTE)
	B_DAY	DATE
	*/
	
	private int userNo;
	private String userId;
	private String userPwd;
	private String userName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private String info;
	private Date dateOfBirth;
	
	// 생성자부
	// 기본생성자, default값이 있는 필드를 제외한 생성자, 모든 필드를 포함하는 생성자
	public Member() {
		super();
	}
	
	public Member(String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String info, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.info = info;
		this.dateOfBirth = dateOfBirth;
	}

	public Member(String userId, String userPwd, String userName, String gender, int age, String email, String phone,
			String address, String info, Date dateOfBirth) {
		super();
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.info = info;
		this.dateOfBirth = dateOfBirth;
	}

	public Member(int userNo, String userId, String userPwd, String userName, String gender, int age, String email,
			String phone, String address, String info, Date dateOfBirth) {
		super();
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.info = info;
		this.dateOfBirth = dateOfBirth;
	}

	// Getter/Setter
	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// toString메소드
	@Override
	public String toString() {
		return "Member [회원번호 : " + userNo + ", 아이디 : " + userId + ", 비밀번호 : " + userPwd + ", 사용자 이름 : " + userName
				+ ", 성별 : " + gender + ", 나이 : " + age + ", 이메일 : " + email + ", 연락처 : " + phone + ", 주소 : "
				+ address + ", 생년월일 : " + dateOfBirth + ", 짧은 소개 : " + info +"]";
	}
	
	
	
}
