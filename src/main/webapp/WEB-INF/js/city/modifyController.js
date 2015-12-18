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


	app.controller('modifyController', function($scope, $http, URL, $routeParams, $location) {
		console.log("modifyController...");
		console.log("URL.PUT_ITEM_MODIFY_BASE =" + URL.PUT_ITEM_MODIFY_BASE);
		console.log("URL.GET_ITEM_BASE =" + URL.GET_ITEM_BASE);
		console.log("id = " + $routeParams.id);
		
		$scope.$parent.title = "Modify City View";	
		
		var ajax = $http.get(URL.GET_ITEM_BASE + $routeParams.id);	//ajax를 이용하여 페이지 호출
																	//URL.GET_ITEM_BASE 요청되면 CityControll에  getCityItem이 수행

		
		ajax.then(function(value) {			//ajax if문 표현 
			console.dir(value);
			$scope.city = value.data;		//model에 binding이 자동으로 된다.	
		}, function(reason) {
			console.dir(reason);
			alert("error...");
		});
		
		$scope.submit = function(){
			var ajax = $http.put(URL.PUT_ITEM_MODIFY_BASE + $scope.city.id,{	//var ajax는 local변수
				
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
