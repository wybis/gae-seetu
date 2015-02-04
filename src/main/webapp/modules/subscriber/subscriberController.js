app.classy.controller({

	name : 'subscriberController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Subscribers';

		this.log.info('subscriberController...');
	}

});