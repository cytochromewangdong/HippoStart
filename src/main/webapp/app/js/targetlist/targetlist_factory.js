'use strict';

/**
 * Factory for Targetlist
 */
targetlistModule.factory('Targetlist', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage targetlist
    var entityURL = restURL + '/targetlist';
	
	/**
     * Validate targetlist
     * @param targetlist targetlist
     * @throws validation exception
     */
	var validate = function (targetlist) {
		var errors = [];
        if( targetlist.uid == null || targetlist.uid == '' ) {
			errors.push('targetlist.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all targetlists as list items
         * @return all targetlists as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/targetlist');
    	},

        /**
         * Get all targetlists
         * @return all targetlists
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get targetlist
         * @param uid uid
         * @return targetlist
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new targetlist
         * @param targetlist targetlist
         * @return targetlist saved
         */
		create: function(targetlist) {
			validate(targetlist)
			var url = entityURL;
			return $http.post(url, targetlist);
    	},

        /**
         * Update targetlist
         * @param targetlist targetlist
         * @return targetlist saved
         */
    	update: function(targetlist) {
			validate(targetlist)
			var url = entityURL + '/' + targetlist.uid;
			return $http.put(url, targetlist);
    	},

		/**
         * Delete targetlist
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

