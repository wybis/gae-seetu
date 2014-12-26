function logoutController($rootScope, $scope, $log, sessionService, $location) {
	$rootScope.viewName = 'SignOut';

	sessionService.logout().then(function(response) {
		$rootScope.isLoggedIn = false;
		$rootScope.homeView = '/index';
		$location.path($rootScope.homeView);
	});

	$log.debug('logoutContoller...');
}
appControllers.controller('logoutController', logoutController);