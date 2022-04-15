package co.micol.myweb.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.myweb.common.DataSource;
import co.micol.myweb.member.service.MemberService;
import co.micol.myweb.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> memberSelectList() {
		List<MemberVO> list = new ArrayList<MemberVO>();
		MemberVO vo;
		String sql = "select * from member";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("memberid"));
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setAuthor(rs.getString("author"));
				vo.seteDate(rs.getDate("edate"));
				vo.setcDate(rs.getDate("cdate"));
				vo.setdDate(rs.getDate("ddate"));
				list.add(vo);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return list;
	}

	@Override
	public MemberVO memberSelect(MemberVO vo) {
		String sql = "select * from member where memberid = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setMemberPassword(rs.getString("memberpassword"));
				vo.setMemberAddress(rs.getString("memberaddress"));
				vo.setAuthor(rs.getString("author"));
				vo.seteDate(rs.getDate("edate"));
				vo.setcDate(rs.getDate("cdate"));
				vo.setdDate(rs.getDate("ddate"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean idCheck(String id) {
		boolean b = false;
		String sql = "select count(memberid) from member where memberid = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) b = true;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return b;
	}
	
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "select * from member where memberid = ? and memberpassword = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("membername"));
				vo.setAuthor(rs.getString("author"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return vo;
	}

	private void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
