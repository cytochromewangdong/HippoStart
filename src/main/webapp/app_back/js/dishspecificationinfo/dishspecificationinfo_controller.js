'use strict';

/**
 * Controller for Dishspecificationinfo
 **/
dishspecificationinfoModule.controller('DishspecificationinfoCtrl', ['Dishspecificationinfo',  'Dishinfo', '$scope', '$routeParams', '$http', '$location', '$cookies', 'MessageHandler', 'restURL', function(Dishspecificationinfo, Dishinfo, $scope, $routeParams, $http, $location, $cookies, MessageHandler, restURL) {
	 'Dishinfo',     // edition mode
    $scope.mode = null;
    
	// list of dishspecificationinfos
    $scope.dishspecificationinfos = [];
	// dishspecificationinfo to edit
    $scope.dishspecificationinfo = null;

	// referencies entities
	$scope.items = {};
    // dishinfos
	$scope.items.dishinfos = [];

    /**
     * Load all referencies entities
     */
	$scope.loadAllReferencies = function() {
		Dishinfo.getAllAsListItems().then(
				function(success) {
        	        $scope.items.dishinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    };
    
    /**
     * Refresh dishspecificationinfos list
     */
    $scope.refreshDishspecificationinfoList = function() {
    	try {
			$scope.dishspecificationinfos = [];
        	Dishspecificationinfo.getAll().then(
				function(success) {
        	        $scope.dishspecificationinfos = success.data;
            	}, 
	            MessageHandler.manageError);
    	} catch(ex) {
    		MessageHandler.manageException(ex);
    	}
    }
    /**
     * Refresh dishspecificationinfo
     */
    $scope.refreshDishspecificationinfo = function(dishid, uid) {
    	try {
        	$scope.dishspecificationinfo = null;
	        Dishspecificationinfo.get(dishid, uid).then(
				function(success) {
        	        $scope.dishspecificationinfo = success.data;
            	}, 
	            MessageHandler.manageError);
    	  } catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    }

    /**
     * Go to the dishspecificationinfos list page
     */
    $scope.goToDishspecificationinfoList = function() {
        $scope.refreshDishspecificationinfoList();
        $location.path('/dishspecificationinfo');
    }
    /**
     * Go to the dishspecificationinfo edit page
     */
    $scope.goToDishspecificationinfo = function(dishid, uid) {
        $scope.refreshDishspecificationinfo(dishid, uid);
        $location.path('/dishspecificationinfo/'+dishid+'/'+uid);
    }

    // Actions

    /**
     * Save dishspecificationinfo
     */
    $scope.save = function() {
    	try {
			MessageHandler.cleanMessage();
			var save;
			if( $scope.mode === 'create' ) {
        		save = Dishspecificationinfo.create;
			} else {
				save = Dishspecificationinfo.update;
			}
			save($scope.dishspecificationinfo).then(
    	        function(success) {
	                MessageHandler.addSuccess('save ok');
                	$scope.dishspecificationinfo = success.data;
            	},
        	    MessageHandler.manageError);
    	} catch(ex) {
        	MessageHandler.manageException(ex);
    	}
    };
    /**
     * Delete dishspecificationinfo
     */
    $scope.delete = function(dishid, uid) {
	    try {
			MessageHandler.cleanMessage();
    	    Dishspecificationinfo.delete(dishid, uid).then(
				function(success) {
                	$scope.goToDishspecificationinfoList();
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
        $scope.dishspecificationinfo = {};
        $scope.mode = 'create';
		$scope.loadAllReferencies();
        $scope.bookorderitem = null;
    } else if( $routeParams.dishid != null && $routeParams.uid != null ) {
        // Edit page
		$scope.loadAllReferencies();
		$scope.refreshDishspecificationinfo($routeParams.dishid, $routeParams.uid);
    } else {
        // List page
        $scope.refreshDishspecificationinfoList();
    }
    
    
}]);
