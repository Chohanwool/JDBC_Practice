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
}
