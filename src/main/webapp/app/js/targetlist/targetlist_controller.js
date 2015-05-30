'use strict';

/**
 * Controller for Targetlist
 **/
targetlistModule.controller('TargetlistCtrl', ['Targetlist',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Targetlist, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of targetlists
    $scope.targetlists = [];
	// targetlist to edit
    $scope.targetlist = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh targetlists list
     */
    $scope.refreshTargetlistList = function() {
    	try {
			$scope.targetlists = [];
        	Targetlist.getAll().then(
				function(success) {
        	        $scope.targetlists = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh targetlist
     */
    $scope.refreshTargetlist = function(uid) {
    	try {
        	$scope.targetlist = null;
	        Targetlist.get(uid).then(
				function(success) {
        	        $scope.targetlist = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the targetlists list page
     */
    $scope.goToTargetlistList = function() {
        $scope.refreshTargetlistList();
        $location.path('/targetlist');
    }
    /**
     * Go to the targetlist edit page
     */
    $scope.goToTargetlist = function(uid) {
        $scope.refreshTargetlist(uid);
        $location.path('/targetlist/'+uid);
    }

    // Actions

    /**
     * Save targetlist
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Targetlist.create;
			} else {
				save = Targetlist.update;
			}
			save($scope.targetlist).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.targetlist = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete targetlist
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Targetlist.delete(uid).then(
				function(success) {
                	$scope.goToTargetlistList();
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
        $scope.targetlist = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshTargetlist($routeParams.uid);
    } else {
        // List page
        $scope.refreshTargetlistList();
    }
    
    
}]);
