'use strict';

/**
 * Controller for Dishspecificationinfo
 **/
dishspecificationinfoModule.controller('DishspecificationinfoCtrl', ['Dishspecificationinfo',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Dishspecificationinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of dishspecificationinfos
    $scope.dishspecificationinfos = [];
	// dishspecificationinfo to edit
    $scope.dishspecificationinfo = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh dishspecificationinfos list
     */
    $scope.refreshDishspecificationinfoList = function() {
    	try {
			$scope.dishspecificationinfos = [];
        	Dishspecificationinfo.getAll().then(
				function(success) {
        	        $scope.dishspecificationinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh dishspecificationinfo
     */
    $scope.refreshDishspecificationinfo = function(uid) {
    	try {
        	$scope.dishspecificationinfo = null;
	        Dishspecificationinfo.get(uid).then(
				function(success) {
        	        $scope.dishspecificationinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the dishspecificationinfos list page
     */
    $scope.goToDishspecificationinfoList = function() {
        $scope.refreshDishspecificationinfoList();
        $location.path('/dishspecificationinfo');
    }
    /**
     * Go to the dishspecificationinfo edit page
     */
    $scope.goToDishspecificationinfo = function(uid) {
        $scope.refreshDishspecificationinfo(uid);
        $location.path('/dishspecificationinfo/'+uid);
    }

    // Actions

    /**
     * Save dishspecificationinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Dishspecificationinfo.create;
			} else {
				save = Dishspecificationinfo.update;
			}
			save($scope.dishspecificationinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.dishspecificationinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete dishspecificationinfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Dishspecificationinfo.delete(uid).then(
				function(success) {
                	$scope.goToDishspecificationinfoList();
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
        $scope.dishspecificationinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshDishspecificationinfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshDishspecificationinfoList();
    }
    
    
}]);
