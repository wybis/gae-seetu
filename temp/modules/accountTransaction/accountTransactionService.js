function accountTransactionService($log, $http, $q) {
	var basePath = 'accountTransactions';

	var service = {};

	var searchResults = {
		criteria : {},
		id : 0,
		hasMoreItems : false,
		itemsPerPage : 50,
		currentPage : 0,
		currentPageLabel : 0,
		totalPages : 0,
		items : []
	};
	service.searchResults = searchResults;

	service.all = function() {
		var path = basePath + '/all';

		var deferred = $q.defer();
		$http.get(path).success(function(response) {
			if (response.type === 0) {
				searchResults.items = response.data
			}
			$log.info(response);
		})

		return deferred.promise;
	};

	return service;
}
appServices.factory('accountTransactionService', accountTransactionService);