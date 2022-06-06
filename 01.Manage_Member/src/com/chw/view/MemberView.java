package com.chw.view;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import com.chw.controller.MemberController;
import com.chw.model.vo.Member;

public class MemberView {
	
	// view에서 사용할 스캐너와 컨트롤러 객체 필드로 생성
	private Scanner sc = new Scanner(System.in);
	private MemberController mc = new MemberController();
	
	/**
	 * 클라이언트가 처음 보게될 메인 메뉴
	 */
	public void mainMenu() {
		
		while(true) {
			System.out.println("\n\n========== 메인 메뉴 ==========");
			System.out.println("1. 전체 회원 조회");
			System.out.println("2. 신규 회원 추가");
			System.out.println("3. 회원 검색(아이디)");
			System.out.println("4. 회원 검색(주소)");
			System.out.println("5. 회원 정보 수정");
			System.out.println("0. 프로그램 종료");
			
			System.out.println("\n메뉴 번호를 입력하세요 > ");
			int menu = sc.nextInt();
			sc.nextLine(); // 개행문자를 날려주기 위한 구문
			
			switch (menu) {
			case 1 :
				selectAll();
				break;
			case 2 :
				insertMember();
				break;
			case 3 :
				searchById();
				break;
			case 4 :
				searchByKeyword();
				break;
			case 5 :
				System.out.println("5번 메뉴 호출");
				break;
			case 0 :
				System.out.println("프로그램을 종료합니다.");
				return;

			default:
				System.out.println("없는 메뉴 번호입니다. 다시 입력하세요!!\n");
				break;
			}
		}
	}

	/**
	 * 현재 DB에 존재하는 전체 회원의 정보를 모두 요청하는 메소드 -> 컨트롤러의 메소드 호출
	 */
	private void selectAll() {
		
		System.out.println("========== 전체 회원 조회 ==========");
		
		// 현재 존재하는 모든 회원의 정보를 요청하는 것이기때문에 따로 전달해줄 매개변수 없음
		// 컨트롤러 호출
		mc.selectAll();
		
	}
	
	/**
	 * 신규 회원 추가 요청(폼)
	 */
	private void insertMember() {
		
		System.out.println("========== 신규 회원 추가 ==========");
		
		System.out.println("아이디 입력 > ");
		String userId = sc.nextLine();
		System.out.println("비밀번호 입력 > ");
		String userPwd = sc.nextLine();
		System.out.println("이름 입력 > ");
		String userName = sc.nextLine();
		System.out.println("성별 입력 ( M , F ) > ");
		String gender = sc.nextLine();
		System.out.println("나이 입력 > ");
		int age = sc.nextInt();
		sc.nextLine();
		System.out.println("이메일 입력 > ");
		String email = sc.nextLine();
		System.out.println("연락처 입력 > ");
		String phone = sc.nextLine();
		System.out.println("주소 입력 (입력하지 않으면 기본값 입력됩니다.)> ");
		String address = sc.nextLine();
		System.out.println("생년월일 입력 (YYYY-MM-DD) > ");
		String birthDay = sc.nextLine();
		System.out.println("짧은 자기 소개 > ");
		String info = sc.nextLine();
		
		// vo객체에서 생년월일은 Date 객체로 받아야한다.
		// String으로 받은 값을 Date 타입으로 변환 => valueOf() 사용
		// 생년월일값을 받을때에는 YYYY-MM-DD 포멧으로 받아줘야한다.
		Date dateOfBirth = Date.valueOf(birthDay);
		
		Member m = new Member(userId, userPwd, userName, gender, age, email, phone, address, info, dateOfBirth);
		
		new MemberController().insertMember(m);
		
	}
	
	private void searchById() {
		System.out.println("\n아이디로 검색하기 > ");
		String search = sc.nextLine();
		
		new MemberController().searchById(search);
	}
	
	private void searchByKeyword() {
		
		System.out.println("키워드 검색(주소) > ");
		
		String keyword = sc.nextLine();
		
		new MemberController().searchByKeyword(keyword);
		
	}
	// ------------------------------------------------------------------------------------------------------------------------
	public void displayList(ArrayList<Member> memberList) {
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}

	public void requestResult(String msg) {
		System.out.println(msg);
		
	}

	public void displayMember(Member m) {
		System.out.println(m);
	}

}
