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
		   $scope.getAllItems=function(){
		   $http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
		   $http.get("https://digitaldining.herokuapp.com/service/rest/getAll")
		   		.success(function(response){
		   			$scope.allItems = response;
		   			console.log(response);
		   		})
		   		.error(function(response){
		   			console.log("Internal error : "+response);
		   		});
	   };
	   })
	   .controller("testController",function($scope){
			$scope.abc = function(){
				//console.log($scope.date.getDay());
				var payload = {};
				payload.transactionDate = $scope.date,
				payload.transactionParticulars = $scope.particulars,
				payload.transactionAmount = $scope.amount,
				payload.transactionCategory = $scope.category,
				payload.transactionBorrowed = $scope.isdebit,
				payload.transactionDebitedFrom = $scope.dname,
				payload.transactionDebitSettled = $scope.dsettled,
				payload.transactionCredited = $scope.iscredit,
				payload.transactionCreditedTo = $scope.cname,
				payload.transactionCreditSettled = $scope.csettled,
				payload.transactionTimestamp = new Date();
				console.log(payload);
			}
	   });
