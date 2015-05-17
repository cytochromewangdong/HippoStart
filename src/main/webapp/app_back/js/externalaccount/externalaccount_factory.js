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
        if( externalaccount.userid == null || externalaccount.userid == '' ) {
			errors.push('externalaccount.id.not.defined');
		}
        if( externalaccount.usersource == null || externalaccount.usersource == '' ) {
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
         * @param userid userid
         * @param usersource usersource
         * @return externalaccount
         */
    	get: function(userid, usersource) {
    	    var url = entityURL + '/' + userid + '/' + usersource;
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
			var url = entityURL + '/' + externalaccount.userid + '/' + externalaccount.usersource;
			return $http.put(url, externalaccount);
    	},

		/**
         * Delete externalaccount
         * @param userid userid
         * @param usersource usersource
         */
    	delete: function(userid, usersource) {
        	var url = entityURL + '/' + userid + '/' + usersource;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

