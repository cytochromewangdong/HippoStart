'use strict';

/**
 * Factory for Comboinfo
 */
comboinfoModule.factory('Comboinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage comboinfo
    var entityURL = restURL + '/comboinfo';
	
	/**
     * Validate comboinfo
     * @param comboinfo comboinfo
     * @throws validation exception
     */
	var validate = function (comboinfo) {
		var errors = [];
        if( comboinfo.uid == null || comboinfo.uid == '' ) {
			errors.push('comboinfo.id.not.defined');
		}
        if( comboinfo.childid == null || comboinfo.childid == '' ) {
			errors.push('comboinfo.id.not.defined');
		}
        if( comboinfo.specificationid == null || comboinfo.specificationid == '' ) {
			errors.push('comboinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all comboinfos as list items
         * @return all comboinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/comboinfo');
    	},

        /**
         * Get all comboinfos
         * @return all comboinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get comboinfo
         * @param uid uid
         * @param childid childid
         * @param specificationid specificationid
         * @return comboinfo
         */
    	get: function(uid, childid, specificationid) {
    	    var url = entityURL + '/' + uid + '/' + childid + '/' + specificationid;
        	return $http.get(url);
    	},

        /**
         * Create a new comboinfo
         * @param comboinfo comboinfo
         * @return comboinfo saved
         */
		create: function(comboinfo) {
			validate(comboinfo)
			var url = entityURL;
			return $http.post(url, comboinfo);
    	},

        /**
         * Update comboinfo
         * @param comboinfo comboinfo
         * @return comboinfo saved
         */
    	update: function(comboinfo) {
			validate(comboinfo)
			var url = entityURL + '/' + comboinfo.uid + '/' + comboinfo.childid + '/' + comboinfo.specificationid;
			return $http.put(url, comboinfo);
    	},

		/**
         * Delete comboinfo
         * @param uid uid
         * @param childid childid
         * @param specificationid specificationid
         */
    	delete: function(uid, childid, specificationid) {
        	var url = entityURL + '/' + uid + '/' + childid + '/' + specificationid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

