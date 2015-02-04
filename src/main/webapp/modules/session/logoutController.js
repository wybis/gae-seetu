app.classy.controller({

	name : 'logoutController',

	inject : [ '$rootScope', '$scope', '$log', 'sessionService', '$location' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'signout';

		var $rootScope = this.$rootScope, $location = this.$location;

		this.sessionService.logout().then(function(response) {
			$rootScope.isLoggedIn = false;
			$rootScope.homeView = '/index';
			$location.path('/signin');
		});

		this.$log.info('logoutController...');
	}

});