'use strict';

/**
 * Factory for Dishspecificationinfo
 */
dishspecificationinfoModule.factory('Dishspecificationinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage dishspecificationinfo
    var entityURL = restURL + '/dishspecificationinfo';
	
	/**
     * Validate dishspecificationinfo
     * @param dishspecificationinfo dishspecificationinfo
     * @throws validation exception
     */
	var validate = function (dishspecificationinfo) {
		var errors = [];
        if( dishspecificationinfo.uid == null || dishspecificationinfo.uid == '' ) {
			errors.push('dishspecificationinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all dishspecificationinfos as list items
         * @return all dishspecificationinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/dishspecificationinfo');
    	},

        /**
         * Get all dishspecificationinfos
         * @return all dishspecificationinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get dishspecificationinfo
         * @param uid uid
         * @return dishspecificationinfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new dishspecificationinfo
         * @param dishspecificationinfo dishspecificationinfo
         * @return dishspecificationinfo saved
         */
		create: function(dishspecificationinfo) {
			validate(dishspecificationinfo)
			var url = entityURL;
			return $http.post(url, dishspecificationinfo);
    	},

        /**
         * Update dishspecificationinfo
         * @param dishspecificationinfo dishspecificationinfo
         * @return dishspecificationinfo saved
         */
    	update: function(dishspecificationinfo) {
			validate(dishspecificationinfo)
			var url = entityURL + '/' + dishspecificationinfo.uid;
			return $http.put(url, dishspecificationinfo);
    	},

		/**
         * Delete dishspecificationinfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

