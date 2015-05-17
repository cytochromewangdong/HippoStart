'use strict';

/**
 * Controller for Promotiondetailinfo
 **/
promotiondetailinfoModule.controller('PromotiondetailinfoCtrl', ['Promotiondetailinfo',  'Dishinfo', 'Dishspecificationinfo', '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Promotiondetailinfo, Dishinfo, Dishspecificationinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	 'Dishinfo',  'Dishspecificationinfo',     // edition mode
    $scope.mode = null;
    
	// list of promotiondetailinfos
    $scope.promotiondetailinfos = [];
	// promotiondetailinfo to edit
    $scope.promotiondetailinfo = null;

	// referencies entities
	$scope.items = {};
    // dishinfos
	$scope.items.dishinfos = [];
    // dishspecificationinfos
	$scope.items.dishspecificationinfos = [];

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
		Dishinfo.getAllAsListItems().then(
				function(success) {
        	        $scope.items.dishinfos = success.data;
            	}, 
	            MessageHandler.manageError);
		Dishspecificationinfo.getAllAsListItems().then(
				function(success) {
        	        $scope.items.dishspecificationinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    };
    
    /**
     * Refresh promotiondetailinfos list
     */
    $scope.refreshPromotiondetailinfoList = function() {
    	try {
			$scope.promotiondetailinfos = [];
        	Promotiondetailinfo.getAll().then(
				function(success) {
        	        $scope.promotiondetailinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh promotiondetailinfo
     */
    $scope.refreshPromotiondetailinfo = function(uid, dishid, specificationid) {
    	try {
        	$scope.promotiondetailinfo = null;
	        Promotiondetailinfo.get(uid, dishid, specificationid).then(
				function(success) {
        	        $scope.promotiondetailinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the promotiondetailinfos list page
     */
    $scope.goToPromotiondetailinfoList = function() {
        $scope.refreshPromotiondetailinfoList();
        $location.path('/promotiondetailinfo');
    }
    /**
     * Go to the promotiondetailinfo edit page
     */
    $scope.goToPromotiondetailinfo = function(uid, dishid, specificationid) {
        $scope.refreshPromotiondetailinfo(uid, dishid, specificationid);
        $location.path('/promotiondetailinfo/'+uid+'/'+dishid+'/'+specificationid);
    }

    // Actions

    /**
     * Save promotiondetailinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Promotiondetailinfo.create;
			} else {
				save = Promotiondetailinfo.update;
			}
			save($scope.promotiondetailinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.promotiondetailinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete promotiondetailinfo
     */
    $scope.delete = function(uid, dishid, specificationid) {
	    try {
			MessageHandler.cleanMessage();
    	    Promotiondetailinfo.delete(uid, dishid, specificationid).then(
				function(success) {
                	$scope.goToPromotiondetailinfoList();
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
        $scope.promotiondetailinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null && $routeParams.dishid != null && $routeParams.specificationid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshPromotiondetailinfo($routeParams.uid, $routeParams.dishid, $routeParams.specificationid);
    } else {
        // List page
        $scope.refreshPromotiondetailinfoList();
    }
    
    
}]);
