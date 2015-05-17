'use strict';

/**
 * Factory for Dishinfo
 */
dishinfoModule.factory('Dishinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage dishinfo
    var entityURL = restURL + '/dishinfo';
	
	/**
     * Validate dishinfo
     * @param dishinfo dishinfo
     * @throws validation exception
     */
	var validate = function (dishinfo) {
		var errors = [];
        if( dishinfo.uid == null || dishinfo.uid == '' ) {
			errors.push('dishinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all dishinfos as list items
         * @return all dishinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/dishinfo');
    	},

        /**
         * Get all dishinfos
         * @return all dishinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get dishinfo
         * @param uid uid
         * @return dishinfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new dishinfo
         * @param dishinfo dishinfo
         * @return dishinfo saved
         */
		create: function(dishinfo) {
			validate(dishinfo)
			var url = entityURL;
			return $http.post(url, dishinfo);
    	},

        /**
         * Update dishinfo
         * @param dishinfo dishinfo
         * @return dishinfo saved
         */
    	update: function(dishinfo) {
			validate(dishinfo)
			var url = entityURL + '/' + dishinfo.uid;
			return $http.put(url, dishinfo);
    	},

		/**
         * Delete dishinfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

