'use strict';

/**
 * Controller for Orderdetail
 **/
orderdetailModule.controller('OrderdetailCtrl', ['Orderdetail',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Orderdetail, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of orderdetails
    $scope.orderdetails = [];
	// orderdetail to edit
    $scope.orderdetail = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh orderdetails list
     */
    $scope.refreshOrderdetailList = function() {
    	try {
			$scope.orderdetails = [];
        	Orderdetail.getAll().then(
				function(success) {
        	        $scope.orderdetails = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh orderdetail
     */
    $scope.refreshOrderdetail = function(orderno, uid) {
    	try {
        	$scope.orderdetail = null;
	        Orderdetail.get(orderno, uid).then(
				function(success) {
        	        $scope.orderdetail = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the orderdetails list page
     */
    $scope.goToOrderdetailList = function() {
        $scope.refreshOrderdetailList();
        $location.path('/orderdetail');
    }
    /**
     * Go to the orderdetail edit page
     */
    $scope.goToOrderdetail = function(orderno, uid) {
        $scope.refreshOrderdetail(orderno, uid);
        $location.path('/orderdetail/'+orderno+'/'+uid);
    }

    // Actions

    /**
     * Save orderdetail
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Orderdetail.create;
			} else {
				save = Orderdetail.update;
			}
			save($scope.orderdetail).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.orderdetail = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete orderdetail
     */
    $scope.delete = function(orderno, uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Orderdetail.delete(orderno, uid).then(
				function(success) {
                	$scope.goToOrderdetailList();
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
        $scope.orderdetail = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.orderno != null && $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshOrderdetail($routeParams.orderno, $routeParams.uid);
    } else {
        // List page
        $scope.refreshOrderdetailList();
    }
    
    
}]);
