/**
 * @author java
 */
app.config(function($routeProvider) {
		console.log("/delete config...")
		
		$routeProvider.when("/delete/:id", {				//delete로 요청을 하면
			templateUrl: "delete.html",				//delete.html을 불러와서 ng-view를 호출 
			controller: "deleteController"			//deleteController를 실행
		});
		
	});


	app.controller('deleteController', function($scope, $http, URL, $routeParams, $location) {
		console.log("deleteController...");
		console.log("URL.DELETE_ITEM_DELETE_BASE =" + URL.DELETE_ITEM_DELETE_BASE);
		console.log("id = " + $routeParams.id);
		$scope.$parent.title = "Delete City View";		
		
		var ajax = $http.get(URL.GET_ITEM_BASE+ $routeParams.id);
		
		$scope.submit = function(){
			var ajax = $http.remove(URL.DELETE_ITEM_DELETE_BASE + $scope.city.id,{	//var ajax는 local변수
				id : 		 $scope.city.id,
				name : 		 $scope.city.name,
				countryCode: $scope.city.countryCode,
				district : 	 $scope.city.district,
				population : $scope.city.population
			});
			
	
			
			ajax.then(function(value) {
				console.dir(value);
				$location.path("/list");
			}, function(reason) {
				console.dir(reason);
				alert("error...");
			});
		};
		
	});
