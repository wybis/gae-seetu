function initController($rootScope, $scope, $log, bootstrapNotifyService,
		$http, announcementService) {
	var wydNotifyService = bootstrapNotifyService;

	$rootScope.viewName = 'Init';

	$scope.announcements = announcementService;

	$scope.reset = function() {
		var path = '_admin/backupAndRestore/reset';
		$http.get(path).success(function(response) {
			$log.info(response);
			wydNotifyService.addInfo(response.message);
		})
	};

	$scope.riskAnalysis = function() {
		var basePath = 'api/risk-analysis/';
		var path = basePath + 'token';
		$http.get(path).success(function(response1) {
			$log.info(response1);
			path = basePath + response1.id + '/customer-resident-info';
			var content = [ {
				'countryCode' : 'MYR'
			} ];
			$http.post(path, content).success(function(response2) {
				$log.info(response2);
				path = basePath + response1.id + '/result';
				$http.get(path).success(function(response3) {
					$log.info(response3);
				})
			})
		})
	};

	$log.debug('initController...');
}
appControllers.controller('initController', initController);
