'use strict';

/**
 * Controller for Promotioninfo
 **/
promotioninfoModule.controller('PromotioninfoCtrl', ['Promotioninfo',  '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Promotioninfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	    // edition mode
    $scope.mode = null;
    
	// list of promotioninfos
    $scope.promotioninfos = [];
	// promotioninfo to edit
    $scope.promotioninfo = null;

	// referencies entities
	$scope.items = {};

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
    };
    
    /**
     * Refresh promotioninfos list
     */
    $scope.refreshPromotioninfoList = function() {
    	try {
			$scope.promotioninfos = [];
        	Promotioninfo.getAll().then(
				function(success) {
        	        $scope.promotioninfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh promotioninfo
     */
    $scope.refreshPromotioninfo = function(uid) {
    	try {
        	$scope.promotioninfo = null;
	        Promotioninfo.get(uid).then(
				function(success) {
        	        $scope.promotioninfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the promotioninfos list page
     */
    $scope.goToPromotioninfoList = function() {
        $scope.refreshPromotioninfoList();
        $location.path('/promotioninfo');
    }
    /**
     * Go to the promotioninfo edit page
     */
    $scope.goToPromotioninfo = function(uid) {
        $scope.refreshPromotioninfo(uid);
        $location.path('/promotioninfo/'+uid);
    }

    // Actions

    /**
     * Save promotioninfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Promotioninfo.create;
			} else {
				save = Promotioninfo.update;
			}
			save($scope.promotioninfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.promotioninfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete promotioninfo
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Promotioninfo.delete(uid).then(
				function(success) {
                	$scope.goToPromotioninfoList();
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
        $scope.promotioninfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshPromotioninfo($routeParams.uid);
    } else {
        // List page
        $scope.refreshPromotioninfoList();
    }
    
    
}]);
