package co.micol.myweb.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myweb.notice.web.NoticeList;
import co.micol.myweg.member.web.MemberLogin;
import co.micol.myweg.member.web.MemberLogout;

//@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, MyCommand> map = new HashMap<String, MyCommand>();

	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		map.put("/main.do", new MainCommand());
		map.put("/memberLogin.do", new MemberLogin());
		map.put("/memberLogout.do", new MemberLogout());
		map.put("/noticeList.do", new NoticeList());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());

		MyCommand myCommand = map.get(path);
		String viewPage = myCommand.execute(request, response);

		if (viewPage != null) {
			// ajax 응답
			if (viewPage.startsWith("ajax:")) {
				response.setContentType("text/plain; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}

			// 뷰페이지 포워드
			if (viewPage.endsWith(".jsp"))
				viewPage = "WEB-INF/jsp/" + viewPage;

			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		}
	}

}
