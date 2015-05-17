'use strict';

/**
 * Controller for Payment
 **/
paymentModule.controller('PaymentCtrl', ['Payment',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Payment, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of payments
    $scope.payments = [];
	// payment to edit
    $scope.payment = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh payments list
     */
    $scope.refreshPaymentList = function() {
    	try {
			$scope.payments = [];
        	Payment.getAll().then(
				function(success) {
        	        $scope.payments = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh payment
     */
    $scope.refreshPayment = function(uid) {
    	try {
        	$scope.payment = null;
	        Payment.get(uid).then(
				function(success) {
        	        $scope.payment = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the payments list page
     */
    $scope.goToPaymentList = function() {
        $scope.refreshPaymentList();
        $location.path('/payment');
    }
    /**
     * Go to the payment edit page
     */
    $scope.goToPayment = function(uid) {
        $scope.refreshPayment(uid);
        $location.path('/payment/'+uid);
    }

    // Actions

    /**
     * Save payment
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Payment.create;
			} else {
				save = Payment.update;
			}
			save($scope.payment).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.payment = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete payment
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Payment.delete(uid).then(
				function(success) {
                	$scope.goToPaymentList();
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
        $scope.payment = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshPayment($routeParams.uid);
    } else {
        // List page
        $scope.refreshPaymentList();
    }
    
    
}]);
