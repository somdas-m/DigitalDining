angular
		.module("expenseManager", [ "kendo.directives" ])
		.controller(
				"testController",
				function($scope, $http) {
					var data;
					/*$scope.productsDataSource = {
						type : "odata",
						serverFiltering : true,
						transport : {
							read : {
								url : "https://demos.telerik.com/kendo-ui/service/Northwind.svc/Products",
							}
						}
					};*/// dropdown
					$scope.insertToDB = function() {
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
						$http
								.post(
										"https://somexpenses.herokuapp.com/service/rest/insertToDB",
										payload).success(function(response) {
									$scope.allItems = response;
									console.log(response);
								}).error(
										function(response) {
											console.log("Internal error : "
													+ response);
										});
					};
					$scope.getAllfromDB = function() {
						$http.defaults.headers.common['Access-Control-Allow-Origin'] = '*';
						$http
								.get(
										"https://somexpenses.herokuapp.com/service/rest/getAll")
								.success(function(response) {
									data = response;
									console.log(response);
									$scope.gridOptions = {
										dataSource : data,
										selectable : "row",
										toolbar : ['create'],
										editable : 'popup',
										columns : [ {
											field : "transactionID",
											title : "ID"
										}, {
											field : "transactionDate",
											title : "Date",
											width : "120px"
										}, {
											field : "transactionParticulars",
											title : "Particulars",
											width : "120px"
										}, {
											field : "transactionAmount",
											title : "Amount",
											width : "120px"
										}, {
											field : "transactionCategory",
											title : "Category",
											width : "120px"
										}, {
											field : "transactionBorrowed",
											title : "Borrowed",
											width : "120px"
										}, {
											field : "transactionDebitedFrom",
											title : "To",
											width : "120px"
										}, {
											field : "transactionDebitSettled",
											title : "Settled",
											width : "120px"
										}, {
											field : "transactionCredited",
											title : "ToGet",
											width : "120px"
										}, {
											field : "transactionCreditedTo",
											title : "From",
											width : "120px"
										}, {
											field : "transactionCreditSettled",
											title : "Settled",
											width : "120px"
										}, {
											field : "transactionTimestamp",
											title : "TImestamp",
											width : "120px"
										} ]
									};
								}).error(
										function(response) {
											console.log("Internal error : "
													+ response);
										});
					};
					/*var data = new kendo.data.DataSource({
					      data: [
					        { text: "Foo", id: 1 },
					        { text: "Bar", id: 2 },
					        { text: "Baz", id: 3 }
					      ]
					    });*/
				});
