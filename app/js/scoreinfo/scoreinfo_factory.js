'use strict';

/**
 * Factory for Scoreinfo
 */
scoreinfoModule.factory('Scoreinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage scoreinfo
    var entityURL = restURL + '/scoreinfo';
	
	/**
     * Validate scoreinfo
     * @param scoreinfo scoreinfo
     * @throws validation exception
     */
	var validate = function (scoreinfo) {
		var errors = [];
        if( scoreinfo.uid == null || scoreinfo.uid == '' ) {
			errors.push('scoreinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all scoreinfos as list items
         * @return all scoreinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/scoreinfo');
    	},

        /**
         * Get all scoreinfos
         * @return all scoreinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get scoreinfo
         * @param uid uid
         * @return scoreinfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new scoreinfo
         * @param scoreinfo scoreinfo
         * @return scoreinfo saved
         */
		create: function(scoreinfo) {
			validate(scoreinfo)
			var url = entityURL;
			return $http.post(url, scoreinfo);
    	},

        /**
         * Update scoreinfo
         * @param scoreinfo scoreinfo
         * @return scoreinfo saved
         */
    	update: function(scoreinfo) {
			validate(scoreinfo)
			var url = entityURL + '/' + scoreinfo.uid;
			return $http.put(url, scoreinfo);
    	},

		/**
         * Delete scoreinfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

