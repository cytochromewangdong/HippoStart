'use strict';

/**
 * Factory for Sequence
 */
sequenceModule.factory('Sequence', ['$http', 'restURL', function($http, restURL) {

	// REST Service URL to manage sequence
    var entityURL = restURL + '/sequence';
	
	/**
     * Validate sequence
     * @param sequence sequence
     * @throws validation exception
     */
	var validate = function (sequence) {
		var errors = [];
        if( sequence.uid == null || sequence.uid == '' ) {
			errors.push('sequence.id.not.defined');
		}
        if( sequence.keyword == null || sequence.keyword == '' ) {
			errors.push('sequence.id.not.defined');
		}
		if(errors.length > 0) {
			throw errors;
		}
    };
	
	return {
        /**
         * Get all sequences as list items
         * @return all sequences as list items
         */
    	getAllAsListItems: function() {
        	return $http.get(restURL + '/items/sequence');
    	},

        /**
         * Get all sequences
         * @return all sequences
         */
    	getAll: function() {
        	return $http.get(entityURL);
    	},

        /**
         * Get sequence
         * @param uid uid
         * @param keyword keyword
         * @return sequence
         */
    	get: function(uid, keyword) {
    	    var url = entityURL + '/' + uid + '/' + keyword;
        	return $http.get(url);
    	},

        /**
         * Create a new sequence
         * @param sequence sequence
         * @return sequence saved
         */
		create: function(sequence) {
			validate(sequence)
			var url = entityURL;
			return $http.post(url, sequence);
    	},

        /**
         * Update sequence
         * @param sequence sequence
         * @return sequence saved
         */
    	update: function(sequence) {
			validate(sequence)
			var url = entityURL + '/' + sequence.uid + '/' + sequence.keyword;
			return $http.put(url, sequence);
    	},

		/**
         * Delete sequence
         * @param uid uid
         * @param keyword keyword
         */
    	delete: function(uid, keyword) {
        	var url = entityURL + '/' + uid + '/' + keyword;
        	return $http.delete(url);
    	}
	};
	return $this;
}]);

