app.classy.controller({

	name : 'logoutController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Signout';

		this.log.info('logoutController...');
	}

});