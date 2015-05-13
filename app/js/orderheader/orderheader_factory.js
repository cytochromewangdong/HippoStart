'use strict';

/**
 * Factory for Orderheader
 */
orderheaderModule.factory('Orderheader', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage orderheader
    var entityURL = restURL + '/orderheader';
	
	/**
     * Validate orderheader
     * @param orderheader orderheader
     * @throws validation exception
     */
	var validate = function (orderheader) {
		var errors = [];
        if( orderheader.uid == null || orderheader.uid == '' ) {
			errors.push('orderheader.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all orderheaders as list items
         * @return all orderheaders as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/orderheader');
    	},

        /**
         * Get all orderheaders
         * @return all orderheaders
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get orderheader
         * @param uid uid
         * @return orderheader
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new orderheader
         * @param orderheader orderheader
         * @return orderheader saved
         */
		create: function(orderheader) {
			validate(orderheader)
			var url = entityURL;
			return $http.post(url, orderheader);
    	},

        /**
         * Update orderheader
         * @param orderheader orderheader
         * @return orderheader saved
         */
    	update: function(orderheader) {
			validate(orderheader)
			var url = entityURL + '/' + orderheader.uid;
			return $http.put(url, orderheader);
    	},

		/**
         * Delete orderheader
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

