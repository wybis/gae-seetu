app.classy.controller({

	name : 'testController',

	inject : [ '$rootScope', '$scope', '$log', 'wydNotifyService' ],

	data : {
		log : '$log'
	},

	init : function() {
		this.$rootScope.viewName = 'Home';

		this.log.info('testController...');
	},

	methods : {
		success : function() {
			this.wydNotifyService.addSuccess("Success message...", false);
		},

		info : function() {
			this.wydNotifyService.addInfo("Info message...", false);
		},

		warning : function() {
			this.wydNotifyService.addWarning("Warning message...", false);
		},

		error : function() {
			this.wydNotifyService.addError("Error message...", false);
		},

		clear : function() {
			this.wydNotifyService.removeAll();
		}
	}

});