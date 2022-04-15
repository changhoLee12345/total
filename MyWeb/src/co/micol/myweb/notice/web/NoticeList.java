package co.micol.myweb.notice.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myweb.common.MyCommand;
import co.micol.myweb.common.PagingVO;
import co.micol.myweb.notice.service.NoticeService;
import co.micol.myweb.notice.serviceImpl.NoticeServiceImpl;
import co.micol.myweb.notice.vo.NoticeVO;

public class NoticeList implements MyCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 공지사항 목록
		NoticeService noticeService = new NoticeServiceImpl();
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		PagingVO pvo = new PagingVO();
		System.out.println(pvo.getEndPage());
		if(request.getParameter("startPage") != null) {
			pvo.setStartPage(Integer.parseInt(request.getParameter("startPage")));
		} else {
			pvo.setStartPage(1);
		}
		System.out.println(pvo.getStartPage());
		
		list = noticeService.noticeSelectList(pvo);
		pvo.setTotalCount(noticeService.totalCount(pvo));  //총레코드 수
		System.out.println(pvo.getTotalCount());
		request.setAttribute("page", pvo);
		request.setAttribute("notices", list);
		
		return "notice/noticeList.tiles";
	}

}
