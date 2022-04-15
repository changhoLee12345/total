package co.micol.myweb.notice.service;

import java.util.List;

import co.micol.myweb.common.PagingVO;
import co.micol.myweb.notice.vo.NoticeVO;

public interface NoticeService {
	List<NoticeVO> noticeSelectList(PagingVO pvo);
	NoticeVO noticeSelect(NoticeVO vo);
	int noticeInsert(NoticeVO vo);
	int noticeUpdate(NoticeVO vo);
	int noticeDelete(NoticeVO vo);
	int totalCount(PagingVO pvo);
}
