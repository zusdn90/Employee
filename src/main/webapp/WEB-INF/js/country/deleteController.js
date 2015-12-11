/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/delete config...")
		
		$routeProvider.when("/delete", {				//delete로 요청을 하면
			templateUrl: "delete.html",				//delete.html을 불러와서 ng-view를 호출 
			controller: "deleteController"			//deleteController를 실행
		});
		
	});


	app.controller('deleteController', function($scope, $http, URL) {
		console.log("deleteController...");
		console.log("URL.DELETE_ITEM_DELETE_BASE =" + URL.DELETE_ITEM_DELETE_BASE);
		
		$scope.$parent.title = "Delete City View";		
	});
