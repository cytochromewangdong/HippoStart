'use strict';

/**
 * Factory for Externalaccount
 */
externalaccountModule.factory('Externalaccount', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage externalaccount
    var entityURL = restURL + '/externalaccount';
	
	/**
     * Validate externalaccount
     * @param externalaccount externalaccount
     * @throws validation exception
     */
	var validate = function (externalaccount) {
		var errors = [];
        if( externalaccount.uid == null || externalaccount.uid == '' ) {
			errors.push('externalaccount.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all externalaccounts as list items
         * @return all externalaccounts as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/externalaccount');
    	},

        /**
         * Get all externalaccounts
         * @return all externalaccounts
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get externalaccount
         * @param uid uid
         * @return externalaccount
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new externalaccount
         * @param externalaccount externalaccount
         * @return externalaccount saved
         */
		create: function(externalaccount) {
			validate(externalaccount)
			var url = entityURL;
			return $http.post(url, externalaccount);
    	},

        /**
         * Update externalaccount
         * @param externalaccount externalaccount
         * @return externalaccount saved
         */
    	update: function(externalaccount) {
			validate(externalaccount)
			var url = entityURL + '/' + externalaccount.uid;
			return $http.put(url, externalaccount);
    	},

		/**
         * Delete externalaccount
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

