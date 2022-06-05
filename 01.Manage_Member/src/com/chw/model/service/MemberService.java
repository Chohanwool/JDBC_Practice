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

}
