function sessionService($log, $http, $q) {
	var basePath = 'sessions';

	var service = {
		context : {}
	};

	service.properties = function() {
		var path = basePath + '/properties';

		var deferred = $q.defer();
		$http.get(path).success(function(response) {
			if (response.type === 0) {
				_.assign(service.context, response.data);
				deferred.resolve(response);
			}
			// $log.info(response);
		}).error(function() {
			deferred.reject("unable to authenticate...");
		});

		return deferred.promise;
	};

	service.login = function(user) {
		var path = basePath + '/login';

		var deferred = $q.defer();
		$http.post(path, user).success(function(response) {
			if (response.type >= 0) {
				if (response.type === 0) {
					_.assign(service.context, response.data);
				}
				deferred.resolve(response);
			}
			// $log.info(response);
		}).error(function() {
			deferred.reject("unable to authenticate...");
		});

		return deferred.promise;
	};

	service.logout = function() {
		var path = basePath + '/logout';

		var deferred = $q.defer();
		$http.get(path).success(function(response) {
			if (response.type === 0) {
				_.assign(service.context, response.data);
				deferred.resolve(response);
			}
			// $log.info(response);
		}).error(function() {
			deferred.reject("unable to logout...");
		});

		return deferred.promise;
	};
	return service;
}
appServices.factory('sessionService', sessionService);