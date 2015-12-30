<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">	<!-- responsive를 위해 꼭필요 모바일 환경에서  -->
<meta charset="UTF-8">
<%@ include file="/WEB-INF/view/common.jspf" %>
<title>main.jsp</title>

<!-- URL 결정 Resolve -->
<c:url var="URL_GET_LIST" 					value="/city/"/>
<c:url var="URL_GET_ITEM_BASE" 				value="/city/"/> 		<!-- /city/{id} -->
<c:url var="URL_GET_PAGE_BASE" 				value="/city/page/"/>	<!-- /city/page/{pageNo} -->

<c:url var="URL_POST_LIST_APPEND"			value="/city/"/>
<c:url var="URL_POST_ITEM_APPEND"			value="/city/"/>

<c:url var="URL_PUT_LIST_MODIFY"			value="/city/"/>
<c:url var="URL_PUT_ITEM_MODIFY_BASE"		value="/city/"/>		<!-- /city/{id} -->

<c:url var="URL_DELETE_ITEM_DELETE_BASE"	value="/city/"/>		<!-- /city/{id} -->

<script type="text/javascript">
	
	var urls = {
			GET_LIST : 					"${URL_GET_LIST}",
			GET_PAGE_BASE: 				"${URL_GET_PAGE_BASE}",
			GET_ITEM_BASE:				"${URL_GET_ITEM_BASE}",
			
			POST_LIST_APPEND:			"${URL_POST_LIST_APPEND}",
			POST_ITEM_APPEND:			"${URL_POST_ITEM_APPEND}",
			
			PUT_LIST_MODIFY: 			"${URL_PUT_LIST_MODIFY}",
			PUT_ITEM_MODIFY_BASE: 		"${URL_PUT_ITEM_MODIFY_BASE}",
			
			DELETE_ITEM_DELETE_BASE:	"${URL_DELETE_ITEM_DELETE_BASE}"
	};
	
	
	var deps = ['ngRoute',
	            'ngAnimate',
	            'ngTouch',
	            'angular-loading-bar',
	            'ui.bootstrap'
	           ];
	
	
	var app = angular.module("employeeApp", deps);
	
	app.config(function($routeProvider) {
		$routeProvider.otherwise({
			redirectTo: "/list"
		});
	});
	
	app.constant("URL", urls);		//URL을 상수화 
	
	
	app.controller("mainController", function($scope, $http, $location) {
		console.log("mainController...");
	//	$location.path("/list");
		
		$scope.staticOrFixed = "navbar-static-top";
		
		$scope.setMenuStyle = function(str) {
			$scope.staticOrFixed = str;
		};
		
		var ajax = $http.get("/Employee/user/logincheck");
		ajax.then(function(value) {
			$scope.loginstatus = value.data;
		});
	});
	
</script>
<c:url var="listController" value="/js/city/listController.js"/>
<c:url var="detailController" value="/js/city/detailController.js"/>
<c:url var="appendController" value="/js/city/appendController.js"/>
<c:url var="modifyController" value="/js/city/modifyController.js"/>
<c:url var="deleteController" value="/js/city/deleteController.js"/>

<script type="text/javascript" src="${listController}"></script>
<script type="text/javascript" src="${detailController}"></script>
<script type="text/javascript" src="${appendController}"></script>
<script type="text/javascript" src="${modifyController}"></script>
<script type="text/javascript" src="${deleteController}"></script>

</head>
<body data-ng-controller="mainController" class="container">
<pre>{{loginstatus}}</pre>
<h1>{{title}}</h1>
<div data-ng-view>

</div>
</body>
</html>