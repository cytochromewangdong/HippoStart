'use strict';

/**
 * Factory for Category
 */
categoryModule.factory('Category', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage category
    var entityURL = restURL + '/category';
	
	/**
     * Validate category
     * @param category category
     * @throws validation exception
     */
	var validate = function (category) {
		var errors = [];
        if( category.uid == null || category.uid == '' ) {
			errors.push('category.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all categorys as list items
         * @return all categorys as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/category');
    	},

        /**
         * Get all categorys
         * @return all categorys
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get category
         * @param uid uid
         * @return category
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new category
         * @param category category
         * @return category saved
         */
		create: function(category) {
			validate(category)
			var url = entityURL;
			return $http.post(url, category);
    	},

        /**
         * Update category
         * @param category category
         * @return category saved
         */
    	update: function(category) {
			validate(category)
			var url = entityURL + '/' + category.uid;
			return $http.put(url, category);
    	},

		/**
         * Delete category
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

