'use strict';

/**
 * Factory for Orderdetail
 */
orderdetailModule.factory('Orderdetail', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage orderdetail
    var entityURL = restURL + '/orderdetail';
	
	/**
     * Validate orderdetail
     * @param orderdetail orderdetail
     * @throws validation exception
     */
	var validate = function (orderdetail) {
		var errors = [];
        if( orderdetail.orderno == null || orderdetail.orderno == '' ) {
			errors.push('orderdetail.id.not.defined');
		}
        if( orderdetail.uid == null || orderdetail.uid == '' ) {
			errors.push('orderdetail.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all orderdetails as list items
         * @return all orderdetails as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/orderdetail');
    	},

        /**
         * Get all orderdetails
         * @return all orderdetails
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get orderdetail
         * @param orderno orderno
         * @param uid uid
         * @return orderdetail
         */
    	get: function(orderno, uid) {
    	    var url = entityURL + '/' + orderno + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new orderdetail
         * @param orderdetail orderdetail
         * @return orderdetail saved
         */
		create: function(orderdetail) {
			validate(orderdetail)
			var url = entityURL;
			return $http.post(url, orderdetail);
    	},

        /**
         * Update orderdetail
         * @param orderdetail orderdetail
         * @return orderdetail saved
         */
    	update: function(orderdetail) {
			validate(orderdetail)
			var url = entityURL + '/' + orderdetail.orderno + '/' + orderdetail.uid;
			return $http.put(url, orderdetail);
    	},

		/**
         * Delete orderdetail
         * @param orderno orderno
         * @param uid uid
         */
    	delete: function(orderno, uid) {
        	var url = entityURL + '/' + orderno + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

