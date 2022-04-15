package co.micol.dbtest.member.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import co.micol.dbtest.common.DAO;
import co.micol.dbtest.member.service.MemberService;
import co.micol.dbtest.member.vo.MemberVO;

public class MemberServiceImpl extends DAO implements MemberService {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> selectMemberList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO selectMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(MemberVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MemberVO loginCheck(MemberVO vo) {
		String sql = "select * from member where memberid=? and memberpassword=?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setMemberName(rs.getString("membername"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}
	
	public boolean idCheck(String id) {
		boolean isId = false;  //초기값을 존재하지 않는것을 기준으로 한다.
		String sql = "select memberid from member where memberid = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(rs.next()) isId = true;  //레코드에 값이 존재하면
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return isId;
	}
	
	private void close() {
		try{
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
