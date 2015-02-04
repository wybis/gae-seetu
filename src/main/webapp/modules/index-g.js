app.classy.controller({

	name : 'rootController',

	inject : [ '$scope', '$log', '$http', '$filter' ],

	data : {
		log : '$log'
	},

	initScope : {
		httpResponse : {},
		masterJsons : [],
		masterJson : {}
	},

	init : function() {
		var path = "/modules/z-console/masters.json";
		var $log = this.$log, masterJsons = this.$scope.masterJsons;
		this.$http.get(path).success(function(response) {
			// $log.info(response);
			_.forEach(response, function(item) {
				masterJsons.push(item);
			})
			// $log.info(masterJsons);
		});

		this.log.info('rootController...');
	},

	methods : {

		onMasterJsonChange : function() {
			var $log = this.$log, $filter = this.$filter;
			var masterJson = this.$scope.masterJson;
			if (masterJson.value) {
				return;
			}
			this.$log.info(masterJson);
			var path = '/modules/z-console/' + masterJson.id;
			this.$http.get(path).success(function(response) {
				$log.info(response);
				masterJson.value = response;
				masterJson.json = $filter('json')(masterJson.value, '    ');
				$log.info(masterJson.json);
			});
		},

		execute : function(path) {
			var log = this.log, httpResponse = this.$scope.httpResponse;
			httpResponse.path = path;
			httpResponse.text = '';
			this.$http.get(path).success(function(response) {
				// log.info(response);
				httpResponse.text = '\n' + response;
			});
		}
	}

});

function appInit($log, $rootScope, $location) {
	$log.info('Initialization started...');

	$log.info('Initialization finished...');
}
app.run([ '$log', '$rootScope', '$location', appInit ]);
