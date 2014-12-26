function accountTransactionController($rootScope, $scope, $log,
		accountTransactionService) {
	$rootScope.viewName = 'Account Transactions';

	$scope.searchResults = accountTransactionService.searchResults;

	accountTransactionService.all();

	$log.debug('accountTransactionController...');
}
appControllers.controller('accountTransactionController',
		accountTransactionController);
