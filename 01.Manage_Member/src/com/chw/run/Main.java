package com.chw.run;

import com.chw.view.MemberView;

public class Main {

	public static void main(String[] args) {
		
		// view의 메인 메뉴를 호출
		new MemberView().mainMenu();
		// 한번만 호출하면 역할을 다하기 때문에 따로 객체 생성 안함
	}

}
