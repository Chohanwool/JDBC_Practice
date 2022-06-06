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

	
	public Member searchById(Connection conn, String search) {
		
		// 필요 변수 세팅
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		Member m = null;
		
		String sql = prop.getProperty("selectById");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, search);
			
			rSet = pstmt.executeQuery();
			
		if (rSet.next()) {
			m = new Member(rSet.getInt("USERNO"),
						   rSet.getString("USERID"),
						   rSet.getString("USERPWD"),
						   rSet.getString("USERNAME"),
						   rSet.getString("GENDER"),
						   rSet.getInt("AGE"),
						   rSet.getString("EMAIL"),
						   rSet.getString("PHONE"),
						   rSet.getString("ADDRESS"),
						   rSet.getString("INFO"),
						   rSet.getDate("B_DAY"));
		} else {
			return m;
		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(rSet);
			Template.close(pstmt);
		}
		
		return m;
	}

	public ArrayList<Member> searchByKeyword(Connection conn, String keyword) {
		
		// 필요변수 세팅
		PreparedStatement pstmt = null;
		ResultSet rSet = null;
		ArrayList<Member> matchedMember = new ArrayList<Member>();
		
		String sql = prop.getProperty("searchByKeyword");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ("%" + keyword + "%"));
			
			rSet = pstmt.executeQuery();
			
			while (rSet.next()) {
				matchedMember.add(new Member(rSet.getInt("USERNO"),
											 rSet.getString("USERID"),
											 rSet.getString("USERPWD"),
											 rSet.getString("USERNAME"),
											 rSet.getString("GENDER"),
											 rSet.getInt("AGe"),
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
		
		return matchedMember;
	}

	public int modifyMember(Connection conn, String userId, String userPwd, String email, String phone, String address, String info) {
		
		// 필요변수 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("modifyMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userPwd);
			pstmt.setString(2, email);
			pstmt.setString(3, phone);
			pstmt.setString(4, address);
			pstmt.setString(5, info);
			pstmt.setString(6, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		
		// 필요변수 세팅
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			Template.close(pstmt);
		}
		
		return result;
	}

	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
