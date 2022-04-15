package co.micol.dbtest.notice.serviceImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.dbtest.common.DAO;
import co.micol.dbtest.notice.service.NoticeService;
import co.micol.dbtest.notice.vo.NoticeVO;

public class NoticeServiceImpl extends DAO implements NoticeService {
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<NoticeVO> noticeSelectList() {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "select * from notice";
		try {
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
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
	public NoticeVO noticeSelect(NoticeVO vo) {
		String sql = "select * from notice where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, vo.getId());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWdate(rs.getDate("wdate"));
				vo.setHit(rs.getInt("hit"));
				hitCount(vo.getId()); //조회수 증가하는 메소드
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return vo;
	}

	@Override
	public int insertNotice(NoticeVO vo) {
		int n = 0;
		String sql = "insert into notice(id, title, content, wdate) values(notice_seq.nextval,?,?,?)";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setDate(3, vo.getWdate());
			n = psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		
		return n;
	}

	@Override
	public int updateNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteNotice(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
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
	
	private void hitCount(int key) {
		String sql = "update notice set hit = hit + 1 where id = ?";
		try {
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, key);
			psmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
