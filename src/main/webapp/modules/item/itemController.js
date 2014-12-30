function itemController($rootScope, $scope, $log, itemService) {
	$rootScope.viewName = 'Chits';

	$scope.items = itemService.items

	$scope.refresh = function() {
		itemService.all();
	};

	$scope.refresh();

	$scope.bottomReached = function() {
		$log.info('bottom reached...');
	}

	$log.debug('itemController...');
}
appControllers.controller('itemController', itemController);

function itemAddOrEditController($rootScope, $scope, $log, itemService,
		$routeParams, $location) {
	$rootScope.viewName = 'Add/Edit Chit';

	$scope.message = '';

	if ($routeParams.id == 0) {
		itemService.setCurrentItemAsNewItem();
		$scope.item = itemService.currentItem;
	} else {
		itemService.setCurrentItemById($routeParams.id);
		$scope.item = itemService.currentItem;
	}
	$log.info(itemService.currentItem);
	$log.info($scope.item);

	$scope.save = function() {
		$log.info('Successfully saved...');
		itemService.saveCurrentItem();
		$location.path('/items');
	};

	$log.debug('itemAddOrEditController...');
}
appControllers.controller('itemAddOrEditController', itemAddOrEditController);
