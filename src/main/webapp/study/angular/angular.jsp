<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko" data-ng-app="employeeApp">	<!-- angular Application 선언 -->
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="UTF-8">
<%@include file="/WEB-INF/view/common.jspf" %>


<script type="text/javascript">	//Model 부분
   var app = angular.module("employeeApp", []);		//모듈 생성
   app.controller("examController", function($scope, $http) {
      $scope.title = "Angular 기본구조 연습";
      $scope.titleClick = function(){
         $scope.title += "+";
      }
//       $scope.name = "홍길동";
   
      $scope.depts = [
         {deptno : 10, dname : '총무부1' , loc : 'seoul1'},
         {deptno : 20, dname : '총무부2' , loc : 'seoul2'},
         {deptno : 30, dname : '총무부3' , loc : 'seoul3'},
         {deptno : 40, dname : '총무부4' , loc : 'seoul4'},
         {deptno : 50, dname : '총무부5' , loc : 'seoul5'}
      ];   
      
      $scope.deleteDept = function(index) {
    	  var id = $scope.depts[index].deptno;
		  alert("id = " + id);		
		
		  $scope.depts.splice(index, 1);		//splice는 데이터 삭제시 사용
	};
	
	$scope.imgs = [
		
	          {alt : '100', src : 'http://www.placehold.it/100x100/ff0000/0000ff?text=cat'},
	          {alt : '200', src : 'http://www.placehold.it/200x200/00ff00/0000ff?text=cat1'},
	          {alt : '300', src : 'http://www.placehold.it/300x300/ff00ff/0000ff?text=dog'},
	          {alt : '400', src : 'http://www.placehold.it/400x400/0000ff/ff00ff?text=dog1'},
	          {alt : '500', src : 'http://www.placehold.it/500x500/ffff00/0000ff?text=zebra'}
	           ];
   });
</script>

<title>angular.jsp</title>
</head>


<body data-ng-controller="examController">	<!-- ng는 지시어 ==> 부가적인 기능을 부여  -->
<h1 data-ng-click="titleClick()">{{title}}</h1>	
<p> 3 + 4 = {{ 3 + 4 }}</p>
<hr>
<!-- ng-model은 model이랑 바인딩 시켜준다 model에 데이터입력-->
<input type="text" data-ng-model="name"/> 

<h3>{{name}}</h3>
<!-- responsive 스크롤만들기 -->
<hr>
<div class="table-responsive">
<!-- condensed 패딩 줄이기 -->
<table class="table table-condensed">
   <thead>
   <tr><th>No</th><th>deptno</th><th>dname</th><th>loc</th><th> </th></tr>
   </thead>
   <tbody>
   <tr data-ng-repeat="dept in depts">
      <td>{{$index}}</td>
      <td>{{dept.deptno}}</td>
      <td>{{dept.dname}}</td>
      <td>{{dept.loc}}</td>
      <td data-ng-click="deleteDept($index)"><a href="#" class="btn btn-primary">삭제</a></td>
   </tr>
   </tbody>
</table>
</div>

<hr>

<div class="table-responsive">
<!-- condensed 패딩 줄이기 -->
<table class="table table-condensed">
   <thead>
   <tr><th>deptno</th><th>dname</th><th>loc</th></tr>
   </thead>
   <tbody>
   <tr>
      <td>{{depts[0].deptno}}</td>
      <td>{{depts[0].dname}}</td>
      <td>{{depts[0].loc}}</td>
   </tr>
   <tr>
      <td>{{depts[1].deptno}}</td>
      <td>{{depts[1].dname}}</td>
      <td>{{depts[1].loc}}</td>
   </tr>
   <tr>
      <td>{{depts[2].deptno}}</td>
      <td>{{depts[2].dname}}</td>
      <td>{{depts[2].loc}}</td>
   </tr>
   </tbody>
</table>
</div>

<ul class="list-group">
	<li class="list-group-item" data-ng-repeat="img in imgs">
		<h3>{{img.src}}</h3>
		<img class="img-circle img-responsive" alt="{{img.alt}}" src="{{img.src}}">
	</li>
</ul>

</body>
</html>