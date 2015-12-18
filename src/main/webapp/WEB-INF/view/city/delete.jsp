<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>    
<!DOCTYPE html>
<html lang="ko">
<head>
<title>delete.jsp</title>

</head>
<body class="container">

<a class="btn btn-primary" href="#/list">list...</a>
<form name="cityForm" novalidate="novalidate" data-ng-submit="submit()">
				<!-- Submit -->
				<div class="form-group">
				<input type="submit" 
					   value="확인"
					   class="btn btn-primary"
					   data-ng-disabled="cityForm.$invalid"/>
					   <div>cityForm.$invalid = {{cityForm.$invalid}}</div>	
				</div>
			</form>
</body>
</html>




