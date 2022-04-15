<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
       #topMenu {
               height: 30px;
               width: 850px;
       }

       #topMenu ul li {
               list-style: none;
               color: white;
               background-color: #2d2d2d;
               float: left;
               line-height: 30px;
               vertical-align: middle;
               text-align: center;
       }

       #topMenu .menuLink {
               text-decoration:none;
               color: white;
               display: block;
               width: 150px;
               font-size: 12px;
               font-weight: bold;
               font-family: "Trebuchet MS";
       }
       #topMenu .menuLink:hover {
               color: red;
               background-color: #4d4d4d;
       }
</style>
</head>
<body>
<div align="center">
	<nav id="topMenu" >
		<ul>
			<li><a class="menuLink" href="noticeList.do">공지사항</a></li>
			<li>|</li>
			<li><a class="menuLink" href="">자유게시판</a></li>
			<li>|</li>
			<li><a class="menuLink" href="">소개하는 글</a></li>
			<li>|</li>
			<c:if test="${id ne null }">
				<li><a class="menuLink" href="memberLoginOut.do">로그아웃</a></li>
				<li>|</li>
				<li><a class="menuLink" href="">나의정보</a></li>
			</c:if>
			<c:if test="${empty id }">
				<li><a class="menuLink" href="memberLoginForm.do">로그인</a></li>			
				<li>|</li>
				<li><a class="menuLink" href="memberJoinForm.do">회원가입</a></li>
			</c:if>
		</ul>
	</nav>
</div>
</body>
</html>