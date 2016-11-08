/**
 * 
 */

(function() {

	var mod = angular.module('bank', []);
	mod.controller('TxrController', function($scope, $http) {
		var api = "api/txr"
		$scope.txrForm = {};
		$scope.doTxr = function() {
			$http.post(api, $scope.txrForm).then(function(status) {
				console.log(status);
			}, function(error) {
				console.log(error);
			});
		}

	});

})();