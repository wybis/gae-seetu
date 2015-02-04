function infoController($rootScope, $scope, $log, $http) {
	$rootScope.viewName = 'Info';

	var basePath = '_admin';

	var contents = {
		info : {},
		health : {},
		metrics : {},
		dump : {},
		trace : {},
		sessions : {}
	};
	$scope.contents = contents;

	$scope.refreshInfo = function() {
		var path = basePath + '/info';
		$http.get(path).success(function(response) {
			// $log.info(response);
			contents.info = response;
		})
	};

	$scope.refreshHealth = function() {
		var path = basePath + '/health';
		$http.get(path).success(function(response) {
			// $log.info(response);
			contents.health = response;
		})
	};

	$scope.refreshMetrics = function() {
		var path = basePath + '/metrics';
		$http.get(path).success(function(response) {
			// $log.info(response);
			contents.metrics = response;
		})
	};

	$scope.refreshDump = function() {
		var path = basePath + '/dump';
		$http.get(path).success(function(response) {
			// $log.info(response);
			contents.dump = response;
		})
	};

	$scope.refreshTrace = function() {
		var path = basePath + '/trace';
		$http.get(path).success(function(response) {
			// $log.info(response);
			contents.trace = response;
		})
	};

	$scope.refreshSessions = function() {
		 var path = basePath + '/sessions';
		$http.get(path).success(function(response) {
			// $log.info(response);
			contents.sessions = response;
		})
	};

	$scope.refreshInfo();
	$scope.refreshHealth();
	$scope.refreshMetrics();
	$scope.refreshDump();
	$scope.refreshTrace();
	$scope.refreshSessions();

	$log.debug('infoController...');
}
appControllers.controller('infoController', infoController);
