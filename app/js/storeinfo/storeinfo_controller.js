'use strict';

/**
 * Controller for Storeinfo
 **/
storeinfoModule.controller('StoreinfoCtrl', ['Storeinfo',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Storeinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of storeinfos
    $scope.storeinfos = [];
	// storeinfo to edit
    $scope.storeinfo = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh storeinfos list
     */
    $scope.refreshStoreinfoList = function() {
    	try {
			$scope.storeinfos = [];
        	Storeinfo.getAll().then(
				function(success) {
        	        $scope.storeinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh storeinfo
     */
    $scope.refreshStoreinfo = function(uid) {
    	try {
        	$scope.storeinfo = null;
	        Storeinfo.get(uid).then(
				function(success) {
        	        $scope.storeinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the storeinfos list page
     */
    $scope.goToStoreinfoList = function() {
        $scope.refreshStoreinfoList();
        $location.path('/storeinfo');
    }
    /**
     * Go to the storeinfo edit page
     */
    $scope.goToStoreinfo = function(uid) {
        $scope.refreshStoreinfo(uid);
        $location.path('/storeinfo/'+uid);
    }

    // Actions

    /**
     * Save storeinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Storeinfo.create;
			} else {
				save = Storeinfo.update;
			}
			save($scope.storeinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.storeinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete storeinfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Storeinfo.delete(uid).then(
				function(success) {
                	$scope.goToStoreinfoList();
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
        $scope.storeinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshStoreinfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshStoreinfoList();
    }
    
    
}]);
