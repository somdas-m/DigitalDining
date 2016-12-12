angular.module("digitalDining",[])
		.controller("insertController",function($scope, $http){
			$scope.insert = function(){
				var payload = {
						"itemNumber"   : $scope.ITEM_NUMBER,
						"itemName"	   : $scope.ITEM_NAME,
						"itemPrice"	   : $scope.ITEM_PRICE,
						"itemCategory" : $scope.ITEM_CATEGORY 
				};
				console.log(payload);
				$http.post("https://digitaldining.herokuapp.com/service/rest/insertNewItem", payload)
					.success(function(response){
						console.log(response);
					})
					.error(function(response){
						console.log("Error : "+response);
					});
			}
			
		})
	   .controller("viewController", function($scope, $http){
		   $http.get("https://digitaldining.herokuapp.com/service/rest/getAll")
		   		.success(function(response){
		   			$scope.allItems = response;
		   			console.log(response);
		   		})
		   		.error(function(response){
		   			console.log("Internal error : "+response);
		   		});
	   });