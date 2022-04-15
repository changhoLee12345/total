package co.micol.dbtest.member.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.dbtest.member.serviceImpl.MemberServiceImpl;

/**
 * Servlet implementation class MemberIdCheck
 */
@WebServlet("/ajaxMemberIdCheck")
public class AjaxMemberIdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxMemberIdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");  //한글깨짐 방지
		PrintWriter out = response.getWriter(); //결과를 돌려주기 위해
		MemberServiceImpl dao = new MemberServiceImpl();  //모델시작
		String id = request.getParameter("id");
		boolean chk = dao.idCheck(id);
		int cnt = 0;
		if(chk) cnt = 1;                              //모델 끝
		
		out.print(cnt);  //json("{\"cnt\":" + cnt + "}")  //결과 돌려주기
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
