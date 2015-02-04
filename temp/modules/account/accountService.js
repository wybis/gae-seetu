function accountService($log, $http, $q) {
	var basePath = 'accounts';

	var service = {
		items : [],
		itemsMap : {}
	};

	function addOrUpdateCache(itemx) {
		var item = service.itemsMap[itemx.id]
		if (item) {
			_.assign(item, itemx);
		} else {
			service.items.push(itemx);
			service.itemsMap[itemx.id] = itemx;
		}
	}

	service.all = function() {
		var path = basePath + '/all';

		var deferred = $q.defer();
		$http.get(path).success(function(response) {
			if (response.type === 0) {
				_.forEach(response.data, function(itemx) {
					addOrUpdateCache(itemx)
				});
				deferred.resolve(response);
			}
			$log.info(response);
		})

		return deferred.promise;
	};

	return service;
}
appServices.factory('accountService', accountService);