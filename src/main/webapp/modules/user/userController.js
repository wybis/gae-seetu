app.classy.controller({

	name : 'userController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Users';

		this.log.info('userController...');
	}

});