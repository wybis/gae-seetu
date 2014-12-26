function itemTransactionController($rootScope, $scope, $log,
		itemTransactionService) {
	$rootScope.viewName = 'Chit Transactions';

	$scope.items = itemTransactionService.items

	$scope.refresh = function() {
		itemTransactionService.all();
	};

	$scope.refresh();

	$log.debug('itemTransactionController...');
}
appControllers.controller('itemTransactionController',
		itemTransactionController);
