<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<title>append.jsp</title>

</head>
<body class="container">
<a class="btn btn-primary" href="#/list">list...</a>
<div class="row">
	<div class="col-sm-6 col-sm-offset-3">
		<div class="panel panel-default">
			<div class="panel-heading">도시 입력</div>
			<pre>{{city}}</pre>				<!-- model에 있는 데이터를 view에 바인딩 >>단반향 -->
			<div class="panel-body">
			<form name="cityForm" novalidate="novalidate" data-ng-submit="submit()">
				<!-- Name -->
				<div class="form-group">
				<label for="name">Name : </label>
				<input id="name"
					   name="name"
					   type="text" 
					   class="form-control"
					   required="required"
					   data-ng-model="city.name"	
					   data-ng-maxlength="35"		
					   />	<!-- 사용자의 입력이 발생하면 city.name -->
					   <div>cityForm.name.$invalid = {{cityForm.name.$invalid}}</div>
					   <div>cityForm.name.$error.required ={{cityForm.name.$error.required}}</div>
					   <div>cityForm.name.$error.maxlength ={{cityForm.name.$error.maxlength}}</div>
					   <div data-ng-show="cityForm.name.$dirty">
						   <div class="alert alert-warning" data-ng-show="cityForm.name.$error.required">필수 입력 항목입니다.</div>
						   <div class="alert alert-warning" data-ng-show="cityForm.name.$error.maxlength">35자리까지 입력가능합니다.</div>
					   </div>
				</div>
				<!-- CountryCode -->
				<div class="form-group">
				<label for="countryCode">CountryCode : </label>
				<input id="countryCode"
					   name="countryCode"
					   type="text" 
					   class="form-control"
					   required="required"
					   data-ng-model="city.countryCode"
					   data-ng-maxlength="3"
					   />
				   <div>cityForm.countryCode.$invalid = {{cityForm.countryCode.$invalid}}</div>
					   <div>cityForm.countryCode.$error.required ={{cityForm.countryCode.$error.required}}</div>
					   <div>cityForm.countryCode.$error.maxlength ={{cityForm.countryCode.$error.maxlength}}</div>
					   <div>cityForm.countryCode.$error.minlength ={{cityForm.countryCode.$error.minlength}}</div>
					   <div data-ng-show="cityForm.countryCode.$dirty">
						   <div class="alert alert-warning" data-ng-show="cityForm.countryCode.$error.required">필수 입력 항목입니다.</div>
						   <div class="alert alert-warning" data-ng-show="cityForm.countryCode.$error.maxlength || cityForm.countryCode.$error.minlength">3자리만 입력가능합니다.</div>
					   </div>
				</div>
				<!-- District -->
				<div class="form-group">
				<label for="district">District : </label>
				<input id="district"
					   name="district"
					   type="text" 
					   class="form-control"
					   required="required"
					   data-ng-model="city.district"	
					   data-ng-maxlength="20"
					   />
					  	 <!-- 입력값을 서버에 전송하기 위해 data-ng-model을 사용하여 양반향 바인딩-->
				<div>cityForm.district.$invalid = {{cityForm.district.$invalid}}</div>
					   <div>cityForm.district.$error.required ={{cityForm.district.$error.required}}</div>
					   <div>cityForm.district.$error.maxlength ={{cityForm.district.$error.maxlength}}</div>
					   <div data-ng-show="cityForm.districts.$dirty">
						   <div class="alert alert-warning" data-ng-show="cityForm.district.$error.required">필수 입력 항목입니다.</div>
						   <div class="alert alert-warning" data-ng-show="cityForm.district.$error.maxlength">20자리까지 입력가능합니다.</div>
					   </div>	   
				</div>
				<!-- Population -->
				<div class="form-group">
					<label for="population">Population : </label>
					<input id="population"
						   name="population"
						   type="number" 
						   class="form-control"
						   required="required"
						   data-ng-model="city.population"
						   data-ng-min="0"
						   data-ng-max="20000000000"
						   />
					<div>cityForm.population.$invalid = {{cityForm.population.$invalid}}</div>
					   <div>cityForm.population.$error.required ={{cityForm.population.$error.required}}</div>
					   <div>cityForm.population.$error.number ={{cityForm.population.$error.number}}</div>
					   <div>cityForm.population.$error.max ={{cityForm.population.$error.max}}</div>
					   <div>cityForm.population.$error.min ={{cityForm.population.$error.min}}</div>
					   <div data-ng-show="cityForm.population.$dirty">
						   <div class="alert alert-warning" data-ng-show="cityForm.population.$error.required">필수 입력 항목입니다.</div>
						   <div class="alert alert-warning" data-ng-show="cityForm.population.$error.number">숫자만 입력가능합니다.</div>
						   <div class="alert alert-warning" data-ng-show="cityForm.population.$error.max">최대값을 초과하였습니다.</div>
						   <div class="alert alert-warning" data-ng-show="cityForm.population.$error.min">0이상 입력 가능합니다.</div>
					   </div>	   
						   
					</div>
					
				<!-- Submit -->
				<div class="form-group">
				<input type="submit" 
					   value="확인"
					   class="btn btn-primary"
					   data-ng-disabled="cityForm.$invalid"/>
					   <div>cityForm.$invalid = {{cityForm.$invalid}}</div>	
				</div>
			</form>
			</div>
	</div>	
</div>
</div>
</body>
</html>

