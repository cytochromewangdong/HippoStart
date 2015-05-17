'use strict';

/**
 * Factory for Payment
 */
paymentModule.factory('Payment', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage payment
    var entityURL = restURL + '/payment';
	
	/**
     * Validate payment
     * @param payment payment
     * @throws validation exception
     */
	var validate = function (payment) {
		var errors = [];
        if( payment.uid == null || payment.uid == '' ) {
			errors.push('payment.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all payments as list items
         * @return all payments as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/payment');
    	},

        /**
         * Get all payments
         * @return all payments
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get payment
         * @param uid uid
         * @return payment
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new payment
         * @param payment payment
         * @return payment saved
         */
		create: function(payment) {
			validate(payment)
			var url = entityURL;
			return $http.post(url, payment);
    	},

        /**
         * Update payment
         * @param payment payment
         * @return payment saved
         */
    	update: function(payment) {
			validate(payment)
			var url = entityURL + '/' + payment.uid;
			return $http.put(url, payment);
    	},

		/**
         * Delete payment
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

