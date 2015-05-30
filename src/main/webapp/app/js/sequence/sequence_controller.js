'use strict';

/**
 * Controller for Sequence
 **/
sequenceModule.controller('SequenceCtrl', ['Sequence',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Sequence, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of sequences
    $scope.sequences = [];
	// sequence to edit
    $scope.sequence = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh sequences list
     */
    $scope.refreshSequenceList = function() {
    	try {
			$scope.sequences = [];
        	Sequence.getAll().then(
				function(success) {
        	        $scope.sequences = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh sequence
     */
    $scope.refreshSequence = function(keyword) {
    	try {
        	$scope.sequence = null;
	        Sequence.get(keyword).then(
				function(success) {
        	        $scope.sequence = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the sequences list page
     */
    $scope.goToSequenceList = function() {
        $scope.refreshSequenceList();
        $location.path('/sequence');
    }
    /**
     * Go to the sequence edit page
     */
    $scope.goToSequence = function(keyword) {
        $scope.refreshSequence(keyword);
        $location.path('/sequence/'+keyword);
    }

    // Actions

    /**
     * Save sequence
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Sequence.create;
			} else {
				save = Sequence.update;
			}
			save($scope.sequence).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.sequence = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete sequence
     */
    $scope.delete = function(keyword) {
	    try {
			MessageHandler.cleanMessage();
    	    Sequence.delete(keyword).then(
				function(success) {
                	$scope.goToSequenceList();
            	}, 
                MessageHandler.manageError);
        } catch(ex) {
            MessageHandler.manageException(ex);
        }
    };
    
    // Main
	MessageHandler.cleanMessage();
    if( $location.path().endsWith('/new') ) {
        // Creation page
        $scope.sequence = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.keyword != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshSequence($routeParams.keyword);
    } else {
        // List page
        $scope.refreshSequenceList();
    }
    
    
}]);
