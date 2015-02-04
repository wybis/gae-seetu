app.classy.controller({

	name : 'rootController',

	inject : [ '$rootScope', '$scope', '$log', '$window', 'sessionService' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.sessionService.properties();

		this.$rootScope.sessionContext = this.sessionService.context;

		this.log.info('rootController...');
	},

	methods : {
		viewSource : function() {
			var s = 'view-source:' + this.$rootScope.currentViewSrcUrl;
			this.$log.info(s);
			this.$window.open(s);
		}
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

	$routeProvider.when('/test', {
		templateUrl : 'modules/test/d.html',
		controller : 'testController'
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

function appInit($log, $rootScope, $location, $sessionStorage) {
	$log.info('Initialization started...');

	$rootScope.$on("$routeChangeStart", function(event, next, current) {
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
		// $log.info('srcUrl = ' + srcUrl);
	});

	$rootScope.$on("$routeChangeSuccess", function(event, next, current) {
		// $log.info('Location : ', $location.path());
		var curLocPath = $location.path();
		// $log.info('After Current Location : ', curLocPath);
	});

	$rootScope.isLoggedIn = false;
	$rootScope.homeView = '/index';

	var locPath = $sessionStorage.seetuCLP;
	if (!locPath) {
		locPath = '/index';
	}
	$location.path(locPath);

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', '$sessionStorage', appInit ]);
