<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp"><!-- 1. -->
<head>
<meta name="viewport" content="width=device-width, initail-scale=1.0">
<meta charset="UTF-8">

<%@include file="/WEB-INF/view/common.jspf" %>
<title>bootstrap.jsp</title>
<style type="text/css">
	img{
		width: 100%;
		height: 100px;
	}


</style>
<script type="text/javascript">
	var app = angular.module('employeeApp', []); 				// 3.
	app.controller('examController', function($scope) { 	// 4.
		
	});

</script>
</head>
<body data-ng-controller="examController"><!-- 2. -->

<div class="container"><!-- 반응형을 위해서 Class를 container로지정 -->
	<div class="row">
		<div class="col-sm-6">	<!-- 하나의row에대해서 화면의 반을 차지 -->
			<img alt="xxx" src="http://www.placehold.it/100x100/ff0000/0000ff?text=50%">
		</div>
		<div class="col-sm-6">
			<img alt="xxx" src="http://www.placehold.it/100x100/ff00ff/0000ff?text=50%">
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<img alt="xxx" src="http://www.placehold.it/100x100/00ffff/0000ff?text=100%">
		</div>
		<div class="col-sm-4">
			<img alt="xxx" src="http://www.placehold.it/100x100/000000/ff00ff?text=100%">
		</div>
		<div class="col-sm-4">
			<img alt="xxx" src="http://www.placehold.it/100x100/000000/ff00ff?text=100%">
		</div>
		<div class="col-sm-4">
			<img alt="xxx" src="http://www.placehold.it/100x100/000000/ff00ff?text=100%">
		</div>
		<div class="col-sm-4">
			<img alt="xxx" src="http://www.placehold.it/100x100/000000/ff00ff?text=100%">
		</div>
	</div>
</div>

<div class="container-fluid"><!-- fluid 유동적 -->
	<div class="row">
	<!-- 영역분할은 크기로 하는것이 아니라 비율로 하는 것  -->
		<div class="col-sm-6">	<!-- 하나의row에대해서 화면의 반을 차지 -->
			<img alt="xxx" src="http://www.placehold.it/100x100/ff0000/0000ff?text=50%">
		</div>
		<div class="col-sm-6">
			<img alt="xxx" src="http://www.placehold.it/100x100/ff00ff/0000ff?text=50%">
		</div>
	</div>
	<div class="row">
		<div class="col-sm-12">
			<img alt="xxx" src="http://www.placehold.it/100x100/00ffff/0000ff?text=100%">
		</div>
	</div>

</div>

</body>
</html>