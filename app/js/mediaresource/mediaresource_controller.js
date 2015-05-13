'use strict';

/**
 * Controller for Mediaresource
 **/
mediaresourceModule.controller('MediaresourceCtrl', ['Mediaresource',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Mediaresource, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of mediaresources
    $scope.mediaresources = [];
	// mediaresource to edit
    $scope.mediaresource = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh mediaresources list
     */
    $scope.refreshMediaresourceList = function() {
    	try {
			$scope.mediaresources = [];
        	Mediaresource.getAll().then(
				function(success) {
        	        $scope.mediaresources = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh mediaresource
     */
    $scope.refreshMediaresource = function(uid) {
    	try {
        	$scope.mediaresource = null;
	        Mediaresource.get(uid).then(
				function(success) {
        	        $scope.mediaresource = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the mediaresources list page
     */
    $scope.goToMediaresourceList = function() {
        $scope.refreshMediaresourceList();
        $location.path('/mediaresource');
    }
    /**
     * Go to the mediaresource edit page
     */
    $scope.goToMediaresource = function(uid) {
        $scope.refreshMediaresource(uid);
        $location.path('/mediaresource/'+uid);
    }

    // Actions

    /**
     * Save mediaresource
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Mediaresource.create;
			} else {
				save = Mediaresource.update;
			}
			save($scope.mediaresource).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.mediaresource = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete mediaresource
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Mediaresource.delete(uid).then(
				function(success) {
                	$scope.goToMediaresourceList();
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
        $scope.mediaresource = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshMediaresource($routeParams.uid);
    } else {
        // List page
        $scope.refreshMediaresourceList();
    }
    
    
}]);
