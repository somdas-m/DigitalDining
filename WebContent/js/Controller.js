angular.module("digitalDining",[])
		.controller("insertController",function($scope, $http){
			$scope.insert = function(){
				var payload = {
						"itemNumber"   : $scope.ITEM_ID,
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
			
		});
angular.module("digitalDining",[])
	   .controller("viewController", function($scope, $http){
		   
	   });