<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div align="center">
	<div><h3>로 그 인</h3></div>
	<div>
		<form id="frm" name="frm" action="memberLogin.do" method="post">
			<div>
			<table border="1">
				<tr>
					<th width="100" class="text-center">아 이 디</th>
					<td width="200"><input type="text" id="memberId" name="memberId" placeholder="아이디를 입력하세요"></td>
				</tr>
				<tr>
					<th width="10" class="text-center">패스워드</th>
					<td width="200"><input type="password" id="memberPassword" name="memberPassword" placeholder="패스워드를 입력하세요"></td>
				</tr>
			</table>
			</div><br/>
			<div>
				<input type="submit" value="로그인">&nbsp;&nbsp;
				<input type="reset" value="취소">&nbsp;&nbsp;
				<input type="button" value="회원가입" onclick="">
			</div><br/>
		</form>
	</div>
</div>
