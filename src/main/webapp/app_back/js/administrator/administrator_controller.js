'use strict';

/**
 * Controller for Administrator
 **/
administratorModule.controller('AdministratorCtrl', ['Administrator',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Administrator, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of administrators
    $scope.administrators = [];
	// administrator to edit
    $scope.administrator = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh administrators list
     */
    $scope.refreshAdministratorList = function() {
    	try {
			$scope.administrators = [];
        	Administrator.getAll().then(
				function(success) {
        	        $scope.administrators = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh administrator
     */
    $scope.refreshAdministrator = function(uid) {
    	try {
        	$scope.administrator = null;
	        Administrator.get(uid).then(
				function(success) {
        	        $scope.administrator = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the administrators list page
     */
    $scope.goToAdministratorList = function() {
        $scope.refreshAdministratorList();
        $location.path('/administrator');
    }
    /**
     * Go to the administrator edit page
     */
    $scope.goToAdministrator = function(uid) {
        $scope.refreshAdministrator(uid);
        $location.path('/administrator/'+uid);
    }

    // Actions

    /**
     * Save administrator
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Administrator.create;
			} else {
				save = Administrator.update;
			}
			save($scope.administrator).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.administrator = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete administrator
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Administrator.delete(uid).then(
				function(success) {
                	$scope.goToAdministratorList();
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
        $scope.administrator = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshAdministrator($routeParams.uid);
    } else {
        // List page
        $scope.refreshAdministratorList();
    }
    
    
}]);
