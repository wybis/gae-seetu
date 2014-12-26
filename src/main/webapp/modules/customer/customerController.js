function customerController($rootScope, $scope, $log) {
	$rootScope.viewName = 'Subscribers';

	$log.debug('customerController...');
}
appControllers.controller('customerController', customerController);
