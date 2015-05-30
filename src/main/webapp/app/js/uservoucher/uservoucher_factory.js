'use strict';

/**
 * Factory for Uservoucher
 */
uservoucherModule.factory('Uservoucher', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage uservoucher
    var entityURL = restURL + '/uservoucher';
	
	/**
     * Validate uservoucher
     * @param uservoucher uservoucher
     * @throws validation exception
     */
	var validate = function (uservoucher) {
		var errors = [];
        if( uservoucher.uid == null || uservoucher.uid == '' ) {
			errors.push('uservoucher.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all uservouchers as list items
         * @return all uservouchers as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/uservoucher');
    	},

        /**
         * Get all uservouchers
         * @return all uservouchers
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get uservoucher
         * @param uid uid
         * @return uservoucher
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new uservoucher
         * @param uservoucher uservoucher
         * @return uservoucher saved
         */
		create: function(uservoucher) {
			validate(uservoucher)
			var url = entityURL;
			return $http.post(url, uservoucher);
    	},

        /**
         * Update uservoucher
         * @param uservoucher uservoucher
         * @return uservoucher saved
         */
    	update: function(uservoucher) {
			validate(uservoucher)
			var url = entityURL + '/' + uservoucher.uid;
			return $http.put(url, uservoucher);
    	},

		/**
         * Delete uservoucher
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

