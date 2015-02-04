app.classy.controller({

	name : 'loginController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Sign In';

		this.log.info('loginController...');
	}

});