package com.chw.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.chw.model.dao.MemberDao;
import com.chw.model.vo.Member;
import static com.chw.common.Template.*;

public class MemberService {
	
	private Connection conn = getConnection();

	public ArrayList<Member> seletAll() {
		
//		Connection conn = getConnection();
		
		ArrayList<Member> memberList = new MemberDao().selectAll(conn);
		
		close(conn);
		
		return memberList;
		
	}

	public int insertMember(Member m) {
		
		int result = new MemberDao().insertMember(conn, m);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	
	public Member searchById(String search) {
		
		Member m = new MemberDao().searchById(conn, search);
		
		close(conn);
		
		return m;
	}

	public ArrayList<Member> searchByKeyword(String keyword) {
		
		ArrayList<Member> matchedMember = new MemberDao().searchByKeyword(conn, keyword);
		
		close(conn);
		
		return matchedMember;
	}

	public int modifyMember(String userId, String userPwd, String email, String phone, String address, String info) {
		
		int result = new MemberDao().modifyMember(conn, userId, userPwd, email, phone, address, info);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public int deleteMember(String userId) {
		
		int result = new MemberDao().deleteMember(conn, userId);
		
		if (result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		return result;
	}

	

	
	

	

}
