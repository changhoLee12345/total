<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>jquery.jsp</title>
<style>
	.active { background-color: green;}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<br>
	<button type="button" id="btnAdd">추가</button>
	<table id="tbl">
		<thead>
			<tr>
				<th>번호</th>
				<th>이름</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>1</td>
				<td class="username">홍길동</td>
			</tr>
			<tr>
				<td>2</td>
				<td class="username">김</td>
			</tr>
			<tr>
				<td>3</td>
				<td class="username">박</td>
			</tr>
		</tbody>
	</table>
	<script>
		//js
/* 		btnAdd.addEventListener("click", function(){
			alert("추가")
		}); */
		
		//jquery
		$("#btnAdd").bind("click", function(){
				$("<tr>").append(  $("<td>").html("5")  )
					     .append(  $("<td>").html("홍길동")  )
					     .appendTo(  $("tbody")  );
		})
	</script>
</body>
</html>