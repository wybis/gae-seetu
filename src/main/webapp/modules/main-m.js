'use strict';

function rootController($scope, $log, $window, $rootScope, sessionService) {

	$rootScope.sessionContext = sessionService.context;

	sessionService.properties();

	$scope.viewSource = function() {
		var s = 'view-source:' + $rootScope.currentViewSrcUrl;
		$log.info(s);
		$window.open(s);
	};

	$log.info('root...');
}
appControllers.controller('rootController', rootController);

var dependents = [ 'ngRoute', 'ngSanitize' ];
dependents.push('ngStorage');
// dependents.push('green.inputmask4angular');
// dependents.push('ngInputDate');
dependents.push('mobile-angular-ui')
dependents.push('app.filters');
dependents.push('app.directives');
dependents.push('app.services');
dependents.push('app.controllers');
var app = angular.module('app', dependents);

// app.config(function(uiSelectConfig) {
// uiSelectConfig.theme = 'select2';
// });

app.config(function($httpProvider) {
	$httpProvider.interceptors.push('generalHttpInterceptor');
});

app.config(function($routeProvider, $locationProvider) {

	$routeProvider.when('/', {
		templateUrl : 'modules/home/index-m.html',
		controller : 'indexController',
		reloadOnSearch : false
	});

	$routeProvider.when('/notFound', {
		templateUrl : 'modules/zgeneral/notFound-m.html',
		reloadOnSearch : false
	});

	$routeProvider.when('/index', {
		templateUrl : 'modules/home/index-m.html',
		controller : 'indexController',
		reloadOnSearch : false
	});

	$routeProvider.when('/signin', {
		templateUrl : 'modules/session/login-m.html',
		controller : 'loginController',
		reloadOnSearch : false
	});

	$routeProvider.when('/signout', {
		templateUrl : 'modules/session/logout-m.html',
		controller : 'logoutController',
		reloadOnSearch : false
	});

	$routeProvider.when('/settings', {
		templateUrl : 'modules/session/setting-m.html',
		controller : 'settingController',
		reloadOnSearch : false
	});

	$routeProvider.when('/home', {
		templateUrl : 'modules/home/index-m.html',
		controller : 'indexController',
		reloadOnSearch : false
	});

	$routeProvider.when('/bidding', {
		templateUrl : 'modules/bidding/m.html',
		controller : 'biddingController',
		reloadOnSearch : false
	});

	$routeProvider.when('/items', {
		templateUrl : 'modules/item/m.html',
		controller : 'itemController',
		reloadOnSearch : false
	});

	$routeProvider.when('/itemTransactions', {
		templateUrl : 'modules/itemTransaction/m.html',
		controller : 'itemTransactionController',
		reloadOnSearch : false
	});

	$routeProvider.when('/customers', {
		templateUrl : 'modules/customer/m.html',
		controller : 'customerController',
		reloadOnSearch : false
	});

	$routeProvider.when('/accounts', {
		templateUrl : 'modules/account/m.html',
		controller : 'accountController',
		reloadOnSearch : false
	});

	$routeProvider.when('/accountTransactions', {
		templateUrl : 'modules/accountTransaction/m.html',
		controller : 'accountTransactionController',
		reloadOnSearch : false
	});

	$routeProvider.when('/users', {
		templateUrl : 'modules/user/m.html',
		controller : 'userController',
		reloadOnSearch : false
	});

	$routeProvider.otherwise({
		redirectTo : '/notFound'
	});

	// $locationProvider.html5Mode(true);
});

function appInit($log, $rootScope, $location, $sessionStorage) {
	$log.info('Initialization started...');

	_.mixin(_.str.exports());

	$rootScope.$on("$routeChangeStart", function(event, next, current) {
		$rootScope.loading = true;

		// $log.info('Location : ', $location.path());
		var curLocPath = $location.path();
		$log.info('Before Current Location : ', curLocPath);
		if (curLocPath == '/notFound' || curLocPath == '/signin'
				|| curLocPath == '/signout') {
			return;
		}
		$sessionStorage.seetuCLP = curLocPath;
		// $log.info('Stored Location : ', $sessionStorage.seetuCLP);

		var srcUrl = $location.absUrl().indexOf('index');
		srcUrl = $location.absUrl().substring(0, srcUrl);
		srcUrl = srcUrl + next.templateUrl
		$rootScope.currentViewSrcUrl = srcUrl;
		$log.info('srcUrl = ' + srcUrl);
	});

	$rootScope.$on("$routeChangeSuccess", function(event, next, current) {
		$rootScope.loading = false;

		// $log.info('Location : ', $location.path());
		var curLocPath = $location.path();
		// $log.info('After Current Location : ', curLocPath);
	});

	$rootScope.isLoggedIn = false;
	$rootScope.homeView = '/index';

	var path = $sessionStorage.seetuCLP;
	if (!path) {
		path = '/index';
	}
	$location.path(path);

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', '$sessionStorage', appInit ]);
