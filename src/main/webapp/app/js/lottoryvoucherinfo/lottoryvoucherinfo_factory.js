'use strict';

/**
 * Factory for Lottoryvoucherinfo
 */
lottoryvoucherinfoModule.factory('Lottoryvoucherinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage lottoryvoucherinfo
    var entityURL = restURL + '/lottoryvoucherinfo';
	
	/**
     * Validate lottoryvoucherinfo
     * @param lottoryvoucherinfo lottoryvoucherinfo
     * @throws validation exception
     */
	var validate = function (lottoryvoucherinfo) {
		var errors = [];
        if( lottoryvoucherinfo.uid == null || lottoryvoucherinfo.uid == '' ) {
			errors.push('lottoryvoucherinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all lottoryvoucherinfos as list items
         * @return all lottoryvoucherinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/lottoryvoucherinfo');
    	},

        /**
         * Get all lottoryvoucherinfos
         * @return all lottoryvoucherinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get lottoryvoucherinfo
         * @param uid uid
         * @return lottoryvoucherinfo
         */
    	get: function(uid) {
    	    var url = entityURL + '/' + uid;
        	return $http.get(url);
    	},

        /**
         * Create a new lottoryvoucherinfo
         * @param lottoryvoucherinfo lottoryvoucherinfo
         * @return lottoryvoucherinfo saved
         */
		create: function(lottoryvoucherinfo) {
			validate(lottoryvoucherinfo)
			var url = entityURL;
			return $http.post(url, lottoryvoucherinfo);
    	},

        /**
         * Update lottoryvoucherinfo
         * @param lottoryvoucherinfo lottoryvoucherinfo
         * @return lottoryvoucherinfo saved
         */
    	update: function(lottoryvoucherinfo) {
			validate(lottoryvoucherinfo)
			var url = entityURL + '/' + lottoryvoucherinfo.uid;
			return $http.put(url, lottoryvoucherinfo);
    	},

		/**
         * Delete lottoryvoucherinfo
         * @param uid uid
         */
    	delete: function(uid) {
        	var url = entityURL + '/' + uid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

