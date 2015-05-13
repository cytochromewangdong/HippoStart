'use strict';

/**
 * Controller for Account
 **/
accountModule.controller('AccountCtrl', ['Account',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Account, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of accounts
    $scope.accounts = [];
	// account to edit
    $scope.account = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh accounts list
     */
    $scope.refreshAccountList = function() {
    	try {
			$scope.accounts = [];
        	Account.getAll().then(
				function(success) {
        	        $scope.accounts = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh account
     */
    $scope.refreshAccount = function(uid) {
    	try {
        	$scope.account = null;
	        Account.get(uid).then(
				function(success) {
        	        $scope.account = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the accounts list page
     */
    $scope.goToAccountList = function() {
        $scope.refreshAccountList();
        $location.path('/account');
    }
    /**
     * Go to the account edit page
     */
    $scope.goToAccount = function(uid) {
        $scope.refreshAccount(uid);
        $location.path('/account/'+uid);
    }

    // Actions

    /**
     * Save account
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Account.create;
			} else {
				save = Account.update;
			}
			save($scope.account).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.account = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete account
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Account.delete(uid).then(
				function(success) {
                	$scope.goToAccountList();
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
        $scope.account = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshAccount($routeParams.uid);
    } else {
        // List page
        $scope.refreshAccountList();
    }
    
    
}]);
