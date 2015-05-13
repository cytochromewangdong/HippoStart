'use strict';

/**
 * Controller for Systemparameter
 **/
systemparameterModule.controller('SystemparameterCtrl', ['Systemparameter',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Systemparameter, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of systemparameters
    $scope.systemparameters = [];
	// systemparameter to edit
    $scope.systemparameter = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh systemparameters list
     */
    $scope.refreshSystemparameterList = function() {
    	try {
			$scope.systemparameters = [];
        	Systemparameter.getAll().then(
				function(success) {
        	        $scope.systemparameters = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh systemparameter
     */
    $scope.refreshSystemparameter = function(uid) {
    	try {
        	$scope.systemparameter = null;
	        Systemparameter.get(uid).then(
				function(success) {
        	        $scope.systemparameter = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the systemparameters list page
     */
    $scope.goToSystemparameterList = function() {
        $scope.refreshSystemparameterList();
        $location.path('/systemparameter');
    }
    /**
     * Go to the systemparameter edit page
     */
    $scope.goToSystemparameter = function(uid) {
        $scope.refreshSystemparameter(uid);
        $location.path('/systemparameter/'+uid);
    }

    // Actions

    /**
     * Save systemparameter
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Systemparameter.create;
			} else {
				save = Systemparameter.update;
			}
			save($scope.systemparameter).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.systemparameter = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete systemparameter
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Systemparameter.delete(uid).then(
				function(success) {
                	$scope.goToSystemparameterList();
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
        $scope.systemparameter = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshSystemparameter($routeParams.uid);
    } else {
        // List page
        $scope.refreshSystemparameterList();
    }
    
    
}]);
