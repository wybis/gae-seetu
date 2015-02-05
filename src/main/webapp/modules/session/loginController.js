app.classy.controller({

	name : 'loginController',

	inject : [ '$rootScope', '$scope', '$log', 'wydNotifyService',
			'sessionService', '$sessionStorage', '$location', '$timeout' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'sign In';

		this.$scope.user = {
			id : '',
			password : '',
			loadingClass : '',
			message : null
		};

		this.log.info('loginController...');
	},

	methods : {
		signin : function() {
			var $log = this.$log, $rootScope = this.$rootScope;
			var wydNotifyService = this.wydNotifyService;
			var $sessionStorage = this.$sessionStorage;
			var $location = this.$location, $timeout = this.$timeout;

			var user = this.$scope.user, userReq = {
				id : user.id,
				password : user.password
			};
			user.loadingClass = 'loading';
			var ss = this.sessionService.login(userReq);
			ss.then(function(response) {
				user.loadingClass = '';
				//$log.info(response);
				if (response.type === 1) {
					user.message = response.message;
					wydNotifyService.addError(user.message, true);
				} else {
					user.password = '';
					$rootScope.isLoggedIn = true;
					$rootScope.homeView = '/home';
					var locPath = $sessionStorage.seetuCLP;
					$log.info('Last Stored Location : ', locPath);
					if (!locPath) {
						locPath = $rootScope.homeView;
					}
					$location.path(locPath);
				}
			})
		}
	}

});