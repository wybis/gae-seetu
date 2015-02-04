app.classy.controller({

	name : 'homeController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Home';

		this.$scope.message = 'Welcome to Seetu!';

		this.log.info('homeController...');
	}

});