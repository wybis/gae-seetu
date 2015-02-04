app.classy.controller({

	name : 'accountController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Accounts';

		this.log.info('accountController...');
	}

});