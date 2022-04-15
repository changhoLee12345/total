package co.micol.myweg.member.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.myweb.common.MyCommand;

public class MemberLogout implements MyCommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Logout
		HttpSession session = request.getSession();
		session.invalidate();
		return "main.do";
	}

}
