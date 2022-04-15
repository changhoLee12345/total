<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div align="center"> 
	<div><h3>공지사항 목록</h3></div>
	<div>
		<form id="frm" name="frm" action="" method="post">
			<input type="hidden" id="startPage" name="startPage">
			<input type="hidden" id="recId" name="recId">
		</form>
	</div>
	<div>
		<table border="1">
		<tr>
			<c:forEach var="i" begin="1" end="${page.totalCount}" >
				<td width="20" align="center">${i}</td>				
			</c:forEach>
		</tr>
		</table>
	</div>
</div>