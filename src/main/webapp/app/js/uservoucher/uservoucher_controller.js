'use strict';

/**
 * Controller for Uservoucher
 **/
uservoucherModule.controller('UservoucherCtrl', ['Uservoucher',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Uservoucher, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of uservouchers
    $scope.uservouchers = [];
	// uservoucher to edit
    $scope.uservoucher = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh uservouchers list
     */
    $scope.refreshUservoucherList = function() {
    	try {
			$scope.uservouchers = [];
        	Uservoucher.getAll().then(
				function(success) {
        	        $scope.uservouchers = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh uservoucher
     */
    $scope.refreshUservoucher = function(uid) {
    	try {
        	$scope.uservoucher = null;
	        Uservoucher.get(uid).then(
				function(success) {
        	        $scope.uservoucher = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the uservouchers list page
     */
    $scope.goToUservoucherList = function() {
        $scope.refreshUservoucherList();
        $location.path('/uservoucher');
    }
    /**
     * Go to the uservoucher edit page
     */
    $scope.goToUservoucher = function(uid) {
        $scope.refreshUservoucher(uid);
        $location.path('/uservoucher/'+uid);
    }

    // Actions

    /**
     * Save uservoucher
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Uservoucher.create;
			} else {
				save = Uservoucher.update;
			}
			save($scope.uservoucher).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.uservoucher = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete uservoucher
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Uservoucher.delete(uid).then(
				function(success) {
                	$scope.goToUservoucherList();
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
        $scope.uservoucher = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshUservoucher($routeParams.uid);
    } else {
        // List page
        $scope.refreshUservoucherList();
    }
    
    
}]);
