'use strict';

/**
 * Factory for Verifyrecord
 */
verifyrecordModule.factory('Verifyrecord', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage verifyrecord
    var entityURL = restURL + '/verifyrecord';
	
	/**
     * Validate verifyrecord
     * @param verifyrecord verifyrecord
     * @throws validation exception
     */
	var validate = function (verifyrecord) {
		var errors = [];
        if( verifyrecord.uid == null || verifyrecord.uid == '' ) {
			errors.push('verifyrecord.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all verifyrecords as list items
         * @return all verifyrecords as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/verifyrecord');
    	},

        /**
         * Get all verifyrecords
         * @return all verifyrecords
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get verifyrecord
         * @param uid uid
         * @return verifyrecord
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new verifyrecord
         * @param verifyrecord verifyrecord
         * @return verifyrecord saved
         */
		create: function(verifyrecord) {
			validate(verifyrecord)
			var url = entityURL;
			return $http.post(url, verifyrecord);
    	},

        /**
         * Update verifyrecord
         * @param verifyrecord verifyrecord
         * @return verifyrecord saved
         */
    	update: function(verifyrecord) {
			validate(verifyrecord)
			var url = entityURL + '/' + verifyrecord.uid;
			return $http.put(url, verifyrecord);
    	},

		/**
         * Delete verifyrecord
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

