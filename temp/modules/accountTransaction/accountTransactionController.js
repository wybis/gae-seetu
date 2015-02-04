function accountTransactionController($rootScope, $scope, $log,
		accountTransactionService) {
	$rootScope.viewName = 'Account Transactions';

	$scope.searchFilters = {
		accountId : ''
	};

	$scope.searchResults = accountTransactionService.searchResults;

	accountTransactionService.all();

	$log.debug('accountTransactionController...');
}
appControllers.controller('accountTransactionController',
		accountTransactionController);
