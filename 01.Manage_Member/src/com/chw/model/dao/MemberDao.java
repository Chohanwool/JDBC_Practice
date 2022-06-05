package com.chw.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.chw.common.Template;
import com.chw.model.vo.Member;

public class MemberDao {
	
	private Properties prop = new Properties();
	
	public MemberDao() {
		try {
			prop.loadFromXML(new FileInputStream("resources/query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Member> selectAll(Connection conn) {
		
		// 필요 변수 세팅
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<Member> memberList = new ArrayList<Member>();
		
		String sql = prop.getProperty("selectAll");
		try {
			
			pstmt = conn.prepareStatement(sql);
			
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				memberList.add(new Member(rSet.getInt("USERNO"),
										  rSet.getString("USERID"),
										  rSet.getString("USERPWD"),
										  rSet.getString("USERNAME"),
										  rSet.getString("GENDER"),
										  rSet.getInt("AGE"),
										  rSet.getString("EMAIL"),
										  rSet.getString("PHONE"),
										  rSet.getString("ADDRESS"),
										  rSet.getString("INFO"),
										  rSet.getDate("B_DAY")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(rSet);
			Template.close(pstmt);
		}
		return memberList;
	}

	public int insertMember(Connection conn, Member m) {
		
		// 필요 변수 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getInfo());
			pstmt.setDate(10, m.getDateOfBirth());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
		}
		return result;
	}

}
