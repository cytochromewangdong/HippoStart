'use strict';

/**
 * Factory for Storeinfo
 */
storeinfoModule.factory('Storeinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage storeinfo
    var entityURL = restURL + '/storeinfo';
	
	/**
     * Validate storeinfo
     * @param storeinfo storeinfo
     * @throws validation exception
     */
	var validate = function (storeinfo) {
		var errors = [];
        if( storeinfo.uid == null || storeinfo.uid == '' ) {
			errors.push('storeinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all storeinfos as list items
         * @return all storeinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/storeinfo');
    	},

        /**
         * Get all storeinfos
         * @return all storeinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get storeinfo
         * @param uid uid
         * @return storeinfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new storeinfo
         * @param storeinfo storeinfo
         * @return storeinfo saved
         */
		create: function(storeinfo) {
			validate(storeinfo)
			var url = entityURL;
			return $http.post(url, storeinfo);
    	},

        /**
         * Update storeinfo
         * @param storeinfo storeinfo
         * @return storeinfo saved
         */
    	update: function(storeinfo) {
			validate(storeinfo)
			var url = entityURL + '/' + storeinfo.uid;
			return $http.put(url, storeinfo);
    	},

		/**
         * Delete storeinfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

