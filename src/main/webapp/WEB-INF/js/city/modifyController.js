/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/modify config...")
		
		$routeProvider.when("/modify/:id", {				//modify로 요청을 하면
			templateUrl: "modify.html",				//modify.html을 불러와서 ng-view를 호출 
			controller: "modifyController"			//modifyController를 실행
		});
		
	});


	app.controller('modifyController', function($scope, $http, URL, $routeParams) {
		console.log("modifyController...");
		console.log("URL.PUT_ITEM_MODIFY_BASE =" + URL.PUT_ITEM_MODIFY_BASE);
		console.log("URL.GET_ITEM_BASE =" + URL.GET_ITEM_BASE);
		console.log("id = " + $routeParams.id);
		
		$scope.$parent.title = "Modify City View";	
		
		var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.id);	//ajax를 이용하여 페이지 호출
		
		ajax.then(function(value) {
			console.dir(value);
			$scope.cityForm = value.data;
		}, function(reason) {
			console.dir(reason);
			alert("error...");
		});
		
	});
