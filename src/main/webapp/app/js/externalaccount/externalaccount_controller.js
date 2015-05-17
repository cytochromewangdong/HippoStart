'use strict';

/**
 * Controller for Externalaccount
 **/
externalaccountModule.controller('ExternalaccountCtrl', ['Externalaccount',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Externalaccount, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of externalaccounts
    $scope.externalaccounts = [];
	// externalaccount to edit
    $scope.externalaccount = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh externalaccounts list
     */
    $scope.refreshExternalaccountList = function() {
    	try {
			$scope.externalaccounts = [];
        	Externalaccount.getAll().then(
				function(success) {
        	        $scope.externalaccounts = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh externalaccount
     */
    $scope.refreshExternalaccount = function(userid, usersource) {
    	try {
        	$scope.externalaccount = null;
	        Externalaccount.get(userid, usersource).then(
				function(success) {
        	        $scope.externalaccount = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the externalaccounts list page
     */
    $scope.goToExternalaccountList = function() {
        $scope.refreshExternalaccountList();
        $location.path('/externalaccount');
    }
    /**
     * Go to the externalaccount edit page
     */
    $scope.goToExternalaccount = function(userid, usersource) {
        $scope.refreshExternalaccount(userid, usersource);
        $location.path('/externalaccount/'+userid+'/'+usersource);
    }

    // Actions

    /**
     * Save externalaccount
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Externalaccount.create;
			} else {
				save = Externalaccount.update;
			}
			save($scope.externalaccount).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.externalaccount = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete externalaccount
     */
    $scope.delete = function(userid, usersource) {
	    try {
			MessageHandler.cleanMessage();
    	    Externalaccount.delete(userid, usersource).then(
				function(success) {
                	$scope.goToExternalaccountList();
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
        $scope.externalaccount = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.userid != null && $routeParams.usersource != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshExternalaccount($routeParams.userid, $routeParams.usersource);
    } else {
        // List page
        $scope.refreshExternalaccountList();
    }
    
    
}]);
