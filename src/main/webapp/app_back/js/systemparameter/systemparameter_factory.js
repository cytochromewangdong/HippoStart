'use strict';

/**
 * Factory for Systemparameter
 */
systemparameterModule.factory('Systemparameter', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage systemparameter
    var entityURL = restURL + '/systemparameter';
	
	/**
     * Validate systemparameter
     * @param systemparameter systemparameter
     * @throws validation exception
     */
	var validate = function (systemparameter) {
		var errors = [];
        if( systemparameter.uid == null || systemparameter.uid == '' ) {
			errors.push('systemparameter.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all systemparameters as list items
         * @return all systemparameters as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/systemparameter');
    	},

        /**
         * Get all systemparameters
         * @return all systemparameters
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get systemparameter
         * @param uid uid
         * @return systemparameter
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new systemparameter
         * @param systemparameter systemparameter
         * @return systemparameter saved
         */
		create: function(systemparameter) {
			validate(systemparameter)
			var url = entityURL;
			return $http.post(url, systemparameter);
    	},

        /**
         * Update systemparameter
         * @param systemparameter systemparameter
         * @return systemparameter saved
         */
    	update: function(systemparameter) {
			validate(systemparameter)
			var url = entityURL + '/' + systemparameter.uid;
			return $http.put(url, systemparameter);
    	},

		/**
         * Delete systemparameter
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

