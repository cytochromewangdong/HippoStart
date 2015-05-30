'use strict';

/**
 * Factory for Adlist
 */
adlistModule.factory('Adlist', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage adlist
    var entityURL = restURL + '/adlist';
	
	/**
     * Validate adlist
     * @param adlist adlist
     * @throws validation exception
     */
	var validate = function (adlist) {
		var errors = [];
        if( adlist.uid == null || adlist.uid == '' ) {
			errors.push('adlist.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all adlists as list items
         * @return all adlists as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/adlist');
    	},

        /**
         * Get all adlists
         * @return all adlists
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get adlist
         * @param uid uid
         * @return adlist
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new adlist
         * @param adlist adlist
         * @return adlist saved
         */
		create: function(adlist) {
			validate(adlist)
			var url = entityURL;
			return $http.post(url, adlist);
    	},

        /**
         * Update adlist
         * @param adlist adlist
         * @return adlist saved
         */
    	update: function(adlist) {
			validate(adlist)
			var url = entityURL + '/' + adlist.uid;
			return $http.put(url, adlist);
    	},

		/**
         * Delete adlist
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

