function customerController($rootScope, $scope, $log, customerService) {
	$rootScope.viewName = 'Subscribers';

	$scope.items = customerService.items;

	$scope.refresh = function() {
		customerService.all();
	};

	$scope.refresh();

	$log.debug('customerController...');
}
appControllers.controller('customerController', customerController);
