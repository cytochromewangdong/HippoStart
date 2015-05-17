'use strict';

/**
 * Controller for Verifyrecord
 **/
verifyrecordModule.controller('VerifyrecordCtrl', ['Verifyrecord',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Verifyrecord, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of verifyrecords
    $scope.verifyrecords = [];
	// verifyrecord to edit
    $scope.verifyrecord = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh verifyrecords list
     */
    $scope.refreshVerifyrecordList = function() {
    	try {
			$scope.verifyrecords = [];
        	Verifyrecord.getAll().then(
				function(success) {
        	        $scope.verifyrecords = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh verifyrecord
     */
    $scope.refreshVerifyrecord = function(uid) {
    	try {
        	$scope.verifyrecord = null;
	        Verifyrecord.get(uid).then(
				function(success) {
        	        $scope.verifyrecord = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the verifyrecords list page
     */
    $scope.goToVerifyrecordList = function() {
        $scope.refreshVerifyrecordList();
        $location.path('/verifyrecord');
    }
    /**
     * Go to the verifyrecord edit page
     */
    $scope.goToVerifyrecord = function(uid) {
        $scope.refreshVerifyrecord(uid);
        $location.path('/verifyrecord/'+uid);
    }

    // Actions

    /**
     * Save verifyrecord
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Verifyrecord.create;
			} else {
				save = Verifyrecord.update;
			}
			save($scope.verifyrecord).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.verifyrecord = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete verifyrecord
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Verifyrecord.delete(uid).then(
				function(success) {
                	$scope.goToVerifyrecordList();
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
        $scope.verifyrecord = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshVerifyrecord($routeParams.uid);
    } else {
        // List page
        $scope.refreshVerifyrecordList();
    }
    
    
}]);
