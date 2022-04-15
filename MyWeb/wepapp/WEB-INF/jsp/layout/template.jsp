<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>    
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
	<meta name="description" content="" />
	<meta name="author" content="" />
	<title>My Web Site</title>
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="css/styles.css" rel="stylesheet" />
	<!-- Bootstrap core JS-->
    <script src="js/jquery-3.6.0.min.js"></script>
    <script src="bootstrap-4.6.0/js/bootstrap.bundle.min.js"></script>
    <!-- Third party plugin JS-->
    <script src="js/anime.min.js"></script>
    <!-- Core theme JS-->
    <script src="js/scripts.js"></script>
</head>

<body id="page-top">
<div>
<header class="bg-primary text-white">
    <div class="container text-center">
        <h1>Welcome to My Home</h1>
    </div>
</header>
</div>
    <tiles:insertAttribute name="menu" /> 

<div class="container" style="margin-top:30px">

    <tiles:insertAttribute name="body" /> 

</div>

<!-- Footer-->
<div>
	<footer class="py-5 bg-dark">
	    <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2021</p></div>
	</footer>
</div>
</body>
</html>
    