'use strict';

/**
 * Factory for Vouchergeneratorinfo
 */
vouchergeneratorinfoModule.factory('Vouchergeneratorinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage vouchergeneratorinfo
    var entityURL = restURL + '/vouchergeneratorinfo';
	
	/**
     * Validate vouchergeneratorinfo
     * @param vouchergeneratorinfo vouchergeneratorinfo
     * @throws validation exception
     */
	var validate = function (vouchergeneratorinfo) {
		var errors = [];
        if( vouchergeneratorinfo.uid == null || vouchergeneratorinfo.uid == '' ) {
			errors.push('vouchergeneratorinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all vouchergeneratorinfos as list items
         * @return all vouchergeneratorinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/vouchergeneratorinfo');
    	},

        /**
         * Get all vouchergeneratorinfos
         * @return all vouchergeneratorinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get vouchergeneratorinfo
         * @param uid uid
         * @return vouchergeneratorinfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new vouchergeneratorinfo
         * @param vouchergeneratorinfo vouchergeneratorinfo
         * @return vouchergeneratorinfo saved
         */
		create: function(vouchergeneratorinfo) {
			validate(vouchergeneratorinfo)
			var url = entityURL;
			return $http.post(url, vouchergeneratorinfo);
    	},

        /**
         * Update vouchergeneratorinfo
         * @param vouchergeneratorinfo vouchergeneratorinfo
         * @return vouchergeneratorinfo saved
         */
    	update: function(vouchergeneratorinfo) {
			validate(vouchergeneratorinfo)
			var url = entityURL + '/' + vouchergeneratorinfo.uid;
			return $http.put(url, vouchergeneratorinfo);
    	},

		/**
         * Delete vouchergeneratorinfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

