appServices.factory('bootstrapNotifyService', function($log, $timeout) {

	var baseAlert = {
		success : false,
		info : false,
		error : false,
		warning : false,
		message : ''
	};

	return {
		alerts : [],

		addSuccess : function(message, clear) {
			// $log.info(message);
			if (clear) {
				this.alerts.length = 0;
			}
			var talert = angular.extend({}, baseAlert, {
				success : true,
				message : message
			});
			this.alerts.push(talert);
			var self = this;
			$timeout(function() {
				self.remove(talert);
			}, 6000);
		},

		addInfo : function(message, clear) {
			// $log.info(message);
			if (clear) {
				this.alerts.length = 0;
			}
			var talert = angular.extend({}, baseAlert, {
				info : true,
				message : message
			});
			this.alerts.push(talert);
			var self = this;
			$timeout(function() {
				self.remove(talert);
			}, 6000);
		},

		addWarning : function(message, clear) {
			// $log.info(message);
			if (clear) {
				this.alerts.length = 0;
			}
			var talert = angular.extend({}, baseAlert, {
				warning : true,
				message : message
			});
			this.alerts.push(talert);
			var self = this;
			$timeout(function() {
				self.remove(talert);
			}, 3000);
		},

		addError : function(message, clear) {
			// $log.info(message);
			if (clear) {
				this.alerts.length = 0;
			}
			var talert = angular.extend({}, baseAlert, {
				error : true,
				message : message
			});
			this.alerts.push(talert);
			var self = this;
			$timeout(function() {
				self.remove(talert);
			}, 9000);
		},

		remove : function(alert) {
			var index = this.alerts.indexOf(alert);
			this.alerts.splice(index, 1);
		},

		removeAll : function() {
			this.alerts.length = 0;
		}
	};
});

function bootstrapNotifyDirective(bootstrapNotifyService) {
	return {

		restrict : 'E',

		replace : true,

		templateUrl : 'modules/zgeneral/bootstrapNotifyDirective.html',

		link : function($scope) {
			$scope.notifyService = bootstrapNotifyService;
		}
	};
}
appDirectives.directive('bootstrapNotifyDirective', [ 'bootstrapNotifyService',
		bootstrapNotifyDirective ]);
