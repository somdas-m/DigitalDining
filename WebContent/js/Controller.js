angular
		.module("expenseManager", [ "kendo.directives" ])
		.controller(
				"testController",
				function($scope, $http) {
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
									$scope.allResult = response;
									console.log(response);
								}).error(
										function(response) {
											console.log("Internal error : "
													+ response);
										});
					};
					$scope.mainGridOptions = {
						dataSource :{
							transport : {
								read : "https://somexpenses.herokuapp.com/service/rest/getAll"
							},
							pageSize : 5,
							serverPaging : true,
							serverSorting : true
						},
						sortable : true,
						pageable : true,
						columns : [ {
							field : "transactionID",
							title : "ID",
							width : "120px"
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
						},{
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
							title : "From",
							width : "Settled"
						}, {
							field : "transactionTimestamp",
							title : "TImestamp",
							width : "120px"
						} ]
					};
				});
