function rootController($scope, $log, $http) {
	$scope.message = ''

	$scope.execute = function(path) {
		$http.get(path).success(function(response) {
			$scope.message = response;
		})
	};

	$log.info('rootController...');
}
appControllers.controller('rootController', rootController);

var dependents = [ 'ngRoute', 'ngSanitize' ];
dependents.push('ngStorage');
dependents.push('app.filters');
dependents.push('app.directives');
dependents.push('app.services');
dependents.push('app.controllers');
var app = angular.module('app', dependents);

app.config(function($httpProvider) {
	$httpProvider.interceptors.push('generalHttpInterceptor');
});

function appInit($log, $window, $sessionStorage) {
	$log.info('Initialization started...');

	_.mixin(_.str.exports());

	$log.info('Initialization finished...');
}
app.run([ '$log', '$window', '$sessionStorage', appInit ]);
