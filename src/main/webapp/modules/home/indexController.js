function indexController($rootScope, $scope, $log) {
	$rootScope.viewName = 'Home';

	$log.debug('indexController...');
}
appControllers.controller('indexController', indexController);
