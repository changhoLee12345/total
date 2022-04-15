package co.micol.myweg.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.myweb.common.MyCommand;
import co.micol.myweb.member.serviceImpl.MemberServiceImpl;
import co.micol.myweb.member.vo.MemberVO;

public class MemberLogin implements MyCommand{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Loging
		MemberServiceImpl memberService = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = memberService.memberLogin(vo);
		String viewPage;
		
		if(vo.getAuthor() != null) {
			session.setAttribute("author", vo.getAuthor());
			request.setAttribute("member", vo);
			viewPage = "member/memberSuccess.tiles";
		} else {
			viewPage = "main.do";
		}
		
		return viewPage;
	}

}
