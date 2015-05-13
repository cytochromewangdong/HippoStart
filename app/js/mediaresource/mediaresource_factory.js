'use strict';

/**
 * Factory for Mediaresource
 */
mediaresourceModule.factory('Mediaresource', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage mediaresource
    var entityURL = restURL + '/mediaresource';
	
	/**
     * Validate mediaresource
     * @param mediaresource mediaresource
     * @throws validation exception
     */
	var validate = function (mediaresource) {
		var errors = [];
        if( mediaresource.uid == null || mediaresource.uid == '' ) {
			errors.push('mediaresource.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all mediaresources as list items
         * @return all mediaresources as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/mediaresource');
    	},

        /**
         * Get all mediaresources
         * @return all mediaresources
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get mediaresource
         * @param uid uid
         * @return mediaresource
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new mediaresource
         * @param mediaresource mediaresource
         * @return mediaresource saved
         */
		create: function(mediaresource) {
			validate(mediaresource)
			var url = entityURL;
			return $http.post(url, mediaresource);
    	},

        /**
         * Update mediaresource
         * @param mediaresource mediaresource
         * @return mediaresource saved
         */
    	update: function(mediaresource) {
			validate(mediaresource)
			var url = entityURL + '/' + mediaresource.uid;
			return $http.put(url, mediaresource);
    	},

		/**
         * Delete mediaresource
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

