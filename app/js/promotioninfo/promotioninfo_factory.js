'use strict';

/**
 * Factory for Promotioninfo
 */
promotioninfoModule.factory('Promotioninfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage promotioninfo
    var entityURL = restURL + '/promotioninfo';
	
	/**
     * Validate promotioninfo
     * @param promotioninfo promotioninfo
     * @throws validation exception
     */
	var validate = function (promotioninfo) {
		var errors = [];
        if( promotioninfo.uid == null || promotioninfo.uid == '' ) {
			errors.push('promotioninfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all promotioninfos as list items
         * @return all promotioninfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/promotioninfo');
    	},

        /**
         * Get all promotioninfos
         * @return all promotioninfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get promotioninfo
         * @param uid uid
         * @return promotioninfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new promotioninfo
         * @param promotioninfo promotioninfo
         * @return promotioninfo saved
         */
		create: function(promotioninfo) {
			validate(promotioninfo)
			var url = entityURL;
			return $http.post(url, promotioninfo);
    	},

        /**
         * Update promotioninfo
         * @param promotioninfo promotioninfo
         * @return promotioninfo saved
         */
    	update: function(promotioninfo) {
			validate(promotioninfo)
			var url = entityURL + '/' + promotioninfo.uid;
			return $http.put(url, promotioninfo);
    	},

		/**
         * Delete promotioninfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

