'use strict';

/**
 * Factory for Paymentlog
 */
paymentlogModule.factory('Paymentlog', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage paymentlog
    var entityURL = restURL + '/paymentlog';
	
	/**
     * Validate paymentlog
     * @param paymentlog paymentlog
     * @throws validation exception
     */
	var validate = function (paymentlog) {
		var errors = [];
        if( paymentlog.uid == null || paymentlog.uid == '' ) {
			errors.push('paymentlog.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all paymentlogs as list items
         * @return all paymentlogs as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/paymentlog');
    	},

        /**
         * Get all paymentlogs
         * @return all paymentlogs
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get paymentlog
         * @param uid uid
         * @return paymentlog
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new paymentlog
         * @param paymentlog paymentlog
         * @return paymentlog saved
         */
		create: function(paymentlog) {
			validate(paymentlog)
			var url = entityURL;
			return $http.post(url, paymentlog);
    	},

        /**
         * Update paymentlog
         * @param paymentlog paymentlog
         * @return paymentlog saved
         */
    	update: function(paymentlog) {
			validate(paymentlog)
			var url = entityURL + '/' + paymentlog.uid;
			return $http.put(url, paymentlog);
    	},

		/**
         * Delete paymentlog
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

