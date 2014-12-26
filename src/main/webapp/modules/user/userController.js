function userController($rootScope, $scope, $log) {
	$rootScope.viewName = 'Users';

	$log.debug('userController...');
}
appControllers.controller('userController', userController);
