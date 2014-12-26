function itemController($rootScope, $scope, $log, itemService) {
	$rootScope.viewName = 'Chits';

	$scope.items = itemService.items

	$scope.refresh = function() {
		itemService.all();
	};

	$scope.refresh();

	$log.debug('itemController...');
}
appControllers.controller('itemController', itemController);
