app.classy.controller({

	name : 'rootController',

	inject : [ '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.log.info('rootController...');
	}

});

app.config(function($routeProvider, $locationProvider) {
	$routeProvider.when('/', {
		templateUrl : 'modules/home/index-d.html',
		controller : 'indexController'
	});

	$routeProvider.when('/notFound', {
		templateUrl : 'modules/z-semantic/notFound-d.html'
	});

	$routeProvider.when('/index', {
		templateUrl : 'modules/home/index-d.html',
		controller : 'indexController'
	});

	$routeProvider.when('/signin', {
		templateUrl : 'modules/session/login-d.html',
		controller : 'loginController',
		reloadOnSearch : false
	});

	$routeProvider.when('/signout', {
		templateUrl : 'modules/session/logout-d.html',
		controller : 'logoutController',
		reloadOnSearch : false
	});

	$routeProvider.when('/settings', {
		templateUrl : 'modules/session/setting-d.html',
		controller : 'settingController',
		reloadOnSearch : false
	});

	$routeProvider.when('/home', {
		templateUrl : 'modules/home/home-d.html',
		controller : 'homeController',
		reloadOnSearch : false
	});

	$routeProvider.when('/accounts', {
		templateUrl : 'modules/account/d.html',
		controller : 'accountController',
		reloadOnSearch : false
	});

	$routeProvider.when('/users', {
		templateUrl : 'modules/user/d.html',
		controller : 'userController',
		reloadOnSearch : false
	});

	$routeProvider.when('/subscribers', {
		templateUrl : 'modules/subscriber/d.html',
		controller : 'subscriberController',
		reloadOnSearch : false
	});

	$routeProvider.when('/chits', {
		templateUrl : 'modules/chit/d.html',
		controller : 'chitController',
		reloadOnSearch : false
	});

	$routeProvider.otherwise({
		redirectTo : '/notFound'
	});
});

function appInit($log, $rootScope, $location) {
	$log.info('Initialization started...');

	var path = '/index';
	$location.path(path);

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', appInit ]);
