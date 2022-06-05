package com.chw.view;

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
				System.out.println("2번 메뉴 호출");
				break;
			case 3 :
				System.out.println("3번 메뉴 호출");
				break;
			case 4 :
				System.out.println("4번 메뉴 호출");
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
	
	// ------------------------------------------------------------------------------------------------------------------------
	public void displayList(ArrayList<Member> memberList) {
		
		for(Member m : memberList) {
			System.out.println(m);
		}
	}

	public void RequestResult() {
		System.out.println("전체 회원 정보 조회에 실패 하였습니다.");
		
	}

}
