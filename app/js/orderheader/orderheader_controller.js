'use strict';

/**
 * Controller for Orderheader
 **/
orderheaderModule.controller('OrderheaderCtrl', ['Orderheader',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Orderheader, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of orderheaders
    $scope.orderheaders = [];
	// orderheader to edit
    $scope.orderheader = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh orderheaders list
     */
    $scope.refreshOrderheaderList = function() {
    	try {
			$scope.orderheaders = [];
        	Orderheader.getAll().then(
				function(success) {
        	        $scope.orderheaders = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh orderheader
     */
    $scope.refreshOrderheader = function(uid) {
    	try {
        	$scope.orderheader = null;
	        Orderheader.get(uid).then(
				function(success) {
        	        $scope.orderheader = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the orderheaders list page
     */
    $scope.goToOrderheaderList = function() {
        $scope.refreshOrderheaderList();
        $location.path('/orderheader');
    }
    /**
     * Go to the orderheader edit page
     */
    $scope.goToOrderheader = function(uid) {
        $scope.refreshOrderheader(uid);
        $location.path('/orderheader/'+uid);
    }

    // Actions

    /**
     * Save orderheader
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Orderheader.create;
			} else {
				save = Orderheader.update;
			}
			save($scope.orderheader).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.orderheader = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete orderheader
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Orderheader.delete(uid).then(
				function(success) {
                	$scope.goToOrderheaderList();
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
        $scope.orderheader = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshOrderheader($routeParams.uid);
    } else {
        // List page
        $scope.refreshOrderheaderList();
    }
    
    
}]);
