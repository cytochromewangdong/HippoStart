'use strict';

/**
 * Factory for Pointrule
 */
pointruleModule.factory('Pointrule', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage pointrule
    var entityURL = restURL + '/pointrule';
	
	/**
     * Validate pointrule
     * @param pointrule pointrule
     * @throws validation exception
     */
	var validate = function (pointrule) {
		var errors = [];
        if( pointrule.type == null || pointrule.type == '' ) {
			errors.push('pointrule.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all pointrules as list items
         * @return all pointrules as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/pointrule');
    	},

        /**
         * Get all pointrules
         * @return all pointrules
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get pointrule
         * @param type type
         * @return pointrule
         */
    	get: function(type) {
    	    var url = entityURL + '/' + type;
        	return $http.get(url);
    	},

        /**
         * Create a new pointrule
         * @param pointrule pointrule
         * @return pointrule saved
         */
		create: function(pointrule) {
			validate(pointrule)
			var url = entityURL;
			return $http.post(url, pointrule);
    	},

        /**
         * Update pointrule
         * @param pointrule pointrule
         * @return pointrule saved
         */
    	update: function(pointrule) {
			validate(pointrule)
			var url = entityURL + '/' + pointrule.type;
			return $http.put(url, pointrule);
    	},

		/**
         * Delete pointrule
         * @param type type
         */
    	delete: function(type) {
        	var url = entityURL + '/' + type;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

