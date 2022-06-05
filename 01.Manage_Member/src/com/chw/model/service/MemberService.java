package com.chw.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.chw.model.dao.MemberDao;
import com.chw.model.vo.Member;
import static com.chw.common.Template.*;

public class MemberService {

	public ArrayList<Member> seletAll() {
		
		Connection conn = getConnection();
		
		ArrayList<Member> memberList = new MemberDao().selectAll(conn);
		
		close(conn);
		
		return memberList;
		
	}

}
