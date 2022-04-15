<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.actor , .director { 
 	display: inline-block; 
 	width:100px;
}
td, .director { 
	cursor : pointer;
}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
<button type="button" id="btnMovie">박스오피스</button>
<table border="1">
	<thead><tr><td>순위</td><td>영화제목</td></tr></thead>
	<tbody></tbody>
</table>
<div id="info"></div>
<div id="movie"></div>
<script>
	$("#btnMovie").bind("click", function(){
		let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20210426";	
		$.ajax({
			url : url,
			dataType : "json",
			success : function(datas) {
				let list = datas.boxOfficeResult.dailyBoxOfficeList;
				$("tbody").empty();   //$("tbody").html("");
				for(i=0; i<list.length; i++ ) {
					$("<tr>").append(  $("<td>").html(list[i].movieCd)  )
				     		 .append(  $("<td>").html(list[i].movieNm)  )
				     		 .appendTo(  $("tbody")  );
				}
			}	// end of success	
		}); // end of ajax		
	})  // end of bind
	
	//////// 영화코드로 영화상세정보 조회
	$("tbody").on("click", "td:first-child" , function(){
		let mvCd = $(this).html();
		let url = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+mvCd
		$.ajax({
			url : url,
			dataType : "json",
			success : function(datas){
				let directors = datas.movieInfoResult.movieInfo.directors
				let actors = datas.movieInfoResult.movieInfo.actors;
				
				//내용 지우기
				$("#info").empty();
				
				//감독이름
				$("#info").append($("<h3>").html("감독"));
				for(director of directors) {
					$("#info").append($("<span>").addClass("director")
							                     .html(director.peopleNm))
				}
				//출연배우들
				$("#info").append($("<h3>").html("배우"));
				for(actor of actors) {
					$("#info").append($("<span>").addClass("actor")
							                     .html(actor.peopleNm))
				}
			}
		});		
	})
	
	//감독의 작품 조회해서 div#movie 태그에 출력
	$("#info").on("click",".director", function(){
		console.log( $(this).html() );
		
	})
	
</script>
</body>
</html>