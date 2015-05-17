'use strict';

/**
 * Controller for Paymentlog
 **/
paymentlogModule.controller('PaymentlogCtrl', ['Paymentlog',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Paymentlog, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of paymentlogs
    $scope.paymentlogs = [];
	// paymentlog to edit
    $scope.paymentlog = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh paymentlogs list
     */
    $scope.refreshPaymentlogList = function() {
    	try {
			$scope.paymentlogs = [];
        	Paymentlog.getAll().then(
				function(success) {
        	        $scope.paymentlogs = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh paymentlog
     */
    $scope.refreshPaymentlog = function(uid) {
    	try {
        	$scope.paymentlog = null;
	        Paymentlog.get(uid).then(
				function(success) {
        	        $scope.paymentlog = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the paymentlogs list page
     */
    $scope.goToPaymentlogList = function() {
        $scope.refreshPaymentlogList();
        $location.path('/paymentlog');
    }
    /**
     * Go to the paymentlog edit page
     */
    $scope.goToPaymentlog = function(uid) {
        $scope.refreshPaymentlog(uid);
        $location.path('/paymentlog/'+uid);
    }

    // Actions

    /**
     * Save paymentlog
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Paymentlog.create;
			} else {
				save = Paymentlog.update;
			}
			save($scope.paymentlog).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.paymentlog = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete paymentlog
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Paymentlog.delete(uid).then(
				function(success) {
                	$scope.goToPaymentlogList();
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
        $scope.paymentlog = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshPaymentlog($routeParams.uid);
    } else {
        // List page
        $scope.refreshPaymentlogList();
    }
    
    
}]);
