'use strict';

/**
 * Controller for Pointrule
 **/
pointruleModule.controller('PointruleCtrl', ['Pointrule',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Pointrule, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of pointrules
    $scope.pointrules = [];
	// pointrule to edit
    $scope.pointrule = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh pointrules list
     */
    $scope.refreshPointruleList = function() {
    	try {
			$scope.pointrules = [];
        	Pointrule.getAll().then(
				function(success) {
        	        $scope.pointrules = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh pointrule
     */
    $scope.refreshPointrule = function(type) {
    	try {
        	$scope.pointrule = null;
	        Pointrule.get(type).then(
				function(success) {
        	        $scope.pointrule = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the pointrules list page
     */
    $scope.goToPointruleList = function() {
        $scope.refreshPointruleList();
        $location.path('/pointrule');
    }
    /**
     * Go to the pointrule edit page
     */
    $scope.goToPointrule = function(type) {
        $scope.refreshPointrule(type);
        $location.path('/pointrule/'+type);
    }

    // Actions

    /**
     * Save pointrule
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Pointrule.create;
			} else {
				save = Pointrule.update;
			}
			save($scope.pointrule).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.pointrule = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete pointrule
     */
    $scope.delete = function(type) {
	    try {
			MessageHandler.cleanMessage();
    	    Pointrule.delete(type).then(
				function(success) {
                	$scope.goToPointruleList();
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
        $scope.pointrule = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.type != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshPointrule($routeParams.type);
    } else {
        // List page
        $scope.refreshPointruleList();
    }
    
    
}]);
