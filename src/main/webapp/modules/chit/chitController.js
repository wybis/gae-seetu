app.classy.controller({

	name : 'chitController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Chits';

		this.log.info('chitController...');
	}

});