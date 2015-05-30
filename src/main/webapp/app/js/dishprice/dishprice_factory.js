'use strict';

/**
 * Factory for Dishprice
 */
dishpriceModule.factory('Dishprice', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage dishprice
    var entityURL = restURL + '/dishprice';
	
	/**
     * Validate dishprice
     * @param dishprice dishprice
     * @throws validation exception
     */
	var validate = function (dishprice) {
		var errors = [];
        if( dishprice.uid == null || dishprice.uid == '' ) {
			errors.push('dishprice.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all dishprices as list items
         * @return all dishprices as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/dishprice');
    	},

        /**
         * Get all dishprices
         * @return all dishprices
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get dishprice
         * @param uid uid
         * @return dishprice
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new dishprice
         * @param dishprice dishprice
         * @return dishprice saved
         */
		create: function(dishprice) {
			validate(dishprice)
			var url = entityURL;
			return $http.post(url, dishprice);
    	},

        /**
         * Update dishprice
         * @param dishprice dishprice
         * @return dishprice saved
         */
    	update: function(dishprice) {
			validate(dishprice)
			var url = entityURL + '/' + dishprice.uid;
			return $http.put(url, dishprice);
    	},

		/**
         * Delete dishprice
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

