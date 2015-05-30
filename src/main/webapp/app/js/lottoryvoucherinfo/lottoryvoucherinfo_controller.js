'use strict';

/**
 * Controller for Lottoryvoucherinfo
 **/
lottoryvoucherinfoModule.controller('LottoryvoucherinfoCtrl', ['Lottoryvoucherinfo',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Lottoryvoucherinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of lottoryvoucherinfos
    $scope.lottoryvoucherinfos = [];
	// lottoryvoucherinfo to edit
    $scope.lottoryvoucherinfo = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh lottoryvoucherinfos list
     */
    $scope.refreshLottoryvoucherinfoList = function() {
    	try {
			$scope.lottoryvoucherinfos = [];
        	Lottoryvoucherinfo.getAll().then(
				function(success) {
        	        $scope.lottoryvoucherinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh lottoryvoucherinfo
     */
    $scope.refreshLottoryvoucherinfo = function(uid) {
    	try {
        	$scope.lottoryvoucherinfo = null;
	        Lottoryvoucherinfo.get(uid).then(
				function(success) {
        	        $scope.lottoryvoucherinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the lottoryvoucherinfos list page
     */
    $scope.goToLottoryvoucherinfoList = function() {
        $scope.refreshLottoryvoucherinfoList();
        $location.path('/lottoryvoucherinfo');
    }
    /**
     * Go to the lottoryvoucherinfo edit page
     */
    $scope.goToLottoryvoucherinfo = function(uid) {
        $scope.refreshLottoryvoucherinfo(uid);
        $location.path('/lottoryvoucherinfo/'+uid);
    }

    // Actions

    /**
     * Save lottoryvoucherinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Lottoryvoucherinfo.create;
			} else {
				save = Lottoryvoucherinfo.update;
			}
			save($scope.lottoryvoucherinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.lottoryvoucherinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete lottoryvoucherinfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Lottoryvoucherinfo.delete(uid).then(
				function(success) {
                	$scope.goToLottoryvoucherinfoList();
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
        $scope.lottoryvoucherinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshLottoryvoucherinfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshLottoryvoucherinfoList();
    }
    
    
}]);
