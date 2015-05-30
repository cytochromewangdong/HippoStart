'use strict';

/**
 * Controller for Adlist
 **/
adlistModule.controller('AdlistCtrl', ['Adlist',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Adlist, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of adlists
    $scope.adlists = [];
	// adlist to edit
    $scope.adlist = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh adlists list
     */
    $scope.refreshAdlistList = function() {
    	try {
			$scope.adlists = [];
        	Adlist.getAll().then(
				function(success) {
        	        $scope.adlists = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh adlist
     */
    $scope.refreshAdlist = function(uid) {
    	try {
        	$scope.adlist = null;
	        Adlist.get(uid).then(
				function(success) {
        	        $scope.adlist = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the adlists list page
     */
    $scope.goToAdlistList = function() {
        $scope.refreshAdlistList();
        $location.path('/adlist');
    }
    /**
     * Go to the adlist edit page
     */
    $scope.goToAdlist = function(uid) {
        $scope.refreshAdlist(uid);
        $location.path('/adlist/'+uid);
    }

    // Actions

    /**
     * Save adlist
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Adlist.create;
			} else {
				save = Adlist.update;
			}
			save($scope.adlist).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.adlist = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete adlist
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Adlist.delete(uid).then(
				function(success) {
                	$scope.goToAdlistList();
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
        $scope.adlist = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshAdlist($routeParams.uid);
    } else {
        // List page
        $scope.refreshAdlistList();
    }
    
    
}]);
