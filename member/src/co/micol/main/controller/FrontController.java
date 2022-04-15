package co.micol.main.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.main.common.Command;
import co.micol.main.main.MainCommand;
import co.micol.main.member.web.MemberList;
import co.micol.main.member.web.MemberLogin;
import co.micol.main.member.web.MemberLoginForm;
import co.micol.main.member.web.MemberRegister;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(description = "모든요청을 처리하는 부분", urlPatterns = { "*.do" })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();

    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void init(ServletConfig config) throws ServletException {
		// TODO 요청한 값들(즉 url 패턴을 저장 하는 역활)
		map.put("/main.do", new MainCommand());  //main.jsp 동작
		map.put("/memberList.do", new MemberList());  //회원목록 가져오기
		map.put("/memberRegister.do", new MemberRegister());  //회원등록
		map.put("/memberLoginForm.do", new MemberLoginForm());    //회원로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin());     //로그인 프로세스 처리

	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 요청을 분석해서 결과를 돌려준다.
		request.setCharacterEncoding("utf-8");  //한글 깨짐방지를 위해
		String uri = request.getRequestURI();   //URI를 가져온다
		String contextPath = request.getContextPath();  //컨텍스트 root를 가져온다.
		String path = uri.substring(contextPath.length());  //실제 요청한 값을 찾는다.
		
		Command command = map.get(path);  //요청한 키값으로 실행할 Model을 받아온다.
		String viewPage = command.execute(request, response);  //실행후 보여줄 page를 돌려준다
		
		if(viewPage.endsWith(".jsp")) 
			viewPage = "WEB-INF/views/" + viewPage;  //jsp에 접근할 수 있도록 변환
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
				
	}

}
