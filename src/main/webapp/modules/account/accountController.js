function accountController($rootScope, $scope, $log, accountService) {
	$rootScope.viewName = 'Accounts';

	$scope.items = accountService.items

	$scope.refresh = function() {
		accountService.all();
	};

	$scope.refresh();

	$log.debug('accountController...');
}
appControllers.controller('accountController', accountController);
