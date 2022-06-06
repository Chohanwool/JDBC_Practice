package com.chw.controller;

import java.util.ArrayList;

import com.chw.model.service.MemberService;
import com.chw.model.vo.Member;
import com.chw.view.MemberView;

public class MemberController {

	/**
	 * 뷰에서 클라이언트에 의해 요청된 회원 전체 조회 메소드
	 */
	public void selectAll() {
		
		// 최종적으로 반환 받을 값을 생각해보자  전체 회원의 정보를 받을 것이기 때문에
		// ArrayList를 생성해서 받아준다. 
		ArrayList<Member> memberList = new MemberService().seletAll();
		
		if (memberList != null) {
			new MemberView().displayList(memberList);
		} else {
			new MemberView().requestResult("현재 등록된 회원이 없습니다.");
		}
	}

	/**
	 * 뷰에서 클라이언트에 의해 요청된 회원 추가 메소드
	 */
 	public void insertMember(Member m) {
		
		// 결과는 int타입으로 반환된다.
		int result = new MemberService().insertMember(m);
		
		if (result > 0) {
			new MemberView().requestResult("신규 회원 추가 성공!!");
		} else {
			new MemberView().requestResult("신규 회원 추가 실패!!");
		}
		
	}

	
 	public void searchById(String search) {
		
 		// 회원의 id는 유니크한 값이기 때문에 ArrayList로 받을 필요 없다.
 		// Member객체로 받아주자
 		Member m = new MemberService().searchById(search);
 		
 		if (m != null) {
			new MemberView().requestResult("회원 조회 결괴\n");
			new MemberView().displayMember(m);
		} else {
			new MemberView().requestResult("해당 아이디로 검색되는 회원이 존재하지 않습니다.\n");
		}
		
	}

	public void searchByKeyword(String keyword) {
		
		// 결과는 null or 1개 이상의 행
		ArrayList<Member> matchedMember = new MemberService().searchByKeyword(keyword);
		
		if (!matchedMember.isEmpty()) {
			new MemberView().requestResult("조회 성공!!\n");
			new MemberView().displayList(matchedMember);
		} else {
			new MemberView().requestResult("해당 조건을 만족하는 결과가 존재하지 않습니다.");
		}
		
	}
}
