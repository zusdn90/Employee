/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/modify config...")
		
		$routeProvider.when("/modify", {				//modify로 요청을 하면
			templateUrl: "modify.html",				//modify.html을 불러와서 ng-view를 호출 
			controller: "modifyController"			//modifyController를 실행
		});
		
	});


	app.controller('modifyController', function($scope, $http, URL) {
		console.log("modifyController...");
		console.log("URL.PUT_ITEM_MODIFY_BASE =" + URL.GET_ITEM_MODIFY_BASE);
		
		$scope.$parent.title = "Modify City View";		
	});
