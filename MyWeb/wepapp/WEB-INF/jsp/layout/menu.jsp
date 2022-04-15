<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">Start My WebSite</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <c:choose>
                <c:when test="${empty author }">
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="noticeList.do">공지사항</a></li>
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#">자유게시판</a></li>          
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#">회원가입</a></li>
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="memberLogin.do">로그인</a></li>
                </c:when>
                <c:when test="${author eq 'USER' }">
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="noticeList.do">공지사항</a></li>
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#">자유게시판</a></li>          
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#">나의정보수정</a></li>
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="memberLogout.do">로그아웃</a></li>
                </c:when>
                <c:otherwise>
                	<li class="nav-item"><a class="nav-link js-scroll-trigger" href="noticeList.do">공지사항관리</a></li>
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#">회원관리</a></li>
	                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="memberLogout.do">로그아웃</a></li>  
                </c:otherwise>
            	</c:choose>
            </ul>
        </div>
    </div>
</nav>