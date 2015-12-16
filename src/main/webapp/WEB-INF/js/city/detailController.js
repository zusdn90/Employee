/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/detail config...")
		
		$routeProvider.when("/detail/:id", {				//detail로 요청을 하면
			templateUrl: "detail.html",				//detail.html을 불러와서 ng-view를 호출 
			controller: "detailController"			//detailController를 실행
		});
		
	});


	app.controller('detailController', function($scope, $http, URL, $routeParams) {
		console.log("detailController...");
		console.log("URL.GET_ITEM_BASE =" + URL.GET_ITEM_BASE);
		console.log("id = " + $routeParams);
		
		$scope.$parent.title = "Detail City View";		
	});
