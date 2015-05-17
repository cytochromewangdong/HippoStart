'use strict';

/**
 * Factory for Cateringcorpinfo
 */
cateringcorpinfoModule.factory('Cateringcorpinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage cateringcorpinfo
    var entityURL = restURL + '/cateringcorpinfo';
	
	/**
     * Validate cateringcorpinfo
     * @param cateringcorpinfo cateringcorpinfo
     * @throws validation exception
     */
	var validate = function (cateringcorpinfo) {
		var errors = [];
        if( cateringcorpinfo.uid == null || cateringcorpinfo.uid == '' ) {
			errors.push('cateringcorpinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all cateringcorpinfos as list items
         * @return all cateringcorpinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/cateringcorpinfo');
    	},

        /**
         * Get all cateringcorpinfos
         * @return all cateringcorpinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get cateringcorpinfo
         * @param uid uid
         * @return cateringcorpinfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new cateringcorpinfo
         * @param cateringcorpinfo cateringcorpinfo
         * @return cateringcorpinfo saved
         */
		create: function(cateringcorpinfo) {
			validate(cateringcorpinfo)
			var url = entityURL;
			return $http.post(url, cateringcorpinfo);
    	},

        /**
         * Update cateringcorpinfo
         * @param cateringcorpinfo cateringcorpinfo
         * @return cateringcorpinfo saved
         */
    	update: function(cateringcorpinfo) {
			validate(cateringcorpinfo)
			var url = entityURL + '/' + cateringcorpinfo.uid;
			return $http.put(url, cateringcorpinfo);
    	},

		/**
         * Delete cateringcorpinfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

