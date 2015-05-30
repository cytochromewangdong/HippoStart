'use strict';

/**
 * Controller for Dishprice
 **/
dishpriceModule.controller('DishpriceCtrl', ['Dishprice',  'Dishspecificationinfo', '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Dishprice, Dishspecificationinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	 'Dishspecificationinfo',     // edition mode
    $scope.mode = null;
    
	// list of dishprices
    $scope.dishprices = [];
	// dishprice to edit
    $scope.dishprice = null;

	// referencies entities
	$scope.items = {};
    // dishspecificationinfos
	$scope.items.dishspecificationinfos = [];

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
		Dishspecificationinfo.getAllAsListItems().then(
				function(success) {
        	        $scope.items.dishspecificationinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    };
    
    /**
     * Refresh dishprices list
     */
    $scope.refreshDishpriceList = function() {
    	try {
			$scope.dishprices = [];
        	Dishprice.getAll().then(
				function(success) {
        	        $scope.dishprices = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh dishprice
     */
    $scope.refreshDishprice = function(uid) {
    	try {
        	$scope.dishprice = null;
	        Dishprice.get(uid).then(
				function(success) {
        	        $scope.dishprice = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the dishprices list page
     */
    $scope.goToDishpriceList = function() {
        $scope.refreshDishpriceList();
        $location.path('/dishprice');
    }
    /**
     * Go to the dishprice edit page
     */
    $scope.goToDishprice = function(uid) {
        $scope.refreshDishprice(uid);
        $location.path('/dishprice/'+uid);
    }

    // Actions

    /**
     * Save dishprice
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Dishprice.create;
			} else {
				save = Dishprice.update;
			}
			save($scope.dishprice).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.dishprice = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete dishprice
     */
    $scope.delete = function(uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Dishprice.delete(uid).then(
				function(success) {
                	$scope.goToDishpriceList();
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
        $scope.dishprice = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshDishprice($routeParams.uid);
    } else {
        // List page
        $scope.refreshDishpriceList();
    }
    
    
}]);
