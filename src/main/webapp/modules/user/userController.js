function userController($rootScope, $scope, $log, userService) {
	$rootScope.viewName = 'Users';

	$scope.items = userService.items;

	$scope.refresh = function() {
		userService.all();
	};

	$scope.refresh();

	$log.debug('userController...');
}
appControllers.controller('userController', userController);
