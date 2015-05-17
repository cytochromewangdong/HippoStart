'use strict';

/**
 * Factory for Administrator
 */
administratorModule.factory('Administrator', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage administrator
    var entityURL = restURL + '/administrator';
	
	/**
     * Validate administrator
     * @param administrator administrator
     * @throws validation exception
     */
	var validate = function (administrator) {
		var errors = [];
        if( administrator.uid == null || administrator.uid == '' ) {
			errors.push('administrator.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all administrators as list items
         * @return all administrators as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/administrator');
    	},

        /**
         * Get all administrators
         * @return all administrators
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get administrator
         * @param uid uid
         * @return administrator
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new administrator
         * @param administrator administrator
         * @return administrator saved
         */
		create: function(administrator) {
			validate(administrator)
			var url = entityURL;
			return $http.post(url, administrator);
    	},

        /**
         * Update administrator
         * @param administrator administrator
         * @return administrator saved
         */
    	update: function(administrator) {
			validate(administrator)
			var url = entityURL + '/' + administrator.uid;
			return $http.put(url, administrator);
    	},

		/**
         * Delete administrator
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

