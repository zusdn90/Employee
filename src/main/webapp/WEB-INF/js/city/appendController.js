/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/append config...")
		
		$routeProvider.when("/append", {				//append로 요청을 하면
			templateUrl: "append.html",				//append.html을 불러와서 ng-view를 호출 
			controller: "appendController"			//appendController를 실행
		});
		
	});


	app.controller('Controller', function($scope, $http, URL) {
		console.log("appendController...");
		console.log("URL.POST_ITEM_APPEND =" + URL.POST_ITEM_APPEND);
		
		$scope.$parent.title = "Append City View";		
	});
