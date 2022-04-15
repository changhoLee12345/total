package co.micol.main.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.main.common.Command;
import co.micol.main.member.serviceImpl.MemberDao;
import co.micol.main.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 처리 과정
		MemberDao dao = new MemberDao();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId"));
		vo.setMemberPassword(request.getParameter("memberPassword"));
		
		vo = dao.memberLoginCheck(vo);
		
		String viewPage;
		request.setAttribute("member", vo);  //권한위임시 나를 실고가라
		
		if(vo.getMemberName() != null) {			
			viewPage = "member/memberLoginSuccess.jsp";
		}else {
			viewPage = "member/memberLoginFail.jsp";
		}
		
		return viewPage;
	}

}
