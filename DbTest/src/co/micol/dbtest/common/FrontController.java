package co.micol.dbtest.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.member.web.IdCheck;
import co.micol.dbtest.member.web.MemberJoin;
import co.micol.dbtest.member.web.MemberJoinForm;
import co.micol.dbtest.member.web.MemberLogin;
import co.micol.dbtest.member.web.MemberLoginForm;
import co.micol.dbtest.member.web.MemberLoginOut;
import co.micol.dbtest.notice.web.Notice;
import co.micol.dbtest.notice.web.NoticeForm;
import co.micol.dbtest.notice.web.NoticeList;
import co.micol.dbtest.notice.web.NoticeWrite;

/**
 * Servlet implementation class FrontController
 */
//@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HashMap<String, DbCommand> map = new HashMap<String, DbCommand>();   
    
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	public void init(ServletConfig config) throws ServletException {
		// TODO 호출명 저장소
		map.put("/main.do", new MainPage());  //시작페이지
		map.put("/noticeList.do", new NoticeList());  //공지사항 목록
		map.put("/notice.do",new Notice());  //공지사항 내용보기
		map.put("/noticeForm.do", new NoticeForm());   //공지사항 등록 폼 호출
		map.put("/noticeWrite.do", new NoticeWrite());  //공지사항 저장
		map.put("/memberLoginForm.do", new MemberLoginForm());  //로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin());  //로그인 처리
		map.put("/memberLoginOut.do", new MemberLoginOut());  //로그아웃 처리
//		map.put("/idCheck.do",new IdCheck());  //아이디 중복 체크
		map.put("/memberJoinForm.do", new MemberJoinForm());  //회원가입 폼 호출
		map.put("/memberJoin.do", new MemberJoin());    //회원가입 처리
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 실제처리할 command를 호출하고, 결과를 돌려줄 페이지를 작성하는 곳
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		DbCommand dbCommand = map.get(path);
		String viewPage = dbCommand.execute(request, response);
		
		if(viewPage.endsWith(".jsp"))
			viewPage = "WEB-INF/jsp/" + viewPage;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

}
