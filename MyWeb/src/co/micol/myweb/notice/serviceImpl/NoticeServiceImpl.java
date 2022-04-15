package co.micol.myweb.notice.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.myweb.common.DataSource;
import co.micol.myweb.common.PagingVO;
import co.micol.myweb.notice.service.NoticeService;
import co.micol.myweb.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<NoticeVO> noticeSelectList(PagingVO pvo) {
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		NoticeVO vo;
		String sql = "select id, title, wdate, hit from "
				+ "(select SEQ, id, title, wdate, hit "
				+ "from (select ROWNUM AS SEQ, id, title, wdate, hit "
				+ "from (select * from notice order by id desc) ) where SEQ >= ?) "
				+ "where ROWNUM <= ?";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, pvo.getStartPage());
			psmt.setInt(2, pvo.getEndPage());
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new NoticeVO();
				vo.setId(rs.getInt("id"));
				vo.setTitle(rs.getString("title"));
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int noticeInsert(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeUpdate(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int noticeDelete(NoticeVO vo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public int totalCount(PagingVO pvo) {
		int count = 0;
		String sql = "select count(*) from notice";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
				count = count/pvo.getEndPage() +1;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return count;
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
