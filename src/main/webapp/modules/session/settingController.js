app.classy.controller({

	name : 'settingController',

	inject : [ '$rootScope', '$scope', '$log' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Settings';

		this.log.info('settingController...');
	}

});