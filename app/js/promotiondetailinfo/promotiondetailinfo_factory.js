'use strict';

/**
 * Factory for Promotiondetailinfo
 */
promotiondetailinfoModule.factory('Promotiondetailinfo', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage promotiondetailinfo
    var entityURL = restURL + '/promotiondetailinfo';
	
	/**
     * Validate promotiondetailinfo
     * @param promotiondetailinfo promotiondetailinfo
     * @throws validation exception
     */
	var validate = function (promotiondetailinfo) {
		var errors = [];
        if( promotiondetailinfo.uid == null || promotiondetailinfo.uid == '' ) {
			errors.push('promotiondetailinfo.id.not.defined');
		}
        if( promotiondetailinfo.dishid == null || promotiondetailinfo.dishid == '' ) {
			errors.push('promotiondetailinfo.id.not.defined');
		}
        if( promotiondetailinfo.specificationid == null || promotiondetailinfo.specificationid == '' ) {
			errors.push('promotiondetailinfo.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all promotiondetailinfos as list items
         * @return all promotiondetailinfos as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/promotiondetailinfo');
    	},

        /**
         * Get all promotiondetailinfos
         * @return all promotiondetailinfos
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get promotiondetailinfo
         * @param uid uid
         * @param dishid dishid
         * @param specificationid specificationid
         * @return promotiondetailinfo
         */
    	get: function(uid, dishid, specificationid) {
    	    var url = entityURL + '/' + uid + '/' + dishid + '/' + specificationid;
        	return $http.get(url);
    	},

        /**
         * Create a new promotiondetailinfo
         * @param promotiondetailinfo promotiondetailinfo
         * @return promotiondetailinfo saved
         */
		create: function(promotiondetailinfo) {
			validate(promotiondetailinfo)
			var url = entityURL;
			return $http.post(url, promotiondetailinfo);
    	},

        /**
         * Update promotiondetailinfo
         * @param promotiondetailinfo promotiondetailinfo
         * @return promotiondetailinfo saved
         */
    	update: function(promotiondetailinfo) {
			validate(promotiondetailinfo)
			var url = entityURL + '/' + promotiondetailinfo.uid + '/' + promotiondetailinfo.dishid + '/' + promotiondetailinfo.specificationid;
			return $http.put(url, promotiondetailinfo);
    	},

		/**
         * Delete promotiondetailinfo
         * @param uid uid
         * @param dishid dishid
         * @param specificationid specificationid
         */
    	delete: function(uid, dishid, specificationid) {
        	var url = entityURL + '/' + uid + '/' + dishid + '/' + specificationid;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

