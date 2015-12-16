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


	app.controller('appendController', function($scope, $http, $location, URL) {
		console.log("appendController...");
		console.log("URL.POST_ITEM_APPEND =" + URL.POST_ITEM_APPEND);
		
		$scope.$parent.title = "Append City View";		
		$scope.city={};
		
		$scope.submit = function()
		{
			var ajax = $http.post(URL.POST_ITEM_APPEND,{
				name : $scope.city.name,
				district : $scope.city.district,
				countryCode : $scope.city.countryCode,
				population : $scope.city.population
			});
			
			ajax.then(function(value) {				//성공시
				$location.path("/list");
			}, function(reason) {					//에러시
				$scope.city = reason.data;	
			});
		};
	});
